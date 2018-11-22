import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelManager implements MouseWheelListener {
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();

        if (notches < 0) {
            // mouse wheel moved down
            Camera.nextColor(1);

        }

        else {
            Camera.nextColor(-1);
        }

    }
}
