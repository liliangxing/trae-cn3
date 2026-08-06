package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import io.noties.prism4j.Prism4j;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class Prism4jThemeBase implements Prism4jTheme {
    private final ColorHashMap colorHashMap = init();

    protected static int applyAlpha(int i, int i2) {
        return (i << 24) | (i2 & 16777215);
    }

    protected abstract ColorHashMap init();

    /* JADX INFO: Access modifiers changed from: protected */
    public static int applyAlpha(float f, int i) {
        return applyAlpha((int) ((f * 255.0f) + 0.5f), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isOfType(String str, String str2, String str3) {
        return str.equals(str2) || str.equals(str3);
    }

    protected int color(String str, String str2, String str3) {
        Color color = this.colorHashMap.get(str2);
        if (color == null && str3 != null) {
            color = this.colorHashMap.get(str3);
        }
        if (color != null) {
            return color.color;
        }
        return 0;
    }

    @Override // io.noties.markwon.syntax.Prism4jTheme
    public void apply(String str, Prism4j.Syntax syntax, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        String type = syntax.type();
        String alias = syntax.alias();
        int color = color(str, type, alias);
        if (color != 0) {
            applyColor(str, type, alias, color, spannableStringBuilder, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyColor(String str, String str2, String str3, int i, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i2, i3, 33);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class Color {
        protected final int color;

        public static Color of(int i) {
            return new Color(i);
        }

        protected Color(int i) {
            this.color = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class ColorHashMap extends HashMap<String, Color> {
        /* JADX INFO: Access modifiers changed from: protected */
        public ColorHashMap add(int i, String str) {
            put(str, Color.of(i));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ColorHashMap add(int i, String str, String str2) {
            Color of = Color.of(i);
            put(str, of);
            put(str2, of);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ColorHashMap add(int i, String str, String str2, String str3) {
            Color of = Color.of(i);
            put(str, of);
            put(str2, of);
            put(str3, of);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ColorHashMap add(int i, String... strArr) {
            Color of = Color.of(i);
            for (String str : strArr) {
                put(str, of);
            }
            return this;
        }
    }
}
