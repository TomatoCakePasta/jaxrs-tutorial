package sampleapi;

import java.io.IOException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class MyReaderInterceptor
        implements ReaderInterceptor {

	@Override
    public Object aroundReadFrom(
    		ReaderInterceptorContext context
    		) 
    throws IOException, WebApplicationException {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("\n=== ReaderInterceptor BEFORE ===");
		
		System.out.println("MediaType = " + context.getMediaType());
		// 今回のリクエストで対応している型 (どのJava型にマップするか)
		System.out.println("Type = " + context.getType());
		
		// MessageBodyReaderを選択/実行
		// context.getType()の型を処理できるMBRを探して呼ぶ
		Object result = context.proceed();
		
		System.out.println("\n=== ReaderInterceptor AFTER ===");
		System.out.println("Result = " + result);
		 
		return result;
    }
	
}