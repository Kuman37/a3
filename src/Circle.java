public class Circle extends Shape {
    private int radius;

    public Circle(String id, int radius, Renderer renderer) {
        super(id, renderer);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public String execute() {
        return renderer.render("circle", "radius", radius);
    }
}