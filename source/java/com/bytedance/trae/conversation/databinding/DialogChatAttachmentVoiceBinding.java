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
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class DialogChatAttachmentVoiceBinding implements ViewBinding {
    public final LinearLayout btnCamera;
    public final ImageView btnClose;
    public final LinearLayout btnFiles;
    public final LinearLayout btnPhoto;
    public final View dragHandle;
    public final FrameLayout header;
    public final LinearLayout optionsGrid;
    private final LinearLayout rootView;
    public final View spacerCameraPhoto;
    public final View spacerPhotoFiles;
    public final TextView tvTitle;

    private DialogChatAttachmentVoiceBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, LinearLayout linearLayout4, View view, FrameLayout frameLayout, LinearLayout linearLayout5, View view2, View view3, TextView textView) {
        this.rootView = linearLayout;
        this.btnCamera = linearLayout2;
        this.btnClose = imageView;
        this.btnFiles = linearLayout3;
        this.btnPhoto = linearLayout4;
        this.dragHandle = view;
        this.header = frameLayout;
        this.optionsGrid = linearLayout5;
        this.spacerCameraPhoto = view2;
        this.spacerPhotoFiles = view3;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogChatAttachmentVoiceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChatAttachmentVoiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_chat_attachment_voice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChatAttachmentVoiceBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.btn_camera;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btn_files;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.btn_photo;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.drag_handle))) != null) {
                        i = R.id.header;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.options_grid;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.spacer_camera_photo))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.spacer_photo_files))) != null) {
                                i = R.id.tv_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new DialogChatAttachmentVoiceBinding((LinearLayout) view, linearLayout, imageView, linearLayout2, linearLayout3, findChildViewById, frameLayout, linearLayout4, findChildViewById2, findChildViewById3, textView);
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
