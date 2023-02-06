public class OKMessage implements Message {
    private static final String code = "200 OK";
    private String[] params;
    private String text;

    public OKMessage(String[] params) {
        this.params = params;

        this.text = String.format("HTTP/1.1 %s\r\n" +
                "Content-Type: %s\r\n" +
                "Content-Length: %s\r\n" +
                "Connection: close\r\n" +
                "\r\n", code, params[0], params[1]);

    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String[] getParams() {
        return params;
    }
}
