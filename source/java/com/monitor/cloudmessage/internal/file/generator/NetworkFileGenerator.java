package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.core.ResManager;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class NetworkFileGenerator {
    private static final int DEFAULT_PING_TIME = 5;
    private static final String FROM_PING = "From";
    private static final String SMALL_FROM_PING = "from";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c2 A[Catch: IOException -> 0x01be, TRY_LEAVE, TryCatch #18 {IOException -> 0x01be, blocks: (B:76:0x01ba, B:69:0x01c2), top: B:75:0x01ba }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01eb A[Catch: IOException -> 0x01e7, TRY_LEAVE, TryCatch #10 {IOException -> 0x01e7, blocks: (B:103:0x01e3, B:94:0x01eb), top: B:102:0x01e3 }] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedWriter] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File generateFile(Context context, JSONObject jSONObject) {
        String str;
        FileWriter fileWriter;
        InputStream inputStream;
        ?? r3;
        OutputStream outputStream;
        InputStream inputStream2;
        ?? r32;
        FileWriter fileWriter2;
        BufferedWriter bufferedWriter;
        String optString = jSONObject.optString("domain");
        OutputStream outputStream2 = null;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (optString.startsWith(ResManager.HTTP_SCHEME) || optString.startsWith("https://")) {
            str = null;
        } else {
            str = ResManager.HTTP_SCHEME + optString;
            optString = "https://" + optString;
        }
        try {
            String host = new URL(optString).getHost();
            String absolutePath = FileUtils.getCloudMsgDir(context).getAbsolutePath();
            String str2 = absolutePath + File.separator + String.format("%s.txt", host);
            jSONObject2.put("networkType", NetworkUtils.getNetworkAccessType(context));
            jSONObject2.put("currentNativeIP", NetworkUtils.getNativeIp());
            jSONObject2.put("localDNS", NetworkUtils.getLocalDNS(context));
            jSONObject2.put("localGateway", NetworkUtils.getGateway(context));
            jSONObject2.put("uploadSpeed", NetworkUtils.getUploadSpeed(context));
            jSONObject2.put("downloadSpeed", NetworkUtils.getDownloadSpeed(context));
            jSONObject2.put("cdn", host);
            jSONObject2.put("domainNameParse", NetworkUtils.parseDomainName(host));
            if (!NetworkUtils.testGet(optString, jSONObject2) && str != null) {
                NetworkUtils.testGet(str, jSONObject2);
            }
            Process exec = Runtime.getRuntime().exec("ping -c 5 " + host);
            OutputStream outputStream3 = exec.getOutputStream();
            try {
                outputStream3.close();
                long nanoTime = System.nanoTime();
                inputStream = exec.getInputStream();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
                    JSONArray jSONArray = new JSONArray();
                    float f = 0.0f;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        jSONArray.put(readLine);
                        if (readLine.contains(FROM_PING) || readLine.contains("from")) {
                            f = ((float) (System.nanoTime() - nanoTime)) / 1000000.0f;
                        }
                    }
                    exec.destroy();
                    jSONObject2.put("pingResults", jSONArray);
                    jSONObject2.put("elapsedTime", f);
                    File file = new File(absolutePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    FileWriter fileWriter3 = new FileWriter(str2);
                    try {
                        bufferedWriter = new BufferedWriter(fileWriter3);
                        try {
                            bufferedWriter.write(jSONObject2.toString());
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            try {
                                bufferedWriter.close();
                                fileWriter3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            return new File(str2);
                        } catch (Exception e4) {
                            e = e4;
                            fileWriter = fileWriter3;
                            e = e;
                            inputStream2 = inputStream;
                            outputStream = outputStream3;
                            r32 = bufferedWriter;
                            try {
                                e.printStackTrace();
                                if (outputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                if (r32 != 0) {
                                }
                                if (fileWriter != null) {
                                }
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                outputStream2 = outputStream;
                                inputStream = inputStream2;
                                r3 = r32;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (r3 != 0) {
                                    try {
                                        r3.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileWriter != null) {
                                    fileWriter.close();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream2 = outputStream3;
                            fileWriter = fileWriter3;
                            th = th;
                            r3 = bufferedWriter;
                            if (outputStream2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (r3 != 0) {
                            }
                            if (fileWriter != null) {
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        bufferedWriter = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = null;
                    }
                } catch (Exception e9) {
                    e = e9;
                    inputStream2 = inputStream;
                    r32 = 0;
                    outputStream = outputStream3;
                    fileWriter = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileWriter2 = null;
                    outputStream2 = outputStream3;
                    fileWriter = fileWriter2;
                    r3 = fileWriter2;
                    if (outputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (r3 != 0) {
                    }
                    if (fileWriter != null) {
                    }
                }
            } catch (Exception e10) {
                e = e10;
                outputStream = outputStream3;
                fileWriter = null;
                inputStream2 = null;
                r32 = inputStream2;
                e.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                if (r32 != 0) {
                    try {
                        r32.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                        return null;
                    }
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                fileWriter2 = null;
            }
        } catch (Exception e14) {
            e = e14;
            fileWriter = null;
            outputStream = null;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileWriter = null;
            inputStream = null;
            r3 = 0;
        }
    }
}
