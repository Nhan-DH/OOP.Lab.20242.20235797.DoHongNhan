package lab2;

public class Cart {
	public static final int MAX_NUMBERS_ORDERS = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];

	private int qtyOrdered; // so DVD hien tai trong Cart

	public void addDigitalVideoDisc(DigitalVideoDisc x) {
		if (qtyOrdered == MAX_NUMBERS_ORDERS) {
			System.out.println("Cart đã đầy, không thể thêm");
		} else {
			itemsOrdered[qtyOrdered] = x;
			qtyOrdered++;
			System.out.println("Đã thêm DVD : " + x.getTitle() + " vào thành công !!!");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc y) {

		if (itemsOrdered[0] == null) {
			System.out.println("Cart hiện tại đã trống !!!");
		} else {
			int a = 0;
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i] == y) {
					System.out.println("Đã xóa DVD : " + y.getTitle() + " thành công !!!" + " ( -" + y.getCost() + " ) ");
					a = i;
					break;
				}
			}
		if(a == 0) {
			System.out.println("DVD không tồn tại trong Cart");
		}
			

			for (int i1 = a; i1 < qtyOrdered; i1++) {
				itemsOrdered[i1] = itemsOrdered[i1 + 1];
				qtyOrdered--;

			}
		}
	}

	public float totalCost() {
		float sum = 0.00f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
}
