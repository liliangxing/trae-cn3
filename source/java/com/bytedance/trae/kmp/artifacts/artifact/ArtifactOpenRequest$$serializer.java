package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ArtifactModels.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class ArtifactOpenRequest$$serializer implements GeneratedSerializer<ArtifactOpenRequest> {
    public static final int $stable;
    public static final ArtifactOpenRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private ArtifactOpenRequest$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ArtifactOpenRequest$$serializer artifactOpenRequest$$serializer = new ArtifactOpenRequest$$serializer();
        INSTANCE = artifactOpenRequest$$serializer;
        $stable = 8;
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest", artifactOpenRequest$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("artifactId", false);
        pluginGeneratedSerialDescriptor.addElement("kind", false);
        pluginGeneratedSerialDescriptor.addElement("filePath", false);
        pluginGeneratedSerialDescriptor.addElement("lastFrameUri", false);
        pluginGeneratedSerialDescriptor.addElement("durationSeconds", false);
        pluginGeneratedSerialDescriptor.addElement("fileAction", false);
        pluginGeneratedSerialDescriptor.addElement("conversationId", false);
        pluginGeneratedSerialDescriptor.addElement("messageId", false);
        pluginGeneratedSerialDescriptor.addElement("cliConversationId", false);
        pluginGeneratedSerialDescriptor.addElement("cliType", false);
        pluginGeneratedSerialDescriptor.addElement("turnId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ArtifactOpenRequest.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, kSerializerArr[1], StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x009d. Please report as an issue. */
    /* renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public final ArtifactOpenRequest m846deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        String str7;
        int i2;
        ArtifactKind artifactKind;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        deserializationStrategyArr = ArtifactOpenRequest.$childSerializers;
        int i3 = 10;
        int i4 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            ArtifactKind artifactKind2 = (ArtifactKind) beginStructure.decodeSerializableElement(serialDescriptor, 1, deserializationStrategyArr[1], (Object) null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 9);
            i2 = 2047;
            artifactKind = artifactKind2;
            str8 = decodeStringElement;
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str4 = decodeStringElement6;
            str2 = decodeStringElement4;
            str = decodeStringElement3;
            str6 = str11;
            str7 = str10;
            str3 = decodeStringElement5;
            i = decodeIntElement;
            str9 = decodeStringElement2;
        } else {
            boolean z = true;
            int i5 = 0;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            ArtifactKind artifactKind3 = null;
            int i6 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 9;
                    case 0:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i6 |= 1;
                        i3 = 10;
                        i4 = 9;
                    case 1:
                        artifactKind3 = (ArtifactKind) beginStructure.decodeSerializableElement(serialDescriptor, 1, deserializationStrategyArr[1], artifactKind3);
                        i6 |= 2;
                        i3 = 10;
                        i4 = 9;
                    case 2:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                        i3 = 10;
                        i4 = 9;
                    case 3:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i6 |= 8;
                        i3 = 10;
                        i4 = 9;
                    case 4:
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i6 |= 16;
                    case 5:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str13);
                        i6 |= 32;
                    case 6:
                        str = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i6 |= 64;
                    case 7:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i6 |= 128;
                    case 8:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                    case 9:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= 512;
                    case 10:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str12);
                        i6 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i5;
            str5 = str12;
            str6 = str13;
            String str17 = str16;
            str7 = str14;
            i2 = i6;
            artifactKind = artifactKind3;
            str8 = str15;
            str9 = str17;
        }
        beginStructure.endStructure(serialDescriptor);
        return new ArtifactOpenRequest(i2, str8, artifactKind, str9, str7, i, str6, str, str2, str3, str4, str5, null);
    }

    public final void serialize(Encoder encoder, ArtifactOpenRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        ArtifactOpenRequest.write$Self$artifacts_mainlandRelease(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
