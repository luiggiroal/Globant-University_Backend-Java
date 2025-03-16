package entidades;

public class Oficina {
    private int idOficina;
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;

    public Oficina(int idOficina, String codigoOficina, String ciudad, String pais, String region, String codigoPostal, String telefono) {
        this.idOficina = idOficina;
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public Oficina(String codigoOficina, String ciudad, String pais, String region, String codigoPostal, String telefono) {
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public Oficina() {
    }

    @Override
    public String toString() {
        return """
                Oficina{\
                    idOficina = %d, \
                    codigoOficina = '%s', \
                    ciudad = '%s', \
                    pais = '%s', \
                    region = '%s', \
                    codigoPostal = '%s', \
                    telefono = '%s'\
                }
                """.formatted(idOficina, codigoOficina, ciudad, pais, region, codigoPostal, telefono);
    }
}
