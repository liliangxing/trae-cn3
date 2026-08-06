package com.bytedance.push.settings.storage;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.push.settings.StorageFactory;
import com.bytedance.push.settings.helper.SettingsFileLockHelper;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import com.bytedance.push.settings.utils.SettingsUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharedPreferenceStorageFactory implements StorageFactory {
    private static final ConcurrentHashMap<String, Storage> CACHE = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Storage> MT_CACHE = new ConcurrentHashMap<>();
    public static final String PROCESS_MAIN = "main";
    public static final String PROCESS_SMP = "smp";
    private final String TAG = "SPStorageFactory";

    @Override // com.bytedance.push.settings.StorageFactory
    public Storage create(Context context, boolean z, String str, String str2) {
        Storage buildStorageWithNotAllowStartOthersProcess;
        if (z) {
            ConcurrentHashMap<String, Storage> concurrentHashMap = MT_CACHE;
            Storage storage = concurrentHashMap.get(str);
            if (storage != null) {
                if (TextUtils.isEmpty(str2) || !(storage instanceof MultiProcessSpStorage)) {
                    return storage;
                }
                SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "SharedPreferenceStorageFactory#create : originProcess is not empty but  storageResult instanceof MultiProcessSpStorage, not use it");
            }
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "SharedPreferenceStorageFactory#create : storageKey is " + str);
            boolean readAllowStartOthersProcess = SettingsFileLockHelper.getInstance().readAllowStartOthersProcess(context);
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "SharedPreferenceStorageFactory#create allowStartOthersProcessFromSp is " + readAllowStartOthersProcess);
            if (readAllowStartOthersProcess) {
                buildStorageWithNotAllowStartOthersProcess = buildStorageWithAllowStartOthersProcess(context, str, str2);
            } else {
                buildStorageWithNotAllowStartOthersProcess = buildStorageWithNotAllowStartOthersProcess(context, str, str2);
            }
            concurrentHashMap.put(str, buildStorageWithNotAllowStartOthersProcess);
            return buildStorageWithNotAllowStartOthersProcess;
        }
        ConcurrentHashMap<String, Storage> concurrentHashMap2 = CACHE;
        Storage storage2 = concurrentHashMap2.get(str);
        if (storage2 != null) {
            return storage2;
        }
        SharedPreferenceStorage sharedPreferenceStorage = new SharedPreferenceStorage(context, str);
        concurrentHashMap2.put(str, sharedPreferenceStorage);
        return sharedPreferenceStorage;
    }

    private Storage buildStorageWithAllowStartOthersProcess(Context context, String str, String str2) {
        SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "SharedPreferenceStorageFactory#buildStorageWithAllowStartOthersProcess storageKey is " + str);
        if (TextUtils.equals(str2, PROCESS_SMP) || TextUtils.equals(str2, "main")) {
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "originProcess is  ：" + str2 + " ， use MPProviderProcessStorage!");
            return new MPProviderProcessStorage(context, str);
        }
        if (MainProcessSettingsProvider.isInProviderProcess(context)) {
            return new MPProviderProcessStorage(context, str);
        }
        return new MultiProcessSpStorage(context, str);
    }

    private Storage buildStorageWithNotAllowStartOthersProcess(Context context, String str, String str2) {
        if (TextUtils.equals(str2, PROCESS_SMP) || TextUtils.equals(str2, "main")) {
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "originProcess is  ：" + str2 + " ， use MPProviderProcessStorage!");
            return new MPProviderProcessStorage(context, str);
        }
        SettingsFileLockHelper.getInstance().onProcessStart(context);
        String firstProcess = SettingsFileLockHelper.getInstance().getFirstProcess(context);
        SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "firstProcess is  ：" + firstProcess);
        if (TextUtils.equals(SettingsUtils.getCurProcessName(context), firstProcess)) {
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "curIsFirstProcess ，write sp with MPProviderProcessStorage");
            return new MPProviderProcessStorage(context, str);
        }
        if (!TextUtils.isEmpty(firstProcess) && firstProcess.endsWith(":smp")) {
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "firstProcess is smp, write sp with MultiProcessSpStorage");
            return new MultiProcessSpStorage(context, str, true);
        }
        if (TextUtils.isEmpty(firstProcess)) {
            SettingsLoggerHelper.getInstance().mo259e("SPStorageFactory", "firstProcess is empty, write on main process");
        } else {
            SettingsLoggerHelper.getInstance().mo257d("SPStorageFactory", "firstProcess is not smp, write on main process");
        }
        if (MainProcessSettingsProvider.isInProviderProcess(context)) {
            return new MPProviderProcessStorage(context, str);
        }
        return new MultiProcessSpStorage(context, str);
    }
}
