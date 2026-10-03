package sampleapi;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SearchExceptionMapper 
	implements ExceptionMapper<SearchException> {

	@Override
	public Response toResponse(SearchException exception) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("\n=== ExceptionMapper ===");
		System.out.println("Status = " + Response.Status.BAD_REQUEST);
		System.out.println("message = " + exception.getMessage());
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(exception.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
