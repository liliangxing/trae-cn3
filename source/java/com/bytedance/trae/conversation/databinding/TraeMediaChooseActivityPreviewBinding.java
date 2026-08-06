package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeMediaChooseActivityPreviewBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final ImageView btnBack;
    public final TextView btnSend;
    public final CheckBox cbOrigin;
    public final ViewPager2 pager;
    private final ConstraintLayout rootView;
    public final FrameLayout selectionContainer;
    public final ConstraintLayout topBar;
    public final TextView tvOrder;

    private TraeMediaChooseActivityPreviewBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, TextView textView, CheckBox checkBox, ViewPager2 viewPager2, FrameLayout frameLayout, ConstraintLayout constraintLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.bottomBar = linearLayout;
        this.btnBack = imageView;
        this.btnSend = textView;
        this.cbOrigin = checkBox;
        this.pager = viewPager2;
        this.selectionContainer = frameLayout;
        this.topBar = constraintLayout2;
        this.tvOrder = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeMediaChooseActivityPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeMediaChooseActivityPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_media_choose_activity_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeMediaChooseActivityPreviewBinding bind(View view) {
        ViewPager2 findChildViewById;
        ConstraintLayout findChildViewById2;
        int i = C0637R.id.bottom_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.btn_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.btn_send;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.cb_origin;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                    if (checkBox != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.pager))) != null) {
                        i = C0637R.id.selection_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.top_bar))) != null) {
                            i = C0637R.id.tv_order;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new TraeMediaChooseActivityPreviewBinding((ConstraintLayout) view, linearLayout, imageView, textView, checkBox, findChildViewById, frameLayout, findChildViewById2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
