package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestV1 {

    SearchResult result = new SearchResult();

    int key = 3;
    int[] seq1 = {1};
    int[] seq2 = {1, 2, 3, 4, 5};

   /* @Before
    public void setup(){
        key = 3;
        seq1 = new int[1];
    }*/

    @Test public void oneElementArrayHasSearchResult() throws Exception {
        result = BinarySearch.search(1, seq1);
        assertTrue(result.isFound());
    }

    @Test public void oneElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(2, seq1);
        assertFalse(result.isFound());
    }

    @Test public void multiElementArrayHasSearchResultAtFirstPosition() throws Exception {
        result = BinarySearch.search(1, seq2);
        assertTrue(result.isFound() && result.getPosition() == 1);
    }

    @Test public void multiElementArrayHasSearchResultAtLastPosition() throws Exception {
        result = BinarySearch.search(5, seq2);
        assertTrue(result.isFound() && result.getPosition() == seq2.length);
    }

    @Test public void multiElementArrayHasSearchResultAtMiddlePosition() throws Exception {
        result = BinarySearch.search(3, seq2);
        assertTrue(result.isFound() && result.getPosition() == seq2.length/2+1);
    }

    @Test public void multiElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(20, seq2);
        assertFalse(result.isFound());
    }
}
