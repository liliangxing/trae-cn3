package com.edu.onetex.latex.graphic;

import kotlin.Metadata;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BoldItalic' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FontStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/edu/onetex/latex/graphic/FontStyle;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Regular", "Bold", "Italic", "BoldItalic", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FontStyle {
    private static final /* synthetic */ FontStyle[] $VALUES;
    public static final FontStyle Bold;
    public static final FontStyle BoldItalic;
    public static final FontStyle Italic;
    public static final FontStyle Regular;
    private final int value;

    public static FontStyle valueOf(String str) {
        return (FontStyle) Enum.valueOf(FontStyle.class, str);
    }

    public static FontStyle[] values() {
        return (FontStyle[]) $VALUES.clone();
    }

    private FontStyle(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        FontStyle fontStyle = new FontStyle("Regular", 0, 0);
        Regular = fontStyle;
        FontStyle fontStyle2 = new FontStyle("Bold", 1, 2);
        Bold = fontStyle2;
        FontStyle fontStyle3 = new FontStyle("Italic", 2, 4);
        Italic = fontStyle3;
        FontStyle fontStyle4 = new FontStyle("BoldItalic", 3, fontStyle2.value | fontStyle3.value);
        BoldItalic = fontStyle4;
        $VALUES = new FontStyle[]{fontStyle, fontStyle2, fontStyle3, fontStyle4};
    }
}
