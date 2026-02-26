package cpm.cg;

public class Game {
	private String gameName;
	private String authorName;
	private float price;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	public Game(String gameName, String authorName, float price) {
		super();
		this.gameName = gameName;
		this.authorName = authorName;
		this.price = price;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String toString() {
		return gameName+"\t"+authorName+"\t"+price;
	}
	
}
