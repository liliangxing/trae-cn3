package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentSkillsBottomSheetBinding implements ViewBinding {
    public final FrameLayout btnClose;
    public final View indicator;
    private final LinearLayout rootView;
    public final RecyclerView rvSkills;
    public final TextView tvTitle;

    private FragmentSkillsBottomSheetBinding(LinearLayout linearLayout, FrameLayout frameLayout, View view, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.btnClose = frameLayout;
        this.indicator = view;
        this.rvSkills = recyclerView;
        this.tvTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSkillsBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSkillsBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_skills_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSkillsBottomSheetBinding bind(View view) {
        View findChildViewById;
        RecyclerView findChildViewById2;
        int i = C0820R.id.btn_close;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.indicator))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.rv_skills))) != null) {
            i = C0820R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new FragmentSkillsBottomSheetBinding((LinearLayout) view, frameLayout, findChildViewById, findChildViewById2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
