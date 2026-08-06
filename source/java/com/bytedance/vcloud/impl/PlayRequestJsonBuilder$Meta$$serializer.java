package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.impl.PlayRequestJsonBuilder;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import com.lynx.tasm.animation.AnimationConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.Meta.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$Meta;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$Meta$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.Meta> {
    public static final PlayRequestJsonBuilder$Meta$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$Meta$$serializer playRequestJsonBuilder$Meta$$serializer = new PlayRequestJsonBuilder$Meta$$serializer();
        INSTANCE = playRequestJsonBuilder$Meta$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.Meta", playRequestJsonBuilder$Meta$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("definition", true);
        pluginGeneratedSerialDescriptor.addElement("quality", true);
        pluginGeneratedSerialDescriptor.addElement("vtype", true);
        pluginGeneratedSerialDescriptor.addElement("atype", true);
        pluginGeneratedSerialDescriptor.addElement("vwidth", true);
        pluginGeneratedSerialDescriptor.addElement("vheight", true);
        pluginGeneratedSerialDescriptor.addElement("bitrate", true);
        pluginGeneratedSerialDescriptor.addElement("codec_type", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("file_id", true);
        pluginGeneratedSerialDescriptor.addElement("fps", true);
        pluginGeneratedSerialDescriptor.addElement("file_hash", true);
        pluginGeneratedSerialDescriptor.addElement("real_bitrate", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$Meta$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x009e. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.Meta m2617deserialize(Decoder decoder) {
        int i;
        int i2;
        String str;
        String str2;
        int i3;
        int i4;
        String str3;
        String str4;
        String str5;
        long j;
        String str6;
        String str7;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i7 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(descriptor2, 3);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 4);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 5);
            int decodeIntElement3 = beginStructure.decodeIntElement(descriptor2, 6);
            String decodeStringElement5 = beginStructure.decodeStringElement(descriptor2, 7);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 8);
            String decodeStringElement6 = beginStructure.decodeStringElement(descriptor2, 9);
            int decodeIntElement4 = beginStructure.decodeIntElement(descriptor2, 10);
            String decodeStringElement7 = beginStructure.decodeStringElement(descriptor2, 11);
            str2 = decodeStringElement;
            i2 = beginStructure.decodeIntElement(descriptor2, 12);
            str = decodeStringElement7;
            i4 = decodeIntElement4;
            str3 = decodeStringElement6;
            str6 = decodeStringElement5;
            i5 = decodeIntElement3;
            i = decodeIntElement2;
            str7 = decodeStringElement4;
            i6 = decodeIntElement;
            str4 = decodeStringElement3;
            str5 = decodeStringElement2;
            j = decodeLongElement;
            i3 = 8191;
        } else {
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            boolean z = true;
            int i8 = 0;
            int i9 = 0;
            i = 0;
            int i10 = 0;
            long j2 = 0;
            String str14 = null;
            int i11 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i7 |= 1;
                        str8 = beginStructure.decodeStringElement(descriptor2, 0);
                    case 1:
                        str13 = beginStructure.decodeStringElement(descriptor2, 1);
                        i7 |= 2;
                    case 2:
                        str12 = beginStructure.decodeStringElement(descriptor2, 2);
                        i7 |= 4;
                    case 3:
                        str11 = beginStructure.decodeStringElement(descriptor2, 3);
                        i7 |= 8;
                    case 4:
                        i10 = beginStructure.decodeIntElement(descriptor2, 4);
                        i7 |= 16;
                    case 5:
                        i = beginStructure.decodeIntElement(descriptor2, 5);
                        i7 |= 32;
                    case 6:
                        i9 = beginStructure.decodeIntElement(descriptor2, 6);
                        i7 |= 64;
                    case 7:
                        str10 = beginStructure.decodeStringElement(descriptor2, 7);
                        i7 |= 128;
                    case 8:
                        j2 = beginStructure.decodeLongElement(descriptor2, 8);
                        i7 |= 256;
                    case 9:
                        str9 = beginStructure.decodeStringElement(descriptor2, 9);
                        i7 |= 512;
                    case 10:
                        i8 = beginStructure.decodeIntElement(descriptor2, 10);
                        i7 |= 1024;
                    case 11:
                        str14 = beginStructure.decodeStringElement(descriptor2, 11);
                        i7 |= AnimationConstant.PROP_BOTTOM;
                    case 12:
                        i11 = beginStructure.decodeIntElement(descriptor2, 12);
                        i7 |= 4096;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i2 = i11;
            str = str14;
            str2 = str8;
            i3 = i7;
            long j3 = j2;
            i4 = i8;
            str3 = str9;
            str4 = str12;
            str5 = str13;
            j = j3;
            int i12 = i10;
            str6 = str10;
            str7 = str11;
            i5 = i9;
            i6 = i12;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.Meta(i3, str2, str5, str4, str7, i6, i, i5, str6, j, str3, i4, str, i2, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.Meta value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.Meta.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
