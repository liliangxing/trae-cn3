package com.bytedance.ug.sdk.deeplink.interfaces;

import android.content.ClipData;
import android.content.Context;

/* loaded from: classes4.dex */
public interface IClipboard {
    void appendTextToClipboard(Context context, CharSequence charSequence);

    void clearClipBoard(Context context);

    void clearClipBoard(Context context, String str, ClipData clipData);

    ClipData getClipBoardContent(Context context);

    void writeClipBoard(Context context, CharSequence charSequence, CharSequence charSequence2);
}
