package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogIdeProjectBinding implements ViewBinding {
    public final LinearLayout layoutEmpty;
    public final ProgressBar progressLoading;
    private final LinearLayout rootView;
    public final RecyclerView rvProjects;
    public final TraeTitleBar titleBar;
    public final TextView tvEmpty;
    public final TextView tvFooterHint;

    private TraeDialogIdeProjectBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView, TraeTitleBar traeTitleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.layoutEmpty = linearLayout2;
        this.progressLoading = progressBar;
        this.rvProjects = recyclerView;
        this.titleBar = traeTitleBar;
        this.tvEmpty = textView;
        this.tvFooterHint = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogIdeProjectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogIdeProjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_ide_project, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogIdeProjectBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.layout_empty;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.progress_loading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_projects))) != null) {
                i = C0637R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                if (traeTitleBar != null) {
                    i = C0637R.id.tv_empty;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = C0637R.id.tv_footer_hint;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new TraeDialogIdeProjectBinding((LinearLayout) view, linearLayout, progressBar, findChildViewById, traeTitleBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
