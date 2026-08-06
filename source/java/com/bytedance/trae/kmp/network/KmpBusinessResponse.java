package com.bytedance.trae.kmp.network;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import java.util.Set;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: KmpBusinessResponse.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 7*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000278B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0014\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u001bJB\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÇ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0002H×\u0003J\t\u0010+\u001a\u00020\fH×\u0001J\t\u0010,\u001a\u00020\u0006H×\u0001JE\u0010-\u001a\u00020.\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H\u000105H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016¨\u00069"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;", "T", "", "code", "", "rawMsg", "", "rawMessage", "data", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getCode", "()J", "getRawMsg$annotations", "getRawMsg", "()Ljava/lang/String;", "getRawMessage$annotations", "getRawMessage", "getData$annotations", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "businessMessage", "getBusinessMessage", "isSuccess", "", "successCodes", "", "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$base_mainlandRelease", "Companion", "$serializer", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class KmpBusinessResponse<T> {
    private static final SerialDescriptor $cachedDescriptor;
    public static final int $stable = 0;
    public static final long CODE_UNKNOWN = -999;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long code;
    private final T data;
    private final String rawMessage;
    private final String rawMsg;

    public KmpBusinessResponse() {
        this(0L, (String) null, (String) null, (Object) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KmpBusinessResponse copy$default(KmpBusinessResponse kmpBusinessResponse, long j, String str, String str2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            j = kmpBusinessResponse.code;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = kmpBusinessResponse.rawMsg;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = kmpBusinessResponse.rawMessage;
        }
        String str4 = str2;
        T t = obj;
        if ((i & 8) != 0) {
            t = kmpBusinessResponse.data;
        }
        return kmpBusinessResponse.copy(j2, str3, str4, t);
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

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
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

    public final T component4() {
        return this.data;
    }

    public final KmpBusinessResponse<T> copy(long code, String rawMsg, String rawMessage, T data) {
        return new KmpBusinessResponse<>(code, rawMsg, rawMessage, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpBusinessResponse)) {
            return false;
        }
        KmpBusinessResponse kmpBusinessResponse = (KmpBusinessResponse) other;
        return this.code == kmpBusinessResponse.code && Intrinsics.areEqual(this.rawMsg, kmpBusinessResponse.rawMsg) && Intrinsics.areEqual(this.rawMessage, kmpBusinessResponse.rawMessage) && Intrinsics.areEqual(this.data, kmpBusinessResponse.data);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        String str = this.rawMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.rawMessage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        T t = this.data;
        return hashCode3 + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "KmpBusinessResponse(code=" + this.code + ", rawMsg=" + this.rawMsg + ", rawMessage=" + this.rawMessage + ", data=" + this.data + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ KmpBusinessResponse(int i, long j, String str, String str2, Object obj, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, $cachedDescriptor);
        }
        this.code = (i & 1) == 0 ? -999L : j;
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
            this.data = null;
        } else {
            this.data = obj;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$base_mainlandRelease(KmpBusinessResponse self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != -999) {
            output.encodeLongElement(serialDesc, 0, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.rawMsg != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.rawMsg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.rawMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.rawMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) typeSerial0, self.data);
        }
    }

    public KmpBusinessResponse(long j, String str, String str2, T t) {
        this.code = j;
        this.rawMsg = str;
        this.rawMessage = str2;
        this.data = t;
    }

    public /* synthetic */ KmpBusinessResponse(long j, String str, String str2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -999L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : obj);
    }

    public final long getCode() {
        return this.code;
    }

    public final String getRawMsg() {
        return this.rawMsg;
    }

    public final String getRawMessage() {
        return this.rawMessage;
    }

    public final T getData() {
        return this.data;
    }

    public final String getBusinessMessage() {
        String str = this.rawMsg;
        if (str != null) {
            return str;
        }
        String str2 = this.rawMessage;
        return str2 == null ? "" : str2;
    }

    public final boolean isSuccess(Set<Long> successCodes) {
        Intrinsics.checkNotNullParameter(successCodes, "successCodes");
        return successCodes.contains(Long.valueOf(this.code));
    }

    /* compiled from: KmpBusinessResponse.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\b0\u0007\"\u0004\b\u0001\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;", "", "<init>", "()V", "CODE_UNKNOWN", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;", "T", "typeSerial0", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> KSerializer<KmpBusinessResponse<T>> serializer(KSerializer<T> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new KmpBusinessResponse$$serializer<>(typeSerial0);
        }
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.trae.kmp.network.KmpBusinessResponse", (GeneratedSerializer) null, 4);
        pluginGeneratedSerialDescriptor.addElement("code", true);
        pluginGeneratedSerialDescriptor.addElement("msg", true);
        pluginGeneratedSerialDescriptor.addElement("message", true);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }
}
