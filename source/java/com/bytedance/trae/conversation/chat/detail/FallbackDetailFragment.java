package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FallbackDetailFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J7\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "buildSection", "context", "Landroid/content/Context;", "density", "", "label", "", ReportConstant.COMMON_CONTENT, "maxHeight", "", "(Landroid/content/Context;FLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/view/View;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FallbackDetailFragment extends Fragment {
    private static final String ARG_INPUT = "input";
    private static final String ARG_OUTPUT = "output";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = requireContext.getResources().getDisplayMetrics().density;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_INPUT) : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(ARG_OUTPUT) : null;
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setOrientation(1);
        int i = (int) (16 * f);
        int i2 = (int) (12 * f);
        linearLayout.setPadding(i, i2, i, i2);
        if (string != null) {
            String string3 = requireContext.getString(C0637R.string.trae_chat_tool_fallback_input);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            linearLayout.addView(buildSection(requireContext, f, string3, string, null));
        }
        if (string2 != null) {
            String string4 = requireContext.getString(C0637R.string.trae_chat_tool_fallback_output);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            View buildSection = buildSection(requireContext, f, string4, string2, Integer.valueOf((int) (250 * f)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (int) (24 * f);
            buildSection.setLayoutParams(layoutParams);
            linearLayout.addView(buildSection);
        }
        ScrollView scrollView = new ScrollView(requireContext);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return scrollView;
    }

    private final View buildSection(Context context, float density, String label, String content, Integer maxHeight) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setText(label);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 15.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        int i = (int) (12 * density);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setStroke((int) (1 * density), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2));
        gradientDrawable.setCornerRadius(10 * density);
        TextView textView2 = new TextView(context);
        textView2.setText(content);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.MONOSPACE);
        if (maxHeight != null) {
            ScrollView scrollView = new ScrollView(context);
            scrollView.setVerticalScrollBarEnabled(true);
            scrollView.setPadding(i, i, i, i);
            scrollView.setBackground(gradientDrawable);
            scrollView.addView(textView2, new FrameLayout.LayoutParams(-1, -2));
            linearLayout = scrollView;
        } else {
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setOrientation(1);
            linearLayout3.setPadding(i, i, i, i);
            linearLayout3.setBackground(gradientDrawable);
            linearLayout3.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout = linearLayout3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, maxHeight != null ? maxHeight.intValue() : -2);
        layoutParams.topMargin = i;
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(linearLayout, layoutParams);
        return linearLayout2;
    }

    /* compiled from: FallbackDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;", "", "<init>", "()V", "ARG_INPUT", "", "ARG_OUTPUT", "newInstance", "Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;", "inputText", "outputText", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FallbackDetailFragment newInstance(String inputText, String outputText) {
            FallbackDetailFragment fallbackDetailFragment = new FallbackDetailFragment();
            Bundle bundle = new Bundle();
            if (inputText != null) {
                bundle.putString(FallbackDetailFragment.ARG_INPUT, inputText);
            }
            if (outputText != null) {
                bundle.putString(FallbackDetailFragment.ARG_OUTPUT, outputText);
            }
            fallbackDetailFragment.setArguments(bundle);
            return fallbackDetailFragment;
        }
    }
}
