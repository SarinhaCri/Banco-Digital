import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            Cliente cliente = new Cliente(nome);

            System.out.println("Escolha o tipo de conta: 1 - Conta Corrente | 2 - Conta Poupança");
            int tipoConta = scanner.nextInt();
            scanner.nextLine();

            Conta conta;
            if (tipoConta == 1) {
                conta = new ContaCorrente(cliente);
            } else {
                conta = new ContaPoupanca(cliente);
            }

            banco.adicionarConta(conta);

            int opcao;
            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Transferir");
                System.out.println("4 - Consultar saldo");
                System.out.println("5 - Sair");
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    }
                    case 2 -> {
                        System.out.print("Digite o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    }
                    case 3 -> {
                        System.out.print("Digite o nome do destinatário: ");
                        String nomeDestinatario = scanner.nextLine();
                        Conta contaDestino = banco.buscarContaPorNome(nomeDestinatario);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor para transferir: ");
                            double valorTransferencia = scanner.nextDouble();
                            conta.transferir(valorTransferencia, contaDestino);
                        } else {
                            System.out.println("Conta do destinatário não encontrada.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Cliente: " + conta.getCliente().getNome());
                        System.out.println("Saldo atual: " + conta.getSaldo());
                    }
                    case 5 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 5);
        } 
    }
}
