package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.InternalExpressDetectConfig;
import com.ss.bytertc.engine.NativeRTCVideoFunctions;
import com.ss.bytertc.engine.data.VirtualBackgroundSource;
import com.ss.bytertc.engine.handler.RTCFaceDetectionObserver;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCVideoEffect extends IVideoEffect {
    private static final String TAG = "RTCVideoEffect";
    private IFaceDetectionObserver mFaceDetectionObserver;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeEngine;
    private RTCFaceDetectionObserver mRTCFaceDetectionObserver;
    private final ReentrantReadWriteLock mReadWriteLock;

    public RTCVideoEffect(long nativeEngine) {
        this.mNativeEngine = 0L;
        this.mRTCFaceDetectionObserver = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeEngine = nativeEngine;
        this.mRTCFaceDetectionObserver = new RTCFaceDetectionObserver(this);
        LogUtil.m218i(TAG, "create rtc video effect");
    }

    private boolean engineInvalid() {
        return this.mNativeEngine == 0;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setAlgoModelResourceFinder(long finder, long deleter) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setAlgoModelResourceFinder failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeSetVideoEffectAlgoModelResourceFinder(this.mNativeEngine, finder, deleter);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int initCVResource(String license_file, String algo_model_dir) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, initCVResource failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeInitCVResource(this.mNativeEngine, license_file, algo_model_dir);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVideoEffect() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, enableVideoEffect failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeEnableVideoEffect2(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVideoEffect() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, disableVideoEffect failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeDisableVideoEffect(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public long getVideoEffectHandle() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getVideoEffectHandle failed.");
                this.mJniReadLock.unlock();
                return -1006L;
            }
            return NativeRTCVideoFunctions.nativeGetVideoEffectHandle(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int applyStickerEffect(String tickerPath) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, applyStickerEffect failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeApplyStickerEffect(this.mNativeEngine, tickerPath);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setEffectNodes(List<String> effect_nodes) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            if (effect_nodes == null) {
                LogUtil.m219w(TAG, "effect_nodes is null, setting empty effect nodes.");
                effect_nodes = new ArrayList<>();
            }
            String[] strArr = new String[effect_nodes.size()];
            effect_nodes.toArray(strArr);
            return NativeRTCVideoFunctions.nativeSetVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int appendEffectNodes(List<String> effect_nodes) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, appendEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String[] strArr = new String[effect_nodes.size()];
            effect_nodes.toArray(strArr);
            return NativeRTCVideoFunctions.nativeAppendVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int removeEffectNodes(List<String> effect_nodes) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, removeEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String[] strArr = new String[effect_nodes.size()];
            effect_nodes.toArray(strArr);
            return NativeRTCVideoFunctions.nativeRemoveVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int updateEffectNode(String effectNode, String key, float value) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, updateEffectNode failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeUpdateVideoEffectNode(this.mNativeEngine, effectNode, key, value);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilter(String filter_res) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setColorFilter failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeSetVideoEffectColorFilter(this.mNativeEngine, filter_res);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilterIntensity(float intensity) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setColorFilterIntensity failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeSetVideoEffectColorFilterIntensity(this.mNativeEngine, intensity);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVirtualBackground(String bg_sticker_res, VirtualBackgroundSource source) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, enableVirtualBackground failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String str = "";
            if (source != null && source.sourcePath != null) {
                str = source.sourcePath;
            }
            return NativeRTCVideoFunctions.nativeEnableVirtualBackground(this.mNativeEngine, bg_sticker_res, source.sourceType.ordinal(), source.sourceColor, str);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVirtualBackground() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, disableVirtualBackground failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeDisableVirtualBackground(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setVideoEffectExpressionDetect(VideoEffectExpressionConfig config) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setVideoEffectExpressionDetect failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            return NativeRTCVideoFunctions.nativeSetVideoEffectExpressionDetect(this.mNativeEngine, new InternalExpressDetectConfig(config));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public IFaceDetectionObserver getFaceDetectionObserver() {
        return this.mFaceDetectionObserver;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableFaceDetection(IFaceDetectionObserver observer, int interval_ms, String face_model_path) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, registerFaceDetectionObserver failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            this.mFaceDetectionObserver = observer;
            return NativeRTCVideoFunctions.nativeEnableFaceDetection(this.mNativeEngine, this.mRTCFaceDetectionObserver, interval_ms, face_model_path);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableFaceDetection() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, registerFaceDetectionObserver failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            this.mFaceDetectionObserver = null;
            return NativeRTCVideoFunctions.nativeDisableFaceDetection(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setVideoEffectTouchEvent(int pointerId, float x, float y, float force, float majorRadius, EffectTouchType type, int pointerCount) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, setVideoEffectTouchEvent failed.");
                this.mJniReadLock.unlock();
                return -10086;
            }
            return NativeRTCVideoFunctions.nativeSetVideoEffectTouchEvent(this.mNativeEngine, pointerId, x, y, force, majorRadius, type.ordinal(), pointerCount);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int getGestureRegistered(EffectTouchGesture gesture) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, getGestureRegistered failed.");
                this.mJniReadLock.unlock();
                return -10086;
            }
            return NativeRTCVideoFunctions.nativeGetGestureRegistered(this.mNativeEngine, gesture.getValue());
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int getSuspendGestureRecognizer(EffectTouchGesture gesture, boolean suspend) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "invalid, getSuspendGestureRecognizer failed.");
                this.mJniReadLock.unlock();
                return -10086;
            }
            return NativeRTCVideoFunctions.nativeGetSuspendGestureRecognizer(this.mNativeEngine, gesture.getValue(), suspend);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        LogUtil.m218i(TAG, "dispose rtc video effect");
        this.mJniWriteLock.lock();
        try {
            this.mNativeEngine = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
