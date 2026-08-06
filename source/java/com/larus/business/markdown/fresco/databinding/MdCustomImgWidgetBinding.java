package com.larus.business.markdown.fresco.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.markdown.fresco.C1324R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MdCustomImgWidgetBinding implements ViewBinding {
    public final SimpleDraweeView customImgWidget;
    public final ConstraintLayout customImgWidgetGroup;
    private final ConstraintLayout rootView;

    private MdCustomImgWidgetBinding(ConstraintLayout constraintLayout, SimpleDraweeView simpleDraweeView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.customImgWidget = simpleDraweeView;
        this.customImgWidgetGroup = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MdCustomImgWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MdCustomImgWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1324R.layout.md_custom_img_widget, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MdCustomImgWidgetBinding bind(View view) {
        int i = C1324R.id.custom_img_widget;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(i);
        if (simpleDraweeView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new MdCustomImgWidgetBinding(constraintLayout, simpleDraweeView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
