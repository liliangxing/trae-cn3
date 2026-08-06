package com.bytedance.ug.sdk.deeplink.interfaces;

import android.content.ClipData;
import android.content.ClipboardManager;

/* loaded from: classes4.dex */
public interface IZLinkCompliance {
    ClipData getPrimaryClipData(ClipboardManager clipboardManager);

    void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData);
}
