package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonEncoder;

/* compiled from: AbsDtoKSerializer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/kmp/network/bridge/AbsDtoKSerializer;", "T", "Lkotlinx/serialization/KSerializer;", "serializer", "Lkotlin/Function1;", "", "desirializer", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDesirializer", "()Lkotlin/jvm/functions/Function1;", "getSerializer", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AbsDtoKSerializer<T> implements KSerializer<T> {
    private final SerialDescriptor descriptor;
    private final Function1<String, T> desirializer;
    private final Function1<T, String> serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public AbsDtoKSerializer(Function1<? super T, String> function1, Function1<? super String, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(function1, "serializer");
        Intrinsics.checkNotNullParameter(function12, "desirializer");
        this.serializer = function1;
        this.desirializer = function12;
        this.descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("proxy", PrimitiveKind.STRING.INSTANCE);
    }

    public final Function1<T, String> getSerializer() {
        return this.serializer;
    }

    public final Function1<String, T> getDesirializer() {
        return this.desirializer;
    }

    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        String str = (String) this.serializer.invoke(value);
        if (encoder instanceof JsonEncoder) {
            ((JsonEncoder) encoder).encodeJsonElement(Json.Default.parseToJsonElement(str));
            return;
        }
        throw new RuntimeException("AbsDtoKSerializer only support json");
    }

    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (decoder instanceof JsonDecoder) {
            T t = (T) this.desirializer.invoke(((JsonDecoder) decoder).decodeJsonElement().toString());
            if (t != null) {
                return t;
            }
            throw new RuntimeException("AbsDtoKSerializer got null");
        }
        throw new RuntimeException("AbsDtoKSerializer only support json");
    }
}
