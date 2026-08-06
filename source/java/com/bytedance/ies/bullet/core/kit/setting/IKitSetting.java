package com.bytedance.ies.bullet.core.kit.setting;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.core.kit.setting.IKitSetting;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IKitSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eR\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/setting/IKitSetting;", ExifInterface.GPS_DIRECTION_TRUE, "", "properties", "", "", "Lcom/bytedance/ies/bullet/core/kit/setting/IPropertySetter;", "getProperties", "()Ljava/util/Map;", "merge", "", PreloadConfig.KEY_OTHER, "useOthersOnConflict", "", "(Lcom/bytedance/ies/bullet/core/kit/setting/IKitSetting;Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IKitSetting<T extends IKitSetting<T>> {
    Map<String, IPropertySetter<?>> getProperties();

    void merge(T other, boolean useOthersOnConflict);

    /* compiled from: IKitSetting.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void merge$default(IKitSetting iKitSetting, IKitSetting iKitSetting2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: merge");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iKitSetting.merge(iKitSetting2, z);
        }
    }
}
