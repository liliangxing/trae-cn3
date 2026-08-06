package com.bytedance.ies.bullet.prefetchv2;

import kotlin.Metadata;

/* compiled from: PrefetchSessionContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchSessionContext;", "", "()V", "prefetchConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "getPrefetchConfig", "()Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "setPrefetchConfig", "(Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PrefetchSessionContext {
    private PrefetchConfig prefetchConfig;

    public final PrefetchConfig getPrefetchConfig() {
        return this.prefetchConfig;
    }

    public final void setPrefetchConfig(PrefetchConfig prefetchConfig) {
        this.prefetchConfig = prefetchConfig;
    }
}
