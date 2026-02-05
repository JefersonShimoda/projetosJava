public class Conta {
    private Long numero;
    private Double saldo;
    private Cliente cliente;

    private static Long sequencialConta = 0L;

    public Conta(
        Long numero,
        Double saldo,
        Cliente cliente
    ) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void sacar(Double valor) {
        if(valor<saldo){
            saldo = saldo - valor;
        }
    }

    public void depositar(Double valor) {
        saldo = saldo + valor;
    }

    public void transferir(Conta destino, double valor){
        sacar(valor);
        destino.depositar(valor);
    }

    public Long getNumero() {
        return this.numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static Long getSequencialConta(){
        sequencialConta += 1;
        return sequencialConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
