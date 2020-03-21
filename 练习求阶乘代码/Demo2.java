public class Demo2{
	
	/**
		编写一个Java程序在屏幕上输出1！+2！+3！+..+10！的和。
		
		1.求一个数的阶乘
		2.把从1到10每一个数的阶乘求和
	
	*/
	public static void main(String[] args){
		
		//定义一个总和的变量
		int total = 0;
		for(int i = 1; i <= 10; i++){
			//累加  total = total + fn(i);
			total += fn(i);
		}
		System.out.println(total);
	}
	
	/**
	  给定一个数，求这个数的阶乘
	  5！ = 5*4！
	  4！ = 4*3！
		3！ = 3*2！
		2！ = 2*1！
		1！ = 1
		
		fn(num) = num * fn(num - 1)
		5! = 5*4*3*2*1
		
		递归：就是方法自身调用方法自身，一定要有退出的标识
	*/
	public static int fn(int num){
		//定义一个结果的变量
		int result = 1;
		if(num > 1){
			//方法自身调用自身
			result = num * fn(num - 1);
		}
		return result;
		
	}
}