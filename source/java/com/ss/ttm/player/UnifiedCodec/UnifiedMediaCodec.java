package com.ss.ttm.player.UnifiedCodec;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.callback.Callback;
import com.ss.ttm.player.UnifiedCodec.callback.CodecCallback;
import com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter;
import com.ss.ttm.player.UnifiedCodec.statistics.MediaCodecStatistics;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.vcbkit.VLog;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class UnifiedMediaCodec implements IMediaCodec {
    public static final int ERROR_ADAPTER_IS_NULL = -1000;
    private static final String TAG = "UnifiedMediaCodec";
    public CodecAdapter mCodecAdapter;
    public CodecCallback mCodecCallback;
    public boolean mCodecFinalReuseEnable;
    private final String mCodecNameOrType;
    private boolean mConfigureCalled;
    private final CreateBy mCreateBy;
    public boolean mIsReused;
    private String mMimeType;
    private boolean mEnableReuse = true;
    public final MediaCodecStatistics mCodecStatistics = new MediaCodecStatistics();

    /* loaded from: classes7.dex */
    public enum CreateBy {
        CreateByName,
        CreateByType
    }

    private UnifiedMediaCodec(String codecNameOrType, CreateBy createBy) {
        this.mCodecNameOrType = codecNameOrType;
        this.mCreateBy = createBy;
    }

    public static UnifiedMediaCodec createByCodecName(String codecName) {
        return new UnifiedMediaCodec(codecName, CreateBy.CreateByName);
    }

    public static UnifiedMediaCodec createByCodecType(String codecType) {
        return new UnifiedMediaCodec(codecType, CreateBy.CreateByType);
    }

    private void onAfterConfigure() {
        this.mCodecStatistics.configCodecEnd(this.mIsReused);
    }

    private void onAfterStart() {
        this.mCodecStatistics.startCodecEnd();
    }

    private void onBeforeConfigure(Surface surface) {
        this.mCodecFinalReuseEnable = MediaCodecManager.getInstance().reuseEnable(this, surface);
        this.mCodecStatistics.createByCodecStart();
        this.mCodecStatistics.createByCodecEnd();
        this.mCodecStatistics.configCodecStart(this.mCodecFinalReuseEnable);
    }

    private void onBeforeStart() {
        this.mCodecStatistics.startCodecStart();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags) throws IOException {
        if (this.mConfigureCalled) {
            VLog.w(TAG, "configure ignored, mediaFormat:" + mediaFormat + " surface:" + surface + " crypto:" + mediaCrypto + " flags:" + flags + " stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.mConfigureCalled = true;
        this.mMimeType = mediaFormat.getString("mime");
        onBeforeConfigure(surface);
        this.mCodecStatistics.setIsVideo(isVideo());
        if (this.mCodecAdapter == null) {
            this.mCodecAdapter = MediaCodecManager.getInstance().configure(mediaFormat, surface, mediaCrypto, flags, this);
        } else {
            MediaCodecManager.getInstance().configureCodec(this.mCodecAdapter, mediaFormat, surface, mediaCrypto, flags, this);
        }
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || codecAdapter.checkCodecError()) {
            throw new RuntimeException("create codec adapter failed");
        }
        onAfterConfigure();
    }

    public final int dequeueInputBuffer(long timeoutUs) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            return codecAdapter.dequeueInputBuffer(timeoutUs);
        }
        return -1000;
    }

    public final int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long timeoutUs) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            return codecAdapter.dequeueOutputBuffer(bufferInfo, timeoutUs);
        }
        return -1000;
    }

    public final void flush() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.flush();
        }
    }

    public final CodecCallback getCodecCallback() {
        return this.mCodecCallback;
    }

    public final CodecAdapter getCodecAdapter() {
        return this.mCodecAdapter;
    }

    public CreateBy getCreateMethod() {
        return this.mCreateBy;
    }

    public final ByteBuffer getInputBuffer(int index) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            return codecAdapter.getMediaCodec().getInputBuffer(index);
        }
        return null;
    }

    public final ByteBuffer[] getInputBuffers() {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getInputBuffers();
    }

    public final String getCodecNameOrType() {
        return this.mCodecNameOrType;
    }

    public final ByteBuffer getOutputBuffer(int index) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getOutputBuffer(index);
    }

    public final ByteBuffer[] getOutputBuffers() {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getOutputBuffers();
    }

    public final MediaFormat getOutputFormat() {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getOutputFormat();
    }

    public final Image getOutputImage(int index) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            return codecAdapter.getMediaCodec().getOutputImage(index);
        }
        return null;
    }

    public final MediaCodec.OutputFrame getOutputFrame(int index) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getOutputFrame(index);
    }

    public final MediaCodec.QueueRequest getQueueRequest(int index) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getQueueRequest(index);
    }

    public final MediaCodecInfo getCodecInfo() {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getCodecInfo();
    }

    public final String getName() {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return null;
        }
        return mediaCodec.getName();
    }

    public final boolean isReuseEnable() {
        return this.mEnableReuse;
    }

    public final boolean isVideo() {
        return CodecUtils.isVideo(this.mMimeType);
    }

    public final void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.queueInputBuffer(index, offset, size, presentationTimeUs, flags);
        }
    }

    public final void queueSecureInputBuffer(int index, int offset, MediaCodec.CryptoInfo cryptoInfo, long presentationTimeUs, int flags) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.queueSecureInputBuffer(index, offset, cryptoInfo, presentationTimeUs, flags);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void release() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.release();
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void releaseOutputBuffer(int index, boolean render) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.releaseOutputBuffer(index, render);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void reset() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.reset();
        }
    }

    public final void setCallback(Callback callback) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || codecAdapter.getMediaCodec() == null) {
            return;
        }
        this.mCodecAdapter.setCallback(this, callback);
    }

    public final void setCodecCallback(CodecCallback codecCallback) {
        this.mCodecCallback = codecCallback;
    }

    public final void setOutputSurface(Surface surface) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.setOutputSurface(surface);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void setParameters(Bundle bundle) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setParameters(bundle);
    }

    public final void setEnableReuse(boolean enable) {
        this.mEnableReuse = enable;
    }

    public final void setVideoScalingMode(int mode) {
        MediaCodec mediaCodec;
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || (mediaCodec = codecAdapter.getMediaCodec()) == null) {
            return;
        }
        mediaCodec.setVideoScalingMode(mode);
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void start() {
        onBeforeStart();
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.start();
        }
        onAfterStart();
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void stop() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.stop();
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void releaseOutputBuffer(int index, long renderTimestampNs) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.releaseOutputBuffer(index, renderTimestampNs);
        }
    }

    public final void setCallback(Callback callback, Handler handler) {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter != null) {
            codecAdapter.setCallback(this, callback, handler);
        }
    }

    @Override // com.ss.ttm.player.UnifiedCodec.IMediaCodec
    public void configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler) throws IOException {
        if (this.mConfigureCalled) {
            VLog.w(TAG, "configure ignored, Format:" + mediaFormat + " surface:" + surface + " flags:" + flags + " descrambler:" + mediaDescrambler + " stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.mConfigureCalled = true;
        onBeforeConfigure(surface);
        if (this.mCodecAdapter == null) {
            this.mCodecAdapter = MediaCodecManager.getInstance().configure(mediaFormat, surface, flags, mediaDescrambler, this);
        } else {
            MediaCodecManager.getInstance().configureCodec(this.mCodecAdapter, mediaFormat, surface, mediaDescrambler, flags, this);
        }
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null || codecAdapter.checkCodecError()) {
            throw new RuntimeException("create codec adapter failed");
        }
        onAfterConfigure();
    }

    public Handler getCodecHandler() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null) {
            return null;
        }
        return codecAdapter.getCodecHandler();
    }

    public void forceDisableReuse() {
        CodecAdapter codecAdapter = this.mCodecAdapter;
        if (codecAdapter == null) {
            return;
        }
        codecAdapter.setReusable(false);
    }

    public void createCodecEarly() throws IOException {
        this.mCodecFinalReuseEnable = this.mEnableReuse;
        String mimeType = CodecUtils.getMimeType(this.mCodecNameOrType);
        this.mMimeType = mimeType;
        if (mimeType != null) {
            this.mCodecAdapter = MediaCodecManager.getInstance().getCodecAdapter(MediaFormat.createVideoFormat(mimeType, 1920, 1920), this, null);
        }
    }
}
