package com.bytedance.trae.home.solo.setting.data;

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

/* compiled from: DeviceManagementRepository.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\bH×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;", "", "cliId", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCliId$annotations", "()V", "getCliId", "()Ljava/lang/String;", "getName$annotations", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_mainlandRelease", "$serializer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final /* data */ class RenameCliRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String cliId;
    private final String name;

    public static /* synthetic */ RenameCliRequest copy$default(RenameCliRequest renameCliRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = renameCliRequest.cliId;
        }
        if ((i & 2) != 0) {
            str2 = renameCliRequest.name;
        }
        return renameCliRequest.copy(str, str2);
    }

    @SerialName("cli_id")
    public static /* synthetic */ void getCliId$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getCliId() {
        return this.cliId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final RenameCliRequest copy(String cliId, String name) {
        Intrinsics.checkNotNullParameter(cliId, "cliId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new RenameCliRequest(cliId, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenameCliRequest)) {
            return false;
        }
        RenameCliRequest renameCliRequest = (RenameCliRequest) other;
        return Intrinsics.areEqual(this.cliId, renameCliRequest.cliId) && Intrinsics.areEqual(this.name, renameCliRequest.name);
    }

    public int hashCode() {
        return (this.cliId.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "RenameCliRequest(cliId=" + this.cliId + ", name=" + this.name + ')';
    }

    /* compiled from: DeviceManagementRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<RenameCliRequest> serializer() {
            return RenameCliRequest$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RenameCliRequest(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, RenameCliRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.cliId = str;
        this.name = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_mainlandRelease(RenameCliRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.cliId);
        output.encodeStringElement(serialDesc, 1, self.name);
    }

    public RenameCliRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "cliId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.cliId = str;
        this.name = str2;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final String getName() {
        return this.name;
    }
}
