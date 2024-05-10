import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

public class gameSwing extends JPanel implements KeyListener,ActionListener {


    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;
    //x axis and y axis of slider
    private int playerX = 310;
    private int getPlayerX = 310;
    private int ballpositionX = 120;
    private int ballPositionY = 350;
    //direction of the ball
    private int ballxdir = -1;
    private int ballydir = -2;

private CodeRunner map;

    public gameSwing() {
        map=new CodeRunner(3,7);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //backgorund
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
     //drawing map
        map.draw((Graphics2D)g);
        //bordars
        g.setColor(Color.pink);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

//scores
        g.setColor(Color.white);
        g.setFont(new Font("Afnan",Font.BOLD,25));
        g.drawString(""+score,590,30);

        //the -paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, 550, 100, 8);

        //the-ball
        g.setColor(Color.red);
        g.fillOval(ballpositionX, ballPositionY, 20, 20);
        if(totalBricks==0){
            play=false;
            ballxdir=0;
            ballydir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("Afnan",Font.BOLD,30));
            g.drawString("You Won :",260,300);

            g.setFont(new Font("Afnan",Font.BOLD,20));
            g.drawString("Press Enter to Restart  :",230,350);

        }
     //   g.dispose();

        //game over handling
        if(ballPositionY>570){
            play=false;
            ballxdir=0;
            ballydir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("Afnan",Font.BOLD,30));
            g.drawString("Game Over,Scores :",190,300);

            g.setFont(new Font("rafi",Font.BOLD,20));
            g.drawString("Press Enter to Restart  :",230,350);

        }

g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play){
            //for interecting with the paddel
            if(new Rectangle(ballpositionX,ballPositionY,20,20).
                    intersects(new Rectangle(playerX,550,100,8))){
                ballydir=-ballydir;
            }
           A: for(int i=0;i<map.map.length;i++){
                for(int j=0;j<map.map[0].length;j++){
                    if(map.map[i][j]>0){
                        int brickX=j*map.brickWeight+80;
                        int brcikY=i*map.brickHight+50;
                        int brickWidth=map.brickWeight;
                        int brickHeight=map.brickHight;

            Rectangle rect = new Rectangle(brickX,brcikY,brickWidth,brickHeight);
            Rectangle ballRect = new Rectangle(ballpositionX,ballPositionY,20,20);
            Rectangle brickRect=rect;


            if(ballRect.intersects(brickRect)){
                map.setBrickValue(0,i,j);
                totalBricks --;
                score+=5;

                if(ballpositionX+19<=brickRect.x || ballpositionX+1>=
                ballRect.x +brickRect.width){
                    ballxdir=-ballxdir;

                }
                else{
                    ballydir=-ballydir;
                }
                break A;

            }
                    }
                }
            }



            ballpositionX+=ballxdir;
            ballPositionY+=ballydir;
            //left border
            if( ballpositionX<0){
                ballxdir=-ballxdir;
            }
            //top border

            if(ballPositionY<0){
                ballydir=-ballydir;
            }
            //right border
            if(ballpositionX>670){
                ballxdir=-ballxdir;
            }
        }


        //recall the paint method here cz by
        // increamenting and decrementing we need re drawing
        repaint();


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (playerX >= 600) {
                playerX = 600;

            } else {
                moveRight();
            }
        }
            if ( e.getKeyCode() == KeyEvent.VK_LEFT){
                if (playerX < 10) {
                    playerX = 10;

                } else {
                    moveLeft();
                }

            }
            //entering after game over
if(e.getKeyCode()==KeyEvent.VK_ENTER){

        play=true;
        ballpositionX=120;
        ballPositionY=350;
        ballxdir=-1;
        ballydir=-2;
        playerX=310;
        score=0;
        totalBricks=21;
        map=new CodeRunner(3,7);
        repaint();

}



    }
    public void moveRight(){
        play=true;
        playerX+=20;

    }
    public void moveLeft(){
        play=true;
        playerX-=20;

    }
}
