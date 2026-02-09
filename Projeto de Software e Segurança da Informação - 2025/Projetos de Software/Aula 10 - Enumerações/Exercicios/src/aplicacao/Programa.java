package aplicacao;
import java.util.Date;
import entidades.Ordem;
import entidades.enums.OrderStatus;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ordem ordem = new Ordem(1080, new Date(), OrderStatus.PAGAMENTO_PENDENTE);
		System.out.println(ordem);
		
		
		OrderStatus os1 = OrderStatus.ENTREGUE;
		OrderStatus os2 = OrderStatus.valueOf("ENTREGUE");
		System.out.println(os1);
		System.out.println(os2);
	}

}
