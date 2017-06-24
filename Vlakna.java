

public class Vlakna
{
    public class VlaknoGUI extends Thread
    {
        public VlaknoGUI()
        {super();}
        public void run()
        {
            GUI gui = new GUI();
        }
        public void metoda()
        {
            Thread Vlakno = new VlaknoGUI();
            Vlakno.start();
        }
    }
    public class VlaknoAddIdea extends Thread
    {
        public VlaknoAddIdea()
        {super();}
        public void run()
        {
            AddIdea AI = new AddIdea();
        }
        public  void metoda()
        {
            Thread Vlakno = new VlaknoAddIdea();
            Vlakno.start();
        }
    }
}
