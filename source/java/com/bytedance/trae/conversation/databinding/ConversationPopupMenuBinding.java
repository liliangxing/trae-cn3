package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class ConversationPopupMenuBinding implements ViewBinding {
    public final ImageView ivMenuPin;
    public final LinearLayout menuArtifact;
    public final LinearLayout menuDelete;
    public final View menuDividerArtifact;
    public final View menuDividerPin;
    public final LinearLayout menuPin;
    public final LinearLayout menuRename;
    private final LinearLayout rootView;
    public final TextView tvMenuPin;

    private ConversationPopupMenuBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, View view2, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView) {
        this.rootView = linearLayout;
        this.ivMenuPin = imageView;
        this.menuArtifact = linearLayout2;
        this.menuDelete = linearLayout3;
        this.menuDividerArtifact = view;
        this.menuDividerPin = view2;
        this.menuPin = linearLayout4;
        this.menuRename = linearLayout5;
        this.tvMenuPin = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConversationPopupMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConversationPopupMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.conversation_popup_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConversationPopupMenuBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.iv_menu_pin;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.menu_artifact;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.menu_delete;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.menu_divider_artifact))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.menu_divider_pin))) != null) {
                    i = R.id.menu_pin;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.menu_rename;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout4 != null) {
                            i = R.id.tv_menu_pin;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ConversationPopupMenuBinding((LinearLayout) view, imageView, linearLayout, linearLayout2, findChildViewById, findChildViewById2, linearLayout3, linearLayout4, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
