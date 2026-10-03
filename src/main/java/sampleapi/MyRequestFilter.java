package sampleapi;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyRequestFilter 
	implements ContainerRequestFilter {

	@Override
	public void filter(
			ContainerRequestContext requestContext
			) 
		throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("=== Request Filter === ");
		
		System.out.println("Method = "
				+ requestContext.getMethod());
		
		System.out.println("URI = "
				+ requestContext.getUriInfo().getRequestUri());
	}

}
