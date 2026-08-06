package com.bytedance.android.anniex.utils;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViexExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"sendGlobalEventInternal", "", "Lcom/lynx/tasm/LynxView;", StrategyConstants.NAME, "", "params", "Lcom/lynx/react/bridge/JavaOnlyArray;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LynxViexExtKt {
    public static final void sendGlobalEventInternal(LynxView lynxView, String str, JavaOnlyArray javaOnlyArray) {
        Intrinsics.checkNotNullParameter(lynxView, "<this>");
        Intrinsics.checkNotNullParameter(str, StrategyConstants.NAME);
        Intrinsics.checkNotNullParameter(javaOnlyArray, "params");
        if (lynxView.enableJSRuntime()) {
            lynxView.sendGlobalEvent(str, javaOnlyArray);
        } else {
            lynxView.triggerEventBus(str, (List) javaOnlyArray);
        }
    }
}
