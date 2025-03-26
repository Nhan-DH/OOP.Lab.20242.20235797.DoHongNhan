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
			int a = -1;
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i] == y) {
					System.out
							.println("Đã xóa DVD : " + y.getTitle() + " thành công !!!" + " ( -" + y.getCost() + " ) ");
					a = i;
					break;
				}
			}
			if (a == -1) {
				System.out.println("DVD không tồn tại trong Cart");
			}

			for (int i1 = a; i1 < qtyOrdered - 1; i1++) {
				itemsOrdered[i1] = itemsOrdered[i1 + 1];

			}
		}
		qtyOrdered--;
		System.out.println("Giỏ hàng hiện tại là :");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + " . " + itemsOrdered[i].getTitle() + " giá : " + itemsOrdered[i].getCost());
		}

	}

	public void totalCost() {
		System.out.println("Hóa đơn của bạn : ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + " . " + itemsOrdered[i].getTitle() + " giá : " + itemsOrdered[i].getCost());
		}
		float sum = 0.00f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		System.out.printf("Tổng tiền cần thanh toán: %.2f\n", sum);
	}
}
