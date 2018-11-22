import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class Screen extends JComponent {


    static ArrayList<Cube> cubes = new ArrayList<>();
    public static Line2D.Double horizontala, verticala, horizontalb, verticalb;

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.fillRect(0, 0, (int) Main.ScreenSize.getWidth(), (int) Main.ScreenSize.getHeight());

        for (Polygon3D p : Main.polygons) {
            p.repaint();
        }

        Calculator.sortPolygons(Main.polygons);

        Polygon3D closestToMid = new Polygon3D(Double.MAX_VALUE, Double.MAX_VALUE);
        for (Polygon3D p : Main.polygons) {
            if (p.intersects) {
                if (p.distanceToMiddle < closestToMid.distanceToMiddle) {
                    closestToMid.intersects = false;
                    closestToMid = p;
                }
            }
        }

        Polygon3D closest = new Polygon3D(Double.MAX_VALUE, Double.MAX_VALUE);
        for (Polygon3D p : Main.polygons) {
            if (p.intersects) {
                if (p.distanceToMiddle < closest.distanceToMiddle) {
                    closest.intersects = false;
                    closest = p;
                }
            }
        }



        for (Polygon3D p : Main.polygons) {

            p.fillPolygon(g2d, null);

            if (p.intersects) {

                p.fillPolygon(g2d, new Color(16, 16, 16, 90));
                Camera.setSelectedPolygon(p);
            }

            g2d.setColor(Color.black);
            p.drawPolygon(g2d);
        }

        /**g2d.setColor(Color.red);
        g2d.draw(horizontala);
        g2d.draw(verticala);
        g2d.setColor(Color.blue);
        g2d.draw(horizontalb);
        g2d.draw(verticalb);**/

        g2d.setColor(Camera.getSelectedColor());
        g2d.fillRect(0, 0, 10, 10);


        //Main.polygons.clear();


    }

    public void placeBlock(Polygon3D selectedPolygon) {
        if (selectedPolygon.type == "FRONT") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX(), selectedPolygon.vertices[0].getY(), selectedPolygon.vertices[0].getZ() - 1, Camera.getSelectedColor());
            cubes.add(c);
        }

        if (selectedPolygon.type == "BACK") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX(), selectedPolygon.vertices[0].getY() - 1, selectedPolygon.vertices[0].getZ(), Camera.getSelectedColor());
            cubes.add(c);
        }

        if (selectedPolygon.type == "LEFT") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX() - 1, selectedPolygon.vertices[0].getY() - 1, selectedPolygon.vertices[0].getZ() - 1, Camera.getSelectedColor());
            cubes.add(c);
        }

        if (selectedPolygon.type == "RIGHT") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX(), selectedPolygon.vertices[0].getY(), selectedPolygon.vertices[0].getZ(), Camera.getSelectedColor());
            cubes.add(c);
        }

        if (selectedPolygon.type == "TOP") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX(), selectedPolygon.vertices[0].getY(), selectedPolygon.vertices[0].getZ(), Camera.getSelectedColor());
            cubes.add(c);
        }

        if (selectedPolygon.type == "BOTTOM") {
            Cube c = new Cube(selectedPolygon.vertices[0].getX(), selectedPolygon.vertices[0].getY() - 1, selectedPolygon.vertices[0].getZ(), Camera.getSelectedColor());
            cubes.add(c);
        }
    }

    public void removeBlock(Polygon3D selectedPolygon) {
        if (selectedPolygon.type == "FRONT") {
            cubes.remove(selectedPolygon.cube);
        }

        if (selectedPolygon.type == "BACK") {
            cubes.remove(selectedPolygon.cube);
        }

        if (selectedPolygon.type == "LEFT") {
            cubes.remove(selectedPolygon.cube);
        }

        if (selectedPolygon.type == "RIGHT") {
            cubes.remove(selectedPolygon.cube);
        }

        if (selectedPolygon.type == "TOP") {
            cubes.remove(selectedPolygon.cube);
        }

        if (selectedPolygon.type == "BOTTOM") {
            cubes.remove(selectedPolygon.cube);
        }
    }

    public Screen() {
        super();

        horizontala = new Line2D.Double();
        verticala = new Line2D.Double();
        horizontalb = new Line2D.Double();
        verticalb = new Line2D.Double();
        /**
         * MAYBE +1
         */
        horizontala.setLine(0 - 1000, Main.ScreenSize.getHeight() / 2, Main.ScreenSize.getWidth() / 2, Main.ScreenSize.getHeight() / 2);
        verticala.setLine(Main.ScreenSize.getWidth() / 2, 0 - 1000, Main.ScreenSize.getWidth() / 2, Main.ScreenSize.getHeight() / 2);
        horizontalb.setLine(Main.ScreenSize.getWidth() / 2, Main.ScreenSize.getHeight() / 2, Main.ScreenSize.getWidth() + 1000, Main.ScreenSize.getHeight() / 2);
        verticalb.setLine(Main.ScreenSize.getWidth() / 2, Main.ScreenSize.getHeight() / 2, Main.ScreenSize.getWidth() / 2, Main.ScreenSize.getHeight() + 1000);

        Random gen = new Random();


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cube c = new Cube(i, -1, j, new Color(154,205,50));
                cubes.add(c);


            }
        }

        for (int i = 0; i < 10; i++) {
            //Tree tree = new Tree(gen.nextInt(20), 0, gen.nextInt(20), cubes);
        }

        for (Cube c : cubes) {
            c.addPolygons();
        }


    }

}
