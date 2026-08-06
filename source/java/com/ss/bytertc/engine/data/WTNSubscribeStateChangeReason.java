package com.ss.bytertc.engine.data;

import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes7.dex */
public enum WTNSubscribeStateChangeReason {
    SUBSCRIBE(0),
    UNSUBSCRIBE(1300),
    REMOTE_UNPUBLISH(1301),
    OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT(MediaPlayer.MEDIA_PLAYER_OPTION_AUTO_DISCONNECTED_CPU),
    OVER_STREAM_SUBSCRIBE_USER_LIMIT(MediaPlayer.MEDIA_PLAYER_OPTION_CALIBRATION_AUDIO_TYPE),
    OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_THRESH);

    private int value;

    WTNSubscribeStateChangeReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.WTNSubscribeStateChangeReason$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason;

        static {
            int[] iArr = new int[WTNSubscribeStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason = iArr;
            try {
                iArr[WTNSubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_CLIENT_SUBSCRIBE_STREAM_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_USER_LIMIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[WTNSubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_REQUEST_LIMIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeStateChangeReason[ordinal()]) {
            case 1:
                return "kWTNSubscribeStateChangeReasonSubscribe";
            case 2:
                return "kWTNSubscribeStateChangeReasonUnsubscribe";
            case 3:
                return "kWTNSubscribeStateChangeReasonRemoteUnpublish";
            case 4:
                return "kWTNSubscribeStateChangeReasonOverClientSubscribeStreamLimit";
            case 5:
                return "kWTNSubscribeStateChangeReasonOverStreamSubscribeUserLimit";
            case 6:
                return "kWTNSubscribeStateChangeReasonOverStreamSubscribeRequestLimit";
            default:
                return "";
        }
    }

    public static WTNSubscribeStateChangeReason fromId(int id) {
        for (WTNSubscribeStateChangeReason wTNSubscribeStateChangeReason : values()) {
            if (wTNSubscribeStateChangeReason.value() == id) {
                return wTNSubscribeStateChangeReason;
            }
        }
        return null;
    }
}
