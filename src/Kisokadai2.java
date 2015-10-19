import java.io.*;
public class Kisokadai2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x=0;
		int val = (int)(Math.random()*100) + 1; //ランダムで値を出力(0～99の値なので+1)
		//High Lowの処理
		while(true){
			try{
				System.out.print("1~100の入力: ");
				x = Integer.parseInt(br.readLine());
			}catch(Exception e){
				System.out.println("1~100の入力です。");
			}
			
			if(x<=0 | 100<x){//入力された値が1～100でない場合
				System.out.println("1~100にしてください。");
			}else if(x==val){//正解処理
				System.out.println("正解です。");
				break;
			}else if(x < val){//入力値が答えより小さい場合
				System.out.println("入力値が答えより小さいです");
			}else{//入力値が答えより大きい場合
				System.out.println("入力値が答えより大きいです");
			}
		}
	}
}