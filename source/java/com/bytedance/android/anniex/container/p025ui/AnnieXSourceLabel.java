package com.bytedance.android.anniex.container.p025ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.ies.bullet.core.device.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXSourceLabel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXSourceLabel;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "labelHeight", "attachToRoot", "", "frameLayout", "Landroid/widget/FrameLayout;", "attachToRoot$anniex_release", "getLabelHeight", "updateSource", "source", "", "updateSource$anniex_release", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXSourceLabel extends AppCompatTextView {
    private static final int LABEL_HEIGHT_DP = 40;
    private static final float LABEL_TEXT_SIZE = 15.0f;
    private final int labelHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnieXSourceLabel(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnieXSourceLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnnieXSourceLabel(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXSourceLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.labelHeight = UIUtils.dpToPx$anniex_release(40, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachToRoot$anniex_release(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "frameLayout");
        setVisibility(4);
        setGravity(17);
        setTextSize(1, LABEL_TEXT_SIZE);
        setTextColor(getResources().getColor(C0840R.color.annie_x_source_label_text_color));
        setBackgroundColor(getResources().getColor(C0840R.color.annie_x_source_label_bg_color));
        frameLayout.addView((View) this, new FrameLayout.LayoutParams(-1, this.labelHeight));
    }

    public final int getLabelHeight() {
        return this.labelHeight;
    }

    public final void updateSource$anniex_release(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        setText(getContext().getString(C0840R.string.annie_x_source_label_text, source));
        setVisibility(0);
    }
}
