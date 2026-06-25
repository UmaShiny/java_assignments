/**
 * 基本課題　5.A Task5AServer
 * @author 221205015 伊藤優希
 */
import java.io.*;
import java.net.*;

public class Task5AServer {
	
	private static final int MAX_CONNECTION = 2;
	private static ServerSocket serverSocket;
	
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(Integer.parseInt(args[0])), MAX_CONNECTION);
			System.out.printf("ポート%s番をリッスン中");
			// クライアントからの接続要求を待機(クライアント接続するまでブロッキング)
			while(true) {
				socket = serverSocket.accept();
				
				// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				//　接続されたしたクライアントの情報を表示
				showClientInformation(socket);
				
			}
		}catch(Exception e) {
			
		}finally {
			
		}
	}private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();
		
		System.out.println("クライアント[/" + address.toString() + ":" + port +"]が接続しました．");
	}
}
