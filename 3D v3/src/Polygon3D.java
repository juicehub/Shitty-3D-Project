import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Polygon3D {

    Polygon p;
    Vertex[] vertices;
    Color color;
    double distance;
    double distanceToMiddle = 0;
    boolean intersects;
    String type;
    Cube cube;

    public void repaint() {
        p = new Polygon();
        for (Vertex v : vertices) {
            int x = (int) Calculator.calculateScreenLocation(Camera.getLocation(), Camera.getYaw(), Camera.getPitch(), v).getX();
            int y = (int) Calculator.calculateScreenLocation(Camera.getLocation(), Camera.getYaw(), Camera.getPitch(), v).getY();

            p.addPoint(x, y);
            for (int i = 0; i < p.xpoints.length; i++) {
                int dx = p.xpoints[i] - (int) (Main.ScreenSize.getWidth() / 2);
                int dy = p.ypoints[i] - (int) (Main.ScreenSize.getHeight() / 2);
                int d = (int) Math.sqrt(dx * dx + dy * dy);
                distanceToMiddle += d;
            }

            int intersectsHora = 0;
            int intersectsVera = 0;
            int intersectsHorb = 0;
            int intersectsVerb = 0;
            for (int i = 0; i < p.xpoints.length; i++) {
                if (i != p.xpoints.length - 1 && Main.screen.horizontala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                    intersectsHora++;
                } else if (Main.screen.horizontala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                    intersectsHora++;
                }

                if (i != p.xpoints.length - 1 && Main.screen.verticala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                    intersectsVera++;
                } else if (Main.screen.verticala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                    intersectsVera++;
                }

                if (i != p.xpoints.length - 1 && Main.screen.horizontalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                    intersectsHorb++;
                } else if (Main.screen.horizontalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                    intersectsHorb++;
                }

                if (i != p.xpoints.length - 1 && Main.screen.verticalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                    intersectsVerb++;
                } else if (Main.screen.verticalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                    intersectsVerb++;
                }
            }

            if (intersectsHora == 1 || intersectsVera == 1 || intersectsHorb == 1 || intersectsVerb == 1) {
                intersects = true;

            }

            //if (intersectsHora > 1 || intersectsHorb > 1 || intersectsVera > 1 || intersectsVerb > 1) intersects = true;
        }
    }

    public Polygon3D(double distanceToMiddle, double distance)
    {
        this.distanceToMiddle = distanceToMiddle;
        this.distance = distance;
    }
    public Polygon3D(Vertex[] vertices, Color color, Cube origin, String type) {
        p = new Polygon();
        for (Vertex v : vertices) {
            int x = (int) Calculator.calculateScreenLocation(Camera.getLocation(), Camera.getYaw(), Camera.getPitch(), v).getX();
            int y = (int) Calculator.calculateScreenLocation(Camera.getLocation(), Camera.getYaw(), Camera.getPitch(), v).getY();

            p.addPoint(x, y);
        }
        this.type = type;
        this.vertices = vertices;
        this.color = color;
        this.cube = origin;
        this.distance = Calculator.calculateDistance(Camera.getLocation(), this);

        for (int i = 0; i < p.xpoints.length; i++) {
            int dx = p.xpoints[i] - (int) (Main.ScreenSize.getWidth() / 2);
            int dy = p.ypoints[i] - (int) (Main.ScreenSize.getHeight() / 2);
            int d = (int) Math.sqrt(dx*dx + dy*dy);
            distanceToMiddle += d;
        }

        int intersectsHora = 0;
        int intersectsVera = 0;
        int intersectsHorb = 0;
        int intersectsVerb = 0;
        for (int i = 0; i < p.xpoints.length; i++) {
            if (i != p.xpoints.length - 1 && Main.screen.horizontala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                intersectsHora++;
            }

            else if (Main.screen.horizontala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                intersectsHora++;
            }

            if (i != p.xpoints.length - 1 && Main.screen.verticala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                intersectsVera++;
            }

            else if (Main.screen.verticala.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                intersectsVera++;
            }

            if (i != p.xpoints.length - 1 && Main.screen.horizontalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                intersectsHorb++;
            }

            else if (Main.screen.horizontalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                intersectsHorb++;
            }

            if (i != p.xpoints.length - 1 && Main.screen.verticalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[i + 1], p.ypoints[i + 1])) {
                intersectsVerb++;
            }

            else if (Main.screen.verticalb.intersectsLine(p.xpoints[i], p.ypoints[i], p.xpoints[0], p.ypoints[0])) {
                intersectsVerb++;
            }
        }

        if (intersectsHora == 1 || intersectsVera == 1 || intersectsHorb == 1 || intersectsVerb == 1) {
            intersects = true;

        }

        //if (intersectsHora > 1 || intersectsHorb > 1 || intersectsVera > 1 || intersectsVerb > 1) intersects = true;
    }

    public void drawPolygon(Graphics2D g2d) {
        g2d.drawPolygon(p);
    }

    public void fillPolygon(Graphics2D g2d, Color color2) {
        g2d.setColor(color2);
        if (color2 == null) {
            g2d.setColor(color);
        }



        g2d.fillPolygon(p);
    }


}
