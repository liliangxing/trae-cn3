package com.bytedance.trae.home.solo.setting.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SettingsNetworkModels.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0007H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto;", "", "data", "Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData$annotations", "()V", "getData", "()Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "CountData", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class UnreadCountDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CountData data;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UnreadCountDto() {
        this(r0, 1, (DefaultConstructorMarker) r0);
        CountData countData = null;
    }

    public static /* synthetic */ UnreadCountDto copy$default(UnreadCountDto unreadCountDto, CountData countData, int i, Object obj) {
        if ((i & 1) != 0) {
            countData = unreadCountDto.data;
        }
        return unreadCountDto.copy(countData);
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final CountData getData() {
        return this.data;
    }

    public final UnreadCountDto copy(CountData data) {
        return new UnreadCountDto(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnreadCountDto) && Intrinsics.areEqual(this.data, ((UnreadCountDto) other).data);
    }

    public int hashCode() {
        CountData countData = this.data;
        if (countData == null) {
            return 0;
        }
        return countData.hashCode();
    }

    public String toString() {
        return "UnreadCountDto(data=" + this.data + ')';
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UnreadCountDto> serializer() {
            return UnreadCountDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UnreadCountDto(int i, CountData countData, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, UnreadCountDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.data = null;
        } else {
            this.data = countData;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(UnreadCountDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.data == null) {
            z = false;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 0, UnreadCountDto$CountData$$serializer.INSTANCE, self.data);
        }
    }

    public UnreadCountDto(CountData countData) {
        this.data = countData;
    }

    public /* synthetic */ UnreadCountDto(CountData countData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : countData);
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\u0015H×\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;", "", "count", "", "<init>", "(I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCount$annotations", "()V", "getCount", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CountData {
        public static final int $stable = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int count;

        public CountData() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CountData copy$default(CountData countData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = countData.count;
            }
            return countData.copy(i);
        }

        @SerialName("count")
        public static /* synthetic */ void getCount$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final CountData copy(int count) {
            return new CountData(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CountData) && this.count == ((CountData) other).count;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "CountData(count=" + this.count + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/UnreadCountDto$CountData;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CountData> serializer() {
                return UnreadCountDto$CountData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ CountData(int i, int i2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, UnreadCountDto$CountData$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.count = 0;
            } else {
                this.count = i2;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(CountData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.count == 0) {
                z = false;
            }
            if (z) {
                output.encodeIntElement(serialDesc, 0, self.count);
            }
        }

        public CountData(int i) {
            this.count = i;
        }

        public /* synthetic */ CountData(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i);
        }

        public final int getCount() {
            return this.count;
        }
    }

    public final CountData getData() {
        return this.data;
    }
}
