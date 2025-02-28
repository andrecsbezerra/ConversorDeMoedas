package uninter;

// Classe Dolar que herda da classe Moeda
public class Dolar extends Moeda {

    // Construtor da classe Dolar que inicializa o valor da moeda
    public Dolar(double valor) {
        this.valor = valor;
    }

    // Método sobrescrito da classe Moeda que exibe informações sobre a moeda
    @Override
    public void info() {
        System.out.printf("Dolar - $ %.2f\n", valor);
    }

    // Método sobrescrito da classe Moeda que converte o valor da moeda para reais
    @Override
    public double converter() {
        return this.valor * 5.13; // Converte Dólar para Real com uma taxa fixa de 5.13
    }

    // Método sobrescrito equals para comparar se dois objetos Dolar são iguais
    @Override
    public boolean equals(Object objeto) {
        // Verifica se o objeto passado é da mesma classe
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        // Faz o cast do objeto para a classe Dolar
        Dolar objetoDeDolar = (Dolar) objeto;

        // Compara os valores dos dois objetos
        if (this.valor != objetoDeDolar.valor) {
            return false;
        }

        return true;
    }
}
