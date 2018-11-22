import java.util.ArrayList;

public class Calculator {
    public static Location calculateScreenLocation(Location view, double yaw, double pitch, Vertex vertex) {
        double cx = view.getX();
        double cy = view.getY();
        double cz = view.getZ();

        double cos_yaw = Math.cos(Math.toDegrees(yaw));
        double cos_pitch = Math.cos(Math.toDegrees(pitch));
        double sin_yaw = Math.sin(Math.toDegrees(yaw));
        double sin_pitch = Math.sin(Math.toDegrees(pitch));

        double x = (cx - vertex.getX()) * cos_yaw - (cz - vertex.getZ()) * sin_yaw;
        double z = (cz - vertex.getZ()) * cos_yaw + (cx - vertex.getX()) * sin_yaw;
        double y = (cy - vertex.getY()) * cos_pitch - z * sin_pitch;
        z = z * cos_pitch + (cy - vertex.getY()) * sin_pitch;

        int width = (int) Main.ScreenSize.getWidth();
        int height = (int) Main.ScreenSize.getHeight();

        double f = (width / 2) / z;
        int rx = (int) (x * f) + (width / 2);
        int ry = (int) (y * f) + (height / 2);

        return new Location(rx, ry);

    }

    public static double calculateDepth(Location from, double yaw, double pitch, Location to) {
        double fx = from.getX();
        double fy = from.getY();
        double fz = from.getZ();

        double tx = to.getX();
        double ty = to.getY();
        double tz = to.getZ();

        double cos_yaw = Math.cos(Math.toDegrees(yaw));
        double cos_pitch = Math.cos(Math.toDegrees(pitch));
        double sin_yaw = Math.sin(Math.toDegrees(yaw));
        double sin_pitch = Math.sin(Math.toDegrees(pitch));

        double x = (fx - tx) * cos_yaw - (fz - tz) * sin_yaw;
        double z = (fz - tz) * cos_yaw + (fx - tx) * sin_yaw;
        double y = (fy - ty) * cos_pitch - z * sin_pitch;
        z = z * cos_pitch + (fy - ty) * sin_pitch;

        return z;
    }

    public static double calculateDistance(Location from, Polygon3D to) {

        double total = 0;

        for (Vertex vertex : to.vertices) {
            double dx = from.getX() - vertex.getX();
            double dy = from.getY() - vertex.getY();
            double dz = from.getZ() - vertex.getZ();

            double d = Math.sqrt(dx*dx + dy*dy + dz*dz);
            total += d;
        }

        double distance = total / to.vertices.length;

        return distance;
    }

    public static ArrayList<Polygon3D> sortPolygons(ArrayList<Polygon3D> polygons) {
        Polygon3D temp;

        for (Polygon3D p : polygons) {

            /**double ax = 0, ay = 0, az = 0;

            for (Vertex v : p.vertices) {
                ax += v.x;
                ay += v.y;
                az += v.z;
            }

            ax /= 8;
            ay /= 8;
            az /= 8;**/


            p.distance = calculateDistance(Camera.getLocation(), p);
            //p.distance = calculateDepth(Camera.getLocation(), Camera.yaw, Camera.pitch, new Location(ax, ay, az));



        }

        for (int i = 1; i < polygons.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(polygons.get(j).distance > polygons.get(j - 1).distance){
                    temp = polygons.get(j);
                    polygons.set(j, polygons.get(j - 1));
                    polygons.set(j - 1, temp);

                }
            }
        }
        return polygons;
    }

}
