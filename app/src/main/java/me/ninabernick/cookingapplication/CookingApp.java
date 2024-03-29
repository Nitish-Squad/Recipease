package me.ninabernick.cookingapplication;

import android.app.Application;

import com.bennyhuo.swipefinishable.SwipeFinishable;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;

import me.ninabernick.cookingapplication.models.Comment;
import me.ninabernick.cookingapplication.models.Recipe;
import me.ninabernick.cookingapplication.models.SharedRecipe;

public class CookingApp extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        SwipeFinishable.INSTANCE.init(this);

        // registration of subclass below (in our case, should be recipe)
        ParseObject.registerSubclass(Recipe.class);
        ParseObject.registerSubclass(Comment.class);
        ParseObject.registerSubclass(SharedRecipe.class);


        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("cooking-guide-application")
                .clientKey("e90701f1ceb5b2e1")
                .server("http://cooking-guide.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);

        ParseFacebookUtils.initialize(getApplicationContext());
    }
}
