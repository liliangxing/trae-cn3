package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import io.noties.prism4j.Prism4j;

/* loaded from: classes.dex */
public interface Prism4jTheme {
    void apply(String str, Prism4j.Syntax syntax, SpannableStringBuilder spannableStringBuilder, int i, int i2);

    int background();

    int textColor();
}
