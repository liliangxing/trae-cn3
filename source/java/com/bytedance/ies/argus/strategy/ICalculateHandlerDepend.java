package com.bytedance.ies.argus.strategy;

import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StrategyCalculateHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/argus/strategy/ICalculateHandlerDepend;", "", "getClientStrategyProvider", "", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "getContainerContext", "Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface ICalculateHandlerDepend {
    List<BaseStrategyProvider> getClientStrategyProvider();

    ContainerContext getContainerContext();
}
