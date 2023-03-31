import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.awt.event.ActionEvent;

public class Main extends javax.swing.JFrame implements ActionListener {
    static int seconds=0;
    static int minutes=0;
    static int hours=0;
    static double vATCost;

    static double elapsedTimeHours;
    static double elapsedTimeMinutes;
    static double elapsedTimeSeconds;
    boolean started =false;
    static int elapsedTime = 0; 
    static double callCost;
    static String seconds_string = String.format("%02d", seconds);
    static String minutes_string = String.format("%02d", minutes);
    static String hours_string= String.format("%02d",hours);
    static String elapsedSeconds_string= String.format("%02e",elapsedTimeSeconds);
    static String elapsedMinutes_string= String.format("%02e",elapsedTimeMinutes);
    static String elapsedHours_string= String.format("%02e",elapsedTimeHours);
    static String callCost_string= String.format("%2e",callCost);

      static Timer timer = new Timer(10, (java.awt.event.ActionListener) new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

            
        }});

    public void Socket(InetAddress address, int port, InetAddress localAddr, int localPort)throws IOException{}
    static JButton StartCallButton;
    static JButton EndCallButton;
    static JLabel timeLabel;
    JLabel questionJLabel;
    static JPanel panel = new JPanel();
    static JPanel panel2= new JPanel();
    static JTextField networkANS;
    static JTextField dayANS;
    static String network;
    static String dayOrNight;
    static ImageIcon icon = new ImageIcon("callForMe");
   
    public static void main(String[]args){
        JFrame frame =new JFrame();
        panel= new JPanel();
        frame.setSize(400,700);
        frame.setBounds(0, 15 , 400,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setBackground(Color.getHSBColor(134, 400, 234));
        panel.setLayout(null);
        frame .setVisible(true);


        // JFrame newFrame = new JFrame();
        // newFrame.setBounds(200,0,50,50);
        // newFrame.setSize(100,100);
        // newFrame.setLayout(null);
        // newFrame.setVisible(true);


        // JLabel label2= new JLabel();
        // label2.setBounds(200, 0, 100, 15);
        //  label2.setBackground(Color.getHSBColor(0, 0, 0));
        // // label2.setLayout(null);
        // // label2.setIcon(icon);
        // // label2.setOpaque(true);
        // label2.setLayout(null);
        // label2.setVisible(true);
        // newFrame.add(label2);

        JLabel callingServicJLabel=new JLabel("SOKUDAIKIRI MITSUDATA");
        callingServicJLabel.setBounds(30, 20, 300, 25);
        callingServicJLabel.setFont(new Font("Traditional Arabic",Font.BOLD,20));
        panel.add(callingServicJLabel);

        JLabel questionJLabel=new JLabel("Which Network are you Calling?");
        questionJLabel.setBounds(10, 55, 300, 25);
        questionJLabel.setFont(new Font("times new roman",Font.PLAIN,15));
        panel.add(questionJLabel);

        JLabel dayOrNight=new JLabel("Is it day Or night?");
        dayOrNight.setBounds(10,115,200,25);
        dayOrNight.setFont(new Font("times new roman",Font.PLAIN,15));
        panel.add(dayOrNight);


        networkANS=new JTextField("");
        networkANS.setBounds(10, 80, 200, 25);
        networkANS.setFont(null);
        panel.add(networkANS);

        dayANS=new JTextField("");
        dayANS.setBounds(10, 140, 200, 25);
        dayANS.setFont(null);
        panel.add(dayANS);


        timeLabel= new JLabel();
        timeLabel.setBounds(10,140,120,120);
        timeLabel.setFont(new Font("Ink Free",Font.PLAIN,20));
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        panel.add(timeLabel);



        StartCallButton = new JButton("START CALL");
        StartCallButton.setBounds(10,220,120,25);
        StartCallButton.addActionListener(new Main());
        panel.add(StartCallButton);

        EndCallButton =new JButton("END CALL");
        EndCallButton.setBounds(140,220,120,25);
        EndCallButton.addActionListener(new Main());
        panel.add(EndCallButton);
       

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==StartCallButton){
        network =networkANS .getText();
        dayOrNight=dayANS .getText();
           start();
        started=true;
       }
    
     {
        if(e.getSource()==EndCallButton){
            started=false;
            timer.stop();
            System.out.println(elapsedTime);
 
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);       
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
            elapsedTime();
            calcCost();

       }
       }}
        
    
        void start(){
           timer.start();
        }
        void stop(){
            timer.stop();
        }
        void restart(){
            timer.restart();
        }

        void elapsedTime(){
    
        elapsedTimeHours = (elapsedTime/3600000);
        elapsedTimeMinutes = (elapsedTime/60000) % 60;
        elapsedTimeSeconds = (elapsedTime/1000) % 60;

        JLabel elapsedTimeJLabel=new JLabel();
        elapsedTimeJLabel.setBounds(120, 280, 200, 25);
        elapsedTimeJLabel.setFont(new Font("times new roman",Font.PLAIN,15));
        elapsedHours_string= String.format("%02e",elapsedTimeHours);
        elapsedMinutes_string= String.format("%02e",elapsedTimeMinutes);
        elapsedSeconds_string= String.format("%02e",elapsedTimeSeconds);
        elapsedTimeJLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        panel.add(elapsedTimeJLabel);

        JLabel secondsDisplay= new JLabel("Elapsed time =");
        secondsDisplay.setBounds(10,280,100,25);
        secondsDisplay.setFont(new Font("times new roman",Font.PLAIN,15));
        panel.add(secondsDisplay);

      



        } 
               public static double calcCost(){ 
                if(dayOrNight.equals("Day")){
                    if(network.equals("saf")){
                        double minutesHere=0;
                        minutesHere=(elapsedTimeSeconds/60) +elapsedTimeMinutes +(elapsedTimeHours*60);
                        callCost=minutesHere*4;


                    }
                    else{
                        double minutesHere=0;
                        minutesHere=(elapsedTimeSeconds/60)+elapsedTimeMinutes +(elapsedTimeHours*60);
                        callCost=minutesHere*5;
                    }
                }
                else{
                    if(network.equals("saf")) {
                        double minutesHere=0;
                        minutesHere=(elapsedTimeSeconds/60)+elapsedTimeMinutes +(elapsedTimeHours*60);
                        callCost=minutesHere*3;
                    }
                    else{
                        double minutesHere=0;
                        minutesHere=(elapsedTimeSeconds/60)+elapsedTimeMinutes +(elapsedTimeHours*60);
                        callCost=minutesHere*5;
                    }
                    

                    }
                    if(elapsedTimeMinutes>2){ //checks if the elapsedTimeMinutes are > than 2 if greater than 2 it's to calculate 16% VAT
                    vATCost =(0.16*callCost)+callCost;

                    JLabel costMessageLabel= new JLabel("Cost for calling in Ksh=");
                    costMessageLabel.setBounds(10,320,150,25);
                    costMessageLabel.setFont(new Font("times new roman",Font.PLAIN,15));;
                    panel.add(costMessageLabel);

                    JLabel costLabel = new JLabel();
                    costLabel.setBounds(150,320,120,25);
                    costLabel.setFont(new Font("times new roman",Font.PLAIN,15));
                    String vATCost_string = String.format("%1f",vATCost);
                    costLabel.setText(vATCost_string);
                    panel.add(costLabel);
                    
                    System.out.println("call cost="+callCost);
                    System.out.println(elapsedTimeHours);
                    System.out.println(elapsedTimeMinutes);
                    System.out.println(elapsedTimeSeconds);
                    System.out.println(vATCost);
                    
                }
                else{
                    JLabel costMessageLabel= new JLabel("Cost for calling in Ksh=");
                    costMessageLabel.setBounds(10,320,150,25);
                    costMessageLabel.setFont(new Font("times new roman",Font.PLAIN,15));;
                    panel.add(costMessageLabel);

                    JLabel costLabel = new JLabel();
                    costLabel.setBounds(150,320,120,25);
                    costLabel.setFont(new Font("times new roman",Font.PLAIN,15));
                    callCost_string=String.format("%1f",callCost);
                    costLabel.setText(callCost_string);
                    panel.add(costLabel);

                    System.out.println("call cost="+callCost);
                    System.out.println(elapsedTimeHours);
                    System.out.println(elapsedTimeMinutes);
                    System.out.println(elapsedTimeSeconds);
                }
                
                return callCost;
            }
          
            
        }
        
