package com.bytedance.forest.chain.fetchers;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* compiled from: GeckoXAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J)\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/OnUpdateListener;", "", "onUpdateFailed", "", "channel", "", LynxError.LYNX_THROWABLE, "", "onUpdateSuccess", "path", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface OnUpdateListener {
    void onUpdateFailed(String channel, Throwable throwable);

    void onUpdateSuccess(String channel, String path, Long version);

    /* compiled from: GeckoXAdapter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onUpdateFailed$default(OnUpdateListener onUpdateListener, String str, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdateFailed");
            }
            if ((i & 2) != 0) {
                th = null;
            }
            onUpdateListener.onUpdateFailed(str, th);
        }
    }
}
