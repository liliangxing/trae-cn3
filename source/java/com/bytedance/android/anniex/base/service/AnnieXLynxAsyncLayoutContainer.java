package com.bytedance.android.anniex.base.service;

import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.async.IPreLayoutContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxAsyncLayoutContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLayoutContainer;", "Lcom/lynx/tasm/service/async/IPreLayoutContainer;", "lynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "(Lcom/bytedance/android/anniex/ui/AnnieXLynxView;)V", "getLynxView", "Lcom/lynx/tasm/LynxView;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxAsyncLayoutContainer implements IPreLayoutContainer {
    private final AnnieXLynxView lynxView;

    public AnnieXLynxAsyncLayoutContainer(AnnieXLynxView annieXLynxView) {
        Intrinsics.checkNotNullParameter(annieXLynxView, "lynxView");
        this.lynxView = annieXLynxView;
    }

    public LynxView getLynxView() {
        return this.lynxView;
    }
}
