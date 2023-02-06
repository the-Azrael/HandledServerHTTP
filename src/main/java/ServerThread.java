import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerThread implements Runnable {
    private static final int METHOD_IDX = 0;
    private static final int PATH_IDX = 1;
    private static final AtomicInteger cnt = new AtomicInteger(0);
    private final int id;
    private final Socket socket;
    private HandlersMap handlers;
    private final BufferedReader in;
    private final BufferedOutputStream out;

    public ServerThread(Socket socket, HandlersMap handlers) throws IOException {
        id = cnt.incrementAndGet();
        this.socket = socket;
        this.handlers = handlers;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedOutputStream(socket.getOutputStream());
    }

    public Request getRequest() {
        Request request = null;
        try {
            if (in.ready()) {
                String inData = in.readLine();
                if (inData != null) {
                    request = new Request(inData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public void run() {
        Request request = null;
        while(true) {
            request = getRequest();
            if (request != null && request.getSplitData().length == 3) {
                Handler handler = handlers.getHandler(request.getSplitData()[METHOD_IDX],
                        request.getSplitData()[PATH_IDX]);
                if (handler != null) {
                    handler.handle(request, out);
                }
                break;
            }
        }
        System.out.println("ServerThread " + id + " ended!");
    }

}


