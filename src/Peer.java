import java.io.*;
import java.net.Socket;

public class Peer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type a port address");
        String portNumber = bufferedReader.readLine();

        PeerHandler peerHandler = new PeerHandler(portNumber,null);
        peerHandler.start();

        System.out.println("Type a port address to send");
        String toWhom = bufferedReader.readLine();

        Socket socket = new Socket("localhost", Integer.parseInt(toWhom));
        peerHandler.setSocket(socket);

//        String whichClient = bufferedReader.readLine();


        System.out.println("Start typing...");
        System.out.println("You can press 'q' to exit!");

        boolean flag = true;
        while (flag){

            String message = bufferedReader.readLine();

            System.out.println("Is it urgent? Yes/No");
            String isUrgent = bufferedReader.readLine();
            boolean isUrgentFinal;

            if(isUrgent.equalsIgnoreCase("yes")){
                isUrgentFinal = true;
            }else if (isUrgent.equalsIgnoreCase("no")){
                isUrgentFinal = false;
            }else{
                isUrgentFinal = false;
            }

            Message messageSend = new Message.Builder(message, isUrgentFinal).build();

            if(message.equalsIgnoreCase("q")){
                flag = false;
                break;
            }
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(String.valueOf(messageSend));

        }
    }

}
