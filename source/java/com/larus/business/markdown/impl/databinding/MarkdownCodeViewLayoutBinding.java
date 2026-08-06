package com.larus.business.markdown.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.business.markdown.impl.R;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui.MaxHeightLinearLayout;

/* loaded from: classes6.dex */
public final class MarkdownCodeViewLayoutBinding implements ViewBinding {
    public final FrameLayout markdownCodeContainer;
    public final ImageView markdownCodeCopyButton;
    public final TextView markdownCodeFoldDesc;
    public final ImageView markdownCodeFullscreenButton;
    public final LinearLayout markdownCodeHeader;
    public final TextView markdownCodeLanguage;
    public final ImageView markdownCodePreviewButton;
    private final MaxHeightLinearLayout rootView;

    private MarkdownCodeViewLayoutBinding(MaxHeightLinearLayout maxHeightLinearLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, ImageView imageView2, LinearLayout linearLayout, TextView textView2, ImageView imageView3) {
        this.rootView = maxHeightLinearLayout;
        this.markdownCodeContainer = frameLayout;
        this.markdownCodeCopyButton = imageView;
        this.markdownCodeFoldDesc = textView;
        this.markdownCodeFullscreenButton = imageView2;
        this.markdownCodeHeader = linearLayout;
        this.markdownCodeLanguage = textView2;
        this.markdownCodePreviewButton = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaxHeightLinearLayout getRoot() {
        return this.rootView;
    }

    public static MarkdownCodeViewLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MarkdownCodeViewLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.markdown_code_view_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MarkdownCodeViewLayoutBinding bind(View view) {
        int i = R.id.markdownCodeContainer;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
        if (frameLayout != null) {
            i = R.id.markdownCodeCopyButton;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.markdownCodeFoldDesc;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.markdownCodeFullscreenButton;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = R.id.markdownCodeHeader;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = R.id.markdownCodeLanguage;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = R.id.markdownCodePreviewButton;
                                ImageView imageView3 = (ImageView) view.findViewById(i);
                                if (imageView3 != null) {
                                    return new MarkdownCodeViewLayoutBinding((MaxHeightLinearLayout) view, frameLayout, imageView, textView, imageView2, linearLayout, textView2, imageView3);
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
