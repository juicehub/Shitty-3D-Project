import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    static boolean SHIFT, W, SPACE, A, S, D, Right, Left, Up, Down;


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {
            SHIFT = true;
        }

        if (key == KeyEvent.VK_W) {
            W = true;
        }

        if (key == KeyEvent.VK_SPACE) {
            SPACE = true;
        }

        if (key == KeyEvent.VK_A) {
            A = true;
        }

        if (key == KeyEvent.VK_S) {
            S = true;
        }

        if (key == KeyEvent.VK_D) {
            D = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            Right = true;
        }

        if (key == KeyEvent.VK_LEFT) {
            Left = true;
        }

        if (key == KeyEvent.VK_UP) {
            Up = true;
        }

        if (key == KeyEvent.VK_DOWN) {
            Down = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SHIFT) {
            SHIFT = false;
        }

        if (key == KeyEvent.VK_W) {
            W = false;
        }

        if (key == KeyEvent.VK_SPACE) {
            SPACE = false;
        }

        if (key == KeyEvent.VK_A) {
            A = false;
        }

        if (key == KeyEvent.VK_S) {
            S = false;
        }

        if (key == KeyEvent.VK_D) {
            D = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            Right = false;
        }

        if (key == KeyEvent.VK_LEFT) {
            Left = false;
        }

        if (key == KeyEvent.VK_UP) {
            Up = false;
        }

        if (key == KeyEvent.VK_DOWN) {
            Down = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
