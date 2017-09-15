package com.webstore.mail;

import com.webstore.core.entity.UsuarioEntity;

public class MailDeCambioContraseniaVO implements MailVO{
    private UsuarioEntity usuarioEntity;
    private String link;

    public MailDeCambioContraseniaVO(UsuarioEntity usuarioEntity, String link) {
        this.usuarioEntity = usuarioEntity;
        this.link = link;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
