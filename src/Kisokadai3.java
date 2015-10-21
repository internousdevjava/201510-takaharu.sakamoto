import java.io.*;
public class Kisokadai3 {
	public static void main(String[] args){
		int x = 0;
		while(x!=1){
		System.out.println("メニューを表示します"); 
		System.out.println("番号を入力してください"); 
		System.out.println("１　ファイルの作成"); 
		System.out.println("２　ファイルの書き込み"); 
		System.out.println("３　ファイルの読み込み"); 
		System.out.println("４　終了"); 
		System.out.print("="); 
		
		int a;
		InputStreamReader isr= new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr); 
		try{ 
			String buf = br.readLine(); 
			a = Integer.parseInt(buf); 
		}catch(Exception e){ 
			a = 0; 
		} 
		if(a==1){
			//ファイル作成プログラム↓
			String sakusei = "";
			try{
			System.out.println("新規作成したい場所を指定＋ファイル名＋拡張子");
			System.out.println("例 =C:/Users//internous//test.txt");
			System.out.print("=");
			sakusei=br.readLine();
			}
			catch(Exception e){
			}
			//入力したファイルがあるかどうか検索
			File file = new File(sakusei); 
			File dir = new File(file.getParent()); 
			
			//入力したファイルがなければ作成
			try{
			if(dir.exists()){ //フォルダの存在のチェック
				System.out.println("ディレクトリは存在します。");
				System.out.println("メニューに戻ります");
			}else{
				System.out.println("新しくディレクトリを作成しました。");
				dir.mkdir(); //ディレクトリ作成
			}
			if(file.exists()){ //ファイルの存在のチェック
				System.out.println("ファイルは存在します。");
				System.out.println("メニューに戻ります");
			}else{
				System.out.println("新しくファイルを作成しました。");
				
					file.createNewFile(); //ファイル作成
			}
				}catch(Exception e){
				}
		}
		if(a==2){
		//ファイル書き込みのプログラム
			String kakikomi = "";
			try{
				//書き込みファイルの指定
				System.out.println("書き込みたい場所を指定＋ファイル名＋拡張子");
				System.out.println("例 =C:/Users//internous//test.txt");
				System.out.print("=");
				kakikomi=br.readLine();
				}
				catch(Exception e){
				}
			File checkfile = new File(kakikomi);
			if(!checkfile.exists()){
				System.out.println("そのファイルは存在しません。");
				System.out.println("新しくファイルを作成しました。");
			}
			
			int c = 0;
			while(c != 3){
				String filestr = "";
				try{
					//書き込み方法の選択
					System.out.println("書き込み方法を指定してください");
					System.out.println("1.上書き    2.追記   3.終了");
					System.out.print("=");
					c = Integer.parseInt(br.readLine());//入力受付
				if(c == 1){
					//ファイルへ上書き
					FileWriter fileuwagaki = new FileWriter(new File(kakikomi));
					System.out.print("入力してください");
					System.out.print("=");
					filestr = br.readLine();
					fileuwagaki.write(filestr + "\r\n"); //入力された文字列を上書き 
					fileuwagaki.close();
				}else if(c == 2){
					//ファイルへ追記
					FileWriter filetuiki = new FileWriter(new File(kakikomi),true);
					//trueを入れることで指定ファイルに追記できる
					System.out.print("入力してください");
					System.out.print("=");
					filestr = br.readLine();
					filetuiki.write(filestr + "\r\n");
					filetuiki.close();
				}else if(c == 3){//終了
					System.out.println("書き込みを終了します");
				}else{//指定外の数字が入力された時
					System.out.println("指定内の数字を入力してください");
				}  			
				
				}catch(Exception e){
					System.out.println("指定内の数字を入力してください");
				}
			}
		}
			if(a==3){
				String yomikomi = "";
				try{
					//読み込みファイルの指定
					System.out.println("読み込みたい場所を指定＋ファイル名＋拡張子");
					System.out.println("例 =C:/Users//internous//test.txt");
					System.out.print("=");
					yomikomi =br.readLine();
					BufferedReader fileread = new BufferedReader(new FileReader(new File(yomikomi)));
					//指定ファイルをまとめて読み込み
					String readstr = "";
					System.out.println("---" + yomikomi + "-----"); //読み込み開始
					while((readstr = fileread.readLine()) != null){
						//上から1行ずつ読み込んで表示。中身がnull(なにも書いてない)になったら終了
						System.out.println(readstr);
					}
					System.out.println("---------------------------------"); //読み込み終了
					fileread.close();
				}catch(Exception e){
					System.out.println("Error");
					}
				
			}
			if(a==4);{
				System.out.println("終了しますか");
				System.out.println("１　はい　　　２　いいえ");
				try{
					x=Integer.parseInt(br.readLine());
				}catch(Exception e){
				}
			}
		}
		System.out.println("終了しました。");
	}
}