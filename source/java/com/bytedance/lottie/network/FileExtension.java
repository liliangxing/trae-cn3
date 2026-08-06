package com.bytedance.lottie.network;

import com.bytedance.lottie.L;

/* loaded from: classes4.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        L.warn("Unable to find correct extension for " + str);
        return Json;
    }
}
