package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentConnectorsBinding implements ViewBinding {
    public final LinearLayout cardGithub;
    public final LinearLayout cardManageGithub;
    public final View dividerGithub;
    private final LinearLayout rootView;
    public final SwitchCompat switchGithub;
    public final TraeTitleBar titleBar;
    public final TextView tvGithubTitle;

    private FragmentConnectorsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, SwitchCompat switchCompat, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = linearLayout;
        this.cardGithub = linearLayout2;
        this.cardManageGithub = linearLayout3;
        this.dividerGithub = view;
        this.switchGithub = switchCompat;
        this.titleBar = traeTitleBar;
        this.tvGithubTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentConnectorsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentConnectorsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_connectors, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentConnectorsBinding bind(View view) {
        View findChildViewById;
        SwitchCompat findChildViewById2;
        int i = C0820R.id.card_github;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0820R.id.card_manage_github;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_github))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.switch_github))) != null) {
                i = C0820R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                if (traeTitleBar != null) {
                    i = C0820R.id.tv_github_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new FragmentConnectorsBinding((LinearLayout) view, linearLayout, linearLayout2, findChildViewById, findChildViewById2, traeTitleBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
