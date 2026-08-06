package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogCodeDeviceSelectBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    public final ProgressBar progressLoading;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDevices;
    public final TraeTitleBar titleBar;

    private TraeDialogCodeDeviceSelectBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = constraintLayout;
        this.contentContainer = constraintLayout2;
        this.progressLoading = progressBar;
        this.rvDevices = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogCodeDeviceSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogCodeDeviceSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_code_device_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogCodeDeviceSelectBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.content_container;
        ConstraintLayout findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = C0637R.id.progress_loading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_devices))) != null) {
                i = C0637R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                if (traeTitleBar != null) {
                    return new TraeDialogCodeDeviceSelectBinding((ConstraintLayout) view, findChildViewById2, progressBar, findChildViewById, traeTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
