package com.lynx.tasm.behavior.p000ui.image;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ImageInterceptor;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.lynx.tasm.utils.ContextUtils;
import java.util.HashMap;
import javax.xml.transform.Transformer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ImageUrlRedirectUtils {
    private static final String TAG = "ImageUrlRedirectUtils";

    public static String redirectUrl(Context context, String str) {
        return redirectUrl(context, str, false);
    }

    public static String asyncRedirectUrl(LynxContext lynxContext, String str) {
        return redirectUrl(lynxContext, str, true);
    }

    private static String redirectUrl(Context context, String str, boolean z) {
        ImageInterceptor imageInterceptor;
        String shouldRedirectImageUrl;
        if (!(context instanceof LynxContext) || TextUtils.isEmpty(str)) {
            return str;
        }
        LynxContext lynxContext = ContextUtils.toLynxContext(context);
        if (lynxContext == null) {
            LLog.e(TAG, "redirecting url failed due to no context available");
            return str;
        }
        if (z) {
            imageInterceptor = lynxContext.getAsyncImageInterceptor();
        } else {
            imageInterceptor = lynxContext.imageInterceptor();
        }
        return (imageInterceptor == null || (shouldRedirectImageUrl = shouldRedirectImageUrl(imageInterceptor, str, lynxContext.getTemplateUrl())) == null) ? str : redirectResUrlIfNeed(lynxContext, shouldRedirectImageUrl);
    }

    public static void loadImage(Context context, String str, String str2, float f, float f2, Transformer transformer, ImageInterceptor.CompletionHandler completionHandler) {
        LynxContext lynxContext = ContextUtils.toLynxContext(context);
        if (lynxContext == null) {
            LLog.e(TAG, "load image failed due to no context available");
            return;
        }
        ImageInterceptor imageInterceptor = lynxContext.imageInterceptor();
        if (imageInterceptor != null) {
            imageInterceptor.loadImage(lynxContext, str, str2, f, f2, transformer, completionHandler);
        } else {
            completionHandler.imageLoadCompletion(null, null);
        }
    }

    private static String redirectResUrlIfNeed(Context context, String str) {
        boolean z;
        if (str.startsWith(ResManager.LOCAL_RESOURCE_SCHEME)) {
            for (int i = 7; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z) {
                int indexOf = str.indexOf(46);
                if (indexOf < 0) {
                    indexOf = str.length();
                }
                return ResManager.LOCAL_RESOURCE_SCHEME + context.getResources().getIdentifier(str.substring(7, indexOf), "drawable", context.getPackageName());
            }
        }
        return str;
    }

    private static String shouldRedirectImageUrl(ImageInterceptor imageInterceptor, String str, String str2) {
        String str3;
        int lastIndexOf;
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            TraceEvent.beginSection("Interceptor.shouldRedirectImageUrl", hashMap);
        }
        try {
            str3 = imageInterceptor.shouldRedirectImageUrl(str);
        } catch (Exception e) {
            LLog.d(TAG, "shouldRedirectImageUrl occurred with exception: " + e.getMessage());
            str3 = null;
        }
        TraceEvent.endSection("Interceptor.shouldRedirectImageUrl");
        if (str3 != null) {
            return str3;
        }
        if (TextUtils.isEmpty(str) || !str.startsWith("./") || TextUtils.isEmpty(str2) || (lastIndexOf = str2.lastIndexOf("/")) <= 0) {
            return null;
        }
        String str4 = str2.substring(0, lastIndexOf) + str.substring(1);
        LLog.d(TAG, "shouldRedirectImageUrl use local image url:" + str4);
        if (str4.startsWith(ImageDelegate.HTTP_PREFIX) || str4.startsWith(ResManager.FILE_SCHEME) || str4.startsWith("content://") || str4.startsWith("res://") || str4.startsWith("data:")) {
            return str4;
        }
        if (str4.startsWith("assets:///")) {
            return str4.replace("assets:///", ResManager.LOCAL_ASSET_SCHEME);
        }
        if (str4.startsWith("assets://")) {
            return str4.replace("assets://", ResManager.LOCAL_ASSET_SCHEME);
        }
        return str4.startsWith(ResManager.LOCAL_ASSET_SCHEME) ? str4 : ResManager.FILE_SCHEME + str4;
    }
}
