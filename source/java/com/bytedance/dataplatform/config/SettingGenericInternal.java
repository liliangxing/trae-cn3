package com.bytedance.dataplatform.config;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.dataplatform.TypeWrapper;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExperimentEntityUtiil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086\bJ$\u0010\t\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0086\n¢\u0006\u0002\u0010\fJ*\u0010\t\u001a\u0002H\b\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u0002H\bH\u0086\n¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/dataplatform/config/SettingGenericInternal;", "", "isSticky", "", "(Z)V", "()Z", "genericType", "Ljava/lang/reflect/Type;", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "key", "", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public class SettingGenericInternal {
    private final boolean isSticky;

    public SettingGenericInternal(boolean z) {
        this.isSticky = z;
    }

    /* renamed from: isSticky, reason: from getter */
    public final boolean getIsSticky() {
        return this.isSticky;
    }

    public final /* synthetic */ <T> Type genericType() {
        Intrinsics.needClassReification();
        Type type = new TypeWrapper<T>() { // from class: com.bytedance.dataplatform.config.SettingGenericInternal$genericType$1
        }.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeWrapper<T>() {}.type");
        return type;
    }

    public final /* synthetic */ <T> T invoke(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.needClassReification();
        Type type = new TypeWrapper<T>() { // from class: com.bytedance.dataplatform.config.SettingGenericInternal$invoke$$inlined$genericType$1
        }.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeWrapper<T>() {}.type");
        return (T) ExperimentEntityUtiilKt.setting(key, type, null, getIsSticky());
    }

    public final /* synthetic */ <T> T invoke(String key, T defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        Intrinsics.needClassReification();
        Type type = new TypeWrapper<T>() { // from class: com.bytedance.dataplatform.config.SettingGenericInternal$invoke$$inlined$genericType$2
        }.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "object : TypeWrapper<T>() {}.type");
        T t = (T) ExperimentEntityUtiilKt.setting(key, type, defaultValue, getIsSticky());
        if (t == null) {
            Intrinsics.throwNpe();
        }
        return t;
    }
}
