package com.bytedance.android.anniex.utils;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnnieXUrlExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u000f\u001a\u00020\bH\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0000\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0014"}, d2 = {"enableFlowPage", "", "pageOptContainer", "Lcom/bytedance/android/anniex/utils/PageOptContainer;", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "enableFlowPopup", "popupTypeOpt", "", "enableLitePage", "enablePageOpt", "enablePageSwitch", "blackList", "", "whiteList", "targetPageOpt", "enableSwitchFowPage", "getType", "uri", "IsEnablePrefetch", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXUrlExtKt {
    public static final boolean IsEnablePrefetch(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return StringsKt.equals$default(ExtKt.safeGetQueryParameter(uri, "enable_prefetch"), DiskLruCache.VERSION, false, 2, (Object) null);
    }

    public static final String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        String path = uri.getPath();
        String str = path != null ? path : "";
        if (Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, ProxyConfig.MATCH_HTTPS)) {
            return "_unknown";
        }
        if (!StringsKt.endsWith$default(authority, "_popup", false, 2, (Object) null)) {
            if (!StringsKt.endsWith$default(authority, "_page", false, 2, (Object) null) && !Intrinsics.areEqual(authority, "lynxview") && !Intrinsics.areEqual(authority, "webview")) {
                if (!StringsKt.endsWith$default(str, "_popup", false, 2, (Object) null)) {
                    if (!StringsKt.endsWith$default(str, "_page", false, 2, (Object) null) && !Intrinsics.areEqual(str, "lynxview") && !Intrinsics.areEqual(str, "webview")) {
                        return "_unknown";
                    }
                }
            }
            return "_page";
        }
        return "_popup";
    }

    public static final boolean enableFlowPopup(String str) {
        return Intrinsics.areEqual(str, AnnieXConstants.FLOW) && IConditionCallKt.enableAnnieXFlowPopup();
    }

    private static final boolean enablePageOpt(PageOptContainer pageOptContainer, Uri uri, boolean z, List<String> list, List<String> list2, String str) {
        if (!z) {
            return false;
        }
        String cDN$default = ExtKt.getCDN$default(uri, (String) null, 1, (Object) null);
        if (cDN$default == null) {
            cDN$default = uri.toString();
            Intrinsics.checkNotNullExpressionValue(cDN$default, "schema.toString()");
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default(cDN$default, (String) it.next(), false, 2, (Object) null)) {
                return false;
            }
        }
        if (Intrinsics.areEqual(pageOptContainer.getPageOpt$anniex_release(), str)) {
            return true;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (StringsKt.contains$default(cDN$default, (String) it2.next(), false, 2, (Object) null)) {
                pageOptContainer.setPageOpt$anniex_release(str);
                return true;
            }
        }
        return false;
    }

    public static final boolean enableLitePage(PageOptContainer pageOptContainer, Uri uri) {
        Intrinsics.checkNotNullParameter(pageOptContainer, "pageOptContainer");
        Intrinsics.checkNotNullParameter(uri, StrategyConstants.SCHEMA);
        return enablePageOpt(pageOptContainer, uri, IConditionCallKt.enableAnnieXLitePage(), IConditionCallKt.annieLiteBlackList(), IConditionCallKt.annieLiteWhiteList(), AnnieXConstants.LITE_PAGE);
    }

    public static final boolean enableFlowPage(PageOptContainer pageOptContainer, Uri uri) {
        Intrinsics.checkNotNullParameter(pageOptContainer, "pageOptContainer");
        Intrinsics.checkNotNullParameter(uri, StrategyConstants.SCHEMA);
        return enablePageOpt(pageOptContainer, uri, IConditionCallKt.enableAnnieXFlowPage(), IConditionCallKt.annieFlowBlackList(), IConditionCallKt.annieFlowWhiteList(), AnnieXConstants.FLOW);
    }

    public static final boolean enableSwitchFowPage(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, StrategyConstants.SCHEMA);
        String cDN$default = ExtKt.getCDN$default(uri, (String) null, 1, (Object) null);
        if (cDN$default == null) {
            cDN$default = uri.toString();
            Intrinsics.checkNotNullExpressionValue(cDN$default, "schema.toString()");
        }
        Iterator it = IConditionCallKt.enableAnnieXFlowSwitchWhiteList().iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default(cDN$default, (String) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
