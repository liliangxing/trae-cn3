package com.bytedance.ies.argus.repository;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.repository.ContainerConfigItem;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: ContainerConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/repository/ContainerConfigProvider;", "Lcom/bytedance/ies/argus/repository/BaseConfigProvider;", "Lcom/bytedance/ies/argus/repository/ContainerConfigModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", Scraps.STORAGE, "get", "getContainerAspectRule", "Lcom/bytedance/ies/argus/repository/ContainerConfigItem;", "cId", "", "innerParse", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerConfigProvider extends BaseConfigProvider<ContainerConfigModel> {
    private ContainerConfigModel storage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContainerConfigProvider(CoroutineScope coroutineScope) {
        super(coroutineScope);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
    }

    public final ContainerConfigItem getContainerAspectRule(String cId) {
        Map<String, ContainerConfigItem> conf;
        Intrinsics.checkNotNullParameter(cId, "cId");
        ContainerConfigModel containerConfigModel = this.storage;
        if (containerConfigModel == null || (conf = containerConfigModel.getConf()) == null) {
            return null;
        }
        return conf.get(cId);
    }

    /* renamed from: get, reason: from getter */
    public final ContainerConfigModel getStorage() {
        return this.storage;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.argus.repository.BaseConfigProvider
    public ContainerConfigModel innerParse(JSONObject data, ConfigInfo info) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(info, "info");
        ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject optJSONObject = data.optJSONObject("conf");
        if (optJSONObject != null) {
            ContainerConfigItem.Builder builder = new ContainerConfigItem.Builder(env, null);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("host");
            ContainerConfigItem build = builder.build("host", optJSONObject2, null);
            if (build != null) {
                linkedHashMap.put("host", build);
            }
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "cIdKeys");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!Intrinsics.areEqual(next, "host")) {
                    Intrinsics.checkNotNullExpressionValue(next, "cId");
                    ContainerConfigItem build2 = builder.build(next, optJSONObject.optJSONObject(next), optJSONObject2);
                    if (build2 != null) {
                        linkedHashMap.put(next, build2);
                    }
                }
            }
            ContainerConfigModel containerConfigModel = new ContainerConfigModel(MapsKt.toMap(linkedHashMap), info.getFetchType(), info.getGeckoVersion());
            containerConfigModel.setConfInfo(info);
            this.storage = containerConfigModel;
        }
        return this.storage;
    }
}
