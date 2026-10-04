public class AsciiRenderer implements Renderer {
    public String render(String shape, String dimension, int value) {
        return "ASCII " + shape + " " + dimension + "=" + value;
    }
}