import java.awt.*;

public class CodeRunner {
    public int map[][];
    public int brickHight;

    public int brickWeight;
    public CodeRunner(int row,int colms){
        map=new int[row][colms];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j]=1;

            }
        }
        brickWeight=540/colms;
        brickHight=150/row;

    }
    public void draw(  Graphics2D g){
        for(int i=0;i<map.length;i++
        ){
            for(int j=0;j<map[0].length;j++){
if(map[i][j]>0){
    g.setColor(Color.white);
    g.fillRect(j*brickWeight+80,i*brickHight+50,
            brickWeight,brickHight);



    g.setStroke(new BasicStroke(3));
    g.setColor(Color.black);
    g.drawRect(j*brickWeight+80,i*brickHight+50,
            brickWeight,brickHight);
}
            }
        }
    }
    public void setBrickValue(int value,int row,int colms){
        map[row][colms]=value;
    }

}
