import java.util.List;
import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private Integer ano;
    private boolean disponibilidade = true;

    public Carro(
            String marca,
            String modelo,
            String cor,
            String placa,
            Integer ano
    ) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.ano = ano;
    }

    public void alugar() {
        this.disponibilidade = false;
        System.out.println(
                "Carro alugado: " + marca + " " + modelo + " " + cor + " " + ano
        );
    }

    public String getPlaca() {
        return placa;
    }

    public void devolver() {
        this.disponibilidade = true;
        System.out.println(
                "Carro devolvido: " + marca + " " + modelo + " " + cor + " " + ano
        );
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    @Override
    public String toString() {
        return "Carro: " + marca + " " + modelo + " " + cor + " " + ano +  " "+disponibilidade;
    }
}