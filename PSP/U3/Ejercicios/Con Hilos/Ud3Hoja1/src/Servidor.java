import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    static final int PUERTO = 5000;
    private static int clientes = 0;
    private Socket cliente;

    public Servidor(Socket cliente) {
        this.cliente = cliente;

    }

    public void run() {
        try {
                // se incrementa el número de clientes
                clientes++;
                // cliente.getInetAddress() devuelve la dirección IP del cliente
                System.out.println("Cliente " + clientes + " IP: " + cliente.getInetAddress());
                // Se envía un mensaje al cliente
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF("Hola cliente nº" + clientes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{

            // Se crea el socket del servidor
            ServerSocket server = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en puerto " + PUERTO);

            while (true) {
                // Se espera una conexión de un cliente
                Socket cliente = server.accept();

                new Servidor(cliente).start();

            }

        } catch(RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
