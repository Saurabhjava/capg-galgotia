package cpm.cg;

import java.util.Scanner;

public class DigitalcomProcess {
	public static void main(String[] args) {
		User u = new User();
		GameService gs = new GameService();
		while (true) {
			System.out.println("1: for RegisterUser");
			System.out.println("2: for Login");
			System.out.println("3: for Exit");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter UserID and Password:");
				u.addUser(sc.next(), sc.next());
				break;
			case 2:
				System.out.println("Enter UserId and Password to Login");
				if (u.IsAuthenticated(sc.next(), sc.next())) {
					while (true) {
						System.out.println("3: To view All Game");
						System.out.println("4: To search Game");
						System.out.println("5: To Exit");
						int ch1 = sc.nextInt();
						switch (ch1) {
						case 3:
							gs.viewAll().forEach(g -> System.out.println(g));
							break;
						case 4:
							System.out.println("Enter AuthorName");
							System.out.println(gs.authorSearch(sc.next()));
							break;
						case 5:
							return;

						}
					}
				} else {
					System.out.println("Wrong UserId and Password");
				}

			case 3:
				return;
			}
		}
	}
}
