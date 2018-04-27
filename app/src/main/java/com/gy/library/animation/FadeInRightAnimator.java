package com.gy.library.animation;



import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Interpolator;

import com.gy.library.BaseItemAnimator;

public class FadeInRightAnimator extends BaseItemAnimator {

  public FadeInRightAnimator() {
  }

  public FadeInRightAnimator(Interpolator interpolator) {
    mInterpolator = interpolator;
  }

  @Override protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
    ViewCompat.animate(holder.itemView)
            .translationX(holder.itemView.getRootView().getWidth() * .25f)
            .alpha(0)
            .setDuration(getRemoveDuration())
            .setInterpolator(mInterpolator)
            .setListener(new DefaultRemoveVpaListener(holder))
            .setStartDelay(getRemoveDelay(holder))
            .start();
  }

  @Override
  protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {

    holder.itemView.setTranslationX(holder.itemView.getRootView().getWidth() * .25f);
    holder.itemView.setAlpha(0);
  }

  @Override protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
    ViewCompat.animate(holder.itemView)
            .translationX(0)
            .alpha(1)
            .setDuration(getAddDuration())
            .setInterpolator(mInterpolator)
            .setListener(new DefaultAddVpaListener(holder))
            .setStartDelay(getAddDelay(holder))
            .start();
  }
}
