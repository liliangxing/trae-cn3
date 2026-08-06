package com.edu.onetex.latex.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import com.edu.onetex.latex.graphic.Path;
import com.edu.onetex.latex.view.ILaTeXView;
import com.facebook.imagepipeline.common.RotationOptions;
import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.animation.AnimationConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Graphics2D.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0013\n\u0002\b\u0007\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0002\\]B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J8\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016H\u0002J(\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J(\u0010)\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J8\u0010*\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\"\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J8\u00100\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J(\u00101\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J8\u00102\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\u0012H\u0002J\u0012\u00107\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u000109H\u0002J.\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\u00012\b\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@J\b\u0010A\u001a\u00020\u0012H\u0002J\b\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0016H\u0002J\b\u0010E\u001a\u00020\u0012H\u0002J\b\u0010F\u001a\u00020\u0012H\u0002J\u0016\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u0016J\u000e\u0010J\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u000205J\u0014\u0010L\u001a\u00020\u00122\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0NJ\b\u0010O\u001a\u00020\u0012H\u0002J\u0012\u0010P\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J0\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\u00162\u0006\u0010T\u001a\u0002052\u0006\u0010U\u001a\u0002052\b\u0010V\u001a\u0004\u0018\u00010WJ\u0016\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\u0016J\f\u0010[\u001a\u00020>*\u00020WH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D;", "", "context", "Landroid/content/Context;", "canvas", "Landroid/graphics/Canvas;", "(Landroid/content/Context;Landroid/graphics/Canvas;)V", "Ljava/lang/ref/WeakReference;", "customViewList", "Ljava/util/LinkedList;", "Lcom/edu/onetex/latex/view/ILaTeXView;", "font", "Lcom/edu/onetex/latex/graphic/Font;", "mOldDrawPaintStyle", "Landroid/graphics/Paint$Style;", "paint", "Landroid/text/TextPaint;", "afterFill", "", "beforeFill", "drawArc", "x", "", "y", "w", "h", "startAngle", "endAngle", "drawChar", "c", "", "drawCircle", "radius", "drawLine", "x1", "y1", "x2", "y2", "drawPath", "path", "Lcom/edu/onetex/latex/graphic/Path;", "drawRect", "drawRoundRect", "rx", "ry", "drawText", "txt", "", "fillArc", "fillRect", "fillRoundRect", "getCanvas", "getColor", "", ReportUtil.Event.EVENT_INIT, "play", "act", "Lcom/edu/onetex/latex/graphic/GraphicAction;", "record", "action", "arg", DefaultLogicExecutor.EVENT_ARGS, "", "intArgs", "", "restoreDrawPaintStyle", "restoreTransform", "rotate", "angle", "saveDrawPaintStyle", "saveTransform", "scale", "sx", "sy", "setCanvas", "setColor", "setCustomViewList", "list", "", "setDrawPaintFillStyle", "setFont", "setStroke", AnimationConstant.PROP_STR_WIDTH, "miterLimit", "cap", "join", "doubleArray", "", "translate", "dx", "dy", "toFloatArray", "ACT", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class Graphics2D {
    private static final int CAP_BUTT = 0;
    private static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    private static final int JOIN_ROUND = 1;
    public static final String TAG = "com.edu.onetex.latex.graphic.Graphics2D";
    private static boolean isTextContrastMode;
    private WeakReference<Canvas> canvas;
    private final Context context;
    private LinkedList<ILaTeXView> customViewList;
    private Font font;
    private Paint.Style mOldDrawPaintStyle;
    private final TextPaint paint;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ACT.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ACT.ACT_SETFONT.ordinal()] = 1;
            iArr[ACT.ACT_SETCOLOR.ordinal()] = 2;
            iArr[ACT.ACT_SETSTROKE.ordinal()] = 3;
            iArr[ACT.ACT_TRANSLATE.ordinal()] = 4;
            iArr[ACT.ACT_SCALE.ordinal()] = 5;
            iArr[ACT.ACT_ROTATE.ordinal()] = 6;
            iArr[ACT.ACT_DRAWCHAR.ordinal()] = 7;
            iArr[ACT.ACT_DRAWTEXT.ordinal()] = 8;
            iArr[ACT.ACT_DRAWLINE.ordinal()] = 9;
            iArr[ACT.ACT_DRAWRECT.ordinal()] = 10;
            iArr[ACT.ACT_FILLRECT.ordinal()] = 11;
            iArr[ACT.ACT_DRAWROUNDRECT.ordinal()] = 12;
            iArr[ACT.ACT_DRAWCIRCLE.ordinal()] = 13;
            iArr[ACT.ACT_DRAWARC.ordinal()] = 14;
            iArr[ACT.ACT_FILLARC.ordinal()] = 15;
            iArr[ACT.ACT_SAVETRANSFORM.ordinal()] = 16;
            iArr[ACT.ACT_RESTORETRANSFORM.ordinal()] = 17;
            iArr[ACT.ACT_DRAWPATH.ordinal()] = 18;
            iArr[ACT.ACT_DRAWVIEW.ordinal()] = 19;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Graphics2D(Context context) {
        this(context, r0, 2, r0);
        Canvas canvas = null;
    }

    public Graphics2D(Context context, Canvas canvas) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.paint = new TextPaint(1);
        Typeface typeface = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.DEFAULT");
        this.font = new Font(typeface, 46.0f, false);
        this.customViewList = new LinkedList<>();
        if (canvas != null) {
            this.canvas = new WeakReference<>(canvas);
        }
        init();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Graphics2D(Context context, Canvas canvas, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, canvas);
        if ((i & 2) != 0) {
            canvas = null;
        }
    }

    private final void init() {
        this.paint.setColor(-16777216);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setSubpixelText(true);
        this.paint.setLinearText(true);
    }

    public final void setCanvas(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.canvas = new WeakReference<>(canvas);
    }

    private final Canvas getCanvas() {
        WeakReference<Canvas> weakReference = this.canvas;
        if (weakReference == null) {
            return null;
        }
        Intrinsics.checkNotNull(weakReference);
        return weakReference.get();
    }

    public final void setCustomViewList(List<? extends ILaTeXView> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.customViewList.clear();
        this.customViewList.addAll(list);
    }

    private final void setFont(Font font) {
        if (font != null) {
            this.font = font;
        }
        this.paint.setTypeface(this.font.getTypeface());
        this.paint.setTextSize(this.font.getSize());
        this.paint.setTextSkewX(this.font.getIsItalic() ? -0.25f : 0.0f);
    }

    public final void setColor(int c) {
        this.paint.setColor(c);
    }

    public final int getColor() {
        return this.paint.getColor();
    }

    public final void setStroke(float width, float miterLimit, int cap, int join, double[] doubleArray) {
        this.paint.setStrokeWidth(width);
        this.paint.setStrokeMiter(miterLimit);
        if (cap == 0) {
            this.paint.setStrokeCap(Paint.Cap.BUTT);
        } else if (cap == 1) {
            this.paint.setStrokeCap(Paint.Cap.ROUND);
        } else if (cap == 2) {
            this.paint.setStrokeCap(Paint.Cap.SQUARE);
        }
        if (join == 0) {
            this.paint.setStrokeJoin(Paint.Join.MITER);
        } else if (join == 1) {
            this.paint.setStrokeJoin(Paint.Join.ROUND);
        } else if (join == 2) {
            this.paint.setStrokeJoin(Paint.Join.BEVEL);
        }
        if (doubleArray != null) {
            this.paint.setPathEffect(new DashPathEffect(toFloatArray(doubleArray), 0.0f));
        } else {
            this.paint.setPathEffect(null);
        }
    }

    private final float[] toFloatArray(double[] dArr) {
        int length = dArr.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = (float) dArr[i];
        }
        return fArr;
    }

    public final void translate(float dx, float dy) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.translate(dx, dy);
        }
    }

    public final void scale(float sx, float sy) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.scale(sx, sy);
        }
    }

    private final void rotate(float angle) {
        float f = (float) ((angle / 3.141592653589793d) * RotationOptions.ROTATE_180);
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.rotate(f);
        }
    }

    private final void saveDrawPaintStyle() {
        this.mOldDrawPaintStyle = this.paint.getStyle();
    }

    private final void restoreDrawPaintStyle() {
        this.paint.setStyle(this.mOldDrawPaintStyle);
    }

    private final void setDrawPaintFillStyle() {
        this.paint.setStyle(Paint.Style.FILL);
    }

    private final void beforeFill() {
        saveDrawPaintStyle();
        setDrawPaintFillStyle();
    }

    private final void afterFill() {
        restoreDrawPaintStyle();
    }

    private final void drawChar(char c, float x, float y) {
        drawText(String.valueOf(c), x, y);
    }

    private final void drawText(String txt, float x, float y) {
        Canvas canvas = getCanvas();
        if (canvas == null || txt == null) {
            return;
        }
        beforeFill();
        if (isTextContrastMode) {
            android.graphics.Path path = new android.graphics.Path();
            this.paint.getTextPath(txt, 0, txt.length(), x, y, path);
            canvas.drawPath(path, this.paint);
        } else {
            Paint.Style style = this.paint.getStyle();
            float strokeWidth = this.paint.getStrokeWidth();
            OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
            if (configuration != null && configuration.getFontBold()) {
                this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.paint.setStrokeWidth(0.02f);
            }
            canvas.drawText(txt, 0, txt.length(), x, y, (Paint) this.paint);
            this.paint.setStyle(style);
            this.paint.setStrokeWidth(strokeWidth);
        }
        afterFill();
    }

    private final void drawLine(float x1, float y1, float x2, float y2) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.drawLine(x1, y1, x1 + (x2 - x1), y2, this.paint);
        }
    }

    private final void drawRect(float x, float y, float w, float h) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.drawRect(x, y, x + w, y + h, this.paint);
        }
    }

    private final void fillRect(float x, float y, float w, float h) {
        beforeFill();
        drawRect(x, y, w, h);
        afterFill();
    }

    private final void drawRoundRect(float x, float y, float w, float h, float rx, float ry) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.drawRoundRect(x, y, x + w, y + h, rx, ry, this.paint);
        }
    }

    private final void drawCircle(float x, float y, float radius) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.drawCircle(x, y, radius, this.paint);
        }
    }

    private final void fillRoundRect(float x, float y, float w, float h, float rx, float ry) {
        beforeFill();
        drawRoundRect(x, y, w, h, rx, ry);
        afterFill();
    }

    private final void drawPath(Path path) {
        beforeFill();
        Canvas canvas = getCanvas();
        if (canvas != null) {
            OneTexConfiguration configuration = LaTeXEngine.INSTANCE.getConfiguration();
            if (configuration == null || !configuration.getLowVersionCompat()) {
                canvas.drawPath(path.getPath(), this.paint);
            } else {
                for (Path.C0155Op c0155Op : path.getOpList()) {
                    canvas.drawLine((float) c0155Op.getStartX(), (float) c0155Op.getStartY(), (float) c0155Op.getEndX(), (float) c0155Op.getEndY(), this.paint);
                }
            }
            afterFill();
        }
    }

    private final void drawArc(float x, float y, float w, float h, float startAngle, float endAngle) {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            double d = 180.0f;
            canvas.drawArc(x, y, x + w, y + h, (float) ((startAngle * 3.141592653589793d) / d), (float) ((endAngle * 3.141592653589793d) / d), false, this.paint);
        }
    }

    private final void fillArc(float x, float y, float w, float h, float startAngle, float endAngle) {
        beforeFill();
        drawArc(x, y, w, h, startAngle, endAngle);
        afterFill();
    }

    private final void saveTransform() {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.save();
        }
    }

    private final void restoreTransform() {
        Canvas canvas = getCanvas();
        if (canvas != null) {
            canvas.restore();
        }
    }

    private final void play(GraphicAction act) {
        if (act == null) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[ACT.values()[act.getAction()].ordinal()]) {
            case 1:
                Object arg = act.getArg();
                setFont((Font) (arg instanceof Font ? arg : null));
                return;
            case 2:
                int[] intArgs = act.getIntArgs();
                Intrinsics.checkNotNull(intArgs);
                setColor(intArgs[0]);
                return;
            case 3:
                float[] args = act.getArgs();
                Intrinsics.checkNotNull(args);
                float f = args[0];
                float[] args2 = act.getArgs();
                Intrinsics.checkNotNull(args2);
                float f2 = args2[1];
                float[] args3 = act.getArgs();
                Intrinsics.checkNotNull(args3);
                int i = (int) args3[2];
                float[] args4 = act.getArgs();
                Intrinsics.checkNotNull(args4);
                int i2 = (int) args4[3];
                Object arg2 = act.getArg();
                setStroke(f, f2, i, i2, (double[]) (arg2 instanceof double[] ? arg2 : null));
                return;
            case 4:
                float[] args5 = act.getArgs();
                Intrinsics.checkNotNull(args5);
                float f3 = args5[0];
                float[] args6 = act.getArgs();
                Intrinsics.checkNotNull(args6);
                translate(f3, args6[1]);
                return;
            case 5:
                float[] args7 = act.getArgs();
                Intrinsics.checkNotNull(args7);
                float f4 = args7[0];
                float[] args8 = act.getArgs();
                Intrinsics.checkNotNull(args8);
                scale(f4, args8[1]);
                return;
            case 6:
                float[] args9 = act.getArgs();
                Intrinsics.checkNotNull(args9);
                rotate(args9[0]);
                return;
            case 7:
                Intrinsics.checkNotNull(act.getArgs());
                float[] args10 = act.getArgs();
                Intrinsics.checkNotNull(args10);
                float f5 = args10[1];
                float[] args11 = act.getArgs();
                Intrinsics.checkNotNull(args11);
                drawChar((char) r0[0], f5, args11[2]);
                return;
            case 8:
                String str = (String) act.getArg();
                float[] args12 = act.getArgs();
                Intrinsics.checkNotNull(args12);
                float f6 = args12[0];
                float[] args13 = act.getArgs();
                Intrinsics.checkNotNull(args13);
                drawText(str, f6, args13[1]);
                return;
            case 9:
                float[] args14 = act.getArgs();
                Intrinsics.checkNotNull(args14);
                float f7 = args14[0];
                float[] args15 = act.getArgs();
                Intrinsics.checkNotNull(args15);
                float f8 = args15[1];
                float[] args16 = act.getArgs();
                Intrinsics.checkNotNull(args16);
                float f9 = args16[2];
                float[] args17 = act.getArgs();
                Intrinsics.checkNotNull(args17);
                drawLine(f7, f8, f9, args17[3]);
                return;
            case 10:
                float[] args18 = act.getArgs();
                Intrinsics.checkNotNull(args18);
                float f10 = args18[0];
                float[] args19 = act.getArgs();
                Intrinsics.checkNotNull(args19);
                float f11 = args19[1];
                float[] args20 = act.getArgs();
                Intrinsics.checkNotNull(args20);
                float f12 = args20[2];
                float[] args21 = act.getArgs();
                Intrinsics.checkNotNull(args21);
                drawRect(f10, f11, f12, args21[3]);
                return;
            case 11:
                float[] args22 = act.getArgs();
                Intrinsics.checkNotNull(args22);
                float f13 = args22[0];
                float[] args23 = act.getArgs();
                Intrinsics.checkNotNull(args23);
                float f14 = args23[1];
                float[] args24 = act.getArgs();
                Intrinsics.checkNotNull(args24);
                float f15 = args24[2];
                float[] args25 = act.getArgs();
                Intrinsics.checkNotNull(args25);
                fillRect(f13, f14, f15, args25[3]);
                return;
            case 12:
                float[] args26 = act.getArgs();
                Intrinsics.checkNotNull(args26);
                float f16 = args26[0];
                float[] args27 = act.getArgs();
                Intrinsics.checkNotNull(args27);
                float f17 = args27[1];
                float[] args28 = act.getArgs();
                Intrinsics.checkNotNull(args28);
                float f18 = args28[2];
                float[] args29 = act.getArgs();
                Intrinsics.checkNotNull(args29);
                float f19 = args29[3];
                float[] args30 = act.getArgs();
                Intrinsics.checkNotNull(args30);
                float f20 = args30[4];
                float[] args31 = act.getArgs();
                Intrinsics.checkNotNull(args31);
                drawRoundRect(f16, f17, f18, f19, f20, args31[5]);
                return;
            case 13:
                float[] args32 = act.getArgs();
                Intrinsics.checkNotNull(args32);
                float f21 = args32[0];
                float[] args33 = act.getArgs();
                Intrinsics.checkNotNull(args33);
                float f22 = args33[1];
                float[] args34 = act.getArgs();
                Intrinsics.checkNotNull(args34);
                drawCircle(f21, f22, args34[2]);
                return;
            case 14:
                float[] args35 = act.getArgs();
                Intrinsics.checkNotNull(args35);
                float f23 = args35[0];
                float[] args36 = act.getArgs();
                Intrinsics.checkNotNull(args36);
                float f24 = args36[1];
                float[] args37 = act.getArgs();
                Intrinsics.checkNotNull(args37);
                float f25 = args37[2];
                float[] args38 = act.getArgs();
                Intrinsics.checkNotNull(args38);
                float f26 = args38[3];
                float[] args39 = act.getArgs();
                Intrinsics.checkNotNull(args39);
                float f27 = args39[4];
                float[] args40 = act.getArgs();
                Intrinsics.checkNotNull(args40);
                drawArc(f23, f24, f25, f26, f27, args40[5]);
                return;
            case 15:
                float[] args41 = act.getArgs();
                Intrinsics.checkNotNull(args41);
                float f28 = args41[0];
                float[] args42 = act.getArgs();
                Intrinsics.checkNotNull(args42);
                float f29 = args42[1];
                float[] args43 = act.getArgs();
                Intrinsics.checkNotNull(args43);
                float f30 = args43[2];
                float[] args44 = act.getArgs();
                Intrinsics.checkNotNull(args44);
                float f31 = args44[3];
                float[] args45 = act.getArgs();
                Intrinsics.checkNotNull(args45);
                float f32 = args45[4];
                float[] args46 = act.getArgs();
                Intrinsics.checkNotNull(args46);
                fillArc(f28, f29, f30, f31, f32, args46[5]);
                return;
            case 16:
                saveTransform();
                return;
            case 17:
                restoreTransform();
                return;
            case 18:
                Object arg3 = act.getArg();
                if (arg3 != null) {
                    drawPath((Path) arg3);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.edu.onetex.latex.graphic.Path");
            case 19:
                Iterator<T> it = this.customViewList.iterator();
                while (it.hasNext()) {
                    ((ILaTeXView) it.next()).paintAndroidView(this);
                }
                return;
            default:
                return;
        }
    }

    public static /* synthetic */ void record$default(Graphics2D graphics2D, int i, Object obj, float[] fArr, int[] iArr, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            iArr = null;
        }
        graphics2D.record(i, obj, fArr, iArr);
    }

    public final void record(int action, Object arg, float[] args, int[] intArgs) {
        play(new GraphicAction((byte) action, arg, args, intArgs));
    }

    /* compiled from: Graphics2D.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D$Companion;", "", "()V", "CAP_BUTT", "", "CAP_ROUND", "CAP_SQUARE", "JOIN_BEVEL", "JOIN_MITER", "JOIN_ROUND", "TAG", "", "isTextContrastMode", "", "()Z", "setTextContrastMode", "(Z)V", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isTextContrastMode() {
            return Graphics2D.isTextContrastMode;
        }

        public final void setTextContrastMode(boolean z) {
            Graphics2D.isTextContrastMode = z;
        }
    }

    /* compiled from: Graphics2D.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/edu/onetex/latex/graphic/Graphics2D$ACT;", "", "action", "", "(Ljava/lang/String;IB)V", "getAction", "()B", "setAction", "(B)V", "ACT_SETFONT", "ACT_SETCOLOR", "ACT_SETSTROKE", "ACT_TRANSLATE", "ACT_SCALE", "ACT_ROTATE", "ACT_DRAWCHAR", "ACT_DRAWTEXT", "ACT_DRAWLINE", "ACT_DRAWRECT", "ACT_FILLRECT", "ACT_DRAWROUNDRECT", "ACT_DRAWARC", "ACT_FILLARC", "ACT_DRAWPATH", "ACT_SAVETRANSFORM", "ACT_RESTORETRANSFORM", "ACT_GETTRANSFORM", "ACT_DRAWIMAGE", "ACT_DRAWVIEW", "ACT_DRAWCIRCLE", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum ACT {
        ACT_SETFONT((byte) 1),
        ACT_SETCOLOR((byte) 2),
        ACT_SETSTROKE((byte) 3),
        ACT_TRANSLATE((byte) 4),
        ACT_SCALE((byte) 5),
        ACT_ROTATE((byte) 6),
        ACT_DRAWCHAR((byte) 7),
        ACT_DRAWTEXT((byte) 8),
        ACT_DRAWLINE((byte) 9),
        ACT_DRAWRECT((byte) 10),
        ACT_FILLRECT((byte) 11),
        ACT_DRAWROUNDRECT((byte) 12),
        ACT_DRAWARC((byte) 13),
        ACT_FILLARC((byte) 14),
        ACT_DRAWPATH((byte) 15),
        ACT_SAVETRANSFORM((byte) 16),
        ACT_RESTORETRANSFORM((byte) 17),
        ACT_GETTRANSFORM((byte) 18),
        ACT_DRAWIMAGE((byte) 19),
        ACT_DRAWVIEW((byte) 20),
        ACT_DRAWCIRCLE((byte) 21);

        private byte action;

        ACT(byte b) {
            this.action = b;
        }

        public final byte getAction() {
            return this.action;
        }

        public final void setAction(byte b) {
            this.action = b;
        }
    }
}
