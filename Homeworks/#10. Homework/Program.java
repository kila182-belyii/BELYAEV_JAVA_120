import java.util.Arrays;
import java.util.Scanner;
public class Program {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         char text[];
         String input = scanner.nextLine();       
         while (!input.equals("quit")) { 
           text = input.toCharArray();
           printMaxCountCharLatin(text);
           printMaxCountCharKirill(text);
           input = scanner.nextLine();         
         }       
     }
     public static void printMaxCountCharLatin(char[] text) {
         int count[] = new int[26];
         for (int i = 0; i < text.length; i++) {
            int charCode = (int)text[i];
            if (charCode > 'Z') {
               charCode = charCode - 32;
            }
            charCode = charCode - 'A';
            if ((charCode >= 0) && (charCode < 25)) {
               count[charCode]++;
            }
         }
         int maxCount = 0;
         for (int i = 0; i < count.length; i++) {
           if (count[i] > maxCount) {
                maxCount = count[i];
           }
         }
         if (maxCount > 0) {
           for (int i = 0; i < count.length; i++) {
              if (count[i] == maxCount) {
                System.out.println((char)(i + 65 + 32) + ":" + maxCount);
              }
           }
         }        
     }      
     public static void printMaxCountCharKirill(char[] text) {
         //массив для подсчета кол-ва присутствющих симовлов независимо от регистра
         int count[] = new int[33];               
         for (int i = 0; i < text.length; i++) {
           int charCode = (int)text[i];
           //отображаем код символа в диапазон массива [0-32]
           //для символа 'ё' отдельный алгоритм
           if ((charCode == 'Ё') || (charCode == 'ё')) {
                count[32]++;
           } else {
                if (charCode > 'Я') {
                 charCode = charCode - 32;
                }
                charCode = charCode - 'А';
                if ((charCode >= 0) && (charCode < 32)) {
                 count[charCode]++;
                }
           }           
         }
         int maxCount = 0;
         for (int i = 0; i < count.length; i++) {
           if (count[i] > maxCount) {
                maxCount = count[i];
           }
         }
         if (maxCount > 0) {
           for (int i = 0; i < count.length; i++) {
                if (count[i] == maxCount) {
                 if (i == 32) {
                      System.out.println('ё' + ":" + maxCount);
                 } else {
                      System.out.println((char)(i + 1040 + 32) + ":" + maxCount);
                 }      
                }
           }
         }        
     }           
}
