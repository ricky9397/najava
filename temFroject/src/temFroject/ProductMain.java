package temFroject;

public class ProductMain {

	public static void main(String[] args) {
		ProductManager p = new ProductManager(ProductDAO.getInstance());
	      
	      p.list();

	}

}
