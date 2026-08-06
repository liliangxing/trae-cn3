package com.bytedance.pia.core.plugins;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.ResourceConverterKt;
import com.bytedance.pia.snapshot.SnapShotManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/pia/core/plugins/SnapshotPlugin;", "Lcom/bytedance/pia/core/runtime/PiaPlugin;", "runtime", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "(Lcom/bytedance/pia/core/runtime/PiaRuntime;Lcom/bytedance/pia/core/PiaManifest;)V", PiaPropsPlugin.PROPS_NAME_MANIFEST, "()Lcom/bytedance/pia/core/PiaManifest;", "getName", "", "initialize", "", "onAfterLoadResource", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "request", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "response", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SnapshotPlugin extends PiaPlugin {
    private final PiaManifest manifest;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return ErrorType.SNAPSHOT;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotPlugin(PiaRuntime piaRuntime, PiaManifest piaManifest) {
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
    public void initialize() {
        SnapShotManager snapShotManager = SnapShotManager.INSTANCE;
        Context applicationContext = PiaContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext()");
        snapShotManager.initialize(applicationContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public IResourceResponse onAfterLoadResource(IResourceRequest request, IResourceResponse response) {
        Intrinsics.checkNotNullParameter(request, "request");
        SnapShotManager snapShotManager = SnapShotManager.INSTANCE;
        PiaRuntime piaRuntime = this.runtime;
        Intrinsics.checkNotNullExpressionValue(piaRuntime, "runtime");
        PiaRuntime piaRuntime2 = piaRuntime;
        Uri uri = request.get$uri();
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(uri, "request.url ?: Uri.EMPTY");
        WebResourceResponse shouldInterceptRequest = snapShotManager.shouldInterceptRequest(piaRuntime2, uri, request.getRequestHeaders(), response != null ? ResourceConverterKt.toWebResourceResponse(response) : null);
        if (shouldInterceptRequest != null) {
            return ResourceConverterKt.toResourceResponse$default(shouldInterceptRequest, null, 1, null);
        }
        return null;
    }
}
