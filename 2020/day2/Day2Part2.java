import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

class PwdString {
  String pwdString;
  char letter;
  Integer firstIndex;
  Integer secIndex;

  public PwdString(String pwdString) {
    String[] splitString = pwdString.split(" ", 3);
    String[] letterRange = splitString[0].split("-", 2);
    this.pwdString = splitString[2];
    this.letter = splitString[1].charAt(0);
    this.firstIndex = Integer.parseInt(letterRange[0]);
    this.secIndex = Integer.parseInt(letterRange[1]);
  }

  public boolean pwdChecker() {
    int seen = 0; 

    if (pwdString.charAt(firstIndex-1) == letter) {
      seen++;
    } 
    
    if (pwdString.charAt(secIndex-1) == letter) {
      seen++;
    }

    if (seen == 1) {
      return true;
    } 
   
    return false;  
  }
}

public class Day2Part2 {
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
    Integer count = 0;
    ArrayList<String> pwdList = new ArrayList<String>();

    try {
      pwdList = readInput();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found.");
    }

    for (String pwdString : pwdList) {
      PwdString newString = new PwdString(pwdString);
      if (newString.pwdChecker()) { 
        count++;
      } 
    }

    System.out.println(count);
  }
}
