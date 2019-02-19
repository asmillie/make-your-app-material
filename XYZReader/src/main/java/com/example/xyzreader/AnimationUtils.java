package com.example.xyzreader;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;

import static android.support.v4.app.ActivityCompat.startPostponedEnterTransition;

public class AnimationUtils {

    private AnimationUtils() {}

    /*
        From guide @ https://www.androiddesignpatterns.com/2015/03/activity-postponed-shared-element-transitions-part3b.html
     */

    /**
     * Call on a view when it is ready to animate the enter transition
     * @param activity The activity the view is contained in
     * @param sharedElement The view being animated
     */
    public static void scheduleStartPostponedTransition(final Activity activity, final View sharedElement) {
        sharedElement.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                        startPostponedEnterTransition(activity);
                        return true;
                    }
                });
    }
}
