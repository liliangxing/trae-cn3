package com.bytedance.crash.general;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HardwareInfo implements Serializable {
    private static final String FILE_NAME = "hardware.inf";
    public static final String KEY_HW_CPU_ABI = "cpu_abi";
    public static final String KEY_HW_CPU_HARDWARE = "hardware";
    public static final String KEY_HW_CPU_MODEL = "cpu_model";
    public static final String KEY_HW_DENSITY_DPI = "density_dpi";
    public static final String KEY_HW_DISPLAY_DENSITY = "display_density";
    public static final String KEY_HW_DISPLAY_RESOLUTION = "resolution";
    public static final String KEY_HW_RAM_SIZE = "ram_size";
    public static final String KEY_HW_VENDOR_BRAND = "device_brand";
    public static final String KEY_HW_VENDOR_MANUFACTURER = "device_manufacturer";
    public static final String KEY_HW_VENDOR_MODEL = "device_model";
    private static final long serialVersionUID = 20241001154124L;
    private String mCpuAbi;
    private String mCpuHardware;
    private String mCpuModel;
    private String mDisplayDensity;
    private int mDisplayDensityDpi;
    private String mDisplayResolution;
    private long mJiffies;
    private String mRamSize;
    private String mVendorBrand;
    private String mVendorManufacturer;
    private String mVendorModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HardwareInfo get(Context context, File file) {
        HardwareInfo hardwareInfo;
        File file2 = new File(file, FILE_NAME);
        try {
            hardwareInfo = (HardwareInfo) SerializeFactory.load(file2);
            HardwareInfo hardwareInfo2 = hardwareInfo;
        } catch (Exception unused) {
            hardwareInfo = null;
        }
        if (hardwareInfo == null) {
            hardwareInfo = new HardwareInfo();
            hardwareInfo.mVendorModel = HardwareInfoHelper.getVendorModel();
            hardwareInfo.mVendorBrand = HardwareInfoHelper.getVendorBrand();
            hardwareInfo.mVendorManufacturer = HardwareInfoHelper.getVendorManufacturer();
            hardwareInfo.mJiffies = HardwareInfoHelper.getJiffies();
            hardwareInfo.mCpuAbi = HardwareInfoHelper.getCpuAbi();
            hardwareInfo.mCpuModel = HardwareInfoHelper.getCpuModel();
            hardwareInfo.mCpuHardware = HardwareInfoHelper.getCpuHardware();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                hardwareInfo.mDisplayResolution = HardwareInfoHelper.getDisplayResolution(displayMetrics);
                hardwareInfo.mDisplayDensity = HardwareInfoHelper.getDisplayDensityStr(displayMetrics);
                hardwareInfo.mDisplayDensityDpi = HardwareInfoHelper.getDisplayDensityInt(displayMetrics);
            }
            hardwareInfo.mRamSize = HardwareInfoHelper.getRamSize();
            SerializeFactory.store(file2, hardwareInfo);
        }
        return hardwareInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putTo(JSONObject jSONObject) {
        JSONUtils.put(jSONObject, "device_brand", this.mVendorBrand);
        JSONUtils.put(jSONObject, "device_model", this.mVendorModel);
        JSONUtils.put(jSONObject, "device_manufacturer", this.mVendorManufacturer);
        JSONUtils.put(jSONObject, "density_dpi", Integer.valueOf(this.mDisplayDensityDpi));
        JSONUtils.put(jSONObject, "resolution", this.mDisplayResolution);
        JSONUtils.put(jSONObject, "display_density", this.mDisplayDensity);
        JSONUtils.put(jSONObject, "cpu_abi", this.mCpuAbi);
        JSONUtils.put(jSONObject, KEY_HW_CPU_HARDWARE, this.mCpuHardware);
        JSONUtils.put(jSONObject, KEY_HW_CPU_MODEL, this.mCpuModel);
        JSONUtils.put(jSONObject, KEY_HW_RAM_SIZE, this.mRamSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getJiffy() {
        return this.mJiffies;
    }
}
