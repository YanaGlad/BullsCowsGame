import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame {
    static Image img = new ImageIcon("Res/bulz.png").getImage();
    static Image mainBckg = new ImageIcon("Res/cows.png").getImage();
    static boolean clicked = false;

    public static void main(String[] args) {

        MainFrame mainFrame;
        mainFrame = new MainFrame();
        mainFrame.setSize(700, 440);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        MainFrame.button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                clicked = true;
                MainFrame mainFrame2;
                mainFrame2 = new MainFrame();
                mainFrame2.setSize(700, 440);
                mainFrame2.setResizable(false);
                mainFrame2.setLocationRelativeTo(null);
                mainFrame2.setVisible(true);
            }
        });


    }

}


class Backg extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!Main.clicked)
            g.drawImage(Main.img, 0, 0, null);
        else
            g.drawImage(Main.mainBckg, 0, 0, null);
    }
}

class MainFrame extends JFrame {
      static JButton button, ok, tro, restart;
    String num;
    private static ArrayList<JButton> buttons = new ArrayList<>(9);
    private static JTextField textField, textFieldF, textFieldF2, textFieldF3;

    MainFrame() {

        setContentPane(new Backg());

        Container container = getContentPane();
        Font font = new Font("Arial", Font.BOLD, 20);

        if (!Main.clicked) {
            container.setLayout(null);
            button = new JButton("Начать игру");
            button.setFont(font);
            button.setSize(200, 50);
            button.setLocation(240, 70);
            container.add(button);
        } else {
            System.out.println("YES");
            container.setLayout(null);

            int startX = 100, startY = 70;

            for (int i = 0; i < 9; i++) {
                buttons.add(new JButton(String.valueOf(i + 1)));

                buttons.get(i).setLocation(startX, startY);
                buttons.get(i).setFont(font);
                if ((i + 1) % 3 == 0) {
                    startY += 70;
                    startX = 100;
                } else {
                    startX += 70;
                }
                buttons.get(i).setSize(50, 50);

                int finalI = i;
                buttons.get(i).addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (textField.getText().length() < 4) {
                            textField.setText(textField.getText() + buttons.get(finalI).getText());
                        }
                    }
                });

                container.add(buttons.get(i));
            }
            tro = new JButton("0");
            tro.setSize(50, 50);
            tro.setLocation(170, 280);
            tro.setFont(font);

            tro.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (textField.getText().length() < 4) {
                        textField.setText(textField.getText() + tro.getText());
                    }
                }
            });
            container.add(tro);


            Font fontz = new Font("Arial", Font.BOLD, 20);

            ok = new JButton("ok");
            ok.setFont(fontz);
            ok.setSize(70, 50);
            ok.setLocation(595, 40);
            container.add(ok);

            Font font1 = new Font("Arial", Font.BOLD, 40);
            textField = new JTextField();
            textField.setLocation(425, 40);
            textField.setSize(150, 50);
            textField.setHorizontalAlignment(SwingConstants.CENTER);
            textField.setFont(font1);
            textField.setEnabled(false);
            container.add(textField);

            textFieldF = new JTextField();
            textFieldF.setLocation(420, 110);
            textFieldF.setSize(60, 60);
            textFieldF.setFont(font);
            textFieldF.setHorizontalAlignment(SwingConstants.CENTER);
            textFieldF.setEnabled(false);
            container.add(textFieldF);

            textFieldF2 = new JTextField();
            textFieldF2.setLocation(520, 110);
            textFieldF2.setSize(60, 60);
            textFieldF2.setFont(font);
            textFieldF2.setHorizontalAlignment(SwingConstants.CENTER);
            textFieldF2.setEnabled(false);
            container.add(textFieldF2);

            Font foo = new Font("Arial", Font.BOLD, 50);

            textFieldF3 = new JTextField("* * * *");
            textFieldF3.setLocation(425, 310);
            textFieldF3.setSize(150, 50);
            textFieldF3.setDisabledTextColor(Color.BLACK);
            textFieldF3.setFont(foo);
            textFieldF3.setHorizontalAlignment(SwingConstants.CENTER);
            textFieldF3.setEnabled(false);
            container.add(textFieldF3);

            Random rnd = new Random();

            restart = new JButton("Play again");
            restart.setFont(font);
            restart.setSize(200, 40);
            restart.setLocation(400, 200);

            restart.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = rnd.nextInt(10);
                    int b = rnd.nextInt(10);
                    int c = rnd.nextInt(10);
                    int d = rnd.nextInt(10);

                    while (b == a || b == c || b == d) b = rnd.nextInt(10);

                    while (c == a || c == b || c == d) c = rnd.nextInt(10);

                    while (d == b || d == c || d == a) d = rnd.nextInt(10);

                    int finalB = b;
                    int finalC = c;
                    int finalD = d;

                    num += a + "" + finalB + "" + finalC + "" + finalD + "";
                    System.out.println(num);
                    textFieldF3.setText("* * * *");

                    restart.setVisible(false);
                }
            });
            restart.setVisible(false);
            container.add(restart);


            int a = rnd.nextInt(10);
            int b = rnd.nextInt(10);
            int c = rnd.nextInt(10);
            int d = rnd.nextInt(10);

            while (b == a || b == c || b == d) b = rnd.nextInt(10);

            while (c == a || c == b || c == d) c = rnd.nextInt(10);

            while (d == b || d == c || d == a) d = rnd.nextInt(10);


            int finalB = b;
            int finalC = c;
            int finalD = d;

            BullsCows bb = new BullsCows();
            num = "" + a + "" + finalB + "" + finalC + "" + finalD + "";
            System.out.println(num);


            ok.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int[] answer = bb.checkBullCow(String.valueOf(num).toCharArray(), MainFrame.textField.getText().toCharArray());

                    MainFrame.textFieldF.setText(String.valueOf(answer[0]));
                    MainFrame.textFieldF2.setText(String.valueOf(answer[1]));
                    textField.setText("");
                    if (answer[0] == 4) {
                        textFieldF3.setText(num);
                        num = "";
                        restart.setVisible(true);
                    }

                }
            });

        }
    }

}
