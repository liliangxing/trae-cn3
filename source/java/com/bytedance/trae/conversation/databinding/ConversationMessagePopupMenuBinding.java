package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class ConversationMessagePopupMenuBinding implements ViewBinding {
    public final View dividerDelete;
    public final View dividerRevert;
    public final LinearLayout menuCopy;
    public final LinearLayout menuDelete;
    public final LinearLayout menuRevert;
    private final LinearLayout rootView;

    private ConversationMessagePopupMenuBinding(LinearLayout linearLayout, View view, View view2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.dividerDelete = view;
        this.dividerRevert = view2;
        this.menuCopy = linearLayout2;
        this.menuDelete = linearLayout3;
        this.menuRevert = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConversationMessagePopupMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConversationMessagePopupMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.conversation_message_popup_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConversationMessagePopupMenuBinding bind(View view) {
        View findChildViewById;
        int i = R.id.divider_delete;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider_revert))) != null) {
            i = R.id.menu_copy;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.menu_delete;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.menu_revert;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        return new ConversationMessagePopupMenuBinding((LinearLayout) view, findChildViewById2, findChildViewById, linearLayout, linearLayout2, linearLayout3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
