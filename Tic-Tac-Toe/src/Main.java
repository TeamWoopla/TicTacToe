import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main extends JPanel {

    public static JFrame startframe = new JFrame("TicTacToe");
    public static JFrame PVAIframe = new JFrame("Player Versus AI");
    public static JFrame PVPframe = new JFrame("Player Versus Player");


    public static JLabel Xwin = new JLabel("X WON!");
    public static JLabel Owin = new JLabel("O WON!");

    private JButton b1 = new JButton(" ");
    private JButton b2 = new JButton(" ");
    private JButton b3 = new JButton(" ");
    private JButton b4 = new JButton(" ");
    private JButton b5 = new JButton(" ");
    private JButton b6 = new JButton(" ");
    private JButton b7 = new JButton(" ");
    private JButton b8 = new JButton(" ");
    private JButton b9 = new JButton(" ");
    private boolean Xtrun = true;
    public static boolean DestroyPVP = false;

    private Main() {
        JPanel panel1 = new JPanel(new GridLayout(3, 3));

        b1.setFont(new Font("Arial", Font.PLAIN, 40));
        b2.setFont(new Font("Arial", Font.PLAIN, 40));
        b3.setFont(new Font("Arial", Font.PLAIN, 40));
        b4.setFont(new Font("Arial", Font.PLAIN, 40));
        b5.setFont(new Font("Arial", Font.PLAIN, 40));
        b6.setFont(new Font("Arial", Font.PLAIN, 40));
        b7.setFont(new Font("Arial", Font.PLAIN, 40));
        b8.setFont(new Font("Arial", Font.PLAIN, 40));
        b9.setFont(new Font("Arial", Font.PLAIN, 40));

        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);
        b8.setBackground(Color.WHITE);
        b9.setBackground(Color.WHITE);

        b1.setBorder(new LineBorder(new Color(0, 0, 0)));
        b2.setBorder(new LineBorder(new Color(0, 0, 0)));
        b3.setBorder(new LineBorder(new Color(0, 0, 0)));
        b4.setBorder(new LineBorder(new Color(0, 0, 0)));
        b5.setBorder(new LineBorder(new Color(0, 0, 0)));
        b6.setBorder(new LineBorder(new Color(0, 0, 0)));
        b7.setBorder(new LineBorder(new Color(0, 0, 0)));
        b8.setBorder(new LineBorder(new Color(0, 0, 0)));
        b9.setBorder(new LineBorder(new Color(0, 0, 0)));

        b1.setFocusable(true);
        b2.setFocusable(true);
        b3.setFocusable(true);
        b4.setFocusable(true);
        b5.setFocusable(true);
        b6.setFocusable(true);
        b7.setFocusable(true);
        b8.setFocusable(true);
        b9.setFocusable(true);

        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        panel1.add(b5);
        panel1.add(b6);
        panel1.add(b7);
        panel1.add(b8);
        panel1.add(b9);

        ButtonListener listener = new ButtonListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);
        b8.addActionListener(listener);
        b9.addActionListener(listener);

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        startframe.setResizable(false);
        startframe.setSize(500, 500);
        startframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startframe.setVisible(true);
        JButton b11 = new JButton("Player Versus Player");
        JButton b22 = new JButton("Player Versus AI");
        JLabel hello = new JLabel("Please Pick One :");
        Xwin.setFont(new Font("Arial", Font.PLAIN, 40));
        Owin.setFont(new Font("Arial", Font.PLAIN, 40));
        Xwin.setBounds(250, 10, 500, 110);
        Owin.setBounds(250, 10, 500, 110);
        b11.setFont(new Font("Arial", Font.PLAIN, 40));
        b22.setFont(new Font("Arial", Font.PLAIN, 40));
        hello.setFont(new Font("Arial", Font.PLAIN, 20));
        b11.setBackground(Color.WHITE);
        b22.setBackground(Color.WHITE);
        b11.setBorder(new LineBorder(new Color(51, 153, 255)));
        b22.setBorder(new LineBorder(new Color(51, 153, 255)));
        startframe.setLayout(null);
        hello.setBounds(50, 10, 400, 100);
        b11.setBounds(50, 100, 400, 100);
        b22.setBounds(50, 250, 400, 100);
        startframe.add(b11);
        startframe.add(b22);
        startframe.add(hello);
        b11.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    PVPframe.getContentPane().removeAll();
                    PVPframe.add(new Main());
                    PVPframe.setSize(500, 500);
                    PVPframe.setVisible(true);
                    PVPframe.setResizable(false);
                    startframe.setVisible(false);
                }
            }
        });
        b22.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    PVAIframe.getContentPane().removeAll();
                    PVAIframe.add(new AI());
                    PVAIframe.setSize(500, 500);
                    PVAIframe.setVisible(true);
                    PVAIframe.setResizable(false);
                    startframe.setVisible(false);
                }
            }
        });

    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                if (Xtrun) {
                    b1.setText("X");
                } else {
                    b1.setText("O");
                }
                Xtrun = !Xtrun;
                b1.removeActionListener(this);
            } else if (e.getSource() == b2) {
                if (Xtrun) {
                    b2.setText("X");
                } else {
                    b2.setText("O");
                }
                Xtrun = !Xtrun;
                b2.removeActionListener(this);

            } else if (e.getSource() == b3) {
                if (Xtrun) {
                    b3.setText("X");
                } else {
                    b3.setText("O");
                }
                Xtrun = !Xtrun;
                b3.removeActionListener(this);

            } else if (e.getSource() == b4) {
                if (Xtrun) {
                    b4.setText("X");
                } else {
                    b4.setText("O");
                }
                Xtrun = !Xtrun;
                b4.removeActionListener(this);

            } else if (e.getSource() == b5) {
                if (Xtrun) {
                    b5.setText("X");
                } else {
                    b5.setText("O");
                }
                Xtrun = !Xtrun;
                b5.removeActionListener(this);

            } else if (e.getSource() == b6) {
                if (Xtrun) {
                    b6.setText("X");
                } else {
                    b6.setText("O");
                }
                Xtrun = !Xtrun;
                b6.removeActionListener(this);

            } else if (e.getSource() == b7) {
                if (Xtrun) {
                    b7.setText("X");
                } else {
                    b7.setText("O");
                }
                Xtrun = !Xtrun;
                b7.removeActionListener(this);

            } else if (e.getSource() == b8) {
                if (Xtrun) {
                    b8.setText("X");
                } else {
                    b8.setText("O");
                }
                Xtrun = !Xtrun;
                b8.removeActionListener(this);

            } else if (e.getSource() == b9) {
                if (Xtrun) {
                    b9.setText("X");
                } else {
                    b9.setText("O");
                }
                Xtrun = !Xtrun;
                b9.removeActionListener(this);
            }
            if ((b1.getText().equals("X")) && (b2.getText().equals("X")) && (b3.getText().equals("X")) ||
                    (b4.getText().equals("X")) && (b5.getText().equals("X")) && (b6.getText().equals("X")) ||
                    (b7.getText().equals("X")) && (b8.getText().equals("X")) && (b9.getText().equals("X")) ||
                    (b1.getText().equals("X")) && (b4.getText().equals("X")) && (b7.getText().equals("X")) ||
                    (b2.getText().equals("X")) && (b5.getText().equals("X")) && (b8.getText().equals("X")) ||
                    (b3.getText().equals("X")) && (b6.getText().equals("X")) && (b9.getText().equals("X")) ||
                    (b1.getText().equals("X")) && (b5.getText().equals("X")) && (b9.getText().equals("X")) ||
                    (b3.getText().equals("X")) && (b5.getText().equals("X")) && (b7.getText().equals("X"))) {
                startframe.setVisible(true);
                Owin.setVisible(false);
                startframe.add(Xwin);
                Xwin.setVisible(true);

            } else if ((b1.getText().equals("O")) && (b2.getText().equals("O")) && (b3.getText().equals("O")) ||
                    (b4.getText().equals("O")) && (b5.getText().equals("O")) && (b6.getText().equals("O")) ||
                    (b7.getText().equals("O")) && (b8.getText().equals("O")) && (b9.getText().equals("O")) ||
                    (b1.getText().equals("O")) && (b4.getText().equals("O")) && (b7.getText().equals("O")) ||
                    (b2.getText().equals("O")) && (b5.getText().equals("O")) && (b8.getText().equals("O")) ||
                    (b3.getText().equals("O")) && (b6.getText().equals("O")) && (b9.getText().equals("O")) ||
                    (b1.getText().equals("O")) && (b5.getText().equals("O")) && (b9.getText().equals("O")) ||
                    (b3.getText().equals("O")) && (b5.getText().equals("O")) && (b7.getText().equals("O"))) {
                startframe.setVisible(true);
                Xwin.setVisible(false);
                Owin.setVisible(true);
                startframe.add(Owin);
            }

        }
    }
}