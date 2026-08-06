package com.bytedance.ies.bullet.core.kit.setting;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: IKitSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00018\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/setting/IPropertySetter;", ExifInterface.GPS_DIRECTION_TRUE, "", "isSet", "", "()Z", "property", "getProperty", "()Ljava/lang/Object;", "setProperty", "(Ljava/lang/Object;)V", "merge", "", PreloadConfig.KEY_OTHER, "useOthersOnConflict", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPropertySetter<T> {
    T getProperty();

    boolean isSet();

    void merge(IPropertySetter<T> other, boolean useOthersOnConflict);

    void setProperty(T t);

    /* compiled from: IKitSetting.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void merge$default(IPropertySetter iPropertySetter, IPropertySetter iPropertySetter2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: merge");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iPropertySetter.merge(iPropertySetter2, z);
        }
    }
}
