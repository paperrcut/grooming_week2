package com.practice.week2.Comparable_Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int yearPublished;

    public int compareTo(Book o)
    {
        return this.yearPublished-o.yearPublished;
    }

    @Override
    public String toString() {
        return "title: " + title  +
                "\t\tauthor: " + author +
                "\t\tyearPublished: " + yearPublished + "\n";
    }

    public static void main(String[] args)
    {
        List<Book> books= new ArrayList<>();
        books.add(new Book("40 Rules of Love","Elif Shafak", 2009));
        books.add(new Book("Mein Kampf","Adolf Hitler", 1925));
        books.add(new Book("Supernatural Omnibus","Ruskin Bond", 2005));

        System.out.println("Before sort:\n"+books);
        Collections.sort(books);
        System.out.println("After sort:\n"+books);
    }
}
