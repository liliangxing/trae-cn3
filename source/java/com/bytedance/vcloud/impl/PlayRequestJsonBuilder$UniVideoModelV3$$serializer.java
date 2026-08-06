package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.impl.PlayRequestJsonBuilder;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.UniVideoModelV3.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVideoModelV3;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$UniVideoModelV3$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.UniVideoModelV3> {
    public static final PlayRequestJsonBuilder$UniVideoModelV3$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$UniVideoModelV3$$serializer playRequestJsonBuilder$UniVideoModelV3$$serializer = new PlayRequestJsonBuilder$UniVideoModelV3$$serializer();
        INSTANCE = playRequestJsonBuilder$UniVideoModelV3$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.UniVideoModelV3", playRequestJsonBuilder$UniVideoModelV3$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("video_id", false);
        pluginGeneratedSerialDescriptor.addElement("video_duration", false);
        pluginGeneratedSerialDescriptor.addElement("media_type", false);
        pluginGeneratedSerialDescriptor.addElement("uni_vm_ext", false);
        pluginGeneratedSerialDescriptor.addElement("volume", false);
        pluginGeneratedSerialDescriptor.addElement("big_thumbs", true);
        pluginGeneratedSerialDescriptor.addElement("dynamic_video", true);
        pluginGeneratedSerialDescriptor.addElement("video_list", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$UniVideoModelV3$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = PlayRequestJsonBuilder.UniVideoModelV3.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE, PlayRequestJsonBuilder$Volume$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[7])};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x007f. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.UniVideoModelV3 m2625deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        List list;
        int i;
        PlayRequestJsonBuilder.DynamicVideo dynamicVideo;
        PlayRequestJsonBuilder.ThumbInfo thumbInfo;
        PlayRequestJsonBuilder.Volume volume;
        String str;
        double d;
        PlayRequestJsonBuilder.UniVmExt uniVmExt;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        deserializationStrategyArr = PlayRequestJsonBuilder.UniVideoModelV3.$childSerializers;
        int i2 = 6;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(descriptor2, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            PlayRequestJsonBuilder.UniVmExt uniVmExt2 = (PlayRequestJsonBuilder.UniVmExt) beginStructure.decodeSerializableElement(descriptor2, 3, PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.Volume volume2 = (PlayRequestJsonBuilder.Volume) beginStructure.decodeSerializableElement(descriptor2, 4, PlayRequestJsonBuilder$Volume$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.ThumbInfo thumbInfo2 = (PlayRequestJsonBuilder.ThumbInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 5, PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.DynamicVideo dynamicVideo2 = (PlayRequestJsonBuilder.DynamicVideo) beginStructure.decodeNullableSerializableElement(descriptor2, 6, PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, deserializationStrategyArr[7], (Object) null);
            dynamicVideo = dynamicVideo2;
            thumbInfo = thumbInfo2;
            uniVmExt = uniVmExt2;
            volume = volume2;
            i = 255;
            d = decodeDoubleElement;
            str2 = decodeStringElement2;
            str = decodeStringElement;
        } else {
            double d2 = 0.0d;
            boolean z = true;
            int i3 = 0;
            PlayRequestJsonBuilder.DynamicVideo dynamicVideo3 = null;
            List list2 = null;
            PlayRequestJsonBuilder.ThumbInfo thumbInfo3 = null;
            PlayRequestJsonBuilder.Volume volume3 = null;
            PlayRequestJsonBuilder.UniVmExt uniVmExt3 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i3 |= 1;
                        str3 = beginStructure.decodeStringElement(descriptor2, 0);
                        i2 = 6;
                    case 1:
                        i3 |= 2;
                        d2 = beginStructure.decodeDoubleElement(descriptor2, 1);
                        i2 = 6;
                    case 2:
                        str4 = beginStructure.decodeStringElement(descriptor2, 2);
                        i3 |= 4;
                        i2 = 6;
                    case 3:
                        uniVmExt3 = (PlayRequestJsonBuilder.UniVmExt) beginStructure.decodeSerializableElement(descriptor2, 3, PlayRequestJsonBuilder$UniVmExt$$serializer.INSTANCE, uniVmExt3);
                        i3 |= 8;
                        i2 = 6;
                    case 4:
                        volume3 = (PlayRequestJsonBuilder.Volume) beginStructure.decodeSerializableElement(descriptor2, 4, PlayRequestJsonBuilder$Volume$$serializer.INSTANCE, volume3);
                        i3 |= 16;
                        i2 = 6;
                    case 5:
                        thumbInfo3 = (PlayRequestJsonBuilder.ThumbInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 5, PlayRequestJsonBuilder$ThumbInfo$$serializer.INSTANCE, thumbInfo3);
                        i3 |= 32;
                        i2 = 6;
                    case 6:
                        dynamicVideo3 = (PlayRequestJsonBuilder.DynamicVideo) beginStructure.decodeNullableSerializableElement(descriptor2, i2, PlayRequestJsonBuilder$DynamicVideo$$serializer.INSTANCE, dynamicVideo3);
                        i3 |= 64;
                    case 7:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, deserializationStrategyArr[7], list2);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            i = i3;
            String str5 = str4;
            dynamicVideo = dynamicVideo3;
            double d3 = d2;
            thumbInfo = thumbInfo3;
            volume = volume3;
            str = str3;
            d = d3;
            uniVmExt = uniVmExt3;
            str2 = str5;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.UniVideoModelV3(i, str, d, str2, uniVmExt, volume, thumbInfo, dynamicVideo, list, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.UniVideoModelV3 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.UniVideoModelV3.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
