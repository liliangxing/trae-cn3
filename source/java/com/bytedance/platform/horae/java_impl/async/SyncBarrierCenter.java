package com.bytedance.platform.horae.java_impl.async;

import android.app.Application;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.sync.hook.OnHookPointTrigger;
import com.bytedance.platform.horae.java_impl.sync.hook.PerformTraversalsHookPointer;
import com.bytedance.platform.horae.java_impl.sync.hook.TimerInMessageQueue;
import com.bytedance.platform.horae.java_impl.sync.hook.TriggerFromLooperPrinter;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SyncBarrierCenter implements OnHookPointTrigger {
    private static final String TAG = "SyncBarrierCenter";
    private MessageQueue mMessageQueue;
    private boolean mSyncBarrierAdded;
    private int mToken;
    private Method postSyncBarrier;
    private Method removeSyncBarrier;
    private static SyncBarrierCenter sInstance = new SyncBarrierCenter();
    private static final Object LOCK = new Object();

    private SyncBarrierCenter() {
    }

    public void start(Application application, Looper looper) {
        new TimerInMessageQueue(this).onHook();
        new TriggerFromLooperPrinter(this).onHook();
        new PerformTraversalsHookPointer(application, this).onHook();
        try {
            this.mMessageQueue = (MessageQueue) DoubleReflectHelper.getField(Looper.class, "mQueue").get(looper);
        } catch (IllegalAccessException e) {
            Logger.m205e(TAG, e.toString());
        }
    }

    public static SyncBarrierCenter getInstance() {
        return sInstance;
    }

    public void postSyncBarrier() {
        synchronized (LOCK) {
            if (this.postSyncBarrier == null) {
                this.postSyncBarrier = DoubleReflectHelper.getMethod(MessageQueue.class, "postSyncBarrier", new Class[0]);
            }
            if (!this.mSyncBarrierAdded) {
                try {
                    this.mToken = ((Integer) this.postSyncBarrier.invoke(this.mMessageQueue, new Object[0])).intValue();
                    this.mSyncBarrierAdded = true;
                    Logger.m205e(TAG, "Sync barrier " + this.mToken + " had bean added!!!!");
                } catch (Throwable th) {
                    Logger.m205e(TAG, th.toString());
                }
            }
        }
    }

    private void removeSyncBarrier() {
        synchronized (LOCK) {
            if (this.removeSyncBarrier == null) {
                this.removeSyncBarrier = DoubleReflectHelper.getMethod(MessageQueue.class, "removeSyncBarrier", Integer.TYPE);
            }
            try {
                if (this.mSyncBarrierAdded) {
                    this.removeSyncBarrier.invoke(this.mMessageQueue, Integer.valueOf(this.mToken));
                    this.mSyncBarrierAdded = false;
                    Logger.m205e(TAG, "Sync barrier" + this.mToken + "had bean removed!!!!");
                }
            } catch (Throwable th) {
                Logger.m205e(TAG, th.toString());
            }
        }
    }

    @Override // com.bytedance.platform.horae.java_impl.sync.hook.OnHookPointTrigger
    public void onHookPointTrigger(String str) {
        removeSyncBarrier();
    }
}
