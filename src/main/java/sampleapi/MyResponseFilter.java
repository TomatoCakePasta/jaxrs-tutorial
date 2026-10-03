package sampleapi;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyResponseFilter 
	implements ContainerResponseFilter {

	@Override
	public void filter(
			ContainerRequestContext requestContext, 
			ContainerResponseContext responseContext
		)
			throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("=== Response Filter === ");
		
		System.out.println("Status = "
				+ responseContext.getStatus());
		
		System.out.println("Entity = "
				+ responseContext.getEntity());
	}
}
