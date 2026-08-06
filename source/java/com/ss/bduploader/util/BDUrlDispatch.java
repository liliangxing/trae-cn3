package com.ss.bduploader.util;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.ss.bduploader.BDUploadUtil;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes7.dex */
public class BDUrlDispatch {
    private static final String TAG = "ttmn";
    private static final String URL_DISPATCHRESULT_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult";
    private static final String URL_DISPATCH_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher";
    private static final String URL_REQUEST_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest";
    private static volatile BDUrlDispatch mInstance;
    private final ReentrantReadWriteLock mDispatchlock = new ReentrantReadWriteLock();
    public long mDispatchDuration = -1;
    public String mTncTag = null;

    public static BDUrlDispatch inst() {
        if (mInstance == null) {
            synchronized (BDUrlDispatch.class) {
                if (mInstance == null) {
                    mInstance = new BDUrlDispatch();
                }
            }
        }
        return mInstance;
    }

    public String getDispatchUrl(String str, String str2) {
        String doDispatchUrl;
        this.mDispatchlock.writeLock().lock();
        this.mDispatchDuration = -1L;
        try {
            doDispatchUrl = doOkHttpDispatchPrivate(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, e.toString());
            doDispatchUrl = BDUploadUtil.urlDispatch != null ? BDUploadUtil.urlDispatch.doDispatchUrl(str, str2) : null;
        }
        this.mDispatchlock.writeLock().unlock();
        return doDispatchUrl;
    }

    private String doOkHttpDispatchPrivate(String str, String str2) throws Exception {
        Log.d(TAG, "url is " + str + ", method:" + str2);
        Class<?> cls = Class.forName(URL_DISPATCH_CLASS_NAME);
        Object invoke = cls.getMethod("inst", new Class[0]).invoke(null, new Object[0]);
        Boolean bool = (Boolean) cls.getMethod("isDispatchActionsEmpty", new Class[0]).invoke(invoke, new Object[0]);
        this.mTncTag = (String) cls.getMethod("getTncEtag", new Class[0]).invoke(invoke, new Object[0]);
        Log.d(TAG, "isDispatchActionsEmpty:" + bool + "getTncEtag:" + this.mTncTag);
        if (!bool.booleanValue()) {
            Log.d(TAG, "isDispatchActionsEmpty" + bool);
            long currentTimeMillis = System.currentTimeMillis();
            Class<?> cls2 = Class.forName(URL_REQUEST_CLASS_NAME);
            Object invoke2 = cls.getMethod("getDispatchResultForUrl", cls2).invoke(invoke, cls2.getConstructor(String.class, String.class).newInstance(str, str2));
            this.mDispatchDuration = System.currentTimeMillis() - currentTimeMillis;
            Log.d(TAG, "dispatchTime:" + this.mDispatchDuration);
            if (invoke2 != null) {
                Class<?> cls3 = Class.forName(URL_DISPATCHRESULT_CLASS_NAME);
                String str3 = (String) cls3.getField("mDispatchedURL").get(invoke2);
                if (!str.equals(str3)) {
                    List list = (List) cls3.getField("mActionRuleIdList").get(invoke2);
                    if (str3.isEmpty() && !list.isEmpty()) {
                        throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
                    }
                    if (UrlUtils.isValidUrl(str3)) {
                        str = str3;
                    }
                }
            }
        } else {
            Log.d(TAG, "fallback to host replace map");
            long currentTimeMillis2 = System.currentTimeMillis();
            String str4 = (String) cls.getMethod("handleHostMapping", String.class).invoke(invoke, str);
            this.mDispatchDuration = System.currentTimeMillis() - currentTimeMillis2;
            Log.d(TAG, "dispatchTime:" + this.mDispatchDuration);
            if (!str.equals(str4) && UrlUtils.isValidUrl(str4)) {
                str = str4;
            }
        }
        Log.d(TAG, "url is " + str);
        return str;
    }
}
