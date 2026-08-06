package com.bytedance.reparo.core.parse;

import android.text.TextUtils;
import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.common.utils.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LocalRecordParser {
    private static final String TAG = "LocalRecordParser";
    private PatchConfiguration mConfiguration;

    public LocalRecordParser(PatchConfiguration patchConfiguration) {
        this.mConfiguration = patchConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalRecord read() {
        String readFileContent = readFileContent();
        LocalRecord localRecord = null;
        try {
            localRecord = new JsonParser().parse(readFileContent);
        } catch (Exception unused) {
            FileUtils.delete(this.mConfiguration.getLocalRecordFile());
            PatchLogger.e(TAG, "parse local-record.info failed. " + readFileContent);
        }
        return localRecord == null ? new LocalRecord() : localRecord;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.reparo.core.parse.FileLockHelper] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.reparo.core.parse.FileLockHelper] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readFileContent() {
        ?? r3;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        IOException e;
        ?? localRecordFile = this.mConfiguration.getLocalRecordFile();
        File publicLockFile = this.mConfiguration.getPublicLockFile();
        StringBuilder sb = new StringBuilder();
        AutoCloseable autoCloseable = null;
        try {
            try {
                FileUtils.ensureFileExist(localRecordFile);
                fileInputStream = new FileInputStream((File) localRecordFile);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            inputStreamReader = null;
            fileInputStream = null;
            e = e2;
            localRecordFile = 0;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
            fileInputStream = null;
        }
        try {
            localRecordFile = FileLockHelper.getFileLock(publicLockFile);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(cArr, 0, read);
                    }
                    if (localRecordFile != 0) {
                        try {
                            localRecordFile.close();
                        } catch (IOException e3) {
                            e = e3;
                            PatchLogger.e(TAG, "close lock helper failed.(read)", e);
                            IOUtils.close(fileInputStream);
                            IOUtils.close(inputStreamReader);
                            return sb.toString();
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    PatchLogger.e(TAG, "read local record failed.", e);
                    if (localRecordFile != 0) {
                        try {
                            localRecordFile.close();
                        } catch (IOException e5) {
                            e = e5;
                            PatchLogger.e(TAG, "close lock helper failed.(read)", e);
                            IOUtils.close(fileInputStream);
                            IOUtils.close(inputStreamReader);
                            return sb.toString();
                        }
                    }
                    IOUtils.close(fileInputStream);
                    IOUtils.close(inputStreamReader);
                    return sb.toString();
                }
            } catch (IOException e6) {
                e = e6;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                publicLockFile = null;
                autoCloseable = localRecordFile;
                r3 = publicLockFile;
                if (autoCloseable != null) {
                    try {
                        autoCloseable.close();
                    } catch (IOException e7) {
                        PatchLogger.e(TAG, "close lock helper failed.(read)", e7);
                    }
                }
                IOUtils.close(fileInputStream);
                IOUtils.close(r3);
                throw th;
            }
        } catch (IOException e8) {
            inputStreamReader = null;
            e = e8;
            localRecordFile = 0;
        } catch (Throwable th4) {
            th = th4;
            r3 = 0;
            if (autoCloseable != null) {
            }
            IOUtils.close(fileInputStream);
            IOUtils.close(r3);
            throw th;
        }
        IOUtils.close(fileInputStream);
        IOUtils.close(inputStreamReader);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.reparo.core.parse.LocalRecordParser$1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.bytedance.reparo.core.parse.FileLockHelper] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(LocalRecord localRecord) {
        FileOutputStream fileOutputStream;
        ?? r3 = 0;
        r3 = null;
        FileLockHelper fileLockHelper = null;
        r3 = 0;
        String json = new JsonParser().toJson(localRecord);
        File localRecordFile = this.mConfiguration.getLocalRecordFile();
        File publicLockFile = this.mConfiguration.getPublicLockFile();
        try {
            try {
                FileUtils.ensureFileExist(localRecordFile);
                fileOutputStream = new FileOutputStream(localRecordFile);
                try {
                    fileLockHelper = FileLockHelper.getFileLock(publicLockFile);
                    fileOutputStream.write(json.getBytes());
                    r3 = fileLockHelper;
                    if (fileLockHelper != null) {
                        try {
                            fileLockHelper.close();
                            r3 = fileLockHelper;
                        } catch (IOException e) {
                            e = e;
                            PatchLogger.e(TAG, "close lock helper failed.(write)", e);
                            IOUtils.close(fileOutputStream);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    PatchLogger.e(TAG, "write local record failed. ", e);
                    r3 = fileLockHelper;
                    if (fileLockHelper != null) {
                        try {
                            fileLockHelper.close();
                            r3 = fileLockHelper;
                        } catch (IOException e3) {
                            e = e3;
                            PatchLogger.e(TAG, "close lock helper failed.(write)", e);
                            IOUtils.close(fileOutputStream);
                        }
                    }
                    IOUtils.close(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e4) {
                        PatchLogger.e(TAG, "close lock helper failed.(write)", e4);
                    }
                }
                IOUtils.close(fileOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (r3 != 0) {
            }
            IOUtils.close(fileOutputStream);
            throw th;
        }
        IOUtils.close(fileOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class JsonParser {
        private static final String KEY_HAS_JAVA_PATCH = "hasJavaPatch";
        private static final String KEY_HAS_SO_LIBRARIES = "hasSoLibraries";
        private static final String KEY_HOST_APP_VERSION = "hostAppVersion";
        private static final String KEY_INSTALL_DIR_PATH = "installDirPath";
        private static final String KEY_ISSUE_ID = "issueId";
        private static final String KEY_IS_ASYNC_LOAD = "isAsyncLoad";
        private static final String KEY_IS_SUPPORT_SUB_PROCESS = "isSupportSubProcess";
        private static final String KEY_JAVA_PATCH_ROOT_DIR_PATH = "javaPatchRootDirPath";
        private static final String KEY_PATCH_ID = "patchId";
        private static final String KEY_PATCH_MD5 = "patchMd5";
        private static final String KEY_PATCH_RECORD_INFO_SET = "patchRecordInfoSet";
        private static final String KEY_PATCH_VERSION = "patchVersion";
        private static final String KEY_SO_INFO_FILE_PATH = "soInfoFilePath";
        private static final String STR_NON_JSON_OBJECT = "{}";

        private JsonParser() {
        }

        public LocalRecord parse(String str) throws JSONException {
            LocalRecord localRecord = new LocalRecord();
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(STR_NON_JSON_OBJECT, str)) {
                JSONObject jSONObject = new JSONObject(str);
                localRecord.setHostAppVersion(jSONObject.optString(KEY_HOST_APP_VERSION));
                HashSet hashSet = new HashSet();
                JSONArray optJSONArray = jSONObject.optJSONArray(KEY_PATCH_RECORD_INFO_SET);
                if (optJSONArray == null) {
                    return localRecord;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    PatchRecordInfo patchRecordInfo = new PatchRecordInfo();
                    patchRecordInfo.setHasJavaPatch(jSONObject2.optBoolean(KEY_HAS_JAVA_PATCH));
                    patchRecordInfo.setHasSoLibraries(jSONObject2.optBoolean(KEY_HAS_SO_LIBRARIES));
                    patchRecordInfo.setHostAppVersion(jSONObject2.optString(KEY_HOST_APP_VERSION));
                    patchRecordInfo.setInstallDir(new File(jSONObject2.optString(KEY_INSTALL_DIR_PATH)));
                    patchRecordInfo.setAsyncLoad(jSONObject2.optBoolean(KEY_IS_ASYNC_LOAD, true));
                    patchRecordInfo.setSupportSubProcess(jSONObject2.optBoolean(KEY_IS_SUPPORT_SUB_PROCESS, false));
                    patchRecordInfo.setJavaPatchRootDir(new File(jSONObject2.optString(KEY_JAVA_PATCH_ROOT_DIR_PATH)));
                    patchRecordInfo.setPatchId(jSONObject2.optString(KEY_PATCH_ID));
                    patchRecordInfo.setIssueId(jSONObject2.optString(KEY_ISSUE_ID));
                    patchRecordInfo.setPatchMd5(jSONObject2.optString(KEY_PATCH_MD5));
                    patchRecordInfo.setPatchVersion(jSONObject2.optString(KEY_PATCH_VERSION));
                    patchRecordInfo.setSoInfoFile(new File(jSONObject2.optString(KEY_SO_INFO_FILE_PATH)));
                    hashSet.add(patchRecordInfo);
                }
                localRecord.setPatchRecordInfoSet(hashSet);
            }
            return localRecord;
        }

        public String toJson(LocalRecord localRecord) {
            try {
                String jsonImpl = toJsonImpl(localRecord);
                return TextUtils.equals(STR_NON_JSON_OBJECT, jsonImpl) ? "" : jsonImpl;
            } catch (JSONException e) {
                PatchLogger.e(LocalRecordParser.TAG, "to json error. " + localRecord.toString(), e);
                return "";
            }
        }

        public String toJsonImpl(LocalRecord localRecord) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(localRecord.getHostAppVersion())) {
                jSONObject.putOpt(KEY_HOST_APP_VERSION, localRecord.getHostAppVersion());
            }
            Set<PatchRecordInfo> patchRecordInfoSet = localRecord.getPatchRecordInfoSet();
            if (patchRecordInfoSet.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (PatchRecordInfo patchRecordInfo : patchRecordInfoSet) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt(KEY_HOST_APP_VERSION, patchRecordInfo.getHostAppVersion());
                    jSONObject2.putOpt(KEY_HAS_JAVA_PATCH, Boolean.valueOf(patchRecordInfo.isHasJavaPatch()));
                    jSONObject2.putOpt(KEY_HAS_SO_LIBRARIES, Boolean.valueOf(patchRecordInfo.isHasSoLibraries()));
                    jSONObject2.putOpt(KEY_INSTALL_DIR_PATH, patchRecordInfo.getInstallDirPath());
                    jSONObject2.putOpt(KEY_IS_ASYNC_LOAD, Boolean.valueOf(patchRecordInfo.isAsyncLoad()));
                    jSONObject2.putOpt(KEY_IS_SUPPORT_SUB_PROCESS, Boolean.valueOf(patchRecordInfo.isSupportSubProcess()));
                    jSONObject2.putOpt(KEY_JAVA_PATCH_ROOT_DIR_PATH, patchRecordInfo.getJavaPatchRootDirPath());
                    jSONObject2.putOpt(KEY_PATCH_ID, patchRecordInfo.getPatchId());
                    jSONObject2.putOpt(KEY_ISSUE_ID, patchRecordInfo.getIssueId());
                    jSONObject2.putOpt(KEY_PATCH_MD5, patchRecordInfo.getPatchMd5());
                    jSONObject2.putOpt(KEY_PATCH_VERSION, patchRecordInfo.getPatchVersion());
                    jSONObject2.putOpt(KEY_SO_INFO_FILE_PATH, patchRecordInfo.getSoInfoFilePath());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(KEY_PATCH_RECORD_INFO_SET, jSONArray);
            }
            return jSONObject.toString();
        }
    }
}
