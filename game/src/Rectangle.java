public class Rectangle {
    double x1, y1, x2, y2;
    Boolean change, color;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = false;
        this.change = false;
    }

    public String toString() {
        return "(" + this.x1 + "; " + this.y1 + ") " + " (" + this.x2 + "; " + this.y2 + ")";
    }
}
