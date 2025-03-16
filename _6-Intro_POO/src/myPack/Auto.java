package myPack;
public class Auto {
    private String marca;
    private String modelo;
    private int anio;

    public Auto() {
    }
    public Auto(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public Auto(String marca) {
        this.marca = marca;
    }

    public void imprimirDatos() {
        if (this.marca != null)
            System.out.printf("Marca: %s%n", this.marca);
        else
            System.out.println("La marca no fue inicializada");

        if (this.anio != 0)
            System.out.printf("Año: %s%n", this.anio);
        else
            System.out.println("El año no fue inicializado");

        if (this.modelo != null)
            System.out.printf("Modelo: %s%n", this.modelo);
        else
            System.out.println("El modelo no fue inicializado");
        
        if (this.anio == 0 && this.marca == null && this.modelo == null)
            System.out.println("El constructor fue inicializado con el constructor sin parámetros");

        System.out.println("----------------------");
    }

}
