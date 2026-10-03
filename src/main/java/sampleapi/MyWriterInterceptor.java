package sampleapi;

import java.io.IOException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;

@Provider
public class MyWriterInterceptor 
	implements WriterInterceptor {

	@Override
	public void aroundWriteTo(
			WriterInterceptorContext context
		) 
		throws IOException, WebApplicationException {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("\n=== WriterInterceptor BEFORE ===");
		
		System.out.println("MediaType = " + context.getMediaType());
		
		// 今回のレスポンスで対応する型 (どのJava型をHTTPに変換するか)
		System.out.println("Type = " + context.getType());
		System.out.println("Entity = " + context.getEntity());
		
		// context.getEntity()を処理できるMBRを探して呼ぶ
		context.proceed();
		
		System.out.println("\n=== WriterInterceptor AFTER ===");
	}
	
}
