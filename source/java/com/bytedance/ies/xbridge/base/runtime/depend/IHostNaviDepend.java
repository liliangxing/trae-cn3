package com.bytedance.ies.xbridge.base.runtime.depend;

import android.app.Activity;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostNaviDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNaviDepend;", "", "configBackPress", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "activity", "Landroid/app/Activity;", "backPressConfig", "Lcom/bytedance/ies/xbridge/base/runtime/depend/BackPressConfig;", "configPopup", "config", "Lcom/bytedance/ies/xbridge/base/runtime/depend/PopupConfig;", "setOnAppStatusChange", "status", "Lcom/bytedance/ies/xbridge/base/runtime/depend/OnAppStatusChange;", "unSetAppStatusChange", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IHostNaviDepend {

    /* compiled from: IHostNaviDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static void configBackPress(IHostNaviDepend iHostNaviDepend, XContextProviderFactory xContextProviderFactory, Activity activity, BackPressConfig backPressConfig) {
        }

        public static void configPopup(IHostNaviDepend iHostNaviDepend, XContextProviderFactory xContextProviderFactory, Activity activity, PopupConfig popupConfig) {
        }

        public static void setOnAppStatusChange(IHostNaviDepend iHostNaviDepend, XContextProviderFactory xContextProviderFactory, Activity activity, OnAppStatusChange onAppStatusChange) {
            Intrinsics.checkNotNullParameter(onAppStatusChange, "status");
        }

        public static void unSetAppStatusChange(IHostNaviDepend iHostNaviDepend, XContextProviderFactory xContextProviderFactory, Activity activity) {
        }
    }

    void configBackPress(XContextProviderFactory contextProviderFactory, Activity activity, BackPressConfig backPressConfig);

    void configPopup(XContextProviderFactory contextProviderFactory, Activity activity, PopupConfig config);

    void setOnAppStatusChange(XContextProviderFactory contextProviderFactory, Activity activity, OnAppStatusChange status);

    void unSetAppStatusChange(XContextProviderFactory contextProviderFactory, Activity activity);
}
