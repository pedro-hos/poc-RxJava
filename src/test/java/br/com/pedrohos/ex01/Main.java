package br.com.pedrohos.ex01;

import rx.Observable;
import rx.Subscriber;

/**
 * @author pedro
 */
public class Main {
	
	public static void main( final String[] args ) {
		
		final Observable<String> meuObservable = Observable.create(
		
				new Observable.OnSubscribe<String>() {

					@Override
					public void call( final Subscriber<? super String> subscriber ) {
						subscriber.onNext("Hello World");
						subscriber.onCompleted();
					}
				
				}
		);
		
		final Subscriber<String> meuSubscriber = new Subscriber<String>() {

			@Override
			public void onCompleted() { }

			@Override
			public void onError( final Throwable value ) { }

			@Override
			public void onNext( final String value ) {
				System.out.println(value);
			}
		
		};
		
		meuObservable.subscribe(meuSubscriber);
	}
	
}
