/**
 * 基本課題　5.A Task5AClient
 * @author 221205015 伊藤優希
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Task5AClient {
	public static void main(String[] args) {
		// コマンドライン引数から接続先サーバのホスト名またはIPアドレスを取得
		String server = args[0];
		// コマンドライン引数からポート番号を取得
		int port = Integer.parseInt(args[1]);
		
		Socket socket = null;
		try {
			//　ソケットを作成
			socket = new Socket();

			//　指定されたホスト名(IPアドレス)とポート番号でサーバに接続する
			socket.connect(new InetSocketAddress(server,port));
			
			// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			while(true) {
				//　演算回数を送信
				dos.writeUTF(InputCommand());
				dos.flush();
				
			}
			
			
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	private static String InputCommand() {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		String argument = scanner.nextLine();
		String str = command + " " +  argument;
		System.out.printf("%s　が入力されました",str);
		return str;
	}
	

}
