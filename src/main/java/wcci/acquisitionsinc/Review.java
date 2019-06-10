package wcci.acquisitionsinc;

public class Review {

	private int id;
	private String title;

	public Review() {
		this.title = "";
	}

	public Review(int id) {
		this.id = id;
		this.title = "";
	}

	public Review(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return "";
	}

	public String getReviewCategory() {
		return "";
	}

	public String getContent() {
		return "";
	}

}
