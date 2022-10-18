import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws UnknownHostException, IOException {
        

        try (Scanner scanner = new Scanner(System.in)) {

            
            while(true) {
                System.out.print("Enter your message/request: ");
                String msg = scanner.nextLine();
                Socket clientSocket = new Socket("localhost", 9900);

                if(clientSocket.isConnected()) {
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    bWriter.write(msg);
                    bWriter.newLine();
                    bWriter.flush();

                    System.out.println(bReader.readLine());

                    bReader.close();
                    bWriter.close();
                    clientSocket.close();

                    if(clientSocket.isClosed())
                        System.out.println("\tDisconnecting to the server...");

                }
            }
            

        }

    }

}
