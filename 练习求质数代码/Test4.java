package day13;

public class Test4 {
	public static void main(String[] args) throws Exception {
		//求1000万内质数的数量
		System.out.println("--单线程--------------------");
		f1();
		System.out.println("--5个线程--------------------");
		f2();
	}
	
	private static void f1() throws Exception {
		long t = System.currentTimeMillis();
		
		T1 t1 = new T1(0, 10000000);
		t1.start();
		
		//main线程暂停,等待t1线程的执行结果
		t1.join();
		
		//等t1结束后再访问它的计算结果
		int c = t1.count;
		
		t = System.currentTimeMillis()-t;
		System.out.println("质数: "+c);
		System.out.println("时间: "+t);
	}

	private static void f2() throws Exception {
		long t = System.currentTimeMillis();
		
		T1[] a = new T1[5];//創建數組，把五個綫程放到一個數組裏
		//遍歷數組 
		for (int i = 0; i < a.length; i++) {
			a[i] = new T1(2000000*i, 2000000*(i+1));
			a[i].start();
		}
		
		//累加结果
		int sum = 0;
		for (T1 t1 : a) {
			t1.join();//取这个线程的结果前,要等待它结束
			sum += t1.count;
		}
		
		t = System.currentTimeMillis()-t;
		System.out.println("质数: "+sum);
		System.out.println("时间: "+t);
	}
	//第一步from，to用來確定範圍，構造方法來接收參數，再加入run方法。傳入的質數從3開始，
	static class T1 extends Thread {
		int from;
		int to;
		int count;//統計from到to之間的質數並保存求出的质数数量
		//alt+shift+s, generate constructor using fields 
		public T1(int from, int to) {
			//对2不判断是否是质数,认为是已知的质数
			if (from <= 2) {
				from = 3;
				count = 1;//假如從3開始，那麽3之前已經有一個質數（2），故count = 1
			}
			this.from = from;
			this.to = to;
		}
		@Override
		public void run() {
			// [from, to)
			for(int i=from; i<to; i++) {
				if (isPrime(i)) {//判断i的值是否是质数
					count++;     //是质数,计数递增
				}
			}
		}
		private boolean isPrime(int i) {
			//在 2 到 i开方+1 范围,找能把i整除的值
			double m = Math.sqrt(i) + 1;
			for (int j = 2; j < m; j++) {
				if (i%j == 0) {    //判斷i能被j整除
					return false;  //那么i不是质数
				}
			}			
			//把前面的值都判断完,没有能把i整除的值,i是质数
			return true;
		}
	}
}
