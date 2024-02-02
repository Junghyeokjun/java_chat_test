import java.io.DataInputStream;
import java.net.Socket;

public class Receiver extends Thread{
	Socket socket;
	DataInputStream in;	
	
	public Receiver(Socket socket) {
		this.socket=socket;
		 try {
			 in=new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
