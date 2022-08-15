package com.example.wordsapp

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class OrderOfTestAnnotations{
    @Before
    fun setup(){
        print("Set up function")
    }
    @Test
    fun test_a(){
        print("Test a")
    }
}
class NavigationTests {
    @Test
    fun navigate_to_words_nav_component() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        val letterListScenario = launchFragmentInContainer<LetterListFragment>(
            themeResId =
            R.style.Theme_Words
        )

        letterListScenario.onFragment { fragment ->

            navController.setGraph(R.navigation.nav_graph)

            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click())
            )

        assertEquals(navController.currentDestination?.id, R.id.wordListFragment)


    }

    lateinit var navController: TestNavHostController

    lateinit var letterListScenario: FragmentScenario<LetterListFragment>

    @Before
    fun setup(){
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        letterListScenario =  launchFragmentInContainer(themeResId=R.style.Theme_Words)

        letterListScenario.onFragment { fragment ->

            navController.setGraph(R.navigation.nav_graph)

            Navigation.setViewNavController(fragment.requireView(),  navController)
        }
    }
}
