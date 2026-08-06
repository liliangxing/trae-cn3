package com.bytedance.ug.sdk.share.api.depend;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IShareImageTokenConfig {
    void checkImageToken();

    void checkSelectedMediaToken(String str);

    void handleAppBackground();

    boolean showImageTokenDialog(Context context, ShareContent shareContent);
}
