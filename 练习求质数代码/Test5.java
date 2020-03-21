package day14;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {
	public static void main(String[] args) throws Exception {
		//5���̵߳��̳߳�
		ExecutorService pool = 
		 Executors.newFixedThreadPool(5);
		//��������ȡ��ƾ֤������
		Future<Integer>[] a = new Future[5];
		//����5�����񶪽��̳߳�,�����5��ȡ��ƾ֤��������
		for (int i = 0; i < 5; i++) {
			a[i] = pool.submit(new C1(2000000*i, 2000000*(i+1)));  
		}
		
		int sum = 0;
		for (Future<Integer> f : a) {
			sum += f.get();//���5�������ִ�н��,ȡ��
		}
		System.out.println("����: "+sum);
		pool.shutdown(); //�����̳߳�
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
