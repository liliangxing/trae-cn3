package com.edu.onetex.latex;

import com.edu.onetex.ScreenUtilKt;
import com.edu.onetex.latex.graphic.FontStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0017\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012¢\u0006\u0002\u0010\u0017J\u000e\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0005R\u001a\u0010\u0018\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001a\u00101\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010%\"\u0004\b8\u00109R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00105¨\u0006="}, d2 = {"Lcom/edu/onetex/latex/LaTeXParam;", "", "content", "", "texWidthSize", "Lcom/edu/onetex/latex/TexSize;", "textSizeSize", "density", "", "fontStyle", "", "lineHeightMultiple", "", "alignment", "Lcom/edu/onetex/latex/TexAlignment;", "foregroundColor", "backgroundColor", "enablePhysicsFormula", "", "enableRollbackAnalysis", "splitStyle", "Lcom/edu/onetex/latex/TextSplitStyle;", "autoSpliteFormular", "(Ljava/lang/String;Lcom/edu/onetex/latex/TexSize;Lcom/edu/onetex/latex/TexSize;FIDLcom/edu/onetex/latex/TexAlignment;IIZZLcom/edu/onetex/latex/TextSplitStyle;Z)V", "alignValue", "getAlignValue", "()I", "setAlignValue", "(I)V", "getAlignment", "()Lcom/edu/onetex/latex/TexAlignment;", "getAutoSpliteFormular", "()Z", "getBackgroundColor", "getContent", "()Ljava/lang/String;", "getDensity", "()F", "getEnablePhysicsFormula", "getEnableRollbackAnalysis", "getFontStyle", "getForegroundColor", "getLineHeightMultiple", "()D", "getSplitStyle", "()Lcom/edu/onetex/latex/TextSplitStyle;", "splitStyleValue", "getSplitStyleValue", "setSplitStyleValue", "texWidth", "getTexWidth", "setTexWidth", "getTexWidthSize", "()Lcom/edu/onetex/latex/TexSize;", "textSize", "getTextSize", "setTextSize", "(F)V", "getTextSizeSize", "getSize", "texSize", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class LaTeXParam {
    private int alignValue;
    private final TexAlignment alignment;
    private final boolean autoSpliteFormular;
    private final int backgroundColor;
    private final String content;
    private final float density;
    private final boolean enablePhysicsFormula;
    private final boolean enableRollbackAnalysis;
    private final int fontStyle;
    private final int foregroundColor;
    private final double lineHeightMultiple;
    private final TextSplitStyle splitStyle;
    private int splitStyleValue;
    private int texWidth;
    private final TexSize texWidthSize;
    private float textSize;
    private final TexSize textSizeSize;

    public LaTeXParam(String content, TexSize texWidthSize, TexSize textSizeSize, float f, int i, double d, TexAlignment alignment, int i2, int i3, boolean z, boolean z2, TextSplitStyle splitStyle, boolean z3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(texWidthSize, "texWidthSize");
        Intrinsics.checkNotNullParameter(textSizeSize, "textSizeSize");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(splitStyle, "splitStyle");
        this.content = content;
        this.texWidthSize = texWidthSize;
        this.textSizeSize = textSizeSize;
        this.density = f;
        this.fontStyle = i;
        this.lineHeightMultiple = d;
        this.alignment = alignment;
        this.foregroundColor = i2;
        this.backgroundColor = i3;
        this.enablePhysicsFormula = z;
        this.enableRollbackAnalysis = z2;
        this.splitStyle = splitStyle;
        this.autoSpliteFormular = z3;
        this.texWidth = (int) getSize(texWidthSize);
        this.textSize = getSize(textSizeSize);
        this.alignValue = alignment.getValue();
        this.splitStyleValue = splitStyle.getValue();
        texWidthSize.setDensity(f);
        textSizeSize.setDensity(f);
    }

    public final String getContent() {
        return this.content;
    }

    public final TexSize getTexWidthSize() {
        return this.texWidthSize;
    }

    public final TexSize getTextSizeSize() {
        return this.textSizeSize;
    }

    public /* synthetic */ LaTeXParam(String str, TexSize texSize, TexSize texSize2, float f, int i, double d, TexAlignment texAlignment, int i2, int i3, boolean z, boolean z2, TextSplitStyle textSplitStyle, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, texSize, texSize2, (i4 & 8) != 0 ? ScreenUtilKt.getScreenDensity() : f, (i4 & 16) != 0 ? FontStyle.Regular.getValue() : i, (i4 & 32) != 0 ? 1.14d : d, (i4 & 64) != 0 ? TexAlignment.JUSTIFIED : texAlignment, (i4 & 128) != 0 ? -16777216 : i2, (i4 & 256) != 0 ? 0 : i3, (i4 & 512) != 0 ? true : z, (i4 & 1024) != 0 ? false : z2, (i4 & 2048) != 0 ? TextSplitStyle.SPLIT_STYLE_CHAR : textSplitStyle, (i4 & 4096) != 0 ? false : z3);
    }

    public final float getDensity() {
        return this.density;
    }

    public final int getFontStyle() {
        return this.fontStyle;
    }

    public final double getLineHeightMultiple() {
        return this.lineHeightMultiple;
    }

    public final TexAlignment getAlignment() {
        return this.alignment;
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final boolean getEnablePhysicsFormula() {
        return this.enablePhysicsFormula;
    }

    public final boolean getEnableRollbackAnalysis() {
        return this.enableRollbackAnalysis;
    }

    public final TextSplitStyle getSplitStyle() {
        return this.splitStyle;
    }

    public final boolean getAutoSpliteFormular() {
        return this.autoSpliteFormular;
    }

    protected final int getTexWidth() {
        return this.texWidth;
    }

    protected final void setTexWidth(int i) {
        this.texWidth = i;
    }

    protected final float getTextSize() {
        return this.textSize;
    }

    protected final void setTextSize(float f) {
        this.textSize = f;
    }

    protected final int getAlignValue() {
        return this.alignValue;
    }

    protected final void setAlignValue(int i) {
        this.alignValue = i;
    }

    protected final int getSplitStyleValue() {
        return this.splitStyleValue;
    }

    protected final void setSplitStyleValue(int i) {
        this.splitStyleValue = i;
    }

    public final float getSize(TexSize texSize) {
        float size;
        float f;
        Intrinsics.checkNotNullParameter(texSize, "texSize");
        int unit = texSize.getUnit();
        if (unit == 0) {
            return texSize.getSize();
        }
        if (unit == 1) {
            size = texSize.getSize();
            f = this.density;
        } else if (unit == 2) {
            size = texSize.getSize();
            f = this.density;
        } else {
            return texSize.getSize();
        }
        return size * f;
    }
}
