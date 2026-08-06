package com.bytedance.android.anniex.lite.flow.web;

import android.net.Uri;
import com.bytedance.android.anniex.lite.flow.base.AnnieXDispatchManagerCache;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\t"}, d2 = {"dispatchWebFlow", "", "bid", "", "sessionId", "uri", "Landroid/net/Uri;", "getWebLoadContextProvider", "Lcom/bytedance/android/anniex/lite/flow/web/IAnnieXWebPreloadProvider;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebDispatchManagerKt {
    public static final void dispatchWebFlow(String str, String str2, Uri uri) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str2) == null) {
            AnnieXWebDispatchManager annieXWebDispatchManager = new AnnieXWebDispatchManager(str, str2);
            annieXWebDispatchManager.dispatchFlow(new LoadFlowTask(FlowTaskType.RouterInitTask, str, str2, uri));
            annieXWebDispatchManager.dispatchFlow(new LoadFlowTask(FlowTaskType.EnginePreloadTask, str, str2, uri));
        }
    }

    public static final IAnnieXWebPreloadProvider getWebLoadContextProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        if (AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str) == null || !(AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str) instanceof IAnnieXWebPreloadProvider)) {
            return null;
        }
        AnnieXModelStoreOwner dispatchManager = AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str);
        Intrinsics.checkNotNull(dispatchManager, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider");
        return (IAnnieXWebPreloadProvider) dispatchManager;
    }
}
