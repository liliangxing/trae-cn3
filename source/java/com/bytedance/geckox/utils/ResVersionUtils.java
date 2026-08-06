package com.bytedance.geckox.utils;

import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ResVersionUtils {
    public static Long getLatestChannelVersion(File file) {
        if (file == null) {
            return null;
        }
        String[] split = file.getAbsolutePath().split("/");
        String str = split[split.length - 2];
        String str2 = split[split.length - 1];
        return innerGetLatestChannelVersion(file);
    }

    public static Long innerGetLatestChannelVersion(File file) {
        String str;
        String str2;
        ChannelMeta meta;
        if (file == null) {
            return null;
        }
        String[] split = file.getAbsolutePath().split("/");
        if (split.length >= 2 && (meta = ChannelMetaManager.INSTANCE.getMeta((str = split[split.length - 2]), (str2 = split[split.length - 1]))) != null) {
            return ChannelMetaManager.INSTANCE.checkLatestVersion(str, str2, meta, "channelDir: " + file.getAbsolutePath());
        }
        return null;
    }

    public static List<Long> getAllVersion(File file) {
        ArrayList arrayList = null;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.geckox.utils.ResVersionUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        if (listFiles != null && listFiles.length != 0) {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                try {
                    arrayList.add(Long.valueOf(Long.valueOf(file2.getName()).longValue()));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }
}
