package apr2021;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {
	int counter = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public PrintInOrder() {
	}

	public void first(Runnable printFirst) throws InterruptedException {
		lock.lock();
		if (counter == 0)
			printFirst.run();
		counter++;
		condition.signalAll();
		lock.unlock();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		lock.lock();
		while (counter < 1)
			condition.await();
		printSecond.run();
		counter++;
		condition.signalAll();
		lock.unlock();

	}

	public void third(Runnable printThird) throws InterruptedException {
		lock.lock();
		if (counter < 2)
			condition.await();
		printThird.run();
		lock.unlock();

	}

	public static void main(String[] args) throws InterruptedException {

//		int[] input = { 2, 1, 3 };
//		int[] input = { 1, 2, 3 };
//		int[] input = { 2, 1, 3 };
		int[] input = { 3, 2, 1 };

		PrintInOrder p = new PrintInOrder();

		Thread th1 = new Thread(() -> {
			try {
				p.first(() -> System.out.println("first"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread th2 = new Thread(() -> {
			try {
				p.second(() -> System.out.println("second"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread th3 = new Thread(() -> {
			try {
				p.third(() -> System.out.println("third"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
			case 1:
				th1.start();
				break;
			case 2:
				th2.start();
				break;
			case 3:
				th3.start();
				break;
			}
		}

	}

}
