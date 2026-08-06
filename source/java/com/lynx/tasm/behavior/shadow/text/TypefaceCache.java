package com.lynx.tasm.behavior.shadow.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.FontFaceParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes7.dex */
public class TypefaceCache {
    private static final String TAG = "TypefaceCache";
    private static final int sMaxStyles = 4;
    private static final Map<String, Typeface[]> sFontFamilyCache = new HashMap();
    private static final Map<Typeface, Typeface[]> sTypefaceCache = new HashMap();
    private static final String[] sFileExtensions = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] sFileSuffixes = {".ttf", ".otf"};
    private static ConcurrentHashMap<String, AssetsFontCache> mAssetFontCache = new ConcurrentHashMap<>();
    private static final List<LazyProvider> sLazyProviders = new ArrayList();

    /* loaded from: classes7.dex */
    public interface LazyProvider {
        Typeface getTypeface(String str, int i);
    }

    /* loaded from: classes7.dex */
    public interface TypefaceListener {
        void onTypefaceUpdate(Typeface typeface, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class AssetsFontCache {
        public Typeface mTypeface;

        AssetsFontCache(Typeface typeface) {
            this.mTypeface = typeface;
        }
    }

    public static synchronized void addLazyProvider(LazyProvider lazyProvider) {
        synchronized (TypefaceCache.class) {
            if (lazyProvider == null) {
                return;
            }
            sLazyProviders.add(lazyProvider);
        }
    }

    public static synchronized void removeLazyProvider(LazyProvider lazyProvider) {
        synchronized (TypefaceCache.class) {
            sLazyProviders.remove(lazyProvider);
        }
    }

    public static synchronized boolean containsTypeface(String str) {
        boolean containsKey;
        synchronized (TypefaceCache.class) {
            containsKey = sFontFamilyCache.containsKey(str);
        }
        return containsKey;
    }

    public static synchronized boolean containsTypeface(String str, int i) {
        boolean z;
        synchronized (TypefaceCache.class) {
            Typeface[] typefaceArr = sFontFamilyCache.get(str);
            if (typefaceArr != null) {
                z = typefaceArr[i] != null;
            }
        }
        return z;
    }

    public static synchronized void cacheTypeface(String str, int i, Typeface typeface) {
        synchronized (TypefaceCache.class) {
            Map<String, Typeface[]> map = sFontFamilyCache;
            Typeface[] typefaceArr = map.get(str);
            if (typefaceArr == null) {
                typefaceArr = new Typeface[4];
                map.put(str, typefaceArr);
            }
            typefaceArr[i] = typeface;
            sTypefaceCache.put(typeface, typefaceArr);
        }
    }

    public static synchronized void removePreRegisteredFontCache(String str) {
        synchronized (TypefaceCache.class) {
            if (str == null) {
                sFontFamilyCache.clear();
            } else {
                sFontFamilyCache.remove(str);
            }
        }
    }

    public static void cacheFullStyleTypefacesFromAssets(AssetManager assetManager, String str, String str2) {
        for (int i = 0; i < 4; i++) {
            cacheTypefaceFromAssets(assetManager, str, i, str2);
        }
    }

    public static void cacheTypefaceFromAssets(AssetManager assetManager, String str, int i, String str2) {
        Typeface typefaceFromAssets = getTypefaceFromAssets(assetManager, str, i, str2);
        if (typefaceFromAssets != null) {
            cacheTypeface(str, i, typefaceFromAssets);
        }
    }

    public static Typeface getTypefaceFromAssets(AssetManager assetManager, String str, int i, String str2) {
        String str3 = str + str2 + i;
        if (mAssetFontCache.containsKey(str3)) {
            return mAssetFontCache.get(str3).mTypeface;
        }
        StringBuilder append = new StringBuilder(32).append(str2).append((str2.endsWith("/") || str2.equals("")) ? "" : "/").append(str).append(sFileExtensions[i]);
        int length = append.length();
        for (String str4 : sFileSuffixes) {
            String sb = append.toString();
            if (!sb.endsWith(str4)) {
                sb = append.append(str4).toString();
            }
            try {
                Typeface createFromAsset = Typeface.createFromAsset(assetManager, sb);
                mAssetFontCache.put(str3, new AssetsFontCache(createFromAsset));
                return createFromAsset;
            } catch (RuntimeException e) {
                LLog.w(TAG, "Exception happens whe cacheTypefaceFromAssets with message " + e.getMessage());
                append.setLength(length);
            }
        }
        mAssetFontCache.put(str3, new AssetsFontCache(null));
        return null;
    }

    public static void cacheFullStyleTypefacesFromFile(String str, String str2) {
        for (int i = 0; i < 4; i++) {
            cacheTypefaceFromFile(str, i, str2);
        }
    }

    public static void cacheTypefaceFromFile(String str, int i, String str2) {
        TraceEvent.beginSection(TraceEventDef.TYPEFACE_CACHE_CATCH_FROM_FILE);
        Typeface typefaceFromFile = getTypefaceFromFile(str, i, str2);
        if (typefaceFromFile != null) {
            cacheTypeface(str, i, typefaceFromFile);
        }
        TraceEvent.endSection(TraceEventDef.TYPEFACE_CACHE_CATCH_FROM_FILE);
    }

    public static Typeface getTypefaceFromFile(String str, int i, String str2) {
        String[] strArr = sFileExtensions;
        StringBuilder append = new StringBuilder(32).append(str2).append((str2.endsWith("/") || str2.equals("")) ? "" : "/").append(str).append(strArr[i]);
        int length = append.length();
        for (String str3 : strArr) {
            try {
                return INVOKESTATIC_com_lynx_tasm_behavior_shadow_text_TypefaceCache_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(append.append(str3).toString());
            } catch (RuntimeException e) {
                LLog.w(TAG, "Exception happens whe cacheTypefaceFromFile with message " + e.getMessage());
                append.setLength(length);
            }
        }
        return null;
    }

    public static synchronized Typeface getTypeface(LynxContext lynxContext, String str, int i) {
        synchronized (TypefaceCache.class) {
            for (String str2 : str.split(",")) {
                String trim = FontFaceParser.trim(str2);
                if (!TextUtils.isEmpty(trim)) {
                    Typeface cachedTypeface = getCachedTypeface(trim, i);
                    if (cachedTypeface != null) {
                        return cachedTypeface;
                    }
                    Typeface typeface = FontFaceManager.getInstance().getTypeface(lynxContext, trim, i, null);
                    if (typeface != null) {
                        return typeface;
                    }
                }
            }
            LLog.v(TAG, "Can't not find typeface for fontFamily: " + str + " in lynx.");
            return null;
        }
    }

    public static synchronized Typeface getCachedTypeface(String str, int i) {
        Typeface typeface;
        Typeface typeface2;
        synchronized (TypefaceCache.class) {
            Typeface[] typefaceArr = sFontFamilyCache.get(str);
            if (typefaceArr != null && (typeface2 = typefaceArr[i]) != null) {
                return typeface2;
            }
            for (LazyProvider lazyProvider : sLazyProviders) {
                if (lazyProvider != null && (typeface = lazyProvider.getTypeface(str, i)) != null) {
                    cacheTypeface(str, i, typeface);
                    return typeface;
                }
            }
            return null;
        }
    }

    public static synchronized Typeface getTypeface(Typeface typeface, int i) {
        synchronized (TypefaceCache.class) {
            if (typeface == null) {
                return Typeface.defaultFromStyle(i);
            }
            Map<Typeface, Typeface[]> map = sTypefaceCache;
            Typeface[] typefaceArr = map.get(typeface);
            if (typefaceArr == null) {
                typefaceArr = new Typeface[4];
                typefaceArr[typeface.getStyle()] = typeface;
            } else {
                Typeface typeface2 = typefaceArr[i];
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            Typeface create = Typeface.create(typeface, i);
            typefaceArr[i] = create;
            map.put(create, typefaceArr);
            return create;
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    public static Typeface INVOKESTATIC_com_lynx_tasm_behavior_shadow_text_TypefaceCache_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(String str) {
        if (TypeFaceOptimizer.getSwitch() && str != null) {
            if (TypeFaceLancet.cache.contains(str)) {
                return (Typeface) TypeFaceLancet.cache.get(str);
            }
            Typeface createFromFile = Typeface.createFromFile(str);
            if (createFromFile != null) {
                TypeFaceLancet.cache.put(str, createFromFile);
                return createFromFile;
            }
        }
        return Typeface.createFromFile(str);
    }
}
