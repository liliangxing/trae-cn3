package com.bytedance.android.monitorV2.lynx_helper;

import com.bytedance.android.monitorV2.lynx.data.entity.LynxNativeErrorData;
import com.bytedance.android.monitorV2.lynx.impl.LynxIntegration;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompatLynxViewClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx_helper/CompatLynxViewClient;", "Lcom/lynx/tasm/LynxViewClient;", "lynxViewRef", "Ljava/lang/ref/WeakReference;", "Lcom/lynx/tasm/LynxView;", "(Ljava/lang/ref/WeakReference;)V", "lynxViewDataManager", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxIntegration;", "onDestroy", "", "onReceivedError", "error", "Lcom/lynx/tasm/LynxError;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CompatLynxViewClient extends LynxViewClient {
    private final LynxIntegration lynxViewDataManager;
    private final WeakReference<LynxView> lynxViewRef;

    public CompatLynxViewClient(WeakReference<LynxView> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "lynxViewRef");
        this.lynxViewRef = weakReference;
        this.lynxViewDataManager = LynxViewDataManager.INSTANCE.getOrCreate(weakReference.get());
    }

    public void onReceivedError(LynxError error) {
        if (error != null) {
            LynxIntegration lynxIntegration = this.lynxViewDataManager;
            LynxNativeErrorData lynxNativeErrorData = new LynxNativeErrorData();
            lynxNativeErrorData.setScene("lynx_error");
            lynxNativeErrorData.setErrorCode(error.getErrorCode());
            lynxNativeErrorData.setErrorMsg(error.getMsg());
            lynxIntegration.onReceivedError(lynxNativeErrorData);
        }
    }

    public void onDestroy() {
        this.lynxViewDataManager.onDestroy();
    }
}
