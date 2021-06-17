package algorithms.string;

public class Pair {
    String val;
    Integer freq;
    // Note that the freq here corresponds to accessFrequency and not freqPrefix

    public Integer getFrequency(){
        return freq;
    }

    public String getValue(){
        return val;
    }

    public Pair(String val, Integer freq){
        this.val = val;
        this.freq = freq;
    }
}
