package br.com.pedrohos.ex11;

import rx.functions.Action1;

/**
 * @author pedro
 *
 */
public class Teste implements Action1<Integer> {

	@Override
	public void call( final Integer number ) {
		System.out.println(">>>>>>>> " + number + ": " + Thread.currentThread().getName());
		
	}
	
}
