package com.ss.android.message.util;

import android.os.Bundle;
import com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;

/* loaded from: classes7.dex */
public class BundleUtils {
    public static String toStr(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            return VoiceAttemptMetricsTracker.FINAL_SOURCE_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : keySet) {
            sb.append(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bundle.get(str) + UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }
}
