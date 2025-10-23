package library;

import java.util.Scanner;

public class libraryDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(    System.in);
        BookStorga bookStorga = new BookStorga();
        boolean isRun = true;

        while (isRun){
            System.out.println("Please input 0 for EXIT");
            System.out.println("Please input 1 for ADD BOOK");
            System.out.println("Please input 2 for PRINT ALL BOOKS");
            System.out.println("Please input 3 for SEARCH BOOK BY TITLE");
            System.out.println("Please input 4 for PRINT EXPENSIVE BOOK");
            System.out.println("Please input 5 for DELETE BOOK BY INDEX");
            System.out.println("Please input 6 for SEARCH BOOKS BY PRICE RANGE");
            String command = scanner.nextLine();
            switch (command){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Please input book`s title");
                   String bookTitle = scanner.nextLine();
                    System.out.println("Please input book`s authorName");
                    String authorName = scanner.nextLine();
                    System.out.println("Please input book`s prise ");
                    double prise = Double. parseDouble(scanner .nextLine());
                    int quantity = 0;
                    Book book = new Book(bookTitle, authorName, prise,
                            quantity);
                    bookStorga.add(book);
                    System.out.println("Book added successfully");
                    break;
                case "2":
                    bookStorga.print();
                    break;
                case "3":
                    System.out.println("Pleace input keyword");
                    String keyword = scanner.nextLine();
                    bookStorga.search(keyword);
                case "4":
                    Book expensiveBook = bookStorga.getBookByMaxPrice();
                    System.out.println(expensiveBook);
                    break;
                case "5":
                    bookStorga.print();
                    System.out.println("Please input index to delete:");
                    int index = Integer.parseInt(scanner.nextLine());
                    bookStorga.deleteByIndex(index);
                    break;
                case "6":
                    System.out.println("Please input min price:");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Please input max price:");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    bookStorga.searchByPriceRange(minPrice, maxPrice);
                    break;
                default:
                    System.err.println("Wrong command! try again");





            }
        }
    }
}
