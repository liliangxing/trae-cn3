package com.ss.ttm.player.UnifiedCodec;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.reuse.ReusePolicy;
import com.ss.ttm.player.UnifiedCodec.surface.GLSurfaceTexture;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.ttm.player.UnifiedCodec.util.DeviceUtils;
import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;
import com.ss.ttm.player.UnifiedCodec.util.ThreadManager;
import com.ss.vcbkit.VLog;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class PreloadCodecManager {
    private static final String TAG = "PreloadCodecManager";
    private boolean mIsPreloaded;

    private MediaFormat getPreloadMediaFormat(String str) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        ReusePolicy reusePolicy = MediaCodecManager.getInstance().getReusePolicy();
        int i = reusePolicy.mInitWidth;
        int i2 = reusePolicy.mInitHeight;
        int max = Math.max(0, CodecUtils.getCodecMaxInputSize(str, i, i2));
        mediaFormat.setInteger("width", 1);
        mediaFormat.setInteger("height", 1);
        mediaFormat.setInteger("max-width", i);
        mediaFormat.setInteger("max-height", i2);
        if (max > 0) {
            mediaFormat.setInteger("max-input-size", max);
        }
        return mediaFormat;
    }

    private Surface getSurface() {
        return new GLSurfaceTexture(1, 1).getSurface();
    }

    public static boolean isInvalidMimeType(String mimeType) {
        return TextUtils.equals(mimeType, MimeTypes.VIDEO_H264) || TextUtils.equals(mimeType, MimeTypes.VIDEO_H265);
    }

    public void preloadCodecByMimeType(String str) {
        Surface surface = getSurface();
        if (surface != null) {
            try {
                UnifiedMediaCodec createByCodecType = UnifiedMediaCodec.createByCodecType(str);
                createByCodecType.configure(getPreloadMediaFormat(str), surface, (MediaCrypto) null, 0);
                createByCodecType.start();
                createByCodecType.stop();
                createByCodecType.release();
                return;
            } catch (Throwable th) {
                VLog.m251w(TAG, "preloadCodecByMimeType sampleMimeType:" + str + " exception..." + th);
                return;
            }
        }
        VLog.m251w(TAG, "preloadCodecByMimeType sampleMimeType:" + str + " failed...");
    }

    public final void preload(final Set<String> codecMimes) {
        if (!this.mIsPreloaded) {
            this.mIsPreloaded = true;
            ThreadManager.execute(new Runnable() { // from class: com.ss.ttm.player.UnifiedCodec.PreloadCodecManager.1
                @Override // java.lang.Runnable
                public void run() {
                    for (String str : codecMimes) {
                        if (PreloadCodecManager.isInvalidMimeType(str)) {
                            PreloadCodecManager.this.preloadCodecByMimeType(str);
                        }
                    }
                }
            });
        } else {
            VLog.m251w(TAG, "preload codec return, for isPreload:" + this.mIsPreloaded + " apiLevel:" + DeviceUtils.SDK_INT);
        }
    }
}
