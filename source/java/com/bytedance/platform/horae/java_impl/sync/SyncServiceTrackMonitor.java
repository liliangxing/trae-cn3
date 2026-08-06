package com.bytedance.platform.horae.java_impl.sync;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.platform.horae.common.ActivityThreadUtils;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.java_impl.ServiceFollowBean;
import com.bytedance.platform.horae.java_impl.async.AsyncMessageHandleUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SyncServiceTrackMonitor implements Handler.Callback {
    private static Map<IBinder, Service> mServices;
    private static SyncServiceTrackMonitor sInstance = new SyncServiceTrackMonitor();
    private boolean mHintMessageOrderReverse;
    private Handler.Callback mOriginalCallback;
    private List<ServiceFollowBean> mServiceFollowBeanS = new ArrayList();

    private SyncServiceTrackMonitor() {
    }

    public static SyncServiceTrackMonitor getInstance() {
        return sInstance;
    }

    public synchronized String getServiceComponentName(IBinder iBinder) {
        String str;
        if (mServices == null) {
            try {
                Object obj = ActivityThreadUtils.getsActivityThread();
                mServices = (Map) DoubleReflectHelper.getField(obj.getClass(), "mServices").get(obj);
            } catch (Throwable unused) {
            }
        }
        Map<IBinder, Service> map = mServices;
        str = null;
        if (map != null && map.get(iBinder) != null) {
            str = mServices.get(iBinder).getClass().getName();
        }
        if (str == null) {
            this.mHintMessageOrderReverse = true;
        }
        return str;
    }

    public void start() {
        try {
            Handler handler = (Handler) ActivityThreadUtils.getHInActivityThread();
            Field field = DoubleReflectHelper.getField(Handler.class, "mCallback");
            this.mOriginalCallback = (Handler.Callback) field.get(handler);
            field.set(handler, this);
        } catch (Throwable th) {
            if (SyncServiceScheduleManager.getInstance().getOnEventOccur() != null) {
                SyncServiceScheduleManager.getInstance().getOnEventOccur().onExceptionOccur(th);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (AsyncMessageHandleUtils.isServiceOrReceiverMessage(message)) {
            if (message.arg2 == 9529) {
                return true;
            }
            try {
                this.mServiceFollowBeanS.add(ServiceFollowBean.fetchServiceName(message));
                if (this.mServiceFollowBeanS.size() > 100) {
                    this.mServiceFollowBeanS.subList(0, 50).clear();
                }
            } catch (Throwable unused) {
            }
            message.arg2 = SyncServiceScheduleManager.HANDLING_BY_SYSTEM_FLAG;
        }
        Handler.Callback callback = this.mOriginalCallback;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }

    public List<ServiceFollowBean> getServiceTraceInfo() {
        return this.mServiceFollowBeanS;
    }

    public boolean getIsHintReverseServiceMessageOrder() {
        return this.mHintMessageOrderReverse;
    }
}
