/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author vikas
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class PoliceRun
{
    public static void main(String[] args) {
        //Below thread is for making the whole GUI thread safe !!
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LogWriter lg = new LogWriter(); 
                lg.writeLog("Police_run:Game Started with initial Frame");
                //Open the first Page!!
                FirstPage fir = new FirstPage();
                fir.create_one();
            }
    });
}
}

class Car 
{
    String common = "images\\";
    JLabel create_car(String file)
    {
        JLabel my_car = new JLabel(make_icons(common+file));
        return my_car;
    }
    Icon make_icons(String src)
    {
        Icon icon = new ImageIcon(src);
//        JLabel label = new JLabel(icon);
        return icon;
    }
    int my_pos_x()
    {
        int a = MouseInfo.getPointerInfo().getLocation().x-50;
        return a;
    }
}

class Logic 
{
    LogWriter lg = new LogWriter();
    String game_name = "Police Run:";
    int x;
    int time=0;
    Random randomGenerator = new Random();
    int gen_random()
    {
        x = randomGenerator.nextInt(400);
        lg.writeLog(game_name+":Main_frame:Getting Random number!!");
        return x;
    }
    int st()
    {
        Thread tim = new Thread(){             
        @Override
        public void run(){
        for(int i=0;;i++)
        {    
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                   
                }
                time++;
        }
        }
       };
        tim.start();
        lg.writeLog(game_name+":Main_frame:Started Time!!");
        return 0;
    }
    int get_time()
    {
        return time;
    }
}
//-----------------------------------End of the game ----------------------------//
class End extends FirstPage
{
    String game_name = "Police Run";
    LogWriter lg = new LogWriter();
    JFrame f2 = new JFrame();
    Icon icon = new ImageIcon(common+"final.jpg");
    Icon icon2 = new ImageIcon(common+"play_again.png");
    End(int time)
    {
//        Score sc = new Score();
//        sc.writeScore("vikas","Police Run",time);
        lg.writeLog(game_name+":Main_frame:Game Ends !!");
        JLayeredPane l = new JLayeredPane();
        JLabel ob3 = new JLabel(icon);
        final JLabel play_again = new JLabel(icon2);
        ob3.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        play_again.setBounds(0,0,icon2.getIconWidth(),icon2.getIconHeight());
        l.add(ob3,new Integer(0),0);
        JLabel l2 = new JLabel("Your Score = "+time);
            lg.writeLog(game_name+":Main_frame:Score =  !!"+time);
            l2.setForeground(Color.red);
            l2.setFont(new Font("Serif", Font.PLAIN, 50));
            l2.setBounds(600, 400, 500, 500);
            l.add(l2,new Integer(1),0);
            l.add(play_again,new Integer(1),0);
            f2.add(l);
            f2.setBackground(Color.blue);
            f2.setSize(1000,800);
            f2.setVisible(true);
           play_again.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(play_again);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                f2.setVisible(false);
                Finalgui fin = new Finalgui();
                fin.createframe();
                fin.change(-99);
                lg.writeLog(game_name+":Main_frame:User Wants to play again!!");
                }  
            }
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        }); 
}
}
//-----------------------------------End of the game ----------------------------//


//-----------------------------------FirstPage of the game ----------------------------//
class FirstPage
{
    //Initializing all variables!!
    String game_name = "Police Run:";
    LogWriter lg = new LogWriter();
    String common = "images\\";
    JFrame frm1 = new JFrame();
    JLayeredPane full = new JLayeredPane();
    Icon icon = new ImageIcon(common+"first.jpg");
    Icon strt = new ImageIcon(common+"run.png");
    Icon story = new ImageIcon(common+"story.png");
    
    //Creating the frame!!
    public int create_one()
    {
       lg.writeLog(game_name+":First_frame:Creating first frame!!");
       JLabel back = new JLabel(icon);
       final JLabel st1 = new JLabel(strt);
       final JLabel stry = new JLabel(story);
       back.setBounds(50,0,icon.getIconWidth(),icon.getIconHeight());
       st1.setBounds(70,100,strt.getIconWidth(),strt.getIconHeight());
       stry.setBounds(70,200,story.getIconWidth(),story.getIconHeight());
       full.add(back , new Integer(0),0);
       full.add(st1 , new Integer(1),0);
       full.add(stry , new Integer(1),0);
       full.setVisible(true);
       frm1.add(full);
       frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frm1.setSize(1400,1000);
       frm1.setVisible(true);
       st1.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(st1);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                frm1.setVisible(false);
                Finalgui fin = new Finalgui();
                fin.createframe();
                fin.change(-99);
                lg.writeLog(game_name+":First_frame:User pressed Start game!!");
                }  
            }
           
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        });  
       stry.addMouseListener(new MouseAdapter()  
        {  
            public void mousePressed(MouseEvent e)  
            {  
                Rectangle rects = getClickableRegions(stry);  
                Point p = e.getPoint();  
                String s = "error";  
                if(rects.contains(p))  
                {
                    JLabel lab = new JLabel("YOU HAVE ROBBED A BANK AND  TRYING TO ESCAPE FROM");
                    JLabel lab2 = new JLabel("POLICE, GUIDE YOUR CAR AND SEE FOR HOW MUCH TIME POLICE WILL FOLLOW YOU!!");
                    JLabel lab1 = new JLabel("SOMETIMES YOUR CAR MIGHT SEEM TO CRASH");
                    JLabel lab3 = new JLabel("BUT IT SO HAPPENS THAT DUE TO POWER OF YOUR CAR IT ESCAPED THE CRASH !!HURRAY !! ");
//                    System.out.println("Done!1");
                    lab.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab1.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab2.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab3.setFont(new Font("Serif", Font.PLAIN, 30));
                    lab.setBounds(0, 0, 1200, 50);
                    lab2.setBounds(0, 10, 1200, 100);
                    lab1.setBounds(0, 200, 1200, 100);
                    lab3.setBounds(0, 600, 1200, 100);
                    JFrame fr = new JFrame();
//                    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
                    fr.add(lab);
                    fr.add(lab1);
                    fr.add(lab2);
                    fr.add(lab3);
                    fr.setBackground(Color.blue);
                    fr.setSize(1500,700);
                    fr.setVisible(true);
                }
                lg.writeLog(game_name+":First_frame:User pressed Start game!!");
                }  
        public Rectangle getClickableRegions(JLabel label) {
        int w = label.getWidth();  
        int h = label.getHeight();  
        Rectangle but = new Rectangle(0, 0, w, h); 
        return but; 
            }
        });
       return 0;
    } 
}
//-----------------------------------FirstPage of the game ----------------------------//

class Finalgui {    
    //--------------------------All Global Variables Start here ----------------------------//
    final String game_name = "Police-run:";
    public  JLayeredPane lpane = new JLayeredPane();
    Logic l = new Logic();
    Car c = new Car();
    public JFrame f = new JFrame("Game !!");
    LogWriter lg = new LogWriter(); 
    
    // --------All Track variables which cause animation ---------//
    public JPanel track1 =  createTrack(-100);
    public JPanel track2 =  createTrack(150);
    public JPanel track3 =  createTrack(300);
    public JPanel track4 =  createTrack(450);
    public JPanel track5 =  createTrack(600);
    // --------All Track variables which cause animation end here ---------//
    
    //For creating cars !!
    String common = "images\\";
    JLabel my_car = c.create_car("my_car.png");
    JLabel police = c.create_car("police.png");
    JLabel ob2 = c.create_car("ob2.png");
    //--------------------------All Global Variables End here ----------------------------//
    
    //--------------------------Creating Track of a Particular ---------------------------//
    JPanel createTrack(int size)
    {
        Color c = Color.YELLOW;
        JPanel temp = new JPanel();
        temp.setSize(10, 25);
        temp.setBackground(c);
        temp.setLayout(null);
        //This below line is used to set the x and y axis of track !!!
        temp.setBounds(740, size, 25, 100);
        temp.setOpaque(true);
        return temp;
    }
    //--------------------------Creating Track of a Particular (above)---------------------------//
    
                      
    //---------Create the final frame here with all Jpanel added to it !!!----------------//
    public int createframe()
    {
        lg.writeLog(game_name+":Main_frame:Started to create frame");
        f.setPreferredSize(new Dimension(2000, 1000));
        f.add(panels());
        f.pack();
        f.setBackground(Color.black);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        lg.writeLog(game_name+":Main_frame:Done with creating frame");
        return 0;
    }
    //---------Create the final frame here with all Jpanel added to it above !!!----------------//
    
    
    //---------Creates different layers of the Game!!! ----------------------------------------//
    JLayeredPane panels()
    {
        lg.writeLog(game_name+":Main_frame:Started to create Panels");
        JPanel mainpanel = new JPanel(new GridLayout(1,3));
        JPanel green1 = createRect(Color.green, 50);
        JPanel black = createRect(Color.black, 2000);
        JPanel green2 = createRect(Color.green, 50);
        mainpanel.add(green1);
        mainpanel.add(black);
        mainpanel.add(green2);
        mainpanel.setBounds(0, 0, 1500, 700);
        mainpanel.setOpaque(true);
        lpane.setBounds(0, 0, 60, 40);
        lpane.add(mainpanel, new Integer(0), 0);
        //===========Adding all tracks for animation !! ==========//
        lpane.add(track1, new Integer(1), 0);
        lpane.add(track2, new Integer(1), 0);
        lpane.add(track3, new Integer(1), 0);
        lpane.add(track4, new Integer(1), 0);
        lpane.add(track5, new Integer(1), 0);
        //===========Adding all tracks for animation !! ==========//
        
        //===========Adding all vehicles =========================//
        lpane.add(my_car,new Integer(2),0);
        lpane.add(police,new Integer(2),0);
        lpane.add(ob2,new Integer(2),0);
        //===========Adding all vehicles above =========================//
        lg.writeLog(game_name+":Main_frame:Done with creating Panels");
        return lpane;
    }
    //---------Creates different layers of the Game above!!! ----------------------------------------//

    
    JPanel createRect(Color c,int size)
    {
        JPanel temp = new JPanel();
        temp.setBackground(c);
        temp.setLayout(null);
        temp.setSize( 5 , 100);
        temp.setOpaque(true);
        return temp;
    }
 
    
    //------------------Main Part which has everything ---------------------------------------------//
    int change(final int size)
    {
        lg.writeLog(game_name+":Main_frame:Entered to main part of the game");
        Thread th = new Thread(){
        int t1=-99,t2=151,t3=301,t4=451,t5=601;
        int x_loc;  
        int ob_x = 0,ob_x2=0;
        int ob_y=0,ob_y2=0;
        @Override
        public void run()
        {
        int tmp;
        tmp = size; 
        ob_y=0;
        l.st();
        for(int i=0,flag=1,end = 0,flag2=1;;i++)
        {    
                try {
//                    if (l.get_time() < 15)
                    sleep(1);
                } catch (InterruptedException ex) {
                       lg.writeLog("Error in main_change_class"+ex);
                }
                
                x_loc = c.my_pos_x();
                
                //=============To avoid car going out of the frame =========//
                if (x_loc < 500)
                {
                    x_loc = 500;
                }
                if (x_loc > 900)
                    x_loc = 900;
                //=============To avoid car going out of the frame =========//
                
                //================To check any thing going out of the frame ============//
                if (t1 > 700)
                    t1 = -100;
                if (t2 > 700)
                    t2 = -100;
                if (t3 > 700)
                    t3 = -100;
                if (t4 > 700)
                    t4 = -100;
                if (t5 > 700)
                    t5 = -100;
                //================To check any thing going out of the frame ============//
                
                //================Start car when time is more than 5secs================//
                if (l.get_time() > 5 && flag != 0)
                {
                    ob_x = 500 + l.gen_random();
                    police.setBounds(ob_x,0,25,100);
                    lg.writeLog(game_name+":Main_frame:More than 5 secs and creating a obstacle");
                    flag =0;
                }
                if(l.get_time() > 15 && flag2 !=0)
                {   
                    ob_x2 = 500 + l.gen_random();
                    while( !(ob_x2 > ob_x+30 || ob_x2 < ob_x-30 ))
                        ob_x2 = 500 + l.gen_random();
                    ob2.setBounds(ob_x2,0,100,25);
                    lg.writeLog(game_name+":Main_frame:More than 15 secs and creating a obstacle");
                    flag2 = 0;
                }
                //================Start car when time is more than 5secs================//
                
                
                if ( flag == 0)
                {
                    police.setBounds(ob_x,ob_y++,25,100);
                    if (ob_y > 700)
                    {
                        flag = 1;
                        ob_y=0;
                    }
                }
                if ( flag2 == 0)
                {
                    ob2.setBounds(ob_x2,ob_y2++,100,25);
                    if (ob_y2 > 700)
                    {
                        flag2 = 1;
                        ob_y2=0;
                    }
                }
                if (ob_y >= 600)
                    if (check_collision(ob_x,x_loc) == 1)
                    {
                        f.setVisible(false);
                        break;
                    }
                if (ob_y2 >= 600 && l.time > 15)
                    if (check_collision(ob_x2,x_loc) == 1)
                    {       
                        f.setVisible(false);
                        break;
                    }
                my_car.setBounds(x_loc,600,100,100);
                track1.setBounds(740,t1++,25,100);
                track2.setBounds(740,t2++,25,100);
                track3.setBounds(740,t3++,25,100);
                track4.setBounds(740,t4++,25,100);
                track5.setBounds(740,t5++,25,100);
            }
        }
       };
       th.start();      
        return 0;
    }
    
    //-----------------------Function to Check Collisions !!! ---------------------//
    int check_collision(int ob,int my)
    {
        if (my > ob-30 && ob+30 > my )
        {
            lg.writeLog(game_name+":Main_frame:Colidded!!");
            End e = new End(l.get_time());
            return 1;
        }
        if ((ob < my && my < ob+30) || (ob < my+20 && my+20 < ob+30))
        {
            lg.writeLog(game_name+":Main_frame:Colidded!!");
            End e = new End(l.get_time());
            return 1;
        }
        if ((ob < my && my < ob+20) || (ob < my+20 && my+20 < ob+20))
        {
            lg.writeLog(game_name+":Main_frame:Colidded!!");
            End e = new End(l.get_time());
            return 1;
        }
        return 0;
    }
    //-----------------------Function to Check Collisions !!! ---------------------//
    
    
}
class LogWriter{
  
    
    public synchronized void writeLog(String entry){
        BufferedWriter bw=null;
         try {

 

        bw =new BufferedWriter(new FileWriter("log.txt",true));

        bw.append(entry);

        bw.newLine();

 

    } catch (IOException e) {

 

        e.printStackTrace();

 

    }finally{

 

      try {

 

              bw.close();

 

      } catch (IOException e) {
 

               e.printStackTrace();
      }
}
 }
   

    }
