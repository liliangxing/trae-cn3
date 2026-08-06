package com.lynx.animax.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.lynx.animax.base.Status;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class CodecManager {
    private static final int INVALID_FRAME = -1;
    private static final int MAX_CACHE_FRAME_COUNT = 20;
    private static final int MAX_TRY_COUNT = 3;
    private static final String TAG = "CodecManager";
    private VideoAsset mAsset;
    private int mCachedFrame;
    private int mCurrentMaxCacheFrameCount;
    private int mCurrentPresentFrame;
    private MediaCodec mDecoder;
    private String mDecoderName;
    private boolean mDecoderValid;
    private int mInfoTryAgainCount;
    private int mNextInputFrame;
    private int mNextOutputFrame;
    private CodecErrorReporter mReporter;
    private Surface mSurface;
    private long mTimeoutUs;
    private boolean mDecoderShouldRestart = false;
    private int mMediaCodecListNextTryIndex = 0;

    /* loaded from: classes6.dex */
    public interface CodecErrorReporter {
        void markDrawnOnce();

        void reportError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum ProcessFrameStatus {
        SUCCESS,
        TRY_AGAIN_IF_NECESSARY,
        TRY_AGAIN,
        FATAL
    }

    public CodecManager(CodecErrorReporter codecErrorReporter) {
        setReporter(codecErrorReporter);
    }

    public void initDecoder() {
        boolean z;
        String name;
        VideoAsset videoAsset = this.mAsset;
        if (videoAsset == null) {
            return;
        }
        MediaFormat format = videoAsset.getFormat();
        AnimaXLog.i("CodecManager", "initDecoder, format: " + format);
        String string = format.getString("mime");
        if (string == null) {
            return;
        }
        int codecCount = MediaCodecList.getCodecCount();
        while (true) {
            int i = this.mMediaCodecListNextTryIndex;
            if (i >= codecCount) {
                z = false;
                break;
            }
            this.mMediaCodecListNextTryIndex = i + 1;
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder() && supportMimeType(codecInfoAt, string) && (name = codecInfoAt.getName()) != null) {
                Status tryInitDecoder = tryInitDecoder(name);
                if (tryInitDecoder.mSuccess) {
                    z = true;
                    break;
                }
                AnimaXLog.e("CodecManager", "[" + name + "]: " + tryInitDecoder.mErrMsg);
            }
        }
        if (!z) {
            reportError("initDecoder error");
        } else {
            prepareFrameToMaxCacheCapacity();
        }
    }

    public void decodeAndUploadFrame(int i) {
        if (this.mDecoderShouldRestart) {
            this.mDecoderShouldRestart = false;
            releaseDecoder();
            initDecoder();
        }
        if (this.mDecoderValid && i != this.mCurrentPresentFrame) {
            refreshPlayerState(i);
            if (this.mDecoderValid) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int i2 = 3;
                while (this.mCurrentPresentFrame != i) {
                    prepareFrameToMaxCacheCapacity();
                    if (this.mCachedFrame == 0) {
                        return;
                    }
                    ProcessFrameStatus processFrame = processFrame(bufferInfo, this.mNextOutputFrame == i);
                    if (ProcessFrameStatus.SUCCESS != processFrame && ProcessFrameStatus.TRY_AGAIN != processFrame) {
                        if (ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY != processFrame || i2 <= 0) {
                            return;
                        } else {
                            i2--;
                        }
                    }
                }
                markDrawnOnce();
                prepareNextFrame();
            }
        }
    }

    public void attachSurface(Surface surface) {
        this.mSurface = surface;
    }

    public void attachAsset(VideoAsset videoAsset) {
        this.mAsset = videoAsset;
        if (videoAsset == null) {
            return;
        }
        if (!videoAsset.prepareFrameBufferIfNecessary()) {
            AnimaXLog.e("CodecManager", "attachAsset error: prepareFrameBuffer fail, reset mAsset");
            this.mAsset = null;
        } else {
            long frameRate = this.mAsset.getFrameRate();
            if (frameRate <= 0) {
                frameRate = 30;
            }
            this.mTimeoutUs = 1000000 / frameRate;
        }
    }

    public void setTimeout(long j) {
        this.mTimeoutUs = j;
    }

    public void setReporter(CodecErrorReporter codecErrorReporter) {
        this.mReporter = codecErrorReporter;
    }

    public void releaseDecoder() {
        if (this.mDecoder == null) {
            return;
        }
        AnimaXLog.i("CodecManager", "releaseDecoder");
        stopDecoder();
        this.mDecoderValid = false;
        this.mDecoder.release();
        this.mDecoder = null;
        resetDecoderState();
    }

    public void resetDecoderState() {
        this.mInfoTryAgainCount = 0;
        updateCurrentMaxCacheFrameCount();
        this.mCurrentPresentFrame = -1;
        this.mCachedFrame = 0;
        this.mNextInputFrame = 0;
        this.mNextOutputFrame = -1;
    }

    private boolean supportMimeType(MediaCodecInfo mediaCodecInfo, String str) {
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        int length = supportedTypes == null ? 0 : supportedTypes.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(supportedTypes[i])) {
                return true;
            }
        }
        return false;
    }

    private Status tryInitDecoder(String str) {
        AnimaXLog.i("CodecManager", "try decoder: " + str);
        if (this.mAsset == null) {
            return new Status("tryInitDecoder error: mAsset is null");
        }
        Status createCodec = createCodec(str);
        if (!createCodec.mSuccess) {
            return createCodec;
        }
        Status configureCodec = configureCodec(this.mAsset.getFormat(), this.mSurface, null, 0);
        if (!configureCodec.mSuccess) {
            this.mDecoder.release();
            this.mDecoder = null;
            return configureCodec;
        }
        Status startDecoder = startDecoder();
        if (!startDecoder.mSuccess) {
            this.mDecoder.release();
            this.mDecoder = null;
            return startDecoder;
        }
        this.mDecoderName = str;
        this.mDecoderValid = true;
        AnimaXLog.i("CodecManager", "chosen decoder: " + str);
        return new Status(true);
    }

    private Status createCodec(String str) {
        String str2;
        try {
            this.mDecoder = MediaCodec.createByCodecName(str);
            str2 = null;
        } catch (MediaCodec.CodecException e) {
            str2 = "createByCodecName CodecException: " + e.getMessage();
        } catch (IOException e2) {
            e = e2;
            str2 = "createByCodecName Exception: " + e.getMessage();
        } catch (IllegalArgumentException e3) {
            e = e3;
            str2 = "createByCodecName Exception: " + e.getMessage();
        }
        return new Status(str2);
    }

    private Status configureCodec(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        String str;
        try {
            this.mDecoder.configure(mediaFormat, surface, mediaCrypto, i);
            str = null;
        } catch (MediaCodec.CodecException e) {
            str = "configureCodec CodecException: " + e.getMessage();
        } catch (MediaCodec.CryptoException e2) {
            str = "configureCodec CryptoException: " + e2.getMessage();
        } catch (IllegalArgumentException e3) {
            e = e3;
            str = "configureCodec Exception: " + e.getMessage();
        } catch (IllegalStateException e4) {
            e = e4;
            str = "configureCodec Exception: " + e.getMessage();
        }
        return new Status(str);
    }

    private Status startDecoder() {
        String str;
        try {
            this.mDecoder.start();
            str = null;
        } catch (MediaCodec.CodecException e) {
            str = "startDecoder CodecException: " + e.getMessage();
        } catch (IllegalArgumentException e2) {
            e = e2;
            str = "startDecoder Exception: " + e.getMessage();
        } catch (IllegalStateException e3) {
            e = e3;
            str = "startDecoder Exception: " + e.getMessage();
        }
        return new Status(str);
    }

    private Status stopDecoder() {
        String str;
        try {
            this.mDecoder.stop();
            str = null;
        } catch (IllegalArgumentException | IllegalStateException e) {
            str = "stopDecoder Exception: " + e.getMessage();
        }
        return new Status(str);
    }

    private void refreshPlayerState(int i) {
        VideoAsset videoAsset = this.mAsset;
        if (videoAsset == null) {
            return;
        }
        int prevKeyFrame = videoAsset.getPrevKeyFrame(i);
        if (-1 == this.mNextOutputFrame) {
            this.mCachedFrame = 0;
            this.mNextInputFrame = prevKeyFrame;
            return;
        }
        int i2 = (i - prevKeyFrame) + 1;
        int i3 = this.mCurrentPresentFrame;
        if (i3 > i) {
            i += this.mAsset.getFrameCount();
            i3 = this.mCurrentPresentFrame;
        }
        int i4 = i - i3;
        int i5 = this.mCachedFrame;
        if ((i4 > i5 ? i4 - i5 : 0) > i2) {
            discardCachedFrame();
            this.mNextInputFrame = prevKeyFrame;
            this.mNextOutputFrame = -1;
        }
    }

    private ProcessFrameStatus processFrame(MediaCodec.BufferInfo bufferInfo, boolean z) {
        if (this.mAsset == null) {
            return ProcessFrameStatus.FATAL;
        }
        try {
            int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(bufferInfo, this.mTimeoutUs);
            if (-3 == dequeueOutputBuffer) {
                AnimaXLog.i("CodecManager", "output buffers changed");
                return ProcessFrameStatus.TRY_AGAIN;
            }
            if (-2 == dequeueOutputBuffer) {
                AnimaXLog.i("CodecManager", "output format changed: " + getOutputFormatSafely());
                return ProcessFrameStatus.TRY_AGAIN;
            }
            if (-1 == dequeueOutputBuffer) {
                this.mInfoTryAgainCount++;
                updateCurrentMaxCacheFrameCount();
                return ProcessFrameStatus.TRY_AGAIN_IF_NECESSARY;
            }
            if (dequeueOutputBuffer < 0) {
                reportError("[" + this.mDecoderName + "]: outputBufferIndex: " + dequeueOutputBuffer);
                return ProcessFrameStatus.FATAL;
            }
            releaseOutputBuffer(dequeueOutputBuffer, z);
            this.mCachedFrame--;
            int i = this.mNextOutputFrame;
            this.mCurrentPresentFrame = i;
            this.mNextOutputFrame = (i + 1) % this.mAsset.getFrameCount();
            return ProcessFrameStatus.SUCCESS;
        } catch (MediaCodec.CodecException e) {
            reportError("[" + this.mDecoderName + "]: dequeueOutputBuffer CodecException: " + e.getMessage());
            return ProcessFrameStatus.FATAL;
        } catch (IllegalStateException e2) {
            reportError("[" + this.mDecoderName + "]: dequeueOutputBuffer IllegalStateException: " + e2.getMessage());
            this.mDecoderValid = false;
            this.mDecoderShouldRestart = true;
            return ProcessFrameStatus.FATAL;
        }
    }

    private MediaFormat getOutputFormatSafely() {
        MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec == null) {
            return null;
        }
        try {
            return mediaCodec.getOutputFormat();
        } catch (IllegalStateException e) {
            AnimaXLog.e("CodecManager", "getOutputFormat failed: " + e.getMessage());
            return null;
        }
    }

    private void updateCurrentMaxCacheFrameCount() {
        if (this.mInfoTryAgainCount < 0) {
            this.mInfoTryAgainCount = 0;
        }
        int i = this.mInfoTryAgainCount;
        if (i > 1) {
            this.mCurrentMaxCacheFrameCount = Math.min(20, i + 5);
        } else {
            this.mCurrentMaxCacheFrameCount = Math.min(20, (i * 3) + 3);
        }
    }

    private void discardCachedFrame() {
        if (this.mCachedFrame > 0) {
            flush();
            this.mCachedFrame = 0;
        }
    }

    private void flush() {
        String str;
        try {
            this.mDecoder.flush();
            str = null;
        } catch (MediaCodec.CodecException e) {
            str = "[" + this.mDecoderName + "]: flush CodecException: " + e.getMessage();
        } catch (IllegalStateException e2) {
            str = "[" + this.mDecoderName + "]: flush IllegalStateException: " + e2.getMessage();
        }
        if (str != null) {
            reportError(str);
            this.mDecoderValid = false;
        }
    }

    private boolean queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        String str;
        try {
            this.mDecoder.queueInputBuffer(i, i2, i3, j, i4);
            str = null;
        } catch (MediaCodec.CodecException e) {
            str = "[" + this.mDecoderName + "]: queueInputBuffer CodecException: " + e.getMessage();
        } catch (MediaCodec.CryptoException e2) {
            str = "[" + this.mDecoderName + "]: queueInputBuffer CryptoException: " + e2.getMessage();
        } catch (IllegalStateException e3) {
            str = "[" + this.mDecoderName + "]: queueInputBuffer IllegalStateException: " + e3.getMessage();
        }
        if (str == null) {
            return true;
        }
        reportError(str);
        return false;
    }

    private boolean releaseOutputBuffer(int i, boolean z) {
        String str;
        try {
            this.mDecoder.releaseOutputBuffer(i, z);
            str = null;
        } catch (MediaCodec.CodecException e) {
            str = "[" + this.mDecoderName + "]: releaseOutputBuffer CodecException: " + e.getMessage();
        } catch (IllegalStateException e2) {
            str = "[" + this.mDecoderName + "]: releaseOutputBuffer IllegalStateException: " + e2.getMessage();
        }
        if (str == null) {
            return true;
        }
        reportError(str);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0058 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int prepareInputBuffer(ByteBuffer byteBuffer) {
        int i;
        ByteBuffer inputBuffer;
        try {
            i = this.mDecoder.dequeueInputBuffer(this.mTimeoutUs);
        } catch (MediaCodec.CodecException e) {
            reportError("[" + this.mDecoderName + "]: dequeueInputBuffer CodecException: " + e.getMessage());
            i = -1;
            if (i < 0) {
                return -1;
            }
            if (byteBuffer != null) {
            }
            return i;
        } catch (IllegalStateException e2) {
            reportError("[" + this.mDecoderName + "]: dequeueInputBuffer IllegalStateException: " + e2.getMessage());
            this.mDecoderValid = false;
            this.mDecoderShouldRestart = true;
            i = -1;
            if (i < 0) {
            }
        }
        if (i < 0 || (inputBuffer = getInputBuffer(i)) == null) {
            return -1;
        }
        if (byteBuffer != null) {
            inputBuffer.put(byteBuffer);
        }
        return i;
    }

    private ByteBuffer getInputBuffer(int i) {
        try {
            return this.mDecoder.getInputBuffer(i);
        } catch (MediaCodec.CodecException e) {
            reportError("[" + this.mDecoderName + "]: getInputBuffer CodecException: " + e.getMessage());
            return null;
        } catch (IllegalStateException e2) {
            reportError("[" + this.mDecoderName + "]: getInputBuffer IllegalStateException: " + e2.getMessage());
            return null;
        }
    }

    private void prepareFrameToMaxCacheCapacity() {
        do {
        } while (prepareNextFrame());
    }

    private boolean prepareNextFrame() {
        VideoAsset videoAsset;
        FrameInfo frameInfo;
        ByteBuffer frameData;
        int prepareInputBuffer;
        if (!this.mDecoderValid || (videoAsset = this.mAsset) == null || this.mCachedFrame >= this.mCurrentMaxCacheFrameCount || (frameData = this.mAsset.getFrameData((frameInfo = videoAsset.getFrameInfo(this.mNextInputFrame)))) == null || (prepareInputBuffer = prepareInputBuffer(frameData)) < 0) {
            return false;
        }
        boolean queueInputBuffer = queueInputBuffer(prepareInputBuffer, 0, frameInfo.end() - frameInfo.begin(), frameInfo.getPresentationTimeUs(), 0);
        if (queueInputBuffer) {
            this.mCachedFrame++;
            if (-1 == this.mNextOutputFrame) {
                this.mNextOutputFrame = this.mNextInputFrame;
            }
            this.mNextInputFrame = (this.mNextInputFrame + 1) % this.mAsset.getFrameCount();
        }
        return queueInputBuffer;
    }

    private void reportError(String str) {
        CodecErrorReporter codecErrorReporter = this.mReporter;
        if (codecErrorReporter != null) {
            codecErrorReporter.reportError(str);
        }
    }

    private void markDrawnOnce() {
        CodecErrorReporter codecErrorReporter = this.mReporter;
        if (codecErrorReporter != null) {
            codecErrorReporter.markDrawnOnce();
        }
    }
}
