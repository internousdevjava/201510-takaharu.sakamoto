/**
 * 
 */

/**
 * @author internous
 *
 */
import java.io.*;
public class Kisokadai1 {
	public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0; //������
        int y = 0; //������
        
        //x�̒l��0~100�ɂȂ�܂ŕ����Ȃ���
        while(x < 1 || 100 < x){ //0�ȉ�101�ȏ�̎����[�v
        	try{
        		System.out.println("x��1~100�̒l����͂��Ă��������B");
        		x = 0; //���s���̏������p
        		System.out.print("x=");
        		x = Integer.parseInt(br.readLine());
        	}catch(Exception e){
        		System.out.println("�����ɂ��Ă��������B");
        	}
        }
        //y�̒l��0~100�ɂȂ�܂ŕ����Ȃ���
        while(y < 1 || 100 < y){ //0�ȉ�101�ȏ�̎����[�v
        	try{
        		System.out.println("y��1~100�̒l����͂��Ă��������B");
        		y = 0; //���s���̏������p
        		System.out.print("x="+x+" y=");
        		y = Integer.parseInt(br.readLine());
        	}catch(Exception e){
        		System.out.println("�����ɂ��Ă��������B");
        	}
        }

        //���\
        for(int j=y;j>=1;j--){
        	space(j);//y��(����)�̕\��
        	for(int k=1;k<=x;k++){
        		space(j*k);//1�s�\��
        	}
        	System.out.println("");//1�s�I������玟�̍s�ɍs���ׂ̉��s
        }
        System.out.print("      ");//�����ڂ𐮂��邽�߂̋�
        for(int i=1;i<=x;i++){
        	space(i);//x��(����)�̕\��
        }
	}

	//�����ڂ𐮂��邽�߂̋󔒍쐬�ƕ\��
	static void space(int val){
		int leng = String.valueOf(val).length(); //���͂��ꂽ�l�̌�������
		//�����ɂ��킹�ċ󔒂��쐬
		switch(leng){
		case 1:System.out.print("    " + val + " "); break; //1���̂Ƃ�
		case 2:System.out.print("   " + val + " "); break;  //2���̂Ƃ�
		case 3:System.out.print("  " + val + " "); break;   //3���̂Ƃ�
		case 4:System.out.print(" " + val + " ");break;     //4���̂Ƃ�
		case 5:System.out.print(val + " ");break;}          //5���̂Ƃ�
	}
}