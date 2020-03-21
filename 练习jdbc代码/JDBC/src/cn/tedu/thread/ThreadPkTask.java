package cn.tedu.thread;

import java.util.ArrayList;
import java.util.Random;

public class ThreadPkTask {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		final ArrayList<Integer> l = new ArrayList<>();
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		final Random random = new Random();
			
		for (int i = 0; i < 1000; i++) {
							
			Thread thread = new Thread() {
				public void run() {
					l.add(random.nextInt());
				}
			};
			thread.start();
			thread.join();//等待执行完再执行main方法，与main方法一起结束。注释掉的话，输出的size小于1000。
		}
		System.out.println("用时"+(System.currentTimeMillis()-start));
		System.out.println("大小"+l.size());
	}
}
