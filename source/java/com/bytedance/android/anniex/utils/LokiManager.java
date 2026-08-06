package com.bytedance.android.anniex.utils;

import android.content.Context;
import android.net.Uri;
import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.ability.XBridgeHelper;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.model.LynxViewBuilderParams;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.navigator.NavigationModule;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LokiManager.kt */
@Deprecated(message = "千万不要这样用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/utils/LokiManager;", "", "()V", "createAnnieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "templateUri", "Landroid/net/Uri;", "bid", "", "lynxViewBuilderParams", "Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "sessionId", "createAnnieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "context", "Landroid/content/Context;", "lynxModel", "getSubUrl", "safeGetQueryParameter", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LokiManager {
    public static final LokiManager INSTANCE = new LokiManager();

    private LokiManager() {
    }

    public final AnnieXLynxModel createAnnieXLynxModel(Uri templateUri, String bid, LynxViewBuilderParams lynxViewBuilderParams, String sessionId) {
        Intrinsics.checkNotNullParameter(templateUri, "templateUri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(lynxViewBuilderParams, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String subUrl = getSubUrl(templateUri);
        if (subUrl == null) {
            subUrl = templateUri.toString();
            Intrinsics.checkNotNullExpressionValue(subUrl, "templateUri.toString()");
        }
        return new AnnieXLynxModel(subUrl, templateUri, bid, null, null, lynxViewBuilderParams, sessionId, null, null, false, true, null, null, false, null, 31640, null);
    }

    private final String getSubUrl(Uri templateUri) {
        if (Intrinsics.areEqual(templateUri.getScheme(), "http") || Intrinsics.areEqual(templateUri.getScheme(), ProxyConfig.MATCH_HTTPS)) {
            return templateUri.toString();
        }
        String safeGetQueryParameter = safeGetQueryParameter(templateUri, "a_surl");
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = safeGetQueryParameter(templateUri, "surl");
        return safeGetQueryParameter2 == null ? safeGetQueryParameter(templateUri, StreamTrafficObservable.STREAM_URL) : safeGetQueryParameter2;
    }

    private final String safeGetQueryParameter(Uri templateUri, String key) {
        try {
            return templateUri.getQueryParameter(key);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AnnieXLynxView createAnnieXLynxView(Context context, AnnieXLynxModel lynxModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lynxModel, "lynxModel");
        boolean useMotion = InteractiveXUtil.INSTANCE.useMotion(lynxModel.getOriginalUri());
        LynxViewProvider lynxViewProvider = new LynxViewProvider((LynxView) null, 1, (DefaultConstructorMarker) null);
        LynxViewBuilder lynxViewBuilder = lynxModel.getLynxViewBuilderParams().toLynxViewBuilder(lynxModel.getSessionId());
        lynxViewBuilder.registerModule(NavigationModule.NAME, NavigationModule.class, (Object) null);
        lynxViewBuilder.registerModule("hybridMonitor", LynxViewMonitorModule.class, lynxViewProvider);
        LynxBDXBridge lynxBridge = XBridgeHelper.INSTANCE.getLynxBridge(context, lynxModel, lynxViewBuilder);
        AnnieXLynxView annieXLynxView = new AnnieXLynxView(context, lynxModel.getSessionId(), lynxModel.getBid(), lynxViewBuilder);
        if (useMotion) {
            InteractiveXUtil.INSTANCE.injectMotionPhysics(annieXLynxView);
        }
        annieXLynxView.initBridge(lynxBridge, lynxModel);
        annieXLynxView.setViewZoom(lynxModel.getLynxViewBuilderParams().getViewZoom());
        String lynxGroupName = lynxModel.getLynxViewBuilderParams().getLynxGroupName();
        if (lynxGroupName != null) {
            annieXLynxView.setGroupName(lynxGroupName);
        }
        lynxViewProvider.setView(annieXLynxView);
        return annieXLynxView;
    }
}
