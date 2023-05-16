package file.dto;

public class Filetest {

	private int fileno;
	private String title;
	private String origin_name;
	private String stored_name;

	public Filetest() {}

	public Filetest(int fileno, String title, String origin_name, String stored_name) {
		super();
		this.fileno = fileno;
		this.title = title;
		this.origin_name = origin_name;
		this.stored_name = stored_name;
	}

	@Override
	public String toString() {
		return "Filetest [fileno=" + fileno + ", title=" + title + ", origin_name=" + origin_name + ", stored_name="
				+ stored_name + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getStored_name() {
		return stored_name;
	}

	public void setStored_name(String stored_name) {
		this.stored_name = stored_name;
	}
	
}
