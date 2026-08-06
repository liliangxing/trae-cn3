package com.bytedance.reparo.core.parse;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class SoFile {
    public String cpuAbi;
    public long crc;
    public boolean isDiff = true;
    public String name;
    public File outputFile;
    public String relativePath;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof SoFile)) {
            return false;
        }
        SoFile soFile = (SoFile) obj;
        return TextUtils.equals(this.name, soFile.name) && TextUtils.equals(this.relativePath, soFile.relativePath) && TextUtils.equals(this.cpuAbi, soFile.cpuAbi);
    }

    public SoFile copy(File file, boolean z) {
        SoFile soFile = new SoFile();
        soFile.cpuAbi = this.cpuAbi;
        soFile.name = this.name;
        soFile.crc = this.crc;
        soFile.relativePath = this.relativePath;
        soFile.outputFile = file;
        soFile.isDiff = z;
        return soFile;
    }
}
