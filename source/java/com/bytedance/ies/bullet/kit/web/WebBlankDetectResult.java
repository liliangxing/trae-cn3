package com.bytedance.ies.bullet.kit.web;

import com.bytedance.ies.bullet.service.base.callbacks.BlankDetectResult;
import com.bytedance.ies.bullet.service.base.callbacks.ViewBlankState;
import kotlin.Metadata;

/* compiled from: WebBlankDetectResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/WebBlankDetectResult;", "Lcom/bytedance/ies/bullet/service/base/callbacks/BlankDetectResult;", "state", "", "(I)V", "getState", "()I", "getViewBlankState", "Lcom/bytedance/ies/bullet/service/base/callbacks/ViewBlankState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WebBlankDetectResult extends BlankDetectResult {
    private final int state;

    public WebBlankDetectResult(int i) {
        this.state = i;
    }

    public final int getState() {
        return this.state;
    }

    @Override // com.bytedance.ies.bullet.service.base.callbacks.BlankDetectResult
    public ViewBlankState getViewBlankState() {
        int i = this.state;
        if (i == 1) {
            return ViewBlankState.BLANK;
        }
        if (i == 2) {
            return ViewBlankState.NORMAL;
        }
        return ViewBlankState.UNKNOWN;
    }
}
