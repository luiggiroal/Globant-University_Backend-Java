package entidades;

public class GamaProducto {
    private String idGama;
    private String gama;
    private String descripcion;
    private String descripcionHtml;
    private String imagen;

    public GamaProducto(String idGama, String gama, String descripcion, String descripcionHtml, String imagen) {
        this.idGama = idGama;
        this.gama = gama;
        this.descripcion = descripcion;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public GamaProducto(String gama, String descripcion, String descripcionHtml, String imagen) {
        this.gama = gama;
        this.descripcion = descripcion;
        this.descripcionHtml = descripcionHtml;
        this.imagen = imagen;
    }

    public GamaProducto() {
    }

    public String getIdGama() {
        return idGama;
    }

    public void setIdGama(String idGama) {
        this.idGama = idGama;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return """
                GamaProducto{\
                    idGama = %d, \
                    gama = '%s', \
                    descripcion = '%s', \
                    descripcionHtml = '%s', \
                    imagen = '%s'\
                }
                """.formatted(idGama, gama, descripcion, descripcionHtml, imagen);
    }
}
