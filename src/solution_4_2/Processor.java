/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_4_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author R2-D2
 */
public class Processor {

    private List<Pair> dots;
    private List<Pair> resultList;

    public Processor(List list) {
        dots = list;
        resultList = new ArrayList<Pair>();

    }

    //find sequense

    public void calculate() {

        List<Pair> list = new ArrayList<Pair>(dots);
        int last = 0;
        resultList.add(list.get(last));
        //find next dot, and delete pre
        do {
            last = remove(last, list);
        } while (list.size() != 1);

    }

    public List<Pair> getResultList() {
        return resultList;
    }

    public int remove(int i, List<Pair> list) {
        /*
         get "lines" between 2 dot, and looking for a point
         above or below that do not have other points .
         Use factor D.
         Suppose we have 3 points A ( x1, y1 ) and B ( x2, y2 ), C ( x3 , y3 ) . Through the points A and B, a line is drawn .
         And we need to determine how to point C is relatively straight AB . To calculate this value:
         D = ( x3 - x1) ( y2 - y1 ) - ( Y3 - y1 ) (x2 - x1)
         - If D = 0 - means the point C lies on the line AB .
         - If D < 0 - means the point C is left of the line .
         - If D> 0 - means the point C lies to the right of the line.         
         */
        for (int j = 0; j < list.size(); j++) {
            if (i != j) {
                float d = list.get(j).getX() - list.get(i).getX();
                if (d == 0) {
                    d = 1;
                }
                int below = 0;
                int under = 0;
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        //calculate D, and find count dot below and under
                        float D = (list.get(k).getX() - list.get(i).getX()) * (list.get(j).getY()
                                - list.get(i).getY()) - (list.get(k).getY() - list.get(i).getY()) * (list.get(j).getX() - list.get(i).getX());
                        if (D < 0) {
                            below++;
                        } else {
                            under++;
                        }
                    }
                }
                // if under or below we have no dots, get this dot
                if (below == 0 || under == 0) {
                    Pair m = list.get(j);
                    resultList.add(list.get(j));
                    list.remove(i);
                    // return index this dot
                    return list.indexOf(m);
                }
            }
        }
        return 0;
    }
}
