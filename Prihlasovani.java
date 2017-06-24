 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;

public class Prihlasovani extends JFrame
{
    private static JLabel nazev = new JLabel("Prihlas se:");
    private static JLabel popUser = new JLabel("Uzivatelske jmeno");
    private JTextField username;
    private static JLabel popPass = new JLabel("Heslo");
    private JPasswordField password;
    private JButton signIn;
    private String jmeno;
    private String heslo;
    public Prihlasovani()
    {
        super("Writer 2.0");
        setSize(100, 200);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        username = new JTextField(10);
        password = new JPasswordField(10);
        signIn = new JButton("Prihlasit se");
        jmeno = "filip";
        heslo = "mazza";
        this.add(nazev);
        this.add(popUser);
        this.add(username);
        this.add(popPass);
        this.add(password);
        this.add(signIn);
        this.setVisible(true);
        nazev.setVisible(true);
        popUser.setVisible(true);
        username.setVisible(true);
        popPass.setVisible(true);
        password.setVisible(true);
        signIn.setVisible(true);
        signIn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                prihlaseni();
            }
        });
    }
    public void prihlaseni()
    {
        String hp = "";
        char [] hpch = password.getPassword();
        String ju = username.getText();
        for(int i = 0; i < hpch.length; i++)
        {
            hp = hp + hpch [i];
        }
        if (ju.equals(jmeno) && hp.equals(heslo))
        {
            this.setVisible(false);
            //Vlakna.VlaknoGUI a = new Vlakna.VlaknoGUI();
            //a.metoda();
        }
    }
}
