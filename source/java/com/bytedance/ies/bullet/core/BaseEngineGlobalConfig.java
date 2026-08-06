package com.bytedance.ies.bullet.core;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeHandleUnit;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.bridge.IBridgeScopeProviderFactory;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.model.pipeline.IProcessor;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.BulletLoadUriIdentifier;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\"H\u0016J\u0018\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\"H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/bytedance/ies/bullet/core/BaseEngineGlobalConfig;", "Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "()V", "bridgeRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "getBridgeRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "setBridgeRegistry", "(Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "bulletLifeCycleListenerList", "", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "getBulletLifeCycleListenerList", "()Ljava/util/List;", "setBulletLifeCycleListenerList", "(Ljava/util/List;)V", "defaultBid", "", "getDefaultBid", "()Ljava/lang/String;", "globalProps", "", "", "getGlobalProps", "()Ljava/util/Map;", "setGlobalProps", "(Ljava/util/Map;)V", "config", "", "packageNames", "", "createOrMergeBridgeRegistry", "bridgeService", "Lcom/bytedance/ies/bullet/core/kit/service/IBridgeService;", "useOthersOnConflict", "", "reset", "updateBridgeRegister", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "updateGlobalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseEngineGlobalConfig implements IEngineGlobalConfig {
    private IBridgeRegistry bridgeRegistry;
    private BulletContext bulletContext;
    private Map<String, Object> globalProps = new LinkedHashMap();
    private List<IBulletLoadLifeCycle> bulletLifeCycleListenerList = new ArrayList();

    /* compiled from: BulletContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KitType.values().length];
            try {
                iArr[KitType.LYNX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KitType.WEB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void setGlobalProps(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.globalProps = map;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public List<IBulletLoadLifeCycle> getBulletLifeCycleListenerList() {
        return this.bulletLifeCycleListenerList;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void setBulletLifeCycleListenerList(List<IBulletLoadLifeCycle> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bulletLifeCycleListenerList = list;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public IBridgeRegistry getBridgeRegistry() {
        return this.bridgeRegistry;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void setBridgeRegistry(IBridgeRegistry iBridgeRegistry) {
        this.bridgeRegistry = iBridgeRegistry;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public BulletContext getBulletContext() {
        return this.bulletContext;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void setBulletContext(BulletContext bulletContext) {
        this.bulletContext = bulletContext;
    }

    public final String getDefaultBid() {
        String bid;
        BulletContext bulletContext = getBulletContext();
        return (bulletContext == null || (bid = bulletContext.getBid()) == null) ? "default_bid" : bid;
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void config(BulletContext bulletContext, List<String> packageNames) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        setBulletContext(bulletContext);
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void updateGlobalProps() {
        String str;
        LinkedHashMap linkedHashMap;
        BulletLoadUriIdentifier uriIdentifier;
        String identifierUrl;
        AbsBulletMonitorCallback monitorCallback;
        if (!getGlobalProps().isEmpty()) {
            getGlobalProps().clear();
        }
        Map<String, Object> globalProps = getGlobalProps();
        globalProps.put("bullet_version", "9.0.0");
        globalProps.put("bulletVersion", "9.0.0");
        BulletContext bulletContext = getBulletContext();
        String str2 = "";
        if (bulletContext == null || (str = bulletContext.getSessionId()) == null) {
            str = "";
        }
        globalProps.put("containerID", str);
        BulletContext bulletContext2 = getBulletContext();
        if (bulletContext2 == null || (monitorCallback = bulletContext2.getMonitorCallback()) == null || (linkedHashMap = monitorCallback.generatePerfMapForGlobalProps()) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        globalProps.putAll(linkedHashMap);
        BulletContext bulletContext3 = getBulletContext();
        if (bulletContext3 != null && (uriIdentifier = bulletContext3.getUriIdentifier()) != null && (identifierUrl = uriIdentifier.getIdentifierUrl()) != null) {
            str2 = identifierUrl;
        }
        globalProps.put("resolvedUrl", str2);
        globalProps.put("isPreInstallApp", Integer.valueOf(AnnieXRuntime.INSTANCE.getApplicationDepend().isPreInstallApp() ? 1 : 0));
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void updateBridgeRegister(boolean useOthersOnConflict, KitType kitType) {
        BulletContext bulletContext;
        BulletSchemeContext schemeContext;
        List<String> packages;
        String bid;
        IBridgeService iBridgeService;
        BulletContext bulletContext2;
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        int i = WhenMappings.$EnumSwitchMapping$0[kitType.ordinal()];
        boolean z = false;
        if (i == 1 ? !((bulletContext = getBulletContext()) == null || !BulletContextKt.useXBride3(bulletContext)) : !(i != 2 || (bulletContext2 = getBulletContext()) == null || !BulletContextKt.useWebXBridge3(bulletContext2))) {
            z = true;
        }
        if (z) {
            IBridgeService iBridgeService2 = (IBridgeService) ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class);
            if (iBridgeService2 != null) {
                iBridgeService2.initialize();
                return;
            }
            return;
        }
        IBridgeService iBridgeService3 = (IBridgeService) ServiceCenter.INSTANCE.instance().get("default_bid", IBridgeService.class);
        ArrayList arrayList = new ArrayList();
        BulletContext bulletContext3 = getBulletContext();
        if (bulletContext3 != null && (bid = bulletContext3.getBid()) != null) {
            if (!(true ^ Intrinsics.areEqual(bid, "default_bid"))) {
                bid = null;
            }
            if (bid != null && (iBridgeService = (IBridgeService) ServiceCenter.INSTANCE.instance().get(bid, IBridgeService.class)) != null) {
                arrayList.add(iBridgeService);
            }
        }
        BulletContext bulletContext4 = getBulletContext();
        if (bulletContext4 != null && (schemeContext = bulletContext4.getSchemeContext()) != null && (packages = schemeContext.getPackages()) != null) {
            Iterator<T> it = packages.iterator();
            while (it.hasNext()) {
                IBridgeService iBridgeService4 = (IBridgeService) ServiceCenter.INSTANCE.instance().get((String) it.next(), IBridgeService.class);
                if (iBridgeService4 != null && !Intrinsics.areEqual(iBridgeService4.getBid(), "default_bid")) {
                    arrayList.add(iBridgeService4);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            createOrMergeBridgeRegistry((IBridgeService) it2.next(), useOthersOnConflict);
        }
        if (iBridgeService3 != null) {
            createOrMergeBridgeRegistry(iBridgeService3, useOthersOnConflict);
        }
        BulletContext bulletContext5 = getBulletContext();
        if (bulletContext5 == null) {
            return;
        }
        bulletContext5.setBridgeRegistry(getBridgeRegistry());
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void createOrMergeBridgeRegistry(final IBridgeService bridgeService, boolean useOthersOnConflict) {
        Intrinsics.checkNotNullParameter(bridgeService, "bridgeService");
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        IProcessor<BridgeHandleUnit> iProcessor = null;
        ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null);
        BulletContext bulletContext2 = getBulletContext();
        List<IBridgeScopeProviderFactory> createBridgeScopeProviders = bridgeService.createBridgeScopeProviders(providerFactory);
        Function1<ContextProviderFactory, List<? extends IGenericBridgeMethod>> function1 = new Function1<ContextProviderFactory, List<? extends IGenericBridgeMethod>>() { // from class: com.bytedance.ies.bullet.core.BaseEngineGlobalConfig$createOrMergeBridgeRegistry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final List<IGenericBridgeMethod> invoke(ContextProviderFactory contextProviderFactory) {
                Intrinsics.checkNotNullParameter(contextProviderFactory, "_contextProviderFactory");
                ArrayList arrayList = new ArrayList();
                IBridgeService iBridgeService = IBridgeService.this;
                arrayList.addAll(iBridgeService.createBridges(contextProviderFactory));
                try {
                    arrayList.addAll(iBridgeService.createIDLBridges(contextProviderFactory));
                } catch (Throwable unused) {
                }
                return arrayList;
            }
        };
        try {
            iProcessor = bridgeService.createBridgeRegistryTransformerProvider(providerFactory);
        } catch (YieldError unused) {
        }
        BridgeRegistry bridgeRegistry = new BridgeRegistry(bulletContext2, createBridgeScopeProviders, function1, providerFactory, iProcessor);
        if (getBridgeRegistry() == null) {
            setBridgeRegistry(bridgeRegistry);
            return;
        }
        IBridgeRegistry bridgeRegistry2 = getBridgeRegistry();
        if (bridgeRegistry2 != null) {
            bridgeRegistry2.merge(bridgeRegistry, useOthersOnConflict);
        }
    }

    @Override // com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void reset() {
        getGlobalProps().clear();
        getBulletLifeCycleListenerList().clear();
        IBridgeRegistry bridgeRegistry = getBridgeRegistry();
        if (bridgeRegistry != null) {
            bridgeRegistry.release();
        }
        setBridgeRegistry(null);
    }
}
