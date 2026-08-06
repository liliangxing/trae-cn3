package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.base.callbacks.BlankDetectResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletEventListener;", "", "()V", "onBlankDetectFinish", "", "result", "Lcom/bytedance/ies/bullet/service/base/callbacks/BlankDetectResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BulletEventListener {
    public void onBlankDetectFinish(BlankDetectResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }
}
