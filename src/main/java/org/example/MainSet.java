package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainSet {

    public static void exampleHashCode() {
        Set<Tag> tags = new HashSet<>();
        HTag htag = new HTag(1, "Hej");
        tags.add(htag);
        System.out.println(tags.size());
        tags.add(htag);
        System.out.println(tags.size());
        boolean ct = tags.contains(htag);
        HTag htag2 = new HTag(1, "Hej");
        htag2.setId(htag.getId());
        tags.add(htag2);
        System.out.println(tags.size());

        for (Tag tag: tags) {
            System.out.println(tag);
        }

        System.out.println(tags);

    }


    public static void main(String[] args) {
        Set<Tag> tags = new HashSet<>();
        long start = System.currentTimeMillis();
        Set<Integer> hashCodes = new HashSet<>();
        for (int i=1; i<=4000000; i++) {
            HTag hTag = new HTag(1, "Hej" + i);
            //tags.add(new HTag(1, "Hej +" + i));
            hTag.setId(hTag.getText());
            tags.add(hTag);
            hashCodes.add(hTag.hashCode());
            PTag pTag = new PTag("Hejx"+i);
            pTag.setId(pTag.getText());
            tags.add(pTag);
            hashCodes.add(pTag.hashCode());
        }

        long end = System.currentTimeMillis();
        System.out.println("loop1=" + (end-start));
        System.out.println(tags.size());
        System.out.println("hashcodesz=" + hashCodes.size());

        //for (int i=0; i<4; i++) {  dur ikke til slet
        int sz = tags.size();

        Iterator<Tag> it = tags.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            if (tag instanceof HTag) {
                it.remove();
            }
        }
        System.out.println(tags.size());
        long slet = System.currentTimeMillis();
        System.out.println("slet=" + (slet-end));

    }

}
