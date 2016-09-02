package br.com.pedrohos.ex05;

import java.time.LocalDate;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		
		Observable.just("Hello World ")
				  .map(value -> value + LocalDate.now())
				  .subscribe( System.out :: println );
		
	}
	
}
