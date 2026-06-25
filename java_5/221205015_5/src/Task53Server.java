/**
 * 基本課題　5.3 Task53Server
 * @author 221205015 伊藤優希
 */
import java.io.*;
import java.net.*;

public class Task53Server {
	
	private static final int MAX_CONNECTION = 2;
	private static ServerSocket serverSocket;
	
	public static void main(String args[]) {
		
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(8008),MAX_CONNECTION);
			System.out.println("ポート8008番をリッスン中...");
			// クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
			while(true) {
				// クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
				socket = serverSocket.accept();
				
				// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				// 接続したクライアントの情報を表示
				showClientInformation(socket);
				
				// データの受信
				long times = dis.readLong();
				// 受信したデータを表示
				System.out.println("クライアントへ演算が開始することを通知します");
				System.out.printf("演算回数%dで円周率を演算開始...",times);
				
				//送信する演算開始の通知メッセージ定義
				String hostName = socket.getLocalAddress().getHostName();
				String Openingmessage = "サーバ" + hostName + "が演算を開始しました";
				
				// 開始通知の送信
				dos.writeUTF(Openingmessage);
				dos.flush();
				
				//演算開始
				Picalculator.setNum((int)times);
				Picalculator.calcPI();
				long ProcessingTime = Picalculator.getProcessingTime();
				double plotPI = Picalculator.getplotPI();
				double gapFromTrueValue = Picalculator.getgapFromTrueValue();
				//演算終了
				
				System.out.printf("演算終了\n");
				
				String Endingmessage = "サーバが演算を終了しました";
				
				// 終了通知の送信
				dos.writeUTF(Endingmessage);
				dos.flush();
				
				System.out.println("クライアントへ演算結果["+ ProcessingTime + "ms　" + plotPI +"]を送信します．");
				
				// 計算に要した処理時間の送信
				dos.writeLong(ProcessingTime);
				dos.flush();
				
				dos.writeDouble(plotPI);
				dos.flush();
				
				dos.writeDouble(gapFromTrueValue);
				dos.flush();
				
				socket.close();
			}

			
			
					
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
		}
		
	}private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();
		
		System.out.println("クライアント[/" + address.toString() + ":" + port +"]が接続しました．");
	}
}
