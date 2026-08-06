package com.bytedance.trae.conversation.chat.checkpoint;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointInteraction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "", "<init>", "()V", "planItemId", "", "getPlanItemId", "()Ljava/lang/String;", "toolName", "getToolName", DBDefinition.TASK_ID, "getTaskId", "conversationId", "getConversationId", "Confirm", "Skip", "SubmitAnswer", "Cancel", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CheckpointDecision {
    public /* synthetic */ CheckpointDecision(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getConversationId();

    public abstract String getPlanItemId();

    public abstract String getTaskId();

    public abstract String getToolName();

    private CheckpointDecision() {
    }

    /* compiled from: CheckpointInteraction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "planItemId", "", "toolName", DBDefinition.TASK_ID, "conversationId", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getToolName", "getTaskId", "getConversationId", "getParams", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Confirm extends CheckpointDecision {
        private final String conversationId;
        private final String params;
        private final String planItemId;
        private final String taskId;
        private final String toolName;

        public static /* synthetic */ Confirm copy$default(Confirm confirm, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = confirm.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = confirm.toolName;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = confirm.taskId;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = confirm.conversationId;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = confirm.params;
            }
            return confirm.copy(str, str6, str7, str8, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getParams() {
            return this.params;
        }

        public final Confirm copy(String planItemId, String toolName, String taskId, String conversationId, String params) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            return new Confirm(planItemId, toolName, taskId, conversationId, params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Confirm)) {
                return false;
            }
            Confirm confirm = (Confirm) other;
            return Intrinsics.areEqual(this.planItemId, confirm.planItemId) && Intrinsics.areEqual(this.toolName, confirm.toolName) && Intrinsics.areEqual(this.taskId, confirm.taskId) && Intrinsics.areEqual(this.conversationId, confirm.conversationId) && Intrinsics.areEqual(this.params, confirm.params);
        }

        public int hashCode() {
            int hashCode = this.planItemId.hashCode() * 31;
            String str = this.toolName;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.taskId.hashCode()) * 31;
            String str2 = this.conversationId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.params;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Confirm(planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", params=" + this.params + ')';
        }

        public /* synthetic */ Confirm(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : str5);
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getPlanItemId() {
            return this.planItemId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getToolName() {
            return this.toolName;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getTaskId() {
            return this.taskId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getConversationId() {
            return this.conversationId;
        }

        public final String getParams() {
            return this.params;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Confirm(String planItemId, String str, String taskId, String str2, String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.planItemId = planItemId;
            this.toolName = str;
            this.taskId = taskId;
            this.conversationId = str2;
            this.params = str3;
        }
    }

    /* compiled from: CheckpointInteraction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Skip;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "planItemId", "", "toolName", DBDefinition.TASK_ID, "conversationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getToolName", "getTaskId", "getConversationId", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Skip extends CheckpointDecision {
        private final String conversationId;
        private final String planItemId;
        private final String taskId;
        private final String toolName;

        public static /* synthetic */ Skip copy$default(Skip skip, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = skip.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = skip.toolName;
            }
            if ((i & 4) != 0) {
                str3 = skip.taskId;
            }
            if ((i & 8) != 0) {
                str4 = skip.conversationId;
            }
            return skip.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final Skip copy(String planItemId, String toolName, String taskId, String conversationId) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            return new Skip(planItemId, toolName, taskId, conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Skip)) {
                return false;
            }
            Skip skip = (Skip) other;
            return Intrinsics.areEqual(this.planItemId, skip.planItemId) && Intrinsics.areEqual(this.toolName, skip.toolName) && Intrinsics.areEqual(this.taskId, skip.taskId) && Intrinsics.areEqual(this.conversationId, skip.conversationId);
        }

        public int hashCode() {
            int hashCode = this.planItemId.hashCode() * 31;
            String str = this.toolName;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.taskId.hashCode()) * 31;
            String str2 = this.conversationId;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Skip(planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", taskId=" + this.taskId + ", conversationId=" + this.conversationId + ')';
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getPlanItemId() {
            return this.planItemId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getToolName() {
            return this.toolName;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getTaskId() {
            return this.taskId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getConversationId() {
            return this.conversationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Skip(String planItemId, String str, String taskId, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.planItemId = planItemId;
            this.toolName = str;
            this.taskId = taskId;
            this.conversationId = str2;
        }
    }

    /* compiled from: CheckpointInteraction.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$SubmitAnswer;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "planItemId", "", "toolName", DBDefinition.TASK_ID, "conversationId", "questionsJson", "answers", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;", "supplementaryInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getToolName", "getTaskId", "getConversationId", "getQuestionsJson", "getAnswers", "()Ljava/util/List;", "getSupplementaryInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SubmitAnswer extends CheckpointDecision {
        private final List<AnswerEntry> answers;
        private final String conversationId;
        private final String planItemId;
        private final String questionsJson;
        private final String supplementaryInfo;
        private final String taskId;
        private final String toolName;

        public static /* synthetic */ SubmitAnswer copy$default(SubmitAnswer submitAnswer, String str, String str2, String str3, String str4, String str5, List list, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitAnswer.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = submitAnswer.toolName;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = submitAnswer.taskId;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = submitAnswer.conversationId;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = submitAnswer.questionsJson;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                list = submitAnswer.answers;
            }
            List list2 = list;
            if ((i & 64) != 0) {
                str6 = submitAnswer.supplementaryInfo;
            }
            return submitAnswer.copy(str, str7, str8, str9, str10, list2, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getQuestionsJson() {
            return this.questionsJson;
        }

        public final List<AnswerEntry> component6() {
            return this.answers;
        }

        /* renamed from: component7, reason: from getter */
        public final String getSupplementaryInfo() {
            return this.supplementaryInfo;
        }

        public final SubmitAnswer copy(String planItemId, String toolName, String taskId, String conversationId, String questionsJson, List<AnswerEntry> answers, String supplementaryInfo) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(questionsJson, "questionsJson");
            Intrinsics.checkNotNullParameter(answers, "answers");
            return new SubmitAnswer(planItemId, toolName, taskId, conversationId, questionsJson, answers, supplementaryInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubmitAnswer)) {
                return false;
            }
            SubmitAnswer submitAnswer = (SubmitAnswer) other;
            return Intrinsics.areEqual(this.planItemId, submitAnswer.planItemId) && Intrinsics.areEqual(this.toolName, submitAnswer.toolName) && Intrinsics.areEqual(this.taskId, submitAnswer.taskId) && Intrinsics.areEqual(this.conversationId, submitAnswer.conversationId) && Intrinsics.areEqual(this.questionsJson, submitAnswer.questionsJson) && Intrinsics.areEqual(this.answers, submitAnswer.answers) && Intrinsics.areEqual(this.supplementaryInfo, submitAnswer.supplementaryInfo);
        }

        public int hashCode() {
            int hashCode = this.planItemId.hashCode() * 31;
            String str = this.toolName;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.taskId.hashCode()) * 31;
            String str2 = this.conversationId;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.questionsJson.hashCode()) * 31) + this.answers.hashCode()) * 31;
            String str3 = this.supplementaryInfo;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "SubmitAnswer(planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", questionsJson=" + this.questionsJson + ", answers=" + this.answers + ", supplementaryInfo=" + this.supplementaryInfo + ')';
        }

        public /* synthetic */ SubmitAnswer(String str, String str2, String str3, String str4, String str5, List list, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, list, (i & 64) != 0 ? null : str6);
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getPlanItemId() {
            return this.planItemId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getToolName() {
            return this.toolName;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getTaskId() {
            return this.taskId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getConversationId() {
            return this.conversationId;
        }

        public final String getQuestionsJson() {
            return this.questionsJson;
        }

        public final List<AnswerEntry> getAnswers() {
            return this.answers;
        }

        public final String getSupplementaryInfo() {
            return this.supplementaryInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubmitAnswer(String planItemId, String str, String taskId, String str2, String questionsJson, List<AnswerEntry> answers, String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(questionsJson, "questionsJson");
            Intrinsics.checkNotNullParameter(answers, "answers");
            this.planItemId = planItemId;
            this.toolName = str;
            this.taskId = taskId;
            this.conversationId = str2;
            this.questionsJson = questionsJson;
            this.answers = answers;
            this.supplementaryInfo = str3;
        }
    }

    /* compiled from: CheckpointInteraction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Cancel;", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;", "planItemId", "", "toolName", DBDefinition.TASK_ID, "conversationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getToolName", "getTaskId", "getConversationId", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Cancel extends CheckpointDecision {
        private final String conversationId;
        private final String planItemId;
        private final String taskId;
        private final String toolName;

        public static /* synthetic */ Cancel copy$default(Cancel cancel, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cancel.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = cancel.toolName;
            }
            if ((i & 4) != 0) {
                str3 = cancel.taskId;
            }
            if ((i & 8) != 0) {
                str4 = cancel.conversationId;
            }
            return cancel.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final Cancel copy(String planItemId, String toolName, String taskId, String conversationId) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            return new Cancel(planItemId, toolName, taskId, conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cancel)) {
                return false;
            }
            Cancel cancel = (Cancel) other;
            return Intrinsics.areEqual(this.planItemId, cancel.planItemId) && Intrinsics.areEqual(this.toolName, cancel.toolName) && Intrinsics.areEqual(this.taskId, cancel.taskId) && Intrinsics.areEqual(this.conversationId, cancel.conversationId);
        }

        public int hashCode() {
            int hashCode = this.planItemId.hashCode() * 31;
            String str = this.toolName;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.taskId.hashCode()) * 31;
            String str2 = this.conversationId;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Cancel(planItemId=" + this.planItemId + ", toolName=" + this.toolName + ", taskId=" + this.taskId + ", conversationId=" + this.conversationId + ')';
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getPlanItemId() {
            return this.planItemId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getToolName() {
            return this.toolName;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getTaskId() {
            return this.taskId;
        }

        @Override // com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision
        public String getConversationId() {
            return this.conversationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancel(String planItemId, String str, String taskId, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            this.planItemId = planItemId;
            this.toolName = str;
            this.taskId = taskId;
            this.conversationId = str2;
        }
    }
}
