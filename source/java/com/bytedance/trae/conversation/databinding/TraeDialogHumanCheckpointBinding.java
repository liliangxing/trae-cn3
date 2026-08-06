package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeDialogHumanCheckpointBinding implements ViewBinding {
    public final LinearLayout actionGroup;
    public final TextView btnCancel;
    public final FrameLayout btnClose;
    public final FrameLayout btnHeaderNext;
    public final FrameLayout btnHeaderPrev;
    public final TextView btnNext;
    public final TextView btnPrev;
    public final CardView cardContainer;
    public final LinearLayout header;
    public final LinearLayout headerNavGroup;
    public final ImageView ivHeaderNext;
    public final ImageView ivHeaderPrev;
    public final LinearLayout normalContent;
    private final NestedScrollView rootView;
    public final RecyclerView rvOptions;
    public final NestedScrollView titleScrollView;
    public final TextView tvProgress;
    public final TextView tvQuestion;

    private TraeDialogHumanCheckpointBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, TextView textView2, TextView textView3, CardView cardView, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout4, RecyclerView recyclerView, NestedScrollView nestedScrollView2, TextView textView4, TextView textView5) {
        this.rootView = nestedScrollView;
        this.actionGroup = linearLayout;
        this.btnCancel = textView;
        this.btnClose = frameLayout;
        this.btnHeaderNext = frameLayout2;
        this.btnHeaderPrev = frameLayout3;
        this.btnNext = textView2;
        this.btnPrev = textView3;
        this.cardContainer = cardView;
        this.header = linearLayout2;
        this.headerNavGroup = linearLayout3;
        this.ivHeaderNext = imageView;
        this.ivHeaderPrev = imageView2;
        this.normalContent = linearLayout4;
        this.rvOptions = recyclerView;
        this.titleScrollView = nestedScrollView2;
        this.tvProgress = textView4;
        this.tvQuestion = textView5;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeDialogHumanCheckpointBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogHumanCheckpointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_dialog_human_checkpoint, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogHumanCheckpointBinding bind(View view) {
        CardView findChildViewById;
        RecyclerView findChildViewById2;
        NestedScrollView findChildViewById3;
        int i = C0637R.id.action_group;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.btn_cancel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C0637R.id.btn_close;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = C0637R.id.btn_header_next;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = C0637R.id.btn_header_prev;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout3 != null) {
                            i = C0637R.id.btn_next;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = C0637R.id.btn_prev;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.card_container))) != null) {
                                    i = C0637R.id.header;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = C0637R.id.header_nav_group;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = C0637R.id.iv_header_next;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = C0637R.id.iv_header_prev;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    i = C0637R.id.normal_content;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout4 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_options))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = C0637R.id.title_scroll_view))) != null) {
                                                        i = C0637R.id.tv_progress;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = C0637R.id.tv_question;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                return new TraeDialogHumanCheckpointBinding((NestedScrollView) view, linearLayout, textView, frameLayout, frameLayout2, frameLayout3, textView2, textView3, findChildViewById, linearLayout2, linearLayout3, imageView, imageView2, linearLayout4, findChildViewById2, findChildViewById3, textView4, textView5);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
