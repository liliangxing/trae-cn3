package com.bytedance.frameworks.baselib.network.http.parser;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.util.ByteArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.MimeUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class StreamParser {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE_OCTET = "application/octet-stream";
    private static final String KEY_READ_RESPONSE_BUFF_INCREASE_SIZE = "read_response_buff_increase_size";
    private static final String KEY_READ_RESPONSE_BUFF_INIT_SIZE = "read_response_buff_init_size";
    private static final String KEY_RETROFIT_READ_MAX_LENGTH = "retrofit_response_max_length";
    private static final String KEY_RETROFIT_RESPONSE_MAX_LENGTH_PATH_LIST = "retrofit_response_max_length_path_prefix_list";
    private static final String KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE = "specific_init_size";
    private static final int READ_RESPONSE_FIRST_INCREASE_SIZE = 102400;
    private static final int READ_RESPONSE_FREE_MIN_BUFF_SIZE = 4096;
    private static final int READ_RESPONSE_INIT_BUFF_SIZE = 32768;
    private static final String TAG = "StreamParser";
    private static volatile int sReadBodyBuffFirstIncreaseSize;
    private static volatile int sReadBodyBuffInitSize;
    private static final Map<String, Integer> sSpecificReadBodyBuffInitSize = new ConcurrentHashMap();
    private static final int DEFAULT_MAX_API_RESPONSE_LENGTH = 5242880;
    private static volatile int sReadMaxLength = DEFAULT_MAX_API_RESPONSE_LENGTH;
    private static final Map<String, Integer> sReadMaxLengthMap = new ConcurrentHashMap();

    private static boolean isBuffSizeValid(int i) {
        return i >= 4096 && i <= DEFAULT_MAX_API_RESPONSE_LENGTH;
    }

    public static void onConfigUpdate(SharedPreferences sharedPreferences) {
        sReadBodyBuffInitSize = sharedPreferences.getInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = sharedPreferences.getInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
    }

    public static void onServerConfigUpdate(JSONObject jSONObject) {
        sReadBodyBuffInitSize = jSONObject.optInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = jSONObject.optInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE);
        if (optJSONObject != null) {
            sSpecificReadBodyBuffInitSize.clear();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                int optInt = optJSONObject.optInt(next);
                if (optInt >= 4096) {
                    sSpecificReadBodyBuffInitSize.put(next, Integer.valueOf(optInt));
                }
            }
            if (Logger.debug()) {
                Logger.d(TAG, "bufrefine, get specific init size " + sSpecificReadBodyBuffInitSize);
            }
        }
        sReadMaxLength = jSONObject.optInt(KEY_RETROFIT_READ_MAX_LENGTH, DEFAULT_MAX_API_RESPONSE_LENGTH);
        JSONObject optJSONObject2 = jSONObject.optJSONObject(KEY_RETROFIT_RESPONSE_MAX_LENGTH_PATH_LIST);
        sReadMaxLengthMap.clear();
        if (optJSONObject2 != null) {
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                int optInt2 = optJSONObject2.optInt(next2);
                if (optInt2 >= DEFAULT_MAX_API_RESPONSE_LENGTH) {
                    Map<String, Integer> map = sReadMaxLengthMap;
                    map.put(next2, Integer.valueOf(optInt2));
                    if (Logger.debug()) {
                        Logger.d(TAG, "max length refine, " + map.size() + " key " + next2 + " value " + optInt2);
                    }
                }
            }
        }
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor editor) {
        editor.putInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, sReadBodyBuffInitSize);
        editor.putInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, sReadBodyBuffFirstIncreaseSize);
    }

    public static boolean testIsSSBinary(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(CONTENT_TYPE_OCTET);
        if (indexOf >= 0) {
            indexOf = str.indexOf("ssmix=", indexOf + 24);
        }
        return indexOf > 0;
    }

    public static void decodeSSBinary(byte[] bArr, int i) throws IOException {
        if (bArr == null || i <= 0) {
            return;
        }
        byte[] bArr2 = {-99, -114, Byte.MAX_VALUE, 90};
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % 4]);
        }
    }

    public static void safeClose(Closeable closeable) {
        safeClose(closeable, null);
    }

    private static void safeClose(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (!Logger.debug() || str == null) {
                    return;
                }
                Logger.d(TAG, str + " " + e);
            }
        }
    }

    public static byte[] stream2ByteArray(int i, InputStream inputStream, long j, RequestHandler requestHandler) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                if (j > 2147483647L) {
                    Logger.w(TAG, "HTTP entity too large to be buffered in memory");
                    return null;
                }
                if (j < 0) {
                    j = 4096;
                } else if (i > 0 && j > i) {
                    Logger.w(TAG, "entity length exceed given maxLength: " + i + " " + j);
                    return null;
                }
                ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer((int) j);
                byte[] bArr = new byte[4096];
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return byteArrayBuffer.toByteArray();
                    }
                    byteArrayBuffer.append(bArr, 0, read);
                    i2 += read;
                    if (i > 0 && i2 > i) {
                        Logger.w(TAG, "entity length did exceed given maxLength");
                        return null;
                    }
                }
            } catch (Exception e) {
                if (requestHandler != null) {
                    try {
                        requestHandler.abort();
                    } catch (Throwable unused) {
                    }
                }
                throw e;
            }
        } finally {
            safeClose(inputStream);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00f4, code lost:
    
        if (r27 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00f6, code lost:
    
        r0 = r27.getURI();
        r27.abort();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00ff, code lost:
    
        com.bytedance.common.utility.Logger.v(com.bytedance.frameworks.baselib.network.http.parser.StreamParser.TAG, "download file canceled " + r0);
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x011a, code lost:
    
        safeClose(r1, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0124, code lost:
    
        if (r6 == null) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0126, code lost:
    
        r6.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x012a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0130, code lost:
    
        if (com.bytedance.common.utility.Logger.debug() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0132, code lost:
    
        com.bytedance.common.utility.Logger.d(com.bytedance.frameworks.baselib.network.http.parser.StreamParser.TAG, r14 + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0144, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00fe, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01bf, code lost:
    
        r19 = r14;
        r8 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01c3, code lost:
    
        r24.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01ca, code lost:
    
        if (r11 <= 0) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0204, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0207, code lost:
    
        r6.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x020a, code lost:
    
        safeClose(null, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0216, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x021e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x021f, code lost:
    
        r3 = r8;
        r1 = null;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0217, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0218, code lost:
    
        r3 = r8;
        r1 = null;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x022c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x022d, code lost:
    
        r3 = r8;
        r1 = null;
        r11 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0225, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0226, code lost:
    
        r3 = r8;
        r1 = null;
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01cc, code lost:
    
        r10.seek(0);
        r1 = new java.io.FileOutputStream(new java.io.File(r16, r31));
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01dd, code lost:
    
        r3 = r10.read(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01e1, code lost:
    
        if (r3 == (-1)) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01e3, code lost:
    
        r1.write(r0, 0, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01e8, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01f3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x01f4, code lost:
    
        r11 = r1;
        r3 = r8;
        r1 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x01ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x01ed, code lost:
    
        r2 = r0;
        r11 = r1;
        r3 = r8;
        r1 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x01ff, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0200, code lost:
    
        r3 = r8;
        r1 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x01f9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x01fa, code lost:
    
        r2 = r0;
        r3 = r8;
        r1 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0236, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0237, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0244, code lost:
    
        r11 = null;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0233, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0234, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x023d, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0160, code lost:
    
        com.bytedance.common.utility.Logger.w(com.bytedance.frameworks.baselib.network.http.parser.StreamParser.TAG, "entity length did exceed given maxLength");
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x016f, code lost:
    
        throw new com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException(r28, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0175, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0176, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0059, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x028d, code lost:
    
        r27.abort();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0170, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0171, code lost:
    
        r2 = r0;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x004e, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x029e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [long] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean stream2File(InputStream inputStream, long j, RequestHandler requestHandler, int i, String str, String str2, String str3, IDownloadPublisher<String> iDownloadPublisher, String str4, TaskInfo taskInfo) throws Exception {
        File file;
        ?? r10;
        File file2;
        String str5;
        String str6;
        ?? r11;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        boolean z;
        File createTempFile;
        long j2;
        int i2;
        InputStream inputStream2 = inputStream;
        ?? r2 = j;
        String str7 = str;
        String str8 = ".tmp";
        if (inputStream2 == null) {
            return false;
        }
        String str9 = "delete temp file exception ";
        String str10 = "close random file exception ";
        try {
            if (r2 > 2147483647L) {
                Logger.w(TAG, "HTTP entity too large");
                throw new DownloadFileTooLargeException(i, 2147483647L);
            }
            try {
                if (r2 < 0) {
                    r2 = 4096;
                } else if (i > 0 && r2 > i) {
                    Logger.w(TAG, "entity length exceed given maxLength");
                    throw new DownloadFileTooLargeException(i, r2);
                }
                try {
                    File file3 = new File(str7);
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    try {
                        createTempFile = File.createTempFile("tempimage", ".tmp", new File(str7));
                    } catch (IOException e) {
                        if (StringUtils.isEmpty(str2) || str2.equals(str7)) {
                            throw e;
                        }
                        File file4 = new File(str2);
                        if (!file4.exists()) {
                            file4.mkdirs();
                        }
                        createTempFile = File.createTempFile("tempimage", ".tmp", new File(str2));
                        str7 = str2;
                    }
                    file = createTempFile;
                    if (file == null) {
                        safeClose(inputStream2, "close instream exception ");
                        safeClose(null, "close outstream exception ");
                        safeClose(null, "close random file exception ");
                        if (file == null) {
                            return false;
                        }
                        try {
                            file.delete();
                            return false;
                        } catch (Exception e2) {
                            if (!Logger.debug()) {
                                return false;
                            }
                            Logger.d(TAG, "delete temp file exception " + e2);
                            return false;
                        }
                    }
                    str8 = "close outstream exception ";
                    try {
                        r10 = new RandomAccessFile(file, "rw");
                        try {
                            r10.setLength(0L);
                            byte[] bArr = new byte[4096];
                            String str11 = str7;
                            long j3 = 0;
                            long j4 = 0;
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                if (taskInfo != null) {
                                    try {
                                        if (taskInfo.isCanceled()) {
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        str5 = str9;
                                        str6 = str10;
                                        z = r10;
                                        r11 = null;
                                        r10 = z;
                                        if (requestHandler != null) {
                                        }
                                        try {
                                            throw e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            th = th;
                                            closeable = r10;
                                            safeClose(inputStream2, "close instream exception ");
                                            safeClose(r11, str8);
                                            safeClose(closeable, str6);
                                            if (file == null) {
                                                throw th;
                                            }
                                            try {
                                                file.delete();
                                                throw th;
                                            } catch (Exception e4) {
                                                if (!Logger.debug()) {
                                                    throw th;
                                                }
                                                Logger.d(TAG, str5 + e4);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str5 = str9;
                                        str6 = str10;
                                        closeable2 = r10;
                                        r11 = null;
                                        closeable = closeable2;
                                        safeClose(inputStream2, "close instream exception ");
                                        safeClose(r11, str8);
                                        safeClose(closeable, str6);
                                        if (file == null) {
                                        }
                                    }
                                }
                                str5 = str9;
                                String str12 = str10;
                                long j5 = j3 + read;
                                if (i > 0 && j5 > i) {
                                    break;
                                }
                                try {
                                    r10.write(bArr, 0, read);
                                    if (iDownloadPublisher != null && str4 != null) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (currentTimeMillis - j4 >= 500) {
                                            if (r2 >= j5) {
                                                j2 = j5;
                                                i2 = (int) ((100 * j5) / r2);
                                            } else {
                                                j2 = j5;
                                                i2 = 80;
                                            }
                                            if (i2 >= 99) {
                                                i2 = 99;
                                            }
                                            iDownloadPublisher.publishProgress(i2, str4);
                                            j4 = currentTimeMillis;
                                            j3 = j2;
                                            str10 = str12;
                                            str9 = str5;
                                        }
                                    }
                                    j2 = j5;
                                    j3 = j2;
                                    str10 = str12;
                                    str9 = str5;
                                } catch (Exception e5) {
                                    e = e5;
                                    str6 = str12;
                                    z = r10;
                                    r11 = null;
                                    r10 = z;
                                    if (requestHandler != null) {
                                    }
                                    throw e;
                                } catch (Throwable th4) {
                                    th = th4;
                                    str6 = str12;
                                    closeable2 = r10;
                                    r11 = null;
                                    closeable = closeable2;
                                    safeClose(inputStream2, "close instream exception ");
                                    safeClose(r11, str8);
                                    safeClose(closeable, str6);
                                    if (file == null) {
                                    }
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str5 = str9;
                            str6 = str10;
                        } catch (Throwable th5) {
                            th = th5;
                            str5 = str9;
                            str6 = str10;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str5 = "delete temp file exception ";
                        str6 = "close random file exception ";
                        file2 = null;
                    } catch (Throwable th6) {
                        th = th6;
                        str5 = "delete temp file exception ";
                        str6 = "close random file exception ";
                        r10 = 0;
                    }
                } catch (Exception e8) {
                    e = e8;
                    str5 = "delete temp file exception ";
                    str6 = "close random file exception ";
                    str8 = "close outstream exception ";
                    r2 = 0;
                    file = r2;
                    file2 = file;
                    r11 = file2;
                    r10 = file2;
                    if (requestHandler != null) {
                    }
                    throw e;
                } catch (Throwable th7) {
                    th = th7;
                    str5 = "delete temp file exception ";
                    str6 = "close random file exception ";
                    str8 = "close outstream exception ";
                    r2 = 0;
                    file = r2;
                    r10 = file;
                    r11 = r10;
                    th = th;
                    closeable = r10;
                    safeClose(inputStream2, "close instream exception ");
                    safeClose(r11, str8);
                    safeClose(closeable, str6);
                    if (file == null) {
                    }
                }
            } catch (Exception e9) {
                e = e9;
                str5 = "delete temp file exception ";
                str6 = "close random file exception ";
                str8 = "close outstream exception ";
                file = null;
            } catch (Throwable th8) {
                th = th8;
                str5 = "delete temp file exception ";
                str6 = "close random file exception ";
                str8 = "close outstream exception ";
                file = null;
            }
        } catch (Exception e10) {
            e = e10;
            file = r2;
            file2 = file;
            r11 = file2;
            r10 = file2;
            if (requestHandler != null) {
            }
            throw e;
        } catch (Throwable th9) {
            th = th9;
            file = r2;
            r10 = file;
            r11 = r10;
            th = th;
            closeable = r10;
            safeClose(inputStream2, "close instream exception ");
            safeClose(r11, str8);
            safeClose(closeable, str6);
            if (file == null) {
            }
        }
    }

    public static byte[] response2buf(boolean z, Map<String, List<String>> map, int i, InputStream inputStream, int[] iArr, RequestHandler requestHandler) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] readResponse = readResponse(z, map, i, inputStream, iArr, null);
            if (readResponse == null || iArr[0] <= 0) {
                return null;
            }
            return readResponse;
        } catch (Exception e) {
            if (requestHandler != null) {
                try {
                    requestHandler.abort();
                } catch (Throwable unused) {
                }
            }
            throw e;
        }
    }

    private static int getMaxLength(int i, RetrofitMetrics retrofitMetrics) {
        Integer num;
        Map<String, Integer> map = sReadMaxLengthMap;
        if (!map.isEmpty() && retrofitMetrics != null && retrofitMetrics.url != null) {
            String path = retrofitMetrics.url.getPath();
            for (String str : map.keySet()) {
                if (path.startsWith(str) && (num = sReadMaxLengthMap.get(str)) != null) {
                    return num.intValue();
                }
            }
        }
        return i >= DEFAULT_MAX_API_RESPONSE_LENGTH ? i : Math.max(sReadMaxLength, DEFAULT_MAX_API_RESPONSE_LENGTH);
    }

    public static byte[] readResponse(boolean z, Map<String, List<String>> map, int i, InputStream inputStream, int[] iArr, RetrofitMetrics retrofitMetrics) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            inputStream = processInputStream(inputStream, map, z, retrofitMetrics);
            return readResponseInternal(z, i, inputStream, iArr, retrofitMetrics, false, false);
        } finally {
            safeClose(inputStream);
        }
    }

    public static byte[] readResponseInternal(boolean z, int i, InputStream inputStream, int[] iArr, RetrofitMetrics retrofitMetrics, boolean z2, boolean z3) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int maxLength = getMaxLength(i, retrofitMetrics);
        if (Logger.debug()) {
            Logger.d(TAG, "readResponseInternal maxLength is " + maxLength);
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (z3) {
                return readResponseWithZeroCopy(inputStream, retrofitMetrics);
            }
            if (z2) {
                byte[] readResponseWithOkio = readResponseWithOkio(maxLength, inputStream, retrofitMetrics);
                if (retrofitMetrics != null) {
                    retrofitMetrics.extra.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                return readResponseWithOkio;
            }
            byte[] readResponseLegacy = readResponseLegacy(z, maxLength, inputStream, iArr, retrofitMetrics);
            if (retrofitMetrics != null) {
                retrofitMetrics.extra.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            return readResponseLegacy;
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.extra.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private static byte[] readResponseWithOkio(int i, InputStream inputStream, RetrofitMetrics retrofitMetrics) throws IOException {
        Buffer buffer = new Buffer();
        try {
            BufferedSource buffer2 = Okio.buffer(Okio.source(inputStream));
            while (!buffer2.exhausted()) {
                try {
                    long j = i;
                    if (buffer2.read(buffer, j - buffer.size()) == -1 || buffer.size() > j) {
                        throw new DownloadFileTooLargeException(i, buffer.size());
                    }
                } finally {
                }
            }
            if (retrofitMetrics != null) {
                retrofitMetrics.responseReadType = 1;
                retrofitMetrics.extra.put("streamReadByteCount", Long.valueOf(buffer.size()));
            }
            byte[] readByteArray = buffer.readByteArray();
            if (buffer2 != null) {
                buffer2.close();
            }
            return readByteArray;
        } catch (Exception e) {
            Logger.e("ttnet_okio", e.getMessage());
            throw e;
        }
    }

    public static byte[] readResponseWithZeroCopy(InputStream inputStream, RetrofitMetrics retrofitMetrics) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            inputStream.read(new byte[0]);
            int available = inputStream.available();
            if (Logger.debug()) {
                Logger.d("ttnet_0cp", "available size is " + available);
            }
            byte[] bArr = new byte[available];
            inputStream.read(bArr);
            if (retrofitMetrics != null) {
                retrofitMetrics.responseReadType = 2;
                retrofitMetrics.extra.put("streamReadByteCount", Long.valueOf(available));
            }
            return bArr;
        } catch (IOException e) {
            Logger.e("ttnet_0cp", e.getMessage());
            throw e;
        }
    }

    private static byte[] readResponseLegacy(boolean z, int i, InputStream inputStream, int[] iArr, RetrofitMetrics retrofitMetrics) throws IOException {
        int read;
        Integer num;
        int i2 = isBuffSizeValid(sReadBodyBuffInitSize) ? sReadBodyBuffInitSize : 32768;
        int i3 = isBuffSizeValid(sReadBodyBuffFirstIncreaseSize) ? sReadBodyBuffFirstIncreaseSize : READ_RESPONSE_FIRST_INCREASE_SIZE;
        if (retrofitMetrics != null && retrofitMetrics.url != null && !TextUtils.isEmpty(retrofitMetrics.url.getPath()) && (num = sSpecificReadBodyBuffInitSize.get(retrofitMetrics.url.getPath())) != null) {
            i2 = num.intValue();
        }
        if (Logger.debug() && retrofitMetrics != null && retrofitMetrics.url != null) {
            Logger.d(TAG, "bufrefine " + retrofitMetrics.url.getPath() + " read init buf size is " + i2);
        }
        byte[] bArr = new byte[i2];
        int i4 = 0;
        int i5 = 0;
        do {
            try {
                if (i4 + 4096 > bArr.length) {
                    byte[] bArr2 = new byte[bArr.length < i3 ? bArr.length + i3 : bArr.length * 2];
                    System.arraycopy(bArr, 0, bArr2, 0, i4);
                    i5++;
                    bArr = bArr2;
                }
                read = inputStream.read(bArr, i4, bArr.length - i4);
            } catch (EOFException e) {
                if (z && i4 > 0) {
                    Logger.w(TAG, "ungzip got exception " + e);
                } else {
                    throw e;
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                if (z && i4 > 0 && ("CRC mismatch".equals(message) || "Size mismatch".equals(message))) {
                    Logger.w(TAG, "ungzip got exception " + e2);
                } else {
                    throw e2;
                }
            } catch (OutOfMemoryError e3) {
                Logger.e(TAG, "new buff error" + e3);
                return null;
            }
            if (read <= 0) {
                if (i4 <= 0) {
                    return null;
                }
                if (retrofitMetrics != null) {
                    retrofitMetrics.responseReadType = 0;
                    retrofitMetrics.extra.put("streamReadByteCount", Long.valueOf(i4));
                    retrofitMetrics.streamParserCopyCount = i5;
                }
                if (Logger.debug() && retrofitMetrics != null && retrofitMetrics.url != null) {
                    Logger.d(TAG, "bufrefine " + retrofitMetrics.url.getPath() + " copyTimes is " + i5 + " final length is " + i4);
                }
                byte[] bArr3 = new byte[i4];
                System.arraycopy(bArr, 0, bArr3, 0, i4);
                iArr[0] = i4;
                return bArr3;
            }
            i4 += read;
        } while (i4 <= i);
        Logger.w(TAG, "entity length did exceed given maxLength");
        throw new DownloadFileTooLargeException(i, i4);
    }

    public static String bytesToString(byte[] bArr, Map<String, String> map) throws Exception {
        if (bArr == null) {
            return null;
        }
        String str = map.get("Content-Type");
        if (TextUtils.isEmpty(str)) {
            str = map.get("Content-Type".toLowerCase());
        }
        return bytesToString(bArr, str);
    }

    public static String bytesToString(byte[] bArr, String str) throws Exception {
        if (bArr == null) {
            return null;
        }
        String str2 = UrlUtils.UTF_8;
        String parseCharset = MimeUtil.parseCharset(str, UrlUtils.UTF_8);
        if (parseCharset != null) {
            str2 = parseCharset;
        }
        return new String(bArr, str2);
    }

    public static InputStream processInputStream(InputStream inputStream, Map<String, List<String>> map, boolean z, RetrofitMetrics retrofitMetrics) throws IOException {
        if (z) {
            return new GZIPInputStream(inputStream);
        }
        NetworkParams.StreamProcessor streamProcessor = NetworkParams.getStreamProcessor();
        if (streamProcessor == null) {
            return inputStream;
        }
        if (retrofitMetrics != null) {
            retrofitMetrics.inputStreamProcessStart();
        }
        try {
            return streamProcessor.processInputStream(inputStream, map, retrofitMetrics);
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.inputStreamProcessEnd();
            }
        }
    }
}
