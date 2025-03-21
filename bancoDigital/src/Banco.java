import java.util.ArrayList;
import java.util.List;
public class Banco {
    private final List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println("Cliente: " + conta.getCliente().getNome() + " | Tipo: " + conta.getTipo() + " | Saldo: " + conta.getSaldo());
        }
    }

    public Conta buscarContaPorNome(String nome) {
        for (Conta conta : contas) {
            if (conta.getCliente().getNome().equalsIgnoreCase(nome)) {
                return conta;
            }
        }
        return null;
    }
}