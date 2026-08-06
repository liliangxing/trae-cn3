package com.bytedance.android.anniex.pitaya;

import com.bytedance.android.anniex.pitaya.StrategyManager;
import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PitayaPackageInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jt\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\b\u0010+\u001a\u00020\u0005H\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/PitayaPackageInfo;", "", StrategyConstants.STRATEGY, "Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;", "name", "", "version", "deployment", "taskType", "", "from", "buildTime", StrategyConstants.MODELS, "", "Lcom/bytedance/android/anniex/pitaya/PitayaModelInfo;", "(Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getBuildTime", "()Ljava/lang/String;", "getDeployment", "getFrom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModels", "()Ljava/util/List;", "getName", "getStrategy", "()Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;", "getTaskType", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/android/anniex/pitaya/PitayaPackageInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PitayaPackageInfo {
    private final String buildTime;
    private final String deployment;
    private final Integer from;
    private final List<PitayaModelInfo> models;
    private final String name;
    private final StrategyManager.Strategy strategy;
    private final Integer taskType;
    private final String version;

    /* renamed from: component1, reason: from getter */
    public final StrategyManager.Strategy getStrategy() {
        return this.strategy;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeployment() {
        return this.deployment;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTaskType() {
        return this.taskType;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getFrom() {
        return this.from;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBuildTime() {
        return this.buildTime;
    }

    public final List<PitayaModelInfo> component8() {
        return this.models;
    }

    public final PitayaPackageInfo copy(StrategyManager.Strategy strategy, String name, String version, String deployment, Integer taskType, Integer from, String buildTime, List<PitayaModelInfo> models) {
        return new PitayaPackageInfo(strategy, name, version, deployment, taskType, from, buildTime, models);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PitayaPackageInfo)) {
            return false;
        }
        PitayaPackageInfo pitayaPackageInfo = (PitayaPackageInfo) other;
        return Intrinsics.areEqual(this.strategy, pitayaPackageInfo.strategy) && Intrinsics.areEqual(this.name, pitayaPackageInfo.name) && Intrinsics.areEqual(this.version, pitayaPackageInfo.version) && Intrinsics.areEqual(this.deployment, pitayaPackageInfo.deployment) && Intrinsics.areEqual(this.taskType, pitayaPackageInfo.taskType) && Intrinsics.areEqual(this.from, pitayaPackageInfo.from) && Intrinsics.areEqual(this.buildTime, pitayaPackageInfo.buildTime) && Intrinsics.areEqual(this.models, pitayaPackageInfo.models);
    }

    public int hashCode() {
        StrategyManager.Strategy strategy = this.strategy;
        int hashCode = (strategy == null ? 0 : strategy.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deployment;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.taskType;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.from;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.buildTime;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<PitayaModelInfo> list = this.models;
        return hashCode7 + (list != null ? list.hashCode() : 0);
    }

    public PitayaPackageInfo(StrategyManager.Strategy strategy, String str, String str2, String str3, Integer num, Integer num2, String str4, List<PitayaModelInfo> list) {
        this.strategy = strategy;
        this.name = str;
        this.version = str2;
        this.deployment = str3;
        this.taskType = num;
        this.from = num2;
        this.buildTime = str4;
        this.models = list;
    }

    public final StrategyManager.Strategy getStrategy() {
        return this.strategy;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getDeployment() {
        return this.deployment;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final Integer getFrom() {
        return this.from;
    }

    public final String getBuildTime() {
        return this.buildTime;
    }

    public final List<PitayaModelInfo> getModels() {
        return this.models;
    }

    public String toString() {
        return "PitayaPackageInfo(strategy=" + this.strategy + ", name=" + this.name + ')';
    }
}
