import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * Created by adam on 4/27/17.
 */
public class Problem54 implements Euler {
    @Override
    public String answer() throws Exception {
        String[] hands = readFile();

        for (String hand : hands) {

            String player1 = hand.substring(0, hand.length() / 2);
            String player2 = hand.substring((hand.length() / 2) + 1, hand.length());

            Hand player1Hand = new Hand(player1);
        }

        return null;
    }

    private enum PokerHand {
        HighCard(0), OnePair(1), TwoPair(2), ThreeOfAKind(3), Straight(4), Flush(5), FullHouse(6),
        FourOfAKind(7), StraightFlush(8), RoyalFlush(9);
        private int rank;

        private PokerHand(int rank) {
            this.rank = rank;
        }
    }

    private class Hand {
        Card[] hand;

        public Hand(String handString) {
            this.hand = new Card[5];
            int counter = 0;
            for(String cardString: handString.split(" ")) {
                Card c = new Card(cardString);
                hand[counter] = c;
                counter++;
            }
            Arrays.sort(hand);
        }

        private boolean isFlush() {
            char first = hand[0].getSuit();
            for(Card c: hand) {
                if(c.getSuit() != first) {
                    return false;
                }
            }
            return true;
        }

    }

    private class Card implements Comparable{
        final char suit;
        final int rank;

        Map<Character, Integer> letterToRankMap;

        public Card(String cardString) {
            this.suit = cardString.charAt(1);
            char letter_representation = cardString.charAt(0);
            switch(letter_representation) {
                case 'A':
                    this.rank = 14;
                    break;
                case 'K':
                    this.rank = 13;
                    break;
                case 'Q':
                    this.rank = 12;
                    break;
                case 'J':
                    this.rank = 11;
                    break;
                case 'T':
                    this.rank = 10;
                    break;
                default:
                    this.rank = letter_representation-'0';
            }
        }
        public char getSuit() {
            return this.suit;
        }
        public int getRank() {
            return this.rank;
        }

        @Override
        public int compareTo(Object c) {
            return Integer.valueOf(this.getRank()).compareTo(((Card)c).getRank());
        }
    }

    private String[] readFile() throws Exception {
        String[] hands = new String[1000];
        String filename = "text/Problem54.txt";
        BufferedReader buf = new BufferedReader(new FileReader(filename));
        String currentLine;
        int counter = 0;
        while((currentLine = buf.readLine()) != null) {
            hands[counter] = currentLine;
            counter++;
        }
        return hands;
    }

}
