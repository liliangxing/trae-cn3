package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemChatImageBinding implements ViewBinding {
    public final SimpleDraweeView ivAttachment;
    private final SimpleDraweeView rootView;

    private TraeItemChatImageBinding(SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2) {
        this.rootView = simpleDraweeView;
        this.ivAttachment = simpleDraweeView2;
    }

    public SimpleDraweeView getRoot() {
        return this.rootView;
    }

    public static TraeItemChatImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemChatImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_chat_image, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemChatImageBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        return new TraeItemChatImageBinding(simpleDraweeView, simpleDraweeView);
    }
}
