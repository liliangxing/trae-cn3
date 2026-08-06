package com.bytedance.ug.sdk.share.image.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.image.utils.ImageConfigUtils;
import com.bytedance.ug.sdk.share.impl.cache.ShareCacheManager;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.manager.TokenCheckerManager;
import com.bytedance.ug.sdk.share.impl.model.ImageCheckResult;
import com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageCheckerManager {
    private static final String TAG = "ImageCheckerManager";
    private final Context mContext;
    private static final AtomicBoolean isChanged = new AtomicBoolean(true);
    private static final AtomicBoolean albumChanged = new AtomicBoolean(false);

    private ImageCheckerManager() {
        this.mContext = ShareSdkManager.getInstance().getAppContext();
        tryRegisterContentObserver();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class Singleton {
        private static ImageCheckerManager sInstance = new ImageCheckerManager();

        private Singleton() {
        }
    }

    public static ImageCheckerManager inst() {
        return Singleton.sInstance;
    }

    public void checkMediaToken() {
        if (TokenParseManager.getInstance().getCheckLock()) {
            Logger.m469i(TAG, "checkLock is true");
        } else {
            parseCheckResult(getAlbumCheckResult());
        }
    }

    public void checkSelectedMedia(final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ShareConfigManager.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.image.manager.ImageCheckerManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageCheckerManager imageCheckerManager = ImageCheckerManager.this;
                    imageCheckerManager.parseCheckResult(imageCheckerManager.decodeMedia(str));
                }
            });
        } else {
            parseCheckResult(decodeMedia(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseCheckResult(final ImageCheckResult imageCheckResult) {
        if (imageCheckResult == null || TextUtils.isEmpty(imageCheckResult.getCommand())) {
            return;
        }
        if (!TextUtils.isEmpty(imageCheckResult.getQrScan())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.image.manager.ImageCheckerManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TokenParseManager.getInstance().dealWithQrScanResult(imageCheckResult.getQrScan());
                }
            });
        } else if (!TextUtils.isEmpty(imageCheckResult.getHiddenStr())) {
            TokenParseManager.getInstance().translateCommand(imageCheckResult.getHiddenStr(), imageCheckResult.isFromVideo() ? 2 : 1);
        }
        TokenCheckerManager.getInstance().setHandleImageToken(true);
    }

    private List<String> getMediaList(boolean z) {
        if (!isChanged.compareAndSet(true, false)) {
            Logger.m469i(TAG, "相册内容未发生改变，不允许扫描相册");
            return new ArrayList();
        }
        Logger.m469i(TAG, "相册内容发生改变，允许扫描相册");
        ContentResolver contentResolver = this.mContext.getContentResolver();
        Cursor query = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"date_added", "_data"}, "mime_type=? OR mime_type=? OR mime_type=?", new String[]{"image/jpeg", "image/png", "image/jpg"}, "date_added DESC");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("_data"));
                if (!TextUtils.isEmpty(string)) {
                    if (z) {
                        arrayList.add(Long.valueOf(query.getLong(query.getColumnIndex("date_added"))));
                    }
                    arrayList2.add(string);
                    Logger.m469i(TAG, "image path add " + string);
                    if (arrayList2.size() >= ImageConfigUtils.getCheckAlbumImageNum()) {
                        break;
                    }
                }
            }
            query.close();
        }
        if (!z) {
            return arrayList2;
        }
        Cursor query2 = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"date_added", "_data"}, null, null, "date_added DESC");
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (query2 != null) {
            while (query2.moveToNext()) {
                String string2 = query2.getString(query2.getColumnIndex("_data"));
                if (!TextUtils.isEmpty(string2)) {
                    arrayList3.add(Long.valueOf(query2.getLong(query2.getColumnIndex("date_added"))));
                    arrayList4.add(string2);
                    Logger.m469i(TAG, "video path add " + string2);
                    if (arrayList4.size() >= ImageConfigUtils.getCheckAlbumImageNum()) {
                        break;
                    }
                }
            }
            query2.close();
        }
        ArrayList arrayList5 = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < arrayList.size() && i2 < arrayList3.size()) {
            if (((Long) arrayList.get(i)).longValue() > ((Long) arrayList3.get(i2)).longValue()) {
                arrayList5.add(arrayList2.get(i));
                i++;
            } else {
                arrayList5.add(arrayList4.get(i2));
                i2++;
            }
        }
        while (i < arrayList.size()) {
            arrayList5.add(arrayList2.get(i));
            i++;
        }
        while (i2 < arrayList3.size()) {
            arrayList5.add(arrayList4.get(i2));
            i2++;
        }
        return arrayList5.size() > ImageConfigUtils.getCheckAlbumImageNum() ? arrayList5.subList(0, ImageConfigUtils.getCheckAlbumImageNum()) : arrayList5;
    }

    private ImageCheckResult getAlbumCheckResult() {
        boolean hasPermission;
        boolean z;
        Context appContext = ShareSdkManager.getInstance().getAppContext();
        if (Build.VERSION.SDK_INT >= 33) {
            hasPermission = ShareConfigManager.getInstance().hasPermission(appContext, "android.permission.READ_MEDIA_IMAGES");
            z = ShareConfigManager.getInstance().hasPermission(appContext, "android.permission.READ_MEDIA_VIDEO");
            Logger.m469i(TAG, "media images permission is " + hasPermission + "; media video permission is " + z);
        } else {
            hasPermission = ShareConfigManager.getInstance().hasPermission(appContext, "android.permission.READ_EXTERNAL_STORAGE");
            Logger.m469i(TAG, "external storage permission is " + hasPermission);
            z = hasPermission;
        }
        ImageCheckResult imageCheckResult = null;
        if (hasPermission) {
            List<String> mediaList = getMediaList(z && (ShareConfigManager.getInstance().isEnableVideoQrcodeParse() || ShareConfigManager.getInstance().enableHostVideoHiddenWaterMark()));
            if (mediaList.size() == 0) {
                return null;
            }
            LinkedHashMap<String, Boolean> imageCheckedPaths = ShareCacheManager.getInstance().getImageCheckedPaths(ShareCacheManager.CHECKED_IMAGE_PATH_LIST);
            LinkedHashMap<String, Boolean> imageCheckedPaths2 = ShareCacheManager.getInstance().getImageCheckedPaths(ShareCacheManager.HIDDEN_IMAGE_PATH_LIST);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z2 = false;
            for (int i = 0; i < mediaList.size(); i++) {
                String str = mediaList.get(i);
                if (z2) {
                    linkedHashMap.put(str, Boolean.valueOf(imageCheckedPaths.containsKey(str) ? imageCheckedPaths.get(str).booleanValue() : false));
                } else {
                    linkedHashMap.put(str, true);
                    String mediaName = getMediaName(str);
                    if (imageCheckedPaths2.containsKey(mediaName)) {
                        if (imageCheckedPaths2.get(mediaName).booleanValue()) {
                            Logger.m469i(TAG, "hiddenImagePaths contains : " + mediaName + ", value is true. stop reading!");
                            z2 = true;
                        }
                    } else if (imageCheckedPaths.containsKey(str) && imageCheckedPaths.get(str).booleanValue()) {
                        Logger.m469i(TAG, "cachedPaths contains " + str);
                    } else if (!isValidTimeScope(str)) {
                        Logger.m469i(TAG, "media time is too old");
                    } else {
                        imageCheckResult = decodeMedia(str);
                        if (imageCheckResult != null) {
                            ShareCacheManager.getInstance().updateSaveAlbumMediaCache(mediaName, true);
                            Logger.m469i(TAG, "decode success : " + str + ", stop reading!");
                            z2 = true;
                        }
                    }
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                ShareCacheManager.getInstance().updateCheckAlbumMedia((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        }
        return imageCheckResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageCheckResult decodeMedia(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Bitmap bitmapFromSD;
        if (TextUtils.isEmpty(str) || !isValidMediaSize(str)) {
            return null;
        }
        if (isImage(str)) {
            Logger.m469i(TAG, "read image path : " + str);
            if (!ShareConfigManager.getInstance().isEnableHiddenWatermark() || (bitmapFromSD = FileUtils.getBitmapFromSD(str)) == null) {
                str4 = "";
            } else {
                Logger.m469i(TAG, "read image hidden mark");
                str4 = HiddenWartermarkDepend.getHiddenString(bitmapFromSD);
            }
            if (!TextUtils.isEmpty(str4)) {
                Logger.m469i(TAG, "image token hidden str : " + str4);
                ShareEvent.sendHiddenReadEvent();
                return new ImageCheckResult(str, "", str4, false);
            }
            if (ShareConfigManager.getInstance().isEnableQrcodeParse()) {
                Logger.m469i(TAG, "read image qrcode");
                str5 = ShareConfigManager.getInstance().getQrDecodeStr(str);
            } else {
                str5 = "";
            }
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            Logger.m469i(TAG, "image token qrscan str : " + str5);
            ShareEvent.sendQrcodeReadEvent();
            return new ImageCheckResult(str, str5, "", false);
        }
        Logger.m469i(TAG, "read video path : " + str);
        if (ShareConfigManager.getInstance().isEnableVideoQrcodeParse()) {
            Logger.m469i(TAG, "read video qrcode");
            String deCodeImgFromVideo = deCodeImgFromVideo(str);
            if (!TextUtils.isEmpty(deCodeImgFromVideo)) {
                str2 = ShareConfigManager.getInstance().getQrDecodeStr(deCodeImgFromVideo);
                if (TextUtils.isEmpty(str2)) {
                    Logger.m469i(TAG, "video token qrscan str : " + str2);
                    ShareEvent.sendQrcodeReadEvent();
                    return new ImageCheckResult(str, str2, "", true);
                }
                if (ShareConfigManager.getInstance().enableHostVideoHiddenWaterMark()) {
                    Logger.m469i(TAG, "read video hidden mark");
                    str3 = ShareConfigManager.getInstance().getVideoHiddenMark(str);
                } else {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    return null;
                }
                Logger.m469i(TAG, "video token hidden str : " + str3);
                ShareEvent.sendHiddenReadEvent();
                return new ImageCheckResult(str, "", str3, true);
            }
        }
        str2 = "";
        if (TextUtils.isEmpty(str2)) {
        }
    }

    private boolean isValidMediaSize(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file).available() < ImageConfigUtils.getMediaParseMaxSize();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isValidTimeScope(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int mediaParseMaxTime = ImageConfigUtils.getMediaParseMaxTime();
        if (mediaParseMaxTime <= 0) {
            return true;
        }
        return System.currentTimeMillis() - new File(str).lastModified() <= ((long) mediaParseMaxTime);
    }

    private boolean isImage(String str) {
        return str != null && (str.endsWith(".jpeg") || str.endsWith(".png") || str.endsWith(".jpg"));
    }

    private String getMediaName(String str) {
        int lastIndexOf;
        int i;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) < 0 || (i = lastIndexOf + 1) >= str.length()) ? str : str.substring(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a A[Catch: all -> 0x00d2, Exception -> 0x00d4, TryCatch #3 {Exception -> 0x00d4, blocks: (B:10:0x001f, B:15:0x005a, B:17:0x006c, B:19:0x0074, B:23:0x0082, B:42:0x0043), top: B:9:0x001f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: all -> 0x00d2, Exception -> 0x00d4, TRY_LEAVE, TryCatch #3 {Exception -> 0x00d4, blocks: (B:10:0x001f, B:15:0x005a, B:17:0x006c, B:19:0x0074, B:23:0x0082, B:42:0x0043), top: B:9:0x001f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce A[Catch: IOException -> 0x00de, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x00de, blocks: (B:31:0x00ce, B:52:0x00da), top: B:8:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String deCodeImgFromVideo(String str) {
        Bitmap frameAtIndex;
        if (!TextUtils.isEmpty(str)) {
            if (!new File(str).exists()) {
                return "";
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                    } catch (Exception e) {
                        Logger.m467e(TAG, "error", e);
                        mediaMetadataRetriever.release();
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        try {
                            Logger.m469i(TAG, "MediaMetadataRetriever getFrameAtIndex()");
                            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(32));
                            frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(parseInt > 0 ? parseInt - 1 : 0);
                        } catch (Exception e2) {
                            Logger.m469i(TAG, "getFrameAtIndex failed, " + e2.toString());
                        }
                        if (frameAtIndex == null) {
                            Logger.m469i(TAG, "MediaMetadataRetriever getFrameAtTime()");
                            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                            for (long j = parseLong; frameAtIndex == null && parseLong - j <= 120; j -= 40) {
                                frameAtIndex = mediaMetadataRetriever.getFrameAtTime(1000 * j, 2);
                            }
                        }
                        if (frameAtIndex == null) {
                            Logger.m469i(TAG, "deCodeImgFromVideo succeed");
                            String cacheFilePathDir = FileUtils.getCacheFilePathDir();
                            String str2 = "decode_image_" + System.currentTimeMillis() + ".jpeg";
                            FileUtils.saveBitmapToSD(frameAtIndex, cacheFilePathDir, str2);
                            frameAtIndex.recycle();
                            String str3 = cacheFilePathDir + File.separator + str2;
                            try {
                                mediaMetadataRetriever.release();
                            } catch (IOException e3) {
                                Logger.m467e(TAG, "media release error", e3);
                            }
                            return str3;
                        }
                        mediaMetadataRetriever.release();
                    }
                    frameAtIndex = null;
                    if (frameAtIndex == null) {
                    }
                    if (frameAtIndex == null) {
                    }
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (IOException e4) {
                        Logger.m467e(TAG, "media release error", e4);
                    }
                    throw th;
                }
            } catch (IOException e5) {
                Logger.m467e(TAG, "media release error", e5);
            }
        }
        Logger.m469i(TAG, "deCodeImgFromVideo failed");
        return "";
    }

    public void tryRegisterContentObserver() {
        Context context = this.mContext;
        if (context == null) {
            Logger.m466e(TAG, "tryRegisterContentObserver() mContext is null, return");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Logger.m466e(TAG, "tryRegisterContentObserver() mContentResolver is null, return");
            return;
        }
        try {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, new ContentObserver(new Handler(Looper.getMainLooper()) { // from class: com.bytedance.ug.sdk.share.image.manager.ImageCheckerManager.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                }
            }) { // from class: com.bytedance.ug.sdk.share.image.manager.ImageCheckerManager.4
                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    super.onChange(z, uri);
                    if (ImageCheckerManager.albumChanged.compareAndSet(false, true)) {
                        ImageCheckerManager.isChanged.compareAndSet(false, true);
                        Logger.m469i(ImageCheckerManager.TAG, "Album photos have changed");
                    }
                }
            });
        } catch (Throwable th) {
            Logger.m466e(TAG, th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    public void handleAppBackground() {
        albumChanged.set(false);
    }
}
