package com.lynx.tasm.utils;

import android.text.Layout;
import android.text.StaticLayout;
import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes7.dex */
public class HuaWeiTextLayoutCompat {
    private static Field mColumnsField;
    private static Field mLinesField;

    static {
        try {
            Field declaredField = StaticLayout.class.getDeclaredField("mLines");
            mLinesField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = StaticLayout.class.getDeclaredField("mColumns");
            mColumnsField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fixEllipsizeIfNeeded(Layout layout, CharSequence charSequence) {
        int lineCount;
        int i;
        int ellipsisStart;
        if (layout == null || android.text.TextUtils.isEmpty(charSequence) || (lineCount = layout.getLineCount()) == 0 || (ellipsisStart = layout.getEllipsisStart(lineCount - 1)) < 0 || !Character.isLowSurrogate(charSequence.charAt(ellipsisStart))) {
            return;
        }
        int i2 = ellipsisStart + 1;
        if (layout instanceof StaticLayout) {
            try {
                ((int[]) mLinesField.get(layout))[(((Integer) mColumnsField.get(layout)).intValue() * i) + 5] = i2;
            } catch (Exception e) {
                Log.e("Lynx", "HuaWei emoji err", e);
                e.printStackTrace();
            }
        }
    }
}
