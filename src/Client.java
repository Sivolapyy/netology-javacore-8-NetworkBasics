import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket("localhost", 25000)) {

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Код задачи 1 "Клиент-серверное приложение"
            out.println("Mike");
            System.out.println(in.readLine());
            System.out.println();

            // Код задачи 2 "Клиент-сервер с рюшечками"
            Scanner sc = new Scanner(System.in);

            System.out.println(in.readLine());
            out.println(sc.nextLine());
            System.out.println(in.readLine());
            out.println(sc.nextLine());
            System.out.println(in.readLine());

        } catch (IOException exc) {
            System.out.println("Ошибка - " + exc.getMessage());
        }
    }
}
