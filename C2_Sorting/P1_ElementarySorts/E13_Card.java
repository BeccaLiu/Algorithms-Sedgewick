package P1_ElementarySorts;

import P3_BagQueueStack.Deque;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rliu on 10/11/16.
 * Using insertion sort
 */
public class E13_Card {


    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Suits s : Suits.values())
            for (Numerals n : Numerals.values())
                cards.add(new Card(s, n));

        Collections.shuffle(cards);

        //deckSort(cards.toArray(new Card[cards.size()]));
        dequeueSort(cards.toArray(new Card[cards.size()]));
    }

    public static void dequeueSort(Card[] toSort) {//it is acutally bubble sort
        Deque<Card> cards = new Deque<>();
        int j = 0;
        for (Card c : toSort) {
            //if(j<5)
            cards.pushRight(c);
            //j++;
        }
        int count = 0;
        while (count != cards.size() - 1) {
            count = 0;
            for (int i = 0; i < cards.size() - 1; i++) {
                Card a = cards.popLeft();
                Card b = cards.popLeft();
                if (a.compareTo(b) < 0) {
                    cards.pushLeft(b);
                    cards.pushRight(a);
                    count++;

                } else {
                    cards.pushLeft(a);
                    cards.pushRight(b);
                }
            }
            cards.pushRight(cards.popLeft());

        }
        for (Card c : cards)
            StdOut.print(c + " ");
        StdOut.println();
    }

    public static void deckSort(Card[] toSort) {
        for (int i = 1; i < toSort.length; i++) {
            for (int j = i; j > 0 && toSort[j].compareTo(toSort[j - 1]) < 0; j--) {
                Card temp = toSort[j];
                toSort[j] = toSort[j - 1];
                toSort[j - 1] = temp;
            }
        }

        for (Card c : toSort)
            StdOut.print(c + " ");
        StdOut.println();

    }

    private enum Numerals {
        ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13);

        int value;

        Numerals(int i) {
            this.value = i;
        }

    }

    private enum Suits {

        Spades(1),
        Hearts(2),
        Diamonds(3),
        Clubs(4);

        int value;

        Suits(int i) {
            this.value = i;
        }
    }

    private static class Card implements Comparable<Card> {
        Suits suit;
        Numerals rank;

        public Card(Suits suit, Numerals ranks) {
            this.suit = suit;
            this.rank = ranks;
        }

        @Override
        public int compareTo(Card o) {

            if (this.suit.equals(o.suit)) {
                return this.rank.compareTo(o.rank);
            } else {
                return this.suit.compareTo(o.suit);
            }
        }

        public String toString() {
            return this.suit + "" + this.rank;
        }
    }
}

