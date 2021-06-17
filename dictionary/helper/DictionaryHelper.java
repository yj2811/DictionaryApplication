package dictionary.helper;

import java.util.List;

// Interface for a business implementation (template for features)
// Provides loose coupling
public interface DictionaryHelper {
    public boolean insert(String word);

    public boolean search(String word);

    public boolean delete(String word);

    public List<String> autoSuggest(String prefix);

    public List<String> autoCorrect(String word);
}
