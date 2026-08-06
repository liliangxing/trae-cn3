package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.SourceType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.ss.android.download.api.constant.Downloads;
import io.noties.markwon.core.spans.EmphasisSpan;
import io.noties.markwon.core.spans.StrongEmphasisSpan;
import io.noties.markwon.syntax.Prism4jThemeBase;

/* loaded from: classes.dex */
public class Prism4jThemeDefault extends Prism4jThemeBase {
    private final int background;

    @Override // io.noties.markwon.syntax.Prism4jTheme
    public int textColor() {
        return -587202560;
    }

    public static Prism4jThemeDefault create() {
        return new Prism4jThemeDefault(-658704);
    }

    public static Prism4jThemeDefault create(int i) {
        return new Prism4jThemeDefault(i);
    }

    public Prism4jThemeDefault(int i) {
        this.background = i;
    }

    @Override // io.noties.markwon.syntax.Prism4jTheme
    public int background() {
        return this.background;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    protected Prism4jThemeBase.ColorHashMap init() {
        return new Prism4jThemeBase.ColorHashMap().add(-9404272, "comment", "prolog", "doctype", "cdata").add(-6710887, "punctuation").add(-6750123, "property", "tag", "boolean", "number", "constant", "symbol", Downloads.Impl.COLUMN_DELETED).add(-10053376, "selector", "attr-name", "string", "char", SourceType.BUILTIN, "inserted").add(-6656454, OnekeyLoginConstants.CU_KEY_OPERATOR, Downloads.Impl.COLUMN_APP_DATA, "url").add(-16746582, "atrule", "attr-value", "keyword").add(-2274712, "function", "class-name").add(-1140480, "regex", "important", "variable");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public void applyColor(String str, String str2, String str3, int i, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (PreloadConfig.KEY_STYLESHEET.equals(str) && isOfType("string", str2, str3)) {
            super.applyColor(str, str2, str3, -6656454, spannableStringBuilder, i2, i3);
            spannableStringBuilder.setSpan(new BackgroundColorSpan(-2130706433), i2, i3, 33);
            return;
        }
        super.applyColor(str, str2, str3, isOfType(LynxBridgeCall.NAME_SPACE, str2, str3) ? applyAlpha(0.7f, i) : i, spannableStringBuilder, i2, i3);
        if (isOfType("important", str2, str3) || isOfType("bold", str2, str3)) {
            spannableStringBuilder.setSpan(new StrongEmphasisSpan(), i2, i3, 33);
        }
        if (isOfType("italic", str2, str3)) {
            spannableStringBuilder.setSpan(new EmphasisSpan(), i2, i3, 33);
        }
    }
}
