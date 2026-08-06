package com.bytedance.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import com.bytedance.lottie.model.LottieCompositionCache;
import com.bytedance.lottie.network.NetworkFetcher;
import com.bytedance.lottie.parser.LottieCompositionParser;
import com.bytedance.lottie.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return NetworkFetcher.fetch(context, str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return NetworkFetcher.fetchSync(context, str);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return cache(rawResCacheKey(i), new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromRawResSync(applicationContext, i);
            }
        });
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i), rawResCacheKey(i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static String rawResCacheKey(int i) {
        return "rawRes_" + i;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        });
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(new JsonReader(new StringReader(str)), str2, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str, true);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSync(jsonReader, str, false);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str, boolean z) {
        try {
            LottieComposition parse = LottieCompositionParser.parse(jsonReader);
            LottieCompositionCache.getInstance().put(str, parse);
            return new LottieResult<>(parse);
        } catch (Throwable th) {
            try {
                LottieMonitor.reportError(str, th);
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(th);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } finally {
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
            }
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = fromJsonInputStreamSync(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(".png")) {
                    hashMap.put(nextEntry.getName().split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            LottieCompositionCache.getInstance().put(str, lottieComposition);
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromJsonDir(final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonDirSync(str, str2);
            }
        });
    }

    private static boolean checkComposition(LottieComposition lottieComposition) {
        if (lottieComposition == null) {
            return false;
        }
        Iterator<Map.Entry<String, LottieImageAsset>> it = lottieComposition.getImages().entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().getBitmap() == null) {
                return false;
            }
        }
        return true;
    }

    public static void fromJsonFileAsync(final String str, final String str2, ImageAssetDelegateAsync imageAssetDelegateAsync, CompositionReadyListener compositionReadyListener) {
        LottieComposition lottieComposition = LottieCompositionCache.getInstance().get(str2);
        if (checkComposition(lottieComposition)) {
            compositionReadyListener.onCompositionReady(lottieComposition);
        } else {
            LottieTask.EXECUTOR.execute(new LottieTaskRunnable(imageAssetDelegateAsync, compositionReadyListener, null) { // from class: com.bytedance.lottie.LottieCompositionFactory.9
                @Override // java.lang.Runnable
                public void run() {
                    LottieCompositionFactory.fromJsonFileAsyncInternal(str, str2, getWeakDelegate(), getWeakListener());
                }
            });
        }
    }

    public static void fromJsonAssetAsync(Context context, final String str, final String str2, ImageAssetDelegateAsync imageAssetDelegateAsync, CompositionReadyListener compositionReadyListener) {
        LottieComposition lottieComposition = LottieCompositionCache.getInstance().get(str2);
        if (checkComposition(lottieComposition)) {
            compositionReadyListener.onCompositionReady(lottieComposition);
        } else {
            LottieTask.EXECUTOR.execute(new LottieTaskRunnable(imageAssetDelegateAsync, compositionReadyListener, context) { // from class: com.bytedance.lottie.LottieCompositionFactory.10
                @Override // java.lang.Runnable
                public void run() {
                    LottieCompositionFactory.fromJsonAssetAsyncInternal(getWeakCtx(), str, str2, getWeakDelegate(), getWeakListener());
                }
            });
        }
    }

    public static LottieResult<LottieComposition> fromJsonDirSync(String str, String str2) {
        return fromJsonDirSyncInternal(str, str2);
    }

    private static LottieResult<LottieComposition> fromJsonDirSyncInternal(String str, String str2) {
        HashMap hashMap = new HashMap();
        File file = new File(str);
        LinkedList linkedList = new LinkedList();
        linkedList.offer(file);
        LottieComposition lottieComposition = null;
        while (!linkedList.isEmpty()) {
            try {
                File file2 = (File) linkedList.poll();
                if (file2 != null) {
                    for (File file3 : file2.listFiles()) {
                        if (file3.isDirectory()) {
                            linkedList.add(file3);
                        } else if (file3.getName().contains(".json")) {
                            lottieComposition = fromJsonInputStreamSync(new FileInputStream(file3), str2, true).getValue();
                        } else if (file3.getName().contains(".png")) {
                            String[] split = file3.getName().split("/");
                            hashMap.put(split[split.length - 1], BitmapFactory.decodeFile(file3.getPath()));
                        }
                    }
                }
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        }
        if (lottieComposition == null) {
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
            if (findImageAssetForFileName != null) {
                findImageAssetForFileName.setBitmap((Bitmap) entry.getValue());
            }
        }
        for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
            if (entry2.getValue().getBitmap() == null) {
                return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
            }
        }
        LottieCompositionCache.getInstance().put(str2, lottieComposition);
        return new LottieResult<>(lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fromJsonFileAsyncInternal(String str, final String str2, WeakReference<ImageAssetDelegateAsync> weakReference, WeakReference<CompositionReadyListener> weakReference2) {
        if (weakReference.get() == null || weakReference2.get() == null) {
            return;
        }
        ImageAssetDelegateAsync imageAssetDelegateAsync = weakReference.get();
        final CompositionReadyListener compositionReadyListener = weakReference2.get();
        try {
            LottieComposition value = fromJsonInputStreamSync(new FileInputStream(new File(str)), str2, true).getValue();
            if (value == null) {
                compositionReadyListener.onCompositionFailed("fromJsonFileAsyncInternal Unable to parse composition and composition is null");
            } else {
                prepareBitmapForComposition(value, imageAssetDelegateAsync, new CompositionReadyListener() { // from class: com.bytedance.lottie.LottieCompositionFactory.11
                    @Override // com.bytedance.lottie.CompositionReadyListener
                    public void onCompositionReady(LottieComposition lottieComposition) {
                        LottieCompositionCache.getInstance().put(str2, lottieComposition);
                        compositionReadyListener.onCompositionReady(lottieComposition);
                    }

                    @Override // com.bytedance.lottie.CompositionReadyListener
                    public void onCompositionFailed(String str3) {
                        compositionReadyListener.onCompositionFailed(str3);
                    }
                });
            }
        } catch (Exception e) {
            compositionReadyListener.onCompositionFailed("fromJsonFileAsyncInternal Unable to parse composition. Error msg is " + e.toString());
        }
    }

    public static void fromJsonStringAsync(final String str, final String str2, ImageAssetDelegateAsync imageAssetDelegateAsync, CompositionReadyListener compositionReadyListener) {
        LottieComposition lottieComposition = LottieCompositionCache.getInstance().get(str2);
        if (checkComposition(lottieComposition)) {
            compositionReadyListener.onCompositionReady(lottieComposition);
        } else {
            LottieTask.EXECUTOR.execute(new LottieTaskRunnable(imageAssetDelegateAsync, compositionReadyListener, null) { // from class: com.bytedance.lottie.LottieCompositionFactory.12
                @Override // java.lang.Runnable
                public void run() {
                    LottieCompositionFactory.fromJsonStringAsyncInternal(str, str2, getWeakDelegate(), getWeakListener());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fromJsonStringAsyncInternal(String str, final String str2, WeakReference<ImageAssetDelegateAsync> weakReference, WeakReference<CompositionReadyListener> weakReference2) {
        if (weakReference.get() == null || weakReference2.get() == null) {
            return;
        }
        final CompositionReadyListener compositionReadyListener = weakReference2.get();
        try {
            prepareBitmapForComposition(LottieCompositionParser.parse(new JsonReader(new StringReader(str))), weakReference.get(), new CompositionReadyListener() { // from class: com.bytedance.lottie.LottieCompositionFactory.13
                @Override // com.bytedance.lottie.CompositionReadyListener
                public void onCompositionReady(LottieComposition lottieComposition) {
                    LottieCompositionCache.getInstance().put(str2, lottieComposition);
                    compositionReadyListener.onCompositionReady(lottieComposition);
                }

                @Override // com.bytedance.lottie.CompositionReadyListener
                public void onCompositionFailed(String str3) {
                    compositionReadyListener.onCompositionFailed(str3);
                }
            });
        } finally {
            try {
            } finally {
            }
        }
    }

    private static void prepareBitmapForComposition(final LottieComposition lottieComposition, ImageAssetDelegateAsync imageAssetDelegateAsync, final CompositionReadyListener compositionReadyListener) {
        if (lottieComposition.getImages() == null || lottieComposition.getImages().size() == 0) {
            lottieComposition.setBitmapReady(true);
            compositionReadyListener.onCompositionReady(lottieComposition);
            return;
        }
        if (lottieComposition.getImages() != null) {
            final AtomicInteger atomicInteger = new AtomicInteger(lottieComposition.getImages().size());
            for (Map.Entry<String, LottieImageAsset> entry : lottieComposition.getImages().entrySet()) {
                if (imageAssetDelegateAsync != null) {
                    final LottieImageAsset value = entry.getValue();
                    if ("%s".equals(value.getFileName())) {
                        lottieComposition.setNeedPolyfill(true);
                        if (atomicInteger.decrementAndGet() == 0) {
                            lottieComposition.setBitmapReady(true);
                            compositionReadyListener.onCompositionReady(lottieComposition);
                        }
                    } else {
                        imageAssetDelegateAsync.fetchBitmapAsync(value, new LottieCallback<Bitmap>() { // from class: com.bytedance.lottie.LottieCompositionFactory.14
                            @Override // com.bytedance.lottie.LottieCallback
                            public void onSuccess(Bitmap bitmap) {
                                LottieImageAsset.this.setBitmap(bitmap);
                                if (atomicInteger.decrementAndGet() == 0) {
                                    lottieComposition.setBitmapReady(true);
                                    compositionReadyListener.onCompositionReady(lottieComposition);
                                }
                            }

                            @Override // com.bytedance.lottie.LottieCallback
                            public void onFailed() {
                                lottieComposition.setBitmapReady(false);
                                compositionReadyListener.onCompositionFailed("");
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fromJsonAssetAsyncInternal(WeakReference<Context> weakReference, String str, final String str2, WeakReference<ImageAssetDelegateAsync> weakReference2, WeakReference<CompositionReadyListener> weakReference3) {
        if (weakReference.get() == null || weakReference2.get() == null || weakReference3.get() == null) {
            return;
        }
        Context context = weakReference.get();
        final CompositionReadyListener compositionReadyListener = weakReference3.get();
        ImageAssetDelegateAsync imageAssetDelegateAsync = weakReference2.get();
        try {
            LottieComposition value = fromAssetSync(context, str).getValue();
            if (value == null) {
                compositionReadyListener.onCompositionFailed("fromJsonAssetSyncInternal Unable to parse composition and composition is null");
            } else {
                prepareBitmapForComposition(value, imageAssetDelegateAsync, new CompositionReadyListener() { // from class: com.bytedance.lottie.LottieCompositionFactory.15
                    @Override // com.bytedance.lottie.CompositionReadyListener
                    public void onCompositionReady(LottieComposition lottieComposition) {
                        LottieCompositionCache.getInstance().put(str2, lottieComposition);
                        compositionReadyListener.onCompositionReady(lottieComposition);
                    }

                    @Override // com.bytedance.lottie.CompositionReadyListener
                    public void onCompositionFailed(String str3) {
                        compositionReadyListener.onCompositionFailed(str3);
                    }
                });
            }
        } catch (Exception e) {
            compositionReadyListener.onCompositionFailed("load composition failed from asset. " + e.getMessage());
        }
    }

    public static LottieTask<LottieComposition> fromJsonWithImages(final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.16
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonWithImagesSync(str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonWithImagesSync(String str, String str2) {
        return fromJsonWithImagesSyncInternal(str, str2);
    }

    public static LottieResult<LottieComposition> fromJsonWithImagesSyncInternal(String str, String str2) {
        new HashMap();
        File file = new File(str);
        LinkedList linkedList = new LinkedList();
        linkedList.offer(file.getParentFile());
        try {
            LottieComposition value = fromJsonInputStreamSync(new FileInputStream(file), str2, true).getValue();
            if (value == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.poll();
                if (file2 != null) {
                    for (File file3 : file2.listFiles()) {
                        if (file3.isDirectory()) {
                            linkedList.add(file3);
                        } else if (file3.getName().contains(".png")) {
                            String[] split = file3.getName().split("/");
                            LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(value, split[split.length - 1]);
                            if (findImageAssetForFileName != null) {
                                findImageAssetForFileName.setBitmap(BitmapFactory.decodeFile(file3.getPath()));
                            }
                        }
                    }
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry : value.getImages().entrySet()) {
                if (entry.getValue().getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry.getValue().getFileName()));
                }
            }
            LottieCompositionCache.getInstance().put(str2, value);
            return new LottieResult<>(value);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.bytedance.lottie.LottieCompositionFactory.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public LottieResult<LottieComposition> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new LottieResult<>(LottieComposition.this);
                }
            });
        }
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        lottieTask.addListener(new LottieListener<LottieComposition>() { // from class: com.bytedance.lottie.LottieCompositionFactory.18
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition2) {
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, lottieComposition2);
                }
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        lottieTask.addFailureListener(new LottieListener<Throwable>() { // from class: com.bytedance.lottie.LottieCompositionFactory.19
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        map.put(str, lottieTask);
        return lottieTask;
    }
}
