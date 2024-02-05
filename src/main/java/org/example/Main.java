package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       //Kod et loop der kører 20 gange
       //     i hver iteration, tilføj et HTag og et PTag til liste. og det er en ArrayList.class

        List<Tag> tags = new ArrayList<>();
        for (int i=1; i<=20; i++) {
            tags.add(new HTag(1, "Hej +" + i));
        }




        SpanTag sp = new SpanTag("Hej");
        System.out.println(sp);
        PTag ptag = new PTag("jeg er p");
        System.out.println(ptag);





    }
}
