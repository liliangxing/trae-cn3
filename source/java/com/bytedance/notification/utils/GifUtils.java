package com.bytedance.notification.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.push.monitor.IPushMonitor;
import com.bytedance.push.monitor.PushMonitor;
import com.bytedance.push.settings.notification.NotificationParamsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.BitmapUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GifUtils {
    private static String TAG = "GifUtils";

    public static List<Bitmap> getAllFramesForGif(String str, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Logger.m268d(TAG, "videoPath: " + str);
        try {
            mediaMetadataRetriever.setDataSource(str);
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
            long j = i * 1000;
            for (long j2 = 0; j2 < parseLong; j2 += j) {
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(j2, 3);
                if (frameAtTime != null) {
                    int totalBitmapSize = getTotalBitmapSize(arrayList);
                    if ((totalBitmapSize / Math.max(arrayList.size(), 1)) * (arrayList.size() + 1) >= getGifMaxBytes()) {
                        Logger.m268d(TAG, "Bitmap: " + arrayList.size());
                        Logger.m268d(TAG, "Size: " + totalBitmapSize);
                        if (!arrayList.isEmpty()) {
                            return arrayList;
                        }
                    }
                    arrayList.add(BitmapUtils.processBitmapForGif(frameAtTime, i2, i2 / 15.0f));
                } else {
                    Logger.m271e(TAG, "Time Error:" + j2);
                    return arrayList;
                }
            }
            mediaMetadataRetriever.release();
            Logger.m268d(TAG, "Bitmap: " + arrayList.size());
            Logger.m268d(TAG, "Size: " + getTotalBitmapSize(arrayList));
            return arrayList;
        } catch (Exception e) {
            Logger.m271e(TAG, e.getMessage());
            Logger.m271e(TAG, Arrays.toString(e.getStackTrace()));
            monitorGifUtilsException(e);
            return arrayList;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private static int getTotalBitmapSize(List<Bitmap> list) {
        int i = 0;
        if (list != null) {
            for (Bitmap bitmap : list) {
                if (bitmap != null) {
                    i += bitmap.getByteCount();
                }
            }
        }
        return i;
    }

    private static int getGifMaxBytes() {
        int i;
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        if (notificationParamsModel == null || (i = notificationParamsModel.notificationGifMaxBytes) <= 0) {
            return 200;
        }
        return i;
    }

    private static void monitorGifUtilsException(Exception exc) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TAG, exc.getStackTrace());
            PushMonitor.monitorEvent(IPushMonitor.EVENT_MONITOR_GIF_NOTIFICATION, jSONObject, null, null);
        } catch (Exception e) {
            Logger.m271e(TAG, e.getMessage());
        }
    }
}
