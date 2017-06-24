 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.awt.event.ActionEvent;
 import java.awt.AWTEvent;
 import java.util.EventObject;
 import java.util.Calendar;

public class GUI extends JFrame
{
    private JButton nazev1 = new JButton("New Idea");
    private JButton nazev2 = new JButton("New Idea");
    private JButton nazev3 = new JButton("New Idea");
    private JButton downButton = new JButton("▲");
    private JButton save;
    private JButton upButton = new JButton("▼");
    private static JLabel nazev = new JLabel("Writer 2.0");
    private JTextArea popisek;
    public String [] [] namety = {
                                 {"nazev1", "popisek1"},
                                 {"nazev2", "popisek2"},
                                 {"nazev3", "popisek3"},
                                 {"nazev4", "popisek4"},
                                 };
    public int index;
    private int indexPole = -1;
    private long [] time = new long [2]; 
    public GUI()
    {
        super("Writer 2.0");
        this.index = 0;
        this.setSize(300, 650);
        this.setResizable(true);
        Font f1 = new Font("Arial", Font.PLAIN, 60);
        Font f2 = new Font("Arial", Font.PLAIN, 40);
        this.nazev.setFont(f1);
        this.setLayout(new GridLayout(8, 1, 5, 15));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.RED);
        this.setVisible(true);
        this.add(nazev);
        this.nazev.setVisible(true);
        checkPole();
        this.namety [0] [0] = "nazev1";
        this.namety [0] [1] = "popisek1";
        this.nazev1.setText(this.namety [0] [0]);
        this.nazev2.setText(this.namety [1] [0]);
        this.nazev3.setText(this.namety [2] [0]);
        this.save = new JButton("Save");
        this.upButton.setFont(f2);
        this.nazev1.setFont(f2);
        this.nazev2.setFont(f2);
        this.nazev3.setFont(f2);
        this.add(downButton);
        this.add(nazev1);
        this.add(nazev2);
        this.add(nazev3);
        this.add(upButton);
        this.downButton.setVisible(true);
        this.nazev1.setVisible(true);
        this.nazev2.setVisible(true);
        this.nazev3.setVisible(true);
        this.upButton.setVisible(true);
        this.popisek = new JTextArea("Write Idea");
        checkPole();
        this.add(popisek);
        this.add(save);
        this.save.setFont(f2);
        this.upButton.setFont(f1);
        this.popisek.setVisible(true);
        this.save.setVisible(true);
        this.downButton.setVisible(true);
        downButton.setFont(f1);
        index = 0;
        this.upButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                upIdea();
            }
        }
        );
        this.save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                prepis();
            }
        }
        );
        this.downButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                downIdea();
            }
        }
        );
        this.nazev1.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e)
            {
                indexPole = index;
                time [0] = e.getWhen();
            }
            public void mouseReleased(MouseEvent e)
            {
                time [1] = e.getWhen();
                checkTime(0);
            }
            public void mouseExited(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
        }
        );
        this.nazev2.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e)
            {
                indexPole = index + 1;
                time [0] = e.getWhen();
            }
            public void mouseReleased(MouseEvent e)
            {
                time [1] = e.getWhen();
                checkTime(1);
            }
            public void mouseExited(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
        }
        );
        this.nazev3.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e){}
            public void mousePressed(MouseEvent e)
            {
                indexPole = index + 2;
                time [0] = e.getWhen();
            }
            public void mouseReleased(MouseEvent e)
            {
                time [1] = e.getWhen();
                checkTime(2);
            }
            public void mouseExited(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
        }
        );
    }
    public void checkPole()
    {    
        String [] [] pole = namety;
        String [] [] souborPole = new String [0] [0];
        souborPole = Soubory.load();
        if(souborPole != null)
        {
            if(namety.equals(souborPole))
            {
                pole = namety;
            }
            else 
            {
                int a = namety.length;
                int b = souborPole.length;
                if(b > a)
                {
                    pole = souborPole;
                }
                else
                {
                        for(int i = 0; i < b; i++)
                        {
                            namety [i] = souborPole [i];
                        }
                        pole = namety;
                }
            }
        }
        else
        {
            popisek.setText("Load failed.");
        }
        namety = pole;
    }
    public void upIdea()
    {
        if (index < this.namety.length-3)
        {
            index++;
            this.nazev1.setText(this.namety [index] [0]);
            this.nazev2.setText(this.namety [index + 1] [0]);
            this.nazev3.setText(this.namety [index + 2] [0]);
        }
        else
        {
            if (index == this.namety.length-3)
            {
                index++;
                this.nazev1.setText(this.namety [index] [0]);
                this.nazev2.setText(this.namety [index + 1] [0]);
                this.nazev3.setText("New Idea");
            }
        }
    }
    public void downIdea()
    {
        if (index >= 1)
        {
            index--;
            this.nazev1.setText(this.namety [index] [0]);
            this.nazev2.setText(this.namety [index + 1] [0]);
            this.nazev3.setText(this.namety [index + 2] [0]);
        }
    }
    public void vypis(int b)
    {
        String a;
        if(b == 2)
        {
            a = this.nazev1.getText();
            for(int i = 0; i < this.namety.length; i++)
            {
                if(a.equals(this.namety [i] [0]))
                {
                    this.indexPole = i;
                }
            }
        }
        if(b == 3)
        {
            a = this.nazev2.getText();
            for(int i = 0; i < namety.length; i++)
            {
                if(a.equals(namety [i] [0]))
                {
                    indexPole = i;
                }
            }
        }
        if(b == 4)
        {
            a = nazev3.getText();
            for(int i = 0; i < namety.length; i++)
            {
                if(a.equals(namety [i] [0]))
                {
                    indexPole = i;
                }
                else
                {
                    if (a.equals("New Idea"))
                    {
                        //VlaknoAddIdea.metoda();
                        //while(New.Nazev == null)
                        //{}
                        //String [] [] Pole = new String [namety.length + 1] [2];
                        //for (int j = 0; j < Pole.length; j++)
                        //{
                        //    Pole [j] = namety [j];
                        //}
                        //Pole [namety.length] [0] = New.Nazev;
                        //namety = Pole;
                        //nazev3.setText(New.Nazev);
                    }
                }
            }
        }
        popisek.setText(namety [indexPole] [1]);
    }
    public void prepis()
    {
        if(indexPole >= 0)
        {
            String a = popisek.getText();
            namety [indexPole] [2] = a;
            Soubory.save(namety);
        }
    }
    public void checkTime(int a)
    {
        if(a != 2)
        {
            if(time [1] >= time [0] + 1000)
            {
                EditTitle b = new EditTitle(namety, index, a);
            }
            else
            {
                vypis(a);
            }
        }
        else
        {
            if(nazev3.getText() == "New Idea")
            {
                if(time [1] >= time [0] + 1000)
                {
                    AddIdea b = new AddIdea(namety, index);
                }
                else
                {
                    popisek.setText("Write Idea");
                }
            }
            else
            {
                if(time [1] >= time [0] + 1000)
                {
                    EditTitle b = new EditTitle(namety, index, a);
                }
                else
                {
                    vypis(a);
                }
            }
        }
    }
}
