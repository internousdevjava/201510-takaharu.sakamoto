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
        int x = 0; //初期化
        int y = 0; //初期化
        
        //xの値が0~100になるまで聞きなおす
        while(x < 1 || 100 < x){ //0以下101以上の時ループ
        	try{
        		System.out.println("xに1~100の値を入力してください。");
        		x = 0; //失敗時の初期化用
        		System.out.print("x=");
        		x = Integer.parseInt(br.readLine());
        	}catch(Exception e){
        		System.out.println("数字にしてください。");
        	}
        }
        //yの値が0~100になるまで聞きなおす
        while(y < 1 || 100 < y){ //0以下101以上の時ループ
        	try{
        		System.out.println("yに1~100の値を入力してください。");
        		y = 0; //失敗時の初期化用
        		System.out.print("x="+x+" y=");
        		y = Integer.parseInt(br.readLine());
        	}catch(Exception e){
        		System.out.println("数字にしてください。");
        	}
        }

        //九九表
        for(int j=y;j>=1;j--){
        	space(j);//y軸(左側)の表示
        	for(int k=1;k<=x;k++){
        		space(j*k);//1行表示
        	}
        	System.out.println("");//1行終わったら次の行に行く為の改行
        }
        System.out.print("      ");//見た目を整えるための空白
        for(int i=1;i<=x;i++){
        	space(i);//x軸(下側)の表示
        }
	}

	//見た目を整えるための空白作成と表示
	static void space(int val){
		int leng = String.valueOf(val).length(); //入力された値の桁数を代入
		//桁数にあわせて空白を作成
		switch(leng){
		case 1:System.out.print("    " + val + " "); break; //1桁のとき
		case 2:System.out.print("   " + val + " "); break;  //2桁のとき
		case 3:System.out.print("  " + val + " "); break;   //3桁のとき
		case 4:System.out.print(" " + val + " ");break;     //4桁のとき
		case 5:System.out.print(val + " ");break;}          //5桁のとき
	}
}