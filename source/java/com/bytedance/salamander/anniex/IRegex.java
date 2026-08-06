package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: AnniexMonitorFoundationInterfaceIRegex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0014\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\n\u001a\u00020\bH&J\u001c\u0010\u000b\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/salamander/anniex/IRegex;", "", "containsMatchInput", "", "regex", "Lkotlin/text/Regex;", "Lcom/bytedance/salamander/anniex/AnnieXRegex;", "input", "", "createRegex", "pattern", "matches", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IRegex {
    boolean containsMatchInput(Regex regex, String input);

    Regex createRegex(String pattern);

    boolean matches(Regex regex, String input);
}
