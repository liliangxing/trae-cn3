package com.bytedance.notification.utils;

import android.text.Html;
import android.text.SpannableString;
import com.bytedance.push.utils.Logger;

/* loaded from: classes4.dex */
public class RichTextUtils {
    private static String TAG = "RichTextUtils";

    public static SpannableString getRichTextFromRawText(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.isEmpty()) {
                return null;
            }
            return new SpannableString(Html.fromHtml(str, 0));
        } catch (Exception e) {
            Logger.d(TAG, e.getMessage());
            return null;
        }
    }
}
