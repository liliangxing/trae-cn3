package com.bytedance.notification.helper;

import android.util.Log;
import android.view.View;
import com.bytedance.common.notification.R;
import com.bytedance.notification.activity.BannerActivity;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class BannerActivityHelper {
    private static volatile BannerActivityHelper sBannerActivityHelper;
    private WeakReference<BannerActivity> mBannerActivityRef;
    private WeakReference<View> mBannerViewRef;
    private long mDuration;
    private boolean mIsShowing = false;
    private int mMarginTop;
    private long mMsgId;
    public static int DISMISS_ANIMAL_FROM_LEFT_TO_RIGHT = R.anim.banner_out_to_right;
    public static int DISMISS_ANIMAL_FROM_RIGHT_TO_LEFT = R.anim.banner_out_to_left;
    public static int DISMISS_ANIMAL_FROM_BOTTOM_TO_TOP = R.anim.banner_out_to_top;

    public static BannerActivityHelper getInstance() {
        if (sBannerActivityHelper == null) {
            synchronized (BannerActivityHelper.class) {
                if (sBannerActivityHelper == null) {
                    sBannerActivityHelper = new BannerActivityHelper();
                }
            }
        }
        return sBannerActivityHelper;
    }

    private BannerActivityHelper() {
    }

    public WeakReference<BannerActivity> getBannerActivityRef() {
        Log.d("BannerActivityTag", "getBannerActivityRef ");
        return this.mBannerActivityRef;
    }

    public BannerActivityHelper setBannerActivityRef(WeakReference<BannerActivity> weakReference) {
        Log.d("BannerActivityTag", "setBannerActivityRef:" + weakReference);
        this.mBannerActivityRef = weakReference;
        return this;
    }

    public WeakReference<View> getBannerViewRef() {
        return this.mBannerViewRef;
    }

    public BannerActivityHelper setBannerViewRef(WeakReference<View> weakReference) {
        this.mBannerViewRef = weakReference;
        return this;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public BannerActivityHelper setMarginTop(int i) {
        this.mMarginTop = i;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public BannerActivityHelper setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public BannerActivityHelper setMsgId(long j) {
        this.mMsgId = j;
        return this;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public BannerActivityHelper setShowing(boolean z) {
        this.mIsShowing = z;
        return this;
    }

    public void finish() {
        this.mIsShowing = false;
        this.mMsgId = 0L;
        this.mDuration = 0L;
        this.mBannerActivityRef = null;
        this.mBannerViewRef = null;
    }
}
