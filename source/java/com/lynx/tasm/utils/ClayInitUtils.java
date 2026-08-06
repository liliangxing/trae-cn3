package com.lynx.tasm.utils;

import android.content.Context;
import com.lynx.tasm.ClayDelegate;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.provider.ResProvider;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ClayInitUtils {
    public static final String TAG = "InitClay";
    private static boolean mIsClayValid;

    public static boolean isClayValid() {
        return mIsClayValid;
    }

    public static boolean initClaySo(Context context, INativeLibraryLoader iNativeLibraryLoader, ResProvider resProvider) {
        try {
            Class.forName("com.lynx.tasm.loader.RenderkitLoader").getMethod("initRenderkit", Context.class, INativeLibraryLoader.class, ResProvider.class).invoke(null, context, iNativeLibraryLoader, resProvider);
            mIsClayValid = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LLog.e(TAG, "Reflective call RenderkitLoader.initRenderkit failed: " + e);
            mIsClayValid = false;
            return false;
        }
    }

    public static ClayDelegate initClayDelegateForLynxView(LynxView lynxView, Context context, ILynxUIRenderer iLynxUIRenderer, String str) {
        try {
            return (ClayDelegate) Class.forName("com.lynx.tasm.ClayInitiator").getDeclaredMethod("init", LynxView.class, Context.class, ILynxUIRenderer.class, String.class).invoke(null, lynxView, context, iLynxUIRenderer, str);
        } catch (ClassNotFoundException e) {
            LLog.e(TAG, "Could not init renderkit view");
            throw new RuntimeException("Fatal: init renderkit view error: " + e.getCause());
        } catch (IllegalAccessException e2) {
            LLog.e(TAG, "Could not init renderkit view");
            throw new RuntimeException("Fatal: init renderkit view error: " + e2.getCause());
        } catch (NoSuchMethodException e3) {
            LLog.e(TAG, "Could not init renderkit view");
            throw new RuntimeException("Fatal: init renderkit view error: " + e3.getCause());
        } catch (InvocationTargetException e4) {
            LLog.e(TAG, "Could not init renderkit view");
            throw new RuntimeException("Fatal: init renderkit view error: " + e4.getCause());
        }
    }
}
