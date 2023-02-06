import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
  private static final int port = 9999;
  private static final String PATH = "./public";

  public static void main(String[] args) throws IOException {
    Server server = new Server();

    server.addHandler("GET", "/index.html", new Handler() {
      @Override
      public void handle(Request request, BufferedOutputStream responseStream) {
        Response response = new Response(PATH + request.getSplitData()[1], responseStream);
        if (response != null) {
          response.write();
        }
      }
    });

    server.addHandler("GET", "/classic.html", new Handler() {
      @Override
      void handle(Request request, BufferedOutputStream responseStream) {
        Response response = new Response(PATH + request.getSplitData()[1], responseStream);
        if (response != null) {
          response.write();
        }
      }
    });

    server.addHandler("GET", "/events.html", new Handler() {
      @Override
      void handle(Request request, BufferedOutputStream responseStream) {
        Response response = new Response(PATH + request.getSplitData()[1], responseStream);
        if (response != null) {
          response.write();
        }
      }
    });
    server.listen(port);
  }
}


