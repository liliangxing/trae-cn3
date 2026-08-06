package com.bytedance.android.monitorV2.webview.base;

import com.bytedance.android.monitorV2.webview.NavigationDataManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISSPRootInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J<\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/base/ISSPRootInterface;", "", "getParentUrl", "", "getRootUrl", "handleSPPMonitorInfo", "", "event", "currentNavigation", "Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "url", "params", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ISSPRootInterface {
    String getParentUrl();

    String getRootUrl();

    void handleSPPMonitorInfo(String event, NavigationDataManager currentNavigation, String url, Map<String, ? extends Object> params);

    /* compiled from: ISSPRootInterface.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class DefaultImpls {
        public static String getParentUrl(ISSPRootInterface iSSPRootInterface) {
            return null;
        }

        public static String getRootUrl(ISSPRootInterface iSSPRootInterface) {
            return null;
        }

        public static void handleSPPMonitorInfo(ISSPRootInterface iSSPRootInterface, String str, NavigationDataManager navigationDataManager, String str2, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "event");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleSPPMonitorInfo$default(ISSPRootInterface iSSPRootInterface, String str, NavigationDataManager navigationDataManager, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleSPPMonitorInfo");
            }
            if ((i & 8) != 0) {
                map = null;
            }
            iSSPRootInterface.handleSPPMonitorInfo(str, navigationDataManager, str2, map);
        }
    }
}
