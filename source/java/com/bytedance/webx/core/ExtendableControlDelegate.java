package com.bytedance.webx.core;

import com.bytedance.webx.IExtension;
import com.bytedance.webx.context.ExtendableContext;
import com.bytedance.webx.context.IContextItem;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ExtendableControlDelegate {
    protected ExtendableContext mExtendableContext;

    public void setExtendableContext(ExtendableContext extendableContext) {
        this.mExtendableContext = extendableContext;
    }

    public ExtendableContext getExtendableContext() {
        return this.mExtendableContext;
    }

    public <T extends IExtension> T castExtendable(Class<T> cls) {
        IContextItem extension = this.mExtendableContext.getExtension(cls);
        if (cls.isInstance(extension)) {
            return (T) extension;
        }
        return null;
    }
}
