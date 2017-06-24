 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.awt.event.ActionEvent;
 import java.awt.AWTEvent;
 import java.util.EventObject;

public class AddIdea extends JFrame
{
    private static JLabel nazev = new JLabel("Add Idea");
    private static JLabel addNazev = new JLabel("Title:");
    private JTextField novyNazev;
    private JButton save;
    private String [] [] namety = new String [0] [0];
    public String Nazev;
    public AddIdea(String [] [] namety, int index)
    {
        super("Add Idea");
        setSize(100, 150);
        setResizable(false);
        this.setLayout(new GridLayout(4, 1, 5, 5));
        this.setVisible(true);
        this.add(nazev);
        this.add(addNazev);
        novyNazev = new JTextField(10);
        this.add(novyNazev);
        save = new JButton("Save");
        this.add(save);
        nazev.setVisible(true);
        addNazev.setVisible(true);
        novyNazev.setVisible(true);
        save.setVisible(true);
        this.namety = namety;
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                copyIdea();
            }
        }
        );
    }
    public void copyIdea()
    {
        namety = Soubory.load();
        String nazev = novyNazev.getText();
        int a = namety.length;
        String [] [] pole = new String [a + 1] [2];
        for(int i = 0; i < a; i++)
        {
            pole [i] = namety [i];
        }
        namety = pole;
        Soubory.save(namety);
        this.setVisible(false);
    }
}
