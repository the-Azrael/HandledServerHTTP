import java.io.BufferedOutputStream;

abstract class Handler {
    abstract void handle(Request request, BufferedOutputStream responseStream);
}
