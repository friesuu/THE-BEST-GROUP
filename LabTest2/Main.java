package LabTest2;

public class Main 
{
    public static void main(String[] args) 
    {
        BorrowedBookStack<Integer> borrowedBooks = new BorrowedBookStack<Integer>(5);
        ReturnedBooksQueue<Integer> returnedBooksQueue = new ReturnedBooksQueue<Integer>(5);

        borrowedBooks.borrowBook(1111);
        borrowedBooks.borrowBook(2222);
        borrowedBooks.borrowBook(3333);
        borrowedBooks.borrowBook(4444);
        borrowedBooks.borrowBook(5555); // Adding 5 books to BorrowedBooksStack 
       
        System.out.println("The book ID at the top of the stack is: " + borrowedBooks.peekAtTopBook()); // Checking the top of the borrowed books stack

        //System.out.println(borrowedBooks.returnBook());

        System.out.println("Returning book...");
        returnedBooksQueue.returnBook(borrowedBooks.returnBook()); // Simulating book returning using the returnBook() methods
        returnedBooksQueue.returnBook(borrowedBooks.returnBook());
        returnedBooksQueue.returnBook(borrowedBooks.returnBook());

        System.out.println("Returned book ID: " + returnedBooksQueue.processReturnedBooks()); // Processing returned books
        System.out.println("Returned book ID: " + returnedBooksQueue.processReturnedBooks());
        System.out.println("Returned book ID: " + returnedBooksQueue.processReturnedBooks());
        
        //System.out.println(returnedBooksQueue.peekAtFrontBook());

        //System.out.println(borrowedBooks.getSize());
    }    
}
