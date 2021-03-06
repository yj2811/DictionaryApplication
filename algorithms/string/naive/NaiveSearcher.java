package algorithms.string.naive;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import algorithms.string.SearchDAOInterface;

public class NaiveSearcher implements SearchDAOInterface{
    
    // A simple hash set implementation to perform the operations
    Set<String> dictionarySet = new HashSet<>();

    public boolean insert(String word){
        return dictionarySet.add(word);
    }

    public boolean search(String word){
        return dictionarySet.contains(word);
    }

    public boolean delete(String word){
        return dictionarySet.remove(word);
    }

    public List<String> autoSuggest(String prefix){
        throw new UnsupportedOperationException();
    }

    public List<String> autoCorrect(String word){
        throw new UnsupportedOperationException();
    }

}
