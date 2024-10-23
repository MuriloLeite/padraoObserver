import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
        this.ultimaNotificacao = null;
    }

    public void FazerPedido(Pedido pedido) {
        pedido.addObserver(this);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Observable pedido, Object arg) {
        this.ultimaNotificacao = nome + ": " + arg;
    }
}
