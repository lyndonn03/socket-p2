import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocketHandler implements Runnable {

    private Socket clientSocket;
    private InputStreamReader iReader;
    private OutputStreamWriter oWriter;
    private BufferedReader bReader;
    private BufferedWriter bWriter;

    public ClientSocketHandler(Socket clientSocket) throws IOException {
        assert(clientSocket != null);

        this.clientSocket = clientSocket;
        this.iReader = new InputStreamReader(clientSocket.getInputStream());
        this.oWriter = new OutputStreamWriter(clientSocket.getOutputStream());
        this.bReader = new BufferedReader(iReader);
        this.bWriter = new BufferedWriter(oWriter);

    }

    @Override
    public void run() {

        while(!clientSocket.isClosed()) {
            try {

                String msg = bReader.readLine();
                if(msg != null) {

                    Thread.sleep(5000); // apply slow response

                    String indexMsgResponse = "Here is my response: " + msg;
                    bWriter.write(indexMsgResponse);
                    bWriter.newLine();
                    bWriter.flush();
                    clientSocket.close();
                    bWriter.close();
                    bReader.close();

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        
    }
    
}
