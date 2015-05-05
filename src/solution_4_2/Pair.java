/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution_4_2;

import java.util.Comparator;

/**
 *
 * @author R2-D2
 */
//class dot
public class Pair {

    private Integer x;
    private Integer y;

    public Pair(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    //get 
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.x;
        hash = 61 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}
