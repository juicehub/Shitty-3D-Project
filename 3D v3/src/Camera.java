import java.awt.*;

public class Camera {

    static double x, y, z;
    static double yaw, pitch;
    static double speed, sensitivity;
    static Polygon3D selectedPolygon;
    static Color selectedColor;
    static Color[] colors = new Color[]{Color.red, new Color(154,205,50), Color.yellow, Color.black, new Color(139,69,19), Color.cyan, Color.white, Color.gray, Color.darkGray, Color.lightGray, new Color(0, 0, 255)};
    static int colorsIndex;

    public static Location getLocation() {
        Location location = new Location(x, y, z);
        return location;
    }

    public static void nextColor(int d) {
        colorsIndex += d;
        if (colorsIndex == colors.length) colorsIndex = 0;
        if (colorsIndex < 0) colorsIndex = colors.length - 1;

        setSelectedColor(colors[colorsIndex]);
    }

    public static void setLocation(Location location) {
        Camera.x = location.getX();
        Camera.y = location.getY();
        Camera.z = location.getZ();
    }

    public static Color getSelectedColor() {
        return selectedColor;
    }

    public static void setSelectedColor(Color selectedColor) {
        Camera.selectedColor = selectedColor;
    }

    public static void setLocation(double x, double y, double z) {
        Camera.x = x;
        Camera.y = y;
        Camera.z = z;
    }

    public static Polygon3D getSelectedPolygon() {
        return selectedPolygon;
    }

    public static void setSelectedPolygon(Polygon3D selectedPolygon) {
        Camera.selectedPolygon = selectedPolygon;
    }

    public static double getSpeed() {
        return speed;
    }

    public static void setSpeed(double speed) {
        Camera.speed = speed;
    }

    public static double getSensitivity() {
        return sensitivity;
    }

    public static void setSensitivity(double sensitivity) {
        Camera.sensitivity = sensitivity;
    }

    public static double getX() {
        return x;
    }
    public static void setX(double x) {
        Camera.x = x;
    }
    public static double getY() {
        return y;
    }
    public static void setY(double y) {
        Camera.y = y;
    }
    public static double getZ() {
        return z;
    }
    public static void setZ(double z) {
        Camera.z = z;
    }
    public static double getYaw() {
        return yaw;
    }
    public static void setYaw(double yaw) {
        Camera.yaw = yaw;
    }
    public static double getPitch() {
        return pitch;
    }
    public static void setPitch(double pitch) {
        Camera.pitch = pitch;
    }



}
