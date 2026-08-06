package com.bytedance.ruler.base.models;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RuleExecuteResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u00060"}, d2 = {"Lcom/bytedance/ruler/base/models/Performance;", "", "paramsCost", "", "strategySelectFromCache", "", "selectSceneCost", "selectStrategyCost", "buildRulescost", "execRulesCost", "blackListCost", "strategySelectFromTrie", "(JZJJJJJZ)V", "getBlackListCost", "()J", "setBlackListCost", "(J)V", "getBuildRulescost", "setBuildRulescost", "getExecRulesCost", "setExecRulesCost", "getParamsCost", "setParamsCost", "getSelectSceneCost", "setSelectSceneCost", "getSelectStrategyCost", "setSelectStrategyCost", "getStrategySelectFromCache", "()Z", "setStrategySelectFromCache", "(Z)V", "getStrategySelectFromTrie", "setStrategySelectFromTrie", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class Performance {
    private long blackListCost;
    private long buildRulescost;
    private long execRulesCost;
    private long paramsCost;
    private long selectSceneCost;
    private long selectStrategyCost;
    private boolean strategySelectFromCache;
    private boolean strategySelectFromTrie;

    public Performance() {
        this(0L, false, 0L, 0L, 0L, 0L, 0L, false, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getParamsCost() {
        return this.paramsCost;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getStrategySelectFromCache() {
        return this.strategySelectFromCache;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSelectSceneCost() {
        return this.selectSceneCost;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSelectStrategyCost() {
        return this.selectStrategyCost;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBuildRulescost() {
        return this.buildRulescost;
    }

    /* renamed from: component6, reason: from getter */
    public final long getExecRulesCost() {
        return this.execRulesCost;
    }

    /* renamed from: component7, reason: from getter */
    public final long getBlackListCost() {
        return this.blackListCost;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getStrategySelectFromTrie() {
        return this.strategySelectFromTrie;
    }

    public final Performance copy(long paramsCost, boolean strategySelectFromCache, long selectSceneCost, long selectStrategyCost, long buildRulescost, long execRulesCost, long blackListCost, boolean strategySelectFromTrie) {
        return new Performance(paramsCost, strategySelectFromCache, selectSceneCost, selectStrategyCost, buildRulescost, execRulesCost, blackListCost, strategySelectFromTrie);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Performance)) {
            return false;
        }
        Performance performance = (Performance) other;
        return this.paramsCost == performance.paramsCost && this.strategySelectFromCache == performance.strategySelectFromCache && this.selectSceneCost == performance.selectSceneCost && this.selectStrategyCost == performance.selectStrategyCost && this.buildRulescost == performance.buildRulescost && this.execRulesCost == performance.execRulesCost && this.blackListCost == performance.blackListCost && this.strategySelectFromTrie == performance.strategySelectFromTrie;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = Long.hashCode(this.paramsCost) * 31;
        boolean z = this.strategySelectFromCache;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((((((((((hashCode + i) * 31) + Long.hashCode(this.selectSceneCost)) * 31) + Long.hashCode(this.selectStrategyCost)) * 31) + Long.hashCode(this.buildRulescost)) * 31) + Long.hashCode(this.execRulesCost)) * 31) + Long.hashCode(this.blackListCost)) * 31;
        boolean z2 = this.strategySelectFromTrie;
        return hashCode2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "Performance(paramsCost=" + this.paramsCost + ", strategySelectFromCache=" + this.strategySelectFromCache + ", selectSceneCost=" + this.selectSceneCost + ", selectStrategyCost=" + this.selectStrategyCost + ", buildRulescost=" + this.buildRulescost + ", execRulesCost=" + this.execRulesCost + ", blackListCost=" + this.blackListCost + ", strategySelectFromTrie=" + this.strategySelectFromTrie + ")";
    }

    public Performance(long j, boolean z, long j2, long j3, long j4, long j5, long j6, boolean z2) {
        this.paramsCost = j;
        this.strategySelectFromCache = z;
        this.selectSceneCost = j2;
        this.selectStrategyCost = j3;
        this.buildRulescost = j4;
        this.execRulesCost = j5;
        this.blackListCost = j6;
        this.strategySelectFromTrie = z2;
    }

    public final long getParamsCost() {
        return this.paramsCost;
    }

    public final void setParamsCost(long j) {
        this.paramsCost = j;
    }

    public final boolean getStrategySelectFromCache() {
        return this.strategySelectFromCache;
    }

    public final void setStrategySelectFromCache(boolean z) {
        this.strategySelectFromCache = z;
    }

    public final long getSelectSceneCost() {
        return this.selectSceneCost;
    }

    public final void setSelectSceneCost(long j) {
        this.selectSceneCost = j;
    }

    public final long getSelectStrategyCost() {
        return this.selectStrategyCost;
    }

    public final void setSelectStrategyCost(long j) {
        this.selectStrategyCost = j;
    }

    public final long getBuildRulescost() {
        return this.buildRulescost;
    }

    public final void setBuildRulescost(long j) {
        this.buildRulescost = j;
    }

    public final long getExecRulesCost() {
        return this.execRulesCost;
    }

    public final void setExecRulesCost(long j) {
        this.execRulesCost = j;
    }

    public final long getBlackListCost() {
        return this.blackListCost;
    }

    public final void setBlackListCost(long j) {
        this.blackListCost = j;
    }

    public /* synthetic */ Performance(long j, boolean z, long j2, long j3, long j4, long j5, long j6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 0L : j3, (i & 16) != 0 ? 0L : j4, (i & 32) != 0 ? 0L : j5, (i & 64) == 0 ? j6 : 0L, (i & 128) == 0 ? z2 : false);
    }

    public final boolean getStrategySelectFromTrie() {
        return this.strategySelectFromTrie;
    }

    public final void setStrategySelectFromTrie(boolean z) {
        this.strategySelectFromTrie = z;
    }
}
