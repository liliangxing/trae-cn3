package com.ss.bytertc.engine;

import android.content.Context;
import android.content.Intent;
import android.view.Surface;
import android.view.View;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.engine.data.EchoTestConfig;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.handler.RTCEncryptHandler;
import com.ss.bytertc.engine.handler.RTCExternalVideoEncoderEventHandler;
import com.ss.bytertc.engine.handler.RTCFaceDetectionObserver;
import com.ss.bytertc.engine.handler.RTCLocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.handler.RTCRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.handler.RTCVideoEventHandler;
import com.ss.bytertc.engine.handler.RTCVideoProcessor;
import com.ss.bytertc.engine.live.ChorusCacheSyncConfig;
import com.ss.bytertc.engine.live.ChorusCacheSyncObserver;
import com.ss.bytertc.engine.live.ClientMixedStreamConfig;
import com.ss.bytertc.engine.live.MixedStreamConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetConfig;
import com.ss.bytertc.engine.live.PushMixedStreamToCDNObserver;
import com.ss.bytertc.engine.type.ProblemFeedbackInfo;
import com.ss.bytertc.engine.video.ISnapshotResultCallback;
import com.ss.bytertc.engine.video.IVideoSink;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeRTCVideoFunctions {
    public static native int nativeAppendVideoEffectNodes(long enginePtr, String[] effectNodes);

    public static native int nativeApplyStickerEffect(long mNativeEngine, String tickerPath);

    public static native int nativeClearVideoWatermark(long enginePtr, int streamIndex);

    public static native long nativeCreateRTCVideo(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath);

    public static native long nativeCreateRTCVideoMulti(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath);

    public static native long nativeCreateRoom(long enginePtr, String roomId);

    public static native long nativeCreateRoomEx(long enginePtr, String roomId);

    public static native long nativeCreateRtsRoom(long enginePtr, String roomId);

    public static native void nativeDestroyRTCVideo(long enginePtr);

    public static native void nativeDestroyRTCVideoMulti(long enginePtr);

    public static native int nativeDisableAlphaChannelVideoEncode(long enginePtr, int index);

    public static native int nativeDisableAudioFrameCallback(long enginePtr, int method);

    public static native int nativeDisableAudioProcessor(long enginePtr, int audio_frame_method);

    public static native int nativeDisableFaceDetection(long enginePtr);

    public static native int nativeDisableVideoEffect(long enginePtr);

    public static native int nativeDisableVirtualBackground(long enginePtr);

    public static native int nativeEenableRescaleAudioVolume(long roomptr, boolean enable);

    public static native int nativeEnableAlphaChannelVideoEncode(long enginePtr, int index, int layout);

    public static native int nativeEnableAudioAEDReport(long enginePtr, int interval);

    public static native int nativeEnableAudioDecoding(long enginePtr, boolean enable);

    public static native int nativeEnableAudioEncoding(long enginePtr, boolean enable);

    public static native int nativeEnableAudioFrameCallback(long enginePtr, int method, int sample_rate, int channel);

    public static native int nativeEnableAudioProcessor(long enginePtr, int audio_frame_method, int samplerate, int channel, int samplesPerCall);

    public static native int nativeEnableAudioPropertiesReport(long enginePtr, int interval, boolean enableSpectrum, boolean enableVad, int localMainReportMode, float smooth, int audioReportMode, boolean enableVoicePitch);

    public static native int nativeEnableAudioVADReport(long enginePtr, int interval);

    public static native int nativeEnableAutoSubscribe(long roomptr, int subModeAudio, int subModeVideo);

    public static native int nativeEnableCameraAutoExposureFaceMode(long enginePtr, boolean enable);

    public static native int nativeEnableCameraTorch(long enginePtr, boolean enable);

    public static native int nativeEnableEffectBeauty(long enginePtr, boolean enable);

    public static native int nativeEnableExternalSoundCard(long enginePtr, boolean enable);

    public static native int nativeEnableFaceDetection(long enginePtr, RTCFaceDetectionObserver observer, int interval, String face_model_path);

    public static native int nativeEnableLocalVoiceReverb(long enginePtr, boolean enable);

    public static native int nativeEnableNtpTimestampInRtp(long enginePtr, boolean enable);

    public static native int nativeEnablePlaybackDucking(long enginePtr, boolean enable);

    public static native int nativeEnableSimulcastMode(long enginePtr, boolean enabled);

    public static native int nativeEnableVideoEffect(long enginePtr, boolean enable);

    public static native int nativeEnableVideoEffect2(long enginePtr);

    public static native int nativeEnableVirtualBackground(long enginePtr, String bgStickerPath, int sourceType, int sourceColor, String sourcePath);

    public static native int nativeEnableVocalInstrumentBalance(long enginePtr, boolean enable);

    public static native long nativeGetAmazingEffectInterface(long enginePtr);

    public static native long nativeGetAudioDeviceManager(long enginePtr);

    public static native long nativeGetAudioEffectPlayer(long enginePtr);

    public static native int nativeGetAudioRoute(long enginePtr);

    public static native float nativeGetCameraZoomMaxRatio(long enginePtr);

    public static native int nativeGetDownlinkNetworkBandwidthEstimationStatus(long roomptr);

    public static native int nativeGetGestureRegistered(long mNativeEngine, int gesture);

    public static native long nativeGetKTVManager(long enginePtr);

    public static native long nativeGetMediaPlayer(long enginePtr, int playerId);

    public static native NetworkTimeInfo nativeGetNetworkTimeInfo(long enginePtr);

    public static native int nativeGetPeerOnlineStatus(long enginePtr, String peer_user_id);

    public static native String nativeGetSDKVersion();

    public static native long nativeGetSimilaritySingScoringManager(long enginePtr);

    public static native long nativeGetSingScoringManager(long enginePtr);

    public static native int nativeGetSuspendGestureRecognizer(long mNativeEngine, int gesture, boolean suspend);

    public static native int nativeGetUplinkNetworkBandwidthEstimationStatus(long roomptr);

    public static native long nativeGetVideoDeviceManager(long enginePtr);

    public static native long nativeGetVideoEffectHandle(long enginePtr);

    public static native long nativeGetWTNStream(long enginePtr);

    public static native int nativeInitCVResource(long enginePtr, String license_file, String algo_model_dir);

    public static native boolean nativeIsCameraExposurePositionSupported(long enginePtr);

    public static native boolean nativeIsCameraFocusPositionSupported(long enginePtr);

    public static native boolean nativeIsCameraZoomSupported(long enginePtr);

    public static native boolean nativeIsStreamUnpublished(long roomptr, int mediaStreamType);

    public static native boolean nativeIsSupportFlashLight(long enginePtr);

    public static native int nativeLogin(long enginePtr, String token, String uid);

    public static native int nativeLogout(long enginePtr);

    public static native int nativeMuteAudioCapture(long enginePtr, int index, boolean mute);

    public static native int nativePullExternalAudioFrame(long enginePtr, byte[] audioFrame, int samples, int sampleRate, int channel);

    public static native int nativePushClientMixedStreamExternalVideoFrame(long enginePtr, String uid, VideoFrameData videoFrame);

    public static native int nativePushExternalAudioFrame(long enginePtr, byte[] audioFrame, int samples, int sampleRate, int channel, byte[] extraInfo);

    public static native int nativePushExternalEncodedAudioFrame(long enginePtr, int codecType, ByteBuffer data, int size, long timestampUs, int sampleRate, int channelNum, int frameSizeMs, ByteBuffer extraInfo, int extraInfoSize);

    public static native int nativePushExternalEncodedVideoFrame(long enginePtr, int streamIndex, int videoIndex, ByteBuffer buffer, long timestampUs, long timestampDtsUs, int width, int height, int videoCodecType, int videoPictureType, int videoRotation, ByteBuffer seiData);

    public static native int nativePushExternalVideoFrame(long enginePtr, VideoFrameData vfd);

    public static native int nativePushScreenAudioFrame(long enginePtr, byte[] audioFrame, int samples, int sampleRate, int channel);

    public static native int nativePushScreenFrame(long enginePtr, VideoFrameData vfd);

    public static native int nativeRegisterLocalEncodedVideoFrameObserver(long enginePtr, RTCLocalEncodedVideoFrameObserver mRtcLocalEncodedVideoFrameObserver);

    public static native int nativeRegisterLocalVideoProcessor(long enginePtr, RTCVideoProcessor mRtcVideoProcessor, int requiredPixelFormat, int streamIndex);

    public static native int nativeRegisterRemoteEncodedVideoFrameObserver(long enginePtr, RTCRemoteEncodedVideoFrameObserver mRtcRemoteEncodedVideoFrameObserver);

    public static native int nativeRemoveVideoEffectNodes(long enginePtr, String[] effectNodes);

    public static native int nativeReportFeedback(long enginePtr, long types, ProblemFeedbackInfo info);

    public static native int nativeRequestRemoteVideoKeyFrame(long enginePtr, String roomId, String UserId, int streamIndex);

    public static native void nativeResetScreenVideoConfigs(long enginePtr);

    public static native int nativeSendMultiSEIMessagePerVideoFrame(long enginePtr, int streamIndex, byte[] seiData, int repeatCount, int mode);

    public static native int nativeSendPublicStreamSEIMessage(long enginePtr, int streamIndex, int channelId, byte[] message, int repeatCount, int mode);

    public static native int nativeSendSEIMessage(long enginePtr, int streamIndex, byte[] seiData, int repeatCount);

    public static native long nativeSendServerBinaryMessage(long enginePtr, byte[] buffer);

    public static native long nativeSendServerMessage(long enginePtr, String message);

    public static native int nativeSendStreamSyncInfo(long enginePtr, byte[] data, int streamIndex, int repeatCount, int streamType);

    public static native long nativeSendUserBinaryMessageOutsideRoom(long enginePtr, String uid, byte[] buffer, int config);

    public static native long nativeSendUserMessageOutsideRoom(long enginePtr, String uid, String message, int config);

    public static native int nativeSetAnsMode(long enginePtr, int ans_mode);

    public static native void nativeSetAppState(long enginePtr, String state);

    public static native int nativeSetAudioAlignmentProperty(long enginePtr, String roomId, String uid, int stream_index, int mode);

    public static native int nativeSetAudioFrameObserver(long enginePtr, IAudioFrameObserver audioFrameObserver);

    public static native int nativeSetAudioFrameProcessor(long enginePtr, IAudioFrameProcessor audioProcesser);

    public static native int nativeSetAudioProfile(long enginePtr, int audio_profile);

    public static native int nativeSetAudioRenderType(long enginePtr, int renderType);

    public static native int nativeSetAudioRoute(long enginePtr, int device);

    public static native int nativeSetAudioScenario(long enginePtr, int audioScenario);

    public static native int nativeSetAudioSourceType(long enginePtr, int sourceType);

    public static native int nativeSetBeautyIntensity(long enginePtr, int beautyMode, float intensity);

    public static native int nativeSetBusinessId(long enginePtr, String businessId);

    public static native int nativeSetCameraAdaptiveMinimumFrameRate(long enginePtr, int framerate);

    public static native int nativeSetCameraExposureCompensation(long enginePtr, float val);

    public static native int nativeSetCameraExposurePosition(long enginePtr, float x, float y);

    public static native int nativeSetCameraFocusPosition(long enginePtr, float x, float y);

    public static native int nativeSetCameraZoomRatio(long enginePtr, float zoom);

    public static native int nativeSetCaptureVolume(long enginePtr, int volume, int index);

    public static native int nativeSetCellularEnhancement(long enginePtr, InternalMediaTypeEnhancementConfig config);

    public static native int nativeSetClientMixedStreamObserver(long enginePtr, PushMixedStreamToCDNObserver observer);

    public static native int nativeSetCustomizeEncryptHandler(long enginePtr, RTCEncryptHandler handler);

    public static native int nativeSetDefaultAudioRoute(long enginePtr, int device);

    public static native int nativeSetDummyCaptureImagePath(long enginePtr, String filePath);

    public static native int nativeSetEarMonitorMode(long enginePtr, int earMonitorMode);

    public static native int nativeSetEarMonitorMode2(long enginePtr, int earMonitorMode, int earMonitorAudioFilter);

    public static native int nativeSetEarMonitorVolume(long enginePtr, int earMonitorVolume);

    public static native int nativeSetEncryptInfo(long enginePtr, int aesType, String key);

    public static native void nativeSetExternalSurface(long enginePtr, String roomId, String userID, int index, Surface externalSurface);

    public static native int nativeSetExternalVideoEncoderEventHandler(long enginePtr, RTCExternalVideoEncoderEventHandler eventHandler);

    public static native int nativeSetLocalProxy(long enginePtr, List<InternalLocalProxyConfiguration> localProxyConfigurations);

    public static native int nativeSetLocalSimulcastMode(long enginePtr, int mode);

    public static native int nativeSetLocalSimulcastModeV1(long enginePtr, int mode, List<InternalVideoEncoderConfig> internalVideoStreamDescriptionList);

    public static native int nativeSetLocalVideoCanvas(long enginePtr, int streamIndex, View renderView, Surface renderSurface, int renderMode, int background_color);

    public static native int nativeSetLocalVideoMirrorType(long enginePtr, int mirrorType);

    public static native int nativeSetLocalVideoSink(long enginePtr, int streamIndex, IVideoSink videoSink, int requiredPixelFormat);

    public static native int nativeSetLocalVoiceEqualization(long enginePtr, int frequency, int gain);

    public static native int nativeSetLocalVoicePitch(long enginePtr, int pitch);

    public static native int nativeSetLocalVoiceReverbParam(long enginePtr, float roomSize, float decayTime, float damping, float wetGain, float dryGain, float preDelay);

    public static native int nativeSetLogConfig(int logLevel, String logPath, int logFileSize, String logFilenamePrefix);

    public static native void nativeSetNetworkRequestIntercept(int type);

    public static native int nativeSetPlaybackVolume(long enginePtr, int volume);

    public static native int nativeSetPublishChannel(long roomptr, String channelName);

    public static native int nativeSetPublishFallbackOption(long enginePtr, int option);

    public static native int nativeSetPublishSpecialStream(long roomptr, int type);

    public static native int nativeSetPublishSpecialStreamWithStreamIndex(long roomptr, int streamIndex, int type);

    public static native int nativeSetRemoteAudioPlaybackVolume(long enginePtr, String roomId, String userId, int streamIndex, int volume);

    public static native int nativeSetRemoteEncodedAudioFrameObserver(long enginePtr, IRemoteEncodedAudioFrameObserver audioFrameObserver);

    public static native int nativeSetRemoteSubscribeFallbackOption(long enginePtr, int option);

    public static native int nativeSetRemoteUserPriority(long enginePtr, String roomid, String uid, int priority);

    public static native int nativeSetRemoteVideoCanvas(long enginePtr, String roomId, String uid, int streamIndex, View renderView, Surface surface, int renderMode, int background_color, int render_rotation);

    public static native int nativeSetRemoteVideoMirrorType(long enginePtr, String roomId, String userId, int streamIndex, int mirrorType);

    public static native int nativeSetRemoteVideoSink(long enginePtr, String roomId, String userId, int streamIndex, IVideoSink videoSink, int requiredPixelFormat);

    public static native int nativeSetRemoteVideoSuperResolution(long enginePtr, String roomId, String uid, int streamIndex, int superResolutionMode);

    public static native int nativeSetRuntimeParameters(long enginePtr, String json_string);

    public static native int nativeSetScreenAudioSourceType(long enginePtr, int sourceType);

    public static native int nativeSetScreenAudioStreamIndex(long enginePtr, int index);

    public static native void nativeSetScreenVideoConfigs(long enginePtr);

    public static native int nativeSetScreenVideoEncoderConfig(long enginePtr, InternalVideoEncoderConfig internalScreenVideoEncoderConfig);

    public static native int nativeSetServerParams(long enginePtr, String signature, String url);

    public static native void nativeSetSubscribeBaselineData(long roomptr, String userID, boolean isScreen, SubscribeVideoBaseline videoBaseline);

    public static native int nativeSetSubscribeChannels(long roomptr, String[] channelsInfo, boolean enable_rescale);

    public static native int nativeSetSubscribeSpecialStream(long roomptr, int[] types);

    public static native int nativeSetVideoCaptureConfig(long enginePtr, InternalVideoCaptureConfig captureConfig);

    public static native int nativeSetVideoCaptureRotation(long enginePtr, int rotation);

    public static native int nativeSetVideoDecoderConfig(long enginePtr, String roomId, String UserId, int streamIndex, int videoDecoderConfig);

    public static native int nativeSetVideoDenoiser(long enginePtr, int videoDenoiseMode);

    public static native int nativeSetVideoDigitalZoomConfig(long enginePtr, int type, float size);

    public static native int nativeSetVideoDigitalZoomControl(long enginePtr, int direction);

    public static native int nativeSetVideoEffectAlgoModelResourceFinder(long enginePtr, long finder, long releaser);

    public static native int nativeSetVideoEffectColorFilter(long enginePtr, String resFile);

    public static native int nativeSetVideoEffectColorFilterIntensity(long enginePtr, float intensity);

    public static native int nativeSetVideoEffectExpressionDetect(long enginePtr, InternalExpressDetectConfig config);

    public static native int nativeSetVideoEffectNodes(long enginePtr, String[] effectNodes);

    public static native int nativeSetVideoEffectTouchEvent(long mNativeEngine, int pointerId, float x, float y, float force, float majorRadius, int type, int pointerCount);

    public static native int nativeSetVideoEncoderConfigV1(long enginePtr, InternalVideoEncoderConfig internalVideoEncoderConfig, String parameters);

    public static native int nativeSetVideoEncoderConfigWithMain(long enginePtr, List<InternalVideoEncoderConfig> internalVideoEncoderConfigList, List<InternalVideoEncoderConfig> internalVideoEncoderConfigMainList);

    public static native int nativeSetVideoOrientation(long videoPtr, int orientation);

    public static native int nativeSetVideoRotationMode(long enginePtr, int rotationMode);

    public static native int nativeSetVideoSourceTypeWithStreamId(long enginePtr, int streamIndex, int videoSourceType);

    public static native int nativeSetVideoWatermark(long enginePtr, int streamIndex, String imagePath, boolean visibleInPreview, float lx, float ly, float lw, float lh, float px, float py, float pw, float ph);

    public static native int nativeSetVoiceChangerType(long enginePtr, int voiceChanger);

    public static native int nativeSetVoiceReverbType(long enginePtr, int voiceReverb);

    public static native int nativeSetupLocalScreenSink(long enginePtr, IVideoSink videoSink, String uid);

    public static native int nativeSetupLocalVideoSink(long enginePtr, IVideoSink videoSink, String uid);

    public static native int nativeStartAudioCapture(long enginePtr);

    public static native int nativeStartAudioRecording(long enginePtr, String filePath, int sampleRate, int channel, int frameSource, int quality);

    public static native int nativeStartChorusCacheSync(long enginePtr, ChorusCacheSyncConfig chorusConfig, ChorusCacheSyncObserver observer);

    public static native int nativeStartClientMixedStream(long enginePtr, String taskId, MixedStreamConfig transcoding, ClientMixedStreamConfig clientConfig);

    public static native int nativeStartCloudProxy(long enginePtr, List<InternalCloudProxyInfo> cloudProxiesInfo);

    public static native int nativeStartEchoTest(long enginePtr, EchoTestConfig config, int delayTime);

    public static native int nativeStartFileRecording(long enginePtr, int streamIndex, String dirPath, int fileType, int recordType);

    public static native int nativeStartHardwareEchoDetection(long enginePtr, String filePath);

    public static native int nativeStartNetworkProbe(long enginePtr, boolean uplink, int uplinkBandwidth, boolean downlink, int downlinkBandwidth);

    public static native int nativeStartPushMixedStream(long enginePtr, String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig transcoding);

    public static native int nativeStartPushSingleStream(long enginePtr, String taskId, String rid, String uid, String url, boolean isScreen);

    public static native int nativeStartScreenAudioCapture(long enginePtr);

    public static native int nativeStartScreenCapture(long enginePtr, int type, Intent mediaProjectionResultData);

    public static native int nativeStartVideoCapture(long enginePtr);

    public static native int nativeStartVideoDigitalZoomControl(long enginePtr, int direction);

    public static native int nativeStopAudioCapture(long enginePtr);

    public static native int nativeStopAudioRecording(long enginePtr);

    public static native int nativeStopChorusCacheSync(long enginePtr);

    public static native int nativeStopClientMixedStream(long enginePtr, String taskId);

    public static native int nativeStopCloudProxy(long enginePtr);

    public static native int nativeStopEchoTest(long engienPtr);

    public static native int nativeStopFileRecording(long enginePtr, int streamIndex);

    public static native int nativeStopHardwareEchoDetection(long enginePtr);

    public static native int nativeStopNetworkProbe(long enginePtr);

    public static native int nativeStopPushMixedStream(long enginePtr, String taskId, int targetType);

    public static native int nativeStopPushSingleStream(long enginePtr, String taskId);

    public static native int nativeStopScreenAudioCapture(long enginePtr);

    public static native int nativeStopScreenCapture(long enginePtr);

    public static native int nativeStopScreenVideoCapture(long enginePtr);

    public static native int nativeStopVideoCapture(long enginePtr);

    public static native int nativeStopVideoDigitalZoomControl(long enginePtr);

    public static native int nativeSwitchCamera(long enginePtr, int cameraId);

    public static native long nativeTakeLocalSnapshot(long enginePtr, int streamIndex, ISnapshotResultCallback callback);

    public static native long nativeTakeRemoteSnapshot(long enginePtr, String roomId, String userId, int streamIndex, ISnapshotResultCallback callback);

    public static native int nativeUpdateClientMixedStream(long enginePtr, String taskId, MixedStreamConfig transcoding, ClientMixedStreamConfig clientConfig);

    public static native int nativeUpdateLocalVideoCanvas(long enginePtr, int streamIndex, int renderMode, int background_color);

    public static native int nativeUpdateLoginToken(long enginePtr, String token);

    public static native int nativeUpdatePushMixedStream(long enginePtr, String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig transcoding);

    public static native int nativeUpdateRemoteVideoCanvas(long enginePtr, String roomId, String userId, int streamIndex, int renderMode, int background_color, int render_rotation);

    public static native int nativeUpdateScreenCapture(long enginePtr, int type);

    public static native int nativeUpdateVideoEffectNode(long enginePtr, String effectNode, String key, float value);

    public static native void nativeWriteLog(String fileName, int lineNum, String apiName, String level, String format);

    public static native int nativesetLocalVideoSink(long enginePtr, int streamIndex, IVideoSink videoSink, int requiredPixelFormat, int position);

    public static native int nativesetRemoteVideoSink(long enginePtr, String roomId, String userId, int streamIndex, IVideoSink videoSink, int requiredPixelFormat, int position, int apply_rotation, int mirror_type);
}
