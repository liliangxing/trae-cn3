package com.bytedance.trae.conversation.voice.network;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;", "", "agentType", "", "modelName", StrategyConstants.MODELS, "", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAgentType$annotations", "()V", "getAgentType", "()Ljava/lang/String;", "getModelName$annotations", "getModelName", "getModels", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VoiceSubTaskConfig {

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName(StrategyConstants.MODEL_NAME)
    private final String modelName;

    @SerializedName(StrategyConstants.MODELS)
    private final List<JsonObject> models;

    public VoiceSubTaskConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoiceSubTaskConfig copy$default(VoiceSubTaskConfig voiceSubTaskConfig, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceSubTaskConfig.agentType;
        }
        if ((i & 2) != 0) {
            str2 = voiceSubTaskConfig.modelName;
        }
        if ((i & 4) != 0) {
            list = voiceSubTaskConfig.models;
        }
        return voiceSubTaskConfig.copy(str, str2, list);
    }

    @Deprecated(message = "Sub task agent_type is fixed by client; this response field is ignored.")
    public static /* synthetic */ void getAgentType$annotations() {
    }

    @Deprecated(message = "Use models instead; this response field is ignored.")
    public static /* synthetic */ void getModelName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    public final List<JsonObject> component3() {
        return this.models;
    }

    public final VoiceSubTaskConfig copy(String agentType, String modelName, List<JsonObject> models) {
        return new VoiceSubTaskConfig(agentType, modelName, models);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceSubTaskConfig)) {
            return false;
        }
        VoiceSubTaskConfig voiceSubTaskConfig = (VoiceSubTaskConfig) other;
        return Intrinsics.areEqual(this.agentType, voiceSubTaskConfig.agentType) && Intrinsics.areEqual(this.modelName, voiceSubTaskConfig.modelName) && Intrinsics.areEqual(this.models, voiceSubTaskConfig.models);
    }

    public int hashCode() {
        String str = this.agentType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.modelName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<JsonObject> list = this.models;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "VoiceSubTaskConfig(agentType=" + this.agentType + ", modelName=" + this.modelName + ", models=" + this.models + ')';
    }

    public VoiceSubTaskConfig(String str, String str2, List<JsonObject> list) {
        this.agentType = str;
        this.modelName = str2;
        this.models = list;
    }

    public /* synthetic */ VoiceSubTaskConfig(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final List<JsonObject> getModels() {
        return this.models;
    }
}
