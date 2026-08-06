package com.bytedance.monitor.collector.service;

import android.app.Service;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.monitor.util.ActivityThreadUtils;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes4.dex */
public class ServiceTrackMonitor implements Handler.Callback {
    private static Map<IBinder, Service> mServices;
    private static ServiceTrackMonitor sInstance = new ServiceTrackMonitor();
    private static ServiceFollowBean sServiceFollowBean = null;
    private Handler.Callback mOriginalCallback;

    private ServiceTrackMonitor() {
    }

    public static ServiceTrackMonitor getInstance() {
        return sInstance;
    }

    public synchronized String getServiceComponentName(IBinder iBinder) {
        String str;
        if (mServices == null) {
            try {
                Object currentActivityThread = ActivityThreadUtils.currentActivityThread();
                mServices = (Map) DoubleReflectHelper.getField(currentActivityThread.getClass(), "mServices").get(currentActivityThread);
            } catch (Throwable unused) {
            }
        }
        Map<IBinder, Service> map = mServices;
        str = null;
        if (map != null && map.get(iBinder) != null) {
            str = mServices.get(iBinder).getClass().getName();
        }
        return str;
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
        try {
            if (MessageHandleUtils.isServiceMessage(message)) {
                sServiceFollowBean = ServiceFollowBean.fetchServiceName(message);
            }
        } catch (Throwable unused) {
        }
        Handler.Callback callback = this.mOriginalCallback;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }

    public static ServiceFollowBean getCurrentService() {
        return sServiceFollowBean;
    }

    public static void clearCurrentService() {
        sServiceFollowBean = null;
    }
}
