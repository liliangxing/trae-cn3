package com.bytedance.ies.bullet.core.kit.setting;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IKitSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0014\u001a\u00020\u0005H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00018\u00008V@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/setting/PropertySetter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/core/kit/setting/IPropertySetter;", "initProperty", "nullInitPropertyAsNotSet", "", "(Ljava/lang/Object;Z)V", "isSet", "()Z", "localIsSet", "value", "property", "getProperty", "()Ljava/lang/Object;", "setProperty", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "merge", "", PreloadConfig.KEY_OTHER, "useOthersOnConflict", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PropertySetter<T> implements IPropertySetter<T> {
    private boolean localIsSet;
    private T property;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PropertySetter() {
        this(r2, false, 3, r2);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }

    public PropertySetter(T t, boolean z) {
        boolean z2 = true;
        if (z && t == null) {
            z2 = false;
        }
        this.localIsSet = z2;
        this.property = t;
    }

    public /* synthetic */ PropertySetter(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? true : z);
    }

    @Override // com.bytedance.ies.bullet.core.kit.setting.IPropertySetter
    public T getProperty() {
        return this.property;
    }

    @Override // com.bytedance.ies.bullet.core.kit.setting.IPropertySetter
    public void setProperty(T t) {
        this.localIsSet = true;
        this.property = t;
    }

    @Override // com.bytedance.ies.bullet.core.kit.setting.IPropertySetter
    /* renamed from: isSet, reason: from getter */
    public boolean getLocalIsSet() {
        return this.localIsSet;
    }

    @Override // com.bytedance.ies.bullet.core.kit.setting.IPropertySetter
    public void merge(IPropertySetter<T> other, boolean useOthersOnConflict) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (getLocalIsSet()) {
            if (other.getLocalIsSet() && useOthersOnConflict) {
                setProperty(other.getProperty());
                return;
            }
            return;
        }
        if (other.getLocalIsSet()) {
            setProperty(other.getProperty());
        }
    }
}
