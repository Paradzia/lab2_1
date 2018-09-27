package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinarySearchMiddleElementTests {

    private SearchResult result = new SearchResult();

    private int[] seqMultiOdd = {1, 2, 3, 4, 5};
    private int[] seqMultiEven = {1, 2, 3, 4, 5, 6};

    @Test public void EvenMultiElementArrayHasSearchResultAtMiddlePosition() throws Exception {
        result = BinarySearch.search(3, seqMultiOdd);
        assertThat(seqMultiOdd.length / 2 + 1, is(result.getPosition()));
    }

    @Test public void EvenMultiElementArrayHasSearchResultAtMiddlePositionMinusOne() throws Exception {
        result = BinarySearch.search(2, seqMultiOdd);
        assertThat(seqMultiOdd.length / 2, is(result.getPosition()));
    }

    @Test public void EvenMultiElementArrayHasSearchResultAtMiddlePositionPlusOne() throws Exception {
        result = BinarySearch.search(4, seqMultiOdd);
        assertThat(seqMultiOdd.length / 2 + 2, is(result.getPosition()));
    }

    @Test public void oddMultiElementArrayHasSearchResultAtMiddleLeftPosition() throws Exception {
        result = BinarySearch.search(3, seqMultiEven);
        assertThat(seqMultiEven.length / 2, is(result.getPosition()));
    }

    @Test public void oddMultiElementArrayHasSearchResultAtMiddleRightPosition() throws Exception {
        result = BinarySearch.search(4, seqMultiEven);
        assertThat(seqMultiEven.length / 2 + 1, is(result.getPosition()));
    }
}
