package com.webstore.core.business;

import com.webstore.core.entity.*;
import com.webstore.core.repository.*;
import com.webstore.rest.request.StockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class StockBusiness {
    private StockRepository stockRepository;
    private ProductoRepository productoRepository;
    private AlmacenRepository almacenRepository;
    private MovimientoAlmacenStockRepository movimientoAlmacenStockRepository;
    private ProveedorRepository proveedorRepository;
    private TipoProductoRepository tipoProductoRepository;
    private SubtipoProductoRepository subtipoProductoRepository;

    @Autowired
    public StockBusiness(
            StockRepository stockRepository,
            ProductoRepository productoRepository,
            AlmacenRepository almacenRepository,
            MovimientoAlmacenStockRepository movimientoAlmacenStockRepository,
            ProveedorRepository proveedorRepository,
            TipoProductoRepository tipoProductoRepository,
            SubtipoProductoRepository subtipoProductoRepository
    ){
        this.stockRepository = stockRepository;
        this.productoRepository = productoRepository;
        this.almacenRepository = almacenRepository;
        this.movimientoAlmacenStockRepository = movimientoAlmacenStockRepository;
        this.proveedorRepository = proveedorRepository;
        this.tipoProductoRepository = tipoProductoRepository;
        this.subtipoProductoRepository = subtipoProductoRepository;
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
}
