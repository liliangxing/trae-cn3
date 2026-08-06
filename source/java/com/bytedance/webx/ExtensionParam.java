package com.bytedance.webx;

import com.bytedance.webx.core.ThreadSession;

/* loaded from: classes6.dex */
public class ExtensionParam {
    public static <T extends ExtensionParam> T selectParam(Class<T> cls) {
        ExtensionParam[] peek = ThreadSession.sExtensionParamStack.get().peek();
        if (peek == null) {
            return null;
        }
        for (ExtensionParam extensionParam : peek) {
            T t = (T) extensionParam;
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }
}
