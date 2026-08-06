package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.core.kit.bridge.IBridgeRegistry;
import com.bytedance.ies.bullet.core.kit.service.IBridgeService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH&J\u001a\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\u001dH&J\u001a\u0010&\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020(H&J\b\u0010)\u001a\u00020\u001dH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/ies/bullet/core/IEngineGlobalConfig;", "", "bridgeRegistry", "Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "getBridgeRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;", "setBridgeRegistry", "(Lcom/bytedance/ies/bullet/core/kit/bridge/IBridgeRegistry;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "bulletLifeCycleListenerList", "", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "getBulletLifeCycleListenerList", "()Ljava/util/List;", "setBulletLifeCycleListenerList", "(Ljava/util/List;)V", "globalProps", "", "", "getGlobalProps", "()Ljava/util/Map;", "setGlobalProps", "(Ljava/util/Map;)V", "config", "", "packageNames", "", "createOrMergeBridgeRegistry", "bridgeService", "Lcom/bytedance/ies/bullet/core/kit/service/IBridgeService;", "useOthersOnConflict", "", "reset", "updateBridgeRegister", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "updateGlobalProps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IEngineGlobalConfig {
    void config(BulletContext bulletContext, List<String> packageNames);

    void createOrMergeBridgeRegistry(IBridgeService bridgeService, boolean useOthersOnConflict);

    IBridgeRegistry getBridgeRegistry();

    BulletContext getBulletContext();

    List<IBulletLoadLifeCycle> getBulletLifeCycleListenerList();

    Map<String, Object> getGlobalProps();

    void reset();

    void setBridgeRegistry(IBridgeRegistry iBridgeRegistry);

    void setBulletContext(BulletContext bulletContext);

    void setBulletLifeCycleListenerList(List<IBulletLoadLifeCycle> list);

    void setGlobalProps(Map<String, Object> map);

    void updateBridgeRegister(boolean useOthersOnConflict, KitType kitType);

    void updateGlobalProps();

    /* compiled from: BulletContext.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateBridgeRegister$default(IEngineGlobalConfig iEngineGlobalConfig, boolean z, KitType kitType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBridgeRegister");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iEngineGlobalConfig.updateBridgeRegister(z, kitType);
        }

        public static /* synthetic */ void createOrMergeBridgeRegistry$default(IEngineGlobalConfig iEngineGlobalConfig, IBridgeService iBridgeService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createOrMergeBridgeRegistry");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iEngineGlobalConfig.createOrMergeBridgeRegistry(iBridgeService, z);
        }
    }
}
