package com.bytedance.android.anniex.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DebugTagDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0017J\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J3\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e0\u0019H\u0007J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/utils/DebugTagDrawable;", "Landroid/graphics/drawable/Drawable;", "bgColor", "", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "height", "tagLayout", "Landroid/text/StaticLayout;", "text", "", "textPaint", "Landroid/text/TextPaint;", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "getText", "setAlpha", "alpha", "setClickListener", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setText", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugTagDrawable extends Drawable {
    private final Integer bgColor;
    private int height;
    private StaticLayout tagLayout;
    private String text;
    private final TextPaint textPaint;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugTagDrawable() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.OPAQUE", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public DebugTagDrawable(Integer num) {
        this.bgColor = num;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(UnitExtKt.getDp2px(10.0f));
        textPaint.setColor(-1);
        textPaint.setTextAlign(Paint.Align.LEFT);
        this.textPaint = textPaint;
    }

    public /* synthetic */ DebugTagDrawable(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Integer.valueOf(Color.parseColor("#a63182f2")) : num);
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        invalidateSelf();
    }

    public final String getText() {
        return this.text;
    }

    public final void setClickListener(final View view, final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.android.anniex.utils.DebugTagDrawable$setClickListener$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                StaticLayout staticLayout;
                StaticLayout staticLayout2;
                StaticLayout staticLayout3;
                int action = motionEvent.getAction();
                staticLayout = DebugTagDrawable.this.tagLayout;
                if (staticLayout != null && action == 0) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    int height = DebugTagDrawable.this.getBounds().height();
                    staticLayout2 = DebugTagDrawable.this.tagLayout;
                    Intrinsics.checkNotNull(staticLayout2);
                    if (y > height - staticLayout2.getHeight() && y < DebugTagDrawable.this.getBounds().height()) {
                        staticLayout3 = DebugTagDrawable.this.tagLayout;
                        Intrinsics.checkNotNull(staticLayout3);
                        if (x < staticLayout3.getWidth()) {
                            booleanRef.element = true;
                            return true;
                        }
                    }
                }
                if (!booleanRef.element || action != 1) {
                    return false;
                }
                listener.invoke(view);
                booleanRef.element = false;
                return true;
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        String str = this.text;
        if (str == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        Integer num = this.bgColor;
        if (num != null) {
            num.intValue();
            spannableString.setSpan(new BackgroundColorSpan(this.bgColor.intValue()), 0, str.length(), 33);
        }
        StaticLayout staticLayout = new StaticLayout(spannableString, this.textPaint, getBounds().width(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.tagLayout = staticLayout;
        if (staticLayout.getLineCount() > 0) {
            this.height = staticLayout.getHeight();
        }
        canvas.save();
        canvas.translate(0.0f, getBounds().height() - this.height);
        staticLayout.draw(canvas);
        canvas.restore();
    }
}
