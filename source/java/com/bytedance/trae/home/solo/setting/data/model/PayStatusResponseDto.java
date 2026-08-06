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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001c\u001a\u00020\tH×\u0001J\t\u0010\u001d\u001a\u00020\u0003H×\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;", "", "userPayIdentityStr", "", "data", "Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserPayIdentityStr$annotations", "()V", "getUserPayIdentityStr", "()Ljava/lang/String;", "getData$annotations", "getData", "()Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusDto;", "effectiveUserPayIdentityStr", "getEffectiveUserPayIdentityStr", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class PayStatusResponseDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PayStatusDto data;
    private final String userPayIdentityStr;

    /* JADX WARN: Multi-variable type inference failed */
    public PayStatusResponseDto() {
        this((String) null, (PayStatusDto) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ PayStatusResponseDto copy$default(PayStatusResponseDto payStatusResponseDto, String str, PayStatusDto payStatusDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payStatusResponseDto.userPayIdentityStr;
        }
        if ((i & 2) != 0) {
            payStatusDto = payStatusResponseDto.data;
        }
        return payStatusResponseDto.copy(str, payStatusDto);
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("user_pay_identity_str")
    public static /* synthetic */ void getUserPayIdentityStr$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    /* renamed from: component2, reason: from getter */
    public final PayStatusDto getData() {
        return this.data;
    }

    public final PayStatusResponseDto copy(String userPayIdentityStr, PayStatusDto data) {
        return new PayStatusResponseDto(userPayIdentityStr, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayStatusResponseDto)) {
            return false;
        }
        PayStatusResponseDto payStatusResponseDto = (PayStatusResponseDto) other;
        return Intrinsics.areEqual(this.userPayIdentityStr, payStatusResponseDto.userPayIdentityStr) && Intrinsics.areEqual(this.data, payStatusResponseDto.data);
    }

    public int hashCode() {
        String str = this.userPayIdentityStr;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        PayStatusDto payStatusDto = this.data;
        return hashCode + (payStatusDto != null ? payStatusDto.hashCode() : 0);
    }

    public String toString() {
        return "PayStatusResponseDto(userPayIdentityStr=" + this.userPayIdentityStr + ", data=" + this.data + ')';
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PayStatusResponseDto> serializer() {
            return PayStatusResponseDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PayStatusResponseDto(int i, String str, PayStatusDto payStatusDto, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, PayStatusResponseDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.userPayIdentityStr = null;
        } else {
            this.userPayIdentityStr = str;
        }
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = payStatusDto;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(PayStatusResponseDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.userPayIdentityStr != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.userPayIdentityStr);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, PayStatusDto$$serializer.INSTANCE, self.data);
        }
    }

    public PayStatusResponseDto(String str, PayStatusDto payStatusDto) {
        this.userPayIdentityStr = str;
        this.data = payStatusDto;
    }

    public /* synthetic */ PayStatusResponseDto(String str, PayStatusDto payStatusDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : payStatusDto);
    }

    public final String getUserPayIdentityStr() {
        return this.userPayIdentityStr;
    }

    public final PayStatusDto getData() {
        return this.data;
    }

    public final String getEffectiveUserPayIdentityStr() {
        String str = this.userPayIdentityStr;
        if (str != null) {
            return str;
        }
        PayStatusDto payStatusDto = this.data;
        if (payStatusDto != null) {
            return payStatusDto.getUserPayIdentityStr();
        }
        return null;
    }
}
