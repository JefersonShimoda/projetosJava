import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(
            String nome,
            List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public Conta criarConta(Cliente cliente) {
        Conta conta = new Conta(Conta.getSequencialConta(), 0.0, cliente);
        this.guardarContas(conta);
        return conta;
    }

    public void guardarContas(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarConta(Long contaProcurada) {

        return contas.stream()
                .filter(e -> e.getNumero() == contaProcurada)
                .findFirst()
                .orElse(null);
    }

    public List<Conta> getContas() {
        return this.contas;
    }
}
