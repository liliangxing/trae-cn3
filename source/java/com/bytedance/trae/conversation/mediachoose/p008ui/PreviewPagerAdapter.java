package com.bytedance.trae.conversation.mediachoose.p008ui;

import android.media.MediaPlayer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseItemPreviewPageBinding;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.p008ui.PreviewPagerAdapter;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewPagerAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u00020\u000e2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0014\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0016\u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;", "items", "", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "<init>", "(Ljava/util/List;)V", "videoViews", "Landroid/util/SparseArray;", "Landroid/widget/VideoView;", "currentIndex", "", "onPageSelected", "", "index", "stopCurrentVideo", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", NewTaskTracker.Param.POSITION, "onViewRecycled", "getItemCount", "playVideoIfNeeded", "PageViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewPagerAdapter extends RecyclerView.Adapter<PageViewHolder> {
    private int currentIndex;
    private final List<MediaItem> items;
    private final SparseArray<VideoView> videoViews;

    public PreviewPagerAdapter(List<MediaItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.videoViews = new SparseArray<>();
        this.currentIndex = -1;
    }

    public final void onPageSelected(int index) {
        this.currentIndex = index;
        playVideoIfNeeded(index);
    }

    public final void stopCurrentVideo() {
        VideoView videoView = this.videoViews.get(this.currentIndex);
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }

    public PageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        TraeMediaChooseItemPreviewPageBinding inflate = TraeMediaChooseItemPreviewPageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PageViewHolder(this, inflate);
    }

    public void onBindViewHolder(PageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position), position);
    }

    public void onViewRecycled(PageViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.stopVideo();
    }

    public int getItemCount() {
        return this.items.size();
    }

    /* compiled from: PreviewPagerAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter$PageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;", "<init>", "(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemPreviewPageBinding;)V", "bind", "", "item", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", NewTaskTracker.Param.POSITION, "", "stopVideo", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class PageViewHolder extends RecyclerView.ViewHolder {
        private final TraeMediaChooseItemPreviewPageBinding binding;
        final /* synthetic */ PreviewPagerAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageViewHolder(PreviewPagerAdapter previewPagerAdapter, TraeMediaChooseItemPreviewPageBinding traeMediaChooseItemPreviewPageBinding) {
            super(traeMediaChooseItemPreviewPageBinding.getRoot());
            Intrinsics.checkNotNullParameter(traeMediaChooseItemPreviewPageBinding, "binding");
            this.this$0 = previewPagerAdapter;
            this.binding = traeMediaChooseItemPreviewPageBinding;
        }

        public final void bind(MediaItem item, final int position) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.isVideo()) {
                this.binding.videoView.setVisibility(0);
                this.binding.ivImage.setVisibility(8);
                final VideoView videoView = this.binding.videoView;
                Intrinsics.checkNotNullExpressionValue(videoView, "videoView");
                this.this$0.videoViews.put(position, videoView);
                videoView.setVideoURI(item.getUri());
                videoView.setMediaController(new MediaController(videoView.getContext()));
                final PreviewPagerAdapter previewPagerAdapter = this.this$0;
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bytedance.trae.conversation.mediachoose.ui.PreviewPagerAdapter$PageViewHolder$$ExternalSyntheticLambda0
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        PreviewPagerAdapter.PageViewHolder.bind$lambda$0(position, previewPagerAdapter, videoView, mediaPlayer);
                    }
                });
                return;
            }
            this.binding.videoView.setVisibility(8);
            this.binding.ivImage.setVisibility(0);
            this.binding.ivImage.setImageURI(item.getUri());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(int i, PreviewPagerAdapter previewPagerAdapter, VideoView videoView, MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(true);
            if (i == previewPagerAdapter.currentIndex) {
                videoView.start();
            } else {
                mediaPlayer.pause();
                mediaPlayer.seekTo(1);
            }
        }

        public final void stopVideo() {
            this.binding.videoView.stopPlayback();
        }
    }

    private final void playVideoIfNeeded(int index) {
        int size = this.videoViews.size();
        for (int i = 0; i < size; i++) {
            this.videoViews.valueAt(i).stopPlayback();
        }
        VideoView videoView = this.videoViews.get(index);
        if (videoView != null) {
            videoView.start();
        }
    }
}
