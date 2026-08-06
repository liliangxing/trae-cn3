package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class ItemDirectoryNodeEditingBinding implements ViewBinding {
    public final EditText etFolderName;
    public final ImageView ivIconEditing;
    public final ProgressBar progressCreating;
    private final LinearLayout rootView;
    public final View viewIndentEditing;

    private ItemDirectoryNodeEditingBinding(LinearLayout linearLayout, EditText editText, ImageView imageView, ProgressBar progressBar, View view) {
        this.rootView = linearLayout;
        this.etFolderName = editText;
        this.ivIconEditing = imageView;
        this.progressCreating = progressBar;
        this.viewIndentEditing = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemDirectoryNodeEditingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDirectoryNodeEditingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_directory_node_editing, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDirectoryNodeEditingBinding bind(View view) {
        View findChildViewById;
        int i = R.id.et_folder_name;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.iv_icon_editing;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.progress_creating;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_indent_editing))) != null) {
                    return new ItemDirectoryNodeEditingBinding((LinearLayout) view, editText, imageView, progressBar, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
