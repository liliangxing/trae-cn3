package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeMediaChooseFragmentBinding implements ViewBinding {
    public final LinearLayout bottomBar;
    public final TextView btnPreview;
    public final TextView btnSend;
    public final CheckBox cbOrigin;
    public final TextView partialPermissionNotice;
    private final LinearLayout rootView;

    /* renamed from: rv */
    public final RecyclerView f1300rv;
    public final TraeTitleBar titleBar;

    private TraeMediaChooseFragmentBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, CheckBox checkBox, TextView textView3, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.bottomBar = linearLayout2;
        this.btnPreview = textView;
        this.btnSend = textView2;
        this.cbOrigin = checkBox;
        this.partialPermissionNotice = textView3;
        this.f1300rv = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeMediaChooseFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeMediaChooseFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_media_choose_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeMediaChooseFragmentBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.bottom_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.btn_preview;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0637R.id.btn_send;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = C0637R.id.cb_origin;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                    if (checkBox != null) {
                        i = C0637R.id.partial_permission_notice;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.f1281rv))) != null) {
                            i = C0637R.id.title_bar;
                            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                            if (traeTitleBar != null) {
                                return new TraeMediaChooseFragmentBinding((LinearLayout) view, linearLayout, textView, textView2, checkBox, textView3, findChildViewById, traeTitleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
