package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogDocumentSelectBinding implements ViewBinding {
    public final ConstraintLayout bottomSheetContainer;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDocuments;
    public final TraeTitleBar titleBar;

    private TraeDialogDocumentSelectBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = constraintLayout;
        this.bottomSheetContainer = constraintLayout2;
        this.rvDocuments = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogDocumentSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogDocumentSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_document_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogDocumentSelectBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.bottom_sheet_container;
        ConstraintLayout findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_documents))) != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                return new TraeDialogDocumentSelectBinding((ConstraintLayout) view, findChildViewById2, findChildViewById, traeTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
