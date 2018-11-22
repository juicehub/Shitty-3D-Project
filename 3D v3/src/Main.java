import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static ArrayList<Polygon3D> polygons = new ArrayList<>();
    public static Screen screen = new Screen();
    final static int DELAY = 10;

    public Main() {
        super("3D");
        add(screen);
        addKeyListener(new KeyManager());
        addMouseListener(new MouseManager());
        addMouseWheelListener(new MouseWheelManager());
        setSize(ScreenSize);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Camera.setLocation(10, 20, 10);
        Camera.setSpeed(0.2);
        Camera.setSensitivity(0.0001);
        Camera.setSelectedColor(Color.yellow);

        ScreenThread thread = new ScreenThread(DELAY);
        thread.start();
        new Main();
    }

}
