import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class AI extends JPanel {

    private JButton[][] Button = new JButton[3][3];

    AI() {
        JPanel panel1 = new JPanel(new GridLayout(3, 3));
        AI.BL listener = new AI.BL();

        for (int i = 0, j = 0 ; i < 3; j++) {
            Button[i][j] = new JButton(String.valueOf(" "));
            Button[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
            Button[i][j].setBackground(Color.WHITE);
            Button[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
            panel1.add(Button[i][j]);
            Button[i][j].addActionListener(listener);
            if (j == 2) {
                j = -1;
                i++;
            }
        }

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
    }

    private void WinCheck(){
        for (int i1 = 0; i1 < 3; i1++) {
            if ((Button[i1][0].getText().equals("X") && Button[i1][1].getText().equals("X") && Button[i1][2].getText().equals("X")) ||
                    (Button[0][i1].getText().equals("X") && Button[1][i1].getText().equals("X") && Button[2][i1].getText().equals("X"))){
                Main.startframe.setVisible(true);
                Main.Owin.setVisible(false);
                Main.startframe.add(Main.Xwin);
                Main.Xwin.setVisible(true);
                Main.DestroyPVP = true;
            }
        }
        if ((Button[0][0].getText().equals("X") && Button[1][1].getText().equals("X") && Button[2][2].getText().equals("X")) ||
                (Button[2][0].getText().equals("X") && Button[1][1].getText().equals("X") && Button[0][2].getText().equals("X"))){
            Main.startframe.setVisible(true);
            Main.Owin.setVisible(false);
            Main.startframe.add(Main.Xwin);
            Main.Xwin.setVisible(true);
            Main.DestroyPVP = true;
        }
        for (int i1 = 0; i1 < 3; i1++) {
            if ((Button[i1][0].getText().equals("O") && Button[i1][1].getText().equals("O") && Button[i1][2].getText().equals("O")) ||
                    (Button[0][i1].getText().equals("O") && Button[1][i1].getText().equals("O") && Button[2][i1].getText().equals("O"))){
                Main.startframe.setVisible(true);
                Main.Owin.setVisible(true);
                Main.startframe.add(Main.Owin);
                Main.Xwin.setVisible(false);
                Main.DestroyPVP = true;
            }
        }
        if ((Button[0][0].getText().equals("O") && Button[1][1].getText().equals("O") && Button[2][2].getText().equals("O")) ||
                (Button[2][0].getText().equals("O") && Button[1][1].getText().equals("O") && Button[0][2].getText().equals("O"))){
            Main.startframe.setVisible(true);
            Main.Owin.setVisible(true);
            Main.startframe.add(Main.Owin);
            Main.Xwin.setVisible(false);
            Main.DestroyPVP = true;
        }
    }

    class BL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0, j = 0 ; i < 3; j++) {
                if (e.getSource() == Button[i][j]) {
                    Button[i][j].setText("X");
                    Button[i][j].removeActionListener(this);
                }
                if (j == 2) {
                    j = -1;
                    i++;
                }
            }
            WinCheck();
            boolean placed = true;
            boolean continues = true;
            for (int i1 = 0, j1 = 0 ; i1 < 3; j1++) {
                for (int i2 = 0, j2 = 0; i2 < 3; j2++) {
                    if (Button[i1][j1].getText().equals("X") && Button[i2][j2].getText().equals("X")) {
                        if (!((i1 == i2) && (j1 == j2))) {
                            if (continues) {
                                if (j1 == j2) {
                                    for (int z = 0; z < 3; z++) {
                                        if (z != i1 && z != i2) {
                                            if (Button[z][j1].getText().equals(" ")) {
                                                Button[z][j1].setText("O");
                                                Button[z][j1].removeActionListener(this);
                                                placed = false;
                                                continues = false;
                                            }
                                        }
                                    }
                                }
                            }
                            if (continues) {
                                if (i1 == i2) {
                                    for (int z = 0; z < 3; z++) {
                                        if (z != j1 && z != j2) {
                                            if (Button[i1][z].getText().equals(" ")) {
                                                Button[i1][z].setText("O");
                                                Button[i1][z].removeActionListener(this);
                                                placed = false;
                                                continues = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (j2 == 2) {
                        j2 = -1;
                        i2++;
                    }
                }
                if (j1 == 2) {
                    j1 = -1;
                    i1++;
                }
            }
            if ((Button[0][0].getText().equals("X")) && (Button[1][1].getText().equals("X")) && continues ) {
                Button[2][2].setText("O");
                Button[2][2].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if ((Button[0][2].getText().equals("X")) && (Button[1][1].getText().equals("X")) && continues ) {
                Button[2][0].setText("O");
                Button[2][0].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if ((Button[2][0].getText().equals("X")) && (Button[1][1].getText().equals("X")) && continues ) {
                Button[0][2].setText("O");
                Button[0][2].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if ((Button[2][2].getText().equals("X")) && (Button[1][1].getText().equals("X")) && continues ) {
                Button[0][0].setText("O");
                Button[0][0].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if ((Button[2][2].getText().equals("X")) && (Button[0][0].getText().equals("X")) && continues ) {
                Button[1][1].setText("O");
                Button[1][1].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if ((Button[2][0].getText().equals("X")) && (Button[0][2].getText().equals("X")) && continues ) {
                Button[1][1].setText("O");
                Button[1][1].removeActionListener(this);
                placed = false;
                continues = false;
            }
            if (placed){
                System.out.println("RandomPlace");
                int[] check = new int[9];
                for (int i = 0; i < 9; i++){
                    boolean arraynum = true;
                    while (arraynum){
                        boolean arraynum2 = true;
                        Random rand = new Random();
                        check[i] = rand.nextInt(9) + 1;
                        for (int j = 0; j < i; j++){
                            if (check[i] == check[j]){
                                arraynum2 = false;
                            }
                        }
                        if (arraynum2){
                            arraynum = false;
                        }
                    }
                }
                for (int i = 0; i < 9; i++) {
                    switch (check[i]) {
                        case 1:
                            if (Button[0][0].getText().equals(" ")) {
                                Button[0][0].setText("O");
                                Button[0][0].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 2:
                            if (Button[1][0].getText().equals(" ")) {
                                Button[1][0].setText("O");
                                Button[1][0].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 3:
                            if (Button[2][0].getText().equals(" ")) {
                                Button[2][0].setText("O");
                                Button[2][0].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 4:
                            if (Button[0][1].getText().equals(" ")) {
                                Button[0][1].setText("O");
                                Button[0][1].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 5:
                            if (Button[1][1].getText().equals(" ")) {
                                Button[1][1].setText("O");
                                Button[1][1].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 6:
                            if (Button[2][1].getText().equals(" ")) {
                                Button[2][1].setText("O");
                                Button[2][1].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 7:
                            if (Button[0][2].getText().equals(" ")) {
                                Button[0][2].setText("O");
                                Button[0][2].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 8:
                            if (Button[1][2].getText().equals(" ")) {
                                Button[1][2].setText("O");
                                Button[1][2].removeActionListener(this);
                                i = 100;
                            }
                            break;
                        case 9:
                            if (Button[2][2].getText().equals(" ")) {
                                Button[2][2].setText("O");
                                Button[2][2].removeActionListener(this);
                                i = 100;
                            }
                            break;
                    }
                }
            }
            WinCheck();
        }
    }
}