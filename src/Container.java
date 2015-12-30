import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Container {
    private final int GB_HEIGHT = (int) GameBoard.getDimension().getHeight();
    private final int GB_WIDTH = (int) GameBoard.getDimension().getWidth();
    private final int BOTTOM_HEIGHT = 20;

    private final GameBoard gameBoard;
    private final JFrame background;
    private final JButton pauseButton;
    private final JButton quitButton;
    private final JButton restartButton;
    private final JLabel score;

    Container() {

        background = new JFrame("Snake Game");
        gameBoard = new GameBoard(this);

        KeyboardControl control = new KeyboardControl(gameBoard);
        JPanel bottom = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new BorderLayout());

        background.setSize(new Dimension(GB_WIDTH, GB_HEIGHT + BOTTOM_HEIGHT));
        background.getContentPane().setBackground(Color.white);
        background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background.setVisible(true);
        background.setResizable(false);

        background.add(control);
        background.add(gameBoard, BorderLayout.CENTER);

        pauseButton = new JButton("Pause");
        quitButton = new JButton("Quit");
        restartButton = new JButton("Restart");
        bottom.add(pauseButton, BorderLayout.WEST);
        
        bottom.add(quitButton, BorderLayout.EAST);
        restartButton.setFocusable(false);
        pauseButton.setFocusable(false);
        quitButton.setFocusable(false);

        score = new JLabel("score: " + gameBoard.getScore() + " \t");
        top.add(score, BorderLayout.EAST);

        bottom.setBackground(Color.white);
        background.getContentPane().add(bottom, BorderLayout.SOUTH);
        background.getContentPane().add(top, BorderLayout.NORTH);

        if (Snake.isDead())
            pauseButton.setEnabled(false);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                restartButton.setEnabled(false);
                restartButton.setVisible(false);

                if (gameBoard.isRunning()) {
                    gameBoard.stop();
                    pauseButton.setText("Start");

                } else {
                    gameBoard.start();
                    pauseButton.setText("Pause");
                }
                gameBoard.setRunning(!gameBoard.isRunning());

            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void dispose() {
        System.exit(0);
    }

    public void updateScore() {
        score.setText("score: " + gameBoard.getScore() + " \t");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Container();
            }
        });
    }
}