package com.ss.android.message.util;

import android.content.Intent;
import com.bytedance.push.utils.Logger;
import java.util.HashSet;

/* loaded from: classes7.dex */
public class IntentSecurityUtils {
    private static final int IMMUTABLE_FLAGS = 195;

    public static boolean isSafeIntent(Intent intent) {
        if (intent == null) {
            Logger.w("IntentSecurityUtils", "[isSafeIntent]return false because intent is null");
            return false;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("android.intent.action.CHOOSER");
        hashSet.add("android.intent.action.SEND");
        hashSet.add("android.intent.action.SEND_MULTIPLE");
        hashSet.add("android.media.action.IMAGE_CAPTURE");
        hashSet.add("android.media.action.IMAGE_CAPTURE_SECURE");
        hashSet.add("android.media.action.VIDEO_CAPTURE");
        if (hashSet.contains(intent.getAction())) {
            Logger.w("IntentSecurityUtils", "[isSafeIntent]return false because intent action is " + intent.getAction());
            return false;
        }
        if ((intent.getFlags() & 195) != 0) {
            Logger.w("IntentSecurityUtils", "[isSafeIntent]return false because intent flag is " + intent.getFlags());
            return false;
        }
        Logger.i("IntentSecurityUtils", "[isSafeIntent]return true");
        return true;
    }
}
