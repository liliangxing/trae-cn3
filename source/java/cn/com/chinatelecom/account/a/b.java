package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069 A[Catch: Exception -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x006d, blocks: (B:20:0x003d, B:39:0x0069), top: B:6:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        InputStreamReader inputStreamReader;
        File c = c(context);
        StringBuilder sb = new StringBuilder();
        if (c == null || !c.exists()) {
            return "";
        }
        try {
            try {
                fileInputStream = new FileInputStream(c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != 0) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return sb.toString();
                            } finally {
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        inputStreamReader.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    fileInputStream.close();
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                th = th;
                inputStreamReader = bufferedReader;
                th.printStackTrace();
                if (bufferedReader != null) {
                }
                if (inputStreamReader != 0) {
                }
                if (fileInputStream != null) {
                }
                return sb.toString();
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            bufferedReader = null;
        }
        return sb.toString();
    }

    public static void a(Context context, String str) {
        File c = c(context);
        if (c == null || !c.exists()) {
            a(b(context), str);
        } else {
            a(c, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x004f -> B:19:0x0069). Please report as a decompilation issue!!! */
    private static void a(File file, String str) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        if (file == null || !file.exists()) {
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file, false);
                    try {
                        bufferedWriter = new BufferedWriter(fileWriter);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bufferedWriter2 = bufferedWriter2;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th) {
                th = th;
                fileWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            boolean isEmpty = TextUtils.isEmpty(str);
            if (isEmpty != 0) {
                str = "";
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            try {
                bufferedWriter.close();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            fileWriter.close();
            bufferedWriter2 = isEmpty;
        } catch (Exception e5) {
            e = e5;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            if (fileWriter != null) {
                fileWriter.close();
                bufferedWriter2 = bufferedWriter2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (fileWriter == null) {
                throw th;
            }
            try {
                fileWriter.close();
                throw th;
            } catch (Exception e8) {
                e8.printStackTrace();
                throw th;
            }
        }
    }

    private static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            File file = new File(context.getFilesDir() + "/eAccount/Log/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "ipa_ol.ds");
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static File c(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir() + "/eAccount/Log/");
                if (!file.exists()) {
                    return null;
                }
                File file2 = new File(file, "ipa_ol.ds");
                if (file2.exists()) {
                    return file2;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
