public class Demo{
	
	/**
		编写一个Java程序在屏幕上输出1！+2！+3！+..+10！的和。
		
		1.求一个数的阶乘
		2.把从1到10每一个数的阶乘求和
	
	*/
	public static void main(String[] args){
		//调用阶乘的方法
		int r = fn(5);
		System.out.println(r);
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