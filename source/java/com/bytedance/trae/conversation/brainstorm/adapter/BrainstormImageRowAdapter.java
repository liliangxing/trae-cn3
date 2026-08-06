package com.bytedance.trae.conversation.brainstorm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter;
import com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter;
import com.bytedance.trae.conversation.brainstorm.model.AttachmentState;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormImageRowAdapter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "ImageCellViewHolder", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormImageRowAdapter extends ListAdapter<BrainstormAttachment, ImageCellViewHolder> {
    private static final BrainstormImageRowAdapter$Companion$DIFF$1 DIFF = new DiffUtil.ItemCallback<BrainstormAttachment>() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$Companion$DIFF$1
        public boolean areItemsTheSame(BrainstormAttachment oldItem, BrainstormAttachment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getAttachmentId(), newItem.getAttachmentId());
        }

        public boolean areContentsTheSame(BrainstormAttachment oldItem, BrainstormAttachment newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getState() == newItem.getState() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.areEqual(oldItem.getLocalUri(), newItem.getLocalUri());
        }
    };
    private final HistorySubtitleAdapter.AttachmentCallback callback;

    public BrainstormImageRowAdapter(HistorySubtitleAdapter.AttachmentCallback attachmentCallback) {
        super(DIFF);
        this.callback = attachmentCallback;
    }

    public ImageCellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_brainstorm_image_cell, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        return new ImageCellViewHolder((FrameLayout) inflate, this.callback);
    }

    public void onBindViewHolder(ImageCellViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((BrainstormAttachment) item);
    }

    /* compiled from: BrainstormImageRowAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "callback", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;", "<init>", "(Landroid/widget/FrameLayout;Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V", "previewView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "loadingOverlay", "Landroid/view/View;", "failedOverlay", "closeView", "previewLoader", "Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormPreviewImageLoader;", "bound", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "bind", "", "attachment", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ImageCellViewHolder extends RecyclerView.ViewHolder {
        private BrainstormAttachment bound;
        private final HistorySubtitleAdapter.AttachmentCallback callback;
        private final View closeView;
        private final FrameLayout container;
        private final View failedOverlay;
        private final View loadingOverlay;
        private final BrainstormPreviewImageLoader previewLoader;
        private final SimpleDraweeView previewView;

        /* compiled from: BrainstormImageRowAdapter.kt */
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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageCellViewHolder(FrameLayout frameLayout, HistorySubtitleAdapter.AttachmentCallback attachmentCallback) {
            super(frameLayout);
            Intrinsics.checkNotNullParameter(frameLayout, "container");
            this.container = frameLayout;
            this.callback = attachmentCallback;
            SimpleDraweeView findViewById = frameLayout.findViewById(C0637R.id.iv_cell_preview);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            SimpleDraweeView simpleDraweeView = findViewById;
            this.previewView = simpleDraweeView;
            View findViewById2 = frameLayout.findViewById(C0637R.id.overlay_cell_loading);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.loadingOverlay = findViewById2;
            View findViewById3 = frameLayout.findViewById(C0637R.id.overlay_cell_failed);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.failedOverlay = findViewById3;
            View findViewById4 = frameLayout.findViewById(C0637R.id.iv_cell_close);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.closeView = findViewById4;
            this.previewLoader = new BrainstormPreviewImageLoader(simpleDraweeView);
        }

        public final void bind(BrainstormAttachment attachment) {
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.bound = attachment;
            this.previewLoader.load(attachment.getLocalUri());
            this.loadingOverlay.setVisibility(attachment.getState() == AttachmentState.Uploading ? 0 : 8);
            this.failedOverlay.setVisibility(attachment.getState() == AttachmentState.Failed ? 0 : 8);
            this.closeView.setVisibility(attachment.getState() != AttachmentState.Uploaded ? 0 : 8);
            this.container.setAlpha(attachment.getState() == AttachmentState.Cancelled ? 0.6f : 1.0f);
            this.closeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BrainstormImageRowAdapter.ImageCellViewHolder.bind$lambda$1(BrainstormImageRowAdapter.ImageCellViewHolder.this, view);
                }
            });
            this.container.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BrainstormImageRowAdapter.ImageCellViewHolder.bind$lambda$2(BrainstormImageRowAdapter.ImageCellViewHolder.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ImageCellViewHolder imageCellViewHolder, View view) {
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback;
            BrainstormAttachment brainstormAttachment = imageCellViewHolder.bound;
            if (brainstormAttachment == null || (attachmentCallback = imageCellViewHolder.callback) == null) {
                return;
            }
            attachmentCallback.onClose(brainstormAttachment.getAttachmentId(), brainstormAttachment.getState());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(ImageCellViewHolder imageCellViewHolder, View view) {
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback;
            BrainstormAttachment brainstormAttachment = imageCellViewHolder.bound;
            if (brainstormAttachment == null) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[brainstormAttachment.getState().ordinal()];
            if (i != 1) {
                if (i == 2 || (attachmentCallback = imageCellViewHolder.callback) == null) {
                    return;
                }
                attachmentCallback.onPreview(brainstormAttachment);
                return;
            }
            HistorySubtitleAdapter.AttachmentCallback attachmentCallback2 = imageCellViewHolder.callback;
            if (attachmentCallback2 != null) {
                attachmentCallback2.onRetry(brainstormAttachment.getAttachmentId());
            }
        }
    }
}
