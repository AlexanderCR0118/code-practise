public class Demo{
	
	/**
		��дһ��Java��������Ļ�����1��+2��+3��+..+10���ĺ͡�
		
		1.��һ�����Ľ׳�
		2.�Ѵ�1��10ÿһ�����Ľ׳����
	
	*/
	public static void main(String[] args){
		//���ý׳˵ķ���
		int r = fn(5);
		System.out.println(r);
	}
	
	/**
	  ����һ��������������Ľ׳�
	  5�� = 5*4*3*2*1
	  4�� = 4*3*2*1
		3�� = 3*2*1
		2�� = 2*1
		1�� = 1
	*/
	public static int fn(int num){
		//����һ������ı���
		int result = 1;
		//���������������
		for(int i = num; i > 0; i--){
			//�۳�
			result *= i;
		}
		return result;
		
	}
}