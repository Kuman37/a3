public class VectorRenderer implements Renderer {
    public String render(String shape, int size) {
        return "VECTOR " + shape + " " + size;
    }
}