package br.com.pedrohos.ex10;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) {
		Observable.interval(2, TimeUnit.SECONDS)
				  .subscribe(System.out::println);
	}
	
}
