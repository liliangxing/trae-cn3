package com.bytedance.trae.conversation.chat.viewholder;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.IMessageListener;
import com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow;
import com.bytedance.trae.conversation.chat.menu.MessagePopupWindow;
import com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.bytedance.trae.conversation.products.InputPreviewActivity;
import com.bytedance.trae.conversation.products.LocalArtifactPath;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.conversation.tracker.AIEventContext;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.tracker.SoloChatMode;
import com.bytedance.trae.conversation.tracker.TraeAITracker;
import com.bytedance.trae.conversation.widget.CustomTagSpan;
import com.bytedance.trae.conversation.widget.CustomTagStyle;
import com.bytedance.trae.conversation.widget.PluginTagItem;
import com.bytedance.trae.conversation.widget.PluginTagSpan;
import com.bytedance.trae.conversation.widget.SkillTagSpan;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.MessagePartNormalizer;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020 H\u0002J\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u001cJ\b\u00103\u001a\u00020$H\u0002J\b\u00104\u001a\u00020$H\u0002J\b\u00105\u001a\u00020$H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001eH\u0002J\u0012\u00108\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b.\u0010/¨\u0006@"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "messageListener", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "<init>", "(Landroid/view/View;Lcom/bytedance/trae/conversation/chat/IMessageListener;)V", "getMessageListener", "()Lcom/bytedance/trae/conversation/chat/IMessageListener;", "tvContent", "Landroid/widget/TextView;", "rvImages", "Landroidx/recyclerview/widget/RecyclerView;", "messageContainer", "textContainer", "Landroid/widget/FrameLayout;", "gradientMask", "tvShowMore", "attachmentAdapter", "Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;", "resolveJob", "Lkotlinx/coroutines/Job;", "messagePopupWindow", "Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;", "expandedTextPopupWindow", "Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;", "currentMessage", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "maxCount", "", "isExpanded", "", "resolveChatMode", "Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "handleDeleteClick", "", "isExecutionCompleted", "imageUploadApi", "Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "getImageUploadApi", "()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;", "imageUploadApi$delegate", "Lkotlin/Lazy;", "resourceUploadApi", "Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "getResourceUploadApi", "()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;", "resourceUploadApi$delegate", "bind", "message", "setupGradientMask", "applyCollapseState", "applyExpandedState", "dp", "value", "startsWithAgentReviewMarker", "getAgentReviewMarkerTagText", "", "part", "Lcom/bytedance/trae/im/model/MessagePart;", "getAgentReviewMarkerDescription", "Companion", "AttachmentListAdapter", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserMessageViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AttachmentListAdapter attachmentAdapter;
    private ParsedChatMessage currentMessage;
    private ExpandedTextPopupWindow expandedTextPopupWindow;
    private final View gradientMask;

    /* renamed from: imageUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy imageUploadApi;
    private boolean isExpanded;
    private final int maxCount;
    private final View messageContainer;
    private final IMessageListener messageListener;
    private MessagePopupWindow messagePopupWindow;
    private Job resolveJob;

    /* renamed from: resourceUploadApi$delegate, reason: from kotlin metadata */
    private final Lazy resourceUploadApi;
    private final RecyclerView rvImages;
    private final FrameLayout textContainer;
    private final TextView tvContent;
    private final TextView tvShowMore;

    public final IMessageListener getMessageListener() {
        return this.messageListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder(final View view, IMessageListener iMessageListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.messageListener = iMessageListener;
        View findViewById = view.findViewById(C0637R.id.tv_message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.tvContent = textView;
        RecyclerView findViewById2 = view.findViewById(C0637R.id.rv_images);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        RecyclerView recyclerView = findViewById2;
        this.rvImages = recyclerView;
        View findViewById3 = view.findViewById(C0637R.id.ll_message_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.messageContainer = findViewById3;
        View findViewById4 = view.findViewById(C0637R.id.fl_text_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.textContainer = (FrameLayout) findViewById4;
        View findViewById5 = view.findViewById(C0637R.id.v_gradient_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.gradientMask = findViewById5;
        View findViewById6 = view.findViewById(C0637R.id.tv_show_more);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        TextView textView2 = (TextView) findViewById6;
        this.tvShowMore = textView2;
        AttachmentListAdapter attachmentListAdapter = new AttachmentListAdapter();
        this.attachmentAdapter = attachmentListAdapter;
        this.maxCount = 6;
        this.imageUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda4
            public final Object invoke() {
                ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$3;
                imageUploadApi_delegate$lambda$3 = UserMessageViewHolder.imageUploadApi_delegate$lambda$3();
                return imageUploadApi_delegate$lambda$3;
            }
        });
        this.resourceUploadApi = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda5
            public final Object invoke() {
                ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$5;
                resourceUploadApi_delegate$lambda$5 = UserMessageViewHolder.resourceUploadApi_delegate$lambda$5();
                return resourceUploadApi_delegate$lambda$5;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        recyclerView.setAdapter(attachmentListAdapter);
        final int m830dp = m830dp(12);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder.1
            public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                if (parent.getChildAdapterPosition(view2) < (parent.getAdapter() != null ? r4.getItemCount() : 0) - 1) {
                    outRect.right = m830dp;
                }
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean _init_$lambda$7;
                _init_$lambda$7 = UserMessageViewHolder._init_$lambda$7(UserMessageViewHolder.this, view2);
                return _init_$lambda$7;
            }
        });
        setupGradientMask();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserMessageViewHolder._init_$lambda$9(UserMessageViewHolder.this, view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoloChatMode resolveChatMode() {
        Conversation currentConversation;
        IMessageListener iMessageListener = this.messageListener;
        String mode = (iMessageListener == null || (currentConversation = iMessageListener.getCurrentConversation()) == null) ? null : currentConversation.getMode();
        return Intrinsics.areEqual(mode, "work") ? SoloChatMode.WORK : Intrinsics.areEqual(mode, "code") ? SoloChatMode.CODE : SoloChatMode.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDeleteClick() {
        List<ParsedChatMessage> emptyList;
        int i;
        CustomConfirmDialog delete;
        Conversation currentConversation;
        final ParsedChatMessage parsedChatMessage = this.currentMessage;
        if (parsedChatMessage == null) {
            return;
        }
        Context context = this.tvContent.getContext();
        IMessageListener iMessageListener = this.messageListener;
        String id = (iMessageListener == null || (currentConversation = iMessageListener.getCurrentConversation()) == null) ? null : currentConversation.getId();
        if (id == null) {
            id = "";
        }
        String str = id;
        final SoloChatMode resolveChatMode = resolveChatMode();
        TraeAITracker.INSTANCE.trackDeleteClick(new AIEventContext(null, str, parsedChatMessage.getMessageId(), null, 9, null), resolveChatMode);
        IMessageListener iMessageListener2 = this.messageListener;
        if (iMessageListener2 == null || (emptyList = iMessageListener2.getAllMessages()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<ParsedChatMessage> list = emptyList;
        int i2 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ParsedChatMessage) it.next()).isUserMessage() && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        final int i3 = i2;
        if (i3 == 1) {
            i = R.string.trae_conversation_dialog_delete_last_message_desc;
        } else {
            i = R.string.trae_conversation_dialog_delete_message_desc;
        }
        int i4 = i;
        CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
        Intrinsics.checkNotNull(context);
        String string = context.getString(R.string.trae_conversation_dialog_delete_message_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(R.string.trae_conversation_dialog_btn_delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        delete = companion.delete(context, string, string2, (r38 & 8) != 0 ? "" : null, string3, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : 0, (r38 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : 0, new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit handleDeleteClick$lambda$1;
                handleDeleteClick$lambda$1 = UserMessageViewHolder.handleDeleteClick$lambda$1(UserMessageViewHolder.this, i3, parsedChatMessage, resolveChatMode);
                return handleDeleteClick$lambda$1;
            }
        }, (r38 & 65536) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        delete.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleDeleteClick$lambda$1(UserMessageViewHolder userMessageViewHolder, int i, ParsedChatMessage parsedChatMessage, SoloChatMode soloChatMode) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new UserMessageViewHolder$handleDeleteClick$1$1(userMessageViewHolder, i, parsedChatMessage, soloChatMode, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private final boolean isExecutionCompleted() {
        IMessageListener iMessageListener;
        return (this.currentMessage == null || (iMessageListener = this.messageListener) == null || iMessageListener.getAllMessages() == null || this.messageListener.isStreaming()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationCopilotImageUploadApi getImageUploadApi() {
        return (ConversationCopilotImageUploadApi) this.imageUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotImageUploadApi imageUploadApi_delegate$lambda$3() {
        return new ConversationCopilotImageUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda9
            public final Object invoke() {
                String imageUploadApi_delegate$lambda$3$lambda$2;
                imageUploadApi_delegate$lambda$3$lambda$2 = UserMessageViewHolder.imageUploadApi_delegate$lambda$3$lambda$2();
                return imageUploadApi_delegate$lambda$3$lambda$2;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String imageUploadApi_delegate$lambda$3$lambda$2() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationCopilotResourceUploadApi getResourceUploadApi() {
        return (ConversationCopilotResourceUploadApi) this.resourceUploadApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationCopilotResourceUploadApi resourceUploadApi_delegate$lambda$5() {
        return new ConversationCopilotResourceUploadApi(new Function0() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda1
            public final Object invoke() {
                String resourceUploadApi_delegate$lambda$5$lambda$4;
                resourceUploadApi_delegate$lambda$5$lambda$4 = UserMessageViewHolder.resourceUploadApi_delegate$lambda$5$lambda$4();
                return resourceUploadApi_delegate$lambda$5$lambda$4;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resourceUploadApi_delegate$lambda$5$lambda$4() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$7(final UserMessageViewHolder userMessageViewHolder, View view) {
        MessagePopupWindow.Mode mode;
        if (userMessageViewHolder.startsWithAgentReviewMarker(userMessageViewHolder.currentMessage)) {
            return true;
        }
        boolean z = false;
        if (!userMessageViewHolder.isExecutionCompleted()) {
            ParsedChatMessage parsedChatMessage = userMessageViewHolder.currentMessage;
            if (parsedChatMessage != null && UserMessageViewHolderKt.isBrainstormMessage(parsedChatMessage)) {
                return true;
            }
        }
        MessagePopupWindow messagePopupWindow = userMessageViewHolder.messagePopupWindow;
        if (messagePopupWindow != null) {
            messagePopupWindow.dismiss();
        }
        ExpandedTextPopupWindow expandedTextPopupWindow = userMessageViewHolder.expandedTextPopupWindow;
        if (expandedTextPopupWindow != null) {
            expandedTextPopupWindow.dismiss();
        }
        ParsedChatMessage parsedChatMessage2 = userMessageViewHolder.currentMessage;
        if (parsedChatMessage2 != null && UserMessageViewHolderKt.isBrainstormMessage(parsedChatMessage2)) {
            z = true;
        }
        if (z) {
            mode = MessagePopupWindow.Mode.Brainstorm;
        } else if (!userMessageViewHolder.isExecutionCompleted()) {
            mode = MessagePopupWindow.Mode.Event;
        } else {
            mode = MessagePopupWindow.Mode.Message;
        }
        MessagePopupWindow.OnMenuClickListener onMenuClickListener = new MessagePopupWindow.OnMenuClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$2$menuListener$1
            @Override // com.bytedance.trae.conversation.chat.menu.MessagePopupWindow.OnMenuClickListener
            public void onCopyClick() {
                TextView textView;
                TextView textView2;
                TextView textView3;
                textView = UserMessageViewHolder.this.tvContent;
                Object systemService = textView.getContext().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                textView2 = UserMessageViewHolder.this.tvContent;
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("message", textView2.getText()));
                textView3 = UserMessageViewHolder.this.tvContent;
                CustomToast.showLong(textView3.getContext(), R.string.trae_conversation_copied);
            }

            @Override // com.bytedance.trae.conversation.chat.menu.MessagePopupWindow.OnMenuClickListener
            public void onDeleteClick() {
                UserMessageViewHolder.this.handleDeleteClick();
            }

            @Override // com.bytedance.trae.conversation.chat.menu.MessagePopupWindow.OnMenuClickListener
            public void onRevertClick() {
                ParsedChatMessage parsedChatMessage3;
                SoloChatMode resolveChatMode;
                parsedChatMessage3 = UserMessageViewHolder.this.currentMessage;
                if (parsedChatMessage3 == null) {
                    return;
                }
                IMessageListener messageListener = UserMessageViewHolder.this.getMessageListener();
                Object obj = null;
                if ((messageListener != null ? messageListener.getCurrentConversation() : null) == null) {
                    return;
                }
                Conversation currentConversation = UserMessageViewHolder.this.getMessageListener().getCurrentConversation();
                String id = currentConversation != null ? currentConversation.getId() : null;
                if (id == null) {
                    id = "";
                }
                String str = id;
                resolveChatMode = UserMessageViewHolder.this.resolveChatMode();
                TraeAITracker.INSTANCE.trackRevertClick(new AIEventContext(null, str, parsedChatMessage3.getMessageId(), null, 9, null), resolveChatMode);
                List<ParsedChatMessage> allMessages = UserMessageViewHolder.this.getMessageListener().getAllMessages();
                if (allMessages == null) {
                    allMessages = CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : allMessages) {
                    if (((ParsedChatMessage) obj2).isUserMessage()) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    obj = it.next();
                    if (it.hasNext()) {
                        long createdAt = ((ParsedChatMessage) obj).getCreatedAt();
                        do {
                            Object next = it.next();
                            long createdAt2 = ((ParsedChatMessage) next).getCreatedAt();
                            if (createdAt > createdAt2) {
                                obj = next;
                                createdAt = createdAt2;
                            }
                        } while (it.hasNext());
                    }
                }
                ParsedChatMessage parsedChatMessage4 = (ParsedChatMessage) obj;
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new UserMessageViewHolder$2$menuListener$1$onRevertClick$1(UserMessageViewHolder.this, parsedChatMessage3, parsedChatMessage4 != null && Intrinsics.areEqual(parsedChatMessage4.getMessageId(), parsedChatMessage3.getMessageId()), resolveChatMode, null), 3, (Object) null);
            }
        };
        PopupWindow.OnDismissListener onDismissListener = new PopupWindow.OnDismissListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda8
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                UserMessageViewHolder.lambda$7$lambda$6(UserMessageViewHolder.this);
            }
        };
        if (userMessageViewHolder.isExpanded) {
            Context context = userMessageViewHolder.tvContent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            CharSequence text = userMessageViewHolder.tvContent.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            ExpandedTextPopupWindow expandedTextPopupWindow2 = new ExpandedTextPopupWindow(context, text, onMenuClickListener, mode);
            userMessageViewHolder.expandedTextPopupWindow = expandedTextPopupWindow2;
            expandedTextPopupWindow2.setOnDismissListener(onDismissListener);
            ExpandedTextPopupWindow expandedTextPopupWindow3 = userMessageViewHolder.expandedTextPopupWindow;
            if (expandedTextPopupWindow3 != null) {
                expandedTextPopupWindow3.showBelow(userMessageViewHolder.tvContent);
            }
        } else {
            Context context2 = userMessageViewHolder.tvContent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            MessagePopupWindow messagePopupWindow2 = new MessagePopupWindow(context2, onMenuClickListener, mode);
            userMessageViewHolder.messagePopupWindow = messagePopupWindow2;
            messagePopupWindow2.setOnDismissListener(onDismissListener);
            MessagePopupWindow messagePopupWindow3 = userMessageViewHolder.messagePopupWindow;
            if (messagePopupWindow3 != null) {
                messagePopupWindow3.showBelow(userMessageViewHolder.tvContent);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$7$lambda$6(UserMessageViewHolder userMessageViewHolder) {
        if (userMessageViewHolder.isExpanded) {
            return;
        }
        userMessageViewHolder.messageContainer.setBackgroundResource(C0637R.drawable.trae_bg_chat_bubble_sent);
        ViewCompat.setElevation(userMessageViewHolder.messageContainer, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$9(UserMessageViewHolder userMessageViewHolder, View view, View view2) {
        userMessageViewHolder.isExpanded = true;
        RecyclerView parent = view.getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? parent : null;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        final LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        final int bindingAdapterPosition = userMessageViewHolder.getBindingAdapterPosition();
        final int top = view.getTop() - (recyclerView != null ? recyclerView.getPaddingTop() : 0);
        userMessageViewHolder.applyExpandedState();
        if (linearLayoutManager == null || bindingAdapterPosition == -1) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                linearLayoutManager.scrollToPositionWithOffset(bindingAdapterPosition, top);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0247, code lost:
    
        if (r0 != null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x029e, code lost:
    
        if (r1 != null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02bb, code lost:
    
        if (r0 == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0360, code lost:
    
        if (r7 != null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x037d, code lost:
    
        if (r2 != null) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x04a7, code lost:
    
        if (r2 != null) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04cc, code lost:
    
        if (r2 != null) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04fa, code lost:
    
        if (r2 != null) goto L312;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bind(ParsedChatMessage message) {
        boolean z;
        boolean z2;
        String userContent;
        Object obj;
        String str;
        String str2;
        String str3;
        JsonElement jsonElement;
        Pair pair;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        JsonObject data;
        JsonElement jsonElement2;
        JsonObject data2;
        JsonElement jsonElement3;
        JsonObject data3;
        JsonElement jsonElement4;
        String str9;
        String str10;
        JsonObject data4;
        String str11;
        String str12;
        Object skillTagSpan;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        JsonElement jsonElement7;
        String str13;
        JsonObject data5;
        String str14;
        JsonElement jsonElement8;
        JsonElement jsonElement9;
        JsonElement jsonElement10;
        String str15;
        String str16;
        JsonElement jsonElement11;
        String str17;
        String str18;
        JsonElement jsonElement12;
        Intrinsics.checkNotNullParameter(message, "message");
        Job job = this.resolveJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
        this.currentMessage = message;
        IMessageListener iMessageListener = this.messageListener;
        Conversation currentConversation = iMessageListener != null ? iMessageListener.getCurrentConversation() : null;
        AttachmentListAdapter attachmentListAdapter = this.attachmentAdapter;
        String id = currentConversation != null ? currentConversation.getId() : null;
        String str19 = "";
        if (id == null) {
            id = "";
        }
        attachmentListAdapter.setConversationId(id);
        AttachmentListAdapter attachmentListAdapter2 = this.attachmentAdapter;
        String cliConversationId = currentConversation != null ? currentConversation.getCliConversationId() : null;
        if (cliConversationId == null) {
            cliConversationId = "";
        }
        attachmentListAdapter2.setChatSessionId(cliConversationId);
        AttachmentListAdapter attachmentListAdapter3 = this.attachmentAdapter;
        String environment = currentConversation != null ? currentConversation.getEnvironment() : null;
        if (environment == null) {
            environment = "";
        }
        attachmentListAdapter3.setCliType(environment);
        AttachmentListAdapter attachmentListAdapter4 = this.attachmentAdapter;
        String mode = currentConversation != null ? currentConversation.getMode() : null;
        if (mode == null) {
            mode = "";
        }
        attachmentListAdapter4.setMode(mode);
        this.attachmentAdapter.setMessageId(message.getMessageId());
        this.attachmentAdapter.setMessageListener(this.messageListener);
        this.isExpanded = false;
        List<MessagePart> query = message.getQuery();
        if (query == null) {
            query = CollectionsKt.emptyList();
        }
        Set of = SetsKt.setOf(new String[]{"slash_command", "text", "image", "attachment", MessagePart.TYPE_FOLDER, "code", MessagePart.TYPE_TERMINAL, MessagePart.TYPE_WEB_PAGE, MessagePart.TYPE_FILE, MessagePart.TYPE_CREATE_MR});
        List<MessagePart> list = query;
        boolean z3 = list instanceof Collection;
        if (!z3 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!CollectionsKt.contains(of, ((MessagePart) it.next()).getType())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            this.messageContainer.setVisibility(0);
            this.tvContent.setText(this.itemView.getContext().getString(R.string.trae_conversation_unsupported_message_format));
            this.rvImages.setVisibility(8);
            this.attachmentAdapter.submitList(CollectionsKt.emptyList(), MapsKt.emptyMap());
            return;
        }
        String str20 = "slash_command";
        if (!z3 || !list.isEmpty()) {
            for (MessagePart messagePart : list) {
                if (Intrinsics.areEqual(messagePart.getType(), "slash_command") || Intrinsics.areEqual(messagePart.getType(), MessagePart.TYPE_FOLDER) || Intrinsics.areEqual(messagePart.getType(), "code") || Intrinsics.areEqual(messagePart.getType(), MessagePart.TYPE_TERMINAL) || Intrinsics.areEqual(messagePart.getType(), MessagePart.TYPE_FILE) || Intrinsics.areEqual(messagePart.getType(), MessagePart.TYPE_CREATE_MR)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        String str21 = IWeixinService.ResponseConstants.URL;
        String str22 = MessagePart.TYPE_WEB_PAGE;
        if (z2) {
            this.messageContainer.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<MessagePart> it2 = query.iterator();
            while (it2.hasNext()) {
                MessagePart next = it2.next();
                CustomTagStyle fromMessagePartType = CustomTagStyle.INSTANCE.fromMessagePartType(next.getType(), next);
                if (Intrinsics.areEqual(next.getType(), "text")) {
                    JsonObject data6 = next.getData();
                    if (data6 != null && (jsonElement12 = data6.get(ReportConstant.COMMON_CONTENT)) != null) {
                        if (!jsonElement12.isJsonPrimitive()) {
                            jsonElement12 = null;
                        }
                        if (jsonElement12 != null) {
                            str17 = jsonElement12.getAsString();
                            str18 = str17;
                            if (!(str18 != null || str18.length() == 0)) {
                                spannableStringBuilder.append((CharSequence) str18);
                            }
                        }
                    }
                    str17 = null;
                    str18 = str17;
                    if (!(str18 != null || str18.length() == 0)) {
                    }
                } else if (Intrinsics.areEqual(next.getType(), str22)) {
                    JsonObject data7 = next.getData();
                    if (data7 != null && (jsonElement11 = data7.get(str21)) != null) {
                        if (!jsonElement11.isJsonPrimitive()) {
                            jsonElement11 = null;
                        }
                        if (jsonElement11 != null) {
                            str15 = jsonElement11.getAsString();
                            str16 = str15;
                            if (!(str16 != null || str16.length() == 0)) {
                                spannableStringBuilder.append((CharSequence) str16);
                            }
                        }
                    }
                    str15 = null;
                    str16 = str15;
                    if (!(str16 != null || str16.length() == 0)) {
                    }
                } else {
                    Iterator<MessagePart> it3 = it2;
                    if (Intrinsics.areEqual(next.getType(), str20)) {
                        JsonObject data8 = next.getData();
                        if (data8 != null && (jsonElement10 = data8.get("command_type")) != null) {
                            if (!jsonElement10.isJsonPrimitive()) {
                                jsonElement10 = null;
                            }
                            if (jsonElement10 != null) {
                                str9 = jsonElement10.getAsString();
                            }
                        }
                        str9 = str19;
                        str4 = str19;
                        str7 = str20;
                        str5 = str21;
                        if (Intrinsics.areEqual(str9, "skill") || Intrinsics.areEqual(str9, "plugin")) {
                            JsonObject data9 = next.getData();
                            if (data9 != null && (jsonElement7 = data9.get(IGoogleService.ResponseKey.DISPLAY_NAME)) != null) {
                                if (!jsonElement7.isJsonPrimitive()) {
                                    jsonElement7 = null;
                                }
                                if (jsonElement7 != null) {
                                    str10 = jsonElement7.getAsString();
                                    data4 = next.getData();
                                    if (data4 != null && (jsonElement6 = data4.get("command")) != null) {
                                        if (!jsonElement6.isJsonPrimitive()) {
                                            jsonElement6 = null;
                                        }
                                        if (jsonElement6 != null) {
                                            str11 = jsonElement6.getAsString();
                                        }
                                    }
                                    str11 = str4;
                                    if (Intrinsics.areEqual(str9, "plugin") && str10 != null) {
                                        if (!(str10.length() <= 0)) {
                                            str10 = null;
                                        }
                                    }
                                    str10 = str11;
                                    if (str10.length() <= 0) {
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (" " + str10 + (char) 160));
                                        int length2 = spannableStringBuilder.length();
                                        JsonObject data10 = next.getData();
                                        str6 = str22;
                                        if (data10 != null && (jsonElement5 = data10.get("icon_url")) != null) {
                                            if (!jsonElement5.isJsonPrimitive()) {
                                                jsonElement5 = null;
                                            }
                                            if (jsonElement5 != null) {
                                                str12 = jsonElement5.getAsString();
                                                int i = !Intrinsics.areEqual(str9, "plugin") ? C0637R.drawable.ic_chat_attachment_plugins : C0637R.drawable.ic_input_skill;
                                                if (Intrinsics.areEqual(str9, "plugin")) {
                                                    Context context = this.itemView.getContext();
                                                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                                                    skillTagSpan = new SkillTagSpan(context, str10, i, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 4088, null);
                                                } else {
                                                    Context context2 = this.itemView.getContext();
                                                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                                    skillTagSpan = new PluginTagSpan(context2, str10, i, new PluginTagItem(str11, str10, i, str12), str12, new WeakReference(this.tvContent), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 16320, null);
                                                }
                                                spannableStringBuilder.setSpan(skillTagSpan, length, length2, 33);
                                                spannableStringBuilder.append((CharSequence) " ");
                                            }
                                        }
                                        str12 = null;
                                        if (!Intrinsics.areEqual(str9, "plugin")) {
                                        }
                                        if (Intrinsics.areEqual(str9, "plugin")) {
                                        }
                                        spannableStringBuilder.setSpan(skillTagSpan, length, length2, 33);
                                        spannableStringBuilder.append((CharSequence) " ");
                                    }
                                }
                            }
                            str10 = null;
                            data4 = next.getData();
                            if (data4 != null) {
                                if (!jsonElement6.isJsonPrimitive()) {
                                }
                                if (jsonElement6 != null) {
                                }
                            }
                            str11 = str4;
                            if (Intrinsics.areEqual(str9, "plugin")) {
                                if (!(str10.length() <= 0)) {
                                }
                            }
                            str10 = str11;
                            if (str10.length() <= 0) {
                            }
                        } else {
                            JsonObject data11 = next.getData();
                            if (data11 != null && (jsonElement9 = data11.get(IGoogleService.ResponseKey.DISPLAY_NAME)) != null) {
                                if (!jsonElement9.isJsonPrimitive()) {
                                    jsonElement9 = null;
                                }
                                if (jsonElement9 != null) {
                                    str13 = jsonElement9.getAsString();
                                    data5 = next.getData();
                                    if (data5 != null && (jsonElement8 = data5.get("command")) != null) {
                                        if (!jsonElement8.isJsonPrimitive()) {
                                            jsonElement8 = null;
                                        }
                                        if (jsonElement8 != null) {
                                            str14 = jsonElement8.getAsString();
                                        }
                                    }
                                    str14 = str4;
                                    CustomTagStyle fromSlashCommandPartType = CustomTagStyle.INSTANCE.fromSlashCommandPartType(str14);
                                    if (str13 != null) {
                                        if (!(str13.length() > 0)) {
                                            str13 = null;
                                        }
                                    }
                                    str13 = str14;
                                    if (str13.length() <= 0) {
                                        int length3 = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (" " + str13 + (char) 160));
                                        int length4 = spannableStringBuilder.length();
                                        Context context3 = this.itemView.getContext();
                                        Intrinsics.checkNotNull(context3);
                                        spannableStringBuilder.setSpan(new CustomTagSpan(context3, str13, fromSlashCommandPartType.getIconRes(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fromSlashCommandPartType.getBgColor(context3), fromSlashCommandPartType.getTextColor(context3), 0.0f, 1272, null), length3, length4, 33);
                                        spannableStringBuilder.append((CharSequence) " ");
                                    }
                                }
                            }
                            str13 = null;
                            data5 = next.getData();
                            if (data5 != null) {
                                if (!jsonElement8.isJsonPrimitive()) {
                                }
                                if (jsonElement8 != null) {
                                }
                            }
                            str14 = str4;
                            CustomTagStyle fromSlashCommandPartType2 = CustomTagStyle.INSTANCE.fromSlashCommandPartType(str14);
                            if (str13 != null) {
                            }
                            str13 = str14;
                            if (str13.length() <= 0) {
                            }
                        }
                        it2 = it3;
                        str19 = str4;
                        str20 = str7;
                        str21 = str5;
                    } else {
                        str4 = str19;
                        str5 = str21;
                        str6 = str22;
                        str7 = str20;
                        if (fromMessagePartType != null) {
                            String type = next.getType();
                            if (type != null) {
                                switch (type.hashCode()) {
                                    case -1991372985:
                                        if (type.equals(MessagePart.TYPE_CREATE_MR)) {
                                            str8 = getAgentReviewMarkerTagText(next);
                                            break;
                                        }
                                        break;
                                    case -1268966290:
                                        if (type.equals(MessagePart.TYPE_FOLDER) && (data = next.getData()) != null && (jsonElement2 = data.get("name")) != null) {
                                            if (!jsonElement2.isJsonPrimitive()) {
                                                jsonElement2 = null;
                                            }
                                            if (jsonElement2 != null) {
                                                str8 = jsonElement2.getAsString();
                                                break;
                                            }
                                        }
                                        break;
                                    case -1181248900:
                                        if (type.equals(MessagePart.TYPE_TERMINAL)) {
                                            str8 = "Terminal";
                                            break;
                                        }
                                        break;
                                    case 3059181:
                                        if (type.equals("code") && (data2 = next.getData()) != null && (jsonElement3 = data2.get("name")) != null) {
                                            if (!jsonElement3.isJsonPrimitive()) {
                                                jsonElement3 = null;
                                            }
                                            if (jsonElement3 != null) {
                                                str8 = jsonElement3.getAsString();
                                                break;
                                            }
                                        }
                                        break;
                                    case 3143036:
                                        if (type.equals(MessagePart.TYPE_FILE) && (data3 = next.getData()) != null && (jsonElement4 = data3.get("name")) != null) {
                                            if (!jsonElement4.isJsonPrimitive()) {
                                                jsonElement4 = null;
                                            }
                                            if (jsonElement4 != null) {
                                                str8 = jsonElement4.getAsString();
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                            str8 = str4;
                            if (str8.length() > 0) {
                                int length5 = spannableStringBuilder.length();
                                spannableStringBuilder.append((CharSequence) (" " + str8 + (char) 160));
                                int length6 = spannableStringBuilder.length();
                                Context context4 = this.itemView.getContext();
                                Intrinsics.checkNotNull(context4);
                                spannableStringBuilder.setSpan(new CustomTagSpan(context4, str8, fromMessagePartType.getIconRes(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fromMessagePartType.getBgColor(context4), fromMessagePartType.getTextColor(context4), 0.0f, 1272, null), length5, length6, 33);
                                if (Intrinsics.areEqual(next.getType(), MessagePart.TYPE_CREATE_MR)) {
                                    String agentReviewMarkerDescription = getAgentReviewMarkerDescription(next);
                                    if (agentReviewMarkerDescription.length() > 0) {
                                        spannableStringBuilder.append((CharSequence) " ");
                                        spannableStringBuilder.append((CharSequence) agentReviewMarkerDescription);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    spannableStringBuilder.append((CharSequence) " ");
                                }
                            }
                        }
                    }
                    it2 = it3;
                    str19 = str4;
                    str20 = str7;
                    str21 = str5;
                    str22 = str6;
                }
            }
            this.tvContent.setText(spannableStringBuilder);
        } else {
            String str23 = IWeixinService.ResponseConstants.URL;
            Object obj2 = MessagePart.TYPE_WEB_PAGE;
            if (query == null || !(!query.isEmpty())) {
                userContent = message.getUserContent();
            } else {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                for (MessagePart messagePart2 : query) {
                    if (Intrinsics.areEqual(messagePart2.getType(), "text")) {
                        String extractText = MessagePartNormalizer.INSTANCE.extractText(messagePart2);
                        if (!(extractText == null || extractText.length() == 0)) {
                            spannableStringBuilder2.append((CharSequence) extractText);
                        }
                        Unit unit3 = Unit.INSTANCE;
                        str = str23;
                        obj = obj2;
                    } else {
                        obj = obj2;
                        if (Intrinsics.areEqual(messagePart2.getType(), obj)) {
                            JsonObject data12 = messagePart2.getData();
                            str = str23;
                            if (data12 != null && (jsonElement = data12.get(str)) != null) {
                                if (!jsonElement.isJsonPrimitive()) {
                                    jsonElement = null;
                                }
                                if (jsonElement != null) {
                                    str2 = jsonElement.getAsString();
                                    str3 = str2;
                                    if (!(str3 != null || str3.length() == 0)) {
                                        spannableStringBuilder2.append((CharSequence) str3);
                                    }
                                    Unit unit4 = Unit.INSTANCE;
                                }
                            }
                            str2 = null;
                            str3 = str2;
                            if (!(str3 != null || str3.length() == 0)) {
                            }
                            Unit unit42 = Unit.INSTANCE;
                        } else {
                            str = str23;
                        }
                    }
                    str23 = str;
                    obj2 = obj;
                }
                userContent = spannableStringBuilder2.toString();
            }
            if (TextUtils.isEmpty(userContent)) {
                this.messageContainer.setVisibility(8);
            } else {
                this.messageContainer.setVisibility(0);
            }
            this.tvContent.setText(userContent == null ? "" : userContent);
        }
        applyCollapseState();
        List<MessagePart> query2 = message.getQuery();
        if (query2 == null) {
            query2 = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : query2) {
            MessagePart messagePart3 = (MessagePart) obj3;
            if (Intrinsics.areEqual(messagePart3.getType(), "image") || Intrinsics.areEqual(messagePart3.getType(), "attachment")) {
                arrayList.add(obj3);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            this.rvImages.setVisibility(8);
            this.attachmentAdapter.submitList(CollectionsKt.emptyList(), MapsKt.emptyMap());
            return;
        }
        this.rvImages.setVisibility(0);
        ArrayList arrayList3 = new ArrayList();
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            UserPreviewImageItem previewImageItemFromData = UserMessageViewHolderKt.previewImageItemFromData((MessagePart) it4.next());
            if (previewImageItemFromData != null) {
                arrayList3.add(previewImageItemFromData);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            this.attachmentAdapter.submitList(arrayList2, MapsKt.emptyMap());
            return;
        }
        String chatSessionId = this.attachmentAdapter.getChatSessionId();
        if (StringsKt.isBlank(chatSessionId)) {
            chatSessionId = this.attachmentAdapter.getConversationId();
        }
        String str24 = chatSessionId;
        ArrayList<UserPreviewImageItem> arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (UserPreviewImageItem userPreviewImageItem : arrayList5) {
            if (userPreviewImageItem.getKind() == UserPreviewImageKind.LOCAL_ARTIFACT) {
                String requestTarget = LocalArtifactPath.INSTANCE.requestTarget(userPreviewImageItem.getSourceId());
                FileDownloadHelper fileDownloadHelper = new FileDownloadHelper();
                Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                File cachedFile = fileDownloadHelper.getCachedFile(applicationContext, str24, requestTarget);
                if (cachedFile != null) {
                    pair = TuplesKt.to(userPreviewImageItem.getSourceId(), Uri.fromFile(cachedFile).toString());
                }
                pair = null;
            } else {
                String str25 = ResourceRepoManager.INSTANCE.get(userPreviewImageItem.getSourceId());
                if (str25 != null) {
                    pair = TuplesKt.to(userPreviewImageItem.getSourceId(), str25);
                }
                pair = null;
            }
            if (pair != null) {
                arrayList6.add(pair);
            }
        }
        Map<String, String> map = MapsKt.toMap(arrayList6);
        ArrayList arrayList7 = new ArrayList();
        for (Object obj4 : arrayList5) {
            if (!map.containsKey(((UserPreviewImageItem) obj4).getSourceId())) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = arrayList7;
        this.attachmentAdapter.submitList(arrayList2, map);
        if (arrayList8.isEmpty()) {
            return;
        }
        this.resolveJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new UserMessageViewHolder$bind$1(arrayList4, this, map, arrayList8, null), 3, (Object) null);
    }

    private final void setupGradientMask() {
        final int color = ContextCompat.getColor(this.itemView.getContext(), C0591R.color.trae_chat_user_bubble_gradient);
        final int argb = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$setupGradientMask$1
            @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
            public Shader resize(int width, int height) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, height, argb, color, Shader.TileMode.CLAMP);
            }
        });
        this.gradientMask.setBackground(paintDrawable);
    }

    private final void applyCollapseState() {
        if (this.isExpanded) {
            applyExpandedState();
            return;
        }
        View view = this.messageContainer;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        view.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.textContainer;
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        layoutParams2.height = -2;
        frameLayout.setLayoutParams(layoutParams2);
        this.tvContent.setMaxLines(this.maxCount);
        this.gradientMask.setVisibility(8);
        this.tvShowMore.setVisibility(8);
        this.tvContent.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UserMessageViewHolder.applyCollapseState$lambda$35(UserMessageViewHolder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyCollapseState$lambda$35(UserMessageViewHolder userMessageViewHolder) {
        Layout layout;
        if (userMessageViewHolder.isExpanded || (layout = userMessageViewHolder.tvContent.getLayout()) == null || layout.getLineCount() <= userMessageViewHolder.maxCount) {
            return;
        }
        userMessageViewHolder.gradientMask.setVisibility(0);
        userMessageViewHolder.tvShowMore.setVisibility(0);
    }

    private final void applyExpandedState() {
        View view = this.messageContainer;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.textContainer;
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        layoutParams2.height = -2;
        frameLayout.setLayoutParams(layoutParams2);
        this.tvContent.setMaxLines(Integer.MAX_VALUE);
        this.gradientMask.setVisibility(8);
        this.tvShowMore.setVisibility(8);
    }

    /* renamed from: dp */
    private final int m830dp(int value) {
        return (int) (value * this.itemView.getResources().getDisplayMetrics().density);
    }

    /* compiled from: UserMessageViewHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$Companion;", "", "<init>", "()V", "create", "Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;", "parent", "Landroid/view/ViewGroup;", "messageLister", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserMessageViewHolder create(ViewGroup parent, IMessageListener messageLister) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_user_message, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new UserMessageViewHolder(inflate, messageLister);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserMessageViewHolder.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003456B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u001a\u0010&\u001a\u00020#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0006H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020*H\u0016J\u0018\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016J\b\u00102\u001a\u00020*H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00101\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "items", "", "Lcom/bytedance/trae/im/model/MessagePart;", "resolvedUrls", "", "", "conversationId", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "chatSessionId", "getChatSessionId", "setChatSessionId", "cliType", "getCliType", "setCliType", "mode", "getMode", "setMode", "messageId", "getMessageId", "setMessageId", "messageListener", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "getMessageListener", "()Lcom/bytedance/trae/conversation/chat/IMessageListener;", "setMessageListener", "(Lcom/bytedance/trae/conversation/chat/IMessageListener;)V", "submitList", "", "newItems", "urls", "updateResolvedUrls", "allPreviewImages", "Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;", "getItemViewType", "", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "onViewRecycled", "Companion", "ImageViewHolder", "FileViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AttachmentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int VIEW_TYPE_FILE = 1;
        private static final int VIEW_TYPE_IMAGE = 0;
        private IMessageListener messageListener;
        private List<MessagePart> items = CollectionsKt.emptyList();
        private Map<String, String> resolvedUrls = MapsKt.emptyMap();
        private String conversationId = "";
        private String chatSessionId = "";
        private String cliType = "";
        private String mode = "";
        private String messageId = "";

        public final String getConversationId() {
            return this.conversationId;
        }

        public final void setConversationId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.conversationId = str;
        }

        public final String getChatSessionId() {
            return this.chatSessionId;
        }

        public final void setChatSessionId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.chatSessionId = str;
        }

        public final String getCliType() {
            return this.cliType;
        }

        public final void setCliType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cliType = str;
        }

        public final String getMode() {
            return this.mode;
        }

        public final void setMode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mode = str;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final void setMessageId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.messageId = str;
        }

        public final IMessageListener getMessageListener() {
            return this.messageListener;
        }

        public final void setMessageListener(IMessageListener iMessageListener) {
            this.messageListener = iMessageListener;
        }

        public final void submitList(List<MessagePart> newItems, Map<String, String> urls) {
            Intrinsics.checkNotNullParameter(newItems, "newItems");
            Intrinsics.checkNotNullParameter(urls, "urls");
            this.items = newItems;
            this.resolvedUrls = urls;
            notifyDataSetChanged();
        }

        public final void updateResolvedUrls(Map<String, String> urls) {
            Intrinsics.checkNotNullParameter(urls, "urls");
            this.resolvedUrls = urls;
            notifyDataSetChanged();
        }

        private final List<UserPreviewImageItem> allPreviewImages() {
            ArrayList arrayList;
            List<ParsedChatMessage> allMessages;
            ArrayList arrayList2;
            IMessageListener iMessageListener = this.messageListener;
            if (iMessageListener == null || (allMessages = iMessageListener.getAllMessages()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (ParsedChatMessage parsedChatMessage : allMessages) {
                    if (!parsedChatMessage.isUserMessage()) {
                        arrayList2 = CollectionsKt.emptyList();
                    } else {
                        List<MessagePart> query = parsedChatMessage.getQuery();
                        if (query == null) {
                            query = CollectionsKt.emptyList();
                        }
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<T> it = query.iterator();
                        while (it.hasNext()) {
                            UserPreviewImageItem previewImageItemFromData = UserMessageViewHolderKt.previewImageItemFromData((MessagePart) it.next());
                            if (previewImageItemFromData != null) {
                                arrayList4.add(previewImageItemFromData);
                            }
                        }
                        arrayList2 = arrayList4;
                    }
                    CollectionsKt.addAll(arrayList3, arrayList2);
                }
                arrayList = arrayList3;
            }
            if (arrayList == null) {
                arrayList = CollectionsKt.emptyList();
            }
            ArrayList arrayList5 = arrayList;
            if (arrayList5.isEmpty()) {
                List<MessagePart> list = this.items;
                ArrayList arrayList6 = new ArrayList();
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    UserPreviewImageItem previewImageItemFromData2 = UserMessageViewHolderKt.previewImageItemFromData((MessagePart) it2.next());
                    if (previewImageItemFromData2 != null) {
                        arrayList6.add(previewImageItemFromData2);
                    }
                }
                arrayList5 = arrayList6;
            }
            return arrayList5;
        }

        public int getItemViewType(int position) {
            boolean isImageAttachmentPart;
            isImageAttachmentPart = UserMessageViewHolderKt.isImageAttachmentPart(this.items.get(position));
            return !isImageAttachmentPart ? 1 : 0;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LayoutInflater from = LayoutInflater.from(parent.getContext());
            if (viewType == 0) {
                View inflate = from.inflate(C0637R.layout.trae_item_chat_image, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                return new ImageViewHolder(inflate);
            }
            View inflate2 = from.inflate(C0637R.layout.trae_item_chat_attachment, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new FileViewHolder(inflate2);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            MessagePart messagePart = this.items.get(position);
            if (holder instanceof ImageViewHolder) {
                ((ImageViewHolder) holder).bind(messagePart, this.resolvedUrls, allPreviewImages(), this.conversationId, this.chatSessionId, this.cliType, this.mode, this.messageId);
            } else if (holder instanceof FileViewHolder) {
                ((FileViewHolder) holder).bind(messagePart, this.conversationId, this.cliType, this.mode, this.messageId, this.messageListener);
            }
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof ImageViewHolder) {
                ((ImageViewHolder) holder).cancelLoad();
            }
            super.onViewRecycled(holder);
        }

        /* compiled from: UserMessageViewHolder.kt */
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JX\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\rH\u0002J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0002JB\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0006\u0010!\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "fileDownloadHelper", "Lcom/bytedance/trae/conversation/products/FileDownloadHelper;", "loadJob", "Lkotlinx/coroutines/Job;", "bind", "", "part", "Lcom/bytedance/trae/im/model/MessagePart;", "resolvedUrls", "", "", "allImages", "", "Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;", "conversationId", "chatSessionId", "cliType", "mode", "messageId", "applyImageHierarchy", "bindRemoteResourceImage", "resourceId", "resolvedUrl", "bindLocalArtifactImage", "artifactPath", "cancelLoad", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class ImageViewHolder extends RecyclerView.ViewHolder {
            private final FileDownloadHelper fileDownloadHelper;
            private final SimpleDraweeView ivImage;
            private Job loadJob;

            /* compiled from: UserMessageViewHolder.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[UserPreviewImageKind.values().length];
                    try {
                        iArr[UserPreviewImageKind.IMAGE_ID.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UserPreviewImageKind.REMOTE_RESOURCE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[UserPreviewImageKind.LOCAL_ARTIFACT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                SimpleDraweeView findViewById = view.findViewById(C0637R.id.iv_attachment);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.ivImage = findViewById;
                this.fileDownloadHelper = new FileDownloadHelper();
            }

            public final void bind(MessagePart part, Map<String, String> resolvedUrls, final List<UserPreviewImageItem> allImages, final String conversationId, final String chatSessionId, String cliType, String mode, final String messageId) {
                String sourceId;
                Intrinsics.checkNotNullParameter(part, "part");
                Intrinsics.checkNotNullParameter(resolvedUrls, "resolvedUrls");
                Intrinsics.checkNotNullParameter(allImages, "allImages");
                Intrinsics.checkNotNullParameter(conversationId, "conversationId");
                Intrinsics.checkNotNullParameter(chatSessionId, "chatSessionId");
                Intrinsics.checkNotNullParameter(cliType, "cliType");
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(messageId, "messageId");
                cancelLoad();
                final UserPreviewImageItem previewImageItemFromData = UserMessageViewHolderKt.previewImageItemFromData(part);
                String str = (previewImageItemFromData == null || (sourceId = previewImageItemFromData.getSourceId()) == null) ? null : resolvedUrls.get(sourceId);
                applyImageHierarchy();
                if ((previewImageItemFromData != null ? previewImageItemFromData.getKind() : null) == UserPreviewImageKind.REMOTE_RESOURCE) {
                    bindRemoteResourceImage(previewImageItemFromData.getSourceId(), str);
                } else {
                    if ((previewImageItemFromData != null ? previewImageItemFromData.getKind() : null) == UserPreviewImageKind.LOCAL_ARTIFACT) {
                        bindLocalArtifactImage(previewImageItemFromData.getSourceId(), str, conversationId, chatSessionId, cliType, mode, messageId);
                    } else {
                        String str2 = str;
                        if (!(str2 == null || str2.length() == 0)) {
                            this.ivImage.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(str)).setAutoPlayAnimations(true).setOldController(this.ivImage.getController()).build());
                        } else {
                            this.ivImage.setImageURI((Uri) null);
                        }
                    }
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UserMessageViewHolder.AttachmentListAdapter.ImageViewHolder.bind$lambda$13(UserPreviewImageItem.this, allImages, this, chatSessionId, conversationId, messageId, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void bind$lambda$13(UserPreviewImageItem userPreviewImageItem, List list, ImageViewHolder imageViewHolder, String str, String str2, String str3, View view) {
                UserPreviewImageKind kind = userPreviewImageItem != null ? userPreviewImageItem.getKind() : null;
                int i = kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
                if (i != -1) {
                    if (i == 1) {
                        List list2 = list;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list2) {
                            if (((UserPreviewImageItem) obj).getKind() == UserPreviewImageKind.IMAGE_ID) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(((UserPreviewImageItem) it.next()).getSourceId());
                        }
                        ArrayList arrayList4 = arrayList3;
                        int coerceAtLeast = RangesKt.coerceAtLeast(arrayList4.indexOf(userPreviewImageItem.getSourceId()), 0);
                        ArrayList arrayList5 = arrayList4;
                        if (!arrayList5.isEmpty()) {
                            ArrayList arrayList6 = new ArrayList();
                            for (Object obj2 : list2) {
                                if (((UserPreviewImageItem) obj2).getKind() == UserPreviewImageKind.IMAGE_ID) {
                                    arrayList6.add(obj2);
                                }
                            }
                            ArrayList arrayList7 = arrayList6;
                            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                            Iterator it2 = arrayList7.iterator();
                            while (it2.hasNext()) {
                                String displayName = ((UserPreviewImageItem) it2.next()).getDisplayName();
                                if (displayName == null) {
                                    displayName = "";
                                }
                                arrayList8.add(displayName);
                            }
                            MultiImagePreviewActivity.Companion companion = MultiImagePreviewActivity.INSTANCE;
                            Context context = imageViewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            companion.startWithImageIds(context, new ArrayList<>(arrayList5), coerceAtLeast, new ArrayList<>(arrayList8));
                            return;
                        }
                        return;
                    }
                    if (i == 2) {
                        List list3 = list;
                        ArrayList arrayList9 = new ArrayList();
                        for (Object obj3 : list3) {
                            if (((UserPreviewImageItem) obj3).getKind() == UserPreviewImageKind.REMOTE_RESOURCE) {
                                arrayList9.add(obj3);
                            }
                        }
                        ArrayList arrayList10 = arrayList9;
                        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
                        Iterator it3 = arrayList10.iterator();
                        while (it3.hasNext()) {
                            arrayList11.add(((UserPreviewImageItem) it3.next()).getSourceId());
                        }
                        ArrayList arrayList12 = arrayList11;
                        int coerceAtLeast2 = RangesKt.coerceAtLeast(arrayList12.indexOf(userPreviewImageItem.getSourceId()), 0);
                        ArrayList arrayList13 = arrayList12;
                        if (!arrayList13.isEmpty()) {
                            ArrayList arrayList14 = new ArrayList();
                            for (Object obj4 : list3) {
                                if (((UserPreviewImageItem) obj4).getKind() == UserPreviewImageKind.REMOTE_RESOURCE) {
                                    arrayList14.add(obj4);
                                }
                            }
                            ArrayList arrayList15 = arrayList14;
                            ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList15, 10));
                            Iterator it4 = arrayList15.iterator();
                            while (it4.hasNext()) {
                                String displayName2 = ((UserPreviewImageItem) it4.next()).getDisplayName();
                                if (displayName2 == null) {
                                    displayName2 = "";
                                }
                                arrayList16.add(displayName2);
                            }
                            MultiImagePreviewActivity.Companion companion2 = MultiImagePreviewActivity.INSTANCE;
                            Context context2 = imageViewHolder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                            companion2.startWithRemoteResources(context2, new ArrayList<>(arrayList13), coerceAtLeast2, new ArrayList<>(arrayList16));
                            return;
                        }
                        return;
                    }
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List list4 = list;
                    ArrayList arrayList17 = new ArrayList();
                    for (Object obj5 : list4) {
                        if (((UserPreviewImageItem) obj5).getKind() == UserPreviewImageKind.LOCAL_ARTIFACT) {
                            arrayList17.add(obj5);
                        }
                    }
                    ArrayList arrayList18 = arrayList17;
                    ArrayList arrayList19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList18, 10));
                    Iterator it5 = arrayList18.iterator();
                    while (it5.hasNext()) {
                        arrayList19.add(((UserPreviewImageItem) it5.next()).getSourceId());
                    }
                    ArrayList arrayList20 = arrayList19;
                    int coerceAtLeast3 = RangesKt.coerceAtLeast(arrayList20.indexOf(userPreviewImageItem.getSourceId()), 0);
                    ArrayList arrayList21 = arrayList20;
                    if (!arrayList21.isEmpty()) {
                        ArrayList arrayList22 = new ArrayList();
                        for (Object obj6 : list4) {
                            if (((UserPreviewImageItem) obj6).getKind() == UserPreviewImageKind.LOCAL_ARTIFACT) {
                                arrayList22.add(obj6);
                            }
                        }
                        ArrayList arrayList23 = arrayList22;
                        ArrayList arrayList24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList23, 10));
                        Iterator it6 = arrayList23.iterator();
                        while (it6.hasNext()) {
                            String displayName3 = ((UserPreviewImageItem) it6.next()).getDisplayName();
                            if (displayName3 == null) {
                                displayName3 = "";
                            }
                            arrayList24.add(displayName3);
                        }
                        MultiImagePreviewActivity.Companion companion3 = MultiImagePreviewActivity.INSTANCE;
                        Context context3 = imageViewHolder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        companion3.startWithLocalArtifacts(context3, new ArrayList<>(arrayList21), coerceAtLeast3, new ArrayList<>(arrayList24), str, str2, str3);
                    }
                }
            }

            private final void applyImageHierarchy() {
                RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(TypedValue.applyDimension(1, 14.0f, this.ivImage.getResources().getDisplayMetrics()));
                fromCornersRadius.setRoundingMethod(RoundingParams.RoundingMethod.OVERLAY_COLOR);
                fromCornersRadius.setOverlayColor(Color.parseColor("#FFF5F5F5"));
                GenericDraweeHierarchy hierarchy = this.ivImage.getHierarchy();
                hierarchy.setPlaceholderImage(C0591R.drawable.trae_bg_image_loading, ScalingUtils.ScaleType.CENTER_CROP);
                hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                hierarchy.setRoundingParams(fromCornersRadius);
            }

            private final void bindRemoteResourceImage(String resourceId, String resolvedUrl) {
                this.itemView.setTag(resourceId);
                this.ivImage.setController((DraweeController) null);
                if (resolvedUrl == null) {
                    return;
                }
                if (StringsKt.startsWith$default(resolvedUrl, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(resolvedUrl, "file://", false, 2, (Object) null)) {
                    this.ivImage.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(resolvedUrl)).setAutoPlayAnimations(true).setOldController(this.ivImage.getController()).build());
                } else {
                    this.loadJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C0711xf3ba48b2(this, resourceId, resolvedUrl, resourceId, null), 3, (Object) null);
                }
            }

            private final void bindLocalArtifactImage(String artifactPath, String resolvedUrl, String conversationId, String chatSessionId, String cliType, String mode, String messageId) {
                String requestTarget = LocalArtifactPath.INSTANCE.requestTarget(artifactPath);
                String str = chatSessionId;
                if (StringsKt.isBlank(str)) {
                    str = conversationId;
                }
                String str2 = str;
                this.itemView.setTag(artifactPath);
                this.ivImage.setController((DraweeController) null);
                FileDownloadHelper fileDownloadHelper = this.fileDownloadHelper;
                Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                File cachedFile = fileDownloadHelper.getCachedFile(applicationContext, str2, requestTarget);
                if (cachedFile != null) {
                    this.ivImage.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.fromFile(cachedFile)).setAutoPlayAnimations(true).setOldController(this.ivImage.getController()).build());
                } else {
                    if (resolvedUrl == null) {
                        return;
                    }
                    this.loadJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new C0709xd23a1bad(this, artifactPath, resolvedUrl, str2, requestTarget, null), 3, (Object) null);
                }
            }

            public final void cancelLoad() {
                Job job = this.loadJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.loadJob = null;
            }
        }

        /* compiled from: UserMessageViewHolder.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "tvFilename", "Landroid/widget/TextView;", "tvFileExt", "ivFileIcon", "Landroid/widget/ImageView;", "bind", "", "part", "Lcom/bytedance/trae/im/model/MessagePart;", "conversationId", "", "cliType", "mode", "messageId", "messageListener", "Lcom/bytedance/trae/conversation/chat/IMessageListener;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class FileViewHolder extends RecyclerView.ViewHolder {
            private final ImageView ivFileIcon;
            private final TextView tvFileExt;
            private final TextView tvFilename;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                View findViewById = view.findViewById(C0637R.id.tv_filename);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.tvFilename = (TextView) findViewById;
                View findViewById2 = view.findViewById(C0637R.id.tv_file_ext);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.tvFileExt = (TextView) findViewById2;
                View findViewById3 = view.findViewById(C0637R.id.iv_file_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.ivFileIcon = (ImageView) findViewById3;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
            
                if (r0 != null) goto L14;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void bind(final MessagePart part, final String conversationId, final String cliType, final String mode, final String messageId, final IMessageListener messageListener) {
                String str;
                JsonElement jsonElement;
                Intrinsics.checkNotNullParameter(part, "part");
                Intrinsics.checkNotNullParameter(conversationId, "conversationId");
                Intrinsics.checkNotNullParameter(cliType, "cliType");
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(messageId, "messageId");
                JsonObject data = part.getData();
                if (data != null && (jsonElement = data.get("filename")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str = jsonElement.getAsString();
                    }
                }
                str = "File";
                final String str2 = str;
                final String previewOidIdFromData = UserMessageViewHolderKt.previewOidIdFromData(part);
                this.tvFilename.setText(str2);
                String upperCase = StringsKt.substringAfterLast(str2, '.', "").toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                TextView textView = this.tvFileExt;
                String str3 = upperCase;
                if (str3.length() == 0) {
                    str3 = "FILE";
                }
                textView.setText(str3);
                this.ivFileIcon.setImageResource(C0637R.drawable.ic_conversation_pdf);
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$AttachmentListAdapter$FileViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UserMessageViewHolder.AttachmentListAdapter.FileViewHolder.bind$lambda$2(MessagePart.this, messageListener, previewOidIdFromData, str2, conversationId, messageId, this, cliType, mode, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void bind$lambda$2(MessagePart messagePart, IMessageListener iMessageListener, String str, String str2, String str3, String str4, FileViewHolder fileViewHolder, String str5, String str6, View view) {
                Conversation currentConversation;
                String previewChatSessionIdFromData = UserMessageViewHolderKt.previewChatSessionIdFromData(messagePart);
                if (previewChatSessionIdFromData == null) {
                    previewChatSessionIdFromData = (iMessageListener == null || (currentConversation = iMessageListener.getCurrentConversation()) == null) ? null : currentConversation.getCliConversationId();
                    if (previewChatSessionIdFromData == null) {
                        previewChatSessionIdFromData = "";
                    }
                }
                String str7 = previewChatSessionIdFromData;
                if (StringsKt.isBlank(str7)) {
                    FLogger.INSTANCE.w("UserMessageAttachment", "open attachment without chatSessionId: uri=" + str + ", fileName=" + str2 + ", conversationId=" + str3 + ", messageId=" + str4);
                }
                InputPreviewActivity.Companion companion = InputPreviewActivity.INSTANCE;
                Context context = fileViewHolder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.start(context, str, str2, str3, str7, str5, str6, str4);
            }
        }
    }

    private final boolean startsWithAgentReviewMarker(ParsedChatMessage message) {
        List<MessagePart> query = message != null ? message.getQuery() : null;
        List<MessagePart> list = query;
        return !(list == null || list.isEmpty()) && Intrinsics.areEqual(query.get(0).getType(), MessagePart.TYPE_CREATE_MR);
    }

    private final String getAgentReviewMarkerTagText(MessagePart part) {
        JsonElement jsonElement;
        JsonObject data = part.getData();
        String str = null;
        if (data != null && (jsonElement = data.get("scene")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        Context context = this.itemView.getContext();
        if (Intrinsics.areEqual(str, "check_pr_review") || Intrinsics.areEqual(str, "check_pr_resolve")) {
            String string = context.getString(C0637R.string.trae_agent_review_check_pr);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String string2 = context.getString(C0637R.string.trae_agent_review_create_pr);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        if (r0.equals("check_pr_resolve") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        r4 = r4.getString(com.bytedance.trae.conversation.C0637R.string.trae_agent_review_desc_resolve);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r0.equals("create_pr_review") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r4 = r4.getString(com.bytedance.trae.conversation.C0637R.string.trae_agent_review_desc_review);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r0.equals("check_pr_review") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r0.equals("create_pr_resolve") == false) goto L31;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x002c. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getAgentReviewMarkerDescription(MessagePart part) {
        JsonElement jsonElement;
        JsonObject data = part.getData();
        String str = null;
        if (data != null && (jsonElement = data.get("scene")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        Context context = this.itemView.getContext();
        if (str != null) {
            switch (str.hashCode()) {
                case -1087990830:
                    break;
                case 36025790:
                    break;
                case 657723570:
                    break;
                case 1114214470:
                    break;
            }
        }
        return "";
    }
}
