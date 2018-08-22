# Design the data structures for an online book reader system.

## Object Oriented Design Questions:
1. Handle Ambiguity
What does it mean to be an online book reader system? If we make the assumption that it is like read.amazon.com: 
  * this thing should have access to a User's library of books. 
  * When you open a book, it should display the content of the book. 
  * When a book is opened, it should turn to the page that the user was last on
  * You should be able to move back and forth through the pages. 
  * You should be able to bookmark a page. 
  * Since it is online, it probably needs a list of users. 

2. Define Core Objects
```User, Library, Book, Reader```

3. Analyze Relationships 
A User has a Library. 
A Library has a list of Books.

4. Investigate Actions
A User has a Library object, and should probably have a pointer to current Book being read.
This current Book pointer should be swapped out if the user chooses to read another book. 

The Library object has a list of books that would be displayed by the Reader. When a book is selected,
the Reader opens the book and sets current book being read on the User. 

Perhaps better would be to have a Reader Object on the User. The Reader Object would have the current book
being read. 

## Data Structures

```Java
// again, public accessors for brevity. 
// Disclaimer - did not implement all objects, just sampling. Yes, I know this doesn't fully finish
// the problem, but it's enough to say I dabbled. 
public class User {
  public int id;
  public String firstName;
  public String lastName;
  public Library library;

  public User(int id) {
    User userObj = AuthService.getUser(id);
    this.id = userObj.id;
    this.firstName = userObj.firstName;
    this.lastName = userObj.lastName;
    this.library = userObj.library;
  }
}

public class Library {
  public ArrayList<Book> library; 
  public Book currentlyReading;
}

public class Book {
  public String title;
  public String author;
  public ArrayList<Page> pages;
}

public class Page {
  public String content; 
}

```