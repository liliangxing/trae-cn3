package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DialogChatAttachmentBinding implements ViewBinding {
    public final LinearLayout container;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;

    private DialogChatAttachmentBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.container = linearLayout2;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogChatAttachmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogChatAttachmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.dialog_chat_attachment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogChatAttachmentBinding bind(View view) {
        int i = C0637R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                return new DialogChatAttachmentBinding((LinearLayout) view, linearLayout, traeTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
