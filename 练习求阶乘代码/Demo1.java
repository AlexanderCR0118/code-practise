public class Demo1{
	
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
	  5！ = 5*4*3*2*1
	  4！ = 4*3*2*1
		3！ = 3*2*1
		2！ = 2*1
		1！ = 1
	*/
	public static int fn(int num){
		//定义一个结果的变量
		int result = 1;
		//变量参数这个数字
		for(int i = num; i > 0; i--){
			//累乘
			result *= i;
		}
		return result;
		
	}
}