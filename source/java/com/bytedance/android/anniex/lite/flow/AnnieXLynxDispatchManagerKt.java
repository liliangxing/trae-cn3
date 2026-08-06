package com.bytedance.android.anniex.lite.flow;

import com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider;
import com.bytedance.android.anniex.lite.flow.base.AnnieXDispatchManagerCache;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"getLynxLoadContextProvider", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxPreloadProvider;", "sessionId", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxDispatchManagerKt {
    public static final IAnnieXLynxPreloadProvider getLynxLoadContextProvider(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        if (AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str) == null || !(AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str) instanceof IAnnieXLynxPreloadProvider)) {
            return null;
        }
        AnnieXModelStoreOwner dispatchManager = AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(str);
        Intrinsics.checkNotNull(dispatchManager, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider");
        return (IAnnieXLynxPreloadProvider) dispatchManager;
    }
}
