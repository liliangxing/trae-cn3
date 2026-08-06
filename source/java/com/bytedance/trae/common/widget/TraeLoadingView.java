package com.bytedance.trae.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeLoadingView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/common/widget/TraeLoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressDrawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "progressImage", "Landroidx/appcompat/widget/AppCompatImageView;", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "onWindowVisibilityChanged", "setLoadingVisible", "visible", "", "updateDrawableRunning", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLoadingView extends FrameLayout {
    private final CircularProgressDrawable progressDrawable;
    private final AppCompatImageView progressImage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TraeLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TraeLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TraeLoadingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStyle(1);
        this.progressDrawable = circularProgressDrawable;
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageDrawable(circularProgressDrawable);
        this.progressImage = appCompatImageView;
        setContentDescription(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_tooltip));
        setBackground(gradientDrawable);
        ViewCompat.setElevation(this, getResources().getDimension(C0591R.dimen.trae_loading_view_elevation));
        addView((View) appCompatImageView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateDrawableRunning();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.progressDrawable.stop();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        updateDrawableRunning();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        updateDrawableRunning();
    }

    public final void setLoadingVisible(boolean visible) {
        setVisibility(visible ? 0 : 8);
    }

    private final void updateDrawableRunning() {
        if (isShown() && getWindowVisibility() == 0) {
            if (this.progressDrawable.isRunning()) {
                return;
            }
            this.progressDrawable.start();
        } else if (this.progressDrawable.isRunning()) {
            this.progressDrawable.stop();
        }
    }
}
