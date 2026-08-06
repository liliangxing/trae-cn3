package com.bytedance.pitaya.api.mutilinstance;

import com.bytedance.pitaya.api.CoreProvider;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegateCoreProvider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/mutilinstance/DelegateCoreProvider;", "Lcom/bytedance/pitaya/api/CoreProvider;", "()V", "cores", "", "", "Lcom/bytedance/pitaya/api/IPitayaCore;", "value", "realProvider", "getRealProvider", "()Lcom/bytedance/pitaya/api/CoreProvider;", "setRealProvider", "(Lcom/bytedance/pitaya/api/CoreProvider;)V", "getCore", CommonConstants.KEY_AID, "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelegateCoreProvider implements CoreProvider {
    public static final DelegateCoreProvider INSTANCE = new DelegateCoreProvider();
    private static final Map<String, IPitayaCore> cores = new LinkedHashMap();
    private static CoreProvider realProvider;

    private DelegateCoreProvider() {
    }

    public final CoreProvider getRealProvider() {
        return realProvider;
    }

    public final void setRealProvider(CoreProvider coreProvider) {
        Map<String, IPitayaCore> map = cores;
        synchronized (map) {
            if (coreProvider != null) {
                if (realProvider == null) {
                    realProvider = coreProvider;
                    for (Map.Entry<String, IPitayaCore> entry : map.entrySet()) {
                        if (entry.getValue() instanceof DelegateCore) {
                            IPitayaCore value = entry.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.pitaya.api.mutilinstance.DelegateCore");
                            DelegateCore delegateCore = (DelegateCore) value;
                            CoreProvider coreProvider2 = realProvider;
                            delegateCore.setRealCore$pitayacore_release(coreProvider2 != null ? coreProvider2.getCore(entry.getKey()) : null);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.bytedance.pitaya.api.CoreProvider
    public IPitayaCore getCore(String aid) {
        DelegateCore delegateCore;
        Intrinsics.checkNotNullParameter(aid, CommonConstants.KEY_AID);
        Map<String, IPitayaCore> map = cores;
        synchronized (map) {
            delegateCore = map.get(aid);
            if (delegateCore == null) {
                CoreProvider coreProvider = realProvider;
                if (coreProvider == null || (delegateCore = coreProvider.getCore(aid)) == null) {
                    delegateCore = new DelegateCore(aid);
                }
                map.put(aid, delegateCore);
            }
        }
        return delegateCore;
    }
}
