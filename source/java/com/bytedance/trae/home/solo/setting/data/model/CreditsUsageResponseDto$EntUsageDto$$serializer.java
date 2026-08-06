package com.bytedance.trae.home.solo.setting.data.model;

import com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SettingsNetworkModels.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto.EntUsageDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class CreditsUsageResponseDto$EntUsageDto$$serializer implements GeneratedSerializer<CreditsUsageResponseDto.EntUsageDto> {
    public static final int $stable;
    public static final CreditsUsageResponseDto$EntUsageDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private CreditsUsageResponseDto$EntUsageDto$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CreditsUsageResponseDto$EntUsageDto$$serializer creditsUsageResponseDto$EntUsageDto$$serializer = new CreditsUsageResponseDto$EntUsageDto$$serializer();
        INSTANCE = creditsUsageResponseDto$EntUsageDto$$serializer;
        $stable = 8;
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto.EntUsageDto", creditsUsageResponseDto$EntUsageDto$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("credits_amount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE)};
    }

    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final CreditsUsageResponseDto.EntUsageDto m2421deserialize(Decoder decoder) {
        Double d;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (beginStructure.decodeSequentially()) {
            d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, (Object) null);
        } else {
            int i2 = 0;
            d = null;
            while (i != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    i = 0;
                } else {
                    if (decodeElementIndex != 0) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    d = (Double) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, d);
                    i2 |= 1;
                }
            }
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CreditsUsageResponseDto.EntUsageDto(i, d, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CreditsUsageResponseDto.EntUsageDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CreditsUsageResponseDto.EntUsageDto.write$Self$impl_mainlandRelease(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
