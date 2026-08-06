package com.bytedance.platform.horae.java_impl;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.platform.horae.OnEventOccur;
import com.bytedance.platform.horae.java_impl.async.AsyncMessageHandleUtils;
import com.bytedance.platform.horae.java_impl.async.AsyncServiceScheduleManager;
import com.bytedance.platform.horae.java_impl.sync.SyncServiceScheduleManager;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class ServiceScheduleManager {
    private static ServiceScheduleManager sInstance;
    private Application mContext;
    private boolean mInitialed;
    private boolean mSync;

    private ServiceScheduleManager(Application application) {
        this.mContext = application;
    }

    public static ServiceScheduleManager getInstance(Application application) {
        if (sInstance == null) {
            synchronized (ServiceScheduleManager.class) {
                if (sInstance == null) {
                    sInstance = new ServiceScheduleManager(application);
                }
            }
        }
        return sInstance;
    }

    public void start(boolean z, String str, OnEventOccur onEventOccur, Set<String> set, boolean z2, long j) {
        if (this.mInitialed) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Parameter threadName can not be null!");
        }
        this.mSync = z;
        this.mInitialed = true;
        if (z) {
            SyncServiceScheduleManager.getInstance().start(this.mContext, str, onEventOccur, z2);
        } else {
            AsyncMessageHandleUtils.setNoOptList(set);
            AsyncServiceScheduleManager.getInstance().start(this.mContext, str, onEventOccur, z2, j);
        }
    }

    public boolean isHintServiceMessageReverse() {
        if (this.mSync) {
            return SyncServiceScheduleManager.getInstance().isHintServiceMessageReverse();
        }
        return AsyncServiceScheduleManager.getInstance().isHintServiceMessageReverse();
    }

    public List<ServiceFollowBean> getServiceTraceInfo() {
        if (this.mSync) {
            return SyncServiceScheduleManager.getInstance().getServiceTraceInfo();
        }
        return AsyncServiceScheduleManager.getInstance().getServiceTraceInfo();
    }
}
