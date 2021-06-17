package algorithms.string.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.string.Pair;

public class TrieNode {
    private int freqPrefixes = 0;
    private int accessFrequency = 0;
    private boolean isAnEnd = false;
    Map<Character, TrieNode> children = new HashMap<>();

    boolean insert(String word, int index){

        if(index == word.length()){
            if(isAnEnd) return false;
            else{
                freqPrefixes++;
                isAnEnd = true;
                return true;
            }
        }

        if(children.get(word.charAt(index)) == null){
            children.put(word.charAt(index), new TrieNode());
        }
        if(children.get(word.charAt(index)).insert(word, index+1)){
            freqPrefixes++;
            return true;
        }
        return false;
    }

    boolean search(String word, int index){

        if(index == word.length()){
            if(isAnEnd){
                accessFrequency++;
            }
            return isAnEnd;
        }

        if(children.get(word.charAt(index)) == null){
            return false;
        }
        return children.get(word.charAt(index)).search(word, index+1);
    }

    boolean delete(String word, int index){

        if(word.length() == index){
            if(isAnEnd){
                freqPrefixes--;
                isAnEnd = false;
                return true;
            }
            return false;
        }

        if(children.get(word.charAt(index)) == null){
            return false;
        }

        if(children.get(word.charAt(index)).delete(word, index+1)){
            freqPrefixes--;
            if(freqPrefixes == 0){
                children.remove(word.charAt(index));
            }
            return true;
        }
        return false;
    }

    TrieNode getPrefixNode(String word, int index){
        if(word.length()==index){
            return this;
        }

        if(children.get(word.charAt(index)) == null){
            return null;
        }

        return children.get(word.charAt(index)).getPrefixNode(word, index+1);
    }

    // dfs
    List<Pair> getAllDescendentWords(String word){
        List<Pair> descendents = new ArrayList<>();
        if(isAnEnd){
            descendents.add(new Pair(word, accessFrequency));
        }

        for(char c: children.keySet()){
            String newPrefix = word + c;
            // all the arrays merge
            descendents.addAll(children.get(c).getAllDescendentWords(newPrefix));
        }
        return descendents;
    }

}
