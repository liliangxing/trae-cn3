package com.lynx.tasm.behavior;

import android.content.Context;
import javax.xml.transform.Transformer;

/* loaded from: classes7.dex */
public interface ImageInterceptor {

    /* loaded from: classes7.dex */
    public interface CompletionHandler {
        void imageLoadCompletion(Object obj, Throwable th);
    }

    void loadImage(Context context, String str, String str2, float f, float f2, Transformer transformer, CompletionHandler completionHandler);

    String shouldRedirectImageUrl(String str);
}
