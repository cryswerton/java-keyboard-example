import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PixelControlWithKeyboard {
    private static int pixelX = 200; // Initial X position
    private static int pixelY = 200; // Initial Y position
    private static final int PIXEL_SIZE = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pixel Control with Keyboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            PixelPanel pixelPanel = new PixelPanel();
            frame.add(pixelPanel);

            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();

                    switch (keyCode) {
                        case KeyEvent.VK_LEFT:
                            pixelX -= 5;
                            break;
                        case KeyEvent.VK_RIGHT:
                            pixelX += 5;
                            break;
                        case KeyEvent.VK_UP:
                            pixelY -= 5;
                            break;
                        case KeyEvent.VK_DOWN:
                            pixelY += 5;
                            break;
                    }
                    pixelPanel.repaint();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });

            frame.setFocusable(true);
            frame.requestFocus();

            frame.setVisible(true);
        });
    }

    static class PixelPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawPixel(g, pixelX, pixelY, Color.RED);
        }

        private void drawPixel(Graphics g, int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
}
