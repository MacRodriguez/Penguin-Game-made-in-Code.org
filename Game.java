import org.code.playground.*;
import org.code.media.*;
import java.io.FileNotFoundException;



  
public final class Game {
  
  public static Board myBoard = Playground.board;
  public static GameImage penguin = GameControl.createImage("penguin.jpg", 180, 180, 40, 40);
  public static GameImage pengu2 = GameControl.createImage("pengu2.jpg", penguin.getX()-40, penguin.getY()-40, 120, 120);
  public static GameClickable attackbutton = GameControl.createButton("attbutton.jpg", 280, 340, 110, 50);
  public static GameClickable uparr = GameControl.createButton("uparrow.jpg", 100, 280, 50, 50);
  public static GameClickable downarr = GameControl.createButton("downarrow.jpg", 100, 340, 50, 50);
  public static GameClickable leftarr = GameControl.createButton("leftarrow.jpg", 40, 340, 50, 50);
  public static GameClickable rightarr = GameControl.createButton("rightarrow.jpg", 160, 340, 50, 50);
  public static GameImage lizar1 = GameControl.createImage("lizar.jpg", (int)((Math.random() * 7 + 1) * 20), (int)((Math.random() * 7 + 1) * 20), 40, 40);
  public static GameImage lizar2 = GameControl.createImage("lizar.jpg", (int)((Math.random() * 7 + 11) * 20), (int)((Math.random() * 7 + 1) * 20), 40, 40);
  public static GameImage lizar3 = GameControl.createImage("lizar.jpg", (int)((Math.random() * 7 + 1) * 20), (int)((Math.random() * 7 + 11) * 20), 40, 40);
  public static GameImage lizar4 = GameControl.createImage("lizar.jpg", (int)((Math.random() * 7 + 11) * 20), (int)((Math.random() * 7 + 11) * 20), 40, 40);
  public static GameImage lizarBoss = GameControl.createImage("lizarBoss.jpg", (int)((Math.random() * 15 + 1) * 20), (int)((Math.random() * 15 + 1) * 20), 40, 40);
  public static GameImage background = GameControl.createImage("pixil-frame-0.jpg", 0, 0, 400, 400);
  public static TextItem message = new TextItem("WIN", 190, 190, Color.BLACK, Font.SANS, 100, 0);
  public static int count = 0;
  /* Use this method to setup the display (show the images).
   * Calling this method shows the images on the screen so
   * the user can begin playing the game.
   */
  public static void play() {
      GameImage.displayGame();
      myBoard.addImageItem(background);
      throwLizars();
      myBoard.addImageItem(penguin);
      myBoard.addClickableImage(attackbutton);
      myBoard.addClickableImage(uparr);
      myBoard.addClickableImage(downarr);
      myBoard.addClickableImage(leftarr);
      myBoard.addClickableImage(rightarr);
      GameControl.startPlayground();
  }
  
  /* Use this method to check whether the player's move
   * is valid. You may need to add parameters based on
   * the rules of your game.
   */
  public static void throwLizars() {
    GameImage[] lizars = {lizar1, lizar2, lizar3, lizar4};
    for(int i = 0; i < 4; i++) {
      myBoard.addImageItem(lizars[i]);
    }
  }
   public static void attack() {
    GameImage[] lizars = {lizar1, lizar2, lizar3, lizar4, lizarBoss};
    for(int i = 0; i < 5; i++) {
      if(lizars[i].getX() < penguin.getX() + 100  && lizars[i].getX() > penguin.getX() - 75 && lizars[i].getY() < penguin.getY() + 100 && lizars[i].getY() > penguin.getY() - 75) {
        lizars[i].setX(500);
        lizars[i].setY(500);
        myBoard.removeItem(lizars[i]);
        try{
        myBoard.playSound("lizarddeath.wav");
        } catch(FileNotFoundException e){
        System.out.println("error playing sound");
        }
        System.out.println("MURDER!");
        count++;
      } 
      if(count == 4) {
        myBoard.addImageItem(lizarBoss);
      } else if (count > 4){
        gameOver();
      }
    }
  }
  public static boolean isValidMove(String dir) {
    if(dir == "up"){
      if(penguin.getY() <= 10){
        return(false);
      }
      return(true);
    } else if(dir == "down"){
      if(penguin.getY() >= 380){
        return(false);
      }
      return(true);
    } else if(dir == "left"){https://studio.code.org/s/csa4-pilot/lessons/12/levels/1#
      if(penguin.getX() <= 10){
        return(false);
      }
      return(true);
    } else if(dir == "right"){
      if(penguin.getX() >= 380){
        return(false);
      }
      return(true);
    } 
   return(false);
  }
  
  /* Use this method to update the score based on the
   * results of the isValidMove() method. You may need
   * add parameters based on the rules of your game.
   */
  public static void updateScreen(String dir) {
    
    if(dir == "up"){
      if(isValidMove(dir)){
        penguin.setY(penguin.getY() - 40);
        myBoard.removeItem(pengu2);
      }
    } else if(dir == "down"){
      if(isValidMove(dir)){
        penguin.setY(penguin.getY() + 40);
        myBoard.removeItem(pengu2);
      }
    } else if(dir == "left"){
      if(isValidMove(dir)){
        penguin.setX(penguin.getX() - 40);
        myBoard.removeItem(pengu2);
      }
    } else if (dir == "right"){
      if(isValidMove(dir)){
        penguin.setX(penguin.getX() + 40);
        myBoard.removeItem(pengu2);
      }
    } else if (dir == "attack"){
      pengu2.setX(penguin.getX() -40);
      pengu2.setY(penguin.getY() -40);
      myBoard.addImageItem(pengu2);
      try{
        myBoard.playSound("swordswing.wav");
        } catch(FileNotFoundException e){
        System.out.println("error playing sound");
        }
      
      attack();

          
         
          
        
        
        
        
    }
    
  }
  
  // Use this method to check if the game is over.
  public static void gameOver() {
    try{
        myBoard.playSound("winsound.wav");
        } catch(FileNotFoundException e){
        System.out.println("error playing sound");
        }
      myBoard.addTextItem(message);
  }
}
