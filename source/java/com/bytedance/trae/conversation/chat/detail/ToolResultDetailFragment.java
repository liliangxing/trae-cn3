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
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView;
import com.bytedance.trae.conversation.widget.BottomSheetNestedScrollView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolResultDetailFragment.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016JK\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$J\u0014\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "monoTypeface", "Landroid/graphics/Typeface;", "getMonoTypeface", "()Landroid/graphics/Typeface;", "setMonoTypeface", "(Landroid/graphics/Typeface;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "buildWarningView", "context", "Landroid/content/Context;", ToolResultDetailFragment.ARG_TITLE, "", "message", "onDestroyView", "", "buildSection", "density", "", "label", ReportConstant.COMMON_CONTENT, "maxHeight", "", "minHeight", "isPlaceholder", "", "(Landroid/content/Context;FLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)Landroid/view/View;", "findBottomSheet", "Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolResultDetailFragment extends Fragment {
    private static final String ARG_COMMAND = "command";
    private static final String ARG_COMMAND_LABEL = "command_label";
    private static final String ARG_OUTPUT = "output";
    private static final String ARG_OUTPUT_LABEL = "output_label";
    private static final String ARG_TITLE = "title";
    private static final String ARG_WARNING_MESSAGE = "warning_message";
    private static final String ARG_WARNING_TITLE = "warning_title";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Typeface monoTypeface;

    public final Typeface getMonoTypeface() {
        return this.monoTypeface;
    }

    public final void setMonoTypeface(Typeface typeface) {
        this.monoTypeface = typeface;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2, types: [int] */
    /* JADX WARN: Type inference failed for: r21v3 */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String string;
        String string2;
        int i;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = requireContext.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(requireContext);
        boolean z = true;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int i2 = (int) (16 * f);
        int i3 = (int) (12 * f);
        linearLayout.setPadding(i2, i3, i2, i3);
        Bundle arguments = getArguments();
        String string3 = arguments != null ? arguments.getString(ARG_COMMAND) : null;
        Bundle arguments2 = getArguments();
        String string4 = arguments2 != null ? arguments2.getString(ARG_OUTPUT) : null;
        Bundle arguments3 = getArguments();
        String string5 = arguments3 != null ? arguments3.getString(ARG_TITLE) : null;
        Bundle arguments4 = getArguments();
        String string6 = arguments4 != null ? arguments4.getString(ARG_WARNING_TITLE) : null;
        Bundle arguments5 = getArguments();
        String string7 = arguments5 != null ? arguments5.getString(ARG_WARNING_MESSAGE) : null;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (string = arguments6.getString(ARG_COMMAND_LABEL)) == null) {
            string = requireContext.getString(C0637R.string.trae_chat_tool_cmd_command);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (string2 = arguments7.getString(ARG_OUTPUT_LABEL)) == null) {
            string2 = requireContext.getString(C0637R.string.trae_chat_tool_cmd_output);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        String str = string2;
        try {
            this.monoTypeface = Typeface.createFromAsset(requireContext.getAssets(), "fonts/JetBrainsMono-Regular.ttf");
        } catch (Exception unused) {
        }
        if (string5 != null) {
            try {
                ProcessDetailBottomSheet findBottomSheet = findBottomSheet(getActivity());
                if (findBottomSheet != null) {
                    findBottomSheet.setTitle(string5);
                }
            } catch (Exception unused2) {
            }
        }
        String str2 = string6;
        if (!(str2 == null || str2.length() == 0)) {
            if (string7 == null) {
                string7 = "";
            }
            linearLayout.addView(buildWarningView(requireContext, string6, string7));
        }
        String str3 = string3;
        if (str3 == null || str3.length() == 0) {
            i = 0;
        } else {
            i = 0;
            linearLayout.addView(buildSection$default(this, requireContext, f, string, string3, Integer.valueOf((int) (120 * f)), 0, false, 96, null));
        }
        String str4 = string4;
        boolean z2 = (str4 == null || str4.length() == 0) ? true : i;
        if (z2) {
            string4 = requireContext.getString(C0637R.string.trae_chat_tool_cmd_no_output);
        }
        String str5 = string4 == null ? "No output" : string4;
        if (str3 != null && str3.length() != 0) {
            z = i;
        }
        int i4 = z ? i : (int) (24 * f);
        View buildSection = buildSection(requireContext, f, str, str5, Integer.valueOf(i), (int) (250 * f), z2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i, 1.0f);
        layoutParams.topMargin = i4;
        buildSection.setLayoutParams(layoutParams);
        linearLayout.addView(buildSection);
        return linearLayout;
    }

    private final View buildWarningView(Context context, String title, String message) {
        StreamBannerView streamBannerView = new StreamBannerView(context);
        StreamBannerView.configureInlineAlert$default(streamBannerView, title, message, StreamBannerView.Style.WARNING, null, 8, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_24);
        streamBannerView.setLayoutParams(layoutParams);
        return streamBannerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        try {
            ProcessDetailBottomSheet findBottomSheet = findBottomSheet(getActivity());
            if (findBottomSheet != null) {
                findBottomSheet.setTitle(getString(C0637R.string.trae_chat_process_detail_title));
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ View buildSection$default(ToolResultDetailFragment toolResultDetailFragment, Context context, float f, String str, String str2, Integer num, int i, boolean z, int i2, Object obj) {
        return toolResultDetailFragment.buildSection(context, f, str, str2, num, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? false : z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View buildSection(Context context, float density, String label, String content, Integer maxHeight, int minHeight, boolean isPlaceholder) {
        int color;
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        if (minHeight > 0) {
            linearLayout2.setMinimumHeight(minHeight);
        }
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
        if (isPlaceholder) {
            color = ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary);
        } else {
            color = ContextCompat.getColor(context, C0591R.color.trae_text_text_default);
        }
        TextView textView2 = new TextView(context);
        textView2.setText(content);
        textView2.setTextColor(color);
        textView2.setTextSize(2, 16.0f);
        textView2.setTypeface(Typeface.MONOSPACE);
        try {
            Typeface typeface = this.monoTypeface;
            if (typeface != null) {
                textView2.setTypeface(typeface);
            }
        } catch (Exception unused) {
        }
        if (maxHeight != null) {
            BottomSheetNestedScrollView bottomSheetNestedScrollView = new BottomSheetNestedScrollView(context, null, 0, 6, null);
            if (maxHeight.intValue() > 0) {
                bottomSheetNestedScrollView.setMaxHeight(maxHeight.intValue());
            }
            bottomSheetNestedScrollView.setVerticalScrollBarEnabled(true);
            bottomSheetNestedScrollView.setPadding(i, i, i, i);
            bottomSheetNestedScrollView.setBackground(gradientDrawable);
            bottomSheetNestedScrollView.addView(textView2, new FrameLayout.LayoutParams(-1, -2));
            linearLayout = (View) bottomSheetNestedScrollView;
        } else {
            LinearLayout linearLayout3 = new LinearLayout(context);
            linearLayout3.setOrientation(1);
            linearLayout3.setPadding(i, i, i, i);
            linearLayout3.setBackground(gradientDrawable);
            linearLayout3.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
            linearLayout = linearLayout3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, minHeight > 0 ? 0 : -2, minHeight > 0 ? 1.0f : 0.0f);
        layoutParams.topMargin = i;
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(linearLayout, layoutParams);
        return linearLayout2;
    }

    /* compiled from: ToolResultDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005JP\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;", "", "<init>", "()V", "ARG_COMMAND", "", "ARG_OUTPUT", "ARG_TITLE", "ARG_COMMAND_LABEL", "ARG_OUTPUT_LABEL", "ARG_WARNING_TITLE", "ARG_WARNING_MESSAGE", "newInstance", "Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;", ToolResultDetailFragment.ARG_COMMAND, ToolResultDetailFragment.ARG_OUTPUT, "commandLabel", "outputLabel", "titleLable", "warningTitle", "warningMessage", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToolResultDetailFragment newInstance(String command, String output) {
            ToolResultDetailFragment toolResultDetailFragment = new ToolResultDetailFragment();
            Bundle bundle = new Bundle();
            if (command != null) {
                bundle.putString(ToolResultDetailFragment.ARG_COMMAND, command);
            }
            if (output != null) {
                bundle.putString(ToolResultDetailFragment.ARG_OUTPUT, output);
            }
            toolResultDetailFragment.setArguments(bundle);
            return toolResultDetailFragment;
        }

        public final ToolResultDetailFragment newInstance(String command, String output, String commandLabel, String outputLabel, String titleLable, String warningTitle, String warningMessage) {
            ToolResultDetailFragment toolResultDetailFragment = new ToolResultDetailFragment();
            Bundle bundle = new Bundle();
            if (command != null) {
                bundle.putString(ToolResultDetailFragment.ARG_COMMAND, command);
            }
            if (output != null) {
                bundle.putString(ToolResultDetailFragment.ARG_OUTPUT, output);
            }
            if (commandLabel != null) {
                bundle.putString(ToolResultDetailFragment.ARG_COMMAND_LABEL, commandLabel);
            }
            if (outputLabel != null) {
                bundle.putString(ToolResultDetailFragment.ARG_OUTPUT_LABEL, outputLabel);
            }
            if (titleLable != null) {
                bundle.putString(ToolResultDetailFragment.ARG_TITLE, titleLable);
            }
            if (warningTitle != null) {
                bundle.putString(ToolResultDetailFragment.ARG_WARNING_TITLE, warningTitle);
            }
            if (warningMessage != null) {
                bundle.putString(ToolResultDetailFragment.ARG_WARNING_MESSAGE, warningMessage);
            }
            toolResultDetailFragment.setArguments(bundle);
            return toolResultDetailFragment;
        }
    }

    private final ProcessDetailBottomSheet findBottomSheet(FragmentActivity activity) {
        if (activity == null) {
            return null;
        }
        ProcessDetailBottomSheet findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(ProcessDetailBottomSheet.TAG);
        if (findFragmentByTag instanceof ProcessDetailBottomSheet) {
            return findFragmentByTag;
        }
        return null;
    }
}
