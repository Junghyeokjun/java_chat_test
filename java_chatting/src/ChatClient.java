import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {

		Socket socket = null;

		try {
			socket=new Socket("localhost",7777);
			
			System.out.println("서버가 작동되었습니다.");
			
			Sender sender = new Sender(socket);
			Receiver receiver=new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
