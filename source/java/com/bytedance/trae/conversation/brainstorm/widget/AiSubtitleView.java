package com.bytedance.trae.conversation.brainstorm.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AiSubtitleView.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J(\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0014J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u001eJ\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\u0010\u00105\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00106\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aiSubtitleAdapter", "Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;", "subtitleLineIdCounter", "maxLineWidthPx", "", "visibleLineCount", "lineHeightPx", "autoScrollToBottom", "", "getAutoScrollToBottom", "()Z", "setAutoScrollToBottom", "(Z)V", "measurePaint", "Landroid/graphics/Paint;", "itemHorizontalPaddingPx", "fadePaint", "fadeHeight", "showTopFade", "setLayoutParams", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "appendText", "newChars", "", "clearAll", "updateFadeVisibility", "scrollToBottom", "getLastLineViewHolder", "Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;", "appendCharsToLines", "flushLastLineAnimation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AiSubtitleView extends RecyclerView {
    private final AiSubtitleAdapter aiSubtitleAdapter;
    private boolean autoScrollToBottom;
    private final float fadeHeight;
    private final Paint fadePaint;
    private final int itemHorizontalPaddingPx;
    private final int lineHeightPx;
    private float maxLineWidthPx;
    private final Paint measurePaint;
    private boolean showTopFade;
    private int subtitleLineIdCounter;
    private final int visibleLineCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AiSubtitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AiSubtitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }

    public /* synthetic */ AiSubtitleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiSubtitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        AiSubtitleAdapter aiSubtitleAdapter = new AiSubtitleAdapter();
        this.aiSubtitleAdapter = aiSubtitleAdapter;
        this.visibleLineCount = 3;
        int applyDimension = (int) TypedValue.applyDimension(1, 34.0f, context.getResources().getDisplayMetrics());
        this.lineHeightPx = applyDimension;
        this.autoScrollToBottom = true;
        Paint paint = new Paint();
        paint.setTextSize(TypedValue.applyDimension(2, 17.0f, context.getResources().getDisplayMetrics()));
        paint.setLetterSpacing(-0.014f);
        this.measurePaint = paint;
        this.fadePaint = new Paint();
        this.fadeHeight = applyDimension;
        setHasFixedSize(true);
        setLayoutManager((RecyclerView.LayoutManager) new LinearLayoutManager(context));
        setAdapter(aiSubtitleAdapter);
        setNestedScrollingEnabled(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = 3 * applyDimension;
        }
    }

    public final boolean getAutoScrollToBottom() {
        return this.autoScrollToBottom;
    }

    public final void setAutoScrollToBottom(boolean z) {
        this.autoScrollToBottom = z;
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if (params != null) {
            params.height = this.visibleLineCount * this.lineHeightPx;
        }
        super.setLayoutParams(params);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw && w > 0) {
            this.maxLineWidthPx = RangesKt.coerceAtLeast((((w - getPaddingLeft()) - getPaddingRight()) - this.itemHorizontalPaddingPx) - TypedValue.applyDimension(1, 16.0f, getContext().getResources().getDisplayMetrics()), 0.0f);
            this.fadePaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.fadeHeight, -419957003, 16250613, Shader.TileMode.CLAMP));
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.showTopFade) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.fadeHeight, this.fadePaint);
        }
    }

    public final void appendText(String newChars) {
        Intrinsics.checkNotNullParameter(newChars, "newChars");
        if (newChars.length() == 0) {
            return;
        }
        appendCharsToLines(newChars);
        updateFadeVisibility();
    }

    public final void clearAll() {
        AiSubtitleAdapter.LineViewHolder lastLineViewHolder = getLastLineViewHolder();
        if (lastLineViewHolder != null) {
            lastLineViewHolder.cancelAnimation();
        }
        this.subtitleLineIdCounter = 0;
        this.aiSubtitleAdapter.clearAll();
        this.showTopFade = false;
        invalidate();
    }

    private final void updateFadeVisibility() {
        if (this.showTopFade || this.aiSubtitleAdapter.getItemCount() <= this.visibleLineCount) {
            return;
        }
        this.showTopFade = true;
    }

    private final void scrollToBottom() {
        final int itemCount = this.aiSubtitleAdapter.getItemCount();
        if (itemCount > 0) {
            post(new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AiSubtitleView.scrollToBottom$lambda$2(AiSubtitleView.this, itemCount);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToBottom$lambda$2(AiSubtitleView aiSubtitleView, int i) {
        aiSubtitleView.scrollToPosition(i - 1);
    }

    private final AiSubtitleAdapter.LineViewHolder getLastLineViewHolder() {
        int itemCount = this.aiSubtitleAdapter.getItemCount() - 1;
        if (itemCount < 0) {
            return null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(itemCount);
        if (findViewHolderForAdapterPosition instanceof AiSubtitleAdapter.LineViewHolder) {
            return (AiSubtitleAdapter.LineViewHolder) findViewHolderForAdapterPosition;
        }
        return null;
    }

    private final void appendCharsToLines(String newChars) {
        int length = newChars.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = newChars.charAt(i);
            if (charAt == '\n') {
                flushLastLineAnimation();
                AiSubtitleAdapter aiSubtitleAdapter = this.aiSubtitleAdapter;
                int i2 = this.subtitleLineIdCounter;
                this.subtitleLineIdCounter = i2 + 1;
                aiSubtitleAdapter.appendLine(new AiSubtitleAdapter.SubtitleLine(i2, "", false, 4, null));
            } else {
                AiSubtitleAdapter.SubtitleLine lastLine = this.aiSubtitleAdapter.getLastLine();
                if (lastLine == null) {
                    AiSubtitleAdapter aiSubtitleAdapter2 = this.aiSubtitleAdapter;
                    int i3 = this.subtitleLineIdCounter;
                    this.subtitleLineIdCounter = i3 + 1;
                    aiSubtitleAdapter2.appendLine(new AiSubtitleAdapter.SubtitleLine(i3, String.valueOf(charAt), false, 4, null));
                } else {
                    String str = lastLine.getText() + charAt;
                    float measureText = this.measurePaint.measureText(str);
                    float f = this.maxLineWidthPx;
                    if (f > 0.0f && measureText > f) {
                        this.aiSubtitleAdapter.forceUpdateLastLine(lastLine);
                        AiSubtitleAdapter aiSubtitleAdapter3 = this.aiSubtitleAdapter;
                        int i4 = this.subtitleLineIdCounter;
                        this.subtitleLineIdCounter = i4 + 1;
                        aiSubtitleAdapter3.appendLine(new AiSubtitleAdapter.SubtitleLine(i4, String.valueOf(charAt), false, 4, null));
                    } else {
                        AiSubtitleAdapter.SubtitleLine copy$default = AiSubtitleAdapter.SubtitleLine.copy$default(lastLine, 0, str, false, 5, null);
                        this.aiSubtitleAdapter.updateLastLineData(copy$default);
                        AiSubtitleAdapter.LineViewHolder lastLineViewHolder = getLastLineViewHolder();
                        if (lastLineViewHolder != null) {
                            lastLineViewHolder.animateAppend(str);
                        } else {
                            this.aiSubtitleAdapter.forceUpdateLastLine(copy$default);
                        }
                    }
                }
            }
            z = true;
        }
        if (z && this.autoScrollToBottom) {
            scrollToBottom();
        }
    }

    private final void flushLastLineAnimation() {
        AiSubtitleAdapter.LineViewHolder lastLineViewHolder = getLastLineViewHolder();
        if (lastLineViewHolder != null) {
            lastLineViewHolder.cancelAnimation();
            lastLineViewHolder.getTextView().setTranslationX(0.0f);
        }
    }
}
