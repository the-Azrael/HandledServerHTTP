import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server extends Thread {
    private static final String PATH = "./public";
    private int port;
    private ServerSocket serverSocket;
    private HandlersMap handlers;

    public Server() {
        this.handlers = new HandlersMap();
    }

    public void addHandler(String method, String path, Handler handler) {
        handlers.add(method, path, handler);
    };

    @Override
    public synchronized void start() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(64);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket, handlers);
                executor.execute(serverThread);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void listen(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        this.start();
    }
}
