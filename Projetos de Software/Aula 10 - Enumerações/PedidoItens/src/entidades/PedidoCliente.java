package entidades;

import java.util.ArrayList;
import java.util.List;

import entidadesEnum.StatusPedido;

public class PedidoCliente {
	private Cliente cliente;
	private List<ItemPedido> itens;
	private StatusPedido status;
	
	public PedidoCliente(Cliente cliente, StatusPedido status) {
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.status = status;
	}
	
	public void adicionarItem(ItemPedido item) {
		itens.add(item);
	}
	
	public double calcularTotalPedido() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }
	
	@Override
	public String toString() {
	    return "Pedido do Cliente: " + cliente.getNome() + " (" + cliente.getEmail() + ")\n" + "Status do Pedido: " 
	    		+ status + "\nTotal do Pedido: R$ " + String.format("%.2f", calcularTotalPedido());

	    
	}
	
}
