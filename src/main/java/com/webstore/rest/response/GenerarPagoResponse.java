package com.webstore.rest.response;

public class GenerarPagoResponse {
    private String link;

    public GenerarPagoResponse(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
