package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import net.openid.appauth.BuildConfig;

/* compiled from: MonthSerializers.kt */
@Metadata(m4d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a9\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, m5d2 = {"createEnumSerializer", "Lkotlinx/serialization/KSerializer;", "E", BuildConfig.FLAVOR, "serialName", BuildConfig.FLAVOR, "values", BuildConfig.FLAVOR, "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "kotlinx-datetime_release"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class MonthSerializersKt {
    public static final <E extends Enum<E>> KSerializer<E> createEnumSerializer(String serialName, E[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(serialName, values);
    }
}
