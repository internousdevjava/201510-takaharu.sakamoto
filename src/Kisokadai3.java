import java.io.*;
public class Kisokadai3 {
	public static void main(String[] args){
		int x = 0;
		while(x!=1){
		System.out.println("���j���[��\�����܂�"); 
		System.out.println("�ԍ�����͂��Ă�������"); 
		System.out.println("�P�@�t�@�C���̍쐬"); 
		System.out.println("�Q�@�t�@�C���̏�������"); 
		System.out.println("�R�@�t�@�C���̓ǂݍ���"); 
		System.out.println("�S�@�I��"); 
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
			//�t�@�C���쐬�v���O������
			String sakusei = "";
			try{
			System.out.println("�V�K�쐬�������ꏊ���w��{�t�@�C�����{�g���q");
			System.out.println("�� =C:/Users//internous//test.txt");
			System.out.print("=");
			sakusei=br.readLine();
			}
			catch(Exception e){
			}
			//���͂����t�@�C�������邩�ǂ�������
			File file = new File(sakusei); 
			File dir = new File(file.getParent()); 
			
			//���͂����t�@�C�����Ȃ���΍쐬
			try{
			if(dir.exists()){ //�t�H���_�̑��݂̃`�F�b�N
				System.out.println("�f�B���N�g���͑��݂��܂��B");
				System.out.println("���j���[�ɖ߂�܂�");
			}else{
				System.out.println("�V�����f�B���N�g�����쐬���܂����B");
				dir.mkdir(); //�f�B���N�g���쐬
			}
			if(file.exists()){ //�t�@�C���̑��݂̃`�F�b�N
				System.out.println("�t�@�C���͑��݂��܂��B");
				System.out.println("���j���[�ɖ߂�܂�");
			}else{
				System.out.println("�V�����t�@�C�����쐬���܂����B");
				
					file.createNewFile(); //�t�@�C���쐬
			}
				}catch(Exception e){
				}
		}
		if(a==2){
		//�t�@�C���������݂̃v���O����
			String kakikomi = "";
			try{
				//�������݃t�@�C���̎w��
				System.out.println("�������݂����ꏊ���w��{�t�@�C�����{�g���q");
				System.out.println("�� =C:/Users//internous//test.txt");
				System.out.print("=");
				kakikomi=br.readLine();
				}
				catch(Exception e){
				}
			File checkfile = new File(kakikomi);
			if(!checkfile.exists()){
				System.out.println("���̃t�@�C���͑��݂��܂���B");
				System.out.println("�V�����t�@�C�����쐬���܂����B");
			}
			
			int c = 0;
			while(c != 3){
				String filestr = "";
				try{
					//�������ݕ��@�̑I��
					System.out.println("�������ݕ��@���w�肵�Ă�������");
					System.out.println("1.�㏑��    2.�ǋL   3.�I��");
					System.out.print("=");
					c = Integer.parseInt(br.readLine());//���͎�t
				if(c == 1){
					//�t�@�C���֏㏑��
					FileWriter fileuwagaki = new FileWriter(new File(kakikomi));
					System.out.print("���͂��Ă�������");
					System.out.print("=");
					filestr = br.readLine();
					fileuwagaki.write(filestr + "\r\n"); //���͂��ꂽ��������㏑�� 
					fileuwagaki.close();
				}else if(c == 2){
					//�t�@�C���֒ǋL
					FileWriter filetuiki = new FileWriter(new File(kakikomi),true);
					//true�����邱�ƂŎw��t�@�C���ɒǋL�ł���
					System.out.print("���͂��Ă�������");
					System.out.print("=");
					filestr = br.readLine();
					filetuiki.write(filestr + "\r\n");
					filetuiki.close();
				}else if(c == 3){//�I��
					System.out.println("�������݂��I�����܂�");
				}else{//�w��O�̐��������͂��ꂽ��
					System.out.println("�w����̐�������͂��Ă�������");
				}  			
				
				}catch(Exception e){
					System.out.println("�w����̐�������͂��Ă�������");
				}
			}
		}
			if(a==3){
				String yomikomi = "";
				try{
					//�ǂݍ��݃t�@�C���̎w��
					System.out.println("�ǂݍ��݂����ꏊ���w��{�t�@�C�����{�g���q");
					System.out.println("�� =C:/Users//internous//test.txt");
					System.out.print("=");
					yomikomi =br.readLine();
					BufferedReader fileread = new BufferedReader(new FileReader(new File(yomikomi)));
					//�w��t�@�C�����܂Ƃ߂ēǂݍ���
					String readstr = "";
					System.out.println("---" + yomikomi + "-----"); //�ǂݍ��݊J�n
					while((readstr = fileread.readLine()) != null){
						//�ォ��1�s���ǂݍ���ŕ\���B���g��null(�Ȃɂ������ĂȂ�)�ɂȂ�����I��
						System.out.println(readstr);
					}
					System.out.println("---------------------------------"); //�ǂݍ��ݏI��
					fileread.close();
				}catch(Exception e){
					System.out.println("Error");
					}
				
			}
			if(a==4);{
				System.out.println("�I�����܂���");
				System.out.println("�P�@�͂��@�@�@�Q�@������");
				try{
					x=Integer.parseInt(br.readLine());
				}catch(Exception e){
				}
			}
		}
		System.out.println("�I�����܂����B");
	}
}