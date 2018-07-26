package objectOrientedDesign.CardDeck;
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	// for sake of brevity, setting this to public. Ideally there would be a wrapper around all methods.
	public ArrayList<Card> deck;
	
	public CardDeck(boolean... shouldShuffle) {
		_initializeDeck();
		if (shouldShuffle[0] == true) {
			shuffle();
		}
	}
		
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	private void _initializeDeck() {
		// method should populate deck with cards
	}
	
}
