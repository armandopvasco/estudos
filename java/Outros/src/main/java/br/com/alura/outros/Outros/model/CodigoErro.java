package br.com.alura.outros.Outros.model;

public enum CodigoErro {
    // Definir os valores
    NOT_FOUND (404, "Not Found"),
    BAD_REQUEST (400, "Bad Request"),
    INTERNAL_SERVER_ERROR (500, "Internal Server Error");

    private int codigo;
    private String descricao;

    CodigoErro (int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        // Implementar aqui
        return codigo;
    }

    public String getDescricao() {
        // Implementar aqui
        return descricao;
    }
}
