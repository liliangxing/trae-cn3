package com.bytedance.ies.argus.repository;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/argus/repository/RecoveryConfigModel;", "Lcom/bytedance/ies/argus/repository/BaseRemoteConfig;", "forceCloseAll", "", "aspect", "Lorg/json/JSONObject;", StrategyConstants.STRATEGY, CloudControlInf.PLUGIN, "(ZLorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getAspect", "()Lorg/json/JSONObject;", "getForceCloseAll", "()Z", "getPlugin", "getStrategy", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RecoveryConfigModel extends BaseRemoteConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JSONObject aspect;
    private final boolean forceCloseAll;
    private final JSONObject plugin;
    private final JSONObject strategy;

    public RecoveryConfigModel() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ RecoveryConfigModel copy$default(RecoveryConfigModel recoveryConfigModel, boolean z, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = recoveryConfigModel.forceCloseAll;
        }
        if ((i & 2) != 0) {
            jSONObject = recoveryConfigModel.aspect;
        }
        if ((i & 4) != 0) {
            jSONObject2 = recoveryConfigModel.strategy;
        }
        if ((i & 8) != 0) {
            jSONObject3 = recoveryConfigModel.plugin;
        }
        return recoveryConfigModel.copy(z, jSONObject, jSONObject2, jSONObject3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getForceCloseAll() {
        return this.forceCloseAll;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getAspect() {
        return this.aspect;
    }

    /* renamed from: component3, reason: from getter */
    public final JSONObject getStrategy() {
        return this.strategy;
    }

    /* renamed from: component4, reason: from getter */
    public final JSONObject getPlugin() {
        return this.plugin;
    }

    public final RecoveryConfigModel copy(boolean forceCloseAll, JSONObject aspect, JSONObject strategy, JSONObject plugin) {
        return new RecoveryConfigModel(forceCloseAll, aspect, strategy, plugin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecoveryConfigModel)) {
            return false;
        }
        RecoveryConfigModel recoveryConfigModel = (RecoveryConfigModel) other;
        return this.forceCloseAll == recoveryConfigModel.forceCloseAll && Intrinsics.areEqual(this.aspect, recoveryConfigModel.aspect) && Intrinsics.areEqual(this.strategy, recoveryConfigModel.strategy) && Intrinsics.areEqual(this.plugin, recoveryConfigModel.plugin);
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.forceCloseAll) * 31;
        JSONObject jSONObject = this.aspect;
        int hashCode2 = (hashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        JSONObject jSONObject2 = this.strategy;
        int hashCode3 = (hashCode2 + (jSONObject2 == null ? 0 : jSONObject2.hashCode())) * 31;
        JSONObject jSONObject3 = this.plugin;
        return hashCode3 + (jSONObject3 != null ? jSONObject3.hashCode() : 0);
    }

    public String toString() {
        return "RecoveryConfigModel(forceCloseAll=" + this.forceCloseAll + ", aspect=" + this.aspect + ", strategy=" + this.strategy + ", plugin=" + this.plugin + ')';
    }

    public /* synthetic */ RecoveryConfigModel(boolean z, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : jSONObject, (i & 4) != 0 ? null : jSONObject2, (i & 8) != 0 ? null : jSONObject3);
    }

    public final boolean getForceCloseAll() {
        return this.forceCloseAll;
    }

    public final JSONObject getAspect() {
        return this.aspect;
    }

    public final JSONObject getStrategy() {
        return this.strategy;
    }

    public final JSONObject getPlugin() {
        return this.plugin;
    }

    /* compiled from: ArgusConfigManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/RecoveryConfigModel$Companion;", "", "()V", "init", "Lcom/bytedance/ies/argus/repository/RecoveryConfigModel;", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecoveryConfigModel init(JSONObject data, ConfigInfo info) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(info, "info");
            RecoveryConfigModel recoveryConfigModel = new RecoveryConfigModel(data.optBoolean("force_close_all", false), data.optJSONObject("aspect"), data.optJSONObject(StrategyConstants.STRATEGY), data.optJSONObject(CloudControlInf.PLUGIN));
            recoveryConfigModel.setConfInfo(info);
            return recoveryConfigModel;
        }
    }

    public RecoveryConfigModel(boolean z, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        super(null, 1, null);
        this.forceCloseAll = z;
        this.aspect = jSONObject;
        this.strategy = jSONObject2;
        this.plugin = jSONObject3;
    }
}
