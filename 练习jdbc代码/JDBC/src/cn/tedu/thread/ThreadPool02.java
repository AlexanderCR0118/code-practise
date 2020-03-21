package cn.tedu.thread;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool02 {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		Random random = new Random();
		while (true) {
			newFixedThreadPool.execute(new Runnable() {			
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+
							":"+"is running");
					
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
		}
	}
}
