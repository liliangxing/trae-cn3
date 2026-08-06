package com.bytedance.ies.bullet.lynx.impl;

import com.bytedance.ies.bullet.core.BaseEngineGlobalConfig;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.IEngineGlobalConfig;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxEngineGlobalConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/impl/LynxEngineGlobalConfig;", "Lcom/bytedance/ies/bullet/core/BaseEngineGlobalConfig;", "()V", "behaviors", "", "", "getBehaviors", "()Ljava/util/List;", "defaultGlobalLynxConfigService", "Lcom/bytedance/ies/bullet/kit/lynx/service/ILynxGlobalConfigService;", "getDefaultGlobalLynxConfigService", "()Lcom/bytedance/ies/bullet/kit/lynx/service/ILynxGlobalConfigService;", "setDefaultGlobalLynxConfigService", "(Lcom/bytedance/ies/bullet/kit/lynx/service/ILynxGlobalConfigService;)V", "lynxClientDelegates", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClientDelegates", "lynxGlobalConfigServiceList", "getLynxGlobalConfigServiceList", "modules", "getModules", "config", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "packageNames", "", "", "reset", "updateGlobalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxEngineGlobalConfig extends BaseEngineGlobalConfig {
    private ILynxGlobalConfigService defaultGlobalLynxConfigService;
    private final List<ILynxGlobalConfigService> lynxGlobalConfigServiceList = new ArrayList();
    private final List<Object> behaviors = new ArrayList();
    private final List<Object> modules = new ArrayList();
    private final List<ILynxClientDelegate> lynxClientDelegates = new ArrayList();

    public final ILynxGlobalConfigService getDefaultGlobalLynxConfigService() {
        return this.defaultGlobalLynxConfigService;
    }

    public final void setDefaultGlobalLynxConfigService(ILynxGlobalConfigService iLynxGlobalConfigService) {
        this.defaultGlobalLynxConfigService = iLynxGlobalConfigService;
    }

    public final List<ILynxGlobalConfigService> getLynxGlobalConfigServiceList() {
        return this.lynxGlobalConfigServiceList;
    }

    public final List<Object> getBehaviors() {
        return this.behaviors;
    }

    public final List<Object> getModules() {
        return this.modules;
    }

    public final List<ILynxClientDelegate> getLynxClientDelegates() {
        return this.lynxClientDelegates;
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void reset() {
        super.reset();
        getBulletLifeCycleListenerList().clear();
        this.defaultGlobalLynxConfigService = null;
        this.lynxGlobalConfigServiceList.clear();
        this.behaviors.clear();
        this.modules.clear();
        this.lynxClientDelegates.clear();
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void config(BulletContext bulletContext, List<String> packageNames) {
        ILynxClientDelegate lynxClient;
        ILynxGlobalConfigService iLynxGlobalConfigService;
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        super.config(bulletContext, packageNames);
        ContextProviderFactory providerFactory = ContextProviderManager.INSTANCE.getProviderFactory(bulletContext.getSessionId());
        Iterator<T> it = packageNames.iterator();
        while (it.hasNext()) {
            ILynxGlobalConfigService iLynxGlobalConfigService2 = (ILynxGlobalConfigService) ServiceCenter.INSTANCE.instance().get((String) it.next(), ILynxGlobalConfigService.class);
            if (iLynxGlobalConfigService2 != null && !Intrinsics.areEqual(iLynxGlobalConfigService2.getBid(), getDefaultBid())) {
                this.lynxGlobalConfigServiceList.add(iLynxGlobalConfigService2);
            }
        }
        this.defaultGlobalLynxConfigService = (ILynxGlobalConfigService) ServiceCenter.INSTANCE.instance().get(getDefaultBid(), ILynxGlobalConfigService.class);
        if (!Intrinsics.areEqual("default_bid", getDefaultBid()) && (iLynxGlobalConfigService = (ILynxGlobalConfigService) ServiceCenter.INSTANCE.instance().get("default_bid", ILynxGlobalConfigService.class)) != null) {
            List<?> createBehaviors = iLynxGlobalConfigService.createBehaviors(providerFactory);
            if (createBehaviors != null) {
                this.behaviors.addAll(createBehaviors);
            }
            ILynxClientDelegate createGlobalClientDelegate = iLynxGlobalConfigService.createGlobalClientDelegate(providerFactory);
            if (createGlobalClientDelegate != null) {
                this.lynxClientDelegates.add(createGlobalClientDelegate);
            }
        }
        for (ILynxGlobalConfigService iLynxGlobalConfigService3 : this.lynxGlobalConfigServiceList) {
            ILynxClientDelegate createGlobalClientDelegate2 = iLynxGlobalConfigService3.createGlobalClientDelegate(providerFactory);
            if (createGlobalClientDelegate2 != null) {
                this.lynxClientDelegates.add(createGlobalClientDelegate2);
            }
            List<?> createBehaviors2 = iLynxGlobalConfigService3.createBehaviors(providerFactory);
            if (createBehaviors2 != null) {
                this.behaviors.addAll(createBehaviors2);
            }
            List<?> createLynxModule = iLynxGlobalConfigService3.createLynxModule(providerFactory);
            if (createLynxModule != null) {
                this.modules.addAll(createLynxModule);
            }
            IBulletLoadLifeCycle createKitViewLifecycleDelegate = iLynxGlobalConfigService3.createKitViewLifecycleDelegate(providerFactory);
            if (createKitViewLifecycleDelegate != null) {
                getBulletLifeCycleListenerList().add(createKitViewLifecycleDelegate);
            }
        }
        ILynxGlobalConfigService iLynxGlobalConfigService4 = this.defaultGlobalLynxConfigService;
        if (iLynxGlobalConfigService4 != null) {
            ILynxClientDelegate createGlobalClientDelegate3 = iLynxGlobalConfigService4.createGlobalClientDelegate(providerFactory);
            if (createGlobalClientDelegate3 != null) {
                this.lynxClientDelegates.add(createGlobalClientDelegate3);
            }
            List<?> createBehaviors3 = iLynxGlobalConfigService4.createBehaviors(providerFactory);
            if (createBehaviors3 != null) {
                this.behaviors.addAll(createBehaviors3);
            }
            List<?> createLynxModule2 = iLynxGlobalConfigService4.createLynxModule(providerFactory);
            if (createLynxModule2 != null) {
                this.modules.addAll(createLynxModule2);
            }
            IBulletLoadLifeCycle createKitViewLifecycleDelegate2 = iLynxGlobalConfigService4.createKitViewLifecycleDelegate(providerFactory);
            if (createKitViewLifecycleDelegate2 != null) {
                getBulletLifeCycleListenerList().add(createKitViewLifecycleDelegate2);
            }
        }
        Iterator<T> it2 = getBulletLifeCycleListenerList().iterator();
        while (it2.hasNext()) {
            ILynxClientDelegate lynxClient2 = ((IBulletLoadLifeCycle) it2.next()).getLynxClient();
            if (lynxClient2 != null) {
                this.lynxClientDelegates.add(lynxClient2);
            }
        }
        IBulletLoadLifeCycle bulletLoadLifeCycleListener = bulletContext.getBulletLoadLifeCycleListener();
        if (bulletLoadLifeCycleListener != null && (lynxClient = bulletLoadLifeCycleListener.getLynxClient()) != null) {
            this.lynxClientDelegates.add(lynxClient);
        }
        ILynxClientDelegate iLynxClientDelegate = (ILynxClientDelegate) providerFactory.provideInstance(ILynxClientDelegate.class);
        if (iLynxClientDelegate != null) {
            this.lynxClientDelegates.add(iLynxClientDelegate);
        }
        IEngineGlobalConfig.DefaultImpls.updateBridgeRegister$default(this, false, KitType.LYNX, 1, null);
        bulletContext.getBulletGlobalLifeCycleListenerList().clear();
        bulletContext.setBulletGlobalLifeCycleListenerList(getBulletLifeCycleListenerList());
    }

    @Override // com.bytedance.ies.bullet.core.BaseEngineGlobalConfig, com.bytedance.ies.bullet.core.IEngineGlobalConfig
    public void updateGlobalProps() {
        Map<String, Object> constants;
        super.updateGlobalProps();
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        ContextProviderFactory providerFactory = contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null);
        Map<String, Object> globalProps = getGlobalProps();
        Iterator<T> it = this.lynxGlobalConfigServiceList.iterator();
        while (it.hasNext()) {
            Map<String, Object> constants2 = ((ILynxGlobalConfigService) it.next()).getConstants(providerFactory);
            if (constants2 != null) {
                globalProps.putAll(constants2);
            }
        }
        ILynxGlobalConfigService iLynxGlobalConfigService = this.defaultGlobalLynxConfigService;
        if (iLynxGlobalConfigService == null || (constants = iLynxGlobalConfigService.getConstants(providerFactory)) == null) {
            return;
        }
        globalProps.putAll(constants);
    }
}
