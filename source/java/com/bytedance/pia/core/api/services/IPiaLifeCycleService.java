package com.bytedance.pia.core.api.services;

import android.net.Uri;
import com.bytedance.pia.core.api.PiaCoreApi;
import com.bytedance.pia.core.api.plugin.IPiaLifeCycle;
import com.bytedance.pia.core.api.utils.IReleasable;

/* loaded from: classes4.dex */
public interface IPiaLifeCycleService {

    /* loaded from: classes4.dex */
    public enum WarmupStage {
        Load,
        Activate
    }

    IPiaLifeCycle createLifeCycle(String str);

    IPiaLifeCycle createLifeCycle(String str, Object obj);

    boolean support(Uri uri);

    boolean support(String str);

    IReleasable warmup(String str, String str2);

    IReleasable warmup(String str, String str2, Object obj);

    IReleasable warmup(String str, String str2, Object obj, WarmupStage warmupStage);

    static IPiaLifeCycleService inst() {
        return (IPiaLifeCycleService) PiaCoreApi.get(IPiaLifeCycleService.class);
    }
}
