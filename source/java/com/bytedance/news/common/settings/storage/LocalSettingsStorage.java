package com.bytedance.news.common.settings.storage;

import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.internal.AllLocalSettingsDataCache;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class LocalSettingsStorage implements Storage {
    private AllLocalSettingsDataCache mAllLocalSettingsDataCache = AllLocalSettingsDataCache.getInstance();
    private Storage mOriginalStorage;
    private String mStorageKey;

    public LocalSettingsStorage(String str, Storage storage) {
        this.mOriginalStorage = storage;
        this.mStorageKey = str;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putString(String str, String str2) {
        this.mOriginalStorage.putString(str, str2);
        this.mAllLocalSettingsDataCache.putString(str, str2);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putInt(String str, int i) {
        this.mOriginalStorage.putInt(str, i);
        this.mAllLocalSettingsDataCache.putInt(str, i);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putLong(String str, long j) {
        this.mOriginalStorage.putLong(str, j);
        this.mAllLocalSettingsDataCache.putLong(str, j);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putFloat(String str, float f) {
        this.mOriginalStorage.putFloat(str, f);
        this.mAllLocalSettingsDataCache.putFloat(str, f);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putBoolean(String str, boolean z) {
        this.mOriginalStorage.putBoolean(str, z);
        this.mAllLocalSettingsDataCache.putBoolean(str, z);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putStringSet(String str, Set<String> set) {
        this.mOriginalStorage.putStringSet(str, set);
        this.mAllLocalSettingsDataCache.putStringSet(str, set);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public String getString(String str) {
        return getString(str, "");
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public String getString(String str, String str2) {
        String string = this.mOriginalStorage.getString(str, str2);
        this.mAllLocalSettingsDataCache.putString(str, string);
        return string;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public int getInt(String str, int i) {
        int i2 = this.mOriginalStorage.getInt(str, i);
        this.mAllLocalSettingsDataCache.putInt(str, i2);
        return i2;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public long getLong(String str) {
        return getLong(str, 0L);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public long getLong(String str, long j) {
        long j2 = this.mOriginalStorage.getLong(str, j);
        this.mAllLocalSettingsDataCache.putLong(str, j2);
        return j2;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public float getFloat(String str, float f) {
        float f2 = this.mOriginalStorage.getFloat(str, f);
        this.mAllLocalSettingsDataCache.putFloat(str, f2);
        return f2;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean getBoolean(String str, boolean z) {
        boolean z2 = this.mOriginalStorage.getBoolean(str, z);
        this.mAllLocalSettingsDataCache.putBoolean(str, z2);
        return z2;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public Set<String> getStringSet(String str) {
        return getStringSet(str, new HashSet());
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.mOriginalStorage.getStringSet(str, set);
        this.mAllLocalSettingsDataCache.putStringSet(str, stringSet);
        return stringSet;
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void remove(String str) {
        this.mOriginalStorage.remove(str);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void clear() {
        this.mOriginalStorage.clear();
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean contains(String str) {
        return this.mOriginalStorage.contains(str);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void apply() {
        this.mOriginalStorage.apply();
    }
}
