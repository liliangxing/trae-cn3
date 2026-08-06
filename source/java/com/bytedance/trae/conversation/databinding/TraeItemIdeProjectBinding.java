package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemIdeProjectBinding implements ViewBinding {
    public final RadioButton radioProject;
    private final LinearLayout rootView;
    public final TextView tvProjectName;
    public final TextView tvProjectPath;

    private TraeItemIdeProjectBinding(LinearLayout linearLayout, RadioButton radioButton, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.radioProject = radioButton;
        this.tvProjectName = textView;
        this.tvProjectPath = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemIdeProjectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemIdeProjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_ide_project, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemIdeProjectBinding bind(View view) {
        int i = R.id.radio_project;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.tv_project_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_project_path;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new TraeItemIdeProjectBinding((LinearLayout) view, radioButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
