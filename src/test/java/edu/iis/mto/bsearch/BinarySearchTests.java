package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchTests {

    SearchResult result = new SearchResult();

    private int[] seqSingle = {1};
    private int[] seqMultiOdd = {1, 2, 3, 4, 5};
    private int[] seqMultiEven = {1, 2, 3, 4, 5, 6};

    @Test public void oneElementArrayHasSearchResult() throws Exception {
        result = BinarySearch.search(1, seqSingle);
        assertThat(true, is(result.isFound()));
    }

    @Test public void oneElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(2, seqSingle);
        assertThat(false, is(result.isFound()));
    }

    @Test public void multiElementArrayHasSearchResultAtFirstPosition() throws Exception {
        result = BinarySearch.search(1, seqMultiOdd);
        assertThat(1, is(result.getPosition()));
    }

    @Test public void multiElementArrayHasSearchResultAtLastPosition() throws Exception {
        result = BinarySearch.search(5, seqMultiOdd);
        assertThat(seqMultiOdd.length, is(result.getPosition()));

    }

    @Test public void multiElementArrayHasNotSearchResult() throws Exception {
        result = BinarySearch.search(20, seqMultiOdd);
        assertThat(false, is(result.isFound()));
    }

    @Test(expected = IllegalArgumentException.class) public void sequenceIsEmpty() {
        int[] empty = new int[0];
        BinarySearch.search(1, empty);
    }

    @Test(expected = IllegalArgumentException.class) public void sequenceIsNotSorted() {
        int[] seqNotSorted = {7, 3, 4, 21, 54, 1, 13, 9};
        BinarySearch.search(1, seqNotSorted);
    }

}
