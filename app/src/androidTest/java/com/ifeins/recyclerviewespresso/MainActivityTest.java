package com.ifeins.recyclerviewespresso;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.ifeins.recyclerviewespresso.RecyclerViewItemCountAssertion.recyclerViewWithItemsCount;

/**
 * @author ifeins
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTapOnToggle_shouldRemoveLastRow() {
        onView(withId(R.id.my_switch)).perform(click());

        onView(withId(R.id.recycler_view)).check(recyclerViewWithItemsCount(2));
    }

}
