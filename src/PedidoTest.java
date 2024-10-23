import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("Cliente 1");
        cliente.FazerPedido(pedido);
        pedido.setStatus("Pedido em preparação");
        assertEquals("Cliente 1: Pedido em preparação", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMultiplosClientes() {
        Pedido pedido = new Pedido();
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.FazerPedido(pedido);
        cliente2.FazerPedido(pedido);
        pedido.setStatus("Pedido enviado");
        assertEquals("Cliente 1: Pedido enviado", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2: Pedido enviado", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarClienteQueNaoEstaRegistrado() {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente("Cliente 1");
        pedido.setStatus("Pedido entregue");
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteClienteAssociadoAPedido() {
        Pedido pedidoA = new Pedido();
        Pedido pedidoB = new Pedido();
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.FazerPedido(pedidoA);
        cliente2.FazerPedido(pedidoB);
        pedidoA.setStatus("Pedido em preparação");
        pedidoB.setStatus("Pedido enviado");

        assertEquals("Cliente 1: Pedido em preparação", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2: Pedido enviado", cliente2.getUltimaNotificacao());
    }
}
