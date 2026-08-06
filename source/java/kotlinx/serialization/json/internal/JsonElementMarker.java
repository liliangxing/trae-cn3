package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: JsonElementMarker.kt */
@Metadata(m4d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m5d2 = {"Lkotlinx/serialization/json/internal/JsonElementMarker;", BuildConfig.FLAVOR, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "origin", "Lkotlinx/serialization/internal/ElementMarker;", "value", BuildConfig.FLAVOR, "isUnmarkedNull", "isUnmarkedNull$kotlinx_serialization_json", "()Z", "mark", BuildConfig.FLAVOR, ClassOf.INDEX, BuildConfig.FLAVOR, "mark$kotlinx_serialization_json", "nextUnmarkedIndex", "nextUnmarkedIndex$kotlinx_serialization_json", "readIfAbsent", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class JsonElementMarker {
    private boolean isUnmarkedNull;
    private final ElementMarker origin;

    public JsonElementMarker(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.origin = new ElementMarker(descriptor, new JsonElementMarker$origin$1(this));
    }

    /* renamed from: isUnmarkedNull$kotlinx_serialization_json, reason: from getter */
    public final boolean getIsUnmarkedNull() {
        return this.isUnmarkedNull;
    }

    public final void mark$kotlinx_serialization_json(int index) {
        this.origin.mark(index);
    }

    public final int nextUnmarkedIndex$kotlinx_serialization_json() {
        return this.origin.nextUnmarkedIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readIfAbsent(SerialDescriptor descriptor, int index) {
        boolean z = !descriptor.isElementOptional(index) && descriptor.getElementDescriptor(index).isNullable();
        this.isUnmarkedNull = z;
        return z;
    }
}
