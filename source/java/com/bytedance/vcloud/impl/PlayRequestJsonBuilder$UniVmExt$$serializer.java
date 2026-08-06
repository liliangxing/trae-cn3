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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: PlayRequestJsonBuilder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/bytedance/vcloud/impl/PlayRequestJsonBuilder.UniVmExt.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/vcloud/impl/PlayRequestJsonBuilder$UniVmExt;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", CustomDataTagHandler.VALUE_ATTRIBUTE, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PlayRequestJsonBuilder$UniVmExt$$serializer implements GeneratedSerializer<PlayRequestJsonBuilder.UniVmExt> {
    public static final PlayRequestJsonBuilder$UniVmExt$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlayRequestJsonBuilder$UniVmExt$$serializer playRequestJsonBuilder$UniVmExt$$serializer = new PlayRequestJsonBuilder$UniVmExt$$serializer();
        INSTANCE = playRequestJsonBuilder$UniVmExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.vcloud.impl.PlayRequestJsonBuilder.UniVmExt", playRequestJsonBuilder$UniVmExt$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("source_id", false);
        pluginGeneratedSerialDescriptor.addElement("log_label", false);
        pluginGeneratedSerialDescriptor.addElement("url_expired_ts", false);
        pluginGeneratedSerialDescriptor.addElement("source_type", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlayRequestJsonBuilder$UniVmExt$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public PlayRequestJsonBuilder.UniVmExt m2626deserialize(Decoder decoder) {
        String str;
        int i;
        int i2;
        String str2;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 1);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 2);
            str = decodeStringElement;
            i = beginStructure.decodeIntElement(descriptor2, 3);
            i2 = 15;
            str2 = decodeStringElement2;
            j = decodeLongElement;
        } else {
            String str3 = null;
            String str4 = null;
            boolean z = true;
            long j2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    str3 = beginStructure.decodeStringElement(descriptor2, 0);
                    i4 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(descriptor2, 1);
                    i4 |= 2;
                } else if (decodeElementIndex == 2) {
                    j2 = beginStructure.decodeLongElement(descriptor2, 2);
                    i4 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    i3 = beginStructure.decodeIntElement(descriptor2, 3);
                    i4 |= 8;
                }
            }
            str = str3;
            i = i3;
            i2 = i4;
            str2 = str4;
            j = j2;
        }
        beginStructure.endStructure(descriptor2);
        return new PlayRequestJsonBuilder.UniVmExt(i2, str, str2, j, i, null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, PlayRequestJsonBuilder.UniVmExt value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, CustomDataTagHandler.VALUE_ATTRIBUTE);
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PlayRequestJsonBuilder.UniVmExt.write$Self$uniplayer_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
