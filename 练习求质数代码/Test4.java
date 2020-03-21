package day13;

public class Test4 {
	public static void main(String[] args) throws Exception {
		//��1000��������������
		System.out.println("--���߳�--------------------");
		f1();
		System.out.println("--5���߳�--------------------");
		f2();
	}
	
	private static void f1() throws Exception {
		long t = System.currentTimeMillis();
		
		T1 t1 = new T1(0, 10000000);
		t1.start();
		
		//main�߳���ͣ,�ȴ�t1�̵߳�ִ�н��
		t1.join();
		
		//��t1�������ٷ������ļ�����
		int c = t1.count;
		
		t = System.currentTimeMillis()-t;
		System.out.println("����: "+c);
		System.out.println("ʱ��: "+t);
	}

	private static void f2() throws Exception {
		long t = System.currentTimeMillis();
		
		T1[] a = new T1[5];//�������M�����傀�Q�̷ŵ�һ�����M�Y
		//��v���M 
		for (int i = 0; i < a.length; i++) {
			a[i] = new T1(2000000*i, 2000000*(i+1));
			a[i].start();
		}
		
		//�ۼӽ��
		int sum = 0;
		for (T1 t1 : a) {
			t1.join();//ȡ����̵߳Ľ��ǰ,Ҫ�ȴ�������
			sum += t1.count;
		}
		
		t = System.currentTimeMillis()-t;
		System.out.println("����: "+sum);
		System.out.println("ʱ��: "+t);
	}
	//��һ��from��to�Á�_�����������췽������Յ������ټ���run������������|����3�_ʼ��
	static class T1 extends Thread {
		int from;
		int to;
		int count;//�yӋfrom��to֮�g���|���K�����������������
		//alt+shift+s, generate constructor using fields 
		public T1(int from, int to) {
			//��2���ж��Ƿ�������,��Ϊ����֪������
			if (from <= 2) {
				from = 3;
				count = 1;//�����3�_ʼ������3֮ǰ�ѽ���һ���|����2������count = 1
			}
			this.from = from;
			this.to = to;
		}
		@Override
		public void run() {
			// [from, to)
			for(int i=from; i<to; i++) {
				if (isPrime(i)) {//�ж�i��ֵ�Ƿ�������
					count++;     //������,��������
				}
			}
		}
		private boolean isPrime(int i) {
			//�� 2 �� i����+1 ��Χ,���ܰ�i������ֵ
			double m = Math.sqrt(i) + 1;
			for (int j = 2; j < m; j++) {
				if (i%j == 0) {    //�Д�i�ܱ�j����
					return false;  //��ôi��������
				}
			}			
			//��ǰ���ֵ���ж���,û���ܰ�i������ֵ,i������
			return true;
		}
	}
}
