package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.trae.conversation.devices.DeviceProductType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "", "enable", "", "version", "", "priority", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "minIntervalMillis", "", "<init>", "(ZILjava/util/List;J)V", "getEnable", "()Z", "getVersion", "()I", "getPriority", "()Ljava/util/List;", "getMinIntervalMillis", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class NewFeaturePromptConfig {
    public static final long DEFAULT_MIN_INTERVAL_MILLIS = 86400000;
    public static final int DEFAULT_VERSION = 1;
    private final boolean enable;
    private final long minIntervalMillis;
    private final List<DeviceProductType> priority;
    private final int version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<DeviceProductType> DEFAULT_PRIORITY = CollectionsKt.listOf(new DeviceProductType[]{DeviceProductType.WORK, DeviceProductType.IDE});
    private static final NewFeaturePromptConfig DISABLED = new NewFeaturePromptConfig(false, 0, null, 0, 14, null);

    public NewFeaturePromptConfig() {
        this(false, 0, null, 0L, 15, null);
    }

    public static /* synthetic */ NewFeaturePromptConfig copy$default(NewFeaturePromptConfig newFeaturePromptConfig, boolean z, int i, List list, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = newFeaturePromptConfig.enable;
        }
        if ((i2 & 2) != 0) {
            i = newFeaturePromptConfig.version;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            list = newFeaturePromptConfig.priority;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            j = newFeaturePromptConfig.minIntervalMillis;
        }
        return newFeaturePromptConfig.copy(z, i3, list2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final List<DeviceProductType> component3() {
        return this.priority;
    }

    /* renamed from: component4, reason: from getter */
    public final long getMinIntervalMillis() {
        return this.minIntervalMillis;
    }

    public final NewFeaturePromptConfig copy(boolean enable, int version, List<? extends DeviceProductType> priority, long minIntervalMillis) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return new NewFeaturePromptConfig(enable, version, priority, minIntervalMillis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewFeaturePromptConfig)) {
            return false;
        }
        NewFeaturePromptConfig newFeaturePromptConfig = (NewFeaturePromptConfig) other;
        return this.enable == newFeaturePromptConfig.enable && this.version == newFeaturePromptConfig.version && Intrinsics.areEqual(this.priority, newFeaturePromptConfig.priority) && this.minIntervalMillis == newFeaturePromptConfig.minIntervalMillis;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enable) * 31) + Integer.hashCode(this.version)) * 31) + this.priority.hashCode()) * 31) + Long.hashCode(this.minIntervalMillis);
    }

    public String toString() {
        return "NewFeaturePromptConfig(enable=" + this.enable + ", version=" + this.version + ", priority=" + this.priority + ", minIntervalMillis=" + this.minIntervalMillis + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewFeaturePromptConfig(boolean z, int i, List<? extends DeviceProductType> list, long j) {
        Intrinsics.checkNotNullParameter(list, "priority");
        this.enable = z;
        this.version = i;
        this.priority = list;
        this.minIntervalMillis = j;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getVersion() {
        return this.version;
    }

    public /* synthetic */ NewFeaturePromptConfig(boolean z, int i, List list, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) == 0 ? i : 1, (i2 & 4) != 0 ? DEFAULT_PRIORITY : list, (i2 & 8) != 0 ? 86400000L : j);
    }

    public final List<DeviceProductType> getPriority() {
        return this.priority;
    }

    public final long getMinIntervalMillis() {
        return this.minIntervalMillis;
    }

    /* compiled from: NewFeaturePromptPolicy.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;", "", "<init>", "()V", "DEFAULT_VERSION", "", "DEFAULT_MIN_INTERVAL_MILLIS", "", "DEFAULT_PRIORITY", "", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getDEFAULT_PRIORITY", "()Ljava/util/List;", "DISABLED", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "getDISABLED", "()Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceProductType> getDEFAULT_PRIORITY() {
            return NewFeaturePromptConfig.DEFAULT_PRIORITY;
        }

        public final NewFeaturePromptConfig getDISABLED() {
            return NewFeaturePromptConfig.DISABLED;
        }
    }
}
