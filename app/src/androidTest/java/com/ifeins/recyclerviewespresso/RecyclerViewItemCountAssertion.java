package com.ifeins.recyclerviewespresso;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author ifeins
 */
public class RecyclerViewItemCountAssertion implements ViewAssertion {
    private final int mExpectedCount;

    public static ViewAssertion recyclerViewWithItemsCount(int expectedCount) {
        return new RecyclerViewItemCountAssertion(expectedCount);
    }

    private RecyclerViewItemCountAssertion(int expectedCount) {
        mExpectedCount = expectedCount;
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        assertThat(adapter.getItemCount(), is(mExpectedCount));
    }
}
