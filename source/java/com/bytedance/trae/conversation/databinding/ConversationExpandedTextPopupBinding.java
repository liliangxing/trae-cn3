package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class ConversationExpandedTextPopupBinding implements ViewBinding {
    public final View dividerDelete;
    public final View dividerRevert;
    public final LinearLayout llMenuContainer;
    public final LinearLayout menuCopy;
    public final LinearLayout menuDelete;
    public final LinearLayout menuRevert;
    private final FrameLayout rootView;
    public final ScrollView svTextContent;
    public final TextView tvFullText;

    private ConversationExpandedTextPopupBinding(FrameLayout frameLayout, View view, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ScrollView scrollView, TextView textView) {
        this.rootView = frameLayout;
        this.dividerDelete = view;
        this.dividerRevert = view2;
        this.llMenuContainer = linearLayout;
        this.menuCopy = linearLayout2;
        this.menuDelete = linearLayout3;
        this.menuRevert = linearLayout4;
        this.svTextContent = scrollView;
        this.tvFullText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConversationExpandedTextPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConversationExpandedTextPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.conversation_expanded_text_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConversationExpandedTextPopupBinding bind(View view) {
        View findChildViewById;
        int i = R.id.divider_delete;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider_revert))) != null) {
            i = R.id.ll_menu_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.menu_copy;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.menu_delete;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.menu_revert;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout4 != null) {
                            i = R.id.sv_text_content;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.tv_full_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new ConversationExpandedTextPopupBinding((FrameLayout) view, findChildViewById2, findChildViewById, linearLayout, linearLayout2, linearLayout3, linearLayout4, scrollView, textView);
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
