package com.bytedance.android.monitorV2;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/AnnieXMonitor;", "", "()V", "customReport", "", "view", "Landroid/view/View;", "customInfo", "Lcom/bytedance/android/monitorV2/entity/CustomInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieXMonitor {
    public static final AnnieXMonitor INSTANCE = new AnnieXMonitor();

    private AnnieXMonitor() {
    }

    public static /* synthetic */ void customReport$default(AnnieXMonitor annieXMonitor, View view, CustomInfo customInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            view = null;
        }
        annieXMonitor.customReport(view, customInfo);
    }

    public final void customReport(View view, CustomInfo customInfo) {
        Intrinsics.checkNotNullParameter(customInfo, "customInfo");
        if (view instanceof LynxView) {
            LynxViewMonitor.INSTANCE.getINSTANCE().reportCustom((LynxView) view, customInfo);
        } else if (view instanceof WebView) {
            WebViewMonitorHelper.getInstance().customReport((WebView) view, customInfo);
        } else {
            HybridMultiMonitor.getInstance().customReport(customInfo);
        }
    }
}
