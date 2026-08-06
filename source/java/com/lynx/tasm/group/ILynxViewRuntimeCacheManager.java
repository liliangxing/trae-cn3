package com.lynx.tasm.group;

import com.lynx.tasm.ILynxEngine;
import com.lynx.tasm.TemplateBundle;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxViewRuntimeCacheManager {
    BitmapSize getBitmapSizeCache(String str);

    ILynxEngine getLynxEngine();

    TemplateBundle getTemplateBundle();

    void setBitmapSizeCache(String str, int i, int i2);

    void setLynxEngine(ILynxEngine iLynxEngine);

    void setTemplateBundle(TemplateBundle templateBundle);
}
