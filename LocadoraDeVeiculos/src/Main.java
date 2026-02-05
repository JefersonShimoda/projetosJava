import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

void main() {

    List<Carro> carros = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Locacao> locacoes = new ArrayList<>();
    boolean continuar = true;
    int opcao;

    do {
        System.out.println("##------------------Menu-------------------##");
        System.out.println("|------------------------------------------|");
        System.out.println("| Opção 1 - Cadastrar Carro                |");
        System.out.println("| Opção 2 - Listar Todos Carros            |");
        System.out.println("| Opção 3 - Listar Carros Disponiveis      |");
        System.out.println("| Opção 4 - Listar Carros Indisponiveis    |");
        System.out.println("| Opção 5 - Cadastrar Cliente              |");
        System.out.println("| Opção 6 - Listar Clientes                |");
        System.out.println("| Opção 7 - Alugar Carro                   |");
        System.out.println("| Opção 8 - Devolver Carro                 |");
        System.out.println("| Opção 9 - Listar todas locações          |");
        System.out.println("| Opção 10 - Listar locações ativas        |");
        System.out.println("| Opção 11 - Listar locações inativas      |");
        System.out.println("| Opção 12 - Finalizar Sistema             |");
        System.out.println("|------------------------------------------|");
        System.out.println("Digite uma opção: ");
        opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                cadastrarCarro(carros);
                break;
            case 2:
                System.out.println("Todos Carros: ");
                listarCarros(carros, null);
                break;
            case 3:
                System.out.println("Todos Carros Disponiveis: ");
                listarCarros(carros, true);
                break;
            case 4:
                System.out.println("Todos Carros Indisponiveis: ");
                listarCarros(carros, false);
                break;
            case 5:
                cadastrarCliente(clientes);
                break;
            case 6:
                System.out.println("Todos Clientes: ");
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado");
                    break;
                }
                System.out.println(clientes.toString());
                break;
            case 7:
                Alugar(clientes, carros, locacoes);
                break;
            case 8:
                devolverVeiculo(carros);
                break;
            case 9:
                System.out.println("Listar todas locações");
                listarLocacoes(locacoes, null);
                break;
            case 10:
                System.out.println("Listar locações ativas");
                listarLocacoes(locacoes, true);
                break;

            case 11:
                System.out.println("Listar locações inativas");
                listarLocacoes(locacoes, false);
                break;

            case 12:
                System.out.println("Até logo!");
                continuar = false;
                sc.close();

            default:
                System.out.println("Opção Inválida!");
                break;

        }
    } while (continuar);
}

private void listarLocacoes(List<Locacao> locacoes, Boolean situacao) {
    List<Locacao> lista = locacoes;
    if (situacao != null) {
        lista = locacoes.stream()
                .filter(locacao -> locacao.getCarro().isDisponibilidade() == !situacao)
                .collect(Collectors.toList());
    }
    if (lista.isEmpty()) {
        System.out.println("Nenhuma locação encontrada.");
        return;
    }
    System.out.println(locacoes);
}

private void listarCarros(List<Carro> carros, Boolean situacao) {
    List<Carro> lista = carros;
    if (situacao != null) {
        lista = carros.stream()
                .filter(carro -> carro.isDisponibilidade() == situacao)
                .collect(Collectors.toList());
    }
    if (lista.isEmpty()) {
        System.out.println("Nenhum carro encontrado.");
        return;
    }
    System.out.println(lista);
}

private void devolverVeiculo(List<Carro> carros) {
    Carro carro = this.encontrarCarro(carros);
    if (carro == null) {
        return;
    }
    carro.devolver();
    System.out.println("Veiculo devolvido com sucesso.");
}

private Carro encontrarCarro(List<Carro> carros) {
    System.out.println("Infome a placa do veiculo: ");
    sc.nextLine();
    String placa = sc.nextLine();
    Optional<Carro> carroSelecionadoOptional =
            carros.stream()
                    .filter(carro -> carro.getPlaca().equals(placa))
                    .findFirst();

    if (carroSelecionadoOptional.isEmpty()) {
        System.out.println("Veiculo não encontrado'");
        return null;
    }
    return carroSelecionadoOptional.get();
}

private void Alugar(List<Cliente> clientes, List<Carro> carros, List<Locacao> locacoes) {
    System.out.println("Alugar carro ");
    System.out.println("Infome o CPF: ");
    Integer cpf = sc.nextInt();
    List<Cliente> clienteList = clientes.stream()
            .filter(cliente -> cliente.getCpf() == cpf)
            .collect(Collectors.toList());

    Carro carro = encontrarCarro(carros);
    if (carro == null) {
        return;
    }

    System.out.println("Quantos dias de aluguel? ");
    Integer dias = sc.nextInt();

    Locacao locacao1 = new Locacao(clienteList.getFirst(), carro, LocalDate.now(), LocalDate.now().plusDays(dias));
    locacoes.add(locacao1);
    System.out.println("Aluguel realizado com sucesso");
}

private void cadastrarCarro(List<Carro> carros) {
    IO.println(String.format("Marca: "));
    sc.nextLine();
    String marca = sc.nextLine();
    IO.println(String.format("Modelo: "));
    String modelo = sc.nextLine();
    IO.println(String.format("Cor: "));
    String cor = sc.nextLine();
    IO.println(String.format("Placa: "));
    String placa = sc.nextLine();
    IO.println(String.format("Ano: "));
    Integer ano = sc.nextInt();

    Carro carro = new Carro(marca, modelo, cor, placa, ano);
    carros.add(carro);
    System.out.println("Cadastrado com sucesso.");
}

private void cadastrarCliente(List<Cliente> clientes) {
    IO.println(String.format("Nome: "));
    sc.nextLine();
    String nome = sc.nextLine();
    IO.println(String.format("CPF: "));
    Integer cpf = sc.nextInt();

    Cliente cliente = new Cliente(nome, cpf);
    clientes.add(cliente);
    System.out.println("Cadastrado com sucesso");
}