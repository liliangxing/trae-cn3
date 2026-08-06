package com.bytedance.ug.sdk.share.api.depend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ISharePermissionConfig {
    boolean hasPermission(Context context, String str);

    void requestPermissions(Activity activity, String[] strArr, ShareContent shareContent, RequestPermissionsCallback requestPermissionsCallback);
}
