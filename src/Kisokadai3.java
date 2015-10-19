import java.io.*;
public class Kisokadai3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //どこのメソッドでもreadLineを使うためここで宣言
	public static void main(String[] args) {
		String str = ""; //パスを含めたファイル名を保存
		int No = 0; //ファイルに対する命令を保存

		str = create(); //ファイル指定のメソッド呼び出し
		//終了の4が入力されるまでループ
		while(No != 4){
			String filename = new File(str).getName(); //現在指定されているファイル名を取得
			System.out.println("現在開かれているファイル : " + filename); //現在指定されているファイル名表示
			No = menu(); //ファイルに何をするか入力を求めるメソッド呼び出し
			switch(No){
			case 1:filewrite(str); break; //書き込みメソッドの呼び出し
			case 2:fileread(str); break; //読み込みメソッドの呼び出し
			case 3:str = create(); break; //ファイルの指定メソッドの呼び出し
			case 4:System.out.println("終了します"); break; //全ての操作を終了
			default:System.out.println("指定内の数字を入力して下さい"); break; //1から4以外の数字が入力された時
			}
		}
	}

	static int menu(){//一番最初のメニュー画面
		int x = 0; //何を選択したかを保存
		try{
			System.out.println("1:書き込み  2:読み込み  3:ファイルの再指定  4:終了");
			System.out.print("実行内容を数字で入力してください : ");
			x = Integer.parseInt(br.readLine());
		}catch(Exception e){
			System.out.println("指定されている数字を入力して下さい");
		}
		return x; //指定された選択を対応している数字で返す
	}
	
	static String create(){ //ファイルを指定
		String st = "";
		try{
			System.out.println("以下のようにファイル名を記載して下さい");
			System.out.println("例 - C:/Users//internous//test.txt");
			st = br.readLine(); //ファイル名とパスを取得
		}catch(Exception e){
			System.out.println(e);
		}
		File file = new File(st); //ファイルの存在チェック、作成用
		File dir = new File(file.getParent()); //ディレクトリの存在チェック、作成用
		//mkdirｓは複数階層のディレクトリがなくても一括で作成する
		if(dir.mkdirs()){//ディレクトリを新しく作成出来ればtrue、作成できなければfalseを返す
			System.out.println("新しくディレクトリを作成します");
		}else{
			System.out.println("ディレクトリが存在します");
		}
		if(file.exists()){ //ファイルが存在しているかチェック
			System.out.println("ファイルを開きます");
		}else{
			try{
				file.createNewFile();
				System.out.println("新しくファイルを作成します");
			}catch(Exception e){
				System.out.println("Error");
				System.out.println("ファイルの再指定を行って下さい");
			}
		}
		return st; //記載したファイル名とパスを返す
	}

	static void filewrite(String st){//書き込み用
		int x = 0; //選択の保存用
		while(x != 3){
			try{
				System.out.println("書き込み方法を指定して下さい");
				System.out.print("1:上書き    2:追記   3:終了    :  ");
				x = Integer.parseInt(br.readLine());
				String filestr = ""; //入力文字列の保存
				if(x == 1){//上書き
					FileWriter fileuwagaki = new FileWriter(new File(st)); //パスに指定されたファイルに書き込みを行う宣言
					System.out.print("入力内容:");
					filestr = br.readLine();
					fileuwagaki.write(filestr + "\r\n"); //入力された文字列を上書き   //改行方法 Windows=\r\n  Linux=\n
					fileuwagaki.close();
				}else if(x == 2){//追記
					FileWriter filetuiki = new FileWriter(new File(st),true); //trueを入れることで指定ファイルに追記できる
					System.out.print("入力内容:");
					filestr = br.readLine();
					filetuiki.write(filestr + "\r\n");
					filetuiki.close();
				}else if(x == 3){//終了
					System.out.println("書き込みを終了します");
				}else{//指定外の数字が入力された時
					System.out.println("指定内の数字を入力して下さい");
				}
			}catch(Exception e){
				System.out.println("指定内の数字を入力して下さい");
			}
		}
	}

	static void fileread(String st){//読み込み
		try{
			BufferedReader fileread = new BufferedReader(new FileReader(new File(st))); //指定ファイルをまとめて読み込み
			String readstr = "";
			System.out.println("---" + st + "-----"); //読み込み開始
			while((readstr = fileread.readLine()) != null){ //上から1行ずつ読み込んで表示。中身がnull(なにも書いてない)になったら終了
				System.out.println(readstr);
			}
			System.out.println("---------------------------------"); //読み込み終了
			fileread.close();
		}catch(Exception e){
			System.out.println("Error");
		}
	}
}