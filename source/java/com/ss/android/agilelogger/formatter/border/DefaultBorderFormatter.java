package com.ss.android.agilelogger.formatter.border;

import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes7.dex */
public class DefaultBorderFormatter implements BorderFormatter {
    private static final String BOTTOM_HORIZONTAL_BORDER = "╚═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final String DIVIDER_HORIZONTAL_BORDER = "╟───────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_HORIZONTAL_BORDER = "╔═══════════════════════════════════════════════════════════════════════════════════════════════════";
    private static final char VERTICAL_BORDER_CHAR = 9553;

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String[] strArr2 = new String[strArr.length];
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                strArr2[i] = str;
                i++;
            }
        }
        if (i == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(appendVerticalBorder(strArr2[i2]));
            if (i2 != i - 1) {
                sb.append("\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n");
            } else {
                sb.append("\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
            }
        }
        return sb.toString();
    }

    private static String appendVerticalBorder(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 10);
        String[] split = str.split(UpdateDialogNewBase.TYPE);
        int length = split.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(UpdateDialogNewBase.TYPE);
            }
            sb.append(VERTICAL_BORDER_CHAR).append(split[i]);
        }
        return sb.toString();
    }
}
