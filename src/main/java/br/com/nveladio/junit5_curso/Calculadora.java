package br.com.nveladio.junit5_curso;

public class Calculadora {
    public Calculadora(){
        System.out.println("New Calc");
    }


    public int soma(int a, int b) {
        return a + b;
    }

    public float dividir(int a, int b) {
        return (float) a / b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("--------------------------------");
        System.out.println("Resultado: " + calc.soma(2, 3));
        System.out.println("Resultado: " + calc.soma(4, 3));
        System.out.println("Resultado: " + calc.soma(5, 6));
    }
}
