package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentBrainstormIntroBinding implements ViewBinding {
    public final Button btnStart;
    public final LinearLayout descContainer;
    public final ImageView ivPhoneMockup;
    public final FrameLayout mockupContainer;
    private final LinearLayout rootView;
    public final FrameLayout sphereArea;
    public final BrainstormTopBar topBar;
    public final TextView tvDescLine1;
    public final TextView tvDescLine2;
    public final TextView tvTitle;
    public final WebView webviewSphere;

    private TraeFragmentBrainstormIntroBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, BrainstormTopBar brainstormTopBar, TextView textView, TextView textView2, TextView textView3, WebView webView) {
        this.rootView = linearLayout;
        this.btnStart = button;
        this.descContainer = linearLayout2;
        this.ivPhoneMockup = imageView;
        this.mockupContainer = frameLayout;
        this.sphereArea = frameLayout2;
        this.topBar = brainstormTopBar;
        this.tvDescLine1 = textView;
        this.tvDescLine2 = textView2;
        this.tvTitle = textView3;
        this.webviewSphere = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentBrainstormIntroBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentBrainstormIntroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_brainstorm_intro, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentBrainstormIntroBinding bind(View view) {
        int i = C0637R.id.btn_start;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = C0637R.id.desc_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = C0637R.id.iv_phone_mockup;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0637R.id.mockup_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = C0637R.id.sphere_area;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = C0637R.id.top_bar;
                            BrainstormTopBar brainstormTopBar = (BrainstormTopBar) ViewBindings.findChildViewById(view, i);
                            if (brainstormTopBar != null) {
                                i = C0637R.id.tv_desc_line1;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = C0637R.id.tv_desc_line2;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = C0637R.id.tv_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = C0637R.id.webview_sphere;
                                            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                                            if (webView != null) {
                                                return new TraeFragmentBrainstormIntroBinding((LinearLayout) view, button, linearLayout, imageView, frameLayout, frameLayout2, brainstormTopBar, textView, textView2, textView3, webView);
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
