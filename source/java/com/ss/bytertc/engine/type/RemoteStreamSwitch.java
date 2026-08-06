package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteStreamSwitch;

/* loaded from: classes7.dex */
public class RemoteStreamSwitch {
    public boolean afterEnable;
    public int afterVideoIndex;
    public boolean beforeEnable;
    public int beforeVideoIndex;
    public boolean isScreen;
    public FallbackOrRecoverReason reason;
    public String uid;

    public RemoteStreamSwitch() {
    }

    public RemoteStreamSwitch(InternalRemoteStreamSwitch event) {
        this.uid = event.uid;
        this.beforeVideoIndex = event.beforeVideoIndex;
        this.afterVideoIndex = event.afterVideoIndex;
        this.beforeEnable = event.beforeEnable;
        this.afterEnable = event.afterEnable;
        this.reason = getFallbackOrRecoverReason(event.reason);
    }

    private FallbackOrRecoverReason getFallbackOrRecoverReason(int reason) {
        switch (reason) {
            case 0:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_BANDWIDTH;
            case 1:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_FALLBACK_BY_PERFORMANCE;
            case 2:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_BANDWIDTH;
            case 3:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_SUBSCRIBE_RECOVER_BY_PERFORMANCE;
            case 4:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_BANDWIDTH;
            case 5:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_FALLBACK_BY_PERFORMANCE;
            case 6:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_BANDWIDTH;
            case 7:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_PUBLISH_RECOVER_BY_PERFORMANCE;
            default:
                return FallbackOrRecoverReason.FALLBACK_OR_RECOVER_REASON_UNKNOWN;
        }
    }

    public String toString() {
        return "RemoteStreamSwitch{uid='" + this.uid + "', isScreen='" + this.isScreen + "', before_video_index='" + this.beforeVideoIndex + "', after_video_index='" + this.afterVideoIndex + "', before_enable='" + this.beforeEnable + "', after_enable='" + this.afterEnable + "', reason='" + this.reason + "'}";
    }
}
