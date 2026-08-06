package com.ss.ttm.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class MediacodecBlockManager {
    private static final String TAG = "JAJMediaCodec_MediacodecBlockManager";
    private static final ArrayList<MediaCodecInfo> mCodecs = new ArrayList<>();
    private static final Object mCodecCachedLock = new Object();
    private static boolean mCodecCached = false;
    private static CodecGetter sCodecGetterInstance = null;

    /* loaded from: classes7.dex */
    private static class MediacodecCall implements Callable<MediaCodec> {
        private static final List<MediacodecCall> mediacodecCallList = new ArrayList();
        private String mCodecName;
        private boolean mSyncRelease;
        private boolean needRelease = false;
        private final Object resultLock = new Object();
        private MediaCodec mediaCodecResult = null;

        public MediacodecCall(String codecName, boolean syncRelease) {
            this.mCodecName = null;
            this.mSyncRelease = false;
            this.mCodecName = codecName;
            this.mSyncRelease = syncRelease;
            mediacodecCallList.add(this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public MediaCodec call() throws Exception {
            MediaCodec mediaCodec;
            MediaCodec createByCodecNameMayBlock = MediacodecBlockManager.createByCodecNameMayBlock(this.mCodecName);
            synchronized (this.resultLock) {
                this.mediaCodecResult = createByCodecNameMayBlock;
                if (this.needRelease) {
                    MediacodecBlockManager.releaseMediaCodec(createByCodecNameMayBlock, this.mSyncRelease);
                    this.mediaCodecResult = null;
                }
                mediacodecCallList.remove(this);
                mediaCodec = this.mediaCodecResult;
            }
            return mediaCodec;
        }

        public void releaseResult(boolean release) {
            synchronized (this.resultLock) {
                this.needRelease = release;
                if (release) {
                    MediacodecBlockManager.releaseMediaCodec(this.mediaCodecResult, this.mSyncRelease);
                    this.mediaCodecResult = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseCodecSync(MediaCodec codec) {
        if (codec != null) {
            try {
                codec.release();
            } catch (Exception e) {
                AVLogger.w(TAG, codec + " release failed : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void releaseMediaCodec(final MediaCodec codec, boolean syncRelease) {
        if (syncRelease) {
            releaseCodecSync(codec);
            return;
        }
        try {
            AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.MediacodecBlockManager.1
                @Override // java.lang.Runnable
                public void run() {
                    AVLogger.d(MediacodecBlockManager.TAG, "start releaseCodec task");
                    MediacodecBlockManager.releaseCodecSync(codec);
                }
            });
        } catch (Throwable unused) {
            AVLogger.w(TAG, "new thread failed");
            releaseCodecSync(codec);
        }
    }

    public static MediaCodec createByCodecName(String codecName, long timeoutMs, boolean syncRelease) {
        MediaCodec mediaCodec;
        AVLogger.d(TAG, "createByCodecName timeoutMs : " + timeoutMs + " , syncRelease " + syncRelease);
        if (timeoutMs <= 0) {
            return createByCodecNameMayBlock(codecName);
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        MediacodecCall mediacodecCall = new MediacodecCall(codecName, syncRelease);
        try {
            try {
                mediaCodec = (MediaCodec) newSingleThreadExecutor.submit(mediacodecCall).get(timeoutMs, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                AVLogger.w(TAG, e.toString());
                mediacodecCall.releaseResult(true);
                newSingleThreadExecutor.shutdown();
                mediaCodec = null;
            }
            return mediaCodec;
        } finally {
            mediacodecCall.releaseResult(false);
            newSingleThreadExecutor.shutdown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaCodec createByCodecNameMayBlock(String codecName) {
        try {
            return MediaCodec.createByCodecName(codecName);
        } catch (Exception e) {
            AVLogger.w(TAG, e.toString());
            return null;
        }
    }

    /* loaded from: classes7.dex */
    private static class CodecGetter {
        public CodecGetter(final boolean enableGetCodecInfosOpt) {
            AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.MediacodecBlockManager.CodecGetter.1
                @Override // java.lang.Runnable
                public void run() {
                    MediacodecBlockManager.getCodecsMayBlock(enableGetCodecInfosOpt);
                }
            });
        }
    }

    public static ArrayList<MediaCodecInfo> getCodecs(boolean async, boolean enableGetCodecInfosOpt) {
        AVLogger.d(TAG, "getCodecs async : " + async);
        if (!async) {
            return getCodecsMayBlock(enableGetCodecInfosOpt);
        }
        if (sCodecGetterInstance == null) {
            synchronized (CodecGetter.class) {
                if (sCodecGetterInstance == null) {
                    sCodecGetterInstance = new CodecGetter(enableGetCodecInfosOpt);
                }
            }
        }
        synchronized (mCodecCachedLock) {
            if (!mCodecCached) {
                return null;
            }
            return mCodecs;
        }
    }

    public static synchronized ArrayList<MediaCodecInfo> getCodecsMayBlock(boolean enableGetCodecInfosOpt) {
        ArrayList arrayList;
        ArrayList<MediaCodecInfo> arrayList2;
        synchronized (MediacodecBlockManager.class) {
            synchronized (mCodecCachedLock) {
                String str = TAG;
                StringBuilder append = new StringBuilder("mCodecCached : ").append(mCodecCached).append(" , mCodecs size:");
                ArrayList<MediaCodecInfo> arrayList3 = mCodecs;
                AVLogger.d(str, append.append(arrayList3.size()).toString());
                if (mCodecCached) {
                    return arrayList3;
                }
                if (enableGetCodecInfosOpt) {
                    try {
                        arrayList = new ArrayList(Arrays.asList(new MediaCodecList(1).getCodecInfos()));
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    try {
                        int codecCount = MediaCodecList.getCodecCount();
                        arrayList = new ArrayList();
                        for (int i = 0; i < codecCount; i++) {
                            arrayList.add(MediaCodecList.getCodecInfoAt(i));
                        }
                    } catch (Exception unused2) {
                        AVLogger.w(TAG, "mediaserver died");
                        return null;
                    }
                }
                synchronized (mCodecCachedLock) {
                    arrayList2 = mCodecs;
                    arrayList2.addAll(arrayList);
                    mCodecCached = true;
                }
                AVLogger.d(TAG, "cache complete, mCodecCached : " + mCodecCached + " , mCodecs size:" + arrayList2.size());
                return arrayList2;
            }
        }
    }
}
