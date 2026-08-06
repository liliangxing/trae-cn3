package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BottomSheetSkillsBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final LinearLayout errorContainer;
    public final EditText etSearch;
    public final ImageView ivSearchClear;
    public final ImageView ivSearchIcon;
    public final LinearLayout loadingContainer;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final FrameLayout searchContainer;
    public final TraeTitleBar titleBar;
    public final TextView tvEmptyState;
    public final TextView tvErrorContent;

    private BottomSheetSkillsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ImageView imageView, ImageView imageView2, LinearLayout linearLayout3, RecyclerView recyclerView, FrameLayout frameLayout, TraeTitleBar traeTitleBar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.contentContainer = linearLayout;
        this.errorContainer = linearLayout2;
        this.etSearch = editText;
        this.ivSearchClear = imageView;
        this.ivSearchIcon = imageView2;
        this.loadingContainer = linearLayout3;
        this.recyclerView = recyclerView;
        this.searchContainer = frameLayout;
        this.titleBar = traeTitleBar;
        this.tvEmptyState = textView;
        this.tvErrorContent = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetSkillsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetSkillsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.bottom_sheet_skills, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetSkillsBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.content_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.error_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = C0637R.id.et_search;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = C0637R.id.iv_search_clear;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = C0637R.id.iv_search_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = C0637R.id.loading_container;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.recycler_view))) != null) {
                                i = C0637R.id.search_container;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = C0637R.id.title_bar;
                                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                    if (traeTitleBar != null) {
                                        i = C0637R.id.tv_empty_state;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = C0637R.id.tv_error_content;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new BottomSheetSkillsBinding((ConstraintLayout) view, linearLayout, linearLayout2, editText, imageView, imageView2, linearLayout3, findChildViewById, frameLayout, traeTitleBar, textView, textView2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
