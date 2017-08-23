package com.webstore.mail;

import com.webstore.core.entity.OrdenEntregaInvitadoEntity;
import com.webstore.core.entity.UsuarioInvitadoEntity;
import com.webstore.rest.request.FilaResumenCompraRequest;

import java.util.List;

public class MailVO {
    private List<FilaResumenCompraRequest> filaResumenCompraRequest;
    private UsuarioInvitadoEntity usuarioInvitadoEntity;
    private OrdenEntregaInvitadoEntity ordenEntregaInvitadoEntity;

    public MailVO(List<FilaResumenCompraRequest> filaResumenCompraRequest, UsuarioInvitadoEntity usuarioInvitadoEntity, OrdenEntregaInvitadoEntity ordenEntregaInvitadoEntity) {
        this.filaResumenCompraRequest = filaResumenCompraRequest;
        this.usuarioInvitadoEntity = usuarioInvitadoEntity;
        this.ordenEntregaInvitadoEntity = ordenEntregaInvitadoEntity;
    }

    public List<FilaResumenCompraRequest> getFilaResumenCompraRequest() {
        return filaResumenCompraRequest;
    }

    public void setFilaResumenCompraRequest(List<FilaResumenCompraRequest> filaResumenCompraRequest) {
        this.filaResumenCompraRequest = filaResumenCompraRequest;
    }

    public UsuarioInvitadoEntity getUsuarioInvitadoEntity() {
        return usuarioInvitadoEntity;
    }

    public void setUsuarioInvitadoEntity(UsuarioInvitadoEntity usuarioInvitadoEntity) {
        this.usuarioInvitadoEntity = usuarioInvitadoEntity;
    }

    public OrdenEntregaInvitadoEntity getOrdenEntregaInvitadoEntity() {
        return ordenEntregaInvitadoEntity;
    }

    public void setOrdenEntregaInvitadoEntity(OrdenEntregaInvitadoEntity ordenEntregaInvitadoEntity) {
        this.ordenEntregaInvitadoEntity = ordenEntregaInvitadoEntity;
    }
}

