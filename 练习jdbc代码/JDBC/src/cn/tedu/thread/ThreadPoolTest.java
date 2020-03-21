package cn.tedu.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		ArrayList<Object> l = new ArrayList<>();
		Random random = new Random();
		
		for (int i = 0; i < 1000; i++) {
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					l.add(random.nextInt());
				}
			});
		}
		executor.shutdown();
		//executor.awaitTermination(timeout: 1, unit);
		System.out.println("用时"+(System.currentTimeMillis()-start));
	}
}
