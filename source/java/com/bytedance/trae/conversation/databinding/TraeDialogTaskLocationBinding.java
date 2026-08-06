package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogTaskLocationBinding implements ViewBinding {
    public final LinearLayout btnAddDevice;
    public final ConstraintLayout contentContainer;
    public final ProgressBar progressLoading;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDevices;
    public final TraeTitleBar titleBar;

    private TraeDialogTaskLocationBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = constraintLayout;
        this.btnAddDevice = linearLayout;
        this.contentContainer = constraintLayout2;
        this.progressLoading = progressBar;
        this.rvDevices = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogTaskLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogTaskLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_task_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogTaskLocationBinding bind(View view) {
        ConstraintLayout findChildViewById;
        RecyclerView findChildViewById2;
        int i = C0637R.id.btn_add_device;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.content_container))) != null) {
            i = C0637R.id.progress_loading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_devices))) != null) {
                i = C0637R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                if (traeTitleBar != null) {
                    return new TraeDialogTaskLocationBinding((ConstraintLayout) view, linearLayout, findChildViewById, progressBar, findChildViewById2, traeTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
