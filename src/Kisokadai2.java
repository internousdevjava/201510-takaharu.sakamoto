import java.io.*;
public class Kisokadai2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x=0;
		int val = (int)(Math.random()*100) + 1; //�����_���Œl���o��(0�`99�̒l�Ȃ̂�+1)
		//High Low�̏���
		while(true){
			try{
				System.out.print("1~100�̓���: ");
				x = Integer.parseInt(br.readLine());
			}catch(Exception e){
				System.out.println("1~100�̓��͂ł��B");
			}
			
			if(x<=0 | 100<x){//���͂��ꂽ�l��1�`100�łȂ��ꍇ
				System.out.println("1~100�ɂ��Ă��������B");
			}else if(x==val){//��������
				System.out.println("�����ł��B");
				break;
			}else if(x < val){//���͒l��������菬�����ꍇ
				System.out.println("���͒l��������菬�����ł�");
			}else{//���͒l���������傫���ꍇ
				System.out.println("���͒l���������傫���ł�");
			}
		}
	}
}