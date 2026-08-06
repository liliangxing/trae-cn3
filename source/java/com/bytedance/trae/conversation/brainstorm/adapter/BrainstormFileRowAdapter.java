package com.bytedance.trae.conversation.brainstorm.adapter;

import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.VoiceAttachmentIconResolver;
import com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter;
import com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormFileRowAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "FileCellViewHolder", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormFileRowAdapter extends ListAdapter<BrainstormAttachment, FileCellViewHolder> {
    private static final BrainstormFileRowAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<BrainstormAttachment>() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$Companion$DIFF$1
        public boolean areItemsTheSame(BrainstormAttachment oldItem, BrainstormAttachment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getAttachmentId(), newItem.getAttachmentId());
        }

        public boolean areContentsTheSame(BrainstormAttachment oldItem, BrainstormAttachment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getState() == newItem.getState() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.areEqual(oldItem.getDisplayName(), newItem.getDisplayName());
        }
    };
    private final HistorySubtitleAdapter.AttachmentCallback callback;

    public BrainstormFileRowAdapter(HistorySubtitleAdapter.AttachmentCallback attachmentCallback) {
        super(DIFF);
        this.callback = attachmentCallback;
    }

    public FileCellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_brainstorm_file_cell, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        return new FileCellViewHolder((FrameLayout) inflate, this.callback);
    }

    public void onBindViewHolder(FileCellViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((BrainstormAttachment) item);
    }

    /* compiled from: BrainstormFileRowAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormFileRowAdapter$FileCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Landroid/widget/FrameLayout;Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "card", "Landroid/view/View;", "typeIcon", "Landroid/widget/ImageView;", "nameView", "Landroid/widget/TextView;", "statusView", "loadingOverlay", "failedOverlay", "closeView", "bound", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "bind", "", "attachment", "applyTypeIcon", "applyStatus", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class FileCellViewHolder extends RecyclerView.ViewHolder {
        private BrainstormAttachment bound;
        private final HistorySubtitleAdapter.AttachmentCallback callback;
        private final View card;
        private final View closeView;
        private final FrameLayout container;
        private final View failedOverlay;
        private final View loadingOverlay;
        private final TextView nameView;
        private final TextView statusView;
        private final ImageView typeIcon;

        /* compiled from: BrainstormFileRowAdapter.kt */
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
        public FileCellViewHolder(FrameLayout frameLayout, HistorySubtitleAdapter.AttachmentCallback attachmentCallback) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            this.container = frameLayout;
            this.callback = attachmentCallback;
            View findViewById = frameLayout.findViewById(C0637R.id.card_file_cell);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.card = findViewById;
            View findViewById2 = frameLayout.findViewById(C0637R.id.iv_file_type_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.typeIcon = (ImageView) findViewById2;
            View findViewById3 = frameLayout.findViewById(C0637R.id.tv_file_name);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.nameView = (TextView) findViewById3;
            View findViewById4 = frameLayout.findViewById(C0637R.id.tv_file_status);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.statusView = (TextView) findViewById4;
            View findViewById5 = frameLayout.findViewById(C0637R.id.overlay_file_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.loadingOverlay = findViewById5;
            View findViewById6 = frameLayout.findViewById(C0637R.id.overlay_file_failed);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.failedOverlay = findViewById6;
            View findViewById7 = frameLayout.findViewById(C0637R.id.iv_file_close);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.closeView = findViewById7;
        }

        public final void bind(BrainstormAttachment attachment) {
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.bound = attachment;
            this.nameView.setText(attachment.getDisplayName());
            applyTypeIcon(attachment);
            applyStatus(attachment);
            this.loadingOverlay.setVisibility(attachment.getState() == AttachmentState.Uploading ? 0 : 8);
            this.failedOverlay.setVisibility(attachment.getState() == AttachmentState.Failed ? 0 : 8);
            this.closeView.setVisibility(attachment.getState() != AttachmentState.Uploaded ? 0 : 8);
            this.card.setAlpha(attachment.getState() == AttachmentState.Cancelled ? 0.6f : 1.0f);
            this.closeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BrainstormFileRowAdapter.FileCellViewHolder.bind$lambda$1(BrainstormFileRowAdapter.FileCellViewHolder.this, view);
                }
            });
            this.card.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormFileRowAdapter$FileCellViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BrainstormFileRowAdapter.FileCellViewHolder.bind$lambda$2(BrainstormFileRowAdapter.FileCellViewHolder.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(FileCellViewHolder fileCellViewHolder, View view) {
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback;
            BrainstormAttachment brainstormAttachment = fileCellViewHolder.bound;
            if (brainstormAttachment == null || (attachmentCallback = fileCellViewHolder.callback) == null) {
                return;
            }
            attachmentCallback.onClose(brainstormAttachment.getAttachmentId(), brainstormAttachment.getState());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(FileCellViewHolder fileCellViewHolder, View view) {
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback;
            BrainstormAttachment brainstormAttachment = fileCellViewHolder.bound;
            if (brainstormAttachment == null) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[brainstormAttachment.getState().ordinal()];
            if (i != 1) {
                if (i == 2 || (attachmentCallback = fileCellViewHolder.callback) == null) {
                    return;
                }
                attachmentCallback.onPreview(brainstormAttachment);
                return;
            }
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback2 = fileCellViewHolder.callback;
            if (attachmentCallback2 != null) {
                attachmentCallback2.onRetry(brainstormAttachment.getAttachmentId());
            }
        }

        private final void applyTypeIcon(BrainstormAttachment attachment) {
            this.typeIcon.setImageResource(VoiceAttachmentIconResolver.INSTANCE.getFileIconRes(attachment.getDisplayName(), attachment.getMimeType(), attachment.isImage()));
        }

        private final void applyStatus(BrainstormAttachment attachment) {
            int i = WhenMappings.$EnumSwitchMapping$0[attachment.getState().ordinal()];
            if (i == 1) {
                this.statusView.setVisibility(0);
                this.statusView.setText(Formatter.formatShortFileSize(this.itemView.getContext(), attachment.getSizeBytes()));
                return;
            }
            if (i == 3) {
                this.statusView.setVisibility(0);
                this.statusView.setText(Formatter.formatShortFileSize(this.itemView.getContext(), attachment.getSizeBytes()) + "  " + attachment.getProgress() + '%');
            } else if (i == 4) {
                this.statusView.setVisibility(0);
                this.statusView.setText(Formatter.formatShortFileSize(this.itemView.getContext(), attachment.getSizeBytes()));
            } else {
                this.statusView.setVisibility(attachment.getSizeBytes() > 0 ? 0 : 8);
                if (attachment.getSizeBytes() > 0) {
                    this.statusView.setText(Formatter.formatShortFileSize(this.itemView.getContext(), attachment.getSizeBytes()));
                }
            }
        }
    }
}
