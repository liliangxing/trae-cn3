package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemCheckpointInputBinding implements ViewBinding {
    public final FrameLayout btnCustomSend;
    public final FrameLayout checkboxContainer;
    public final EditText etCustomAnswer;
    public final ImageView ivCheck;
    public final ImageView ivCustomEdit;
    public final ImageView ivCustomSend;
    public final LinearLayout optionRoot;
    private final LinearLayout rootView;

    private TraeItemCheckpointInputBinding(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btnCustomSend = frameLayout;
        this.checkboxContainer = frameLayout2;
        this.etCustomAnswer = editText;
        this.ivCheck = imageView;
        this.ivCustomEdit = imageView2;
        this.ivCustomSend = imageView3;
        this.optionRoot = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemCheckpointInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemCheckpointInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_checkpoint_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemCheckpointInputBinding bind(View view) {
        int i = R.id.btn_custom_send;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.checkbox_container;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = R.id.et_custom_answer;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.iv_check;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_custom_edit;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv_custom_send;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.option_root;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    return new TraeItemCheckpointInputBinding((LinearLayout) view, frameLayout, frameLayout2, editText, imageView, imageView2, imageView3, linearLayout);
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
