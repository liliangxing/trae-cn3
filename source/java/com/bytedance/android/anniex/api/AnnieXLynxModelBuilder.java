package com.bytedance.android.anniex.api;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.model.AnnieXLynxModelKt;
import com.bytedance.android.anniex.model.LynxViewBuilderParams;
import com.bytedance.android.anniex.monitor.AnnieXCardErrorMonitor;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.utils.LokiManager;
import com.bytedance.android.anniex.utils.UrlExtKt;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.device.BulletDeviceUtils;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.ForestLynxSSRProcessor;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfig;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.upc.cache.ApiMultiProcessSharedProvider;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnnieXLynxModelBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJN\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u0007JX\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0007JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u0007Je\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0001¢\u0006\u0002\b\u0018J\\\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u0007J.\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u0007J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0013J\b\u0010!\u001a\u00020\tH\u0002J0\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/android/anniex/api/AnnieXLynxModelBuilder;", "", "bid", "", "globalProps", "", "lynxViewBuilderParams", "Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "cacheUrlGlobalProps", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;Z)V", "finalGlobalProps", "", "build", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "uri", "Landroid/net/Uri;", "preload", "templateData", "Lcom/lynx/tasm/TemplateData;", "isCompactMode", "enterFrom", "enablePrefetch", "sessionId", "build$anniex_release", "template", "", "isSSR", "ssrHydrateConfig", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$SSRHydrateConfig;", "buildInCompactMode", "copy", StrategyConstants.MODEL, "copyModelBugfix", "mergeGlobalProps", "preBuild", "updateLynxViewBuilderParams", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxModelBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String SSR_MODE_SSR_MIX = "mix";
    public static final String SSR_MODE_SSR_ONLY = "ssr";
    private final String bid;
    private final boolean cacheUrlGlobalProps;
    private Map<String, Object> finalGlobalProps;
    private final Map<String, Object> globalProps;
    private final LynxViewBuilderParams lynxViewBuilderParams;

    public AnnieXLynxModelBuilder() {
        this(null, null, null, false, 15, null);
    }

    public AnnieXLynxModelBuilder(String str, Map<String, ? extends Object> map, LynxViewBuilderParams lynxViewBuilderParams, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(map, "globalProps");
        Intrinsics.checkNotNullParameter(lynxViewBuilderParams, "lynxViewBuilderParams");
        this.bid = str;
        this.globalProps = map;
        this.lynxViewBuilderParams = lynxViewBuilderParams;
        this.cacheUrlGlobalProps = z;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ AnnieXLynxModelBuilder(java.lang.String r31, java.util.Map r32, com.bytedance.android.anniex.model.LynxViewBuilderParams r33, boolean r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r30 = this;
            r0 = r35 & 1
            if (r0 == 0) goto L7
            java.lang.String r0 = "default_bid"
            goto L9
        L7:
            r0 = r31
        L9:
            r1 = r35 & 2
            if (r1 == 0) goto L12
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            goto L14
        L12:
            r1 = r32
        L14:
            r2 = r35 & 4
            if (r2 == 0) goto L48
            com.bytedance.android.anniex.model.LynxViewBuilderParams r2 = new com.bytedance.android.anniex.model.LynxViewBuilderParams
            r3 = r2
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 16777215(0xffffff, float:2.3509886E-38)
            r29 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L4a
        L48:
            r2 = r33
        L4a:
            r3 = r35 & 8
            if (r3 == 0) goto L52
            r3 = 0
            r4 = r30
            goto L56
        L52:
            r4 = r30
            r3 = r34
        L56:
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.anniex.api.AnnieXLynxModelBuilder.<init>(java.lang.String, java.util.Map, com.bytedance.android.anniex.model.LynxViewBuilderParams, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ AnnieXLynxModel buildInCompactMode$default(AnnieXLynxModelBuilder annieXLynxModelBuilder, byte[] bArr, Uri uri, TemplateData templateData, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            templateData = null;
        }
        if ((i & 8) != 0) {
            str = "annieXCard";
        }
        return annieXLynxModelBuilder.buildInCompactMode(bArr, uri, templateData, str);
    }

    public static /* synthetic */ AnnieXLynxModel build$default(AnnieXLynxModelBuilder annieXLynxModelBuilder, Uri uri, boolean z, TemplateData templateData, Map map, String str, int i, Object obj) {
        TemplateData templateData2 = (i & 4) != 0 ? null : templateData;
        Map map2 = (i & 8) != 0 ? null : map;
        if ((i & 16) != 0) {
            str = "annieXCard";
        }
        return annieXLynxModelBuilder.build(uri, z, templateData2, map2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ TemplateData mergeGlobalProps$default(AnnieXLynxModelBuilder annieXLynxModelBuilder, Uri uri, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return annieXLynxModelBuilder.mergeGlobalProps(uri, str, map);
    }

    public final boolean copyModelBugfix() {
        return IConditionCallKt.enableCopyDataBugfix();
    }

    /* compiled from: AnnieXLynxModelBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/api/AnnieXLynxModelBuilder$Companion;", "", "()V", "SSR_MODE_SSR_MIX", "", "SSR_MODE_SSR_ONLY", "generateSessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String generateSessionId() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            return uuid;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x001e, B:5:0x002c, B:12:0x0047, B:17:0x003b), top: B:2:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AnnieXLynxModel buildInCompactMode(byte[] template, Uri uri, TemplateData templateData, String enterFrom) {
        boolean z;
        TemplateData empty;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
        try {
            String preBuild = preBuild(uri);
            LynxViewBuilderParams updateLynxViewBuilderParams = updateLynxViewBuilderParams(uri);
            Map map = this.globalProps;
            if (map != null && !map.isEmpty()) {
                z = false;
                if (z) {
                    empty = TemplateData.empty();
                    empty.updateData(this.globalProps);
                } else {
                    empty = null;
                }
                TemplateData templateData2 = empty;
                String uri2 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                AnnieXLynxModel annieXLynxModel = new AnnieXLynxModel(uri2, uri, null, templateData2, null, updateLynxViewBuilderParams, preBuild, templateData, AnnieXLynxModelKt.toComparableByteArray(template), false, true, null, enterFrom, false, null, 27156, null);
                MonitorManager.INSTANCE.onLynxModelCreateEnd(preBuild);
                return annieXLynxModel;
            }
            z = true;
            if (z) {
            }
            TemplateData templateData22 = empty;
            String uri22 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri22, "uri.toString()");
            AnnieXLynxModel annieXLynxModel2 = new AnnieXLynxModel(uri22, uri, null, templateData22, null, updateLynxViewBuilderParams, preBuild, templateData, AnnieXLynxModelKt.toComparableByteArray(template), false, true, null, enterFrom, false, null, 27156, null);
            MonitorManager.INSTANCE.onLynxModelCreateEnd(preBuild);
            return annieXLynxModel2;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        }
    }

    public final AnnieXLynxModel build(byte[] template, Uri uri, TemplateData templateData, Map<String, ? extends Object> globalProps, boolean isSSR, AnnieXLynxModel.SSRHydrateConfig ssrHydrateConfig, String enterFrom) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:build");
        try {
            String preBuild = preBuild(uri);
            LynxViewBuilderParams updateLynxViewBuilderParams = !isSSR ? updateLynxViewBuilderParams(uri) : this.lynxViewBuilderParams;
            TemplateData mergeGlobalProps = mergeGlobalProps(uri, preBuild, globalProps);
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            AnnieXLynxModel annieXLynxModel = new AnnieXLynxModel(uri2, uri, null, mergeGlobalProps, null, updateLynxViewBuilderParams, preBuild, templateData, AnnieXLynxModelKt.toComparableByteArray(template), isSSR, false, ssrHydrateConfig, enterFrom, false, null, 25620, null);
            MonitorManager.INSTANCE.onLynxModelCreateEnd(preBuild);
            return annieXLynxModel;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        }
    }

    public final AnnieXLynxModel build(Uri uri, boolean preload, TemplateData templateData, Map<String, ? extends Object> globalProps, String enterFrom) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:build");
        try {
            return build(uri, preload, templateData, globalProps, false, enterFrom);
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        }
    }

    public final AnnieXLynxModel build(Uri uri, boolean preload, TemplateData templateData, Map<String, ? extends Object> globalProps, boolean isCompactMode, String enterFrom) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:build");
        try {
            return build(uri, preload, templateData, globalProps, isCompactMode, enterFrom, true);
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:build");
        }
    }

    public final AnnieXLynxModel build(Uri uri, boolean preload, TemplateData templateData, Map<String, ? extends Object> globalProps, boolean isCompactMode, String enterFrom, boolean enablePrefetch) {
        AnnieXLynxModel build$anniex_release;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
        try {
            if (Intrinsics.areEqual(this.bid, "Loki")) {
                build$anniex_release = LokiManager.INSTANCE.createAnnieXLynxModel(uri, this.bid, this.lynxViewBuilderParams, INSTANCE.generateSessionId());
            } else {
                build$anniex_release = build$anniex_release(uri, preBuild(uri), preload, templateData, globalProps, isCompactMode, enterFrom, enablePrefetch);
            }
            return build$anniex_release;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0100 A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x010e A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015a A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018f A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02a9 A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b7 A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d5 A[Catch: all -> 0x0341, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00b1 A[Catch: all -> 0x0341, TRY_LEAVE, TryCatch #0 {all -> 0x0341, blocks: (B:3:0x001e, B:7:0x002d, B:13:0x003f, B:16:0x0049, B:18:0x0064, B:21:0x007c, B:25:0x0181, B:29:0x018f, B:31:0x01dc, B:32:0x01e7, B:34:0x023d, B:36:0x0243, B:38:0x0249, B:40:0x0289, B:42:0x028f, B:48:0x029d, B:53:0x02a9, B:62:0x02f2, B:65:0x0303, B:76:0x02b7, B:78:0x02c9, B:83:0x02d5, B:86:0x02d9, B:87:0x0267, B:92:0x0091, B:94:0x00a5, B:99:0x00b1, B:105:0x00e1, B:108:0x00e8, B:111:0x00ee, B:102:0x00f7, B:114:0x00d7, B:115:0x00fa, B:117:0x0100, B:118:0x0109, B:120:0x010e, B:121:0x015a, B:104:0x00b7), top: B:2:0x001e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AnnieXLynxModel build$anniex_release(Uri uri, String sessionId, boolean preload, TemplateData templateData, Map<String, ? extends Object> globalProps, boolean isCompactMode, String enterFrom, boolean enablePrefetch) {
        boolean z;
        TemplateData templateData2;
        TemplateData templateData3;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        Map<String, ? extends Object> map;
        String str2;
        TemplateData templateData4;
        boolean z5;
        TemplateData templateData5;
        boolean z6;
        TemplateData mergeGlobalProps;
        TemplateData templateData6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String queryParameter;
        Integer num;
        String str3;
        String str4;
        Object obj;
        TemplateData templateData7;
        TemplateData templateData8;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:buildInCompactMode");
        try {
            TemplateData lynxSSRRequestUrl = UrlExtKt.getLynxSSRRequestUrl(uri, this.bid, sessionId);
            String str5 = "";
            TemplateData templateData9 = lynxSSRRequestUrl == null ? "" : lynxSSRRequestUrl;
            boolean z11 = ((CharSequence) templateData9).length() > 0;
            if (z11 && (str5 = ExtKt.safeGetQueryParameter(uri, "ssr_mode")) == null) {
                str5 = SSR_MODE_SSR_MIX;
            }
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("enable_element_tree_reuse", false);
            TemplateData subUrl = UrlExtKt.getSubUrl(uri);
            TemplateData uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
            LynxViewBuilderParams updateLynxViewBuilderParams = updateLynxViewBuilderParams(uri);
            if (preload) {
                boolean areEqual = Intrinsics.areEqual(uri.getQueryParameter("enable_preload"), ApiMultiProcessSharedProvider.ALL_TYPE);
                boolean booleanQueryParameter2 = uri.getBooleanQueryParameter("enable_lynx_predecode", false);
                if (z11 && !Intrinsics.areEqual(str5, SSR_MODE_SSR_MIX)) {
                    str3 = "dynamic";
                    str4 = "getQueryParameter(\"dynamic\")";
                    templateData2 = null;
                    templateData3 = uri2;
                    z2 = booleanQueryParameter;
                    z3 = z11;
                    z4 = false;
                    if (((CharSequence) templateData9).length() > 0 ? true : z4 ? 1 : 0) {
                        ForestLoader forestLoader = ForestLoader.INSTANCE;
                        PreloadType preloadType = PreloadType.LYNX;
                        TaskConfig taskConfig = new TaskConfig(templateData2, 1, templateData2);
                        taskConfig.setCdnUrl(templateData9);
                        taskConfig.setCustomMaxAge(5);
                        taskConfig.setLoadToMemory(z4);
                        Pair[] pairArr = new Pair[2];
                        pairArr[z4 ? 1 : 0] = TuplesKt.to("x-accept-engine-version", LynxEnv.inst().getSSRApiVersion());
                        z = true;
                        pairArr[1] = TuplesKt.to("x-lynx-ssr-accept-type", "binary_v1");
                        taskConfig.setInjectedHttpHeaders(MapsKt.mapOf(pairArr));
                        String queryParameter2 = uri.getQueryParameter(str3);
                        if (queryParameter2 != null) {
                            Intrinsics.checkNotNullExpressionValue(queryParameter2, str4);
                            templateData8 = StringsKt.toIntOrNull(queryParameter2);
                        } else {
                            templateData8 = templateData2;
                        }
                        taskConfig.setDynamic(templateData8);
                        Unit unit = Unit.INSTANCE;
                        ForestLoader.preloadWithProcessor$default(forestLoader, (Forest) null, templateData3, areEqual, sessionId, preloadType, true, "AnnieX_card", taskConfig, true, new ForestLynxSSRProcessor(sessionId, this.bid, booleanQueryParameter2, areEqual, false, 16, (DefaultConstructorMarker) null), (Function2) null, InputDeviceCompat.SOURCE_GAMEPAD, (Object) null);
                    } else {
                        z = true;
                    }
                }
                boolean z12 = z11;
                TaskConfig taskConfig2 = new TaskConfig((String) null, 1, (DefaultConstructorMarker) null);
                taskConfig2.setBid(this.bid);
                CharSequence charSequence = (CharSequence) subUrl;
                if (charSequence != null && charSequence.length() != 0) {
                    z10 = false;
                    if (!z10) {
                        if (Intrinsics.areEqual(str5, SSR_MODE_SSR_MIX)) {
                            try {
                                Result.Companion companion = Result.Companion;
                                obj = Result.constructor-impl(Uri.parse(subUrl).buildUpon().appendQueryParameter("disable_cdn", DiskLruCache.VERSION).build().toString());
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            templateData7 = (String) obj;
                            if (templateData7 == null) {
                                templateData7 = subUrl;
                            }
                            Intrinsics.checkNotNullExpressionValue(templateData7, "{\n                      …                        }");
                        } else {
                            templateData7 = subUrl;
                        }
                        taskConfig2.setCdnUrl(templateData7);
                    }
                    queryParameter = uri.getQueryParameter("dynamic");
                    if (queryParameter == null) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "getQueryParameter(\"dynamic\")");
                        num = StringsKt.toIntOrNull(queryParameter);
                    } else {
                        num = null;
                    }
                    taskConfig2.setDynamic(num);
                    if (!booleanQueryParameter2) {
                        str4 = "getQueryParameter(\"dynamic\")";
                        str3 = "dynamic";
                        templateData2 = null;
                        templateData3 = uri2;
                        z2 = booleanQueryParameter;
                        z3 = z12;
                        z4 = false;
                        ForestLoader.preloadWithProcessor$default(ForestLoader.INSTANCE, (Forest) null, uri2, areEqual, sessionId, PreloadType.LYNX, true, "AnnieX_card", taskConfig2, true, new TemplateBundleProcessor(updateLynxViewBuilderParams.getCodeCacheSourceUrl(), false, 2, (DefaultConstructorMarker) null), (Function2) null, InputDeviceCompat.SOURCE_GAMEPAD, (Object) null);
                    } else {
                        str3 = "dynamic";
                        str4 = "getQueryParameter(\"dynamic\")";
                        templateData2 = null;
                        templateData3 = uri2;
                        z2 = booleanQueryParameter;
                        z4 = false;
                        z3 = z12;
                        ForestLoader.preload$default(ForestLoader.INSTANCE, (Forest) null, templateData3, areEqual, sessionId, PreloadType.LYNX, true, "AnnieX_card", taskConfig2, true, (Function2) null, InputDeviceCompat.SOURCE_DPAD, (Object) null);
                    }
                    if (((CharSequence) templateData9).length() > 0 ? true : z4 ? 1 : 0) {
                    }
                }
                z10 = true;
                if (!z10) {
                }
                queryParameter = uri.getQueryParameter("dynamic");
                if (queryParameter == null) {
                }
                taskConfig2.setDynamic(num);
                if (!booleanQueryParameter2) {
                }
                if (((CharSequence) templateData9).length() > 0 ? true : z4 ? 1 : 0) {
                }
            } else {
                z = true;
                templateData2 = null;
                templateData3 = uri2;
                z2 = booleanQueryParameter;
                z3 = z11;
                z4 = false;
            }
            if (!enablePrefetch || !UrlExtKt.getIsEnablePrefetch(uri)) {
                str = sessionId;
                map = globalProps;
                str2 = str5;
                templateData4 = templateData9;
                z5 = z4;
                templateData5 = templateData2;
                z6 = z;
            } else if (IConditionCallKt.enableLynxCardPrefetchWithBid()) {
                str2 = str5;
                z6 = z;
                templateData4 = templateData9;
                map = globalProps;
                z5 = z4;
                str = sessionId;
                templateData5 = templateData2;
                PrefetchV2.prefetchBySchemaUri$default(PrefetchV2.INSTANCE, uri, (PrefetchConfig) null, this.bid, 2, (Object) null);
            } else {
                str = sessionId;
                map = globalProps;
                str2 = str5;
                templateData4 = templateData9;
                z5 = z4;
                templateData5 = templateData2;
                z6 = z;
                PrefetchV2.prefetchBySchemaUri$default(PrefetchV2.INSTANCE, uri, (PrefetchConfig) null, (String) null, 6, (Object) null);
            }
            if (isCompactMode) {
                Map map2 = this.globalProps;
                if (map2 != null && !map2.isEmpty()) {
                    z7 = z5;
                    if (!z7) {
                        if (map != null && !globalProps.isEmpty()) {
                            z9 = z5;
                            if (!z9) {
                                templateData6 = templateData5;
                                boolean z13 = z3;
                                TemplateData templateData10 = !z13 ? templateData4 : templateData5;
                                TemplateData templateData11 = templateData10 != null ? subUrl == null ? templateData3 : subUrl : templateData10;
                                String str6 = this.bid;
                                if (((CharSequence) templateData4).length() > 0) {
                                    z6 = z5;
                                }
                                AnnieXLynxModel annieXLynxModel = new AnnieXLynxModel(templateData11, uri, str6, templateData6, null, updateLynxViewBuilderParams, sessionId, templateData, null, z6, isCompactMode, null, enterFrom, false, null, 26896, null);
                                annieXLynxModel.setLynxSSRViaSchemaConfig$anniex_release(z13);
                                annieXLynxModel.setSsrMode$anniex_release(str2);
                                annieXLynxModel.setEnableElementTreeReuse$anniex_release(z2);
                                MonitorManager.INSTANCE.onLynxModelCreateEnd(sessionId);
                                return annieXLynxModel;
                            }
                            mergeGlobalProps = TemplateData.empty();
                            mergeGlobalProps.updateData(map);
                        }
                        z9 = z6;
                        if (!z9) {
                        }
                    } else {
                        mergeGlobalProps = TemplateData.empty();
                        mergeGlobalProps.updateData(this.globalProps);
                        Intrinsics.checkNotNullExpressionValue(mergeGlobalProps, "empty().apply {\n        …lProps)\n                }");
                        if (map != null && !globalProps.isEmpty()) {
                            z8 = z5;
                            if (!z8) {
                                mergeGlobalProps.updateData(map);
                            }
                        }
                        z8 = z6;
                        if (!z8) {
                        }
                    }
                }
                z7 = z6;
                if (!z7) {
                }
            } else {
                mergeGlobalProps = mergeGlobalProps(uri, str, map);
            }
            templateData6 = mergeGlobalProps;
            boolean z132 = z3;
            if (!z132) {
            }
            if (templateData10 != null) {
            }
            String str62 = this.bid;
            if (((CharSequence) templateData4).length() > 0) {
            }
            AnnieXLynxModel annieXLynxModel2 = new AnnieXLynxModel(templateData11, uri, str62, templateData6, null, updateLynxViewBuilderParams, sessionId, templateData, null, z6, isCompactMode, null, enterFrom, false, null, 26896, null);
            annieXLynxModel2.setLynxSSRViaSchemaConfig$anniex_release(z132);
            annieXLynxModel2.setSsrMode$anniex_release(str2);
            annieXLynxModel2.setEnableElementTreeReuse$anniex_release(z2);
            MonitorManager.INSTANCE.onLynxModelCreateEnd(sessionId);
            return annieXLynxModel2;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:buildInCompactMode");
        }
    }

    public final AnnieXLynxModel copy(AnnieXLynxModel r21, TemplateData templateData, TemplateData globalProps) {
        AnnieXLynxModel copy;
        Intrinsics.checkNotNullParameter(r21, StrategyConstants.MODEL);
        TraceEvent.beginSection("AnnieXLynxModelBuilder:copy");
        try {
            String preBuild = preBuild(r21.getOriginalUri());
            if (copyModelBugfix()) {
                TemplateData globalProps2 = globalProps == null ? r21.getGlobalProps() : globalProps;
                if (globalProps2 != null) {
                    globalProps2.put("containerID", preBuild);
                }
            }
            if (templateData != null && globalProps != null) {
                globalProps.flush();
                copy = r21.copy((r32 & 1) != 0 ? r21.url : null, (r32 & 2) != 0 ? r21.originalUri : null, (r32 & 4) != 0 ? r21.bid : null, (r32 & 8) != 0 ? r21.globalProps : globalProps, (r32 & 16) != 0 ? r21.extra : null, (r32 & 32) != 0 ? r21.lynxViewBuilderParams : null, (r32 & 64) != 0 ? r21.sessionId : preBuild, (r32 & 128) != 0 ? r21.templateData : templateData, (r32 & 256) != 0 ? r21.template : null, (r32 & 512) != 0 ? r21.isSSR : false, (r32 & 1024) != 0 ? r21.isCompactMode : false, (r32 & 2048) != 0 ? r21.ssrHydrateConfig : null, (r32 & 4096) != 0 ? r21.enterFrom : null, (r32 & 8192) != 0 ? r21.useXBridge3 : false, (r32 & 16384) != 0 ? r21.compactConfig : null);
                copy.setEnableElementTreeReuse$anniex_release(r21.getEnableElementTreeReuse());
            } else if (templateData != null) {
                copy = r21.copy((r32 & 1) != 0 ? r21.url : null, (r32 & 2) != 0 ? r21.originalUri : null, (r32 & 4) != 0 ? r21.bid : null, (r32 & 8) != 0 ? r21.globalProps : null, (r32 & 16) != 0 ? r21.extra : null, (r32 & 32) != 0 ? r21.lynxViewBuilderParams : null, (r32 & 64) != 0 ? r21.sessionId : preBuild, (r32 & 128) != 0 ? r21.templateData : templateData, (r32 & 256) != 0 ? r21.template : null, (r32 & 512) != 0 ? r21.isSSR : false, (r32 & 1024) != 0 ? r21.isCompactMode : false, (r32 & 2048) != 0 ? r21.ssrHydrateConfig : null, (r32 & 4096) != 0 ? r21.enterFrom : null, (r32 & 8192) != 0 ? r21.useXBridge3 : false, (r32 & 16384) != 0 ? r21.compactConfig : null);
                copy.setEnableElementTreeReuse$anniex_release(r21.getEnableElementTreeReuse());
            } else if (globalProps != null) {
                globalProps.flush();
                copy = r21.copy((r32 & 1) != 0 ? r21.url : null, (r32 & 2) != 0 ? r21.originalUri : null, (r32 & 4) != 0 ? r21.bid : null, (r32 & 8) != 0 ? r21.globalProps : globalProps, (r32 & 16) != 0 ? r21.extra : null, (r32 & 32) != 0 ? r21.lynxViewBuilderParams : null, (r32 & 64) != 0 ? r21.sessionId : preBuild, (r32 & 128) != 0 ? r21.templateData : null, (r32 & 256) != 0 ? r21.template : null, (r32 & 512) != 0 ? r21.isSSR : false, (r32 & 1024) != 0 ? r21.isCompactMode : false, (r32 & 2048) != 0 ? r21.ssrHydrateConfig : null, (r32 & 4096) != 0 ? r21.enterFrom : null, (r32 & 8192) != 0 ? r21.useXBridge3 : false, (r32 & 16384) != 0 ? r21.compactConfig : null);
                copy.setEnableElementTreeReuse$anniex_release(r21.getEnableElementTreeReuse());
            } else {
                copy = r21.copy((r32 & 1) != 0 ? r21.url : null, (r32 & 2) != 0 ? r21.originalUri : null, (r32 & 4) != 0 ? r21.bid : null, (r32 & 8) != 0 ? r21.globalProps : null, (r32 & 16) != 0 ? r21.extra : null, (r32 & 32) != 0 ? r21.lynxViewBuilderParams : null, (r32 & 64) != 0 ? r21.sessionId : preBuild, (r32 & 128) != 0 ? r21.templateData : null, (r32 & 256) != 0 ? r21.template : null, (r32 & 512) != 0 ? r21.isSSR : false, (r32 & 1024) != 0 ? r21.isCompactMode : false, (r32 & 2048) != 0 ? r21.ssrHydrateConfig : null, (r32 & 4096) != 0 ? r21.enterFrom : null, (r32 & 8192) != 0 ? r21.useXBridge3 : false, (r32 & 16384) != 0 ? r21.compactConfig : null);
                copy.setEnableElementTreeReuse$anniex_release(r21.getEnableElementTreeReuse());
            }
            MonitorManager.INSTANCE.onLynxModelCreateEnd(preBuild);
            return copy;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:copy");
        }
    }

    public final String preBuild(Uri uri) {
        TraceEvent.beginSection("AnnieXLynxModelBuilder:preBuild");
        try {
            String generateSessionId = INSTANCE.generateSessionId();
            MonitorManager.INSTANCE.onLynxModelCreateBegin(this.bid, generateSessionId);
            MonitorManager.INSTANCE.updateUriIdentifier(generateSessionId, uri);
            return generateSessionId;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
    
        if (r4 != false) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TemplateData mergeGlobalProps(Uri uri, String sessionId, Map<String, ? extends Object> globalProps) {
        Map<String, Object> anniXConstants;
        TraceEvent.beginSection("AnnieXLynxModelBuilder:mergeGlobalProps");
        try {
            HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", "mergeGlobalProps:" + sessionId, (Map) null, (LoggerContext) null, 12, (Object) null);
            if (this.finalGlobalProps == null) {
                Map<String, Object> commonGlobalProps = GlobalPropsHelper.INSTANCE.getCommonGlobalProps(KitType.LYNX, this.bid);
                boolean z = true;
                commonGlobalProps.put("useXBridge3", true);
                commonGlobalProps.put("usePiperData", false);
                if (!IConditionCallKt.enableCardBuilderPropsFix()) {
                    for (Map.Entry entry : this.globalProps.entrySet()) {
                        commonGlobalProps.put(entry.getKey(), entry.getValue());
                    }
                }
                if (commonGlobalProps.get("osVersion") != null) {
                    if (String.valueOf(commonGlobalProps.get("osVersion")).length() != 0) {
                        z = false;
                    }
                }
                String system = BulletDeviceUtils.INSTANCE.getSystem();
                String str = "get osVersion by cache == null, osVersion is" + system;
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieX", str, (Map) null, (LoggerContext) null, 12, (Object) null);
                commonGlobalProps.put("osVersion", system);
                AnnieXCardErrorMonitor.INSTANCE.reportGlobalPropsError(str);
                this.finalGlobalProps = commonGlobalProps;
            }
            TemplateData empty = TemplateData.empty();
            if (this.finalGlobalProps != null) {
                Map map = this.finalGlobalProps;
                Intrinsics.checkNotNull(map);
                empty.updateData(map);
                if (IConditionCallKt.enableCardBuilderPropsFix()) {
                    empty.updateData(this.globalProps);
                }
                empty.updateData(GlobalPropsHelper.INSTANCE.getUriGlobalProps(KitType.LYNX, uri, this.bid, sessionId, this.cacheUrlGlobalProps));
                empty.put("containerID", sessionId);
                IAnnieXBizPropsProvider iAnnieXBizPropsProvider = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(this.bid, IAnnieXBizPropsProvider.class);
                if (iAnnieXBizPropsProvider != null && (anniXConstants = iAnnieXBizPropsProvider.getAnniXConstants(KitType.LYNX, this.bid, uri)) != null) {
                    empty.updateData(anniXConstants);
                }
                if (globalProps != null) {
                    empty.updateData(globalProps);
                }
            }
            TraceEvent.beginSection("TemplateData:flush");
            try {
                empty.flush();
                Unit unit = Unit.INSTANCE;
                TraceEvent.endSection("TemplateData:flush");
                Intrinsics.checkNotNullExpressionValue(empty, "empty().apply {\n        …)\n            }\n        }");
                return empty;
            } catch (Throwable th) {
                TraceEvent.endSection("TemplateData:flush");
                throw th;
            }
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:mergeGlobalProps");
        }
    }

    public final LynxViewBuilderParams updateLynxViewBuilderParams(Uri uri) {
        LynxViewBuilderParams lynxViewBuilderParams;
        TraceEvent.beginSection("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        try {
            if (!this.lynxViewBuilderParams.getEnableUserCodeCache()) {
                lynxViewBuilderParams = this.lynxViewBuilderParams;
            } else {
                lynxViewBuilderParams = r2.copy((r42 & 1) != 0 ? r2.enableLayoutSafepoint : false, (r42 & 2) != 0 ? r2.threadStrategy : null, (r42 & 4) != 0 ? r2.lynxGroup : null, (r42 & 8) != 0 ? r2.lynxGroupName : null, (r42 & 16) != 0 ? r2.presetHeightMeasureSpec : 0, (r42 & 32) != 0 ? r2.presetWidthMeasureSpec : 0, (r42 & 64) != 0 ? r2.fontScale : 0.0f, (r42 & 128) != 0 ? r2.enableCreateViewAsync : false, (r42 & 256) != 0 ? r2.enableSyncFlush : false, (r42 & 512) != 0 ? r2.customInit : null, (r42 & 1024) != 0 ? r2.enableAutoExpose : false, (r42 & 2048) != 0 ? r2.screenWidth : 0, (r42 & 4096) != 0 ? r2.screenHeight : 0, (r42 & 8192) != 0 ? r2.behaviors : null, (r42 & 16384) != 0 ? r2.modules : null, (r42 & 32768) != 0 ? r2.resourceProviders : null, (r42 & 65536) != 0 ? r2.fontLoader : null, (r42 & 131072) != 0 ? r2.enablePendingJsTask : false, (r42 & 262144) != 0 ? r2.enableJSRuntime : false, (r42 & 524288) != 0 ? r2.enableAirStrictMode : false, (r42 & 1048576) != 0 ? r2.enableUserCodeCache : false, (r42 & 2097152) != 0 ? r2.codeCacheSourceUrl : UrlExtKt.getIdentifierUrl(uri), (r42 & 4194304) != 0 ? r2.enableVSyncAlignedMessageLoop : false, (r42 & 8388608) != 0 ? this.lynxViewBuilderParams.viewZoom : 0.0f);
                if (IConditionCallKt.enableLynxViewBuilderParamsFix()) {
                    lynxViewBuilderParams.setLynxViewConfig$anniex_release(this.lynxViewBuilderParams.getLynxViewConfig$anniex_release());
                    lynxViewBuilderParams.setUri(this.lynxViewBuilderParams.getUri());
                }
            }
            return lynxViewBuilderParams;
        } finally {
            TraceEvent.endSection("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        }
    }
}
