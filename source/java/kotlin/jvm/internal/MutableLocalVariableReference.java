package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;
import net.openid.appauth.BuildConfig;

/* compiled from: localVariableReferences.kt */
@Metadata(m4d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, m5d2 = {"Lkotlin/jvm/internal/MutableLocalVariableReference;", "Lkotlin/jvm/internal/MutablePropertyReference0;", "<init>", "()V", "getOwner", "Lkotlin/reflect/KDeclarationContainer;", "get", BuildConfig.FLAVOR, "set", BuildConfig.FLAVOR, "value", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class MutableLocalVariableReference extends MutablePropertyReference0 {
    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object value) {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }
}
