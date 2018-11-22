import java.awt.*;

public class ScreenThread extends Thread {

    int delay;
    Robot robot;

    public ScreenThread(int delay) {
        this.delay = delay;
    }

    public void run() {
        while (true) {

            if (KeyManager.W) {
                Camera.z -= Math.cos(Math.toDegrees(Camera.yaw)) * Camera.speed;
                Camera.x -= Math.sin(Math.toDegrees(Camera.yaw)) * Camera.speed;
            }

            if (KeyManager.S) {
                Camera.z += Math.cos(Math.toDegrees(Camera.yaw)) * Camera.speed;
                Camera.x += Math.sin(Math.toDegrees(Camera.yaw)) * Camera.speed;
            }

            if (KeyManager.A) {
                Camera.z -= Math.sin(Math.toDegrees(Camera.yaw)) * Camera.speed;
                Camera.x += Math.cos(Math.toDegrees(Camera.yaw)) * Camera.speed;
            }

            if (KeyManager.D) {
                Camera.z += Math.sin(Math.toDegrees(Camera.yaw)) * Camera.speed;
                Camera.x -= Math.cos(Math.toDegrees(Camera.yaw)) * Camera.speed;
            }

            if (KeyManager.SHIFT) {
                Camera.y -= Camera.speed;
            }

            if (KeyManager.SPACE) {
                Camera.y += Camera.speed;
            }

            if (KeyManager.Right) {
                Camera.yaw += Camera.sensitivity;
            }

            if (KeyManager.Left) {
                Camera.yaw -= Camera.sensitivity;
            }

            if (KeyManager.Up) {
                Camera.pitch -= Camera.sensitivity;
            }

            if (KeyManager.Down) {
                Camera.pitch += Camera.sensitivity;
            }



            int mousex = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int mousey = (int) MouseInfo.getPointerInfo().getLocation().getY();

            int dx = (int) (Main.ScreenSize.getWidth() / 2) - mousex;
            int dy = (int) (Main.ScreenSize.getHeight() / 2) - mousey;

            {
                try {
                    robot = new Robot();
                    robot.mouseMove((int) Main.ScreenSize.getWidth() / 2, (int) Main.ScreenSize.getHeight() / 2);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }

            Camera.yaw -= dx * Camera.sensitivity;
            Camera.pitch -= dy * Camera.sensitivity;

            Main.screen.repaint();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
