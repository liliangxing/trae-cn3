package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class ReuseConfig extends InitConfig {
    /* JADX INFO: Access modifiers changed from: protected */
    public ReuseConfig(ReuseConfig reuse, int t) {
        super(reuse == null ? 0L : reuse.nativeHandle(), t);
        if (reuse == null || t != 0) {
            return;
        }
        reuse.commit();
    }
}
