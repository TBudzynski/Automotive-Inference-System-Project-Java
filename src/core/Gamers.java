    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package core;

    import JaCoP.core.*;
    import JaCoP.constraints.*;
    import JaCoP.search.*;

    /**
     *
     * @author Tomasz Budzynski
     */
    
    // po skompilowaniu pokazuja się wyniki dla wszystkich mężczyzn. Interesuje nas wynik Deana, który posiada ID =3 
    public class Gamers extends CLP {
            
         public void model(){
        System.out.println("Program solving 4 gamers problem ");
    
         IntVar[] names = new IntVar[4];
          //Indexes of names.
            int  Adam= 0, 
                Bill= 1, 
                Charles = 2, 
                Dean= 3;

            IntVar[] games = new IntVar[4];
            //Indexes of games.
            int bridge = 0, 
                chess = 1, 
               checkers = 2, 
               domino = 3;



            IntVar[] sport = new IntVar[4];
            //Indexes of sports.
            int bicycle = 0, 
                swimming = 1, 
                tennis = 2, 
                skiing = 3; 

            String[] peopleNames = {"Adam", "Bill", "Charls", "Dean"};
            String[] gamesNames = {"Bridge", "Chess","Checkers" , "Domino"};
            String[] sportNames = {"Bicycle", "Tennis", "Swims", "Skiing"};

        
          
         

            for(int i = 0; i < 4; i++){
                names[i] = new IntVar(store,"\n" + peopleNames[i] + " people has ID", 0, 3);
                games[i] = new IntVar(store,"\n" + gamesNames[i] + " is favourite game in people with ID", 0, 3);
                sport[i] = new IntVar(store,"\n" + sportNames[i] + " is favourite sport in people with ID", 0, 3);

                vars.add(names[i]);
                vars.add(games[i]);
                vars.add(sport[i]);
            }


            store.impose( new Alldifferent(names));
            store.impose( new Alldifferent(games));
            store.impose( new Alldifferent(sport));

        /*
        *ograniczenia które ustawiają logikę sentencji napisanych nad ograniczeniem. 
        */
           /*
            Adam gra w szachy
            */
            store.impose(new XeqC(games[chess],Adam));
            /*

            Bicycle rider plays checkers really well.
            */
                    store.impose(new XeqY(sport[bicycle], games[checkers]));
                    /*
                    Dean does not play bridge.

                    */
                    store.impose(new XneqC(games[bridge], Dean));
                    /*

                     Charles is not the swimmer.

                    */


                    store.impose(new XneqC(sport[swimming], Charles));
                    /*
                    Adam does not ski.
                    */

                    store.impose(new XneqC(sport[skiing], Adam));
                    /*

                    Bill does not know how to play checkers nor tennis.


                    */
                    store.impose( new And( new XneqC(games[checkers], Bill), ( new XneqC(sport[tennis], Bill))));
                    /*
                    . Dean cannot ride a bike
                    */

                    store.impose(new XneqC(sport[bicycle], Dean));
                    /*
                     Charles does not play domino.
                    */
                    store.impose(new XneqC(games[domino], Charles));
                    /*
                     Bridge player cannot ski.
            */
                    store.impose(new XneqY(games[bridge], sport[skiing]));

        }

        public void search(){

            long begin;
            begin = System.currentTimeMillis();

            Search label = new DepthFirstSearch();
            SelectChoicePoint select = new SimpleSelect( vars.toArray(new Var[vars.size()]),new MostConstrainedStatic(), new IndomainMin());

            boolean result = label.labeling(store, select);

            long end;
            end = System.currentTimeMillis();

            if(result)
                store.print();
            else
                System.out.println("Failed to find any solution");

            System.out.println("Number of milliseconds: " + (end - begin));


    }
    }
    
        