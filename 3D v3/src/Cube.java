import java.awt.Color;
import java.util.ArrayList;

public class Cube {

    double x, y, z;
    Location location;
    Vertex a, b, c, d, e, f, g, h;
    Color color;
    Polygon3D[] polygons = new Polygon3D[6];

    public Cube(double x, double y, double z, double length, double width, double height) {
        this.x = x;
        this.y = y;
        this.z = z;

        location = new Location(x, y, z);
        //mid = new Location(x + length / 2, y + height / 2, z + width / 2);

        a = new Vertex(x, y, z);
        b = new Vertex(x + length, y, z);
        c = new Vertex(x, y, z + width);
        d = new Vertex(x + length, y, z + width);
        e = new Vertex(x, y + height, z);
        f = new Vertex(x + length, y + height, z);
        g = new Vertex(x, y + height, z + width);
        h = new Vertex(x + length, y + height, z + width);
    }

    public Cube(double x, double y, double z, Color color) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.color = color;

        location = new Location(x, y, z);

        a = new Vertex(x, y, z);
        b = new Vertex(x + 1, y, z);
        c = new Vertex(x, y, z + 1);
        d = new Vertex(x + 1, y, z + 1);
        e = new Vertex(x, y + 1, z);
        f = new Vertex(x + 1, y + 1, z);
        g = new Vertex(x, y + 1, z + 1);
        h = new Vertex(x + 1, y + 1, z + 1);
    }



    public void addPolygons() {

        double ax = a.x + b.x + c.x + d.x + e.x + f.x + g.x + h.x;
        double ay = a.y + b.y + c.y + d.y + e.y + f.y + g.y + h.y;
        double az = a.z + b.z + c.z + d.z + e.z + f.z + g.z + h.z;

        ax /= 8;
        ay /= 8;
        az /= 8;

        Location mid = new Location(ax, ay, az);

        if (Calculator.calculateDepth(Camera.getLocation(), Camera.yaw, Camera.pitch, mid) > 1) {
            Polygon3D i = new Polygon3D(new Vertex[]{a, b, f, e}, color, this, "FRONT");
            Polygon3D j = new Polygon3D(new Vertex[]{b, f, h, d}, color, this, "RIGHT");
            Polygon3D k = new Polygon3D(new Vertex[]{g, h, d, c}, color, this, "BACK");
            Polygon3D l = new Polygon3D(new Vertex[]{g, c, a, e}, color, this, "LEFT");
            Polygon3D m = new Polygon3D(new Vertex[]{a, b, d, c}, color, this, "BOTTOM");
            Polygon3D n = new Polygon3D(new Vertex[]{e, f, h, g}, color, this, "TOP");

            polygons[0] = i;
            polygons[1] = j;
            polygons[2] = k;
            polygons[3] = l;
            polygons[4] = m;
            polygons[5] = n;

            Main.polygons.add(i);
            Main.polygons.add(j);
            Main.polygons.add(k);
            Main.polygons.add(l);
            Main.polygons.add(m);
            Main.polygons.add(n);
        }
    }

}
