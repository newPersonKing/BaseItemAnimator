package com.gy.library.animation;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Interpolator;

import com.gy.library.BaseItemAnimator;

/**
 * Created by emcc-pc on 2018/4/27.
 */

public class FadeInAnimator extends BaseItemAnimator {

    public FadeInAnimator() {}

    public FadeInAnimator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }
    /*添加动画 从0到1 的变化*/
    @Override
    protected void animateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .alpha(1)
                .setDuration(getAddDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultAddVpaListener(holder))
                .setStartDelay(getAddDelay(holder))
                .start();
    }

   /*添加动画前设置初始值*/
    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        holder.itemView.setAlpha(0.5f);
    }

    @Override
    protected void animateRemoveImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .alpha(1)
                .setDuration(getRemoveDuration())
                .setInterpolator(mInterpolator)
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }
}
