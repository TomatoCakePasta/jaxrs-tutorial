package sampleapi;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class MyJsonMessageBodyReader 
	implements MessageBodyReader<SearchRequest> {
	
	@Override
	public boolean isReadable(
			Class<?> type,
			Type genericType,
			Annotation[] annotations,
			MediaType mediaType) {
		boolean isReadable = (type == SearchRequest.class);
		System.out.println("MyJsonMessageBodyReader.isReadable returns: " + isReadable);
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
	
}
