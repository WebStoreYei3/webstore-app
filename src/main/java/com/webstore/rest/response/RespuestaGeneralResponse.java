package com.webstore.rest.response;

public class RespuestaGeneralResponse {
    private boolean resultado;

    public RespuestaGeneralResponse(boolean resultado) {
        this.resultado = resultado;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
}
