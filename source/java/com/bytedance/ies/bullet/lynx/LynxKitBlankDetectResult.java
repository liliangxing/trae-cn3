package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.service.base.callbacks.BlankDetectResult;
import com.bytedance.ies.bullet.service.base.callbacks.ViewBlankState;
import kotlin.Metadata;

/* compiled from: LynxKitBlankDetectResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxKitBlankDetectResult;", "Lcom/bytedance/ies/bullet/service/base/callbacks/BlankDetectResult;", "effectivePercent", "", "(F)V", "getEffectivePercent", "()F", "getViewBlankState", "Lcom/bytedance/ies/bullet/service/base/callbacks/ViewBlankState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxKitBlankDetectResult extends BlankDetectResult {
    private final float effectivePercent;

    public LynxKitBlankDetectResult(float f) {
        this.effectivePercent = f;
    }

    public final float getEffectivePercent() {
        return this.effectivePercent;
    }

    @Override // com.bytedance.ies.bullet.service.base.callbacks.BlankDetectResult
    public ViewBlankState getViewBlankState() {
        if (this.effectivePercent < 0.05d) {
            return ViewBlankState.BLANK;
        }
        return ViewBlankState.NORMAL;
    }
}
