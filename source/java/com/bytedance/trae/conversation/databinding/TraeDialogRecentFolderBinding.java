package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogRecentFolderBinding implements ViewBinding {
    public final Button btnSelectOtherFolder;
    public final ImageView layoutEmpty;
    private final LinearLayout rootView;
    public final RecyclerView rvRecentFolders;
    public final TraeTitleBar titleBar;

    private TraeDialogRecentFolderBinding(LinearLayout linearLayout, Button button, ImageView imageView, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.btnSelectOtherFolder = button;
        this.layoutEmpty = imageView;
        this.rvRecentFolders = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogRecentFolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogRecentFolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_recent_folder, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogRecentFolderBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_select_other_folder;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C0637R.id.layout_empty;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_recent_folders))) != null) {
                i = C0637R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                if (traeTitleBar != null) {
                    return new TraeDialogRecentFolderBinding((LinearLayout) view, button, imageView, findChildViewById, traeTitleBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
