package br.com.pedrohos.ex13;

import java.util.ArrayList;
import java.util.List;

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
		
		final List<String> teste = new ArrayList<>();
		
		Observable.range(0, 10).flatMap(new Func1<Integer, Observable<String>>() {

			@Override
			public Observable<String> call( final Integer arg0 ) {
				return Observable.just(arg0)
								.subscribeOn(Schedulers.computation())
								.map(n -> n + " " + Thread.currentThread().getName());
			}
		
		})
		  .doOnNext(teste :: add)
		  .subscribe();
		
		Thread.sleep(1000);
		
		teste.forEach(System.out :: println);
		
		
	}
	
}
