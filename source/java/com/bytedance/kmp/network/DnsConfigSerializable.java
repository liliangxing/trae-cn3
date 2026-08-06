package com.bytedance.kmp.network;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/kmp/network/DnsConfigSerializable;", "", "seen1", "", "prefer_ip", "", "backup_ip", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getBackup_ip", "()Ljava/lang/String;", "setBackup_ip", "(Ljava/lang/String;)V", "getPrefer_ip", "setPrefer_ip", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$network_service_release", "$serializer", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class DnsConfigSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String backup_ip;
    private String prefer_ip;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DnsConfigSerializable() {
        this(r0, r0, 3, (DefaultConstructorMarker) r0);
        String str = null;
    }

    public static /* synthetic */ DnsConfigSerializable copy$default(DnsConfigSerializable dnsConfigSerializable, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dnsConfigSerializable.prefer_ip;
        }
        if ((i & 2) != 0) {
            str2 = dnsConfigSerializable.backup_ip;
        }
        return dnsConfigSerializable.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPrefer_ip() {
        return this.prefer_ip;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBackup_ip() {
        return this.backup_ip;
    }

    public final DnsConfigSerializable copy(String prefer_ip, String backup_ip) {
        return new DnsConfigSerializable(prefer_ip, backup_ip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DnsConfigSerializable)) {
            return false;
        }
        DnsConfigSerializable dnsConfigSerializable = (DnsConfigSerializable) other;
        return Intrinsics.areEqual(this.prefer_ip, dnsConfigSerializable.prefer_ip) && Intrinsics.areEqual(this.backup_ip, dnsConfigSerializable.backup_ip);
    }

    public int hashCode() {
        String str = this.prefer_ip;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.backup_ip;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DnsConfigSerializable(prefer_ip=" + this.prefer_ip + ", backup_ip=" + this.backup_ip + ')';
    }

    /* compiled from: KmpNetworkManagerImpl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/network/DnsConfigSerializable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/kmp/network/DnsConfigSerializable;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DnsConfigSerializable> serializer() {
            return DnsConfigSerializable$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DnsConfigSerializable(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, DnsConfigSerializable$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.prefer_ip = null;
        } else {
            this.prefer_ip = str;
        }
        if ((i & 2) == 0) {
            this.backup_ip = null;
        } else {
            this.backup_ip = str2;
        }
    }

    public DnsConfigSerializable(String str, String str2) {
        this.prefer_ip = str;
        this.backup_ip = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$network_service_release(DnsConfigSerializable self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.prefer_ip != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.prefer_ip);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.backup_ip != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.backup_ip);
        }
    }

    public /* synthetic */ DnsConfigSerializable(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getPrefer_ip() {
        return this.prefer_ip;
    }

    public final void setPrefer_ip(String str) {
        this.prefer_ip = str;
    }

    public final String getBackup_ip() {
        return this.backup_ip;
    }

    public final void setBackup_ip(String str) {
        this.backup_ip = str;
    }
}
