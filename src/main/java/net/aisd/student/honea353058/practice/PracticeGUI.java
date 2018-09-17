package net.aisd.student.honea353058.practice;

import org.encog.ml.data.basic.BasicMLData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PracticeGUI extends JFrame implements Runnable {

    private double calculate;

    public PracticeGUI(Practice practice) {

        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                calculate = practice.network.compute(new BasicMLData(new double[]{e.getY() / (double) getWidth()})).getData(0);

                System.out.println(calculate + " - " + (e.getY() / (double) getWidth()));

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setContentPane(new JPanel() {

            @Override
            public void paint(Graphics g) {

                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

                g.drawString("" + calculate, getWidth() / 2, getHeight() / 2);


            }
        });

        setVisible(true);

        new Thread(this::run).start();

    }

    @Override
    public void run() {

        while (true) {

            try {

                repaint();

                Thread.sleep(1000 / 30);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
