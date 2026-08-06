package com.bytedance.ug.sdk.share.api.depend;

import android.content.Context;

/* loaded from: classes4.dex */
public interface IShareClipboardConfig {
    void onClipBoardResult(int i, String str);

    String readClipBoard(Context context);

    void writeClipBoard(Context context, String str);
}
