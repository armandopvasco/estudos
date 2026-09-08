package br.com.alura.musicmatch.musicmatch.model;

public enum TipoArtista {
    SOLO ("solo"),
    DUPLA ("dupla"),
    BANDA ("banda");

    private String tipoArtista;

    TipoArtista(String tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public static TipoArtista fromString(String text) {
        for (TipoArtista tipo : TipoArtista.values()) {
            if (tipo.tipoArtista.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma tipo de artista encontrado para o texto fornecido: " + text);
    }
}
