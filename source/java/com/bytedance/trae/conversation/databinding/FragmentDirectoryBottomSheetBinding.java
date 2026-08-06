package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentDirectoryBottomSheetBinding implements ViewBinding {
    public final FrameLayout bottomActionContainer;
    public final Button btnAddFolder;
    public final FrameLayout directoryContentContainer;
    public final ProgressBar progressLoading;
    private final LinearLayout rootView;
    public final RecyclerView rvDirectory;
    public final TraeTitleBar titleBar;
    public final TextView tvEmptyState;

    private FragmentDirectoryBottomSheetBinding(LinearLayout linearLayout, FrameLayout frameLayout, Button button, FrameLayout frameLayout2, ProgressBar progressBar, RecyclerView recyclerView, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = linearLayout;
        this.bottomActionContainer = frameLayout;
        this.btnAddFolder = button;
        this.directoryContentContainer = frameLayout2;
        this.progressLoading = progressBar;
        this.rvDirectory = recyclerView;
        this.titleBar = traeTitleBar;
        this.tvEmptyState = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDirectoryBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDirectoryBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.fragment_directory_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDirectoryBottomSheetBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.bottom_action_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.btn_add_folder;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = C0637R.id.directory_content_container;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = C0637R.id.progress_loading;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_directory))) != null) {
                        i = C0637R.id.title_bar;
                        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                        if (traeTitleBar != null) {
                            i = C0637R.id.tv_empty_state;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new FragmentDirectoryBottomSheetBinding((LinearLayout) view, frameLayout, button, frameLayout2, progressBar, findChildViewById, traeTitleBar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
