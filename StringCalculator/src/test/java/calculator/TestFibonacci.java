package samples;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestFibonacci {

	
	@Test
	public void getFibonacciFirst(){
		
		Stream.iterate(new int[]{0, 1},t->new int[]{t[1],t[0]+t[1]})
		.limit(10)
		.map(t->t[0])
		.forEach(System.out::println);
	}
	
	@Test
	public void getFibonacciSecond() {
		IntSupplier fib = new IntSupplier() {

			private int previus=0;
			private int current= 1;
			@Override
			public int getAsInt() {
				int oldPrevius=this.previus;
				int nextValue = this.previus+this.current;
				this.previus=this.current;
				this.current= nextValue;
				return oldPrevius;
			}
		};
		
		IntStream.generate(fib).limit(10).forEach(System.out::println);		
		
		
	}
	
}
