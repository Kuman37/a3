public class RasterRenderer implements Renderer {
    public String render(String shape, int size) {
        return "RASTER " + shape + " " + size;
    }
}