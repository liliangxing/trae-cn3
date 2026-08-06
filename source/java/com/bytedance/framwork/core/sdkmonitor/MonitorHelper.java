package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.framwork.core.sdklib.util.ProcessUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class MonitorHelper {
    private static String sProcessName;
    private static String sShortProcessName;

    public static String getShortProcessName(Context context) {
        if (sShortProcessName == null) {
            String replace = ProcessUtils.getCurProcessName(context).replace(context.getPackageName(), AirActionConstant.ActionId.ACTION_ID_PARAMS).replace(Constants.COLON_SEPARATOR, "_");
            sShortProcessName = replace;
            sShortProcessName = replace.replace(LibrarianImpl.Constants.DOT, "_");
        }
        return sShortProcessName;
    }

    public static String getProcessName(Context context) {
        if (sProcessName == null) {
            sProcessName = ProcessUtils.getCurProcessName(context);
        }
        return sProcessName;
    }
}
