package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlinx.datetime.internal.format.Accessor;
import net.openid.appauth.BuildConfig;

/* compiled from: FieldSpec.kt */
@Metadata(m4d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, m5d2 = {"Lkotlinx/datetime/internal/format/PropertyAccessor;", "Object", "Field", "Lkotlinx/datetime/internal/format/Accessor;", "property", "Lkotlin/reflect/KMutableProperty1;", "<init>", "(Lkotlin/reflect/KMutableProperty1;)V", "name", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "trySetWithoutReassigning", "container", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getter", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class PropertyAccessor<Object, Field> implements Accessor<Object, Field> {
    private final KMutableProperty1<Object, Field> property;

    public PropertyAccessor(KMutableProperty1<Object, Field> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.property = property;
    }

    @Override // kotlinx.datetime.internal.format.Accessor
    public Field getterNotNull(Object object) {
        return (Field) Accessor.DefaultImpls.getterNotNull(this, object);
    }

    @Override // kotlinx.datetime.internal.format.parser.AssignableField
    public String getName() {
        return this.property.getName();
    }

    @Override // kotlinx.datetime.internal.format.parser.AssignableField
    public Field trySetWithoutReassigning(Object container, Field newValue) {
        Field field = this.property.get(container);
        if (field == null) {
            this.property.set(container, newValue);
        } else if (!Intrinsics.areEqual(field, newValue)) {
            return field;
        }
        return null;
    }

    @Override // kotlinx.datetime.internal.format.Accessor
    public Field getter(Object container) {
        return this.property.get(container);
    }
}
