package com.bytedance.webx.core;

import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.context.ExtendableContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IExtendableControl {
    ExtendableContext getExtendableContext();

    void init(WebXEnv webXEnv);
}
