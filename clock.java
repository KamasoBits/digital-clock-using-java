import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Digital_clock extends JFrame{
    private JLabel timeLabel;
    private JLabel dateLabel;

    public Digital_clock(){
        setTitle("Digital_Clock");
        SetSize(500,200);
        setDefaultCloseOperation(JFrame.Exit_ON_CLOSe);
        setResizable(false);

        //create a panel to hold the time and sate lable
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new BorderLayout());


        //create a label to display time

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.RED);

        //create a label to display the date
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN,20));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setVerticalAlignment(swingConstants.CENTER);
        dateLabel.setForeground(Color.WHITE);
        
        // Add the time and date labels tothe panel
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.CENTER);

        // set the panel background color
        panel.setBackground(Color.BLACK);

        // Add the panel to the frame
        add(panel);

        //use a timer to update the time and date labels every second

        Timer timer = new Timer(1000, new ActionListener()){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTimeAndDate();
           }
        
        };
        timer.start();
    }
    private void updateTimeAndDate(){
        //Get the current time and format it
        Calender calender =Calender.getInstance();
        SimpleDateFormat timeFormatter =new SimpleDateFormat("HH:mm:ss");
        String time = timeFormatter.formart(calender.getTime());

        //get the current date and format it
        SimpleDateFormat dateFormatter =new SimpleDateFormat("EEE,MMM dd, yyyy");
        String date = dateFormatter.format(calender.getTime());

        // Update the time and date labels
        timeLabel.setText(time);
        dateLabel.setText(date);

    }
public static void main (String[] args){

    Digital_clock clock = new Digital_clock();
    clock.setVisible(true);
}   
}