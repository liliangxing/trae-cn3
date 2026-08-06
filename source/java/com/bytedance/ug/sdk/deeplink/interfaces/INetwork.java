package com.bytedance.ug.sdk.deeplink.interfaces;

import com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes4.dex */
public interface INetwork {
    public static final INetwork DEFAULT = new INetwork() { // from class: com.bytedance.ug.sdk.deeplink.interfaces.INetwork.1
        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public void fetchScheme(String str, String str2, int i, CallBackForFetchScheme callBackForFetchScheme) throws Exception {
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public String get(String str, Map<String, String> map, boolean z, long j) throws Exception {
            URL url;
            try {
                url = new URL(str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    return inputStream2String(httpURLConnection.getInputStream());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public String post(String str, Map<String, String> map, byte[] bArr, long j, boolean z, String str2, boolean z2) throws Exception {
            URL url;
            try {
                url = new URL(str);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                url = null;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (j > 0) {
                    httpURLConnection.setConnectTimeout((int) j);
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", str2);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    return inputStream2String(httpURLConnection.getInputStream());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }

        public String inputStream2String(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    return byteArrayOutputStream.toString();
                }
            }
        }
    };

    void fetchScheme(String str, String str2, int i, CallBackForFetchScheme callBackForFetchScheme) throws Exception;

    String get(String str, Map<String, String> map, boolean z, long j) throws Exception;

    String post(String str, Map<String, String> map, byte[] bArr, long j, boolean z, String str2, boolean z2) throws Exception;
}
