import processing.core.PApplet;

public class Goal {
    float posY = 700;
    int player1Score =0;
    int player2Score = 0;
    float vel = (float) -0.5;
PApplet p;
    Goal(PApplet p){
    this.p =p;

    }
    //displayGoal er en funktion der tegner målet
    public void displayGoal(){
        //Spiller 1 mål

        p.rect(0,posY,10,300);
        p.rect(0,posY+300,70,-10);
        p.rect(0,posY,70,20);

        //Spiller 2 mål
        p.rect(1500,posY,-10,300);
        p.rect(1500,posY,-70,-20);
        p.rect(1500,posY+300,-70,-10);

        //Pedestaler til målene
        p.fill(118,118,118);
        p.rect(1500,posY+300,-70,400);
        p.rect(0,posY+300,70,400);
        moveGoal();
        p.fill(255);

    }
    //insideGoal er en funktion der tager højde for boldens position og ser om den er inden for målet og hvis den er inde for målet bliver der givet et point og alt bliver så resat
   public void insideGoal(Ball ball, Character player1, Character player2){

if (ball.pos.x<70&&ball.pos.y<posY+300&&ball.pos.y>posY){
    posY=700;
    player2Score++;
    ball.pos.x = p.width/2;
    ball.pos.y = 500;
    ball.vel.mult(0);

    player1.pos.x = 75;
    player2.pos.x = 1425;
    System.out.println("MÅL p2");
}
if (ball.pos.x>1430&&ball.pos.y<posY+300&&ball.pos.y>posY){
    posY=700;
    player1Score++;
    ball.pos.x = p.width/2;
    ball.pos.y = 500;
    ball.vel.mult(0);
    player1.pos.x = 75;
    player2.pos.x = 1425;
    System.out.println("MÅL p1");
    }
    }
    //moveGoal er en funktion der bevæger målet
    public void moveGoal(){
        if (posY<=400) {
            vel = (float) 0.5;
        }
        if (posY>=700) {
            vel = (float) - 0.5;
        }
        posY+=vel;
    }

}
