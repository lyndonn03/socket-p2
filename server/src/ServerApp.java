import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServerApp {
    public static void main(String[] args) throws InterruptedException, IOException {

        try (ServerSocket serverSocket = new ServerSocket(9900)) {

            System.out.println("Server is listening on port " + serverSocket.getLocalPort() + "...");

            ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

            while(true) {

                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientSocketHandler(clientSocket));
                System.out.println("Number of active threads: " + pool.getActiveCount());

            }

            
        }

        
    }
}
