package kotlinx.serialization.json.internal;

import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElementKt;
import net.openid.appauth.BuildConfig;

/* compiled from: StreamingJsonEncoder.kt */
@Metadata(m4d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, m5d2 = {"unsignedNumberDescriptors", BuildConfig.FLAVOR, "Lkotlinx/serialization/descriptors/SerialDescriptor;", "isUnsignedNumber", BuildConfig.FLAVOR, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnquotedLiteral", "kotlinx-serialization-json"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class StreamingJsonEncoderKt {
    private static final Set<SerialDescriptor> unsignedNumberDescriptors = SetsKt.setOf((Object[]) new SerialDescriptor[]{BuiltinSerializersKt.serializer(UInt.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(ULong.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(UByte.INSTANCE).getDescriptor(), BuiltinSerializersKt.serializer(UShort.INSTANCE).getDescriptor()});

    public static final boolean isUnsignedNumber(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && unsignedNumberDescriptors.contains(serialDescriptor);
    }

    public static final boolean isUnquotedLiteral(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return serialDescriptor.getIsInline() && Intrinsics.areEqual(serialDescriptor, JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }
}
