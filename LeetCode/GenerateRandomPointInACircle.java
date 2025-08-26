import java.util.*;

class Solution {
    double radius, x_center, y_center;
    Random rand;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        double r = radius * Math.sqrt(rand.nextDouble());
        double theta = 2 * Math.PI * rand.nextDouble();
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        return new double[]{x, y};
    }
}
