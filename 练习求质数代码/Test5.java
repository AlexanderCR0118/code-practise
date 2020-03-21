package day14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {
	public static void main(String[] args) throws Exception {
		//5个线程的线程池
		ExecutorService pool = 
		 Executors.newFixedThreadPool(5);
		//用来保存取餐凭证的数组
		Future<Integer>[] a = new Future[5];
		//创建5个任务丢进线程池,并获得5个取餐凭证放入数组
		for (int i = 0; i < 5; i++) {
			a[i] = pool.submit(new C1(2000000*i, 2000000*(i+1)));  
		}
		
		int sum = 0;
		for (Future<Integer> f : a) {
			sum += f.get();//获得5个任务的执行结果,取餐
		}
		System.out.println("质数: "+sum);
		pool.shutdown(); //销毁线程池
	}
	
	static class C1 implements Callable<Integer> {
		int from;
		int to;
		int count;
		public C1(int from, int to) {
			if (from<=2) {
				from = 3;
				count = 1;
			}
			this.from = from;
			this.to = to;
		}
		@Override
		public Integer call() throws Exception {
			for (int i = from; i < to; i++) {
				if (isPrime(i)) {
					count++;
				}
			}
			return count;
		}
		private boolean isPrime(int i) {
			double m = Math.sqrt(i)+1;
			for (int j = 2; j < m; j++) {
				if (i%j == 0) {
					return false;
				}
			}
			return true;
		}
		
	}
}
