package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class DialogEditNameBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnSave;
    public final EditText etName;
    private final LinearLayout rootView;
    public final TextView tvCharCount;

    private DialogEditNameBinding(LinearLayout linearLayout, TextView textView, TextView textView2, EditText editText, TextView textView3) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnSave = textView2;
        this.etName = editText;
        this.tvCharCount = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogEditNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogEditNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_edit_name, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogEditNameBinding bind(View view) {
        int i = R.id.btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_save;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.et_name;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.tv_char_count;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new DialogEditNameBinding((LinearLayout) view, textView, textView2, editText, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
