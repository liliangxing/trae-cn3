package com.bytedance.ug.sdk.deeplink;

import android.content.ClipData;
import android.content.Context;

/* loaded from: classes4.dex */
public interface IClipboardChecker {
    public static final int PRIORITY_FISSION = 1;
    public static final int PRIORITY_SCHEME = 0;
    public static final String TYPE_FISSION = "fission";
    public static final String TYPE_SCHEME = "scheme";

    boolean check(Context context, String str, ClipData clipData);

    int getPriority();

    boolean isMatch(String str, ClipData clipData);

    boolean isSelf(String str);

    boolean process(long j, ClipData clipData);
}
