package com.bytedance.notification.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.common.notification.R;
import com.bytedance.common.push.notification.BaseBannerActivity;
import com.bytedance.notification.helper.BannerActivityHelper;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.ttm.player.C;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes4.dex */
public class BannerActivity extends BaseBannerActivity {
    private final String TAG = "BannerActivityTag";
    private boolean mNeedFinishPending = true;
    private int mDisMissAnimal = R.anim.banner_out;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.d("BannerActivityTag", "onCreate of BannerActivity, sIsShowing is " + BannerActivityHelper.getInstance().isShowing());
        if (BannerActivityHelper.getInstance().isShowing()) {
            Logger.w("BannerActivityTag", "onCreate of BannerActivity, sIsShowing is true,finish self");
            finish();
            return;
        }
        BannerActivityHelper.getInstance().setBannerActivityRef(new WeakReference<>(this));
        BannerActivityHelper.getInstance().setShowing(true);
        WeakReference<View> bannerViewRef = BannerActivityHelper.getInstance().getBannerViewRef();
        if (bannerViewRef == null) {
            Logger.w("BannerActivityTag", "bannerViewRef is null,finish self");
            finish();
            return;
        }
        View view = bannerViewRef.get();
        if (view == null) {
            Logger.w("BannerActivityTag", "bannerView is null,finish self");
            finish();
            return;
        }
        Window window = getWindow();
        try {
            window.setGravity(49);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 35;
            attributes.y = BannerActivityHelper.getInstance().getMarginTop() + getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
            attributes.height = -2;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setFlags(32, 32);
            setContentView(view);
            overridePendingTransition(R.anim.banner_in, R.anim.banner_silent);
            Logger.d("onCreate of BannerActivity, sDuration is " + BannerActivityHelper.getInstance().getDuration());
            view.postDelayed(new Runnable() { // from class: com.bytedance.notification.activity.BannerActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.d("finish BannerActivity");
                    BannerActivity.this.finish();
                }
            }, BannerActivityHelper.getInstance().getDuration());
            PushNotificationSupporter.get().onBannerNotificationShow(BannerActivityHelper.getInstance().getMsgId(), true, "success", "actual");
        } catch (Throwable th) {
            Logger.e("BannerActivityTag", "exception in banner,finish self ", th);
            finish();
        }
    }

    public void finishSelf(boolean z, int i) {
        Log.d("BannerActivityTag", "finishSelf");
        this.mNeedFinishPending = z;
        this.mDisMissAnimal = i;
        if (BannerActivityHelper.getInstance().isShowing()) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        ActivityManager.AppTask appTask;
        BannerActivityHelper.getInstance().finish();
        super.finish();
        Log.d("BannerActivityTag", "on finish, mNeedFinishPending is " + this.mNeedFinishPending + " mDisMissAnimal is " + this.mDisMissAnimal);
        if (this.mNeedFinishPending) {
            overridePendingTransition(0, this.mDisMissAnimal);
        }
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) getSystemService(ActivityManager.class)).getAppTasks();
        if (appTasks != null) {
            Log.d("BannerActivityTag", "tasks size is " + appTasks.size());
            if (appTasks.size() <= 0 || (appTask = appTasks.get(0)) == null) {
                return;
            }
            Logger.d("BannerActivityTag", "set topTask excludeFrom Recents to true");
            appTask.setExcludeFromRecents(true);
        }
    }

    public static void showBannerView(Context context, View view, int i, long j) {
        Class cls;
        BannerActivityHelper.getInstance().setBannerViewRef(new WeakReference<>(view));
        BannerActivityHelper.getInstance().setMarginTop(i);
        BannerActivityHelper.getInstance().setDuration(j);
        try {
            if (ToolUtils.isSmpProcess(context)) {
                cls = SmpBannerActivity.class;
            } else {
                cls = BannerActivity.class;
            }
            Intent intent = new Intent(context, (Class<?>) cls);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
        } catch (Throwable th) {
            Logger.e("showBannerView", th.getMessage());
        }
    }

    public static void setBannerView(View view, int i, long j, long j2) {
        BannerActivityHelper.getInstance().setBannerViewRef(new WeakReference<>(view));
        BannerActivityHelper.getInstance().setMarginTop(i);
        BannerActivityHelper.getInstance().setDuration(j);
        BannerActivityHelper.getInstance().setMsgId(j2);
    }
}
