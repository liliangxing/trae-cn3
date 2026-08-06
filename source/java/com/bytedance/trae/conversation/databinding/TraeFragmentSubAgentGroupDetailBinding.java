package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentSubAgentGroupDetailBinding implements ViewBinding {
    public final LinearLayout llAgentHeader;
    public final LinearLayout llContent;
    private final NestedScrollView rootView;
    public final TextView tvAgentDesc;
    public final TextView tvAgentIcon;
    public final TextView tvAgentName;

    private TraeFragmentSubAgentGroupDetailBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = nestedScrollView;
        this.llAgentHeader = linearLayout;
        this.llContent = linearLayout2;
        this.tvAgentDesc = textView;
        this.tvAgentIcon = textView2;
        this.tvAgentName = textView3;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentSubAgentGroupDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentSubAgentGroupDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_sub_agent_group_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentSubAgentGroupDetailBinding bind(View view) {
        int i = C0637R.id.ll_agent_header;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.ll_content;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = C0637R.id.tv_agent_desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_agent_icon;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C0637R.id.tv_agent_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new TraeFragmentSubAgentGroupDetailBinding((NestedScrollView) view, linearLayout, linearLayout2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
