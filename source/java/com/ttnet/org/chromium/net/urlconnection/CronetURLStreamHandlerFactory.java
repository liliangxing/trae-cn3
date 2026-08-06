package com.ttnet.org.chromium.net.urlconnection;

import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private final ExperimentalCronetEngine mCronetEngine;

    public CronetURLStreamHandlerFactory(ExperimentalCronetEngine experimentalCronetEngine) {
        if (experimentalCronetEngine == null) {
            throw new NullPointerException("CronetEngine is null.");
        }
        this.mCronetEngine = experimentalCronetEngine;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        if (ImageDelegate.HTTP_PREFIX.equals(str) || "https".equals(str)) {
            return new CronetHttpURLStreamHandler(this.mCronetEngine);
        }
        return null;
    }
}
