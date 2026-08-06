package com.bytedance.ies.xbridge.base.runtime.depend;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostHeadSetHead.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostHeadSetDepend;", "", "registerHeadSetListener", "", "containerId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostHeadSetDepend$IHeadSetListener;", "unRegisterHeadSetListener", "IHeadSetListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostHeadSetDepend {

    /* compiled from: IHostHeadSetHead.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void registerHeadSetListener(IHostHeadSetDepend iHostHeadSetDepend, String str, IHeadSetListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void unRegisterHeadSetListener(IHostHeadSetDepend iHostHeadSetDepend, String containerId) {
            Intrinsics.checkNotNullParameter(containerId, "containerId");
        }
    }

    /* compiled from: IHostHeadSetHead.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostHeadSetDepend$IHeadSetListener;", "", "onPlug", "", "isConnect", "", "type", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IHeadSetListener {
        void onPlug(boolean isConnect, String type);
    }

    void registerHeadSetListener(String containerId, IHeadSetListener listener);

    void unRegisterHeadSetListener(String containerId);
}
