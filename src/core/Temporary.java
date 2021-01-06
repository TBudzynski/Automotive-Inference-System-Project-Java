package core;

import JaCoP.core.*;  
import JaCoP.constraints.*;  
import JaCoP.search.*;

/**
 * Temporary class inheriting from CLP.
 * 
 * @author Tomasz Budzynski
 */
public class Temporary extends CLP {
    
    /**
     * Initializes IntVar array and tests global constraint.
     * Created IntVar array stores 4 variables, each of them
     * contains numbers [1..6] with aliases being respectively: 
     * v1, v2, v3 , v4,v5 and v6. Tested global constraint is Alldifferent().
     * 
     */
    public void model()
    {
     
      
        v=new IntVar[6];
        for (int i=0;i<6;i++)
        {
           v[i]=new IntVar(store,"v"+i,1,6);
        }
        Constraint ctr = new Alldifferent(v); 
        store.impose(ctr);
        
    }

    /**
     * Creates an object of SelectChoicePoint() class, 
     * runs search and prints on the console search result.
     * Method uses IntVar array created in model() method.
     * 
     * @see model()
    */
    public void search()
    {
        SelectChoicePoint<IntVar> select = 
            new InputOrderSelect<IntVar>(store, v, new IndomainMin<IntVar>()); 
        boolean result = search.labeling(store, select); 
        
        if ( result ) 
            System.out.println("Solution: " + v[0]+", "
                    + v[1] +", "+ v[2] +", " +v[3] + v[4] +", " +v[5]  ); 
        else 
        
            System.out.println("Nie ma rozwiazan!"); 
    }
        
}
