package com.bytedance.trae.conversation.chat.block;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.block.renderer.ref.WebReference;
import com.bytedance.trae.conversation.chat.error.AgentErrorLevel;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.ArtifactData;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.DocReferencesData;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedTokenUsage;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.Reference;
import com.bytedance.trae.im.model.SearchReferenceData;
import com.bytedance.trae.im.service.FastRequestEvent;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactDescriptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgentContentBlock.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:!\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0019%&'()*+,-./0123456789:;<=¨\u0006>"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "", "<init>", "()V", "Avatar", "References", "Thinking", "Thought", "Toolcall", "ToolcallGroup", "PureShowWidgetToolcallGroup", "TodoGroup", "SubAgentGroup", "Summary", "VoiceSummary", "Artifacts", "ActionType", "FeedbackState", "ActionBar", "UpgradeReminder", "Error", "FreeActivityQuotaError", "Loading", "CancelBanner", "Queuing", "InitialLoading", "VoiceSummaryLoading", "ProcessStart", "ProcessEnd", "GroupType", "GroupStatus", "TailStatus", "CardActionType", "CardStyle", "CardAction", "PromotionCard", "ViewVoiceHistory", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AgentContentBlock {
    public /* synthetic */ AgentContentBlock(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AgentContentBlock() {
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010$\u001a\u00020\rHÆ\u0003Jt\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\n\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "agentName", "", "agentAvatarId", "agentType", "cliType", "messageId", "sessionId", "replyToMessageId", "isExpressPass", "", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;J)V", "getAgentName", "()Ljava/lang/String;", "getAgentAvatarId", "getAgentType", "getCliType", "getMessageId", "getSessionId", "getReplyToMessageId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;J)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Avatar extends AgentContentBlock {
        private final String agentAvatarId;
        private final String agentName;
        private final String agentType;
        private final String cliType;
        private final long createdAt;
        private final Boolean isExpressPass;
        private final String messageId;
        private final String replyToMessageId;
        private final String sessionId;

        /* renamed from: component1, reason: from getter */
        public final String getAgentName() {
            return this.agentName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAgentAvatarId() {
            return this.agentAvatarId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAgentType() {
            return this.agentType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCliType() {
            return this.cliType;
        }

        /* renamed from: component5, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getIsExpressPass() {
            return this.isExpressPass;
        }

        /* renamed from: component9, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final Avatar copy(String agentName, String agentAvatarId, String agentType, String cliType, String messageId, String sessionId, String replyToMessageId, Boolean isExpressPass, long createdAt) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new Avatar(agentName, agentAvatarId, agentType, cliType, messageId, sessionId, replyToMessageId, isExpressPass, createdAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Avatar)) {
                return false;
            }
            Avatar avatar = (Avatar) other;
            return Intrinsics.areEqual(this.agentName, avatar.agentName) && Intrinsics.areEqual(this.agentAvatarId, avatar.agentAvatarId) && Intrinsics.areEqual(this.agentType, avatar.agentType) && Intrinsics.areEqual(this.cliType, avatar.cliType) && Intrinsics.areEqual(this.messageId, avatar.messageId) && Intrinsics.areEqual(this.sessionId, avatar.sessionId) && Intrinsics.areEqual(this.replyToMessageId, avatar.replyToMessageId) && Intrinsics.areEqual(this.isExpressPass, avatar.isExpressPass) && this.createdAt == avatar.createdAt;
        }

        public int hashCode() {
            String str = this.agentName;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.agentAvatarId;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.agentType;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cliType;
            int hashCode4 = (((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.messageId.hashCode()) * 31) + this.sessionId.hashCode()) * 31;
            String str5 = this.replyToMessageId;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Boolean bool = this.isExpressPass;
            return ((hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31) + Long.hashCode(this.createdAt);
        }

        public String toString() {
            return "Avatar(agentName=" + this.agentName + ", agentAvatarId=" + this.agentAvatarId + ", agentType=" + this.agentType + ", cliType=" + this.cliType + ", messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", replyToMessageId=" + this.replyToMessageId + ", isExpressPass=" + this.isExpressPass + ", createdAt=" + this.createdAt + ')';
        }

        public final String getAgentName() {
            return this.agentName;
        }

        public final String getAgentAvatarId() {
            return this.agentAvatarId;
        }

        public final String getAgentType() {
            return this.agentType;
        }

        public final String getCliType() {
            return this.cliType;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getReplyToMessageId() {
            return this.replyToMessageId;
        }

        public /* synthetic */ Avatar(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? false : bool, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0L : j);
        }

        public final Boolean isExpressPass() {
            return this.isExpressPass;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Avatar(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(str5, "messageId");
            Intrinsics.checkNotNullParameter(str6, "sessionId");
            this.agentName = str;
            this.agentAvatarId = str2;
            this.agentType = str3;
            this.cliType = str4;
            this.messageId = str5;
            this.sessionId = str6;
            this.replyToMessageId = str7;
            this.isExpressPass = bool;
            this.createdAt = j;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "codeReferences", "", "Lcom/bytedance/trae/im/model/Reference;", "searchReferences", "Lcom/bytedance/trae/im/model/SearchReferenceData;", "docReferences", "Lcom/bytedance/trae/im/model/DocReferencesData;", "<init>", "(Ljava/util/List;Lcom/bytedance/trae/im/model/SearchReferenceData;Lcom/bytedance/trae/im/model/DocReferencesData;)V", "getCodeReferences", "()Ljava/util/List;", "getSearchReferences", "()Lcom/bytedance/trae/im/model/SearchReferenceData;", "getDocReferences", "()Lcom/bytedance/trae/im/model/DocReferencesData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class References extends AgentContentBlock {
        private final List<Reference> codeReferences;
        private final DocReferencesData docReferences;
        private final SearchReferenceData searchReferences;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ References copy$default(References references, List list, SearchReferenceData searchReferenceData, DocReferencesData docReferencesData, int i, Object obj) {
            if ((i & 1) != 0) {
                list = references.codeReferences;
            }
            if ((i & 2) != 0) {
                searchReferenceData = references.searchReferences;
            }
            if ((i & 4) != 0) {
                docReferencesData = references.docReferences;
            }
            return references.copy(list, searchReferenceData, docReferencesData);
        }

        public final List<Reference> component1() {
            return this.codeReferences;
        }

        /* renamed from: component2, reason: from getter */
        public final SearchReferenceData getSearchReferences() {
            return this.searchReferences;
        }

        /* renamed from: component3, reason: from getter */
        public final DocReferencesData getDocReferences() {
            return this.docReferences;
        }

        public final References copy(List<Reference> codeReferences, SearchReferenceData searchReferences, DocReferencesData docReferences) {
            Intrinsics.checkNotNullParameter(codeReferences, "codeReferences");
            return new References(codeReferences, searchReferences, docReferences);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof References)) {
                return false;
            }
            References references = (References) other;
            return Intrinsics.areEqual(this.codeReferences, references.codeReferences) && Intrinsics.areEqual(this.searchReferences, references.searchReferences) && Intrinsics.areEqual(this.docReferences, references.docReferences);
        }

        public int hashCode() {
            int hashCode = this.codeReferences.hashCode() * 31;
            SearchReferenceData searchReferenceData = this.searchReferences;
            int hashCode2 = (hashCode + (searchReferenceData == null ? 0 : searchReferenceData.hashCode())) * 31;
            DocReferencesData docReferencesData = this.docReferences;
            return hashCode2 + (docReferencesData != null ? docReferencesData.hashCode() : 0);
        }

        public String toString() {
            return "References(codeReferences=" + this.codeReferences + ", searchReferences=" + this.searchReferences + ", docReferences=" + this.docReferences + ')';
        }

        public final List<Reference> getCodeReferences() {
            return this.codeReferences;
        }

        public final SearchReferenceData getSearchReferences() {
            return this.searchReferences;
        }

        public final DocReferencesData getDocReferences() {
            return this.docReferences;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public References(List<Reference> list, SearchReferenceData searchReferenceData, DocReferencesData docReferencesData) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "codeReferences");
            this.codeReferences = list;
            this.searchReferences = searchReferenceData;
            this.docReferences = docReferencesData;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "planItemId", "", "reasoningContent", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "isThinking", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedToolCallInfo;Z)V", "getPlanItemId", "()Ljava/lang/String;", "getReasoningContent", "getToolCallInfo", "()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Thinking extends AgentContentBlock {
        private final boolean isThinking;
        private final String planItemId;
        private final String reasoningContent;
        private final ParsedToolCallInfo toolCallInfo;

        public static /* synthetic */ Thinking copy$default(Thinking thinking, String str, String str2, ParsedToolCallInfo parsedToolCallInfo, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = thinking.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = thinking.reasoningContent;
            }
            if ((i & 4) != 0) {
                parsedToolCallInfo = thinking.toolCallInfo;
            }
            if ((i & 8) != 0) {
                z = thinking.isThinking;
            }
            return thinking.copy(str, str2, parsedToolCallInfo, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReasoningContent() {
            return this.reasoningContent;
        }

        /* renamed from: component3, reason: from getter */
        public final ParsedToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsThinking() {
            return this.isThinking;
        }

        public final Thinking copy(String planItemId, String reasoningContent, ParsedToolCallInfo toolCallInfo, boolean isThinking) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(reasoningContent, "reasoningContent");
            return new Thinking(planItemId, reasoningContent, toolCallInfo, isThinking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Thinking)) {
                return false;
            }
            Thinking thinking = (Thinking) other;
            return Intrinsics.areEqual(this.planItemId, thinking.planItemId) && Intrinsics.areEqual(this.reasoningContent, thinking.reasoningContent) && Intrinsics.areEqual(this.toolCallInfo, thinking.toolCallInfo) && this.isThinking == thinking.isThinking;
        }

        public int hashCode() {
            int hashCode = ((this.planItemId.hashCode() * 31) + this.reasoningContent.hashCode()) * 31;
            ParsedToolCallInfo parsedToolCallInfo = this.toolCallInfo;
            return ((hashCode + (parsedToolCallInfo == null ? 0 : parsedToolCallInfo.hashCode())) * 31) + Boolean.hashCode(this.isThinking);
        }

        public String toString() {
            return "Thinking(planItemId=" + this.planItemId + ", reasoningContent=" + this.reasoningContent + ", toolCallInfo=" + this.toolCallInfo + ", isThinking=" + this.isThinking + ')';
        }

        public /* synthetic */ Thinking(String str, String str2, ParsedToolCallInfo parsedToolCallInfo, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, parsedToolCallInfo, (i & 8) != 0 ? true : z);
        }

        public final String getPlanItemId() {
            return this.planItemId;
        }

        public final String getReasoningContent() {
            return this.reasoningContent;
        }

        public final ParsedToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        public final boolean isThinking() {
            return this.isThinking;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Thinking(String str, String str2, ParsedToolCallInfo parsedToolCallInfo, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "planItemId");
            Intrinsics.checkNotNullParameter(str2, "reasoningContent");
            this.planItemId = str;
            this.reasoningContent = str2;
            this.toolCallInfo = parsedToolCallInfo;
            this.isThinking = z;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "planItemId", "", "thought", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPlanItemId", "()Ljava/lang/String;", "getThought", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Thought extends AgentContentBlock {
        private final String planItemId;
        private final String thought;

        public static /* synthetic */ Thought copy$default(Thought thought, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = thought.planItemId;
            }
            if ((i & 2) != 0) {
                str2 = thought.thought;
            }
            return thought.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getThought() {
            return this.thought;
        }

        public final Thought copy(String planItemId, String thought) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(thought, "thought");
            return new Thought(planItemId, thought);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Thought)) {
                return false;
            }
            Thought thought = (Thought) other;
            return Intrinsics.areEqual(this.planItemId, thought.planItemId) && Intrinsics.areEqual(this.thought, thought.thought);
        }

        public int hashCode() {
            return (this.planItemId.hashCode() * 31) + this.thought.hashCode();
        }

        public String toString() {
            return "Thought(planItemId=" + this.planItemId + ", thought=" + this.thought + ')';
        }

        public final String getPlanItemId() {
            return this.planItemId;
        }

        public final String getThought() {
            return this.thought;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Thought(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "planItemId");
            Intrinsics.checkNotNullParameter(str2, "thought");
            this.planItemId = str;
            this.thought = str2;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "planItemId", "", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedToolCallInfo;Lcom/bytedance/trae/im/model/ConfirmInfo;)V", "getPlanItemId", "()Ljava/lang/String;", "getToolCallInfo", "()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "getConfirmInfo", "()Lcom/bytedance/trae/im/model/ConfirmInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Toolcall extends AgentContentBlock {
        private final ConfirmInfo confirmInfo;
        private final String planItemId;
        private final ParsedToolCallInfo toolCallInfo;

        public static /* synthetic */ Toolcall copy$default(Toolcall toolcall, String str, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toolcall.planItemId;
            }
            if ((i & 2) != 0) {
                parsedToolCallInfo = toolcall.toolCallInfo;
            }
            if ((i & 4) != 0) {
                confirmInfo = toolcall.confirmInfo;
            }
            return toolcall.copy(str, parsedToolCallInfo, confirmInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPlanItemId() {
            return this.planItemId;
        }

        /* renamed from: component2, reason: from getter */
        public final ParsedToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        /* renamed from: component3, reason: from getter */
        public final ConfirmInfo getConfirmInfo() {
            return this.confirmInfo;
        }

        public final Toolcall copy(String planItemId, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
            Intrinsics.checkNotNullParameter(planItemId, "planItemId");
            Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
            return new Toolcall(planItemId, toolCallInfo, confirmInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Toolcall)) {
                return false;
            }
            Toolcall toolcall = (Toolcall) other;
            return Intrinsics.areEqual(this.planItemId, toolcall.planItemId) && Intrinsics.areEqual(this.toolCallInfo, toolcall.toolCallInfo) && Intrinsics.areEqual(this.confirmInfo, toolcall.confirmInfo);
        }

        public int hashCode() {
            int hashCode = ((this.planItemId.hashCode() * 31) + this.toolCallInfo.hashCode()) * 31;
            ConfirmInfo confirmInfo = this.confirmInfo;
            return hashCode + (confirmInfo == null ? 0 : confirmInfo.hashCode());
        }

        public String toString() {
            return "Toolcall(planItemId=" + this.planItemId + ", toolCallInfo=" + this.toolCallInfo + ", confirmInfo=" + this.confirmInfo + ')';
        }

        public /* synthetic */ Toolcall(String str, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, parsedToolCallInfo, (i & 4) != 0 ? null : confirmInfo);
        }

        public final String getPlanItemId() {
            return this.planItemId;
        }

        public final ParsedToolCallInfo getToolCallInfo() {
            return this.toolCallInfo;
        }

        public final ConfirmInfo getConfirmInfo() {
            return this.confirmInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Toolcall(String str, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "planItemId");
            Intrinsics.checkNotNullParameter(parsedToolCallInfo, "toolCallInfo");
            this.planItemId = str;
            this.toolCallInfo = parsedToolCallInfo;
            this.confirmInfo = confirmInfo;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "groupType", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;", "title", "", "toolcalls", "", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "children", "isCollapsed", "", "groupFinished", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZ)V", "getGroupType", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;", "getTitle", "()Ljava/lang/String;", "getToolcalls", "()Ljava/util/List;", "getChildren", "()Z", "getGroupFinished", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ToolcallGroup extends AgentContentBlock {
        private final List<AgentContentBlock> children;
        private final boolean groupFinished;
        private final GroupType groupType;
        private final boolean isCollapsed;
        private final String title;
        private final List<ParsedToolCallInfo> toolcalls;

        public static /* synthetic */ ToolcallGroup copy$default(ToolcallGroup toolcallGroup, GroupType groupType, String str, List list, List list2, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                groupType = toolcallGroup.groupType;
            }
            if ((i & 2) != 0) {
                str = toolcallGroup.title;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = toolcallGroup.toolcalls;
            }
            List list3 = list;
            if ((i & 8) != 0) {
                list2 = toolcallGroup.children;
            }
            List list4 = list2;
            if ((i & 16) != 0) {
                z = toolcallGroup.isCollapsed;
            }
            boolean z3 = z;
            if ((i & 32) != 0) {
                z2 = toolcallGroup.groupFinished;
            }
            return toolcallGroup.copy(groupType, str2, list3, list4, z3, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final GroupType getGroupType() {
            return this.groupType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<ParsedToolCallInfo> component3() {
            return this.toolcalls;
        }

        public final List<AgentContentBlock> component4() {
            return this.children;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsCollapsed() {
            return this.isCollapsed;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getGroupFinished() {
            return this.groupFinished;
        }

        public final ToolcallGroup copy(GroupType groupType, String title, List<ParsedToolCallInfo> toolcalls, List<? extends AgentContentBlock> children, boolean isCollapsed, boolean groupFinished) {
            Intrinsics.checkNotNullParameter(groupType, "groupType");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(toolcalls, "toolcalls");
            Intrinsics.checkNotNullParameter(children, "children");
            return new ToolcallGroup(groupType, title, toolcalls, children, isCollapsed, groupFinished);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolcallGroup)) {
                return false;
            }
            ToolcallGroup toolcallGroup = (ToolcallGroup) other;
            return this.groupType == toolcallGroup.groupType && Intrinsics.areEqual(this.title, toolcallGroup.title) && Intrinsics.areEqual(this.toolcalls, toolcallGroup.toolcalls) && Intrinsics.areEqual(this.children, toolcallGroup.children) && this.isCollapsed == toolcallGroup.isCollapsed && this.groupFinished == toolcallGroup.groupFinished;
        }

        public int hashCode() {
            return (((((((((this.groupType.hashCode() * 31) + this.title.hashCode()) * 31) + this.toolcalls.hashCode()) * 31) + this.children.hashCode()) * 31) + Boolean.hashCode(this.isCollapsed)) * 31) + Boolean.hashCode(this.groupFinished);
        }

        public String toString() {
            return "ToolcallGroup(groupType=" + this.groupType + ", title=" + this.title + ", toolcalls=" + this.toolcalls + ", children=" + this.children + ", isCollapsed=" + this.isCollapsed + ", groupFinished=" + this.groupFinished + ')';
        }

        public final GroupType getGroupType() {
            return this.groupType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<ParsedToolCallInfo> getToolcalls() {
            return this.toolcalls;
        }

        public /* synthetic */ ToolcallGroup(GroupType groupType, String str, List list, List list2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(groupType, str, list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2);
        }

        public final List<AgentContentBlock> getChildren() {
            return this.children;
        }

        public final boolean isCollapsed() {
            return this.isCollapsed;
        }

        public final boolean getGroupFinished() {
            return this.groupFinished;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ToolcallGroup(GroupType groupType, String str, List<ParsedToolCallInfo> list, List<? extends AgentContentBlock> list2, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(groupType, "groupType");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "toolcalls");
            Intrinsics.checkNotNullParameter(list2, "children");
            this.groupType = groupType;
            this.title = str;
            this.toolcalls = list;
            this.children = list2;
            this.isCollapsed = z;
            this.groupFinished = z2;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "title", "", "toolcalls", "", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "children", "isCollapsed", "", "groupFinished", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZ)V", "getTitle", "()Ljava/lang/String;", "getToolcalls", "()Ljava/util/List;", "getChildren", "()Z", "getGroupFinished", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PureShowWidgetToolcallGroup extends AgentContentBlock {
        private final List<AgentContentBlock> children;
        private final boolean groupFinished;
        private final boolean isCollapsed;
        private final String title;
        private final List<ParsedToolCallInfo> toolcalls;

        public static /* synthetic */ PureShowWidgetToolcallGroup copy$default(PureShowWidgetToolcallGroup pureShowWidgetToolcallGroup, String str, List list, List list2, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pureShowWidgetToolcallGroup.title;
            }
            if ((i & 2) != 0) {
                list = pureShowWidgetToolcallGroup.toolcalls;
            }
            List list3 = list;
            if ((i & 4) != 0) {
                list2 = pureShowWidgetToolcallGroup.children;
            }
            List list4 = list2;
            if ((i & 8) != 0) {
                z = pureShowWidgetToolcallGroup.isCollapsed;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                z2 = pureShowWidgetToolcallGroup.groupFinished;
            }
            return pureShowWidgetToolcallGroup.copy(str, list3, list4, z3, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<ParsedToolCallInfo> component2() {
            return this.toolcalls;
        }

        public final List<AgentContentBlock> component3() {
            return this.children;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsCollapsed() {
            return this.isCollapsed;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getGroupFinished() {
            return this.groupFinished;
        }

        public final PureShowWidgetToolcallGroup copy(String title, List<ParsedToolCallInfo> toolcalls, List<? extends AgentContentBlock> children, boolean isCollapsed, boolean groupFinished) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(toolcalls, "toolcalls");
            Intrinsics.checkNotNullParameter(children, "children");
            return new PureShowWidgetToolcallGroup(title, toolcalls, children, isCollapsed, groupFinished);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PureShowWidgetToolcallGroup)) {
                return false;
            }
            PureShowWidgetToolcallGroup pureShowWidgetToolcallGroup = (PureShowWidgetToolcallGroup) other;
            return Intrinsics.areEqual(this.title, pureShowWidgetToolcallGroup.title) && Intrinsics.areEqual(this.toolcalls, pureShowWidgetToolcallGroup.toolcalls) && Intrinsics.areEqual(this.children, pureShowWidgetToolcallGroup.children) && this.isCollapsed == pureShowWidgetToolcallGroup.isCollapsed && this.groupFinished == pureShowWidgetToolcallGroup.groupFinished;
        }

        public int hashCode() {
            return (((((((this.title.hashCode() * 31) + this.toolcalls.hashCode()) * 31) + this.children.hashCode()) * 31) + Boolean.hashCode(this.isCollapsed)) * 31) + Boolean.hashCode(this.groupFinished);
        }

        public String toString() {
            return "PureShowWidgetToolcallGroup(title=" + this.title + ", toolcalls=" + this.toolcalls + ", children=" + this.children + ", isCollapsed=" + this.isCollapsed + ", groupFinished=" + this.groupFinished + ')';
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<ParsedToolCallInfo> getToolcalls() {
            return this.toolcalls;
        }

        public /* synthetic */ PureShowWidgetToolcallGroup(String str, List list, List list2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2);
        }

        public final List<AgentContentBlock> getChildren() {
            return this.children;
        }

        public final boolean isCollapsed() {
            return this.isCollapsed;
        }

        public final boolean getGroupFinished() {
            return this.groupFinished;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PureShowWidgetToolcallGroup(String str, List<ParsedToolCallInfo> list, List<? extends AgentContentBlock> list2, boolean z, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "toolcalls");
            Intrinsics.checkNotNullParameter(list2, "children");
            this.title = str;
            this.toolcalls = list;
            this.children = list2;
            this.isCollapsed = z;
            this.groupFinished = z2;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "todoWriteId", "", "title", "summary", "children", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V", "getTodoWriteId", "()Ljava/lang/String;", "getTitle", "getSummary", "getChildren", "()Ljava/util/List;", "getStatus", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TodoGroup extends AgentContentBlock {
        private final List<AgentContentBlock> children;
        private final GroupStatus status;
        private final String summary;
        private final String title;
        private final String todoWriteId;

        public static /* synthetic */ TodoGroup copy$default(TodoGroup todoGroup, String str, String str2, String str3, List list, GroupStatus groupStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = todoGroup.todoWriteId;
            }
            if ((i & 2) != 0) {
                str2 = todoGroup.title;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = todoGroup.summary;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                list = todoGroup.children;
            }
            List list2 = list;
            if ((i & 16) != 0) {
                groupStatus = todoGroup.status;
            }
            return todoGroup.copy(str, str4, str5, list2, groupStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTodoWriteId() {
            return this.todoWriteId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public final List<AgentContentBlock> component4() {
            return this.children;
        }

        /* renamed from: component5, reason: from getter */
        public final GroupStatus getStatus() {
            return this.status;
        }

        public final TodoGroup copy(String todoWriteId, String title, String summary, List<? extends AgentContentBlock> children, GroupStatus status) {
            Intrinsics.checkNotNullParameter(todoWriteId, "todoWriteId");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
            return new TodoGroup(todoWriteId, title, summary, children, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TodoGroup)) {
                return false;
            }
            TodoGroup todoGroup = (TodoGroup) other;
            return Intrinsics.areEqual(this.todoWriteId, todoGroup.todoWriteId) && Intrinsics.areEqual(this.title, todoGroup.title) && Intrinsics.areEqual(this.summary, todoGroup.summary) && Intrinsics.areEqual(this.children, todoGroup.children) && this.status == todoGroup.status;
        }

        public int hashCode() {
            int hashCode = this.todoWriteId.hashCode() * 31;
            String str = this.title;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.summary;
            return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.children.hashCode()) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "TodoGroup(todoWriteId=" + this.todoWriteId + ", title=" + this.title + ", summary=" + this.summary + ", children=" + this.children + ", status=" + this.status + ')';
        }

        public final String getTodoWriteId() {
            return this.todoWriteId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final List<AgentContentBlock> getChildren() {
            return this.children;
        }

        public /* synthetic */ TodoGroup(String str, String str2, String str3, List list, GroupStatus groupStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, list, (i & 16) != 0 ? GroupStatus.RUNNING : groupStatus);
        }

        public final GroupStatus getStatus() {
            return this.status;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TodoGroup(String str, String str2, String str3, List<? extends AgentContentBlock> list, GroupStatus groupStatus) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "todoWriteId");
            Intrinsics.checkNotNullParameter(list, "children");
            Intrinsics.checkNotNullParameter(groupStatus, PageDataManager.EXTRA_STATUS);
            this.todoWriteId = str;
            this.title = str2;
            this.summary = str3;
            this.children = list;
            this.status = groupStatus;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "agentRunId", "", "agentId", "agentDisplayName", "description", "children", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "isLastRunningSubAgent", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;Z)V", "getAgentRunId", "()Ljava/lang/String;", "getAgentId", "getAgentDisplayName", "getDescription", "getChildren", "()Ljava/util/List;", "getStatus", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubAgentGroup extends AgentContentBlock {
        private final String agentDisplayName;
        private final String agentId;
        private final String agentRunId;
        private final List<AgentContentBlock> children;
        private final String description;
        private final boolean isLastRunningSubAgent;
        private final GroupStatus status;

        public static /* synthetic */ SubAgentGroup copy$default(SubAgentGroup subAgentGroup, String str, String str2, String str3, String str4, List list, GroupStatus groupStatus, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subAgentGroup.agentRunId;
            }
            if ((i & 2) != 0) {
                str2 = subAgentGroup.agentId;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = subAgentGroup.agentDisplayName;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = subAgentGroup.description;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                list = subAgentGroup.children;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                groupStatus = subAgentGroup.status;
            }
            GroupStatus groupStatus2 = groupStatus;
            if ((i & 64) != 0) {
                z = subAgentGroup.isLastRunningSubAgent;
            }
            return subAgentGroup.copy(str, str5, str6, str7, list2, groupStatus2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAgentRunId() {
            return this.agentRunId;
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
        public final String getDescription() {
            return this.description;
        }

        public final List<AgentContentBlock> component5() {
            return this.children;
        }

        /* renamed from: component6, reason: from getter */
        public final GroupStatus getStatus() {
            return this.status;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsLastRunningSubAgent() {
            return this.isLastRunningSubAgent;
        }

        public final SubAgentGroup copy(String agentRunId, String agentId, String agentDisplayName, String description, List<? extends AgentContentBlock> children, GroupStatus status, boolean isLastRunningSubAgent) {
            Intrinsics.checkNotNullParameter(agentRunId, "agentRunId");
            Intrinsics.checkNotNullParameter(children, "children");
            Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
            return new SubAgentGroup(agentRunId, agentId, agentDisplayName, description, children, status, isLastRunningSubAgent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubAgentGroup)) {
                return false;
            }
            SubAgentGroup subAgentGroup = (SubAgentGroup) other;
            return Intrinsics.areEqual(this.agentRunId, subAgentGroup.agentRunId) && Intrinsics.areEqual(this.agentId, subAgentGroup.agentId) && Intrinsics.areEqual(this.agentDisplayName, subAgentGroup.agentDisplayName) && Intrinsics.areEqual(this.description, subAgentGroup.description) && Intrinsics.areEqual(this.children, subAgentGroup.children) && this.status == subAgentGroup.status && this.isLastRunningSubAgent == subAgentGroup.isLastRunningSubAgent;
        }

        public int hashCode() {
            int hashCode = this.agentRunId.hashCode() * 31;
            String str = this.agentId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.agentDisplayName;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.description;
            return ((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.children.hashCode()) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.isLastRunningSubAgent);
        }

        public String toString() {
            return "SubAgentGroup(agentRunId=" + this.agentRunId + ", agentId=" + this.agentId + ", agentDisplayName=" + this.agentDisplayName + ", description=" + this.description + ", children=" + this.children + ", status=" + this.status + ", isLastRunningSubAgent=" + this.isLastRunningSubAgent + ')';
        }

        public final String getAgentRunId() {
            return this.agentRunId;
        }

        public final String getAgentId() {
            return this.agentId;
        }

        public final String getAgentDisplayName() {
            return this.agentDisplayName;
        }

        public final String getDescription() {
            return this.description;
        }

        public final List<AgentContentBlock> getChildren() {
            return this.children;
        }

        public /* synthetic */ SubAgentGroup(String str, String str2, String str3, String str4, List list, GroupStatus groupStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, list, (i & 32) != 0 ? GroupStatus.RUNNING : groupStatus, (i & 64) != 0 ? false : z);
        }

        public final GroupStatus getStatus() {
            return this.status;
        }

        public final boolean isLastRunningSubAgent() {
            return this.isLastRunningSubAgent;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SubAgentGroup(String str, String str2, String str3, String str4, List<? extends AgentContentBlock> list, GroupStatus groupStatus, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "agentRunId");
            Intrinsics.checkNotNullParameter(list, "children");
            Intrinsics.checkNotNullParameter(groupStatus, PageDataManager.EXTRA_STATUS);
            this.agentRunId = str;
            this.agentId = str2;
            this.agentDisplayName = str3;
            this.description = str4;
            this.children = list;
            this.status = groupStatus;
            this.isLastRunningSubAgent = z;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", ReportConstant.COMMON_CONTENT, "", "finished", "", "trackingId", "webReferences", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getFinished", "()Z", "getTrackingId", "getWebReferences", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Summary extends AgentContentBlock {
        private final String content;
        private final boolean finished;
        private final String trackingId;
        private final List<WebReference> webReferences;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Summary copy$default(Summary summary, String str, boolean z, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = summary.content;
            }
            if ((i & 2) != 0) {
                z = summary.finished;
            }
            if ((i & 4) != 0) {
                str2 = summary.trackingId;
            }
            if ((i & 8) != 0) {
                list = summary.webReferences;
            }
            return summary.copy(str, z, str2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTrackingId() {
            return this.trackingId;
        }

        public final List<WebReference> component4() {
            return this.webReferences;
        }

        public final Summary copy(String content, boolean finished, String trackingId, List<WebReference> webReferences) {
            Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
            return new Summary(content, finished, trackingId, webReferences);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) other;
            return Intrinsics.areEqual(this.content, summary.content) && this.finished == summary.finished && Intrinsics.areEqual(this.trackingId, summary.trackingId) && Intrinsics.areEqual(this.webReferences, summary.webReferences);
        }

        public int hashCode() {
            int hashCode = ((this.content.hashCode() * 31) + Boolean.hashCode(this.finished)) * 31;
            String str = this.trackingId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<WebReference> list = this.webReferences;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Summary(content=" + this.content + ", finished=" + this.finished + ", trackingId=" + this.trackingId + ", webReferences=" + this.webReferences + ')';
        }

        public /* synthetic */ Summary(String str, boolean z, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list);
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final String getTrackingId() {
            return this.trackingId;
        }

        public final List<WebReference> getWebReferences() {
            return this.webReferences;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Summary(String str, boolean z, String str2, List<WebReference> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
            this.content = str;
            this.finished = z;
            this.trackingId = str2;
            this.webReferences = list;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "header", "", "markdown", "bottom", "finished", "", "trackingId", "historySessionId", "conversationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "getMarkdown", "getBottom", "getFinished", "()Z", "getTrackingId", "getHistorySessionId", "getConversationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class VoiceSummary extends AgentContentBlock {
        private final String bottom;
        private final String conversationId;
        private final boolean finished;
        private final String header;
        private final String historySessionId;
        private final String markdown;
        private final String trackingId;

        public static /* synthetic */ VoiceSummary copy$default(VoiceSummary voiceSummary, String str, String str2, String str3, boolean z, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = voiceSummary.header;
            }
            if ((i & 2) != 0) {
                str2 = voiceSummary.markdown;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = voiceSummary.bottom;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                z = voiceSummary.finished;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                str4 = voiceSummary.trackingId;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = voiceSummary.historySessionId;
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                str6 = voiceSummary.conversationId;
            }
            return voiceSummary.copy(str, str7, str8, z2, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getHeader() {
            return this.header;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMarkdown() {
            return this.markdown;
        }

        /* renamed from: component3, reason: from getter */
        public final String getBottom() {
            return this.bottom;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTrackingId() {
            return this.trackingId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getHistorySessionId() {
            return this.historySessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final VoiceSummary copy(String header, String markdown, String bottom, boolean finished, String trackingId, String historySessionId, String conversationId) {
            Intrinsics.checkNotNullParameter(header, "header");
            Intrinsics.checkNotNullParameter(markdown, "markdown");
            Intrinsics.checkNotNullParameter(bottom, "bottom");
            return new VoiceSummary(header, markdown, bottom, finished, trackingId, historySessionId, conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceSummary)) {
                return false;
            }
            VoiceSummary voiceSummary = (VoiceSummary) other;
            return Intrinsics.areEqual(this.header, voiceSummary.header) && Intrinsics.areEqual(this.markdown, voiceSummary.markdown) && Intrinsics.areEqual(this.bottom, voiceSummary.bottom) && this.finished == voiceSummary.finished && Intrinsics.areEqual(this.trackingId, voiceSummary.trackingId) && Intrinsics.areEqual(this.historySessionId, voiceSummary.historySessionId) && Intrinsics.areEqual(this.conversationId, voiceSummary.conversationId);
        }

        public int hashCode() {
            int hashCode = ((((((this.header.hashCode() * 31) + this.markdown.hashCode()) * 31) + this.bottom.hashCode()) * 31) + Boolean.hashCode(this.finished)) * 31;
            String str = this.trackingId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.historySessionId;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.conversationId;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "VoiceSummary(header=" + this.header + ", markdown=" + this.markdown + ", bottom=" + this.bottom + ", finished=" + this.finished + ", trackingId=" + this.trackingId + ", historySessionId=" + this.historySessionId + ", conversationId=" + this.conversationId + ')';
        }

        public /* synthetic */ VoiceSummary(String str, String str2, String str3, boolean z, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
        }

        public final String getHeader() {
            return this.header;
        }

        public final String getMarkdown() {
            return this.markdown;
        }

        public final String getBottom() {
            return this.bottom;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final String getTrackingId() {
            return this.trackingId;
        }

        public final String getHistorySessionId() {
            return this.historySessionId;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VoiceSummary(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "header");
            Intrinsics.checkNotNullParameter(str2, "markdown");
            Intrinsics.checkNotNullParameter(str3, "bottom");
            this.header = str;
            this.markdown = str2;
            this.bottom = str3;
            this.finished = z;
            this.trackingId = str4;
            this.historySessionId = str5;
            this.conversationId = str6;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J[\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006*"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "products", "Lcom/bytedance/trae/im/model/ArtifactData;", "videoArtifacts", "", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", "chatSessionId", "", "turnId", "messageId", "iGetMessage", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "summary", "<init>", "(Lcom/bytedance/trae/im/model/ArtifactData;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/IMessageListener;Ljava/lang/String;)V", "getProducts", "()Lcom/bytedance/trae/im/model/ArtifactData;", "getVideoArtifacts", "()Ljava/util/List;", "getChatSessionId", "()Ljava/lang/String;", "getTurnId", "getMessageId", "getIGetMessage", "()Lcom/bytedance/trae/conversation/chat/IMessageListener;", "getSummary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Artifacts extends AgentContentBlock {
        private final String chatSessionId;
        private final IMessageListener iGetMessage;
        private final String messageId;
        private final ArtifactData products;
        private final String summary;
        private final String turnId;
        private final List<VideoArtifactDescriptor> videoArtifacts;

        public static /* synthetic */ Artifacts copy$default(Artifacts artifacts, ArtifactData artifactData, List list, String str, String str2, String str3, IMessageListener iMessageListener, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                artifactData = artifacts.products;
            }
            if ((i & 2) != 0) {
                list = artifacts.videoArtifacts;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                str = artifacts.chatSessionId;
            }
            String str5 = str;
            if ((i & 8) != 0) {
                str2 = artifacts.turnId;
            }
            String str6 = str2;
            if ((i & 16) != 0) {
                str3 = artifacts.messageId;
            }
            String str7 = str3;
            if ((i & 32) != 0) {
                iMessageListener = artifacts.iGetMessage;
            }
            IMessageListener iMessageListener2 = iMessageListener;
            if ((i & 64) != 0) {
                str4 = artifacts.summary;
            }
            return artifacts.copy(artifactData, list2, str5, str6, str7, iMessageListener2, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final ArtifactData getProducts() {
            return this.products;
        }

        public final List<VideoArtifactDescriptor> component2() {
            return this.videoArtifacts;
        }

        /* renamed from: component3, reason: from getter */
        public final String getChatSessionId() {
            return this.chatSessionId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTurnId() {
            return this.turnId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: component6, reason: from getter */
        public final IMessageListener getIGetMessage() {
            return this.iGetMessage;
        }

        /* renamed from: component7, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public final Artifacts copy(ArtifactData products, List<VideoArtifactDescriptor> videoArtifacts, String chatSessionId, String turnId, String messageId, IMessageListener iGetMessage, String summary) {
            Intrinsics.checkNotNullParameter(videoArtifacts, "videoArtifacts");
            Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
            Intrinsics.checkNotNullParameter(turnId, "turnId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            return new Artifacts(products, videoArtifacts, chatSessionId, turnId, messageId, iGetMessage, summary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Artifacts)) {
                return false;
            }
            Artifacts artifacts = (Artifacts) other;
            return Intrinsics.areEqual(this.products, artifacts.products) && Intrinsics.areEqual(this.videoArtifacts, artifacts.videoArtifacts) && Intrinsics.areEqual(this.chatSessionId, artifacts.chatSessionId) && Intrinsics.areEqual(this.turnId, artifacts.turnId) && Intrinsics.areEqual(this.messageId, artifacts.messageId) && Intrinsics.areEqual(this.iGetMessage, artifacts.iGetMessage) && Intrinsics.areEqual(this.summary, artifacts.summary);
        }

        public int hashCode() {
            ArtifactData artifactData = this.products;
            int hashCode = (((((((((artifactData == null ? 0 : artifactData.hashCode()) * 31) + this.videoArtifacts.hashCode()) * 31) + this.chatSessionId.hashCode()) * 31) + this.turnId.hashCode()) * 31) + this.messageId.hashCode()) * 31;
            IMessageListener iMessageListener = this.iGetMessage;
            int hashCode2 = (hashCode + (iMessageListener == null ? 0 : iMessageListener.hashCode())) * 31;
            String str = this.summary;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Artifacts(products=" + this.products + ", videoArtifacts=" + this.videoArtifacts + ", chatSessionId=" + this.chatSessionId + ", turnId=" + this.turnId + ", messageId=" + this.messageId + ", iGetMessage=" + this.iGetMessage + ", summary=" + this.summary + ')';
        }

        public final ArtifactData getProducts() {
            return this.products;
        }

        public /* synthetic */ Artifacts(ArtifactData artifactData, List list, String str, String str2, String str3, IMessageListener iMessageListener, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(artifactData, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, str3, iMessageListener, (i & 64) != 0 ? null : str4);
        }

        public final List<VideoArtifactDescriptor> getVideoArtifacts() {
            return this.videoArtifacts;
        }

        public final String getChatSessionId() {
            return this.chatSessionId;
        }

        public final String getTurnId() {
            return this.turnId;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final IMessageListener getIGetMessage() {
            return this.iGetMessage;
        }

        public final String getSummary() {
            return this.summary;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Artifacts(ArtifactData artifactData, List<VideoArtifactDescriptor> list, String str, String str2, String str3, IMessageListener iMessageListener, String str4) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "videoArtifacts");
            Intrinsics.checkNotNullParameter(str, "chatSessionId");
            Intrinsics.checkNotNullParameter(str2, "turnId");
            Intrinsics.checkNotNullParameter(str3, "messageId");
            this.products = artifactData;
            this.videoArtifacts = list;
            this.chatSessionId = str;
            this.turnId = str2;
            this.messageId = str3;
            this.iGetMessage = iMessageListener;
            this.summary = str4;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "THUMBS_UP", "THUMBS_DOWN", "COPY", "RETRY", "MORE", "USER_ERPRESS_PASS_WHEN_ERROR", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActionType[] $VALUES;
        public static final ActionType THUMBS_UP = new ActionType("THUMBS_UP", 0);
        public static final ActionType THUMBS_DOWN = new ActionType("THUMBS_DOWN", 1);
        public static final ActionType COPY = new ActionType("COPY", 2);
        public static final ActionType RETRY = new ActionType("RETRY", 3);
        public static final ActionType MORE = new ActionType("MORE", 4);
        public static final ActionType USER_ERPRESS_PASS_WHEN_ERROR = new ActionType("USER_ERPRESS_PASS_WHEN_ERROR", 5);

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{THUMBS_UP, THUMBS_DOWN, COPY, RETRY, MORE, USER_ERPRESS_PASS_WHEN_ERROR};
        }

        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }

        static {
            ActionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ActionType(String str, int i) {
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "THUMBS_UP", "THUMBS_DOWN", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FeedbackState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FeedbackState[] $VALUES;
        public static final FeedbackState NONE = new FeedbackState("NONE", 0);
        public static final FeedbackState THUMBS_UP = new FeedbackState("THUMBS_UP", 1);
        public static final FeedbackState THUMBS_DOWN = new FeedbackState("THUMBS_DOWN", 2);

        private static final /* synthetic */ FeedbackState[] $values() {
            return new FeedbackState[]{NONE, THUMBS_UP, THUMBS_DOWN};
        }

        public static EnumEntries<FeedbackState> getEntries() {
            return $ENTRIES;
        }

        static {
            FeedbackState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FeedbackState(String str, int i) {
        }

        public static FeedbackState valueOf(String str) {
            return (FeedbackState) Enum.valueOf(FeedbackState.class, str);
        }

        public static FeedbackState[] values() {
            return (FeedbackState[]) $VALUES.clone();
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010HÆ\u0003J\u0086\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0007\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001fR\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", PageDataManager.EXTRA_STATUS, "", "messageId", "tokenUsage", "Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "isUserCanceled", "", "feedbackState", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "showFeedback", "showManualStopStatus", "showInterjectedStatus", "isVoiceSummaryStyle", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedTokenUsage;Ljava/lang/Boolean;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;ZZZZLkotlin/jvm/functions/Function1;)V", "getStatus", "()Ljava/lang/String;", "getMessageId", "getTokenUsage", "()Lcom/bytedance/trae/im/model/ParsedTokenUsage;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFeedbackState", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "getShowFeedback", "()Z", "getShowManualStopStatus", "getShowInterjectedStatus", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedTokenUsage;Ljava/lang/Boolean;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;ZZZZLkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ActionBar extends AgentContentBlock {
        private final FeedbackState feedbackState;
        private final Boolean isUserCanceled;
        private final boolean isVoiceSummaryStyle;
        private final String messageId;
        private final transient Function1<ActionType, Unit> onActionClick;
        private final boolean showFeedback;
        private final boolean showInterjectedStatus;
        private final boolean showManualStopStatus;
        private final String status;
        private final ParsedTokenUsage tokenUsage;

        /* renamed from: component1, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public final Function1<ActionType, Unit> component10() {
            return this.onActionClick;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: component3, reason: from getter */
        public final ParsedTokenUsage getTokenUsage() {
            return this.tokenUsage;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getIsUserCanceled() {
            return this.isUserCanceled;
        }

        /* renamed from: component5, reason: from getter */
        public final FeedbackState getFeedbackState() {
            return this.feedbackState;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getShowFeedback() {
            return this.showFeedback;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getShowManualStopStatus() {
            return this.showManualStopStatus;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getShowInterjectedStatus() {
            return this.showInterjectedStatus;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsVoiceSummaryStyle() {
            return this.isVoiceSummaryStyle;
        }

        public final ActionBar copy(String status, String messageId, ParsedTokenUsage tokenUsage, Boolean isUserCanceled, FeedbackState feedbackState, boolean showFeedback, boolean showManualStopStatus, boolean showInterjectedStatus, boolean isVoiceSummaryStyle, Function1<? super ActionType, Unit> onActionClick) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(feedbackState, "feedbackState");
            return new ActionBar(status, messageId, tokenUsage, isUserCanceled, feedbackState, showFeedback, showManualStopStatus, showInterjectedStatus, isVoiceSummaryStyle, onActionClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionBar)) {
                return false;
            }
            ActionBar actionBar = (ActionBar) other;
            return Intrinsics.areEqual(this.status, actionBar.status) && Intrinsics.areEqual(this.messageId, actionBar.messageId) && Intrinsics.areEqual(this.tokenUsage, actionBar.tokenUsage) && Intrinsics.areEqual(this.isUserCanceled, actionBar.isUserCanceled) && this.feedbackState == actionBar.feedbackState && this.showFeedback == actionBar.showFeedback && this.showManualStopStatus == actionBar.showManualStopStatus && this.showInterjectedStatus == actionBar.showInterjectedStatus && this.isVoiceSummaryStyle == actionBar.isVoiceSummaryStyle && Intrinsics.areEqual(this.onActionClick, actionBar.onActionClick);
        }

        public int hashCode() {
            String str = this.status;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.messageId.hashCode()) * 31;
            ParsedTokenUsage parsedTokenUsage = this.tokenUsage;
            int hashCode2 = (hashCode + (parsedTokenUsage == null ? 0 : parsedTokenUsage.hashCode())) * 31;
            Boolean bool = this.isUserCanceled;
            int hashCode3 = (((((((((((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.feedbackState.hashCode()) * 31) + Boolean.hashCode(this.showFeedback)) * 31) + Boolean.hashCode(this.showManualStopStatus)) * 31) + Boolean.hashCode(this.showInterjectedStatus)) * 31) + Boolean.hashCode(this.isVoiceSummaryStyle)) * 31;
            Function1<ActionType, Unit> function1 = this.onActionClick;
            return hashCode3 + (function1 != null ? function1.hashCode() : 0);
        }

        public String toString() {
            return "ActionBar(status=" + this.status + ", messageId=" + this.messageId + ", tokenUsage=" + this.tokenUsage + ", isUserCanceled=" + this.isUserCanceled + ", feedbackState=" + this.feedbackState + ", showFeedback=" + this.showFeedback + ", showManualStopStatus=" + this.showManualStopStatus + ", showInterjectedStatus=" + this.showInterjectedStatus + ", isVoiceSummaryStyle=" + this.isVoiceSummaryStyle + ", onActionClick=" + this.onActionClick + ')';
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final ParsedTokenUsage getTokenUsage() {
            return this.tokenUsage;
        }

        public final Boolean isUserCanceled() {
            return this.isUserCanceled;
        }

        public /* synthetic */ ActionBar(String str, String str2, ParsedTokenUsage parsedTokenUsage, Boolean bool, FeedbackState feedbackState, boolean z, boolean z2, boolean z3, boolean z4, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, parsedTokenUsage, bool, (i & 16) != 0 ? FeedbackState.NONE : feedbackState, (i & 32) != 0 ? true : z, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? false : z4, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : function1);
        }

        public final FeedbackState getFeedbackState() {
            return this.feedbackState;
        }

        public final boolean getShowFeedback() {
            return this.showFeedback;
        }

        public final boolean getShowManualStopStatus() {
            return this.showManualStopStatus;
        }

        public final boolean getShowInterjectedStatus() {
            return this.showInterjectedStatus;
        }

        public final boolean isVoiceSummaryStyle() {
            return this.isVoiceSummaryStyle;
        }

        public final Function1<ActionType, Unit> getOnActionClick() {
            return this.onActionClick;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ActionBar(String str, String str2, ParsedTokenUsage parsedTokenUsage, Boolean bool, FeedbackState feedbackState, boolean z, boolean z2, boolean z3, boolean z4, Function1<? super ActionType, Unit> function1) {
            super(null);
            Intrinsics.checkNotNullParameter(str2, "messageId");
            Intrinsics.checkNotNullParameter(feedbackState, "feedbackState");
            this.status = str;
            this.messageId = str2;
            this.tokenUsage = parsedTokenUsage;
            this.isUserCanceled = bool;
            this.feedbackState = feedbackState;
            this.showFeedback = z;
            this.showManualStopStatus = z2;
            this.showInterjectedStatus = z3;
            this.isVoiceSummaryStyle = z4;
            this.onActionClick = function1;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "conversationId", "", "onClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getConversationId", "()Ljava/lang/String;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class UpgradeReminder extends AgentContentBlock {
        private final String conversationId;
        private final transient Function1<String, Unit> onClick;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpgradeReminder copy$default(UpgradeReminder upgradeReminder, String str, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = upgradeReminder.conversationId;
            }
            if ((i & 2) != 0) {
                function1 = upgradeReminder.onClick;
            }
            return upgradeReminder.copy(str, function1);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final Function1<String, Unit> component2() {
            return this.onClick;
        }

        public final UpgradeReminder copy(String conversationId, Function1<? super String, Unit> onClick) {
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            return new UpgradeReminder(conversationId, onClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpgradeReminder)) {
                return false;
            }
            UpgradeReminder upgradeReminder = (UpgradeReminder) other;
            return Intrinsics.areEqual(this.conversationId, upgradeReminder.conversationId) && Intrinsics.areEqual(this.onClick, upgradeReminder.onClick);
        }

        public int hashCode() {
            int hashCode = this.conversationId.hashCode() * 31;
            Function1<String, Unit> function1 = this.onClick;
            return hashCode + (function1 == null ? 0 : function1.hashCode());
        }

        public String toString() {
            return "UpgradeReminder(conversationId=" + this.conversationId + ", onClick=" + this.onClick + ')';
        }

        public /* synthetic */ UpgradeReminder(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : function1);
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        public final Function1<String, Unit> getOnClick() {
            return this.onClick;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public UpgradeReminder(String str, Function1<? super String, Unit> function1) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "conversationId");
            this.conversationId = str;
            this.onClick = function1;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "error", "Lcom/bytedance/trae/im/model/ParsedError;", "displayMessage", "", "level", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "displayTitle", "showInfoIcon", "", "<init>", "(Lcom/bytedance/trae/im/model/ParsedError;Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;Ljava/lang/String;Z)V", "getError", "()Lcom/bytedance/trae/im/model/ParsedError;", "getDisplayMessage", "()Ljava/lang/String;", "getLevel", "()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "getDisplayTitle", "getShowInfoIcon", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Error extends AgentContentBlock {
        private final String displayMessage;
        private final String displayTitle;
        private final ParsedError error;
        private final AgentErrorLevel level;
        private final boolean showInfoIcon;

        public static /* synthetic */ Error copy$default(Error error, ParsedError parsedError, String str, AgentErrorLevel agentErrorLevel, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                parsedError = error.error;
            }
            if ((i & 2) != 0) {
                str = error.displayMessage;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                agentErrorLevel = error.level;
            }
            AgentErrorLevel agentErrorLevel2 = agentErrorLevel;
            if ((i & 8) != 0) {
                str2 = error.displayTitle;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                z = error.showInfoIcon;
            }
            return error.copy(parsedError, str3, agentErrorLevel2, str4, z);
        }

        /* renamed from: component1, reason: from getter */
        public final ParsedError getError() {
            return this.error;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDisplayMessage() {
            return this.displayMessage;
        }

        /* renamed from: component3, reason: from getter */
        public final AgentErrorLevel getLevel() {
            return this.level;
        }

        /* renamed from: component4, reason: from getter */
        public final String getDisplayTitle() {
            return this.displayTitle;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShowInfoIcon() {
            return this.showInfoIcon;
        }

        public final Error copy(ParsedError error, String displayMessage, AgentErrorLevel level, String displayTitle, boolean showInfoIcon) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
            Intrinsics.checkNotNullParameter(level, "level");
            return new Error(error, displayMessage, level, displayTitle, showInfoIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.error, error.error) && Intrinsics.areEqual(this.displayMessage, error.displayMessage) && this.level == error.level && Intrinsics.areEqual(this.displayTitle, error.displayTitle) && this.showInfoIcon == error.showInfoIcon;
        }

        public int hashCode() {
            int hashCode = ((((this.error.hashCode() * 31) + this.displayMessage.hashCode()) * 31) + this.level.hashCode()) * 31;
            String str = this.displayTitle;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.showInfoIcon);
        }

        public String toString() {
            return "Error(error=" + this.error + ", displayMessage=" + this.displayMessage + ", level=" + this.level + ", displayTitle=" + this.displayTitle + ", showInfoIcon=" + this.showInfoIcon + ')';
        }

        public /* synthetic */ Error(ParsedError parsedError, String str, AgentErrorLevel agentErrorLevel, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsedError, str, agentErrorLevel, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z);
        }

        public final ParsedError getError() {
            return this.error;
        }

        public final String getDisplayMessage() {
            return this.displayMessage;
        }

        public final AgentErrorLevel getLevel() {
            return this.level;
        }

        public final String getDisplayTitle() {
            return this.displayTitle;
        }

        public final boolean getShowInfoIcon() {
            return this.showInfoIcon;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(ParsedError parsedError, String str, AgentErrorLevel agentErrorLevel, String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(parsedError, "error");
            Intrinsics.checkNotNullParameter(str, "displayMessage");
            Intrinsics.checkNotNullParameter(agentErrorLevel, "level");
            this.error = parsedError;
            this.displayMessage = str;
            this.level = agentErrorLevel;
            this.displayTitle = str2;
            this.showInfoIcon = z;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "error", "Lcom/bytedance/trae/im/model/ParsedError;", "isLatestAgent", "", "originMessage", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;", "", "<init>", "(Lcom/bytedance/trae/im/model/ParsedError;ZLcom/bytedance/trae/im/model/ParsedChatMessage;Lkotlin/jvm/functions/Function1;)V", "getError", "()Lcom/bytedance/trae/im/model/ParsedError;", "()Z", "getOriginMessage", "()Lcom/bytedance/trae/im/model/ParsedChatMessage;", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FreeActivityQuotaError extends AgentContentBlock {
        private final ParsedError error;
        private final boolean isLatestAgent;
        private final transient Function1<ActionType, Unit> onActionClick;
        private final ParsedChatMessage originMessage;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FreeActivityQuotaError copy$default(FreeActivityQuotaError freeActivityQuotaError, ParsedError parsedError, boolean z, ParsedChatMessage parsedChatMessage, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                parsedError = freeActivityQuotaError.error;
            }
            if ((i & 2) != 0) {
                z = freeActivityQuotaError.isLatestAgent;
            }
            if ((i & 4) != 0) {
                parsedChatMessage = freeActivityQuotaError.originMessage;
            }
            if ((i & 8) != 0) {
                function1 = freeActivityQuotaError.onActionClick;
            }
            return freeActivityQuotaError.copy(parsedError, z, parsedChatMessage, function1);
        }

        /* renamed from: component1, reason: from getter */
        public final ParsedError getError() {
            return this.error;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsLatestAgent() {
            return this.isLatestAgent;
        }

        /* renamed from: component3, reason: from getter */
        public final ParsedChatMessage getOriginMessage() {
            return this.originMessage;
        }

        public final Function1<ActionType, Unit> component4() {
            return this.onActionClick;
        }

        public final FreeActivityQuotaError copy(ParsedError error, boolean isLatestAgent, ParsedChatMessage originMessage, Function1<? super ActionType, Unit> onActionClick) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(originMessage, "originMessage");
            return new FreeActivityQuotaError(error, isLatestAgent, originMessage, onActionClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FreeActivityQuotaError)) {
                return false;
            }
            FreeActivityQuotaError freeActivityQuotaError = (FreeActivityQuotaError) other;
            return Intrinsics.areEqual(this.error, freeActivityQuotaError.error) && this.isLatestAgent == freeActivityQuotaError.isLatestAgent && Intrinsics.areEqual(this.originMessage, freeActivityQuotaError.originMessage) && Intrinsics.areEqual(this.onActionClick, freeActivityQuotaError.onActionClick);
        }

        public int hashCode() {
            int hashCode = ((((this.error.hashCode() * 31) + Boolean.hashCode(this.isLatestAgent)) * 31) + this.originMessage.hashCode()) * 31;
            Function1<ActionType, Unit> function1 = this.onActionClick;
            return hashCode + (function1 == null ? 0 : function1.hashCode());
        }

        public String toString() {
            return "FreeActivityQuotaError(error=" + this.error + ", isLatestAgent=" + this.isLatestAgent + ", originMessage=" + this.originMessage + ", onActionClick=" + this.onActionClick + ')';
        }

        public /* synthetic */ FreeActivityQuotaError(ParsedError parsedError, boolean z, ParsedChatMessage parsedChatMessage, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(parsedError, (i & 2) != 0 ? false : z, parsedChatMessage, (i & 8) != 0 ? null : function1);
        }

        public final ParsedError getError() {
            return this.error;
        }

        public final boolean isLatestAgent() {
            return this.isLatestAgent;
        }

        public final ParsedChatMessage getOriginMessage() {
            return this.originMessage;
        }

        public final Function1<ActionType, Unit> getOnActionClick() {
            return this.onActionClick;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FreeActivityQuotaError(ParsedError parsedError, boolean z, ParsedChatMessage parsedChatMessage, Function1<? super ActionType, Unit> function1) {
            super(null);
            Intrinsics.checkNotNullParameter(parsedError, "error");
            Intrinsics.checkNotNullParameter(parsedChatMessage, "originMessage");
            this.error = parsedError;
            this.isLatestAgent = z;
            this.originMessage = parsedChatMessage;
            this.onActionClick = function1;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "tailStatus", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;)V", "getTailStatus", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Loading extends AgentContentBlock {
        private final TailStatus tailStatus;

        public static /* synthetic */ Loading copy$default(Loading loading, TailStatus tailStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                tailStatus = loading.tailStatus;
            }
            return loading.copy(tailStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final TailStatus getTailStatus() {
            return this.tailStatus;
        }

        public final Loading copy(TailStatus tailStatus) {
            Intrinsics.checkNotNullParameter(tailStatus, "tailStatus");
            return new Loading(tailStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && this.tailStatus == ((Loading) other).tailStatus;
        }

        public int hashCode() {
            return this.tailStatus.hashCode();
        }

        public String toString() {
            return "Loading(tailStatus=" + this.tailStatus + ')';
        }

        public final TailStatus getTailStatus() {
            return this.tailStatus;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(TailStatus tailStatus) {
            super(null);
            Intrinsics.checkNotNullParameter(tailStatus, "tailStatus");
            this.tailStatus = tailStatus;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "isUserCanceled", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CancelBanner extends AgentContentBlock {
        private final boolean isUserCanceled;

        public static /* synthetic */ CancelBanner copy$default(CancelBanner cancelBanner, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = cancelBanner.isUserCanceled;
            }
            return cancelBanner.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsUserCanceled() {
            return this.isUserCanceled;
        }

        public final CancelBanner copy(boolean isUserCanceled) {
            return new CancelBanner(isUserCanceled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CancelBanner) && this.isUserCanceled == ((CancelBanner) other).isUserCanceled;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isUserCanceled);
        }

        public String toString() {
            return "CancelBanner(isUserCanceled=" + this.isUserCanceled + ')';
        }

        public final boolean isUserCanceled() {
            return this.isUserCanceled;
        }

        public CancelBanner(boolean z) {
            super(null);
            this.isUserCanceled = z;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", NewTaskTracker.Param.POSITION, "", "noticeTitle", "", "message", "originMessage", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "fastRequestEvent", "Lcom/bytedance/trae/im/service/FastRequestEvent;", "queueId", "requestUUid", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/model/ParsedChatMessage;Lcom/bytedance/trae/im/service/FastRequestEvent;Ljava/lang/String;Ljava/lang/String;)V", "getPosition", "()I", "getNoticeTitle", "()Ljava/lang/String;", "getMessage", "getOriginMessage", "()Lcom/bytedance/trae/im/model/ParsedChatMessage;", "getFastRequestEvent", "()Lcom/bytedance/trae/im/service/FastRequestEvent;", "getQueueId", "getRequestUUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Queuing extends AgentContentBlock {
        private final FastRequestEvent fastRequestEvent;
        private final String message;
        private final String noticeTitle;
        private final ParsedChatMessage originMessage;
        private final int position;
        private final String queueId;
        private final String requestUUid;

        public static /* synthetic */ Queuing copy$default(Queuing queuing, int i, String str, String str2, ParsedChatMessage parsedChatMessage, FastRequestEvent fastRequestEvent, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = queuing.position;
            }
            if ((i2 & 2) != 0) {
                str = queuing.noticeTitle;
            }
            String str5 = str;
            if ((i2 & 4) != 0) {
                str2 = queuing.message;
            }
            String str6 = str2;
            if ((i2 & 8) != 0) {
                parsedChatMessage = queuing.originMessage;
            }
            ParsedChatMessage parsedChatMessage2 = parsedChatMessage;
            if ((i2 & 16) != 0) {
                fastRequestEvent = queuing.fastRequestEvent;
            }
            FastRequestEvent fastRequestEvent2 = fastRequestEvent;
            if ((i2 & 32) != 0) {
                str3 = queuing.queueId;
            }
            String str7 = str3;
            if ((i2 & 64) != 0) {
                str4 = queuing.requestUUid;
            }
            return queuing.copy(i, str5, str6, parsedChatMessage2, fastRequestEvent2, str7, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNoticeTitle() {
            return this.noticeTitle;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final ParsedChatMessage getOriginMessage() {
            return this.originMessage;
        }

        /* renamed from: component5, reason: from getter */
        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        /* renamed from: component6, reason: from getter */
        public final String getQueueId() {
            return this.queueId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getRequestUUid() {
            return this.requestUUid;
        }

        public final Queuing copy(int position, String noticeTitle, String message, ParsedChatMessage originMessage, FastRequestEvent fastRequestEvent, String queueId, String requestUUid) {
            Intrinsics.checkNotNullParameter(originMessage, "originMessage");
            return new Queuing(position, noticeTitle, message, originMessage, fastRequestEvent, queueId, requestUUid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Queuing)) {
                return false;
            }
            Queuing queuing = (Queuing) other;
            return this.position == queuing.position && Intrinsics.areEqual(this.noticeTitle, queuing.noticeTitle) && Intrinsics.areEqual(this.message, queuing.message) && Intrinsics.areEqual(this.originMessage, queuing.originMessage) && Intrinsics.areEqual(this.fastRequestEvent, queuing.fastRequestEvent) && Intrinsics.areEqual(this.queueId, queuing.queueId) && Intrinsics.areEqual(this.requestUUid, queuing.requestUUid);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.position) * 31;
            String str = this.noticeTitle;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.message;
            int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.originMessage.hashCode()) * 31;
            FastRequestEvent fastRequestEvent = this.fastRequestEvent;
            int hashCode4 = (hashCode3 + (fastRequestEvent == null ? 0 : fastRequestEvent.hashCode())) * 31;
            String str3 = this.queueId;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.requestUUid;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Queuing(position=" + this.position + ", noticeTitle=" + this.noticeTitle + ", message=" + this.message + ", originMessage=" + this.originMessage + ", fastRequestEvent=" + this.fastRequestEvent + ", queueId=" + this.queueId + ", requestUUid=" + this.requestUUid + ')';
        }

        public /* synthetic */ Queuing(int i, String str, String str2, ParsedChatMessage parsedChatMessage, FastRequestEvent fastRequestEvent, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, parsedChatMessage, (i2 & 16) != 0 ? null : fastRequestEvent, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4);
        }

        public final int getPosition() {
            return this.position;
        }

        public final String getNoticeTitle() {
            return this.noticeTitle;
        }

        public final String getMessage() {
            return this.message;
        }

        public final ParsedChatMessage getOriginMessage() {
            return this.originMessage;
        }

        public final FastRequestEvent getFastRequestEvent() {
            return this.fastRequestEvent;
        }

        public final String getQueueId() {
            return this.queueId;
        }

        public final String getRequestUUid() {
            return this.requestUUid;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Queuing(int i, String str, String str2, ParsedChatMessage parsedChatMessage, FastRequestEvent fastRequestEvent, String str3, String str4) {
            super(null);
            Intrinsics.checkNotNullParameter(parsedChatMessage, "originMessage");
            this.position = i;
            this.noticeTitle = str;
            this.message = str2;
            this.originMessage = parsedChatMessage;
            this.fastRequestEvent = fastRequestEvent;
            this.queueId = str3;
            this.requestUUid = str4;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class InitialLoading extends AgentContentBlock {
        public static final InitialLoading INSTANCE = new InitialLoading();

        private InitialLoading() {
            super(null);
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class VoiceSummaryLoading extends AgentContentBlock {
        public static final VoiceSummaryLoading INSTANCE = new VoiceSummaryLoading();

        private VoiceSummaryLoading() {
            super(null);
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessStart;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ProcessStart extends AgentContentBlock {
        public static final ProcessStart INSTANCE = new ProcessStart();

        private ProcessStart() {
            super(null);
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "durationMs", "", "isCompleted", "", "autoCollapse", "<init>", "(JZZ)V", "getDurationMs", "()J", "()Z", "getAutoCollapse", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ProcessEnd extends AgentContentBlock {
        private final boolean autoCollapse;
        private final long durationMs;
        private final boolean isCompleted;

        public static /* synthetic */ ProcessEnd copy$default(ProcessEnd processEnd, long j, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = processEnd.durationMs;
            }
            if ((i & 2) != 0) {
                z = processEnd.isCompleted;
            }
            if ((i & 4) != 0) {
                z2 = processEnd.autoCollapse;
            }
            return processEnd.copy(j, z, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDurationMs() {
            return this.durationMs;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsCompleted() {
            return this.isCompleted;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutoCollapse() {
            return this.autoCollapse;
        }

        public final ProcessEnd copy(long durationMs, boolean isCompleted, boolean autoCollapse) {
            return new ProcessEnd(durationMs, isCompleted, autoCollapse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessEnd)) {
                return false;
            }
            ProcessEnd processEnd = (ProcessEnd) other;
            return this.durationMs == processEnd.durationMs && this.isCompleted == processEnd.isCompleted && this.autoCollapse == processEnd.autoCollapse;
        }

        public int hashCode() {
            return (((Long.hashCode(this.durationMs) * 31) + Boolean.hashCode(this.isCompleted)) * 31) + Boolean.hashCode(this.autoCollapse);
        }

        public String toString() {
            return "ProcessEnd(durationMs=" + this.durationMs + ", isCompleted=" + this.isCompleted + ", autoCollapse=" + this.autoCollapse + ')';
        }

        public /* synthetic */ ProcessEnd(long j, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, z, (i & 4) != 0 ? true : z2);
        }

        public final long getDurationMs() {
            return this.durationMs;
        }

        public final boolean isCompleted() {
            return this.isCompleted;
        }

        public final boolean getAutoCollapse() {
            return this.autoCollapse;
        }

        public ProcessEnd(long j, boolean z, boolean z2) {
            super(null);
            this.durationMs = j;
            this.isCompleted = z;
            this.autoCollapse = z2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;", "", "<init>", "(Ljava/lang/String;I)V", "EXPLORE", "BROWSER", "TODO", "SUB_AGENT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class GroupType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GroupType[] $VALUES;
        public static final GroupType EXPLORE = new GroupType("EXPLORE", 0);
        public static final GroupType BROWSER = new GroupType("BROWSER", 1);
        public static final GroupType TODO = new GroupType("TODO", 2);
        public static final GroupType SUB_AGENT = new GroupType("SUB_AGENT", 3);

        private static final /* synthetic */ GroupType[] $values() {
            return new GroupType[]{EXPLORE, BROWSER, TODO, SUB_AGENT};
        }

        public static EnumEntries<GroupType> getEntries() {
            return $ENTRIES;
        }

        static {
            GroupType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private GroupType(String str, int i) {
        }

        public static GroupType valueOf(String str) {
            return (GroupType) Enum.valueOf(GroupType.class, str);
        }

        public static GroupType[] values() {
            return (GroupType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "COMPLETED", "FAILED", "CANCELED", "WAITING_CONFIRM", "INTERJECTED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class GroupStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GroupStatus[] $VALUES;
        public static final GroupStatus RUNNING = new GroupStatus("RUNNING", 0);
        public static final GroupStatus COMPLETED = new GroupStatus("COMPLETED", 1);
        public static final GroupStatus FAILED = new GroupStatus("FAILED", 2);
        public static final GroupStatus CANCELED = new GroupStatus("CANCELED", 3);
        public static final GroupStatus WAITING_CONFIRM = new GroupStatus("WAITING_CONFIRM", 4);
        public static final GroupStatus INTERJECTED = new GroupStatus("INTERJECTED", 5);

        private static final /* synthetic */ GroupStatus[] $values() {
            return new GroupStatus[]{RUNNING, COMPLETED, FAILED, CANCELED, WAITING_CONFIRM, INTERJECTED};
        }

        public static EnumEntries<GroupStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            GroupStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private GroupStatus(String str, int i) {
        }

        public static GroupStatus valueOf(String str) {
            return (GroupStatus) Enum.valueOf(GroupStatus.class, str);
        }

        public static GroupStatus[] values() {
            return (GroupStatus[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;", "", "<init>", "(Ljava/lang/String;I)V", "THINKING", "PENDING", "GENERATING_CODE", "COMMAND_RUNNING", "SUCCESS", "FAILED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class TailStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TailStatus[] $VALUES;
        public static final TailStatus THINKING = new TailStatus("THINKING", 0);
        public static final TailStatus PENDING = new TailStatus("PENDING", 1);
        public static final TailStatus GENERATING_CODE = new TailStatus("GENERATING_CODE", 2);
        public static final TailStatus COMMAND_RUNNING = new TailStatus("COMMAND_RUNNING", 3);
        public static final TailStatus SUCCESS = new TailStatus("SUCCESS", 4);
        public static final TailStatus FAILED = new TailStatus("FAILED", 5);

        private static final /* synthetic */ TailStatus[] $values() {
            return new TailStatus[]{THINKING, PENDING, GENERATING_CODE, COMMAND_RUNNING, SUCCESS, FAILED};
        }

        public static EnumEntries<TailStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            TailStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private TailStatus(String str, int i) {
        }

        public static TailStatus valueOf(String str) {
            return (TailStatus) Enum.valueOf(TailStatus.class, str);
        }

        public static TailStatus[] values() {
            return (TailStatus[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardActionType;", "", "<init>", "(Ljava/lang/String;I)V", "DEEPLINK", "URL", "DISMISS", "CUSTOM", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CardActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CardActionType[] $VALUES;
        public static final CardActionType DEEPLINK = new CardActionType("DEEPLINK", 0);
        public static final CardActionType URL = new CardActionType("URL", 1);
        public static final CardActionType DISMISS = new CardActionType("DISMISS", 2);
        public static final CardActionType CUSTOM = new CardActionType("CUSTOM", 3);

        private static final /* synthetic */ CardActionType[] $values() {
            return new CardActionType[]{DEEPLINK, URL, DISMISS, CUSTOM};
        }

        public static EnumEntries<CardActionType> getEntries() {
            return $ENTRIES;
        }

        static {
            CardActionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CardActionType(String str, int i) {
        }

        public static CardActionType valueOf(String str) {
            return (CardActionType) Enum.valueOf(CardActionType.class, str);
        }

        public static CardActionType[] values() {
            return (CardActionType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "SUCCESS", "WARNING", "INFO", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CardStyle {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CardStyle[] $VALUES;
        public static final CardStyle DEFAULT = new CardStyle("DEFAULT", 0);
        public static final CardStyle SUCCESS = new CardStyle("SUCCESS", 1);
        public static final CardStyle WARNING = new CardStyle("WARNING", 2);
        public static final CardStyle INFO = new CardStyle("INFO", 3);

        private static final /* synthetic */ CardStyle[] $values() {
            return new CardStyle[]{DEFAULT, SUCCESS, WARNING, INFO};
        }

        public static EnumEntries<CardStyle> getEntries() {
            return $ENTRIES;
        }

        static {
            CardStyle[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CardStyle(String str, int i) {
        }

        public static CardStyle valueOf(String str) {
            return (CardStyle) Enum.valueOf(CardStyle.class, str);
        }

        public static CardStyle[] values() {
            return (CardStyle[]) $VALUES.clone();
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardAction;", "", "label", "", ReportConstant.COMMON_ACTION_TYPE, "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardActionType;", "actionData", "isPrimary", "", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardActionType;Ljava/lang/String;Z)V", "getLabel", "()Ljava/lang/String;", "getActionType", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardActionType;", "getActionData", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CardAction {
        private final String actionData;
        private final CardActionType actionType;
        private final boolean isPrimary;
        private final String label;

        public static /* synthetic */ CardAction copy$default(CardAction cardAction, String str, CardActionType cardActionType, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cardAction.label;
            }
            if ((i & 2) != 0) {
                cardActionType = cardAction.actionType;
            }
            if ((i & 4) != 0) {
                str2 = cardAction.actionData;
            }
            if ((i & 8) != 0) {
                z = cardAction.isPrimary;
            }
            return cardAction.copy(str, cardActionType, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component2, reason: from getter */
        public final CardActionType getActionType() {
            return this.actionType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getActionData() {
            return this.actionData;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsPrimary() {
            return this.isPrimary;
        }

        public final CardAction copy(String label, CardActionType actionType, String actionData, boolean isPrimary) {
            Intrinsics.checkNotNullParameter(label, "label");
            Intrinsics.checkNotNullParameter(actionType, ReportConstant.COMMON_ACTION_TYPE);
            return new CardAction(label, actionType, actionData, isPrimary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardAction)) {
                return false;
            }
            CardAction cardAction = (CardAction) other;
            return Intrinsics.areEqual(this.label, cardAction.label) && this.actionType == cardAction.actionType && Intrinsics.areEqual(this.actionData, cardAction.actionData) && this.isPrimary == cardAction.isPrimary;
        }

        public int hashCode() {
            int hashCode = ((this.label.hashCode() * 31) + this.actionType.hashCode()) * 31;
            String str = this.actionData;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isPrimary);
        }

        public String toString() {
            return "CardAction(label=" + this.label + ", actionType=" + this.actionType + ", actionData=" + this.actionData + ", isPrimary=" + this.isPrimary + ')';
        }

        public CardAction(String str, CardActionType cardActionType, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "label");
            Intrinsics.checkNotNullParameter(cardActionType, ReportConstant.COMMON_ACTION_TYPE);
            this.label = str;
            this.actionType = cardActionType;
            this.actionData = str2;
            this.isPrimary = z;
        }

        public /* synthetic */ CardAction(String str, CardActionType cardActionType, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, cardActionType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z);
        }

        public final String getLabel() {
            return this.label;
        }

        public final CardActionType getActionType() {
            return this.actionType;
        }

        public final String getActionData() {
            return this.actionData;
        }

        public final boolean isPrimary() {
            return this.isPrimary;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003Jl\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "cardId", "", "iconRes", "", "iconUrl", "title", "actions", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardAction;", "style", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;", "onActionClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;Lkotlin/jvm/functions/Function1;)V", "getCardId", "()Ljava/lang/String;", "getIconRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconUrl", "getTitle", "getActions", "()Ljava/util/List;", "getStyle", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;", "getOnActionClick", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CardStyle;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PromotionCard;", "equals", "", "other", "", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PromotionCard extends AgentContentBlock {
        private final List<CardAction> actions;
        private final String cardId;
        private final Integer iconRes;
        private final String iconUrl;
        private final transient Function1<CardAction, Unit> onActionClick;
        private final CardStyle style;
        private final String title;

        public static /* synthetic */ PromotionCard copy$default(PromotionCard promotionCard, String str, Integer num, String str2, String str3, List list, CardStyle cardStyle, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = promotionCard.cardId;
            }
            if ((i & 2) != 0) {
                num = promotionCard.iconRes;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                str2 = promotionCard.iconUrl;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                str3 = promotionCard.title;
            }
            String str5 = str3;
            if ((i & 16) != 0) {
                list = promotionCard.actions;
            }
            List list2 = list;
            if ((i & 32) != 0) {
                cardStyle = promotionCard.style;
            }
            CardStyle cardStyle2 = cardStyle;
            if ((i & 64) != 0) {
                function1 = promotionCard.onActionClick;
            }
            return promotionCard.copy(str, num2, str4, str5, list2, cardStyle2, function1);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCardId() {
            return this.cardId;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getIconRes() {
            return this.iconRes;
        }

        /* renamed from: component3, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<CardAction> component5() {
            return this.actions;
        }

        /* renamed from: component6, reason: from getter */
        public final CardStyle getStyle() {
            return this.style;
        }

        public final Function1<CardAction, Unit> component7() {
            return this.onActionClick;
        }

        public final PromotionCard copy(String cardId, Integer iconRes, String iconUrl, String title, List<CardAction> actions, CardStyle style, Function1<? super CardAction, Unit> onActionClick) {
            Intrinsics.checkNotNullParameter(cardId, "cardId");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(actions, "actions");
            Intrinsics.checkNotNullParameter(style, "style");
            return new PromotionCard(cardId, iconRes, iconUrl, title, actions, style, onActionClick);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PromotionCard)) {
                return false;
            }
            PromotionCard promotionCard = (PromotionCard) other;
            return Intrinsics.areEqual(this.cardId, promotionCard.cardId) && Intrinsics.areEqual(this.iconRes, promotionCard.iconRes) && Intrinsics.areEqual(this.iconUrl, promotionCard.iconUrl) && Intrinsics.areEqual(this.title, promotionCard.title) && Intrinsics.areEqual(this.actions, promotionCard.actions) && this.style == promotionCard.style && Intrinsics.areEqual(this.onActionClick, promotionCard.onActionClick);
        }

        public int hashCode() {
            int hashCode = this.cardId.hashCode() * 31;
            Integer num = this.iconRes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.iconUrl;
            int hashCode3 = (((((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.title.hashCode()) * 31) + this.actions.hashCode()) * 31) + this.style.hashCode()) * 31;
            Function1<CardAction, Unit> function1 = this.onActionClick;
            return hashCode3 + (function1 != null ? function1.hashCode() : 0);
        }

        public String toString() {
            return "PromotionCard(cardId=" + this.cardId + ", iconRes=" + this.iconRes + ", iconUrl=" + this.iconUrl + ", title=" + this.title + ", actions=" + this.actions + ", style=" + this.style + ", onActionClick=" + this.onActionClick + ')';
        }

        public final String getCardId() {
            return this.cardId;
        }

        public final Integer getIconRes() {
            return this.iconRes;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getTitle() {
            return this.title;
        }

        public /* synthetic */ PromotionCard(String str, Integer num, String str2, String str3, List list, CardStyle cardStyle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, str3, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CardStyle.DEFAULT : cardStyle, (i & 64) != 0 ? null : function1);
        }

        public final List<CardAction> getActions() {
            return this.actions;
        }

        public final CardStyle getStyle() {
            return this.style;
        }

        public final Function1<CardAction, Unit> getOnActionClick() {
            return this.onActionClick;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PromotionCard(String str, Integer num, String str2, String str3, List<CardAction> list, CardStyle cardStyle, Function1<? super CardAction, Unit> function1) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "cardId");
            Intrinsics.checkNotNullParameter(str3, "title");
            Intrinsics.checkNotNullParameter(list, "actions");
            Intrinsics.checkNotNullParameter(cardStyle, "style");
            this.cardId = str;
            this.iconRes = num;
            this.iconUrl = str2;
            this.title = str3;
            this.actions = list;
            this.style = cardStyle;
            this.onActionClick = function1;
        }
    }

    /* compiled from: AgentContentBlock.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "sessionId", "", "conversationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getConversationId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ViewVoiceHistory extends AgentContentBlock {
        private final String conversationId;
        private final String sessionId;

        public static /* synthetic */ ViewVoiceHistory copy$default(ViewVoiceHistory viewVoiceHistory, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewVoiceHistory.sessionId;
            }
            if ((i & 2) != 0) {
                str2 = viewVoiceHistory.conversationId;
            }
            return viewVoiceHistory.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final ViewVoiceHistory copy(String sessionId, String conversationId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(conversationId, "conversationId");
            return new ViewVoiceHistory(sessionId, conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewVoiceHistory)) {
                return false;
            }
            ViewVoiceHistory viewVoiceHistory = (ViewVoiceHistory) other;
            return Intrinsics.areEqual(this.sessionId, viewVoiceHistory.sessionId) && Intrinsics.areEqual(this.conversationId, viewVoiceHistory.conversationId);
        }

        public int hashCode() {
            return (this.sessionId.hashCode() * 31) + this.conversationId.hashCode();
        }

        public String toString() {
            return "ViewVoiceHistory(sessionId=" + this.sessionId + ", conversationId=" + this.conversationId + ')';
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getConversationId() {
            return this.conversationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewVoiceHistory(String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "sessionId");
            Intrinsics.checkNotNullParameter(str2, "conversationId");
            this.sessionId = str;
            this.conversationId = str2;
        }
    }
}
