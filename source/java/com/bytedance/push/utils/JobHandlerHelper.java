package com.bytedance.push.utils;

import android.app.Service;
import android.app.job.JobService;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.reflect.Reflect;
import com.ss.android.message.util.ToolUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JobHandlerHelper {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class JobHandlerCallBack implements Handler.Callback {
        Handler.Callback mJobCallBack;
        Handler mJobHandler;

        public JobHandlerCallBack(Handler handler, Handler.Callback callback) {
            this.mJobHandler = handler;
            this.mJobCallBack = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Handler handler;
            if (message != null) {
                try {
                    if (Logger.debug()) {
                        Logger.m268d("PushJobService", "handleMsg what = " + message.what);
                    }
                    Handler.Callback callback = this.mJobCallBack;
                    if (!(callback != null ? callback.handleMessage(message) : false) && (handler = this.mJobHandler) != null) {
                        handler.handleMessage(message);
                    }
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Handler.Callback callback2 = this.mJobCallBack;
            if (callback2 != null) {
                return callback2.handleMessage(message);
            }
            return false;
        }
    }

    public static void tryHackJobHandler(Service service) {
        Reflect on;
        try {
            if (service instanceof JobService) {
                JobService jobService = (JobService) service;
                if (ToolUtils.isMainProcess(jobService) || Build.VERSION.SDK_INT >= 26 || (on = Reflect.on(jobService)) == null) {
                    return;
                }
                on.call("ensureHandler");
                Handler handler = (Handler) on.field("mHandler", new Class[]{Class.forName("android.app.job.JobService$JobHandler")}).get();
                if (handler != null) {
                    Reflect on2 = Reflect.on(handler);
                    on2.set("mCallback", new JobHandlerCallBack(handler, (Handler.Callback) on2.field("mCallback", new Class[]{Handler.Callback.class}).get()));
                    if (Logger.debug()) {
                        Logger.m268d("PushJobService", "tryHackJobHandler success");
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
