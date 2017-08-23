package com.webstore.core.business;

import com.mercadopago.MP;
import com.webstore.core.entity.*;
import com.webstore.core.repository.*;
import com.webstore.mail.MailVO;
import com.webstore.mail.MessageGenerator;
import com.webstore.mail.MotorMail;
import com.webstore.rest.request.FilaResumenCompraRequest;
import com.webstore.rest.request.PagoRequest;
import com.webstore.rest.request.StockRequest;
import com.webstore.rest.response.GenerarPagoResponse;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class StockBusiness {
    private StockRepository stockRepository;
    private ProductoRepository productoRepository;
    private AlmacenRepository almacenRepository;
    private MovimientoAlmacenStockRepository movimientoAlmacenStockRepository;
    private ProveedorRepository proveedorRepository;
    private TipoProductoRepository tipoProductoRepository;
    private SubtipoProductoRepository subtipoProductoRepository;
    private UsuarioRepository usuarioRepository;
    private UsuarioInvitadoRepository usuarioInvitadoRepository;
    private OrdenEntregaInvitadoRepository ordenEntregaInvitadoRepository;
    private MessageGenerator messageGenerator;

    @Autowired
    public StockBusiness(
            StockRepository stockRepository,
            ProductoRepository productoRepository,
            AlmacenRepository almacenRepository,
            MovimientoAlmacenStockRepository movimientoAlmacenStockRepository,
            ProveedorRepository proveedorRepository,
            TipoProductoRepository tipoProductoRepository,
            SubtipoProductoRepository subtipoProductoRepository,
            UsuarioRepository usuarioRepository,
            UsuarioInvitadoRepository usuarioInvitadoRepository,
            OrdenEntregaInvitadoRepository ordenEntregaInvitadoRepository,
            MessageGenerator messageGenerator
            ){
        this.stockRepository = stockRepository;
        this.productoRepository = productoRepository;
        this.almacenRepository = almacenRepository;
        this.movimientoAlmacenStockRepository = movimientoAlmacenStockRepository;
        this.proveedorRepository = proveedorRepository;
        this.tipoProductoRepository = tipoProductoRepository;
        this.subtipoProductoRepository = subtipoProductoRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioInvitadoRepository = usuarioInvitadoRepository;
        this.ordenEntregaInvitadoRepository = ordenEntregaInvitadoRepository;
        this.messageGenerator = messageGenerator;
    }

    @RequestMapping(value="/altaStock", method = RequestMethod.POST)
    public void altaProducto(@RequestBody StockRequest stockRequest) throws Exception {
        if(!almacenRepository.exists(stockRequest.getiIdAlmacen())){
            throw new Exception("El almacen de destino no existe");
        }
        if(!productoRepository.exists(stockRequest.getiIdProducto())){
            throw new Exception("El producto solicitado no existe");
        }
        ProductoEntity productoEntity = productoRepository.findOne(stockRequest.getiIdProducto());
        AlmacenEntity almacenEntity = almacenRepository.findOne(stockRequest.getiIdAlmacen());
        ProveedorEntity proveedorEntity = proveedorRepository.findOne(productoEntity.getiIdProveedor());
        TipoProductoEntity tipoProductoEntity = tipoProductoRepository.findOne(productoEntity.getiIdTipo());

        StockEntity stockEntity = new StockEntity();
        stockEntity.setcSku(generarSku(productoEntity.getId(),almacenEntity.getId()));
        stockEntity.setdCantidadDisponible(stockRequest.getdCantidadDisponible());
        stockEntity.setdCantidadMinima(stockRequest.getdCantidadMinima());
        stockEntity.setiIdAlmacen(stockRequest.getiIdAlmacen());
        stockEntity.setiIdProducto(stockRequest.getiIdProducto());
        stockRepository.save(stockEntity);
        MovimientoAlmacenStockEntity movimientoAlmacenStockEntity = new MovimientoAlmacenStockEntity();
        movimientoAlmacenStockEntity.setcSkuStock(stockEntity.getcSku());
        movimientoAlmacenStockEntity.setiIdEmpleado(stockRequest.getiIdEmpleado());
        movimientoAlmacenStockEntity.setiIdAlmacenDestino(stockRequest.getiIdAlmacen());
        movimientoAlmacenStockRepository.save(movimientoAlmacenStockEntity);
    }

    public String generarSku(Integer idProducto, Integer idAlmacen){
        ProductoEntity productoEntity = productoRepository.findOne(idProducto);
        AlmacenEntity almacenEntity = almacenRepository.findOne(idAlmacen);
        ProveedorEntity proveedorEntity = proveedorRepository.findOne(productoEntity.getiIdProveedor());
        TipoProductoEntity tipoProductoEntity = tipoProductoRepository.findOne(productoEntity.getiIdTipo());

        return productoEntity.getcCodigo().substring(0,2)+
                productoEntity.getcMarca().substring(0,2)+
                productoEntity.getcNombre().substring(0,2)+
                productoEntity.getcDescripcion().substring(0,2)+
                proveedorEntity.getcCodigo().substring(0,2)+
                tipoProductoEntity.getcCodigo().substring(0,2)+
                (productoEntity.hasSubTipo()?subtipoProductoRepository.findOne(productoEntity.getiIdSubtipo()):"")+
                almacenEntity.getcDescripcion().substring(0,2);
    }

    public String generarCheckOut(List<FilaResumenCompraRequest> filaResumenCompraRequests) throws Exception {
        MP mp = new MP("8906126282350142", "Y2CO7ygNFHJmVsrNKrVLdEjd1MIFVjcD");
        mp.sandboxMode(true);
        String preferenceData = "{'items':[";
        int i = 0;
        for(FilaResumenCompraRequest filaResumenCompraRequest:filaResumenCompraRequests){
            if(i>0){
                preferenceData += ",";
            }
            ProductoEntity productoEntity = productoRepository.findOne(filaResumenCompraRequest.getId());
            preferenceData += "{'id':'"+productoEntity.getId()+"',"+
                    "'title':"+productoEntity.getcNombre()+","+
                    "'quantity':"+filaResumenCompraRequest.getCantidadProducto()+","+
                    "'currency_id':'MXN',"+
                    "'unit_price':"+productoEntity.getdPrecioPublico()+"}";
            i++;
        }
        preferenceData += "]}";
        System.out.println(preferenceData);
        JSONObject preference = mp.createPreference(preferenceData);
        System.out.println(preference.toString());
        System.out.println(preference.getJSONObject("response").toString());
        return preference.getJSONObject("response").getString("init_point");
    }

    public GenerarPagoResponse generarPago(PagoRequest pagoRequest) throws Exception {
        if(pagoRequest.getUsuarioId()==null){
            UsuarioInvitadoEntity usuarioInvitadoEntity = new UsuarioInvitadoEntity();
            usuarioInvitadoEntity.setcNombre(pagoRequest.getNombre());
            usuarioInvitadoEntity.setcApepat(pagoRequest.getApePat());
            usuarioInvitadoEntity.setcApemat(pagoRequest.getApeMat());
            usuarioInvitadoEntity.setcDireccion1("Direccion: " + pagoRequest.getDireccion() +
                    " Interior: " + (StringUtils.isEmpty(pagoRequest.getNumeroInt())?"N/A":pagoRequest.getNumeroInt()) +
                    " Instrucciones especiales: " + pagoRequest.getInstEspeciales());
            usuarioInvitadoEntity.setcMail(pagoRequest.getEmail());
            usuarioInvitadoEntity.setcTelefono(pagoRequest.getTel());
            usuarioInvitadoEntity = usuarioInvitadoRepository.save(usuarioInvitadoEntity);

            OrdenEntregaInvitadoEntity ordenEntregaInvitadoEntity = new OrdenEntregaInvitadoEntity();
            ordenEntregaInvitadoEntity.setiIdAlmacen(1);
            ordenEntregaInvitadoEntity.setiIdUsuario(usuarioInvitadoEntity.getId());
            ordenEntregaInvitadoEntity.setiIdEstadoOrden(1);
            ordenEntregaInvitadoEntity.setcDireccionEntrega(usuarioInvitadoEntity.getcDireccion1());
            ordenEntregaInvitadoRepository.save(ordenEntregaInvitadoEntity);
            enviarMail(pagoRequest.getFilas(),usuarioInvitadoEntity,ordenEntregaInvitadoEntity);
            return new GenerarPagoResponse(generarCheckOut(pagoRequest.getFilas()));
        }
        return null;
    }

    public String enviarMail(List<FilaResumenCompraRequest> filaResumenCompraRequests,
                             UsuarioInvitadoEntity usuarioInvitadoEntity,
                             OrdenEntregaInvitadoEntity ordenEntregaInvitadoEntity){
        MailVO mailVO = new MailVO(filaResumenCompraRequests,usuarioInvitadoEntity,ordenEntregaInvitadoEntity);
        MotorMail.sendMail(usuarioInvitadoEntity.getcMail(),messageGenerator.generarMensaje(mailVO));
        return "Correcto";
    }
}
