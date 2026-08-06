package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlEnvelope;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class DownloadUrlEnvelope$$serializer implements GeneratedSerializer<DownloadUrlEnvelope> {
    public static final int $stable;
    public static final DownloadUrlEnvelope$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private DownloadUrlEnvelope$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DownloadUrlEnvelope$$serializer downloadUrlEnvelope$$serializer = new DownloadUrlEnvelope$$serializer();
        INSTANCE = downloadUrlEnvelope$$serializer;
        $stable = 8;
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlEnvelope", downloadUrlEnvelope$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("code", false);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(DownloadUrlDto$$serializer.INSTANCE)};
    }

    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final DownloadUrlEnvelope m853deserialize(Decoder decoder) {
        long j;
        int i;
        DownloadUrlDto downloadUrlDto;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        DownloadUrlDto downloadUrlDto2 = null;
        if (beginStructure.decodeSequentially()) {
            j = beginStructure.decodeLongElement(serialDescriptor, 0);
            downloadUrlDto = (DownloadUrlDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DownloadUrlDto$$serializer.INSTANCE, (Object) null);
            i = 3;
        } else {
            j = 0;
            boolean z = true;
            int i2 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    j = beginStructure.decodeLongElement(serialDescriptor, 0);
                    i2 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    downloadUrlDto2 = (DownloadUrlDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DownloadUrlDto$$serializer.INSTANCE, downloadUrlDto2);
                    i2 |= 2;
                }
            }
            i = i2;
            downloadUrlDto = downloadUrlDto2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DownloadUrlEnvelope(i, j, downloadUrlDto, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DownloadUrlEnvelope value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DownloadUrlEnvelope.write$Self$artifacts_mainlandRelease(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
