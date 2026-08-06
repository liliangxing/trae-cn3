package com.bytedance.android.anniex.ability;

import com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider;
import com.bytedance.ies.bullet.base.bridge.IDLBridgeTransformer;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.xbridge.event.idl_bridge.XPublishEventMethod;
import com.bytedance.ies.xbridge.event.idl_bridge.XSubscribeEventMethod;
import com.bytedance.ies.xbridge.event.idl_bridge.XUnsubscribeEventMethod;
import com.bytedance.sdk.xbridge.cn.account.XGetUserInfoMethod;
import com.bytedance.sdk.xbridge.cn.info.XGetAppInfoMethod;
import com.bytedance.sdk.xbridge.cn.info.XGetSettingsMethod;
import com.bytedance.sdk.xbridge.cn.log.XReportALogMethod;
import com.bytedance.sdk.xbridge.cn.log.XReportAppLogMethod;
import com.bytedance.sdk.xbridge.cn.log.XReportMonitorLogMethod;
import com.bytedance.sdk.xbridge.cn.network.XGetAPIParamsMethod;
import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.storage.bridge.XGetStorageInfoMethod;
import com.bytedance.sdk.xbridge.cn.storage.bridge.XGetStorageItemMethod;
import com.bytedance.sdk.xbridge.cn.storage.bridge.XRemoveStorageItemMethod;
import com.bytedance.sdk.xbridge.cn.storage.bridge.XSetStorageItemMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultAnnieXPIAMethodProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/ability/DefaultAnnieXPIAMethodProvider;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/android/anniex/ability/service/IAnnieXPiaMethodProvider;", "()V", "providerMethod", "", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "bid", "providerPreHandleMethod", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DefaultAnnieXPIAMethodProvider extends BaseBulletService implements IAnnieXPiaMethodProvider {
    @Override // com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider
    public Map<String, IDLXBridgeMethod> providerMethod(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("x.getAppInfo", new XGetAppInfoMethod());
        linkedHashMap.put("x.getAPIParams", new XGetAPIParamsMethod());
        linkedHashMap.put("x.getUserInfo", new XGetUserInfoMethod());
        linkedHashMap.put("x.getSettings", new XGetSettingsMethod());
        linkedHashMap.put("x.setStorageItem", new XSetStorageItemMethod());
        linkedHashMap.put("x.getStorageItem", new XGetStorageItemMethod());
        linkedHashMap.put("x.getStorageInfo", new XGetStorageInfoMethod());
        linkedHashMap.put("x.removeStorageItem", new XRemoveStorageItemMethod());
        linkedHashMap.put("x.reportAppLog", new XReportAppLogMethod());
        linkedHashMap.put("x.reportMonitorLog", new XReportMonitorLogMethod());
        linkedHashMap.put("x.reportALog", new XReportALogMethod());
        linkedHashMap.put("x.request", new XRequestMethod());
        linkedHashMap.put("x.subscribeEvent", IDLBridgeTransformer.INSTANCE.xbridge2ToXBridge3(new XSubscribeEventMethod()));
        linkedHashMap.put("x.unsubscribeEvent", IDLBridgeTransformer.INSTANCE.xbridge2ToXBridge3(new XUnsubscribeEventMethod()));
        linkedHashMap.put("x.publishEvent", IDLBridgeTransformer.INSTANCE.xbridge2ToXBridge3(new XPublishEventMethod()));
        return linkedHashMap;
    }

    @Override // com.bytedance.android.anniex.ability.service.IAnnieXPiaMethodProvider
    public Map<String, IDLXBridgeMethod> providerPreHandleMethod(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("x.getAppInfo", new XGetAppInfoMethod());
        linkedHashMap.put("x.getAPIParams", new XGetAPIParamsMethod());
        linkedHashMap.put("x.getUserInfo", new XGetUserInfoMethod());
        return linkedHashMap;
    }
}
