import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

class PwdString {
  String pwdString;
  char letter;
  Integer minCount;
  Integer maxCount;

  public PwdString(String pwdString) { 
    String[] splitString = pwdString.split(" ", 3);
    String[] letterRange = splitString[0].split("-", 2);
    this.pwdString = splitString[2];
    this.letter = splitString[1].charAt(0);
    this.minCount = Integer.parseInt(letterRange[0]);
    this.maxCount = Integer.parseInt(letterRange[1]);
  }

  public boolean pwdCheck() {  
    int count = 0;
    for (int i = 0; i < pwdString.length(); i++) {
      if (pwdString.charAt(i) == letter) {
        count++;
      }
    }

    if (count >= minCount && count <= maxCount) {
      return true;
    } else {
      return false;
    }
  }
}

public class Day2 {
  public static ArrayList readInput() throws FileNotFoundException {
    File inputFile = new File("/home/justin/advent-of-code/2020/day2/input.txt");
    Scanner sc = new Scanner(inputFile);
    ArrayList<String> pwdList = new ArrayList<String>();

    while (sc.hasNextLine()) {
      pwdList.add(sc.nextLine());
    }

    return pwdList;
  }

  public static void main(String[] args) {
    int count = 0;
    ArrayList<String> pwdList = new ArrayList<String>();
    ArrayList<PwdString> pwdListStrings = new ArrayList<PwdString>();

    try {
      pwdList = readInput();
    } catch (FileNotFoundException ex) {
      System.out.println("File Not Found");
    }
  
    for (String pwd : pwdList) {
      PwdString newPwdString = new PwdString(pwd);

      if (newPwdString.pwdCheck()) {
        count++;
      }
    }

    System.out.println(count);
  }
}
