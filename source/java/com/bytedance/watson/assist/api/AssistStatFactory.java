package com.bytedance.watson.assist.api;

import android.content.Context;
import com.bytedance.watson.assist.core.AssistStatImp;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AssistStatFactory {
    public static IAssistStat create(Context context) {
        if (context == null) {
            return null;
        }
        return AssistStatImp.getInstance(context);
    }

    public static IAssistStat create(Context context, AssistConfig assistConfig) {
        if (context == null) {
            return null;
        }
        return AssistStatImp.createNewInstance(context, assistConfig);
    }
}
