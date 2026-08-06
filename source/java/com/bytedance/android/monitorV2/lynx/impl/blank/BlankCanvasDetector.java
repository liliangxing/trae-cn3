package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import android.graphics.text.MeasuredText;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlankCanvasDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0083\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J0\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JH\u0010\f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J,\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J,\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J*\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JR\u0010\u0019\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JR\u0010\u0019\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JL\u0010*\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J(\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\bH\u0016J\u0018\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000209H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020:H\u0016J\u0018\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020:2\u0006\u00107\u001a\u000208H\u0016J@\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020.2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020.2\u0006\u0010#\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010L\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010L\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020P2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020S2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020S2\u0006\u0010 \u001a\u00020\u000eH\u0016J \u0010T\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010U\u001a\u00020\u00062\u0006\u0010J\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010U\u001a\u00020\u00062\b\u0010J\u001a\u0004\u0018\u00010.2\u0006\u0010#\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010Z\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020[2\u0006\u0010Z\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\\\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010]\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010]\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020aH\u0016J(\u0010b\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J@\u0010b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J8\u0010e\u001a\u00020\u00062\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J8\u0010e\u001a\u00020\u00062\u0006\u0010W\u001a\u00020f2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010e\u001a\u00020\u00062\u0006\u0010W\u001a\u00020[2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J8\u0010e\u001a\u00020\u00062\u0006\u0010W\u001a\u00020[2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J@\u0010i\u001a\u00020\u00062\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010O\u001a\u00020P2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J0\u0010i\u001a\u00020\u00062\u0006\u0010W\u001a\u00020[2\u0006\u0010O\u001a\u00020P2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JP\u0010l\u001a\u00020\u00062\u0006\u0010W\u001a\u00020m2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JP\u0010l\u001a\u00020\u00062\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JP\u0010l\u001a\u00020\u00062\u0006\u0010W\u001a\u00020f2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010p\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016Jn\u0010s\u001a\u00020\u00062\u0006\u00107\u001a\u00020t2\u0006\u0010u\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\b2\b\u0010v\u001a\u0004\u0018\u00010.2\u0006\u0010w\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u00020\b2\b\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020\b2\u0006\u0010{\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020~J\u000e\u0010|\u001a\u00020\u00042\u0006\u0010}\u001a\u00020\u007fJ\u0013\u0010\u0080\u0001\u001a\u00020\u00042\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCanvasDetector;", "Landroid/graphics/Canvas;", "()V", "hasDrawn", "", "drawARGB", "", IEncryptorType.DEFAULT_ENCRYPTOR, "", DownloadFileUtils.MODE_READ, "g", "b", "drawArc", "oval", "Landroid/graphics/RectF;", "startAngle", "", "sweepAngle", "useCenter", "paint", "Landroid/graphics/Paint;", "left", "top", "right", "bottom", "drawBitmap", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "src", "Landroid/graphics/Rect;", "dst", "colors", "", "offset", "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "mode", "Landroid/graphics/BlendMode;", "Landroid/graphics/PorterDuff$Mode;", "", "drawDoubleRoundRect", "outer", "outerRx", "outerRy", "inner", "innerRx", "innerRy", "outerRadii", "innerRadii", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPath", "path", "Landroid/graphics/Path;", "drawPicture", "picture", "Landroid/graphics/Picture;", "drawPoint", "drawPoints", "drawPosText", "text", "", "index", "pos", "", "drawRGB", "drawRect", "rect", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "drawRoundRect", "rx", "ry", "drawText", "", "start", "end", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "Landroid/graphics/text/MeasuredText;", "contextStart", "contextEnd", "isRtl", "contextIndex", "contextCount", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "hasContent", "drawer", "Landroid/graphics/drawable/Drawable;", "Landroid/view/View;", "hasContentInternal", "drawable", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCanvasDetector$Drawer;", "Drawer", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class BlankCanvasDetector extends Canvas {
    private boolean hasDrawn;

    /* compiled from: BlankCanvasDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankCanvasDetector$Drawer;", "", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Drawer {
        void draw(Canvas canvas);
    }

    private final boolean hasContentInternal(Drawer drawable) {
        boolean z;
        synchronized (this) {
            drawable.draw(this);
            z = this.hasDrawn;
            this.hasDrawn = false;
        }
        return z;
    }

    public final boolean hasContent(final Drawable drawer) {
        Intrinsics.checkNotNullParameter(drawer, "drawer");
        return hasContentInternal(new Drawer() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankCanvasDetector$hasContent$1
            @Override // com.bytedance.android.monitorV2.lynx.impl.blank.BlankCanvasDetector.Drawer
            public void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                drawer.draw(canvas);
            }
        });
    }

    public final boolean hasContent(final View drawer) {
        Intrinsics.checkNotNullParameter(drawer, "drawer");
        return hasContentInternal(new Drawer() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankCanvasDetector$hasContent$2
            @Override // com.bytedance.android.monitorV2.lynx.impl.blank.BlankCanvasDetector.Drawer
            public void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                drawer.draw(canvas);
            }
        });
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        if (picture.getWidth() <= 0 || picture.getHeight() <= 0) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, RectF dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (picture.getWidth() <= 0 || picture.getHeight() <= 0) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture, Rect dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (picture.getWidth() <= 0 || picture.getHeight() <= 0) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int a, int r, int g, int b) {
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float left, float top, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.isRecycled()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.isRecycled()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.isRecycled()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.isRecycled()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(verts, "verts");
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || bitmap.isRecycled()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float cx, float cy, float radius, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color) {
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawColor(long color) {
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color, PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawColor(int color, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawColor(long color, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, int offset, int count, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF oval, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawOval(float left, float top, float right, float bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float x, float y, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] pts, int offset, int count, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawPosText(char[] text, int index, int count, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(new String(text))) {
            this.hasDrawn = true;
        }
    }

    @Override // android.graphics.Canvas
    public void drawPosText(String text, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(text)) {
            this.hasDrawn = true;
        }
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rect, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (rect.isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect r, Paint paint) {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (r.isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (new RectF(left, top, right, bottom).isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int r, int g, int b) {
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF rect, float rx, float ry, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (rect.isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (new RectF(left, top, right, bottom).isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float outerRx, float outerRy, RectF inner, float innerRx, float innerRy, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (outer.isEmpty() && inner.isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF outer, float[] outerRadii, RectF inner, float[] innerRadii, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(outerRadii, "outerRadii");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(innerRadii, "innerRadii");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (outer.isEmpty() && inner.isEmpty()) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] text, int index, int count, float x, float y, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(new String(text))) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, float x, float y, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawText(String text, int start, int end, float x, float y, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(new String(text))) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode mode, int vertexCount, float[] verts, int vertOffset, float[] texs, int texOffset, int[] colors, int colorOffset, short[] indices, int indexOffset, int indexCount, Paint paint) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(verts, "verts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.hasDrawn = true;
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        this.hasDrawn = true;
    }
}
