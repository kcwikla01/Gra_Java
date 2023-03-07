import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Game game=new Game();
        JFrame jf=new JFrame("GRA");
        jf.setBounds(200,200,700,600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.add(game);
    }
}