import java.io.DataInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerReceiver extends Thread{
	Socket socket;
	DataInputStream in;	

	public ServerReceiver(Socket socket) {
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
				String str=in.readUTF();
				System.out.println(str);
				for (Sender Sender : ChatServer.list) {
					if(!(Sender.socket.equals(this.socket))) {
						Sender.out.writeUTF(str);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
