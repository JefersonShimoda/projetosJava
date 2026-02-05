import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco("Banco do Brasil", new ArrayList<>());
    
        Cliente joao = new Cliente("João Silva", "123.456.789-00");
        Cliente maria = new Cliente("Maria Souza", "987.654.321-00");

        Conta contaJoao = banco.criarConta(joao);
        Conta contaMaria = banco.criarConta(maria);

        System.out.println(banco.getContas().toString());

        System.out.println("=== Depósitos ===");
        contaJoao.depositar(500.00);
        contaMaria.depositar(300.00);

        System.out.println("Saldo João: " + contaJoao.getSaldo());
        System.out.println("Saldo Maria: " + contaMaria.getSaldo());

        System.out.println("\n=== Transferência ===");
        contaJoao.transferir(contaMaria, 200);

        System.out.println("Saldo João: " + contaJoao.getSaldo());
        System.out.println("Saldo Maria: " + contaMaria.getSaldo());

        System.out.println("\n=== Tentativa de saque inválido ===");
        contaJoao.sacar(1000.00); // deve falhar

        System.out.println("Saldo João final: " + contaJoao.getSaldo());
    }
}
