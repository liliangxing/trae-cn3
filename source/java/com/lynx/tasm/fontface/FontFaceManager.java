package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.fontface.FontFace;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import com.lynx.tasm.provider.LynxProviderRegistry;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.generic.LynxGenericResourceFetcher;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.TypefaceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FontFaceManager {
    private static final String BASE64_SRC_CONTAIN = "base64,";
    private static final String BASE64_SRC_PREFIX = "data:";
    private static final String LOCAL_ASSET_PREFIX = "asset:///";
    private static final String LOCAL_SRC_PREFIX = "file://";
    private static final int MAX_FONT_SETTINGS_CACHE_SIZE = 50;
    private static final String TAG = "FontFaceManager";
    private static final String URL_HTTP_SRC_PREFIX = "http";
    private static final String URL_SRC_PREFIX = "https";
    private Map<String, StyledTypeface> mCacheTypeface = new HashMap();
    private List<FontFaceGroup> mLoadingFontFace = new ArrayList();
    private final Map<FontSettingsKey, Typeface> mFontSettingsCache = Collections.synchronizedMap(new LinkedHashMap<FontSettingsKey, Typeface>(16, 0.75f, true) { // from class: com.lynx.tasm.fontface.FontFaceManager.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<FontSettingsKey, Typeface> entry) {
            return size() > 50;
        }
    });

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class Holder {
        static final FontFaceManager INSTANCE = new FontFaceManager();

        private Holder() {
        }
    }

    public static FontFaceManager getInstance() {
        return Holder.INSTANCE;
    }

    public Typeface getFontWithSettings(FontSettingsKey fontSettingsKey) {
        return this.mFontSettingsCache.get(fontSettingsKey);
    }

    public void putFontWithSettings(FontSettingsKey fontSettingsKey, Typeface typeface) {
        if (typeface != null) {
            this.mFontSettingsCache.put(fontSettingsKey, typeface);
        }
    }

    public Typeface getTypeface(final LynxContext lynxContext, final String str, final int i, final TypefaceCache.TypefaceListener typefaceListener) {
        final FontFace fontFace = lynxContext.getFontFace(str);
        if (fontFace == null) {
            return null;
        }
        synchronized (this) {
            StyledTypeface cacheTypeface = getCacheTypeface(fontFace);
            if (cacheTypeface != null && cacheTypeface.checkTypefaceHasCreated(i)) {
                return cacheTypeface.getStyledTypeFace(i);
            }
            final StyledTypeface typeface = fontFace.getTypeface();
            final Handler handler = new Handler(Looper.myLooper());
            if (typeface != null) {
                if (typefaceListener != null) {
                    handler.post(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LLog.i(LynxConstants.TAG, "load font success " + str + i);
                            if (Build.VERSION.SDK_INT < 28) {
                                FontFaceManager.this.invokeTypefaceListenerOnUIThread(handler, typefaceListener, typeface, i);
                            } else {
                                typefaceListener.onTypefaceUpdate(typeface.getStyledTypeFace(i), i);
                            }
                        }
                    });
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    return typeface.getStyledTypeFace(i);
                }
                return typeface.getStyledTypeFace(0);
            }
            LynxThreadPool.getBriefIOExecutor().execute(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.3
                @Override // java.lang.Runnable
                public void run() {
                    FontFaceManager.this.findOrLoadFontFace(lynxContext, fontFace, i, typefaceListener, handler);
                }
            });
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findOrLoadFontFace(LynxContext lynxContext, FontFace fontFace, final int i, final TypefaceCache.TypefaceListener typefaceListener, Handler handler) {
        synchronized (this) {
            StyledTypeface cacheTypeface = getCacheTypeface(fontFace);
            if (cacheTypeface != null) {
                fontFace.setStyledTypeface(cacheTypeface);
                cacheSrc(fontFace, cacheTypeface);
                if (Build.VERSION.SDK_INT >= 28) {
                    final Typeface styledTypeFace = cacheTypeface.getStyledTypeFace(i);
                    if (typefaceListener == null) {
                        return;
                    } else {
                        handler.post(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.4
                            @Override // java.lang.Runnable
                            public void run() {
                                LLog.i(LynxConstants.TAG, "load font success");
                                typefaceListener.onTypefaceUpdate(styledTypeFace, i);
                            }
                        });
                    }
                } else if (typefaceListener == null) {
                    return;
                } else {
                    invokeTypefaceListenerOnUIThread(handler, typefaceListener, cacheTypeface, i);
                }
                return;
            }
            for (FontFaceGroup fontFaceGroup : this.mLoadingFontFace) {
                if (fontFaceGroup.isSameFontFace(fontFace)) {
                    fontFaceGroup.addFontFace(fontFace);
                    fontFaceGroup.addListener(new Pair<>(typefaceListener, Integer.valueOf(i)));
                    return;
                }
            }
            FontFaceGroup fontFaceGroup2 = new FontFaceGroup();
            fontFaceGroup2.addListener(new Pair<>(typefaceListener, Integer.valueOf(i)));
            fontFaceGroup2.addFontFace(fontFace);
            this.mLoadingFontFace.add(fontFaceGroup2);
            Iterator<Pair<FontFace.TYPE, String>> it = fontFace.getSrc().iterator();
            Iterator<Pair<FontFace.TYPE, String>> it2 = fontFace.getSrc().iterator();
            if (lynxContext.getGenericResourceFetcher() != null) {
                TraceEvent.beginSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
                LLog.i(TAG, "Try to loadTypeface with GenericLynxResourceFetcher.");
                loadTypefaceWithGenericLynxResourceFetcher(lynxContext, fontFaceGroup2, it, it2, handler);
                TraceEvent.endSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
                return;
            }
            TraceEvent.beginSection("FontFaceManager.loadTypeface");
            loadTypeface(lynxContext, fontFaceGroup2, it, handler);
            TraceEvent.endSection("FontFaceManager.loadTypeface");
        }
    }

    private synchronized void cacheSrc(FontFace fontFace, StyledTypeface styledTypeface) {
        for (Pair<FontFace.TYPE, String> pair : fontFace.getSrc()) {
            this.mCacheTypeface.put(((FontFace.TYPE) pair.first).name() + ((String) pair.second), styledTypeface);
        }
    }

    private String getPathFromFontResourceProvider(LynxResourceProvider lynxResourceProvider, final LynxContext lynxContext, FontFace.TYPE type, final String str) {
        final String[] strArr = new String[1];
        Bundle bundle = new Bundle();
        bundle.putString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, type.toString());
        lynxResourceProvider.request(new LynxResourceRequest(str, bundle), new LynxResourceCallback<String>() { // from class: com.lynx.tasm.fontface.FontFaceManager.5
            @Override // com.lynx.tasm.provider.LynxResourceCallback
            public void onResponse(LynxResourceResponse<String> lynxResourceResponse) {
                super.onResponse(lynxResourceResponse);
                String data = lynxResourceResponse.getData();
                if (!lynxResourceResponse.success()) {
                    FontFaceManager.this.reportError(30202, lynxResourceResponse.getError().getMessage(), str, null, lynxContext);
                } else {
                    strArr[0] = data;
                }
            }
        });
        return strArr[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadTypeface(LynxContext lynxContext, final FontFaceGroup fontFaceGroup, Iterator<Pair<FontFace.TYPE, String>> it, final Handler handler) {
        Typeface typeface;
        String pathFromFontResourceProvider;
        if (!it.hasNext()) {
            return;
        }
        Pair<FontFace.TYPE, String> next = it.next();
        LynxResourceProvider providerByKey = lynxContext.getProviderRegistry().getProviderByKey(LynxProviderRegistry.LYNX_PROVIDER_TYPE_FONT);
        if (providerByKey != null && !((String) next.second).startsWith(BASE64_SRC_PREFIX) && (pathFromFontResourceProvider = getPathFromFontResourceProvider(providerByKey, lynxContext, (FontFace.TYPE) next.first, (String) next.second)) != null) {
            if (pathFromFontResourceProvider.startsWith(URL_SRC_PREFIX)) {
                typeface = LynxFontFaceLoader.getLoader(lynxContext).loadFontFace(lynxContext, FontFace.TYPE.URL, pathFromFontResourceProvider);
            } else if (pathFromFontResourceProvider.startsWith("file://")) {
                typeface = createTypefaceFromFile(pathFromFontResourceProvider.substring(7), lynxContext);
            } else if (pathFromFontResourceProvider.startsWith("asset:///")) {
                try {
                    typeface = Typeface.createFromAsset(LynxEnv.inst().getAppContext().getAssets(), pathFromFontResourceProvider.substring(9));
                } catch (RuntimeException e) {
                    reportError(30205, "Create typeface from local asset failed", pathFromFontResourceProvider, e, lynxContext);
                }
            }
            if (typeface == null) {
                typeface = LynxFontFaceLoader.getLoader(lynxContext).loadFontFace(lynxContext, (FontFace.TYPE) next.first, (String) next.second);
            }
            if (typeface != null) {
                loadTypeface(lynxContext, fontFaceGroup, it, handler);
                return;
            }
            final StyledTypeface styledTypeface = new StyledTypeface(typeface);
            synchronized (this) {
                for (FontFace fontFace : fontFaceGroup.getFontFaces()) {
                    fontFace.setStyledTypeface(styledTypeface);
                    cacheSrc(fontFace, styledTypeface);
                }
                this.mLoadingFontFace.remove(fontFaceGroup);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Iterator<Pair<TypefaceCache.TypefaceListener, Integer>> it2 = fontFaceGroup.getListeners().iterator();
                while (it2.hasNext()) {
                    styledTypeface.getStyledTypeFace(((Integer) it2.next().second).intValue());
                }
            }
            handler.post(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<Pair<TypefaceCache.TypefaceListener, Integer>> it3 = fontFaceGroup.getListeners().iterator();
                    while (it3.hasNext()) {
                        Pair<TypefaceCache.TypefaceListener, Integer> next2 = it3.next();
                        it3.remove();
                        if (next2.first != null) {
                            if (Build.VERSION.SDK_INT < 28) {
                                FontFaceManager.this.invokeTypefaceListenerOnUIThread(handler, (TypefaceCache.TypefaceListener) next2.first, styledTypeface, ((Integer) next2.second).intValue());
                            } else {
                                LLog.i(LynxConstants.TAG, "load font success");
                                ((TypefaceCache.TypefaceListener) next2.first).onTypefaceUpdate(styledTypeface.getStyledTypeFace(((Integer) next2.second).intValue()), ((Integer) next2.second).intValue());
                            }
                        }
                    }
                }
            });
            return;
        }
        typeface = null;
        if (typeface == null) {
        }
        if (typeface != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadTypefaceWithGenericLynxResourceFetcher(LynxContext lynxContext, final FontFaceGroup fontFaceGroup, Iterator<Pair<FontFace.TYPE, String>> it, Iterator<Pair<FontFace.TYPE, String>> it2, final Handler handler) {
        Typeface typeface;
        if (!it.hasNext()) {
            LLog.w(TAG, "load typeface with GenericLynxResourceFetcher failed, try loadTypeface.");
            loadTypeface(lynxContext, fontFaceGroup, it2, handler);
            return;
        }
        Pair<FontFace.TYPE, String> next = it.next();
        String str = (String) next.second;
        if (!TextUtils.isEmpty(str)) {
            if (FontFace.TYPE.LOCAL == next.first) {
                if (str.startsWith("file://")) {
                    typeface = createTypefaceFromFile(str.substring(7), lynxContext);
                }
            } else if (str.startsWith(BASE64_SRC_PREFIX) && str.contains(BASE64_SRC_CONTAIN)) {
                typeface = loadFromBase64(lynxContext, (FontFace.TYPE) next.first, str);
            } else if (str.startsWith("http")) {
                typeface = loadTypeFaceFromHttpSRCByGenericResourceFetcher(lynxContext, str);
            } else {
                reportError(30201, "Src format is incorrect", str, null, lynxContext);
            }
            if (typeface != null) {
                loadTypefaceWithGenericLynxResourceFetcher(lynxContext, fontFaceGroup, it, it2, handler);
                return;
            }
            LLog.i(TAG, "Lynx load typeface with GenericLynxResourceFetcher success.");
            final StyledTypeface styledTypeface = new StyledTypeface(typeface);
            synchronized (this) {
                for (FontFace fontFace : fontFaceGroup.getFontFaces()) {
                    fontFace.setStyledTypeface(styledTypeface);
                    cacheSrc(fontFace, styledTypeface);
                }
                this.mLoadingFontFace.remove(fontFaceGroup);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Iterator<Pair<TypefaceCache.TypefaceListener, Integer>> it3 = fontFaceGroup.getListeners().iterator();
                while (it3.hasNext()) {
                    styledTypeface.getStyledTypeFace(((Integer) it3.next().second).intValue());
                }
            }
            handler.post(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.7
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<Pair<TypefaceCache.TypefaceListener, Integer>> it4 = fontFaceGroup.getListeners().iterator();
                    while (it4.hasNext()) {
                        Pair<TypefaceCache.TypefaceListener, Integer> next2 = it4.next();
                        it4.remove();
                        if (next2.first != null) {
                            FontFaceManager.this.typefaceHandlerPost(handler, (TypefaceCache.TypefaceListener) next2.first, styledTypeface, (Integer) next2.second);
                        }
                    }
                }
            });
            return;
        }
        typeface = null;
        if (typeface != null) {
        }
    }

    private Typeface loadTypeFaceFromHttpSRCByGenericResourceFetcher(final LynxContext lynxContext, final String str) {
        com.lynx.tasm.resourceprovider.LynxResourceRequest lynxResourceRequest = new com.lynx.tasm.resourceprovider.LynxResourceRequest(str, LynxResourceRequest.LynxResourceType.LynxResourceTypeFont);
        lynxResourceRequest.setAsyncMode(LynxResourceRequest.AsyncMode.MOST_SYNC);
        LynxGenericResourceFetcher genericResourceFetcher = lynxContext.getGenericResourceFetcher();
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (genericResourceFetcher != null) {
            genericResourceFetcher.fetchResource(lynxResourceRequest, new com.lynx.tasm.resourceprovider.LynxResourceCallback<byte[]>() { // from class: com.lynx.tasm.fontface.FontFaceManager.8
                @Override // com.lynx.tasm.resourceprovider.LynxResourceCallback
                public void onResponse(com.lynx.tasm.resourceprovider.LynxResourceResponse<byte[]> lynxResourceResponse) {
                    if (lynxResourceResponse.getState() != LynxResourceResponse.ResponseState.SUCCESS || lynxResourceResponse.getData() == null) {
                        FontFaceManager.this.reportError(30202, "Load font with genericResourceFetcher failed:" + lynxResourceResponse.getError().getMessage(), str, null, lynxContext);
                    } else {
                        atomicReference.set(lynxResourceResponse.getData());
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                reportError(30202, "Load font with genericResourceFetcher failed:request timeout", str, null, lynxContext);
                return null;
            }
            byte[] bArr = (byte[]) atomicReference.get();
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            return TypefaceUtils.createFromBytes(lynxContext, bArr);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            reportError(30202, "Load font with genericResourceFetcher failed", str, e, lynxContext);
            return null;
        }
    }

    private synchronized StyledTypeface getCacheTypeface(FontFace fontFace) {
        Iterator<Pair<FontFace.TYPE, String>> it = fontFace.getSrc().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Pair<FontFace.TYPE, String> next = it.next();
        return this.mCacheTypeface.get(((FontFace.TYPE) next.first).name() + ((String) next.second));
    }

    private Typeface loadFromBase64(LynxContext lynxContext, FontFace.TYPE type, String str) {
        if (!TextUtils.isEmpty(str) && type != FontFace.TYPE.LOCAL) {
            int indexOf = str.indexOf(BASE64_SRC_CONTAIN);
            if (str.startsWith(BASE64_SRC_PREFIX) && indexOf != -1) {
                try {
                    return TypefaceUtils.createFromBytes(lynxContext, Base64.decode(str.substring(indexOf + 7), 0));
                } catch (Exception e) {
                    reportError(30203, "Error when parsing base64 resource", str, e, lynxContext);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void typefaceHandlerPost(Handler handler, TypefaceCache.TypefaceListener typefaceListener, StyledTypeface styledTypeface, Integer num) {
        int intValue = num == null ? 0 : num.intValue();
        if (Build.VERSION.SDK_INT >= 28) {
            LLog.i(TAG, "Lynx load font success.");
            typefaceListener.onTypefaceUpdate(styledTypeface.getStyledTypeFace(intValue), intValue);
        } else {
            invokeTypefaceListenerOnUIThread(handler, typefaceListener, styledTypeface, intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeTypefaceListenerOnUIThread(final Handler handler, final TypefaceCache.TypefaceListener typefaceListener, final StyledTypeface styledTypeface, final int i) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.9
            @Override // java.lang.Runnable
            public void run() {
                final Typeface styledTypeFace = styledTypeface.getStyledTypeFace(i);
                handler.post(new Runnable() { // from class: com.lynx.tasm.fontface.FontFaceManager.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LLog.i(FontFaceManager.TAG, "Lynx load font success.");
                        typefaceListener.onTypefaceUpdate(styledTypeFace, i);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(int i, String str, String str2, Exception exc, LynxContext lynxContext) {
        LynxError lynxError = new LynxError(i, str);
        if (exc != null) {
            lynxError.setCallStack(CallStackUtil.getStackTraceStringTrimmed(exc));
            LLog.e(TAG, exc.getMessage());
        } else {
            LLog.e(TAG, str + ",src:" + str2);
        }
        lynxContext.reportResourceError(str2, "font", lynxError);
    }

    private Typeface createTypefaceFromFile(String str, LynxContext lynxContext) {
        try {
            return m10x7e4950b6(str);
        } catch (RuntimeException e) {
            reportError(30205, "Create typeface from local path failed", str, e, lynxContext);
            return null;
        }
    }

    @Proxy("createFromFile")
    @TargetClass("android.graphics.Typeface")
    /* renamed from: INVOKESTATIC_com_lynx_tasm_fontface_FontFaceManager_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile */
    public static Typeface m10x7e4950b6(String str) {
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
