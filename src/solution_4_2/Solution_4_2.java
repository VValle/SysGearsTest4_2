/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_4_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author R2-D2
 */
public class Solution_4_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan  = new Scanner(System.in);
        List<Pair> dots = new ArrayList<Pair>();
        Random rand = new Random();
        //input size
        System.out.println("Input count dots");
        int size = scan.nextInt();
        //fill array dots, without duplicating
        while (dots.size() != size) {
            //generate dot
            Pair tmp = new Pair(rand.nextInt(20) - 10, rand.nextInt(20) - 10);
            //if list donthave this dot, add it
            //else generate new
            if (!dots.contains(tmp)) {
                dots.add(tmp);
            }
        }
        // print dot
        System.out.println("Your dots: ");
        printList(dots);
        //sort sequence
        Processor processor = new Processor(dots);
        
        //print sorted dot
        System.out.println("Sequence dots without selfintersection: ");
        System.out.println("----------------------------------------------");
        processor.calculate();
        printList(processor.getResultList());
     
    }
    
    
    public static void printList (List<Pair> dots){
         for (int i = 0; i < dots.size(); i++) {
            System.out.println("{" + dots.get(i).getX() + " : " + dots.get(i).getY() + "}");
        }
    }
  
    
}
