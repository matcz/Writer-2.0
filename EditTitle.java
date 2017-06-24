 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.awt.event.ActionEvent;
 import java.awt.AWTEvent;
 import java.util.EventObject;

public class EditTitle extends JFrame
{
    private static JLabel nazev = new JLabel("Edit Title");
    private static JLabel newTitle = new JLabel("Title:");
    private JTextField newTitleText;
    private JButton save;
    private String [] [] namety = new String [0] [0];
    private int index;
    public EditTitle(String [] [] namety, int index, int a)
    {
        super("Edit Title");
        setSize(100, 150);
        setResizable(false);
        this.setLayout(new GridLayout(4, 1, 5, 5));
        this.setVisible(true);
        this.add(nazev);
        this.add(newTitle);
        newTitleText = new JTextField(10);
        this.add(newTitleText);
        save = new JButton("Save");
        this.add(save);
        nazev.setVisible(true);
        newTitle.setVisible(true);
        newTitleText.setVisible(true);
        save.setVisible(true);
        this.namety = namety;
        this.index = index + a;
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                editTitle();
            }
        }
        );
    }
    public void editTitle()
    {
        String a = newTitleText.getText();
        namety [index] [0] = a;
        Soubory.save(namety);
    }
}
