package com.bytedance.trae.conversation.chat.block;

import android.content.res.Resources;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.LoginUtils;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.QueuingManager;
import com.bytedance.trae.conversation.chat.block.renderer.ref.WebReference;
import com.bytedance.trae.conversation.chat.error.AgentErrorCodeRegistry;
import com.bytedance.trae.conversation.chat.error.ContentSecurityErrorMessages;
import com.bytedance.trae.conversation.chat.grouping.GroupingContext;
import com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper;
import com.bytedance.trae.conversation.tracker.Credits4008CodeSource;
import com.bytedance.trae.conversation.tracker.TocCreditsObservation;
import com.bytedance.trae.im.model.ArtifactData;
import com.bytedance.trae.im.model.ChangedVideoData;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.FinishCardResult;
import com.bytedance.trae.im.model.FinishCardResultData;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedTokenUsage;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.im.model.VideoFileDiffInfo;
import com.bytedance.trae.im.model.VideoInfoData;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.FastRequestEvent;
import com.bytedance.trae.im.service.FastRequestEventType;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactFileInput;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactInfoInput;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactParser;
import com.bytedance.trae.kmp.artifacts.artifact.VideoArtifactPlanItemInput;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: AgentContentBlockBuilder.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0084\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\u001eJ\b\u0010%\u001a\u00020\u001eH\u0002J1\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eH\u0000¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u001e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001a\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\"\u00104\u001a\u00020\u00052\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0002J(\u00108\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J\u0010\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u0005H\u0002J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u0002062\u0006\u00109\u001a\u00020\u0005H\u0002J \u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u000f2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000fH\u0002J\"\u0010@\u001a\u0004\u0018\u00010\u00052\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J\"\u0010A\u001a\u0004\u0018\u00010B2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J \u0010C\u001a\u0004\u0018\u00010B2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J \u0010D\u001a\u0004\u0018\u00010B2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J\u0014\u0010E\u001a\u0004\u0018\u00010B2\b\u0010;\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010F\u001a\u00020\u001e2\u0006\u0010=\u001a\u0002062\u0006\u00109\u001a\u00020\u0005H\u0002J\"\u0010G\u001a\u0004\u0018\u00010H2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000f2\u0006\u00109\u001a\u00020\u0005H\u0002J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u000f2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000fH\u0002J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010LH\u0002J\u0015\u0010M\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010LH\u0002¢\u0006\u0002\u0010NJ\u0018\u0010O\u001a\u00020P2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000fH\u0002J\u0012\u0010Q\u001a\u00020\u001e2\b\u0010R\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010S\u001a\u00020\u001e2\b\u0010R\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010T\u001a\u00020\u001e2\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u000fH\u0002J!\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010V2\b\u0010X\u001a\u0004\u0018\u00010VH\u0002¢\u0006\u0002\u0010YR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/AgentContentBlockBuilder;", "", "<init>", "()V", "AGENT_FLOW_TAG", "", "BLOCK_TAG", "PURE_SHOW_WIDGET_TOOL_NAME", "CREDITS_EXHAUSTED_ERROR_CODE", "", "gson", "Lcom/google/gson/Gson;", "FINISH_TOOLS", "", "build", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "resources", "Landroid/content/res/Resources;", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "onActionClick", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;", "", "iMessage", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "isLatestTurn", "", "isLastAgent", "feedbackState", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "messageIndex", "totalMessageCount", "creditsFeatureEnabled", "isOversea", "shouldShowFreeActivityQuotaError", AccountMonitorConstants.CommonParameter.ERROR, "shouldSkipTocCommercialFeatures", "shouldShowFreeActivityQuotaError$conversation_mainlandRelease", "(Ljava/lang/Integer;ZZZ)Z", "resolveErrorCode", "error", "Lcom/bytedance/trae/im/model/ParsedError;", "resolveErrorCode$conversation_mainlandRelease", "(Lcom/bytedance/trae/im/model/ParsedError;)Ljava/lang/Integer;", "containsPureShowWidgetInlineBlock", "blocks", "resolveNoticeTitle", "resolveNoticeMessage", "findMainAgentRunId", "planItems", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "mainAgentId", "sanitizeVoiceSummaryPlanItemsForProcess", "mainAgentRunId", "shouldConsumeVoiceSummaryThought", "thought", "isMainAgentFinish", "planItem", "extractWebReferences", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;", "extractSummary", "extractVoiceSummary", "Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;", "extractVoiceSummaryFromFinishParams", "extractVoiceSummaryFromThought", "parseVoiceSummaryThoughtPayload", "isMainAgentPlanItem", "extractProducts", "Lcom/bytedance/trae/im/model/ArtifactData;", "buildVideoArtifactInputs", "Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactPlanItemInput;", "primitiveStringOrNull", "Lcom/google/gson/JsonElement;", "primitiveIntOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "computeTailStatus", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TailStatus;", "isCodeGenTool", "name", "isCommandTool", "allPlanItemsAreFinishOnly", "computeDurationMs", "", "startTime", "endTime", "(Ljava/lang/Long;Ljava/lang/Long;)J", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentContentBlockBuilder {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final String BLOCK_TAG = "AgentBlock";
    private static final int CREDITS_EXHAUSTED_ERROR_CODE = 4008;
    private static final String PURE_SHOW_WIDGET_TOOL_NAME = "PureShowWidget";
    public static final AgentContentBlockBuilder INSTANCE = new AgentContentBlockBuilder();
    private static final Gson gson = new Gson();
    private static final Set<String> FINISH_TOOLS = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "AgentFinish", "response_to_user", "ResponseToUser", "Task"});

    private AgentContentBlockBuilder() {
    }

    public static /* synthetic */ List build$default(AgentContentBlockBuilder agentContentBlockBuilder, ParsedChatMessage parsedChatMessage, Resources resources, Conversation conversation, Function1 function1, IMessageListener iMessageListener, boolean z, boolean z2, AgentContentBlock.FeedbackState feedbackState, int i, int i2, boolean z3, int i3, Object obj) {
        Object obj2;
        boolean booleanValue;
        Function1 function12 = (i3 & 8) != 0 ? null : function1;
        boolean z4 = (i3 & 32) != 0 ? true : z;
        boolean z5 = (i3 & 64) != 0 ? false : z2;
        AgentContentBlock.FeedbackState feedbackState2 = (i3 & 128) != 0 ? AgentContentBlock.FeedbackState.NONE : feedbackState;
        int i4 = (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i;
        int i5 = (i3 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? 0 : i2;
        if ((i3 & 1024) != 0) {
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl(Boolean.valueOf(TocCreditsPolicy.INSTANCE.isEnabled()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj2)) {
                obj2 = false;
            }
            booleanValue = ((Boolean) obj2).booleanValue();
        } else {
            booleanValue = z3;
        }
        return agentContentBlockBuilder.build(parsedChatMessage, resources, conversation, function12, iMessageListener, z4, z5, feedbackState2, i4, i5, booleanValue);
    }

    /* JADX WARN: Code restructure failed: missing block: B:308:0x04b0, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(kotlin.text.StringsKt.trimStart(r0).toString(), "{", false, 2, (java.lang.Object) null) == false) goto L543;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0752 A[LOOP:3: B:222:0x074c->B:224:0x0752, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x07ba  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0418  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AgentContentBlock> build(ParsedChatMessage message, Resources resources, Conversation conversation, Function1<? super AgentContentBlock.ActionType, Unit> onActionClick, IMessageListener iMessage, boolean isLatestTurn, boolean isLastAgent, AgentContentBlock.FeedbackState feedbackState, int messageIndex, int totalMessageCount, boolean creditsFeatureEnabled) {
        Object obj;
        boolean z;
        ArrayList arrayList;
        List<AgentContentBlock> emptyList;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Object obj2;
        String str;
        String str2;
        String str3;
        List<AgentContentBlock> list;
        Object obj3;
        String str4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        VoiceSummaryPayload extractVoiceSummary;
        String str5;
        boolean z6;
        String str6;
        String str7;
        ArtifactData extractProducts;
        List parseInputs;
        ParsedError error;
        Object obj4;
        ArrayList arrayList4;
        boolean z7;
        boolean z8;
        String str8;
        String str9;
        ParsedError parsedError;
        boolean z9;
        String str10;
        Iterator it;
        AgentContentBlock agentContentBlock;
        boolean z10;
        Object obj5;
        boolean z11;
        boolean z12;
        Credits4008CodeSource credits4008CodeSource;
        String str11;
        JsonElement jsonElement;
        String markdown;
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(feedbackState, "feedbackState");
        ArrayList arrayList5 = new ArrayList();
        FLogger.INSTANCE.i("AgentBlock", "[Builder] build start: messageId=" + message.getMessageId() + ", status=" + message.getStatus() + ", isHistory=" + message.isHistory() + ", isInterjected=" + message.isInterjected() + ", isLatestTurn=" + isLatestTurn);
        boolean isOversea = isOversea();
        try {
            Result.Companion companion = Result.Companion;
            AgentContentBlockBuilder agentContentBlockBuilder = this;
            obj = Result.constructor-impl(Boolean.valueOf(LoginUtils.INSTANCE.shouldSkipTocCommercialFeatures()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = true;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (creditsFeatureEnabled || isOversea || booleanValue) {
            z = false;
        } else {
            z = message.getFastRequestSavings() != null;
            if (!z) {
                FastRequestEvent fastRequestEvent = message.getFastRequestEvent();
                if (fastRequestEvent != null) {
                    Integer type = fastRequestEvent.getType();
                    int value = FastRequestEventType.AlreadyUsing.getValue();
                    if (type != null && type.intValue() == value) {
                        z = true;
                    }
                }
                z = false;
            }
            if (!z) {
                z = QueuingManager.INSTANCE.hasMessageId(message.getMessageId());
            }
        }
        arrayList5.add(new AgentContentBlock.Avatar(message.getAgentName(), message.getAgentAvatarId(), message.getAgentType(), conversation != null ? conversation.getEnvironment() : null, message.getMessageId(), message.getSessionId(), message.getReplyToMessageId(), Boolean.valueOf(z), message.getCreatedAt()));
        ParsedTaskContent taskContent = message.getTaskContent();
        if (taskContent == null || (messages = taskContent.getMessages()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList6 = new ArrayList();
            Iterator<T> it2 = messages.iterator();
            while (it2.hasNext()) {
                ParsedPlanItem planItem = ((ParsedPlanItemMessage) it2.next()).getPlanItem();
                if (planItem != null) {
                    arrayList6.add(planItem);
                }
            }
            arrayList = arrayList6;
        }
        String agentId = message.getAgentId();
        if (agentId == null) {
            agentId = message.getAgentType();
        }
        String str12 = agentId;
        String findMainAgentRunId = findMainAgentRunId(arrayList, str12);
        boolean areEqual = Intrinsics.areEqual(message.getAgentType(), BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY);
        boolean z13 = Intrinsics.areEqual(message.getStatus(), "in_progress") && !message.isHistory();
        boolean z14 = z13 && !isLatestTurn;
        ArrayList arrayList7 = arrayList;
        GroupingContext groupingContext = new GroupingContext(findMainAgentRunId, message.getStatus(), message.isHistory(), isLatestTurn, z13);
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node6] Builder.build: planItemCount=" + (arrayList7 != null ? arrayList7.size() : 0) + ", mainAgentId=" + str12 + ", mainAgentRunId=" + findMainAgentRunId + ", status=" + message.getStatus() + ", isHistory=" + message.isHistory() + ", isLatestTurn=" + isLatestTurn);
        if (arrayList7 != null) {
            int i = 0;
            for (Object obj6 : arrayList7) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ParsedPlanItem parsedPlanItem = (ParsedPlanItem) obj6;
                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                StringBuilder append = new StringBuilder("[Node6] Builder planItem[").append(i).append("]: id=").append(parsedPlanItem.getId()).append(", agentId=").append(parsedPlanItem.getAgentId()).append(", agentRunId=").append(parsedPlanItem.getAgentRunId()).append(", tool=");
                ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
                traeLogUtil.d(AGENT_FLOW_TAG, append.append(toolCallInfo != null ? toolCallInfo.getName() : null).append(", hasThought=").append(parsedPlanItem.getThought() != null).append(", hide=").append(parsedPlanItem.getHide()).toString());
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
        List<ParsedPlanItem> sanitizeVoiceSummaryPlanItemsForProcess = areEqual ? sanitizeVoiceSummaryPlanItemsForProcess(arrayList7, findMainAgentRunId) : arrayList7;
        List<ParsedPlanItem> list2 = sanitizeVoiceSummaryPlanItemsForProcess;
        if (!(list2 == null || list2.isEmpty())) {
            emptyList = PlanItemGrouper.INSTANCE.group(sanitizeVoiceSummaryPlanItemsForProcess, resources, groupingContext);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        FLogger.INSTANCE.i("AgentBlock", "[Builder] processBlocks: count=" + emptyList.size() + ", planItems=" + (arrayList7 != null ? arrayList7.size() : 0));
        TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
        StringBuilder append2 = new StringBuilder("[Node6] Builder processBlocks: count=").append(emptyList.size()).append(", types=");
        List<AgentContentBlock> list3 = emptyList;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList8.add(Reflection.getOrCreateKotlinClass(((AgentContentBlock) it3.next()).getClass()).getSimpleName());
        }
        traeLogUtil2.d(AGENT_FLOW_TAG, append2.append(arrayList8).toString());
        boolean z15 = CollectionsKt.contains(CollectionsKt.listOf(new String[]{"completed", "failed", ConfirmInfo.STATUS_CANCELED}), message.getStatus()) || (Intrinsics.areEqual(message.getStatus(), "in_progress") && message.isHistory()) || z14 || message.isInterjected();
        List<AgentContentBlock> list4 = emptyList;
        boolean z16 = (list4.isEmpty() ^ true) || (z13 && !areEqual);
        boolean containsPureShowWidgetInlineBlock = containsPureShowWidgetInlineBlock(emptyList);
        Integer queuingPosition = message.getQueuingPosition();
        String queueId = message.getQueueId();
        String resolveNoticeTitle = resolveNoticeTitle(resources, message);
        String resolveNoticeMessage = resolveNoticeMessage(resources, message);
        String str13 = resolveNoticeTitle;
        if (str13 == null || StringsKt.isBlank(str13)) {
            String str14 = resolveNoticeMessage;
            if (str14 == null || StringsKt.isBlank(str14)) {
                z2 = false;
                z3 = message.isHistory() && queuingPosition != null && queuingPosition.intValue() > 0 && !z15;
                z4 = !z2 && Intrinsics.areEqual(message.getNoticeType(), ParsedChatMessage.NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED);
                if (z4) {
                    z5 = z16;
                    obj2 = ConfirmInfo.STATUS_CANCELED;
                    str = AGENT_FLOW_TAG;
                    str2 = ", types=";
                    str3 = "AgentBlock";
                    list = list4;
                    obj3 = "failed";
                    str4 = findMainAgentRunId;
                } else {
                    str = AGENT_FLOW_TAG;
                    z5 = z16;
                    str2 = ", types=";
                    list = list4;
                    obj2 = ConfirmInfo.STATUS_CANCELED;
                    obj3 = "failed";
                    str3 = "AgentBlock";
                    str4 = findMainAgentRunId;
                    build$addNoticeBlock(queuingPosition, message, arrayList5, resolveNoticeTitle, resolveNoticeMessage, queueId);
                }
                if (z5) {
                    arrayList2 = arrayList5;
                } else {
                    arrayList2 = arrayList5;
                    arrayList2.add(AgentContentBlock.ProcessStart.INSTANCE);
                    arrayList2.addAll(list);
                    arrayList2.add(new AgentContentBlock.ProcessEnd(computeDurationMs(message.getChatStartTime(), message.getChatEndTime()), z15, z15 && Intrinsics.areEqual(message.getStatus(), "completed") && !containsPureShowWidgetInlineBlock));
                }
                if (z2 || z4) {
                    arrayList3 = arrayList2;
                } else {
                    arrayList3 = arrayList2;
                    build$addNoticeBlock(queuingPosition, message, arrayList2, resolveNoticeTitle, resolveNoticeMessage, queueId);
                }
                if (z3) {
                    build$addQueueBlock(queuingPosition, message, creditsFeatureEnabled, arrayList3, queueId, isOversea);
                }
                extractVoiceSummary = !areEqual ? extractVoiceSummary(arrayList7, str4) : null;
                if (extractVoiceSummary == null) {
                    str6 = null;
                } else if (!areEqual) {
                    str6 = extractSummary(arrayList7, str4);
                } else {
                    if (!z15 || (str6 = extractSummary(arrayList7, str4)) == null) {
                        str5 = null;
                        z6 = false;
                    } else {
                        str5 = null;
                        z6 = false;
                    }
                    str6 = str5;
                    str7 = (extractVoiceSummary != null || (markdown = extractVoiceSummary.getMarkdown()) == null) ? str6 : markdown;
                    if (extractVoiceSummary != null) {
                        String header = extractVoiceSummary.getHeader();
                        String markdown2 = extractVoiceSummary.getMarkdown();
                        String bottom = extractVoiceSummary.getBottom();
                        ParsedTaskContent taskContent2 = message.getTaskContent();
                        arrayList3.add(new AgentContentBlock.VoiceSummary(header, markdown2, bottom, z15, taskContent2 != null ? taskContent2.getTaskId() : str5, message.getReplyToMessageId(), message.getSessionId()));
                    } else {
                        String str15 = str6;
                        if (!((str15 == null || str15.length() == 0) ? true : z6)) {
                            ParsedTaskContent taskContent3 = message.getTaskContent();
                            arrayList3.add(new AgentContentBlock.Summary(str6, z15, taskContent3 != null ? taskContent3.getTaskId() : str5, extractWebReferences(arrayList7)));
                        }
                    }
                    extractProducts = extractProducts(arrayList7, str4);
                    parseInputs = VideoArtifactParser.INSTANCE.parseInputs(buildVideoArtifactInputs(arrayList7));
                    if (extractProducts == null || (!parseInputs.isEmpty())) {
                        String sessionId = message.getSessionId();
                        String turnId = message.getTurnId();
                        arrayList3.add(new AgentContentBlock.Artifacts(extractProducts, parseInputs, sessionId, turnId == null ? "" : turnId, message.getMessageId(), iMessage, str7));
                    }
                    error = message.getError();
                    if (error == null && Intrinsics.areEqual(message.getStatus(), obj3)) {
                        Integer resolveErrorCode$conversation_mainlandRelease = resolveErrorCode$conversation_mainlandRelease(error);
                        if (resolveErrorCode$conversation_mainlandRelease == null) {
                            z11 = isOversea;
                            z10 = creditsFeatureEnabled;
                            obj5 = obj3;
                            z8 = z15;
                            z12 = booleanValue;
                            str9 = str3;
                        } else {
                            if (resolveErrorCode$conversation_mainlandRelease.intValue() == CREDITS_EXHAUSTED_ERROR_CODE) {
                                TocCreditsObservation tocCreditsObservation = TocCreditsObservation.INSTANCE;
                                String sessionId2 = message.getSessionId();
                                String messageId = message.getMessageId();
                                if (error.getCode() != null) {
                                    credits4008CodeSource = Credits4008CodeSource.TopLevel;
                                } else {
                                    credits4008CodeSource = Credits4008CodeSource.DataCode;
                                }
                                boolean isHistory = message.isHistory();
                                String environment = conversation != null ? conversation.getEnvironment() : str5;
                                String mode = conversation != null ? conversation.getMode() : str5;
                                str9 = str3;
                                obj5 = obj3;
                                z8 = z15;
                                z10 = creditsFeatureEnabled;
                                tocCreditsObservation.trackCredits4008Hit(sessionId2, messageId, creditsFeatureEnabled, credits4008CodeSource, isHistory, environment, mode);
                            } else {
                                z10 = creditsFeatureEnabled;
                                obj5 = obj3;
                                z8 = z15;
                                str9 = str3;
                            }
                            z11 = isOversea;
                            z12 = booleanValue;
                        }
                        if (shouldShowFreeActivityQuotaError$conversation_mainlandRelease(resolveErrorCode$conversation_mainlandRelease, z10, z11, z12)) {
                            arrayList3.add(new AgentContentBlock.FreeActivityQuotaError(error, isLastAgent, message, onActionClick));
                            arrayList4 = arrayList3;
                            z7 = z5;
                            obj4 = obj5;
                            str8 = str2;
                        } else {
                            Object obj7 = obj5;
                            try {
                                JsonObject data = error.getData();
                                str11 = (data == null || (jsonElement = data.get(DBData.FIELD_TYPE)) == null) ? null : jsonElement.getAsString();
                            } catch (Throwable unused) {
                                str11 = null;
                            }
                            arrayList4 = arrayList3;
                            str8 = str2;
                            z7 = z5;
                            obj4 = obj7;
                            AgentErrorCodeRegistry.DisplayResult displayMessage = AgentErrorCodeRegistry.INSTANCE.displayMessage(resources, resolveErrorCode$conversation_mainlandRelease, error.getMessage(), error.getData(), str11, creditsFeatureEnabled);
                            arrayList4.add(new AgentContentBlock.Error(error, displayMessage.getMessage(), displayMessage.getLevel(), displayMessage.getTitle(), displayMessage.getShowInfoIcon()));
                        }
                    } else {
                        obj4 = obj3;
                        arrayList4 = arrayList3;
                        z7 = z5;
                        z8 = z15;
                        str8 = str2;
                        str9 = str3;
                    }
                    if (!z8 && !message.isHistory()) {
                        if (!areEqual && extractVoiceSummary == null) {
                            agentContentBlock = AgentContentBlock.VoiceSummaryLoading.INSTANCE;
                        } else {
                            agentContentBlock = AgentContentBlock.InitialLoading.INSTANCE;
                        }
                        arrayList4.add(agentContentBlock);
                    }
                    if (z8) {
                        if (Intrinsics.areEqual(message.getAgentType(), BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY) && extractVoiceSummary == null) {
                            String str16 = str6;
                            if (!((str16 == null || StringsKt.isBlank(str16)) ? true : z6)) {
                                String replyToMessageId = message.getReplyToMessageId();
                                if (!((replyToMessageId == null || StringsKt.isBlank(replyToMessageId)) ? true : z6)) {
                                    String replyToMessageId2 = message.getReplyToMessageId();
                                    arrayList4.add(new AgentContentBlock.ViewVoiceHistory(replyToMessageId2 != null ? replyToMessageId2 : "", message.getSessionId()));
                                }
                            }
                        }
                        Object obj8 = obj2;
                        boolean areEqual2 = Intrinsics.areEqual(message.getStatus(), obj8);
                        boolean z17 = (Intrinsics.areEqual(message.getStatus(), obj8) || Intrinsics.areEqual(message.getStatus(), obj4) || message.isInterjected()) ? true : z6;
                        String status = message.getStatus();
                        String messageId2 = message.getMessageId();
                        ParsedTokenUsage tokenUsage = message.getTokenUsage();
                        Boolean isUserCanceled = message.isUserCanceled();
                        boolean z18 = !z17;
                        parsedError = error;
                        boolean z19 = (!areEqual2 || message.isInterjected()) ? z6 : true;
                        z9 = z8;
                        str10 = str;
                        arrayList4.add(new AgentContentBlock.ActionBar(status, messageId2, tokenUsage, isUserCanceled, feedbackState, z18, z19, message.isInterjected(), areEqual, onActionClick));
                    } else {
                        parsedError = error;
                        z9 = z8;
                        str10 = str;
                    }
                    TraeLogUtil traeLogUtil3 = TraeLogUtil.INSTANCE;
                    StringBuilder append3 = new StringBuilder("[Node6] Builder RESULT: totalBlocks=").append(arrayList4.size()).append(str8);
                    ArrayList arrayList9 = arrayList4;
                    ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
                    it = arrayList9.iterator();
                    while (it.hasNext()) {
                        arrayList10.add(Reflection.getOrCreateKotlinClass(((AgentContentBlock) it.next()).getClass()).getSimpleName());
                    }
                    traeLogUtil3.d(str10, append3.append(arrayList10).append(", hasSummary=").append(str7 != null).append(", hasProducts=").append(extractProducts != null).append(", hasProcess=").append(z7).toString());
                    String str17 = str7;
                    FLogger.INSTANCE.i(str9, "[Builder] build done: totalBlocks=" + arrayList4.size() + ", hasSummary=" + (!(str17 != null || str17.length() == 0)) + ", hasProducts=" + (extractProducts != null) + ", hasError=" + (parsedError != null) + ", isCompleted=" + z9);
                    return arrayList4;
                }
                str5 = null;
                z6 = false;
                if (extractVoiceSummary != null) {
                }
                if (extractVoiceSummary != null) {
                }
                extractProducts = extractProducts(arrayList7, str4);
                parseInputs = VideoArtifactParser.INSTANCE.parseInputs(buildVideoArtifactInputs(arrayList7));
                if (extractProducts == null) {
                }
                String sessionId3 = message.getSessionId();
                String turnId2 = message.getTurnId();
                arrayList3.add(new AgentContentBlock.Artifacts(extractProducts, parseInputs, sessionId3, turnId2 == null ? "" : turnId2, message.getMessageId(), iMessage, str7));
                error = message.getError();
                if (error == null) {
                }
                obj4 = obj3;
                arrayList4 = arrayList3;
                z7 = z5;
                z8 = z15;
                str8 = str2;
                str9 = str3;
                if (!z8) {
                    if (!areEqual) {
                    }
                    agentContentBlock = AgentContentBlock.InitialLoading.INSTANCE;
                    arrayList4.add(agentContentBlock);
                }
                if (z8) {
                }
                TraeLogUtil traeLogUtil32 = TraeLogUtil.INSTANCE;
                StringBuilder append32 = new StringBuilder("[Node6] Builder RESULT: totalBlocks=").append(arrayList4.size()).append(str8);
                ArrayList arrayList92 = arrayList4;
                ArrayList arrayList102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList92, 10));
                it = arrayList92.iterator();
                while (it.hasNext()) {
                }
                traeLogUtil32.d(str10, append32.append(arrayList102).append(", hasSummary=").append(str7 != null).append(", hasProducts=").append(extractProducts != null).append(", hasProcess=").append(z7).toString());
                String str172 = str7;
                FLogger.INSTANCE.i(str9, "[Builder] build done: totalBlocks=" + arrayList4.size() + ", hasSummary=" + (!(str172 != null || str172.length() == 0)) + ", hasProducts=" + (extractProducts != null) + ", hasError=" + (parsedError != null) + ", isCompleted=" + z9);
                return arrayList4;
            }
        }
        z2 = true;
        if (message.isHistory()) {
        }
        if (z2) {
        }
        if (z4) {
        }
        if (z5) {
        }
        if (z2) {
        }
        arrayList3 = arrayList2;
        if (z3) {
        }
        if (!areEqual) {
        }
        if (extractVoiceSummary == null) {
        }
        str5 = null;
        z6 = false;
        if (extractVoiceSummary != null) {
        }
        if (extractVoiceSummary != null) {
        }
        extractProducts = extractProducts(arrayList7, str4);
        parseInputs = VideoArtifactParser.INSTANCE.parseInputs(buildVideoArtifactInputs(arrayList7));
        if (extractProducts == null) {
        }
        String sessionId32 = message.getSessionId();
        String turnId22 = message.getTurnId();
        arrayList3.add(new AgentContentBlock.Artifacts(extractProducts, parseInputs, sessionId32, turnId22 == null ? "" : turnId22, message.getMessageId(), iMessage, str7));
        error = message.getError();
        if (error == null) {
        }
        obj4 = obj3;
        arrayList4 = arrayList3;
        z7 = z5;
        z8 = z15;
        str8 = str2;
        str9 = str3;
        if (!z8) {
        }
        if (z8) {
        }
        TraeLogUtil traeLogUtil322 = TraeLogUtil.INSTANCE;
        StringBuilder append322 = new StringBuilder("[Node6] Builder RESULT: totalBlocks=").append(arrayList4.size()).append(str8);
        ArrayList arrayList922 = arrayList4;
        ArrayList arrayList1022 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList922, 10));
        it = arrayList922.iterator();
        while (it.hasNext()) {
        }
        traeLogUtil322.d(str10, append322.append(arrayList1022).append(", hasSummary=").append(str7 != null).append(", hasProducts=").append(extractProducts != null).append(", hasProcess=").append(z7).toString());
        String str1722 = str7;
        FLogger.INSTANCE.i(str9, "[Builder] build done: totalBlocks=" + arrayList4.size() + ", hasSummary=" + (!(str1722 != null || str1722.length() == 0)) + ", hasProducts=" + (extractProducts != null) + ", hasError=" + (parsedError != null) + ", isCompleted=" + z9);
        return arrayList4;
    }

    private static final void build$addNoticeBlock(Integer num, ParsedChatMessage parsedChatMessage, List<AgentContentBlock> list, String str, String str2, String str3) {
        int intValue = num != null ? num.intValue() : 1;
        FLogger.INSTANCE.i("AgentBlock", "[Builder] addNoticeBlock: queuingPos=" + num + ", noticeType=" + parsedChatMessage.getNoticeType());
        list.add(new AgentContentBlock.Queuing(intValue, str, str2, parsedChatMessage, null, str3, parsedChatMessage.getRequestUUID()));
    }

    private static final void build$addQueueBlock(Integer num, ParsedChatMessage parsedChatMessage, boolean z, List<AgentContentBlock> list, String str, boolean z2) {
        int intValue = num != null ? num.intValue() : 1;
        FLogger.INSTANCE.i("AgentBlock", "[Builder] addQueueBlock: queuingPos=" + num + ' ' + parsedChatMessage.getFastRequestEvent() + ' ' + QueuingManager.INSTANCE.hasUsedPayRight(parsedChatMessage.getMessageId(), parsedChatMessage.getRequestUUID()));
        if (z) {
            list.add(new AgentContentBlock.Queuing(intValue, null, parsedChatMessage.getQueuingMessage(), parsedChatMessage, null, str, parsedChatMessage.getRequestUUID(), 2, null));
        } else {
            if (!z2) {
                if (QueuingManager.INSTANCE.hasUsedPayRight(parsedChatMessage.getMessageId(), parsedChatMessage.getRequestUUID())) {
                    return;
                }
                list.add(new AgentContentBlock.Queuing(intValue, null, parsedChatMessage.getQueuingMessage(), parsedChatMessage, parsedChatMessage.getFastRequestEvent(), str, parsedChatMessage.getRequestUUID(), 2, null));
                return;
            }
            list.add(new AgentContentBlock.Queuing(intValue, null, parsedChatMessage.getQueuingMessage(), parsedChatMessage, null, str, null, 82, null));
        }
    }

    private final boolean isOversea() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AgentContentBlockBuilder agentContentBlockBuilder = this;
            obj = Result.constructor-impl(Boolean.valueOf(AppHost.INSTANCE.isOversea()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final boolean shouldShowFreeActivityQuotaError$conversation_mainlandRelease(Integer r2, boolean creditsFeatureEnabled, boolean isOversea, boolean shouldSkipTocCommercialFeatures) {
        return (r2 == null || r2.intValue() != 4031 || creditsFeatureEnabled || isOversea || shouldSkipTocCommercialFeatures) ? false : true;
    }

    public final Integer resolveErrorCode$conversation_mainlandRelease(ParsedError error) {
        JsonElement jsonElement;
        Object obj;
        Intrinsics.checkNotNullParameter(error, "error");
        Integer code = error.getCode();
        if (code != null) {
            return code;
        }
        JsonObject data = error.getData();
        if (data == null || (jsonElement = data.get("code")) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Integer.valueOf(jsonElement.getAsInt()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.isFailure-impl(obj) ? null : obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(((com.bytedance.trae.conversation.chat.block.AgentContentBlock.Toolcall) r0).getToolCallInfo().getName(), "PureShowWidget") != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[LOOP:0: B:8:0x0016->B:18:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean containsPureShowWidgetInlineBlock(List<? extends AgentContentBlock> blocks) {
        boolean areEqual;
        List<? extends AgentContentBlock> list = blocks;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (AgentContentBlock agentContentBlock : list) {
            if (!(agentContentBlock instanceof AgentContentBlock.PureShowWidgetToolcallGroup)) {
                if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
                    AgentContentBlock agentContentBlock2 = (AgentContentBlock) CollectionsKt.singleOrNull(((AgentContentBlock.ToolcallGroup) agentContentBlock).getChildren());
                    if (agentContentBlock2 != null) {
                        if (agentContentBlock2 instanceof AgentContentBlock.Toolcall) {
                        }
                    }
                } else {
                    if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                        areEqual = INSTANCE.containsPureShowWidgetInlineBlock(((AgentContentBlock.TodoGroup) agentContentBlock).getChildren());
                    } else if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
                        areEqual = INSTANCE.containsPureShowWidgetInlineBlock(((AgentContentBlock.SubAgentGroup) agentContentBlock).getChildren());
                    } else if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                        areEqual = Intrinsics.areEqual(((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName(), "PureShowWidget");
                    }
                    if (areEqual) {
                        return true;
                    }
                }
                areEqual = false;
                if (areEqual) {
                }
            }
            areEqual = true;
            if (areEqual) {
            }
        }
        return false;
    }

    private final String resolveNoticeTitle(Resources resources, ParsedChatMessage message) {
        String noticeTitle = message.getNoticeTitle();
        if (noticeTitle != null) {
            if (!(!StringsKt.isBlank(noticeTitle))) {
                noticeTitle = null;
            }
            if (noticeTitle != null) {
                return noticeTitle;
            }
        }
        String noticeType = message.getNoticeType();
        if (noticeType == null) {
            return null;
        }
        int hashCode = noticeType.hashCode();
        if (hashCode != 720850185) {
            if (hashCode != 1778997648) {
                if (hashCode != 1967322283 || !noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_BLOCKED)) {
                    return null;
                }
            } else if (!noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED)) {
                return null;
            }
        } else if (!noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED)) {
            return null;
        }
        return I18nTextProvider.INSTANCE.getString(resources, R.string.trae_chat_content_security_notice_title, new Object[0]);
    }

    private final String resolveNoticeMessage(Resources resources, ParsedChatMessage message) {
        String noticeMessage = message.getNoticeMessage();
        if (noticeMessage != null) {
            if (!(!StringsKt.isBlank(noticeMessage))) {
                noticeMessage = null;
            }
            if (noticeMessage != null) {
                return noticeMessage;
            }
        }
        String noticeType = message.getNoticeType();
        if (noticeType == null) {
            return null;
        }
        int hashCode = noticeType.hashCode();
        if (hashCode == 720850185) {
            if (noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_INPUT_DESENSITIZED)) {
                return I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_enterprise_content_filter_input_desensitized, new Object[0]);
            }
            return null;
        }
        if (hashCode == 1778997648) {
            if (noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_OUTPUT_DESENSITIZED)) {
                return I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_enterprise_content_filter_output_desensitized, new Object[0]);
            }
            return null;
        }
        if (hashCode == 1967322283 && noticeType.equals(ParsedChatMessage.NOTICE_CONTENT_FILTER_BLOCKED)) {
            return ContentSecurityErrorMessages.INSTANCE.blockedMessage(resources, message.getContentSecurityRuleName());
        }
        return null;
    }

    private final String findMainAgentRunId(List<ParsedPlanItem> planItems, String mainAgentId) {
        String str;
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return "";
        }
        for (ParsedPlanItem parsedPlanItem : planItems) {
            String agentRunId = parsedPlanItem.getAgentRunId();
            if (Intrinsics.areEqual(parsedPlanItem.getAgentId(), mainAgentId)) {
                String str2 = agentRunId;
                if (!(str2 == null || str2.length() == 0)) {
                    return agentRunId;
                }
            }
        }
        String str3 = mainAgentId;
        if (str3 == null || str3.length() == 0) {
            Iterator<T> it = planItems.iterator();
            do {
                str = null;
                if (!it.hasNext()) {
                    break;
                }
                String agentRunId2 = ((ParsedPlanItem) it.next()).getAgentRunId();
                if (agentRunId2 != null) {
                    if (agentRunId2.length() > 0) {
                        str = agentRunId2;
                    }
                }
            } while (str == null);
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    private final List<ParsedPlanItem> sanitizeVoiceSummaryPlanItemsForProcess(List<ParsedPlanItem> planItems, String mainAgentRunId) {
        List<ParsedPlanItem> list = planItems;
        int i = 0;
        if (list == null || list.isEmpty()) {
            return planItems;
        }
        List<ParsedPlanItem> list2 = planItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ParsedPlanItem parsedPlanItem : list2) {
            String thought = parsedPlanItem.getThought();
            if (thought != null) {
                AgentContentBlockBuilder agentContentBlockBuilder = INSTANCE;
                if (agentContentBlockBuilder.isMainAgentPlanItem(parsedPlanItem, mainAgentRunId) && agentContentBlockBuilder.shouldConsumeVoiceSummaryThought(thought)) {
                    i++;
                    parsedPlanItem = parsedPlanItem.copy((r24 & 1) != 0 ? parsedPlanItem.id : null, (r24 & 2) != 0 ? parsedPlanItem.agentId : null, (r24 & 4) != 0 ? parsedPlanItem.agentDisplayName : null, (r24 & 8) != 0 ? parsedPlanItem.agentRunId : null, (r24 & 16) != 0 ? parsedPlanItem.subAgentCallDescription : null, (r24 & 32) != 0 ? parsedPlanItem.thought : null, (r24 & 64) != 0 ? parsedPlanItem.planType : null, (r24 & 128) != 0 ? parsedPlanItem.reasoningContent : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? parsedPlanItem.toolCallInfo : null, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? parsedPlanItem.confirmInfo : null, (r24 & 1024) != 0 ? parsedPlanItem.hide : null);
                }
            }
            arrayList.add(parsedPlanItem);
        }
        ArrayList arrayList2 = arrayList;
        if (i > 0) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node6] Builder voice_summary suppress payload thoughts: count=" + i);
        }
        return arrayList2;
    }

    private final boolean shouldConsumeVoiceSummaryThought(String thought) {
        String obj = StringsKt.trimStart(thought).toString();
        String str = obj;
        if (str.length() == 0) {
            return false;
        }
        return StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) || StringsKt.contains$default(str, "\"header\"", false, 2, (Object) null) || StringsKt.contains$default(str, "\"summary\"", false, 2, (Object) null) || StringsKt.contains$default(str, "\"bottom\"", false, 2, (Object) null) || parseVoiceSummaryThoughtPayload(thought) != null;
    }

    private final boolean isMainAgentFinish(ParsedPlanItem planItem, String mainAgentRunId) {
        String name;
        ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
        if (toolCallInfo == null || (name = toolCallInfo.getName()) == null || !FINISH_TOOLS.contains(name)) {
            return false;
        }
        String agentRunId = planItem.getAgentRunId();
        if (agentRunId == null) {
            agentRunId = "";
        }
        if (!Intrinsics.areEqual(agentRunId, mainAgentRunId)) {
            if (!(agentRunId.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
    
        if (r9 != null) goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0130 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<WebReference> extractWebReferences(List<ParsedPlanItem> planItems) {
        ParsedToolCallResult result;
        JsonObject data;
        JsonArray asJsonArray;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        String str;
        String str2;
        JsonElement jsonElement2;
        String str3;
        JsonElement jsonElement3;
        String str4;
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Set of = SetsKt.setOf(new String[]{"WebSearch", "WebFetch", "web_search", "web_fetch"});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        Iterator<ParsedPlanItem> it = planItems.iterator();
        while (it.hasNext()) {
            ParsedToolCallInfo toolCallInfo = it.next().getToolCallInfo();
            if (toolCallInfo != null && CollectionsKt.contains(of, toolCallInfo.getName()) && (result = toolCallInfo.getResult()) != null && (data = result.getData()) != null && (asJsonArray = data.getAsJsonArray("references")) != null) {
                Iterator it2 = asJsonArray.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    JsonElement jsonElement4 = (JsonElement) it2.next();
                    if (jsonElement4.isJsonObject() && (jsonElement = (asJsonObject = jsonElement4.getAsJsonObject()).get("link")) != null) {
                        if (!jsonElement.isJsonPrimitive()) {
                            jsonElement = null;
                        }
                        if (jsonElement != null && (asString = jsonElement.getAsString()) != null && linkedHashSet.add(asString)) {
                            JsonElement jsonElement5 = asJsonObject.get("title");
                            if (jsonElement5 != null) {
                                if (!jsonElement5.isJsonPrimitive()) {
                                    jsonElement5 = null;
                                }
                                if (jsonElement5 != null) {
                                    str = jsonElement5.getAsString();
                                }
                            }
                            str = "";
                            String str5 = str;
                            JsonElement jsonElement6 = asJsonObject.get("favicon");
                            if (jsonElement6 != null) {
                                if (!jsonElement6.isJsonPrimitive()) {
                                    jsonElement6 = null;
                                }
                                if (jsonElement6 != null) {
                                    str2 = jsonElement6.getAsString();
                                    jsonElement2 = asJsonObject.get("description");
                                    if (jsonElement2 != null) {
                                        if (!jsonElement2.isJsonPrimitive()) {
                                            jsonElement2 = null;
                                        }
                                        if (jsonElement2 != null) {
                                            str3 = jsonElement2.getAsString();
                                            jsonElement3 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                                            if (jsonElement3 != null) {
                                                if (!jsonElement3.isJsonPrimitive()) {
                                                    jsonElement3 = null;
                                                }
                                                if (jsonElement3 != null) {
                                                    str4 = jsonElement3.getAsString();
                                                    if (!(!StringsKt.isBlank(str5))) {
                                                        String str6 = str3;
                                                        if (!(str6 == null || StringsKt.isBlank(str6))) {
                                                        }
                                                    }
                                                    arrayList.add(new WebReference(str5, asString, str2, str3, str4));
                                                }
                                            }
                                            str4 = null;
                                            if (!(!StringsKt.isBlank(str5))) {
                                            }
                                            arrayList.add(new WebReference(str5, asString, str2, str3, str4));
                                        }
                                    }
                                    str3 = null;
                                    jsonElement3 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                                    if (jsonElement3 != null) {
                                    }
                                    str4 = null;
                                    if (!(!StringsKt.isBlank(str5))) {
                                    }
                                    arrayList.add(new WebReference(str5, asString, str2, str3, str4));
                                }
                            }
                            str2 = null;
                            jsonElement2 = asJsonObject.get("description");
                            if (jsonElement2 != null) {
                            }
                            str3 = null;
                            jsonElement3 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                            if (jsonElement3 != null) {
                            }
                            str4 = null;
                            if (!(!StringsKt.isBlank(str5))) {
                            }
                            arrayList.add(new WebReference(str5, asString, str2, str3, str4));
                        }
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return null;
    }

    private final String extractSummary(List<ParsedPlanItem> planItems, final String mainAgentRunId) {
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) SequencesKt.lastOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(planItems), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean extractSummary$lambda$24;
                extractSummary$lambda$24 = AgentContentBlockBuilder.extractSummary$lambda$24(mainAgentRunId, (ParsedPlanItem) obj);
                return Boolean.valueOf(extractSummary$lambda$24);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String extractSummary$lambda$27;
                extractSummary$lambda$27 = AgentContentBlockBuilder.extractSummary$lambda$27((ParsedPlanItem) obj);
                return extractSummary$lambda$27;
            }
        }));
    }

    public static final boolean extractSummary$lambda$24(String str, ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        return INSTANCE.isMainAgentFinish(parsedPlanItem, str);
    }

    public static final String extractSummary$lambda$27(ParsedPlanItem parsedPlanItem) {
        JsonObject params;
        JsonElement jsonElement;
        String asString;
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
        if (toolCallInfo == null || (params = toolCallInfo.getParams()) == null || (jsonElement = params.get("summary")) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || !(!StringsKt.isBlank(asString))) {
            return null;
        }
        return asString;
    }

    private final VoiceSummaryPayload extractVoiceSummary(List<ParsedPlanItem> planItems, String mainAgentRunId) {
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return null;
        }
        VoiceSummaryPayload extractVoiceSummaryFromFinishParams = extractVoiceSummaryFromFinishParams(planItems, mainAgentRunId);
        return extractVoiceSummaryFromFinishParams != null ? extractVoiceSummaryFromFinishParams : extractVoiceSummaryFromThought(planItems, mainAgentRunId);
    }

    private final VoiceSummaryPayload extractVoiceSummaryFromFinishParams(List<ParsedPlanItem> planItems, final String mainAgentRunId) {
        return (VoiceSummaryPayload) SequencesKt.lastOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(planItems), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean extractVoiceSummaryFromFinishParams$lambda$29;
                extractVoiceSummaryFromFinishParams$lambda$29 = AgentContentBlockBuilder.extractVoiceSummaryFromFinishParams$lambda$29(mainAgentRunId, (ParsedPlanItem) obj);
                return Boolean.valueOf(extractVoiceSummaryFromFinishParams$lambda$29);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                VoiceSummaryPayload extractVoiceSummaryFromFinishParams$lambda$30;
                extractVoiceSummaryFromFinishParams$lambda$30 = AgentContentBlockBuilder.extractVoiceSummaryFromFinishParams$lambda$30((ParsedPlanItem) obj);
                return extractVoiceSummaryFromFinishParams$lambda$30;
            }
        }));
    }

    public static final boolean extractVoiceSummaryFromFinishParams$lambda$29(String str, ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        return INSTANCE.isMainAgentFinish(parsedPlanItem, str);
    }

    public static final VoiceSummaryPayload extractVoiceSummaryFromFinishParams$lambda$30(ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        VoiceSummaryPayloadParser voiceSummaryPayloadParser = VoiceSummaryPayloadParser.INSTANCE;
        ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
        return voiceSummaryPayloadParser.parseParams(toolCallInfo != null ? toolCallInfo.getParams() : null);
    }

    private final VoiceSummaryPayload extractVoiceSummaryFromThought(List<ParsedPlanItem> planItems, final String mainAgentRunId) {
        return (VoiceSummaryPayload) SequencesKt.lastOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(planItems), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean extractVoiceSummaryFromThought$lambda$31;
                extractVoiceSummaryFromThought$lambda$31 = AgentContentBlockBuilder.extractVoiceSummaryFromThought$lambda$31(mainAgentRunId, (ParsedPlanItem) obj);
                return Boolean.valueOf(extractVoiceSummaryFromThought$lambda$31);
            }
        }), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                VoiceSummaryPayload extractVoiceSummaryFromThought$lambda$32;
                extractVoiceSummaryFromThought$lambda$32 = AgentContentBlockBuilder.extractVoiceSummaryFromThought$lambda$32((ParsedPlanItem) obj);
                return extractVoiceSummaryFromThought$lambda$32;
            }
        }));
    }

    public static final boolean extractVoiceSummaryFromThought$lambda$31(String str, ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        return INSTANCE.isMainAgentPlanItem(parsedPlanItem, str);
    }

    public static final VoiceSummaryPayload extractVoiceSummaryFromThought$lambda$32(ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        return INSTANCE.parseVoiceSummaryThoughtPayload(parsedPlanItem.getThought());
    }

    private final VoiceSummaryPayload parseVoiceSummaryThoughtPayload(String thought) {
        if (thought != null) {
            if (!(!StringsKt.isBlank(thought))) {
                thought = null;
            }
            if (thought != null) {
                String obj = StringsKt.trimStart(thought).toString();
                if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
                    String str = obj;
                    if (!StringsKt.contains$default(str, "\"header\"", false, 2, (Object) null) && !StringsKt.contains$default(str, "\"summary\"", false, 2, (Object) null) && !StringsKt.contains$default(str, "\"bottom\"", false, 2, (Object) null)) {
                        return new VoiceSummaryPayload("", thought, "");
                    }
                }
                return VoiceSummaryPayloadParser.INSTANCE.parseThought(thought);
            }
        }
        return null;
    }

    private final boolean isMainAgentPlanItem(ParsedPlanItem planItem, String mainAgentRunId) {
        String agentRunId = planItem.getAgentRunId();
        if (agentRunId == null) {
            agentRunId = "";
        }
        if ((mainAgentRunId.length() == 0) || Intrinsics.areEqual(agentRunId, mainAgentRunId)) {
            return true;
        }
        return agentRunId.length() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArtifactData extractProducts(List<ParsedPlanItem> planItems, String mainAgentRunId) {
        ParsedToolCallInfo toolCallInfo;
        ParsedToolCallResult result;
        ArtifactData products;
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ParsedPlanItem parsedPlanItem : planItems) {
            if (isMainAgentFinish(parsedPlanItem, mainAgentRunId) && (toolCallInfo = parsedPlanItem.getToolCallInfo()) != null && (result = toolCallInfo.getResult()) != null) {
                JsonElement data = result.getData();
                if (data != null) {
                    try {
                        FinishCardResult finishCardResult = (FinishCardResult) gson.fromJson(data, FinishCardResult.class);
                        FinishCardResultData data2 = finishCardResult.getData();
                        if (data2 == null || (products = data2.getProducts()) == null) {
                            products = finishCardResult.getProducts();
                        }
                        if (products != null) {
                            return products;
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
                while (r5.hasNext()) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<VideoArtifactPlanItemInput> buildVideoArtifactInputs(List<ParsedPlanItem> planItems) {
        ArtifactData artifactData;
        List<VideoFileDiffInfo> fileDiffInfos;
        ChangedVideoData changedVideos;
        JsonElement data;
        Object obj;
        if (planItems == null) {
            planItems = CollectionsKt.emptyList();
        }
        List<ParsedPlanItem> list = planItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ParsedPlanItem parsedPlanItem : list) {
            ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
            ParsedToolCallResult result = toolCallInfo != null ? toolCallInfo.getResult() : null;
            if (result != null && (data = result.getData()) != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl((FinishCardResult) gson.fromJson(data, FinishCardResult.class));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                FinishCardResult finishCardResult = (FinishCardResult) obj;
                if (finishCardResult != null) {
                    FinishCardResultData data2 = finishCardResult.getData();
                    if (data2 == null || (artifactData = data2.getProducts()) == null) {
                        artifactData = finishCardResult.getProducts();
                    }
                    String agentRunId = parsedPlanItem.getAgentRunId();
                    String name = toolCallInfo == null ? toolCallInfo.getName() : null;
                    String status = result == null ? result.getStatus() : null;
                    fileDiffInfos = (artifactData != null || (changedVideos = artifactData.getChangedVideos()) == null) ? null : changedVideos.getFileDiffInfos();
                    if (fileDiffInfos == null) {
                        fileDiffInfos = CollectionsKt.emptyList();
                    }
                    List<VideoFileDiffInfo> list2 = fileDiffInfos;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (VideoFileDiffInfo videoFileDiffInfo : list2) {
                        AgentContentBlockBuilder agentContentBlockBuilder = INSTANCE;
                        String primitiveStringOrNull = agentContentBlockBuilder.primitiveStringOrNull(videoFileDiffInfo.getFilePath());
                        String primitiveStringOrNull2 = agentContentBlockBuilder.primitiveStringOrNull(videoFileDiffInfo.getFileAction());
                        VideoInfoData videoInfo = videoFileDiffInfo.getVideoInfo();
                        arrayList2.add(new VideoArtifactFileInput(primitiveStringOrNull, primitiveStringOrNull2, videoInfo != null ? new VideoArtifactInfoInput(agentContentBlockBuilder.primitiveStringOrNull(videoInfo.getLastFrameUri()), agentContentBlockBuilder.primitiveIntOrNull(videoInfo.getDuration())) : null));
                    }
                    arrayList.add(new VideoArtifactPlanItemInput(agentRunId, name, status, arrayList2));
                }
            }
            artifactData = null;
            String agentRunId2 = parsedPlanItem.getAgentRunId();
            if (toolCallInfo == null) {
            }
            if (result == null) {
            }
            if (artifactData != null) {
            }
            if (fileDiffInfos == null) {
            }
            List<VideoFileDiffInfo> list22 = fileDiffInfos;
            ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list22, 10));
            while (r6.hasNext()) {
            }
            arrayList.add(new VideoArtifactPlanItemInput(agentRunId2, name, status, arrayList22));
        }
        return arrayList;
    }

    private final String primitiveStringOrNull(JsonElement jsonElement) {
        Object obj;
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final Integer primitiveIntOrNull(JsonElement jsonElement) {
        Object obj;
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Integer.valueOf(jsonElement.getAsInt()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final AgentContentBlock.TailStatus computeTailStatus(List<ParsedPlanItem> planItems) {
        ParsedPlanItem parsedPlanItem;
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return AgentContentBlock.TailStatus.THINKING;
        }
        ListIterator<ParsedPlanItem> listIterator = planItems.listIterator(planItems.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                parsedPlanItem = null;
                break;
            }
            parsedPlanItem = listIterator.previous();
            if (parsedPlanItem.getToolCallInfo() != null) {
                break;
            }
        }
        ParsedPlanItem parsedPlanItem2 = parsedPlanItem;
        ParsedToolCallInfo toolCallInfo = parsedPlanItem2 != null ? parsedPlanItem2.getToolCallInfo() : null;
        if (toolCallInfo != null) {
            ParsedToolCallResult result = toolCallInfo.getResult();
            String status = result != null ? result.getStatus() : null;
            if (Intrinsics.areEqual(status, "running") && isCodeGenTool(toolCallInfo.getName())) {
                return AgentContentBlock.TailStatus.GENERATING_CODE;
            }
            if (Intrinsics.areEqual(status, "running") && isCommandTool(toolCallInfo.getName())) {
                return AgentContentBlock.TailStatus.COMMAND_RUNNING;
            }
            if (Intrinsics.areEqual(status, "success")) {
                return AgentContentBlock.TailStatus.SUCCESS;
            }
            if (Intrinsics.areEqual(status, "failed") || Intrinsics.areEqual(status, "error")) {
                return AgentContentBlock.TailStatus.FAILED;
            }
            return Intrinsics.areEqual(status, "pending") ? AgentContentBlock.TailStatus.PENDING : AgentContentBlock.TailStatus.THINKING;
        }
        return AgentContentBlock.TailStatus.THINKING;
    }

    private final boolean isCodeGenTool(String name) {
        return CollectionsKt.contains(SetsKt.setOf(new String[]{"edit_file", "Write", "Edit", "MultiEdit", "SearchReplace", "create_file", "edit_file_search_replace", "edit_file_update", "write_to_file"}), name);
    }

    private final boolean isCommandTool(String name) {
        return CollectionsKt.contains(SetsKt.setOf(new String[]{"run_command", "RunCommand", "Shell", "exec_command"}), name);
    }

    private final boolean allPlanItemsAreFinishOnly(List<ParsedPlanItem> planItems) {
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return true;
        }
        List<ParsedPlanItem> list2 = planItems;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (ParsedPlanItem parsedPlanItem : list2) {
                ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
                String name = toolCallInfo != null ? toolCallInfo.getName() : null;
                boolean z = name != null && FINISH_TOOLS.contains(name);
                String reasoningContent = parsedPlanItem.getReasoningContent();
                if (!(Intrinsics.areEqual(parsedPlanItem.getHide(), true) || (z && !((reasoningContent == null || StringsKt.isBlank(reasoningContent)) ^ true)))) {
                    return false;
                }
            }
        }
        return true;
    }

    private final long computeDurationMs(Long startTime, Long endTime) {
        if (startTime == null) {
            return 0L;
        }
        return Math.max(0L, (endTime != null ? endTime.longValue() : System.currentTimeMillis()) - startTime.longValue());
    }
}
