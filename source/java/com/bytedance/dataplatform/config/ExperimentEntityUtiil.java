package com.bytedance.dataplatform.config;

import android.text.TextUtils;
import com.bytedance.dataplatform.ExperimentEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExperimentEntityUtiil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/dataplatform/config/ExperimentEntityUtiil;", "", "()V", "generateSettingKey", "Lcom/bytedance/dataplatform/ExperimentEntity;", "o", "sp", "Lcom/bytedance/dataplatform/config/SettingPanel;", "getExperimentEntityList", "", "className", "", "experiment_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ExperimentEntityUtiil {
    public static final ExperimentEntityUtiil INSTANCE = new ExperimentEntityUtiil();

    private ExperimentEntityUtiil() {
    }

    @JvmStatic
    public static final Set<ExperimentEntity> getExperimentEntityList(String className) {
        HashSet hashSet;
        Object obj;
        Intrinsics.checkParameterIsNotNull(className, "className");
        synchronized (ExperimentEntityUtiilKt.getLockObject()) {
            ExperimentEntityUtiilKt.setCollecting(true);
            HashSet hashSet2 = new HashSet();
            try {
                Class<?> cls = Class.forName(className);
                Intrinsics.checkExpressionValueIsNotNull(cls, "clazz");
                Field[] fields = cls.getFields();
                int length = fields.length;
                int i = 0;
                while (true) {
                    Object obj2 = null;
                    if (i >= length) {
                        break;
                    }
                    Field field = fields[i];
                    try {
                        Intrinsics.checkExpressionValueIsNotNull(field, "field");
                        if (Modifier.isStatic(field.getModifiers())) {
                            try {
                                obj2 = field.get(null);
                            } catch (Throwable unused) {
                            }
                            ExperimentEntity generateSettingKey = INSTANCE.generateSettingKey(obj2, (SettingPanel) field.getAnnotation(SettingPanel.class));
                            if (generateSettingKey != null) {
                                hashSet2.add(generateSettingKey);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    i++;
                }
                for (Method method : cls.getMethods()) {
                    try {
                        SettingPanel settingPanel = (SettingPanel) method.getAnnotation(SettingPanel.class);
                        if (settingPanel != null) {
                            try {
                                obj = cls.getField("INSTANCE").get(cls);
                            } catch (Throwable unused3) {
                                obj = null;
                            }
                            method.invoke(obj, new Object[0]);
                            String lastKey = ExperimentEntityUtiilKt.getLastKey();
                            Type lastType = ExperimentEntityUtiilKt.getLastType();
                            Object lastDefault = ExperimentEntityUtiilKt.getLastDefault();
                            String value = settingPanel.value();
                            String[] option = settingPanel.option();
                            hashSet2.add(new ExperimentEntity(lastKey, lastType, lastDefault, value, (String[]) Arrays.copyOf(option, option.length)));
                        }
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable unused5) {
            }
            ExperimentEntityUtiilKt.setCollecting(false);
            hashSet = hashSet2;
        }
        return hashSet;
    }

    private final ExperimentEntity generateSettingKey(Object o, SettingPanel sp) {
        if (o instanceof ExperimentKey) {
            if (sp == null) {
                return null;
            }
            ExperimentKey experimentKey = (ExperimentKey) o;
            String key = experimentKey.getKey();
            Type type = experimentKey.getType();
            Object defaultValue = experimentKey.getDefaultValue();
            String value = sp.value();
            String[] option = sp.option();
            return new ExperimentEntity(key, type, defaultValue, value, (String[]) Arrays.copyOf(option, option.length));
        }
        if (o == null) {
            try {
                Intrinsics.throwNpe();
            } catch (Throwable unused) {
                return null;
            }
        }
        Class<?> cls = o.getClass();
        Field declaredField = cls.getDeclaredField("description");
        Intrinsics.checkExpressionValueIsNotNull(declaredField, "fieldDescription");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(o);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Field declaredField2 = cls.getDeclaredField("name");
        Intrinsics.checkExpressionValueIsNotNull(declaredField2, "fieldName");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(o);
        if (obj2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        String str2 = (String) obj2;
        Field declaredField3 = cls.getDeclaredField("defaultValue");
        Intrinsics.checkExpressionValueIsNotNull(declaredField3, "fieldDefaultValue");
        declaredField3.setAccessible(true);
        Object obj3 = declaredField3.get(o);
        Field declaredField4 = cls.getDeclaredField("option");
        Intrinsics.checkExpressionValueIsNotNull(declaredField4, "fieldOption");
        declaredField4.setAccessible(true);
        Object obj4 = declaredField4.get(o);
        if (!(obj4 instanceof String[])) {
            obj4 = null;
        }
        String[] strArr = (String[]) obj4;
        if (strArr == null) {
            strArr = new String[0];
        }
        Field declaredField5 = cls.getDeclaredField("type");
        Intrinsics.checkExpressionValueIsNotNull(declaredField5, "fieldType");
        declaredField5.setAccessible(true);
        Object obj5 = declaredField5.get(o);
        if (obj5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.Type");
        }
        return new ExperimentEntity(str2, (Type) obj5, obj3, str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
