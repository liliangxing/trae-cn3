package com.bytedance.push.log;

import android.content.Context;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.client.MessageLogClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageLogClientManager {
    public static void start(Context context) {
        if (ToolUtils.isMainProcess(context)) {
            MessageLogClient.start(context);
        }
    }

    static void end(Context context) {
        if (ToolUtils.isMainProcess(context)) {
            MessageLogClient.end(context);
        }
    }
}
