package com.lynx.tasm.p001ui.image.helper;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.optimize.statistics.FrescoTraceListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ByteDanceFrescoUtils {
    private static Method sPauseAnimationMethod = null;
    private static Method sSetCustomParam = null;
    private static Method sSetPreDecodeFrameCountMethod = null;
    private static Method sSetPrivateFrameSchedulerMethod = null;
    private static boolean sSupportPause = true;
    private static boolean sSupportSetCustomParam = true;

    static {
        try {
            sSetPreDecodeFrameCountMethod = ImageDecodeOptionsBuilder.class.getDeclaredMethod("setPreDecodeFrameCount", Integer.TYPE);
        } catch (Throwable th) {
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
        }
        try {
            sSetPrivateFrameSchedulerMethod = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", FrameScheduler.class);
        } catch (Throwable th2) {
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th2));
        }
    }

    public static ImageRequestBuilder fixAnimationBug(ImageRequestBuilder imageRequestBuilder) {
        return fixAnimationBug(imageRequestBuilder, Bitmap.Config.ARGB_8888, false);
    }

    public static ImageRequestBuilder fixAnimationBug(ImageRequestBuilder imageRequestBuilder, Bitmap.Config config, boolean z) {
        ILynxImageService iLynxImageService;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        ImageDecodeOptionsBuilder bitmapConfig = new ImageDecodeOptionsBuilder().setBitmapConfig(config);
        Method method = sSetPreDecodeFrameCountMethod;
        if (method != null) {
            try {
                method.invoke(bitmapConfig, 0);
            } catch (IllegalAccessException e) {
                LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
            } catch (InvocationTargetException e2) {
                LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e2));
            }
        }
        if (z && (iLynxImageService = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class)) != null) {
            iLynxImageService.setCustomImageDecoder(bitmapConfig);
        }
        imageRequestBuilder.setImageDecodeOptions(bitmapConfig.build());
        return imageRequestBuilder;
    }

    public static void fixSlowBug(AnimatedDrawable2 animatedDrawable2) {
        if (sSetPrivateFrameSchedulerMethod == null) {
            return;
        }
        try {
            sSetPrivateFrameSchedulerMethod.invoke(animatedDrawable2, new DropFramesFrameScheduler(animatedDrawable2.getAnimationBackend()));
        } catch (IllegalAccessException e) {
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        } catch (InvocationTargetException e2) {
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e2));
        }
    }

    public static void setCustomParam(ImageRequestBuilder imageRequestBuilder, Map<String, String> map) {
        if (sSupportSetCustomParam) {
            if (sSetCustomParam == null) {
                try {
                    sSetCustomParam = ImageRequestBuilder.class.getDeclaredMethod("setCustomParam", Map.class);
                } catch (Throwable th) {
                    LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
                    sSupportSetCustomParam = false;
                    return;
                }
            }
            try {
                sSetCustomParam.invoke(imageRequestBuilder, map);
            } catch (Throwable th2) {
                LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th2));
            }
        }
    }

    public static boolean pauseAnimation(AnimatedDrawable2 animatedDrawable2) {
        if (!sSupportPause) {
            return false;
        }
        if (sPauseAnimationMethod == null) {
            try {
                sPauseAnimationMethod = AnimatedDrawable2.class.getDeclaredMethod("pause", new Class[0]);
            } catch (NoSuchMethodException e) {
                sSupportPause = false;
                LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
                return false;
            }
        }
        try {
            sPauseAnimationMethod.invoke(animatedDrawable2, new Object[0]);
            return true;
        } catch (IllegalAccessException e2) {
            sSupportPause = false;
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e2));
            return false;
        } catch (InvocationTargetException e3) {
            sSupportPause = false;
            LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e3));
            return false;
        }
    }
}
