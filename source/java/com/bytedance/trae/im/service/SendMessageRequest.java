package com.bytedance.trae.im.service;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISendMessageService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/SendMessageRequest;", "", ReportConstant.COMMON_CONTENT, "", "Lcom/bytedance/trae/im/service/StandardChatMessagePart;", "query", "", "modelName", "agentType", "modelSelectionStrategy", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/util/List;", "getQuery", "()Ljava/lang/String;", "getModelName", "getAgentType", "getModelSelectionStrategy", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SendMessageRequest {

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName(ReportConstant.COMMON_CONTENT)
    private final List<StandardChatMessagePart> content;

    @SerializedName("model_name")
    private final String modelName;

    @SerializedName("model_selection_strategy")
    private final String modelSelectionStrategy;

    @SerializedName("query")
    private final String query;

    public SendMessageRequest() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SendMessageRequest copy$default(SendMessageRequest sendMessageRequest, List list, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sendMessageRequest.content;
        }
        if ((i & 2) != 0) {
            str = sendMessageRequest.query;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = sendMessageRequest.modelName;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = sendMessageRequest.agentType;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = sendMessageRequest.modelSelectionStrategy;
        }
        return sendMessageRequest.copy(list, str5, str6, str7, str4);
    }

    public final List<StandardChatMessagePart> component1() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQuery() {
        return this.query;
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
    public final String getModelSelectionStrategy() {
        return this.modelSelectionStrategy;
    }

    public final SendMessageRequest copy(List<StandardChatMessagePart> content, String query, String modelName, String agentType, String modelSelectionStrategy) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(modelSelectionStrategy, "modelSelectionStrategy");
        return new SendMessageRequest(content, query, modelName, agentType, modelSelectionStrategy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendMessageRequest)) {
            return false;
        }
        SendMessageRequest sendMessageRequest = (SendMessageRequest) other;
        return Intrinsics.areEqual(this.content, sendMessageRequest.content) && Intrinsics.areEqual(this.query, sendMessageRequest.query) && Intrinsics.areEqual(this.modelName, sendMessageRequest.modelName) && Intrinsics.areEqual(this.agentType, sendMessageRequest.agentType) && Intrinsics.areEqual(this.modelSelectionStrategy, sendMessageRequest.modelSelectionStrategy);
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        String str = this.query;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.modelName.hashCode()) * 31;
        String str2 = this.agentType;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.modelSelectionStrategy.hashCode();
    }

    public String toString() {
        return "SendMessageRequest(content=" + this.content + ", query=" + this.query + ", modelName=" + this.modelName + ", agentType=" + this.agentType + ", modelSelectionStrategy=" + this.modelSelectionStrategy + ')';
    }

    public SendMessageRequest(List<StandardChatMessagePart> list, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(list, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(str2, "modelName");
        Intrinsics.checkNotNullParameter(str4, "modelSelectionStrategy");
        this.content = list;
        this.query = str;
        this.modelName = str2;
        this.agentType = str3;
        this.modelSelectionStrategy = str4;
    }

    public /* synthetic */ SendMessageRequest(List list, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "solo_coder" : str3, (i & 16) != 0 ? ModelSelectionConstants.AUTO : str4);
    }

    public final List<StandardChatMessagePart> getContent() {
        return this.content;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final String getModelSelectionStrategy() {
        return this.modelSelectionStrategy;
    }
}
