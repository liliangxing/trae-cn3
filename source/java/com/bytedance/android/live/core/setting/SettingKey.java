package com.bytedance.android.live.core.setting;

import android.os.Looper;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SettingKey<T> {
    private final T debugValue;
    private final T defaultValue;
    private final String description;
    private boolean isOnlyRemote;
    private boolean isPreloadCache;
    private final String name;
    private final String[] option;
    private final boolean sticky;
    private final Type type;
    private T value;

    @Deprecated
    public SettingKey(String str, T t) {
        this(str, t, "");
    }

    @Deprecated
    public SettingKey(String str, T t, String str2) {
        this(str, str2, t, t);
    }

    public SettingKey(String str, Class<T> cls, String str2, boolean z) {
        this.name = str;
        this.description = str2;
        this.isOnlyRemote = z;
        this.type = cls;
        this.defaultValue = null;
        this.debugValue = null;
        this.option = null;
        this.sticky = false;
        this.isPreloadCache = false;
    }

    public SettingKey(String str, String str2, T t, Type type, boolean z, boolean z2) {
        this.name = str;
        this.description = str2;
        this.isOnlyRemote = z;
        this.type = type;
        this.defaultValue = t;
        this.debugValue = null;
        this.option = null;
        this.sticky = z2;
        this.isPreloadCache = false;
    }

    public SettingKey(String str, String str2, T t, Type type, boolean z, boolean z2, boolean z3) {
        this.name = str;
        this.description = str2;
        this.isOnlyRemote = z;
        this.type = type;
        this.defaultValue = t;
        this.debugValue = null;
        this.option = null;
        this.sticky = z2;
        this.isPreloadCache = z3;
    }

    public SettingKey(String str, String str2, T t, T t2) {
        this(str, (Class) t.getClass(), str2, (Object) t, (Object) t2, false, (String[]) null);
    }

    public SettingKey(String str, String str2, T t, T t2, boolean z) {
        this(str, t.getClass(), str2, t, t2, z, (String[]) null);
    }

    @Deprecated
    public SettingKey(String str, T t, String str2, String... strArr) {
        this(str, str2, t, t, strArr);
    }

    public SettingKey(String str, String str2, T t, T t2, String... strArr) {
        this(str, (Class) t.getClass(), str2, (Object) t, (Object) t2, false, strArr);
    }

    public SettingKey(String str, String str2, T t, T t2, boolean z, String... strArr) {
        this(str, t.getClass(), str2, t, t2, z, strArr);
    }

    @Deprecated
    public SettingKey(String str, Class<T> cls) {
        this(str, (Class) cls, "");
    }

    @Deprecated
    public SettingKey(String str, Class<T> cls, String str2) {
        this(str, cls, str2, (Object) null, (Object) null);
    }

    public SettingKey(String str, Class<T> cls, String str2, T t, T t2) {
        this(str, (Class) cls, str2, (Object) t, (Object) t2, false, (String[]) null);
    }

    public SettingKey(String str, Class<T> cls, String str2, T t, T t2, boolean z) {
        this(str, cls, str2, t, t2, z, (String[]) null);
    }

    private SettingKey(String str, Class<T> cls, String str2, T t, T t2, boolean z, String[] strArr) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = str;
        this.description = str2;
        this.defaultValue = t;
        this.debugValue = t2;
        this.type = cls;
        this.option = strArr;
        this.sticky = z;
    }

    public SettingKey(String str, Type type, T t) {
        this.isOnlyRemote = false;
        this.isPreloadCache = false;
        this.name = str;
        this.defaultValue = t;
        this.debugValue = t;
        this.type = type;
        this.description = null;
        this.option = null;
        this.sticky = false;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getOption() {
        return this.option;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public T getDebugValue() {
        return this.debugValue;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isSticky() {
        return this.sticky;
    }

    public boolean isOnlyRemote() {
        return this.isOnlyRemote;
    }

    public T getValue() {
        return getSpValue();
    }

    public SettingKey<T> setPreloadCache(boolean z) {
        this.isPreloadCache = z;
        return this;
    }

    public T getSpValue() {
        if (SettingUtil.sTestSettingCallback == null) {
            T t = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
            this.value = t;
            return t;
        }
        return getWarlockSpValue();
    }

    private T getWarlockSpValue() {
        if (SettingUtil.isDebugMode()) {
            return this.debugValue;
        }
        long nanoTime = System.nanoTime();
        this.value = (T) SettingUtil.getValue("key_ttlive_sdk_setting", this.name, this.type, this.defaultValue, this.value, this.sticky, this.isOnlyRemote, this.isPreloadCache);
        long convert = TimeUnit.MICROSECONDS.convert(System.nanoTime() - nanoTime, TimeUnit.NANOSECONDS);
        if (LiveSettingOldContext.isLocalTest()) {
            if (!LiveSettingOldContext.INSTANCE.isStopLog()) {
                LiveSettingOldContext.i("setting_yzw", "key= " + this.name + " time= " + convert + " type= " + this.type + " isMainThread = " + (Looper.myLooper() == Looper.getMainLooper()));
            }
            SettingUtil.sTestSettingCallback.callBackSetting(this.name, convert, this.type, this.value);
        }
        return this.value;
    }

    /* loaded from: classes2.dex */
    public static class Builder<T> {
        private T defaultValue;
        private String description;
        private String key;
        private Type type;
        private boolean sticky = false;
        private boolean isOnlyRemote = false;
        private boolean isPreloadCache = false;

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setDefaultValue(T t) {
            this.defaultValue = t;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setSticky(boolean z) {
            this.sticky = z;
            return this;
        }

        public Builder setOnlyRemote(boolean z) {
            this.isOnlyRemote = z;
            return this;
        }

        public Builder setPreloadCache(boolean z) {
            this.isPreloadCache = z;
            return this;
        }

        public SettingKey builder() {
            return new SettingKey(this.key, this.description, this.defaultValue, this.type, this.isOnlyRemote, this.sticky, this.isPreloadCache);
        }
    }
}
