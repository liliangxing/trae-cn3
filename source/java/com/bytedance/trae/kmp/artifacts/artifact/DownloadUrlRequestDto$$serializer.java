package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.push.api.PushConst;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlRequestDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class DownloadUrlRequestDto$$serializer implements GeneratedSerializer<DownloadUrlRequestDto> {
    public static final int $stable;
    public static final DownloadUrlRequestDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private DownloadUrlRequestDto$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DownloadUrlRequestDto$$serializer downloadUrlRequestDto$$serializer = new DownloadUrlRequestDto$$serializer();
        INSTANCE = downloadUrlRequestDto$$serializer;
        $stable = 8;
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.trae.kmp.artifacts.artifact.DownloadUrlRequestDto", downloadUrlRequestDto$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("targets", false);
        pluginGeneratedSerialDescriptor.addElement(PushConst.PUSH_KEY_CONVERSATION_ID, false);
        pluginGeneratedSerialDescriptor.addElement(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID, false);
        pluginGeneratedSerialDescriptor.addElement("check_exist", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = DownloadUrlRequestDto.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final DownloadUrlRequestDto m854deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        boolean z;
        int i;
        List list;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        deserializationStrategyArr = DownloadUrlRequestDto.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            List list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, deserializationStrategyArr[0], (Object) null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            list = list2;
            str = decodeStringElement;
            z = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            str2 = decodeStringElement2;
            i = 15;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            List list3 = null;
            String str3 = null;
            String str4 = null;
            int i2 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z2 = false;
                } else if (decodeElementIndex == 0) {
                    list3 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, deserializationStrategyArr[0], list3);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    str3 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    z3 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            z = z3;
            i = i2;
            list = list3;
            str = str3;
            str2 = str4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DownloadUrlRequestDto(i, list, str, str2, z, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, DownloadUrlRequestDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DownloadUrlRequestDto.write$Self$artifacts_mainlandRelease(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
