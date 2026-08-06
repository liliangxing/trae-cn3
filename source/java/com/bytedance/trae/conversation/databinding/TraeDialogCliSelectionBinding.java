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
public final class TraeDialogCliSelectionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView rvClis;
    public final TextView tvTitle;

    private TraeDialogCliSelectionBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.rvClis = recyclerView;
        this.tvTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogCliSelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogCliSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_cli_selection, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogCliSelectionBinding bind(View view) {
        int i = C0637R.id.rv_clis;
        RecyclerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new TraeDialogCliSelectionBinding((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
