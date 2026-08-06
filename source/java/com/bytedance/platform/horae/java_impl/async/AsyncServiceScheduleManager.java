package com.bytedance.platform.horae.java_impl.async;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.bytedance.platform.horae.OnEventOccur;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.ServiceFollowBean;
import com.bytedance.platform.horae.java_impl.barrier.BarrierMonitor;
import com.bytedance.rts.foundation.Int64;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AsyncServiceScheduleManager implements Runnable {
    private static final int INTINIT = -1;
    private static final long THE_SMALLEST_INTERVAL = 2000;
    private static final String TeaEventBarrierTag = "tt_removeBarrier";
    private static AsyncServiceScheduleManager sInstance;
    private Application mContext;
    private MessageQueue mMessageQueue;
    private Field mMessagesHeadField;
    private Field mNextField;
    private OnEventOccur mOnEventOccur;
    public Handler mScheduleCenter;
    private Looper mScheduleLooper;
    private long mStartTimeStamp;
    private boolean mStopped;
    private long mTimeStamp;
    private boolean isInitial = false;
    private boolean mDangerBarrierFeature = false;
    private long mWorkTime = Int64.MAX_VALUE;

    private AsyncServiceScheduleManager() {
    }

    public static AsyncServiceScheduleManager getInstance() {
        if (sInstance == null) {
            synchronized (AsyncServiceScheduleManager.class) {
                if (sInstance == null) {
                    sInstance = new AsyncServiceScheduleManager();
                }
            }
        }
        return sInstance;
    }

    public void start(Application application, String str, OnEventOccur onEventOccur, boolean z, long j) {
        if (this.isInitial) {
            return;
        }
        this.mStartTimeStamp = System.currentTimeMillis();
        this.mWorkTime = j;
        this.mOnEventOccur = onEventOccur;
        this.isInitial = true;
        this.mContext = application;
        this.mDangerBarrierFeature = z;
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        AsyncServiceTrackMonitor.getInstance().start();
        this.mScheduleLooper = handlerThread.getLooper();
        this.mScheduleCenter = new AsyncScheduleCenter(this.mScheduleLooper);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mScheduleCenter.post(new Runnable() { // from class: com.bytedance.platform.horae.java_impl.async.AsyncServiceScheduleManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.m205e("AsyncServiceScheduleManager", "start await!");
                    countDownLatch.await();
                    if (AsyncServiceScheduleManager.this.mOnEventOccur != null) {
                        AsyncServiceScheduleManager.this.mOnEventOccur.onAsyncStart(0);
                    }
                    Logger.m205e("AsyncServiceScheduleManager", "end await!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.platform.horae.java_impl.async.AsyncServiceScheduleManager.2
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
                Logger.m205e("AsyncServiceScheduleManager", "UI thread execute countDown!");
            }
        });
        this.mScheduleCenter.postDelayed(this, THE_SMALLEST_INTERVAL);
        OnEventOccur onEventOccur2 = this.mOnEventOccur;
        if (onEventOccur2 != null) {
            onEventOccur2.onInitialSuccessOccur();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Message message;
        int onFirstMessageOfMessageQueueArrive;
        long j2;
        Logger.m205e("ServiceScheduleManager", "Enter loop()!!! is sync = ");
        if (this.mMessageQueue == null || this.mNextField == null || this.mMessagesHeadField == null) {
            try {
                this.mMessageQueue = (MessageQueue) DoubleReflectHelper.getField(Looper.class, "mQueue").get(Looper.getMainLooper());
                this.mMessagesHeadField = DoubleReflectHelper.getField(MessageQueue.class, "mMessages");
                this.mNextField = DoubleReflectHelper.getField(Message.class, "next");
            } catch (Exception unused) {
                Logger.m205e("ServiceScheduleManager", "Hook fail, stop loop()");
                return;
            }
        }
        if (this.mStopped || System.currentTimeMillis() - this.mStartTimeStamp > this.mWorkTime) {
            this.mStopped = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.platform.horae.java_impl.async.AsyncServiceScheduleManager.3
                @Override // java.lang.Runnable
                public void run() {
                    AsyncServiceScheduleManager.this.sendStopMessageToProtectThread();
                }
            });
            return;
        }
        if (this.mDangerBarrierFeature) {
            BarrierMonitor.getInstance().initBarrierMonitorReflect();
        }
        long j3 = THE_SMALLEST_INTERVAL;
        try {
            synchronized (this.mMessageQueue) {
                Message message2 = (Message) this.mMessagesHeadField.get(this.mMessageQueue);
                message = null;
                onFirstMessageOfMessageQueueArrive = (message2 == null || !this.mDangerBarrierFeature) ? -1 : BarrierMonitor.getInstance().onFirstMessageOfMessageQueueArrive(new WeakReference<>(message2));
                while (message2 != null) {
                    if (AsyncMessageHandleUtils.isServiceOrReceiverMessage(message2)) {
                        Message obtain = Message.obtain(message2);
                        message2.what *= -1;
                        Message obtain2 = Message.obtain(this.mScheduleCenter);
                        obtain2.obj = obtain;
                        this.mScheduleCenter.sendMessageAtTime(obtain2, message2.getWhen());
                        message = message2;
                    }
                    message2 = (Message) this.mNextField.get(message2);
                }
            }
            if (onFirstMessageOfMessageQueueArrive != -1) {
                Logger.m207e(true, TeaEventBarrierTag, "remove last barrier token:" + onFirstMessageOfMessageQueueArrive);
            }
            if (message != null) {
                j2 = message.getWhen() - SystemClock.uptimeMillis();
                if (j2 < 0) {
                    try {
                        Logger.m205e("ServiceScheduleManager", "The last follow message is out of time ,It's dangerous now!");
                    } catch (Exception e) {
                        e = e;
                        j3 = j2;
                        Logger.m205e("ServiceScheduleManager", "Something is wrong here " + e.toString());
                        j = j3;
                        this.mScheduleCenter.postDelayed(this, j);
                    }
                }
            } else {
                j2 = 2000;
            }
            j = Math.max(j2, THE_SMALLEST_INTERVAL);
        } catch (Exception e2) {
            e = e2;
        }
        this.mScheduleCenter.postDelayed(this, j);
    }

    public boolean isHintServiceMessageReverse() {
        return AsyncServiceTrackMonitor.getInstance().getIsHintReverseServiceMessageOrder();
    }

    public List<ServiceFollowBean> getServiceTraceInfo() {
        return AsyncServiceTrackMonitor.getInstance().getServiceTraceInfo();
    }

    public void sendMessageToProtectThread(Message message) {
        Message obtain = Message.obtain(message);
        Message obtain2 = Message.obtain(this.mScheduleCenter);
        obtain2.obj = obtain;
        this.mTimeStamp = message.getWhen();
        obtain2.what = 100;
        this.mScheduleCenter.sendMessageAtTime(obtain2, this.mTimeStamp);
    }

    public void sendStopMessageToProtectThread() {
        Message obtain = Message.obtain(this.mScheduleCenter);
        obtain.what = 101;
        this.mScheduleCenter.sendMessageAtTime(obtain, this.mTimeStamp + 200);
    }

    public OnEventOccur getOnEventOccur() {
        return this.mOnEventOccur;
    }

    public boolean isStopped() {
        return this.mStopped;
    }
}
