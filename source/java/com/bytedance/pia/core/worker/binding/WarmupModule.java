package com.bytedance.pia.core.worker.binding;

import android.content.Context;
import com.bytedance.pia.core.worker.WarmupWorker;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WarmupModule extends JSModule {
    public static final String NAME = "WarmupModule";
    private final WarmupWorker worker;

    public WarmupModule(Context context, Object obj) {
        super(context, obj);
        this.worker = (WarmupWorker) obj;
    }

    @JSMethod
    public void finishWarmup() {
        this.worker.setFinished();
    }
}
