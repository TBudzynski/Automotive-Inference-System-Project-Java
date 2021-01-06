package core;

import java.util.ArrayList;
import JaCoP.core.*;  
import JaCoP.constraints.*;  
import JaCoP.search.*;

/**
 * Parent class for CLP problem modeling
 * 
 * @author Tomasz Budzynski
 */
public class CLP {
    private int size;
    protected IntVar[] v;
    protected Store store = new Store();
    protected Search<IntVar> search = new DepthFirstSearch<IntVar>();
    protected ArrayList<IntVar> vars = new ArrayList<IntVar>();
    
    /**
     * Constructor of CLP class.
     * Initiates an object with 0 as default value of size parameter.
     */
 
   
    protected void model() {    
    }
    
    /**
     * pusta metoda .
     * 
     */
    protected void search(){
        /**
         * pusta metoda.
         */
    }
}
