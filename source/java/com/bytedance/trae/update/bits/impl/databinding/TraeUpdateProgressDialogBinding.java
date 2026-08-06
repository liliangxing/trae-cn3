package com.bytedance.trae.update.bits.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.update.bits.impl.R;

/* loaded from: classes4.dex */
public final class TraeUpdateProgressDialogBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView tvDialogTitle;
    public final TextView tvProgressPercent;
    public final TextView tvUpdateHint;
    public final ProgressBar updateProgressBar;

    private TraeUpdateProgressDialogBinding(CardView cardView, TextView textView, TextView textView2, TextView textView3, ProgressBar progressBar) {
        this.rootView = cardView;
        this.tvDialogTitle = textView;
        this.tvProgressPercent = textView2;
        this.tvUpdateHint = textView3;
        this.updateProgressBar = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static TraeUpdateProgressDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeUpdateProgressDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_update_progress_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeUpdateProgressDialogBinding bind(View view) {
        int i = R.id.tvDialogTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tvProgressPercent;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_update_hint;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.updateProgressBar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        return new TraeUpdateProgressDialogBinding((CardView) view, textView, textView2, textView3, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
