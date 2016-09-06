package br.com.pedrohos.ex04;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		
		Observable.just("Hello World")
				  .subscribe(System.out :: println);
		
	}
	
}
