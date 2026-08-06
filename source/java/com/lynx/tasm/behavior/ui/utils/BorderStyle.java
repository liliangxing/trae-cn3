package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;

/* loaded from: classes7.dex */
public enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED,
    DOUBLE,
    GROOVE,
    RIDGE,
    INSET,
    OUTSET,
    HIDDEN,
    NONE;

    private static int brightColor(int i) {
        return i | 8421504;
    }

    private static int darkenColor(int i) {
        return (i & (-16777216)) | ((16711422 & i) >> 1);
    }

    private static boolean isDarkColor(int i) {
        return (i & 15790320) == 0;
    }

    /* renamed from: com.lynx.tasm.behavior.ui.utils.BorderStyle$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle = iArr;
            try {
                iArr[BorderStyle.DASHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.DOTTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.INSET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.OUTSET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.GROOVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[BorderStyle.RIDGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public PathEffect getPathEffect(float f) {
        int i = AnonymousClass1.$SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[ordinal()];
        if (i == 1) {
            float f2 = f * 3.0f;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        if (i != 2) {
            return null;
        }
        return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
    }

    public PathEffect getPathEffectAutoAdjust(float f, float f2) {
        if (this != DASHED && this != DOTTED) {
            return null;
        }
        if (f < 1.0f) {
            f = 1.0f;
        }
        int i = (((int) (((f2 / ((f * (this == DOTTED ? 2 : 6)) * 0.5f)) - 0.5f) * 0.5f)) * 2) + 1;
        if (i <= 1) {
            return null;
        }
        float f3 = f2 / i;
        return new DashPathEffect(new float[]{f3, f3}, 0.0f);
    }

    public boolean isSolidDashedOrDotted() {
        int i = AnonymousClass1.$SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public static BorderStyle parse(int i) {
        if (i < 0 || i > NONE.ordinal()) {
            return null;
        }
        return values()[i];
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if (r9 == 1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r9 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        r0 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        r0 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0033, code lost:
    
        if (r9 == 1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:
    
        if (r9 == 1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void strokeBorderMoreLines(Canvas canvas, Paint paint, int i, float f, float f2, int i2, int i3, float f3, float f4, float f5, float f6) {
        float f7;
        int i4;
        float f8;
        paint.setPathEffect(null);
        paint.setStrokeWidth(f);
        int i5 = -1;
        while (i5 <= 1) {
            float f9 = 0.0f;
            if (i != 0) {
                if (i == 1) {
                    f8 = i5 * f2;
                } else if (i == 2) {
                    f7 = (-f2) * i5;
                } else if (i != 3) {
                    i4 = 0;
                    f8 = 0.0f;
                } else {
                    f8 = (-f2) * i5;
                }
                paint.setColor(i4);
                canvas.drawLine(f3 + f9, f4 + f8, f5 + f9, f6 + f8, paint);
                i5 += 2;
            } else {
                f7 = i5 * f2;
            }
            float f10 = f7;
            f8 = 0.0f;
            f9 = f10;
            paint.setColor(i4);
            canvas.drawLine(f3 + f9, f4 + f8, f5 + f9, f6 + f8, paint);
            i5 += 2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0016. Please report as an issue. */
    public void strokeBorderLine(Canvas canvas, Paint paint, int i, float f, int i2, float f2, float f3, float f4, float f5, float f6, float f7) {
        PathEffect pathEffectAutoAdjust;
        int i3;
        switch (AnonymousClass1.$SwitchMap$com$lynx$tasm$behavior$ui$utils$BorderStyle[ordinal()]) {
            case 1:
            case 2:
                pathEffectAutoAdjust = getPathEffectAutoAdjust(f7, f6);
                i3 = i2;
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(i3);
                paint.setPathEffect(pathEffectAutoAdjust);
                paint.setStrokeWidth(f);
                canvas.drawLine(f2, f3, f4, f5, paint);
                paint.setPathEffect(null);
                return;
            case 3:
            default:
                i3 = i2;
                pathEffectAutoAdjust = null;
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(i3);
                paint.setPathEffect(pathEffectAutoAdjust);
                paint.setStrokeWidth(f);
                canvas.drawLine(f2, f3, f4, f5, paint);
                paint.setPathEffect(null);
                return;
            case 4:
            case 5:
                return;
            case 6:
                if (isDarkColor(i2)) {
                    if (i == 3 || i == 2) {
                        i3 = brightColor(i2);
                    }
                    i3 = i2;
                } else {
                    if (i == 1 || i == 0) {
                        i3 = darkenColor(i2);
                    }
                    i3 = i2;
                }
                pathEffectAutoAdjust = null;
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(i3);
                paint.setPathEffect(pathEffectAutoAdjust);
                paint.setStrokeWidth(f);
                canvas.drawLine(f2, f3, f4, f5, paint);
                paint.setPathEffect(null);
                return;
            case 7:
                if (isDarkColor(i2)) {
                    if (i == 1 || i == 0) {
                        i3 = brightColor(i2);
                    }
                    i3 = i2;
                } else {
                    if (i == 3 || i == 2) {
                        i3 = darkenColor(i2);
                    }
                    i3 = i2;
                }
                pathEffectAutoAdjust = null;
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(i3);
                paint.setPathEffect(pathEffectAutoAdjust);
                paint.setStrokeWidth(f);
                canvas.drawLine(f2, f3, f4, f5, paint);
                paint.setPathEffect(null);
                return;
            case 8:
                strokeBorderMoreLines(canvas, paint, i, f / 3.0f, f7 / 3.0f, i2, i2, f2, f3, f4, f5);
                return;
            case 9:
                if (isDarkColor(i2)) {
                    strokeBorderMoreLines(canvas, paint, i, f / 2.0f, f7 / 4.0f, brightColor(i2), i2, f2, f3, f4, f5);
                    return;
                } else {
                    strokeBorderMoreLines(canvas, paint, i, f / 2.0f, f7 / 4.0f, i2, darkenColor(i2), f2, f3, f4, f5);
                    return;
                }
            case 10:
                if (isDarkColor(i2)) {
                    strokeBorderMoreLines(canvas, paint, i, f / 2.0f, f7 / 4.0f, i2, brightColor(i2), f2, f3, f4, f5);
                    return;
                } else {
                    strokeBorderMoreLines(canvas, paint, i, f / 2.0f, f7 / 4.0f, darkenColor(i2), i2, f2, f3, f4, f5);
                    return;
                }
        }
    }
}
