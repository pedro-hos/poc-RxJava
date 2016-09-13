package br.com.pedrohos.ex14;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author pedro https://github.com/yfain/rxjava/blob/master/src/schedulers/SubscribeOnObserveOn.java
 *
 */
public class SubscribeOnObserveOn {
	
	public static void main( final String[] args ) {
		
		final List<Beer> beers = loadCellar(); // populate the beer collection
		
		final Observable<Beer> observableBeers = null;
		
		observableBeers.from(beers)
					  .subscribeOn(Schedulers.computation()) // push data on computation thread
					  .doOnNext(beer -> log(beer)) // Side effect: Log on computation thread
					  .observeOn(Schedulers.io()) // Process on another io thread
					  .subscribe(beer -> matureBeer(beer));
		
		// Sleep just to keep the program running
		try {
			Thread.sleep(5000);
			
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void matureBeer(final Beer beer){
        try {
            System.out.println("** Maturing " + beer.name +
                    " on " + Thread.currentThread().getName());

            Thread.sleep((int)(Math.random()*500));

        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

    }

	
	 private static void log(final Beer beer){
	        System.out.println("===> Logging " + beer.name +
	                           " on "  + Thread.currentThread().getName() );
	}
	
	// Populate beer collection
	static List<Beer> loadCellar() {
		final List<Beer> beerStock = new ArrayList<>();
		
		beerStock.add(new Beer("Stella", "Belgium", 7.75f));
		beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
		beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
		beerStock.add(new Beer("Bud Light", "USA", 5.00f));
		beerStock.add(new Beer("Yuengling", "USA", 5.50f));
		beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
		beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
		beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));
		
		return beerStock;
	}
	
}
