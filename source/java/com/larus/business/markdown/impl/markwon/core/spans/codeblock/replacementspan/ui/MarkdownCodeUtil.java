package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkdownCodeUtil.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ui/MarkdownCodeUtil;", "", "()V", "takeFirstLines", "", "text", AirActionConstant.ActionId.ACTION_ID_NAME, "", "takeLastLines", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MarkdownCodeUtil {
    public static final MarkdownCodeUtil INSTANCE = new MarkdownCodeUtil();

    private MarkdownCodeUtil() {
    }

    public static /* synthetic */ String takeLastLines$default(MarkdownCodeUtil markdownCodeUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return markdownCodeUtil.takeLastLines(str, i);
    }

    public final String takeLastLines(String text, int n) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (n <= 0) {
            return "";
        }
        int i = 0;
        for (int length = text.length() - 1; length >= 0; length--) {
            if (text.charAt(length) == '\n' && (i = i + 1) == n) {
                String substring = text.substring(length + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return text;
    }

    public static /* synthetic */ String takeFirstLines$default(MarkdownCodeUtil markdownCodeUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 20;
        }
        return markdownCodeUtil.takeFirstLines(str, i);
    }

    public final String takeFirstLines(String text, int n) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (n <= 0) {
            return "";
        }
        int length = text.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (text.charAt(i2) == '\n' && (i = i + 1) == n) {
                String substring = text.substring(0, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return text;
    }
}
