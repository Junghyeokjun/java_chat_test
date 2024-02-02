import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerReceiver extends Thread {
	Socket socket;
	DataInputStream in;

	public ServerReceiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (in != null) {
			try {
				String str = in.readUTF();
				System.out.println(str);
				for (Socket socket : ChatServer.set ) {
					if (!(ChatServer.map.get(socket).socket.equals(this.socket))) {
						ChatServer.map.get(socket).out.writeUTF(str);
					}
				}
			} catch (Exception e) {
				ChatServer.map.remove(this.socket);
				for (Socket socket : ChatServer.set ) {
					try {
						ChatServer.map.get(socket).out.writeUTF("현재 서버에 남은 인원은 " + ChatServer.map.size() + "명입니다.");
					} catch (IOException e1) {
					}
				}
				break;
			}
		}
	}

}
