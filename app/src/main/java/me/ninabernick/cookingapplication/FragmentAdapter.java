package me.ninabernick.cookingapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.ninabernick.cookingapplication.models.Recipe;

public class FragmentAdapter extends FragmentPagerAdapter {

    Context context;
    Recipe recipe;


    public FragmentAdapter(FragmentManager fragmentManager, Recipe recipe, Context context) {
        super(fragmentManager);
        this.recipe = recipe;
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return StepsFragment.newInstance(position + 1, recipe.getStepTime(position), recipe.getStepImageURL(position), recipe.getStepText(position));
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return recipe.getNumberofSteps();
    }

    // ßReturns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Step " + (position + 1);
    }

}