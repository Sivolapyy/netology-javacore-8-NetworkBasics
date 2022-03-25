import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(25000);

        Socket clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Код задачи 1 "Клиент-серверное приложение"
        System.out.println("New connection accepted");
        final String yourName = in.readLine();
        out.println(String.format("Hi %s, your port is %d", yourName, clientSocket.getPort()));

        // Код задачи 2 "Клиент-сервер с рюшечками"
        out.println("Write your name please?");
        String name = in.readLine();
        out.println("Are you child? (yes/no)");
        String answer = in.readLine();

        switch (answer.toLowerCase(Locale.ROOT)) {
            case "yes":
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                break;
            case "no":
                out.println(
                        String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                break;
            default:
                out.println("I can't understand your answer");
        }

    }
}
