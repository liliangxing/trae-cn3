package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UniAVEngine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniGearStreamType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Unified", "SepVideo", "SepAudio", "Unknown", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum UniGearStreamType {
    Unified(0),
    SepVideo(1),
    SepAudio(2),
    Unknown(-1);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    UniGearStreamType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* compiled from: UniAVEngine.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniGearStreamType$Companion;", "", "()V", "fromValue", "Lcom/bytedance/vcloud/uniplayer/UniGearStreamType;", "value", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniGearStreamType fromValue(int value) {
            return value == UniGearStreamType.Unified.getValue() ? UniGearStreamType.Unified : value == UniGearStreamType.SepVideo.getValue() ? UniGearStreamType.SepVideo : value == UniGearStreamType.SepAudio.getValue() ? UniGearStreamType.SepAudio : UniGearStreamType.Unknown;
        }
    }
}
