public class Demo2{
	
	/**
		��дһ��Java��������Ļ�����1��+2��+3��+..+10���ĺ͡�
		
		1.��һ�����Ľ׳�
		2.�Ѵ�1��10ÿһ�����Ľ׳����
	
	*/
	public static void main(String[] args){
		
		//����һ���ܺ͵ı���
		int total = 0;
		for(int i = 1; i <= 10; i++){
			//�ۼ�  total = total + fn(i);
			total += fn(i);
		}
		System.out.println(total);
	}
	
	/**
	  ����һ��������������Ľ׳�
	  5�� = 5*4��
	  4�� = 4*3��
		3�� = 3*2��
		2�� = 2*1��
		1�� = 1
		
		fn(num) = num * fn(num - 1)
		5! = 5*4*3*2*1
		
		�ݹ飺���Ƿ���������÷�������һ��Ҫ���˳��ı�ʶ
	*/
	public static int fn(int num){
		//����һ������ı���
		int result = 1;
		if(num > 1){
			//���������������
			result = num * fn(num - 1);
		}
		return result;
		
	}
}