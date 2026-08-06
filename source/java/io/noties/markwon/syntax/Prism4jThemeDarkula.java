package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import com.bytedance.forest.model.SourceType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.download.api.constant.Downloads;
import io.noties.markwon.core.spans.EmphasisSpan;
import io.noties.markwon.core.spans.StrongEmphasisSpan;
import io.noties.markwon.syntax.Prism4jThemeBase;

/* loaded from: classes.dex */
public class Prism4jThemeDarkula extends Prism4jThemeBase {
    private final int background;

    @Override // io.noties.markwon.syntax.Prism4jTheme
    public int textColor() {
        return -5654586;
    }

    public static Prism4jThemeDarkula create() {
        return new Prism4jThemeDarkula(-13816531);
    }

    public static Prism4jThemeDarkula create(int i) {
        return new Prism4jThemeDarkula(i);
    }

    public Prism4jThemeDarkula(int i) {
        this.background = i;
    }

    @Override // io.noties.markwon.syntax.Prism4jTheme
    public int background() {
        return this.background;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    protected Prism4jThemeBase.ColorHashMap init() {
        return new Prism4jThemeBase.ColorHashMap().add(-8355712, "comment", "prolog", "cdata").add(-3377102, "delimiter", "boolean", "keyword", "selector", "important", "atrule").add(-5654586, OnekeyLoginConstants.CU_KEY_OPERATOR, "punctuation", "attr-name").add(-1523862, "tag", "doctype", SourceType.BUILTIN).add(-9922629, Downloads.Impl.COLUMN_APP_DATA, "number", "symbol").add(-6785366, "property", "constant", "variable").add(-9795751, "string", "char").add(-4475848, "annotation").add(-5914015, "attr-value").add(-14124066, "url").add(-14739, "function").add(-13221579, "regex").add(-14072778, "inserted").add(-12039606, Downloads.Impl.COLUMN_DELETED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public void applyColor(String str, String str2, String str3, int i, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        super.applyColor(str, str2, str3, i, spannableStringBuilder, i2, i3);
        if (isOfType("important", str2, str3) || isOfType("bold", str2, str3)) {
            spannableStringBuilder.setSpan(new StrongEmphasisSpan(), i2, i3, 33);
        }
        if (isOfType("italic", str2, str3)) {
            spannableStringBuilder.setSpan(new EmphasisSpan(), i2, i3, 33);
        }
    }
}
