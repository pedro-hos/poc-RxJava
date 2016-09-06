package br.com.pedrohos.ex08;

import rx.Observable;

/**
 * @author pedro
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main( final String[] args ) {
		Observable.defer(Main::getObservableString)
		  		  .subscribe(System.out :: println);
		
	}
	
	public static Observable<String> getObservableString() {
		
	      return Observable.create(subscriber -> {
	    	  
	          if (subscriber.isUnsubscribed()) {
	        	  return;
	          }
	          
	          System.out.println("Operação realizada");
	          subscriber.onNext("Mensagem");
	          subscriber.onCompleted();
	      });
	  }
	
}
