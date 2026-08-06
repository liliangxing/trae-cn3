package com.lynx.canvas.recorder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.lynx.tasm.core.ResManager;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class KryptonDefaultMediaRecorder implements KryptonMediaRecorder {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final String[] ENCODER_BLACK_LIST = {"c2.android.avc.encoder"};
    private static final long MIN_INTERVAL = 8000;
    public static final String TAG = "KryptonMediaRecorder";
    public static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAllTrackCount;
    private int mAudioBPS;
    private MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioChannelCount;
    private MediaCodec mAudioMediaCodecEncoder;
    private long mAudioPresentationTimeUs;
    private int mAudioSampleRate;
    private long mAudioSamples;
    private int mAudioTrackIndex;
    private int mBPS;
    private final Delegate mDelegate;
    private int mFPS;
    private int mHeight;
    private final Invoker mInvoker;
    private KryptonMediaRecorder.Listener mListener;
    private int mMaxDuration;
    private MediaMuxer mMediaMuxer;
    private String mMimeType;
    private boolean mMuxerStarted;
    private boolean mPaused;
    private boolean mToAdjustVideoConfig;
    private int mTrackCount;
    private MediaCodec.BufferInfo mVideoBufferInfo;
    private Surface mVideoInputSurface;
    private MediaCodec mVideoMediaCodecEncoder;
    private String mVideoOutputPath;
    private String mVideoOutputUrl;
    private int mVideoTrackIndex;
    private int mWidth;
    private String mVideoRangeLogString = "";
    private boolean mRunning = false;
    private boolean mUseAudio = false;
    private long mLastPauseTime = 0;
    private long mPausedTime = 0;
    private long mLastVideoTime = 0;
    private long mStartTime = 0;
    private long[] mClipTimeArray = null;
    private ArrayList<String> mCachedPaths = new ArrayList<>();

    /* loaded from: classes6.dex */
    public interface Delegate {
        String getVideoDirectory(String str, boolean z);

        VideoFileManagementPolicy getVideoFileManagementPolicy();

        VideoPathInfo getVideoPathInfo(String str, boolean z);
    }

    /* loaded from: classes6.dex */
    public interface Invoker {
        String extractMetadata(MediaMetadataRetriever mediaMetadataRetriever, int i);
    }

    /* loaded from: classes6.dex */
    public enum VideoFileManagementPolicy {
        USER_DEFINED,
        FORCE_DELETE,
        FORCE_KEEP
    }

    /* loaded from: classes6.dex */
    public static class VideoPathInfo {
        public String path;
        public String url;
    }

    public KryptonDefaultMediaRecorder(Delegate delegate, Invoker invoker) {
        if (delegate == null) {
            throw new IllegalArgumentException("KryptonDefaultMediaRecorder delegate must be set.");
        }
        this.mDelegate = delegate;
        this.mInvoker = invoker;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void setListener(KryptonMediaRecorder.Listener listener) {
        this.mListener = listener;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configVideo(String str, int i, int i2, int i3, int i4, int i5) {
        this.mMimeType = str;
        this.mMaxDuration = i;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mBPS = i4;
        this.mFPS = i5;
        this.mToAdjustVideoConfig = true;
        KryptonLLog.i("KryptonMediaRecorder", "configVideo for " + Build.MODEL + ", width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configAudio(int i, int i2, int i3) {
        if (i < 0) {
            this.mUseAudio = false;
            return;
        }
        this.mAudioChannelCount = i;
        this.mAudioBPS = i2;
        this.mAudioSampleRate = i3;
        this.mUseAudio = true;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [com.lynx.canvas.recorder.KryptonDefaultMediaRecorder$1] */
    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized Surface startRecord() {
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mPausedTime = 0L;
            this.mLastPauseTime = 0L;
            this.mMuxerStarted = false;
            this.mLastVideoTime = 0L;
            this.mAudioTrackIndex = -1;
            this.mVideoTrackIndex = -1;
            this.mTrackCount = 0;
            this.mPaused = false;
            this.mAudioPresentationTimeUs = 0L;
            this.mAudioSamples = 0L;
            try {
                prepareVideoEncoder();
                if (this.mUseAudio) {
                    try {
                        prepareAudioEncoder();
                        this.mAllTrackCount = 2;
                    } catch (Exception e) {
                        String str = "prepareAudioEncoder " + e.toString();
                        KryptonLLog.e("KryptonMediaRecorder", str);
                        notifyStartError(str);
                        return null;
                    }
                } else {
                    this.mAllTrackCount = 1;
                }
                try {
                    initMediaMuxer();
                    this.mRunning = true;
                    new Thread("MediaRecorder") { // from class: com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            KryptonDefaultMediaRecorder.this.recorderThreadRun();
                        }
                    }.start();
                    return this.mVideoInputSurface;
                } catch (Exception e2) {
                    String str2 = "initMediaMuxer " + e2.toString();
                    KryptonLLog.e("KryptonMediaRecorder", str2);
                    notifyStartError(str2);
                    return null;
                }
            } catch (Exception e3) {
                String str3 = "prepareVideoEncoder " + e3.toString() + "model:" + Build.MODEL + " width:" + this.mWidth + " height:" + this.mHeight + " bps:" + this.mBPS + "ranges: " + this.mVideoRangeLogString;
                KryptonLLog.e("KryptonMediaRecorder", str3);
                notifyStartError(str3);
                return null;
            }
        }
        notifyStartError("init param error");
        return null;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void stopRecord() {
        this.mPaused = false;
        if (this.mRunning) {
            this.mRunning = false;
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void pauseRecord() {
        this.mLastPauseTime = currentTimeUs();
        this.mPaused = true;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void resumeRecord() {
        this.mPausedTime += currentTimeUs() - this.mLastPauseTime;
        this.mPaused = false;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void destroy(boolean z) {
        stopRecord();
        if (this.mDelegate.getVideoFileManagementPolicy() != null) {
            int i = AnonymousClass3.$SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[this.mDelegate.getVideoFileManagementPolicy().ordinal()];
            if (i == 1) {
                z = true;
            } else if (i == 2) {
                z = false;
            }
        }
        if (z) {
            KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with video files deleted");
            Iterator<String> it = this.mCachedPaths.iterator();
            while (it.hasNext()) {
                deleteFileWithPath(it.next());
            }
        } else {
            KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with 1 video files not deleted");
        }
    }

    /* renamed from: com.lynx.canvas.recorder.KryptonDefaultMediaRecorder$3, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy;

        static {
            int[] iArr = new int[VideoFileManagementPolicy.values().length];
            $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy = iArr;
            try {
                iArr[VideoFileManagementPolicy.FORCE_DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[VideoFileManagementPolicy.FORCE_KEEP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized long lastPresentationTime() {
        return this.mLastVideoTime;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public void onAudioSample(ByteBuffer byteBuffer, int i) {
        MediaCodec mediaCodec = this.mAudioMediaCodecEncoder;
        if (mediaCodec == null) {
            return;
        }
        try {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            if (dequeueInputBuffer < 0) {
                KryptonLLog.w("KryptonMediaRecorder", "no input buffer, audio data dropped");
                return;
            }
            ByteBuffer byteBuffer2 = this.mAudioMediaCodecEncoder.getInputBuffers()[dequeueInputBuffer];
            byteBuffer2.clear();
            byteBuffer.position(0).limit(i);
            byteBuffer2.put(byteBuffer);
            long j = this.mAudioSamples;
            long j2 = (1000000 * j) / this.mAudioSampleRate;
            this.mAudioPresentationTimeUs = j2;
            this.mAudioSamples = j + (i >> 2);
            this.mAudioMediaCodecEncoder.queueInputBuffer(dequeueInputBuffer, 0, i, j2, 0);
        } catch (Exception e) {
            KryptonLLog.w("KryptonMediaRecorder", "onAudioSample exception " + e.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.lynx.canvas.recorder.KryptonDefaultMediaRecorder$2] */
    @Override // com.lynx.canvas.KryptonMediaRecorder
    public boolean clipVideo(long[] jArr) {
        this.mClipTimeArray = jArr;
        new Thread("MediaRecorderClop") { // from class: com.lynx.canvas.recorder.KryptonDefaultMediaRecorder.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                KryptonDefaultMediaRecorder.this.clipThreadRun();
            }
        }.start();
        return true;
    }

    private synchronized long getPresentationTimeUs() {
        if (this.mUseAudio && this.mAudioSamples != 0) {
            return this.mAudioPresentationTimeUs;
        }
        return (currentTimeUs() - this.mStartTime) - this.mPausedTime;
    }

    private void releaseVideoMediaCodecEncoder(boolean z) {
        MediaCodec mediaCodec = this.mVideoMediaCodecEncoder;
        if (mediaCodec == null) {
            return;
        }
        try {
            try {
                mediaCodec.stop();
                this.mVideoMediaCodecEncoder.release();
            } catch (RuntimeException e) {
                KryptonLLog.e("KryptonMediaRecorder", "releaseVideoMediaCodecEncoder exception " + e.toString());
                if (!z) {
                    throw e;
                }
            }
        } finally {
            this.mVideoMediaCodecEncoder = null;
        }
    }

    private void releaseAudioMediaCodecEncoder(boolean z) {
        MediaCodec mediaCodec = this.mAudioMediaCodecEncoder;
        if (mediaCodec == null) {
            return;
        }
        try {
            try {
                mediaCodec.stop();
                this.mAudioMediaCodecEncoder.release();
            } catch (RuntimeException e) {
                KryptonLLog.e("KryptonMediaRecorder", "releaseAudioMediaCodecEncoder exception " + e.toString());
                if (!z) {
                    throw e;
                }
            }
        } finally {
            this.mAudioMediaCodecEncoder = null;
        }
    }

    private void releaseMediaMuxer(boolean z) {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer == null) {
            return;
        }
        try {
            try {
                mediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (IllegalStateException e) {
                KryptonLLog.e("KryptonMediaRecorder", "releaseMediaMuxer exception " + e.toString());
                if (!z) {
                    throw e;
                }
            }
        } finally {
            this.mMediaMuxer = null;
        }
    }

    private synchronized boolean isRunning() {
        return this.mRunning;
    }

    private void notifyStopWithError(String str) {
        tryToDeleteFileWithPath(this.mVideoOutputPath);
        KryptonMediaRecorder.Listener listener = this.mListener;
        if (listener != null) {
            listener.onRecordStopWithError(this, str);
        }
    }

    private void notifyStartError(String str) {
        KryptonMediaRecorder.Listener listener = this.mListener;
        if (listener != null) {
            listener.onRecordStartError(this, str);
        }
    }

    private void notifyStopWithData(float f, long j) {
        KryptonMediaRecorder.Listener listener = this.mListener;
        if (listener != null) {
            listener.onRecordStop(this, this.mVideoOutputPath, this.mVideoOutputUrl, f, j);
        }
    }

    private void notifyFlushRecord() {
        KryptonMediaRecorder.Listener listener = this.mListener;
        if (listener != null) {
            listener.onRecordFlush(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recorderThreadRun() {
        String extractMetadata;
        try {
            this.mStartTime = currentTimeUs();
            while (isRunning()) {
                notifyFlushRecord();
                drainVideoEncoder(false);
                drainAudioEncoder();
                int i = this.mMaxDuration;
                if (i > 0 && this.mLastVideoTime >= i * 1000000.0d) {
                    this.mRunning = false;
                    this.mPaused = false;
                }
            }
            this.mVideoMediaCodecEncoder.signalEndOfInputStream();
            drainVideoEncoder(true);
            drainAudioEncoder();
            try {
                releaseVideoMediaCodecEncoder(false);
                releaseAudioMediaCodecEncoder(false);
                releaseMediaMuxer(false);
                File file = new File(this.mVideoOutputPath);
                if (!file.exists() || !file.isFile()) {
                    notifyStopWithError("create video file failed.");
                    return;
                }
                long length = file.length();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.mVideoOutputPath);
                    Invoker invoker = this.mInvoker;
                    if (invoker != null) {
                        extractMetadata = invoker.extractMetadata(mediaMetadataRetriever, 9);
                    } else {
                        extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    }
                    float parseFloat = extractMetadata != null ? Float.parseFloat(extractMetadata) : 0.0f;
                    this.mCachedPaths.add(this.mVideoOutputPath);
                    notifyStopWithData(parseFloat / 1000.0f, length);
                } catch (Throwable unused) {
                    notifyStopWithError("result video file is empty");
                }
            } catch (Exception e) {
                notifyStopWithError("release Encoder error." + e.toString());
            }
        } catch (Exception e2) {
            notifyStopWithError("encode error " + e2.toString());
        }
    }

    private int valueInRange(int i, Range<Integer> range, int i2, int i3) {
        if (range != null) {
            if (i > range.getUpper().intValue()) {
                return range.getUpper().intValue();
            }
            if (i < range.getLower().intValue()) {
                return range.getLower().intValue();
            }
        } else {
            if (i > i3) {
                return i3;
            }
            if (i < i2) {
                return i2;
            }
        }
        return i;
    }

    private void adjustVideoConfig() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Range<Integer> range;
        Range<Integer> range2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mVideoMediaCodecEncoder.getCodecInfo().getCapabilitiesForType(this.mMimeType);
        if (capabilitiesForType == null || (videoCapabilities = capabilitiesForType.getVideoCapabilities()) == null) {
            i = 176;
            i2 = 1920;
            i3 = 144;
            i4 = 1080;
            i5 = 4;
            range = null;
            range2 = null;
        } else {
            int widthAlignment = videoCapabilities.getWidthAlignment() > 4 ? videoCapabilities.getWidthAlignment() : 4;
            r1 = videoCapabilities.getHeightAlignment() > 4 ? videoCapabilities.getHeightAlignment() : 4;
            range = videoCapabilities.getSupportedFrameRates();
            range2 = videoCapabilities.getBitrateRange();
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            i = supportedWidths.getLower().intValue();
            i2 = supportedWidths.getUpper().intValue();
            i3 = supportedHeights.getLower().intValue();
            i4 = supportedHeights.getUpper().intValue();
            this.mVideoRangeLogString = "widthRange(" + i + "," + i2 + "),heightRange(" + i3 + "," + i4 + "),frameRateRange(" + range.getLower() + "," + range.getUpper() + "),bitRateRange(" + range2.getLower() + "," + range2.getUpper() + ")";
            int i6 = widthAlignment;
            i5 = r1;
            r1 = i6;
        }
        int i7 = this.mWidth;
        int i8 = this.mHeight;
        if (i7 < i8) {
            int i9 = i3;
            i3 = i;
            i = i9;
        } else {
            int i10 = i2;
            i2 = i4;
            i4 = i10;
        }
        if (i7 > i4 || i8 > i2) {
            int i11 = i7 * i2;
            int i12 = i8 * i4;
            if (i11 > i12) {
                if (i7 <= 0) {
                    i7 = 1;
                }
                i8 = i12 / i7;
                i7 = i4;
            } else {
                if (i8 <= 0) {
                    i8 = 1;
                }
                i7 = i11 / i8;
                i8 = i2;
            }
        }
        if (i7 % r1 != 0) {
            i7 = (i7 / r1) * r1;
        }
        if (i8 % i5 != 0) {
            i8 = (i8 / i5) * i5;
        }
        int valueInRange = valueInRange(i7, null, i, i4);
        int valueInRange2 = valueInRange(i8, null, i3, i2);
        int valueInRange3 = valueInRange(this.mFPS, range, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SET_SESSIONID);
        int valueInRange4 = valueInRange(this.mBPS, range2, 280000, 30000000);
        if (this.mWidth == valueInRange && this.mHeight == valueInRange2 && this.mFPS == valueInRange3 && this.mBPS == valueInRange4) {
            return;
        }
        KryptonLLog.i("KryptonMediaRecorder", "adjust video config to width: " + valueInRange + ", height: " + valueInRange2 + ", bps: " + valueInRange4 + ", fps: " + valueInRange3 + " from original width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS + ", range:" + this.mVideoRangeLogString);
        this.mWidth = valueInRange;
        this.mHeight = valueInRange2;
        this.mFPS = valueInRange3;
        this.mBPS = valueInRange4;
    }

    private MediaCodec findEncoderForFormat(MediaFormat mediaFormat) throws IOException {
        String findEncoderForFormat = new MediaCodecList(0).findEncoderForFormat(mediaFormat);
        if (!TextUtils.isEmpty(findEncoderForFormat) && !isInefficientEncoder(findEncoderForFormat)) {
            try {
                return MediaCodec.createByCodecName(findEncoderForFormat);
            } catch (IOException e) {
                KryptonLLog.w("KryptonMediaRecorder", "createByCodecName " + findEncoderForFormat + " exception " + e.getMessage());
            }
        }
        return MediaCodec.createEncoderByType(mediaFormat.getString("mime"));
    }

    private boolean isInefficientEncoder(String str) {
        for (String str2 : ENCODER_BLACK_LIST) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isResolutionSupported(MediaCodec mediaCodec, int i, int i2, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (mediaCodec == null || (capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(str)) == null || (videoCapabilities = capabilitiesForType.getVideoCapabilities()) == null) {
            return false;
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }

    private void autoAdjustVideoConfig() throws Exception {
        if (this.mToAdjustVideoConfig) {
            this.mVideoMediaCodecEncoder = findEncoderForFormat(MediaFormat.createVideoFormat("video/avc", 640, 480));
            adjustVideoConfig();
            if (!isResolutionSupported(this.mVideoMediaCodecEncoder, this.mWidth, this.mHeight, "video/avc")) {
                KryptonLLog.i("KryptonMediaRecorder", "release encoder which do not supported size (" + this.mWidth + ", " + this.mHeight + ")");
                releaseVideoMediaCodecEncoder(true);
            }
            this.mToAdjustVideoConfig = false;
        }
    }

    private void prepareVideoEncoder() throws Exception {
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        releaseVideoMediaCodecEncoder(true);
        autoAdjustVideoConfig();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.mWidth, this.mHeight);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_BIT_RATE, this.mBPS);
        createVideoFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_FRAME_RATE, this.mFPS);
        createVideoFormat.setInteger("i-frame-interval", 1);
        KryptonLLog.i("KryptonMediaRecorder", "create format width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);
        if (this.mVideoMediaCodecEncoder == null) {
            this.mVideoMediaCodecEncoder = findEncoderForFormat(createVideoFormat);
            KryptonLLog.i("KryptonMediaRecorder", " find encoder for size (" + this.mWidth + ", " + this.mHeight + ")");
        } else {
            KryptonLLog.i("KryptonMediaRecorder", " reuse the encoder found with dummy format for size (" + this.mWidth + ", " + this.mHeight + ")");
        }
        this.mVideoMediaCodecEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mVideoInputSurface = this.mVideoMediaCodecEncoder.createInputSurface();
        this.mVideoMediaCodecEncoder.start();
    }

    private long currentTimeUs() {
        long nanoTime = System.nanoTime();
        return (System.currentTimeMillis() * 1000) + ((nanoTime - ((nanoTime / 1000000) * 1000000)) / 1000);
    }

    private void prepareAudioEncoder() throws Exception {
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("aac-profile", 2);
        mediaFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE, this.mAudioSampleRate);
        mediaFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, this.mAudioChannelCount);
        mediaFormat.setInteger(com.ss.ttm.player.MediaFormat.KEY_BIT_RATE, this.mAudioBPS);
        mediaFormat.setInteger("max-input-size", 32768);
        releaseAudioMediaCodecEncoder(true);
        MediaCodec findEncoderForFormat = findEncoderForFormat(mediaFormat);
        this.mAudioMediaCodecEncoder = findEncoderForFormat;
        findEncoderForFormat.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mAudioMediaCodecEncoder.start();
    }

    private String createTempVideoFileInDirectory(String str) {
        if (str == null) {
            return null;
        }
        try {
            File createTempFile = File.createTempFile("krypton", ".mp4", new File(str));
            if (createTempFile.exists()) {
                createTempFile.delete();
            }
            return createTempFile.getPath();
        } catch (Exception e) {
            KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
            return null;
        }
    }

    private VideoPathInfo getOrCreateVideoPathInfo(boolean z) {
        File createTempFile;
        VideoPathInfo videoPathInfo = this.mDelegate.getVideoPathInfo(this.mMimeType, z);
        if (videoPathInfo == null) {
            videoPathInfo = new VideoPathInfo();
        }
        try {
            if (videoPathInfo.path != null) {
                createTempFile = new File(videoPathInfo.path);
            } else {
                String videoDirectory = this.mDelegate.getVideoDirectory(this.mMimeType, z);
                if (videoDirectory == null) {
                    throw new Exception("Should specify a video directory with getVideoDirectory method.");
                }
                createTempFile = File.createTempFile("krypton", ".mp4", new File(videoDirectory));
            }
            if (createTempFile.exists()) {
                createTempFile.delete();
            }
            videoPathInfo.path = createTempFile.getPath();
        } catch (Exception e) {
            KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
            videoPathInfo.path = null;
        }
        if (videoPathInfo.url == null && videoPathInfo.path != null) {
            videoPathInfo.url = ResManager.FILE_SCHEME.concat(videoPathInfo.path);
        }
        return videoPathInfo;
    }

    private void initMediaMuxer() throws Exception {
        releaseMediaMuxer(true);
        VideoPathInfo orCreateVideoPathInfo = getOrCreateVideoPathInfo(false);
        this.mVideoOutputPath = orCreateVideoPathInfo.path;
        this.mVideoOutputUrl = orCreateVideoPathInfo.url;
        this.mMediaMuxer = new MediaMuxer(this.mVideoOutputPath, 0);
    }

    private boolean deleteFileWithPath(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    return true;
                }
                KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + str);
            } else {
                KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + str + ", file not exists");
            }
            return false;
        } catch (Throwable th) {
            KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + str + " exception " + th.toString());
            return false;
        }
    }

    private synchronized void tryToDeleteFileWithPath(String str) {
        if (str != null) {
            deleteFileWithPath(str);
        }
    }

    private void resetOutputFormat(boolean z) {
        if (this.mMuxerStarted) {
            throw new IllegalStateException("output format already changed!");
        }
        if (z) {
            this.mAudioTrackIndex = this.mMediaMuxer.addTrack(this.mAudioMediaCodecEncoder.getOutputFormat());
        } else {
            this.mVideoTrackIndex = this.mMediaMuxer.addTrack(this.mVideoMediaCodecEncoder.getOutputFormat());
        }
        int i = this.mTrackCount + 1;
        this.mTrackCount = i;
        if (i == this.mAllTrackCount) {
            this.mMediaMuxer.start();
            this.mMuxerStarted = true;
        }
    }

    private void drainAudioEncoder() {
        ByteBuffer[] outputBuffers;
        MediaCodec mediaCodec = this.mAudioMediaCodecEncoder;
        if (mediaCodec == null || (outputBuffers = mediaCodec.getOutputBuffers()) == null) {
            return;
        }
        while (true) {
            int dequeueOutputBuffer = this.mAudioMediaCodecEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0L);
            if (dequeueOutputBuffer >= 0 || dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if ((this.mAudioBufferInfo.flags & 2) != 0) {
                    this.mAudioBufferInfo.size = 0;
                }
                if (this.mMuxerStarted && this.mAudioBufferInfo.size != 0) {
                    byteBuffer.position(this.mAudioBufferInfo.offset);
                    byteBuffer.limit(this.mAudioBufferInfo.offset + this.mAudioBufferInfo.size);
                    this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex, byteBuffer, this.mAudioBufferInfo);
                }
                this.mAudioMediaCodecEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
            } else {
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mAudioMediaCodecEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    resetOutputFormat(true);
                } else {
                    KryptonLLog.i("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                }
            }
        }
    }

    private void drainVideoEncoder(boolean z) {
        ByteBuffer[] outputBuffers;
        MediaCodec mediaCodec = this.mVideoMediaCodecEncoder;
        if (mediaCodec == null || (outputBuffers = mediaCodec.getOutputBuffers()) == null) {
            return;
        }
        while (true) {
            int dequeueOutputBuffer = this.mVideoMediaCodecEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if ((this.mVideoBufferInfo.flags & 2) != 0) {
                    this.mVideoBufferInfo.size = 0;
                }
                if (this.mMuxerStarted && this.mVideoBufferInfo.size > 0) {
                    byteBuffer.position(this.mVideoBufferInfo.offset);
                    byteBuffer.limit(this.mVideoBufferInfo.offset + this.mVideoBufferInfo.size);
                    this.mVideoBufferInfo.presentationTimeUs = getPresentationTimeUs();
                    if (!this.mPaused) {
                        long j = this.mVideoBufferInfo.presentationTimeUs;
                        long j2 = this.mLastVideoTime;
                        if (j <= j2) {
                            this.mVideoBufferInfo.presentationTimeUs = j2 + MIN_INTERVAL;
                        }
                        this.mLastVideoTime = this.mVideoBufferInfo.presentationTimeUs;
                        this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex, byteBuffer, this.mVideoBufferInfo);
                    }
                }
                this.mVideoMediaCodecEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.mVideoBufferInfo.flags & 4) != 0) {
                    if (z) {
                        return;
                    }
                    KryptonLLog.w("KryptonMediaRecorder", "reached end of stream unexpectedly");
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.mVideoMediaCodecEncoder.getOutputBuffers();
                KryptonLLog.i("KryptonMediaRecorder", "encoder output buffer length:" + outputBuffers.length);
            } else if (dequeueOutputBuffer == -2) {
                resetOutputFormat(false);
            } else if (dequeueOutputBuffer != -1) {
                KryptonLLog.w("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else if (!z) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ClipVideoTimeRanges {
        public Item[] itemArray;

        /* loaded from: classes6.dex */
        public class Item {
            public long end;
            public long offset;
            public long start;

            public Item() {
            }
        }

        ClipVideoTimeRanges(long[] jArr) {
            if (jArr != null) {
                if (jArr.length > 1) {
                    this.itemArray = new Item[jArr.length / 2];
                    for (int i = 1; i < jArr.length; i++) {
                        Item item = new Item();
                        item.start = jArr[i - 1];
                        item.end = jArr[i];
                        item.offset = -1L;
                        this.itemArray[i / 2] = item;
                    }
                }
            }
        }

        boolean valid() {
            Item[] itemArr = this.itemArray;
            return (itemArr == null || itemArr.length == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clipThreadRun() {
        int i;
        String extractMetadata;
        int integer;
        ClipVideoTimeRanges clipVideoTimeRanges = new ClipVideoTimeRanges(this.mClipTimeArray);
        if (!clipVideoTimeRanges.valid()) {
            notifyClipStopWithError(null, "clip error: no clip time array");
            return;
        }
        KryptonLLog.i("KryptonMediaRecorder", "start clip with ranges");
        VideoPathInfo orCreateVideoPathInfo = getOrCreateVideoPathInfo(true);
        String str = orCreateVideoPathInfo.path;
        String str2 = orCreateVideoPathInfo.url;
        if (str == null) {
            notifyClipStopWithError(null, "clip error: create file exception");
            return;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.mVideoOutputPath);
            int i2 = 0;
            MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            while (i2 < mediaExtractor.getTrackCount()) {
                try {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                    if (trackFormat.getString("mime").startsWith("video/")) {
                        try {
                            integer = trackFormat.getInteger("max-input-size");
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            i6 = mediaMuxer.addTrack(trackFormat);
                            i4 = i2;
                            i3 = integer;
                        } catch (Exception e2) {
                            e = e2;
                            i3 = integer;
                            notifyClipStopWithError(str, "clip error: " + e.toString());
                            i = i2;
                            int i8 = i5;
                            if (i == -1) {
                            }
                        }
                    } else if (trackFormat.getString("mime").startsWith("audio/")) {
                        try {
                            i7 = mediaMuxer.addTrack(trackFormat);
                            i5 = i2;
                        } catch (Exception e3) {
                            e = e3;
                            i5 = i2;
                            i2 = i4;
                            notifyClipStopWithError(str, "clip error: " + e.toString());
                            i = i2;
                            int i82 = i5;
                            if (i == -1) {
                            }
                        }
                    } else {
                        continue;
                    }
                    i2++;
                } catch (Exception e4) {
                    e = e4;
                }
            }
            i = i4;
            int i822 = i5;
            if (i == -1) {
                notifyClipStopWithError(str, "clip error: no video track found");
                return;
            }
            try {
                mediaMuxer.start();
                ByteBuffer allocate = ByteBuffer.allocate(i3);
                if (!clipTrack(mediaExtractor, mediaMuxer, clipVideoTimeRanges, false, allocate, i, i6)) {
                    notifyClipStopWithError(str, "clip error: no video track filled");
                    return;
                }
                if (i822 >= 0) {
                    clipTrack(mediaExtractor, mediaMuxer, clipVideoTimeRanges, true, allocate, i822, i7);
                }
                mediaMuxer.stop();
                mediaMuxer.release();
                mediaExtractor.release();
                File file = new File(str);
                if (!file.exists() || !file.isFile()) {
                    notifyClipStopWithError(str, "create video file failed.");
                    return;
                }
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    long length = file.length();
                    Invoker invoker = this.mInvoker;
                    if (invoker != null) {
                        extractMetadata = invoker.extractMetadata(mediaMetadataRetriever, 9);
                    } else {
                        extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    }
                    float parseFloat = extractMetadata != null ? Float.parseFloat(extractMetadata) : 0.0f;
                    this.mCachedPaths.add(str);
                    KryptonLLog.i("KryptonMediaRecorder", "clip stop with data: path: " + str + ",duration = " + parseFloat + ", size = " + length);
                    KryptonMediaRecorder.Listener listener = this.mListener;
                    if (listener != null) {
                        listener.onClipVideoEnd(this, str, str2, parseFloat / 1000.0f, length);
                    }
                } catch (Throwable unused) {
                    notifyClipStopWithError(str, "video file is empty");
                }
            } catch (Exception e5) {
                notifyClipStopWithError(str, "clip error: clip video data exception " + e5.toString());
            }
        } catch (Exception e6) {
            notifyClipStopWithError(str, "clip error: MediaExtractor exception " + e6.toString());
        }
    }

    private void notifyClipStopWithError(String str, String str2) {
        tryToDeleteFileWithPath(str);
        KryptonMediaRecorder.Listener listener = this.mListener;
        if (listener != null) {
            listener.onClipVideoEndWithError(this, str2);
        }
    }

    private boolean clipTrack(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, ClipVideoTimeRanges clipVideoTimeRanges, boolean z, ByteBuffer byteBuffer, int i, int i2) {
        long j;
        long j2;
        MediaExtractor mediaExtractor2 = mediaExtractor;
        ClipVideoTimeRanges clipVideoTimeRanges2 = clipVideoTimeRanges;
        mediaExtractor2.selectTrack(i);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i3 = 0;
        long j3 = 0;
        int i4 = 0;
        boolean z2 = false;
        long j4 = 0;
        while (i4 < clipVideoTimeRanges2.itemArray.length) {
            ClipVideoTimeRanges.Item item = clipVideoTimeRanges2.itemArray[i4];
            KryptonLLog.i("KryptonMediaRecorder", "start time " + item.start + ", end time" + item.end);
            long j5 = j4;
            mediaExtractor2.seekTo(item.start, i3);
            long j6 = -1;
            while (true) {
                int readSampleData = mediaExtractor2.readSampleData(byteBuffer, i3);
                if (readSampleData < 0) {
                    mediaExtractor2.unselectTrack(i);
                    j = j3;
                    break;
                }
                j = j3;
                long sampleTime = mediaExtractor.getSampleTime();
                int sampleFlags = mediaExtractor.getSampleFlags();
                if (sampleTime > item.end) {
                    KryptonLLog.i("KryptonMediaRecorder", "presentationTimeUs > endTime " + sampleTime + " > " + item.end);
                    break;
                }
                if (item.offset == -1) {
                    item.start = sampleTime;
                    j2 = j;
                    item.offset = j2;
                } else {
                    j2 = j;
                }
                if (sampleTime < item.start) {
                    mediaExtractor.advance();
                } else {
                    long j7 = (sampleTime - item.start) + item.offset;
                    if (j7 < j5) {
                        mediaExtractor.advance();
                    } else {
                        i3 = 0;
                        bufferInfo.offset = 0;
                        bufferInfo.size = readSampleData;
                        bufferInfo.flags = sampleFlags;
                        bufferInfo.presentationTimeUs = j7;
                        mediaMuxer.writeSampleData(i2, byteBuffer, bufferInfo);
                        mediaExtractor.advance();
                        z2 = true;
                        j5 = j7;
                        j3 = j2;
                        j6 = sampleTime;
                        mediaExtractor2 = mediaExtractor;
                        clipVideoTimeRanges2 = clipVideoTimeRanges;
                    }
                }
                mediaExtractor2 = mediaExtractor;
                clipVideoTimeRanges2 = clipVideoTimeRanges;
                j3 = j2;
                i3 = 0;
            }
            if (j6 != -1) {
                j3 = j + (j6 - item.start);
            } else {
                item.start = item.end;
                j3 = j;
            }
            i4++;
            j4 = j5;
            i3 = 0;
        }
        return z2;
    }
}
