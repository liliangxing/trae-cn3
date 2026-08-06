package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SavedStateDecoder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001a;\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n2\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"decodeFromSavedState", ExifInterface.GPS_DIRECTION_TRUE, "", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)Ljava/lang/Object;", "savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SavedStateDecoderKt {
    public static final <T> T decodeFromSavedState(DeserializationStrategy<? extends T> deserializationStrategy, Bundle bundle) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        return (T) decodeFromSavedState$default(deserializationStrategy, bundle, null, 4, null);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        Intrinsics.checkNotNullParameter(savedStateConfiguration, "configuration");
        SerializersModule serializersModule = savedStateConfiguration.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return decodeFromSavedState(SerializersKt.serializer(serializersModule, (KType) null), bundle, savedStateConfiguration);
    }

    public static final /* synthetic */ <T> T decodeFromSavedState(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        Intrinsics.checkNotNullParameter(savedStateConfiguration, "configuration");
        SerializersModule serializersModule = savedStateConfiguration.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return (T) decodeFromSavedState(SerializersKt.serializer(serializersModule, (KType) null), bundle, savedStateConfiguration);
    }

    public static /* synthetic */ Object decodeFromSavedState$default(DeserializationStrategy deserializationStrategy, Bundle bundle, SavedStateConfiguration savedStateConfiguration, int i, Object obj) {
        if ((i & 4) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return decodeFromSavedState(deserializationStrategy, bundle, savedStateConfiguration);
    }

    public static final <T> T decodeFromSavedState(DeserializationStrategy<? extends T> deserializationStrategy, Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        Intrinsics.checkNotNullParameter(savedStateConfiguration, "configuration");
        return (T) new SavedStateDecoder(bundle, savedStateConfiguration).decodeSerializableValue(deserializationStrategy);
    }
}
