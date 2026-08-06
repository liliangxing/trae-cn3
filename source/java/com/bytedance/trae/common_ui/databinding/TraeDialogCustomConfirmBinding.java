package com.bytedance.trae.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common_ui.R;

/* loaded from: classes5.dex */
public final class TraeDialogCustomConfirmBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    public final LinearLayout customConfirmDialogRoot;
    public final EditText etInput;
    public final LinearLayout llButtons;
    private final LinearLayout rootView;
    public final TextView tvDialogTitle;
    public final TextView tvMessage;
    public final View vButtonSpacer;

    private TraeDialogCustomConfirmBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, EditText editText, LinearLayout linearLayout3, TextView textView3, TextView textView4, View view) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.customConfirmDialogRoot = linearLayout2;
        this.etInput = editText;
        this.llButtons = linearLayout3;
        this.tvDialogTitle = textView3;
        this.tvMessage = textView4;
        this.vButtonSpacer = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogCustomConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogCustomConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_dialog_custom_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogCustomConfirmBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_confirm;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.et_input;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.ll_buttons;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.tv_dialog_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tv_message;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_button_spacer))) != null) {
                                return new TraeDialogCustomConfirmBinding(linearLayout, textView, textView2, linearLayout, editText, linearLayout2, textView3, textView4, findChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
