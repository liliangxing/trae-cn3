package com.bytedance.applog;

import com.bytedance.bdinstall.Builder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface BDInstallInitHook {
    void afterHook();

    void beforeInit(Builder builder);
}
