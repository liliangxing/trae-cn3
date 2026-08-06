package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemAttachmentBinding implements ViewBinding {
    public final ImageView btnRemove;
    public final FrameLayout fileInfoOverlay;
    public final SimpleDraweeView ivAttachment;
    public final FrameLayout overlayFailed;
    public final FrameLayout overlayLoading;
    private final FrameLayout rootView;
    public final TextView tvExtBadge;
    public final TextView tvFileName;

    private TraeItemAttachmentBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, SimpleDraweeView simpleDraweeView, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnRemove = imageView;
        this.fileInfoOverlay = frameLayout2;
        this.ivAttachment = simpleDraweeView;
        this.overlayFailed = frameLayout3;
        this.overlayLoading = frameLayout4;
        this.tvExtBadge = textView;
        this.tvFileName = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemAttachmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemAttachmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_attachment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemAttachmentBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        int i = C0637R.id.btn_remove;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.file_info_overlay;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.iv_attachment))) != null) {
                i = C0637R.id.overlay_failed;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = C0637R.id.overlay_loading;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout3 != null) {
                        i = C0637R.id.tv_ext_badge;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C0637R.id.tv_file_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new TraeItemAttachmentBinding((FrameLayout) view, imageView, frameLayout, findChildViewById, frameLayout2, frameLayout3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
