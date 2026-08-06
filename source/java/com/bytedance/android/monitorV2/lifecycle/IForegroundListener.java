package com.bytedance.android.monitorV2.lifecycle;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: IForegroundListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/lifecycle/IForegroundListener;", "", "isApplicationBackgrounded", "", "()Z", "addOnApplicationBackgroundListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/android/monitorV2/lifecycle/OnApplicationBackgroundListener;", "addOnApplicationForegroundListener", "Lcom/bytedance/android/monitorV2/lifecycle/OnApplicationForegroundListener;", "removeOnApplicationBackgroundListener", "removeOnApplicationForegroundListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IForegroundListener {
    void addOnApplicationBackgroundListener(OnApplicationBackgroundListener listener);

    void addOnApplicationForegroundListener(OnApplicationForegroundListener listener);

    boolean isApplicationBackgrounded();

    boolean removeOnApplicationBackgroundListener(OnApplicationBackgroundListener listener);

    boolean removeOnApplicationForegroundListener(OnApplicationForegroundListener listener);
}
