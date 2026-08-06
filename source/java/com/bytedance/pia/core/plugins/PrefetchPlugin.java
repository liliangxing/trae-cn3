package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.page.PrefetchManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/pia/core/plugins/PrefetchPlugin;", "Lcom/bytedance/pia/core/runtime/PiaPlugin;", "runtime", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "(Lcom/bytedance/pia/core/runtime/PiaRuntime;Lcom/bytedance/pia/core/PiaManifest;)V", PiaPropsPlugin.PROPS_NAME_MANIFEST, "()Lcom/bytedance/pia/core/PiaManifest;", "prefetchManager", "Lcom/bytedance/pia/page/PrefetchManager;", "getPrefetchManager", "()Lcom/bytedance/pia/page/PrefetchManager;", "setPrefetchManager", "(Lcom/bytedance/pia/page/PrefetchManager;)V", "getName", "", "initialize", "", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchPlugin extends PiaPlugin {
    private final PiaManifest manifest;
    private PrefetchManager prefetchManager;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return ErrorType.PREFETCH;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrefetchPlugin(PiaRuntime piaRuntime, PiaManifest piaManifest) {
        super(piaRuntime);
        Intrinsics.checkNotNullParameter(piaRuntime, "runtime");
        Intrinsics.checkNotNullParameter(piaManifest, ErrorType.MANIFEST);
        this.manifest = piaManifest;
    }

    public final PiaManifest getManifest() {
        return this.manifest;
    }

    public final PrefetchManager getPrefetchManager() {
        return this.prefetchManager;
    }

    public final void setPrefetchManager(PrefetchManager prefetchManager) {
        this.prefetchManager = prefetchManager;
    }

    @Override // com.bytedance.pia.core.runtime.PiaPlugin, com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        PrefetchManager prefetchManager = this.prefetchManager;
        if (prefetchManager != null) {
            prefetchManager.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
        PiaManifest piaManifest = this.manifest;
        PiaRuntime piaRuntime = this.runtime;
        Intrinsics.checkNotNullExpressionValue(piaRuntime, "runtime");
        this.prefetchManager = new PrefetchManager(piaManifest, piaRuntime);
    }
}
