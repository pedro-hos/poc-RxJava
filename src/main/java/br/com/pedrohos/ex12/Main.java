package br.com.pedrohos.ex12;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author pedro
 *
 */
public class Main {
	
	public static void main( final String[] args ) throws InterruptedException {
		
		System.out.println(">>>> " + Thread.currentThread().getName());
		
		Observable.range(0, 10).flatMap(new Func1<Integer, Observable<Integer>>() {

			@Override
			public Observable<Integer> call( final Integer arg0 ) {
				return Observable.just(arg0)
								 .subscribeOn(Schedulers.computation());
			}
		
		})
		  .subscribe(n -> System.out.println(n + " " + Thread.currentThread().getName()));
		
		Thread.sleep(3000);
	}
	
}
