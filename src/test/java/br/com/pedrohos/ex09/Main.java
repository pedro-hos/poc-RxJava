package br.com.pedrohos.ex09;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		Observable.range(100, 5)
				  .subscribe(System.out :: println);
	}
	
}
