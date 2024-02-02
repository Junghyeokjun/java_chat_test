import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerSender extends Thread{
	String name;
	
	public ServerSender() {
		try {
			name="[서버]";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			try {
				String str=name+scanner.nextLine();
				for (Sender Sender : ChatServer.list) {
					Sender.out.writeUTF(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
