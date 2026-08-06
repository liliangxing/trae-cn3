package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.widget.ShimmerTextView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemToolListBinding implements ViewBinding {
    public final FrameLayout flContent;
    public final ImageView ivChevronRight;
    public final ImageView ivIcon;
    public final LinearLayout llBody;
    public final LinearLayout llHeader;
    private final LinearLayout rootView;
    public final TextView tvBadge;
    public final TextView tvIconEmoji;
    public final TextView tvSubtitle;
    public final ShimmerTextView tvTitle;
    public final View vVerticalLine;

    private TraeItemToolListBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, ShimmerTextView shimmerTextView, View view) {
        this.rootView = linearLayout;
        this.flContent = frameLayout;
        this.ivChevronRight = imageView;
        this.ivIcon = imageView2;
        this.llBody = linearLayout2;
        this.llHeader = linearLayout3;
        this.tvBadge = textView;
        this.tvIconEmoji = textView2;
        this.tvSubtitle = textView3;
        this.tvTitle = shimmerTextView;
        this.vVerticalLine = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemToolListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemToolListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_tool_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemToolListBinding bind(View view) {
        View findChildViewById;
        int i = C0637R.id.fl_content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.iv_chevron_right;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0637R.id.iv_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = C0637R.id.ll_body;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C0637R.id.ll_header;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = C0637R.id.tv_badge;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = C0637R.id.tv_icon_emoji;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = C0637R.id.tv_subtitle;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = C0637R.id.tv_title;
                                        ShimmerTextView shimmerTextView = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
                                        if (shimmerTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.v_vertical_line))) != null) {
                                            return new TraeItemToolListBinding((LinearLayout) view, frameLayout, imageView, imageView2, linearLayout, linearLayout2, textView, textView2, textView3, shimmerTextView, findChildViewById);
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
