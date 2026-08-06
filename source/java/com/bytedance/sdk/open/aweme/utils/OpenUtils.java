package com.bytedance.sdk.open.aweme.utils;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class OpenUtils {
    public static String[] arrayUnique(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    return (String[]) new HashSet(new ArrayList(Arrays.asList(strArr))).toArray(new String[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strArr;
    }

    public static String flavor() {
        return "chinainternal";
    }

    public static boolean isExternal() {
        return TextUtils.equals("chinainternal", "chinaexternal");
    }

    public static boolean isInternal() {
        return TextUtils.equals("chinainternal", "chinainternal");
    }

    public static void setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !visibilityValid(i)) {
            return;
        }
        view.setVisibility(i);
    }

    private static boolean visibilityValid(int i) {
        return i == 0 || i == 8 || i == 4;
    }
}
