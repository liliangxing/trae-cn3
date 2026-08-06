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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SettingsNetworkModels.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\bH×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto;", "", "traeClient", "", "deviceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTraeClient$annotations", "()V", "getTraeClient", "()Ljava/lang/String;", "getDeviceId$annotations", "getDeviceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class PayStatusRequestDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String deviceId;
    private final String traeClient;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PayStatusRequestDto() {
        this(r0, r0, 3, (DefaultConstructorMarker) r0);
        String str = null;
    }

    public static /* synthetic */ PayStatusRequestDto copy$default(PayStatusRequestDto payStatusRequestDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payStatusRequestDto.traeClient;
        }
        if ((i & 2) != 0) {
            str2 = payStatusRequestDto.deviceId;
        }
        return payStatusRequestDto.copy(str, str2);
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName("trae_client")
    public static /* synthetic */ void getTraeClient$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraeClient() {
        return this.traeClient;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final PayStatusRequestDto copy(String traeClient, String deviceId) {
        return new PayStatusRequestDto(traeClient, deviceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayStatusRequestDto)) {
            return false;
        }
        PayStatusRequestDto payStatusRequestDto = (PayStatusRequestDto) other;
        return Intrinsics.areEqual(this.traeClient, payStatusRequestDto.traeClient) && Intrinsics.areEqual(this.deviceId, payStatusRequestDto.deviceId);
    }

    public int hashCode() {
        String str = this.traeClient;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PayStatusRequestDto(traeClient=" + this.traeClient + ", deviceId=" + this.deviceId + ')';
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PayStatusRequestDto> serializer() {
            return PayStatusRequestDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PayStatusRequestDto(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, PayStatusRequestDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.traeClient = null;
        } else {
            this.traeClient = str;
        }
        if ((i & 2) == 0) {
            this.deviceId = null;
        } else {
            this.deviceId = str2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(PayStatusRequestDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.traeClient != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.traeClient);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.deviceId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceId);
        }
    }

    public PayStatusRequestDto(String str, String str2) {
        this.traeClient = str;
        this.deviceId = str2;
    }

    public /* synthetic */ PayStatusRequestDto(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getTraeClient() {
        return this.traeClient;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }
}
