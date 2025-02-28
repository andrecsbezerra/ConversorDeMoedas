package uninter;

import java.util.ArrayList;

// Classe Cofrinho que gerencia uma coleção de objetos Moeda
public class Cofrinho {

    // Lista para armazenar as moedas
    private ArrayList<Moeda> listaMoedas;

    // Construtor da classe Cofrinho que inicializa a lista de moedas
    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    // Método para adicionar uma moeda à lista
    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }

    // Método para remover uma moeda da lista
    public boolean remover(Moeda moeda) {
        this.listaMoedas.remove(moeda);
        return true;
    }

    // Método para listar todas as moedas no cofrinho
    public void listagemMoedas() {
        // Verifica se a lista está vazia
        if (listaMoedas.isEmpty()) {
            System.out.println("Nao existe moedas no cofrinho!");
            return; // Guard Clause ou Early Return
        }
        // Imprime a listagem das moedas
        System.out.println("Moedas no Cofrinho:");
        for (Moeda moeda : this.listaMoedas) {
            moeda.info();
        }
    }

    // Método para calcular o valor total das moedas convertidas
    public double totalConvertido() {
        // Verifica se a lista está vazia
        if (this.listaMoedas.isEmpty()) {
            return 0;
        }

        double valorAcumulado = 0;

        // Soma o valor convertido de cada moeda
        for (Moeda moeda : this.listaMoedas) {
            valorAcumulado = valorAcumulado + moeda.converter();
        }

        return valorAcumulado;
    }

    // Método para obter a lista de moedas do cofrinho
    public ArrayList<Moeda> getListaMoedas() {
        return listaMoedas;
    }

}
