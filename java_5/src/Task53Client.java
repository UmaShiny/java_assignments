/**
 * 基本課題　5.3 Task53Client
 * @author 221205015 伊藤優希
 */
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Task53Client {
	public static void main(String args[]) {
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

			//　演算回数を送信
			dos.writeLong(Times());
			dos.flush();
			
			//　演算開始の通知を受信
			String Openingmessage = dis.readUTF();
			System.out.println(Openingmessage);
			
			//　演算終了の通知を受信
			String Endingmessage = dis.readUTF();
			System.out.println(Endingmessage);
			
			//　各データを受信
			long ProcessingTime = dis.readLong();
			
			double plotPI = dis.readDouble();
			
			double gapFromTrueValue = dis.readDouble();
			
			System.out.println("処理時間=" + ProcessingTime + "ms 演算結果=" + plotPI + "(誤差=" + gapFromTrueValue + ")");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}			
		}
	}
	
	private static long Times() throws NumberFormatException{
		Scanner scanner = new Scanner(System.in);
		System.out.printf("試行回数を入力＞＞");
		String Times_str = scanner.nextLine();
		long Times = Long.parseLong(Times_str);
		scanner.close();
		return Times;
	}
}
