/**
 * 
 */

/**
 * @author internous
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class Kisokadai3 {

	public static void main(String args[]) throws IOException{
		System.out.println("--�����J�n--");
		//�R�}���h���C�����������͂���Ă��邩�`�F�b�N���s��
		if(args.length==0){
			System.out.println("�R�}���h���C���������w�肵�ē��͂��Ȃ����Ă��������B");
			System.out.println("[��] > java TextStream C:\test\test.txt");
			System.out.println("\n�������I�����܂�");
			return;
		}
		// �t�@�C���p�X���w�肷��
		File file = new File(args[0]);
		// �f�B���N�g���p�X���擾����
		File dir=new File(file.getParent());

		if(!dir.exists()){
			System.out.println("�t�H���_������܂���B:"+file.getAbsolutePath());
			dir.mkdirs();
			System.out.println("�쐬����");
		} else {
			System.out.println("�t�H���_�͊��ɑ��݂��܂��B");
		}

		if(file.exists()){
			System.out.println("�t�@�C���͊��ɑ��݂��܂��B\n" + file.getAbsolutePath());
		}else{
			System.out.println("�t�@�C���͑��݂��܂���B\n"+file.getAbsolutePath());
			try{
				if (file.createNewFile()){
					System.out.println("�쐬����");
				}else{
					System.out.println("�쐬���s");
				}
			}catch(IOException e){
				System.out.println(e);
			}
		}



		int end = 0;
		while(end==0){

			System.out.println("\n\n--���j���[--\n\n 1:�ǂݍ���\n 2:��������\n99:�I��\n����͂��Ă�������");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int nu = 0;
			
			if(str.matches("^[0-9]+$")){
				nu=Integer.parseInt(str);
			}else{
				System.out.println("\n----------\n���p���l�Ń��j���[��I�����Ă��������B\n----------\n");
			}
			
			if(nu==99){
				System.out.println("�I��");
				break;
			}
			if(nu==1){
				System.out.println("�t�@�C����ǂ�");
				try{
					FileReader filereader = new FileReader(file.getAbsolutePath());

					int ch;
					while((ch = filereader.read()) != -1){
						System.out.print((char)ch);
					}

					filereader.close();
				}catch(FileNotFoundException e){
					System.out.println(e);
				}catch(IOException e){
					System.out.println(e);
				}
			}
			if(nu==2){
				System.out.println("�t�@�C��������");
				try {
					boolean mode = false;
					System.out.println("���[�h�̐ݒ�B1:�ǋL�A2:�㏑��");
					BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
					String str2 = br2.readLine();
					// ���[�h�����߂�
					switch (str2) {
					case "1":
						mode = true;
						break;
					case "2":
						mode = false;
					default:
						break;
					}
					//�o�͐���쐬����
					FileWriter fw = new FileWriter(file.getAbsolutePath(), mode);
					PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

					//���e���w�肷��
					BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
					String str3 = br3.readLine();
					pw.println(str3);

					//�t�@�C���ɏ����o��
					pw.close();

					//�I�����b�Z�[�W����ʂɏo�͂���
					System.out.println("�o�͂��������܂����B");

				} catch (IOException ex) {
					//��O������
					ex.printStackTrace();
				}

			}
		}
		System.out.println("--�����I��--");
	}
}



