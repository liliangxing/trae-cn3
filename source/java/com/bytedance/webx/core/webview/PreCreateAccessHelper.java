package com.bytedance.webx.core.webview;

import android.content.Context;
import com.bytedance.webx.IContainer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PreCreateAccessHelper {
    public static <T extends IContainer> T newContainer(WebviewManager webviewManager, Context context, Class<T> cls) {
        return (T) webviewManager.newContainer(context, cls);
    }
}
