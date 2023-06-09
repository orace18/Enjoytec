package bj.orace.testdevariable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

    public class Game extends JPanel implements KeyListener {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;

        private int playerX = 100;
        private int playerY = 100;

        public Game() {
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setBackground(Color.BLACK);
            setFocusable(true);
            addKeyListener(this);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillOval(playerX, playerY, 50, 50);
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                playerX -= 10;
            } else if (key == KeyEvent.VK_RIGHT) {
                playerX += 10;
            } else if (key == KeyEvent.VK_UP) {
                playerY -= 10;
            } else if (key == KeyEvent.VK_DOWN) {
                playerY += 10;
            }
            repaint();
        }

        public void keyTyped(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {}

        public static void main(String[] args) {
            JFrame frame = new JFrame("Game");
            Game game = new Game();
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

