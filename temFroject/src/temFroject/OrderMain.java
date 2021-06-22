package temFroject;

public class OrderMain {

	public static void main(String[] args) {
		OrderManager o = new OrderManager(OrderDAO.getInstance());
		o.run();
	}

}
