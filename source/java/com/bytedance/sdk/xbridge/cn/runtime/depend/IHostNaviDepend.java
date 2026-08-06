package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.timonbase.scene.PageDataManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostNaviDepend.kt */
@Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "this depend is no need to inject", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNaviDepend;", "", "configBackPress", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "activity", "Landroid/app/Activity;", "backPressConfig", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/BackPressConfig;", "configPopup", "config", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/PopupConfig;", "setOnAppStatusChange", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnAppStatusChange;", "unSetAppStatusChange", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHostNaviDepend {

    /* compiled from: IHostNaviDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static void configBackPress(IHostNaviDepend iHostNaviDepend, IBDXBridgeContext iBDXBridgeContext, Activity activity, BackPressConfig backPressConfig) {
        }

        public static void configPopup(IHostNaviDepend iHostNaviDepend, IBDXBridgeContext iBDXBridgeContext, Activity activity, PopupConfig popupConfig) {
        }

        public static void setOnAppStatusChange(IHostNaviDepend iHostNaviDepend, IBDXBridgeContext iBDXBridgeContext, Activity activity, OnAppStatusChange onAppStatusChange) {
            Intrinsics.checkNotNullParameter(onAppStatusChange, PageDataManager.EXTRA_STATUS);
        }

        public static void unSetAppStatusChange(IHostNaviDepend iHostNaviDepend, IBDXBridgeContext iBDXBridgeContext, Activity activity) {
        }
    }

    void configBackPress(IBDXBridgeContext bridgeContext, Activity activity, BackPressConfig backPressConfig);

    void configPopup(IBDXBridgeContext bridgeContext, Activity activity, PopupConfig config);

    void setOnAppStatusChange(IBDXBridgeContext bridgeContext, Activity activity, OnAppStatusChange status);

    void unSetAppStatusChange(IBDXBridgeContext bridgeContext, Activity activity);
}
