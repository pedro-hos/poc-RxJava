package br.com.pedrohos.ex03;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		
		final List<String> langs = Arrays.asList("Java", "Clojure", "Scala", "Groovy");
		final Observable<String> observable = Observable.from(langs);
		
		observable.subscribe( new Observer<String>() {

			@Override
			public void onCompleted() {
				System.out.println("Observable completado");
			}

			@Override
			public void onError( final Throwable error ) {
				System.err.println("Ocorreu algum erro no Observable");
			}

			@Override
			public void onNext( final String lang ) {
				System.out.println("O observable retornou " + lang);
			}
		
		});
		
		
	}
	
}
