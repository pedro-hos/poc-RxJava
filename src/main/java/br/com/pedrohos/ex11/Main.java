package br.com.pedrohos.ex11;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action0;
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
		
		System.out.println(">>>> " + Thread.currentThread().getName());
		
		Observable.from(numbs)
							  .subscribeOn(Schedulers.computation())
							  .doOnNext(number -> new Teste().call(number))
							  .doOnCompleted(new Action0() {
								
								@Override
								public void call() {
									System.out.println("terminou");
									
								}
							})
		        			  .subscribe();
		
		System.out.println(">>>> " + Thread.currentThread().getName());
		
		Thread.sleep(3000);
		
	}
	
}
