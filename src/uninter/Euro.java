package uninter;

// Classe Euro que herda da classe Moeda
public class Euro extends Moeda {

    // Construtor da classe Euro que inicializa o valor da moeda
    public Euro(double valor) {
        this.valor = valor;
    }

    // Método sobrescrito da classe Moeda que exibe informações sobre a moeda
    @Override
    public void info() {
        System.out.printf("Euro - € %.2f\n", valor);
    }

    // Método sobrescrito da classe Moeda que converte o valor da moeda para reais
    @Override
    public double converter() {
        return this.valor * 5.55; // Converte Euro para Real com uma taxa fixa de 5.55
    }

    // Método sobrescrito equals para comparar se dois objetos Euro são iguais
    @Override
    public boolean equals(Object objeto) {
        // Verifica se o objeto passado é da mesma classe
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        // Faz o cast do objeto para a classe Euro
        Euro objetoDeEuro = (Euro) objeto;

        // Compara os valores dos dois objetos
        if (this.valor != objetoDeEuro.valor) {
            return false;
        }

        return true;
    }
}
