
## My refactoring approach

I wanted to focus solely on object-oriented design and patterns. The main issue with the original code is that the 
RentalInfo class does too much: it formats a customer statement and contains rate logic for different types of movies. 
This violates the single responsibility principle. Besides, it contains conditional checking on the movie type. This kind 
of code is very brittle as any future change to the rate logic will necessitate making changes in the statement method.

My approach is to abstract away rate calculation logic into a Movie interface. This interface contains two important methods:
rate(nDays) and bonusPoints(nDays). It would be up to the implementing class to realize a concrete business rule, depending
on which type of movie this is.

This interface is implemented by three classes: NewMovie, RegularMovie and ChildrenMovie. Each of these classes implements
its own rate calculation logic. 

Most importantly, the client code (i.e. MovieRental and Customer's printStatement method) will never know the exact type of a movie.
They only see the Movie interface. As a result, the code in printStatement() is much more robust. Any new type of a movie will simply
imply creating a concrete class implementing the Movie interface. The code in printStatement will never need to change.
This significantly decreases a chance of introducing a bug into existing code.

This implementation follows another important SOLID principle: Open/Closed Principle, which states that a class should be open for extension but closed for modification.

Last but not least, the printStatement method takes a Writer as a parameter. The method will write customer statement to this writer. This gives us the flexibility to write to a string, HTML, PDF or even generate a cool image. Just extend Writer and 
override its write() method or use any readily available writers. The overriden write() method could generate HTML or write directly to an underlying PDF library.

Most importantly the printStatement() method is now stable. If you want to add a new movie type rate, just implement the Movie interface with the new logic. If you want to print customer statement to a network socket instead of a string, just use 

PrintWriter out = new PrintWriter(someSocket.getOutputStream());
customer.printStatement(out)

All of that makes code cleaner and more test-friendly. We can now completely isolate tests for each type of a movie.

PS: Usually I would create a Maven project with the src and test folders but I just wanted to focus on the actual object-oriented
design here.

## To run the test:

```
javac src/*.java
java -cp src Main
```
