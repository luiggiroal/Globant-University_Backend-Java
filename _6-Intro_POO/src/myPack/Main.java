package myPack;

public class Main {
    public static void main(String[] args) {
       Auto myAuto = new Auto();
       Auto myAuto2 = new Auto("datsun", "A11", 1988);
       Auto myAuto3 = new Auto("audi", "V10");
       Auto myAuto4 = new Auto("honda");

       myAuto.imprimirDatos();
       myAuto2.imprimirDatos();
       myAuto3.imprimirDatos();
       myAuto4.imprimirDatos();
    }
}
