import java.time.LocalDate;

public class Locacao{
    private Cliente cliente;
    private Carro carro;
    private LocalDate inicio;
    private LocalDate fim;

    public Locacao(
            Cliente cliente,
            Carro carro,
            LocalDate   inicio,
            LocalDate   fim
    ) {
        this.cliente    =  cliente;
        this.carro      =    carro;
        this.inicio     =   inicio;
        this.fim        =  fim;

        this.carro.alugar();
    }

    public Carro getCarro(){
        return this.carro;
    }

    public void finalizarLocacao() {
        this.carro.devolver();
    }

    @Override
    public String toString() {
        return "Locacao: cliente: " + cliente + ",carro: " + carro + ", inicio: " + inicio + ", fim: " + fim;
    }
}