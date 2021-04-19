package apr2021;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class FizzBuzz {
	private int n;
	private int counter = 1;
	Lock mutex = new ReentrantLock(true);
	Condition condition = mutex.newCondition();
	Logger logger = Logger.getLogger(FizzBuzz.class.getName());
	boolean completed = false;

	public FizzBuzz(int n) {
		this.n = n;
		logger.setLevel(Level.INFO);
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (counter <= n) {
			if (mutex.tryLock()) {
				logger.log(Level.INFO, String.format("Entering %s", Thread.currentThread().getName()));
				if (counter % 3 == 0 && counter % 5 != 0) {
					printFizz.run();
					counter++;
					logger.log(Level.INFO, String.format("Unlocking from %s", Thread.currentThread().getName()));
					condition.signalAll();
					mutex.unlock();
				} else {
					logger.log(Level.INFO, String.format("Going for wait %s", Thread.currentThread().getName()));
					condition.await();
				}
			}

		}

		logger.log(Level.INFO, String.format("Exiting %s", Thread.currentThread().getName()));
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (counter <= n) {
			if (mutex.tryLock()) {
				logger.log(Level.INFO, String.format("Entering %s", Thread.currentThread().getName()));
				if (counter % 3 != 0 && counter % 5 == 0) {
					printBuzz.run();
					counter++;
					logger.log(Level.INFO, String.format("Unlocking from %s", Thread.currentThread().getName()));
					condition.signalAll();
					mutex.unlock();
				} else {
					logger.log(Level.INFO, String.format("Going for wait %s", Thread.currentThread().getName()));
					condition.await();
				}
			}
		}
		logger.log(Level.INFO, String.format("Exiting %s", Thread.currentThread().getName()));
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (counter <= n) {
			if (mutex.tryLock()) {
				logger.log(Level.INFO, String.format("Entering %s", Thread.currentThread().getName()));
				if (counter % 3 == 0 && counter % 5 == 0) {
					printFizzBuzz.run();
					counter++;
					logger.log(Level.INFO, String.format("Unlocking from %s", Thread.currentThread().getName()));
					condition.signalAll();
					mutex.unlock();
				} else {
					logger.log(Level.INFO, String.format("Going for wait %s", Thread.currentThread().getName()));
					condition.await();
				}
			}
		}
		logger.log(Level.INFO, String.format("Exiting %s", Thread.currentThread().getName()));
	}

	public void number(IntConsumer printNumber) throws InterruptedException {
		while (counter <= n) {
			if (mutex.tryLock()) {
				logger.log(Level.INFO, String.format("Entering %s", Thread.currentThread().getName()));
				if (counter % 3 != 0 && counter % 5 != 0) {
					printNumber.accept(counter);
					counter++;
					logger.log(Level.INFO, String.format("Unlocking from %s", Thread.currentThread().getName()));
					condition.signalAll();
					mutex.unlock();
				} else {
					logger.log(Level.INFO, String.format("Going for wait %s", Thread.currentThread().getName()));
					condition.await();
				}
			}
		}
		logger.log(Level.INFO, String.format("Exiting %s", Thread.currentThread().getName()));
	}

}

public class FizzBuzzMain {
	public static void main(String[] args) {

		FizzBuzz f = new FizzBuzz(2);

		Thread th1 = new Thread(() -> {
			try {
				f.fizz(() -> System.out.println("Fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Fizz()");

		Thread th2 = new Thread(() -> {
			try {
				f.buzz(() -> System.out.println("Buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Buzz()");

		Thread th3 = new Thread(() -> {
			try {
				f.fizzbuzz(() -> System.out.println("Fizzbuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "FizzBuzz()");

		Thread th4 = new Thread(() -> {
			try {
				f.number((n) -> System.out.println(n));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "number()");

		th1.start();
		th2.start();
		th3.start();
		th4.start();

	}
}