package com.gy.library.animation;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

import com.gy.library.BaseItemAnimator;

public class ScaleInAnimator extends BaseItemAnimator {

  public ScaleInAnimator() {
  }

  public ScaleInAnimator(Interpolator interpolator) {
    mInterpolator = interpolator;
  }

  @Override
  protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
    Log.i("cccccccccccc","animateRemoveImpl");
    ViewCompat.animate(holder.itemView)
        .scaleX(0)
        .scaleY(0)
        .setDuration(getRemoveDuration())
        .setInterpolator(mInterpolator)
        .setListener(new DefaultRemoveVpaListener(holder))
        .setStartDelay(getRemoveDelay(holder))
        .start();
  }

  @Override
  protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
    Log.i("cccccccccccc","preAnimateAddImpl");
    holder.itemView.setScaleX(0);
    holder.itemView.setScaleY(0);
  }

  @Override
  protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
    Log.i("cccccccccccc","animateAddImpl");
    ViewCompat.animate(holder.itemView)
        .scaleX(1)
        .scaleY(1)
        .setDuration(getAddDuration())
        .setInterpolator(mInterpolator)
        .setListener(new DefaultAddVpaListener(holder))
        .setStartDelay(getAddDelay(holder))
        .start();
  }
}
