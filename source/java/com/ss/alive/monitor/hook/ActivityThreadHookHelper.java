package com.ss.alive.monitor.hook;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.push.proxy.AbsMethodInvokeProxy;
import com.bytedance.push.proxy.ActivityThreadHooker;
import com.bytedance.push.proxy.MethodProxyResult;
import com.ss.alive.monitor.ActivityThreadHandler;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ActivityThreadHookHelper extends AbsMethodInvokeProxy {
    private static final String TAG = "ActivityThreadHookHelper";
    private static volatile ActivityThreadHookHelper sActivityThreadHookHelper;
    private ActivityThreadHandler mActivityThreadHandler;

    public static ActivityThreadHookHelper inst(Context context) {
        if (sActivityThreadHookHelper == null) {
            synchronized (ActivityThreadHookHelper.class) {
                if (sActivityThreadHookHelper == null) {
                    sActivityThreadHookHelper = new ActivityThreadHookHelper(context);
                }
            }
        }
        return sActivityThreadHookHelper;
    }

    private ActivityThreadHookHelper(Context context) {
    }

    public void hook(ActivityThreadHandler activityThreadHandler) {
        this.mActivityThreadHandler = activityThreadHandler;
        ActivityThreadHooker.getInstance().addMethodInvokeProxy(this);
    }

    public MethodProxyResult proxyMethodInvoke(Object obj, Method method, Object[] objArr) {
        if (TextUtils.equals(method.getName(), "handleMessage")) {
            this.mActivityThreadHandler.handleMessage((Message) objArr[0]);
        }
        return new MethodProxyResult();
    }
}
