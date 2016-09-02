package br.com.pedrohos.ex11;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) throws InterruptedException {
		
		final List<Integer> numbs = new ArrayList<Integer>();
		
		for (int i = 0; i < 300; i++) {
			numbs.add(i);
		}
		
		System.out.println("o");
		
		Observable.from(numbs)
							  .map(number -> number + 1)
							  .subscribeOn(Schedulers.newThread())
							  //.map(number -> number + 1)
		        			  .subscribe(name -> System.out.println(name + " " + Thread.currentThread().getName()));
		
		System.out.println("2o");
		
		Thread.sleep(3000);
		
	}
	
}
