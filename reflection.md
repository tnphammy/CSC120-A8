Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
    * Constructors:
        - House.java: Overloaded a default constructor, and a constructor with nFloor, hasElevator, and hasDiningRoom only because I thought these where the most important elements of a House for interaction.
        - Library.java: Overloaded constructor with nFloors and hasElevator only due to the same reasons as the one above.
        - (Not within assignment) Student.java: I wanted to do this quickly to skip having to write studentID number and just fill out name and classYear.

    * Methods (in Cafe.java):
        - sellCoffee(): Overloaded another one that could take a named order, like an Americano.
        - sellCoffees(): Overloaded one that could take multiple (specified) number of coffee orders by the specific requirements, and another that could take a named order in specified quantities, like an Americano.

    * Methods (in Library.java):
        - addTitle(): Overloaded so that the library can add multiple books at once. I could have done that with removeTitle(), but I chose not to, because I think removing books by large quantities is not desirable, and should be done carefully.
        - checkOut(): Overloaded so that multiple books can be check out at once. Personally, I've had to check out multiple books many times for classes. So, I see the value in overloading a method for that, and expediting the process.

    * Methods (in House.java):
        - moveIn(): Overloaded so that multiple students can move in a house at once. I did this because for every academic year, many first-years move in at once. This would quicken the process instead of having to add every single student.
        - moveOut(): Overloaded so that multiple students can move out a house at once. Every year, a class year graduates. Also, there are study abroad students that might all move out a house. This makes it faster!
        
- What worked, what didn't, what advice would you give someone taking this course in the future?
    I used much less ChatGPT this time around, and have been working on this project for days.

    * What worked:
        - Giving youself time to figure out the problems, so start coding early!
        - Mainly trying to figure it out yourself first, then consulting the internet, then maybe ChatGPT (but really refrain from it, unless it's overly specific and it's due soon – preventable by starting early!)
        - For my newly made Coffee.java: Sketching a real-life depiction of a coffee shop and seeing what is a class, a subclass, a list.
        - Looking at old assignments and in-class examples instead of googling. 

    * What didn't work:
        - Feeling bad about not being to solve something: It will happen eventually. To mitigate this, it helps to change your mindset into more of a "I've felt it before, and every time I've come out of it, so I can just let it happen and try my best."
        - Consulting ChatGPT and Google too much: I google, on average, every 5 minutes. And honestly, I don't think it's wrong, as I am still in the beginning stages and I have horrible memory. But now, instead, I try to figure it out by myself for at least 10 minutes, so that the attempts can consolidate certain things in my memory. Now, I google mostly what I don't know (as opposed to things I know, but forgot)
