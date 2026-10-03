package sampleapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyJsonMessageBodyProvider
	implements MessageBodyReader<SearchRequest>, MessageBodyWriter<SearchResponse> {
	
	@Override
	public boolean isReadable(
			Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType) {
		boolean isReadable = (type == SearchRequest.class);
		System.out.println("\n=== MessageBodyReader ===");
		System.out.println("MyJsonMessageBodyProvider.isReadable returns: " + isReadable);
		return isReadable;
	}
	
	@Override
	public SearchRequest readFrom(
			Class<SearchRequest> type,
			Type genericeType,
			Annotation[] annotations,
			MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders,
			InputStream entityStream) 
			throws IOException, WebApplicationException {
		
		System.out.println(entityStream);
		String json = new String(
				entityStream.readAllBytes(),
				StandardCharsets.UTF_8
				);
		
		System.out.println("Reader received JSON = " + json);
		
		SearchRequest req = new SearchRequest();
		
		// Mapping
		String keyword = json
				.replace("{", "")
				.replace("}", "")
				.replace("\"", "")
				.replace("keyword:", "")
				.trim();
		
		req.setKeyword(keyword);
		
		return req;
	}

	@Override
	public boolean isWriteable(
			Class<?> type, 
			Type genericType, 
			Annotation[] annotations, 
			MediaType mediaType) {
		// TODO 自動生成されたメソッド・スタブ
		boolean isWritable = (type == SearchResponse.class);
		System.out.println("\n=== MessageBodyWriter ===");
		System.out.println("MyJsonMessageBodyProvider.isWritable returns: " + isWritable);
		return isWritable;
	}

	@Override
	public void writeTo(
			SearchResponse t, 
			Class<?> type, 
			Type genericType, 
			Annotation[] annotations,
			MediaType mediaType, 
			MultivaluedMap<String, Object> httpHeaders, 
			OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("writeTo() SearchResponse = " + t.getKeyword());
		
		String json = """
				{
					"keyword": %s",
					"message": "%s"
				}
				""".formatted(
						t.getKeyword(),
						t.getMessage()
				);
		
		entityStream.write(
				json.getBytes(StandardCharsets.UTF_8)
		);
		return;
	}
	
}
