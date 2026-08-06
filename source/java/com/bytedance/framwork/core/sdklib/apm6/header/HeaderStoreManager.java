package com.bytedance.framwork.core.sdklib.apm6.header;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.framwork.core.sdklib.apm6.DiskEnvironmentHelper;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class HeaderStoreManager {
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String SPLIT = "_";
    private static final String SUFFIX = ".bin";

    private static long getTimeByHeaderId(long j) {
        if (j < 0) {
            return 0L;
        }
        return j >> 16;
    }

    public static HeaderStoreManager getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveHeader(String str, JSONObject jSONObject) {
        File headerDirectory = DiskEnvironmentHelper.getHeaderDirectory();
        if (headerDirectory == null || jSONObject == null) {
            return;
        }
        File file = new File(headerDirectory, getFileName(str));
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileOutputStream(file).getChannel();
            fileChannel.write(ByteBuffer.wrap(jSONObject.toString().getBytes()));
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getHeader(String str) {
        byte[] readFileToByteArray;
        File headerDirectory = DiskEnvironmentHelper.getHeaderDirectory();
        if (headerDirectory != null && (readFileToByteArray = FileUtils.readFileToByteArray(new File(headerDirectory, getFileName(str)))) != null) {
            try {
                return new JSONObject(new String(readFileToByteArray));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String getFileName(String str) {
        return str + SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteExpireFile() {
        File headerDirectory = DiskEnvironmentHelper.getHeaderDirectory();
        if (headerDirectory == null) {
            return;
        }
        headerDirectory.listFiles(new FileFilter() { // from class: com.bytedance.framwork.core.sdklib.apm6.header.HeaderStoreManager.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (!HeaderStoreManager.this.isDelete(file)) {
                    return false;
                }
                FileUtils.deleteFile(file);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDelete(File file) {
        try {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(SUFFIX);
            if (lastIndexOf == -1) {
                return true;
            }
            String[] split = name.substring(0, lastIndexOf).split("_");
            if (split.length < 2) {
                return true;
            }
            return System.currentTimeMillis() - getTimeByHeaderId(Long.parseLong(split[1])) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private static class InnerHolder {
        private static final HeaderStoreManager instance = new HeaderStoreManager();

        private InnerHolder() {
        }
    }
}
