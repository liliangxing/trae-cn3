package com.bytedance.ies.bullet.kit.web;

import com.bytedance.ies.bullet.core.kit.setting.IPropertySetter;
import com.bytedance.ies.bullet.core.kit.setting.KitSetting;
import com.bytedance.ies.bullet.core.kit.setting.PropertySetter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IWebKitSettingsProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/CustomWebSettings;", "Lcom/bytedance/ies/bullet/core/kit/setting/KitSetting;", "hardwareAcceleration", "", "longClickable", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "hardwareAccelerationProperty", "Lcom/bytedance/ies/bullet/core/kit/setting/IPropertySetter;", "getHardwareAccelerationProperty", "()Lcom/bytedance/ies/bullet/core/kit/setting/IPropertySetter;", "longClickableProperty", "getLongClickableProperty", "properties", "", "", "getProperties", "()Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CustomWebSettings extends KitSetting<CustomWebSettings> {
    private final IPropertySetter<Boolean> hardwareAccelerationProperty;
    private final IPropertySetter<Boolean> longClickableProperty;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CustomWebSettings() {
        this(r0, r0, 3, r0);
        Boolean bool = null;
    }

    public /* synthetic */ CustomWebSettings(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
    }

    public CustomWebSettings(Boolean bool, Boolean bool2) {
        this.hardwareAccelerationProperty = new PropertySetter(bool, false, 2, null);
        this.longClickableProperty = new PropertySetter(bool2, false, 2, null);
    }

    public final IPropertySetter<Boolean> getHardwareAccelerationProperty() {
        return this.hardwareAccelerationProperty;
    }

    public final IPropertySetter<Boolean> getLongClickableProperty() {
        return this.longClickableProperty;
    }

    @Override // com.bytedance.ies.bullet.core.kit.setting.IKitSetting
    public Map<String, IPropertySetter<?>> getProperties() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("hardwareAcceleration", this.hardwareAccelerationProperty), TuplesKt.to("longClickable", this.longClickableProperty)});
    }
}
