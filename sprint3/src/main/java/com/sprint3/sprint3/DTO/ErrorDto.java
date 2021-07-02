package com.sprint3.sprint3.DTO;

public class ErrorDto {
    private String campo;
    private String erro;

    public ErrorDto(String campo, String erro){
        this.erro = erro;
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
