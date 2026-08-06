package com.bytedance.crash.general;

import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class RomInfo implements Serializable {
    private static final String FILE_NAME = "rom.inf";
    public static final String KEY_OS_TYPE = "os";
    private static final String KEY_ROM_HARMONY_OS = "is_hm_os";
    private static final String KEY_ROM_INCREMENTAL = "rom";
    public static final String KEY_ROM_KERNEL_VERSION = "kernel_version";
    public static final String KEY_ROM_OS_API = "os_api";
    public static final String KEY_ROM_OS_VERSION = "os_version";
    private static final String KEY_ROM_VERSION = "rom_version";
    private static final long serialVersionUID = 1;
    private boolean mIsHarmonyOs;
    private String mKernelVersion;
    private int mOsApiLevel;
    private String mOsVersion;
    private String mRandomDeviceId;
    private String mRomIncremental;
    private String mRomVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRandomDeviceId() {
        return this.mRandomDeviceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RomInfo get(File file) {
        RomInfo romInfo;
        File file2 = new File(file, FILE_NAME);
        String romVersion = RomInfoHelper.getRomVersion();
        try {
            romInfo = (RomInfo) SerializeFactory.load(file2);
            RomInfo romInfo2 = romInfo;
        } catch (Exception unused) {
            romInfo = null;
        }
        if (romInfo != null && romVersion.equals(String.valueOf(romInfo.mRomVersion))) {
            return romInfo;
        }
        RomInfo romInfo3 = new RomInfo();
        romInfo3.mRomVersion = romVersion;
        romInfo3.mOsVersion = RomInfoHelper.getOsVersion();
        romInfo3.mIsHarmonyOs = RomInfoHelper.isHarmonyOs();
        romInfo3.mKernelVersion = RomInfoHelper.getKernelVersion();
        romInfo3.mRomIncremental = RomInfoHelper.getRomIncremental();
        romInfo3.mOsApiLevel = RomInfoHelper.getOsApiLevel();
        romInfo3.mRandomDeviceId = RomInfoHelper.getRandomDeviceId();
        SerializeFactory.store(file2, romInfo3);
        return romInfo3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putTo(JSONObject jSONObject) {
        JSONUtils.put(jSONObject, "os", "Android");
        JSONUtils.put(jSONObject, "os_version", this.mOsVersion);
        JSONUtils.put(jSONObject, "os_api", Integer.valueOf(this.mOsApiLevel));
        JSONUtils.put(jSONObject, "is_hm_os", Boolean.valueOf(this.mIsHarmonyOs));
        JSONUtils.put(jSONObject, "kernel_version", this.mKernelVersion);
        JSONUtils.put(jSONObject, "rom", this.mRomIncremental);
        JSONUtils.put(jSONObject, "rom_version", this.mRomVersion);
    }
}
