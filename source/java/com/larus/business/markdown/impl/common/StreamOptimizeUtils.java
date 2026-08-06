package com.larus.business.markdown.impl.common;

import io.noties.markwon.html.tag.ImageGridHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StreamOptimizeUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007J\u001c\u0010\u000f\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/common/StreamOptimizeUtils;", "", "()V", "deleteUnCompleteHtmlTag", "", "source", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "findLastUnescapedBracket", "", "input", "", "startIndex", "tryCompleteLink", "", "tryOptImgExclamationMarkChar", ImageGridHandler.Index, "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class StreamOptimizeUtils {
    public static final StreamOptimizeUtils INSTANCE = new StreamOptimizeUtils();

    private StreamOptimizeUtils() {
    }

    public final boolean tryCompleteLink(StringBuilder source) {
        int i;
        Character orNull;
        Intrinsics.checkNotNullParameter(source, "source");
        int length = source.length();
        while (length > 0) {
            length--;
            char charAt = source.charAt(length);
            if (charAt == ')') {
                Character orNull2 = StringsKt.getOrNull(source, length - 1);
                if (orNull2 == null || orNull2.charValue() != '\\') {
                    return false;
                }
            } else {
                if (charAt == '\n') {
                    return false;
                }
                if (charAt == '(') {
                    StringBuilder sb = source;
                    int i2 = length - 1;
                    Character orNull3 = StringsKt.getOrNull(sb, i2);
                    if (orNull3 == null || orNull3.charValue() != '\\') {
                        Character orNull4 = StringsKt.getOrNull(sb, i2);
                        if (orNull4 != null && orNull4.charValue() == ']') {
                            String sb2 = source.toString();
                            Intrinsics.checkNotNullExpressionValue(sb2, "source.toString()");
                            int findLastUnescapedBracket = findLastUnescapedBracket(sb2, length - 2);
                            if (findLastUnescapedBracket < 0) {
                                return false;
                            }
                            source.delete(i2, source.length());
                            source.deleteCharAt(findLastUnescapedBracket);
                            tryOptImgExclamationMarkChar(source, findLastUnescapedBracket - 1);
                            return true;
                        }
                    }
                } else if (charAt == ']') {
                    int i3 = length - 1;
                    Character orNull5 = StringsKt.getOrNull(source, i3);
                    if (orNull5 == null || orNull5.charValue() != '\\') {
                        String sb3 = source.toString();
                        Intrinsics.checkNotNullExpressionValue(sb3, "source.toString()");
                        int findLastUnescapedBracket2 = findLastUnescapedBracket(sb3, i3);
                        if (findLastUnescapedBracket2 < 0) {
                            return false;
                        }
                        source.delete(length, source.length());
                        source.deleteCharAt(findLastUnescapedBracket2);
                        tryOptImgExclamationMarkChar(source, findLastUnescapedBracket2 - 1);
                        return true;
                    }
                } else if (charAt == '[' && ((orNull = StringsKt.getOrNull(source, length - 1)) == null || orNull.charValue() != '\\')) {
                    source.deleteCharAt(length);
                    tryOptImgExclamationMarkChar(source, i);
                    return true;
                }
            }
        }
        return false;
    }

    private final int findLastUnescapedBracket(String input, int startIndex) {
        Character orNull;
        while (-1 < startIndex) {
            String str = input;
            Character orNull2 = StringsKt.getOrNull(str, startIndex);
            if (orNull2 != null && orNull2.charValue() == '[' && ((orNull = StringsKt.getOrNull(str, startIndex - 1)) == null || orNull.charValue() != '\\')) {
                return startIndex;
            }
            startIndex--;
        }
        return -1;
    }

    private final void tryOptImgExclamationMarkChar(StringBuilder source, int index) {
        StringBuilder sb = source;
        Character orNull = StringsKt.getOrNull(sb, index);
        if (orNull != null && orNull.charValue() == '!') {
            Character orNull2 = StringsKt.getOrNull(sb, index - 1);
            if (orNull2 != null && orNull2.charValue() == '\\') {
                return;
            }
            source.delete(index, source.length());
        }
    }

    public final void deleteUnCompleteHtmlTag(StringBuilder source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int length = source.length() - 1;
        boolean z = false;
        while (length > 0) {
            StringBuilder sb = source;
            Character orNull = StringsKt.getOrNull(sb, length);
            if (orNull != null && orNull.charValue() == '<') {
                Character orNull2 = StringsKt.getOrNull(sb, length + 1);
                if (orNull2 != null) {
                    if (orNull2.charValue() == '/') {
                        if (z) {
                            return;
                        }
                        char orNull3 = StringsKt.getOrNull(sb, length + 2);
                        if (orNull3 == null) {
                            orNull3 = 'A';
                        }
                        orNull2 = orNull3;
                    }
                    char charValue = orNull2.charValue();
                    if (!('0' <= charValue && charValue < ':')) {
                        char charValue2 = orNull2.charValue();
                        if (!('A' <= charValue2 && charValue2 < '[')) {
                            return;
                        }
                    }
                }
                source.delete(length, source.length());
                return;
            }
            if (orNull == null || orNull.charValue() != '>') {
                length--;
            } else {
                if (length != source.length() - 1) {
                    return;
                }
                Character orNull4 = StringsKt.getOrNull(sb, length - 1);
                if (orNull4 != null && orNull4.charValue() == '/') {
                    return;
                }
                length--;
                z = true;
            }
        }
    }
}
