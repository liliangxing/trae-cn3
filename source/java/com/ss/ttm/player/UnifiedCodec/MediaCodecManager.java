package com.ss.ttm.player.UnifiedCodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.view.Surface;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;
import com.ss.ttm.player.UnifiedCodec.codec.AudioCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.CodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.DirectCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.FormatWrapper;
import com.ss.ttm.player.UnifiedCodec.codec.ReuseCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.codec.VideoCodecAdapter;
import com.ss.ttm.player.UnifiedCodec.pool.CodecAdapterManager;
import com.ss.ttm.player.UnifiedCodec.reuse.ReuseHelper;
import com.ss.ttm.player.UnifiedCodec.reuse.ReusePolicy;
import com.ss.ttm.player.UnifiedCodec.util.CodecUtils;
import com.ss.ttm.player.UnifiedCodec.util.DeviceUtils;
import com.ss.vcbkit.VLog;
import java.io.IOException;
import java.util.LinkedHashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class MediaCodecManager {
    public static final String TAG = "CodecManager";
    private static final MediaCodecManager mInstance = new MediaCodecManager();
    private boolean mEnablePersistPool = true;
    private final CodecAdapterManager mAudioCodecManager = new CodecAdapterManager();
    private boolean mConfigMethodCalled = false;
    private boolean mEnableGlobalReuse = true;
    private final PreloadCodecManager mPreloadCodecManager = new PreloadCodecManager();
    private ReusePolicy mReusePolicy = ReusePolicy.DEFAULT;
    private final CodecAdapterManager mVideoCodecManager = new CodecAdapterManager();

    public static void init() {
    }

    private void changeToReuseDisable() {
        this.mVideoCodecManager.clearAll();
        this.mAudioCodecManager.clearAll();
    }

    private CodecAdapter createDirectCodecAdapter(MediaFormat mediaFormat, UnifiedMediaCodec unifiedMediaCodec) throws IOException {
        return unifiedMediaCodec.getCreateMethod() == UnifiedMediaCodec.CreateBy.CreateByName ? new DirectCodecAdapter(MediaCodec.createByCodecName(unifiedMediaCodec.getCodecNameOrType())) : new DirectCodecAdapter(MediaCodec.createDecoderByType(unifiedMediaCodec.getCodecNameOrType()));
    }

    private CodecAdapter createReuseCodecAdapter(MediaFormat mediaFormat, UnifiedMediaCodec unifiedMediaCodec) throws IOException {
        String string = mediaFormat.getString("mime");
        FormatWrapper create = FormatWrapper.create(mediaFormat);
        ReuseHelper.initFormatWrapper(create, mediaFormat);
        return ReuseCodecAdapter.create(unifiedMediaCodec.getCreateMethod() == UnifiedMediaCodec.CreateBy.CreateByName ? MediaCodec.createByCodecName(unifiedMediaCodec.getCodecNameOrType()) : MediaCodec.createDecoderByType(string), string, create);
    }

    public CodecAdapter getCodecAdapter(MediaFormat mediaFormat, UnifiedMediaCodec unifiedMediaCodec, Surface surface) throws IOException {
        boolean isVideo = unifiedMediaCodec.isVideo();
        if (DeviceUtils.SDK_INT < 23 || !unifiedMediaCodec.mCodecFinalReuseEnable) {
            unifiedMediaCodec.mIsReused = false;
            return createDirectCodecAdapter(mediaFormat, unifiedMediaCodec);
        }
        FormatWrapper create = FormatWrapper.create(mediaFormat);
        CodecAdapter obtainCodecAdapter = obtainCodecAdapter(isVideo, create);
        if (obtainCodecAdapter != null) {
            ReuseHelper.ReuseResult canReuseType = obtainCodecAdapter.canReuseType(create);
            if (canReuseType == ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITHOUT_RECONFIGURATION || canReuseType == ReuseHelper.ReuseResult.CODEC_RESULT_YES_WITH_RECONFIGURATION) {
                obtainCodecAdapter.prepareReuse();
                unifiedMediaCodec.mIsReused = true;
                return obtainCodecAdapter;
            }
            if (canReuseType == ReuseHelper.ReuseResult.CODEC_RESULT_NO) {
                VLog.m251w(TAG, "getCodec not reuse, isVideo:" + isVideo + " reuseType:" + canReuseType);
            }
        }
        unifiedMediaCodec.mIsReused = false;
        return createReuseCodecAdapter(mediaFormat, unifiedMediaCodec);
    }

    public static MediaCodecManager getInstance() {
        return mInstance;
    }

    private CodecAdapter obtainCodecAdapter(boolean isVideo, FormatWrapper formatWrapper) {
        return (isVideo ? this.mVideoCodecManager : this.mAudioCodecManager).obtainCodecAdapter(formatWrapper);
    }

    private void onCodecRunning(CodecAdapter codecAdapter) {
        if (isEnableGlobalReuse()) {
            if (codecAdapter instanceof VideoCodecAdapter) {
                this.mVideoCodecManager.transToRunning((ReuseCodecAdapter) codecAdapter);
            } else if (codecAdapter instanceof AudioCodecAdapter) {
                this.mAudioCodecManager.transToRunning((ReuseCodecAdapter) codecAdapter);
            }
        }
    }

    public final void clearPersistPool() {
        this.mEnablePersistPool = false;
        this.mVideoCodecManager.clearPersistPool();
        this.mAudioCodecManager.clearPersistPool();
    }

    public final CodecAdapter configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags, UnifiedMediaCodec unifiedMediaCodec) throws IOException {
        CodecAdapter codecAdapter;
        this.mConfigMethodCalled = true;
        this.mEnablePersistPool = true;
        try {
            codecAdapter = getCodecAdapter(mediaFormat, unifiedMediaCodec, surface);
        } catch (Exception e) {
            e = e;
            codecAdapter = null;
        }
        try {
            configureCodec(codecAdapter, mediaFormat, surface, mediaCrypto, flags, unifiedMediaCodec);
        } catch (Exception e2) {
            e = e2;
            VLog.m245d(TAG, "getCodecAdapter failed, e:" + e + ", codecAdapter:" + codecAdapter);
            return codecAdapter;
        }
        return codecAdapter;
    }

    public final ReusePolicy getReusePolicy() {
        return this.mReusePolicy;
    }

    public final boolean isEnablePersistPool() {
        return this.mEnablePersistPool;
    }

    public final boolean isEnableGlobalReuse() {
        return this.mEnableGlobalReuse;
    }

    public final void preloadCodec(String firstCodec, String secondCodec) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (PreloadCodecManager.isInvalidMimeType(firstCodec)) {
            linkedHashSet.add(firstCodec);
        }
        if (PreloadCodecManager.isInvalidMimeType(secondCodec)) {
            linkedHashSet.add(secondCodec);
        }
        this.mPreloadCodecManager.preload(linkedHashSet);
    }

    public final void recycleCodecFromRunning(CodecAdapter codecAdapter) {
        if (isEnableGlobalReuse()) {
            if (codecAdapter instanceof VideoCodecAdapter) {
                this.mVideoCodecManager.transToPersist((ReuseCodecAdapter) codecAdapter);
            } else if (codecAdapter instanceof AudioCodecAdapter) {
                this.mAudioCodecManager.transToPersist((ReuseCodecAdapter) codecAdapter);
            }
        }
    }

    public final void removeCodecFromRunningPool(CodecAdapter codecAdapter) {
        if (isEnableGlobalReuse()) {
            if (codecAdapter instanceof VideoCodecAdapter) {
                this.mVideoCodecManager.removeFromRunning((ReuseCodecAdapter) codecAdapter);
            } else if (codecAdapter instanceof AudioCodecAdapter) {
                this.mAudioCodecManager.removeFromRunning((ReuseCodecAdapter) codecAdapter);
            }
        }
    }

    public boolean reuseEnable(UnifiedMediaCodec unifiedMediaCodec, Surface surface) {
        return (isEnableGlobalReuse() && unifiedMediaCodec.isReuseEnable()) && unifiedMediaCodec.isVideo() && (DeviceUtils.SDK_INT >= 23 && !CodecUtils.codecNeedsSetOutputSurfaceWorkaround()) && surface != null;
    }

    public final void setEnableGlobalReuse(boolean enable) {
        if (this.mEnableGlobalReuse != enable) {
            this.mEnableGlobalReuse = enable;
            if (!this.mConfigMethodCalled || enable) {
                return;
            }
            changeToReuseDisable();
        }
    }

    public final void setReusePolicy(ReusePolicy reusePolicy) {
        this.mReusePolicy = reusePolicy;
    }

    public final CodecAdapter configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler, UnifiedMediaCodec unifiedMediaCodec) throws IOException {
        CodecAdapter codecAdapter;
        this.mConfigMethodCalled = true;
        this.mEnablePersistPool = true;
        try {
            codecAdapter = getCodecAdapter(mediaFormat, unifiedMediaCodec, surface);
        } catch (Exception e) {
            e = e;
            codecAdapter = null;
        }
        try {
            configureCodec(codecAdapter, mediaFormat, surface, mediaDescrambler, flags, unifiedMediaCodec);
        } catch (Exception e2) {
            e = e2;
            VLog.m245d(TAG, "getCodecAdapter failed, e:" + e + ", codecAdapter:" + codecAdapter);
            return codecAdapter;
        }
        return codecAdapter;
    }

    public final void configureCodec(CodecAdapter codec, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags, UnifiedMediaCodec unifiedMediaCodec) {
        codec.setCodecCallback(unifiedMediaCodec.getCodecCallback());
        onCodecRunning(codec);
        codec.configure(mediaFormat, surface, mediaCrypto, flags);
    }

    public final void configureCodec(CodecAdapter codec, MediaFormat mediaFormat, Surface surface, MediaDescrambler mediaDescrambler, int flags, UnifiedMediaCodec unifiedMediaCodec) {
        codec.setCodecCallback(unifiedMediaCodec.getCodecCallback());
        onCodecRunning(codec);
        codec.configure(mediaFormat, surface, flags, mediaDescrambler);
    }
}
