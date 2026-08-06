package com.monitor.cloudmessage.upload.net;

import android.text.TextUtils;
import com.bytedance.apm.util.NetUtils;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.StringUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CloudMessageUploadService {
    public static final String API_PATH = "monitor/collect/c/cloudcontrol/file";
    static final String COMMON_PARAMS_FILETYPE = "command_commonparams";
    static final String CONTENT_TYPE = "multipart/form-data";
    public static String ENCODE = "UTF-8";
    static final String LINE_END = "\r\n";
    static final String PREFIX = "--";
    static final String SPECIFIC_PARAMS_FILETYPE = "command_specificparams";
    public static String UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";
    public static Map<String, String> map = new HashMap();
    static final String BOUNDARY = "cloudMessage" + UUID.randomUUID().toString();

    public static boolean uploadFile(FileUploadInfo fileUploadInfo) {
        int i = 0;
        boolean z = false;
        while (i < fileUploadInfo.getUploadFileAbsluteNames().size()) {
            File file = new File(fileUploadInfo.getUploadFileAbsluteNames().get(i));
            if (file.exists()) {
                int i2 = i < fileUploadInfo.getUploadFileAbsluteNames().size() - 1 ? 1 : 2;
                if (fileUploadInfo.isForceUseState()) {
                    i2 = fileUploadInfo.getCloudMsgResponseCode();
                }
                boolean postFile = postFile(UPLOAD_URL, file, null, i2, fileUploadInfo.getFileType(), fileUploadInfo.getCommandId(), fileUploadInfo.getErrorMsg(), fileUploadInfo.getOperateTime(), fileUploadInfo.getSpecificParams());
                if (postFile && fileUploadInfo.isCompress()) {
                    file.delete();
                }
                z = i == 0 ? postFile : z && postFile;
            }
            i++;
        }
        return z;
    }

    public static boolean uploadData(UploadInfo uploadInfo) {
        return postWithoutFile(UPLOAD_URL, null, uploadInfo.getCloudMsgResponseCode(), uploadInfo.getCommandId(), uploadInfo.getErrorMsg(), uploadInfo.getOperateTime(), uploadInfo.getSpecificParams());
    }

    public static boolean uploadFile(File file, int i, String str, String str2, String str3, long j, HashMap<String, String> hashMap) {
        return postFile(UPLOAD_URL, file, null, i, str, str2, str3, j, hashMap);
    }

    private static boolean postFile(String str, File file, Map<String, String> map2, int i, String str2, String str3, String str4, long j, HashMap<String, String> hashMap) {
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            throw new IllegalArgumentException("url and file not be null ");
        }
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection urlConnection = NetUtils.getUrlConnection(str);
            try {
                urlConnection.setReadTimeout(30000);
                urlConnection.setConnectTimeout(30000);
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setUseCaches(false);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Charset", ENCODE);
                urlConnection.setRequestProperty("connection", "keep-alive");
                urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
                Map<String, String> map3 = map;
                if (map3 != null && !map3.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            urlConnection.setRequestProperty(key, value);
                        }
                    }
                }
                urlConnection.connect();
                dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(PREFIX);
                    String str5 = BOUNDARY;
                    stringBuffer.append(str5);
                    stringBuffer.append(LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + i + LINE_END + PREFIX + str5 + LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + str3 + LINE_END + PREFIX + str5 + LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + str4 + LINE_END + PREFIX + str5 + LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + j + LINE_END + PREFIX + str5 + LINE_END);
                    StringBuilder append = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append.append(CloudMessageManager.getAid()).append(LINE_END).append(PREFIX).append(str5).append(LINE_END).toString());
                    StringBuilder append2 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append2.append(CloudMessageManager.getUpdateVersionCode()).append(LINE_END).append(PREFIX).append(str5).append(LINE_END).toString());
                    StringBuilder append3 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append3.append(CloudMessageManager.getUid()).append(LINE_END).append(PREFIX).append(str5).append(LINE_END).toString());
                    if (i == 2 || i == 3 || (i == 0 && hashMap != null && !hashMap.isEmpty())) {
                        dataOutputStream.write(stringBuffer.toString().getBytes());
                        writeAddtionalInfo(dataOutputStream, hashMap);
                        stringBuffer.setLength(0);
                    }
                    stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + str2 + "\"; filename=\"" + file.getName() + "\"" + LINE_END);
                    stringBuffer.append("Content-Type: text/plain\r\n");
                    stringBuffer.append(LINE_END);
                    dataOutputStream.write(stringBuffer.toString().getBytes());
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    dataOutputStream.write(LINE_END.getBytes());
                    dataOutputStream.write((PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (urlConnection.getResponseCode() == 200) {
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return true;
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = urlConnection;
                    try {
                        th.printStackTrace();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        return false;
                    } finally {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                dataOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
        }
    }

    private static void writeAddtionalInfo(DataOutputStream dataOutputStream, HashMap<String, String> hashMap) throws Throwable {
        if (CloudMessageManager.getInstance().getCommonParams() != null && CloudMessageManager.getInstance().getCommonParams().size() != 0) {
            dataOutputStream.write("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
            dataOutputStream.write(StringUtils.getJsonString(CloudMessageManager.getInstance().getCommonParams()).getBytes());
            dataOutputStream.write(LINE_END.getBytes());
            dataOutputStream.write((PREFIX + BOUNDARY + LINE_END).getBytes());
            dataOutputStream.flush();
        }
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        dataOutputStream.write("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        dataOutputStream.write(StringUtils.getJsonString(hashMap).getBytes());
        dataOutputStream.write(LINE_END.getBytes());
        dataOutputStream.write((PREFIX + BOUNDARY + LINE_END).getBytes());
        dataOutputStream.flush();
    }

    private static boolean postWithoutFile(String str, Map<String, String> map2, int i, String str2, String str3, long j, HashMap<String, String> hashMap) {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection urlConnection = NetUtils.getUrlConnection(str);
            try {
                urlConnection.setReadTimeout(30000);
                urlConnection.setConnectTimeout(30000);
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setUseCaches(false);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Charset", ENCODE);
                urlConnection.setRequestProperty("connection", "keep-alive");
                urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
                Map<String, String> map3 = map;
                if (map3 != null && !map3.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            urlConnection.setRequestProperty(key, value);
                        }
                    }
                }
                urlConnection.connect();
                dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(PREFIX);
                    String str4 = BOUNDARY;
                    stringBuffer.append(str4);
                    stringBuffer.append(LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + i + LINE_END + PREFIX + str4 + LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + str2 + LINE_END + PREFIX + str4 + LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + str3 + LINE_END + PREFIX + str4 + LINE_END);
                    StringBuilder append = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append.append(CloudMessageManager.getAid()).append(LINE_END).append(PREFIX).append(str4).append(LINE_END).toString());
                    StringBuilder append2 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append2.append(CloudMessageManager.getUpdateVersionCode()).append(LINE_END).append(PREFIX).append(str4).append(LINE_END).toString());
                    stringBuffer.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + j + LINE_END + PREFIX + str4 + LINE_END);
                    if (i == 2 || i == 3 || (i == 0 && hashMap != null && !hashMap.isEmpty())) {
                        dataOutputStream.write(stringBuffer.toString().getBytes());
                        writeAddtionalInfo(dataOutputStream, hashMap);
                        stringBuffer.setLength(0);
                    }
                    StringBuilder append3 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");
                    CloudMessageManager.getInstance();
                    stringBuffer.append(append3.append(CloudMessageManager.getUid()).append(LINE_END).append(PREFIX).append(str4).append(LINE_END).toString());
                    dataOutputStream.write(stringBuffer.toString().getBytes());
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    if (urlConnection.getResponseCode() == 200) {
                        if (urlConnection != null) {
                            urlConnection.disconnect();
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return true;
                    }
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = urlConnection;
                    try {
                        th.printStackTrace();
                        return false;
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                dataOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream = null;
        }
    }
}
