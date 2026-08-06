package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.style.ReplacementSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.image.fresco.SvgFrescoDecoder;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginTagSpan.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020(H\u0002J\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u0004\u0018\u00010\"*\u00020&H\u0002J4\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000104H\u0016JR\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/trae/conversation/widget/PluginTagSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/bytedance/trae/conversation/widget/InputTagSpan;", "context", "Landroid/content/Context;", "pluginName", "", "iconRes", "", "pluginItem", "Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "iconUrl", "parentView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "tagTextSize", "", "tagPaddingH", "tagPaddingV", "iconSize", "iconMarginEnd", "tagBgColor", "tagTextColor", "cornerRadius", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILcom/bytedance/trae/conversation/widget/PluginTagItem;Ljava/lang/String;Ljava/lang/ref/WeakReference;FFFFFIIF)V", "getPluginItem", "()Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "appContext", "textPaint", "Landroid/graphics/Paint;", "bgPaint", "spanWidth", "loadedDrawable", "Landroid/graphics/drawable/Drawable;", "activeDataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "fetchIconFromUrl", "", IWeixinService.ResponseConstants.URL, "notifySpanChanged", "release", "toDrawable", "getSize", "paint", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginTagSpan extends ReplacementSpan implements InputTagSpan {
    private static final SvgFrescoDecoder.SvgDrawableFactory SVG_DRAWABLE_FACTORY = new SvgFrescoDecoder.SvgDrawableFactory();
    private DataSource<CloseableReference<CloseableImage>> activeDataSource;
    private final Context appContext;
    private final Paint bgPaint;
    private final float cornerRadius;
    private final float iconMarginEnd;
    private final int iconRes;
    private final float iconSize;
    private final String iconUrl;
    private Drawable loadedDrawable;
    private final WeakReference<View> parentView;
    private final PluginTagItem pluginItem;
    private final String pluginName;
    private int spanWidth;
    private final int tagBgColor;
    private final float tagPaddingH;
    private final float tagPaddingV;
    private final int tagTextColor;
    private final float tagTextSize;
    private final Paint textPaint;

    public final PluginTagItem getPluginItem() {
        return this.pluginItem;
    }

    public /* synthetic */ PluginTagSpan(Context context, String str, int i, PluginTagItem pluginTagItem, String str2, WeakReference weakReference, float f, float f2, float f3, float f4, float f5, int i2, int i3, float f6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, i, pluginTagItem, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? null : weakReference, (i4 & 64) != 0 ? SkillTagSpanKt.m867dp(14.0f, context) : f, (i4 & 128) != 0 ? SkillTagSpanKt.m867dp(10.0f, context) : f2, (i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? SkillTagSpanKt.m867dp(4.0f, context) : f3, (i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? SkillTagSpanKt.m867dp(16.0f, context) : f4, (i4 & 1024) != 0 ? SkillTagSpanKt.m867dp(4.0f, context) : f5, (i4 & 2048) != 0 ? ContextCompat.getColor(context, C0591R.color.trae_accent_accent_skill) : i2, (i4 & 4096) != 0 ? ContextCompat.getColor(context, C0591R.color.trae_text_text_default) : i3, (i4 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? SkillTagSpanKt.m867dp(6.0f, context) : f6);
    }

    public PluginTagSpan(Context context, String str, int i, PluginTagItem pluginTagItem, String str2, WeakReference<View> weakReference, float f, float f2, float f3, float f4, float f5, int i2, int i3, float f6) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pluginName");
        Intrinsics.checkNotNullParameter(pluginTagItem, "pluginItem");
        this.pluginName = str;
        this.iconRes = i;
        this.pluginItem = pluginTagItem;
        this.iconUrl = str2;
        this.parentView = weakReference;
        this.tagTextSize = f;
        this.tagPaddingH = f2;
        this.tagPaddingV = f3;
        this.iconSize = f4;
        this.iconMarginEnd = f5;
        this.tagBgColor = i2;
        this.tagTextColor = i3;
        this.cornerRadius = f6;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        boolean z = true;
        Paint paint = new Paint(1);
        paint.setTextSize(f);
        paint.setColor(i3);
        paint.setTypeface(Typeface.DEFAULT);
        this.textPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(i2);
        paint2.setStyle(Paint.Style.FILL);
        this.bgPaint = paint2;
        String str3 = str2;
        if (str3 != null && str3.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        fetchIconFromUrl(str2);
    }

    private final void fetchIconFromUrl(String url) {
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(url)).build(), this.appContext);
        this.activeDataSource = fetchDecodedImage;
        fetchDecodedImage.subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.bytedance.trae.conversation.widget.PluginTagSpan$fetchIconFromUrl$1
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                CloseableReference closeableReference;
                Drawable drawable;
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished() && (closeableReference = (CloseableReference) dataSource.getResult()) != null) {
                    try {
                        PluginTagSpan pluginTagSpan = PluginTagSpan.this;
                        Object obj = closeableReference.get();
                        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                        drawable = pluginTagSpan.toDrawable((CloseableImage) obj);
                        if (drawable != null) {
                            PluginTagSpan.this.loadedDrawable = drawable;
                            PluginTagSpan.this.notifySpanChanged();
                        }
                        CloseableReference.closeSafely(closeableReference);
                        PluginTagSpan.this.activeDataSource = null;
                    } catch (Throwable th) {
                        CloseableReference.closeSafely(closeableReference);
                        throw th;
                    }
                }
            }

            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                PluginTagSpan.this.activeDataSource = null;
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySpanChanged() {
        Editable editableText;
        WeakReference<View> weakReference = this.parentView;
        KeyEvent.Callback callback = weakReference != null ? (View) weakReference.get() : null;
        EditText editText = callback instanceof EditText ? (EditText) callback : null;
        if (editText == null || (editableText = editText.getEditableText()) == null) {
            return;
        }
        int spanStart = editableText.getSpanStart(this);
        int spanEnd = editableText.getSpanEnd(this);
        if (spanStart < 0 || spanEnd <= spanStart) {
            return;
        }
        editableText.setSpan(this, spanStart, spanEnd, editableText.getSpanFlags(this));
    }

    public final void release() {
        Bitmap bitmap;
        DataSource<CloseableReference<CloseableImage>> dataSource = this.activeDataSource;
        if (dataSource != null) {
            dataSource.close();
        }
        this.activeDataSource = null;
        Drawable drawable = this.loadedDrawable;
        this.loadedDrawable = null;
        if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        Bitmap bitmap2 = bitmap.isRecycled() ^ true ? bitmap : null;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable toDrawable(CloseableImage closeableImage) {
        CloseableBitmap closeableBitmap = closeableImage instanceof CloseableBitmap ? (CloseableBitmap) closeableImage : null;
        Bitmap underlyingBitmap = closeableBitmap != null ? closeableBitmap.getUnderlyingBitmap() : null;
        if (underlyingBitmap != null && !underlyingBitmap.isRecycled()) {
            return new BitmapDrawable(this.appContext.getResources(), underlyingBitmap.copy(Bitmap.Config.ARGB_8888, false));
        }
        return SVG_DRAWABLE_FACTORY.createDrawable(closeableImage);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float measureText = this.textPaint.measureText(this.pluginName);
        float f = this.tagPaddingH;
        this.spanWidth = (int) (this.iconSize + f + this.iconMarginEnd + measureText + f);
        if (fm != null) {
            Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
            int i = (int) (this.iconSize + (this.tagPaddingV * 2));
            int i2 = (fontMetricsInt.top + fontMetricsInt.bottom) / 2;
            int i3 = i / 2;
            fm.top = i2 - i3;
            fm.bottom = i2 + i3;
            fm.ascent = fm.top;
            fm.descent = fm.bottom;
        }
        return this.spanWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        float f = (top + bottom) / 2.0f;
        float f2 = 2;
        float f3 = (this.iconSize + (this.tagPaddingV * f2)) / f2;
        RectF rectF = new RectF(x, f - f3, this.spanWidth + x, f3 + f);
        float f4 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.bgPaint);
        Drawable drawable = this.loadedDrawable;
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(this.appContext, this.iconRes);
        }
        if (drawable != null) {
            int i = (int) (this.tagPaddingH + x);
            float f5 = this.iconSize;
            int i2 = (int) (f - (f5 / f2));
            drawable.setBounds(i, i2, (int) (i + f5), (int) (i2 + f5));
            drawable.draw(canvas);
        }
        canvas.drawText(this.pluginName, x + this.tagPaddingH + this.iconSize + this.iconMarginEnd, f - ((fontMetricsInt.top + fontMetricsInt.bottom) / 2.0f), this.textPaint);
    }
}
