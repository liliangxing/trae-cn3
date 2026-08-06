package com.bytedance.ies.xbridge.base.runtime.depend;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostMemoryWaringDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend;", "", "registerMemoryWaringListener", "", "containerId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend$IMemoryWaringListener;", "unRegisterMemoryWaringListener", "IMemoryWaringListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostMemoryWaringDepend {

    /* compiled from: IHostMemoryWaringDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void registerMemoryWaringListener(IHostMemoryWaringDepend iHostMemoryWaringDepend, String str, IMemoryWaringListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void unRegisterMemoryWaringListener(IHostMemoryWaringDepend iHostMemoryWaringDepend, String str) {
        }
    }

    /* compiled from: IHostMemoryWaringDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend$IMemoryWaringListener;", "", "onTrimMemory", "", "level", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IMemoryWaringListener {
        void onTrimMemory(int level);
    }

    void registerMemoryWaringListener(String containerId, IMemoryWaringListener listener);

    void unRegisterMemoryWaringListener(String containerId);
}
