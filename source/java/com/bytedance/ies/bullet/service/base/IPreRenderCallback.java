package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* compiled from: IPreRenderService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreRenderCallback;", "", "onFailed", "", "result", "Lcom/bytedance/ies/bullet/service/base/PoolResult;", "errorMsg", "", "onSuccess", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPreRenderCallback {
    void onFailed(PoolResult result, String errorMsg);

    void onSuccess(String sessionId);

    /* compiled from: IPreRenderService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onFailed$default(IPreRenderCallback iPreRenderCallback, PoolResult poolResult, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            iPreRenderCallback.onFailed(poolResult, str);
        }
    }
}
