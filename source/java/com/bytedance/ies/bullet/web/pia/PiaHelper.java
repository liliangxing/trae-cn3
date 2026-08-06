package com.bytedance.ies.bullet.web.pia;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.android.anniex.ability.service.IAnnieXAccountService;
import com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilderKt;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.web.pia.PiaHelper;
import com.bytedance.ies.bullet.web.pia.PiaResourceLoader;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.plugin.IPiaLifeCycle;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.api.services.IPiaEnvService;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.pia.core.api.services.IPiaRenderingService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.plugins.RenderingPlugin;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PiaHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004J8\u0010\u000b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r`\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002JR\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0018\u00010\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u00190\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\"\u0010 \u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0019J\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J*\u0010$\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010'J\u0012\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,J\n\u0010-\u001a\u00020.*\u00020/J\n\u00100\u001a\u00020**\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaHelper;", "", "()V", "BULLET_PIA_NAMESPACE_PREFIX", "", "piaContextMap", "", "Lcom/bytedance/ies/bullet/web/pia/PiaHelper$PiaContext;", "createPiaLifeCycle", "Lcom/bytedance/ies/bullet/web/pia/PiaLifeCycle;", "bid", "createPiaMethodsSet", "Ljava/util/HashSet;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashSet;", "ensurePiaEnvInit", "", "getMethodList", "", "getNameSpace", RenderingPlugin.KEY_RENDERING, "Lcom/bytedance/pia/core/api/utils/IReleasable;", "url", "context", "", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "support", "", "updateGlobalProps", "globalProps", "updateUserAgent", "userAgent", "warmup", "sessionId", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "toIResourceResponse", "Lcom/bytedance/pia/core/api/resource/IResourceResponse;", "Landroid/webkit/WebResourceResponse;", "loadFrom", "Lcom/bytedance/pia/core/api/resource/LoadFrom;", "toResourceRequest", "Lcom/bytedance/pia/core/api/resource/IResourceRequest;", "Landroid/webkit/WebResourceRequest;", "toWebResourceResponse", "PiaContext", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaHelper {
    private static final String BULLET_PIA_NAMESPACE_PREFIX = "bullet-";
    public static final PiaHelper INSTANCE = new PiaHelper();
    private static final Map<String, PiaContext> piaContextMap = new LinkedHashMap();

    /* compiled from: PiaHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR,\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaHelper$PiaContext;", "", "userAgent", "", "globalProps", "", "bid", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "getGlobalProps", "()Ljava/util/Map;", "setGlobalProps", "(Ljava/util/Map;)V", "piaMethodsSet", "", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lorg/json/JSONObject;", "getPiaMethodsSet", "()Ljava/util/Set;", "setPiaMethodsSet", "(Ljava/util/Set;)V", "getUserAgent", "setUserAgent", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class PiaContext {
        private final String bid;
        private Map<String, ? extends Object> globalProps;
        private Set<? extends PiaMethod<JSONObject, Object>> piaMethodsSet;
        private String userAgent;

        public PiaContext(String str, Map<String, ? extends Object> map, String str2) {
            Intrinsics.checkNotNullParameter(str, "userAgent");
            Intrinsics.checkNotNullParameter(map, "globalProps");
            Intrinsics.checkNotNullParameter(str2, "bid");
            this.userAgent = str;
            this.globalProps = map;
            this.bid = str2;
            this.piaMethodsSet = PiaHelper.INSTANCE.createPiaMethodsSet(str2);
        }

        public final String getBid() {
            return this.bid;
        }

        public final Map<String, Object> getGlobalProps() {
            return this.globalProps;
        }

        public final String getUserAgent() {
            return this.userAgent;
        }

        public final void setGlobalProps(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.globalProps = map;
        }

        public final void setUserAgent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userAgent = str;
        }

        public final Set<PiaMethod<JSONObject, Object>> getPiaMethodsSet() {
            return this.piaMethodsSet;
        }

        public final void setPiaMethodsSet(Set<? extends PiaMethod<JSONObject, Object>> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.piaMethodsSet = set;
        }
    }

    private PiaHelper() {
    }

    private final List<String> getMethodList(String bid) {
        List<String> mutableListOf = CollectionsKt.mutableListOf(new String[]{"x.getAppInfo", "x.getAPIParams", "x.getUserInfo", "x.getSettings", "x.setStorageItem", "x.getStorageItem", "x.getStorageInfo", "x.removeStorageItem", "x.reportAppLog", "x.reportMonitorLog", "x.reportALog", "x.request", "x.subscribeEvent", "x.unsubscribeEvent", "x.publishEvent"});
        if (Intrinsics.areEqual(bid, BidConstants.WEBCAST)) {
            mutableListOf.add("fetch");
        }
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<PiaMethod<JSONObject, Object>> createPiaMethodsSet(final String bid) {
        final IDLXBridgeMethod iDLXBridgeMethod;
        HashSet<PiaMethod<JSONObject, Object>> hashSet = new HashSet<>();
        IAnnieXPiaMethodProvider iAnnieXPiaMethodProvider = ServiceCenter.INSTANCE.instance().get(bid, IAnnieXPiaMethodProvider.class);
        Map providerMethod = iAnnieXPiaMethodProvider != null ? iAnnieXPiaMethodProvider.providerMethod(bid) : null;
        for (final String str : getMethodList(bid)) {
            if (providerMethod != null && (iDLXBridgeMethod = (IDLXBridgeMethod) providerMethod.get(str)) != null) {
                hashSet.add(new PiaMethod<>(str, new IFactory() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$createPiaMethodsSet$1$1$ll$1
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public final PiaMethod.ICall<JSONObject, Object> create() {
                        return new PiaXBridge3Adapter(bid, str, iDLXBridgeMethod);
                    }
                }));
            }
        }
        return hashSet;
    }

    private final String getNameSpace(String bid) {
        String str = BULLET_PIA_NAMESPACE_PREFIX + bid;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(BULLET_PIA…X).append(bid).toString()");
        return str;
    }

    private final void ensurePiaEnvInit(final String bid) {
        IFactory<Map<String, ?>> iFactory;
        CommonConfig commonConfig;
        try {
            IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
            Boolean enablePiaGlobalProps = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? null : commonConfig.getEnablePiaGlobalProps();
            Map<String, PiaContext> map = piaContextMap;
            if (map.containsKey(bid)) {
                return;
            }
            BulletLogger.INSTANCE.printLog("init PiaEnv for " + bid, LogLevel.I, "XWebKit");
            final PiaContext piaContext = new PiaContext("", MapsKt.emptyMap(), bid);
            map.put(bid, piaContext);
            IPiaEnvService inst = IPiaEnvService.inst();
            if (inst != null) {
                PiaEnv piaEnv = new PiaEnv();
                piaEnv.setNameSpace(INSTANCE.getNameSpace(bid));
                if (!Intrinsics.areEqual(bid, BidConstants.WEBCAST) || !Intrinsics.areEqual(enablePiaGlobalProps, true)) {
                    iFactory = new IFactory() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$2
                        @Override // com.bytedance.pia.core.api.utils.IFactory
                        public final Map<String, ?> create() {
                            return PiaHelper.PiaContext.this.getGlobalProps();
                        }
                    };
                } else {
                    iFactory = new IFactory<Map<String, ?>>() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$1
                        @Override // com.bytedance.pia.core.api.utils.IFactory
                        public Map<String, ?> create() {
                            return create((Object) null);
                        }

                        @Override // com.bytedance.pia.core.api.utils.IFactory
                        public Map<String, ?> create(Object customContext) {
                            CommonConfig commonConfig2;
                            Boolean enablePrefetchUpdateContainerType;
                            SchemaModelUnion schemaModelUnion;
                            ISchemaData schemaData;
                            Uri innerOriginUrl;
                            SchemaModelUnion schemaModelUnion2;
                            ISchemaData schemaData2;
                            Map<String, Object> map2 = null;
                            r1 = null;
                            r1 = null;
                            r1 = null;
                            String str = null;
                            PiaCustomContext piaCustomContext = customContext instanceof PiaCustomContext ? (PiaCustomContext) customContext : null;
                            PiaResourceLoader.Config config = piaCustomContext != null ? (PiaResourceLoader.Config) piaCustomContext.get(PiaResourceLoader.Config.class) : null;
                            IPIAParamsService iPIAParamsService = (IPIAParamsService) ServiceCenter.INSTANCE.instance().get(bid, IPIAParamsService.class);
                            if (iPIAParamsService != null) {
                                Context applicationContext = PiaEnv.Default.getApplicationContext();
                                String valueOf = String.valueOf((config == null || (schemaModelUnion2 = config.getSchemaModelUnion()) == null || (schemaData2 = schemaModelUnion2.getSchemaData()) == null) ? null : schemaData2.getInnerOriginUrl());
                                if (config != null && (schemaModelUnion = config.getSchemaModelUnion()) != null && (schemaData = schemaModelUnion.getSchemaData()) != null && (innerOriginUrl = schemaData.getInnerOriginUrl()) != null) {
                                    str = AnnieXWebModelBuilderKt.getSubUrl(innerOriginUrl);
                                }
                                map2 = iPIAParamsService.getGlobalProps(applicationContext, valueOf, false, str);
                            }
                            IBulletSettingsService iBulletSettingsService2 = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
                            if (((iBulletSettingsService2 == null || (commonConfig2 = (CommonConfig) iBulletSettingsService2.obtainSettings(CommonConfig.class)) == null || (enablePrefetchUpdateContainerType = commonConfig2.getEnablePrefetchUpdateContainerType()) == null) ? true : enablePrefetchUpdateContainerType.booleanValue()) && map2 != null) {
                                map2.put("containerType", "annie");
                            }
                            return map2 == null ? new LinkedHashMap() : map2;
                        }
                    };
                }
                piaEnv.setGlobalPropsFactory(iFactory);
                piaEnv.setSensitiveHeaderFactory((IFactory) new IFactory<Map<String, ? extends String>>() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$3
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public Map<String, ? extends String> create() {
                        return create((Object) null);
                    }

                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public Map<String, ? extends String> create(Object customContext) {
                        IAnnieXAccountService service;
                        String accessTokenForAuthPlatform;
                        BooleanParam enableAccessToken;
                        SchemaModelUnion schemaModelUnion;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        PiaCustomContext piaCustomContext = customContext instanceof PiaCustomContext ? (PiaCustomContext) customContext : null;
                        PiaResourceLoader.Config config = piaCustomContext != null ? (PiaResourceLoader.Config) piaCustomContext.get(PiaResourceLoader.Config.class) : null;
                        Object containerModel = (config == null || (schemaModelUnion = config.getSchemaModelUnion()) == null) ? null : schemaModelUnion.getContainerModel();
                        BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
                        if (((bDXContainerModel == null || (enableAccessToken = bDXContainerModel.getEnableAccessToken()) == null) ? false : Intrinsics.areEqual(enableAccessToken.getValue(), true)) && (service = AnnieXServiceCenter.INSTANCE.getService("default_bid", IAnnieXAccountService.class)) != null && (accessTokenForAuthPlatform = service.accessTokenForAuthPlatform()) != null) {
                            linkedHashMap.put("Authorization", accessTokenForAuthPlatform);
                        }
                        return linkedHashMap;
                    }
                });
                piaEnv.setSecurityFactory(new IFactory<ISecurityDelegate>() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$4
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public ISecurityDelegate create() {
                        return create((Object) null);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public ISecurityDelegate create(Object customContext) {
                        return new PiaSecurityDelegate();
                    }
                });
                piaEnv.setPiaMethodsFactory(new IFactory() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$5
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public final Set<PiaMethod<?, ?>> create() {
                        return PiaHelper.PiaContext.this.getPiaMethodsSet();
                    }
                });
                piaEnv.setResourceLoaderFactory(new IFactory<IResourceLoader>() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$6
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public IResourceLoader create(Object customContext) {
                        String str = bid;
                        PiaCustomContext piaCustomContext = customContext instanceof PiaCustomContext ? (PiaCustomContext) customContext : null;
                        return new PiaResourceLoader(str, piaCustomContext != null ? (PiaResourceLoader.Config) piaCustomContext.get(PiaResourceLoader.Config.class) : null);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public IResourceLoader create() {
                        return new PiaResourceLoader(bid, null, 2, null);
                    }
                });
                piaEnv.setWorkerUserAgentFactory(new IFactory() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$ensurePiaEnvInit$1$7
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public final String create() {
                        if (PiaHelper.PiaContext.this.getUserAgent().length() == 0) {
                            String cachedWebUserAgent$anniex_release = AnnieXRuntime.INSTANCE.getApplicationDepend().getCachedWebUserAgent$anniex_release();
                            return (!Intrinsics.areEqual(bid, BidConstants.WEBCAST) || StringsKt.contains$default(cachedWebUserAgent$anniex_release, "WebcastSDK", false, 2, (Object) null)) ? cachedWebUserAgent$anniex_release : cachedWebUserAgent$anniex_release + " WebcastSDK/unknown";
                        }
                        return PiaHelper.PiaContext.this.getUserAgent();
                    }
                });
                inst.initialize(piaEnv);
            }
        } catch (NullPointerException unused) {
            BulletLogger.INSTANCE.printLog("init PiaEnv failed", LogLevel.E, "XWebKit");
        }
    }

    public final boolean support(String url, String bid) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ensurePiaEnvInit(bid);
        IPiaLifeCycleService inst = IPiaLifeCycleService.inst();
        if (inst != null) {
            return inst.support(url);
        }
        return false;
    }

    public final boolean support(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ensurePiaEnvInit("default_bid");
        IPiaLifeCycleService inst = IPiaLifeCycleService.inst();
        if (inst != null) {
            return inst.support(url);
        }
        return false;
    }

    public final void warmup(String url, String bid, String sessionId, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bid, "bid");
        ensurePiaEnvInit(bid);
        IPiaLifeCycleService inst = IPiaLifeCycleService.inst();
        if (inst != null) {
            String nameSpace = getNameSpace(bid);
            PiaContext piaContext = piaContextMap.get(bid);
            inst.warmup(url, nameSpace, new PiaCustomContext(new PiaResourceLoader.Config(sessionId, schemaModelUnion, piaContext != null ? piaContext.getUserAgent() : null)));
        }
    }

    public final PiaLifeCycle createPiaLifeCycle(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        IPiaLifeCycleService inst = IPiaLifeCycleService.inst();
        PiaResourceLoader.Config config = null;
        if (inst == null) {
            return null;
        }
        IPiaLifeCycle createLifeCycle = inst.createLifeCycle(INSTANCE.getNameSpace(bid), new PiaCustomContext(config, 1, config));
        Intrinsics.checkNotNullExpressionValue(createLifeCycle, "it.createLifeCycle(getNa…bid), PiaCustomContext())");
        return new PiaLifeCycle(createLifeCycle);
    }

    public final void updateUserAgent(String bid, String userAgent) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        PiaContext piaContext = piaContextMap.get(bid);
        if (piaContext != null) {
            piaContext.setUserAgent(userAgent);
        }
    }

    public final void updateGlobalProps(String bid, Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
        PiaContext piaContext = piaContextMap.get(bid);
        if (piaContext != null) {
            piaContext.setGlobalProps(globalProps);
        }
    }

    public final IReleasable rendering(String bid, String url, Map<String, ?> context, IConsumer<Map<String, ?>> resolve, IConsumer<PiaMethod.Error> reject) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        IPiaRenderingService inst = IPiaRenderingService.inst();
        if (inst == null) {
            reject.accept(new PiaMethod.Error("IPiaRenderingService isn't implemented"));
            return null;
        }
        String nameSpace = getNameSpace(bid);
        if (context == null) {
            context = new HashMap();
        }
        return inst.execute(url, nameSpace, context, resolve, reject);
    }

    public final WebResourceResponse toWebResourceResponse(IResourceResponse iResourceResponse) {
        Intrinsics.checkNotNullParameter(iResourceResponse, "<this>");
        return new WebResourceResponse(iResourceResponse.get$mimeType(), iResourceResponse.get$encoding(), iResourceResponse.getData());
    }

    public final IResourceRequest toResourceRequest(final WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "<this>");
        return new IResourceRequest() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$toResourceRequest$1
            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            /* renamed from: getUrl */
            public Uri get$uri() {
                return webResourceRequest.getUrl();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public boolean isForMainFrame() {
                return webResourceRequest.isForMainFrame();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public Map<String, String> getRequestHeaders() {
                return webResourceRequest.getRequestHeaders();
            }
        };
    }

    public final IResourceResponse toIResourceResponse(final WebResourceResponse webResourceResponse, final LoadFrom loadFrom) {
        Intrinsics.checkNotNullParameter(webResourceResponse, "<this>");
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        return new IResourceResponse() { // from class: com.bytedance.ies.bullet.web.pia.PiaHelper$toIResourceResponse$1
            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getMimeType */
            public String get$mimeType() {
                return webResourceResponse.getMimeType();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getEncoding */
            public String get$encoding() {
                return webResourceResponse.getEncoding();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getStatusCode */
            public int get$statusCode() {
                return webResourceResponse.getStatusCode();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getReasonPhrase */
            public String get$reasonPhrase() {
                String reasonPhrase = webResourceResponse.getReasonPhrase();
                return reasonPhrase == null ? "" : reasonPhrase;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public Map<String, String> getHeaders() {
                return webResourceResponse.getResponseHeaders();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            /* renamed from: getLoadFrom, reason: from getter */
            public LoadFrom get$loadFrom() {
                return loadFrom;
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceResponse
            public InputStream getData() {
                return webResourceResponse.getData();
            }
        };
    }
}
