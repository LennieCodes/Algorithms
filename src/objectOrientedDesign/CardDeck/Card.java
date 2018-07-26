package objectOrientedDesign.CardDeck;

public class Card {
	private String _type;
	private String _value;
	
	public Card(String type, String value) {
		this._type = type;
		this._value = value;
	} 
	
	public Card getCard() {
		return new Card(this._type, this._value);
	}
	
	@Override 
	public String toString() {
		return _type + _value;
	}
}
