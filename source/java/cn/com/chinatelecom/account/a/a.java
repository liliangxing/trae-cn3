package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "a";

    public static String a(Context context, String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2;
        String str3 = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                if (TextUtils.isEmpty(str2)) {
                    httpURLConnection.connect();
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    dataOutputStream.write(str2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine).append(UpdateDialogNewBase.TYPE);
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                Throwable th2 = th;
                                inputStream = inputStream2;
                                th = th2;
                                try {
                                    th.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return str3;
                                } catch (Throwable th3) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            throw th3;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th3;
                                }
                            }
                        }
                        str3 = sb.toString();
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    inputStream2 = null;
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str3;
    }
}
