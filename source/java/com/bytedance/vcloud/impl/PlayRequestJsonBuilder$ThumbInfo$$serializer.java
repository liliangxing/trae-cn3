package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.impl.PlayRequestJsonBuilder;
import com.bytedance.webx.seclink.util.ReportUtil;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.ThumbInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$ThumbInfo;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$ThumbInfo$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.ThumbInfo> {
    public static final PlayRequestJsonBuilder$ThumbInfo$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$ThumbInfo$$serializer playRequestJsonBuilder$ThumbInfo$$serializer = new PlayRequestJsonBuilder$ThumbInfo$$serializer();
        INSTANCE = playRequestJsonBuilder$ThumbInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.ThumbInfo", playRequestJsonBuilder$ThumbInfo$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("img_num", false);
        pluginGeneratedSerialDescriptor.addElement("img_uri", false);
        pluginGeneratedSerialDescriptor.addElement("img_url", false);
        pluginGeneratedSerialDescriptor.addElement("img_x_size", false);
        pluginGeneratedSerialDescriptor.addElement("img_y_size", false);
        pluginGeneratedSerialDescriptor.addElement("img_x_len", false);
        pluginGeneratedSerialDescriptor.addElement("img_y_len", false);
        pluginGeneratedSerialDescriptor.addElement(ReportUtil.Params.DURATION, false);
        pluginGeneratedSerialDescriptor.addElement("interval", false);
        pluginGeneratedSerialDescriptor.addElement("fext", false);
        pluginGeneratedSerialDescriptor.addElement("img_urls", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$ThumbInfo$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = PlayRequestJsonBuilder.ThumbInfo.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, DoubleSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[10]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0091. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.ThumbInfo m2623deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        List list;
        int i4;
        String str3;
        double d;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        deserializationStrategyArr = PlayRequestJsonBuilder.ThumbInfo.$childSerializers;
        int i8 = 9;
        int i9 = 0;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 0);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 3);
            int decodeIntElement3 = beginStructure.decodeIntElement(descriptor2, 4);
            int decodeIntElement4 = beginStructure.decodeIntElement(descriptor2, 5);
            int decodeIntElement5 = beginStructure.decodeIntElement(descriptor2, 6);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(descriptor2, 7);
            int decodeIntElement6 = beginStructure.decodeIntElement(descriptor2, 8);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 9);
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 10, deserializationStrategyArr[10], (Object) null);
            i3 = decodeIntElement;
            str3 = decodeStringElement3;
            i = decodeIntElement6;
            i2 = decodeIntElement5;
            i5 = decodeIntElement4;
            i7 = decodeIntElement3;
            str = decodeStringElement;
            d = decodeDoubleElement;
            i6 = decodeIntElement2;
            i4 = 2047;
            str2 = decodeStringElement2;
        } else {
            boolean z = true;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            List list2 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            double d2 = 0.0d;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i8 = 9;
                    case 0:
                        i9 |= 1;
                        i10 = beginStructure.decodeIntElement(descriptor2, 0);
                        i8 = 9;
                    case 1:
                        str4 = beginStructure.decodeStringElement(descriptor2, 1);
                        i9 |= 2;
                        i8 = 9;
                    case 2:
                        str5 = beginStructure.decodeStringElement(descriptor2, 2);
                        i9 |= 4;
                    case 3:
                        i11 = beginStructure.decodeIntElement(descriptor2, 3);
                        i9 |= 8;
                    case 4:
                        i12 = beginStructure.decodeIntElement(descriptor2, 4);
                        i9 |= 16;
                    case 5:
                        i15 = beginStructure.decodeIntElement(descriptor2, 5);
                        i9 |= 32;
                    case 6:
                        i14 = beginStructure.decodeIntElement(descriptor2, 6);
                        i9 |= 64;
                    case 7:
                        d2 = beginStructure.decodeDoubleElement(descriptor2, 7);
                        i9 |= 128;
                    case 8:
                        i13 = beginStructure.decodeIntElement(descriptor2, 8);
                        i9 |= 256;
                    case 9:
                        str6 = beginStructure.decodeStringElement(descriptor2, i8);
                        i9 |= 512;
                    case 10:
                        list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 10, deserializationStrategyArr[10], list2);
                        i9 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i13;
            str = str4;
            i2 = i14;
            str2 = str5;
            int i16 = i9;
            i3 = i10;
            double d3 = d2;
            list = list2;
            i4 = i16;
            str3 = str6;
            d = d3;
            int i17 = i12;
            i5 = i15;
            i6 = i11;
            i7 = i17;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.ThumbInfo(i4, i3, str, str2, i6, i7, i5, i2, d, i, str3, list, null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.ThumbInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.ThumbInfo.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
