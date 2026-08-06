package com.bytedance.crash.dumper;

import android.util.Pair;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.tracker.BatteryTracker;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Scraps implements Serializable {
    public static final String BATTERY = "battery";
    private static final String FILE_NAME = "scraps.inf";
    public static final String INNER_FREE = "inner_free";
    private static final String INNER_FREE_REAL = "inner_free_realUnit";
    public static final String INNER_TOTAL = "inner_total";
    private static final String INNER_TOTAL_REAL = "inner_total_realUnit";
    public static final String INNER_UNIT = "unit";
    public static final String SDCARD_FREE = "sdcard_free";
    private static final String SDCARD_TOTAL = "sdcard_total";
    public static final String STORAGE = "storage";
    private static final long serialVersionUID = 1;
    private int mBatteryLevel;
    private boolean mIsMiniApp;
    private int mMiniAppId;
    private String mMiniAppVersion;
    private long mSdcardFreeSize;
    private long mSdcardTotalSize;
    private long mStorageFreeSize;
    private long mStorageTotalSize;

    private void dumpMiniApp() {
        if (NpthCore.isCurrentMiniAppProcess()) {
            this.mIsMiniApp = true;
            this.mMiniAppId = NpthCore.getMiniAppId();
            this.mMiniAppVersion = NpthCore.getMiniAppVersion();
            return;
        }
        this.mIsMiniApp = false;
    }

    public void loadMiniApp(JSONObject jSONObject) {
        try {
            if (this.mIsMiniApp) {
                jSONObject.put("is_mp", 1);
                jSONObject.put("miniapp_id", this.mMiniAppId);
                jSONObject.put("miniapp_version", this.mMiniAppVersion);
            } else {
                jSONObject.put("miniapp_id", 0);
            }
        } catch (Throwable unused) {
        }
    }

    private void dumpStorage() {
        this.mStorageTotalSize = Storage.storageTotalSize();
        this.mStorageFreeSize = Storage.storageFreeSize();
        Pair<Long, Long> sdcardStorage = Storage.getSdcardStorage();
        this.mSdcardTotalSize = ((Long) sdcardStorage.first).longValue();
        this.mSdcardFreeSize = ((Long) sdcardStorage.second).longValue();
    }

    private void loadStorage(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(SDCARD_TOTAL, Storage.formatSize(this.mSdcardTotalSize));
            jSONObject2.put(SDCARD_FREE, Storage.formatSize(this.mSdcardFreeSize));
            jSONObject2.put(INNER_FREE, Storage.getStorageRange(this.mStorageFreeSize));
            jSONObject2.put(INNER_TOTAL, Storage.getStorageRange(this.mStorageTotalSize));
            jSONObject2.put(INNER_FREE_REAL, Storage.formatSize(this.mStorageFreeSize));
            jSONObject2.put(INNER_TOTAL_REAL, Storage.formatSize(this.mStorageTotalSize));
            jSONObject2.put(INNER_UNIT, Storage.UNIT);
            jSONObject.put(STORAGE, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    private void dumpBattery() {
        this.mBatteryLevel = BatteryTracker.getBatteryLevel();
    }

    private void loadBattery(JSONObject jSONObject) {
        try {
            jSONObject.put("battery", this.mBatteryLevel);
        } catch (Throwable unused) {
        }
    }

    public static void dump(File file) {
        Scraps scraps = new Scraps();
        scraps.dumpMiniApp();
        scraps.dumpStorage();
        scraps.dumpBattery();
        SerializeFactory.store(new File(file, FILE_NAME), scraps);
    }

    public static void pushTo(JSONObject jSONObject, File file) {
        Scraps scraps = file != null ? (Scraps) SerializeFactory.load(new File(file, FILE_NAME)) : null;
        if (scraps == null) {
            scraps = new Scraps();
            scraps.dumpMiniApp();
            scraps.dumpStorage();
            scraps.dumpBattery();
        }
        scraps.loadMiniApp(jSONObject);
        scraps.loadStorage(jSONObject);
        scraps.loadBattery(jSONObject);
    }

    public static void pushTo(JSONObject jSONObject) {
        pushTo(jSONObject, null);
    }
}
