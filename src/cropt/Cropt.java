/*
 * Hipster time wasted
 * code is love
 * Life is good
 * My computer was a drinker and crazy, and one night he comes with a crazy mind and here we go ! 
 */
package cropt;

import static cropt.Cropt.hash;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 *
 * @author Mohammed TABIT <nap.software@gmail.com>
 */
public class Cropt 
{

  


      // TODOConstants
    public String pwd;
    public String key;
    public int lenght;
          

    public static final char[] HASH = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_' };

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
                     System.out.println("Entrez le texte que vous voulez HASH en SHA-256");
                      String algo1=sc.nextLine();
         
            String code= crypt(algo1);
           System.out.println("Votre nouveau texte hashé est = " + code);

      
       Crack();
    }
      public static String hash(String algo, String message)
  {
    try
    {
      byte[] hashData = MessageDigest.getInstance(algo).digest(message.getBytes());
      return byteArrayToHex(hashData);
    }
    catch (Exception e) {}
    return "";
  }        
       private static final char[] BYTE2HEX=(
    "000102030405060708090A0B0C0D0E0F"+
    "101112131415161718191A1B1C1D1E1F"+
    "202122232425262728292A2B2C2D2E2F"+
    "303132333435363738393A3B3C3D3E3F"+
    "404142434445464748494A4B4C4D4E4F"+
    "505152535455565758595A5B5C5D5E5F"+
    "606162636465666768696A6B6C6D6E6F"+
    "707172737475767778797A7B7C7D7E7F"+
    "808182838485868788898A8B8C8D8E8F"+
    "909192939495969798999A9B9C9D9E9F"+
    "A0A1A2A3A4A5A6A7A8A9AAABACADAEAF"+
    "B0B1B2B3B4B5B6B7B8B9BABBBCBDBEBF"+
    "C0C1C2C3C4C5C6C7C8C9CACBCCCDCECF"+
    "D0D1D2D3D4D5D6D7D8D9DADBDCDDDEDF"+
    "E0E1E2E3E4E5E6E7E8E9EAEBECEDEEEF"+
    "F0F1F2F3F4F5F6F7F8F9FAFBFCFDFEFF").toCharArray();
;
    private static String byteArrayToHex(byte[] hashData) {
        final int len=hashData.length;
    final char[] chars=new char[len<<1];
    int hexIndex;
    int idx=0;
    int ofs=0;
    while (ofs<len) {
      hexIndex=(hashData[ofs++] & 0xFF)<<1;
      chars[idx++]=BYTE2HEX[hexIndex++];
      chars[idx++]=BYTE2HEX[hexIndex];
    }
    return new String(chars);
    }
    public static String crypt(String data)
  {
    return hash("SHA-256", data);
  }
      public static String old(String pwd, String key)
  {
   
    pwd = pwd + "\n";
    int _loc6 = pwd.length();
    int _loc7 = key.length();
    String _loc2 = "";
    for (int _loc1 = 0; _loc1 < _loc7; _loc1++) {
      _loc2 = _loc2 + HASH[((pwd.charAt(_loc1 % _loc6) ^ key.charAt(_loc1 % 32)) % '@')];
    }
    int _loc4 = _loc2.length();
    pwd = _loc2;
    _loc2 = "";
    for (int _loc1 = 0; _loc1 < _loc4; _loc1++) {
      _loc2 = _loc2 + HASH[((pwd.charAt(_loc4 - _loc1 - 1) ^ key.charAt((_loc1 + 8) % 32)) % '@')];
    }
    return _loc2;
  }
      //BruteForce
      
  public static String Crack() {
      int size;
       Scanner sc = new Scanner(System.in);
                     System.out.println("Réentrez votre texte pour que notre system guess your text(ca va prendre du temps si c'est un gros texte bon bah il est en dev ce machin bref mais bon, faut attentre pour tester les probab) : ");
                 
      
      String algo;
        algo=sc.nextLine();
        size=algo.length();
    int[] password = new int[size];
    String[] finalPassword = new String[size];
    for (int i = 0; i < size; i++) {
      password[i] = 0;
      finalPassword[i] = "";
    }
      
                   

   
    return computePermutations(size, password, 0, algo);
  }

  private static String computePermutations(int size, int[] password, int position, String pass) {
    String testString = "";
    String assemble = "";
    for (int i = 0; i < 36; i++) {
      password[position] = i;

      if (position != size - 1) {
        testString = computePermutations(size, password, position + 1, pass);
        if (!"".equals(testString)) {
          return testString;
        }
      } else if (position == size - 1) {
        for (int j = 0; j < size; j++) {

          switch (password[j] + 1) {
            case 1:
              assemble = assemble + "A";
              break;
            case 2:
              assemble = assemble + "B";
              break;
            case 3:
              assemble = assemble + "C";
              break;
            case 4:
              assemble = assemble + "D";
              break;
            case 5:
              assemble = assemble + "E";
              break;
            case 6:
              assemble = assemble + "F";
              break;
            case 7:
              assemble = assemble + "G";
              break;
            case 8:
              assemble = assemble + "H";
              break;
            case 9:
              assemble = assemble + "I";
              break;
            case 10:
              assemble = assemble + "J";
              break;
            case 11:
              assemble = assemble + "K";
              break;
            case 12:
              assemble = assemble + "L";
              break;
            case 13:
              assemble = assemble + "M";
              break;
            case 14:
              assemble = assemble + "N";
              break;
            case 15:
              assemble = assemble + "O";
              break;
            case 16:
              assemble = assemble + "P";
              break;
            case 17:
              assemble = assemble + "Q";
              break;
            case 18:
              assemble = assemble + "R";
              break;
            case 19:
              assemble = assemble + "S";
              break;
            case 20:
              assemble = assemble + "T";
              break;
            case 21:
              assemble = assemble + "U";
              break;
            case 22:
              assemble = assemble + "V";
              break;
            case 23:
              assemble = assemble + "W";
              break;
            case 24:
              assemble = assemble + "X";
              break;
            case 25:
              assemble = assemble + "Y";
              break;
            case 26:
              assemble = assemble + "Z";
              break;
            case 27:
              assemble = assemble + "0";
              break;
            case 28:
              assemble = assemble + "1";
              break;
            case 29:
              assemble = assemble + "2";
              break;
            case 30:
              assemble = assemble + "3";
              break;
            case 31:
              assemble = assemble + "4";
              break;
            case 32:
              assemble = assemble + "5";
              break;
            case 33:
              assemble = assemble + "6";
              break;
            case 34:
              assemble = assemble + "7";
              break;
            case 35:
              assemble = assemble + "8";
              break;
            case 36:
              assemble = assemble + "9";
              break;
          }

        }
        System.out.println(assemble);
        if (assemble.equalsIgnoreCase(pass)) {
          System.out.println("Password is: " + assemble);
        return assemble;
        } else {
          assemble = "";
        }
      }


    }
    return "";
  }
}
    
    

