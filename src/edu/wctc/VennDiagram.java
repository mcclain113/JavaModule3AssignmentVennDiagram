package edu.wctc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class VennDiagram <T> {
    public T getCircle1() {
        return circle1;
    }

    public void setCircle1(T circle1) {
        this.circle1 = circle1;
    }

    public T getCircle2() {
        return circle2;
    }

    public void setCircle2(T circle2) {
        this.circle2 = circle2;
    }

    public T getCircle3() {
        return circle3;
    }

    public void setCircle3(T circle3) {
        this.circle3 = circle3;
    }

    public T circle1;
    private T circle2;
    private T circle3;

    Set<T> set1;
    Set<T> set2;
    Set<T> set3;

    public VennDiagram(String label1, String label2, String label3) {
        this.circle1 = (T) label1;
        this.circle2 = (T) label2;
        this.circle3 = (T) label3;

        set1 = new HashSet<>();
        set2 = new HashSet<>();
        set3 = new HashSet<>();
    }

    private Set<T> getCircleForLabel(T label) {
        if (circle1.equals(label)) {
            return set1;
        } else if (circle2.equals(label)) {
            return set2;
        } else if (circle3.equals(label)) {
            return set3;
        } else {
            return null;
        }
    }

    public void add(T item, String label1, String label2, String label3) {

        if (label1.equals(circle1)) {set1.add(item);}
        if (label2.equals(circle2)) {set2.add(item);}
        if (label3.equals(circle3)) {set3.add(item);}


    }

    public void add(T item, String label1, String label2) {

        if (label1.equals(circle1)) {set1.add(item);}
        if (label1.equals(circle2)) {set2.add(item);}
        if (label1.equals(circle3)) {set3.add(item);}

        if (label2.equals(circle1)) {set1.add(item);}
        if (label2.equals(circle2)) {set2.add(item);}
        if (label2.equals(circle3)) {set3.add(item);}


    }

    public void add(T item, String label1) {

        if (label1.equals(circle1)) {set1.add(item);}
        if (label1.equals(circle2)) {set2.add(item);}
        if (label1.equals(circle3)) {set3.add(item);}

    }



    public Set<T> unionOf(String first, String second){
        Set<String> union = new HashSet<>();
        if (first.equals(circle1)) {union.addAll((Collection<? extends String>) set1);}
        if (first.equals(circle2)) {union.addAll((Collection<? extends String>) set2);}
        if (first.equals(circle3)) {union.addAll((Collection<? extends String>) set3);}

        if (second.equals(circle1)) {union.addAll((Collection<? extends String>) set1);}
        if (second.equals(circle2)) {union.addAll((Collection<? extends String>) set2);}
        if (second.equals(circle3)) {union.addAll((Collection<? extends String>) set3);}

        return (Set<T>) union;} //Returns all items in either the first or second set
    
    public Set<T> intersectionOf(String first, String second){
        Set<String> intersection = new HashSet<>();
        if (first.equals(circle1)) {intersection.addAll((Collection<? extends String>) set1);}
        if (first.equals(circle2)) {intersection.addAll((Collection<? extends String>) set2);}
        if (first.equals(circle3)) {intersection.addAll((Collection<? extends String>) set3);}

        if (second.equals(circle1)) {intersection.retainAll((Collection<? extends String>) set1);}
        if (second.equals(circle2)) {intersection.retainAll((Collection<? extends String>) set2);}
        if (second.equals(circle3)) {intersection.retainAll((Collection<? extends String>) set3);}

        return (Set<T>) intersection;} //	Returns all items in both the first and second set

    public Set<T> complementOf(String first, String second){
        Set<String> complement = new HashSet<>();
        if (first.equals(circle1)) {complement.addAll((Collection<? extends String>) set1);}
        if (first.equals(circle2)) {complement.addAll((Collection<? extends String>) set2);}
        if (first.equals(circle3)) {complement.addAll((Collection<? extends String>) set3);}

        if (second.equals(circle1)) {complement.removeAll((Collection<? extends String>) set1);}
        if (second.equals(circle2)) {complement.removeAll((Collection<? extends String>) set2);}
        if (second.equals(circle3)) {complement.removeAll((Collection<? extends String>) set3);}

        return (Set<T>) complement;} //Returns all items in the first set that are NOT also in the second set

    public Set<T> diagramCenter(){
        Set<String> allSets = new HashSet<>();
        allSets.addAll((Collection<? extends String>) set1);
        allSets.retainAll((Collection<? extends String>) set2);
        allSets.retainAll((Collection<? extends String>) set3);
        return (Set<T>) allSets;}




}