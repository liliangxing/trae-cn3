package com.bytedance.sdk.xbridge.cn.info;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.info.AbsXGetSettingsMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingKeyEntry;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueEntry;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetSettingsMethod.kt */
@XBridgeMethod(name = "x.getSettings")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/info/XGetSettingsMethod;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetSettingsMethodIDL;", "()V", "canRunInBackground", "", "getContextDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetSettingsMethodIDL$XGetSettingsParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/info/AbsXGetSettingsMethodIDL$XGetSettingsResultModel;", "transformSettingValues", "", "", "", "settingValueEntries", "", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueEntry;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetSettingsMethod extends AbsXGetSettingsMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    private final IHostContextDepend getContextDependInstance() {
        return XBaseRuntime.INSTANCE.getHostContextDepend();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetSettingsMethodIDL.XGetSettingsParamModel params, CompletionBlock<AbsXGetSettingsMethodIDL.XGetSettingsResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<AbsXGetSettingsMethodIDL.XBridgeBeanXGetSettingsKeys> keys = params.getKeys();
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AbsXGetSettingsMethodIDL.XBridgeBeanXGetSettingsKeys xBridgeBeanXGetSettingsKeys : keys) {
            String key = xBridgeBeanXGetSettingsKeys.getKey();
            String biz = xBridgeBeanXGetSettingsKeys.getBiz();
            SettingValueType valueByType = SettingValueType.INSTANCE.getValueByType(xBridgeBeanXGetSettingsKeys.getType());
            if ((key.length() > 0) && valueByType != SettingValueType.UNSUPPORTED) {
                SettingKeyEntry settingKeyEntry = new SettingKeyEntry(key, valueByType);
                if (biz != null) {
                    settingKeyEntry.setBiz(biz);
                }
                arrayList.add(settingKeyEntry);
                linkedHashSet.add(key);
            }
        }
        if (arrayList.isEmpty()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "empty key or unsupported key type in params", null, 4, null);
            return;
        }
        if (linkedHashSet.size() < arrayList.size()) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "duplicate keys in params", null, 4, null);
            return;
        }
        IHostContextDepend contextDependInstance = getContextDependInstance();
        List<SettingValueEntry> settings = contextDependInstance != null ? contextDependInstance.getSettings(arrayList) : null;
        if (settings == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "getSettings not implemented in host", null, 4, null);
            return;
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetSettingsMethodIDL.XGetSettingsResultModel.class));
        ((AbsXGetSettingsMethodIDL.XGetSettingsResultModel) createXModel).setSettings(transformSettingValues(settings));
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }

    private final Map<String, Object> transformSettingValues(List<SettingValueEntry> settingValueEntries) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SettingValueEntry settingValueEntry : settingValueEntries) {
            linkedHashMap.put(settingValueEntry.getKey(), settingValueEntry.getValue());
        }
        return linkedHashMap;
    }
}
