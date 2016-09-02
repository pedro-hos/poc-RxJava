package br.com.pedrohos.ex06;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		Observable.just("    PeDrO HoS ")
				  .map(String :: toUpperCase)
				  .map(String :: trim)
				  .subscribe(System.out :: println);
		
	}
	
}
