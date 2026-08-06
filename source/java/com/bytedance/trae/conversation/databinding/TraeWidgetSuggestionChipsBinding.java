package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeWidgetSuggestionChipsBinding implements ViewBinding {
    public final LinearLayout chipContentCreation;
    public final LinearLayout chipDataMining;
    public final LinearLayout chipWebReading;
    public final ImageView ivContentCreation;
    public final ImageView ivDataMining;
    public final ImageView ivWebReading;
    public final LinearLayout llSuggestionChips;
    private final LinearLayout rootView;
    public final TextView tvContentCreation;
    public final TextView tvDataMining;
    public final TextView tvWebReading;

    private TraeWidgetSuggestionChipsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.chipContentCreation = linearLayout2;
        this.chipDataMining = linearLayout3;
        this.chipWebReading = linearLayout4;
        this.ivContentCreation = imageView;
        this.ivDataMining = imageView2;
        this.ivWebReading = imageView3;
        this.llSuggestionChips = linearLayout5;
        this.tvContentCreation = textView;
        this.tvDataMining = textView2;
        this.tvWebReading = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeWidgetSuggestionChipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeWidgetSuggestionChipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_widget_suggestion_chips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeWidgetSuggestionChipsBinding bind(View view) {
        int i = R.id.chip_content_creation;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.chip_data_mining;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.chip_web_reading;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.iv_content_creation;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_data_mining;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.iv_web_reading;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                LinearLayout linearLayout4 = (LinearLayout) view;
                                i = R.id.tv_content_creation;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_data_mining;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_web_reading;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            return new TraeWidgetSuggestionChipsBinding(linearLayout4, linearLayout, linearLayout2, linearLayout3, imageView, imageView2, imageView3, linearLayout4, textView, textView2, textView3);
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
