package com.bytedance.trae.conversation.chat.viewholder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository;
import com.bytedance.trae.conversation.chat.FeedbackRepository;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.AgentContentBlockBuilder;
import com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload;
import com.bytedance.trae.conversation.chat.block.VoiceSummaryPayloadParser;
import com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView;
import com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryRenderer;
import com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow;
import com.bytedance.trae.conversation.chat.section.AgentProcessSectionView;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: AgentMessageViewHolder.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJF\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u00162\b\b\u0002\u0010G\u001a\u00020\u00162\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dJF\u0010J\u001a\u00020\"2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u00162\b\b\u0002\u0010G\u001a\u00020\u00162\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dJ<\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010M\u001a\u0004\u0018\u00010\u001e2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dH\u0002J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\"0\u001d2\u0006\u0010D\u001a\u00020EH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010R\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010S\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\u0018\u0010T\u001a\u00020\"2\u0006\u0010D\u001a\u00020E2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010X\u001a\u00020\"H\u0002J\u0010\u0010Y\u001a\u00020\"2\u0006\u0010Z\u001a\u00020\u0016H\u0002J\u0018\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020\"H\u0002J\u0010\u0010a\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010b\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010c\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020EH\u0002J\"\u0010d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010D\u001a\u00020E2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010\u000fH\u0002J$\u0010g\u001a\u0004\u0018\u00010\u001e2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010\u000f2\b\u0010h\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020f2\b\u0010k\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010l\u001a\u00020\u00162\u0006\u0010j\u001a\u00020f2\b\u0010k\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010m\u001a\u0004\u0018\u00010n2\n\u0010o\u001a\u0006\u0012\u0002\b\u00030pH\u0002J\u001e\u0010q\u001a\u00020\"2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010s\u001a\u00020tH\u0002J\u0016\u0010u\u001a\u00020\"2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0016\u0010v\u001a\u00020_2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J*\u0010w\u001a\u00020\"2\u0006\u0010x\u001a\u00020n2\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020_2\b\u0010{\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010|\u001a\u0004\u0018\u00010\u00102\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010z\u001a\u00020_H\u0002J\u0006\u0010}\u001a\u00020\"J\u0010\u0010~\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020nH\u0002J%\u0010~\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020n2\u0013\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\"0\u001dH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020nH\u0002J\t\u0010\u0082\u0001\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R7\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&RL\u0010*\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\"\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R7\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&RL\u00105\u001a4\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\"\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\"\u00109\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "contentContainer", "Landroid/widget/LinearLayout;", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "messageLister", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "<init>", "(Landroid/widget/LinearLayout;Lcom/bytedance/trae/im/service/Conversation;Lcom/bytedance/trae/conversation/chat/IMessageListener;)V", "getMessageLister", "()Lcom/bytedance/trae/conversation/chat/IMessageListener;", "setMessageLister", "(Lcom/bytedance/trae/conversation/chat/IMessageListener;)V", "lastBlocks", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "factory", "Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;", "processSectionView", "Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;", "lastIsLatestTurn", "", "copyIconResetHandler", "Landroid/os/Handler;", "copyIconResetRunnable", "Ljava/lang/Runnable;", "isLastAgent", "onRetryClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "assistantMessageId", "", "getOnRetryClick", "()Lkotlin/jvm/functions/Function1;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function1;)V", "onUseExpressPassClick", "getOnUseExpressPassClick", "setOnUseExpressPassClick", "onFeedbackClick", "Lkotlin/Function2;", "messageId", "resultType", "getOnFeedbackClick", "()Lkotlin/jvm/functions/Function2;", "setOnFeedbackClick", "(Lkotlin/jvm/functions/Function2;)V", "onCopyClick", "getOnCopyClick", "setOnCopyClick", "onReportClick", ReportConstant.COMMON_CONTENT, "getOnReportClick", "setOnReportClick", "onContentChanged", "Lkotlin/Function0;", "getOnContentChanged", "()Lkotlin/jvm/functions/Function0;", "setOnContentChanged", "(Lkotlin/jvm/functions/Function0;)V", "onPureShowWidgetInlineViewCreated", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "getOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease", "setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease", "bind", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "isLatestTurn", "isLastAgentMsg", "upgradeReminderConversationId", "onUpgradeReminderClick", "bindStreaming", "withUpgradeReminder", "blocks", "conversationId", "onClick", "buildActionCallback", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;", "currentConversation", "handleThumbsUp", "handleThumbsDown", "refreshFeedbackState", "newState", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "handleCopy", "showCopiedIconTemporarily", "setCopyButtonCopiedState", "copied", "tintIcon", "icon", "Landroid/widget/ImageView;", "colorRes", "", "cancelCopyIconReset", "handleMore", "showReportConfirmation", "buildCopyContent", "buildVoiceSummaryCopyContent", "planItems", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "findMainAgentRunId", "mainAgentId", "isMainAgentPlanItem", "planItem", "mainAgentRunId", "isFinishTool", "findViewByBlockClass", "Landroid/view/View;", "blockClass", "Lkotlin/reflect/KClass;", "fullRebuild", "newBlocks", "density", "", "incrementalUpdate", "findFirstResultIndex", "applyBlockSpacing", "view", "block", "index", "previousBlock", "previousRenderableBlock", "resetState", "notifyPureShowWidgetInlineViewCreated", "root", "callback", "releasePureShowWidgetInlineViews", "cancelAllTypewriters", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentMessageViewHolder extends RecyclerView.ViewHolder {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final long COPY_ICON_RESET_DELAY_MS = 3000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> FINISH_TOOLS = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "AgentFinish", "response_to_user", "ResponseToUser", "Task"});
    public static final String MORE_BUTTON_TAG = "more_button";
    private final LinearLayout contentContainer;
    private final Conversation conversation;
    private final Handler copyIconResetHandler;
    private Runnable copyIconResetRunnable;
    private final BlockRendererFactory factory;
    private boolean isLastAgent;
    private List<? extends AgentContentBlock> lastBlocks;
    private boolean lastIsLatestTurn;
    private IMessageListener messageLister;
    private Function0<Unit> onContentChanged;
    private Function1<? super String, Unit> onCopyClick;
    private Function2<? super String, ? super String, Unit> onFeedbackClick;
    private Function1<? super PureShowWidgetInlineView, Unit> onPureShowWidgetInlineViewCreated;
    private Function2<? super String, ? super String, Unit> onReportClick;
    private Function1<? super String, Unit> onRetryClick;
    private Function1<? super String, Unit> onUseExpressPassClick;
    private AgentProcessSectionView processSectionView;

    /* compiled from: AgentMessageViewHolder.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentContentBlock.ActionType.values().length];
            try {
                iArr[AgentContentBlock.ActionType.THUMBS_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentContentBlock.ActionType.THUMBS_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentContentBlock.ActionType.COPY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentContentBlock.ActionType.RETRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentContentBlock.ActionType.MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentContentBlock.ActionType.USER_ERPRESS_PASS_WHEN_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final IMessageListener getMessageLister() {
        return this.messageLister;
    }

    public final void setMessageLister(IMessageListener iMessageListener) {
        this.messageLister = iMessageListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMessageViewHolder(LinearLayout linearLayout, Conversation conversation, IMessageListener iMessageListener) {
        super(linearLayout);
        Intrinsics.checkNotNullParameter(linearLayout, "contentContainer");
        this.contentContainer = linearLayout;
        this.conversation = conversation;
        this.messageLister = iMessageListener;
        this.lastBlocks = CollectionsKt.emptyList();
        this.factory = BlockRendererFactory.INSTANCE.getInstance();
        this.lastIsLatestTurn = true;
        this.copyIconResetHandler = new Handler(Looper.getMainLooper());
    }

    public final Function1<String, Unit> getOnRetryClick() {
        return this.onRetryClick;
    }

    public final void setOnRetryClick(Function1<? super String, Unit> function1) {
        this.onRetryClick = function1;
    }

    public final Function1<String, Unit> getOnUseExpressPassClick() {
        return this.onUseExpressPassClick;
    }

    public final void setOnUseExpressPassClick(Function1<? super String, Unit> function1) {
        this.onUseExpressPassClick = function1;
    }

    public final Function2<String, String, Unit> getOnFeedbackClick() {
        return this.onFeedbackClick;
    }

    public final void setOnFeedbackClick(Function2<? super String, ? super String, Unit> function2) {
        this.onFeedbackClick = function2;
    }

    public final Function1<String, Unit> getOnCopyClick() {
        return this.onCopyClick;
    }

    public final void setOnCopyClick(Function1<? super String, Unit> function1) {
        this.onCopyClick = function1;
    }

    public final Function2<String, String, Unit> getOnReportClick() {
        return this.onReportClick;
    }

    public final void setOnReportClick(Function2<? super String, ? super String, Unit> function2) {
        this.onReportClick = function2;
    }

    public final Function0<Unit> getOnContentChanged() {
        return this.onContentChanged;
    }

    public final void setOnContentChanged(Function0<Unit> function0) {
        this.onContentChanged = function0;
    }

    /* renamed from: getOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease */
    public final Function1<PureShowWidgetInlineView, Unit> m828x43ae1e4f() {
        return this.onPureShowWidgetInlineViewCreated;
    }

    /* renamed from: setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease */
    public final void m829xe8a7be5b(Function1<? super PureShowWidgetInlineView, Unit> function1) {
        this.onPureShowWidgetInlineViewCreated = function1;
    }

    public static /* synthetic */ void bind$default(AgentMessageViewHolder agentMessageViewHolder, ParsedChatMessage parsedChatMessage, boolean z, boolean z2, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = false;
        }
        agentMessageViewHolder.bind(parsedChatMessage, z3, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function1);
    }

    public final void bind(ParsedChatMessage message, boolean isLatestTurn, boolean isLastAgentMsg, String upgradeReminderConversationId, Function1<? super String, Unit> onUpgradeReminderClick) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.lastIsLatestTurn = isLatestTurn;
        this.isLastAgent = isLastAgentMsg;
        Function1<AgentContentBlock.ActionType, Unit> buildActionCallback = buildActionCallback(message);
        AgentContentBlock.FeedbackState feedbackState = FeedbackRepository.INSTANCE.getFeedbackState(message.getMessageId());
        AgentContentBlockBuilder agentContentBlockBuilder = AgentContentBlockBuilder.INSTANCE;
        Resources resources = this.itemView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        List<AgentContentBlock> withUpgradeReminder = withUpgradeReminder(AgentContentBlockBuilder.build$default(agentContentBlockBuilder, message, resources, currentConversation(), buildActionCallback, this.messageLister, isLatestTurn, this.isLastAgent, feedbackState, 0, 0, false, 1792, null), upgradeReminderConversationId, onUpgradeReminderClick);
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("[Node8] VH.bind: blockCount=").append(withUpgradeReminder.size()).append(", types=");
        List<AgentContentBlock> list = withUpgradeReminder;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Reflection.getOrCreateKotlinClass(((AgentContentBlock) it.next()).getClass()).getSimpleName());
        }
        traeLogUtil.d(AGENT_FLOW_TAG, append.append(arrayList).toString());
        if ((!this.lastBlocks.isEmpty()) && this.contentContainer.getChildCount() > 0 && Intrinsics.areEqual(withUpgradeReminder, this.lastBlocks)) {
            this.lastBlocks = withUpgradeReminder;
        } else {
            fullRebuild(withUpgradeReminder, this.contentContainer.getContext().getResources().getDisplayMetrics().density);
            this.lastBlocks = withUpgradeReminder;
        }
    }

    public static /* synthetic */ void bindStreaming$default(AgentMessageViewHolder agentMessageViewHolder, ParsedChatMessage parsedChatMessage, boolean z, boolean z2, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            z2 = false;
        }
        agentMessageViewHolder.bindStreaming(parsedChatMessage, z3, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function1);
    }

    public final void bindStreaming(ParsedChatMessage message, boolean isLatestTurn, boolean isLastAgentMsg, String upgradeReminderConversationId, Function1<? super String, Unit> onUpgradeReminderClick) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.lastIsLatestTurn = isLatestTurn;
        this.isLastAgent = isLastAgentMsg;
        Function1<AgentContentBlock.ActionType, Unit> buildActionCallback = buildActionCallback(message);
        AgentContentBlock.FeedbackState feedbackState = FeedbackRepository.INSTANCE.getFeedbackState(message.getMessageId());
        AgentContentBlockBuilder agentContentBlockBuilder = AgentContentBlockBuilder.INSTANCE;
        Resources resources = this.itemView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        List<AgentContentBlock> withUpgradeReminder = withUpgradeReminder(AgentContentBlockBuilder.build$default(agentContentBlockBuilder, message, resources, currentConversation(), buildActionCallback, this.messageLister, isLatestTurn, this.isLastAgent, feedbackState, 0, 0, false, 1792, null), upgradeReminderConversationId, onUpgradeReminderClick);
        float f = this.contentContainer.getContext().getResources().getDisplayMetrics().density;
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node8] VH.bindStreaming: blockCount=" + withUpgradeReminder.size() + ", mode=" + ((this.lastBlocks.isEmpty() || this.contentContainer.getChildCount() == 0) ? "fullRebuild" : "incremental") + ", lastBlockCount=" + this.lastBlocks.size() + ", containerChildren=" + this.contentContainer.getChildCount());
        if (this.lastBlocks.isEmpty() || this.contentContainer.getChildCount() == 0) {
            fullRebuild(withUpgradeReminder, f);
        } else {
            incrementalUpdate(withUpgradeReminder);
        }
        this.lastBlocks = withUpgradeReminder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<AgentContentBlock> withUpgradeReminder(List<? extends AgentContentBlock> blocks, String conversationId, Function1<? super String, Unit> onClick) {
        int i;
        if (conversationId == null) {
            return blocks;
        }
        if (!(!StringsKt.isBlank(conversationId))) {
            conversationId = null;
        }
        if (conversationId == null) {
            return blocks;
        }
        ListIterator listIterator = blocks.listIterator(blocks.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            if (((AgentContentBlock) listIterator.previous()) instanceof AgentContentBlock.ActionBar) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i < 0) {
            return blocks;
        }
        List<AgentContentBlock> mutableList = CollectionsKt.toMutableList(blocks);
        mutableList.add(i, new AgentContentBlock.UpgradeReminder(conversationId, onClick));
        return mutableList;
    }

    private final Function1<AgentContentBlock.ActionType, Unit> buildActionCallback(final ParsedChatMessage message) {
        return new Function1() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit buildActionCallback$lambda$4;
                buildActionCallback$lambda$4 = AgentMessageViewHolder.buildActionCallback$lambda$4(AgentMessageViewHolder.this, message, (AgentContentBlock.ActionType) obj);
                return buildActionCallback$lambda$4;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildActionCallback$lambda$4(AgentMessageViewHolder agentMessageViewHolder, ParsedChatMessage parsedChatMessage, AgentContentBlock.ActionType actionType) {
        Intrinsics.checkNotNullParameter(actionType, ReportConstant.COMMON_ACTION_TYPE);
        switch (WhenMappings.$EnumSwitchMapping$0[actionType.ordinal()]) {
            case 1:
                agentMessageViewHolder.handleThumbsUp(parsedChatMessage);
                break;
            case 2:
                agentMessageViewHolder.handleThumbsDown(parsedChatMessage);
                break;
            case 3:
                agentMessageViewHolder.handleCopy(parsedChatMessage);
                break;
            case 4:
                Function1<? super String, Unit> function1 = agentMessageViewHolder.onRetryClick;
                if (function1 != null) {
                    function1.invoke(parsedChatMessage.getMessageId());
                    break;
                }
                break;
            case 5:
                agentMessageViewHolder.handleMore(parsedChatMessage);
                break;
            case 6:
                Function1<? super String, Unit> function12 = agentMessageViewHolder.onUseExpressPassClick;
                if (function12 != null) {
                    function12.invoke(parsedChatMessage.getMessageId());
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    private final Conversation currentConversation() {
        Conversation currentConversation;
        IMessageListener iMessageListener = this.messageLister;
        return (iMessageListener == null || (currentConversation = iMessageListener.getCurrentConversation()) == null) ? this.conversation : currentConversation;
    }

    private final void handleThumbsUp(ParsedChatMessage message) {
        AgentContentBlock.FeedbackState feedbackState;
        Function2<? super String, ? super String, Unit> function2;
        if (FeedbackRepository.INSTANCE.getFeedbackState(message.getMessageId()) == AgentContentBlock.FeedbackState.THUMBS_UP) {
            feedbackState = AgentContentBlock.FeedbackState.NONE;
        } else {
            feedbackState = AgentContentBlock.FeedbackState.THUMBS_UP;
        }
        FeedbackRepository.INSTANCE.saveFeedbackState(message.getMessageId(), feedbackState);
        this.contentContainer.performHapticFeedback(6);
        if (feedbackState != AgentContentBlock.FeedbackState.NONE && (function2 = this.onFeedbackClick) != null) {
            function2.invoke(message.getMessageId(), "like");
        }
        refreshFeedbackState(message, feedbackState);
    }

    private final void handleThumbsDown(ParsedChatMessage message) {
        AgentContentBlock.FeedbackState feedbackState;
        Function2<? super String, ? super String, Unit> function2;
        if (FeedbackRepository.INSTANCE.getFeedbackState(message.getMessageId()) == AgentContentBlock.FeedbackState.THUMBS_DOWN) {
            feedbackState = AgentContentBlock.FeedbackState.NONE;
        } else {
            feedbackState = AgentContentBlock.FeedbackState.THUMBS_DOWN;
        }
        FeedbackRepository.INSTANCE.saveFeedbackState(message.getMessageId(), feedbackState);
        this.contentContainer.performHapticFeedback(6);
        if (feedbackState != AgentContentBlock.FeedbackState.NONE && (function2 = this.onFeedbackClick) != null) {
            function2.invoke(message.getMessageId(), "dislike");
        }
        refreshFeedbackState(message, feedbackState);
    }

    private final void refreshFeedbackState(ParsedChatMessage message, AgentContentBlock.FeedbackState newState) {
        int i;
        AgentContentBlock.ActionBar copy;
        List<? extends AgentContentBlock> list = this.lastBlocks;
        ListIterator<? extends AgentContentBlock> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            } else if (listIterator.previous() instanceof AgentContentBlock.ActionBar) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i < 0) {
            bind$default(this, message, this.lastIsLatestTurn, this.isLastAgent, null, null, 24, null);
            return;
        }
        AgentContentBlock agentContentBlock = this.lastBlocks.get(i);
        Intrinsics.checkNotNull(agentContentBlock, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.ActionBar");
        copy = r9.copy((r22 & 1) != 0 ? r9.status : null, (r22 & 2) != 0 ? r9.messageId : null, (r22 & 4) != 0 ? r9.tokenUsage : null, (r22 & 8) != 0 ? r9.isUserCanceled : null, (r22 & 16) != 0 ? r9.feedbackState : newState, (r22 & 32) != 0 ? r9.showFeedback : false, (r22 & 64) != 0 ? r9.showManualStopStatus : false, (r22 & 128) != 0 ? r9.showInterjectedStatus : false, (r22 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r9.isVoiceSummaryStyle : false, (r22 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? ((AgentContentBlock.ActionBar) agentContentBlock).onActionClick : null);
        List<? extends AgentContentBlock> mutableList = CollectionsKt.toMutableList(this.lastBlocks);
        mutableList.set(i, copy);
        this.lastBlocks = mutableList;
        View findViewByBlockClass = findViewByBlockClass(Reflection.getOrCreateKotlinClass(AgentContentBlock.ActionBar.class));
        ViewGroup viewGroup = findViewByBlockClass instanceof ViewGroup ? (ViewGroup) findViewByBlockClass : null;
        if (viewGroup == null) {
            bind$default(this, message, this.lastIsLatestTurn, this.isLastAgent, null, null, 24, null);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewWithTag(ActionBarRenderer.THUMBS_UP_TAG);
        View childAt = frameLayout != null ? frameLayout.getChildAt(0) : null;
        ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
        boolean z = newState == AgentContentBlock.FeedbackState.THUMBS_UP;
        if (imageView != null) {
            imageView.setImageResource(z ? C0637R.drawable.trae_ic_thumbs_up_filled : C0637R.drawable.trae_ic_thumbs_up);
        }
        if (imageView != null) {
            tintIcon(imageView, C0591R.color.trae_icon_icon_default);
        }
        FrameLayout frameLayout2 = (FrameLayout) viewGroup.findViewWithTag(ActionBarRenderer.THUMBS_DOWN_TAG);
        KeyEvent.Callback childAt2 = frameLayout2 != null ? frameLayout2.getChildAt(0) : null;
        ImageView imageView2 = childAt2 instanceof ImageView ? (ImageView) childAt2 : null;
        boolean z2 = newState == AgentContentBlock.FeedbackState.THUMBS_DOWN;
        if (imageView2 != null) {
            imageView2.setImageResource(z2 ? C0637R.drawable.trae_ic_thumbs_down_filled : C0637R.drawable.trae_ic_thumbs_down);
        }
        if (imageView2 != null) {
            tintIcon(imageView2, C0591R.color.trae_icon_icon_default);
        }
    }

    private final void handleCopy(ParsedChatMessage message) {
        Context context = this.contentContainer.getContext();
        String buildCopyContent = buildCopyContent(message);
        if (StringsKt.isBlank(buildCopyContent)) {
            CustomToast.showLong(context, R.string.trae_conversation_no_copyable_content);
            return;
        }
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("message", buildCopyContent));
        CustomToast.showLong(context, R.string.trae_conversation_copied);
        showCopiedIconTemporarily();
        Function1<? super String, Unit> function1 = this.onCopyClick;
        if (function1 != null) {
            function1.invoke(message.getMessageId());
        }
    }

    private final void showCopiedIconTemporarily() {
        setCopyButtonCopiedState(true);
        Runnable runnable = this.copyIconResetRunnable;
        if (runnable != null) {
            this.copyIconResetHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AgentMessageViewHolder.showCopiedIconTemporarily$lambda$10(AgentMessageViewHolder.this);
            }
        };
        this.copyIconResetRunnable = runnable2;
        this.copyIconResetHandler.postDelayed(runnable2, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCopiedIconTemporarily$lambda$10(AgentMessageViewHolder agentMessageViewHolder) {
        agentMessageViewHolder.copyIconResetRunnable = null;
        agentMessageViewHolder.setCopyButtonCopiedState(false);
    }

    private final void setCopyButtonCopiedState(boolean copied) {
        FrameLayout frameLayout;
        int i;
        Context context = this.contentContainer.getContext();
        View findViewByBlockClass = findViewByBlockClass(Reflection.getOrCreateKotlinClass(AgentContentBlock.ActionBar.class));
        ViewGroup viewGroup = findViewByBlockClass instanceof ViewGroup ? (ViewGroup) findViewByBlockClass : null;
        if (viewGroup == null || (frameLayout = (FrameLayout) viewGroup.findViewWithTag(ActionBarRenderer.COPY_TAG)) == null) {
            return;
        }
        if (copied) {
            i = R.string.trae_conversation_copied;
        } else {
            i = C0637R.string.trae_message_menu_copy;
        }
        frameLayout.setContentDescription(context.getString(i));
        View childAt = frameLayout.getChildAt(0);
        ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
        if (imageView == null) {
            return;
        }
        if (copied) {
            imageView.setImageResource(C0637R.drawable.trae_ic_copy_checkmark);
            tintIcon(imageView, C0591R.color.trae_icon_icon_default);
        } else {
            imageView.setImageResource(C0637R.drawable.trae_ic_copy);
            tintIcon(imageView, C0591R.color.trae_icon_icon_default);
        }
        imageView.jumpDrawablesToCurrentState();
        imageView.invalidate();
    }

    private final void tintIcon(ImageView icon, int colorRes) {
        ImageViewCompat.setImageTintList(icon, ColorStateList.valueOf(ContextCompat.getColor(this.contentContainer.getContext(), colorRes)));
    }

    private final void cancelCopyIconReset() {
        Runnable runnable = this.copyIconResetRunnable;
        if (runnable != null) {
            this.copyIconResetHandler.removeCallbacks(runnable);
        }
        this.copyIconResetRunnable = null;
    }

    private final void handleMore(final ParsedChatMessage message) {
        View findViewWithTag;
        View view;
        View findViewByBlockClass = findViewByBlockClass(Reflection.getOrCreateKotlinClass(AgentContentBlock.ActionBar.class));
        ViewGroup viewGroup = findViewByBlockClass instanceof ViewGroup ? (ViewGroup) findViewByBlockClass : null;
        if (viewGroup == null || (findViewWithTag = viewGroup.findViewWithTag(MORE_BUTTON_TAG)) == null) {
            return;
        }
        ViewGroup viewGroup2 = findViewWithTag instanceof ViewGroup ? (ViewGroup) findViewWithTag : null;
        if (viewGroup2 == null || (view = viewGroup2.getChildAt(0)) == null) {
            view = findViewWithTag;
        }
        boolean z = !UserMessageViewHolderKt.isBrainstormMessage(message);
        Context context = this.contentContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new ActionBarPopupWindow(context, new ActionBarPopupWindow.OnMenuClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$handleMore$popup$1
            @Override // com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow.OnMenuClickListener
            public void onRetryClick() {
                Function1<String, Unit> onRetryClick = AgentMessageViewHolder.this.getOnRetryClick();
                if (onRetryClick != null) {
                    onRetryClick.invoke(message.getMessageId());
                }
            }

            @Override // com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow.OnMenuClickListener
            public void onReportClick() {
                AgentMessageViewHolder.this.showReportConfirmation(message);
            }
        }, z).showAbove(findViewWithTag, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showReportConfirmation(final ParsedChatMessage message) {
        Context context = this.contentContainer.getContext();
        Intrinsics.checkNotNull(context);
        String string = context.getString(C0637R.string.trae_report_confirm_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C0637R.string.trae_report_confirm_message);
        String string3 = context.getString(C0637R.string.trae_report_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = context.getString(C0637R.string.trae_report_confirm);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog(context, new CustomConfirmDialog.Config(string, string2, null, null, string3, string4, null, 0.0f, null, null, null, null, 0, 0, 0, null, null, null, false, new Function1() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showReportConfirmation$lambda$12;
                showReportConfirmation$lambda$12 = AgentMessageViewHolder.showReportConfirmation$lambda$12(AgentMessageViewHolder.this, message, (String) obj);
                return showReportConfirmation$lambda$12;
            }
        }, null, 1572812, null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showReportConfirmation$lambda$12(AgentMessageViewHolder agentMessageViewHolder, ParsedChatMessage parsedChatMessage, String str) {
        String buildCopyContent = agentMessageViewHolder.buildCopyContent(parsedChatMessage);
        Function2<? super String, ? super String, Unit> function2 = agentMessageViewHolder.onReportClick;
        if (function2 != null) {
            function2.invoke(parsedChatMessage.getMessageId(), buildCopyContent);
        }
        return Unit.INSTANCE;
    }

    private final String buildCopyContent(ParsedChatMessage message) {
        ArrayList<ParsedPlanItem> arrayList;
        Sequence asSequence;
        Sequence filter;
        Sequence mapNotNull;
        String buildVoiceSummaryCopyContent;
        List<ParsedPlanItemMessage> messages;
        StringBuilder sb = new StringBuilder();
        Object content = message.getContent();
        String str = null;
        ParsedTaskContent parsedTaskContent = content instanceof ParsedTaskContent ? (ParsedTaskContent) content : null;
        if (parsedTaskContent == null || (messages = parsedTaskContent.getMessages()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
                if (planItem != null) {
                    arrayList2.add(planItem);
                }
            }
            arrayList = arrayList2;
        }
        if (Intrinsics.areEqual(message.getAgentType(), BrainstormSummaryRepository.AGENT_TYPE_VOICE_SUMMARY) && (buildVoiceSummaryCopyContent = buildVoiceSummaryCopyContent(message, arrayList)) != null) {
            if (!(!StringsKt.isBlank(buildVoiceSummaryCopyContent))) {
                buildVoiceSummaryCopyContent = null;
            }
            if (buildVoiceSummaryCopyContent != null) {
                return buildVoiceSummaryCopyContent;
            }
        }
        if (arrayList != null) {
            for (ParsedPlanItem parsedPlanItem : arrayList) {
                String thought = parsedPlanItem.getThought();
                String str2 = thought;
                if (!(str2 == null || str2.length() == 0)) {
                    if (sb.length() > 0) {
                        sb.append("\n\n");
                    }
                    sb.append(thought);
                }
                String reasoningContent = parsedPlanItem.getReasoningContent();
                String str3 = reasoningContent;
                if (!(str3 == null || str3.length() == 0)) {
                    if (sb.length() > 0) {
                        sb.append("\n\n");
                    }
                    sb.append(reasoningContent);
                }
            }
        }
        String agentId = message.getAgentId();
        if (agentId == null) {
            agentId = message.getAgentType();
        }
        final String findMainAgentRunId = findMainAgentRunId(arrayList, agentId);
        if (arrayList != null && (asSequence = CollectionsKt.asSequence(arrayList)) != null && (filter = SequencesKt.filter(asSequence, new Function1() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                boolean buildCopyContent$lambda$17;
                buildCopyContent$lambda$17 = AgentMessageViewHolder.buildCopyContent$lambda$17(AgentMessageViewHolder.this, findMainAgentRunId, (ParsedPlanItem) obj);
                return Boolean.valueOf(buildCopyContent$lambda$17);
            }
        })) != null && (mapNotNull = SequencesKt.mapNotNull(filter, new Function1() { // from class: com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                String buildCopyContent$lambda$19;
                buildCopyContent$lambda$19 = AgentMessageViewHolder.buildCopyContent$lambda$19((ParsedPlanItem) obj);
                return buildCopyContent$lambda$19;
            }
        })) != null) {
            str = (String) SequencesKt.firstOrNull(mapNotNull);
        }
        String str4 = str;
        if (!(str4 == null || str4.length() == 0)) {
            if (sb.length() > 0) {
                sb.append("\n\n");
            }
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean buildCopyContent$lambda$17(AgentMessageViewHolder agentMessageViewHolder, String str, ParsedPlanItem parsedPlanItem) {
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        return agentMessageViewHolder.isFinishTool(parsedPlanItem, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildCopyContent$lambda$19(ParsedPlanItem parsedPlanItem) {
        JsonObject params;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(parsedPlanItem, "it");
        ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
        if (toolCallInfo == null || (params = toolCallInfo.getParams()) == null || (jsonElement = params.get("summary")) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }

    private final String buildVoiceSummaryCopyContent(ParsedChatMessage message, List<ParsedPlanItem> planItems) {
        String extractSummaryText;
        VoiceSummaryPayload parseThought;
        String markdown;
        List<ParsedPlanItem> list = planItems;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String agentId = message.getAgentId();
        if (agentId == null) {
            agentId = message.getAgentType();
        }
        String findMainAgentRunId = findMainAgentRunId(planItems, agentId);
        ArrayList arrayList = new ArrayList();
        for (ParsedPlanItem parsedPlanItem : planItems) {
            if (isMainAgentPlanItem(parsedPlanItem, findMainAgentRunId) && (parseThought = VoiceSummaryPayloadParser.INSTANCE.parseThought(parsedPlanItem.getThought())) != null && (markdown = parseThought.getMarkdown()) != null) {
                if (!(!StringsKt.isBlank(markdown))) {
                    markdown = null;
                }
                if (markdown != null) {
                    arrayList.add(markdown);
                }
            }
            if (isFinishTool(parsedPlanItem, findMainAgentRunId)) {
                ParsedToolCallInfo toolCallInfo = parsedPlanItem.getToolCallInfo();
                JsonObject params = toolCallInfo != null ? toolCallInfo.getParams() : null;
                VoiceSummaryPayload parseParams = VoiceSummaryPayloadParser.INSTANCE.parseParams(params);
                if (parseParams == null || (extractSummaryText = parseParams.getMarkdown()) == null) {
                    extractSummaryText = VoiceSummaryPayloadParser.INSTANCE.extractSummaryText(params != null ? params.get("summary") : null);
                }
                if (!(!StringsKt.isBlank(extractSummaryText))) {
                    extractSummaryText = null;
                }
                if (extractSummaryText != null) {
                    arrayList.add(extractSummaryText);
                }
            }
        }
        return (String) CollectionsKt.lastOrNull(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[EDGE_INSN: B:17:0x003e->B:18:0x003e BREAK  A[LOOP:0: B:4:0x000c->B:25:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:0: B:4:0x000c->B:25:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String findMainAgentRunId(List<ParsedPlanItem> planItems, String mainAgentId) {
        Object obj;
        Object obj2;
        String agentRunId;
        boolean z;
        if (planItems != null) {
            Iterator<T> it = planItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                ParsedPlanItem parsedPlanItem = (ParsedPlanItem) obj2;
                if (Intrinsics.areEqual(parsedPlanItem.getAgentId(), mainAgentId)) {
                    String agentRunId2 = parsedPlanItem.getAgentRunId();
                    if (!(agentRunId2 == null || agentRunId2.length() == 0)) {
                        z = true;
                        if (!z) {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            ParsedPlanItem parsedPlanItem2 = (ParsedPlanItem) obj2;
            if (parsedPlanItem2 != null && (agentRunId = parsedPlanItem2.getAgentRunId()) != null) {
                return agentRunId;
            }
        }
        if (planItems == null) {
            return null;
        }
        Iterator<T> it2 = planItems.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            String agentRunId3 = ((ParsedPlanItem) obj).getAgentRunId();
            if (!(agentRunId3 == null || agentRunId3.length() == 0)) {
                break;
            }
        }
        ParsedPlanItem parsedPlanItem3 = (ParsedPlanItem) obj;
        if (parsedPlanItem3 != null) {
            return parsedPlanItem3.getAgentRunId();
        }
        return null;
    }

    private final boolean isMainAgentPlanItem(ParsedPlanItem planItem, String mainAgentRunId) {
        String agentRunId = planItem.getAgentRunId();
        String str = mainAgentRunId;
        if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(agentRunId, mainAgentRunId)) {
            String str2 = agentRunId;
            if (!(str2 == null || str2.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private final boolean isFinishTool(ParsedPlanItem planItem, String mainAgentRunId) {
        String name;
        ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
        if (toolCallInfo == null || (name = toolCallInfo.getName()) == null || !FINISH_TOOLS.contains(name)) {
            return false;
        }
        String agentRunId = planItem.getAgentRunId();
        if (!Intrinsics.areEqual(agentRunId, mainAgentRunId)) {
            String str = agentRunId;
            if (!(str == null || str.length() == 0)) {
                return false;
            }
            String str2 = mainAgentRunId;
            if (!(str2 == null || str2.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private final View findViewByBlockClass(KClass<?> blockClass) {
        int childCount = this.contentContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.contentContainer.getChildAt(i);
            if (Intrinsics.areEqual(childAt.getTag(C0637R.id.tag_block_class), blockClass)) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r3 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fullRebuild(List<? extends AgentContentBlock> newBlocks, float density) {
        Context context = this.contentContainer.getContext();
        cancelAllTypewriters();
        cancelCopyIconReset();
        releasePureShowWidgetInlineViews(this.contentContainer);
        this.contentContainer.removeAllViews();
        this.processSectionView = null;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (Object obj : newBlocks) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AgentContentBlock agentContentBlock = (AgentContentBlock) obj;
            if (agentContentBlock instanceof AgentContentBlock.ProcessStart) {
                AgentProcessSectionView agentProcessSectionView = this.processSectionView;
                if (agentProcessSectionView != null) {
                    agentProcessSectionView.reset();
                }
                Intrinsics.checkNotNull(context);
                agentProcessSectionView = new AgentProcessSectionView(context, null, 0, 6, null);
                this.processSectionView = agentProcessSectionView;
                agentProcessSectionView.setTag(C0637R.id.tag_on_content_changed, this.onContentChanged);
                agentProcessSectionView.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, this.onPureShowWidgetInlineViewCreated);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i2 > 0) {
                    layoutParams.topMargin = (int) (24 * density);
                }
                this.contentContainer.addView(agentProcessSectionView, layoutParams);
                arrayList.clear();
                i2++;
                z = true;
            } else if (agentContentBlock instanceof AgentContentBlock.ProcessEnd) {
                AgentContentBlock.ProcessEnd processEnd = (AgentContentBlock.ProcessEnd) agentContentBlock;
                AgentProcessSectionView.ProcessState processState = processEnd.isCompleted() ? AgentProcessSectionView.ProcessState.COMPLETED : AgentProcessSectionView.ProcessState.IN_PROGRESS;
                AgentProcessSectionView agentProcessSectionView2 = this.processSectionView;
                if (agentProcessSectionView2 != null) {
                    agentProcessSectionView2.updateBlocks(CollectionsKt.toList(arrayList), processState);
                }
                AgentProcessSectionView agentProcessSectionView3 = this.processSectionView;
                if (agentProcessSectionView3 != null) {
                    agentProcessSectionView3.setState(processEnd.isCompleted() ? AgentProcessSectionView.ProcessState.COMPLETED : AgentProcessSectionView.ProcessState.IN_PROGRESS, processEnd.getDurationMs(), processEnd.getAutoCollapse());
                }
                if (arrayList.isEmpty() && processEnd.isCompleted()) {
                    AgentProcessSectionView agentProcessSectionView4 = this.processSectionView;
                    if (agentProcessSectionView4 != null) {
                        AgentProcessSectionView agentProcessSectionView5 = agentProcessSectionView4;
                        releasePureShowWidgetInlineViews(agentProcessSectionView5);
                        this.contentContainer.removeView(agentProcessSectionView5);
                    }
                    this.processSectionView = null;
                    i2--;
                }
                z = false;
            } else if (z) {
                arrayList.add(agentContentBlock);
            } else {
                IBlockRenderer renderer = this.factory.getRenderer(agentContentBlock);
                if (renderer != null) {
                    Intrinsics.checkNotNull(context);
                    View render = renderer.render(context, agentContentBlock);
                    render.setTag(C0637R.id.tag_on_content_changed, this.onContentChanged);
                    render.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, this.onPureShowWidgetInlineViewCreated);
                    render.setTag(C0637R.id.tag_block_class, Reflection.getOrCreateKotlinClass(agentContentBlock.getClass()));
                    notifyPureShowWidgetInlineViewCreated(render);
                    applyBlockSpacing(render, agentContentBlock, i2, previousRenderableBlock(newBlocks, i));
                    this.contentContainer.addView(render);
                    i2++;
                }
            }
            i = i3;
        }
    }

    private final void incrementalUpdate(List<? extends AgentContentBlock> newBlocks) {
        int i;
        int i2;
        int i3;
        Object obj;
        Object obj2;
        int i4;
        List<? extends AgentContentBlock> emptyList;
        List<? extends AgentContentBlock> emptyList2;
        IBlockRenderer renderer;
        int i5;
        View childAt;
        View childAt2;
        IBlockRenderer renderer2;
        List<? extends AgentContentBlock> list = this.lastBlocks;
        ListIterator<? extends AgentContentBlock> listIterator = list.listIterator(list.size());
        while (true) {
            i = -1;
            if (!listIterator.hasPrevious()) {
                i3 = -1;
                break;
            }
            AgentContentBlock previous = listIterator.previous();
            if ((previous instanceof AgentContentBlock.InitialLoading) || (previous instanceof AgentContentBlock.VoiceSummaryLoading)) {
                i3 = listIterator.nextIndex();
                break;
            }
        }
        if (i3 >= 0) {
            int childCount = this.contentContainer.getChildCount() - (this.lastBlocks.size() - i3);
            if (childCount >= 0 && childCount < this.contentContainer.getChildCount()) {
                this.contentContainer.removeViewAt(childCount);
            }
            List<? extends AgentContentBlock> list2 = this.lastBlocks;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list2) {
                AgentContentBlock agentContentBlock = (AgentContentBlock) obj3;
                if (!((agentContentBlock instanceof AgentContentBlock.InitialLoading) || (agentContentBlock instanceof AgentContentBlock.VoiceSummaryLoading))) {
                    arrayList.add(obj3);
                }
            }
            this.lastBlocks = arrayList;
        }
        Context context = this.contentContainer.getContext();
        Iterator<T> it = this.lastBlocks.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((AgentContentBlock) obj) instanceof AgentContentBlock.Avatar) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        AgentContentBlock agentContentBlock2 = (AgentContentBlock) obj;
        Iterator<T> it2 = newBlocks.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (((AgentContentBlock) obj2) instanceof AgentContentBlock.Avatar) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        AgentContentBlock agentContentBlock3 = (AgentContentBlock) obj2;
        if (agentContentBlock2 != null && agentContentBlock3 != null && !Intrinsics.areEqual(agentContentBlock2, agentContentBlock3) && (childAt2 = this.contentContainer.getChildAt(0)) != null && Intrinsics.areEqual(childAt2.getTag(C0637R.id.tag_block_class), Reflection.getOrCreateKotlinClass(AgentContentBlock.Avatar.class)) && (renderer2 = this.factory.getRenderer(agentContentBlock3)) != null) {
            renderer2.update(childAt2, agentContentBlock3);
        }
        Iterator<? extends AgentContentBlock> it3 = newBlocks.iterator();
        int i6 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i6 = -1;
                break;
            } else if (it3.next() instanceof AgentContentBlock.ProcessStart) {
                break;
            } else {
                i6++;
            }
        }
        ListIterator<? extends AgentContentBlock> listIterator2 = newBlocks.listIterator(newBlocks.size());
        while (true) {
            if (listIterator2.hasPrevious()) {
                if (listIterator2.previous() instanceof AgentContentBlock.ProcessEnd) {
                    i4 = listIterator2.nextIndex();
                    break;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        AgentProcessSectionView agentProcessSectionView = this.processSectionView;
        if (agentProcessSectionView != null && i6 >= 0 && i4 > i6) {
            if (agentProcessSectionView != null) {
                agentProcessSectionView.setTag(C0637R.id.tag_on_content_changed, this.onContentChanged);
            }
            AgentProcessSectionView agentProcessSectionView2 = this.processSectionView;
            if (agentProcessSectionView2 != null) {
                agentProcessSectionView2.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, this.onPureShowWidgetInlineViewCreated);
            }
            List<? extends AgentContentBlock> subList = newBlocks.subList(i6 + 1, i4);
            AgentProcessSectionView agentProcessSectionView3 = this.processSectionView;
            if (agentProcessSectionView3 != null) {
                AgentProcessSectionView.updateBlocks$default(agentProcessSectionView3, subList, null, 2, null);
            }
            AgentContentBlock agentContentBlock4 = newBlocks.get(i4);
            Intrinsics.checkNotNull(agentContentBlock4, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.ProcessEnd");
            AgentContentBlock.ProcessEnd processEnd = (AgentContentBlock.ProcessEnd) agentContentBlock4;
            AgentProcessSectionView agentProcessSectionView4 = this.processSectionView;
            if (agentProcessSectionView4 != null) {
                agentProcessSectionView4.setState(processEnd.isCompleted() ? AgentProcessSectionView.ProcessState.COMPLETED : AgentProcessSectionView.ProcessState.IN_PROGRESS, processEnd.getDurationMs(), processEnd.getAutoCollapse());
            }
            if (subList.isEmpty() && processEnd.isCompleted()) {
                AgentProcessSectionView agentProcessSectionView5 = this.processSectionView;
                if (agentProcessSectionView5 != null) {
                    AgentProcessSectionView agentProcessSectionView6 = agentProcessSectionView5;
                    releasePureShowWidgetInlineViews(agentProcessSectionView6);
                    this.contentContainer.removeView(agentProcessSectionView6);
                }
                this.processSectionView = null;
            }
        }
        List<? extends AgentContentBlock> list3 = this.lastBlocks;
        ListIterator<? extends AgentContentBlock> listIterator3 = list3.listIterator(list3.size());
        while (true) {
            if (listIterator3.hasPrevious()) {
                if (listIterator3.previous() instanceof AgentContentBlock.ProcessEnd) {
                    i = listIterator3.nextIndex();
                    break;
                }
            } else {
                break;
            }
        }
        int findFirstResultIndex = i >= 0 ? i + 1 : findFirstResultIndex(this.lastBlocks);
        int findFirstResultIndex2 = i4 >= 0 ? i4 + 1 : findFirstResultIndex(newBlocks);
        if (findFirstResultIndex < this.lastBlocks.size()) {
            List<? extends AgentContentBlock> list4 = this.lastBlocks;
            emptyList = list4.subList(findFirstResultIndex, list4.size());
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        if (findFirstResultIndex2 < newBlocks.size()) {
            emptyList2 = newBlocks.subList(findFirstResultIndex2, newBlocks.size());
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        int childCount2 = this.contentContainer.getChildCount() - RangesKt.coerceAtMost(emptyList.size(), this.contentContainer.getChildCount());
        int size = emptyList.size();
        for (i2 = 0; i2 < size && i2 < emptyList2.size(); i2++) {
            if (!Intrinsics.areEqual(emptyList2.get(i2), emptyList.get(i2)) && (i5 = childCount2 + i2) >= 0 && i5 < this.contentContainer.getChildCount() && (childAt = this.contentContainer.getChildAt(i5)) != null) {
                if (emptyList2.get(i2).getClass() == emptyList.get(i2).getClass()) {
                    IBlockRenderer renderer3 = this.factory.getRenderer(emptyList2.get(i2));
                    if (renderer3 != null) {
                        renderer3.update(childAt, emptyList2.get(i2));
                    }
                } else {
                    IBlockRenderer renderer4 = this.factory.getRenderer(emptyList2.get(i2));
                    if (renderer4 != null) {
                        Intrinsics.checkNotNull(context);
                        View render = renderer4.render(context, emptyList2.get(i2));
                        render.setTag(C0637R.id.tag_on_content_changed, this.onContentChanged);
                        render.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, this.onPureShowWidgetInlineViewCreated);
                        render.setTag(C0637R.id.tag_block_class, Reflection.getOrCreateKotlinClass(emptyList2.get(i2).getClass()));
                        notifyPureShowWidgetInlineViewCreated(render);
                        int i7 = findFirstResultIndex2 + i2;
                        applyBlockSpacing(render, emptyList2.get(i2), i7, previousRenderableBlock(newBlocks, i7));
                        releasePureShowWidgetInlineViews(childAt);
                        this.contentContainer.removeViewAt(i5);
                        this.contentContainer.addView(render, i5);
                    }
                }
            }
        }
        int size2 = emptyList2.size();
        for (int size3 = emptyList.size(); size3 < size2; size3++) {
            AgentContentBlock agentContentBlock5 = emptyList2.get(size3);
            if (!(agentContentBlock5 instanceof AgentContentBlock.ProcessStart) && !(agentContentBlock5 instanceof AgentContentBlock.ProcessEnd) && (renderer = this.factory.getRenderer(agentContentBlock5)) != null) {
                Intrinsics.checkNotNull(context);
                View render2 = renderer.render(context, agentContentBlock5);
                render2.setTag(C0637R.id.tag_on_content_changed, this.onContentChanged);
                render2.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, this.onPureShowWidgetInlineViewCreated);
                render2.setTag(C0637R.id.tag_block_class, Reflection.getOrCreateKotlinClass(agentContentBlock5.getClass()));
                notifyPureShowWidgetInlineViewCreated(render2);
                int i8 = findFirstResultIndex2 + size3;
                applyBlockSpacing(render2, agentContentBlock5, i8, previousRenderableBlock(newBlocks, i8));
                this.contentContainer.addView(render2);
            }
        }
    }

    private final void applyBlockSpacing(View view, AgentContentBlock block, int index, AgentContentBlock previousBlock) {
        int dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        }
        if (index > 0) {
            Resources resources = view.getResources();
            if (block instanceof AgentContentBlock.ActionBar) {
                dimensionPixelSize = (((AgentContentBlock.ActionBar) block).isVoiceSummaryStyle() && (previousBlock instanceof AgentContentBlock.VoiceSummary)) ? resources.getDimensionPixelSize(C0637R.dimen.trae_dp_16) : 0;
            } else if ((block instanceof AgentContentBlock.VoiceSummary) || (block instanceof AgentContentBlock.VoiceSummaryLoading)) {
                dimensionPixelSize = resources.getDimensionPixelSize(C0637R.dimen.trae_dp_16);
            } else if (block instanceof AgentContentBlock.UpgradeReminder) {
                dimensionPixelSize = resources.getDimensionPixelSize(C0637R.dimen.trae_dp_8);
            } else {
                dimensionPixelSize = resources.getDimensionPixelSize(C0637R.dimen.trae_dp_24);
            }
            layoutParams2.topMargin = dimensionPixelSize;
        }
        view.setLayoutParams(layoutParams2);
    }

    private final AgentContentBlock previousRenderableBlock(List<? extends AgentContentBlock> blocks, int index) {
        while (true) {
            index--;
            if (-1 >= index) {
                return null;
            }
            AgentContentBlock agentContentBlock = blocks.get(index);
            if (!(agentContentBlock instanceof AgentContentBlock.ProcessStart) && !(agentContentBlock instanceof AgentContentBlock.ProcessEnd)) {
                return agentContentBlock;
            }
        }
    }

    public final void resetState() {
        cancelAllTypewriters();
        cancelCopyIconReset();
        this.lastBlocks = CollectionsKt.emptyList();
        this.processSectionView = null;
        releasePureShowWidgetInlineViews(this.contentContainer);
        this.contentContainer.removeAllViews();
    }

    private final void notifyPureShowWidgetInlineViewCreated(View root) {
        Function1<? super PureShowWidgetInlineView, Unit> function1 = this.onPureShowWidgetInlineViewCreated;
        if (function1 == null) {
            return;
        }
        notifyPureShowWidgetInlineViewCreated(root, function1);
    }

    private final void notifyPureShowWidgetInlineViewCreated(View root, Function1<? super PureShowWidgetInlineView, Unit> callback) {
        if (root instanceof PureShowWidgetInlineView) {
            callback.invoke(root);
            return;
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                notifyPureShowWidgetInlineViewCreated(childAt, callback);
            }
        }
    }

    private final void releasePureShowWidgetInlineViews(View root) {
        if (root instanceof PureShowWidgetInlineView) {
            ((PureShowWidgetInlineView) root).release();
            return;
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                releasePureShowWidgetInlineViews(childAt);
            }
        }
    }

    private final void cancelAllTypewriters() {
        int childCount = this.contentContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.contentContainer.getChildAt(i);
            if (childAt != null) {
                SummaryRenderer.INSTANCE.cancelTypewriter(childAt);
                VoiceSummaryRenderer.INSTANCE.cancelTypewriter(childAt);
            }
        }
    }

    /* compiled from: AgentMessageViewHolder.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$Companion;", "", "<init>", "()V", "MORE_BUTTON_TAG", "", "AGENT_FLOW_TAG", "COPY_ICON_RESET_DELAY_MS", "", "FINISH_TOOLS", "", "create", "Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder;", "parent", "Landroid/view/ViewGroup;", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "messageLister", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AgentMessageViewHolder create(ViewGroup parent, Conversation conversation, IMessageListener messageLister) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_agent_message, parent, false).findViewById(C0637R.id.content_container);
            Intrinsics.checkNotNull(linearLayout);
            return new AgentMessageViewHolder(linearLayout, conversation, messageLister);
        }
    }

    private final int findFirstResultIndex(List<? extends AgentContentBlock> blocks) {
        Iterator<? extends AgentContentBlock> it = blocks.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            AgentContentBlock next = it.next();
            if ((next instanceof AgentContentBlock.Summary) || (next instanceof AgentContentBlock.VoiceSummary) || (next instanceof AgentContentBlock.Artifacts) || (next instanceof AgentContentBlock.UpgradeReminder) || (next instanceof AgentContentBlock.Error) || (next instanceof AgentContentBlock.FreeActivityQuotaError) || (next instanceof AgentContentBlock.InitialLoading) || (next instanceof AgentContentBlock.VoiceSummaryLoading) || (next instanceof AgentContentBlock.ActionBar) || (next instanceof AgentContentBlock.CancelBanner) || (next instanceof AgentContentBlock.Queuing)) {
                break;
            }
            i++;
        }
        return i < 0 ? blocks.size() : i;
    }
}
