package com.bytedance.platform.horae.java_impl.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.platform.horae.common.ActivityThreadUtils;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.java_impl.ServiceFollowBean;
import com.bytedance.platform.horae.java_impl.sync.SyncServiceTrackMonitor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AsyncServiceTrackMonitor implements Handler.Callback {
    private static AsyncServiceTrackMonitor sInstance = new AsyncServiceTrackMonitor();
    private Handler.Callback mOriginalCallback;
    private List<ServiceFollowBean> mServiceFollowBeanS = new ArrayList();
    private List<Message> mPendingMessages = new ArrayList();
    private boolean mQuickenThreadStopped = false;

    private AsyncServiceTrackMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AsyncServiceTrackMonitor getInstance() {
        return sInstance;
    }

    public void start() {
        try {
            Handler handler = (Handler) ActivityThreadUtils.getHInActivityThread();
            Field field = DoubleReflectHelper.getField(Handler.class, "mCallback");
            this.mOriginalCallback = (Handler.Callback) field.get(handler);
            field.set(handler, this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.arg2 == 1000089) {
            Handler.Callback callback = this.mOriginalCallback;
            if (callback != null) {
                return callback.handleMessage(message);
            }
            return false;
        }
        if (AsyncMessageHandleUtils.isServiceOrReceiverMessage(message)) {
            if (!AsyncServiceScheduleManager.getInstance().isStopped()) {
                AsyncServiceScheduleManager.getInstance().sendMessageToProtectThread(message);
            } else {
                Message obtain = Message.obtain(message);
                if (!this.mQuickenThreadStopped) {
                    this.mPendingMessages.add(obtain);
                } else {
                    AsyncMessageHandleUtils.handleMessage(obtain);
                }
            }
            return true;
        }
        if (AsyncMessageHandleUtils.isMessageNeedBeLocked(message)) {
            AsyncMessageHandleUtils.handleMessage(Message.obtain(message));
            return true;
        }
        Handler.Callback callback2 = this.mOriginalCallback;
        if (callback2 != null) {
            return callback2.handleMessage(message);
        }
        return false;
    }

    public List<ServiceFollowBean> getServiceTraceInfo() {
        return this.mServiceFollowBeanS;
    }

    public void addServiceFollowBean(ServiceFollowBean serviceFollowBean) {
        this.mServiceFollowBeanS.add(serviceFollowBean);
    }

    public boolean getIsHintReverseServiceMessageOrder() {
        return SyncServiceTrackMonitor.getInstance().getIsHintReverseServiceMessageOrder();
    }

    public void notifySubThreadDown() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.platform.horae.java_impl.async.AsyncServiceTrackMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = AsyncServiceTrackMonitor.this.mPendingMessages.iterator();
                while (it.hasNext()) {
                    AsyncMessageHandleUtils.handleMessage((Message) it.next());
                }
                AsyncServiceTrackMonitor.this.mQuickenThreadStopped = true;
            }
        });
    }
}
