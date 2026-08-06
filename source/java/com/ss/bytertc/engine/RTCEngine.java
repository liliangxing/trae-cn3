package com.ss.bytertc.engine;

import android.content.Intent;
import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.audio.IMediaPlayer;
import com.ss.bytertc.engine.audio.ISimilaritySingScoringManager;
import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.AlphaLayout;
import com.ss.bytertc.engine.data.AudioAlignmentMode;
import com.ss.bytertc.engine.data.AudioFormat;
import com.ss.bytertc.engine.data.AudioFrameCallbackMethod;
import com.ss.bytertc.engine.data.AudioProcessorMethod;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.AudioRecordingConfig;
import com.ss.bytertc.engine.data.AudioRenderType;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.CloudProxyInfo;
import com.ss.bytertc.engine.data.EarMonitorMode;
import com.ss.bytertc.engine.data.EchoTestConfig;
import com.ss.bytertc.engine.data.EffectBeautyMode;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.MirrorType;
import com.ss.bytertc.engine.data.RTCLogConfig;
import com.ss.bytertc.engine.data.RecordingConfig;
import com.ss.bytertc.engine.data.RemoteMirrorType;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.SEICountPerFrame;
import com.ss.bytertc.engine.data.ScreenMediaType;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoOrientation;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.data.VideoRotationMode;
import com.ss.bytertc.engine.data.VideoSimulcastMode;
import com.ss.bytertc.engine.data.VideoSourceType;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.ZoomConfigType;
import com.ss.bytertc.engine.data.ZoomDirectionType;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.handler.RTCEncryptHandler;
import com.ss.bytertc.engine.live.ChorusCacheSyncConfig;
import com.ss.bytertc.engine.live.ClientMixedStreamConfig;
import com.ss.bytertc.engine.live.IChorusCacheSyncObserver;
import com.ss.bytertc.engine.live.IClientMixedStreamObserver;
import com.ss.bytertc.engine.live.MixedStreamConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetType;
import com.ss.bytertc.engine.live.PushSingleStreamParam;
import com.ss.bytertc.engine.loader.RTCNativeLibraryLoader;
import com.ss.bytertc.engine.mediaio.ILocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.IRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.type.AnsMode;
import com.ss.bytertc.engine.type.AudioProfileType;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.LocalProxyConfiguration;
import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.ProblemFeedbackInfo;
import com.ss.bytertc.engine.type.ProblemFeedbackOption;
import com.ss.bytertc.engine.type.PublishFallbackOption;
import com.ss.bytertc.engine.type.RecordingType;
import com.ss.bytertc.engine.type.RemoteUserPriority;
import com.ss.bytertc.engine.type.SubscribeFallbackOptions;
import com.ss.bytertc.engine.type.TorchState;
import com.ss.bytertc.engine.type.VoiceChangerType;
import com.ss.bytertc.engine.type.VoiceEqualizationConfig;
import com.ss.bytertc.engine.type.VoiceReverbConfig;
import com.ss.bytertc.engine.type.VoiceReverbType;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import com.ss.bytertc.engine.utils.EngineConfigCheck;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.utils.RTCEglContextChecker;
import com.ss.bytertc.engine.video.ISnapshotResultCallback;
import com.ss.bytertc.engine.video.IVideoDeviceManager;
import com.ss.bytertc.engine.video.IVideoEffect;
import com.ss.bytertc.engine.video.IVideoProcessor;
import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.LocalVideoSinkConfig;
import com.ss.bytertc.engine.video.RTCWatermarkConfig;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;
import com.ss.bytertc.engine.video.VideoDecoderConfig;
import com.ss.bytertc.engine.video.VideoPreprocessorConfig;
import com.ss.bytertc.ktv.IKTVManager;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class RTCEngine {
    private static final String TAG = "RtcVideo";
    protected static RTCEngineImpl mInstance;
    protected static RTCEngineImpl mInstanceEx;
    protected static RTCEglContextChecker mRtcEglContextChecker;
    protected static RTCNativeLibraryLoader mRtcNativeLibraryLoader;

    public abstract int clearVideoWatermark(StreamIndex streamIndex);

    public abstract RTCRoom createRTCRoom(String roomId);

    public abstract RTSRoom createRTSRoom(String roomId);

    public abstract int disableAlphaChannelVideoEncode(StreamIndex streamIndex);

    public abstract int disableAudioFrameCallback(AudioFrameCallbackMethod method);

    public abstract int disableAudioProcessor(AudioProcessorMethod method);

    public abstract int enableAlphaChannelVideoEncode(StreamIndex streamIndex, AlphaLayout alphaLayout);

    public abstract int enableAudioAEDReport(int interval);

    public abstract void enableAudioDecoding(boolean enable);

    public abstract void enableAudioEncoding(boolean enable);

    public abstract int enableAudioFrameCallback(AudioFrameCallbackMethod method, AudioFormat format);

    public abstract int enableAudioProcessor(AudioProcessorMethod method, AudioFormat format);

    public abstract int enableAudioPropertiesReport(AudioPropertiesConfig config);

    public abstract int enableAudioVADReport(int interval);

    public abstract int enableCameraAutoExposureFaceMode(boolean enable);

    public abstract int enableEffectBeauty(boolean enable);

    public abstract int enableExternalSoundCard(boolean enable);

    public abstract int enableLocalVoiceReverb(boolean enable);

    public abstract int enableNtpTimestampInRtp(boolean enable);

    public abstract int enablePlaybackDucking(boolean enable);

    public abstract int enableVocalInstrumentBalance(boolean enable);

    public abstract int feedback(List<ProblemFeedbackOption> types, ProblemFeedbackInfo info);

    public abstract IRTCAudioDeviceManager getAudioDeviceManager();

    public abstract IAudioEffectPlayer getAudioEffectPlayer();

    public abstract AudioRoute getAudioRoute();

    public abstract float getCameraZoomMaxRatio();

    public abstract IKTVManager getKTVManager();

    public abstract IMediaPlayer getMediaPlayer(int playerId);

    public abstract long getNativeHandle();

    public abstract NetworkTimeInfo getNetworkTimeInfo();

    public abstract int getPeerOnlineStatus(String peerUserID);

    public abstract ISimilaritySingScoringManager getSimilaritySingScoringManager();

    public abstract ISingScoringManager getSingScoringManager();

    public abstract IVideoDeviceManager getVideoDeviceManager();

    public abstract IVideoEffect getVideoEffectInterface();

    public abstract IWTNStream getWTNStream();

    public abstract boolean isCameraExposurePositionSupported();

    public abstract boolean isCameraFocusPositionSupported();

    public abstract boolean isCameraTorchSupported();

    public abstract boolean isCameraZoomSupported();

    public abstract int login(String token, String uid);

    public abstract int logout();

    public abstract int muteAudioCapture(StreamIndex index, boolean mute);

    public abstract int pullExternalAudioFrame(AudioFrame audioFrame);

    public abstract int pushClientMixedStreamExternalVideoFrame(String uid, VideoFrameData frame);

    public abstract int pushExternalAudioFrame(AudioFrame audioFrame);

    public abstract int pushExternalEncodedAudioFrame(EncodedAudioFrameData audioFrame);

    public abstract int pushExternalEncodedVideoFrame(StreamIndex streamIndex, int videoIndex, RTCEncodedVideoFrame encodedVideoFrame);

    public abstract int pushExternalVideoFrame(VideoFrameData frame);

    public abstract int pushScreenAudioFrame(AudioFrame audioFrame);

    public abstract int pushScreenVideoFrame(VideoFrameData videoFrame);

    public abstract int registerAudioFrameObserver(IAudioFrameObserver observer);

    public abstract int registerAudioProcessor(IAudioFrameProcessor processor);

    public abstract int registerLocalEncodedVideoFrameObserver(ILocalEncodedVideoFrameObserver observer);

    public abstract int registerLocalVideoProcessor(IVideoProcessor processor, VideoPreprocessorConfig config);

    public abstract void registerRemoteEncodedAudioFrameObserver(IRemoteEncodedAudioFrameObserver observer);

    public abstract int registerRemoteEncodedVideoFrameObserver(IRemoteEncodedVideoFrameObserver observer);

    public abstract int requestRemoteVideoKeyFrame(RemoteStreamKey streamKey);

    public abstract int sendPublicStreamSEIMessage(StreamIndex streamIndex, int channelId, byte[] message, int repeatCount, SEICountPerFrame mode);

    public abstract int sendSEIMessage(StreamIndex streamIndex, byte[] message, int repeatCount);

    public abstract int sendSEIMessage(StreamIndex streamIndex, byte[] message, int repeatCount, SEICountPerFrame mode);

    public abstract long sendServerBinaryMessage(byte[] buffer);

    public abstract long sendServerMessage(String message);

    public abstract int sendStreamSyncInfo(byte[] data, StreamSycnInfoConfig config);

    public abstract long sendUserBinaryMessageOutsideRoom(String uid, byte[] buffer, MessageConfig config);

    public abstract long sendUserMessageOutsideRoom(String uid, String message, MessageConfig config);

    public abstract int setAnsMode(AnsMode ansMode);

    public abstract int setAudioAlignmentProperty(RemoteStreamKey streamKey, AudioAlignmentMode mode);

    public abstract int setAudioProfile(AudioProfileType audioProfile);

    public abstract int setAudioRenderType(AudioRenderType type);

    public abstract int setAudioRoute(AudioRoute audioRoute);

    public abstract int setAudioScenario(AudioScenarioType audioScenario);

    public abstract int setAudioSourceType(AudioSourceType type);

    public abstract int setBeautyIntensity(EffectBeautyMode beautyMode, float intensity);

    public abstract int setBusinessId(String businessId);

    public abstract int setCameraAdaptiveMinimumFrameRate(int framerate);

    public abstract int setCameraExposureCompensation(float val);

    public abstract int setCameraExposurePosition(float x, float y);

    public abstract int setCameraFocusPosition(float x, float y);

    public abstract int setCameraTorch(TorchState torchState);

    public abstract int setCameraZoomRatio(float zoom);

    public abstract int setCaptureVolume(StreamIndex index, int volume);

    public abstract int setCellularEnhancement(MediaTypeEnhancementConfig config);

    public abstract int setClientMixedStreamObserver(IClientMixedStreamObserver observer);

    public abstract int setCustomizeEncryptHandler(RTCEncryptHandler handler);

    public abstract int setDefaultAudioRoute(AudioRoute route);

    public abstract int setDummyCaptureImagePath(String filePath);

    public abstract int setEarMonitorMode(EarMonitorMode mode);

    public abstract int setEarMonitorMode(EarMonitorMode mode, int filter);

    public abstract int setEarMonitorVolume(int volume);

    public abstract int setEncryptInfo(int aesType, String key);

    public abstract int setExternalVideoEncoderEventHandler(IExternalVideoEncoderEventHandler handler);

    public abstract int setLocalProxy(List<LocalProxyConfiguration> configurations);

    public abstract int setLocalSimulcastMode(VideoSimulcastMode mode);

    public abstract int setLocalSimulcastMode(VideoSimulcastMode mode, VideoEncoderConfig[] streamConfig);

    public abstract int setLocalVideoCanvas(StreamIndex streamIndex, VideoCanvas videoCanvas);

    public abstract int setLocalVideoMirrorType(MirrorType mirrorType);

    @Deprecated
    public abstract int setLocalVideoSink(StreamIndex index, IVideoSink videoSink, int requiredFormat);

    public abstract int setLocalVideoSink(StreamIndex index, IVideoSink videoSink, LocalVideoSinkConfig config);

    public abstract int setLocalVoiceEqualization(VoiceEqualizationConfig voiceEqualizationConfig);

    public abstract int setLocalVoicePitch(int pitch);

    public abstract int setLocalVoiceReverbParam(VoiceReverbConfig config);

    public abstract int setPlaybackVolume(int volume);

    public abstract int setPublishFallbackOption(PublishFallbackOption option);

    public abstract int setRemoteAudioPlaybackVolume(RemoteStreamKey streamKey, int volume);

    public abstract int setRemoteUserPriority(String roomid, String uid, RemoteUserPriority priority);

    public abstract int setRemoteVideoCanvas(RemoteStreamKey streamKey, VideoCanvas videoCanvas);

    public abstract int setRemoteVideoMirrorType(RemoteStreamKey remoteStreamKey, RemoteMirrorType mirrorType);

    @Deprecated
    public abstract int setRemoteVideoSink(RemoteStreamKey streamKey, IVideoSink videoSink, int requiredFormat);

    public abstract int setRemoteVideoSink(RemoteStreamKey streamKey, IVideoSink videoSink, RemoteVideoSinkConfig config);

    public abstract int setRemoteVideoSuperResolution(RemoteStreamKey streamKey, VideoSuperResolutionMode mode);

    public abstract int setRtcVideoEventHandler(IRTCEngineEventHandler engineEventHandler);

    public abstract int setRuntimeParameters(JSONObject params);

    public abstract int setScreenAudioSourceType(AudioSourceType sourceType);

    public abstract int setScreenAudioStreamIndex(StreamIndex index);

    public abstract int setScreenVideoEncoderConfig(VideoEncoderConfig screenSolution);

    public abstract int setServerParams(String signature, String url);

    public abstract int setSubscribeFallbackOption(SubscribeFallbackOptions option);

    public abstract int setVideoCaptureConfig(com.ss.bytertc.engine.video.VideoCaptureConfig videoCaptureConfig);

    public abstract int setVideoCaptureRotation(VideoRotation rotation);

    public abstract int setVideoDecoderConfig(RemoteStreamKey key, VideoDecoderConfig config);

    public abstract int setVideoDenoiser(VideoDenoiseMode mode);

    public abstract int setVideoDigitalZoomConfig(ZoomConfigType type, float size);

    public abstract int setVideoDigitalZoomControl(ZoomDirectionType direction);

    public abstract int setVideoEncoderConfig(VideoEncoderConfig encoderConfig);

    public abstract int setVideoEncoderConfig(VideoEncoderConfig encoderConfig, JSONObject parameters);

    public abstract int setVideoOrientation(VideoOrientation orientation);

    public abstract int setVideoRotationMode(VideoRotationMode rotationMode);

    public abstract int setVideoSourceType(StreamIndex index, VideoSourceType type);

    public abstract int setVideoWatermark(StreamIndex streamIndex, String imagePath, RTCWatermarkConfig watermarkConfig);

    public abstract int setVoiceChangerType(VoiceChangerType voiceChanger);

    public abstract int setVoiceReverbType(VoiceReverbType voiceReverb);

    public abstract int startAudioCapture();

    public abstract int startAudioRecording(AudioRecordingConfig config);

    public abstract int startChorusCacheSync(ChorusCacheSyncConfig config, IChorusCacheSyncObserver observer);

    public abstract int startClientMixedStream(String taskId, MixedStreamConfig mixedConfig, ClientMixedStreamConfig extra_config);

    public abstract int startCloudProxy(List<CloudProxyInfo> cloudProxiesInfo);

    public abstract int startEchoTest(EchoTestConfig config, int delayTime);

    public abstract int startFileRecording(StreamIndex type, RecordingConfig config, RecordingType recordingType);

    public abstract int startHardwareEchoDetection(String testAudioFilePath);

    public abstract int startNetworkDetection(boolean isTestUplink, int expectedUplinkBitrate, boolean isTestDownlink, int expectedDownlinkBitrate);

    public abstract int startPushMixedStream(String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig mixedConfig);

    public abstract int startPushSingleStream(String taskId, PushSingleStreamParam param);

    public abstract int startScreenCapture(ScreenMediaType type, Intent mediaProjectionResultData);

    public abstract int startVideoCapture();

    public abstract int startVideoDigitalZoomControl(ZoomDirectionType direction);

    public abstract int stopAudioCapture();

    public abstract int stopAudioRecording();

    public abstract int stopChorusCacheSync();

    public abstract int stopClientMixedStream(String taskId);

    public abstract int stopCloudProxy();

    public abstract int stopEchoTest();

    public abstract int stopFileRecording(StreamIndex type);

    public abstract int stopHardwareEchoDetection();

    public abstract int stopNetworkDetection();

    public abstract int stopPushMixedStream(String taskId, MixedStreamPushTargetType targetType);

    public abstract int stopPushSingleStream(String taskId);

    public abstract int stopScreenCapture();

    public abstract int stopVideoCapture();

    public abstract int stopVideoDigitalZoomControl();

    public abstract int switchCamera(CameraId cameraId);

    public abstract long takeLocalSnapshot(StreamIndex streamIndex, ISnapshotResultCallback callback);

    public abstract long takeRemoteSnapshot(RemoteStreamKey streamKey, ISnapshotResultCallback callback);

    public abstract int updateClientMixedStream(String taskId, MixedStreamConfig mixedConfig, ClientMixedStreamConfig extra_config);

    public abstract int updateLocalVideoCanvas(StreamIndex streamIndex, int renderMode, int backgroundColor);

    public abstract int updateLoginToken(String token);

    public abstract int updatePushMixedStream(String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig mixedConfig);

    public abstract int updateRemoteStreamVideoCanvas(RemoteStreamKey streamKey, int renderMode, int backgroundColor);

    public abstract int updateRemoteStreamVideoCanvas(RemoteStreamKey streamKey, RemoteVideoRenderConfig remoteVideoRenderConfig);

    public abstract int updateScreenCapture(ScreenMediaType type);

    public static void setRtcNativeLibraryLoader(RTCNativeLibraryLoader rtcNativeLibraryLoader) {
        LogUtil.m218i(TAG, "set rtc native library loader" + rtcNativeLibraryLoader);
        mRtcNativeLibraryLoader = rtcNativeLibraryLoader;
    }

    public static synchronized RTCEngine createRTCEngine(EngineConfig config, IRTCEngineEventHandler handler) {
        synchronized (RTCEngine.class) {
            if (EngineConfigCheck.checkValid(config) != 0) {
                LogUtil.m216e(TAG, "createRTCEngine: engine config is invalid, error code is " + EngineConfigCheck.checkValid(config));
                return null;
            }
            if (RTCEngineImpl.initializeNativeLibs(config.nativeLoadPath)) {
                RTCEngineImpl rTCEngineImpl = mInstance;
                if (rTCEngineImpl != null) {
                    return rTCEngineImpl;
                }
                try {
                    RTCEngineImpl rTCEngineImpl2 = new RTCEngineImpl(config, handler, null, false, false);
                    mInstance = rTCEngineImpl2;
                    return rTCEngineImpl2;
                } catch (IllegalStateException e) {
                    LogUtil.m216e(TAG, "createRTCEngine: throw exception " + e.getMessage());
                    return null;
                }
            }
            LogUtil.m216e(TAG, "createRTCEngine: fail to load native library");
            return null;
        }
    }

    public static synchronized RTCEngine createRTCEngineMulti(EngineConfig config, IRTCEngineEventHandler handler) {
        synchronized (RTCEngine.class) {
            if (EngineConfigCheck.checkValid(config) != 0) {
                LogUtil.m216e(TAG, "createRTCEngine: engine config is invalid, error code is " + EngineConfigCheck.checkValid(config));
                return null;
            }
            if (RTCEngineImpl.initializeNativeLibs(config.nativeLoadPath)) {
                try {
                    return new RTCEngineImpl(config, handler, null, false, true);
                } catch (IllegalStateException unused) {
                    return null;
                }
            }
            LogUtil.m216e(TAG, "createRTCEngine: fail to load native library");
            return null;
        }
    }

    public static synchronized void destroyRTCEngine() {
        synchronized (RTCEngine.class) {
            RTCEngineImpl rTCEngineImpl = mInstance;
            if (rTCEngineImpl != null) {
                rTCEngineImpl.doDestroy(false);
                mInstance = null;
                mRtcNativeLibraryLoader = null;
                mRtcEglContextChecker = null;
                System.gc();
            }
        }
    }

    public static synchronized void destroyRTCEngineMulti(RTCEngine engine) {
        synchronized (RTCEngine.class) {
            if (engine != null) {
                if (engine == mInstance) {
                    destroyRTCEngine();
                } else {
                    ((RTCEngineImpl) engine).doDestroy(true);
                    System.gc();
                }
            }
        }
    }

    public static String getSDKVersion() {
        return !RTCEngineImpl.initializeNativeLibs() ? "" : RTCEngineImpl.getSdkVersion();
    }

    public static int setLogConfig(RTCLogConfig logConfig) {
        if (RTCEngineImpl.initializeNativeLibs()) {
            return RTCEngineImpl.setLogConfig(logConfig);
        }
        return -1;
    }
}
