import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.*;
/**
 * Square Runner
 * @author Ugo Dos Reis
 * @version 1.3
 * @Instructions:
 * @Use the arrow keys to move
 * @Go as far as you can without falling
 * @Collect items to earn more points
 * @Earn points to unlock special items you can see on your character at the home screen
 * @Collect power ups to have even more fun
 * @CLick on the character to change him
 * @Enjoy!!!
 * 
 */
public class Game extends Applet implements ActionListener,MouseListener,KeyListener
{
    private Timer timer;
    //Imported Images
    private Image Cloud;
    private Image Platform;
    private Image SBubble;
    private Image Runner;
    private Image Square;
    private Image Credits;
    private Image MouthR;
    private Image MouthL;
    private Image Instructions;
    private Image Death;
    private Image Score;
    private Image Logo;
    private Image Wings;
    private Image Wings2;
    private Image Glasses;
    private Image Glasses2;
    private Image Glasses3;
    private Image Glasses4;
    private Image Glasses5;
    private Image Glasses6;
    private Image Glasses7;
    private Image Glasses8;
    private Image Glasses9;
    private Image Glasses10;
    private Image Glasses11;
    private Image Glasses12;
    private Image Hat;
    private Image Hat2;
    private Image Hat3;
    private Image Hat4;
    private Image Hat5;
    private Image Hat6;
    private Image Hat7;
    private Image Hat8;
    private Image Star;
    private Image Jump;
    private Image Thanks;
    //Character
    private double xCharInc,yCharInc;
    private double xChar,yChar;
    private double xCharTemp,yCharTemp;
    private double xCharMov;
    private int items,itemUn;
    private int glasses,hat;
    private int charJump,charBoostCoun,charBoostChan;
    private int xBoost,yBoost,xBoostInc;
    private int boostID;
    //Platforms
    private int xPlatInc;
    private int xPlat,yPlat,yPlat2;
    private int xPlatLen;
    //Clouds
    private int xCloudInc;
    private int xCloud,yCloud,yCloud2;
    //Score
    private double score;
    private double xScore,yScore;
    private int xScoreF;
    private int score30;
    private int stage,msg;
    private int xStar,xStarInc,yStar;
    private int sExtra;
    private int star,starMSG;
    //Instructions
    private int inst;
    private int xInst,yInst;
    //Birds
    private int xBird,yBird,xBirdInc;
    private int birdCount;
    //Other
    private int xMouse,yMouse;
    private int level;
    private int mouth;
    private int xInfo,xPlay;
    private int yInPl;
    private int xHome,xReplay;
    private int yHoRe;
    private int colCheck;
    public void init()
    {
        //Listeners
        addMouseListener(this);
        addKeyListener(this);
        //Timer
        timer=new Timer(10,this);
        timer.start();
        //Background
        setBackground(ColLibUDR.SKYBLUE());
        //Image Import
        Cloud = getImage(getDocumentBase(),"Images/Cloud.png");
        Platform = getImage(getDocumentBase(),"Images/Platform.png");
        SBubble = getImage(getDocumentBase(),"Images/Bubble.png");
        Square = getImage(getDocumentBase(),"Images/Square.png");
        Runner = getImage(getDocumentBase(),"Images/Runner.png");
        Credits = getImage(getDocumentBase(),"Images/Credits.png");
        MouthR = getImage(getDocumentBase(),"Images/MouthR.png");
        MouthL = getImage(getDocumentBase(),"Images/MouthL.png");
        Instructions = getImage(getDocumentBase(),"Images/Instructions.png");
        Death = getImage(getDocumentBase(),"Images/LOST.png");
        Score = getImage(getDocumentBase(),"Images/SCORE.png");
        Logo = getImage(getDocumentBase(),"Images/Logo.png");
        Wings = getImage(getDocumentBase(),"Images/Wings.png");
        Wings2 = getImage(getDocumentBase(), "Images/Wings2.png");
        Glasses = getImage(getDocumentBase(), "Images/Glasses.png");
        Glasses2 = getImage(getDocumentBase(), "Images/Glasses4.png");
        Glasses3 = getImage(getDocumentBase(), "Images/Glasses5.png");
        Glasses4 = getImage(getDocumentBase(), "Images/Glasses6.png");
        Glasses5 = getImage(getDocumentBase(), "Images/Glasses7.png");
        Glasses6 = getImage(getDocumentBase(), "Images/Glasses8.png");
        Glasses7 = getImage(getDocumentBase(), "Images/Glasses9.png");
        Glasses8 = getImage(getDocumentBase(), "Images/Glasses10.png");
        Glasses9 = getImage(getDocumentBase(), "Images/Glasses11.png");
        Glasses10 = getImage(getDocumentBase(), "Images/Glasses12.png");
        Glasses11 = getImage(getDocumentBase(), "Images/Glasses13.png");
        Glasses12 = getImage(getDocumentBase(), "Images/Glasses14.png");
        Hat = getImage(getDocumentBase(), "Images/Hat.png");
        Hat2 = getImage(getDocumentBase(), "Images/Hat3.png");
        Hat3 = getImage(getDocumentBase(), "Images/Hat4.png");
        Hat4 = getImage(getDocumentBase(), "Images/Hat5.png");
        Hat5 = getImage(getDocumentBase(), "Images/Hat6.png");
        Hat6 = getImage(getDocumentBase(), "Images/Hat7.png");
        Hat7 = getImage(getDocumentBase(), "Images/Hat8.png");
        Hat8 = getImage(getDocumentBase(), "Images/Hat9.png");
        Star = getImage(getDocumentBase(), "Images/STAR.png");
        Jump = getImage(getDocumentBase(), "Images/JUMP.png");
        Thanks = getImage(getDocumentBase(), "Images/THANKS.png");
        //Music
        AudioClip music= getAudioClip(getCodeBase(), "music/Song.wav");
        music.loop();
        //Variables
        level=0;
        inst=-1;
        mouth=0;
        xCloud=700;
        yCloud=(int)(Math.random()*200+0);
        xCloudInc=(int)(Math.random()*3+1);
        yCharInc=0.4;
        xCharMov=0.25;
        xChar=102;
        yChar=265;
        xInst=25;
        yInst=560;
        xInfo=490;
        xPlay=350;
        yInPl=300;
        xHome=375;
        xReplay=235;
        yHoRe=350;
        yScore=300;
        colCheck=0;
        items=0;
        itemUn=0;
        glasses=1;
        hat=1;
        xStar=700;
        yStar=250;
        xStarInc=2;
        sExtra=200;
        star=0;
        xBoost=700;
        yBoost=250;
        xBoostInc=2;
    }

    public void actionPerformed(ActionEvent ae){ //Repaints
        repaint();
    }

    public void mouseExited(MouseEvent me){ //draws when leave the screen

    }

    public void mouseEntered(MouseEvent me){ //draws when enter the screen

    }

    public void mouseReleased(MouseEvent me){ //draws when mouse released

    }

    public void mousePressed(MouseEvent me){ //draws when moused pressed

    }

    public void mouseClicked(MouseEvent me){ //draws when pressed and released at same spot
        xMouse=me.getX();
        yMouse=me.getY();
    }

    public void keyReleased(KeyEvent ke){ //draws when you release the key
        int key=ke.getKeyCode();
        switch(key){
            case(KeyEvent.VK_LEFT):
            xCharInc=0;
            break;
            case(KeyEvent.VK_RIGHT):
            xCharInc=0;
            break;
        }
    }

    public void keyPressed(KeyEvent ke){ //draws when you press the key
        int key=ke.getKeyCode();
        switch(key){
            case(KeyEvent.VK_UP):
            if (colCheck==1){
                yCharTemp=charJump;
            }
            break;
            case(KeyEvent.VK_LEFT):
            xCharInc=-1;
            mouth=0;
            break;
            case(KeyEvent.VK_RIGHT):
            xCharInc=1;
            mouth=1;
            break;
            case(KeyEvent.VK_Q):
            level=3;
            break;
        }
    }

    public void keyTyped(KeyEvent ke){ //draws when you press the key

    }

    public void paint(Graphics g)
    {
        if(level==0){
            //Preload
            g.drawImage(Cloud,1000,1000,10,10,this);
            g.drawImage(Platform,1000,1000,10,10,this);
            g.drawImage(SBubble,1000,1000,10,10,this);
            g.drawImage(Square,1000,1000,10,10,this);
            g.drawImage(Runner,1000,1000,10,10,this);
            g.drawImage(Credits,1000,1000,10,10,this);
            g.drawImage(MouthR,1000,1000,10,10,this);
            g.drawImage(MouthL,1000,1000,10,10,this);
            g.drawImage(Instructions,1000,1000,10,10,this);
            g.drawImage(Death,1000,1000,10,10,this);
            g.drawImage(Score,1000,1000,10,10,this);
            g.drawImage(Logo,1000,1000,10,10,this);
            g.drawImage(Wings,1000,1000,10,10,this);
            g.drawImage(Wings2,1000,1000,10,10,this);
            g.drawImage(Glasses,1000,1000,10,10,this);
            g.drawImage(Glasses2,1000,1000,10,10,this);
            g.drawImage(Glasses3,1000,1000,10,10,this);
            g.drawImage(Glasses4,1000,1000,10,10,this);
            g.drawImage(Glasses5,1000,1000,10,10,this);
            g.drawImage(Glasses6,1000,1000,10,10,this);
            g.drawImage(Glasses7,1000,1000,10,10,this);
            g.drawImage(Glasses8,1000,1000,10,10,this);
            g.drawImage(Glasses9,1000,1000,10,10,this);
            g.drawImage(Glasses10,1000,1000,10,10,this);
            g.drawImage(Glasses11,1000,1000,10,10,this);
            g.drawImage(Glasses12,1000,1000,10,10,this);
            g.drawImage(Hat,1000,1000,10,10,this);
            g.drawImage(Hat2,1000,1000,10,10,this);
            g.drawImage(Hat3,1000,1000,10,10,this);
            g.drawImage(Hat4,1000,1000,10,10,this);
            g.drawImage(Hat5,1000,1000,10,10,this);
            g.drawImage(Hat6,1000,1000,10,10,this);
            g.drawImage(Hat7,1000,1000,10,10,this);
            g.drawImage(Hat8,1000,1000,10,10,this);
            g.drawImage(Star,1000,1000,10,10,this);
            g.drawImage(Jump,1000,1000,10,10,this);
            //WARNING
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif",Font.BOLD,10));
            g.drawString("The game is meant to be run in an Applet of 500x700 (heightxwidth)",2,497);
            //Play Button
            g.setColor(ColLibUDR.TRANSWHITE());
            g.fillOval(xPlay,yInPl,90,90);
            g.setColor(ColLibUDR.SKYBLUE());
            Polygon play=new Polygon();
            play.addPoint(xPlay+32,yInPl+18);
            play.addPoint(xPlay+32,yInPl+68);
            play.addPoint(xPlay+72,yInPl+43);
            g.fillPolygon(play);
            if(xMouse>xPlay && xMouse<xPlay+90 && yMouse>yInPl && yMouse<yInPl+90){
                ClickSound(g);
                yPlat2=450;
                xChar=150;
                yChar=100;
                score=0;
                xPlat=200;
                yPlat=400;
                xPlatInc=1;
                xCharTemp=0;
                yCharTemp=0;
                xCloud=700;
                score30=10;
                xPlatLen=150;
                xBird=0;
                xBirdInc=2;
                yBird=200;
                birdCount=0;
                stage=1;
                msg=0;
                level=1;
                charJump=12;
                charBoostChan=1000;
                charBoostCoun=0;
                boostID=0;
            }
            //Instructions
            g.setColor(ColLibUDR.TRANSWHITE());
            g.fillOval(xInfo,yInPl,90,90);
            g.setColor(ColLibUDR.SKYBLUE());
            g.fillRect(xInfo+35,yInPl+15,20,17);
            g.fillRect(xInfo+35,yInPl+40,20,35);
            if(xMouse>xInfo && xMouse<xInfo+90 && yMouse>yInPl && yMouse<yInPl+90){
                inst*=-1;
                ClickSound(g);
            }
            //Details
            g.drawImage(Credits,618,481,77,16,this);
            g.drawImage(Square,25,25,384,114,this);
            g.drawImage(Runner,275,125,404,114,this);
            TitleEffects(g);
        }
        if(level==1){
            //Background Color
            if (stage%2==0) {
                setBackground(Color.BLACK);
            }    
            else {
                setBackground(ColLibUDR.SKYBLUE());
            }
            //Platforms
            Platform(g);
            Platform2(g);
            //Clouds
            Clouds(g);
            Clouds2(g);
            //Bird
            Bird(g);
            //Star
            Star(g);
            //Jump Boost
            Boost(g);
            //Platform Speed
            if ((int)score/100>=450){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*4+5);
                }
                stage=10;
                if(msg==0 && (int)score/100==450 || (int)score/100==451){
                    msg=300;
                }
            }
            else if ((int)score/100>=405){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*5+5);
                }
                stage=9;
                if(msg==0 && (int)score/100==405 || (int)score/100==406){
                    msg=300;
                }
            }
            else if ((int)score/100>=360){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*6+5);
                }
                stage=8;
                if(msg==0 && (int)score/100==360 || (int)score/100==361){
                    msg=300;
                }
            }
            else if ((int)score/100>=300){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*7+5);
                }
                stage=7;
                if(msg==0 && (int)score/100==300 || (int)score/100==301){
                    msg=300;
                }
            }
            else if ((int)score/100>=270){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*8+5);
                }
                stage=6;
                if(msg==0 && (int)score/100==270 || (int)score/100==271){
                    msg=300;
                }
            }
            else if ((int)score/100>=210){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*9+5);
                }
                stage=5;
                if(msg==0 && (int)score/100==210 || (int)score/100==211){
                    msg=300;
                }
            }
            else if ((int)score/100>=150){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*1+4);
                    score30+=(int)(Math.random()*10+5);
                }
                stage=4;
                if(msg==0 && (int)score/100==150 || (int)score/100==151){
                    msg=300;
                }
            }
            else if ((int)score/100>=90){
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*2+3);
                    score30+=(int)(Math.random()*10+5);
                }
                stage=3;
                if(msg==0 && (int)score/100==90 || (int)score/100==91){
                    msg=300;
                }
            }
            else if ((int)score/100>=45) {
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*3+2);
                    score30+=(int)(Math.random()*10+5);
                }
                stage=2;
                if(msg==0 && (int)score/100==45 || (int)score/100==46){
                    msg=300;
                }
            }
            else {
                if (score30==(int)score/100) {
                    xPlatInc=(int)(Math.random()*2+2);
                    score30+=(int)(Math.random()*10+5);
                }
            }
            //Character
            Char(g);
            if (msg!=score && msg!=0){
                xScore=(getWidth()-g.getFontMetrics().stringWidth("Stage: "+stage))/2;
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
                g.drawString("Stage: "+stage,(int)xScore-50,200);
                msg--;
            }
            //Score Counter/Stage
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Comic Sans MS",Font.BOLD,16));
            xScore=score/100;
            xScore=(int)(xScore*100+.5)/100.0;
            xScoreF=(int)xScore;
            g.drawString("Score: "+(int)xScore,2,16);
            if (stage<10){
                g.drawString("Stage: "+stage,628,16);
            }
            else {
                g.drawString("Stage: "+stage,615,16);
            }
            itemUn=items*60+60;
            if((int)score/100>=itemUn){
                xScore=(getWidth()-g.getFontMetrics().stringWidth("New items unlocked!!!"))/2;
                g.drawString("New items unlocked!!!",(int)xScore,16);
            }
            //Check if character is alive
            if (yChar>499 || xChar<0) {
                if (boostID==2 && charBoostCoun>0){ //Check if you are invincible
                    xChar=xPlat;
                    yChar=100;
                }
                else {
                    level=2;
                    setBackground(ColLibUDR.SKYBLUE());
                }
            }
            //Check for collision between character and star
            if (yChar<=yStar+30 && yChar>=yStar-50 && xChar<=xStar+80 && xChar>=xStar-50 && star==1) {
                score+=sExtra;
                star=0;
                starMSG=300;
                score30+=2;
            }
            if (starMSG!=0){
                xScore=(getWidth()-g.getFontMetrics().stringWidth("+2 Points"))/2;
                g.setColor(Color.YELLOW);
                g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
                g.drawString("+2 Points",(int)xScore-50,250);
                starMSG--;
            }
            //Check for collision between character and jump boost
            if (yChar<=yBoost+30 && yChar>=yBoost-50 && xChar<=xBoost+80 && xChar>=xBoost-50 && charBoostChan==1) {
                charBoostChan=0;
                boostID=(int)(Math.random()*2+1);
                if (boostID==1) {
                    charBoostCoun=1500;
                }
                if (boostID==2) {
                    charBoostCoun=500;
                }
            }
            if (charBoostCoun!=0){
                g.setFont(new Font("Comic Sans MS",Font.BOLD,16));
                if (boostID==1 && charBoostCoun>0) {
                    g.drawString("Jump Boost",2,498);
                }
                if (boostID==2 && charBoostCoun>0) {
                    g.drawString("Invincibility",2,498);
                }
            }
            //Variables
            score+=1;
        }
        if(level==2){
            //Final Score
            g.drawImage(Death,71,86,558,114,this);
            g.drawImage(Score,265,200,171,57,this);
            xScore=(getWidth()-g.getFontMetrics().stringWidth(xScoreF+""))/2;
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
            g.drawString((int)xScoreF+"",(int)xScore-10,(int)yScore);
            if ((int)xScoreF>=60 && items==0) {
                items=1;
                glasses=1;
            }
            if ((int)xScoreF>=120 && items==1) {
                items=2;
                hat=1;
            }
            //Variables
            starMSG=0;
            msg=0;
            //Replay Button
            g.setColor(ColLibUDR.TRANSWHITE());
            g.fillOval(xReplay,yHoRe,90,90);
            g.setColor(ColLibUDR.SKYBLUE());
            Polygon replay=new Polygon();
            replay.addPoint(xReplay+20,yHoRe+60);
            replay.addPoint(xReplay+20,yHoRe+70);
            replay.addPoint(xReplay+70,yHoRe+70);
            replay.addPoint(xReplay+70,yHoRe+25);
            replay.addPoint(xReplay+20,yHoRe+25);
            replay.addPoint(xReplay+20,yHoRe+40);
            replay.addPoint(xReplay+10,yHoRe+40);
            replay.addPoint(xReplay+25,yHoRe+55);
            replay.addPoint(xReplay+40,yHoRe+40);
            replay.addPoint(xReplay+30,yHoRe+40);
            replay.addPoint(xReplay+30,yHoRe+35);
            replay.addPoint(xReplay+60,yHoRe+35);
            replay.addPoint(xReplay+60,yHoRe+60);
            g.fillPolygon(replay);
            if(xMouse>xReplay && xMouse<xReplay+90 && yMouse>yHoRe && yMouse<yHoRe+90){
                ClickSound(g);
                yPlat2=450;
                xChar=150;
                yChar=100;
                score=0;
                xPlat=200;
                yPlat=400;
                xPlatInc=1;
                xCharTemp=0;
                yCharTemp=0;
                xCloud=700;
                score30=10;
                xPlatLen=150;
                xBird=0;
                xBirdInc=2;
                yBird=200;
                birdCount=0;
                stage=1;
                msg=0;
                level=1;
                charJump=12;
                charBoostChan=1000;
                charBoostCoun=0;
                boostID=0;
            }
            //Main Menu Button
            g.setColor(ColLibUDR.TRANSWHITE());
            g.fillOval(xHome,yHoRe,90,90);
            g.setColor(ColLibUDR.SKYBLUE());
            Polygon home=new Polygon();
            home.addPoint(xHome+45,yHoRe+15);
            home.addPoint(xHome+20,yHoRe+35);
            home.addPoint(xHome+70,yHoRe+35);
            g.fillPolygon(home);
            g.fillRect(xHome+26,yHoRe+35,40,30);
            if(xMouse>xHome && xMouse<xHome+90 && yMouse>yHoRe && yMouse<yHoRe+90){
                ClickSound(g);
                level=0;
                xChar=102;
                yChar=265;
                xInst=25;
                yInst=560;
                inst=-1;
                xCharTemp=0;
                yCharTemp=0;
            }
            //Logo
            g.drawImage(Logo,550,350,150,150,this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif",Font.BOLD,10));
            g.drawString("Press Q to quit",2,497);
        }
        if(level==3){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.drawImage(Thanks,95,100,510,45,this);
        }
        xMouse=0;
        yMouse=0;
    }

    public void Char(Graphics g){
        //Boost
        if (boostID==1 && charBoostCoun>0) {
            charJump=20;
            charBoostCoun--;
        }
        else if (boostID==2 && charBoostCoun>0) {
            charBoostCoun--;
        }
        else {
            charJump=12;
        }
        //Movement
        yCharTemp-=yCharInc;
        xCharTemp+=xCharInc;
        xCharTemp*=0.9;
        xChar+=xCharTemp;
        colCheck(g);
        if(colCheck==1){
            yChar-=1;
            colCheck(g);
            if(colCheck==1){
                yChar-=1;
                colCheck(g);
                if(colCheck==1){
                    yChar-=1;
                    colCheck(g);
                    if(colCheck==1){
                        yChar-=1;
                        colCheck(g);
                        if(colCheck==1){
                            yChar-=1;
                            colCheck(g);
                            if(colCheck==1){
                                xChar-=xCharTemp;
                                xChar-=1;
                                yChar-=5;
                                xChar+=1;
                            }
                        }
                    }
                }
            }
        }
        yChar-=yCharTemp;
        colCheck(g);
        if(colCheck==1){
            yChar+=yCharTemp;
            yCharTemp=0;
        }
        yChar+=1;
        yChar-=1;
        xChar=(int)(xChar*100+.5)/100.0;
        yChar=(int)(yChar*100+.5)/100.0;
        //Drawing
        if (mouth==1){
            g.setColor(Color.BLACK);
            g.fillRect((int)xChar,(int)yChar,50,50);
            g.setColor(Color.YELLOW);
            g.fillRect((int)xChar+3,(int)yChar+3,44,44);
            g.setColor(Color.BLACK);
            g.fillOval((int)xChar+8,(int)yChar+7,12,12);
            g.fillOval((int)xChar+30,(int)yChar+7,12,12);
            g.setColor(Color.WHITE);
            g.fillOval((int)xChar+10,(int)yChar+9,8,8);
            g.fillOval((int)xChar+32,(int)yChar+9,8,8);
            g.setColor(Color.BLACK);
            g.fillRect((int)xChar+15,(int)yChar+13,2,2);
            g.fillRect((int)xChar+37,(int)yChar+13,2,2);
            g.drawImage(MouthR,(int)xChar+12,(int)yChar+24,26,20,this);
        }
        else {
            g.setColor(Color.BLACK);
            g.fillRect((int)xChar,(int)yChar,50,50);
            g.setColor(Color.YELLOW);
            g.fillRect((int)xChar+3,(int)yChar+3,44,44);
            g.setColor(Color.BLACK);
            g.fillOval((int)xChar+8,(int)yChar+7,12,12);
            g.fillOval((int)xChar+30,(int)yChar+7,12,12);
            g.setColor(Color.WHITE);
            g.fillOval((int)xChar+10,(int)yChar+9,8,8);
            g.fillOval((int)xChar+32,(int)yChar+9,8,8);
            g.setColor(Color.BLACK);
            g.fillRect((int)xChar+12,(int)yChar+13,2,2);
            g.fillRect((int)xChar+34,(int)yChar+13,2,2);
            g.drawImage(MouthL,(int)xChar+12,(int)yChar+24,26,20,this);
        } 
        //Character looks
        if(glasses==1){
            g.drawImage(Glasses,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==2) {
            g.drawImage(Glasses2,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==3) {
            g.drawImage(Glasses3,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==4) {
            g.drawImage(Glasses4,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==5) {
            g.drawImage(Glasses5,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==6) {
            g.drawImage(Glasses6,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==7) {
            g.drawImage(Glasses7,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==8) {
            g.drawImage(Glasses8,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==9) {
            g.drawImage(Glasses9,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==10) {
            g.drawImage(Glasses10,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==11) {
            g.drawImage(Glasses11,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==12) {
            g.drawImage(Glasses12,(int)xChar-1,(int)yChar+5,52,73,this);
        }
        if(hat==1){
            g.drawImage(Hat,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==2) {
            g.drawImage(Hat2,(int)xChar-13,(int)yChar-45,76,76,this);
        }
        else if(hat==3) {
            g.drawImage(Hat3,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==4) {
            g.drawImage(Hat4,(int)xChar-13,(int)yChar-28,76,42,this);
        }
        else if(hat==5) {
            g.drawImage(Hat5,(int)xChar-13,(int)yChar-45,76,76,this);
        }
        else if(hat==6) {
            g.drawImage(Hat6,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==7) {
            g.drawImage(Hat7,(int)xChar-8,(int)yChar-40,70,70,this);
        }
        else if(hat==8) {
            g.drawImage(Hat8,(int)xChar-5,(int)yChar-40,60,60,this);
        }
    }

    public void TitleEffects(Graphics g){ 
        //Character items
        if (xMouse>=xChar-1 && xMouse<=xChar+51 && yMouse>=yChar+10 && yMouse<=yChar+29 && items>0){
            if(glasses==-1){
                glasses=1;
            }
            else if(glasses==12){
                glasses=-1;
            }
            else {
                glasses++;
            }
        }
        if (xMouse>=xChar-13 && xMouse<=xChar+63 && yMouse>=yChar-28 && yMouse<=yChar+10 && items>1){
            if(hat==-1){
                hat=1;
            }
            else if(hat==8){
                hat=-1;
            }
            else {
                hat++;
            }
        }
        //Character on Island
        g.drawImage(Platform,(int)xChar-52,(int)yChar+35,153,99,this);
        g.setColor(Color.BLACK);
        g.fillRect((int)xChar,(int)yChar,50,50);
        g.setColor(Color.YELLOW);
        g.fillRect((int)xChar+3,(int)yChar+3,44,44);
        g.setColor(Color.BLACK);
        g.fillOval((int)xChar+8,(int)yChar+7,12,12);
        g.fillOval((int)xChar+30,(int)yChar+7,12,12);
        g.setColor(Color.WHITE);
        g.fillOval((int)xChar+10,(int)yChar+9,8,8);
        g.fillOval((int)xChar+32,(int)yChar+9,8,8);
        g.setColor(Color.BLACK);
        g.fillRect((int)xChar+15,(int)yChar+13,2,2);
        g.fillRect((int)xChar+37,(int)yChar+13,2,2);
        g.drawImage(MouthR,(int)xChar+12,(int)yChar+24,26,20,this);
        g.drawImage(SBubble,(int)xChar+60,(int)yChar-40,120,67,this);
        //Character looks
        if(glasses==1){
            g.drawImage(Glasses,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==2) {
            g.drawImage(Glasses2,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==3) {
            g.drawImage(Glasses3,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==4) {
            g.drawImage(Glasses4,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==5) {
            g.drawImage(Glasses5,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==6) {
            g.drawImage(Glasses6,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==7) {
            g.drawImage(Glasses7,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==8) {
            g.drawImage(Glasses8,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==9) {
            g.drawImage(Glasses9,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==10) {
            g.drawImage(Glasses10,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==11) {
            g.drawImage(Glasses11,(int)xChar-1,(int)yChar+5,52,19,this);
        }
        else if(glasses==12) {
            g.drawImage(Glasses12,(int)xChar-1,(int)yChar+5,52,73,this);
        }
        if(hat==1){
            g.drawImage(Hat,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==2) {
            g.drawImage(Hat2,(int)xChar-13,(int)yChar-45,76,76,this);
        }
        else if(hat==3) {
            g.drawImage(Hat3,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==4) {
            g.drawImage(Hat4,(int)xChar-13,(int)yChar-28,76,42,this);
        }
        else if(hat==5) {
            g.drawImage(Hat5,(int)xChar-13,(int)yChar-45,76,76,this);
        }
        else if(hat==6) {
            g.drawImage(Hat6,(int)xChar-13,(int)yChar-28,76,38,this);
        }
        else if(hat==7) {
            g.drawImage(Hat7,(int)xChar-8,(int)yChar-40,70,70,this);
        }
        else if(hat==8) {
            g.drawImage(Hat8,(int)xChar-5,(int)yChar-40,60,60,this);
        }
        //Speech bubble
        g.setColor(Color.BLACK);
        if(items>0){
            g.setFont(new Font("Monaco",Font.BOLD,12));
            g.drawString("Click me to",(int)xChar+85,(int)yChar-15);
            g.drawString("change my looks",(int)xChar+71,(int)yChar+5);
        }
        else {
            g.setFont(new Font("Monaco",Font.BOLD,30));
            g.drawString("Hello",(int)xChar+80,(int)yChar+5);
        }
        //Instructions
        g.drawImage(Instructions,xInst,yInst,214,240,this);
        if(xChar>=117 ||xChar<=87){
            xCharMov*=-1;
        }
        if (inst==1 && xChar>-282){
            xChar-=5;
            if (yInst>130){
                yInst-=5;
            }
        }
        else if(xChar<87 && inst==-1){
            xChar+=5;
            yInst+=5;
        }
        else{
            xChar+=xCharMov;
        }
    }

    public void Clouds(Graphics g){ //Draw the first cloud
        if(xCloud>0){
            //Draw Cloud
            g.drawImage(Cloud,xCloud,yCloud,100,72,this);
            //Move Cloud
            xCloud-=xCloudInc;
        }
        else {
            //Cloud Location/Increment
            xCloud=700;
            yCloud=(int)(Math.random()*200+0);
            xCloudInc=(int)(Math.random()*3+1);
        }    
    }

    public void Clouds2(Graphics g){ //Draw the second cloud
        if (xCloud>0 && xCloud<350){
            g.drawImage(Cloud,xCloud+350,yCloud2,100,72,this);
        }
        else{
            g.drawImage(Cloud,xCloud-350,yCloud2,100,72,this);
        }
        if (xCloud==350 || (xCloud<350 && xCloud>340)){
            yCloud2=(int)(Math.random()*200+0);
        }
    }

    public void Star(Graphics g){ //Draw and move the star
        if(xStar>0 && star==1){
            //Draw Star
            g.drawImage(Star,xStar,yStar,30,30,this);
            //Move Star
            xStar-=xStarInc;
        }
        else {
            //Star Location/Increment
            xStar=700;
            yStar=(int)(Math.random()*200+150);
            xStarInc=(int)(Math.random()*2+2);
            star=(int)(Math.random()*1500+0);
        }    
    }

    public void Boost(Graphics g){ //Draw and move boost Icon
        if(xBoost>0 && charBoostChan==1){
            //Draw Boost
            g.drawImage(Jump,xBoost,yBoost,30,30,this);
            //Move Boost
            xBoost-=xBoostInc;
        }
        else {
            //Boost Location/Increment
            xBoost=700;
            yBoost=(int)(Math.random()*200+150);
            xBoostInc=(int)(Math.random()*1+4);
            charBoostChan=(int)(Math.random()*2500+0);
        }   
    }

    public void Bird(Graphics g) { //Draw and move the bird
        if(xBird<700){ 
            g.setColor(Color.RED);
            Polygon bird=new Polygon();
            bird.addPoint(xBird,yBird);
            bird.addPoint(xBird+32,yBird);
            bird.addPoint(xBird+16,yBird-20);
            g.fillPolygon(bird);
            g.setColor(Color.BLACK);
            Polygon birdout=new Polygon();
            birdout.addPoint(xBird,yBird);
            birdout.addPoint(xBird+32,yBird);
            birdout.addPoint(xBird+16,yBird-20);
            g.drawPolygon(birdout);
            g.fillRect(xBird+20,yBird-7,3,3);
            //Move bird wings
            if(birdCount%50>=30){
                g.drawImage(Wings,xBird-60,yBird-25,90,92,this);
            }
            else {
                g.drawImage(Wings2,xBird-60,yBird-20,90,92,this);
            }
            birdCount++;
            //Move the bird
            xBird+=xBirdInc;
        }
        else {
            //Bird Location/increment
            xBird=0;
            yBird=(int)(Math.random()*200+50);
            xBirdInc=(int)(Math.random()*2+2);
        }
    }         

    public void Platform(Graphics g){ //Draw the first platform
        if(xPlat>0){
            //Draw Platform
            g.drawImage(Platform,xPlat,yPlat,xPlatLen,97,this);
            //Move Platform
            xPlat-=xPlatInc;
        }
        else {
            //Platform Location/Increment
            xPlat=700;
            yPlat=(int)(Math.random()*200+25);
            yPlat=500-yPlat;
            xPlatLen=(int)(Math.random()*200+100);
        }
    }

    public void Platform2(Graphics g){ //Draw the second PLatfrom
        if (xPlat>0 && xPlat<350){
            g.drawImage(Platform,xPlat+350,yPlat2,150,97,this);
        }
        else if(xPlat>=349 && xPlat<=351){
            yPlat2=(int)(Math.random()*200+25);
            yPlat2=500-yPlat2;
        }
        else{
            g.drawImage(Platform,xPlat-350,yPlat2,150,97,this);
        }
    }

    public void ClickSound(Graphics g){ //Play Sound when button is clicked
        AudioClip buttonSound= getAudioClip(getCodeBase(), "music/Button.wav");
        buttonSound.play();
    }

    public void colCheck(Graphics g){ //Check for collisions between platforms and character
        if(xChar>=xPlat-50 && xChar<=xPlat+xPlatLen && yChar>=yPlat-35 && yChar<=yPlat+2){
            colCheck=1;
        }
        else if((xPlat>0 && xPlat<350) && xChar>=xPlat+300 && xChar<=xPlat+500 && yChar>=yPlat2-35 && yChar<=yPlat2+2) {
            colCheck=1;
        }
        else if(xChar>=xPlat-400 && xChar<=xPlat-200 && yChar>=yPlat2-35 && yChar<=yPlat2+2) {
            colCheck=1;
        }
        else{
            colCheck=0;
        }
    }
}