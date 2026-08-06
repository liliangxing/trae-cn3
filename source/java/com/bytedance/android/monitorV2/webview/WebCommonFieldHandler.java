package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebCommonFieldHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebCommonFieldHandler;", "", "()V", "addWebCommonField", "", "monitorId", "", "view", "Landroid/webkit/WebView;", "nativeCommon", "Lcom/bytedance/android/monitorV2/entity/NativeCommon;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebCommonFieldHandler {
    public static final WebCommonFieldHandler INSTANCE = new WebCommonFieldHandler();

    private WebCommonFieldHandler() {
    }

    public final void addWebCommonField(String monitorId, WebView view, NativeCommon nativeCommon) {
        String infoField;
        String infoField2;
        String infoField3;
        Intrinsics.checkNotNullParameter(nativeCommon, "nativeCommon");
        String str = nativeCommon.url;
        if ((str == null || str.length() == 0) && (infoField3 = ContainerDataCache.INSTANCE.getInfoField(monitorId, view, "url")) != null) {
            nativeCommon.url = infoField3;
        }
        String str2 = nativeCommon.nativePage;
        if ((str2 == null || str2.length() == 0) && (infoField2 = ContainerDataCache.INSTANCE.getInfoField(monitorId, view, "native_page")) != null) {
            nativeCommon.nativePage = infoField2;
        }
        String str3 = nativeCommon.containerType;
        if (!(str3 == null || str3.length() == 0) || (infoField = ContainerDataCache.INSTANCE.getInfoField(monitorId, view, "container_type")) == null) {
            return;
        }
        nativeCommon.containerType = infoField;
    }
}
