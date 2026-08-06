package io.noties.markwon.html;

import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes6.dex */
public class HtmlEmptyTagReplacement {
    private static final String IFRAME_REPLACEMENT = " ";
    private static final String IMG_REPLACEMENT = "￼";

    public static HtmlEmptyTagReplacement create() {
        return new HtmlEmptyTagReplacement();
    }

    public String replace(HtmlTag htmlTag) {
        String name = htmlTag.name();
        if ("br".equals(name)) {
            return UpdateDialogNewBase.TYPE;
        }
        if ("img".equals(name)) {
            String str = htmlTag.attributes().get(CustomDataTagHandler.ALT_ATTRIBUTE);
            return (str == null || str.length() == 0) ? IMG_REPLACEMENT : str;
        }
        if ("iframe".equals(name)) {
            return IFRAME_REPLACEMENT;
        }
        return null;
    }
}
