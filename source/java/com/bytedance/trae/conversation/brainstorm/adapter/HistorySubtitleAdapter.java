package com.bytedance.trae.conversation.brainstorm.adapter;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.VoiceAttachmentIconResolver;
import com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.MessageRole;
import com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView;
import com.bytedance.trae.conversation.brainstorm.widget.StepInterpolator;
import com.bytedance.trae.conversation.brainstorm.widget.ThinkingDotsView;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: HistorySubtitleAdapter.kt */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\b\f*\u0001I\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\tKLMNOPQRSB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001fJ\u001a\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001fH\u0002J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001fJ\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/J\u0014\u00100\u001a\u00020\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f02J\f\u00103\u001a\b\u0012\u0004\u0012\u00020&04J\"\u00105\u001a\u00020\u001c2\f\u00106\u001a\b\u0012\u0004\u0012\u000207042\f\u00108\u001a\b\u0012\u0004\u0012\u00020&04J\u0010\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#J\b\u0010=\u001a\u00020\u0014H\u0016J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0014H\u0016J\u0018\u0010@\u001a\u00020\u00022\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0014H\u0016J\u0018\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0014H\u0016J&\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00142\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010J¨\u0006T"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "attachmentCallback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "getAttachmentCallback", "()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "setAttachmentCallback", "(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "historyItems", "", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "liveBotItem", "liveUserItem", "thinkingItem", "footerItem", "items", "totalItemCount", "", "getTotalItemCount", "()I", "liveBotPos", "liveUserPos", "thinkingPos", "footerPos", "rebuildItems", "", "setLiveBot", ReportConstant.COMMON_CONTENT, "", "archivedMessageId", "archivedAttachedSubTaskId", "setLiveUser", "", "appendOrUpdateAttachment", "item", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "groupItemId", "groupId", "appendOrUpdateGroupedAttachment", "removeAttachment", "attachmentId", "updateSubTaskBadgeOnMessage", "anchorMessageId", "badge", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "pruneAttachmentsExcept", "attachmentIdsToKeep", "", "currentImageAttachments", "", "seedHistoryWithAttachments", "messages", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "attachments", "setFooter", "text", "setThinkingVisible", "visible", "getItemCount", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "attachmentDelegate", "com/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$attachmentDelegate$1;", "SubtitleItem", "AttachmentCallback", "Companion", "MessageViewHolder", "AttachmentViewHolder", "FileGroupViewHolder", "GroupAttachmentViewHolder", "FooterViewHolder", "ThinkingViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HistorySubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String PAYLOAD_ATTACHMENT_GROUP_UPDATE = "attachment_group_update";
    private static final String PAYLOAD_ATTACHMENT_UPDATE = "attachment_update";
    private static final String PAYLOAD_SUBTASK_UPDATE = "subtask_update";
    private static final String PAYLOAD_TEXT_UPDATE = "text_update";
    private static final String TAG = "HistorySubtitleAdapter";
    private static final int VIEW_TYPE_ATTACHMENT = 2;
    private static final int VIEW_TYPE_ATTACHMENT_GROUP = 4;
    private static final int VIEW_TYPE_FILE_GROUP = 5;
    private static final int VIEW_TYPE_FOOTER = 1;
    private static final int VIEW_TYPE_MESSAGE = 0;
    private static final int VIEW_TYPE_THINKING = 3;
    private AttachmentCallback attachmentCallback;
    private SubtitleItem footerItem;
    private SubtitleItem liveBotItem;
    private SubtitleItem liveUserItem;
    private SubtitleItem thinkingItem;
    private final List<SubtitleItem> historyItems = new ArrayList();
    private final List<SubtitleItem> items = new ArrayList();
    private final HistorySubtitleAdapter$attachmentDelegate$1 attachmentDelegate = new AttachmentCallback() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$attachmentDelegate$1
        @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
        public void onClose(String attachmentId, AttachmentState state) {
            Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
            Intrinsics.checkNotNullParameter(state, "state");
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback = HistorySubtitleAdapter.this.getAttachmentCallback();
            if (attachmentCallback != null) {
                attachmentCallback.onClose(attachmentId, state);
            }
        }

        @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
        public void onRetry(String attachmentId) {
            Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback = HistorySubtitleAdapter.this.getAttachmentCallback();
            if (attachmentCallback != null) {
                attachmentCallback.onRetry(attachmentId);
            }
        }

        @Override // com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.AttachmentCallback
        public void onPreview(BrainstormAttachment attachment) {
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback = HistorySubtitleAdapter.this.getAttachmentCallback();
            if (attachmentCallback != null) {
                attachmentCallback.onPreview(attachment);
            }
        }
    };

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "", "onClose", "", "attachmentId", "", "state", "Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;", "onRetry", "onPreview", "attachment", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface AttachmentCallback {
        void onClose(String attachmentId, AttachmentState state);

        void onPreview(BrainstormAttachment attachment);

        void onRetry(String attachmentId);
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003J{\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0019R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "", "id", "", "role", "Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;", ReportConstant.COMMON_CONTENT, "isLive", "", "isFooter", "isThinkingPlaceholder", "attachment", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "attachments", "", "attachedSubTaskId", "subTaskBadge", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;Ljava/lang/String;ZZZLcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V", "getId", "()Ljava/lang/String;", "getRole", "()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;", "getContent", "()Z", "getAttachment", "()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "getAttachments", "()Ljava/util/List;", "getAttachedSubTaskId", "getSubTaskBadge", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SubtitleItem {
        private final String attachedSubTaskId;
        private final BrainstormAttachment attachment;
        private final List<BrainstormAttachment> attachments;
        private final String content;
        private final String id;
        private final boolean isFooter;
        private final boolean isLive;
        private final boolean isThinkingPlaceholder;
        private final MessageRole role;
        private final SubTaskUiState subTaskBadge;

        public static /* synthetic */ SubtitleItem copy$default(SubtitleItem subtitleItem, String str, MessageRole messageRole, String str2, boolean z, boolean z2, boolean z3, BrainstormAttachment brainstormAttachment, List list, String str3, SubTaskUiState subTaskUiState, int i, Object obj) {
            return subtitleItem.copy((i & 1) != 0 ? subtitleItem.id : str, (i & 2) != 0 ? subtitleItem.role : messageRole, (i & 4) != 0 ? subtitleItem.content : str2, (i & 8) != 0 ? subtitleItem.isLive : z, (i & 16) != 0 ? subtitleItem.isFooter : z2, (i & 32) != 0 ? subtitleItem.isThinkingPlaceholder : z3, (i & 64) != 0 ? subtitleItem.attachment : brainstormAttachment, (i & 128) != 0 ? subtitleItem.attachments : list, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subtitleItem.attachedSubTaskId : str3, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subtitleItem.subTaskBadge : subTaskUiState);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final SubTaskUiState getSubTaskBadge() {
            return this.subTaskBadge;
        }

        /* renamed from: component2, reason: from getter */
        public final MessageRole getRole() {
            return this.role;
        }

        /* renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsLive() {
            return this.isLive;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsFooter() {
            return this.isFooter;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsThinkingPlaceholder() {
            return this.isThinkingPlaceholder;
        }

        /* renamed from: component7, reason: from getter */
        public final BrainstormAttachment getAttachment() {
            return this.attachment;
        }

        public final List<BrainstormAttachment> component8() {
            return this.attachments;
        }

        /* renamed from: component9, reason: from getter */
        public final String getAttachedSubTaskId() {
            return this.attachedSubTaskId;
        }

        public final SubtitleItem copy(String id, MessageRole role, String content, boolean isLive, boolean isFooter, boolean isThinkingPlaceholder, BrainstormAttachment attachment, List<BrainstormAttachment> attachments, String attachedSubTaskId, SubTaskUiState subTaskBadge) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(role, "role");
            Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
            return new SubtitleItem(id, role, content, isLive, isFooter, isThinkingPlaceholder, attachment, attachments, attachedSubTaskId, subTaskBadge);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleItem)) {
                return false;
            }
            SubtitleItem subtitleItem = (SubtitleItem) other;
            return Intrinsics.areEqual(this.id, subtitleItem.id) && this.role == subtitleItem.role && Intrinsics.areEqual(this.content, subtitleItem.content) && this.isLive == subtitleItem.isLive && this.isFooter == subtitleItem.isFooter && this.isThinkingPlaceholder == subtitleItem.isThinkingPlaceholder && Intrinsics.areEqual(this.attachment, subtitleItem.attachment) && Intrinsics.areEqual(this.attachments, subtitleItem.attachments) && Intrinsics.areEqual(this.attachedSubTaskId, subtitleItem.attachedSubTaskId) && Intrinsics.areEqual(this.subTaskBadge, subtitleItem.subTaskBadge);
        }

        public int hashCode() {
            int hashCode = ((((((((((this.id.hashCode() * 31) + this.role.hashCode()) * 31) + this.content.hashCode()) * 31) + Boolean.hashCode(this.isLive)) * 31) + Boolean.hashCode(this.isFooter)) * 31) + Boolean.hashCode(this.isThinkingPlaceholder)) * 31;
            BrainstormAttachment brainstormAttachment = this.attachment;
            int hashCode2 = (hashCode + (brainstormAttachment == null ? 0 : brainstormAttachment.hashCode())) * 31;
            List<BrainstormAttachment> list = this.attachments;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.attachedSubTaskId;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            SubTaskUiState subTaskUiState = this.subTaskBadge;
            return hashCode4 + (subTaskUiState != null ? subTaskUiState.hashCode() : 0);
        }

        public String toString() {
            return "SubtitleItem(id=" + this.id + ", role=" + this.role + ", content=" + this.content + ", isLive=" + this.isLive + ", isFooter=" + this.isFooter + ", isThinkingPlaceholder=" + this.isThinkingPlaceholder + ", attachment=" + this.attachment + ", attachments=" + this.attachments + ", attachedSubTaskId=" + this.attachedSubTaskId + ", subTaskBadge=" + this.subTaskBadge + ')';
        }

        public SubtitleItem(String str, MessageRole messageRole, String str2, boolean z, boolean z2, boolean z3, BrainstormAttachment brainstormAttachment, List<BrainstormAttachment> list, String str3, SubTaskUiState subTaskUiState) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(messageRole, "role");
            Intrinsics.checkNotNullParameter(str2, ReportConstant.COMMON_CONTENT);
            this.id = str;
            this.role = messageRole;
            this.content = str2;
            this.isLive = z;
            this.isFooter = z2;
            this.isThinkingPlaceholder = z3;
            this.attachment = brainstormAttachment;
            this.attachments = list;
            this.attachedSubTaskId = str3;
            this.subTaskBadge = subTaskUiState;
        }

        public /* synthetic */ SubtitleItem(String str, MessageRole messageRole, String str2, boolean z, boolean z2, boolean z3, BrainstormAttachment brainstormAttachment, List list, String str3, SubTaskUiState subTaskUiState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, messageRole, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? null : brainstormAttachment, (i & 128) != 0 ? null : list, (i & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : str3, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : subTaskUiState);
        }

        public final String getId() {
            return this.id;
        }

        public final MessageRole getRole() {
            return this.role;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean isLive() {
            return this.isLive;
        }

        public final boolean isFooter() {
            return this.isFooter;
        }

        public final boolean isThinkingPlaceholder() {
            return this.isThinkingPlaceholder;
        }

        public final BrainstormAttachment getAttachment() {
            return this.attachment;
        }

        public final List<BrainstormAttachment> getAttachments() {
            return this.attachments;
        }

        public final String getAttachedSubTaskId() {
            return this.attachedSubTaskId;
        }

        public final SubTaskUiState getSubTaskBadge() {
            return this.subTaskBadge;
        }
    }

    public final AttachmentCallback getAttachmentCallback() {
        return this.attachmentCallback;
    }

    public final void setAttachmentCallback(AttachmentCallback attachmentCallback) {
        this.attachmentCallback = attachmentCallback;
    }

    public final int getTotalItemCount() {
        return this.items.size();
    }

    private final int liveBotPos() {
        return this.historyItems.size();
    }

    private final int liveUserPos() {
        return this.historyItems.size() + (this.liveBotItem != null ? 1 : 0);
    }

    private final int thinkingPos() {
        return this.historyItems.size() + (this.liveBotItem != null ? 1 : 0) + (this.liveUserItem == null ? 0 : 1);
    }

    private final int footerPos() {
        return thinkingPos() + (this.thinkingItem != null ? 1 : 0);
    }

    private final void rebuildItems() {
        this.items.clear();
        this.items.addAll(this.historyItems);
        SubtitleItem subtitleItem = this.liveBotItem;
        if (subtitleItem != null) {
            this.items.add(subtitleItem);
        }
        SubtitleItem subtitleItem2 = this.liveUserItem;
        if (subtitleItem2 != null) {
            this.items.add(subtitleItem2);
        }
        SubtitleItem subtitleItem3 = this.thinkingItem;
        if (subtitleItem3 != null) {
            this.items.add(subtitleItem3);
        }
        SubtitleItem subtitleItem4 = this.footerItem;
        if (subtitleItem4 != null) {
            this.items.add(subtitleItem4);
        }
    }

    public static /* synthetic */ void setLiveBot$default(HistorySubtitleAdapter historySubtitleAdapter, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        historySubtitleAdapter.setLiveBot(str, str2, str3);
    }

    public final void setLiveBot(String content, String archivedMessageId, String archivedAttachedSubTaskId) {
        String str = archivedMessageId;
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        SubtitleItem subtitleItem = this.liveBotItem;
        int liveBotPos = liveBotPos();
        if (!StringsKt.isBlank(content)) {
            SubtitleItem subtitleItem2 = new SubtitleItem("live_bot", MessageRole.Assistant, content, true, false, false, null, null, null, null, 1008, null);
            if (subtitleItem == null) {
                FLogger.INSTANCE.d(TAG, "setLiveBot[start-live]: len=" + content.length() + ", pos=" + liveBotPos);
                this.liveBotItem = subtitleItem2;
                rebuildItems();
                notifyItemInserted(liveBotPos);
                return;
            }
            if (Intrinsics.areEqual(subtitleItem.getContent(), content)) {
                return;
            }
            this.liveBotItem = subtitleItem2;
            this.items.set(liveBotPos, subtitleItem2);
            notifyItemChanged(liveBotPos, PAYLOAD_TEXT_UPDATE);
            return;
        }
        if (subtitleItem == null) {
            if (str == null && archivedAttachedSubTaskId == null) {
                return;
            }
            FLogger.INSTANCE.w(TAG, "setLiveBot[archive-missing-live]: archivedId=" + str + ", attachedId=" + archivedAttachedSubTaskId + ", historySize=" + this.historyItems.size());
            return;
        }
        if (str == null) {
            str = "history_bot_" + this.historyItems.size();
        }
        String str2 = str;
        FLogger.INSTANCE.d(TAG, "setLiveBot[archive]: archivedId=" + str2 + ", attachedId=" + archivedAttachedSubTaskId + ", oldLen=" + subtitleItem.getContent().length() + ", historySizeBefore=" + this.historyItems.size());
        this.historyItems.add(SubtitleItem.copy$default(subtitleItem, str2, null, null, false, false, false, null, null, archivedAttachedSubTaskId, null, 758, null));
        this.liveBotItem = null;
        rebuildItems();
    }

    public static /* synthetic */ boolean setLiveUser$default(HistorySubtitleAdapter historySubtitleAdapter, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return historySubtitleAdapter.setLiveUser(str, str2);
    }

    public final boolean setLiveUser(String content, String archivedMessageId) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        SubtitleItem subtitleItem = this.liveUserItem;
        int liveUserPos = liveUserPos();
        if (StringsKt.isBlank(content)) {
            if (subtitleItem != null) {
                this.historyItems.add(SubtitleItem.copy$default(subtitleItem, archivedMessageId == null ? "history_user_" + this.historyItems.size() : archivedMessageId, null, null, false, false, false, null, null, null, null, 1014, null));
                this.liveUserItem = null;
                rebuildItems();
            }
            return false;
        }
        SubtitleItem subtitleItem2 = new SubtitleItem("live_user", MessageRole.User, content, true, false, false, null, null, null, null, 1008, null);
        if (subtitleItem == null) {
            this.liveUserItem = subtitleItem2;
            rebuildItems();
            notifyItemInserted(liveUserPos);
            return true;
        }
        if (!Intrinsics.areEqual(subtitleItem.getContent(), content)) {
            this.liveUserItem = subtitleItem2;
            this.items.set(liveUserPos, subtitleItem2);
            notifyItemChanged(liveUserPos, PAYLOAD_TEXT_UPDATE);
        }
        return false;
    }

    public final void appendOrUpdateAttachment(BrainstormAttachment item) {
        Intrinsics.checkNotNullParameter(item, "item");
        String groupId = item.getGroupId();
        if (groupId != null) {
            appendOrUpdateGroupedAttachment(groupId, item);
            return;
        }
        Iterator<SubtitleItem> it = this.historyItems.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            BrainstormAttachment attachment = it.next().getAttachment();
            if (Intrinsics.areEqual(attachment != null ? attachment.getAttachmentId() : null, item.getAttachmentId())) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i;
        if (i2 >= 0) {
            BrainstormAttachment attachment2 = this.historyItems.get(i2).getAttachment();
            SubtitleItem copy$default = SubtitleItem.copy$default(this.historyItems.get(i2), null, null, null, false, false, false, item, null, null, null, 959, null);
            if ((attachment2 == null || item.getCreatedAtMs() <= attachment2.getCreatedAtMs() || i2 == CollectionsKt.getLastIndex(this.historyItems)) ? false : true) {
                this.historyItems.remove(i2);
                this.historyItems.add(copy$default);
                rebuildItems();
                notifyItemMoved(i2, CollectionsKt.getLastIndex(this.historyItems));
                notifyItemChanged(CollectionsKt.getLastIndex(this.historyItems), PAYLOAD_ATTACHMENT_UPDATE);
                return;
            }
            this.historyItems.set(i2, copy$default);
            rebuildItems();
            notifyItemChanged(i2, PAYLOAD_ATTACHMENT_UPDATE);
            return;
        }
        this.historyItems.add(new SubtitleItem("attach_" + item.getAttachmentId(), MessageRole.User, "", false, false, false, item, null, null, null, 952, null));
        rebuildItems();
        notifyItemInserted(this.historyItems.size() - 1);
    }

    private final String groupItemId(String groupId) {
        return "group_" + groupId;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[LOOP:0: B:2:0x000c->B:13:0x0042, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[EDGE_INSN: B:14:0x0048->B:15:0x0048 BREAK  A[LOOP:0: B:2:0x000c->B:13:0x0042], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void appendOrUpdateGroupedAttachment(String groupId, BrainstormAttachment item) {
        int i;
        List plus;
        boolean z;
        Iterator<SubtitleItem> it = this.historyItems.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            SubtitleItem next = it.next();
            if (next.getAttachments() != null) {
                BrainstormAttachment brainstormAttachment = (BrainstormAttachment) CollectionsKt.firstOrNull(next.getAttachments());
                if (Intrinsics.areEqual(brainstormAttachment != null ? brainstormAttachment.getGroupId() : null, groupId)) {
                    z = true;
                    if (!z) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (i3 >= 0) {
            List<BrainstormAttachment> attachments = this.historyItems.get(i3).getAttachments();
            if (attachments == null) {
                attachments = CollectionsKt.emptyList();
            }
            Iterator<BrainstormAttachment> it2 = attachments.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it2.next().getAttachmentId(), item.getAttachmentId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0) {
                plus = CollectionsKt.toMutableList(attachments);
                plus.set(i, item);
            } else {
                plus = CollectionsKt.plus(attachments, item);
            }
            List<SubtitleItem> list = this.historyItems;
            list.set(i3, SubtitleItem.copy$default(list.get(i3), null, null, null, false, false, false, null, plus, null, null, 895, null));
            rebuildItems();
            notifyItemChanged(i3, PAYLOAD_ATTACHMENT_GROUP_UPDATE);
            return;
        }
        this.historyItems.add(new SubtitleItem(groupItemId(groupId), MessageRole.User, "", false, false, false, null, CollectionsKt.listOf(item), null, null, 888, null));
        rebuildItems();
        notifyItemInserted(this.historyItems.size() - 1);
    }

    public final void removeAttachment(String attachmentId) {
        Intrinsics.checkNotNullParameter(attachmentId, "attachmentId");
        Iterator<SubtitleItem> it = this.historyItems.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            BrainstormAttachment attachment = it.next().getAttachment();
            if (Intrinsics.areEqual(attachment != null ? attachment.getAttachmentId() : null, attachmentId)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        this.historyItems.remove(i);
        rebuildItems();
        notifyItemRemoved(i);
    }

    public final void updateSubTaskBadgeOnMessage(String anchorMessageId, SubTaskUiState badge) {
        int i;
        Intrinsics.checkNotNullParameter(anchorMessageId, "anchorMessageId");
        List<SubtitleItem> list = this.historyItems;
        ListIterator<SubtitleItem> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(listIterator.previous().getId(), anchorMessageId)) {
                i = listIterator.nextIndex();
                break;
            }
        }
        int i2 = i;
        if (i2 < 0) {
            FLogger.INSTANCE.w(TAG, "updateSubTaskBadgeOnMessage[anchor-missing]: anchorMessageId=" + anchorMessageId + ", badgeTaskId=" + (badge != null ? badge.getSourceTaskId() : null) + ", badgeState=" + (badge != null ? badge.getState() : null) + ", historySize=" + this.historyItems.size() + ", recentAnchors=" + CollectionsKt.joinToString$default(CollectionsKt.takeLast(this.historyItems, 5), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence updateSubTaskBadgeOnMessage$lambda$10;
                    updateSubTaskBadgeOnMessage$lambda$10 = HistorySubtitleAdapter.updateSubTaskBadgeOnMessage$lambda$10((HistorySubtitleAdapter.SubtitleItem) obj);
                    return updateSubTaskBadgeOnMessage$lambda$10;
                }
            }, 30, (Object) null));
            return;
        }
        SubtitleItem subtitleItem = this.historyItems.get(i2);
        SubTaskUiState subTaskBadge = subtitleItem.getSubTaskBadge();
        if ((subTaskBadge != null ? subTaskBadge.getState() : null) == (badge != null ? badge.getState() : null)) {
            if (Intrinsics.areEqual(subTaskBadge != null ? subTaskBadge.getFailureReason() : null, badge != null ? badge.getFailureReason() : null)) {
                if (Intrinsics.areEqual(subTaskBadge != null ? Boolean.valueOf(subTaskBadge.getLongRunning()) : null, badge != null ? Boolean.valueOf(badge.getLongRunning()) : null)) {
                    return;
                }
            }
        }
        this.historyItems.set(i2, SubtitleItem.copy$default(subtitleItem, null, null, null, false, false, false, null, null, null, badge, 511, null));
        rebuildItems();
        FLogger.INSTANCE.d(TAG, "updateSubTaskBadgeOnMessage[update]: anchorMessageId=" + anchorMessageId + ", idx=" + i2 + ", taskId=" + (badge != null ? badge.getSourceTaskId() : null) + ", from=" + (subTaskBadge != null ? subTaskBadge.getState() : null) + ':' + (subTaskBadge != null ? Boolean.valueOf(subTaskBadge.getLongRunning()) : null) + " to=" + (badge != null ? badge.getState() : null) + ':' + (badge != null ? Boolean.valueOf(badge.getLongRunning()) : null));
        notifyItemChanged(i2, PAYLOAD_SUBTASK_UPDATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence updateSubTaskBadgeOnMessage$lambda$10(SubtitleItem subtitleItem) {
        SubTaskRenderState state;
        Intrinsics.checkNotNullParameter(subtitleItem, "item");
        StringBuilder append = new StringBuilder().append(subtitleItem.getId()).append(':');
        String attachedSubTaskId = subtitleItem.getAttachedSubTaskId();
        Object obj = "-";
        if (attachedSubTaskId == null) {
            attachedSubTaskId = "-";
        }
        StringBuilder append2 = append.append(attachedSubTaskId).append(':');
        SubTaskUiState subTaskBadge = subtitleItem.getSubTaskBadge();
        if (subTaskBadge != null && (state = subTaskBadge.getState()) != null) {
            obj = state;
        }
        return append2.append(obj).toString();
    }

    public final void pruneAttachmentsExcept(Set<String> attachmentIdsToKeep) {
        Intrinsics.checkNotNullParameter(attachmentIdsToKeep, "attachmentIdsToKeep");
        ListIterator<SubtitleItem> listIterator = this.historyItems.listIterator();
        boolean z = false;
        while (listIterator.hasNext()) {
            SubtitleItem next = listIterator.next();
            List<BrainstormAttachment> attachments = next.getAttachments();
            if (attachments == null) {
                if (next.getAttachment() != null && !attachmentIdsToKeep.contains(next.getAttachment().getAttachmentId())) {
                    listIterator.remove();
                    z = true;
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (Object obj : attachments) {
                    if (attachmentIdsToKeep.contains(((BrainstormAttachment) obj).getAttachmentId())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.isEmpty()) {
                    listIterator.remove();
                } else if (arrayList2.size() != attachments.size()) {
                    listIterator.set(SubtitleItem.copy$default(next, null, null, null, false, false, false, null, arrayList2, null, null, 895, null));
                }
                z = true;
            }
        }
        if (z) {
            rebuildItems();
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r3.getLocalUri())) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<BrainstormAttachment> currentImageAttachments() {
        boolean isImageAttachment;
        List<SubtitleItem> list = this.items;
        ArrayList arrayList = new ArrayList();
        for (SubtitleItem subtitleItem : list) {
            List<BrainstormAttachment> attachments = subtitleItem.getAttachments();
            if (attachments == null) {
                BrainstormAttachment attachment = subtitleItem.getAttachment();
                attachments = attachment != null ? CollectionsKt.listOf(attachment) : null;
                if (attachments == null) {
                    attachments = CollectionsKt.emptyList();
                }
            }
            CollectionsKt.addAll(arrayList, attachments);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            isImageAttachment = HistorySubtitleAdapterKt.isImageAttachment((BrainstormAttachment) obj);
            boolean z = isImageAttachment;
            if (z) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void seedHistoryWithAttachments(List<BrainstormMessage> messages, List<BrainstormAttachment> attachments) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        this.historyItems.clear();
        ArrayList arrayList = new ArrayList(messages.size() + attachments.size());
        for (BrainstormMessage brainstormMessage : messages) {
            arrayList.add(new HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged(brainstormMessage.getTimestamp(), 0, new SubtitleItem(brainstormMessage.getId(), brainstormMessage.getRole(), brainstormMessage.getContent(), false, false, false, null, null, brainstormMessage.getAttachedSubTaskId(), null, 736, null)));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (BrainstormAttachment brainstormAttachment : attachments) {
            String groupId = brainstormAttachment.getGroupId();
            if (groupId == null) {
                arrayList.add(new HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged(seedHistoryWithAttachments$tsOf(brainstormAttachment), 1, new SubtitleItem("attach_" + brainstormAttachment.getAttachmentId(), MessageRole.User, "", false, false, false, brainstormAttachment, null, null, null, 952, null)));
            } else {
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                Object obj = linkedHashMap2.get(groupId);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    linkedHashMap2.put(groupId, obj);
                }
                ((List) obj).add(brainstormAttachment);
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            long seedHistoryWithAttachments$tsOf = seedHistoryWithAttachments$tsOf((BrainstormAttachment) it.next());
            while (it.hasNext()) {
                long seedHistoryWithAttachments$tsOf2 = seedHistoryWithAttachments$tsOf((BrainstormAttachment) it.next());
                if (seedHistoryWithAttachments$tsOf > seedHistoryWithAttachments$tsOf2) {
                    seedHistoryWithAttachments$tsOf = seedHistoryWithAttachments$tsOf2;
                }
            }
            arrayList.add(new HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged(seedHistoryWithAttachments$tsOf, 1, new SubtitleItem(groupItemId(str), MessageRole.User, "", false, false, false, null, CollectionsKt.toList(list), null, null, 888, null)));
        }
        CollectionsKt.sortWith(arrayList, ComparisonsKt.compareBy(new Function1[]{new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                Comparable seedHistoryWithAttachments$lambda$16;
                seedHistoryWithAttachments$lambda$16 = HistorySubtitleAdapter.seedHistoryWithAttachments$lambda$16((HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged) obj2);
                return seedHistoryWithAttachments$lambda$16;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$$ExternalSyntheticLambda2
            public final Object invoke(Object obj2) {
                Comparable seedHistoryWithAttachments$lambda$17;
                seedHistoryWithAttachments$lambda$17 = HistorySubtitleAdapter.seedHistoryWithAttachments$lambda$17((HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged) obj2);
                return seedHistoryWithAttachments$lambda$17;
            }
        }}));
        List<SubtitleItem> list2 = this.historyItems;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            list2.add(((HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged) it2.next()).getItem());
        }
        rebuildItems();
        notifyDataSetChanged();
    }

    private static final long seedHistoryWithAttachments$tsOf(BrainstormAttachment brainstormAttachment) {
        if (brainstormAttachment.getCreatedAtMs() > 0) {
            return brainstormAttachment.getCreatedAtMs();
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable seedHistoryWithAttachments$lambda$16(HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged historySubtitleAdapter$seedHistoryWithAttachments$Tagged) {
        Intrinsics.checkNotNullParameter(historySubtitleAdapter$seedHistoryWithAttachments$Tagged, "it");
        return Long.valueOf(historySubtitleAdapter$seedHistoryWithAttachments$Tagged.getTs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable seedHistoryWithAttachments$lambda$17(HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged historySubtitleAdapter$seedHistoryWithAttachments$Tagged) {
        Intrinsics.checkNotNullParameter(historySubtitleAdapter$seedHistoryWithAttachments$Tagged, "it");
        return Integer.valueOf(historySubtitleAdapter$seedHistoryWithAttachments$Tagged.getKindRank());
    }

    public final void setFooter(String text) {
        SubtitleItem subtitleItem = this.footerItem;
        int footerPos = footerPos();
        if (subtitleItem != null) {
            this.footerItem = null;
            rebuildItems();
            notifyItemRemoved(footerPos);
        }
    }

    public final boolean setThinkingVisible(boolean visible) {
        SubtitleItem subtitleItem = this.thinkingItem;
        int thinkingPos = thinkingPos();
        if (visible && subtitleItem == null) {
            this.thinkingItem = new SubtitleItem("thinking_dots", MessageRole.Assistant, "", false, false, true, null, null, null, null, 984, null);
            rebuildItems();
            notifyItemInserted(thinkingPos);
            return true;
        }
        if (!visible && subtitleItem != null) {
            this.thinkingItem = null;
            rebuildItems();
            notifyItemRemoved(thinkingPos);
        }
        return false;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int position) {
        SubtitleItem subtitleItem = this.items.get(position);
        if (subtitleItem.getAttachments() != null) {
            BrainstormAttachment brainstormAttachment = (BrainstormAttachment) CollectionsKt.firstOrNull(subtitleItem.getAttachments());
            return brainstormAttachment != null && brainstormAttachment.isImage() ? 4 : 5;
        }
        if (subtitleItem.getAttachment() != null) {
            return 2;
        }
        if (subtitleItem.isThinkingPlaceholder()) {
            return 3;
        }
        return subtitleItem.isFooter() ? 1 : 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View inflate = from.inflate(C0637R.layout.trae_item_brainstorm_subtitle_footer, parent, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            return new FooterViewHolder((LinearLayout) inflate);
        }
        if (viewType == 2) {
            View inflate2 = from.inflate(C0637R.layout.trae_item_brainstorm_attachment, parent, false);
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.widget.FrameLayout");
            return new AttachmentViewHolder((FrameLayout) inflate2, this.attachmentDelegate);
        }
        if (viewType == 3) {
            View inflate3 = from.inflate(C0637R.layout.trae_item_brainstorm_thinking_dots, parent, false);
            Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type android.widget.LinearLayout");
            return new ThinkingViewHolder((LinearLayout) inflate3);
        }
        if (viewType == 4) {
            View inflate4 = from.inflate(C0637R.layout.trae_item_brainstorm_attachment_group, parent, false);
            Intrinsics.checkNotNull(inflate4, "null cannot be cast to non-null type android.widget.FrameLayout");
            return new GroupAttachmentViewHolder((FrameLayout) inflate4, this.attachmentDelegate);
        }
        if (viewType == 5) {
            View inflate5 = from.inflate(C0637R.layout.trae_item_brainstorm_attachment_group, parent, false);
            Intrinsics.checkNotNull(inflate5, "null cannot be cast to non-null type android.widget.FrameLayout");
            return new FileGroupViewHolder((FrameLayout) inflate5, this.attachmentDelegate);
        }
        View inflate6 = from.inflate(C0637R.layout.trae_item_brainstorm_subtitle, parent, false);
        Intrinsics.checkNotNull(inflate6, "null cannot be cast to non-null type android.widget.LinearLayout");
        return new MessageViewHolder((LinearLayout) inflate6);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SubtitleItem subtitleItem = this.items.get(position);
        if (holder instanceof MessageViewHolder) {
            ((MessageViewHolder) holder).bind(subtitleItem);
            return;
        }
        if (holder instanceof FooterViewHolder) {
            ((FooterViewHolder) holder).bind(subtitleItem);
            return;
        }
        if (holder instanceof AttachmentViewHolder) {
            BrainstormAttachment attachment = subtitleItem.getAttachment();
            if (attachment != null) {
                ((AttachmentViewHolder) holder).bind(attachment);
                return;
            }
            return;
        }
        if (holder instanceof GroupAttachmentViewHolder) {
            List<BrainstormAttachment> attachments = subtitleItem.getAttachments();
            if (attachments != null) {
                ((GroupAttachmentViewHolder) holder).bind(attachments);
                return;
            }
            return;
        }
        if (!(holder instanceof FileGroupViewHolder)) {
            if (holder instanceof ThinkingViewHolder) {
                ((ThinkingViewHolder) holder).bind();
            }
        } else {
            List<BrainstormAttachment> attachments2 = subtitleItem.getAttachments();
            if (attachments2 != null) {
                ((FileGroupViewHolder) holder).bind(attachments2);
            }
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(PAYLOAD_TEXT_UPDATE)) {
            SubtitleItem subtitleItem = this.items.get(position);
            if (holder instanceof MessageViewHolder) {
                ((MessageViewHolder) holder).updateText(subtitleItem.getContent());
                return;
            } else if (holder instanceof FooterViewHolder) {
                ((FooterViewHolder) holder).updateText(subtitleItem.getContent());
                return;
            } else {
                super.onBindViewHolder(holder, position, payloads);
                return;
            }
        }
        if (payloads.contains(PAYLOAD_ATTACHMENT_UPDATE)) {
            BrainstormAttachment attachment = this.items.get(position).getAttachment();
            if ((holder instanceof AttachmentViewHolder) && attachment != null) {
                ((AttachmentViewHolder) holder).updateState(attachment);
                return;
            } else {
                super.onBindViewHolder(holder, position, payloads);
                return;
            }
        }
        if (payloads.contains(PAYLOAD_ATTACHMENT_GROUP_UPDATE)) {
            List<BrainstormAttachment> attachments = this.items.get(position).getAttachments();
            if ((holder instanceof GroupAttachmentViewHolder) && attachments != null) {
                ((GroupAttachmentViewHolder) holder).bind(attachments);
                return;
            } else if (!(holder instanceof FileGroupViewHolder) || attachments == null) {
                super.onBindViewHolder(holder, position, payloads);
                return;
            } else {
                ((FileGroupViewHolder) holder).bind(attachments);
                return;
            }
        }
        if (payloads.contains(PAYLOAD_SUBTASK_UPDATE)) {
            SubtitleItem subtitleItem2 = this.items.get(position);
            if (holder instanceof MessageViewHolder) {
                ((MessageViewHolder) holder).updateSubTaskBadge(subtitleItem2.getSubTaskBadge());
                return;
            } else {
                super.onBindViewHolder(holder, position, payloads);
                return;
            }
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/LinearLayout;", "<init>", "(Landroid/widget/LinearLayout;)V", "textView", "Landroid/widget/TextView;", "badgeContainer", "badgeLoading", "Landroid/widget/ImageView;", "badgeIcon", "badgeText", "badgeLoadingAnim", "Landroid/view/animation/RotateAnimation;", "getBadgeLoadingAnim", "()Landroid/view/animation/RotateAnimation;", "badgeLoadingAnim$delegate", "Lkotlin/Lazy;", "bind", "", "item", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "updateText", "text", "", "updateSubTaskBadge", "badge", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "startBadgeLoading", "stopBadgeLoading", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MessageViewHolder extends RecyclerView.ViewHolder {
        private static final long BADGE_LOADING_DURATION_MS = 1000;
        private static final int BADGE_LOADING_STEPS = 8;
        private final LinearLayout badgeContainer;
        private final ImageView badgeIcon;
        private final ImageView badgeLoading;

        /* renamed from: badgeLoadingAnim$delegate, reason: from kotlin metadata */
        private final Lazy badgeLoadingAnim;
        private final TextView badgeText;
        private final LinearLayout container;
        private final TextView textView;

        /* compiled from: HistorySubtitleAdapter.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MessageRole.values().length];
                try {
                    iArr[MessageRole.User.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MessageRole.Assistant.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            Intrinsics.checkNotNullParameter(linearLayout, "container");
            this.container = linearLayout;
            View findViewById = linearLayout.findViewById(C0637R.id.tv_subtitle_content);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.textView = (TextView) findViewById;
            View findViewById2 = linearLayout.findViewById(C0637R.id.subtask_badge_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.badgeContainer = (LinearLayout) findViewById2;
            View findViewById3 = linearLayout.findViewById(C0637R.id.iv_subtask_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.badgeLoading = (ImageView) findViewById3;
            View findViewById4 = linearLayout.findViewById(C0637R.id.iv_subtask_status_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.badgeIcon = (ImageView) findViewById4;
            View findViewById5 = linearLayout.findViewById(C0637R.id.tv_subtask_status_text);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.badgeText = (TextView) findViewById5;
            this.badgeLoadingAnim = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$MessageViewHolder$$ExternalSyntheticLambda0
                public final Object invoke() {
                    RotateAnimation badgeLoadingAnim_delegate$lambda$1;
                    badgeLoadingAnim_delegate$lambda$1 = HistorySubtitleAdapter.MessageViewHolder.badgeLoadingAnim_delegate$lambda$1();
                    return badgeLoadingAnim_delegate$lambda$1;
                }
            });
        }

        private final RotateAnimation getBadgeLoadingAnim() {
            return (RotateAnimation) this.badgeLoadingAnim.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RotateAnimation badgeLoadingAnim_delegate$lambda$1() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new StepInterpolator(8));
            return rotateAnimation;
        }

        public final void bind(SubtitleItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.textView.setText(item.getContent());
            float f = this.textView.getResources().getDisplayMetrics().density;
            int i = WhenMappings.$EnumSwitchMapping$0[item.getRole().ordinal()];
            if (i == 1) {
                this.container.setGravity(8388613);
                TextView textView = this.textView;
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_text_text_secondary));
                this.textView.setTypeface(null, 0);
                this.textView.setBackgroundResource(C0637R.drawable.trae_bg_voice_history_user_bubble);
                int i2 = (int) (16 * f);
                int i3 = (int) (12 * f);
                this.textView.setPadding(i2, i3, i2, i3);
                this.textView.setMaxWidth((int) (302 * f));
                TextViewCompat.setLineHeight(this.textView, (int) (24 * f));
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.container.setGravity(8388611);
                TextView textView2 = this.textView;
                textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), C0591R.color.trae_text_text_default));
                this.textView.setTypeface(null, 0);
                this.textView.setBackground(null);
                this.textView.setPadding(0, 0, 0, 0);
                this.textView.setMaxWidth((int) (280 * f));
                TextViewCompat.setLineHeight(this.textView, (int) (24 * f));
            }
            updateSubTaskBadge(item.getSubTaskBadge());
        }

        public final void updateText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.textView.setText(text);
        }

        public final void updateSubTaskBadge(SubTaskUiState badge) {
            this.badgeContainer.setVisibility(8);
            stopBadgeLoading();
        }

        private final void startBadgeLoading() {
            if (this.badgeLoading.getAnimation() == null) {
                this.badgeLoading.startAnimation(getBadgeLoadingAnim());
            }
        }

        private final void stopBadgeLoading() {
            if (this.badgeLoading.getAnimation() != null) {
                this.badgeLoading.clearAnimation();
            }
        }
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Landroid/widget/FrameLayout;Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "card", "Landroid/view/View;", "nameView", "Landroid/widget/TextView;", "typeIcon", "Landroid/widget/ImageView;", "previewView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "contentView", "Landroid/widget/LinearLayout;", "loadingOverlay", "failedOverlay", "statusView", "closeView", "previewLoader", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;", "bound", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "bind", "", "attachment", "updateState", "applyTypeIcon", "applyAttachmentVisuals", "applyCardLayout", "isImage", "", "normalStatusColor", "", "isImageAttachment", "dp", "value", "failedStatusText", "", "formatFileSize", "", "bytes", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AttachmentViewHolder extends RecyclerView.ViewHolder {
        private static final int STATUS_COLOR_FAILED = -1554886;
        private BrainstormAttachment bound;
        private final AttachmentCallback callback;
        private final View card;
        private final ImageView closeView;
        private final FrameLayout container;
        private final LinearLayout contentView;
        private final View failedOverlay;
        private final View loadingOverlay;
        private final TextView nameView;
        private final BrainstormPreviewImageLoader previewLoader;
        private final SimpleDraweeView previewView;
        private final TextView statusView;
        private final ImageView typeIcon;

        /* compiled from: HistorySubtitleAdapter.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AttachmentState.values().length];
                try {
                    iArr[AttachmentState.Failed.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AttachmentState.Cancelled.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AttachmentState.Uploading.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AttachmentState.Uploaded.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttachmentViewHolder(FrameLayout frameLayout, AttachmentCallback attachmentCallback) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(attachmentCallback, "callback");
            this.container = frameLayout;
            this.callback = attachmentCallback;
            View findViewById = frameLayout.findViewById(C0637R.id.card_attachment);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.card = findViewById;
            View findViewById2 = frameLayout.findViewById(C0637R.id.tv_attach_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.nameView = (TextView) findViewById2;
            View findViewById3 = frameLayout.findViewById(C0637R.id.iv_attach_type_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.typeIcon = (ImageView) findViewById3;
            SimpleDraweeView findViewById4 = frameLayout.findViewById(C0637R.id.iv_attach_preview);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            SimpleDraweeView simpleDraweeView = findViewById4;
            this.previewView = simpleDraweeView;
            View findViewById5 = frameLayout.findViewById(C0637R.id.ll_attach_file_content);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.contentView = (LinearLayout) findViewById5;
            View findViewById6 = frameLayout.findViewById(C0637R.id.overlay_attach_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.loadingOverlay = findViewById6;
            View findViewById7 = frameLayout.findViewById(C0637R.id.overlay_attach_failed);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.failedOverlay = findViewById7;
            View findViewById8 = frameLayout.findViewById(C0637R.id.tv_attach_status);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.statusView = (TextView) findViewById8;
            View findViewById9 = frameLayout.findViewById(C0637R.id.iv_attach_close);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            this.closeView = (ImageView) findViewById9;
            this.previewLoader = new BrainstormPreviewImageLoader(simpleDraweeView);
        }

        public final void bind(BrainstormAttachment attachment) {
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.bound = attachment;
            this.nameView.setText(attachment.getDisplayName());
            applyAttachmentVisuals(attachment);
            updateState(attachment);
            this.closeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistorySubtitleAdapter.AttachmentViewHolder.bind$lambda$1(HistorySubtitleAdapter.AttachmentViewHolder.this, view);
                }
            });
            this.card.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistorySubtitleAdapter.AttachmentViewHolder.bind$lambda$2(HistorySubtitleAdapter.AttachmentViewHolder.this, view);
                }
            });
            this.statusView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistorySubtitleAdapter.AttachmentViewHolder.bind$lambda$3(HistorySubtitleAdapter.AttachmentViewHolder.this, view);
                }
            });
            this.failedOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistorySubtitleAdapter.AttachmentViewHolder.bind$lambda$5(HistorySubtitleAdapter.AttachmentViewHolder.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(AttachmentViewHolder attachmentViewHolder, View view) {
            BrainstormAttachment brainstormAttachment = attachmentViewHolder.bound;
            if (brainstormAttachment != null) {
                attachmentViewHolder.callback.onClose(brainstormAttachment.getAttachmentId(), brainstormAttachment.getState());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(AttachmentViewHolder attachmentViewHolder, View view) {
            BrainstormAttachment brainstormAttachment = attachmentViewHolder.bound;
            if (brainstormAttachment == null) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[brainstormAttachment.getState().ordinal()];
            if (i == 1) {
                attachmentViewHolder.callback.onRetry(brainstormAttachment.getAttachmentId());
            } else if (i != 2) {
                attachmentViewHolder.callback.onPreview(brainstormAttachment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(AttachmentViewHolder attachmentViewHolder, View view) {
            BrainstormAttachment brainstormAttachment = attachmentViewHolder.bound;
            if (brainstormAttachment != null && brainstormAttachment.getState() == AttachmentState.Failed) {
                attachmentViewHolder.callback.onRetry(brainstormAttachment.getAttachmentId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$5(AttachmentViewHolder attachmentViewHolder, View view) {
            BrainstormAttachment brainstormAttachment = attachmentViewHolder.bound;
            if (brainstormAttachment != null) {
                attachmentViewHolder.callback.onRetry(brainstormAttachment.getAttachmentId());
            }
        }

        public final void updateState(BrainstormAttachment attachment) {
            String string;
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.bound = attachment;
            applyAttachmentVisuals(attachment);
            boolean z = true;
            this.closeView.setVisibility(attachment.getState() != AttachmentState.Uploaded ? 0 : 8);
            int i = WhenMappings.$EnumSwitchMapping$0[attachment.getState().ordinal()];
            if (i == 1) {
                this.statusView.setVisibility(0);
                this.statusView.setText(failedStatusText(attachment));
                this.statusView.setTextColor(normalStatusColor(attachment));
                this.card.setAlpha(1.0f);
                this.card.setClickable(true);
                this.statusView.setClickable(true);
            } else if (i == 2) {
                this.statusView.setVisibility(0);
                this.statusView.setText(C0637R.string.trae_brainstorm_attach_cancelled);
                this.statusView.setTextColor(normalStatusColor(attachment));
                this.card.setAlpha(0.6f);
                this.card.setClickable(false);
                this.statusView.setClickable(false);
            } else if (i == 3) {
                String formatFileSize = formatFileSize(attachment.getSizeBytes());
                int coerceIn = RangesKt.coerceIn(attachment.getProgress(), 0, 100);
                TextView textView = this.statusView;
                if (formatFileSize.length() == 0) {
                    string = this.container.getContext().getString(C0637R.string.trae_brainstorm_attach_uploading_no_size, Integer.valueOf(coerceIn));
                } else {
                    string = this.container.getContext().getString(C0637R.string.trae_brainstorm_attach_uploading_progress, formatFileSize, Integer.valueOf(coerceIn));
                }
                textView.setText(string);
                this.statusView.setVisibility(0);
                this.statusView.setTextColor(normalStatusColor(attachment));
                this.card.setAlpha(1.0f);
                this.card.setClickable(isImageAttachment(attachment));
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                String formatFileSize2 = formatFileSize(attachment.getSizeBytes());
                this.statusView.setVisibility(formatFileSize2.length() > 0 ? 0 : 8);
                this.statusView.setText(formatFileSize2);
                this.statusView.setTextColor(normalStatusColor(attachment));
                this.card.setAlpha(1.0f);
                View view = this.card;
                if (!isImageAttachment(attachment)) {
                    String uploadedRef = attachment.getUploadedRef();
                    if (uploadedRef == null || StringsKt.isBlank(uploadedRef)) {
                        z = false;
                    }
                }
                view.setClickable(z);
            }
            if (attachment.getState() != AttachmentState.Failed) {
                this.statusView.setClickable(false);
            }
        }

        private final void applyTypeIcon(BrainstormAttachment attachment) {
            this.typeIcon.setImageResource(VoiceAttachmentIconResolver.INSTANCE.getFileIconRes(attachment.getDisplayName(), attachment.getMimeType(), attachment.isImage()));
        }

        private final void applyAttachmentVisuals(BrainstormAttachment attachment) {
            boolean isImageAttachment = isImageAttachment(attachment);
            applyCardLayout(isImageAttachment);
            this.previewView.setVisibility(isImageAttachment ? 0 : 8);
            this.contentView.setVisibility(isImageAttachment ^ true ? 0 : 8);
            this.typeIcon.setVisibility(isImageAttachment ^ true ? 0 : 8);
            this.loadingOverlay.setVisibility(isImageAttachment && attachment.getState() == AttachmentState.Uploading ? 0 : 8);
            this.failedOverlay.setVisibility(isImageAttachment && attachment.getState() == AttachmentState.Failed ? 0 : 8);
            if (isImageAttachment) {
                this.previewLoader.load(attachment.getLocalUri());
                this.closeView.setImageResource(C0637R.drawable.trae_ic_brainstorm_attach_close_small);
                return;
            }
            this.previewLoader.clear();
            this.loadingOverlay.setVisibility(8);
            this.failedOverlay.setVisibility(8);
            this.nameView.setTextColor(ContextCompat.getColor(this.container.getContext(), C0591R.color.trae_text_text_default));
            this.closeView.setImageResource(C0637R.drawable.trae_ic_brainstorm_attach_close_small);
            applyTypeIcon(attachment);
        }

        private final void applyCardLayout(boolean isImage) {
            ViewGroup.LayoutParams layoutParams = this.card.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams3 = this.closeView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            if (isImage) {
                layoutParams2.width = m819dp(84);
                layoutParams2.height = m819dp(84);
                this.card.setBackgroundResource(0);
                layoutParams4.width = m819dp(16);
                layoutParams4.height = m819dp(16);
                layoutParams4.topMargin = m819dp(10);
                layoutParams4.setMarginEnd(m819dp(10));
                this.closeView.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_attachment_close);
                this.closeView.setPadding(m819dp(1), m819dp(1), m819dp(1), m819dp(1));
            } else {
                layoutParams2.width = m819dp(180);
                layoutParams2.height = m819dp(52);
                this.card.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_attachment_card);
                layoutParams4.width = m819dp(16);
                layoutParams4.height = m819dp(16);
                layoutParams4.topMargin = m819dp(10);
                layoutParams4.setMarginEnd(m819dp(10));
                this.closeView.setBackgroundResource(C0637R.drawable.trae_bg_brainstorm_attachment_close);
                this.closeView.setPadding(m819dp(1), m819dp(1), m819dp(1), m819dp(1));
            }
            this.card.setLayoutParams(layoutParams2);
            this.closeView.setLayoutParams(layoutParams4);
        }

        private final int normalStatusColor(BrainstormAttachment attachment) {
            if (isImageAttachment(attachment)) {
                return -1;
            }
            return ContextCompat.getColor(this.container.getContext(), C0591R.color.trae_text_text_tertiary);
        }

        private final boolean isImageAttachment(BrainstormAttachment attachment) {
            boolean isImageAttachment;
            isImageAttachment = HistorySubtitleAdapterKt.isImageAttachment(attachment);
            return isImageAttachment;
        }

        /* renamed from: dp */
        private final int m819dp(int value) {
            return (int) ((value * this.container.getResources().getDisplayMetrics().density) + 0.5f);
        }

        private final CharSequence failedStatusText(BrainstormAttachment attachment) {
            String string = this.container.getContext().getString(C0637R.string.trae_brainstorm_attach_resend);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String formatFileSize = formatFileSize(attachment.getSizeBytes());
            String str = formatFileSize.length() == 0 ? string : formatFileSize + "  " + string;
            SpannableString spannableString = new SpannableString(str);
            int indexOf$default = StringsKt.indexOf$default(str, string, 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(STATUS_COLOR_FAILED), indexOf$default, string.length() + indexOf$default, 33);
            }
            return spannableString;
        }

        private final String formatFileSize(long bytes) {
            if (bytes <= 0) {
                return "";
            }
            if (bytes < 1024) {
                return bytes + " B";
            }
            if (bytes < 1048576) {
                return (bytes / 1024) + " KB";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FileGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Landroid/widget/FrameLayout;Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "rowView", "Landroidx/recyclerview/widget/RecyclerView;", "childAdapter", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;", "lastCount", "", "bind", "", "attachments", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FileGroupViewHolder extends RecyclerView.ViewHolder {
        private static final int ROW_ITEM_SPACING_DP = 8;
        private final BrainstormFileRowAdapter childAdapter;
        private int lastCount;
        private final RecyclerView rowView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileGroupViewHolder(FrameLayout frameLayout, AttachmentCallback attachmentCallback) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(attachmentCallback, "callback");
            RecyclerView findViewById = frameLayout.findViewById(C0637R.id.rv_image_row);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            RecyclerView recyclerView = findViewById;
            this.rowView = recyclerView;
            RecyclerView.Adapter brainstormFileRowAdapter = new BrainstormFileRowAdapter(attachmentCallback);
            this.childAdapter = brainstormFileRowAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(frameLayout.getContext(), 0, false));
            recyclerView.setAdapter(brainstormFileRowAdapter);
            final int i = (int) ((8 * frameLayout.getResources().getDisplayMetrics().density) + 0.5f);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.FileGroupViewHolder.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    if (parent.getChildAdapterPosition(view) < (parent.getAdapter() != null ? r4.getItemCount() : 0) - 1) {
                        outRect.right = i;
                    }
                }
            });
        }

        public final void bind(final List<BrainstormAttachment> attachments) {
            Intrinsics.checkNotNullParameter(attachments, "attachments");
            final boolean z = attachments.size() > this.lastCount;
            this.lastCount = attachments.size();
            this.childAdapter.submitList(CollectionsKt.toList(attachments), new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$FileGroupViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HistorySubtitleAdapter.FileGroupViewHolder.bind$lambda$0(z, attachments, this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(boolean z, List list, FileGroupViewHolder fileGroupViewHolder) {
            if (z && (!list.isEmpty())) {
                fileGroupViewHolder.rowView.scrollToPosition(list.size() - 1);
            }
        }
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$GroupAttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Landroid/widget/FrameLayout;Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "rowView", "Landroidx/recyclerview/widget/RecyclerView;", "childAdapter", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;", "lastCount", "", "bind", "", "attachments", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class GroupAttachmentViewHolder extends RecyclerView.ViewHolder {
        private static final int ROW_ITEM_SPACING_DP = 8;
        private final BrainstormImageRowAdapter childAdapter;
        private int lastCount;
        private final RecyclerView rowView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupAttachmentViewHolder(FrameLayout frameLayout, AttachmentCallback attachmentCallback) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            Intrinsics.checkNotNullParameter(attachmentCallback, "callback");
            RecyclerView findViewById = frameLayout.findViewById(C0637R.id.rv_image_row);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            RecyclerView recyclerView = findViewById;
            this.rowView = recyclerView;
            RecyclerView.Adapter brainstormImageRowAdapter = new BrainstormImageRowAdapter(attachmentCallback);
            this.childAdapter = brainstormImageRowAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(frameLayout.getContext(), 0, false));
            recyclerView.setAdapter(brainstormImageRowAdapter);
            final int i = (int) ((8 * frameLayout.getResources().getDisplayMetrics().density) + 0.5f);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter.GroupAttachmentViewHolder.1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    if (parent.getChildAdapterPosition(view) < (parent.getAdapter() != null ? r4.getItemCount() : 0) - 1) {
                        outRect.right = i;
                    }
                }
            });
        }

        public final void bind(final List<BrainstormAttachment> attachments) {
            Intrinsics.checkNotNullParameter(attachments, "attachments");
            final boolean z = attachments.size() > this.lastCount;
            this.lastCount = attachments.size();
            this.childAdapter.submitList(CollectionsKt.toList(attachments), new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$GroupAttachmentViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    HistorySubtitleAdapter.GroupAttachmentViewHolder.bind$lambda$0(z, attachments, this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(boolean z, List list, GroupAttachmentViewHolder groupAttachmentViewHolder) {
            if (z && (!list.isEmpty())) {
                groupAttachmentViewHolder.rowView.scrollToPosition(list.size() - 1);
            }
        }
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/LinearLayout;", "<init>", "(Landroid/widget/LinearLayout;)V", "shimmerTextView", "Lcom/bytedance/trae/conversation/brainstorm/widget/ShimmerTextView;", "bind", "", "item", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "updateText", "text", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout container;
        private final ShimmerTextView shimmerTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            Intrinsics.checkNotNullParameter(linearLayout, "container");
            this.container = linearLayout;
            Object findViewById = linearLayout.findViewById(C0637R.id.tv_footer_shimmer);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.shimmerTextView = (ShimmerTextView) findViewById;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bind(SubtitleItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.shimmerTextView.setText(item.getContent());
            this.container.setGravity(8388611);
            this.shimmerTextView.setTypeface(null, 0);
            ShimmerTextView shimmerTextView = this.shimmerTextView;
            TextViewCompat.setLineHeight((TextView) shimmerTextView, (int) (20 * shimmerTextView.getResources().getDisplayMetrics().density));
            this.shimmerTextView.startShimmer();
        }

        public final void updateText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.shimmerTextView.setText(text);
        }
    }

    /* compiled from: HistorySubtitleAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$ThinkingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/LinearLayout;", "<init>", "(Landroid/widget/LinearLayout;)V", "dotsView", "Lcom/bytedance/trae/conversation/brainstorm/widget/ThinkingDotsView;", "bind", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ThinkingViewHolder extends RecyclerView.ViewHolder {
        private final ThinkingDotsView dotsView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThinkingViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            Intrinsics.checkNotNullParameter(linearLayout, "container");
            View findViewById = linearLayout.findViewById(C0637R.id.thinking_dots);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.dotsView = (ThinkingDotsView) findViewById;
        }

        public final void bind() {
            this.dotsView.startShimmer();
        }
    }
}
