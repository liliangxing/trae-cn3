package com.ss.bytertc.engine.live;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.ttm.player.MediaFormat;
import com.ss.ttm.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MixedStreamConfig {
    private static final String TAG = "MixedStreamConfig";
    public MixedStreamAudioConfig audioConfig;
    public MixedStreamAudioEffectConfig audioEffectConfig;
    public MixedStreamControlConfig controlConfig;
    public MixedStreamSpatialAudioConfig spatialAudioConfig;
    public MixedStreamSyncControlConfig syncControlConfig;
    public MixedStreamVideoConfig videoConfig;
    public MixedStreamLayoutRegionConfig[] regions = null;
    public String userConfigExtraInfo = "";
    public String backgroundColor = "#000000";
    public String backgroundImageURL = "";
    public JSONObject advancedConfig = null;
    public String roomID = "";
    public String userID = "";
    public JSONObject authInfo = null;
    public InterpolationMode interpolationMode = InterpolationMode.LAST_FRAME_FILL;
    public StreamLayoutMode layoutMode = StreamLayoutMode.AUTO;

    public int getMixedStreamLayoutmode() {
        return this.layoutMode.value();
    }

    public String getMixedStreamRoomID() {
        String str = this.roomID;
        return str == null ? "" : str;
    }

    public String getMixedStreamUserID() {
        String str = this.userID;
        return str == null ? "" : str;
    }

    public String getMixedStreamAdvancedConfig() {
        JSONObject jSONObject = this.advancedConfig;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String getMixedStreamAuthInfo() {
        JSONObject jSONObject = this.authInfo;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String getMixedStreamVideoConfigCodec() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        return (mixedStreamVideoConfig == null || mixedStreamVideoConfig.videoCodec == null) ? "" : this.videoConfig.videoCodec.getValue();
    }

    public int getMixedStreamVideoConfigBitrate() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return 0;
        }
        return mixedStreamVideoConfig.bitrate;
    }

    public int getMixedStreamVideoConfigFps() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return 0;
        }
        return mixedStreamVideoConfig.fps;
    }

    public int getMixedStreamVideoConfigGop() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return 0;
        }
        return mixedStreamVideoConfig.gop;
    }

    public int getMixedStreamVideoConfigHeight() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return 0;
        }
        return mixedStreamVideoConfig.height;
    }

    public int getMixedStreamVideoConfigWidth() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return 0;
        }
        return mixedStreamVideoConfig.width;
    }

    public boolean getMixedStreamVideoConfigBFrame() {
        MixedStreamVideoConfig mixedStreamVideoConfig = this.videoConfig;
        if (mixedStreamVideoConfig == null) {
            return false;
        }
        return mixedStreamVideoConfig.enableBframe;
    }

    public String getMixedStreamAudioConfigAudioProfile() {
        MixedStreamAudioConfig mixedStreamAudioConfig = this.audioConfig;
        return (mixedStreamAudioConfig == null || mixedStreamAudioConfig.audioProfile == null) ? "" : this.audioConfig.audioProfile.getValue();
    }

    public String getMixedStreamAudioConfigCodec() {
        MixedStreamAudioConfig mixedStreamAudioConfig = this.audioConfig;
        return (mixedStreamAudioConfig == null || mixedStreamAudioConfig.audioCodec == null) ? "" : this.audioConfig.audioCodec.getValue();
    }

    public int getMixedStreamaudioConfigBitrate() {
        MixedStreamAudioConfig mixedStreamAudioConfig = this.audioConfig;
        if (mixedStreamAudioConfig == null) {
            return 0;
        }
        return mixedStreamAudioConfig.bitrate;
    }

    public int getMixedStreamAudioConfigSampleRate() {
        MixedStreamAudioConfig mixedStreamAudioConfig = this.audioConfig;
        if (mixedStreamAudioConfig == null) {
            return 0;
        }
        return mixedStreamAudioConfig.sampleRate;
    }

    public int getMixedStreamAudioConfigChannels() {
        MixedStreamAudioConfig mixedStreamAudioConfig = this.audioConfig;
        if (mixedStreamAudioConfig == null) {
            return 0;
        }
        return mixedStreamAudioConfig.channels;
    }

    public boolean getMixedStreamServerControlConfigEnableVolumeIndication() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        if (mixedStreamControlConfig == null) {
            return false;
        }
        return mixedStreamControlConfig.enableVolumeIndication;
    }

    public float getMixedStreamServerControlConfigVolumeIndicationInterval() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        if (mixedStreamControlConfig == null) {
            return 2.0f;
        }
        return mixedStreamControlConfig.volumeIndicationInterval;
    }

    public int getMixedStreamServerControlConfigTalkVolume() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        if (mixedStreamControlConfig == null) {
            return 0;
        }
        return mixedStreamControlConfig.talkVolume;
    }

    public boolean getMixedStreamServerControlConfigIsAddVolumeValue() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        if (mixedStreamControlConfig == null) {
            return false;
        }
        return mixedStreamControlConfig.isAddVolumeValue;
    }

    public int getMixedStreamServerControlConfigSeiContentMode() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        return (mixedStreamControlConfig == null ? MixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT : mixedStreamControlConfig.seiContentMode).getValue();
    }

    public int getMixedStreamServerControlConfigSeiPayloadType() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        if (mixedStreamControlConfig == null) {
            return 0;
        }
        return mixedStreamControlConfig.seiPayloadType;
    }

    public String getMixedStreamServerControlConfigSeiPayloadUuid() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        return mixedStreamControlConfig == null ? "" : mixedStreamControlConfig.seiPayloadUuid;
    }

    public int getMixedStreamServerControlConfigMediaType() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        return (mixedStreamControlConfig == null ? MixedStreamMediaType.MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO : mixedStreamControlConfig.mediaType).getValue();
    }

    public int getMixedStreamServerControlConfigPushStreamMode() {
        MixedStreamControlConfig mixedStreamControlConfig = this.controlConfig;
        return (mixedStreamControlConfig == null ? MixedStreamPushMode.ON_STREAM : mixedStreamControlConfig.pushStreamMode).getValue();
    }

    public int getMixedStreamSyncControlConfigSyncStrategy() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        return (mixedStreamSyncControlConfig == null ? MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC : mixedStreamSyncControlConfig.syncStrategy).getValue();
    }

    public int getMixedStreamSyncControlConfigQueueLength() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        if (mixedStreamSyncControlConfig == null) {
            return 0;
        }
        return mixedStreamSyncControlConfig.maxCacheTimeMs;
    }

    public int getMixedStreamSyncControlConfigBaseStreamStartDelayMs() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        if (mixedStreamSyncControlConfig == null) {
            return 0;
        }
        return mixedStreamSyncControlConfig.baseStreamStartDelayMs;
    }

    public boolean getMixedStreamSyncControlConfigVideoNeedMix() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        if (mixedStreamSyncControlConfig == null) {
            return false;
        }
        return mixedStreamSyncControlConfig.videoNeedSdkMix;
    }

    public String getMixedStreamSyncControlConfigBaseUser() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        return mixedStreamSyncControlConfig == null ? "" : mixedStreamSyncControlConfig.baseUserID;
    }

    public String getMixedStreamSyncControlConfigBaseRoom() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        return mixedStreamSyncControlConfig == null ? "" : mixedStreamSyncControlConfig.baseRoomID;
    }

    public int getMixedStreamSyncControlConfigBaseStreamType() {
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = this.syncControlConfig;
        if (mixedStreamSyncControlConfig == null) {
            return 0;
        }
        return mixedStreamSyncControlConfig.baseStreamType.getValue();
    }

    public int getMixedStreamAudioEffectType() {
        MixedStreamAudioEffectConfig mixedStreamAudioEffectConfig = this.audioEffectConfig;
        if (mixedStreamAudioEffectConfig == null) {
            return 0;
        }
        return mixedStreamAudioEffectConfig.mAudioEffectType.value();
    }

    public boolean getMixedStreamSpatialConfigEnableSpatialRender() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return false;
        }
        return mixedStreamSpatialAudioConfig.enableSpatialRender;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionX() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialPosition.f113x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionY() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialPosition.f114y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialPositionZ() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialPosition.f115z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardX() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.forward.f109x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardY() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.forward.f110y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationForwardZ() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.forward.f111z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightX() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.right.f109x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightY() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.right.f110y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationRightZ() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.right.f111z;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpX() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.f105up.f109x;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpY() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.f105up.f110y;
    }

    public float getMixedStreamSpatialConfigAudienceSpatialOrientationUpZ() {
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = this.spatialAudioConfig;
        if (mixedStreamSpatialAudioConfig == null) {
            return 0.0f;
        }
        return mixedStreamSpatialAudioConfig.audienceSpatialOrientation.f105up.f111z;
    }

    public MixedStreamLayoutRegionConfig[] getMixedStreamLayoutRegionConfigs() {
        return this.regions;
    }

    public String getMixedStreamUserConfigExtraInfo() {
        String str = this.userConfigExtraInfo;
        return str == null ? "" : str;
    }

    public String getMixedStreamBackgroundColor() {
        String str = this.backgroundColor;
        return str == null ? "" : str;
    }

    public String getMixedStreamBackgroundImageURL() {
        String str = this.backgroundImageURL;
        return str == null ? "" : str;
    }

    public double getMixedStreamLayoutSourceCropX(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.sourceCrop.locationX;
    }

    public double getMixedStreamLayoutSourceCropY(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.sourceCrop.locationY;
    }

    public double getMixedStreamLayoutSourceCropW(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.sourceCrop.widthProportion;
    }

    public double getMixedStreamLayoutSourceCropH(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.sourceCrop.heightProportion;
    }

    public String getMixedStreamLayoutRegionUserID(MixedStreamLayoutRegionConfig region) {
        return (region == null || region.userID == null) ? "" : region.userID;
    }

    public String getMixedStreamLayoutRegionRoomID(MixedStreamLayoutRegionConfig region) {
        return (region == null || region.roomID == null) ? "" : region.roomID;
    }

    public String getMixedStreamLayoutRegionWtnStreamID(MixedStreamLayoutRegionConfig region) {
        return (region == null || region.wtnStreamID == null) ? "" : region.wtnStreamID;
    }

    public int getMixedStreamLayoutRegionX(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.locationX;
    }

    public int getMixedStreamLayoutRegionY(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.locationY;
    }

    public int getMixedStreamLayoutRegionW(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.width;
    }

    public int getMixedStreamLayoutRegionH(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.height;
    }

    public int getMixedStreamLayoutRegionZOrder(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.zOrder;
    }

    public double getMixedStreamLayoutRegionAlpha(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.alpha;
    }

    public double getMixedStreamLayoutRegionCornerRadius(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0d;
        }
        return region.cornerRadius;
    }

    public int getMixedStreamLayoutRegionMediaType(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.mediaType.getValue();
    }

    public int getMixedStreamLayoutRegionRenderMode(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.renderMode.getValue();
    }

    public boolean getMixedStreamLayoutRegionLocalUser(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return false;
        }
        return region.isLocalUser;
    }

    public int getMixedStreamLayoutRegionScreenStream(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.streamType.getValue();
    }

    public int getMixedStreamLayoutRegionContentType(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.regionContentType.getValue();
    }

    public byte[] getMixedStreamLayoutRegionData(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return null;
        }
        return region.imageWaterMark;
    }

    public int getMixedStreamLayoutRegionDataParamImageWidth(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.imageWaterMarkConfig.imageWidth;
    }

    public int getMixedStreamLayoutRegionDataParamImageHeight(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.imageWaterMarkConfig.imageHeight;
    }

    public int getMixedStreamLayoutRegionAlternateImageFillMode(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return MixedStreamAlternateImageFillMode.FIT.getValue();
        }
        return region.alternateImageFillMode.getValue();
    }

    public String getMixedStreamLayoutRegionAlternateImageURL(MixedStreamLayoutRegionConfig region) {
        return region == null ? "" : region.alternateImageURL;
    }

    public float getMixedStreamLayoutRegionSpatialPositionX(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.f113x;
    }

    public float getMixedStreamLayoutRegionSpatialPositionY(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.f114y;
    }

    public float getMixedStreamLayoutRegionSpatialPositionZ(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0.0f;
        }
        return region.spatialPosition.f115z;
    }

    public boolean getMixedStreamLayoutRegionVideoEnhancement(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return false;
        }
        return region.videoEnhancement;
    }

    public int getMixedStreamLayoutRegionSuperResolutionMode(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 0;
        }
        return region.superResolutionMode;
    }

    public boolean getMixedStreamLayoutRegionIgnoreRtcSei(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return false;
        }
        return region.ignoreRtcSei;
    }

    public boolean getMixedStreamLayoutRegionApplySpatialAudio(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return true;
        }
        return region.applySpatialAudio;
    }

    public int getMixedStreamLayoutRegionVolume(MixedStreamLayoutRegionConfig region) {
        if (region == null) {
            return 100;
        }
        return region.volume;
    }

    public int getMixedStreamInterpolationMode() {
        return this.interpolationMode.value();
    }

    public int getMixedStreamLayoutMode() {
        return this.layoutMode.value();
    }

    public JSONObject getTranscodeMessage() {
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str2 = "height";
        String str3 = "width";
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        JSONObject jSONObject7 = new JSONObject();
        JSONObject jSONObject8 = new JSONObject();
        JSONObject jSONObject9 = new JSONObject();
        new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject10 = new JSONObject();
        JSONObject jSONObject11 = new JSONObject();
        JSONObject jSONObject12 = new JSONObject();
        try {
            jSONObject3.put("videoCodec", this.videoConfig.videoCodec);
            jSONObject3.put("fps", this.videoConfig.fps);
            jSONObject3.put("gop", this.videoConfig.gop);
            jSONObject3.put(MediaFormat.KEY_BIT_RATE, this.videoConfig.bitrate);
            jSONObject3.put("width", this.videoConfig.width);
            jSONObject3.put("height", this.videoConfig.height);
            jSONObject3.put("enableBframe", this.videoConfig.enableBframe);
            jSONObject4.put("audioCodec", this.audioConfig.audioCodec);
            jSONObject4.put(MediaFormat.KEY_BIT_RATE, this.audioConfig.bitrate);
            jSONObject4.put("sampleRate", this.audioConfig.sampleRate);
            jSONObject4.put("channels", this.audioConfig.channels);
            jSONObject4.put("audioProfile", this.audioConfig.audioProfile);
            jSONObject5.put("enableVolumeIndication", this.controlConfig.enableVolumeIndication);
            jSONObject5.put("talkVolume", this.controlConfig.talkVolume);
            jSONObject5.put("isAddVolumeValue", this.controlConfig.isAddVolumeValue);
            jSONObject5.put("volumeIndicationInterval", this.controlConfig.volumeIndicationInterval);
            jSONObject5.put("seiContentMode", this.controlConfig.seiContentMode);
            jSONObject5.put("seiPayloadType", this.controlConfig.seiPayloadType);
            jSONObject5.put("seiPayloadUuid", this.controlConfig.seiPayloadUuid);
            jSONObject5.put("mediaType", this.controlConfig.mediaType);
            jSONObject5.put("pushStreamMode", this.controlConfig.pushStreamMode);
            jSONObject7.put("syncStrategy", this.syncControlConfig.syncStrategy);
            jSONObject7.put("maxCacheTimeMs", this.syncControlConfig.maxCacheTimeMs);
            jSONObject7.put("videoNeedSdkMix", this.syncControlConfig.videoNeedSdkMix);
            jSONObject7.put("baseuserID", this.syncControlConfig.baseUserID);
            jSONObject7.put("baseRoomID", this.syncControlConfig.baseRoomID);
            jSONObject7.put("baseStreamStartDelayMs", this.syncControlConfig.baseStreamStartDelayMs);
            jSONObject8.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, this.audioEffectConfig.mAudioEffectType);
            jSONObject11.put("backgroundColor", this.backgroundColor);
            jSONObject11.put("backgroundImageURL", this.backgroundImageURL);
            MixedStreamLayoutRegionConfig[] mixedStreamLayoutRegionConfigArr = this.regions;
            String str4 = "roomID";
            String str5 = "userID";
            if (mixedStreamLayoutRegionConfigArr != null) {
                int length = mixedStreamLayoutRegionConfigArr.length;
                jSONObject2 = jSONObject8;
                int i = 0;
                while (i < length) {
                    int i2 = length;
                    MixedStreamLayoutRegionConfig mixedStreamLayoutRegionConfig = mixedStreamLayoutRegionConfigArr[i];
                    MixedStreamLayoutRegionConfig[] mixedStreamLayoutRegionConfigArr2 = mixedStreamLayoutRegionConfigArr;
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put(str5, mixedStreamLayoutRegionConfig.userID);
                    jSONObject13.put(str4, mixedStreamLayoutRegionConfig.roomID);
                    jSONObject13.put("wtnStreamID", mixedStreamLayoutRegionConfig.wtnStreamID);
                    jSONObject13.put("locationX", mixedStreamLayoutRegionConfig.locationX);
                    jSONObject13.put("locationY", mixedStreamLayoutRegionConfig.locationY);
                    jSONObject13.put(str3, mixedStreamLayoutRegionConfig.width);
                    jSONObject13.put(str2, mixedStreamLayoutRegionConfig.height);
                    jSONObject13.put("zOrder", mixedStreamLayoutRegionConfig.zOrder);
                    jSONObject13.put("alpha", mixedStreamLayoutRegionConfig.alpha);
                    jSONObject13.put("cornerRadius", mixedStreamLayoutRegionConfig.cornerRadius);
                    jSONObject13.put("mediaType", mixedStreamLayoutRegionConfig.mediaType);
                    jSONObject13.put("renderMode", mixedStreamLayoutRegionConfig.renderMode);
                    jSONObject13.put("isLocalUser", mixedStreamLayoutRegionConfig.isLocalUser);
                    jSONObject13.put("streamType", mixedStreamLayoutRegionConfig.streamType);
                    jSONObject13.put("applySpatialAudio", mixedStreamLayoutRegionConfig.applySpatialAudio);
                    jSONObject13.put("alternateImageFillMode", mixedStreamLayoutRegionConfig.alternateImageFillMode);
                    jSONObject13.put("alternateImageURL", mixedStreamLayoutRegionConfig.alternateImageURL);
                    jSONObject13.put("sourceCropX", mixedStreamLayoutRegionConfig.sourceCrop.locationX);
                    jSONObject13.put("sourceCropY", mixedStreamLayoutRegionConfig.sourceCrop.locationY);
                    jSONObject13.put("sourceCropW", mixedStreamLayoutRegionConfig.sourceCrop.widthProportion);
                    jSONObject13.put("sourceCropH", mixedStreamLayoutRegionConfig.sourceCrop.heightProportion);
                    jSONObject13.put("videoEnhancement", mixedStreamLayoutRegionConfig.videoEnhancement);
                    jSONObject13.put("ignoreRtcSei", mixedStreamLayoutRegionConfig.ignoreRtcSei);
                    jSONObject13.put("superResolutionMode", mixedStreamLayoutRegionConfig.superResolutionMode);
                    jSONArray.put(jSONObject13);
                    i++;
                    str4 = str4;
                    str2 = str2;
                    length = i2;
                    mixedStreamLayoutRegionConfigArr = mixedStreamLayoutRegionConfigArr2;
                    jSONObject7 = jSONObject7;
                    str5 = str5;
                    str3 = str3;
                }
                str = str5;
                jSONObject = jSONObject7;
            } else {
                str = "userID";
                jSONObject = jSONObject7;
                jSONObject2 = jSONObject8;
            }
            String str6 = str4;
            jSONObject11.put("regions", jSONArray);
            jSONObject11.put("userConfigExtraInfo", this.userConfigExtraInfo);
            jSONObject11.put("transcode", jSONObject10);
            jSONObject11.put(MediaFormat.KEY_VIDEO, jSONObject3);
            jSONObject11.put(MediaFormat.KEY_AUDIO, jSONObject4);
            jSONObject11.put("serverControl", jSONObject5);
            jSONObject11.put("clientMix", jSONObject6);
            jSONObject11.put("syncControl", jSONObject);
            jSONObject11.put("audioEffect", jSONObject2);
            jSONObject11.put("layout", jSONObject9);
            JSONObject jSONObject14 = this.advancedConfig;
            if (jSONObject14 != null) {
                jSONObject11.put("advancedConfig", jSONObject14);
            }
            JSONObject jSONObject15 = this.authInfo;
            if (jSONObject15 != null) {
                jSONObject11.put("authInfo", jSONObject15);
            }
            jSONObject12.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, "transcode");
            jSONObject12.put(str6, this.roomID);
            jSONObject12.put(str, this.userID);
            jSONObject12.put("transcodeMeta", jSONObject11);
            jSONObject12.put("layoutMode", this.layoutMode);
            jSONObject12.put("interpolationMode", this.interpolationMode);
            return jSONObject12;
        } catch (Exception e) {
            LogUtil.m220w(TAG, "get json message happen exception", e);
            return null;
        }
    }

    public static MixedStreamConfig defaultMixedStreamConfig() {
        MixedStreamVideoConfig mixedStreamVideoConfig = new MixedStreamVideoConfig();
        mixedStreamVideoConfig.videoCodec = MixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
        mixedStreamVideoConfig.fps = 15;
        mixedStreamVideoConfig.gop = 2;
        mixedStreamVideoConfig.enableBframe = false;
        mixedStreamVideoConfig.height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        mixedStreamVideoConfig.width = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        mixedStreamVideoConfig.bitrate = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE;
        MixedStreamAudioConfig mixedStreamAudioConfig = new MixedStreamAudioConfig();
        mixedStreamAudioConfig.audioCodec = MixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
        mixedStreamAudioConfig.channels = 2;
        mixedStreamAudioConfig.bitrate = 64;
        mixedStreamAudioConfig.sampleRate = 48000;
        mixedStreamAudioConfig.audioProfile = MixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
        MixedStreamControlConfig mixedStreamControlConfig = new MixedStreamControlConfig();
        mixedStreamControlConfig.enableVolumeIndication = false;
        mixedStreamControlConfig.seiContentMode = MixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
        mixedStreamControlConfig.isAddVolumeValue = false;
        mixedStreamControlConfig.talkVolume = 0;
        mixedStreamControlConfig.volumeIndicationInterval = 2.0f;
        mixedStreamControlConfig.seiPayloadType = 100;
        mixedStreamControlConfig.seiPayloadUuid = "";
        MixedStreamSyncControlConfig mixedStreamSyncControlConfig = new MixedStreamSyncControlConfig();
        mixedStreamSyncControlConfig.baseUserID = "";
        mixedStreamSyncControlConfig.baseRoomID = "";
        mixedStreamSyncControlConfig.syncStrategy = MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
        mixedStreamSyncControlConfig.maxCacheTimeMs = 2000;
        mixedStreamSyncControlConfig.videoNeedSdkMix = true;
        mixedStreamSyncControlConfig.baseStreamStartDelayMs = 0;
        MixedStreamAudioEffectConfig mixedStreamAudioEffectConfig = new MixedStreamAudioEffectConfig();
        mixedStreamAudioEffectConfig.mAudioEffectType = MixedStreamAudioEffectType.MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE;
        MixedStreamSpatialAudioConfig mixedStreamSpatialAudioConfig = new MixedStreamSpatialAudioConfig();
        mixedStreamSpatialAudioConfig.enableSpatialRender = false;
        MixedStreamConfig mixedStreamConfig = new MixedStreamConfig();
        mixedStreamConfig.audioConfig = mixedStreamAudioConfig;
        mixedStreamConfig.videoConfig = mixedStreamVideoConfig;
        mixedStreamConfig.controlConfig = mixedStreamControlConfig;
        mixedStreamConfig.syncControlConfig = mixedStreamSyncControlConfig;
        mixedStreamConfig.audioEffectConfig = mixedStreamAudioEffectConfig;
        mixedStreamConfig.spatialAudioConfig = mixedStreamSpatialAudioConfig;
        mixedStreamConfig.backgroundColor = "#000000";
        mixedStreamConfig.userConfigExtraInfo = "";
        return mixedStreamConfig;
    }
}
