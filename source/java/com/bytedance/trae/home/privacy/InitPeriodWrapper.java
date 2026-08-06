package com.bytedance.trae.home.privacy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitPeriodWrapper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;", "", "<init>", "()V", "TAG", "", "notifyAllPeriod", "", "activity", "Landroid/app/Activity;", "applicationAttachBeforeSuper", "context", "Landroid/content/Context;", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "beforeSuperCreate", "afterSuperCreateStart", "afterSuperCreateEnd", "beforeSuperResume", "afterSuperResume", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitPeriodWrapper {
    public static final int $stable = 0;
    public static final InitPeriodWrapper INSTANCE = new InitPeriodWrapper();
    public static final String TAG = "InitPeriodWrapper";

    private InitPeriodWrapper() {
    }

    public final void notifyAllPeriod(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.d(TAG, "InitPeriodWrapper - notifyAllPeriod = " + System.currentTimeMillis());
        Context baseContext = activity.getApplication().getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        applicationAttachBeforeSuper(baseContext);
        applicationAttachAfterSuper();
        Application application = activity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        applicationCreateBeforeSuper(application);
        applicationCreateAfterSuper();
        beforeSuperCreate(activity);
        afterSuperCreateStart();
        afterSuperCreateEnd();
        beforeSuperResume();
        afterSuperResume();
    }

    public final void applicationAttachBeforeSuper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - before application attach, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodStart(InitPeriod.APP_ATTACHBASE2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.APP_ATTACHBASE2SUPER);
    }

    public final void applicationAttachAfterSuper() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        InitScheduler.onPeriodStart(InitPeriod.APP_SUPER2ATTACHBASEEND);
        InitScheduler.onPeriodEnd(InitPeriod.APP_SUPER2ATTACHBASEEND);
    }

    public final void applicationCreateBeforeSuper(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - before application create, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodStart(InitPeriod.APP_ONCREATE2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.APP_ONCREATE2SUPER);
    }

    public final void applicationCreateAfterSuper() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - after application create, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodStart(InitPeriod.APP_SUPER2ONCREATEEND);
        InitScheduler.onPeriodEnd(InitPeriod.APP_SUPER2ONCREATEEND);
        InitScheduler.startDispatchDelayTask();
        InitScheduler.startDispatchIdleTask();
    }

    public final void beforeSuperCreate(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InitScheduler.registerMainActivity(activity);
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - before super activity create, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodStart(InitPeriod.MAIN_ONCREATE2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.MAIN_ONCREATE2SUPER);
    }

    public final void afterSuperCreateStart() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - after super activity start, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodStart(InitPeriod.MAIN_SUPER2ONCREATEEND);
    }

    public final void afterSuperCreateEnd() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        Log.d(TAG, "InitPeriodWrapper - after super activity end, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodEnd(InitPeriod.MAIN_SUPER2ONCREATEEND);
    }

    public final void beforeSuperResume() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        InitScheduler.onPeriodStart(InitPeriod.MAIN_ONRESUME2SUPER);
        InitScheduler.onPeriodEnd(InitPeriod.MAIN_ONRESUME2SUPER);
    }

    public final void afterSuperResume() {
        if (PrivacyManager.INSTANCE.notifyStartEventDelay()) {
            return;
        }
        InitScheduler.onPeriodStart(InitPeriod.MAIN_SUPER2ONRESUMEEND);
        InitScheduler.onPeriodEnd(InitPeriod.MAIN_SUPER2ONRESUMEEND);
    }
}
