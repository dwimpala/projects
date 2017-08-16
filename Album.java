
public class Album {
	String title;
	String artist;
	String genre;
	int releaseDate;
	String totalTime;
	public Album(String title, String artist, String genre, String releaseDate,
			String totalTime) {
		super();
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = Integer.parseInt(releaseDate);
		this.totalTime = totalTime;
	}
	@Override
	public String toString() {
		String delimeter = ", ";
		StringBuilder sb = new StringBuilder();
		sb.append(title);
		sb.append(delimeter);
		sb.append(artist);
		sb.append(delimeter);
		sb.append(genre);
		sb.append(delimeter);
		sb.append(releaseDate);
		sb.append(delimeter);
		sb.append(totalTime);
		return sb.toString();
	}
}
