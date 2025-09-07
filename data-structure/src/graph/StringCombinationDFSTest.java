package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringCombinationDFSTest {

    @Test
    void letterCombinations() {
        StringCombinationDFS stringCombinationDFS = new StringCombinationDFS();
        ArrayList<String> list = new ArrayList<>(
                List.of("ad","ae","af","bd","be","bf","cd","ce","cf")
        );
        assertEquals(list, stringCombinationDFS.letterCombinations("23"));
    }
}