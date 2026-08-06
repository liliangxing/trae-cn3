package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.lynx.tasm.LynxError;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J \u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/OnUpdateListener;", "", "onUpdateFailed", "", "channelList", "", "", LynxError.LYNX_THROWABLE, "", "onUpdateSuccess", "path", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface OnUpdateListener {
    void onUpdateFailed(List<String> channelList, Throwable throwable);

    void onUpdateSuccess(List<String> channelList, String path);

    /* compiled from: ResourceLoaderConfig.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onUpdateFailed$default(OnUpdateListener onUpdateListener, List list, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdateFailed");
            }
            if ((i & 2) != 0) {
                th = null;
            }
            onUpdateListener.onUpdateFailed(list, th);
        }
    }
}
