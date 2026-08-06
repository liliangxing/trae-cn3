package com.bytedance.trae.conversation.voice;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationStateMessage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001:\u0003%&'BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "", DBDefinition.TASK_ID, "", "userID", "roundID", "", "eventTime", "stage", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;", "errorInfo", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;)V", "getTaskId", "()Ljava/lang/String;", "getUserID", "getRoundID", "()J", "getEventTime", "getStage", "()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;", "getErrorInfo", "()Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Stage", "ErrorDetail", "StageCode", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationStateMessage {

    @SerializedName("ErrorInfo")
    private final ErrorDetail errorInfo;

    @SerializedName("EventTime")
    private final long eventTime;

    @SerializedName("RoundID")
    private final long roundID;

    @SerializedName("Stage")
    private final Stage stage;

    @SerializedName("TaskId")
    private final String taskId;

    @SerializedName("UserID")
    private final String userID;

    public ConversationStateMessage() {
        this(null, null, 0L, 0L, null, null, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserID() {
        return this.userID;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRoundID() {
        return this.roundID;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEventTime() {
        return this.eventTime;
    }

    /* renamed from: component5, reason: from getter */
    public final Stage getStage() {
        return this.stage;
    }

    /* renamed from: component6, reason: from getter */
    public final ErrorDetail getErrorInfo() {
        return this.errorInfo;
    }

    public final ConversationStateMessage copy(String taskId, String userID, long roundID, long eventTime, Stage stage, ErrorDetail errorInfo) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(userID, "userID");
        Intrinsics.checkNotNullParameter(stage, "stage");
        return new ConversationStateMessage(taskId, userID, roundID, eventTime, stage, errorInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationStateMessage)) {
            return false;
        }
        ConversationStateMessage conversationStateMessage = (ConversationStateMessage) other;
        return Intrinsics.areEqual(this.taskId, conversationStateMessage.taskId) && Intrinsics.areEqual(this.userID, conversationStateMessage.userID) && this.roundID == conversationStateMessage.roundID && this.eventTime == conversationStateMessage.eventTime && Intrinsics.areEqual(this.stage, conversationStateMessage.stage) && Intrinsics.areEqual(this.errorInfo, conversationStateMessage.errorInfo);
    }

    public int hashCode() {
        int hashCode = ((((((((this.taskId.hashCode() * 31) + this.userID.hashCode()) * 31) + Long.hashCode(this.roundID)) * 31) + Long.hashCode(this.eventTime)) * 31) + this.stage.hashCode()) * 31;
        ErrorDetail errorDetail = this.errorInfo;
        return hashCode + (errorDetail == null ? 0 : errorDetail.hashCode());
    }

    public String toString() {
        return "ConversationStateMessage(taskId=" + this.taskId + ", userID=" + this.userID + ", roundID=" + this.roundID + ", eventTime=" + this.eventTime + ", stage=" + this.stage + ", errorInfo=" + this.errorInfo + ')';
    }

    public ConversationStateMessage(String taskId, String userID, long j, long j2, Stage stage, ErrorDetail errorDetail) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(userID, "userID");
        Intrinsics.checkNotNullParameter(stage, "stage");
        this.taskId = taskId;
        this.userID = userID;
        this.roundID = j;
        this.eventTime = j2;
        this.stage = stage;
        this.errorInfo = errorDetail;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final long getRoundID() {
        return this.roundID;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final Stage getStage() {
        return this.stage;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ConversationStateMessage(String str, String str2, long j, long j2, Stage stage, ErrorDetail errorDetail, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r0, r1, r5, r3, r2, (i & 32) == 0 ? errorDetail : null);
        Stage stage2;
        String str3 = (i & 1) != 0 ? "" : str;
        String str4 = (i & 2) == 0 ? str2 : "";
        long j3 = (i & 4) != 0 ? 0L : j;
        long j4 = (i & 8) == 0 ? j2 : 0L;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if ((i & 16) != 0) {
            stage2 = new Stage(0, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        } else {
            stage2 = stage;
        }
    }

    public final ErrorDetail getErrorInfo() {
        return this.errorInfo;
    }

    /* compiled from: ConversationStateMessage.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$Stage;", "", "code", "", "description", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Stage {

        @SerializedName("Code")
        private final int code;

        @SerializedName("Description")
        private final String description;

        /* JADX WARN: Multi-variable type inference failed */
        public Stage() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Stage copy$default(Stage stage, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = stage.code;
            }
            if ((i2 & 2) != 0) {
                str = stage.description;
            }
            return stage.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Stage copy(int code, String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            return new Stage(code, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stage)) {
                return false;
            }
            Stage stage = (Stage) other;
            return this.code == stage.code && Intrinsics.areEqual(this.description, stage.description);
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.description.hashCode();
        }

        public String toString() {
            return "Stage(code=" + this.code + ", description=" + this.description + ')';
        }

        public Stage(int i, String description) {
            Intrinsics.checkNotNullParameter(description, "description");
            this.code = i;
            this.description = description;
        }

        public /* synthetic */ Stage(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str);
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    /* compiled from: ConversationStateMessage.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$ErrorDetail;", "", "errorCode", "", "reason", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getReason", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ErrorDetail {

        @SerializedName("ErrorCode")
        private final int errorCode;

        @SerializedName("Reason")
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public ErrorDetail() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ErrorDetail copy$default(ErrorDetail errorDetail, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = errorDetail.errorCode;
            }
            if ((i2 & 2) != 0) {
                str = errorDetail.reason;
            }
            return errorDetail.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final ErrorDetail copy(int errorCode, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new ErrorDetail(errorCode, reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorDetail)) {
                return false;
            }
            ErrorDetail errorDetail = (ErrorDetail) other;
            return this.errorCode == errorDetail.errorCode && Intrinsics.areEqual(this.reason, errorDetail.reason);
        }

        public int hashCode() {
            return (Integer.hashCode(this.errorCode) * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "ErrorDetail(errorCode=" + this.errorCode + ", reason=" + this.reason + ')';
        }

        public ErrorDetail(int i, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.errorCode = i;
            this.reason = reason;
        }

        public /* synthetic */ ErrorDetail(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: ConversationStateMessage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/voice/ConversationStateMessage$StageCode;", "", "<init>", "()V", "ERROR_OCCURRED", "", "LISTENING", "THINKING", "ANSWERING", "INTERRUPTED", "ANSWER_FINISH", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StageCode {
        public static final int ANSWERING = 3;
        public static final int ANSWER_FINISH = 5;
        public static final int ERROR_OCCURRED = 0;
        public static final StageCode INSTANCE = new StageCode();
        public static final int INTERRUPTED = 4;
        public static final int LISTENING = 1;
        public static final int THINKING = 2;

        private StageCode() {
        }
    }
}
