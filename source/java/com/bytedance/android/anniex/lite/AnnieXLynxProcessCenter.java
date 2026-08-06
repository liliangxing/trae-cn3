package com.bytedance.android.anniex.lite;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.api.AnnieXLynxModelBuilder;
import com.bytedance.android.anniex.lite.utils.AnnieXLitePageUtilsKt;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.model.LynxViewBuilderParams;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.Behavior;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxProcessCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000eJ \u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLynxProcessCenter;", "", "()V", "lynxModelLruCache", "Landroid/util/LruCache;", "", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "getLynxModelLruCache", "()Landroid/util/LruCache;", "createLynxModel", "bid", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "createLynxModel$anniex_release", "getOrCreateLynxModel", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxProcessCenter {
    public static final AnnieXLynxProcessCenter INSTANCE = new AnnieXLynxProcessCenter();
    private static final LruCache<String, AnnieXLynxModel> lynxModelLruCache = new LruCache<>(5);

    private AnnieXLynxProcessCenter() {
    }

    public final LruCache<String, AnnieXLynxModel> getLynxModelLruCache() {
        return lynxModelLruCache;
    }

    public static /* synthetic */ AnnieXLynxModel getOrCreateLynxModel$default(AnnieXLynxProcessCenter annieXLynxProcessCenter, String str, Uri uri, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return annieXLynxProcessCenter.getOrCreateLynxModel(str, uri, str2);
    }

    public final AnnieXLynxModel createLynxModel$anniex_release(String bid, Uri schema, String sessionId) {
        LynxViewBuilderParams copy;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        MonitorManager.INSTANCE.onLynxModelCreateBegin(bid, sessionId, null);
        LynxViewBuilderParams parseUri = LynxViewBuilderParams.INSTANCE.parseUri(schema);
        List<Behavior> behaviorList = AnnieXLitePageUtilsKt.getBehaviorList(bid, schema);
        if (behaviorList == null) {
            behaviorList = CollectionsKt.emptyList();
        }
        copy = parseUri.copy((r42 & 1) != 0 ? parseUri.enableLayoutSafepoint : false, (r42 & 2) != 0 ? parseUri.threadStrategy : null, (r42 & 4) != 0 ? parseUri.lynxGroup : null, (r42 & 8) != 0 ? parseUri.lynxGroupName : null, (r42 & 16) != 0 ? parseUri.presetHeightMeasureSpec : 0, (r42 & 32) != 0 ? parseUri.presetWidthMeasureSpec : 0, (r42 & 64) != 0 ? parseUri.fontScale : 0.0f, (r42 & 128) != 0 ? parseUri.enableCreateViewAsync : false, (r42 & 256) != 0 ? parseUri.enableSyncFlush : false, (r42 & 512) != 0 ? parseUri.customInit : null, (r42 & 1024) != 0 ? parseUri.enableAutoExpose : false, (r42 & 2048) != 0 ? parseUri.screenWidth : 0, (r42 & 4096) != 0 ? parseUri.screenHeight : 0, (r42 & 8192) != 0 ? parseUri.behaviors : behaviorList, (r42 & 16384) != 0 ? parseUri.modules : null, (r42 & 32768) != 0 ? parseUri.resourceProviders : null, (r42 & 65536) != 0 ? parseUri.fontLoader : null, (r42 & 131072) != 0 ? parseUri.enablePendingJsTask : false, (r42 & 262144) != 0 ? parseUri.enableJSRuntime : false, (r42 & 524288) != 0 ? parseUri.enableAirStrictMode : false, (r42 & 1048576) != 0 ? parseUri.enableUserCodeCache : false, (r42 & 2097152) != 0 ? parseUri.codeCacheSourceUrl : null, (r42 & 4194304) != 0 ? parseUri.enableVSyncAlignedMessageLoop : false, (r42 & 8388608) != 0 ? parseUri.viewZoom : 0.0f);
        if (IConditionCallKt.enableLynxViewBuilderParamsFix()) {
            copy.setLynxViewConfig$anniex_release(parseUri.getLynxViewConfig$anniex_release());
            copy.setUri(parseUri.getUri());
        }
        AnnieXLynxModel build$anniex_release$default = AnnieXLynxModelBuilder.build$anniex_release$default(new AnnieXLynxModelBuilder(bid, null, copy, false, 10, null), schema, sessionId, true, null, null, false, null, false, 216, null);
        lynxModelLruCache.put(sessionId, build$anniex_release$default);
        return build$anniex_release$default;
    }

    public final AnnieXLynxModel getOrCreateLynxModel(String bid, Uri schema, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:preBuild");
        try {
            AnnieXLynxProcessCenter annieXLynxProcessCenter = INSTANCE;
            AnnieXLynxModel annieXLynxModel = annieXLynxProcessCenter.getLynxModelLruCache().get(sessionId);
            if (annieXLynxModel == null) {
                annieXLynxModel = annieXLynxProcessCenter.createLynxModel$anniex_release(bid, schema, sessionId);
            } else {
                Intrinsics.checkNotNullExpressionValue(annieXLynxModel, "lynxModelLruCache.get(se…l(bid, schema, sessionId)");
            }
            return annieXLynxModel;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        }
    }
}
