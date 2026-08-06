package com.bytedance.article.common.monitor.backfetch;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SDCardDirFetch {
    public static final String SD_CARD_DIR_BACK_TYPE = "sd_card_dir_back";
    private static long lastFetchTime;

    private static String generateUploadFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String versionName = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        return TextUtils.isEmpty(versionName) ? String.format("%s_sdcardinfo.zip", simpleDateFormat.format(new Date(System.currentTimeMillis()))) : String.format("%s_sdcardinfo_%s.zip", simpleDateFormat.format(new Date(System.currentTimeMillis())), versionName);
    }

    @Deprecated
    public static void walkdir(File file, BufferedWriter bufferedWriter) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory() && listFiles[i].getPath().indexOf("/.") == -1) {
                    walkdir(listFiles[i], bufferedWriter);
                } else if (!listFiles[i].getName().startsWith(".") && listFiles[i].canRead()) {
                    bufferedWriter.write(String.format("file Name: %s, file size: %s\n", listFiles[i].getAbsolutePath(), FileUtils.getFormatSize(listFiles[i].length())));
                }
            }
        }
    }

    @Deprecated
    protected static void getDeptTree(File file, String str, int i, BufferedWriter bufferedWriter) throws IOException {
        String str2;
        String str3;
        if (!file.isDirectory()) {
            if (file.getName().startsWith(".") || !file.canRead()) {
                return;
            }
            bufferedWriter.write(file.getName());
            bufferedWriter.write(String.format("(size: %s)", FileUtils.getFormatSize(file.length())));
            bufferedWriter.newLine();
            return;
        }
        File[] listFiles = file.listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (i > 0) {
                if (listFiles.length - i2 > 1) {
                    str2 = str + "  |";
                } else {
                    str2 = str + "   ";
                }
                str3 = str + "  |__";
            } else {
                str2 = "";
                str3 = "";
            }
            if (!listFiles[i2].getName().startsWith(".") && listFiles[i2].canRead()) {
                bufferedWriter.write(str3 + listFiles[i2].getName());
                if (!listFiles[i2].isDirectory()) {
                    bufferedWriter.write(String.format("(size: %s)", FileUtils.getFormatSize(listFiles[i2].length())));
                }
                bufferedWriter.newLine();
            }
            if (listFiles[i2].isDirectory() && listFiles[i2].getPath().indexOf("/.") == -1) {
                getDeptTree(listFiles[i2], str2, i + 1, bufferedWriter);
            }
        }
    }

    protected static void getDeptXml(File file, int i, BufferedWriter bufferedWriter) throws IOException {
        if (!file.isDirectory()) {
            if (file.getName().startsWith(".") || !file.canRead()) {
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bufferedWriter.write("\t");
            }
            bufferedWriter.write(String.format("<file name=\"%s\" size=\"%s\"></file>", file.getName(), FileUtils.getFormatSize(file.length())));
            bufferedWriter.newLine();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            bufferedWriter.write("\t");
        }
        bufferedWriter.write(String.format("<dir name=\"%s\">", file.getName()));
        bufferedWriter.newLine();
        for (int i4 = 0; i4 < listFiles.length; i4++) {
            if (!listFiles[i4].getName().startsWith(".") && listFiles[i4].canRead()) {
                if (!listFiles[i4].isDirectory()) {
                    for (int i5 = 0; i5 < i + 1; i5++) {
                        bufferedWriter.write("\t");
                    }
                    bufferedWriter.write(String.format("<file name=\"%s\" size=\"%s\"></file>", listFiles[i4].getName(), FileUtils.getFormatSize(listFiles[i4].length())));
                    bufferedWriter.newLine();
                } else if (listFiles[i4].getPath().indexOf("/.") == -1) {
                    getDeptXml(listFiles[i4], i + 1, bufferedWriter);
                }
            }
        }
        for (int i6 = 0; i6 < i; i6++) {
            bufferedWriter.write("\t");
        }
        bufferedWriter.write("</dir>");
        bufferedWriter.newLine();
    }
}
