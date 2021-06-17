package algorithms.string;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair>{
    
    public int compare(Pair p1, Pair p2){
        if(p1.freq < p2.freq){
            return 1;
        }
        else if(p1.freq > p2.freq){
            return -1;
        }
        return 0;
    }
}
