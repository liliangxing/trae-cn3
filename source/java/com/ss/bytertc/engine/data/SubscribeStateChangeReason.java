package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum SubscribeStateChangeReason {
    SUBSCRIBE(0),
    UNSUBSCRIBE(1),
    REMOTE_PUBLISH(2),
    REMOTE_UNPUBLISH(3),
    STREAM_FAILED_5XX(4),
    STREAM_FAILED_404(5),
    OVER_STREAM_SUBSCRIBE_LIMIT(6),
    NO_SUBSCRIBE_PERMISSION(7);

    private int value;

    SubscribeStateChangeReason(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.SubscribeStateChangeReason$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason;

        static {
            int[] iArr = new int[SubscribeStateChangeReason.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason = iArr;
            try {
                iArr[SubscribeStateChangeReason.SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.UNSUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.REMOTE_PUBLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.REMOTE_UNPUBLISH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.STREAM_FAILED_5XX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.STREAM_FAILED_404.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.OVER_STREAM_SUBSCRIBE_LIMIT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[SubscribeStateChangeReason.NO_SUBSCRIBE_PERMISSION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SubscribeStateChangeReason[ordinal()]) {
            case 1:
                return "kSubscribeStateChangeReasonSubscribe";
            case 2:
                return "kSubscribeStateChangeReasonUnsubscribe";
            case 3:
                return "kSubscribeStateChangeReasonRemotePublish";
            case 4:
                return "kSubscribeStateChangeReasonRemoteUnpublish";
            case 5:
                return "kSubscribeStateChangeReasonStreamFailed5xx";
            case 6:
                return "kSubscribeStateChangeReasonStreamFailed404";
            case 7:
                return "kSubscribeStateChangeReasonOverStreamSubscribeLimit";
            case 8:
                return "kSubscribeStateChangeReasonNoSubscribePermission";
            default:
                return "";
        }
    }

    public static SubscribeStateChangeReason fromId(int id) {
        for (SubscribeStateChangeReason subscribeStateChangeReason : values()) {
            if (subscribeStateChangeReason.value() == id) {
                return subscribeStateChangeReason;
            }
        }
        return null;
    }
}
