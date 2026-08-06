package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class OnceConfig extends InitConfig {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ss.ttm.utils.InitConfig
    public void commit() {
    }

    public OnceConfig(ReuseConfig reuse) {
        super(reuse == null ? 0L : reuse.nativeHandle(), 0);
    }

    private OnceConfig(OnceConfig once) {
        super(once.nativeHandle(), 1);
    }

    public OnceConfig copy() {
        return new OnceConfig(this);
    }
}
