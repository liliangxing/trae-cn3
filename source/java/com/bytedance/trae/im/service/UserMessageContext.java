package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\b\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\n\u0010\u0017R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u000b\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006+"}, d2 = {"Lcom/bytedance/trae/im/service/UserMessageContext;", "", "ppeEnvName", "", "modelInfo", "Lcom/bytedance/trae/im/service/ModelInfo;", "parsedQuery", "asrTimes", "isInPlanMode", "", "isInSpecMode", "isAppendMsg", "commandType", "query", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/im/service/ModelInfo;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Object;)V", "getPpeEnvName", "()Ljava/lang/String;", "getModelInfo", "()Lcom/bytedance/trae/im/service/ModelInfo;", "getParsedQuery", "()Ljava/lang/Object;", "getAsrTimes", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommandType", "getQuery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/bytedance/trae/im/service/ModelInfo;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Object;)Lcom/bytedance/trae/im/service/UserMessageContext;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserMessageContext {

    @SerializedName("asr_times")
    private final Object asrTimes;

    @SerializedName("command_type")
    private final Object commandType;

    @SerializedName("is_append_msg")
    private final Boolean isAppendMsg;

    @SerializedName("is_in_plan_mode")
    private final Boolean isInPlanMode;

    @SerializedName("is_in_spec_mode")
    private final Boolean isInSpecMode;

    @SerializedName("model_info")
    private final ModelInfo modelInfo;

    @SerializedName("parsed_query")
    private final Object parsedQuery;

    @SerializedName("ppe_env_name")
    private final String ppeEnvName;

    @SerializedName("query")
    private final Object query;

    public UserMessageContext() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPpeEnvName() {
        return this.ppeEnvName;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelInfo getModelInfo() {
        return this.modelInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getParsedQuery() {
        return this.parsedQuery;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getAsrTimes() {
        return this.asrTimes;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsInPlanMode() {
        return this.isInPlanMode;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getIsInSpecMode() {
        return this.isInSpecMode;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getIsAppendMsg() {
        return this.isAppendMsg;
    }

    /* renamed from: component8, reason: from getter */
    public final Object getCommandType() {
        return this.commandType;
    }

    /* renamed from: component9, reason: from getter */
    public final Object getQuery() {
        return this.query;
    }

    public final UserMessageContext copy(String ppeEnvName, ModelInfo modelInfo, Object parsedQuery, Object asrTimes, Boolean isInPlanMode, Boolean isInSpecMode, Boolean isAppendMsg, Object commandType, Object query) {
        return new UserMessageContext(ppeEnvName, modelInfo, parsedQuery, asrTimes, isInPlanMode, isInSpecMode, isAppendMsg, commandType, query);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserMessageContext)) {
            return false;
        }
        UserMessageContext userMessageContext = (UserMessageContext) other;
        return Intrinsics.areEqual(this.ppeEnvName, userMessageContext.ppeEnvName) && Intrinsics.areEqual(this.modelInfo, userMessageContext.modelInfo) && Intrinsics.areEqual(this.parsedQuery, userMessageContext.parsedQuery) && Intrinsics.areEqual(this.asrTimes, userMessageContext.asrTimes) && Intrinsics.areEqual(this.isInPlanMode, userMessageContext.isInPlanMode) && Intrinsics.areEqual(this.isInSpecMode, userMessageContext.isInSpecMode) && Intrinsics.areEqual(this.isAppendMsg, userMessageContext.isAppendMsg) && Intrinsics.areEqual(this.commandType, userMessageContext.commandType) && Intrinsics.areEqual(this.query, userMessageContext.query);
    }

    public int hashCode() {
        String str = this.ppeEnvName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ModelInfo modelInfo = this.modelInfo;
        int hashCode2 = (hashCode + (modelInfo == null ? 0 : modelInfo.hashCode())) * 31;
        Object obj = this.parsedQuery;
        int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.asrTimes;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Boolean bool = this.isInPlanMode;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isInSpecMode;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isAppendMsg;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Object obj3 = this.commandType;
        int hashCode8 = (hashCode7 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.query;
        return hashCode8 + (obj4 != null ? obj4.hashCode() : 0);
    }

    public String toString() {
        return "UserMessageContext(ppeEnvName=" + this.ppeEnvName + ", modelInfo=" + this.modelInfo + ", parsedQuery=" + this.parsedQuery + ", asrTimes=" + this.asrTimes + ", isInPlanMode=" + this.isInPlanMode + ", isInSpecMode=" + this.isInSpecMode + ", isAppendMsg=" + this.isAppendMsg + ", commandType=" + this.commandType + ", query=" + this.query + ')';
    }

    public UserMessageContext(String str, ModelInfo modelInfo, Object obj, Object obj2, Boolean bool, Boolean bool2, Boolean bool3, Object obj3, Object obj4) {
        this.ppeEnvName = str;
        this.modelInfo = modelInfo;
        this.parsedQuery = obj;
        this.asrTimes = obj2;
        this.isInPlanMode = bool;
        this.isInSpecMode = bool2;
        this.isAppendMsg = bool3;
        this.commandType = obj3;
        this.query = obj4;
    }

    public /* synthetic */ UserMessageContext(String str, ModelInfo modelInfo, Object obj, Object obj2, Boolean bool, Boolean bool2, Boolean bool3, Object obj3, Object obj4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : modelInfo, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : obj3, (i & 256) == 0 ? obj4 : null);
    }

    public final String getPpeEnvName() {
        return this.ppeEnvName;
    }

    public final ModelInfo getModelInfo() {
        return this.modelInfo;
    }

    public final Object getParsedQuery() {
        return this.parsedQuery;
    }

    public final Object getAsrTimes() {
        return this.asrTimes;
    }

    public final Boolean isInPlanMode() {
        return this.isInPlanMode;
    }

    public final Boolean isInSpecMode() {
        return this.isInSpecMode;
    }

    public final Boolean isAppendMsg() {
        return this.isAppendMsg;
    }

    public final Object getCommandType() {
        return this.commandType;
    }

    public final Object getQuery() {
        return this.query;
    }
}
