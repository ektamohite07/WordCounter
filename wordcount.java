import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
class WordCounter extends JFrame
{
    JLabel label1;
    static JLabel label2;
    JTextArea textArea1;
    WordCounter()
    {
        setLayout(null);
        setTitle("Word Counter");

        label1 = new JLabel("WORDS : 0");
        label2 = new JLabel("TIME : 0 : 0 : 0");
        textArea1 = new JTextArea();

        label1.setBounds(100,100,200,40);
        label2.setBounds(300,100,200,40);
        textArea1.setBounds(100, 150, 300, 250);

        textArea1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e)
            {
                label1.setText("WORDS :"+textArea1.getText().split("").length);
            }
        });

        add(label1);
        add(label2);
        add(textArea1);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new WordCounter();
        new Timer(label2).start();
    }
}
class Timer extends Thread
{
    JLabel timeLabel;
    Timer(JLabel timeLabel)
    {
        this.timeLabel = timeLabel;
    }
    public void run()
    {
        while(true)
        {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second =  c.get(Calendar.SECOND);
        timeLabel.setText("TIME : "+hour+" :"+minute+" : "+second+"");
        }
    }
}