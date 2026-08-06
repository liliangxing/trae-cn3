package com.bytedance.platform.horae.java_impl.sync;

import android.app.Application;
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
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SyncServiceScheduleManager implements Runnable {
    public static final int FOLLOWED_FLAG = 9527;
    public static final int HANDLE_BY_SCHEDULE_FLAG = 9528;
    public static final int HANDLING_BY_SYSTEM_FLAG = 9529;
    private static final int INTINIT = -1;
    public static final long MAX_DELAY_TIME = 1000;
    private static final long THE_SMALLEST_INTERVAL = 2000;
    private static final String TeaEventBarrierTag = "tt_removeBarrier";
    private static final Object mLock = new Object();
    private static SyncServiceScheduleManager sInstance;
    private Application mContext;
    private boolean mInitial;
    private long mLastMessageExecuteTimeStamp;
    private MessageQueue mMessageQueue;
    private Field mMessagesHeadField;
    private Field mNextField;
    private OnEventOccur mOnEventOccur;
    public SyncScheduleCenter mScheduleCenter;
    private boolean mDangerBarrierFeature = false;
    private List<Message> mPendingMessage = new ArrayList();

    private SyncServiceScheduleManager() {
    }

    public void followMessage(Message message) {
        long when;
        checkInit();
        if (message.arg2 == 9527 || message.arg2 == 9529) {
            Logger.m205e("ServiceScheduleManager", "Current message " + message.what + " is already followed!");
            return;
        }
        WeakReference weakReference = new WeakReference(message);
        Message obtainMessage = this.mScheduleCenter.obtainMessage(100);
        obtainMessage.obj = weakReference;
        message.arg2 = FOLLOWED_FLAG;
        if (SystemClock.uptimeMillis() - message.getWhen() > 1000) {
            Logger.m205e("ServiceScheduleManager", "Current follow message " + message.what + " is already out of time.");
            when = SystemClock.uptimeMillis();
        } else {
            when = message.getWhen() + 1000;
        }
        long max = Math.max(this.mLastMessageExecuteTimeStamp + 30, when);
        this.mScheduleCenter.sendMessageAtTime(obtainMessage, max);
        this.mLastMessageExecuteTimeStamp = max;
        Logger.m205e("ServiceScheduleManager", "Follow message " + message + " successful. Trigger at time = " + this.mLastMessageExecuteTimeStamp);
    }

    public void addPendingMessage(Message message) {
        checkInit();
        synchronized (mLock) {
            if (!this.mPendingMessage.contains(message)) {
                this.mPendingMessage.add(message);
            }
        }
    }

    public void handlePendingMessage() {
        checkInit();
        synchronized (mLock) {
            MessageQueue messageQueue = this.mMessageQueue;
            if (messageQueue == null) {
                return;
            }
            synchronized (messageQueue) {
                for (Message message : this.mPendingMessage) {
                    if (message.obj != null && message.arg2 == 9527) {
                        Message obtain = Message.obtain(message);
                        obtain.arg2 = HANDLE_BY_SCHEDULE_FLAG;
                        message.what *= -1;
                        Logger.m205e("ServiceScheduleManager", "Handle pending message " + obtain.what);
                        SyncMessageHandleUtils.handleMessage(obtain);
                    }
                }
            }
            this.mPendingMessage.clear();
        }
    }

    public static SyncServiceScheduleManager getInstance() {
        if (sInstance == null) {
            synchronized (SyncServiceScheduleManager.class) {
                if (sInstance == null) {
                    sInstance = new SyncServiceScheduleManager();
                }
            }
        }
        return sInstance;
    }

    public void start(Application application, String str, OnEventOccur onEventOccur, boolean z) {
        if (this.mInitial) {
            return;
        }
        this.mOnEventOccur = onEventOccur;
        this.mInitial = true;
        this.mContext = application;
        this.mDangerBarrierFeature = z;
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        new HookCenter().onHook(this.mContext);
        SyncServiceTrackMonitor.getInstance().start();
        SyncScheduleCenter syncScheduleCenter = new SyncScheduleCenter(handlerThread.getLooper());
        this.mScheduleCenter = syncScheduleCenter;
        syncScheduleCenter.postDelayed(this, THE_SMALLEST_INTERVAL);
        OnEventOccur onEventOccur2 = this.mOnEventOccur;
        if (onEventOccur2 != null) {
            onEventOccur2.onInitialSuccessOccur();
        }
    }

    private void checkInit() {
        if (this.mContext == null) {
            throw new RuntimeException("Must call start(Application context) first!!!");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Message message;
        int onFirstMessageOfMessageQueueArrive;
        long j;
        Logger.m205e("ServiceScheduleManager", "Enter loop()!!!");
        if (this.mMessageQueue == null || this.mNextField == null || this.mMessagesHeadField == null) {
            try {
                this.mMessageQueue = (MessageQueue) DoubleReflectHelper.getField(Looper.class, "mQueue").get(Looper.getMainLooper());
                this.mMessagesHeadField = DoubleReflectHelper.getField(MessageQueue.class, "mMessages");
                this.mNextField = DoubleReflectHelper.getField(Message.class, "next");
            } catch (Exception e) {
                Logger.m205e("ServiceScheduleManager", "Hook fail, stop loop()");
                OnEventOccur onEventOccur = this.mOnEventOccur;
                if (onEventOccur != null) {
                    onEventOccur.onExceptionOccur(e);
                    return;
                }
                return;
            }
        }
        if (this.mDangerBarrierFeature) {
            BarrierMonitor.getInstance().initBarrierMonitorReflect();
        }
        long j2 = THE_SMALLEST_INTERVAL;
        try {
            synchronized (this.mMessageQueue) {
                Message message2 = (Message) this.mMessagesHeadField.get(this.mMessageQueue);
                message = null;
                onFirstMessageOfMessageQueueArrive = (message2 == null || !this.mDangerBarrierFeature) ? -1 : BarrierMonitor.getInstance().onFirstMessageOfMessageQueueArrive(new WeakReference<>(message2));
                while (message2 != null) {
                    if (SyncMessageHandleUtils.isServiceOrReceiverMessage(message2)) {
                        followMessage(message2);
                        message = message2;
                    }
                    message2 = (Message) this.mNextField.get(message2);
                }
            }
            if (onFirstMessageOfMessageQueueArrive != -1) {
                Logger.m207e(true, TeaEventBarrierTag, "remove last barrier token:" + onFirstMessageOfMessageQueueArrive);
            }
            if (message != null) {
                j = message.getWhen() - SystemClock.uptimeMillis();
                if (j < 0) {
                    try {
                        Logger.m205e("ServiceScheduleManager", "The last follow message is out of time ,It's dangerous now!");
                    } catch (Exception e2) {
                        long j3 = j;
                        e = e2;
                        j2 = j3;
                        Logger.m205e("ServiceScheduleManager", "Something is wrong here " + e.toString());
                        OnEventOccur onEventOccur2 = this.mOnEventOccur;
                        if (onEventOccur2 != null) {
                            onEventOccur2.onExceptionOccur(e);
                        }
                        this.mScheduleCenter.postDelayed(this, j2);
                    }
                }
            } else {
                j = 2000;
            }
            j2 = Math.max(j, THE_SMALLEST_INTERVAL);
        } catch (Exception e3) {
            e = e3;
        }
        this.mScheduleCenter.postDelayed(this, j2);
    }

    public boolean isHintServiceMessageReverse() {
        return SyncServiceTrackMonitor.getInstance().getIsHintReverseServiceMessageOrder();
    }

    public List<ServiceFollowBean> getServiceTraceInfo() {
        return SyncServiceTrackMonitor.getInstance().getServiceTraceInfo();
    }

    public OnEventOccur getOnEventOccur() {
        return this.mOnEventOccur;
    }
}
