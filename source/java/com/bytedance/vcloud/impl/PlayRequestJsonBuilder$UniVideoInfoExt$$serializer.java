package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.impl.PlayRequestJsonBuilder;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.UniVideoInfoExt.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoInfoExt;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$UniVideoInfoExt$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.UniVideoInfoExt> {
    public static final PlayRequestJsonBuilder$UniVideoInfoExt$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$UniVideoInfoExt$$serializer playRequestJsonBuilder$UniVideoInfoExt$$serializer = new PlayRequestJsonBuilder$UniVideoInfoExt$$serializer();
        INSTANCE = playRequestJsonBuilder$UniVideoInfoExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.UniVideoInfoExt", playRequestJsonBuilder$UniVideoInfoExt$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("need_set_token", true);
        pluginGeneratedSerialDescriptor.addElement("decryption_key", true);
        pluginGeneratedSerialDescriptor.addElement("decryption_key_not_encoded", true);
        pluginGeneratedSerialDescriptor.addElement("url_key", true);
        pluginGeneratedSerialDescriptor.addElement("gear_name", true);
        pluginGeneratedSerialDescriptor.addElement("related_audio_file_id", true);
        pluginGeneratedSerialDescriptor.addElement("audio_quality_type", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$UniVideoInfoExt$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005d. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.UniVideoInfoExt m2624deserialize(Decoder decoder) {
        int i;
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 0);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(descriptor2, 4);
            String decodeStringElement5 = beginStructure.decodeStringElement(descriptor2, 5);
            z = decodeBooleanElement;
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, (Object) null);
            str = decodeStringElement5;
            str3 = decodeStringElement3;
            str2 = decodeStringElement4;
            str4 = decodeStringElement2;
            str5 = decodeStringElement;
            i = 127;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            Integer num2 = null;
            i = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                    case 0:
                        i |= 1;
                        z3 = beginStructure.decodeBooleanElement(descriptor2, 0);
                    case 1:
                        str6 = beginStructure.decodeStringElement(descriptor2, 1);
                        i |= 2;
                    case 2:
                        str7 = beginStructure.decodeStringElement(descriptor2, 2);
                        i |= 4;
                    case 3:
                        str8 = beginStructure.decodeStringElement(descriptor2, 3);
                        i |= 8;
                    case 4:
                        str9 = beginStructure.decodeStringElement(descriptor2, 4);
                        i |= 16;
                    case 5:
                        str10 = beginStructure.decodeStringElement(descriptor2, 5);
                        i |= 32;
                    case 6:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num2);
                        i |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num2;
            str = str10;
            str2 = str9;
            str3 = str8;
            str4 = str7;
            str5 = str6;
            z = z3;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.UniVideoInfoExt(i, z, str5, str4, str3, str2, str, num, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.UniVideoInfoExt value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.UniVideoInfoExt.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
