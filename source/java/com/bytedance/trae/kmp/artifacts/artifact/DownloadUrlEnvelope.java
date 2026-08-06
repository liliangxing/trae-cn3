package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\tH×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;", "", "code", "", "data", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;", "<init>", "(JLcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode", "()J", "getData", "()Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class DownloadUrlEnvelope {
    private final long code;
    private final DownloadUrlDto data;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ DownloadUrlEnvelope copy$default(DownloadUrlEnvelope downloadUrlEnvelope, long j, DownloadUrlDto downloadUrlDto, int i, Object obj) {
        if ((i & 1) != 0) {
            j = downloadUrlEnvelope.code;
        }
        if ((i & 2) != 0) {
            downloadUrlDto = downloadUrlEnvelope.data;
        }
        return downloadUrlEnvelope.copy(j, downloadUrlDto);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final DownloadUrlDto getData() {
        return this.data;
    }

    public final DownloadUrlEnvelope copy(long code, DownloadUrlDto data) {
        return new DownloadUrlEnvelope(code, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadUrlEnvelope)) {
            return false;
        }
        DownloadUrlEnvelope downloadUrlEnvelope = (DownloadUrlEnvelope) other;
        return this.code == downloadUrlEnvelope.code && Intrinsics.areEqual(this.data, downloadUrlEnvelope.data);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.code) * 31;
        DownloadUrlDto downloadUrlDto = this.data;
        return hashCode + (downloadUrlDto == null ? 0 : downloadUrlDto.hashCode());
    }

    public String toString() {
        return "DownloadUrlEnvelope(code=" + this.code + ", data=" + this.data + ')';
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DownloadUrlEnvelope> serializer() {
            return DownloadUrlEnvelope$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DownloadUrlEnvelope(int i, long j, DownloadUrlDto downloadUrlDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, DownloadUrlEnvelope$$serializer.INSTANCE.getDescriptor());
        }
        this.code = j;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = downloadUrlDto;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(DownloadUrlEnvelope self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.code);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, DownloadUrlDto$$serializer.INSTANCE, self.data);
        }
    }

    public DownloadUrlEnvelope(long j, DownloadUrlDto downloadUrlDto) {
        this.code = j;
        this.data = downloadUrlDto;
    }

    public /* synthetic */ DownloadUrlEnvelope(long j, DownloadUrlDto downloadUrlDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : downloadUrlDto);
    }

    public final long getCode() {
        return this.code;
    }

    public final DownloadUrlDto getData() {
        return this.data;
    }
}
