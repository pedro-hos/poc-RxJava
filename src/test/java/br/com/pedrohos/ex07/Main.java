package br.com.pedrohos.ex07;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		Observable.just(1, 2, 3, 4)
		  		  .repeat(2)
		  		  .subscribe(System.out :: println);
	}
}
