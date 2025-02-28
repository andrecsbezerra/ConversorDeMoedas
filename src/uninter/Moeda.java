package uninter;

// Classe abstrata Moeda que serve como base para diferentes tipos de moedas
public abstract class Moeda {

    // Atributo protegido para armazenar o valor da moeda
    protected double valor;

    // Método abstrato para exibir informações sobre a moeda
    public abstract void info();

    // Método abstrato para converter o valor da moeda para uma moeda padrão (por exemplo, Real)
    public abstract double converter();
}
