package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ThinkingDetailCardCreator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThinkingDetailCardCreator extends BaseToolDetailCardCreator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CONTENT_LENGTH = 5000;
    private static final String TOOL_TAG = "AgentTool";

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        final String reasoningContent = (planItemContext == null || planItemContext.getPlanItemId() == null) ? null : planItemContext.getReasoningContent();
        if (reasoningContent == null) {
            reasoningContent = "";
        }
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final boolean z = fromString == ToolExecutionStatus.RUNNING || fromString == ToolExecutionStatus.PENDING;
        if (z) {
            string = context.getString(C0637R.string.trae_thinking_title_running);
        } else {
            string = context.getString(C0637R.string.trae_thinking_title_complete);
        }
        String str = string;
        Intrinsics.checkNotNull(str);
        FLogger.INSTANCE.i("AgentTool", "[ThinkingCard] onCreateDetail: name=" + toolCallInfo.getName() + ", isComplete=" + (!z) + ", contentLength=" + reasoningContent.length());
        return new ToolDetailCard("", C0637R.drawable.ic_tool_brain, 0, str, null, null, reasoningContent.length() > 0 ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.ThinkingDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                View onCreateDetail$lambda$1;
                onCreateDetail$lambda$1 = ThinkingDetailCardCreator.onCreateDetail$lambda$1(reasoningContent, z, (Context) obj);
                return onCreateDetail$lambda$1;
            }
        } : null, fromString, false, null, 820, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCreateDetail$lambda$1(String str, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return INSTANCE.buildContentView$conversation_mainlandRelease(context, str, !z);
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        boolean z = fromString == ToolExecutionStatus.RUNNING || fromString == ToolExecutionStatus.PENDING;
        if (z) {
            string = context.getString(C0637R.string.trae_thinking_title_running);
            Intrinsics.checkNotNull(string);
        } else {
            string = context.getString(C0637R.string.trae_thinking_title_complete);
            Intrinsics.checkNotNull(string);
        }
        card.setTitle(string);
        card.setStatus(fromString);
        String reasoningContent = (planItemContext == null || planItemContext.getPlanItemId() == null) ? null : planItemContext.getReasoningContent();
        if (reasoningContent == null) {
            reasoningContent = "";
        }
        String str = reasoningContent.length() > MAX_CONTENT_LENGTH ? StringsKt.take(reasoningContent, MAX_CONTENT_LENGTH) + (char) 8230 : reasoningContent;
        Object contentViewInstance = card.getContentViewInstance();
        SimpleMarkdownTextView simpleMarkdownTextView = contentViewInstance instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) contentViewInstance : null;
        if (simpleMarkdownTextView != null) {
            MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, str, !z, null, 8, null);
        }
        FLogger.INSTANCE.i("AgentTool", "[ThinkingCard] onUpdateCard: name=" + toolCallInfo.getName() + ", isComplete=" + (!z) + ", contentLength=" + reasoningContent.length());
    }

    /* compiled from: ThinkingDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;", "", "<init>", "()V", "MAX_CONTENT_LENGTH", "", "TOOL_TAG", "", "buildContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "rawContent", "finished", "", "buildContentView$conversation_mainlandRelease", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ View buildContentView$conversation_mainlandRelease$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.buildContentView$conversation_mainlandRelease(context, str, z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View buildContentView$conversation_mainlandRelease(Context context, String rawContent, boolean finished) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rawContent, "rawContent");
            float f = context.getResources().getDisplayMetrics().density;
            if (rawContent.length() > ThinkingDetailCardCreator.MAX_CONTENT_LENGTH) {
                rawContent = StringsKt.take(rawContent, ThinkingDetailCardCreator.MAX_CONTENT_LENGTH) + (char) 8230;
            }
            String str = rawContent;
            SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
            simpleMarkdownTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            simpleMarkdownTextView.setTextSize(2, 13.0f);
            simpleMarkdownTextView.setLineSpacing(0.0f, 1.4f);
            simpleMarkdownTextView.setMovementMethod(LinkMovementMethod.getInstance());
            simpleMarkdownTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, str, finished, null, 8, null);
            return (View) simpleMarkdownTextView;
        }
    }
}
