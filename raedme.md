# Introduction


When working with an object-oriented programming language, this issue is inevitable, you want to store some information and you'll want to use a database. Now, You could manually perform a process called serialisation, you take your object in memory, convert it into a standardised format. With this, you move your object fields into a database. Every time you slightly change your Java class, you'll need to write the SQL that goes alongside it.

If you have not experienced this process yet, it can be a pain to deal with. No matter the scale you're working at, it is very time consuming!

And thus, the open-source protagonist takes the stage: Hibernate. It simplifies this process by mapping a Java class to database table. Instead of writing long SQL queries, manual builders or serialisation procedures, we can use Hibernate APIs or Hibernate Query Language (HQL) to perform database operations or queries.

## What is Object Relational Mapping? (ORM)

A programming technique that lets you interact with a relational database using the objects of your programming language, instead of writing raw SQL queries. It acts as a bridge, translating your code's objects into database rows, and vice-versa.

## What is this github for
This github is a template that you can use to create a 7.4,final hibernate application using maven and standalone java.