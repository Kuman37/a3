public class RasterRenderer implements Renderer {
    public String render(String shape, String dimension, int value) {
        return "RASTER " + shape + " " + dimension + "=" + value;
    }
}