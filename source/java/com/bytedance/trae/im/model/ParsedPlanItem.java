package com.bytedance.trae.im.model;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010,J\u0092\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020\u00102\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0017R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006B"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedPlanItem;", "", "id", "", "agentId", "agentDisplayName", "agentRunId", "subAgentCallDescription", "thought", "planType", "reasoningContent", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "hide", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedToolCallInfo;Lcom/bytedance/trae/im/model/ConfirmInfo;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getAgentId", "setAgentId", "(Ljava/lang/String;)V", "getAgentDisplayName", "setAgentDisplayName", "getAgentRunId", "setAgentRunId", "getSubAgentCallDescription", "setSubAgentCallDescription", "getThought", "setThought", "getPlanType", "getReasoningContent", "setReasoningContent", "getToolCallInfo", "()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "setToolCallInfo", "(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V", "getConfirmInfo", "()Lcom/bytedance/trae/im/model/ConfirmInfo;", "setConfirmInfo", "(Lcom/bytedance/trae/im/model/ConfirmInfo;)V", "getHide", "()Ljava/lang/Boolean;", "setHide", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedToolCallInfo;Lcom/bytedance/trae/im/model/ConfirmInfo;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/model/ParsedPlanItem;", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ParsedPlanItem {

    @SerializedName("agent_display_name")
    private String agentDisplayName;

    @SerializedName("agent_id")
    private String agentId;

    @SerializedName("agent_run_id")
    private String agentRunId;

    @SerializedName("confirm_info")
    private ConfirmInfo confirmInfo;

    @SerializedName("hide")
    private Boolean hide;

    @SerializedName("id")
    private final String id;

    @SerializedName("plan_type")
    private final String planType;

    @SerializedName("reasoning_content")
    private String reasoningContent;

    @SerializedName("sub_agent_call_description")
    private String subAgentCallDescription;

    @SerializedName("thought")
    private String thought;

    @SerializedName("tool_call_info")
    private ParsedToolCallInfo toolCallInfo;

    public ParsedPlanItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final ConfirmInfo getConfirmInfo() {
        return this.confirmInfo;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getHide() {
        return this.hide;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAgentDisplayName() {
        return this.agentDisplayName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAgentRunId() {
        return this.agentRunId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubAgentCallDescription() {
        return this.subAgentCallDescription;
    }

    /* renamed from: component6, reason: from getter */
    public final String getThought() {
        return this.thought;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPlanType() {
        return this.planType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReasoningContent() {
        return this.reasoningContent;
    }

    /* renamed from: component9, reason: from getter */
    public final ParsedToolCallInfo getToolCallInfo() {
        return this.toolCallInfo;
    }

    public final ParsedPlanItem copy(String id, String agentId, String agentDisplayName, String agentRunId, String subAgentCallDescription, String thought, String planType, String reasoningContent, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo, Boolean hide) {
        return new ParsedPlanItem(id, agentId, agentDisplayName, agentRunId, subAgentCallDescription, thought, planType, reasoningContent, toolCallInfo, confirmInfo, hide);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedPlanItem)) {
            return false;
        }
        ParsedPlanItem parsedPlanItem = (ParsedPlanItem) other;
        return Intrinsics.areEqual(this.id, parsedPlanItem.id) && Intrinsics.areEqual(this.agentId, parsedPlanItem.agentId) && Intrinsics.areEqual(this.agentDisplayName, parsedPlanItem.agentDisplayName) && Intrinsics.areEqual(this.agentRunId, parsedPlanItem.agentRunId) && Intrinsics.areEqual(this.subAgentCallDescription, parsedPlanItem.subAgentCallDescription) && Intrinsics.areEqual(this.thought, parsedPlanItem.thought) && Intrinsics.areEqual(this.planType, parsedPlanItem.planType) && Intrinsics.areEqual(this.reasoningContent, parsedPlanItem.reasoningContent) && Intrinsics.areEqual(this.toolCallInfo, parsedPlanItem.toolCallInfo) && Intrinsics.areEqual(this.confirmInfo, parsedPlanItem.confirmInfo) && Intrinsics.areEqual(this.hide, parsedPlanItem.hide);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.agentId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agentDisplayName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.agentRunId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subAgentCallDescription;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.thought;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.planType;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.reasoningContent;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ParsedToolCallInfo parsedToolCallInfo = this.toolCallInfo;
        int hashCode9 = (hashCode8 + (parsedToolCallInfo == null ? 0 : parsedToolCallInfo.hashCode())) * 31;
        ConfirmInfo confirmInfo = this.confirmInfo;
        int hashCode10 = (hashCode9 + (confirmInfo == null ? 0 : confirmInfo.hashCode())) * 31;
        Boolean bool = this.hide;
        return hashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParsedPlanItem(id=");
        sb.append(this.id).append(", agentId=").append(this.agentId).append(", agentDisplayName=").append(this.agentDisplayName).append(", agentRunId=").append(this.agentRunId).append(", subAgentCallDescription=").append(this.subAgentCallDescription).append(", thought=").append(this.thought).append(", planType=").append(this.planType).append(", reasoningContent=").append(this.reasoningContent).append(", toolCallInfo=").append(this.toolCallInfo).append(", confirmInfo=").append(this.confirmInfo).append(", hide=").append(this.hide).append(')');
        return sb.toString();
    }

    public ParsedPlanItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, Boolean bool) {
        this.id = str;
        this.agentId = str2;
        this.agentDisplayName = str3;
        this.agentRunId = str4;
        this.subAgentCallDescription = str5;
        this.thought = str6;
        this.planType = str7;
        this.reasoningContent = str8;
        this.toolCallInfo = parsedToolCallInfo;
        this.confirmInfo = confirmInfo;
        this.hide = bool;
    }

    public /* synthetic */ ParsedPlanItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : parsedToolCallInfo, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : confirmInfo, (i & 1024) == 0 ? bool : null);
    }

    public final String getId() {
        return this.id;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final void setAgentId(String str) {
        this.agentId = str;
    }

    public final String getAgentDisplayName() {
        return this.agentDisplayName;
    }

    public final void setAgentDisplayName(String str) {
        this.agentDisplayName = str;
    }

    public final String getAgentRunId() {
        return this.agentRunId;
    }

    public final void setAgentRunId(String str) {
        this.agentRunId = str;
    }

    public final String getSubAgentCallDescription() {
        return this.subAgentCallDescription;
    }

    public final void setSubAgentCallDescription(String str) {
        this.subAgentCallDescription = str;
    }

    public final String getThought() {
        return this.thought;
    }

    public final void setThought(String str) {
        this.thought = str;
    }

    public final String getPlanType() {
        return this.planType;
    }

    public final String getReasoningContent() {
        return this.reasoningContent;
    }

    public final void setReasoningContent(String str) {
        this.reasoningContent = str;
    }

    public final ParsedToolCallInfo getToolCallInfo() {
        return this.toolCallInfo;
    }

    public final void setToolCallInfo(ParsedToolCallInfo parsedToolCallInfo) {
        this.toolCallInfo = parsedToolCallInfo;
    }

    public final ConfirmInfo getConfirmInfo() {
        return this.confirmInfo;
    }

    public final void setConfirmInfo(ConfirmInfo confirmInfo) {
        this.confirmInfo = confirmInfo;
    }

    public final Boolean getHide() {
        return this.hide;
    }

    public final void setHide(Boolean bool) {
        this.hide = bool;
    }
}
