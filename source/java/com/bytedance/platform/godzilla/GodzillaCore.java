package com.bytedance.platform.godzilla;

import android.app.Activity;
import android.app.Application;
import com.bytedance.platform.godzilla.common.ConsumeExceptionHandler;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes4.dex */
public enum GodzillaCore {
    INSTANCE;

    private static final int ACTIVITY_STATE_DESTORY = 3;
    private static final int ACTIVITY_STATE_PAUSE = 1;
    private static final int ACTIVITY_STATE_RESUME = 0;
    private static final int ACTIVITY_STATE_STOP = 2;
    private static final String TAG = "UncaughtExceptionPlugin";
    private static HashMap<Integer, WeakReference<Activity>> mActivityMaps = new HashMap<>();
    private WeakReference<Activity> mLastResumedActivity = null;
    private WeakReference<Activity> mLastPauseActivity = null;
    private WeakReference<Activity> mLastStopActivity = null;
    private WeakReference<Activity> mLastDestoryActivity = null;
    private ConsumeExceptionHandler mConsumeExceptionHandler = null;

    GodzillaCore() {
    }

    public void init(Application application, ILog iLog, Logger.Level level) {
        if (iLog != null) {
            Logger.setLog(iLog);
        }
        if (level != null) {
            Logger.setLogLevel(level);
        }
    }

    private void registerExceptionHandlerIfNeed() {
        if (this.mConsumeExceptionHandler == null) {
            ConsumeExceptionHandler consumeExceptionHandler = new ConsumeExceptionHandler();
            this.mConsumeExceptionHandler = consumeExceptionHandler;
            consumeExceptionHandler.register();
        }
        Logger.i(TAG, "init mConsumeExceptionHandler:" + this.mConsumeExceptionHandler);
    }

    public void addUncaughtExceptionConsumer(UncaughtExceptionConsumer uncaughtExceptionConsumer) {
        registerExceptionHandlerIfNeed();
        Logger.i(TAG, "add consumer:" + uncaughtExceptionConsumer);
        this.mConsumeExceptionHandler.addExceptionConsumer(uncaughtExceptionConsumer);
    }

    public void removeUncaughtExceptionConsumer(UncaughtExceptionConsumer uncaughtExceptionConsumer) {
        Logger.i(TAG, "remove consumer:" + uncaughtExceptionConsumer);
        this.mConsumeExceptionHandler.removeExceptionConsumer(uncaughtExceptionConsumer);
    }

    public void destroy() {
        ConsumeExceptionHandler consumeExceptionHandler = this.mConsumeExceptionHandler;
        if (consumeExceptionHandler != null) {
            consumeExceptionHandler.removeAllExceptionConsumer();
        }
    }
}
