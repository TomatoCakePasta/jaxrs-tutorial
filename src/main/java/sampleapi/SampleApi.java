package sampleapi;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class SampleApi {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainText() {
		String sampleHtml = "";
		return "Got it !!!";
	}
	
	@Path("json")
	@GET
	public String getJson() {
		String sampleJson = "{}";
		return sampleJson;
	}
	
	@Path("html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml() {
	    String sampleHtml = """
	            <!DOCTYPE html>
	            <html lang="ja">
	            <head>
	                <meta charset="UTF-8">
	                <title>JAX-RS Sample</title>
	            </head>
	            <body>
	                <h1>Got it !!!</h1>
	                <p>JerseyからHTMLを返しています。</p>
	            </body>
	            </html>
	            """;

	    return sampleHtml;
	}
	
	@Path("search")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String search(SearchRequest req) {
		
		System.out.println("DTO = " + req);
		System.out.println("keyword = " + req.getKeyword());
		
		String rawHtml = """
	            <!DOCTYPE html>
	            <html lang="ja">
	            <body>
	                <h1>検索結果</h1>
	                <p>検索キーワード：%s</p>
	            </body>
	            </html>
	            """.formatted(req.getKeyword());
		
		return rawHtml;
	}
	
	@Path("search-return-response")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResponse searchReturnResponse(SearchRequest req) {
		System.out.println("DTO = " + req);
		System.out.println("keyword = " + req.getKeyword());
		
		return new SearchResponse(
				req.getKeyword(),
				"検索しました"
			);
	}
}