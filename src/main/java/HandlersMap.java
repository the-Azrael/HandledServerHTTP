import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlersMap {
    private ConcurrentHashMap<MethodPath, Handler> handlersMap;

    public HandlersMap() {
        handlersMap = new ConcurrentHashMap<>();
    }

    public void add(String method, String path, Handler handler) {
        MethodPath methodPath = new MethodPath(method, path);
        handlersMap.put(methodPath, handler);
    }

    public void show() {
        for (Map.Entry<MethodPath, Handler> entry : handlersMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public Handler getHandler(String method, String path) {
        MethodPath methodPath = new MethodPath(method, path);
        return handlersMap.get(methodPath);
    }
}
