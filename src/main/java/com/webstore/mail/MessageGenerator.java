package com.webstore.mail;


import com.webstore.core.entity.ProductoEntity;
import com.webstore.core.repository.ProductoRepository;
import com.webstore.rest.request.FilaResumenCompraRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by oscar on 22/12/2016.
 */
@Component
public class MessageGenerator {
    @Autowired
    private ProductoRepository productoRepository;

    public String generarMensajeDeCompra(MailDeCompraVO mailDeCompraVO){
        BigDecimal total = BigDecimal.valueOf(0);
        String msg = "<h1 style=\"color: #5e9ca0; text-align: center;\"><img src=\"http://www.familydog.com.mx/images/slider_pic2.jpg\" alt=\"imagen\" width=\"582\" height=\"146\" /></h1>";
        msg += "<h2 style=\"color: #2e6c80; text-align: center;\">¡Gracias por tu compra!</h2>";
        msg += "<p style=\"text-align: center;\">Pedido:</p>";
        msg += "<p style=\"text-align: center;\">" +
                "<table style=\"width:100%\">" +
                "<tr>";
        for(FilaResumenCompraRequest filaResumenCompraRequest: mailDeCompraVO.getFilaResumenCompraRequest()){
            ProductoEntity productoEntity = productoRepository.findOne(filaResumenCompraRequest.getId());
            BigDecimal costoFila = productoEntity.getdPrecioPublico().multiply(new BigDecimal(filaResumenCompraRequest.getCantidadProducto()));
            msg += "<td>" + productoEntity.getcNombre() + "</td>" +
                    "<td>" + productoEntity.getdPrecioPublico() + "</td>" +
                    "<td>" + filaResumenCompraRequest.getCantidadProducto() + "</td>" +
                    "<td>" + costoFila.toString() + "</td>" +
                    "</tr>";
            total.add(costoFila);
        }
        msg += "<td> Total: </td>" +
                "<td></td>" +
                "<td></td>" +
                "<td>" + total.toString() + "</td>" +
                "</tr>";
        msg += "<p style=\"text-align: center;\"><br />Envío</p>";
        msg += "<p style=\"text-align: center;\">" +
                "<br /> Cliente: <strong>"+ mailDeCompraVO.getUsuarioInvitadoEntity().getcNombre() +"</strong>" +
                "<br /> Telefono: <strong>" + mailDeCompraVO.getUsuarioInvitadoEntity().getcTelefono() + "</strong>" +
                "<br /> Dirección de entrega: <strong>" + mailDeCompraVO.getOrdenEntregaInvitadoEntity().getcDireccionEntrega() + "</strong></p>";
        msg += "<p style=\"text-align: center;\">Nuestros mejores deseos, Gracias.<br /> Atte:Equipo deWebstore.</p>";
        msg += "<p style=\"text-align: center;\">--------------------------------------------------------------------</p>";
        msg += "<p style=\"text-align: center;\"><img border=\"0\" src=\"ico_09Grande.png\" width=\"40\" height=\"40\"> <span style=\"color:#f9f9f9;\">Web</span><font color=\"#D55534\">Store</font></p>";
        msg += "<p style=\"text-align: center;\">WebStore S.A. de C.V.</p>";
        msg += "<p style=\"text-align: center;\">Direccion.</p>";
        return msg;
    }

    public String generarMensajeDeContrasenia(MailDeCambioContraseniaVO mailDeCambioContraseniaVO){
        BigDecimal total = BigDecimal.valueOf(0);
        String msg = "";
        msg += "<h2 style=\"color: #2e6c80; text-align: center;\">Accede al siguiente link para cambiar tu contrasenia</h2>";
        //msg += "<a href=\"http://localhost:8080/#/cambiarContrasenia/"+ mailDeCambioContraseniaVO.getLink()+"\" style=\"text-align: center;\">http://localhost:8080/#/cambiarContrasenia/"+ mailDeCambioContraseniaVO.getLink()+"</a>";
        msg += "<a href=\"http://webstore.jl.serv.net.mx/#/cambiarContrasenia/"+ mailDeCambioContraseniaVO.getLink()+"\" style=\"text-align: center;\">http://localhost:8080/#/cambiarContrasenia/"+ mailDeCambioContraseniaVO.getLink()+"</a>";
        return msg;
    }
}
