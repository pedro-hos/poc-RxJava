package br.com.pedrohos.ex02;

import rx.Observable;
import rx.Observer;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		
		final Observable<Integer> observable = Observable.create( subscriber -> {
			
			for (int i = 0; i< 3; i++) {
				subscriber.onNext(i);
			}
			
			subscriber.onCompleted();
			
		});
		
		observable.subscribe(new Observer<Integer>() {

			@Override
			public void onCompleted() {
				System.out.println("Observable completado");
				
			}

			@Override
			public void onError( final Throwable value ) {
				System.err.println("Ocorreu algum erro no Observable");
			}

			@Override
			public void onNext( final Integer value ) {
				System.out.println("O observable retornou " + value);
			}
		
		});
		
	}
	
}
