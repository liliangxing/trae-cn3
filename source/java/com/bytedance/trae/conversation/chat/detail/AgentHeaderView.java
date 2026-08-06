package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AgentHeaderView.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconView", "Landroid/widget/ImageView;", "nameView", "Landroid/widget/TextView;", "descView", "density", "", "bind", "", "name", "", "description", "agentId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentHeaderView extends LinearLayout {
    private final float density;
    private final TextView descView;
    private final ImageView iconView;
    private final TextView nameView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentHeaderView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        setOrientation(0);
        setGravity(16);
        float f2 = 12;
        int i = (int) (f2 * f);
        int i2 = (int) (8 * f);
        setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(10 * f);
        setBackground(gradientDrawable);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(C0637R.drawable.avatar_coder);
        this.iconView = imageView;
        int i3 = (int) (24 * f);
        addView(imageView, new LinearLayout.LayoutParams(i3, i3));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (f2 * f));
        Unit unit = Unit.INSTANCE;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 13.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setLetterSpacing(-0.0062f);
        float f3 = 17;
        TextViewCompat.setLineHeight(textView, (int) (f3 * f));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameView = textView;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(context);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView2.setTextSize(2, 13.0f);
        textView2.setLetterSpacing(-0.0062f);
        TextViewCompat.setLineHeight(textView2, (int) (f3 * f));
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setVisibility(8);
        this.descView = textView2;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = (int) (2 * f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(textView2, layoutParams2);
    }

    public static /* synthetic */ void bind$default(AgentHeaderView agentHeaderView, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        agentHeaderView.bind(str, str2, str3);
    }

    public final void bind(String name, String description, String agentId) {
        TextView textView = this.nameView;
        if (name == null) {
            name = getContext().getString(C0637R.string.trae_chat_sub_agent_default);
            Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
        }
        textView.setText(name);
        this.iconView.setImageResource(AgentAvatarHelper.INSTANCE.getAvatarResId(agentId));
        String str = description;
        if (str == null || StringsKt.isBlank(str)) {
            this.descView.setVisibility(8);
        } else {
            this.descView.setText(str);
            this.descView.setVisibility(0);
        }
    }
}
