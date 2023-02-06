import java.util.concurrent.atomic.AtomicInteger;

public class MethodPath {
    private String method;
    private String path;

    public MethodPath(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        return method.hashCode() + path.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        MethodPath methodPath = (MethodPath) obj;
        if (this.getMethod().equalsIgnoreCase(methodPath.getMethod()) && this.getPath().equalsIgnoreCase(methodPath.getPath())) {
            return true;
        } else {
            return false;
        }
    }
}
