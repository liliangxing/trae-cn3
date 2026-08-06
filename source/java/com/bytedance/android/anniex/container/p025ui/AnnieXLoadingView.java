package com.bytedance.android.anniex.container.p025ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLoadingView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXLoadingView;", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$LoadingView;", "()V", "progressView", "Lcom/bytedance/android/anniex/container/ui/AnnieXLoadingView$ProgressView;", "constructUi", "Landroid/view/View;", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "updateProgress", "", NotificationCompat.CATEGORY_PROGRESS, "", "Companion", "ProgressView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLoadingView extends AnnieXUIService.LoadingView {
    private static final int PROGRESS_ONE_HUNDRED = 100;
    private ProgressView progressView;

    /* compiled from: AnnieXLoadingView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXLoadingView$ProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", NotificationCompat.CATEGORY_PROGRESS, "rect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateProgress", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static final class ProgressView extends View {
        private final Paint paint;
        private int progress;
        private final Rect rect;

        public /* synthetic */ ProgressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            Intrinsics.checkNotNullParameter(context, "context");
            Paint paint = new Paint(1);
            paint.setColor(context.getResources().getColor(C0840R.color.annie_x_loading_color));
            this.paint = paint;
            this.rect = new Rect();
        }

        public final void updateProgress(int progress) {
            this.progress = progress;
            postInvalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
            this.rect.set(0, 0, (getMeasuredWidth() * this.progress) / 100, getMeasuredHeight());
            canvas.drawRect(this.rect, this.paint);
        }
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.LoadingView
    public View constructUi(Context context, IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        ProgressView progressView = new ProgressView(context, null, 0, 6, null);
        this.progressView = progressView;
        return progressView;
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.LoadingView
    public void updateProgress(int progress) {
        if (progress == 100) {
            ProgressView progressView = this.progressView;
            if (progressView == null) {
                return;
            }
            progressView.setVisibility(8);
            return;
        }
        ProgressView progressView2 = this.progressView;
        if (progressView2 != null) {
            progressView2.setVisibility(0);
        }
        ProgressView progressView3 = this.progressView;
        if (progressView3 != null) {
            progressView3.updateProgress(progress);
        }
    }
}
