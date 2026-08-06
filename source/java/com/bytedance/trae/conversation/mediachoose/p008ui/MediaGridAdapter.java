package com.bytedance.trae.conversation.mediachoose.p008ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseItemCameraBinding;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseItemMediaBinding;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.p008ui.MediaGridAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaGridAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004)*+,BT\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0016J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCameraClick", "Lkotlin/Function0;", "", "onToggleSelect", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "onPreview", "", "Lkotlin/ParameterName;", "name", "indexInMediaList", "enablePreview", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "items", "Ljava/util/ArrayList;", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;", "Lkotlin/collections/ArrayList;", "selection", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;", "submit", "mediaItems", "", "showCamera", "updateSelection", "currentMediaItems", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "currentIndexInMediaList", "adapterPosition", "CameraViewHolder", "MediaViewHolder", "GridItem", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_CAMERA = 0;
    private static final int TYPE_MEDIA = 1;
    private final boolean enablePreview;
    private final ArrayList<GridItem> items;
    private final Function0<Unit> onCameraClick;
    private final Function1<Integer, Unit> onPreview;
    private final Function1<MediaItem, Unit> onToggleSelect;
    private MediaSelection selection;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaGridAdapter(Function0<Unit> function0, Function1<? super MediaItem, Unit> function1, Function1<? super Integer, Unit> function12, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "onCameraClick");
        Intrinsics.checkNotNullParameter(function1, "onToggleSelect");
        Intrinsics.checkNotNullParameter(function12, "onPreview");
        this.onCameraClick = function0;
        this.onToggleSelect = function1;
        this.onPreview = function12;
        this.enablePreview = z;
        this.items = new ArrayList<>();
    }

    public final void submit(List<MediaItem> mediaItems, boolean showCamera) {
        Intrinsics.checkNotNullParameter(mediaItems, "mediaItems");
        this.items.clear();
        if (showCamera) {
            this.items.add(GridItem.Camera.INSTANCE);
        }
        Iterator<T> it = mediaItems.iterator();
        while (it.hasNext()) {
            this.items.add(new GridItem.Media((MediaItem) it.next()));
        }
        notifyDataSetChanged();
    }

    public final void updateSelection(MediaSelection selection) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        this.selection = selection;
        notifyDataSetChanged();
    }

    public final List<MediaItem> currentMediaItems() {
        ArrayList<GridItem> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList();
        for (GridItem gridItem : arrayList) {
            GridItem.Media media = gridItem instanceof GridItem.Media ? (GridItem.Media) gridItem : null;
            MediaItem item = media != null ? media.getItem() : null;
            if (item != null) {
                arrayList2.add(item);
            }
        }
        return arrayList2;
    }

    public int getItemViewType(int position) {
        GridItem gridItem = this.items.get(position);
        if (Intrinsics.areEqual(gridItem, GridItem.Camera.INSTANCE)) {
            return 0;
        }
        if (gridItem instanceof GridItem.Media) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            TraeMediaChooseItemCameraBinding inflate = TraeMediaChooseItemCameraBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new CameraViewHolder(inflate, this.onCameraClick);
        }
        if (viewType == 1) {
            TraeMediaChooseItemMediaBinding inflate2 = TraeMediaChooseItemMediaBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new MediaViewHolder(inflate2, this.onToggleSelect, this.onPreview, this.enablePreview);
        }
        throw new IllegalStateException(("unexpected viewType=" + viewType).toString());
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GridItem gridItem = this.items.get(position);
        Intrinsics.checkNotNullExpressionValue(gridItem, "get(...)");
        GridItem gridItem2 = gridItem;
        if (Intrinsics.areEqual(gridItem2, GridItem.Camera.INSTANCE)) {
            ((CameraViewHolder) holder).bind();
        } else {
            if (!(gridItem2 instanceof GridItem.Media)) {
                throw new NoWhenBranchMatchedException();
            }
            ((MediaViewHolder) holder).bind(((GridItem.Media) gridItem2).getItem(), this.selection, currentIndexInMediaList(position));
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    private final int currentIndexInMediaList(int adapterPosition) {
        return adapterPosition - (Intrinsics.areEqual(CollectionsKt.firstOrNull(this.items), GridItem.Camera.INSTANCE) ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaGridAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$CameraViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;", "onCameraClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;Lkotlin/jvm/functions/Function0;)V", "bind", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CameraViewHolder extends RecyclerView.ViewHolder {
        private final TraeMediaChooseItemCameraBinding binding;
        private final Function0<Unit> onCameraClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CameraViewHolder(TraeMediaChooseItemCameraBinding traeMediaChooseItemCameraBinding, Function0<Unit> function0) {
            super(traeMediaChooseItemCameraBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeMediaChooseItemCameraBinding, "binding");
            Intrinsics.checkNotNullParameter(function0, "onCameraClick");
            this.binding = traeMediaChooseItemCameraBinding;
            this.onCameraClick = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(CameraViewHolder cameraViewHolder, View view) {
            cameraViewHolder.onCameraClick.invoke();
        }

        public final void bind() {
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$CameraViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaGridAdapter.CameraViewHolder.bind$lambda$0(MediaGridAdapter.CameraViewHolder.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaGridAdapter.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;", "onToggleSelect", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "", "onPreview", "", "Lkotlin/ParameterName;", "name", "indexInMediaList", "enablePreview", "", "<init>", "(Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "bind", "item", "selection", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;", "formatDuration", "", "durationMs", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MediaViewHolder extends RecyclerView.ViewHolder {
        private final TraeMediaChooseItemMediaBinding binding;
        private final boolean enablePreview;
        private final Function1<Integer, Unit> onPreview;
        private final Function1<MediaItem, Unit> onToggleSelect;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MediaViewHolder(TraeMediaChooseItemMediaBinding traeMediaChooseItemMediaBinding, Function1<? super MediaItem, Unit> function1, Function1<? super Integer, Unit> function12, boolean z) {
            super(traeMediaChooseItemMediaBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeMediaChooseItemMediaBinding, "binding");
            Intrinsics.checkNotNullParameter(function1, "onToggleSelect");
            Intrinsics.checkNotNullParameter(function12, "onPreview");
            this.binding = traeMediaChooseItemMediaBinding;
            this.onToggleSelect = function1;
            this.onPreview = function12;
            this.enablePreview = z;
        }

        public final void bind(final MediaItem item, MediaSelection selection, final int indexInMediaList) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.ivThumb.setImageURI(item.getUri());
            if (item.isVideo() && item.getDurationMs() > 0) {
                this.binding.tvDuration.setVisibility(0);
                this.binding.tvDuration.setText(formatDuration(item.getDurationMs()));
            } else {
                this.binding.tvDuration.setVisibility(8);
            }
            String orderText = selection != null ? selection.getOrderText(item.getId()) : null;
            if (orderText == null) {
                orderText = "";
            }
            String str = orderText;
            this.binding.selectionContainer.setSelected(str.length() > 0);
            this.binding.tvOrder.setText(str);
            final boolean z = selection != null && selection.isDisabled(item);
            this.binding.vMask.setVisibility(z ? 0 : 8);
            this.binding.selectionContainer.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaGridAdapter.MediaViewHolder.bind$lambda$0(z, this, item, view);
                }
            });
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.MediaGridAdapter$MediaViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MediaGridAdapter.MediaViewHolder.bind$lambda$1(MediaGridAdapter.MediaViewHolder.this, indexInMediaList, z, item, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(boolean z, MediaViewHolder mediaViewHolder, MediaItem mediaItem, View view) {
            if (z) {
                return;
            }
            mediaViewHolder.onToggleSelect.invoke(mediaItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(MediaViewHolder mediaViewHolder, int i, boolean z, MediaItem mediaItem, View view) {
            if (mediaViewHolder.enablePreview) {
                mediaViewHolder.onPreview.invoke(Integer.valueOf(i));
            } else {
                if (z) {
                    return;
                }
                mediaViewHolder.onToggleSelect.invoke(mediaItem);
            }
        }

        private final String formatDuration(long durationMs) {
            long j = durationMs / 1000;
            long j2 = 60;
            String format = String.format("%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / j2), Long.valueOf(j % j2)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaGridAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;", "", "Camera", "Media", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface GridItem {

        /* compiled from: MediaGridAdapter.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Camera;", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Camera implements GridItem {
            public static final Camera INSTANCE = new Camera();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Camera)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 289243689;
            }

            public String toString() {
                return "Camera";
            }

            private Camera() {
            }
        }

        /* compiled from: MediaGridAdapter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem$Media;", "Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter$GridItem;", "item", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "<init>", "(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)V", "getItem", "()Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Media implements GridItem {
            private final MediaItem item;

            public static /* synthetic */ Media copy$default(Media media, MediaItem mediaItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    mediaItem = media.item;
                }
                return media.copy(mediaItem);
            }

            /* renamed from: component1, reason: from getter */
            public final MediaItem getItem() {
                return this.item;
            }

            public final Media copy(MediaItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new Media(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Media) && Intrinsics.areEqual(this.item, ((Media) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "Media(item=" + this.item + ')';
            }

            public Media(MediaItem mediaItem) {
                Intrinsics.checkNotNullParameter(mediaItem, "item");
                this.item = mediaItem;
            }

            public final MediaItem getItem() {
                return this.item;
            }
        }
    }
}
