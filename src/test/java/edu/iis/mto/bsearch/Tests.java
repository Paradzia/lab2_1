package edu.iis.mto.bsearch;

import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Tests {

    SearchResult result = new SearchResult();

    int key = 3;
    int[] seqSingle = {1};
    int[] seqMulti = {1, 2, 3, 4, 5};
   /* @Before
    public void setup(){
        key = 3;
        seqSingle = new int[1];
    }*/


    @Test
    public void oneElementArrayHasSearchResult() throws Exception {
        result = BinarySearch.search(1, seqSingle);
        assertThat(true, is(result.isFound()));
    }

    @Test
    public void oneElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(2, seqSingle);
        assertThat(false, is(result.isFound()));
    }

    @Test
    public void multiElementArrayHasSearchResultAtFirstPosition() throws Exception {
        result = BinarySearch.search(1, seqMulti);
        assertThat(1, is(result.getPosition()));
    }

    @Test
    public void multiElementArrayHasSearchResultAtLastPosition() throws Exception {
        result = BinarySearch.search(5, seqMulti);
        assertThat(seqMulti.length, is(result.getPosition()));

    }

    @Test
    public void multiElementArrayHasSearchResultAtMiddlePosition() throws Exception {
        result = BinarySearch.search(3, seqMulti);
        assertThat(seqMulti.length / 2 + 1, is(result.getPosition()));
    }

    @Test
    public void multiElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(20, seqMulti);
        assertThat(false, is(result.isFound()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceIsEmpty() {
        int[] empty = new int[0];
        BinarySearch.search(1, empty);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sequenceIsNotSorted() {
        int[] seqNotSorted = {7, 3, 4, 21, 54, 1, 13, 9};
        BinarySearch.search(1, seqNotSorted);
    }


}
