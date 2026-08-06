package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.base.interfaces.Func;
import com.bytedance.ruler.base.interfaces.IParamGetter;
import com.bytedance.ruler.base.interfaces.Operator;
import com.bytedance.ruler.base.models.StrategyExecuteResult;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.timonbase.ITMBusinessService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IRulerBusinessService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0018\u00010\nH&J\b\u0010\r\u001a\u00020\u000bH&J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\fH&J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\nH&J\u001a\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\nH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/IRulerBusinessService;", "Lcom/bytedance/timonbase/ITMBusinessService;", "addFunction", "", "func", "Lcom/bytedance/ruler/base/interfaces/Func;", "addOperator", OnekeyLoginConstants.CU_KEY_OPERATOR, "Lcom/bytedance/ruler/base/interfaces/Operator;", "allParamGetter", "", "", "Lcom/bytedance/ruler/base/interfaces/IParamGetter;", "getStrategySignature", "registerParamGetter", "paramGetter", "validate", "Lcom/bytedance/ruler/base/models/StrategyExecuteResult;", TimonPipeline.KEY_SOURCE, "params", "ruler-adapter-api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IRulerBusinessService extends ITMBusinessService {
    void addFunction(Func func);

    void addOperator(Operator operator);

    Map<String, IParamGetter<?>> allParamGetter();

    String getStrategySignature();

    void registerParamGetter(IParamGetter<?> paramGetter);

    StrategyExecuteResult validate(String source, Map<String, ?> params);

    StrategyExecuteResult validate(Map<String, ?> params);
}
