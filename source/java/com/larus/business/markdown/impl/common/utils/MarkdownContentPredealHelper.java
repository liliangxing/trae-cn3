package com.larus.business.markdown.impl.common.utils;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.model.SyntaxErrorCoverConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MarkdownContentPredealHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/common/utils/MarkdownContentPredealHelper;", "", "()V", "TAG", "", "config", "Lcom/larus/business/markdown/api/model/SyntaxErrorCoverConfig;", "getIndentCount", "", "line", "isOrderedListLine", "", "predealContentForSyntaxErrorCover", "content", "finished", "refineTableInList", "setConfig", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownContentPredealHelper {
    private static final String TAG = "MarkdownContentPredealHelper";
    public static final MarkdownContentPredealHelper INSTANCE = new MarkdownContentPredealHelper();
    private static SyntaxErrorCoverConfig config = new SyntaxErrorCoverConfig(false, 1, null);

    private MarkdownContentPredealHelper() {
    }

    public final void setConfig(SyntaxErrorCoverConfig config2) {
        if (config2 == null) {
            return;
        }
        config = config2;
    }

    public final String predealContentForSyntaxErrorCover(String content, boolean finished) {
        Intrinsics.checkNotNullParameter(content, "content");
        return (finished && config.getRefineTableInList()) ? refineTableInList(content) : content;
    }

    private final String refineTableInList(String content) {
        List mutableList = CollectionsKt.toMutableList(StringsKt.split$default(content, new String[]{"\n"}, false, 0, 6, (Object) null));
        int i = 0;
        while (i < mutableList.size() - 3) {
            String str = (String) mutableList.get(i);
            int indentCount = getIndentCount(str);
            if (str != null) {
                String obj = StringsKt.trimStart(str).toString();
                boolean z = StringsKt.startsWith$default(obj, "- ", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "* ", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "+ ", false, 2, (Object) null);
                boolean isOrderedListLine = isOrderedListLine(obj);
                if (z || isOrderedListLine) {
                    int i2 = i + 1;
                    String str2 = (String) mutableList.get(i2);
                    if (getIndentCount(str2) <= indentCount) {
                        if (str2 != null) {
                            if (StringsKt.startsWith$default(StringsKt.trimStart(str2).toString(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, false, 2, (Object) null)) {
                                String str3 = (String) mutableList.get(i + 2);
                                if (str3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                                String obj2 = StringsKt.trimStart(str3).toString();
                                if (StringsKt.startsWith$default(obj2, "|--", false, 2, (Object) null) || StringsKt.startsWith$default(obj2, "|:-", false, 2, (Object) null) || StringsKt.startsWith$default(obj2, "| --", false, 2, (Object) null)) {
                                    mutableList.add(i2, "\n");
                                    IMarkdownLogger markdownLogger = MarkdownService.INSTANCE.getMarkdownLogger();
                                    if (markdownLogger != null) {
                                        markdownLogger.mo2531i(TAG, "refineTableInList adding triggered, tableStartIndex[" + i2 + ']');
                                    }
                                    i += 4;
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    i = i2;
                } else {
                    i++;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        return CollectionsKt.joinToString$default(mutableList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final int getIndentCount(String line) {
        int length = line.length();
        int i = 0;
        for (int i2 = 0; i2 < length && line.charAt(i2) == ' '; i2++) {
            i++;
        }
        return i;
    }

    private final boolean isOrderedListLine(String line) {
        if (line.length() == 0) {
            return false;
        }
        int i = 0;
        while (i < line.length() && Character.isDigit(line.charAt(i))) {
            i++;
        }
        if (i == 0 || i >= line.length() || line.charAt(i) != '.') {
            return false;
        }
        int i2 = i + 1;
        return i2 < line.length() && line.charAt(i2) == ' ';
    }
}
