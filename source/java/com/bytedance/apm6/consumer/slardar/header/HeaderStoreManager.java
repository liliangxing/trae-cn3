package com.bytedance.apm6.consumer.slardar.header;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class HeaderStoreManager {
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String SUFFIX = ".bin";
    private File directory;
    private volatile boolean initialized;

    public static HeaderStoreManager getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveHeaderInfo(String str, HeaderInfo headerInfo) {
        JSONObject serialize;
        initialize();
        if (this.directory == null || (serialize = HeaderUtils.serialize(headerInfo)) == null) {
            return;
        }
        File file = new File(this.directory, getFileName(str));
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileOutputStream(file).getChannel();
            fileChannel.write(ByteBuffer.wrap(serialize.toString().getBytes()));
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeaderInfo getHeaderInfo(String str) {
        byte[] readFileToByteArray;
        initialize();
        if (this.directory == null || (readFileToByteArray = FileUtils.readFileToByteArray(new File(this.directory, getFileName(str)))) == null) {
            return null;
        }
        return HeaderUtils.deserialize(readFileToByteArray);
    }

    private String getFileName(String str) {
        return str + SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteExpireFile() {
        initialize();
        File file = this.directory;
        if (file == null) {
            return;
        }
        file.listFiles(new FileFilter() { // from class: com.bytedance.apm6.consumer.slardar.header.HeaderStoreManager.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                boolean z = true;
                try {
                    String name = file2.getName();
                    int lastIndexOf = name.lastIndexOf(HeaderStoreManager.SUFFIX);
                    if (lastIndexOf != -1) {
                        if (System.currentTimeMillis() - HeaderUtils.getTimeByHeaderId(Long.parseLong(name.substring(0, lastIndexOf))) < 604800000) {
                            z = false;
                        }
                    }
                } catch (Throwable unused) {
                }
                if (z) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "deleteExpireHeader:" + file2.getName());
                    }
                    FileUtils.deleteFile(file2);
                }
                return false;
            }
        });
    }

    private synchronized void initialize() {
        if (this.initialized) {
            return;
        }
        try {
            File file = new File(DiskEnvironmentHelper.getWorkingDirectory(), "header");
            this.directory = file;
            if (!file.exists()) {
                this.directory.mkdirs();
            }
        } catch (Throwable th) {
            Logger.m120e("APM", "header store init error " + th.toString());
        }
        this.initialized = true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class InnerHolder {
        private static final HeaderStoreManager instance = new HeaderStoreManager();

        private InnerHolder() {
        }
    }
}
