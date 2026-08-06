package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeMediaChooseItemPreviewPageBinding implements ViewBinding {
    public final SimpleDraweeView ivImage;
    private final FrameLayout rootView;
    public final VideoView videoView;

    private TraeMediaChooseItemPreviewPageBinding(FrameLayout frameLayout, SimpleDraweeView simpleDraweeView, VideoView videoView) {
        this.rootView = frameLayout;
        this.ivImage = simpleDraweeView;
        this.videoView = videoView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeMediaChooseItemPreviewPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeMediaChooseItemPreviewPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_media_choose_item_preview_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeMediaChooseItemPreviewPageBinding bind(View view) {
        int i = C0637R.id.iv_image;
        SimpleDraweeView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.video_view;
            VideoView videoView = (VideoView) ViewBindings.findChildViewById(view, i);
            if (videoView != null) {
                return new TraeMediaChooseItemPreviewPageBinding((FrameLayout) view, findChildViewById, videoView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
