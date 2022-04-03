import org.code.playground.*;
import java.io.FileNotFoundException;

// Use this class to create images that can be clicked.
public class GameClickable extends ClickableImage {

	public GameClickable(String filename, int x, int y, int width, int height) throws FileNotFoundException {
    super(filename, x, y, width, height);
  }

  /* Use this method to call isValidMove() from Game.
   * You may have this ClickableImage perform other actions
   * as well based on the rules of your game.
   */
  public void onClick() {
    System.out.println("clicked");
    if(this.getFilename() == "uparrow.jpg"){
      System.out.println("moving up");
      Game.updateScreen("up");
    } else if(this.getFilename() == "downarrow.jpg"){
      Game.updateScreen("down");
    } else if(this.getFilename() == "leftarrow.jpg"){
      Game.updateScreen("left");
    } else if(this.getFilename() == "rightarrow.jpg"){
      Game.updateScreen("right");
    } else if(this.getFilename() == "attbutton.jpg"){
      Game.updateScreen("attack");
    }
  }
}
