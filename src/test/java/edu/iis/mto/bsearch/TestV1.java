package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TestV1 {

    SearchResult result = new SearchResult();

    int key = 3;
    int[] seqSingle = {1};
    int[] seqMulti = {1, 2, 3, 4, 5};
   /* @Before
    public void setup(){
        key = 3;
        seqSingle = new int[1];
    }*/


   // TESTY V1

    @Test public void oneElementArrayHasSearchResult() throws Exception {
        result = BinarySearch.search(1, seqSingle);
        assertThat(true,is(result.isFound()));
    }

    @Test public void oneElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(2, seqSingle);
        assertThat(false,is(result.isFound()));
    }

    @Test public void multiElementArrayHasSearchResultAtFirstPosition() throws Exception {
        result = BinarySearch.search(1, seqMulti);
        assertThat(1,is(result.getPosition()));
    }

    @Test public void multiElementArrayHasSearchResultAtLastPosition() throws Exception {
        result = BinarySearch.search(5, seqMulti);
        assertTrue(result.isFound() && result.getPosition() == seqMulti.length);

    }

    @Test public void multiElementArrayHasSearchResultAtMiddlePosition() throws Exception {
        result = BinarySearch.search(3, seqMulti);
        assertTrue(result.isFound() && result.getPosition() == seqMulti.length/2+1);
    }

    @Test public void multiElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(20, seqMulti);
        assertFalse(result.isFound());
    }
    


}
