package com.bytedance.ies.argus.strategy.provider.ttm;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyProvider;
import com.lynx.tasm.LynxTemplateRender;
import kotlin.Metadata;

/* compiled from: ITTMStrategyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "", "getStrategyProvider", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyProvider;", "hasInit", "", "parseTTMRuleByteCode", "", "code", "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "codeString", "", LynxTemplateRender.RENDER_PHASE_SETUP, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface ITTMStrategyManager {
    BaseStrategyProvider getStrategyProvider();

    boolean hasInit();

    long parseTTMRuleByteCode(byte[] code, long nativeExtendFuncAddress);

    long processTTMRuleByteCodeLong(String codeString, long nativeExtendFuncAddress);

    boolean setup();
}
