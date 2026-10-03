package sampleapi;

public class SearchResponse {
	private String keyword;
	private String message;
	
	public SearchResponse() {
		
	}
	
	public SearchResponse(String keyword, String message) {
		this.keyword = keyword;
		this.message = message;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
