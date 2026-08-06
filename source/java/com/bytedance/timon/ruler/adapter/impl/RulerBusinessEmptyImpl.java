package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.base.interfaces.Func;
import com.bytedance.ruler.base.interfaces.IParamGetter;
import com.bytedance.ruler.base.interfaces.Operator;
import com.bytedance.ruler.base.models.Performance;
import com.bytedance.ruler.base.models.StrategyExecuteResult;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RulerBusinessEmptyImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0014\u0010\u0010\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\rH\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/RulerBusinessEmptyImpl;", "Lcom/bytedance/timon/ruler/adapter/impl/IRulerBusinessService;", "()V", "addFunction", "", "func", "Lcom/bytedance/ruler/base/interfaces/Func;", "addOperator", OnekeyLoginConstants.CU_KEY_OPERATOR, "Lcom/bytedance/ruler/base/interfaces/Operator;", "allParamGetter", "", "", "Lcom/bytedance/ruler/base/interfaces/IParamGetter;", "businessName", "getStrategySignature", "registerParamGetter", "paramGetter", "validate", "Lcom/bytedance/ruler/base/models/StrategyExecuteResult;", TimonPipeline.KEY_SOURCE, "params", "ruler-adapter-api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RulerBusinessEmptyImpl implements IRulerBusinessService {
    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public void addFunction(Func func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public void addOperator(Operator operator) {
        Intrinsics.checkParameterIsNotNull(operator, OnekeyLoginConstants.CU_KEY_OPERATOR);
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public Map<String, IParamGetter<?>> allParamGetter() {
        return null;
    }

    @Override // com.bytedance.timonbase.ITMBusinessService
    public String businessName() {
        return "ruler";
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public String getStrategySignature() {
        return "";
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public void registerParamGetter(IParamGetter<?> paramGetter) {
        Intrinsics.checkParameterIsNotNull(paramGetter, "paramGetter");
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public StrategyExecuteResult validate(Map<String, ?> params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        return new StrategyExecuteResult(0, (String) null, 0L, (List) null, (Performance) null, (Map) null, (Throwable) null, (ArrayList) null, (List) null, false, 1023, (DefaultConstructorMarker) null);
    }

    @Override // com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService
    public StrategyExecuteResult validate(String source, Map<String, ?> params) {
        Intrinsics.checkParameterIsNotNull(source, TimonPipeline.KEY_SOURCE);
        Intrinsics.checkParameterIsNotNull(params, "params");
        return new StrategyExecuteResult(0, (String) null, 0L, (List) null, (Performance) null, (Map) null, (Throwable) null, (ArrayList) null, (List) null, false, 1023, (DefaultConstructorMarker) null);
    }
}
