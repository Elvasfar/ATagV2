package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainLinkedList {

    public static void main(String[] args) {
        //Kod et loop der kører 20 gange
        //     i hver iteration, tilføj et HTag og et PTag til liste. og det er en ArrayList.class

        long start = System.currentTimeMillis();

        List<Tag> tags = new LinkedList<>();
        for (int i=1; i<=2000000; i++) {
            tags.add(new HTag(1, "Hej +" + i));
            tags.add(new PTag("p="+i));
        }

        long end = System.currentTimeMillis();
        System.out.println("loop1=" + (end-start));

        System.out.println(tags.size());
        //for (int i=0; i<4; i++) {  dur ikke til slet
        int sz = tags.size();

        Iterator<Tag> it = tags.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            if (tag instanceof HTag) {
                it.remove();
            }
        }

        /*for(int i = sz-1; i>=0; i--) {
            Tag tag = tags.get(i);
            if (tag instanceof SpanTag) {
                tags.remove(tag);
            }
        }*/
        long slet = System.currentTimeMillis();
        System.out.println("slet=" + (slet-end));

        System.out.println(tags.size());
        //System.out.println(tags);

    }

}
