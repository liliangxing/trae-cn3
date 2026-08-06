package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class MixedStreamPushTargetConfig {
    public String pushCDNURL;
    public MixedStreamPushTargetType pushTargetType;
    public String pushWTNStreamID;

    public MixedStreamPushTargetConfig(MixedStreamPushTargetType targetType, String pushUrl, String pushStreamId) {
        MixedStreamPushTargetType mixedStreamPushTargetType = MixedStreamPushTargetType.PUSH_TO_CDN;
        this.pushTargetType = targetType;
        this.pushCDNURL = pushUrl;
        this.pushWTNStreamID = pushStreamId;
    }

    public MixedStreamPushTargetConfig() {
        this.pushTargetType = MixedStreamPushTargetType.PUSH_TO_CDN;
        this.pushCDNURL = "";
        this.pushWTNStreamID = "";
    }

    public int getMixedStreamPushTargetTypePushTargetType() {
        return this.pushTargetType.value();
    }

    public String getMixedStreamPushTargetTypePushCDNURL() {
        String str = this.pushCDNURL;
        return str == null ? "" : str;
    }

    public String getMixedStreamPushTargetTypePushWTNStreamID() {
        String str = this.pushWTNStreamID;
        return str == null ? "" : str;
    }
}
