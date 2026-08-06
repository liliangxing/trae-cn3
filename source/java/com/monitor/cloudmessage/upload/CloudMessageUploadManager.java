package com.monitor.cloudmessage.upload;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CloudMessageUploadManager {
    private static ArrayList<FileUploadInfo> fileInfos = new ArrayList<>();

    public static void upload(FileUploadInfo fileUploadInfo) {
        if (fileUploadInfo == null || fileUploadInfo.getCallback() == null || fileUploadInfo.getCallback().getUploadFileList().size() == 0 || !checkStateForUpload(fileUploadInfo)) {
            return;
        }
        if (!fileUploadInfo.isCompress()) {
            fileUploadInfo.setUploadFileAbsluteNames(fileUploadInfo.getCallback().getUploadFileList());
        } else {
            zipUploadFile(fileUploadInfo);
        }
        boolean uploadFile = CloudMessageUploadService.uploadFile(fileUploadInfo);
        if (fileUploadInfo.isDelSourceFile() && uploadFile) {
            Iterator<String> it = fileUploadInfo.getCallback().getUploadFileList().iterator();
            while (it.hasNext()) {
                File file = new File(it.next());
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public static void upload(UploadInfo uploadInfo) {
        if (ApmContext.isDebugMode()) {
            Logger.d("cloudmessage", new String[]{"uploadInfo=" + uploadInfo});
        }
        if (uploadInfo == null || TextUtils.isEmpty(uploadInfo.getCommandId())) {
            return;
        }
        CloudMessageUploadService.uploadData(uploadInfo);
    }

    private static boolean checkStateForUpload(FileUploadInfo fileUploadInfo) {
        if (fileUploadInfo.isUploading()) {
            return false;
        }
        return (fileUploadInfo.isSkipUploadInternal() || System.currentTimeMillis() - fileUploadInfo.getLastUploadTime() >= 0) && NetworkUtils.isNetworkAvailable(CloudMessageManager.getInstance().getContext());
    }

    private static void zipUploadFile(FileUploadInfo fileUploadInfo) {
        if (fileUploadInfo.getCallback().getUploadFileList().size() == 1 || fileUploadInfo.isMultiFileInOneZip()) {
            File file = new File(fileUploadInfo.getCallback().getUploadFileList().get(0));
            File file2 = new File(file.getParent(), getZipFileName(file.getName()));
            if (file2.exists()) {
                file2.delete();
            }
            FileUtils.compress(file2.getAbsolutePath(), (String[]) fileUploadInfo.getCallback().getUploadFileList().toArray(new String[fileUploadInfo.getCallback().getUploadFileList().size()]));
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(file2.getAbsolutePath());
            fileUploadInfo.setUploadFileAbsluteNames(arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : fileUploadInfo.getCallback().getUploadFileList()) {
            File file3 = new File(str);
            File file4 = new File(file3.getParent(), getZipFileName(file3.getName()));
            if (file4.exists()) {
                file4.delete();
            }
            FileUtils.compress(file4.getAbsolutePath(), str);
            arrayList2.add(file4.getAbsolutePath());
        }
        fileUploadInfo.setUploadFileAbsluteNames(arrayList2);
    }

    private static String getZipFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return str + "-cloudMsg.zip";
        }
        return str.substring(0, lastIndexOf) + "-cloudMsg.zip";
    }
}
