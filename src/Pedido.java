import java.util.Observable;

public class Pedido extends Observable {
    private String status;

    public Pedido() {
        this.status = "Pedido criado";
    }

    public void setStatus(String novoStatus) {
        this.status = novoStatus;
        setChanged();
        notifyObservers(novoStatus);
    }

    public String getStatus() {
        return status;
    }
}
