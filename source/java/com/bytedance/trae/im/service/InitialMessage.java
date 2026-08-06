package com.bytedance.trae.im.service;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010 J~\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/bytedance/trae/im/service/InitialMessage;", "", ReportConstant.COMMON_CONTENT, "", "Lcom/bytedance/trae/im/service/StandardChatMessagePart;", "chatSessionId", "", "modelName", "agentType", "query", "modelSelectionStrategy", "Lcom/bytedance/trae/im/service/ModelSelectionStrategy;", "customModel", "Lcom/google/gson/JsonObject;", "commonParams", "useFastRequest", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ModelSelectionStrategy;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContent", "()Ljava/util/List;", "getChatSessionId", "()Ljava/lang/String;", "getModelName", "getAgentType", "getQuery", "getModelSelectionStrategy", "()Lcom/bytedance/trae/im/service/ModelSelectionStrategy;", "getCustomModel", "()Lcom/google/gson/JsonObject;", "getCommonParams", "getUseFastRequest", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ModelSelectionStrategy;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/InitialMessage;", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class InitialMessage {

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("common_params")
    private final String commonParams;

    @SerializedName(ReportConstant.COMMON_CONTENT)
    private final List<StandardChatMessagePart> content;

    @SerializedName("custom_model")
    private final JsonObject customModel;

    @SerializedName("model_name")
    private final String modelName;

    @SerializedName("model_selection_strategy")
    private final ModelSelectionStrategy modelSelectionStrategy;

    @SerializedName("query")
    private final String query;

    @SerializedName("use_fast_request")
    private final Boolean useFastRequest;

    public final List<StandardChatMessagePart> component1() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component6, reason: from getter */
    public final ModelSelectionStrategy getModelSelectionStrategy() {
        return this.modelSelectionStrategy;
    }

    /* renamed from: component7, reason: from getter */
    public final JsonObject getCustomModel() {
        return this.customModel;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCommonParams() {
        return this.commonParams;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getUseFastRequest() {
        return this.useFastRequest;
    }

    public final InitialMessage copy(List<StandardChatMessagePart> content, String chatSessionId, String modelName, String agentType, String query, ModelSelectionStrategy modelSelectionStrategy, JsonObject customModel, String commonParams, Boolean useFastRequest) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        return new InitialMessage(content, chatSessionId, modelName, agentType, query, modelSelectionStrategy, customModel, commonParams, useFastRequest);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitialMessage)) {
            return false;
        }
        InitialMessage initialMessage = (InitialMessage) other;
        return Intrinsics.areEqual(this.content, initialMessage.content) && Intrinsics.areEqual(this.chatSessionId, initialMessage.chatSessionId) && Intrinsics.areEqual(this.modelName, initialMessage.modelName) && Intrinsics.areEqual(this.agentType, initialMessage.agentType) && Intrinsics.areEqual(this.query, initialMessage.query) && this.modelSelectionStrategy == initialMessage.modelSelectionStrategy && Intrinsics.areEqual(this.customModel, initialMessage.customModel) && Intrinsics.areEqual(this.commonParams, initialMessage.commonParams) && Intrinsics.areEqual(this.useFastRequest, initialMessage.useFastRequest);
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        String str = this.chatSessionId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.modelName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agentType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.query;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ModelSelectionStrategy modelSelectionStrategy = this.modelSelectionStrategy;
        int hashCode6 = (hashCode5 + (modelSelectionStrategy == null ? 0 : modelSelectionStrategy.hashCode())) * 31;
        JsonObject jsonObject = this.customModel;
        int hashCode7 = (hashCode6 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        String str5 = this.commonParams;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.useFastRequest;
        return hashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "InitialMessage(content=" + this.content + ", chatSessionId=" + this.chatSessionId + ", modelName=" + this.modelName + ", agentType=" + this.agentType + ", query=" + this.query + ", modelSelectionStrategy=" + this.modelSelectionStrategy + ", customModel=" + this.customModel + ", commonParams=" + this.commonParams + ", useFastRequest=" + this.useFastRequest + ')';
    }

    public InitialMessage(List<StandardChatMessagePart> list, String str, String str2, String str3, String str4, ModelSelectionStrategy modelSelectionStrategy, JsonObject jsonObject, String str5, Boolean bool) {
        Intrinsics.checkNotNullParameter(list, ReportConstant.COMMON_CONTENT);
        this.content = list;
        this.chatSessionId = str;
        this.modelName = str2;
        this.agentType = str3;
        this.query = str4;
        this.modelSelectionStrategy = modelSelectionStrategy;
        this.customModel = jsonObject;
        this.commonParams = str5;
        this.useFastRequest = bool;
    }

    public /* synthetic */ InitialMessage(List list, String str, String str2, String str3, String str4, ModelSelectionStrategy modelSelectionStrategy, JsonObject jsonObject, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : modelSelectionStrategy, (i & 64) != 0 ? null : jsonObject, (i & 128) != 0 ? null : str5, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) == 0 ? bool : null);
    }

    public final List<StandardChatMessagePart> getContent() {
        return this.content;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final String getQuery() {
        return this.query;
    }

    public final ModelSelectionStrategy getModelSelectionStrategy() {
        return this.modelSelectionStrategy;
    }

    public final JsonObject getCustomModel() {
        return this.customModel;
    }

    public final String getCommonParams() {
        return this.commonParams;
    }

    public final Boolean getUseFastRequest() {
        return this.useFastRequest;
    }
}
