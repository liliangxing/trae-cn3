package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.ies.xbridge.BridgeDataConverterHolder;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B1\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\bH×\u0001J\t\u0010\u0016\u001a\u00020\u0004H×\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR*\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;", "", "urlMap", "", "", "<init>", "(Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrlMap$annotations", "()V", "getUrlMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BridgeDataConverterHolder.TYPE_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$artifacts_mainlandRelease", "$serializer", "Companion", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class DownloadUrlDto {
    private final Map<String, String> urlMap;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)};

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DownloadUrlDto() {
        this(r0, 1, (DefaultConstructorMarker) r0);
        Map map = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadUrlDto copy$default(DownloadUrlDto downloadUrlDto, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = downloadUrlDto.urlMap;
        }
        return downloadUrlDto.copy(map);
    }

    @SerialName("url_map")
    public static /* synthetic */ void getUrlMap$annotations() {
    }

    public final Map<String, String> component1() {
        return this.urlMap;
    }

    public final DownloadUrlDto copy(Map<String, String> urlMap) {
        return new DownloadUrlDto(urlMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadUrlDto) && Intrinsics.areEqual(this.urlMap, ((DownloadUrlDto) other).urlMap);
    }

    public int hashCode() {
        Map<String, String> map = this.urlMap;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "DownloadUrlDto(urlMap=" + this.urlMap + ')';
    }

    /* compiled from: ArtifactModels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DownloadUrlDto> serializer() {
            return DownloadUrlDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DownloadUrlDto(int i, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, DownloadUrlDto$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.urlMap = null;
        } else {
            this.urlMap = map;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$artifacts_mainlandRelease(DownloadUrlDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.urlMap == null) {
            z = false;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 0, serializationStrategyArr[0], self.urlMap);
        }
    }

    public DownloadUrlDto(Map<String, String> map) {
        this.urlMap = map;
    }

    public /* synthetic */ DownloadUrlDto(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, String> getUrlMap() {
        return this.urlMap;
    }
}
