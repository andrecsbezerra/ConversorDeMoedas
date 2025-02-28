package uninter;

// Classe Real que herda da classe Moeda
public class Real extends Moeda {

    // Construtor da classe Real que inicializa o valor da moeda
    public Real(double valor) {
        this.valor = valor;
    }

    // Método sobrescrito da classe Moeda que exibe informações sobre a moeda
    @Override
    public void info() {
        System.out.printf("Real - R$ %.2f\n", valor);
    }

    // Método sobrescrito da classe Moeda que retorna o valor da moeda em reais
    @Override
    public double converter() {
        return this.valor;
    }

    // Método sobrescrito equals para comparar se dois objetos Real são iguais
    @Override
    public boolean equals(Object objeto) {
        // Verifica se o objeto passado é da mesma classe
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        // Faz o cast do objeto para a classe Real
        Real objetoDeReal = (Real) objeto;

        // Compara os valores dos dois objetos
        if (this.valor != objetoDeReal.valor) {
            return false;
        }

        return true;
    }
}