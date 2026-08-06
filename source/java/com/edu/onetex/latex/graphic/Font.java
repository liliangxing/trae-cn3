package com.edu.onetex.latex.graphic;

import android.app.Application;
import android.graphics.Typeface;
import com.edu.onetex.OneTeXInitializer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Font.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/edu/onetex/latex/graphic/Font;", "", "typeface", "Landroid/graphics/Typeface;", "size", "", "isItalic", "", "(Landroid/graphics/Typeface;FZ)V", "()Z", "deriveFont", "style", "", "getSize", "getTypeface", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Font {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TEX_FONT_STYLE_BOLD = 2;
    private static final int TEX_FONT_STYLE_ITALIC = 4;
    private static final int TEX_FONT_STYLE_PLAIN = 1;
    private final boolean isItalic;
    private final float size;
    private final Typeface typeface;

    @JvmStatic
    public static final Font create(String str, float f) {
        return INSTANCE.create(str, f);
    }

    @JvmStatic
    public static final Font create(String str, int i, float f) {
        return INSTANCE.create(str, i, f);
    }

    public Font(Typeface typeface, float f, boolean z) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
        this.size = f;
        this.isItalic = z;
    }

    /* renamed from: isItalic, reason: from getter */
    public final boolean getIsItalic() {
        return this.isItalic;
    }

    public final Font deriveFont(int style) {
        if (this.typeface.getStyle() == style) {
            return this;
        }
        Typeface typeface = Typeface.create(this.typeface, style);
        Intrinsics.checkNotNullExpressionValue(typeface, "typeface");
        return new Font(typeface, this.size, this.isItalic);
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public final float getSize() {
        return this.size;
    }

    /* compiled from: Font.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/edu/onetex/latex/graphic/Font$Companion;", "", "()V", "TEX_FONT_STYLE_BOLD", "", "TEX_FONT_STYLE_ITALIC", "TEX_FONT_STYLE_PLAIN", "create", "Lcom/edu/onetex/latex/graphic/Font;", "file", "", "size", "", "name", "style", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Font create(String name, int style, float size) {
            int i = 1;
            boolean z = false;
            if (style != 2 && style != 3) {
                if (style == 4 || style == 5) {
                    z = true;
                    i = 0;
                } else if (style == 6) {
                    z = true;
                } else {
                    i = 0;
                }
            }
            Typeface typeface = Typeface.create(name, i);
            Intrinsics.checkNotNullExpressionValue(typeface, "typeface");
            return new Font(typeface, size, z);
        }

        @JvmStatic
        public final Font create(String file, float size) {
            if (OneTeXInitializer.INSTANCE.getApplication$onetex_release() == null) {
                throw new IllegalStateException("application 没有初始化");
            }
            try {
                Application application$onetex_release = OneTeXInitializer.INSTANCE.getApplication$onetex_release();
                Intrinsics.checkNotNull(application$onetex_release);
                Typeface tf = Typeface.createFromAsset(application$onetex_release.getAssets(), file);
                Intrinsics.checkNotNullExpressionValue(tf, "tf");
                return new Font(tf, size, false);
            } catch (Exception unused) {
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "Typeface.DEFAULT");
                return new Font(typeface, size, false);
            }
        }
    }
}
