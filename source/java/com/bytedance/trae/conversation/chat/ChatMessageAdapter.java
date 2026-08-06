package com.bytedance.trae.conversation.chat;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView;
import com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder;
import com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.log.IMLog;
import com.bytedance.trae.im.model.MessageSourcePhase;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ChatMessageAdapter.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 i2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001iB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020CH\u0016J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020CH\u0016J\u0018\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00032\u0006\u0010E\u001a\u00020CH\u0016J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u0003H\u0016J&\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u00032\u0006\u0010E\u001a\u00020C2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NH\u0016J\u0010\u0010P\u001a\u00020A2\u0006\u0010E\u001a\u00020CH\u0002J\u0010\u0010Q\u001a\u00020A2\u0006\u0010E\u001a\u00020CH\u0002J\u0018\u0010R\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010\u00142\u0006\u0010S\u001a\u00020AJ\u000f\u0010T\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0002\u0010UJ \u0010V\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u0014H\u0002J \u0010Y\u001a\u00020\u00182\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\\J\n\u0010]\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010^\u001a\u00020\u00182\b\u0010_\u001a\u0004\u0018\u00010\u00142\b\u0010`\u001a\u0004\u0018\u00010\u0014H\u0002J\u0017\u0010a\u001a\u0004\u0018\u00010C2\u0006\u0010\"\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010bJ(\u0010f\u001a\u00020\u00182\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100H\u0002J\b\u0010h\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R7\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR7\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cRL\u0010 \u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0018\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R7\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cRL\u0010+\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0018\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00105\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR7\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u0010\u0010=\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0018000dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAllMessages", "", "getCurrentConversation", "Lcom/bytedance/trae/im/service/Conversation;", "conversation", "getConversation", "()Lcom/bytedance/trae/im/service/Conversation;", "setConversation", "(Lcom/bytedance/trae/im/service/Conversation;)V", "onRetryClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "assistantMessageId", "", "getOnRetryClick", "()Lkotlin/jvm/functions/Function1;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function1;)V", "onUseExpressPassClick", "getOnUseExpressPassClick", "setOnUseExpressPassClick", "onFeedbackClick", "Lkotlin/Function2;", "messageId", "resultType", "getOnFeedbackClick", "()Lkotlin/jvm/functions/Function2;", "setOnFeedbackClick", "(Lkotlin/jvm/functions/Function2;)V", "onCopyClick", "getOnCopyClick", "setOnCopyClick", "onReportClick", ReportConstant.COMMON_CONTENT, "getOnReportClick", "setOnReportClick", "onContentChanged", "Lkotlin/Function0;", "getOnContentChanged", "()Lkotlin/jvm/functions/Function0;", "setOnContentChanged", "(Lkotlin/jvm/functions/Function0;)V", "onPureShowWidgetInlineViewCreated", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "getOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease", "setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease", "onUpgradeReminderClick", "conversationId", "getOnUpgradeReminderClick", "setOnUpgradeReminderClick", "upgradeReminderConversationId", "currentDebugDialog", "Landroidx/appcompat/app/AlertDialog;", "isStreaming", "", "getItemCount", "", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "payloads", "", "", "isLatestAgentTurn", "isLatestAgentMsg", "setUpgradeReminder", "visible", "upgradeReminderTargetPosition", "()Ljava/lang/Integer;", "showDebugDialog", "message", "title", "submitMessages", "messages", "commitCallback", "Ljava/lang/Runnable;", "upgradeReminderTargetMessageId", "notifyUpgradeReminderTargetChanged", "previousMessageId", "nextMessageId", "positionOfMessage", "(Ljava/lang/String;)Ljava/lang/Integer;", "pendingSubmitOps", "Lkotlin/collections/ArrayDeque;", "isSubmitInFlight", "enqueueSubmitList", "newList", "drainSubmitQueue", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatMessageAdapter extends ListAdapter<ParsedChatMessage, RecyclerView.ViewHolder> implements IMessageListener {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final ChatMessageAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<ParsedChatMessage>() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$Companion$DIFF_CALLBACK$1
        public boolean areItemsTheSame(ParsedChatMessage oldItem, ParsedChatMessage newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getMessageId(), newItem.getMessageId()) || sameAssistantTask(oldItem, newItem);
        }

        public boolean areContentsTheSame(ParsedChatMessage oldItem, ParsedChatMessage newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            MessageSourcePhase sourcePhase = newItem.getSourcePhase();
            if (newItem.isAssistantMessage() && sourcePhase != MessageSourcePhase.FETCHED) {
                if (AppHost.INSTANCE.isDebug()) {
                    TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node5] areContentsTheSame FORCE_FALSE: msgId=" + newItem.getMessageId() + ", sameRef=" + (oldItem == newItem) + ", sourcePhase=" + sourcePhase);
                }
                return false;
            }
            boolean areEqual = Intrinsics.areEqual(oldItem, newItem);
            if (AppHost.INSTANCE.isDebug()) {
                TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node5] areContentsTheSame result=" + areEqual + ": msgId=" + newItem.getMessageId() + ", sameRef=" + (oldItem == newItem) + ", sourcePhase=" + sourcePhase);
            }
            return areEqual;
        }

        public Object getChangePayload(ParsedChatMessage oldItem, ParsedChatMessage newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.isAssistantMessage() && newItem.isAssistantMessage()) {
                return "streaming_update";
            }
            return null;
        }

        private final boolean sameAssistantTask(ParsedChatMessage oldItem, ParsedChatMessage newItem) {
            ParsedTaskContent taskContent;
            String taskId;
            ParsedTaskContent taskContent2;
            String taskId2;
            if (oldItem.isAssistantMessage() && newItem.isAssistantMessage() && (taskContent = oldItem.getTaskContent()) != null && (taskId = taskContent.getTaskId()) != null) {
                if (!(!StringsKt.isBlank(taskId))) {
                    taskId = null;
                }
                if (taskId != null && (taskContent2 = newItem.getTaskContent()) != null && (taskId2 = taskContent2.getTaskId()) != null) {
                    String str = StringsKt.isBlank(taskId2) ^ true ? taskId2 : null;
                    if (str != null) {
                        return Intrinsics.areEqual(taskId, str);
                    }
                }
            }
            return false;
        }
    };
    private static final String PAYLOAD_STREAMING_UPDATE = "streaming_update";
    private static final int VIEW_TYPE_AGENT = 1;
    private static final int VIEW_TYPE_FOOTER = 2;
    private static final int VIEW_TYPE_USER = 0;
    private final Context context;
    private Conversation conversation;
    private AlertDialog currentDebugDialog;
    private boolean isSubmitInFlight;
    private Function0<Unit> onContentChanged;
    private Function1<? super String, Unit> onCopyClick;
    private Function2<? super String, ? super String, Unit> onFeedbackClick;
    private Function1<? super PureShowWidgetInlineView, Unit> onPureShowWidgetInlineViewCreated;
    private Function2<? super String, ? super String, Unit> onReportClick;
    private Function1<? super String, Unit> onRetryClick;
    private Function1<? super String, Unit> onUpgradeReminderClick;
    private Function1<? super String, Unit> onUseExpressPassClick;
    private final ArrayDeque<Function0<Unit>> pendingSubmitOps;
    private String upgradeReminderConversationId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMessageAdapter(Context context) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.pendingSubmitOps = new ArrayDeque<>();
    }

    @Override // com.bytedance.trae.conversation.chat.IMessageListener
    public List<ParsedChatMessage> getAllMessages() {
        List<ParsedChatMessage> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        return currentList;
    }

    @Override // com.bytedance.trae.conversation.chat.IMessageListener
    public Conversation getCurrentConversation() {
        return this.conversation;
    }

    public final Conversation getConversation() {
        return this.conversation;
    }

    public final void setConversation(Conversation conversation) {
        this.conversation = conversation;
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
    public final Function1<PureShowWidgetInlineView, Unit> m821x43ae1e4f() {
        return this.onPureShowWidgetInlineViewCreated;
    }

    /* renamed from: setOnPureShowWidgetInlineViewCreated$conversation_mainlandRelease */
    public final void m822xe8a7be5b(Function1<? super PureShowWidgetInlineView, Unit> function1) {
        this.onPureShowWidgetInlineViewCreated = function1;
    }

    public final Function1<String, Unit> getOnUpgradeReminderClick() {
        return this.onUpgradeReminderClick;
    }

    public final void setOnUpgradeReminderClick(Function1<? super String, Unit> function1) {
        this.onUpgradeReminderClick = function1;
    }

    @Override // com.bytedance.trae.conversation.chat.IMessageListener
    public boolean isStreaming() {
        List currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<ParsedChatMessage> list = currentList;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (ParsedChatMessage parsedChatMessage : list) {
            if ((parsedChatMessage.isUserMessage() || parsedChatMessage.isHistory() || parsedChatMessage.isInterjected()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    public int getItemCount() {
        int itemCount = super.getItemCount();
        if (itemCount <= 0) {
            return 0;
        }
        return itemCount + 1;
    }

    public int getItemViewType(int position) {
        if (position >= super.getItemCount()) {
            return 2;
        }
        return !((ParsedChatMessage) getItem(position)).isUserMessage() ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return UserMessageViewHolder.INSTANCE.create(parent, this);
        }
        if (viewType == 2) {
            float f = parent.getContext().getResources().getDisplayMetrics().density;
            final View view = new View(parent.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, RangesKt.coerceAtLeast((int) (f * 8), 1)));
            return new RecyclerView.ViewHolder(view) { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$onCreateViewHolder$1
            };
        }
        AgentMessageViewHolder create = AgentMessageViewHolder.INSTANCE.create(parent, this.conversation, this);
        create.setOnRetryClick(this.onRetryClick);
        create.setOnFeedbackClick(this.onFeedbackClick);
        create.setOnUseExpressPassClick(this.onUseExpressPassClick);
        create.setOnCopyClick(this.onCopyClick);
        create.setOnReportClick(this.onReportClick);
        create.setOnContentChanged(this.onContentChanged);
        create.m829xe8a7be5b(this.onPureShowWidgetInlineViewCreated);
        return create;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(position) == 2) {
            return;
        }
        final ParsedChatMessage parsedChatMessage = (ParsedChatMessage) getItem(position);
        if (holder instanceof UserMessageViewHolder) {
            Intrinsics.checkNotNull(parsedChatMessage);
            ((UserMessageViewHolder) holder).bind(parsedChatMessage);
        } else if (holder instanceof AgentMessageViewHolder) {
            AgentMessageViewHolder agentMessageViewHolder = (AgentMessageViewHolder) holder;
            agentMessageViewHolder.setMessageLister(this);
            agentMessageViewHolder.m829xe8a7be5b(this.onPureShowWidgetInlineViewCreated);
            boolean z = false;
            if (AppHost.INSTANCE.isDebug()) {
                Object content = parsedChatMessage.getContent();
                ParsedTaskContent parsedTaskContent = content instanceof ParsedTaskContent ? (ParsedTaskContent) content : null;
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node5] onBind: pos=" + position + ", role=" + parsedChatMessage.getRole() + ", planItemCount=" + ((parsedTaskContent == null || (messages = parsedTaskContent.getMessages()) == null) ? 0 : messages.size()) + ", status=" + parsedChatMessage.getStatus() + ", isInterjected=" + parsedChatMessage.isInterjected() + ", isLatest=" + isLatestAgentTurn(position));
            }
            Intrinsics.checkNotNull(parsedChatMessage);
            boolean isLatestAgentTurn = isLatestAgentTurn(position);
            boolean isLatestAgentMsg = isLatestAgentMsg(position);
            String str = this.upgradeReminderConversationId;
            Integer upgradeReminderTargetPosition = upgradeReminderTargetPosition();
            if (upgradeReminderTargetPosition != null && position == upgradeReminderTargetPosition.intValue()) {
                z = true;
            }
            agentMessageViewHolder.bind(parsedChatMessage, isLatestAgentTurn, isLatestAgentMsg, z ? str : null, this.onUpgradeReminderClick);
        }
        if (AppHost.INSTANCE.isDebug()) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean onBindViewHolder$lambda$4;
                    onBindViewHolder$lambda$4 = ChatMessageAdapter.onBindViewHolder$lambda$4(ChatMessageAdapter.this, parsedChatMessage, position, view);
                    return onBindViewHolder$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$4(ChatMessageAdapter chatMessageAdapter, ParsedChatMessage parsedChatMessage, int i, View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Intrinsics.checkNotNull(parsedChatMessage);
        chatMessageAdapter.showDebugDialog(context, parsedChatMessage, "Debug Message (" + i + ')');
        return true;
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof AgentMessageViewHolder) {
            ((AgentMessageViewHolder) holder).resetState();
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (getItemViewType(position) == 2) {
            return;
        }
        if ((!payloads.isEmpty()) && (holder instanceof AgentMessageViewHolder)) {
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) getItem(position);
            AgentMessageViewHolder agentMessageViewHolder = (AgentMessageViewHolder) holder;
            agentMessageViewHolder.m829xe8a7be5b(this.onPureShowWidgetInlineViewCreated);
            if (AppHost.INSTANCE.isDebug()) {
                Object content = parsedChatMessage.getContent();
                ParsedTaskContent parsedTaskContent = content instanceof ParsedTaskContent ? (ParsedTaskContent) content : null;
                TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node5] onBindStreaming: pos=" + position + ", payload=" + CollectionsKt.firstOrNull(payloads) + ", planItemCount=" + ((parsedTaskContent == null || (messages = parsedTaskContent.getMessages()) == null) ? 0 : messages.size()) + ", status=" + parsedChatMessage.getStatus() + ", isInterjected=" + parsedChatMessage.isInterjected());
            }
            Intrinsics.checkNotNull(parsedChatMessage);
            boolean isLatestAgentTurn = isLatestAgentTurn(position);
            boolean isLatestAgentMsg = isLatestAgentMsg(position);
            String str = this.upgradeReminderConversationId;
            Integer upgradeReminderTargetPosition = upgradeReminderTargetPosition();
            agentMessageViewHolder.bindStreaming(parsedChatMessage, isLatestAgentTurn, isLatestAgentMsg, upgradeReminderTargetPosition != null && position == upgradeReminderTargetPosition.intValue() ? str : null, this.onUpgradeReminderClick);
            return;
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    private final boolean isLatestAgentTurn(int position) {
        return position == super.getItemCount() - 1;
    }

    private final boolean isLatestAgentMsg(int position) {
        return position == super.getItemCount() - 1 && ((ParsedChatMessage) getItem(position)).isAssistantMessage();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if ((r6 && (kotlin.text.StringsKt.isBlank(r5) ^ true)) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setUpgradeReminder(String conversationId, boolean visible) {
        Integer upgradeReminderTargetPosition = upgradeReminderTargetPosition();
        if (conversationId != null) {
        }
        conversationId = null;
        this.upgradeReminderConversationId = conversationId;
        Iterator it = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new Integer[]{upgradeReminderTargetPosition, upgradeReminderTargetPosition()})).iterator();
        while (it.hasNext()) {
            notifyItemChanged(((Number) it.next()).intValue());
        }
    }

    private final Integer upgradeReminderTargetPosition() {
        if (this.upgradeReminderConversationId == null) {
            return null;
        }
        int itemCount = super.getItemCount();
        do {
            itemCount--;
            if (-1 >= itemCount) {
                return null;
            }
        } while (!((ParsedChatMessage) getItem(itemCount)).isAssistantMessage());
        return Integer.valueOf(itemCount);
    }

    private final void showDebugDialog(final Context context, ParsedChatMessage message, String title) {
        String str;
        if (AppHost.INSTANCE.isDebug()) {
            try {
                AlertDialog alertDialog = this.currentDebugDialog;
                boolean z = false;
                if (alertDialog != null && alertDialog.isShowing()) {
                    z = true;
                }
                if (z) {
                    return;
                }
                String deviceId = IApplog.INSTANCE.getDeviceId();
                try {
                    str = new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(message);
                } catch (Exception e) {
                    str = "Failed to serialize: " + e.getMessage();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Title: " + title).append('\n');
                sb.append("DID: " + deviceId).append("\nMessage JSON:\n");
                sb.append(str);
                final String sb2 = sb.toString();
                TextView textView = new TextView(context);
                textView.setText(sb2);
                textView.setPadding(48, 32, 48, 32);
                textView.setTextIsSelectable(true);
                textView.setTextSize(12.0f);
                ScrollView scrollView = new ScrollView(context);
                scrollView.addView(textView);
                this.currentDebugDialog = new AlertDialog.Builder(context).setTitle("Debug Message Info").setView(scrollView).setPositiveButton("Copy", new DialogInterface.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChatMessageAdapter.showDebugDialog$lambda$10(context, sb2, this, dialogInterface, i);
                    }
                }).setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ChatMessageAdapter.showDebugDialog$lambda$11(ChatMessageAdapter.this, dialogInterface, i);
                    }
                }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        ChatMessageAdapter.this.currentDebugDialog = null;
                    }
                }).show();
                IMLog.INSTANCE.logParsedChatMessage("ChatMessageAdapter.showDebugDialog", message);
            } catch (Throwable unused) {
                this.currentDebugDialog = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDebugDialog$lambda$10(Context context, String str, ChatMessageAdapter chatMessageAdapter, DialogInterface dialogInterface, int i) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("debug_message", str));
        CustomToast.showLong(context, R.string.trae_conversation_copied);
        dialogInterface.dismiss();
        chatMessageAdapter.currentDebugDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDebugDialog$lambda$11(ChatMessageAdapter chatMessageAdapter, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        chatMessageAdapter.currentDebugDialog = null;
    }

    public static /* synthetic */ void submitMessages$default(ChatMessageAdapter chatMessageAdapter, List list, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            runnable = null;
        }
        chatMessageAdapter.submitMessages(list, runnable);
    }

    public final void submitMessages(List<ParsedChatMessage> messages, final Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        final String upgradeReminderTargetMessageId = upgradeReminderTargetMessageId();
        enqueueSubmitList(messages, new Function0() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit submitMessages$lambda$13;
                submitMessages$lambda$13 = ChatMessageAdapter.submitMessages$lambda$13(ChatMessageAdapter.this, upgradeReminderTargetMessageId, commitCallback);
                return submitMessages$lambda$13;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit submitMessages$lambda$13(ChatMessageAdapter chatMessageAdapter, String str, Runnable runnable) {
        chatMessageAdapter.notifyUpgradeReminderTargetChanged(str, chatMessageAdapter.upgradeReminderTargetMessageId());
        if (runnable != null) {
            runnable.run();
        }
        return Unit.INSTANCE;
    }

    private final String upgradeReminderTargetMessageId() {
        Integer upgradeReminderTargetPosition = upgradeReminderTargetPosition();
        if (upgradeReminderTargetPosition != null) {
            return ((ParsedChatMessage) getItem(upgradeReminderTargetPosition.intValue())).getMessageId();
        }
        return null;
    }

    private final void notifyUpgradeReminderTargetChanged(String previousMessageId, String nextMessageId) {
        List distinct = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new String[]{previousMessageId, nextMessageId}));
        ArrayList arrayList = new ArrayList();
        Iterator it = distinct.iterator();
        while (it.hasNext()) {
            Integer positionOfMessage = positionOfMessage((String) it.next());
            if (positionOfMessage != null) {
                arrayList.add(positionOfMessage);
            }
        }
        Iterator it2 = CollectionsKt.distinct(arrayList).iterator();
        while (it2.hasNext()) {
            notifyItemChanged(((Number) it2.next()).intValue());
        }
    }

    private final Integer positionOfMessage(String messageId) {
        int itemCount = super.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (Intrinsics.areEqual(((ParsedChatMessage) getItem(i)).getMessageId(), messageId)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void enqueueSubmitList$default(ChatMessageAdapter chatMessageAdapter, List list, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        chatMessageAdapter.enqueueSubmitList(list, function0);
    }

    private final void enqueueSubmitList(final List<ParsedChatMessage> newList, final Function0<Unit> commitCallback) {
        this.pendingSubmitOps.addLast(new Function0() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit enqueueSubmitList$lambda$18;
                enqueueSubmitList$lambda$18 = ChatMessageAdapter.enqueueSubmitList$lambda$18(ChatMessageAdapter.this, newList, commitCallback);
                return enqueueSubmitList$lambda$18;
            }
        });
        if (this.isSubmitInFlight) {
            return;
        }
        drainSubmitQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enqueueSubmitList$lambda$18(final ChatMessageAdapter chatMessageAdapter, List list, final Function0 function0) {
        chatMessageAdapter.submitList(list, new Runnable() { // from class: com.bytedance.trae.conversation.chat.ChatMessageAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageAdapter.enqueueSubmitList$lambda$18$lambda$17(function0, chatMessageAdapter);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueueSubmitList$lambda$18$lambda$17(Function0 function0, ChatMessageAdapter chatMessageAdapter) {
        if (function0 != null) {
            function0.invoke();
        }
        chatMessageAdapter.isSubmitInFlight = false;
        chatMessageAdapter.drainSubmitQueue();
    }

    private final void drainSubmitQueue() {
        Function0 function0 = (Function0) this.pendingSubmitOps.removeFirstOrNull();
        if (function0 == null) {
            return;
        }
        this.isSubmitInFlight = true;
        function0.invoke();
    }
}
