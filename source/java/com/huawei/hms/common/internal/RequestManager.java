package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: b */
    private static volatile RequestManager f1220b;

    /* renamed from: c */
    private static Handler f1221c;

    /* renamed from: a */
    private static final Object f1219a = new Object();

    /* renamed from: d */
    private static Queue<HuaweiApi.RequestHandler> f1222d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private static Map<String, HuaweiApi.RequestHandler> f1223e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f1221c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f1222d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f1221c == null) {
            return;
        }
        HMSLog.m2120i("RequestManager", "addToConnectedReqMap");
        f1221c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f1223e.put(str, requestHandler);
            }
        });
    }

    /* renamed from: b */
    private void m1123b() {
        while (!f1222d.isEmpty()) {
            HuaweiApi.RequestHandler poll = f1222d.poll();
            if (poll != null) {
                Object client = poll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    /* renamed from: c */
    private void m1124c() {
        HMSLog.m2120i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f1222d.isEmpty()) {
            f1222d.poll().onConnectionSuspended(1);
        }
        m1125d();
    }

    /* renamed from: d */
    private void m1125d() {
        HMSLog.m2120i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f1223e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f1223e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e) {
                HMSLog.m2118e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f1221c;
    }

    public static RequestManager getInstance() {
        synchronized (f1219a) {
            if (f1220b == null) {
                HandlerThread handlerThread = new HandlerThread("RequestManager");
                handlerThread.start();
                f1220b = new RequestManager(handlerThread.getLooper());
            }
        }
        return f1220b;
    }

    public static void removeReqByTransId(final String str) {
        if (f1221c == null) {
            return;
        }
        HMSLog.m2120i("RequestManager", "removeReqByTransId");
        f1221c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f1223e.remove(str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.m2120i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /* 10011 */:
                m1123b();
                return true;
            case NOTIFY_CONNECT_FAILED /* 10012 */:
                m1122a(message);
                return true;
            case NOTIFY_CONNECT_SUSPENDED /* 10013 */:
                m1124c();
                return true;
            default:
                HMSLog.m2120i("RequestManager", "handleMessage unknown msg:" + message.what);
                return false;
        }
    }

    /* renamed from: a */
    private void m1122a(Message message) {
        HMSLog.m2120i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f1222d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e) {
            HMSLog.m2118e("RequestManager", "<handleConnectFailed> handle Failed" + e.getMessage());
        }
    }
}
