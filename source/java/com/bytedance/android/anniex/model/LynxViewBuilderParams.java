package com.bytedance.android.anniex.model;

import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.lynx.init.LynxGroupHolder;
import com.bytedance.ies.bullet.lynx.init.LynxKitBase;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestExternalJSProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestMediaResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.lynx.jsbridge.ParamWrapper;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEngineBuilder;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.provider.LynxResourceProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxViewBuilderParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000 {2\u00020\u0001:\u0001{B°\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0011\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0002\b\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a\u0012\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u000e¢\u0006\u0002\u0010*J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u001c\u0010[\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0002\b\u0015HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u000bHÆ\u0003J\t\u0010^\u001a\u00020\u000bHÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aHÆ\u0003J\u001d\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001fHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\"HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u000eHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010m\u001a\u00020\u000bHÆ\u0003J\t\u0010n\u001a\u00020\u000bHÆ\u0003J\t\u0010o\u001a\u00020\u000eHÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J´\u0002\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u001b\b\u0002\u0010\u0011\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a2\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u000eHÆ\u0001J\u0013\u0010s\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010u\u001a\u00020\u000bHÖ\u0001J\u000e\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\tJ\u000e\u0010y\u001a\u00020\u00132\u0006\u0010x\u001a\u00020\tJ\t\u0010z\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010'\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R$\u0010\u0011\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0002\b\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0011\u0010&\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010(\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R>\u0010B\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010Cj\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`DX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010KR%\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010KR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0011\u0010)\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010>¨\u0006|"}, d2 = {"Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "", "enableLayoutSafepoint", "", "threadStrategy", "Lcom/lynx/tasm/ThreadStrategyForRendering;", "lynxGroup", "Lcom/lynx/tasm/LynxGroup;", "lynxGroupName", "", "presetHeightMeasureSpec", "", "presetWidthMeasureSpec", "fontScale", "", "enableCreateViewAsync", "enableSyncFlush", "customInit", "Lkotlin/Function1;", "Lcom/lynx/tasm/LynxViewBuilder;", "", "Lkotlin/ExtensionFunctionType;", "enableAutoExpose", "screenWidth", "screenHeight", "behaviors", "", "Lcom/lynx/tasm/behavior/Behavior;", "modules", "Lcom/lynx/jsbridge/ParamWrapper;", "resourceProviders", "", "Lcom/lynx/tasm/provider/LynxResourceProvider;", "fontLoader", "Lcom/lynx/tasm/loader/LynxFontFaceLoader$Loader;", "enablePendingJsTask", "enableJSRuntime", "enableAirStrictMode", "enableUserCodeCache", "codeCacheSourceUrl", "enableVSyncAlignedMessageLoop", "viewZoom", "(ZLcom/lynx/tasm/ThreadStrategyForRendering;Lcom/lynx/tasm/LynxGroup;Ljava/lang/String;IIFZZLkotlin/jvm/functions/Function1;ZIILjava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/lynx/tasm/loader/LynxFontFaceLoader$Loader;ZZZZLjava/lang/String;ZF)V", "getBehaviors", "()Ljava/util/List;", "getCodeCacheSourceUrl", "()Ljava/lang/String;", "getCustomInit", "()Lkotlin/jvm/functions/Function1;", "getEnableAirStrictMode", "()Z", "getEnableAutoExpose", "getEnableCreateViewAsync", "getEnableJSRuntime", "getEnableLayoutSafepoint", "getEnablePendingJsTask", "getEnableSyncFlush", "getEnableUserCodeCache", "getEnableVSyncAlignedMessageLoop", "getFontLoader", "()Lcom/lynx/tasm/loader/LynxFontFaceLoader$Loader;", "getFontScale", "()F", "getLynxGroup", "()Lcom/lynx/tasm/LynxGroup;", "getLynxGroupName", "lynxViewConfig", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLynxViewConfig$anniex_release", "()Ljava/util/HashMap;", "setLynxViewConfig$anniex_release", "(Ljava/util/HashMap;)V", "getModules", "getPresetHeightMeasureSpec", "()I", "getPresetWidthMeasureSpec", "getResourceProviders", "()Ljava/util/Map;", "getScreenHeight", "getScreenWidth", "getThreadStrategy", "()Lcom/lynx/tasm/ThreadStrategyForRendering;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getViewZoom", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toLynxEngineBuilder", "Lcom/lynx/tasm/LynxEngineBuilder;", "sessionId", "toLynxViewBuilder", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final /* data */ class LynxViewBuilderParams {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String POSTFIX_CANVAS = "_canvas";
    private final List<Behavior> behaviors;
    private final String codeCacheSourceUrl;
    private final Function1<LynxViewBuilder, Unit> customInit;
    private final boolean enableAirStrictMode;
    private final boolean enableAutoExpose;
    private final boolean enableCreateViewAsync;
    private final boolean enableJSRuntime;
    private final boolean enableLayoutSafepoint;
    private final boolean enablePendingJsTask;
    private final boolean enableSyncFlush;
    private final boolean enableUserCodeCache;
    private final boolean enableVSyncAlignedMessageLoop;
    private final LynxFontFaceLoader.Loader fontLoader;
    private final float fontScale;
    private final LynxGroup lynxGroup;
    private final String lynxGroupName;
    private HashMap<String, String> lynxViewConfig;
    private final List<ParamWrapper> modules;
    private final int presetHeightMeasureSpec;
    private final int presetWidthMeasureSpec;
    private final Map<String, LynxResourceProvider<?, ?>> resourceProviders;
    private final int screenHeight;
    private final int screenWidth;
    private final ThreadStrategyForRendering threadStrategy;
    private Uri uri;
    private final float viewZoom;

    public LynxViewBuilderParams() {
        this(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, null, null, null, false, false, false, false, null, false, 0.0f, ViewCompat.MEASURED_SIZE_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableLayoutSafepoint() {
        return this.enableLayoutSafepoint;
    }

    public final Function1<LynxViewBuilder, Unit> component10() {
        return this.customInit;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getEnableAutoExpose() {
        return this.enableAutoExpose;
    }

    /* renamed from: component12, reason: from getter */
    public final int getScreenWidth() {
        return this.screenWidth;
    }

    /* renamed from: component13, reason: from getter */
    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final List<Behavior> component14() {
        return this.behaviors;
    }

    public final List<ParamWrapper> component15() {
        return this.modules;
    }

    public final Map<String, LynxResourceProvider<?, ?>> component16() {
        return this.resourceProviders;
    }

    /* renamed from: component17, reason: from getter */
    public final LynxFontFaceLoader.Loader getFontLoader() {
        return this.fontLoader;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getEnablePendingJsTask() {
        return this.enablePendingJsTask;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getEnableJSRuntime() {
        return this.enableJSRuntime;
    }

    /* renamed from: component2, reason: from getter */
    public final ThreadStrategyForRendering getThreadStrategy() {
        return this.threadStrategy;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getEnableAirStrictMode() {
        return this.enableAirStrictMode;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getEnableUserCodeCache() {
        return this.enableUserCodeCache;
    }

    /* renamed from: component22, reason: from getter */
    public final String getCodeCacheSourceUrl() {
        return this.codeCacheSourceUrl;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getEnableVSyncAlignedMessageLoop() {
        return this.enableVSyncAlignedMessageLoop;
    }

    /* renamed from: component24, reason: from getter */
    public final float getViewZoom() {
        return this.viewZoom;
    }

    /* renamed from: component3, reason: from getter */
    public final LynxGroup getLynxGroup() {
        return this.lynxGroup;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLynxGroupName() {
        return this.lynxGroupName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPresetHeightMeasureSpec() {
        return this.presetHeightMeasureSpec;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPresetWidthMeasureSpec() {
        return this.presetWidthMeasureSpec;
    }

    /* renamed from: component7, reason: from getter */
    public final float getFontScale() {
        return this.fontScale;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getEnableCreateViewAsync() {
        return this.enableCreateViewAsync;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnableSyncFlush() {
        return this.enableSyncFlush;
    }

    public final LynxViewBuilderParams copy(boolean enableLayoutSafepoint, ThreadStrategyForRendering threadStrategy, LynxGroup lynxGroup, String lynxGroupName, int presetHeightMeasureSpec, int presetWidthMeasureSpec, float fontScale, boolean enableCreateViewAsync, boolean enableSyncFlush, Function1<? super LynxViewBuilder, Unit> customInit, boolean enableAutoExpose, int screenWidth, int screenHeight, List<? extends Behavior> behaviors, List<? extends ParamWrapper> modules, Map<String, ? extends LynxResourceProvider<?, ?>> resourceProviders, LynxFontFaceLoader.Loader fontLoader, boolean enablePendingJsTask, boolean enableJSRuntime, boolean enableAirStrictMode, boolean enableUserCodeCache, String codeCacheSourceUrl, boolean enableVSyncAlignedMessageLoop, float viewZoom) {
        Intrinsics.checkNotNullParameter(threadStrategy, "threadStrategy");
        Intrinsics.checkNotNullParameter(behaviors, "behaviors");
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(resourceProviders, "resourceProviders");
        return new LynxViewBuilderParams(enableLayoutSafepoint, threadStrategy, lynxGroup, lynxGroupName, presetHeightMeasureSpec, presetWidthMeasureSpec, fontScale, enableCreateViewAsync, enableSyncFlush, customInit, enableAutoExpose, screenWidth, screenHeight, behaviors, modules, resourceProviders, fontLoader, enablePendingJsTask, enableJSRuntime, enableAirStrictMode, enableUserCodeCache, codeCacheSourceUrl, enableVSyncAlignedMessageLoop, viewZoom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxViewBuilderParams)) {
            return false;
        }
        LynxViewBuilderParams lynxViewBuilderParams = (LynxViewBuilderParams) other;
        return this.enableLayoutSafepoint == lynxViewBuilderParams.enableLayoutSafepoint && this.threadStrategy == lynxViewBuilderParams.threadStrategy && Intrinsics.areEqual(this.lynxGroup, lynxViewBuilderParams.lynxGroup) && Intrinsics.areEqual(this.lynxGroupName, lynxViewBuilderParams.lynxGroupName) && this.presetHeightMeasureSpec == lynxViewBuilderParams.presetHeightMeasureSpec && this.presetWidthMeasureSpec == lynxViewBuilderParams.presetWidthMeasureSpec && Float.compare(this.fontScale, lynxViewBuilderParams.fontScale) == 0 && this.enableCreateViewAsync == lynxViewBuilderParams.enableCreateViewAsync && this.enableSyncFlush == lynxViewBuilderParams.enableSyncFlush && Intrinsics.areEqual(this.customInit, lynxViewBuilderParams.customInit) && this.enableAutoExpose == lynxViewBuilderParams.enableAutoExpose && this.screenWidth == lynxViewBuilderParams.screenWidth && this.screenHeight == lynxViewBuilderParams.screenHeight && Intrinsics.areEqual(this.behaviors, lynxViewBuilderParams.behaviors) && Intrinsics.areEqual(this.modules, lynxViewBuilderParams.modules) && Intrinsics.areEqual(this.resourceProviders, lynxViewBuilderParams.resourceProviders) && Intrinsics.areEqual(this.fontLoader, lynxViewBuilderParams.fontLoader) && this.enablePendingJsTask == lynxViewBuilderParams.enablePendingJsTask && this.enableJSRuntime == lynxViewBuilderParams.enableJSRuntime && this.enableAirStrictMode == lynxViewBuilderParams.enableAirStrictMode && this.enableUserCodeCache == lynxViewBuilderParams.enableUserCodeCache && Intrinsics.areEqual(this.codeCacheSourceUrl, lynxViewBuilderParams.codeCacheSourceUrl) && this.enableVSyncAlignedMessageLoop == lynxViewBuilderParams.enableVSyncAlignedMessageLoop && Float.compare(this.viewZoom, lynxViewBuilderParams.viewZoom) == 0;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.enableLayoutSafepoint) * 31) + this.threadStrategy.hashCode()) * 31;
        LynxGroup lynxGroup = this.lynxGroup;
        int hashCode2 = (hashCode + (lynxGroup == null ? 0 : lynxGroup.hashCode())) * 31;
        String str = this.lynxGroupName;
        int hashCode3 = (((((((((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.presetHeightMeasureSpec)) * 31) + Integer.hashCode(this.presetWidthMeasureSpec)) * 31) + Float.hashCode(this.fontScale)) * 31) + Boolean.hashCode(this.enableCreateViewAsync)) * 31) + Boolean.hashCode(this.enableSyncFlush)) * 31;
        Function1<LynxViewBuilder, Unit> function1 = this.customInit;
        int hashCode4 = (((((((((((((hashCode3 + (function1 == null ? 0 : function1.hashCode())) * 31) + Boolean.hashCode(this.enableAutoExpose)) * 31) + Integer.hashCode(this.screenWidth)) * 31) + Integer.hashCode(this.screenHeight)) * 31) + this.behaviors.hashCode()) * 31) + this.modules.hashCode()) * 31) + this.resourceProviders.hashCode()) * 31;
        LynxFontFaceLoader.Loader loader = this.fontLoader;
        int hashCode5 = (((((((((hashCode4 + (loader == null ? 0 : loader.hashCode())) * 31) + Boolean.hashCode(this.enablePendingJsTask)) * 31) + Boolean.hashCode(this.enableJSRuntime)) * 31) + Boolean.hashCode(this.enableAirStrictMode)) * 31) + Boolean.hashCode(this.enableUserCodeCache)) * 31;
        String str2 = this.codeCacheSourceUrl;
        return ((((hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.enableVSyncAlignedMessageLoop)) * 31) + Float.hashCode(this.viewZoom);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LynxViewBuilderParams(enableLayoutSafepoint=");
        sb.append(this.enableLayoutSafepoint).append(", threadStrategy=").append(this.threadStrategy).append(", lynxGroup=").append(this.lynxGroup).append(", lynxGroupName=").append(this.lynxGroupName).append(", presetHeightMeasureSpec=").append(this.presetHeightMeasureSpec).append(", presetWidthMeasureSpec=").append(this.presetWidthMeasureSpec).append(", fontScale=").append(this.fontScale).append(", enableCreateViewAsync=").append(this.enableCreateViewAsync).append(", enableSyncFlush=").append(this.enableSyncFlush).append(", customInit=").append(this.customInit).append(", enableAutoExpose=").append(this.enableAutoExpose).append(", screenWidth=");
        sb.append(this.screenWidth).append(", screenHeight=").append(this.screenHeight).append(", behaviors=").append(this.behaviors).append(", modules=").append(this.modules).append(", resourceProviders=").append(this.resourceProviders).append(", fontLoader=").append(this.fontLoader).append(", enablePendingJsTask=").append(this.enablePendingJsTask).append(", enableJSRuntime=").append(this.enableJSRuntime).append(", enableAirStrictMode=").append(this.enableAirStrictMode).append(", enableUserCodeCache=").append(this.enableUserCodeCache).append(", codeCacheSourceUrl=").append(this.codeCacheSourceUrl).append(", enableVSyncAlignedMessageLoop=").append(this.enableVSyncAlignedMessageLoop);
        sb.append(", viewZoom=").append(this.viewZoom).append(')');
        return sb.toString();
    }

    public LynxViewBuilderParams(boolean z, ThreadStrategyForRendering threadStrategyForRendering, LynxGroup lynxGroup, String str, int i, int i2, float f, boolean z2, boolean z3, Function1<? super LynxViewBuilder, Unit> function1, boolean z4, int i3, int i4, List<? extends Behavior> list, List<? extends ParamWrapper> list2, Map<String, ? extends LynxResourceProvider<?, ?>> map, LynxFontFaceLoader.Loader loader, boolean z5, boolean z6, boolean z7, boolean z8, String str2, boolean z9, float f2) {
        Intrinsics.checkNotNullParameter(threadStrategyForRendering, "threadStrategy");
        Intrinsics.checkNotNullParameter(list, "behaviors");
        Intrinsics.checkNotNullParameter(list2, "modules");
        Intrinsics.checkNotNullParameter(map, "resourceProviders");
        this.enableLayoutSafepoint = z;
        this.threadStrategy = threadStrategyForRendering;
        this.lynxGroup = lynxGroup;
        this.lynxGroupName = str;
        this.presetHeightMeasureSpec = i;
        this.presetWidthMeasureSpec = i2;
        this.fontScale = f;
        this.enableCreateViewAsync = z2;
        this.enableSyncFlush = z3;
        this.customInit = function1;
        this.enableAutoExpose = z4;
        this.screenWidth = i3;
        this.screenHeight = i4;
        this.behaviors = list;
        this.modules = list2;
        this.resourceProviders = map;
        this.fontLoader = loader;
        this.enablePendingJsTask = z5;
        this.enableJSRuntime = z6;
        this.enableAirStrictMode = z7;
        this.enableUserCodeCache = z8;
        this.codeCacheSourceUrl = str2;
        this.enableVSyncAlignedMessageLoop = z9;
        this.viewZoom = f2;
    }

    public final boolean getEnableLayoutSafepoint() {
        return this.enableLayoutSafepoint;
    }

    public /* synthetic */ LynxViewBuilderParams(boolean z, ThreadStrategyForRendering threadStrategyForRendering, LynxGroup lynxGroup, String str, int i, int i2, float f, boolean z2, boolean z3, Function1 function1, boolean z4, int i3, int i4, List list, List list2, Map map, LynxFontFaceLoader.Loader loader, boolean z5, boolean z6, boolean z7, boolean z8, String str2, boolean z9, float f2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? ThreadStrategyForRendering.ALL_ON_UI : threadStrategyForRendering, (i5 & 4) != 0 ? null : lynxGroup, (i5 & 8) != 0 ? null : str, (i5 & 16) != 0 ? 0 : i, (i5 & 32) != 0 ? 0 : i2, (i5 & 64) != 0 ? 1.0f : f, (i5 & 128) != 0 ? false : z2, (i5 & 256) != 0 ? false : z3, (i5 & 512) != 0 ? null : function1, (i5 & 1024) != 0 ? true : z4, (i5 & 2048) != 0 ? -1 : i3, (i5 & 4096) == 0 ? i4 : -1, (i5 & 8192) != 0 ? CollectionsKt.emptyList() : list, (i5 & 16384) != 0 ? CollectionsKt.emptyList() : list2, (i5 & 32768) != 0 ? MapsKt.emptyMap() : map, (i5 & 65536) != 0 ? null : loader, (i5 & 131072) != 0 ? false : z5, (i5 & 262144) == 0 ? z6 : true, (i5 & 524288) != 0 ? false : z7, (i5 & 1048576) != 0 ? false : z8, (i5 & 2097152) != 0 ? null : str2, (i5 & 4194304) != 0 ? false : z9, (i5 & 8388608) != 0 ? 1.0f : f2);
    }

    public final ThreadStrategyForRendering getThreadStrategy() {
        return this.threadStrategy;
    }

    public final LynxGroup getLynxGroup() {
        return this.lynxGroup;
    }

    public final String getLynxGroupName() {
        return this.lynxGroupName;
    }

    public final int getPresetHeightMeasureSpec() {
        return this.presetHeightMeasureSpec;
    }

    public final int getPresetWidthMeasureSpec() {
        return this.presetWidthMeasureSpec;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final boolean getEnableCreateViewAsync() {
        return this.enableCreateViewAsync;
    }

    public final boolean getEnableSyncFlush() {
        return this.enableSyncFlush;
    }

    public final Function1<LynxViewBuilder, Unit> getCustomInit() {
        return this.customInit;
    }

    public final boolean getEnableAutoExpose() {
        return this.enableAutoExpose;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final List<Behavior> getBehaviors() {
        return this.behaviors;
    }

    public final List<ParamWrapper> getModules() {
        return this.modules;
    }

    public final Map<String, LynxResourceProvider<?, ?>> getResourceProviders() {
        return this.resourceProviders;
    }

    public final LynxFontFaceLoader.Loader getFontLoader() {
        return this.fontLoader;
    }

    public final boolean getEnablePendingJsTask() {
        return this.enablePendingJsTask;
    }

    public final boolean getEnableJSRuntime() {
        return this.enableJSRuntime;
    }

    public final boolean getEnableAirStrictMode() {
        return this.enableAirStrictMode;
    }

    public final boolean getEnableUserCodeCache() {
        return this.enableUserCodeCache;
    }

    public final String getCodeCacheSourceUrl() {
        return this.codeCacheSourceUrl;
    }

    public final boolean getEnableVSyncAlignedMessageLoop() {
        return this.enableVSyncAlignedMessageLoop;
    }

    public final float getViewZoom() {
        return this.viewZoom;
    }

    public final HashMap<String, String> getLynxViewConfig$anniex_release() {
        return this.lynxViewConfig;
    }

    public final void setLynxViewConfig$anniex_release(HashMap<String, String> hashMap) {
        this.lynxViewConfig = hashMap;
    }

    /* compiled from: LynxViewBuilderParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJU\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/model/LynxViewBuilderParams$Companion;", "", "()V", "POSTFIX_CANVAS", "", "getLynxGroup", "Lcom/lynx/tasm/LynxGroup;", "groupName", "shareGroup", "", "enableCanvas", "preloadJSPaths", "", "enableDynamicV8", "(Ljava/lang/String;ZZ[Ljava/lang/String;Z)Lcom/lynx/tasm/LynxGroup;", "enableCanvasOptimization", "storageGroup", "(Ljava/lang/String;ZZ[Ljava/lang/String;ZZZ)Lcom/lynx/tasm/LynxGroup;", "parseUri", "Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "uri", "Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxViewBuilderParams parseUri(Uri uri) {
            LynxGroup lynxGroup;
            LynxGroup lynxGroup2;
            int makeMeasureSpec;
            int makeMeasureSpec2;
            int i;
            int i2;
            ThreadStrategyForRendering threadStrategyForRendering;
            Float valueOf;
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (!uri.isHierarchical()) {
                return new LynxViewBuilderParams(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, null, null, null, false, false, false, false, null, false, 0.0f, ViewCompat.MEASURED_SIZE_MASK, null);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (uri.getBooleanQueryParameter("enable_lynx_config", false)) {
                for (String str : uri.getQueryParameterNames()) {
                    String queryParameter = uri.getQueryParameter(str);
                    if (LoaderUtil.INSTANCE.isNotNullOrEmpty(queryParameter)) {
                        Intrinsics.checkNotNullExpressionValue(str, "param");
                        hashMap.put(str, queryParameter);
                    }
                }
            }
            String queryParameter2 = uri.getQueryParameter("group");
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("use_storage_group", false);
            boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("enable_canvas", false);
            boolean booleanQueryParameter3 = uri.getBooleanQueryParameter("enable_canvas_optimize", false);
            boolean booleanQueryParameter4 = uri.getBooleanQueryParameter("enable_dynamic_v8", false);
            boolean booleanQueryParameter5 = uri.getBooleanQueryParameter("share_group", true);
            if (booleanQueryParameter2 && !Intrinsics.areEqual(queryParameter2, "-1")) {
                queryParameter2 = queryParameter2 + LynxViewBuilderParams.POSTFIX_CANVAS;
            }
            String str2 = queryParameter2;
            if (booleanQueryParameter) {
                lynxGroup2 = getLynxGroup(str2, booleanQueryParameter5, booleanQueryParameter2, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter4, booleanQueryParameter3, true);
            } else {
                if (booleanQueryParameter3) {
                    lynxGroup = getLynxGroup$default(this, str2, booleanQueryParameter5, booleanQueryParameter2, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter4, booleanQueryParameter3, false, 64, null);
                } else {
                    lynxGroup = getLynxGroup(str2, booleanQueryParameter5, booleanQueryParameter2, new String[]{"assets://bdlynx_core.js"}, booleanQueryParameter4);
                }
                lynxGroup2 = lynxGroup;
            }
            boolean booleanQueryParameter6 = uri.getBooleanQueryParameter("enable_code_cache", false);
            String queryParameter3 = uri.getQueryParameter("lynx_preset_height");
            String queryParameter4 = uri.getQueryParameter("lynx_preset_width");
            String queryParameter5 = uri.getQueryParameter("lynx_preset_height_spec");
            String queryParameter6 = uri.getQueryParameter("lynx_preset_width_spec");
            if (queryParameter4 == null && queryParameter3 == null) {
                makeMeasureSpec2 = 0;
                makeMeasureSpec = 0;
            } else {
                if (queryParameter4 != null) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(queryParameter4), BasicMeasure.EXACTLY);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                if (queryParameter3 != null) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Integer.parseInt(queryParameter3), BasicMeasure.EXACTLY);
                } else {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
            }
            if (queryParameter6 == null || queryParameter5 == null) {
                i = makeMeasureSpec2;
                i2 = makeMeasureSpec;
            } else {
                i2 = Integer.parseInt(queryParameter6);
                i = Integer.parseInt(queryParameter5);
            }
            String queryParameter7 = uri.getQueryParameter("thread_strategy");
            Float f = null;
            Integer valueOf2 = queryParameter7 != null ? Integer.valueOf(Integer.parseInt(queryParameter7)) : null;
            int id = ThreadStrategyForRendering.ALL_ON_UI.id();
            if (valueOf2 != null && valueOf2.intValue() == id) {
                threadStrategyForRendering = ThreadStrategyForRendering.ALL_ON_UI;
            } else {
                int id2 = ThreadStrategyForRendering.MOST_ON_TASM.id();
                if (valueOf2 != null && valueOf2.intValue() == id2) {
                    threadStrategyForRendering = ThreadStrategyForRendering.MOST_ON_TASM;
                } else {
                    int id3 = ThreadStrategyForRendering.PART_ON_LAYOUT.id();
                    if (valueOf2 != null && valueOf2.intValue() == id3) {
                        threadStrategyForRendering = ThreadStrategyForRendering.PART_ON_LAYOUT;
                    } else {
                        threadStrategyForRendering = (valueOf2 != null && valueOf2.intValue() == ThreadStrategyForRendering.MULTI_THREADS.id()) ? ThreadStrategyForRendering.MULTI_THREADS : ThreadStrategyForRendering.ALL_ON_UI;
                    }
                }
            }
            ThreadStrategyForRendering threadStrategyForRendering2 = threadStrategyForRendering;
            boolean booleanQueryParameter7 = uri.getBooleanQueryParameter("enable_font_scale", false);
            String queryParameter8 = uri.getQueryParameter("font_scale");
            if (booleanQueryParameter7 && queryParameter8 == null) {
                valueOf = LynxKitBase.INSTANCE.getFontScale();
            } else {
                valueOf = queryParameter8 != null ? Float.valueOf(Float.parseFloat(queryParameter8)) : null;
            }
            float floatValue = valueOf != null ? valueOf.floatValue() : 1.0f;
            boolean booleanQueryParameter8 = uri.getBooleanQueryParameter("enable_view_zoom", false);
            String queryParameter9 = uri.getQueryParameter("view_zoom");
            if (booleanQueryParameter8 && queryParameter9 == null) {
                f = LynxKitBase.INSTANCE.getViewZoom();
            } else if (queryParameter9 != null) {
                f = Float.valueOf(Float.parseFloat(queryParameter9));
            }
            LynxViewBuilderParams lynxViewBuilderParams = new LynxViewBuilderParams(uri.getBooleanQueryParameter("preset_safe_point", false), threadStrategyForRendering2, lynxGroup2, str2, i, i2, floatValue, uri.getBooleanQueryParameter("create_view_async", false), uri.getBooleanQueryParameter("enable_sync_flush", false), null, !uri.getBooleanQueryParameter("disable_auto_expose", false), 0, 0, null, null, null, null, uri.getBooleanQueryParameter("enable_pending_js_task", false), false, uri.getBooleanQueryParameter("air_strict_mode", false), booleanQueryParameter6, null, uri.getBooleanQueryParameter("enable_vsync_aligned_message_loop", false), f != null ? f.floatValue() : 1.0f, 2488832, null);
            lynxViewBuilderParams.setLynxViewConfig$anniex_release(hashMap);
            lynxViewBuilderParams.setUri(uri);
            return lynxViewBuilderParams;
        }

        public static /* synthetic */ LynxGroup getLynxGroup$default(Companion companion, String str, boolean z, boolean z2, String[] strArr, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return companion.getLynxGroup(str, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : strArr, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5);
        }

        public final LynxGroup getLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8, boolean enableCanvasOptimization, boolean storageGroup) {
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            if (storageGroup) {
                return LynxGroupHolder.INSTANCE.getOrCreateLynxGroup(groupName, preloadJSPaths, enableCanvas, enableDynamicV8, enableCanvasOptimization, true);
            }
            if (IConditionCallKt.enableAnnieXCardFixedLynxGroup()) {
                return LynxGroupHolder.INSTANCE.createLynxGroup(groupName, shareGroup, enableCanvas, preloadJSPaths, enableDynamicV8, enableCanvasOptimization);
            }
            if (Intrinsics.areEqual(groupName, "-1")) {
                LynxGroup Create = LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8, enableCanvasOptimization);
                Intrinsics.checkNotNullExpressionValue(Create, "Create(\n                …ization\n                )");
                return Create;
            }
            if (shareGroup) {
                return LynxGroupHolder.getOrCreateLynxGroup$default(LynxGroupHolder.INSTANCE, groupName, preloadJSPaths, enableCanvas, enableDynamicV8, enableCanvasOptimization, false, 32, (Object) null);
            }
            LynxGroup Create2 = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8, enableCanvasOptimization);
            Intrinsics.checkNotNullExpressionValue(Create2, "{\n                LynxGr…          )\n            }");
            return Create2;
        }

        public static /* synthetic */ LynxGroup getLynxGroup$default(Companion companion, String str, boolean z, boolean z2, String[] strArr, boolean z3, int i, Object obj) {
            boolean z4 = (i & 4) != 0 ? false : z2;
            if ((i & 8) != 0) {
                strArr = null;
            }
            return companion.getLynxGroup(str, z, z4, strArr, (i & 16) != 0 ? false : z3);
        }

        public final LynxGroup getLynxGroup(String groupName, boolean shareGroup, boolean enableCanvas, String[] preloadJSPaths, boolean enableDynamicV8) {
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            if (IConditionCallKt.enableAnnieXCardFixedLynxGroup()) {
                return LynxGroupHolder.INSTANCE.createLynxGroup(groupName, shareGroup, enableCanvas, preloadJSPaths, enableDynamicV8, false);
            }
            if (Intrinsics.areEqual(groupName, "-1")) {
                LynxGroup Create = LynxGroup.Create(groupName, groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8);
                Intrinsics.checkNotNullExpressionValue(Create, "Create(groupName, groupN…eCanvas, enableDynamicV8)");
                return Create;
            }
            if (shareGroup) {
                return LynxGroupHolder.INSTANCE.getOrCreateLynxGroup(groupName, preloadJSPaths, enableCanvas, enableDynamicV8);
            }
            LynxGroup Create2 = LynxGroup.Create(groupName, preloadJSPaths, false, enableCanvas, enableDynamicV8);
            Intrinsics.checkNotNullExpressionValue(Create2, "{\n                LynxGr…eDynamicV8)\n            }");
            return Create2;
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        this.uri = uri;
    }

    public final LynxViewBuilder toLynxViewBuilder(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxViewBuilder");
        try {
            TraceEvent.beginSection("LynxViewBuilder:<init>");
            try {
                LynxViewBuilder lynxViewBuilder = new LynxViewBuilder();
                TraceEvent.endSection("LynxViewBuilder:<init>");
                lynxViewBuilder.setEnableVSyncAlignedMessageLoop(getEnableVSyncAlignedMessageLoop());
                lynxViewBuilder.setEnableLayoutSafepoint(getEnableLayoutSafepoint());
                lynxViewBuilder.setThreadStrategyForRendering(getThreadStrategy());
                lynxViewBuilder.setLynxGroup(getLynxGroup());
                lynxViewBuilder.setPresetMeasuredSpec(getPresetWidthMeasureSpec(), getPresetHeightMeasureSpec());
                lynxViewBuilder.setFontScale(getFontScale());
                lynxViewBuilder.setEnableCreateViewAsync(getEnableCreateViewAsync());
                lynxViewBuilder.setEnableSyncFlush(getEnableSyncFlush());
                lynxViewBuilder.enableAutoExpose(getEnableAutoExpose());
                lynxViewBuilder.setScreenSize(getScreenWidth(), getScreenHeight());
                lynxViewBuilder.setLynxViewConfig(lynxViewBuilder.getLynxViewConfig());
                TraceEvent.beginSection("LynxViewBuilder:addBehaviors");
                try {
                    lynxViewBuilder.addBehaviors(getBehaviors());
                    TraceEvent.endSection("LynxViewBuilder:addBehaviors");
                    TraceEvent.beginSection("LynxViewBuilder:registerModule");
                    try {
                        for (ParamWrapper paramWrapper : getModules()) {
                            lynxViewBuilder.registerModule(paramWrapper.getName(), paramWrapper.getModuleClass(), paramWrapper.getParam());
                        }
                        Unit unit = Unit.INSTANCE;
                        TraceEvent.endSection("LynxViewBuilder:registerModule");
                        for (Map.Entry entry : MapsKt.asSequence(getResourceProviders())) {
                            lynxViewBuilder.setResourceProvider((String) entry.getKey(), (LynxResourceProvider) entry.getValue());
                        }
                        lynxViewBuilder.setFontLoader(getFontLoader());
                        lynxViewBuilder.setEnablePendingJsTask(getEnablePendingJsTask());
                        lynxViewBuilder.setEnableJSRuntime(getEnableJSRuntime());
                        lynxViewBuilder.setEnableAirStrictMode(getEnableAirStrictMode());
                        lynxViewBuilder.setEnableUserCodeCache(getEnableUserCodeCache());
                        lynxViewBuilder.setCodeCacheSourceUrl(getCodeCacheSourceUrl());
                        lynxViewBuilder.setDynamicComponentFetcher(new ForestDynamicComponentProvider("ttnet", sessionId));
                        lynxViewBuilder.setGenericResourceFetcher(new ForestLynxGenericResourceProvider("ttnet", sessionId));
                        lynxViewBuilder.setMediaResourceFetcher(new ForestMediaResourceProvider("ttnet", sessionId));
                        lynxViewBuilder.setTemplateResourceFetcher(new ForestTemplateResourceProvider("ttnet", sessionId, (IServiceToken) null, 4, (DefaultConstructorMarker) null));
                        Uri uri = lynxViewBuilder.getUri();
                        boolean z = false;
                        if (uri != null && uri.getBooleanQueryParameter("enable_lynx_generic_fetcher", false)) {
                            z = true;
                        }
                        if (z) {
                            lynxViewBuilder.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);
                        }
                        lynxViewBuilder.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider("ttnet", sessionId));
                        Function1<LynxViewBuilder, Unit> customInit = getCustomInit();
                        if (customInit != null) {
                            customInit.invoke(lynxViewBuilder);
                        }
                        return lynxViewBuilder;
                    } catch (Throwable th) {
                        TraceEvent.endSection("LynxViewBuilder:registerModule");
                        throw th;
                    }
                } catch (Throwable th2) {
                    TraceEvent.endSection("LynxViewBuilder:addBehaviors");
                    throw th2;
                }
            } catch (Throwable th3) {
                TraceEvent.endSection("LynxViewBuilder:<init>");
                throw th3;
            }
        } finally {
            TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
        }
    }

    public final LynxEngineBuilder toLynxEngineBuilder(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxEngineBuilder");
        try {
            TraceEvent.beginSection("LynxViewBuilder:<init>");
            try {
                LynxEngineBuilder lynxEngineBuilder = new LynxEngineBuilder();
                TraceEvent.endSection("LynxViewBuilder:<init>");
                lynxEngineBuilder.setEnableVSyncAlignedMessageLoop(getEnableVSyncAlignedMessageLoop());
                lynxEngineBuilder.setEnableLayoutSafepoint(getEnableLayoutSafepoint());
                lynxEngineBuilder.setThreadStrategyForRendering(getThreadStrategy());
                lynxEngineBuilder.setLynxGroup(getLynxGroup());
                lynxEngineBuilder.setPresetMeasuredSpec(getPresetWidthMeasureSpec(), getPresetHeightMeasureSpec());
                lynxEngineBuilder.setFontScale(getFontScale());
                lynxEngineBuilder.setEnableCreateViewAsync(getEnableCreateViewAsync());
                lynxEngineBuilder.setEnableSyncFlush(getEnableSyncFlush());
                lynxEngineBuilder.enableAutoExpose(getEnableAutoExpose());
                lynxEngineBuilder.setScreenSize(getScreenWidth(), getScreenHeight());
                TraceEvent.beginSection("LynxViewBuilder:addBehaviors");
                try {
                    lynxEngineBuilder.addBehaviors(getBehaviors());
                    TraceEvent.endSection("LynxViewBuilder:addBehaviors");
                    TraceEvent.beginSection("LynxViewBuilder:registerModule");
                    try {
                        for (ParamWrapper paramWrapper : getModules()) {
                            lynxEngineBuilder.registerModule(paramWrapper.getName(), paramWrapper.getModuleClass(), paramWrapper.getParam());
                        }
                        Unit unit = Unit.INSTANCE;
                        TraceEvent.endSection("LynxViewBuilder:registerModule");
                        for (Map.Entry entry : MapsKt.asSequence(getResourceProviders())) {
                            lynxEngineBuilder.setResourceProvider((String) entry.getKey(), (LynxResourceProvider) entry.getValue());
                        }
                        lynxEngineBuilder.setFontLoader(getFontLoader());
                        lynxEngineBuilder.setEnablePendingJsTask(getEnablePendingJsTask());
                        lynxEngineBuilder.setEnableJSRuntime(getEnableJSRuntime());
                        lynxEngineBuilder.setEnableAirStrictMode(getEnableAirStrictMode());
                        lynxEngineBuilder.setEnableUserCodeCache(getEnableUserCodeCache());
                        lynxEngineBuilder.setCodeCacheSourceUrl(getCodeCacheSourceUrl());
                        lynxEngineBuilder.setDynamicComponentFetcher(new ForestDynamicComponentProvider("ttnet", sessionId));
                        lynxEngineBuilder.setGenericResourceFetcher(new ForestLynxGenericResourceProvider("ttnet", sessionId));
                        lynxEngineBuilder.setMediaResourceFetcher(new ForestMediaResourceProvider("ttnet", sessionId));
                        lynxEngineBuilder.setTemplateResourceFetcher(new ForestTemplateResourceProvider("ttnet", sessionId, (IServiceToken) null, 4, (DefaultConstructorMarker) null));
                        Uri uri = lynxEngineBuilder.getUri();
                        boolean z = false;
                        if (uri != null && uri.getBooleanQueryParameter("enable_lynx_generic_fetcher", false)) {
                            z = true;
                        }
                        if (z) {
                            lynxEngineBuilder.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);
                        }
                        lynxEngineBuilder.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider("ttnet", sessionId));
                        Function1<LynxViewBuilder, Unit> customInit = getCustomInit();
                        if (customInit != null) {
                            customInit.invoke(lynxEngineBuilder);
                        }
                        lynxEngineBuilder.setThreadStrategyForRendering(ThreadStrategyForRendering.MOST_ON_TASM);
                        lynxEngineBuilder.setEnablePendingJsTask(true);
                        return lynxEngineBuilder;
                    } catch (Throwable th) {
                        TraceEvent.endSection("LynxViewBuilder:registerModule");
                        throw th;
                    }
                } catch (Throwable th2) {
                    TraceEvent.endSection("LynxViewBuilder:addBehaviors");
                    throw th2;
                }
            } catch (Throwable th3) {
                TraceEvent.endSection("LynxViewBuilder:<init>");
                throw th3;
            }
        } finally {
            TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
        }
    }
}
