package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.C0820R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentEditAvatarBinding implements ViewBinding {
    public final ConstraintLayout bottomButtonsContainer;
    public final TextView btnCancel;
    public final TextView btnOk;
    public final SimpleDraweeView ivAvatarPreview;
    private final ConstraintLayout rootView;

    private FragmentEditAvatarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, SimpleDraweeView simpleDraweeView) {
        this.rootView = constraintLayout;
        this.bottomButtonsContainer = constraintLayout2;
        this.btnCancel = textView;
        this.btnOk = textView2;
        this.ivAvatarPreview = simpleDraweeView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEditAvatarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEditAvatarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_edit_avatar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentEditAvatarBinding bind(View view) {
        SimpleDraweeView findChildViewById;
        int i = C0820R.id.bottom_buttons_container;
        ConstraintLayout findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = C0820R.id.btn_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0820R.id.btn_ok;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.iv_avatar_preview))) != null) {
                    return new FragmentEditAvatarBinding((ConstraintLayout) view, findChildViewById2, textView, textView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
