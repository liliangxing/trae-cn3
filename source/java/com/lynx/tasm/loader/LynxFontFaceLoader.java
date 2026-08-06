package com.lynx.tasm.loader;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.utils.TypefaceUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxFontFaceLoader {
    private static Loader sLoader = new Loader() { // from class: com.lynx.tasm.loader.LynxFontFaceLoader.1
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class Loader {
        public final Typeface loadFontFace(LynxContext lynxContext, FontFace.TYPE type, String str) {
            return onLoadFontFace(lynxContext, type, str);
        }

        protected Typeface onLoadFontFace(LynxContext lynxContext, FontFace.TYPE type, String str) {
            if (!TextUtils.isEmpty(str) && type != FontFace.TYPE.LOCAL) {
                int indexOf = str.indexOf("base64,");
                if (str.startsWith("data:") && indexOf != -1) {
                    try {
                        return TypefaceUtils.createFromBytes(lynxContext, Base64.decode(str.substring(indexOf + 7), 0));
                    } catch (Exception e) {
                        lynxContext.reportResourceError(30203, str, "font", e.getMessage());
                    }
                }
            }
            return null;
        }

        protected void reportException(LynxContext lynxContext, String str) {
            lynxContext.reportResourceError(str);
        }
    }

    public static void setLoader(Loader loader) {
        if (loader == null) {
            sLoader = new Loader() { // from class: com.lynx.tasm.loader.LynxFontFaceLoader.2
            };
        } else {
            sLoader = loader;
        }
    }

    public static Loader getLoader(LynxContext lynxContext) {
        if (lynxContext.getFontLoader() != null) {
            return lynxContext.getFontLoader();
        }
        return sLoader;
    }
}
