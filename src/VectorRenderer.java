public class VectorRenderer implements Renderer {
    public String render(String shape, String dimension, int value) {
        return "VECTOR " + shape + " " + dimension + "=" + value;
    }
}