package com.bytedance.trae.conversation.widget;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.databinding.TraeItemAttachmentBinding;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.widget.InputAttachmentAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InputAttachmentAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B1\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;", "onRemove", "Lkotlin/Function1;", "", "onRetry", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "payloads", "", "", "ViewHolder", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputAttachmentAdapter extends ListAdapter<AttachmentItem, ViewHolder> {
    private static final InputAttachmentAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<AttachmentItem>() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentAdapter$Companion$DIFF_CALLBACK$1
        public boolean areItemsTheSame(AttachmentItem oldItem, AttachmentItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getUri(), newItem.getUri());
        }

        public boolean areContentsTheSame(AttachmentItem oldItem, AttachmentItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getUploadStatus() == newItem.getUploadStatus() && Intrinsics.areEqual(oldItem.getFileName(), newItem.getFileName()) && Intrinsics.areEqual(oldItem.getUploadError(), newItem.getUploadError());
        }

        public Object getChangePayload(AttachmentItem oldItem, AttachmentItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getUploadStatus() != newItem.getUploadStatus() ? 1 : null;
        }
    };
    private static final int PAYLOAD_STATUS_CHANGED = 1;
    private final Function1<AttachmentItem, Unit> onRemove;
    private final Function1<AttachmentItem, Unit> onRetry;

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ViewHolder) viewHolder, i, (List<Object>) list);
    }

    public /* synthetic */ InputAttachmentAdapter(Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? new Function1() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentAdapter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = InputAttachmentAdapter._init_$lambda$0((AttachmentItem) obj);
                return _init_$lambda$0;
            }
        } : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(AttachmentItem attachmentItem) {
        Intrinsics.checkNotNullParameter(attachmentItem, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InputAttachmentAdapter(Function1<? super AttachmentItem, Unit> function1, Function1<? super AttachmentItem, Unit> function12) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(function1, "onRemove");
        Intrinsics.checkNotNullParameter(function12, "onRetry");
        this.onRemove = function1;
        this.onRetry = function12;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraeItemAttachmentBinding inflate = TraeItemAttachmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate, this.onRemove, this.onRetry);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind((AttachmentItem) item);
    }

    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        Object item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bindStatus((AttachmentItem) item);
    }

    /* compiled from: InputAttachmentAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;", "onRemove", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "", "onRetry", "<init>", "(Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "bindStatus", "extractExtension", "", "fileName", "mimeType", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TraeItemAttachmentBinding binding;
        private final Function1<AttachmentItem, Unit> onRemove;
        private final Function1<AttachmentItem, Unit> onRetry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(TraeItemAttachmentBinding traeItemAttachmentBinding, Function1<? super AttachmentItem, Unit> function1, Function1<? super AttachmentItem, Unit> function12) {
            super(traeItemAttachmentBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeItemAttachmentBinding, "binding");
            Intrinsics.checkNotNullParameter(function1, "onRemove");
            Intrinsics.checkNotNullParameter(function12, "onRetry");
            this.binding = traeItemAttachmentBinding;
            this.onRemove = function1;
            this.onRetry = function12;
        }

        public final void bind(final AttachmentItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.isImage()) {
                this.binding.ivAttachment.setVisibility(0);
                RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(TypedValue.applyDimension(1, 16.0f, this.binding.ivAttachment.getResources().getDisplayMetrics()));
                fromCornersRadius.setRoundingMethod(RoundingParams.RoundingMethod.OVERLAY_COLOR);
                fromCornersRadius.setOverlayColor(Color.parseColor("#FFF5F5F5"));
                GenericDraweeHierarchy hierarchy = this.binding.ivAttachment.getHierarchy();
                hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
                hierarchy.setRoundingParams(fromCornersRadius);
                this.binding.ivAttachment.setController(Fresco.newDraweeControllerBuilder().setUri(item.getUri()).setAutoPlayAnimations(true).setOldController(this.binding.ivAttachment.getController()).build());
                this.binding.fileInfoOverlay.setVisibility(8);
            } else {
                this.binding.ivAttachment.setVisibility(8);
                this.binding.fileInfoOverlay.setVisibility(0);
                String extractExtension = extractExtension(item.getFileName(), item.getMimeType());
                TextView textView = this.binding.tvExtBadge;
                String upperCase = extractExtension.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                textView.setText(upperCase);
                TextView textView2 = this.binding.tvFileName;
                String fileName = item.getFileName();
                if (fileName == null) {
                    fileName = "";
                }
                textView2.setText(fileName);
            }
            this.binding.btnRemove.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputAttachmentAdapter.ViewHolder.bind$lambda$2(InputAttachmentAdapter.ViewHolder.this, item, view);
                }
            });
            bindStatus(item);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(ViewHolder viewHolder, AttachmentItem attachmentItem, View view) {
            viewHolder.onRemove.invoke(attachmentItem);
        }

        public final void bindStatus(final AttachmentItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            boolean z = item.getUploadStatus() == AttachmentUploadStatus.Uploading || item.getUploadStatus() == AttachmentUploadStatus.Pending;
            boolean z2 = item.getUploadStatus() == AttachmentUploadStatus.Error;
            this.binding.overlayLoading.setVisibility(z ? 0 : 8);
            this.binding.overlayFailed.setVisibility(z2 ? 0 : 8);
            this.binding.overlayFailed.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputAttachmentAdapter.ViewHolder.bindStatus$lambda$3(InputAttachmentAdapter.ViewHolder.this, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindStatus$lambda$3(ViewHolder viewHolder, AttachmentItem attachmentItem, View view) {
            viewHolder.onRetry.invoke(attachmentItem);
        }

        private final String extractExtension(String fileName, String mimeType) {
            String substringAfter;
            int lastIndexOf$default;
            if (fileName == null || (lastIndexOf$default = StringsKt.lastIndexOf$default(fileName, '.', 0, false, 6, (Object) null)) < 0 || lastIndexOf$default >= fileName.length() - 1) {
                return (mimeType == null || (substringAfter = StringsKt.substringAfter(mimeType, '/', "")) == null) ? "" : substringAfter;
            }
            String substring = fileName.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
    }
}
