package com.bytedance.android.anniex.web.monitor;

import android.view.View;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.monitorV2.webview.base.IWebBlankCallback;
import com.bytedance.ies.bullet.service.monitor.reliability.ReliabilityReporter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultAnnieXWebBlankCallback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/web/monitor/DefaultAnnieXWebBlankCallback;", "Lcom/bytedance/android/monitorV2/webview/base/IWebBlankCallback;", "contextRefProvider", "Lkotlin/Function0;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "(Lkotlin/jvm/functions/Function0;)V", "onDetectCost", "", "view", "Landroid/view/View;", "costTime", "", "onDetectResult", "blankState", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DefaultAnnieXWebBlankCallback implements IWebBlankCallback {
    private final Function0<WeakReference<AnnieXWebModel>> contextRefProvider;

    public void onDetectCost(View view, long costTime) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultAnnieXWebBlankCallback(Function0<? extends WeakReference<AnnieXWebModel>> function0) {
        Intrinsics.checkNotNullParameter(function0, "contextRefProvider");
        this.contextRefProvider = function0;
    }

    public void onDetectResult(View view, int blankState) {
        AnnieXWebModel annieXWebModel = (AnnieXWebModel) ((WeakReference) this.contextRefProvider.invoke()).get();
        if (annieXWebModel != null) {
            ReliabilityReporter.INSTANCE.reportBlankDetected(annieXWebModel.getBulletContext(), Integer.valueOf(2 - blankState), (Float) null);
        }
    }
}
