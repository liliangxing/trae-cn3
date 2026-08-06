package com.bytedance.salamander.anniex;

import com.bytedance.webx.addr.AddressParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: AnniexMonitorFoundationImplRegexUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0014\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXRegexUtils;", "Lcom/bytedance/salamander/anniex/IRegex;", "()V", "containsMatchInput", "", "regex", "Lkotlin/text/Regex;", "Lcom/bytedance/salamander/anniex/AnnieXRegex;", "input", "", "createRegex", AddressParam.SETTING_BDWK_EXTENSION_PATTERN, "matches", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class AnnieXRegexUtils implements IRegex {
    @Override // com.bytedance.salamander.anniex.IRegex
    public Regex createRegex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return new Regex(pattern);
    }

    @Override // com.bytedance.salamander.anniex.IRegex
    public boolean matches(Regex regex, String input) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(input, "input");
        return regex.matches(input);
    }

    @Override // com.bytedance.salamander.anniex.IRegex
    public boolean containsMatchInput(Regex regex, String input) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(input, "input");
        return regex.containsMatchIn(input);
    }
}
