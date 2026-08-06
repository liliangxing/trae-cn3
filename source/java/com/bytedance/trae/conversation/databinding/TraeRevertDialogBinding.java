package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRevertDialogBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    private final LinearLayout rootView;
    public final RecyclerView rvFileList;
    public final TextView tvDialogTitle;
    public final TextView tvMessage;

    private TraeRevertDialogBinding(LinearLayout linearLayout, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.rvFileList = recyclerView;
        this.tvDialogTitle = textView3;
        this.tvMessage = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeRevertDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeRevertDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_revert_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeRevertDialogBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0637R.id.btn_confirm;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_file_list))) != null) {
                i = C0637R.id.tv_dialog_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = C0637R.id.tv_message;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        return new TraeRevertDialogBinding((LinearLayout) view, textView, textView2, findChildViewById, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
