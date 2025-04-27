package hust.soict.hesdpi.aims;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import hust.soict.hesdpi.aims.cart.Cart;
import hust.soict.hesdpi.aims.media.Book;
import hust.soict.hesdpi.aims.media.CompactDisc;
import hust.soict.hesdpi.aims.media.DigitalVideoDisc;
import hust.soict.hesdpi.aims.media.Media;
import hust.soict.hesdpi.aims.media.Track;
import hust.soict.hesdpi.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "bach tuyet va 7 chu lun", "hoat hinh", 100.0f, "an danh", 90);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "natra", "hoat hinh", 100.0f, "an danh", 90);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		ArrayList<Track> banghi = new ArrayList<Track>();
		banghi.add(new Track("lao tam kho tu", 3));
		banghi.add(new Track("dung nguoi dung thoi diem", 4));
		banghi.add(new Track("tung yeu ca 1 thanh pho", 5));
		CompactDisc cd = new CompactDisc(3, "tinh yeu", "nhac tre", 50.0f, "Thanh Hung", banghi);
		store.addMedia(cd);
		List<String> tacgia = new ArrayList<String>();
		tacgia.add("nguyen nhat anh");
		tacgia.add("higashino keigo");
		Book book = new Book(4, "mat biec", "tinh cam", 100.f, tacgia);
		store.addMedia(book);
		Cart cart = new Cart();
		cart.addMedia(book);
		cart.addMedia(dvd1);
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner, store, cart);

	}

	public static void showMenu(Scanner scanner, Store store, Cart cart) {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. Xem store");
		System.out.println("2. Them store");
		System.out.println("3. Gio hang hien tai");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Hãy chọn chức năng : 0-1-2-3");
		int option = scanner.nextInt();
		switch (option) {
		case 0 -> {
			scanner.close();
			System.exit(0);
		}
		case 1 -> storeMenu(scanner, store, cart);
		case 2 -> updateStoreMenu(scanner, store, cart);
		case 3 -> {
			cart.printCart();
			cartMenu(scanner, store, cart);
		}
		}
	}

	public static void updateStoreMenu(Scanner scanner, Store store, Cart cart) {
		System.out.println("""
				==========================
				1. Thêm Media
				2. Xóa Media
				3. update Media in Store
				0. Trở về
				==========================
				Option: """);
		int option = scanner.nextInt();
		switch (option) {
		case 1 -> {
			System.out.println("""
					1.DigitalVideoDisc
					2.CompactDisc
					3.Book
					-------
					-> Your type: """);
			int option2 = scanner.nextInt();
			System.out.print("Id là : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("tiêu đề là: ");
			String title = scanner.nextLine();
			System.out.print("thể loại là: ");
			String category = scanner.nextLine();
			System.out.print("Giá là: ");
			float cost = scanner.nextFloat();
			scanner.nextLine();
			switch (option2) {
			case 1 -> {
				System.out.print("Ten dao dien la: ");
				String director = scanner.nextLine();
				System.out.print("Độ dài la : ");
				int length = scanner.nextInt();
				scanner.nextLine();
				store.addMedia(new DigitalVideoDisc(id, title, category, cost, director, length));
			}

			case 2 -> {
				System.out.print("Enter artist's name: ");
				StringBuffer artist = new StringBuffer(scanner.nextLine());
				System.out.print("Enter number of track: ");
				int nbTrack = scanner.nextInt();
				scanner.nextLine();
				ArrayList<Track> tracks = new ArrayList<Track>();
				StringBuilder name = new StringBuilder();
				for (int i = 0; i < nbTrack; i++) {
					System.out.print("Enter Track[" + i + "]'s name: ");
					name.replace(0, name.length(), scanner.nextLine());
					System.out.print("Enter Track[" + i + "]'s length: ");
					int length = scanner.nextInt();
					tracks.add(new Track(name.toString(), length));
					scanner.nextLine();

				}
				store.addMedia(new CompactDisc(id, title, category, cost, artist.toString(), tracks));
			}
			case 3 -> {
				System.out.print("Enter author's name (Enter nothing to skip): ");
				StringBuilder author = new StringBuilder(scanner.nextLine());
				ArrayList<String> authors = new ArrayList<String>();
				while (!author.isEmpty()) {
					authors.add(author.toString());
					System.out.print("Enter author's name (Enter nothing to skip): ");

				}
				store.addMedia(new Book(id, title, category, cost, authors));
			}
			}
		}
		case 2 -> {
			System.out.println("Enter item's title: ");
			scanner.nextLine();
			String title = scanner.nextLine();
			Iterator<Media> iter = store.getItemsInStore().iterator();
			while (iter.hasNext()) {
				Media item = iter.next();
				if (item.getTitle().equals(title)) {
					iter.remove();
					System.out.println(item.getClass().getSimpleName() + " " + item.getTitle()
							+ "'ve been deleted from the store !");
				}
			}
		}
		case 3 -> {
			System.out.println("Enter item's id: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter title: ");
			String title = scanner.nextLine();
			System.out.print("Enter category: ");
			String category = scanner.nextLine();
			System.out.print("Enter cost: ");
			float cost = scanner.nextFloat();
			store.getItemsInStore().get(id).setCost(cost);
			store.getItemsInStore().get(id).setTitle(title);
			store.getItemsInStore().get(id).setCategory(category);
			System.out.println(store);
		}
		case 0 -> {
			showMenu(scanner, store, cart);
		}
		}
	}

	public static void storeMenu(Scanner scanner, Store store, Cart cart) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1 -> mediaDetailsMenu(scanner, store, cart);
		case 0 -> {
			showMenu(scanner, store, cart);
		}
		case 2 -> {
			System.out.print("Enter media's title: ");
			String title = scanner.nextLine();
			Media item = store.findMedia(title);
			if (item == null) {
				System.out.println("There is no such media !");
			} else {
				cart.addMedia(item);
			}
		}
		case 3 -> {
			System.out.print("Enter media's title: ");
			String title = scanner.nextLine();
			Media item = store.findMedia(title);
			if (item == null) {
				System.out.println("There is no such media !");
			} else {
				if (item.getClass().getSimpleName().equals("Book")) {
					System.out.println("This media is unplayable");
				} else {
					if (item instanceof DigitalVideoDisc dvd) {
						dvd.play();
					}
					if (item instanceof CompactDisc cd) {

						cd.play();

					}
				}
			}
		}

		case 4 -> {
			cart.printCart();
			cartMenu(scanner, store, cart);
		}
		}
	}

	public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
		System.out.print("Enter media's title: ");
		String title = scanner.nextLine();
		Media item = store.findMedia(title);
		if (item == null) {
			System.out.println("There is no such media !");
			return;
		}
		System.out.println(item);
		while (true) {
			System.out.println("""
					Options:
					--------------------------------
					1. Add to cart
					2. Play
					0. Back
					--------------------------------
					Please choose a number: 0-1-2""");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 1 -> {
				cart.addMedia(item);
			}
			case 2 -> {
				if (item.getClass().getSimpleName().equals("Book")) {
					System.out.println("This media is unplayable");
				} else {
					if (item instanceof DigitalVideoDisc dvd) {
						dvd.play();
					}
					if (item instanceof CompactDisc cd) {
						cd.play();
					}
				}
			}
			case 0 -> {
				storeMenu(scanner , store , cart);
			}
			}
		}
	}

	public static void cartMenu(Scanner scanner, Store store, Cart cart) {
		while (true) {
			System.out.println("""
					Options:
					--------------------------------
					1. Filter medias in cart
					2. Sort medias in cart
					3. Remove media from cart
					4. Play a media
					5. Place order
					0. Back
					--------------------------------
					"Please choose a number: 0-1-2-3-4-5""");
			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option) {
			case 0 -> {
				showMenu(scanner, store, cart);
			}
			case 1 -> {
				System.out.println("""
						1. Filter by title
						2. Filter by id
						----------------
						your option:
						""");
				int option2 = scanner.nextInt();
				scanner.nextLine();
				if (option2 == 1) {
					int id = scanner.nextInt();
					cart.searchById(id);
				} else {
					String title = scanner.nextLine();
					cart.searchByTitle(title);
				}
			}
			case 2 -> {
				System.out.println("""
						1. sort by title cost
						2. sort by cost title
						----------------
						your option:
						""");
				int option2 = scanner.nextInt();
				scanner.nextLine();
				if (option2 == 1) {
					cart.sortByTitleCost();
					cart.printCart();
				} else {
					cart.sortByCostTitle();
					cart.printCart();
				}
			}
			case 3 -> {
				System.out.print("Enter media's title: ");
				String title = scanner.nextLine();
				Media item = cart.findMedia(title);
				if (item == null) {
					System.out.println("There is no such media !");
				} else {
					cart.removeMedia(item);
				}
			}
			case 4 -> {
				System.out.print("Enter media's title: ");
				String title = scanner.nextLine();
				Media item = cart.findMedia(title);
				if (item == null) {
					System.out.println("There is no such media !");
				} else {
					if (item.getClass().getSimpleName().equals("Book")) {
						System.out.println("This media is unplayable");
					} else {
						if (item instanceof DigitalVideoDisc dvd) {
							dvd.play();
						}
						if (item instanceof CompactDisc cd) {
							cd.play();
						}
					}
				}
			}
			case 5 -> {
				System.out.println("Your cart have been paid\nThanks for using our service");
				cart.emptyCart();
			}
			}
		}
	}

}