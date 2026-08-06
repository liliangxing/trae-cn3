package com.bytedance.trae.home.solo.setting.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SettingsNetworkModels.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0007;<=>?@ABI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003JP\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÇ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00101\u001a\u00020\u000fH×\u0001J\t\u00102\u001a\u00020\u0005H×\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001aR$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u0016R\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001f¨\u0006B"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;", "", "code", "", "rawMsg", "", "rawMessage", "userEntitlementPackList", "", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;", "data", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRawMsg$annotations", "getRawMsg", "()Ljava/lang/String;", "getRawMessage$annotations", "getRawMessage", "getUserEntitlementPackList$annotations", "getUserEntitlementPackList", "()Ljava/util/List;", "getData$annotations", "getData", "()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;", "effectiveCode", "getEffectiveCode", "effectiveEntitlementPacks", "getEffectiveEntitlementPacks", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "NestedDataDto", "EntitlementPackDto", "EntitlementBaseInfoDto", "EntQuotaDto", "EntUsageDto", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CreditsUsageResponseDto {
    private final Long code;
    private final NestedDataDto data;
    private final String rawMessage;
    private final String rawMsg;
    private final List<EntitlementPackDto> userEntitlementPackList;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(CreditsUsageResponseDto$EntitlementPackDto$$serializer.INSTANCE), null};

    public CreditsUsageResponseDto() {
        this((Long) null, (String) null, (String) null, (List) null, (NestedDataDto) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CreditsUsageResponseDto copy$default(CreditsUsageResponseDto creditsUsageResponseDto, Long l, String str, String str2, List list, NestedDataDto nestedDataDto, int i, Object obj) {
        if ((i & 1) != 0) {
            l = creditsUsageResponseDto.code;
        }
        if ((i & 2) != 0) {
            str = creditsUsageResponseDto.rawMsg;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = creditsUsageResponseDto.rawMessage;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            list = creditsUsageResponseDto.userEntitlementPackList;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            nestedDataDto = creditsUsageResponseDto.data;
        }
        return creditsUsageResponseDto.copy(l, str3, str4, list2, nestedDataDto);
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("message")
    public static /* synthetic */ void getRawMessage$annotations() {
    }

    @SerialName("msg")
    public static /* synthetic */ void getRawMsg$annotations() {
    }

    @SerialName("user_entitlement_pack_list")
    public static /* synthetic */ void getUserEntitlementPackList$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRawMsg() {
        return this.rawMsg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRawMessage() {
        return this.rawMessage;
    }

    public final List<EntitlementPackDto> component4() {
        return this.userEntitlementPackList;
    }

    /* renamed from: component5, reason: from getter */
    public final NestedDataDto getData() {
        return this.data;
    }

    public final CreditsUsageResponseDto copy(Long code, String rawMsg, String rawMessage, List<EntitlementPackDto> userEntitlementPackList, NestedDataDto data) {
        return new CreditsUsageResponseDto(code, rawMsg, rawMessage, userEntitlementPackList, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreditsUsageResponseDto)) {
            return false;
        }
        CreditsUsageResponseDto creditsUsageResponseDto = (CreditsUsageResponseDto) other;
        return Intrinsics.areEqual(this.code, creditsUsageResponseDto.code) && Intrinsics.areEqual(this.rawMsg, creditsUsageResponseDto.rawMsg) && Intrinsics.areEqual(this.rawMessage, creditsUsageResponseDto.rawMessage) && Intrinsics.areEqual(this.userEntitlementPackList, creditsUsageResponseDto.userEntitlementPackList) && Intrinsics.areEqual(this.data, creditsUsageResponseDto.data);
    }

    public int hashCode() {
        Long l = this.code;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.rawMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.rawMessage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<EntitlementPackDto> list = this.userEntitlementPackList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        NestedDataDto nestedDataDto = this.data;
        return hashCode4 + (nestedDataDto != null ? nestedDataDto.hashCode() : 0);
    }

    public String toString() {
        return "CreditsUsageResponseDto(code=" + this.code + ", rawMsg=" + this.rawMsg + ", rawMessage=" + this.rawMessage + ", userEntitlementPackList=" + this.userEntitlementPackList + ", data=" + this.data + ')';
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CreditsUsageResponseDto> serializer() {
            return CreditsUsageResponseDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CreditsUsageResponseDto(int i, Long l, String str, String str2, List list, NestedDataDto nestedDataDto, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.code = null;
        } else {
            this.code = l;
        }
        if ((i & 2) == 0) {
            this.rawMsg = null;
        } else {
            this.rawMsg = str;
        }
        if ((i & 4) == 0) {
            this.rawMessage = null;
        } else {
            this.rawMessage = str2;
        }
        if ((i & 8) == 0) {
            this.userEntitlementPackList = null;
        } else {
            this.userEntitlementPackList = list;
        }
        if ((i & 16) == 0) {
            this.data = null;
        } else {
            this.data = nestedDataDto;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(CreditsUsageResponseDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.rawMsg != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.rawMsg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rawMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.rawMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.userEntitlementPackList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, serializationStrategyArr[3], self.userEntitlementPackList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, CreditsUsageResponseDto$NestedDataDto$$serializer.INSTANCE, self.data);
        }
    }

    public CreditsUsageResponseDto(Long l, String str, String str2, List<EntitlementPackDto> list, NestedDataDto nestedDataDto) {
        this.code = l;
        this.rawMsg = str;
        this.rawMessage = str2;
        this.userEntitlementPackList = list;
        this.data = nestedDataDto;
    }

    public /* synthetic */ CreditsUsageResponseDto(Long l, String str, String str2, List list, NestedDataDto nestedDataDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : nestedDataDto);
    }

    public final Long getCode() {
        return this.code;
    }

    public final String getRawMsg() {
        return this.rawMsg;
    }

    public final String getRawMessage() {
        return this.rawMessage;
    }

    public final List<EntitlementPackDto> getUserEntitlementPackList() {
        return this.userEntitlementPackList;
    }

    public final NestedDataDto getData() {
        return this.data;
    }

    public final Long getEffectiveCode() {
        Long l = this.code;
        if (l != null) {
            return l;
        }
        NestedDataDto nestedDataDto = this.data;
        if (nestedDataDto != null) {
            return nestedDataDto.getCode();
        }
        return null;
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001d\u001a\u00020\nH×\u0001J\t\u0010\u001e\u001a\u00020\u001fH×\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;", "", "code", "", "userEntitlementPackList", "", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserEntitlementPackList$annotations", "getUserEntitlementPackList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class NestedDataDto {
        private final Long code;
        private final List<EntitlementPackDto> userEntitlementPackList;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(CreditsUsageResponseDto$EntitlementPackDto$$serializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public NestedDataDto() {
            this((Long) null, (List) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NestedDataDto copy$default(NestedDataDto nestedDataDto, Long l, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                l = nestedDataDto.code;
            }
            if ((i & 2) != 0) {
                list = nestedDataDto.userEntitlementPackList;
            }
            return nestedDataDto.copy(l, list);
        }

        @SerialName("code")
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName("user_entitlement_pack_list")
        public static /* synthetic */ void getUserEntitlementPackList$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Long getCode() {
            return this.code;
        }

        public final List<EntitlementPackDto> component2() {
            return this.userEntitlementPackList;
        }

        public final NestedDataDto copy(Long code, List<EntitlementPackDto> userEntitlementPackList) {
            return new NestedDataDto(code, userEntitlementPackList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NestedDataDto)) {
                return false;
            }
            NestedDataDto nestedDataDto = (NestedDataDto) other;
            return Intrinsics.areEqual(this.code, nestedDataDto.code) && Intrinsics.areEqual(this.userEntitlementPackList, nestedDataDto.userEntitlementPackList);
        }

        public int hashCode() {
            Long l = this.code;
            int hashCode = (l == null ? 0 : l.hashCode()) * 31;
            List<EntitlementPackDto> list = this.userEntitlementPackList;
            return hashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "NestedDataDto(code=" + this.code + ", userEntitlementPackList=" + this.userEntitlementPackList + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$NestedDataDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<NestedDataDto> serializer() {
                return CreditsUsageResponseDto$NestedDataDto$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ NestedDataDto(int i, Long l, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$NestedDataDto$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.code = null;
            } else {
                this.code = l;
            }
            if ((i & 2) == 0) {
                this.userEntitlementPackList = null;
            } else {
                this.userEntitlementPackList = list;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(NestedDataDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
            SerializationStrategy[] serializationStrategyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.code);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.userEntitlementPackList != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, serializationStrategyArr[1], self.userEntitlementPackList);
            }
        }

        public NestedDataDto(Long l, List<EntitlementPackDto> list) {
            this.code = l;
            this.userEntitlementPackList = list;
        }

        public /* synthetic */ NestedDataDto(Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : list);
        }

        public final Long getCode() {
            return this.code;
        }

        public final List<EntitlementPackDto> getUserEntitlementPackList() {
            return this.userEntitlementPackList;
        }
    }

    public final List<EntitlementPackDto> getEffectiveEntitlementPacks() {
        List<EntitlementPackDto> list = this.userEntitlementPackList;
        if (list != null) {
            return list;
        }
        NestedDataDto nestedDataDto = this.data;
        if (nestedDataDto != null) {
            return nestedDataDto.getUserEntitlementPackList();
        }
        return null;
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\tH×\u0001J\t\u0010\u001b\u001a\u00020\u001cH×\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;", "", "entitlementBaseInfo", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;", "usage", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEntitlementBaseInfo$annotations", "()V", "getEntitlementBaseInfo", "()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;", "getUsage$annotations", "getUsage", "()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class EntitlementPackDto {
        public static final int $stable = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final EntitlementBaseInfoDto entitlementBaseInfo;
        private final EntUsageDto usage;

        /* JADX WARN: Multi-variable type inference failed */
        public EntitlementPackDto() {
            this((EntitlementBaseInfoDto) null, (EntUsageDto) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ EntitlementPackDto copy$default(EntitlementPackDto entitlementPackDto, EntitlementBaseInfoDto entitlementBaseInfoDto, EntUsageDto entUsageDto, int i, Object obj) {
            if ((i & 1) != 0) {
                entitlementBaseInfoDto = entitlementPackDto.entitlementBaseInfo;
            }
            if ((i & 2) != 0) {
                entUsageDto = entitlementPackDto.usage;
            }
            return entitlementPackDto.copy(entitlementBaseInfoDto, entUsageDto);
        }

        @SerialName("entitlement_base_info")
        public static /* synthetic */ void getEntitlementBaseInfo$annotations() {
        }

        @SerialName("usage")
        public static /* synthetic */ void getUsage$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final EntitlementBaseInfoDto getEntitlementBaseInfo() {
            return this.entitlementBaseInfo;
        }

        /* renamed from: component2, reason: from getter */
        public final EntUsageDto getUsage() {
            return this.usage;
        }

        public final EntitlementPackDto copy(EntitlementBaseInfoDto entitlementBaseInfo, EntUsageDto usage) {
            return new EntitlementPackDto(entitlementBaseInfo, usage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EntitlementPackDto)) {
                return false;
            }
            EntitlementPackDto entitlementPackDto = (EntitlementPackDto) other;
            return Intrinsics.areEqual(this.entitlementBaseInfo, entitlementPackDto.entitlementBaseInfo) && Intrinsics.areEqual(this.usage, entitlementPackDto.usage);
        }

        public int hashCode() {
            EntitlementBaseInfoDto entitlementBaseInfoDto = this.entitlementBaseInfo;
            int hashCode = (entitlementBaseInfoDto == null ? 0 : entitlementBaseInfoDto.hashCode()) * 31;
            EntUsageDto entUsageDto = this.usage;
            return hashCode + (entUsageDto != null ? entUsageDto.hashCode() : 0);
        }

        public String toString() {
            return "EntitlementPackDto(entitlementBaseInfo=" + this.entitlementBaseInfo + ", usage=" + this.usage + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<EntitlementPackDto> serializer() {
                return CreditsUsageResponseDto$EntitlementPackDto$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EntitlementPackDto(int i, EntitlementBaseInfoDto entitlementBaseInfoDto, EntUsageDto entUsageDto, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$EntitlementPackDto$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.entitlementBaseInfo = null;
            } else {
                this.entitlementBaseInfo = entitlementBaseInfoDto;
            }
            if ((i & 2) == 0) {
                this.usage = null;
            } else {
                this.usage = entUsageDto;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(EntitlementPackDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.entitlementBaseInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, CreditsUsageResponseDto$EntitlementBaseInfoDto$$serializer.INSTANCE, self.entitlementBaseInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.usage != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, CreditsUsageResponseDto$EntUsageDto$$serializer.INSTANCE, self.usage);
            }
        }

        public EntitlementPackDto(EntitlementBaseInfoDto entitlementBaseInfoDto, EntUsageDto entUsageDto) {
            this.entitlementBaseInfo = entitlementBaseInfoDto;
            this.usage = entUsageDto;
        }

        public /* synthetic */ EntitlementPackDto(EntitlementBaseInfoDto entitlementBaseInfoDto, EntUsageDto entUsageDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : entitlementBaseInfoDto, (i & 2) != 0 ? null : entUsageDto);
        }

        public final EntitlementBaseInfoDto getEntitlementBaseInfo() {
            return this.entitlementBaseInfo;
        }

        public final EntUsageDto getUsage() {
            return this.usage;
        }
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0007H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;", "", "quota", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;", "<init>", "(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuota$annotations", "()V", "getQuota", "()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class EntitlementBaseInfoDto {
        public static final int $stable = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final EntQuotaDto quota;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EntitlementBaseInfoDto() {
            this(r0, 1, (DefaultConstructorMarker) r0);
            EntQuotaDto entQuotaDto = null;
        }

        public static /* synthetic */ EntitlementBaseInfoDto copy$default(EntitlementBaseInfoDto entitlementBaseInfoDto, EntQuotaDto entQuotaDto, int i, Object obj) {
            if ((i & 1) != 0) {
                entQuotaDto = entitlementBaseInfoDto.quota;
            }
            return entitlementBaseInfoDto.copy(entQuotaDto);
        }

        @SerialName("quota")
        public static /* synthetic */ void getQuota$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final EntQuotaDto getQuota() {
            return this.quota;
        }

        public final EntitlementBaseInfoDto copy(EntQuotaDto quota) {
            return new EntitlementBaseInfoDto(quota);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EntitlementBaseInfoDto) && Intrinsics.areEqual(this.quota, ((EntitlementBaseInfoDto) other).quota);
        }

        public int hashCode() {
            EntQuotaDto entQuotaDto = this.quota;
            if (entQuotaDto == null) {
                return 0;
            }
            return entQuotaDto.hashCode();
        }

        public String toString() {
            return "EntitlementBaseInfoDto(quota=" + this.quota + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<EntitlementBaseInfoDto> serializer() {
                return CreditsUsageResponseDto$EntitlementBaseInfoDto$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EntitlementBaseInfoDto(int i, EntQuotaDto entQuotaDto, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$EntitlementBaseInfoDto$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.quota = null;
            } else {
                this.quota = entQuotaDto;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(EntitlementBaseInfoDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.quota == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, CreditsUsageResponseDto$EntQuotaDto$$serializer.INSTANCE, self.quota);
            }
        }

        public EntitlementBaseInfoDto(EntQuotaDto entQuotaDto) {
            this.quota = entQuotaDto;
        }

        public /* synthetic */ EntitlementBaseInfoDto(EntQuotaDto entQuotaDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : entQuotaDto);
        }

        public final EntQuotaDto getQuota() {
            return this.quota;
        }
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0007H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;", "", "creditsLimit", "", "<init>", "(Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreditsLimit$annotations", "()V", "getCreditsLimit", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class EntQuotaDto {
        public static final int $stable = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Long creditsLimit;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EntQuotaDto() {
            this(r0, 1, (DefaultConstructorMarker) r0);
            Long l = null;
        }

        public static /* synthetic */ EntQuotaDto copy$default(EntQuotaDto entQuotaDto, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = entQuotaDto.creditsLimit;
            }
            return entQuotaDto.copy(l);
        }

        @SerialName("credits_limit")
        public static /* synthetic */ void getCreditsLimit$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Long getCreditsLimit() {
            return this.creditsLimit;
        }

        public final EntQuotaDto copy(Long creditsLimit) {
            return new EntQuotaDto(creditsLimit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EntQuotaDto) && Intrinsics.areEqual(this.creditsLimit, ((EntQuotaDto) other).creditsLimit);
        }

        public int hashCode() {
            Long l = this.creditsLimit;
            if (l == null) {
                return 0;
            }
            return l.hashCode();
        }

        public String toString() {
            return "EntQuotaDto(creditsLimit=" + this.creditsLimit + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<EntQuotaDto> serializer() {
                return CreditsUsageResponseDto$EntQuotaDto$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EntQuotaDto(int i, Long l, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$EntQuotaDto$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.creditsLimit = null;
            } else {
                this.creditsLimit = l;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(EntQuotaDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.creditsLimit == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.creditsLimit);
            }
        }

        public EntQuotaDto(Long l) {
            this.creditsLimit = l;
        }

        public /* synthetic */ EntQuotaDto(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l);
        }

        public final Long getCreditsLimit() {
            return this.creditsLimit;
        }
    }

    /* compiled from: SettingsNetworkModels.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0007H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "", "creditsAmount", "", "<init>", "(Ljava/lang/Double;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreditsAmount$annotations", "()V", "getCreditsAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "copy", "(Ljava/lang/Double;)Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class EntUsageDto {
        public static final int $stable = 0;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Double creditsAmount;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EntUsageDto() {
            this(r0, 1, (DefaultConstructorMarker) r0);
            Double d = null;
        }

        public static /* synthetic */ EntUsageDto copy$default(EntUsageDto entUsageDto, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = entUsageDto.creditsAmount;
            }
            return entUsageDto.copy(d);
        }

        @SerialName("credits_amount")
        public static /* synthetic */ void getCreditsAmount$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Double getCreditsAmount() {
            return this.creditsAmount;
        }

        public final EntUsageDto copy(Double creditsAmount) {
            return new EntUsageDto(creditsAmount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EntUsageDto) && Intrinsics.areEqual(this.creditsAmount, ((EntUsageDto) other).creditsAmount);
        }

        public int hashCode() {
            Double d = this.creditsAmount;
            if (d == null) {
                return 0;
            }
            return d.hashCode();
        }

        public String toString() {
            return "EntUsageDto(creditsAmount=" + this.creditsAmount + ')';
        }

        /* compiled from: SettingsNetworkModels.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<EntUsageDto> serializer() {
                return CreditsUsageResponseDto$EntUsageDto$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EntUsageDto(int i, Double d, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CreditsUsageResponseDto$EntUsageDto$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.creditsAmount = null;
            } else {
                this.creditsAmount = d;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$impl_mainlandRelease(EntUsageDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.creditsAmount == null) {
                z = false;
            }
            if (z) {
                output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.creditsAmount);
            }
        }

        public EntUsageDto(Double d) {
            this.creditsAmount = d;
        }

        public /* synthetic */ EntUsageDto(Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : d);
        }

        public final Double getCreditsAmount() {
            return this.creditsAmount;
        }
    }
}
