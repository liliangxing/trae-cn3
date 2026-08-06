package com.bytedance.pia.core.plugins;

import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.ResourceConverterKt;
import com.bytedance.pia.nsr.NsrManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NsrPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/plugins/NsrPlugin;", "Lcom/bytedance/pia/core/runtime/PiaPlugin;", "runtime", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "(Lcom/bytedance/pia/core/runtime/PiaRuntime;Lcom/bytedance/pia/core/PiaManifest;)V", PiaPropsPlugin.PROPS_NAME_MANIFEST, "()Lcom/bytedance/pia/core/PiaManifest;", "getName", "", "initialize", "", "onBeforeLoadResource", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "request", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NsrPlugin extends PiaPlugin {
    private final PiaManifest manifest;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return "nsr";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NsrPlugin(PiaRuntime piaRuntime, PiaManifest piaManifest) {
        super(piaRuntime);
        Intrinsics.checkNotNullParameter(piaRuntime, "runtime");
        Intrinsics.checkNotNullParameter(piaManifest, ErrorType.MANIFEST);
        this.manifest = piaManifest;
    }

    public final PiaManifest getManifest() {
        return this.manifest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public IResourceResponse onBeforeLoadResource(IResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        NsrManager nsrManager = NsrManager.INSTANCE;
        String uri = request.get$uri().toString();
        PiaRuntime piaRuntime = this.runtime;
        Intrinsics.checkNotNullExpressionValue(piaRuntime, "runtime");
        WebResourceResponse shouldInterceptRequest = nsrManager.shouldInterceptRequest(uri, piaRuntime);
        if (shouldInterceptRequest != null) {
            return ResourceConverterKt.toResourceResponse$default(shouldInterceptRequest, null, 1, null);
        }
        return super.onBeforeLoadResource(request);
    }
}
