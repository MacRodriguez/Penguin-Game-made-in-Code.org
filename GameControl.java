import org.code.playground.*;
import java.io.FileNotFoundException;

public class GameControl {

  private static Board myBoard = Playground.board;
  private static GameImage temp;
  private static GameClickable tempClickable;

  public static void startPlayground() {
    try {
      myBoard.start();
    } catch (PlaygroundException e) {
      System.out.println("Error starting The Playground.");
    }
  }

  public static void stopPlayground() {
    try {
      myBoard.end();
    } catch (PlaygroundException e) {
      System.out.println("Error starting The Playground.");
    }
  }

  public static GameImage createImage(String filename, int x, int y, int width, int height) {
    try {
      temp = new GameImage(filename, x, y, width, height);
    } catch (FileNotFoundException e) {
      System.out.println("Error creating image: " + filename);
    }

    return temp;
  }

  public static GameClickable createButton(String filename, int x, int y, int width, int height) {
    try {
      tempClickable = new GameClickable(filename, x, y, width, height);
    } catch (FileNotFoundException e) {
      System.out.println("Error creating button: " + filename);
    }

    return tempClickable;
  }

  public static void playSoundEffect(String filename) {
    try {
      myBoard.playSound(filename);
    } catch (FileNotFoundException e) {
      System.out.println("Error playing sound: " + filename);
    }
  }
}
