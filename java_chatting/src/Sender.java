import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			this.name = "[" + socket.getLocalAddress() + "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Sender(Socket socket, String name) {
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			this.name = "[" + name + "]";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("닉네임을 입력해주세요.");
		this.name="["+scanner.nextLine()+"]";
		while (out != null) {
			try {
				out.writeUTF(name + scanner.nextLine());
			} catch (Exception e) {
				System.out.println("연결종료");
				break;
			}
		}
	}

}
