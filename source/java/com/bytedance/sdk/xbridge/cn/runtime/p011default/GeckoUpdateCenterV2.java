package com.bytedance.sdk.xbridge.cn.runtime.p011default;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IGeckoUpdateListener;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHostGeckoDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/default/GeckoUpdateCenterV2;", "", "()V", "listenerMap", "", "", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "register", "", "containerId", "listener", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IGeckoUpdateListener;", "unRegister", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GeckoUpdateCenterV2 {
    public static final GeckoUpdateCenterV2 INSTANCE = new GeckoUpdateCenterV2();
    private static final Map<String, GeckoUpdateListener> listenerMap = new LinkedHashMap();

    private GeckoUpdateCenterV2() {
    }

    public final synchronized void register(String containerId, final IGeckoUpdateListener listener) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<String, GeckoUpdateListener> map = listenerMap;
        if (!map.containsKey(containerId)) {
            GeckoUpdateListener geckoUpdateListener = new GeckoUpdateListener() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.GeckoUpdateCenterV2$register$geckoUpdateListener$1
                public void onUpdateSuccess(UpdatePackage updatePackage, long version) {
                    Intrinsics.checkNotNullParameter(updatePackage, "updatePackage");
                    IGeckoUpdateListener iGeckoUpdateListener = IGeckoUpdateListener.this;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(Constant.KEY_CHANNEL, updatePackage.getChannel());
                    linkedHashMap.put("version", String.valueOf(version));
                    iGeckoUpdateListener.onGeckoUpdateSuccess(linkedHashMap);
                }
            };
            GeckoGlobalManager.registerGeckoUpdateListener(geckoUpdateListener);
            map.put(containerId, geckoUpdateListener);
        } else {
            GeckoGlobalManager.registerGeckoUpdateListener(map.get(containerId));
        }
    }

    public final synchronized void unRegister(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
        Map<String, GeckoUpdateListener> map = listenerMap;
        if (map.containsKey(containerId)) {
            GeckoGlobalManager.unregisterGeckoUpdateListener(map.get(containerId));
        }
    }
}
