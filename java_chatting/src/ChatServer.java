import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	static List<Sender> list=new ArrayList<Sender>();
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버 준비 완료");
			Sender2 sender2=new Sender2();
			sender2.start();
			while (true) {
				socket = serverSocket.accept();

				Sender sender = new Sender(socket);
				Receiver2 receiver = new Receiver2(socket);
				
				list.add(sender);
				
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
