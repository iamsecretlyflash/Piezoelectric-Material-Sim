import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import javax.sound.sampled.*;
public class piezoSimulator extends JFrame  implements
ActionListener,MouseListener
{
    JFrame jf;
    toDisp jtf;
    int pressed =0;
    atom a4,a1,a2,a3;
    Timer t1 = new Timer(200,this);
    Timer t2 = new Timer(200,this);
    Timer xT = new Timer(200,this);
    int times = 0;
    int x,y;
    Timer tim = new Timer(100,this);;
    battery bt = new battery();
    molecule mol;
    JTextField peiz,apres,names;
    mytextfield RIGHTS = new mytextfield(Color.BLACK,Color.WHITE);
    mytextfield RIGHTS2 =new mytextfield(Color.BLACK,Color.WHITE);
    Font f = new Font("Comic Sans MS", Font.BOLD,40);
    public int  batPer;
    int turnOn=0;
    decBattery b2;
    ImagePanel ip ;
    switchImagePanel swi;
    boolean stateex = false;
    int tix = 0 ;
    ImagePanel bolt = new ImagePanel("D:/bolt.jpg");
    Timer addTimer = new Timer(500,new ActionListener(){
                public void actionPerformed(ActionEvent e){
if(tix==0) {
                        jf.add(peiz);
                    }
                    else if(tix==1)
                    {
                        jf.add(apres);
                    }
                    else if(tix==2)
                        jf.add(names);
                    else addTimer.stop();
tix++; }});
 
    boolean killNoise = false;
    Timer noise = new Timer(100,new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    new AePlayWave("D:/
electricalbuzz.wav").start();;
} });
    public static void main()
    {
        piezoSimulator ps = new piezoSimulator();
        ps.setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paint(g);
        g.fillArc(845,600,40,40,0,360);
    }
    public piezoSimulator()
    {
        setTitle("THE PIEZOELECTRIC SIMULATOR");
        RIGHTS.setFont(f);
        RIGHTS2.setFont(f);
        RIGHTS.setBounds(0,680,400,200);
        RIGHTS2.setBounds(0,880,400,200);
        RIGHTS.setBackground(Color.BLACK);
        RIGHTS.setForeground(Color.WHITE);
        RIGHTS2.setBackground(Color.BLACK);
        RIGHTS2.setForeground(Color.WHITE);
        setBounds(0,0,1920,1080);
        setLayout(null);
quartz();
    }
    public class mytextfield extends JComponent
    {
        public mytextfield(Color back, Color font)
        {
            setBackground(back);
repaint(); }
        public void paintComponent(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;
            super.paintComponent(g2d);
            g2d.setColor(Color.BLACK);
            g2d.drawString("MADE BY " , 50,20);
}
 
}
 public void recharge()
{
main(); }
JButton jb;
public void quartz()
{
    add(RIGHTS);
    add(RIGHTS2);
    bt.setBounds(20,20,100,400);
    add(bt);
    bt.update();
    getContentPane().setBackground(new Color(0,0,10));
    atom a1 = new atom(Color.red,0,0,false);//oxygen1
    a1.setBounds(856,142,100,100);
    x = a1.getX();
    y = 50+a1.getY();
    add(a1);
    a2 = new atom(Color.red,0,0,false);//oxygen2
    a2.setBounds(x-500,y+500,100,100);
    add(a2);
    a3 = new atom(Color.RED,0,0,false);//SILICON
    a3.setBounds(x+500,y+500,100,100);
    add(a3);
    a4 = new atom(Color.GREEN,0,0,true);//CHARGE
    a4.setBounds(x,y+260,100,100);
    add(a4);
    atom a5 = new atom(Color.RED,0,0,false);
    a5.setBounds(854,537,1001,100);
    add(a5);
    // a5.setBounds(
    //**ADDING BONDS**\\
    bond b1 = new bond(0,0,0,250,20);
    b1.setBounds(x+45,y+50,20,270);
    add(b1);
    bond b2 =new bond(906-414,0,40,207,10);
    b2.setBounds(414,508,906-414,721-508);
    add(b2);
    bond b3 = new bond(0,0,1400-906,207,10);
    b3.setBounds(906,508,1400-906,721-508);
    add(b3);
    ;
    bolt.setBounds(20,440,119,213);
    add(bolt);
    this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                pressed++;

                    System.out.println(e.getX()+"," + e.getY());
                    if(pressed<4){
                        new AePlayWave("D:/
electricalbuzz.wav").start();
                        a1.setBounds(856,142+10,100,100);
                        a2.setBounds(x-500,y+500+10,100,100);
                        a3.setBounds(x+500,y+500+10,100,100);
                        a4.setBounds(x,y+260+10,100,100);
                        for(int i = 0 ; i <10;i++){}
                        a1.setBounds(856,142,100,100);
                        a2.setBounds(x-500,y+500,100,100);
                        a3.setBounds(x+500,y+500,100,100);
                        a4.setBounds(x,y+260,100,100);
                        bt.x = pressed;
                        bt.update();
                        t1.start();
                    }
                    else if(pressed == 4){
                        getContentPane().removeAll(); //equivalent
to this.getContentPane().removeAll();
                        revalidate();
                        repaint();
                        screen2();
} }
    int ti = 0 ;
    public void screen2() {
        try{
            shutdown();
}
catch(Exception e){}
pressed = 0 ;
t1.stop();
x=0;y=0;
bt.x = 0 ;
times = 0 ; pressed = 0 ; battery bt = new battery(); bt.setBounds(20,20,100,400); add(bt);
bt.x = 3;
bt.update();
mol = new molecule(1500,1050);
        int k = 10;
        add(mol);
 }); }

        setVisible(true);
        JLabel j = new JLabel(" QUARTZ CRYSTAL STRUCTURE ");
        j.setFont(new Font("COMIC SANS MS", Font.BOLD|k, 40));
        j.setForeground(Color.WHITE);
        j.setBounds(320,0,700,100);
        add(j);
        JButton use = new JButton(" PRESS TO USE THE STORED
ELECTRICITY");
        use.setAlignmentX(10F);
        use.setFont(new Font("COMIC SANS MS", Font.BOLD|k, 35));
        use.setBounds(1030,0,1920-1030,100);
        mol.setBounds(320,100,1500,1050);
        use.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    getContentPane().removeAll();
                    revalidate();
                    repaint();
screen3(); }
});
        add(use);
        this.
        addMouseListener(this) ;
        //quartz();
    }
    public void screen3()
    {
        jf = new JFrame();
        jf.setBounds(getBounds());
        jf.setVisible(true);
        dispose();
        jf.setLayout(null);
        batPer = 0 ;
        turnOn = 0 ;
        b2 = new decBattery();
        b2.setBounds(20,40,100,440);
        jf.add(b2);
        jf.getContentPane().setBackground(new Color(0,0,0));
        jf.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e)
{System.out.println(e.getX() + "  ,  " + e.getY());}
            });
        ip= new ImagePanel("D:/bulboff.jpg");
        ip.setBounds(787  ,  254,306,423);
        jf.add(ip);
 
         bolt.setBounds(20,440,119,213);
        jf.add(bolt);
        // BufferedImage myPicture = ImageIO.read(new File("D:/
bulboff.jpg"));
        // JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        swi = new switchImagePanel("D:/switchoff.jpg");
        jb = new JButton("PRESS TO RECHARGE");
        jb.setBounds(1500,700,300,200);
        jb.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    getContentPane().removeAll();
                    revalidate();
                    repaint();
                    jf.dispose();
                    recharge();
                }
            });
        swi.changeState(false);
        swi.addMouseListener(new MouseAdapter(){
= false;
@Override
public void mouseClicked(MouseEvent e){
    if(killNoise ==false)
        noise.start();
    if(stateex == false)stateex = true; else stateex
    swi.changeState(stateex);
    System.out.println(e);
}
    });
jf.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
        {
            System.exit(10);
        }
    });
swi.setBounds(1407,239,310,470);
jf.add(swi);
}
public void bounder()
{
} @Override

public void mouseClicked(MouseEvent e){
         tim.start();
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
    }
    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void mouseReleased(MouseEvent e){}
    public void helpActions()
    {
        //a1.setBounds(e.getX(),e.getY(),100,100);
        //            a3.setBounds(e.getX()+500,e.getY()
+500,100,100);
        //          a2.setBounds(e.getX()-500,e.getY()+500,100,100);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == t1)
        {
            int x = a4.getX();
            int y = a4.getY()+50;
            a4.setBounds(x,y,100,100);
            t1.stop();
            t2.start();
        }
        else if(e.getSource() == t2)
        {
            int x = a4.getX();
            int y = a4.getY()-50;
            a4.setBounds(x,y,100,100);
            t2.stop();
            times++;
            if(times==2)
{
t2.stop();
times = 0;

} else {
                t1.start();
            }
        }
        if (e.getSource()==tim)
        {  ti++;
if(ti ==1) {
                mol.setBounds(350,130,1500,1050);
            }
else {
} }
}
    public void welcom()
    {
        getContentPane().removeAll();
        revalidate();
        jf = new JFrame();
        jf.getContentPane().setBackground(Color.BLACK);
        jf.setBounds(0,0,1920,1080);
        peiz = new JTextField();
        peiz.setBackground(Color.BLACK);
        Font f = new Font("COMIC SANS MS", Font.BOLD, 40);
        peiz.setFont(f);
        peiz.setForeground(Color.WHITE);
        peiz.setText("CONVERTING MOTION TO ELECTRICITY\n USING THE
PIEZOELECTRIC EFFECT");
        peiz.setBounds(200,400,1000,200);
        jf.setVisible(true);
        addTimer.start();
}
    private class decBattery extends JComponent implements
ActionListener{
        int batPer = 0;
        Timer x = new Timer(100,this);
        public decBattery()
        {
}
        public void update()
        {
 mol.setBounds(320,100,1500,1050);
ti=0;
tim.stop();

 batPer)>20)
Graphics2D d = (Graphics2D) g;
super.paintComponent(d);
if(Math.abs(100-batPer)>50)d.setColor(Color.blue);
else if(Math.abs(100-batPer)<=50&&Math.abs(100-
    d.setColor(Color.YELLOW);
else d.setColor(Color.RED);
d.setStroke(new BasicStroke(10));
d.drawRect(0,0,100,400);
Font f = new Font("COMIC SANS MS" , Font.BOLD, 40);
d.setFont(f);
d.fillRect(10,batPer*4,80,400-batPer*4);
d.setColor(Color.red);
d.drawLine(0,batPer*4,100,batPer*4);
d.setColor(Color.green);
d.drawString(Integer.toString(Math.abs(100-batPer))+"%",
    x.start();
    repaint();
}
public void paintComponent(Graphics g)
{
10,batPer*4);
        }
        public void actionPerformed(ActionEvent e)
        {
            if(batPer>=100){
                x.stop();
                killNoise=true;
                ip.changeImage("D:/bulboff.jpg");
                jf.add(jb);
                swi.changeState(false);
                swi.killCode(true);
}
else {
batPer++;
repaint(); }
} }
    private class atom extends JComponent{
        Color k ; int x1,y1;boolean setMovable ;
        public atom(Color c, int x,int y,boolean move)
        {
            k=c;
            x1 = x;
            y1 = y ;

        setMovable = move;
repaint(); }
    public void paintComponent(Graphics d)
    {
        Graphics2D g= (Graphics2D) d;
        g.setColor(k);
        g.fillArc(x1,y1,100,100,0,360);
} }
private class bond extends JComponent
{
    int x1,y1,x2,y2;int s;
    public bond(int xF,int yF,int xL,int yL,int size)
    {
        x1 = xF;y1 = yF;x2=xL;y2 = yL;
        s = size;
        repaint();
}
    public void paintComponent(Graphics g)
    {
        Graphics2D d = (Graphics2D) g;
        d.setColor(Color.white);
        d.setStroke(new BasicStroke(s));
        g.drawLine(x1,y1,x2,y2);
} }
private class molecule extends JComponent
{
    int x,y;
    public molecule(int breadth,int height)
    {
        x = breadth;
        y = height;
        repaint();
}
    public void paintComponent(Graphics g )
    {
        Graphics2D d = (Graphics2D)g;
        super.paintComponent(d);
        int times = 0 ;
        for(int lO = 50 ; lO<=y;lO+=50)
        {
            for(int lI = 0 ; lI<=x;lI+=50)
            {
                times++;
                if(times%2==0)
                    d.setColor(Color.RED);
                else d.setColor(Color.GREEN);
 
                d.fillArc(lI,lO,25,25,0,360);
            }
} }
}
private class battery
extends JPanel
{
    int x;
    public battery()
    {
update(); }
    public void update()
    {
repaint(); }
    public void paint(Graphics g)
    {
        Graphics2D d = (Graphics2D) g;
        d.setStroke(new BasicStroke(10));
        Font f = new Font("COMIC SANS MS" , Font.BOLD, 40);
        d.setFont(f);
        switch(x)
        {
            case 1:
            d.setColor(Color.RED);
            d.drawRect(0,0,100,400);
            d.fillRect(10,267,80,133);
            d.setColor(Color.GREEN);
            d.drawString("30% " ,10,90);
            break;
            case 2:
            d.setColor(Color.YELLOW);
            d.drawRect(0,0,100,400);
            d.fillRect(10,133,80,267);
            d.setColor(Color.GREEN);
            d.drawString("60% " ,10,90);
            break;
            case 3:
            d.setColor(Color.blue);
            d.drawRect(0,0,100,400);
            d.fillRect(10,0,80,400);
            d.setColor(Color.GREEN);
            d.drawString("100% " ,-3,90);
            break;
 
} }
}
private class toDisp extends JComponent {
    String write;
    public toDisp(String str){
write = str; }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawString(write ,0,10);
} }
private class ImagePanel extends JPanel{
    boolean mouseCommand = false;
    private BufferedImage image;
    boolean state = false;
    public ImagePanel(String img) {
        try {
            image = ImageIO.read(new File(img));
        } catch (IOException ex) {
            System.err.println("NOT FOUND");
}
repaint(); }
public void changeImage(String img) { try{
            image = ImageIO.read(new File(img));
        } catch (IOException ex) {
            System.err.println("NOT FOUND");
        }
repaint(); }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
private class switchImagePanel extends JPanel {
 
BufferedImage image;
     boolean doKill = false;
    public switchImagePanel(String img) {
        killCode(doKill);
    }
    public void killCode(boolean enable)
    {
        doKill = enable;
    }
    public void changeState(boolean state)
    {
        if(doKill== false){
            String img = "";
            if(batPer >=100){}
            else {
                if(state == false){
                    noise.stop();
                    b2.x.stop();
                    swi.setBounds(1407,239,310,470);
                    img = "D:/switchoff.jpg";
                    ip.changeImage("D:/bulboff.jpg");
}
else {
                    noise.start();
                    img = "D:/switchon.jpg";
                    swi.setBounds(1407,100,310,490);
                    ip.changeImage("D:/bulbon.jpg");
                    b2.update();
}
                try {
                    image = ImageIO.read(new File(img));
                } catch (IOException ex) {
                    System.err.println("NOT FOUND");
}
} }
}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

}
 