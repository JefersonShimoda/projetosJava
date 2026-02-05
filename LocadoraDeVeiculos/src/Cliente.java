


public class Cliente {
    private String nome;
    private Integer cpf;

    public Cliente(
            String nome,
            Integer cpf
    ) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", " + cpf;
    }
}