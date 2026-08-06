package com.bytedance.platform.settingsx.manager;

import android.content.SharedPreferences;
import com.bytedance.platform.settingsx.Migration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class DefaultMigration implements Migration {
    private static final ExecutorService scheduler = Executors.newSingleThreadExecutor();
    private volatile SharedPreferences mSp;
    private volatile String mSpName;

    public DefaultMigration(String str) {
        this.mSpName = str + ".sp";
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public int getInt(String str) {
        return getSharedPreferences().getInt(str, 0);
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public long getLong(String str) {
        return getSharedPreferences().getLong(str, 0L);
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public float getFloat(String str) {
        return getSharedPreferences().getFloat(str, 0.0f);
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public boolean getBoolean(String str) {
        return getSharedPreferences().getBoolean(str, false);
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public String getString(String str) {
        return getSharedPreferences().getString(str, "");
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public Set<String> getStringSet(String str) {
        return getSharedPreferences().getStringSet(str, new HashSet());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public boolean contains(String str) {
        return getSharedPreferences().contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putString$0$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7829xeb8c5adc(String str, String str2) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putString(str, str2).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putString(final String str, final String str2) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7829xeb8c5adc(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putStringSet$1$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7830x909c8c39(String str, Set set) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putStringSet(str, set).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putStringSet(final String str, final Set<String> set) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7830x909c8c39(str, set);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putInt$2$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7827x231eabd8(String str, int i) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putInt(str, i).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putInt(final String str, final int i) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7827x231eabd8(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putLong$3$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7828x70fc298a(String str, long j) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putLong(str, j).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putLong(final String str, final long j) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7828x70fc298a(str, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putFloat$4$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7826x98b6a2c7(String str, float f) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putFloat(str, f).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putFloat(final String str, final float f) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7826x98b6a2c7(str, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putBoolean$5$com-bytedance-platform-settingsx-manager-DefaultMigration, reason: not valid java name */
    public /* synthetic */ Boolean m7825xe54e7bd4(String str, boolean z) throws Exception {
        return Boolean.valueOf(getSharedPreferences().edit().putBoolean(str, z).commit());
    }

    @Override // com.bytedance.platform.settingsx.Migration
    public void putBoolean(final String str, final boolean z) {
        scheduler.submit(new Callable() { // from class: com.bytedance.platform.settingsx.manager.DefaultMigration$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultMigration.this.m7825xe54e7bd4(str, z);
            }
        });
    }

    private SharedPreferences getSharedPreferences() {
        throw new RuntimeException("不支持老版本的LocalSettingX，请升级apt解决");
    }
}
