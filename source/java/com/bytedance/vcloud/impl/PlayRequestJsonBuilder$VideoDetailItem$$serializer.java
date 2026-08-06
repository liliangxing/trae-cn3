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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.VideoDetailItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$VideoDetailItem;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$VideoDetailItem$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.VideoDetailItem> {
    public static final PlayRequestJsonBuilder$VideoDetailItem$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$VideoDetailItem$$serializer playRequestJsonBuilder$VideoDetailItem$$serializer = new PlayRequestJsonBuilder$VideoDetailItem$$serializer();
        INSTANCE = playRequestJsonBuilder$VideoDetailItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.VideoDetailItem", playRequestJsonBuilder$VideoDetailItem$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("url_list", false);
        pluginGeneratedSerialDescriptor.addElement("fallback_url", true);
        pluginGeneratedSerialDescriptor.addElement("quality_type", true);
        pluginGeneratedSerialDescriptor.addElement("video_meta", true);
        pluginGeneratedSerialDescriptor.addElement("audio_meta", true);
        pluginGeneratedSerialDescriptor.addElement("base_range_info", true);
        pluginGeneratedSerialDescriptor.addElement("check_info", true);
        pluginGeneratedSerialDescriptor.addElement("encrypt_info", true);
        pluginGeneratedSerialDescriptor.addElement("uni_video_info_ext", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$VideoDetailItem$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = PlayRequestJsonBuilder.VideoDetailItem.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$Meta$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$Meta$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a0. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.VideoDetailItem m2627deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        PlayRequestJsonBuilder.UniVideoInfoExt uniVideoInfoExt;
        List list;
        PlayRequestJsonBuilder.RangeInfo rangeInfo;
        Integer num;
        PlayRequestJsonBuilder.EncryptInfo encryptInfo;
        String str;
        PlayRequestJsonBuilder.CheckInfo checkInfo;
        int i;
        PlayRequestJsonBuilder.Meta meta;
        PlayRequestJsonBuilder.Meta meta2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        deserializationStrategyArr = PlayRequestJsonBuilder.VideoDetailItem.$childSerializers;
        int i2 = 7;
        List list2 = null;
        if (beginStructure.decodeSequentially()) {
            List list3 = (List) beginStructure.decodeSerializableElement(descriptor2, 0, deserializationStrategyArr[0], (Object) null);
            String str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.Meta meta3 = (PlayRequestJsonBuilder.Meta) beginStructure.decodeNullableSerializableElement(descriptor2, 3, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.Meta meta4 = (PlayRequestJsonBuilder.Meta) beginStructure.decodeNullableSerializableElement(descriptor2, 4, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.RangeInfo rangeInfo2 = (PlayRequestJsonBuilder.RangeInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 5, PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE, (Object) null);
            PlayRequestJsonBuilder.CheckInfo checkInfo2 = (PlayRequestJsonBuilder.CheckInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 6, PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE, (Object) null);
            encryptInfo = (PlayRequestJsonBuilder.EncryptInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 7, PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE, (Object) null);
            checkInfo = checkInfo2;
            rangeInfo = rangeInfo2;
            uniVideoInfoExt = (PlayRequestJsonBuilder.UniVideoInfoExt) beginStructure.decodeNullableSerializableElement(descriptor2, 8, PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE, (Object) null);
            meta = meta4;
            list = list3;
            str = str2;
            meta2 = meta3;
            i = 511;
        } else {
            boolean z = true;
            int i3 = 0;
            PlayRequestJsonBuilder.UniVideoInfoExt uniVideoInfoExt2 = null;
            PlayRequestJsonBuilder.CheckInfo checkInfo3 = null;
            PlayRequestJsonBuilder.EncryptInfo encryptInfo2 = null;
            PlayRequestJsonBuilder.RangeInfo rangeInfo3 = null;
            PlayRequestJsonBuilder.Meta meta5 = null;
            PlayRequestJsonBuilder.Meta meta6 = null;
            String str3 = null;
            Integer num2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 0, deserializationStrategyArr[0], list2);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str3);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num2);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        meta6 = (PlayRequestJsonBuilder.Meta) beginStructure.decodeNullableSerializableElement(descriptor2, 3, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, meta6);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        meta5 = (PlayRequestJsonBuilder.Meta) beginStructure.decodeNullableSerializableElement(descriptor2, 4, PlayRequestJsonBuilder$Meta$$serializer.INSTANCE, meta5);
                        i3 |= 16;
                        i2 = 7;
                    case 5:
                        rangeInfo3 = (PlayRequestJsonBuilder.RangeInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 5, PlayRequestJsonBuilder$RangeInfo$$serializer.INSTANCE, rangeInfo3);
                        i3 |= 32;
                        i2 = 7;
                    case 6:
                        checkInfo3 = (PlayRequestJsonBuilder.CheckInfo) beginStructure.decodeNullableSerializableElement(descriptor2, 6, PlayRequestJsonBuilder$CheckInfo$$serializer.INSTANCE, checkInfo3);
                        i3 |= 64;
                        i2 = 7;
                    case 7:
                        encryptInfo2 = (PlayRequestJsonBuilder.EncryptInfo) beginStructure.decodeNullableSerializableElement(descriptor2, i2, PlayRequestJsonBuilder$EncryptInfo$$serializer.INSTANCE, encryptInfo2);
                        i3 |= 128;
                    case 8:
                        uniVideoInfoExt2 = (PlayRequestJsonBuilder.UniVideoInfoExt) beginStructure.decodeNullableSerializableElement(descriptor2, 8, PlayRequestJsonBuilder$UniVideoInfoExt$$serializer.INSTANCE, uniVideoInfoExt2);
                        i3 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            uniVideoInfoExt = uniVideoInfoExt2;
            list = list2;
            rangeInfo = rangeInfo3;
            num = num2;
            encryptInfo = encryptInfo2;
            str = str3;
            checkInfo = checkInfo3;
            i = i3;
            PlayRequestJsonBuilder.Meta meta7 = meta6;
            meta = meta5;
            meta2 = meta7;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.VideoDetailItem(i, list, str, num, meta2, meta, rangeInfo, checkInfo, encryptInfo, uniVideoInfoExt, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.VideoDetailItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.VideoDetailItem.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
