package com.bytedance.ies.bullet.core.kit.setting;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.core.kit.setting.IKitSetting;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IKitSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/setting/KitSetting;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/bullet/core/kit/setting/IKitSetting;", "()V", "merge", "", PreloadConfig.KEY_OTHER, "useOthersOnConflict", "", "(Lcom/bytedance/ies/bullet/core/kit/setting/IKitSetting;Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class KitSetting<T extends IKitSetting<T>> implements IKitSetting<T> {
    @Override // com.bytedance.ies.bullet.core.kit.setting.IKitSetting
    public void merge(T other, boolean useOthersOnConflict) {
        IPropertySetter<?> value;
        Intrinsics.checkNotNullParameter(other, "other");
        for (Map.Entry<String, IPropertySetter<?>> entry : other.getProperties().entrySet()) {
            IPropertySetter<?> iPropertySetter = getProperties().get(entry.getKey());
            if (iPropertySetter != null && (value = entry.getValue()) != null) {
                iPropertySetter.merge(value, useOthersOnConflict);
            }
        }
    }
}
