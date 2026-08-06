package com.bytedance.ies.bullet.secure;

import android.view.MotionEvent;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IArgusSafeContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/secure/IArgusSafeContainer;", "", "setSecureMonitorEventListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/bullet/secure/IArgusSafeContainer$IArgusSafeMotionEventListener;", "IArgusSafeMotionEventListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IArgusSafeContainer {

    /* compiled from: IArgusSafeContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void setSecureMonitorEventListener(IArgusSafeContainer iArgusSafeContainer, IArgusSafeMotionEventListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    /* compiled from: IArgusSafeContainer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/secure/IArgusSafeContainer$IArgusSafeMotionEventListener;", "", WebViewContainer.EVENT_onTouchEvent, "", "event", "Landroid/view/MotionEvent;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IArgusSafeMotionEventListener {
        void onTouchEvent(MotionEvent event);
    }

    void setSecureMonitorEventListener(IArgusSafeMotionEventListener listener);
}
