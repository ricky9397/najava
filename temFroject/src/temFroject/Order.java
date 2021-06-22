package temFroject;

public class Order {
	private int oidx;
	private int ordercode;
	private int icod ;
	private int idx;
	private String date;
	private int price;
	private int count;
	public Order(int oidx, int ordercode, int icod, int idx, String date, int price, int count) {
		super();
		this.oidx = oidx;
		this.ordercode = ordercode;
		this.icod = icod;
		this.idx = idx;
		this.date = date;
		this.price = price;
		this.count = count;
	}
	public int getOidx() {
		return oidx;
	}
	public void setOidx(int oidx) {
		this.oidx = oidx;
	}
	public int getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(int ordercode) {
		this.ordercode = ordercode;
	}
	public int getIcod() {
		return icod;
	}
	public void setIcod(int icod) {
		this.icod = icod;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Order [oidx=" + oidx + ", ordercode=" + ordercode + ", icod=" + icod + ", idx=" + idx + ", date=" + date
				+ ", price=" + price + ", count=" + count + "]";
	}
}
