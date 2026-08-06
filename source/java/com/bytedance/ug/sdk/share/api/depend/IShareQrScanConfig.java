package com.bytedance.ug.sdk.share.api.depend;

import android.app.Activity;

/* loaded from: classes4.dex */
public interface IShareQrScanConfig {
    String getQrDecodeStr(String str);

    void handleQrScanResult(Activity activity, String str);
}
