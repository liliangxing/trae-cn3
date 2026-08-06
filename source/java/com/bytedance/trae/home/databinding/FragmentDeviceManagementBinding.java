package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentDeviceManagementBinding implements ViewBinding {
    public final TextView btnAddDevice;
    public final FrameLayout emptyGuideContent;
    public final View indicatorEmptyGuideIde;
    public final View indicatorEmptyGuideWork;
    public final LinearLayout layoutEmptyGuide;
    public final LinearLayout layoutEmptyGuideTabs;
    public final ProgressBar progressLoading;
    private final LinearLayout rootView;
    public final RecyclerView rvDeviceManagement;
    public final LinearLayout tabEmptyGuideIde;
    public final LinearLayout tabEmptyGuideWork;
    public final TraeTitleBar titleBar;
    public final TextView tvEmptyGuideIdeTab;
    public final TextView tvEmptyGuideWorkTab;

    private FragmentDeviceManagementBinding(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, View view, View view2, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, RecyclerView recyclerView, LinearLayout linearLayout4, LinearLayout linearLayout5, TraeTitleBar traeTitleBar, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnAddDevice = textView;
        this.emptyGuideContent = frameLayout;
        this.indicatorEmptyGuideIde = view;
        this.indicatorEmptyGuideWork = view2;
        this.layoutEmptyGuide = linearLayout2;
        this.layoutEmptyGuideTabs = linearLayout3;
        this.progressLoading = progressBar;
        this.rvDeviceManagement = recyclerView;
        this.tabEmptyGuideIde = linearLayout4;
        this.tabEmptyGuideWork = linearLayout5;
        this.titleBar = traeTitleBar;
        this.tvEmptyGuideIdeTab = textView2;
        this.tvEmptyGuideWorkTab = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeviceManagementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeviceManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_device_management, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeviceManagementBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        RecyclerView findChildViewById3;
        int i = C0820R.id.btn_add_device;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0820R.id.empty_guide_content;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.indicator_empty_guide_ide))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.indicator_empty_guide_work))) != null) {
                i = C0820R.id.layout_empty_guide;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C0820R.id.layout_empty_guide_tabs;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = C0820R.id.progress_loading;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0820R.id.rv_device_management))) != null) {
                            i = C0820R.id.tab_empty_guide_ide;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = C0820R.id.tab_empty_guide_work;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout4 != null) {
                                    i = C0820R.id.title_bar;
                                    TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                    if (traeTitleBar != null) {
                                        i = C0820R.id.tv_empty_guide_ide_tab;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = C0820R.id.tv_empty_guide_work_tab;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                return new FragmentDeviceManagementBinding((LinearLayout) view, textView, frameLayout, findChildViewById, findChildViewById2, linearLayout, linearLayout2, progressBar, findChildViewById3, linearLayout3, linearLayout4, traeTitleBar, textView2, textView3);
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
