package Figura_Geometrica;

public class Triangulo extends Figura implements Dibujable{
    private double lado1, lado2, lado3;
    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    public double getLado1() {
        return this.lado1;
    }
    public double getLado2() {
        return this.lado2;
    }
    public double getLado3() {
        return this.lado3;
    }
    @Override
    public double calcularArea() {
        double sp = (this.lado1 + this.lado2 +this.lado3) / 2;
        return Math.sqrt(sp * (sp - this.lado1) * (sp - this.lado2) * (sp - this.lado3));
        }
    @Override
    public double calcularPerimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }
    @Override
    public void dibujar(){
        System.out.println("Dibujando triángulo...");
    }
}
