package com.bytedance.android.anniex.web.api;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.optimize.JSBPreHandleManager;
import com.bytedance.android.anniex.utils.AnnieXUrlExtKt;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.forest.ForestPreloadHelper;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfig;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AnnieXWebModelBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\bJm\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018JT\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002JH\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/web/api/AnnieXWebModelBuilder;", "", "context", "Landroid/content/Context;", "bid", "", "globalProps", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "finalGlobalProps", "build", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "sessionId", "uri", "Landroid/net/Uri;", "modelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "preload", "", "preCreate", "", "needSccDelegate", "enablePrefetch", "enterFrom", "build$anniex_release", StreamTrafficObservable.STREAM_URL, "getContextProvider", "Lcom/bytedance/android/anniex/ability/service/IAnnieXContextProvider;", "mergeGlobalProps", "isCompactMode", "preBuild", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebModelBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bid;
    private final Context context;
    private Map<String, Object> finalGlobalProps;
    private final Map<String, Object> globalProps;

    public AnnieXWebModelBuilder() {
        this(null, null, null, 7, null);
    }

    public AnnieXWebModelBuilder(Context context, String str, Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(map, "globalProps");
        this.context = context;
        this.bid = str;
        this.globalProps = map;
    }

    public /* synthetic */ AnnieXWebModelBuilder(Application application, String str, LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BulletEnv.Companion.getInstance().getApplication() : application, (i & 2) != 0 ? "default_bid" : str, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final AnnieXWebModel build(String r12, boolean preload, boolean preCreate, Map<String, ? extends Object> globalProps, boolean needSccDelegate, boolean enablePrefetch, String enterFrom) {
        Intrinsics.checkNotNullParameter(r12, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Uri parse = Uri.parse(r12);
        Intrinsics.checkNotNullExpressionValue(parse, "uri");
        return build$anniex_release(preBuild(parse), parse, null, preload, preCreate, globalProps, needSccDelegate, enablePrefetch, enterFrom);
    }

    public final AnnieXWebModel build$anniex_release(String sessionId, Uri uri, SchemaModelUnion modelUnion, boolean preload, boolean preCreate, Map<String, ? extends Object> globalProps, boolean needSccDelegate, boolean enablePrefetch, String enterFrom) {
        String str;
        boolean z;
        SchemaModelUnion schemaModelUnion;
        SchemaModelUnion schemaModelUnion2;
        boolean z2;
        IWebKitService iWebKitService;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = uri;
        if (modelUnion == null) {
            SchemaService companion = SchemaService.Companion.getInstance();
            Uri uri2 = (Uri) objectRef.element;
            SchemaConfig schemaConfig = new SchemaConfig();
            schemaConfig.addInterceptor(new AnnieXLiteGlobalPropsInterceptor(this.bid));
            schemaConfig.addInterceptor(new AnnieXLiteForestInterceptor());
            Unit unit = Unit.INSTANCE;
            companion.bindConfig(uri2, schemaConfig);
        }
        SchemaModelUnion schemaModelUnion3 = modelUnion == null ? new SchemaModelUnion(SchemaService.Companion.getInstance().generateSchemaData(this.bid, (Uri) objectRef.element, true)) : modelUnion;
        String str2 = (String) schemaModelUnion3.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
        Uri parse = str2 != null ? Uri.parse(str2) : null;
        if (parse == null) {
            parse = (Uri) objectRef.element;
        } else {
            Intrinsics.checkNotNullExpressionValue(parse, "_modelUnion.schemaData.q…ri.parse(it) } ?: realUri");
        }
        objectRef.element = parse;
        schemaModelUnion3.setContainerModel(SchemaService.Companion.getInstance().generateSchemaModel(schemaModelUnion3.getSchemaData(), BDXContainerModel.class));
        schemaModelUnion3.setUiModel(SchemaService.Companion.getInstance().generateSchemaModel(schemaModelUnion3.getSchemaData(), BDXContainerModel.class));
        schemaModelUnion3.setKitModel(SchemaService.Companion.getInstance().generateSchemaModel(schemaModelUnion3.getSchemaData(), BDXWebKitModel.class));
        BDXWebKitModel kitModel = schemaModelUnion3.getKitModel();
        Intrinsics.checkNotNull(kitModel, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel");
        if (Intrinsics.areEqual(kitModel.getAppendCommonParams().getValue(), true)) {
            StringBuilder sb = new StringBuilder(((Uri) objectRef.element).toString());
            IAnnieXContextProvider contextProvider = getContextProvider(this.bid);
            if (contextProvider != null) {
                contextProvider.appendCommonParams((Uri) objectRef.element, sb, false);
            }
            Uri parse2 = Uri.parse(sb.toString());
            Intrinsics.checkNotNullExpressionValue(parse2, "parse(builder.toString())");
            objectRef.element = parse2;
        }
        if (enablePrefetch && AnnieXUrlExtKt.IsEnablePrefetch((Uri) objectRef.element)) {
            PrefetchV2.prefetchBySchemaUri$default(PrefetchV2.INSTANCE, (Uri) objectRef.element, (PrefetchConfig) null, this.bid, 2, (Object) null);
        }
        String subUrl = AnnieXWebModelBuilderKt.getSubUrl((Uri) objectRef.element);
        String uri3 = ((Uri) objectRef.element).toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "realUri.toString()");
        if (preload) {
            str = uri3;
            z = false;
            schemaModelUnion = schemaModelUnion3;
            ForestPreloadHelper.preloadPage$default(ForestPreloadHelper.INSTANCE, schemaModelUnion3, (Uri) objectRef.element, sessionId, this.bid, PreloadType.WEB, (String) null, false, 96, (Object) null);
        } else {
            str = uri3;
            z = false;
            schemaModelUnion = schemaModelUnion3;
        }
        Map<String, Object> mergeGlobalProps = mergeGlobalProps((Uri) objectRef.element, sessionId, globalProps, AnnieXWebModelBuilderKt.isCompactMode(schemaModelUnion));
        if (PiaHelper.INSTANCE.support(str, this.bid)) {
            schemaModelUnion2 = schemaModelUnion;
            PiaHelper.INSTANCE.warmup(str, this.bid, sessionId, schemaModelUnion2);
            if (mergeGlobalProps != null) {
                PiaHelper.INSTANCE.updateGlobalProps(this.bid, mergeGlobalProps);
            }
            z2 = true;
        } else {
            schemaModelUnion2 = schemaModelUnion;
            z2 = z;
        }
        JSBPreHandleManager.INSTANCE.startPreHandle(sessionId, this.bid, str, PlatformType.WEB);
        String str3 = this.bid;
        String str4 = subUrl == null ? str : subUrl;
        Uri uri4 = (Uri) objectRef.element;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (globalProps != null) {
            linkedHashMap.putAll(globalProps);
        }
        SchemaModelUnion schemaModelUnion4 = schemaModelUnion2;
        AnnieXWebModel annieXWebModel = new AnnieXWebModel(str3, str4, uri4, sessionId, z2, linkedHashMap, mergeGlobalProps, schemaModelUnion2, enterFrom, needSccDelegate);
        if (preCreate && (iWebKitService = ServiceCenter.Companion.instance().get(this.bid, IWebKitService.class)) != null && !iWebKitService.ready()) {
            iWebKitService.initKit(annieXWebModel);
        }
        annieXWebModel.getBulletContext().setSchemaModelUnion(schemaModelUnion4);
        annieXWebModel.getBulletContext().setSchemaData(schemaModelUnion4.getSchemaData());
        MonitorManager.INSTANCE.onWebModelCreateEnd(sessionId);
        return annieXWebModel;
    }

    private final String preBuild(Uri uri) {
        String generateSessionId = INSTANCE.generateSessionId();
        MonitorManager.INSTANCE.onWebModelCreateBegin(this.bid, generateSessionId);
        MonitorManager.INSTANCE.updateUriIdentifier(generateSessionId, uri);
        return generateSessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Map mergeGlobalProps$default(AnnieXWebModelBuilder annieXWebModelBuilder, Uri uri, String str, Map map, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return annieXWebModelBuilder.mergeGlobalProps(uri, str, map, z);
    }

    private final Map<String, Object> mergeGlobalProps(Uri uri, String sessionId, Map<String, ? extends Object> globalProps, boolean isCompactMode) {
        Map<String, Object> anniXConstants;
        if (this.finalGlobalProps == null) {
            Map<String, Object> commonGlobalProps = GlobalPropsHelper.INSTANCE.getCommonGlobalProps(KitType.WEB, this.bid);
            if (!IConditionCallKt.enableCardBuilderPropsFix()) {
                for (Map.Entry<String, Object> entry : this.globalProps.entrySet()) {
                    commonGlobalProps.put(entry.getKey(), entry.getValue());
                }
            }
            this.finalGlobalProps = commonGlobalProps;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Object> map = this.finalGlobalProps;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            linkedHashMap.putAll(map);
            if (IConditionCallKt.enableCardBuilderPropsFix()) {
                linkedHashMap.putAll(this.globalProps);
            }
            linkedHashMap.put("containerID", sessionId);
            if (globalProps != null) {
                linkedHashMap.putAll(globalProps);
            }
        }
        if (isCompactMode && IConditionCallKt.enableAnnieXLiveCompactMode()) {
            IAnnieXBizPropsProvider iAnnieXBizPropsProvider = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(this.bid, IAnnieXBizPropsProvider.class);
            if (iAnnieXBizPropsProvider != null) {
                iAnnieXBizPropsProvider.assembleBizProps(linkedHashMap, KitType.WEB, this.bid, uri);
            }
        } else {
            IAnnieXBizPropsProvider iAnnieXBizPropsProvider2 = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(this.bid, IAnnieXBizPropsProvider.class);
            if (iAnnieXBizPropsProvider2 != null && (anniXConstants = iAnnieXBizPropsProvider2.getAnniXConstants(KitType.WEB, this.bid, uri)) != null) {
                linkedHashMap.putAll(anniXConstants);
            }
        }
        return linkedHashMap;
    }

    /* compiled from: AnnieXWebModelBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/web/api/AnnieXWebModelBuilder$Companion;", "", "()V", "generateSessionId", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

    private final IAnnieXContextProvider getContextProvider(String bid) {
        if (AnnieXSettings.INSTANCE.getOptimizeBulletInit()) {
            return (IAnnieXContextProvider) AnnieXServiceCenter.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        }
        IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
        return iAnnieXContextProvider == null ? (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class) : iAnnieXContextProvider;
    }
}
