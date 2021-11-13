import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class PeerHandler extends Thread{
    private ServerSocket serverSocket;
    private Socket socket;
    private Set<ServerSocket> serverSocketSet = new HashSet<>();

    public PeerHandler(String portNumber, Socket socket) throws IOException {
        this.socket = socket;
        serverSocket = new ServerSocket(Integer.parseInt(portNumber));
        serverSocketSet.add(serverSocket);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true){
            try{
                this.socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(this.socket.getInputStream());
                System.out.println(in.readUTF());

            }catch (Exception e ){
                e.printStackTrace();
            }

        }
    }
}
