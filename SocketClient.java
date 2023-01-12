import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[]args) throws UnknownHostException, IOException {
        Scanner input = new Scanner(System.in);
        int port = 8080;
        String host= "10.113.67.45";
        String answer; String sendMessage; String receivedMessage;
        InetAddress address = InetAddress.getByName(host);
        System.out.println(address);
        Socket socket = new Socket(address, port);

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        System.out.println("Connected! ");
        answer = input.nextLine();
        
        System.out.print("Zevzzz: ");
        sendMessage = answer;
        bw.write(sendMessage);
        bw.newLine();
        bw.flush();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        receivedMessage = br.readLine();
        System.out.println("Percy: " + receivedMessage);
    }
}