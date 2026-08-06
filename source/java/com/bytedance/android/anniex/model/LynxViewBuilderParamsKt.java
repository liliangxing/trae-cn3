package com.bytedance.android.anniex.model;

import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.model.LynxViewBuilderParams;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.lynx.init.LynxKitBase;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxViewBuilderParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"parseUri", "Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "uri", "Landroid/net/Uri;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LynxViewBuilderParamsKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LynxViewBuilderParams parseUri(LynxViewBuilderParams lynxViewBuilderParams, Uri uri) {
        boolean z;
        LynxGroup lynxGroup;
        LynxGroup lynxGroup2;
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int i;
        int i2;
        String queryParameter4;
        ThreadStrategyForRendering threadStrategy;
        boolean booleanQueryParameter;
        String queryParameter5;
        Float f;
        Float valueOf;
        float fontScale;
        boolean booleanQueryParameter2;
        String queryParameter6;
        float viewZoom;
        String queryParameter7;
        boolean enableCreateViewAsync;
        String queryParameter8;
        boolean enableLayoutSafepoint;
        String queryParameter9;
        boolean enableUserCodeCache;
        String queryParameter10;
        boolean enableSyncFlush;
        String queryParameter11;
        boolean enableAutoExpose;
        String queryParameter12;
        boolean enablePendingJsTask;
        String queryParameter13;
        boolean enableVSyncAlignedMessageLoop;
        String queryParameter14;
        boolean z2;
        LynxViewBuilderParams copy;
        Intrinsics.checkNotNullParameter(lynxViewBuilderParams, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!uri.isHierarchical()) {
            return new LynxViewBuilderParams(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, null, null, null, false, false, false, false, null, false, 0.0f, ViewCompat.MEASURED_SIZE_MASK, null);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        boolean z3 = false;
        if (uri.getBooleanQueryParameter("enable_lynx_config", false)) {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter15 = uri.getQueryParameter(str);
                if (LoaderUtil.INSTANCE.isNotNullOrEmpty(queryParameter15)) {
                    Intrinsics.checkNotNullExpressionValue(str, "param");
                    hashMap.put(str, queryParameter15);
                }
            }
        }
        String queryParameter16 = uri.getQueryParameter("group");
        if (queryParameter16 == null) {
            queryParameter16 = "";
        }
        boolean booleanQueryParameter3 = uri.getBooleanQueryParameter("enable_canvas", false);
        boolean booleanQueryParameter4 = uri.getBooleanQueryParameter("enable_canvas_optimize", false);
        boolean booleanQueryParameter5 = uri.getBooleanQueryParameter("enable_dynamic_v8", false);
        boolean booleanQueryParameter6 = uri.getBooleanQueryParameter("share_group", true);
        boolean booleanQueryParameter7 = uri.getBooleanQueryParameter("use_storage_group", false);
        if (booleanQueryParameter3 && !Intrinsics.areEqual(queryParameter16, "-1")) {
            queryParameter16 = queryParameter16 + LynxViewBuilderParams.POSTFIX_CANVAS;
        }
        if (lynxViewBuilderParams.getLynxGroup() != null && Intrinsics.areEqual(lynxViewBuilderParams.getLynxGroupName(), queryParameter16)) {
            lynxGroup2 = lynxViewBuilderParams.getLynxGroup();
        } else if (booleanQueryParameter7) {
            lynxGroup2 = LynxViewBuilderParams.INSTANCE.getLynxGroup(queryParameter16, booleanQueryParameter6, booleanQueryParameter3, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter5, booleanQueryParameter4, true);
        } else {
            if (booleanQueryParameter4) {
                z = true;
                lynxGroup = LynxViewBuilderParams.Companion.getLynxGroup$default(LynxViewBuilderParams.INSTANCE, queryParameter16, booleanQueryParameter6, booleanQueryParameter3, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter5, booleanQueryParameter4, false, 64, null);
            } else {
                z = true;
                lynxGroup = LynxViewBuilderParams.INSTANCE.getLynxGroup(queryParameter16, booleanQueryParameter6, booleanQueryParameter3, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter5);
            }
            queryParameter = uri.getQueryParameter("lynx_preset_height");
            queryParameter2 = uri.getQueryParameter("lynx_preset_width");
            String queryParameter17 = uri.getQueryParameter("lynx_preset_height_spec");
            queryParameter3 = uri.getQueryParameter("lynx_preset_width_spec");
            int presetWidthMeasureSpec = lynxViewBuilderParams.getPresetWidthMeasureSpec();
            int presetHeightMeasureSpec = lynxViewBuilderParams.getPresetHeightMeasureSpec();
            if (queryParameter2 == null || queryParameter != null) {
                if (queryParameter2 == null) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(queryParameter2), BasicMeasure.EXACTLY);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                if (queryParameter == null) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(queryParameter), BasicMeasure.EXACTLY);
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                presetHeightMeasureSpec = makeMeasureSpec2;
                presetWidthMeasureSpec = makeMeasureSpec;
            }
            if (queryParameter3 != null || queryParameter17 == null) {
                i = presetWidthMeasureSpec;
                i2 = presetHeightMeasureSpec;
            } else {
                i = Integer.parseInt(queryParameter3);
                i2 = Integer.parseInt(queryParameter17);
            }
            queryParameter4 = uri.getQueryParameter("thread_strategy");
            if (queryParameter4 == null) {
                int parseInt = Integer.parseInt(queryParameter4);
                if (parseInt == ThreadStrategyForRendering.ALL_ON_UI.id()) {
                    threadStrategy = ThreadStrategyForRendering.ALL_ON_UI;
                } else if (parseInt == ThreadStrategyForRendering.MOST_ON_TASM.id()) {
                    threadStrategy = ThreadStrategyForRendering.MOST_ON_TASM;
                } else if (parseInt == ThreadStrategyForRendering.PART_ON_LAYOUT.id()) {
                    threadStrategy = ThreadStrategyForRendering.PART_ON_LAYOUT;
                } else {
                    threadStrategy = parseInt == ThreadStrategyForRendering.MULTI_THREADS.id() ? ThreadStrategyForRendering.MULTI_THREADS : ThreadStrategyForRendering.ALL_ON_UI;
                }
            } else {
                threadStrategy = lynxViewBuilderParams.getThreadStrategy();
            }
            booleanQueryParameter = uri.getBooleanQueryParameter("enable_font_scale", false);
            queryParameter5 = uri.getQueryParameter("font_scale");
            f = null;
            if (!booleanQueryParameter && queryParameter5 == null) {
                valueOf = LynxKitBase.INSTANCE.getFontScale();
            } else {
                valueOf = queryParameter5 == null ? Float.valueOf(Float.parseFloat(queryParameter5)) : null;
            }
            if (valueOf == null) {
                fontScale = valueOf.floatValue();
            } else {
                fontScale = lynxViewBuilderParams.getFontScale();
            }
            booleanQueryParameter2 = uri.getBooleanQueryParameter("enable_view_zoom", false);
            queryParameter6 = uri.getQueryParameter("view_zoom");
            if (!booleanQueryParameter2 && queryParameter6 == null) {
                f = LynxKitBase.INSTANCE.getViewZoom();
            } else if (queryParameter6 != null) {
                f = Float.valueOf(Float.parseFloat(queryParameter6));
            }
            if (f == null) {
                viewZoom = f.floatValue();
            } else {
                viewZoom = lynxViewBuilderParams.getViewZoom();
            }
            float f2 = viewZoom;
            queryParameter7 = uri.getQueryParameter("create_view_async");
            if (queryParameter7 == null) {
                Integer intOrNull = StringsKt.toIntOrNull(queryParameter7);
                enableCreateViewAsync = (intOrNull != null && intOrNull.intValue() == z) ? z : false;
            } else {
                enableCreateViewAsync = lynxViewBuilderParams.getEnableCreateViewAsync();
            }
            queryParameter8 = uri.getQueryParameter("preset_safe_point");
            if (queryParameter8 == null) {
                Integer intOrNull2 = StringsKt.toIntOrNull(queryParameter8);
                enableLayoutSafepoint = (intOrNull2 != null && intOrNull2.intValue() == z) ? z : false;
            } else {
                enableLayoutSafepoint = lynxViewBuilderParams.getEnableLayoutSafepoint();
            }
            queryParameter9 = uri.getQueryParameter("enable_code_cache");
            if (queryParameter9 == null) {
                Integer intOrNull3 = StringsKt.toIntOrNull(queryParameter9);
                enableUserCodeCache = (intOrNull3 != null && intOrNull3.intValue() == z) ? z : false;
            } else {
                enableUserCodeCache = lynxViewBuilderParams.getEnableUserCodeCache();
            }
            queryParameter10 = uri.getQueryParameter("enable_sync_flush");
            if (queryParameter10 == null) {
                Integer intOrNull4 = StringsKt.toIntOrNull(queryParameter10);
                enableSyncFlush = (intOrNull4 != null && intOrNull4.intValue() == z) ? z : false;
            } else {
                enableSyncFlush = lynxViewBuilderParams.getEnableSyncFlush();
            }
            queryParameter11 = uri.getQueryParameter("disable_auto_expose");
            if (queryParameter11 == null) {
                Integer intOrNull5 = StringsKt.toIntOrNull(queryParameter11);
                enableAutoExpose = (intOrNull5 != null && intOrNull5.intValue() == 0) ? z : false;
            } else {
                enableAutoExpose = lynxViewBuilderParams.getEnableAutoExpose();
            }
            queryParameter12 = uri.getQueryParameter("enable_pending_js_task");
            if (queryParameter12 == null) {
                Integer intOrNull6 = StringsKt.toIntOrNull(queryParameter12);
                enablePendingJsTask = (intOrNull6 != null && intOrNull6.intValue() == z) ? z : false;
            } else {
                enablePendingJsTask = lynxViewBuilderParams.getEnablePendingJsTask();
            }
            queryParameter13 = uri.getQueryParameter("enable_vsync_aligned_message_loop");
            if (queryParameter13 == null) {
                Integer intOrNull7 = StringsKt.toIntOrNull(queryParameter13);
                enableVSyncAlignedMessageLoop = (intOrNull7 != null && intOrNull7.intValue() == z) ? z : false;
            } else {
                enableVSyncAlignedMessageLoop = lynxViewBuilderParams.getEnableVSyncAlignedMessageLoop();
            }
            queryParameter14 = uri.getQueryParameter("air_strict_mode");
            if (queryParameter14 == null) {
                Integer intOrNull8 = StringsKt.toIntOrNull(queryParameter14);
                if (intOrNull8 != null && intOrNull8.intValue() == z) {
                    z2 = z;
                    copy = lynxViewBuilderParams.copy((r42 & 1) != 0 ? lynxViewBuilderParams.enableLayoutSafepoint : enableLayoutSafepoint, (r42 & 2) != 0 ? lynxViewBuilderParams.threadStrategy : threadStrategy, (r42 & 4) != 0 ? lynxViewBuilderParams.lynxGroup : lynxGroup, (r42 & 8) != 0 ? lynxViewBuilderParams.lynxGroupName : queryParameter16, (r42 & 16) != 0 ? lynxViewBuilderParams.presetHeightMeasureSpec : i2, (r42 & 32) != 0 ? lynxViewBuilderParams.presetWidthMeasureSpec : i, (r42 & 64) != 0 ? lynxViewBuilderParams.fontScale : fontScale, (r42 & 128) != 0 ? lynxViewBuilderParams.enableCreateViewAsync : enableCreateViewAsync, (r42 & 256) != 0 ? lynxViewBuilderParams.enableSyncFlush : enableSyncFlush, (r42 & 512) != 0 ? lynxViewBuilderParams.customInit : null, (r42 & 1024) != 0 ? lynxViewBuilderParams.enableAutoExpose : enableAutoExpose, (r42 & 2048) != 0 ? lynxViewBuilderParams.screenWidth : 0, (r42 & 4096) != 0 ? lynxViewBuilderParams.screenHeight : 0, (r42 & 8192) != 0 ? lynxViewBuilderParams.behaviors : null, (r42 & 16384) != 0 ? lynxViewBuilderParams.modules : null, (r42 & 32768) != 0 ? lynxViewBuilderParams.resourceProviders : null, (r42 & 65536) != 0 ? lynxViewBuilderParams.fontLoader : null, (r42 & 131072) != 0 ? lynxViewBuilderParams.enablePendingJsTask : enablePendingJsTask, (r42 & 262144) != 0 ? lynxViewBuilderParams.enableJSRuntime : false, (r42 & 524288) != 0 ? lynxViewBuilderParams.enableAirStrictMode : z2, (r42 & 1048576) != 0 ? lynxViewBuilderParams.enableUserCodeCache : enableUserCodeCache, (r42 & 2097152) != 0 ? lynxViewBuilderParams.codeCacheSourceUrl : null, (r42 & 4194304) != 0 ? lynxViewBuilderParams.enableVSyncAlignedMessageLoop : enableVSyncAlignedMessageLoop, (r42 & 8388608) != 0 ? lynxViewBuilderParams.viewZoom : f2);
                    copy.setUri(uri);
                    copy.setLynxViewConfig$anniex_release(hashMap);
                    return copy;
                }
            } else {
                z3 = lynxViewBuilderParams.getEnableAirStrictMode();
            }
            z2 = z3;
            copy = lynxViewBuilderParams.copy((r42 & 1) != 0 ? lynxViewBuilderParams.enableLayoutSafepoint : enableLayoutSafepoint, (r42 & 2) != 0 ? lynxViewBuilderParams.threadStrategy : threadStrategy, (r42 & 4) != 0 ? lynxViewBuilderParams.lynxGroup : lynxGroup, (r42 & 8) != 0 ? lynxViewBuilderParams.lynxGroupName : queryParameter16, (r42 & 16) != 0 ? lynxViewBuilderParams.presetHeightMeasureSpec : i2, (r42 & 32) != 0 ? lynxViewBuilderParams.presetWidthMeasureSpec : i, (r42 & 64) != 0 ? lynxViewBuilderParams.fontScale : fontScale, (r42 & 128) != 0 ? lynxViewBuilderParams.enableCreateViewAsync : enableCreateViewAsync, (r42 & 256) != 0 ? lynxViewBuilderParams.enableSyncFlush : enableSyncFlush, (r42 & 512) != 0 ? lynxViewBuilderParams.customInit : null, (r42 & 1024) != 0 ? lynxViewBuilderParams.enableAutoExpose : enableAutoExpose, (r42 & 2048) != 0 ? lynxViewBuilderParams.screenWidth : 0, (r42 & 4096) != 0 ? lynxViewBuilderParams.screenHeight : 0, (r42 & 8192) != 0 ? lynxViewBuilderParams.behaviors : null, (r42 & 16384) != 0 ? lynxViewBuilderParams.modules : null, (r42 & 32768) != 0 ? lynxViewBuilderParams.resourceProviders : null, (r42 & 65536) != 0 ? lynxViewBuilderParams.fontLoader : null, (r42 & 131072) != 0 ? lynxViewBuilderParams.enablePendingJsTask : enablePendingJsTask, (r42 & 262144) != 0 ? lynxViewBuilderParams.enableJSRuntime : false, (r42 & 524288) != 0 ? lynxViewBuilderParams.enableAirStrictMode : z2, (r42 & 1048576) != 0 ? lynxViewBuilderParams.enableUserCodeCache : enableUserCodeCache, (r42 & 2097152) != 0 ? lynxViewBuilderParams.codeCacheSourceUrl : null, (r42 & 4194304) != 0 ? lynxViewBuilderParams.enableVSyncAlignedMessageLoop : enableVSyncAlignedMessageLoop, (r42 & 8388608) != 0 ? lynxViewBuilderParams.viewZoom : f2);
            copy.setUri(uri);
            copy.setLynxViewConfig$anniex_release(hashMap);
            return copy;
        }
        lynxGroup = lynxGroup2;
        z = true;
        queryParameter = uri.getQueryParameter("lynx_preset_height");
        queryParameter2 = uri.getQueryParameter("lynx_preset_width");
        String queryParameter172 = uri.getQueryParameter("lynx_preset_height_spec");
        queryParameter3 = uri.getQueryParameter("lynx_preset_width_spec");
        int presetWidthMeasureSpec2 = lynxViewBuilderParams.getPresetWidthMeasureSpec();
        int presetHeightMeasureSpec2 = lynxViewBuilderParams.getPresetHeightMeasureSpec();
        if (queryParameter2 == null) {
        }
        if (queryParameter2 == null) {
        }
        if (queryParameter == null) {
        }
        presetHeightMeasureSpec2 = makeMeasureSpec2;
        presetWidthMeasureSpec2 = makeMeasureSpec;
        if (queryParameter3 != null) {
        }
        i = presetWidthMeasureSpec2;
        i2 = presetHeightMeasureSpec2;
        queryParameter4 = uri.getQueryParameter("thread_strategy");
        if (queryParameter4 == null) {
        }
        booleanQueryParameter = uri.getBooleanQueryParameter("enable_font_scale", false);
        queryParameter5 = uri.getQueryParameter("font_scale");
        f = null;
        if (!booleanQueryParameter) {
        }
        if (queryParameter5 == null) {
        }
        if (valueOf == null) {
        }
        booleanQueryParameter2 = uri.getBooleanQueryParameter("enable_view_zoom", false);
        queryParameter6 = uri.getQueryParameter("view_zoom");
        if (!booleanQueryParameter2) {
        }
        if (queryParameter6 != null) {
        }
        if (f == null) {
        }
        float f22 = viewZoom;
        queryParameter7 = uri.getQueryParameter("create_view_async");
        if (queryParameter7 == null) {
        }
        queryParameter8 = uri.getQueryParameter("preset_safe_point");
        if (queryParameter8 == null) {
        }
        queryParameter9 = uri.getQueryParameter("enable_code_cache");
        if (queryParameter9 == null) {
        }
        queryParameter10 = uri.getQueryParameter("enable_sync_flush");
        if (queryParameter10 == null) {
        }
        queryParameter11 = uri.getQueryParameter("disable_auto_expose");
        if (queryParameter11 == null) {
        }
        queryParameter12 = uri.getQueryParameter("enable_pending_js_task");
        if (queryParameter12 == null) {
        }
        queryParameter13 = uri.getQueryParameter("enable_vsync_aligned_message_loop");
        if (queryParameter13 == null) {
        }
        queryParameter14 = uri.getQueryParameter("air_strict_mode");
        if (queryParameter14 == null) {
        }
        z2 = z3;
        copy = lynxViewBuilderParams.copy((r42 & 1) != 0 ? lynxViewBuilderParams.enableLayoutSafepoint : enableLayoutSafepoint, (r42 & 2) != 0 ? lynxViewBuilderParams.threadStrategy : threadStrategy, (r42 & 4) != 0 ? lynxViewBuilderParams.lynxGroup : lynxGroup, (r42 & 8) != 0 ? lynxViewBuilderParams.lynxGroupName : queryParameter16, (r42 & 16) != 0 ? lynxViewBuilderParams.presetHeightMeasureSpec : i2, (r42 & 32) != 0 ? lynxViewBuilderParams.presetWidthMeasureSpec : i, (r42 & 64) != 0 ? lynxViewBuilderParams.fontScale : fontScale, (r42 & 128) != 0 ? lynxViewBuilderParams.enableCreateViewAsync : enableCreateViewAsync, (r42 & 256) != 0 ? lynxViewBuilderParams.enableSyncFlush : enableSyncFlush, (r42 & 512) != 0 ? lynxViewBuilderParams.customInit : null, (r42 & 1024) != 0 ? lynxViewBuilderParams.enableAutoExpose : enableAutoExpose, (r42 & 2048) != 0 ? lynxViewBuilderParams.screenWidth : 0, (r42 & 4096) != 0 ? lynxViewBuilderParams.screenHeight : 0, (r42 & 8192) != 0 ? lynxViewBuilderParams.behaviors : null, (r42 & 16384) != 0 ? lynxViewBuilderParams.modules : null, (r42 & 32768) != 0 ? lynxViewBuilderParams.resourceProviders : null, (r42 & 65536) != 0 ? lynxViewBuilderParams.fontLoader : null, (r42 & 131072) != 0 ? lynxViewBuilderParams.enablePendingJsTask : enablePendingJsTask, (r42 & 262144) != 0 ? lynxViewBuilderParams.enableJSRuntime : false, (r42 & 524288) != 0 ? lynxViewBuilderParams.enableAirStrictMode : z2, (r42 & 1048576) != 0 ? lynxViewBuilderParams.enableUserCodeCache : enableUserCodeCache, (r42 & 2097152) != 0 ? lynxViewBuilderParams.codeCacheSourceUrl : null, (r42 & 4194304) != 0 ? lynxViewBuilderParams.enableVSyncAlignedMessageLoop : enableVSyncAlignedMessageLoop, (r42 & 8388608) != 0 ? lynxViewBuilderParams.viewZoom : f22);
        copy.setUri(uri);
        copy.setLynxViewConfig$anniex_release(hashMap);
        return copy;
    }
}
