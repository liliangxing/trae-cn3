package com.bytedance.ruler.base.models;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StrategyExecuteResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b)\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0006\u0010=\u001a\u00020\u0005J\b\u0010>\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001a\u00105\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001a\u0010:\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001e¨\u0006?"}, d2 = {"Lcom/bytedance/ruler/base/models/StrategyExecuteResult;", "", "code", "", "msg", "", "paramsCost", "", "strategyNames", "", "performance", "Lcom/bytedance/ruler/base/models/Performance;", "params", "", "error", "", "ruleResults", "Ljava/util/ArrayList;", "Lcom/bytedance/ruler/base/models/RuleExecuteResult;", "Lkotlin/collections/ArrayList;", "fffRuleResults", "useHardCode", "", "(ILjava/lang/String;JLjava/util/List;Lcom/bytedance/ruler/base/models/Performance;Ljava/util/Map;Ljava/lang/Throwable;Ljava/util/ArrayList;Ljava/util/List;Z)V", "getCode", "()I", "enableSelectCache", "getEnableSelectCache", "()Z", "setEnableSelectCache", "(Z)V", "getError", "()Ljava/lang/Throwable;", "getFffRuleResults", "()Ljava/util/List;", "setFffRuleResults", "(Ljava/util/List;)V", "getMsg", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getParamsCost", "()J", "setParamsCost", "(J)V", "getPerformance", "()Lcom/bytedance/ruler/base/models/Performance;", "getRuleResults", "()Ljava/util/ArrayList;", "getStrategyNames", "setStrategyNames", "useFFF", "getUseFFF", "setUseFFF", "getUseHardCode", "setUseHardCode", "useRuleFFF", "getUseRuleFFF", "setUseRuleFFF", "toLogString", "toString", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StrategyExecuteResult {
    private final int code;
    private boolean enableSelectCache;
    private final Throwable error;
    private List<? extends Object> fffRuleResults;
    private final String msg;
    private Map<String, ? extends Object> params;
    private long paramsCost;
    private final Performance performance;
    private final ArrayList<RuleExecuteResult> ruleResults;
    private List<String> strategyNames;
    private boolean useFFF;
    private boolean useHardCode;
    private boolean useRuleFFF;

    public StrategyExecuteResult() {
        this(0, null, 0L, null, null, null, null, null, null, false, 1023, null);
    }

    public StrategyExecuteResult(int i, String str, long j, List<String> list, Performance performance, Map<String, ? extends Object> map, Throwable th, ArrayList<RuleExecuteResult> arrayList, List<? extends Object> list2, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "strategyNames");
        Intrinsics.checkParameterIsNotNull(performance, "performance");
        Intrinsics.checkParameterIsNotNull(arrayList, "ruleResults");
        Intrinsics.checkParameterIsNotNull(list2, "fffRuleResults");
        this.code = i;
        this.msg = str;
        this.paramsCost = j;
        this.strategyNames = list;
        this.performance = performance;
        this.params = map;
        this.error = th;
        this.ruleResults = arrayList;
        this.fffRuleResults = list2;
        this.useHardCode = z;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StrategyExecuteResult(int i, String str, long j, List list, Performance performance, Map map, Throwable th, ArrayList arrayList, List list2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r4, r6, r7, r8, r3, (i2 & 128) != 0 ? new ArrayList() : arrayList, (i2 & 256) != 0 ? new ArrayList() : list2, (i2 & 512) != 0 ? false : z);
        String str2;
        Map map2;
        int i3 = (i2 & 1) != 0 ? -1 : i;
        Throwable th2 = null;
        if ((i2 & 2) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        long j2 = (i2 & 4) != 0 ? 0L : j;
        ArrayList arrayList2 = (i2 & 8) != 0 ? new ArrayList() : list;
        Performance performance2 = (i2 & 16) != 0 ? new Performance(0L, false, 0L, 0L, 0L, 0L, 0L, false, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNKNOWN, null) : performance;
        if ((i2 & 32) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        if ((i2 & 64) != 0) {
        } else {
            th2 = th;
        }
    }

    public final String getMsg() {
        return this.msg;
    }

    public final long getParamsCost() {
        return this.paramsCost;
    }

    public final void setParamsCost(long j) {
        this.paramsCost = j;
    }

    public final List<String> getStrategyNames() {
        return this.strategyNames;
    }

    public final void setStrategyNames(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.strategyNames = list;
    }

    public final Performance getPerformance() {
        return this.performance;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final void setParams(Map<String, ? extends Object> map) {
        this.params = map;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final ArrayList<RuleExecuteResult> getRuleResults() {
        return this.ruleResults;
    }

    public final List<Object> getFffRuleResults() {
        return this.fffRuleResults;
    }

    public final void setFffRuleResults(List<? extends Object> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.fffRuleResults = list;
    }

    public final boolean getUseHardCode() {
        return this.useHardCode;
    }

    public final void setUseHardCode(boolean z) {
        this.useHardCode = z;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("[code = ").append(this.code).append(", msg = ").append(this.msg).append(", error = ").append(this.error).append(", strategyNames=").append(this.strategyNames).append(", result = ").append(this.ruleResults).append(", fffRuleResults=").append(this.fffRuleResults).append(" params = ");
        Map<String, ? extends Object> map = this.params;
        return append.append(map != null ? map.toString() : null).append(", performance = ").append(this.performance).append(", useFFF = ").append(this.useFFF).append(", useRuleFFF = ").append(this.useRuleFFF).append(" useHardCode = ").append(this.useHardCode).append(']').toString();
    }

    public final String toLogString() {
        String title;
        JSONArray jSONArray = new JSONArray();
        for (RuleExecuteResult ruleExecuteResult : this.ruleResults) {
            JSONObject jSONObject = new JSONObject();
            RuleModel ruleModel = ruleExecuteResult.getRuleModel();
            if (ruleModel == null || (title = ruleModel.getKey()) == null) {
                RuleModel ruleModel2 = ruleExecuteResult.getRuleModel();
                title = ruleModel2 != null ? ruleModel2.getTitle() : null;
            }
            if (title == null) {
                title = "unknown";
            }
            jSONObject.put(title, ruleExecuteResult.getResult());
            jSONArray.put(jSONObject);
        }
        List<? extends Object> list = this.fffRuleResults;
        if (!(list == null || list.isEmpty())) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fffRuleResults", this.fffRuleResults.toString());
            jSONArray.put(jSONObject2);
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "jsonArray.toString()");
        return jSONArray2;
    }

    public final boolean getEnableSelectCache() {
        return this.enableSelectCache;
    }

    public final void setEnableSelectCache(boolean z) {
        this.enableSelectCache = z;
    }

    public final boolean getUseFFF() {
        return this.useFFF;
    }

    public final void setUseFFF(boolean z) {
        this.useFFF = z;
    }

    public final boolean getUseRuleFFF() {
        return this.useRuleFFF;
    }

    public final void setUseRuleFFF(boolean z) {
        this.useRuleFFF = z;
    }
}
