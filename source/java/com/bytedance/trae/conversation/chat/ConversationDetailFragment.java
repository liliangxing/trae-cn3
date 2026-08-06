package com.bytedance.trae.conversation.chat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.widget.TraeLoadingView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConversationDetailFragment.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u008f\u00012\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010d\u001a\u00020\u001c2\u0006\u0010e\u001a\u00020]2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u000e\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020hJ\u0018\u0010i\u001a\u00020\u001c2\b\u0010A\u001a\u0004\u0018\u00010&2\u0006\u0010j\u001a\u00020\u0014J\u0006\u0010k\u001a\u00020\u001cJ0\u0010l\u001a\u00020\u001c2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020o0n2\b\b\u0002\u0010p\u001a\u00020\u00142\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bJ\u000e\u0010r\u001a\u00020\u001c2\u0006\u0010s\u001a\u00020\u0014J\u000e\u0010t\u001a\u00020\u001c2\u0006\u0010s\u001a\u00020\u0014J\u000e\u0010u\u001a\u00020\u001c2\u0006\u0010s\u001a\u00020\u0014J\u000e\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u0014J\u0006\u0010x\u001a\u00020\u001cJ\u0006\u0010y\u001a\u00020\u001cJ\u000e\u0010z\u001a\u00020\u00142\u0006\u0010{\u001a\u00020&J\u0006\u0010|\u001a\u00020\u001cJ\f\u0010}\u001a\b\u0012\u0004\u0012\u00020o0nJ\b\u0010~\u001a\u0004\u0018\u00010oJ\b\u0010\u007f\u001a\u00020\u001cH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0083\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0084\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0085\u0001\u001a\u00020\u001cH\u0002J\u001b\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002J\u001b\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0087\u00012\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020o0nH\u0002J\u0013\u0010\u008a\u0001\u001a\u00020\u001c2\b\u0010\u008b\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R7\u0010$\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R7\u0010.\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-RL\u00101\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u001c\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R7\u00109\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010+\"\u0004\b;\u0010-RL\u0010<\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001c\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00106\"\u0004\b?\u00108R7\u0010@\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010+\"\u0004\bC\u0010-R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001e\"\u0004\bL\u0010 R\"\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001e\"\u0004\bO\u0010 R\u000e\u0010P\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0004\n\u0002\u0010TR\u000e\u0010U\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0Y0XX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\u001c0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "adapter", "Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;", "getAdapter", "()Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "rvMessages", "Landroidx/recyclerview/widget/RecyclerView;", "btnScrollToBottom", "Landroid/widget/ImageView;", "olderPageLoading", "Lcom/bytedance/trae/common/widget/TraeLoadingView;", "newerPageLoading", "isAnchorLoadingVisible", "", "isOlderPageLoadingVisible", "isNewerPageLoadingVisible", "hasMoreOlderMessages", "stickyBottomScroller", "Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "onLoadNewer", "getOnLoadNewer", "setOnLoadNewer", "onRetryClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "assistantMessageId", "getOnRetryClick", "()Lkotlin/jvm/functions/Function1;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function1;)V", "onUseExpressPassClick", "getOnUseExpressPassClick", "setOnUseExpressPassClick", "onFeedbackClick", "Lkotlin/Function2;", "messageId", "resultType", "getOnFeedbackClick", "()Lkotlin/jvm/functions/Function2;", "setOnFeedbackClick", "(Lkotlin/jvm/functions/Function2;)V", "onCopyClick", "getOnCopyClick", "setOnCopyClick", "onReportClick", ReportConstant.COMMON_CONTENT, "getOnReportClick", "setOnReportClick", "onUpgradeReminderClick", "conversationId", "getOnUpgradeReminderClick", "setOnUpgradeReminderClick", "lm", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLm", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLm", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "onUserScrolled", "getOnUserScrolled", "setOnUserScrolled", "onJumpToBottomClick", "getOnJumpToBottomClick", "setOnJumpToBottomClick", "userDraggedTowardOlderSinceLastCheck", "userDraggedTowardNewerSinceLastCheck", "lastTouchY", "", "Ljava/lang/Float;", "touchSlop", "", "pureShowWidgetInlineViewRefs", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "onPureShowWidgetInlineViewCreated", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setConversation", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "setUpgradeReminder", "visible", "setTask", "submitMessages", "messages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "snapToBottom", "onCommitted", "setAnchorLoading", "loading", "setLoadingMore", "setLoadingNewer", "setHasMore", "hasMore", "scrollToBottom", "forceScrollToBottom", "scrollToCreatedAt", "anchorCreatedAtMs", "refreshLatestAgentMessage", "getMessages", "getLastMessage", "onDestroyView", "releasePureShowWidgetInlineViews", "maybeLoadOlderAtTop", "maybeLoadNewerAtBottom", "updateScrollToBottomVisibility", "applyAnchorLoadingVisibility", "applyDirectionalLoadingVisibility", "visibleAnchorForPrepend", "Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;", "nextMessages", "visibleAnchorForHistoryAppend", "restoreVisibleAnchor", "anchor", "scheduleScrollToBottomVisibilityUpdate", "showScrollToBottomWithBounce", "VisibleAnchor", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDetailFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ConversationDetailFragment";
    private ImageView btnScrollToBottom;
    private boolean isAnchorLoadingVisible;
    private boolean isNewerPageLoadingVisible;
    private boolean isOlderPageLoadingVisible;
    private Float lastTouchY;
    private LinearLayoutManager lm;
    private TraeLoadingView newerPageLoading;
    private TraeLoadingView olderPageLoading;
    private Function1<? super String, Unit> onCopyClick;
    private Function2<? super String, ? super String, Unit> onFeedbackClick;
    private Function0<Boolean> onJumpToBottomClick;
    private Function0<Unit> onLoadMore;
    private Function0<Unit> onLoadNewer;
    private Function2<? super String, ? super String, Unit> onReportClick;
    private Function1<? super String, Unit> onRetryClick;
    private Function1<? super String, Unit> onUpgradeReminderClick;
    private Function1<? super String, Unit> onUseExpressPassClick;
    private Function0<Unit> onUserScrolled;
    private RecyclerView rvMessages;
    private StickyBottomScroller stickyBottomScroller;
    private int touchSlop;
    private boolean userDraggedTowardNewerSinceLastCheck;
    private boolean userDraggedTowardOlderSinceLastCheck;
    private final FpsTracer fpsTracer = new FpsTracer("conversation_detail_list", false);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda8
        public final Object invoke() {
            ChatMessageAdapter adapter_delegate$lambda$0;
            adapter_delegate$lambda$0 = ConversationDetailFragment.adapter_delegate$lambda$0(ConversationDetailFragment.this);
            return adapter_delegate$lambda$0;
        }
    });
    private boolean hasMoreOlderMessages = true;
    private final List<WeakReference<PureShowWidgetInlineView>> pureShowWidgetInlineViewRefs = new ArrayList();
    private final Function1<PureShowWidgetInlineView, Unit> onPureShowWidgetInlineViewCreated = new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda9
        public final Object invoke(Object obj) {
            Unit onPureShowWidgetInlineViewCreated$lambda$2;
            onPureShowWidgetInlineViewCreated$lambda$2 = ConversationDetailFragment.onPureShowWidgetInlineViewCreated$lambda$2(ConversationDetailFragment.this, (PureShowWidgetInlineView) obj);
            return onPureShowWidgetInlineViewCreated$lambda$2;
        }
    };

    public static final ChatMessageAdapter adapter_delegate$lambda$0(ConversationDetailFragment conversationDetailFragment) {
        Context requireContext = conversationDetailFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        return new ChatMessageAdapter(requireContext);
    }

    private final ChatMessageAdapter getAdapter() {
        return (ChatMessageAdapter) this.adapter.getValue();
    }

    public final Function0<Unit> getOnLoadMore() {
        return this.onLoadMore;
    }

    public final void setOnLoadMore(Function0<Unit> function0) {
        this.onLoadMore = function0;
    }

    public final Function0<Unit> getOnLoadNewer() {
        return this.onLoadNewer;
    }

    public final void setOnLoadNewer(Function0<Unit> function0) {
        this.onLoadNewer = function0;
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

    public final Function1<String, Unit> getOnUpgradeReminderClick() {
        return this.onUpgradeReminderClick;
    }

    public final void setOnUpgradeReminderClick(Function1<? super String, Unit> function1) {
        this.onUpgradeReminderClick = function1;
    }

    public final LinearLayoutManager getLm() {
        return this.lm;
    }

    public final void setLm(LinearLayoutManager linearLayoutManager) {
        this.lm = linearLayoutManager;
    }

    public final Function0<Unit> getOnUserScrolled() {
        return this.onUserScrolled;
    }

    public final void setOnUserScrolled(Function0<Unit> function0) {
        this.onUserScrolled = function0;
    }

    public final Function0<Boolean> getOnJumpToBottomClick() {
        return this.onJumpToBottomClick;
    }

    public final void setOnJumpToBottomClick(Function0<Boolean> function0) {
        this.onJumpToBottomClick = function0;
    }

    public static final Unit onPureShowWidgetInlineViewCreated$lambda$2(ConversationDetailFragment conversationDetailFragment, final PureShowWidgetInlineView pureShowWidgetInlineView) {
        Intrinsics.checkNotNullParameter(pureShowWidgetInlineView, "inlineView");
        CollectionsKt.removeAll(conversationDetailFragment.pureShowWidgetInlineViewRefs, new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean onPureShowWidgetInlineViewCreated$lambda$2$lambda$1;
                onPureShowWidgetInlineViewCreated$lambda$2$lambda$1 = ConversationDetailFragment.onPureShowWidgetInlineViewCreated$lambda$2$lambda$1(PureShowWidgetInlineView.this, (WeakReference) obj);
                return Boolean.valueOf(onPureShowWidgetInlineViewCreated$lambda$2$lambda$1);
            }
        });
        conversationDetailFragment.pureShowWidgetInlineViewRefs.add(new WeakReference<>(pureShowWidgetInlineView));
        return Unit.INSTANCE;
    }

    public static final boolean onPureShowWidgetInlineViewCreated$lambda$2$lambda$1(PureShowWidgetInlineView pureShowWidgetInlineView, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "ref");
        PureShowWidgetInlineView pureShowWidgetInlineView2 = (PureShowWidgetInlineView) weakReference.get();
        return pureShowWidgetInlineView2 == null || pureShowWidgetInlineView2 == pureShowWidgetInlineView;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0637R.layout.trae_fragment_conversation_detail, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.rvMessages = view.findViewById(C0637R.id.rv_messages);
        this.btnScrollToBottom = (ImageView) view.findViewById(C0637R.id.btn_scroll_to_bottom);
        this.olderPageLoading = (TraeLoadingView) view.findViewById(C0637R.id.progress_older_page_loading);
        this.newerPageLoading = (TraeLoadingView) view.findViewById(C0637R.id.progress_newer_page_loading);
        applyDirectionalLoadingVisibility();
        this.lm = new LinearLayoutManager(requireContext());
        RecyclerView recyclerView = this.rvMessages;
        if (recyclerView != null) {
            recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        LinearLayoutManager linearLayoutManager = this.lm;
        if (linearLayoutManager != null) {
            linearLayoutManager.setSmoothScrollbarEnabled(false);
        }
        RecyclerView recyclerView2 = this.rvMessages;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(this.lm);
        }
        this.touchSlop = ViewConfiguration.get(requireContext()).getScaledTouchSlop();
        RecyclerView recyclerView3 = this.rvMessages;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(false);
        }
        getAdapter().setOnRetryClick(new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = ConversationDetailFragment.onViewCreated$lambda$3(ConversationDetailFragment.this, (String) obj);
                return onViewCreated$lambda$3;
            }
        });
        getAdapter().setOnUseExpressPassClick(new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$4;
                onViewCreated$lambda$4 = ConversationDetailFragment.onViewCreated$lambda$4(ConversationDetailFragment.this, (String) obj);
                return onViewCreated$lambda$4;
            }
        });
        getAdapter().setOnFeedbackClick(new Function2() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$5;
                onViewCreated$lambda$5 = ConversationDetailFragment.onViewCreated$lambda$5(ConversationDetailFragment.this, (String) obj, (String) obj2);
                return onViewCreated$lambda$5;
            }
        });
        getAdapter().setOnCopyClick(new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$6;
                onViewCreated$lambda$6 = ConversationDetailFragment.onViewCreated$lambda$6(ConversationDetailFragment.this, (String) obj);
                return onViewCreated$lambda$6;
            }
        });
        getAdapter().setOnReportClick(new Function2() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = ConversationDetailFragment.onViewCreated$lambda$7(ConversationDetailFragment.this, (String) obj, (String) obj2);
                return onViewCreated$lambda$7;
            }
        });
        getAdapter().setOnUpgradeReminderClick(new Function1() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$8;
                onViewCreated$lambda$8 = ConversationDetailFragment.onViewCreated$lambda$8(ConversationDetailFragment.this, (String) obj);
                return onViewCreated$lambda$8;
            }
        });
        getAdapter().m822xe8a7be5b(this.onPureShowWidgetInlineViewCreated);
        RecyclerView recyclerView4 = this.rvMessages;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(getAdapter());
        }
        RecyclerView recyclerView5 = this.rvMessages;
        if (recyclerView5 != null) {
            LinearLayoutManager linearLayoutManager2 = this.lm;
            Intrinsics.checkNotNull(linearLayoutManager2);
            StickyBottomScroller stickyBottomScroller = new StickyBottomScroller(recyclerView5, linearLayoutManager2);
            this.stickyBottomScroller = stickyBottomScroller;
            stickyBottomScroller.attach((RecyclerView.Adapter) getAdapter());
            getAdapter().setOnContentChanged(new Function0() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit onViewCreated$lambda$10$lambda$9;
                    onViewCreated$lambda$10$lambda$9 = ConversationDetailFragment.onViewCreated$lambda$10$lambda$9(ConversationDetailFragment.this);
                    return onViewCreated$lambda$10$lambda$9;
                }
            });
        }
        RecyclerView recyclerView6 = this.rvMessages;
        if (recyclerView6 != null) {
            recyclerView6.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$onViewCreated$8
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
                
                    if (r5 != 3) goto L22;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                    Float f;
                    int i;
                    int i2;
                    Intrinsics.checkNotNullParameter(rv, "rv");
                    Intrinsics.checkNotNullParameter(e, "e");
                    int actionMasked = e.getActionMasked();
                    if (actionMasked != 0) {
                        if (actionMasked != 1) {
                            if (actionMasked == 2) {
                                f = ConversationDetailFragment.this.lastTouchY;
                                if (f != null) {
                                    float y = e.getY() - f.floatValue();
                                    i = ConversationDetailFragment.this.touchSlop;
                                    if (y > i) {
                                        ConversationDetailFragment.this.userDraggedTowardOlderSinceLastCheck = true;
                                    } else {
                                        float floatValue = f.floatValue() - e.getY();
                                        i2 = ConversationDetailFragment.this.touchSlop;
                                        if (floatValue > i2) {
                                            ConversationDetailFragment.this.userDraggedTowardNewerSinceLastCheck = true;
                                        }
                                    }
                                }
                                ConversationDetailFragment.this.lastTouchY = Float.valueOf(e.getY());
                            }
                        }
                        ConversationDetailFragment.this.lastTouchY = null;
                    } else {
                        ConversationDetailFragment.this.lastTouchY = Float.valueOf(e.getY());
                        ConversationDetailFragment.this.userDraggedTowardOlderSinceLastCheck = false;
                        ConversationDetailFragment.this.userDraggedTowardNewerSinceLastCheck = false;
                    }
                    return false;
                }
            });
        }
        RecyclerView recyclerView7 = this.rvMessages;
        if (recyclerView7 != null) {
            recyclerView7.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$onViewCreated$9
                public void onScrollStateChanged(RecyclerView recyclerView8, int newState) {
                    Function0<Unit> onUserScrolled;
                    Intrinsics.checkNotNullParameter(recyclerView8, "recyclerView");
                    if (newState == 1 && (onUserScrolled = ConversationDetailFragment.this.getOnUserScrolled()) != null) {
                        onUserScrolled.invoke();
                    }
                    if (newState == 0) {
                        ConversationDetailFragment.this.updateScrollToBottomVisibility();
                        ConversationDetailFragment.this.maybeLoadOlderAtTop();
                        ConversationDetailFragment.this.maybeLoadNewerAtBottom();
                    }
                }
            });
        }
        ImageView imageView = this.btnScrollToBottom;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ConversationDetailFragment.onViewCreated$lambda$11(ConversationDetailFragment.this, view2);
                }
            });
        }
        this.fpsTracer.startRecyclerView(this.rvMessages);
    }

    public static final Unit onViewCreated$lambda$3(ConversationDetailFragment conversationDetailFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Function1<? super String, Unit> function1 = conversationDetailFragment.onRetryClick;
        if (function1 != null) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$4(ConversationDetailFragment conversationDetailFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Function1<? super String, Unit> function1 = conversationDetailFragment.onUseExpressPassClick;
        if (function1 != null) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$5(ConversationDetailFragment conversationDetailFragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, "resultType");
        Function2<? super String, ? super String, Unit> function2 = conversationDetailFragment.onFeedbackClick;
        if (function2 != null) {
            function2.invoke(str, str2);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$6(ConversationDetailFragment conversationDetailFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Function1<? super String, Unit> function1 = conversationDetailFragment.onCopyClick;
        if (function1 != null) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$7(ConversationDetailFragment conversationDetailFragment, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "messageId");
        Intrinsics.checkNotNullParameter(str2, ReportConstant.COMMON_CONTENT);
        Function2<? super String, ? super String, Unit> function2 = conversationDetailFragment.onReportClick;
        if (function2 != null) {
            function2.invoke(str, str2);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$8(ConversationDetailFragment conversationDetailFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Function1<? super String, Unit> function1 = conversationDetailFragment.onUpgradeReminderClick;
        if (function1 != null) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit onViewCreated$lambda$10$lambda$9(ConversationDetailFragment conversationDetailFragment) {
        StickyBottomScroller stickyBottomScroller = conversationDetailFragment.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.onItemContentChanged();
        }
        return Unit.INSTANCE;
    }

    public static final void onViewCreated$lambda$11(ConversationDetailFragment conversationDetailFragment, View view) {
        StickyBottomScroller stickyBottomScroller;
        Function0<Boolean> function0 = conversationDetailFragment.onJumpToBottomClick;
        boolean z = false;
        if (function0 != null && ((Boolean) function0.invoke()).booleanValue()) {
            z = true;
        }
        if (!z && (stickyBottomScroller = conversationDetailFragment.stickyBottomScroller) != null) {
            stickyBottomScroller.forceScrollToBottom();
        }
        ImageView imageView = conversationDetailFragment.btnScrollToBottom;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final void setConversation(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        getAdapter().setConversation(conversation);
    }

    public final void setUpgradeReminder(String conversationId, boolean visible) {
        getAdapter().setUpgradeReminder(conversationId, visible);
    }

    public final void setTask() {
        LinearLayoutManager linearLayoutManager = this.lm;
        if (linearLayoutManager != null) {
            linearLayoutManager.setSmoothScrollbarEnabled(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void submitMessages$default(ConversationDetailFragment conversationDetailFragment, List list, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        conversationDetailFragment.submitMessages(list, z, function0);
    }

    public final void submitMessages(List<ParsedChatMessage> messages, final boolean snapToBottom, final Function0<Unit> onCommitted) {
        StickyBottomScroller stickyBottomScroller;
        StickyBottomScroller stickyBottomScroller2;
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (messages.isEmpty() && (stickyBottomScroller2 = this.stickyBottomScroller) != null) {
            stickyBottomScroller2.resetFirstSubmit();
        }
        VisibleAnchor visibleAnchor = null;
        VisibleAnchor visibleAnchorForHistoryAppend = snapToBottom ? null : visibleAnchorForHistoryAppend(messages);
        final VisibleAnchor visibleAnchor2 = (!snapToBottom && (visibleAnchor = visibleAnchorForPrepend(messages)) == null) ? visibleAnchorForHistoryAppend : visibleAnchor;
        final boolean z = visibleAnchorForHistoryAppend != null || snapToBottom;
        if (z && (stickyBottomScroller = this.stickyBottomScroller) != null) {
            stickyBottomScroller.suppressDataChangeScroll();
        }
        getAdapter().submitMessages(messages, new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                ConversationDetailFragment.submitMessages$lambda$14(ConversationDetailFragment.this, visibleAnchor2, snapToBottom, onCommitted, z);
            }
        });
    }

    public static final void submitMessages$lambda$14(ConversationDetailFragment conversationDetailFragment, VisibleAnchor visibleAnchor, boolean z, Function0 function0, boolean z2) {
        RecyclerView recyclerView;
        StickyBottomScroller stickyBottomScroller = conversationDetailFragment.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.onFirstSubmit();
        }
        if (visibleAnchor != null) {
            conversationDetailFragment.restoreVisibleAnchor(visibleAnchor);
        }
        if (z) {
            conversationDetailFragment.forceScrollToBottom();
        }
        conversationDetailFragment.scheduleScrollToBottomVisibilityUpdate();
        if (function0 != null) {
            function0.invoke();
        }
        if (!z2 || (recyclerView = conversationDetailFragment.rvMessages) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConversationDetailFragment.submitMessages$lambda$14$lambda$13(ConversationDetailFragment.this);
            }
        });
    }

    public static final void submitMessages$lambda$14$lambda$13(ConversationDetailFragment conversationDetailFragment) {
        StickyBottomScroller stickyBottomScroller = conversationDetailFragment.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.resumeDataChangeScroll();
        }
    }

    public final void setAnchorLoading(boolean loading) {
        this.isAnchorLoadingVisible = loading;
        applyAnchorLoadingVisibility();
    }

    public final void setLoadingMore(boolean loading) {
        TraeLogUtil.INSTANCE.d(TAG, "setLoadingMore: " + loading);
        this.isOlderPageLoadingVisible = loading;
        applyDirectionalLoadingVisibility();
    }

    public final void setLoadingNewer(boolean loading) {
        TraeLogUtil.INSTANCE.d(TAG, "setLoadingNewer: " + loading);
        this.isNewerPageLoadingVisible = loading;
        applyDirectionalLoadingVisibility();
        if (loading) {
            ImageView imageView = this.btnScrollToBottom;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        updateScrollToBottomVisibility();
    }

    public final void setHasMore(boolean hasMore) {
        TraeLogUtil.INSTANCE.d(TAG, "setHasMore: " + hasMore);
        this.hasMoreOlderMessages = hasMore;
    }

    public final void scrollToBottom() {
        StickyBottomScroller stickyBottomScroller = this.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.scrollToBottom();
        }
    }

    public final void forceScrollToBottom() {
        StickyBottomScroller stickyBottomScroller = this.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.forceScrollToBottom();
        }
        ImageView imageView = this.btnScrollToBottom;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public final boolean scrollToCreatedAt(String anchorCreatedAtMs) {
        final int i;
        Intrinsics.checkNotNullParameter(anchorCreatedAtMs, "anchorCreatedAtMs");
        Long longOrNull = StringsKt.toLongOrNull(anchorCreatedAtMs);
        if (longOrNull == null) {
            return false;
        }
        long longValue = longOrNull.longValue();
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator it = currentList.iterator();
        int i2 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((ParsedChatMessage) it.next()).getCreatedAt() >= longValue) {
                break;
            }
            i2++;
        }
        Integer valueOf = Integer.valueOf(i2);
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        } else {
            List currentList2 = getAdapter().getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
            ListIterator listIterator = currentList2.listIterator(currentList2.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                if (((ParsedChatMessage) listIterator.previous()).getCreatedAt() <= longValue) {
                    i = listIterator.nextIndex();
                    break;
                }
            }
        }
        if (i < 0) {
            return false;
        }
        RecyclerView recyclerView = this.rvMessages;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDetailFragment.scrollToCreatedAt$lambda$18(ConversationDetailFragment.this, i);
                }
            });
        }
        return true;
    }

    public static final void scrollToCreatedAt$lambda$18(ConversationDetailFragment conversationDetailFragment, int i) {
        LinearLayoutManager linearLayoutManager = conversationDetailFragment.lm;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i, 96);
        }
        conversationDetailFragment.scheduleScrollToBottomVisibilityUpdate();
    }

    public final void refreshLatestAgentMessage() {
        int i;
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        ListIterator listIterator = currentList.listIterator(currentList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            } else if (!((ParsedChatMessage) listIterator.previous()).isUserMessage()) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i >= 0) {
            getAdapter().notifyItemChanged(i);
        }
    }

    public final List<ParsedChatMessage> getMessages() {
        List<ParsedChatMessage> currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        return currentList;
    }

    public final ParsedChatMessage getLastMessage() {
        Object obj;
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        ListIterator listIterator = currentList.listIterator(currentList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
            if (parsedChatMessage.isAssistantMessage() && parsedChatMessage.isHistory()) {
                break;
            }
        }
        return (ParsedChatMessage) obj;
    }

    public void onDestroyView() {
        StickyBottomScroller stickyBottomScroller = this.stickyBottomScroller;
        if (stickyBottomScroller != null) {
            stickyBottomScroller.detach((RecyclerView.Adapter) getAdapter());
        }
        this.stickyBottomScroller = null;
        releasePureShowWidgetInlineViews();
        getAdapter().m822xe8a7be5b(null);
        RecyclerView recyclerView = this.rvMessages;
        if (recyclerView != null) {
            recyclerView.setAdapter((RecyclerView.Adapter) null);
        }
        this.rvMessages = null;
        this.btnScrollToBottom = null;
        this.olderPageLoading = null;
        this.newerPageLoading = null;
        super.onDestroyView();
    }

    private final void releasePureShowWidgetInlineViews() {
        Iterator<T> it = this.pureShowWidgetInlineViewRefs.iterator();
        while (it.hasNext()) {
            PureShowWidgetInlineView pureShowWidgetInlineView = (PureShowWidgetInlineView) ((WeakReference) it.next()).get();
            if (pureShowWidgetInlineView != null) {
                pureShowWidgetInlineView.release();
            }
        }
        this.pureShowWidgetInlineViewRefs.clear();
    }

    public final void maybeLoadOlderAtTop() {
        LinearLayoutManager linearLayoutManager;
        Function0<Unit> function0 = this.onLoadMore;
        if (function0 == null || !this.userDraggedTowardOlderSinceLastCheck || !this.hasMoreOlderMessages || this.isOlderPageLoadingVisible || getAdapter().getCurrentList().isEmpty() || (linearLayoutManager = this.lm) == null || linearLayoutManager.findFirstVisibleItemPosition() > 0) {
            return;
        }
        this.userDraggedTowardOlderSinceLastCheck = false;
        setLoadingMore(true);
        function0.invoke();
    }

    public final void maybeLoadNewerAtBottom() {
        LinearLayoutManager linearLayoutManager;
        Function0<Unit> function0 = this.onLoadNewer;
        if (function0 == null || (linearLayoutManager = this.lm) == null || !this.userDraggedTowardNewerSinceLastCheck || this.isNewerPageLoadingVisible || getAdapter().getCurrentList().isEmpty() || linearLayoutManager.findLastVisibleItemPosition() < getAdapter().getCurrentList().size() - 1) {
            return;
        }
        this.userDraggedTowardNewerSinceLastCheck = false;
        setLoadingNewer(true);
        function0.invoke();
    }

    public final void updateScrollToBottomVisibility() {
        LinearLayoutManager linearLayoutManager = this.lm;
        if (linearLayoutManager == null) {
            return;
        }
        int itemCount = linearLayoutManager.getItemCount();
        if (this.isNewerPageLoadingVisible) {
            ImageView imageView = this.btnScrollToBottom;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (itemCount == 0) {
            ImageView imageView2 = this.btnScrollToBottom;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        if (getAdapter().getCurrentList().isEmpty()) {
            ImageView imageView3 = this.btnScrollToBottom;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
                return;
            }
            return;
        }
        if (linearLayoutManager.findLastVisibleItemPosition() >= itemCount - 1) {
            ImageView imageView4 = this.btnScrollToBottom;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
                return;
            }
            return;
        }
        showScrollToBottomWithBounce();
    }

    private final void applyAnchorLoadingVisibility() {
        applyDirectionalLoadingVisibility();
    }

    private final void applyDirectionalLoadingVisibility() {
        TraeLoadingView traeLoadingView = this.olderPageLoading;
        if (traeLoadingView != null) {
            traeLoadingView.setLoadingVisible(this.isAnchorLoadingVisible || this.isOlderPageLoadingVisible);
        }
        TraeLoadingView traeLoadingView2 = this.newerPageLoading;
        if (traeLoadingView2 != null) {
            traeLoadingView2.setLoadingVisible(this.isNewerPageLoadingVisible);
        }
    }

    /* compiled from: ConversationDetailFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$VisibleAnchor;", "", "messageId", "", "topOffset", "", "<init>", "(Ljava/lang/String;I)V", "getMessageId", "()Ljava/lang/String;", "getTopOffset", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class VisibleAnchor {
        private final String messageId;
        private final int topOffset;

        public static /* synthetic */ VisibleAnchor copy$default(VisibleAnchor visibleAnchor, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = visibleAnchor.messageId;
            }
            if ((i2 & 2) != 0) {
                i = visibleAnchor.topOffset;
            }
            return visibleAnchor.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTopOffset() {
            return this.topOffset;
        }

        public final VisibleAnchor copy(String messageId, int topOffset) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            return new VisibleAnchor(messageId, topOffset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VisibleAnchor)) {
                return false;
            }
            VisibleAnchor visibleAnchor = (VisibleAnchor) other;
            return Intrinsics.areEqual(this.messageId, visibleAnchor.messageId) && this.topOffset == visibleAnchor.topOffset;
        }

        public int hashCode() {
            return (this.messageId.hashCode() * 31) + Integer.hashCode(this.topOffset);
        }

        public String toString() {
            return "VisibleAnchor(messageId=" + this.messageId + ", topOffset=" + this.topOffset + ')';
        }

        public VisibleAnchor(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "messageId");
            this.messageId = str;
            this.topOffset = i;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final int getTopOffset() {
            return this.topOffset;
        }
    }

    private final VisibleAnchor visibleAnchorForPrepend(List<ParsedChatMessage> nextMessages) {
        ParsedChatMessage parsedChatMessage;
        String messageId;
        LinearLayoutManager linearLayoutManager;
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        if (currentList.isEmpty() || nextMessages.isEmpty() || (parsedChatMessage = (ParsedChatMessage) CollectionsKt.firstOrNull(currentList)) == null || (messageId = parsedChatMessage.getMessageId()) == null) {
            return null;
        }
        Iterator<ParsedChatMessage> it = nextMessages.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getMessageId(), messageId)) {
                break;
            }
            i++;
        }
        if (i <= 0 || (linearLayoutManager = this.lm) == null) {
            return null;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (!(findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < currentList.size())) {
            return null;
        }
        String messageId2 = ((ParsedChatMessage) currentList.get(findFirstVisibleItemPosition)).getMessageId();
        View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        return new VisibleAnchor(messageId2, findViewByPosition != null ? findViewByPosition.getTop() : 0);
    }

    private final VisibleAnchor visibleAnchorForHistoryAppend(List<ParsedChatMessage> nextMessages) {
        boolean z;
        boolean z2;
        LinearLayoutManager linearLayoutManager;
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        if (!currentList.isEmpty() && nextMessages.size() > currentList.size()) {
            List list = currentList;
            Iterable indices = CollectionsKt.getIndices(list);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                IntIterator it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = it.nextInt();
                    ParsedChatMessage parsedChatMessage = (ParsedChatMessage) CollectionsKt.getOrNull(nextMessages, nextInt);
                    if (!Intrinsics.areEqual(parsedChatMessage != null ? parsedChatMessage.getMessageId() : null, ((ParsedChatMessage) currentList.get(nextInt)).getMessageId())) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return null;
            }
            List drop = CollectionsKt.drop(nextMessages, currentList.size());
            if (!drop.isEmpty()) {
                List list2 = drop;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!((ParsedChatMessage) it2.next()).isHistory()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2 || (linearLayoutManager = this.lm) == null) {
                    return null;
                }
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (!(findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < list.size())) {
                    return null;
                }
                String messageId = ((ParsedChatMessage) currentList.get(findFirstVisibleItemPosition)).getMessageId();
                View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                return new VisibleAnchor(messageId, findViewByPosition != null ? findViewByPosition.getTop() : 0);
            }
        }
        return null;
    }

    private final void restoreVisibleAnchor(final VisibleAnchor anchor) {
        RecyclerView recyclerView;
        List currentList = getAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator it = currentList.iterator();
        final int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((ParsedChatMessage) it.next()).getMessageId(), anchor.getMessageId())) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0 && (recyclerView = this.rvMessages) != null) {
            recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDetailFragment.restoreVisibleAnchor$lambda$26(ConversationDetailFragment.this, i, anchor);
                }
            });
        }
    }

    public static final void restoreVisibleAnchor$lambda$26(ConversationDetailFragment conversationDetailFragment, int i, VisibleAnchor visibleAnchor) {
        LinearLayoutManager linearLayoutManager = conversationDetailFragment.lm;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i, visibleAnchor.getTopOffset());
        }
        conversationDetailFragment.scheduleScrollToBottomVisibilityUpdate();
    }

    private final void scheduleScrollToBottomVisibilityUpdate() {
        RecyclerView recyclerView = this.rvMessages;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDetailFragment.scheduleScrollToBottomVisibilityUpdate$lambda$28(ConversationDetailFragment.this);
                }
            });
        }
    }

    public static final void scheduleScrollToBottomVisibilityUpdate$lambda$28(ConversationDetailFragment conversationDetailFragment) {
        RecyclerView recyclerView = conversationDetailFragment.rvMessages;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.ConversationDetailFragment$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationDetailFragment.this.updateScrollToBottomVisibility();
                }
            });
        }
    }

    private final void showScrollToBottomWithBounce() {
        ImageView imageView = this.btnScrollToBottom;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new OvershootInterpolator(1.5f));
        animatorSet.start();
    }

    /* compiled from: ConversationDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/conversation/chat/ConversationDetailFragment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConversationDetailFragment newInstance() {
            return new ConversationDetailFragment();
        }
    }
}
