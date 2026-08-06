package com.github.alexzhirkevich.customqrgenerator.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;

/* compiled from: QrCanvasShape.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;", "", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "drawPaint", "Landroid/graphics/Paint;", "erasePaint", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface QrCanvasShape {
    void draw(Canvas canvas, Paint drawPaint, Paint erasePaint);
}
