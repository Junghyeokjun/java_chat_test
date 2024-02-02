import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChatServer {
	static Map<Socket,Sender> map = new HashMap<>();
	static Set<Socket> set;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버 준비 완료");
			ServerSender serverSender = new ServerSender();
			serverSender.start();
			while (true) {
				socket = serverSocket.accept();

				Sender sender = new Sender(socket);
				ServerReceiver receiver = new ServerReceiver(socket);

				map.put(sender.socket,sender);
				set=map.keySet();
				receiver.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		ServerSocket serverSocket = null;
//		Socket socket = null;
//
//		try {
//			serverSocket = new ServerSocket(7777);
//			System.out.println("서버 준비 완료");
//			socket = serverSocket.accept();
//			
//			Sender sender = new Sender(socket);
//			Receiver receiver=new Receiver(socket);
//			
//			sender.start();
//			receiver.start();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
