package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemBrainstormAttachmentBinding implements ViewBinding {
    public final FrameLayout cardAttachment;
    public final ImageView ivAttachClose;
    public final SimpleDraweeView ivAttachPreview;
    public final ImageView ivAttachTypeIcon;
    public final LinearLayout llAttachFileContent;
    public final LinearLayout llAttachNameRow;
    public final FrameLayout overlayAttachFailed;
    public final FrameLayout overlayAttachLoading;
    private final FrameLayout rootView;
    public final TextView tvAttachName;
    public final TextView tvAttachStatus;

    private TraeItemBrainstormAttachmentBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, SimpleDraweeView simpleDraweeView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.cardAttachment = frameLayout2;
        this.ivAttachClose = imageView;
        this.ivAttachPreview = simpleDraweeView;
        this.ivAttachTypeIcon = imageView2;
        this.llAttachFileContent = linearLayout;
        this.llAttachNameRow = linearLayout2;
        this.overlayAttachFailed = frameLayout3;
        this.overlayAttachLoading = frameLayout4;
        this.tvAttachName = textView;
        this.tvAttachStatus = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemBrainstormAttachmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemBrainstormAttachmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_brainstorm_attachment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemBrainstormAttachmentBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        int i = C0637R.id.card_attachment;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.iv_attach_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.iv_attach_preview))) != null) {
                i = C0637R.id.iv_attach_type_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C0637R.id.ll_attach_file_content;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C0637R.id.ll_attach_name_row;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = C0637R.id.overlay_attach_failed;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null) {
                                i = C0637R.id.overlay_attach_loading;
                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout3 != null) {
                                    i = C0637R.id.tv_attach_name;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = C0637R.id.tv_attach_status;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            return new TraeItemBrainstormAttachmentBinding((FrameLayout) view, frameLayout, imageView, findChildViewById, imageView2, linearLayout, linearLayout2, frameLayout2, frameLayout3, textView, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
