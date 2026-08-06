package com.bytedance.trae.login.bytecloud;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BytecloudLoginHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper;", "", "<init>", "()V", "checkBytedanceNetwork", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;", "checkIntranetRealTime", "NetworkCheckCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudLoginHelper {
    public static final BytecloudLoginHelper INSTANCE = new BytecloudLoginHelper();

    /* compiled from: BytecloudLoginHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/bytecloud/BytecloudLoginHelper$NetworkCheckCallback;", "", "onResult", "", "isBytedanceNetwork", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface NetworkCheckCallback {
        void onResult(boolean isBytedanceNetwork);
    }

    private BytecloudLoginHelper() {
    }

    @JvmStatic
    public static final void checkBytedanceNetwork(LifecycleOwner lifecycleOwner, NetworkCheckCallback callback) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BytecloudLoginHelper$checkBytedanceNetwork$1(callback, null), 3, (Object) null);
    }

    @JvmStatic
    public static final void checkIntranetRealTime(LifecycleOwner lifecycleOwner, NetworkCheckCallback callback) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BytecloudLoginHelper$checkIntranetRealTime$1(callback, null), 3, (Object) null);
    }
}
