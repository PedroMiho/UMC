package programa;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.PedidoCliente;
import entidadesEnum.StatusPedido;

public class Principal {

	public static void main(String[] args) {
	
		Cliente cliente = new Cliente("Pedro", "pedromiho@gmail.com");
		System.out.println(cliente.toString());
		System.out.println();	
		
		System.out.println("Selecione o status do pedido");
		for (StatusPedido status : StatusPedido.values()) {
			System.out.println(status);
		}
		System.out.println();
		StatusPedido status = StatusPedido.valueOf("ENTREGUE");
		
		PedidoCliente pedido = new PedidoCliente(cliente, status);

		int quantidadeItens = 3;
		
		for (int i = 0; i<quantidadeItens;i++) {
			String nomeItem = "Camisa";
			int quantidade = 10;
			double valor = 50;
			
			ItemPedido item = new ItemPedido(nomeItem, quantidade, valor);
			pedido.adicionarItem(item);
			
		}
		
		System.out.println(pedido.toString());
	
	}

}
