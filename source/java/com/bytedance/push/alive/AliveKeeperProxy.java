package com.bytedance.push.alive;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* loaded from: classes4.dex */
public class AliveKeeperProxy {
    private static volatile AliveKeeperProxy sInstance;
    private final Context mContext;
    private final WeakHandler mHandler = PushThreadHandlerManager.inst().getHandler();

    public static AliveKeeperProxy inst(Context context) {
        if (sInstance == null) {
            synchronized (AliveKeeperProxy.class) {
                if (sInstance == null) {
                    sInstance = new AliveKeeperProxy(context);
                }
            }
        }
        return sInstance;
    }

    private AliveKeeperProxy(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public boolean checkConfig(String str) throws PackageManager.NameNotFoundException {
        IAlive impl = getImpl();
        if (impl != null) {
            return impl.checkConfig(this.mContext, str);
        }
        return true;
    }

    public void doKeepAlive() {
        Runnable runnable = new Runnable() { // from class: com.bytedance.push.alive.AliveKeeperProxy.1
            @Override // java.lang.Runnable
            public void run() {
                IAlive impl = AliveKeeperProxy.this.getImpl();
                if (impl != null) {
                    impl.doKeepAlive(AliveKeeperProxy.this.mContext, AliveKeeperProxy.this.mHandler);
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(runnable);
        } else {
            runnable.run();
        }
    }

    public void enableMessageReceiver(boolean z) {
        IAlive impl = getImpl();
        if (impl != null) {
            impl.enableMessageReceiver(this.mContext, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized IAlive getImpl() {
        Class<?> cls;
        try {
            cls = Class.forName("com.a.b.AKeeperImpl");
        } catch (Throwable unused) {
            return null;
        }
        return (IAlive) cls.getMethod("inst", new Class[0]).invoke(cls, new Object[0]);
    }

    public boolean isSswoActivityFinish() {
        IAlive impl = getImpl();
        if (impl != null) {
            return impl.isSsWoFinished();
        }
        return true;
    }
}
