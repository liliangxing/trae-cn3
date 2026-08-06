package com.lynx.tasm.provider;

import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsTemplateProvider {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Callback {
        void onFailed(String str);

        void onSuccess(byte[] bArr);
    }

    public abstract void loadTemplate(String str, Callback callback);

    public void loadTemplate(String str, Callback callback, LynxContext lynxContext) {
        loadTemplate(str, callback);
    }
}
