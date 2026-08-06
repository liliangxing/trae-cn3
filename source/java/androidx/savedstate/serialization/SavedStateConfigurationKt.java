package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.serialization.SavedStateConfiguration;
import androidx.savedstate.serialization.serializers.MutableStateFlowSerializer;
import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleKt;

/* compiled from: SavedStateConfiguration.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SavedStateConfiguration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "from", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "DEFAULT_SERIALIZERS_MODULE", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SavedStateConfigurationKt {
    private static final SerializersModule DEFAULT_SERIALIZERS_MODULE;

    public static final SavedStateConfiguration SavedStateConfiguration(Function1<? super SavedStateConfiguration.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        return SavedStateConfiguration$default(null, function1, 1, null);
    }

    public static /* synthetic */ SavedStateConfiguration SavedStateConfiguration$default(SavedStateConfiguration savedStateConfiguration, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            savedStateConfiguration = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfiguration(savedStateConfiguration, function1);
    }

    public static final SavedStateConfiguration SavedStateConfiguration(SavedStateConfiguration savedStateConfiguration, Function1<? super SavedStateConfiguration.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(savedStateConfiguration, "from");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(savedStateConfiguration);
        function1.invoke(builder);
        return builder.build$savedstate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0(List list) {
        Intrinsics.checkNotNullParameter(list, "elementSerializers");
        return new MutableStateFlowSerializer((KSerializer) CollectionsKt.first(list));
    }

    static {
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        serializersModuleBuilder.contextual(Reflection.getOrCreateKotlinClass(Bundle.class), SavedStateSerializer.INSTANCE);
        serializersModuleBuilder.contextual(Reflection.getOrCreateKotlinClass(MutableStateFlow.class), new Function1() { // from class: androidx.savedstate.serialization.SavedStateConfigurationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                KSerializer DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0;
                DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0 = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0((List) obj);
                return DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0;
            }
        });
        DEFAULT_SERIALIZERS_MODULE = SerializersModuleKt.plus(serializersModuleBuilder.build(), SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform());
    }
}
