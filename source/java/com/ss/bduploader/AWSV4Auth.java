package com.ss.bduploader;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* loaded from: classes7.dex */
public class AWSV4Auth {
    private static String MAC_ALGORITHM = "HmacSHA256";
    protected static final char[] hexArray;
    private static Mac mMacInstance;
    private static MessageDigest mMessageDigest;
    private String accessKeyID;
    private TreeMap<String, String> awsHeaders;
    private boolean awsHeadersHasTimestamp;
    private String canonicalURI;
    private String currentDate;
    private boolean debug;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String strSignedHeader;
    private String xAmzDate;

    static {
        try {
            mMacInstance = Mac.getInstance("HmacSHA256");
            mMessageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException unused) {
        }
        hexArray = "0123456789ABCDEF".toCharArray();
    }

    private AWSV4Auth() {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private String accessKeyID;
        private TreeMap<String, String> awsHeaders;
        private String canonicalURI;
        private boolean debug = false;
        private String httpMethodName;
        private String payload;
        private TreeMap<String, ArrayList<String>> queryParameters;
        private String regionName;
        private String secretAccessKey;
        private String serviceName;

        public Builder(String str, String str2) {
            this.accessKeyID = str;
            this.secretAccessKey = str2;
        }

        public Builder regionName(String str) {
            this.regionName = str;
            return this;
        }

        public Builder serviceName(String str) {
            this.serviceName = str;
            return this;
        }

        public Builder httpMethodName(String str) {
            this.httpMethodName = str;
            return this;
        }

        public Builder canonicalURI(String str) {
            this.canonicalURI = str;
            return this;
        }

        public Builder queryParameters(TreeMap<String, ArrayList<String>> treeMap) {
            this.queryParameters = treeMap;
            return this;
        }

        public Builder awsHeaders(TreeMap<String, String> treeMap) {
            this.awsHeaders = treeMap;
            return this;
        }

        public Builder payload(String str) {
            this.payload = str;
            return this;
        }

        public Builder debug() {
            this.debug = true;
            return this;
        }

        public AWSV4Auth build() {
            return new AWSV4Auth(this);
        }
    }

    private AWSV4Auth(Builder builder) {
        this.awsHeadersHasTimestamp = false;
        this.debug = false;
        this.accessKeyID = builder.accessKeyID;
        this.secretAccessKey = builder.secretAccessKey;
        this.regionName = builder.regionName;
        this.serviceName = builder.serviceName;
        this.httpMethodName = builder.httpMethodName;
        this.canonicalURI = builder.canonicalURI;
        this.queryParameters = builder.queryParameters;
        this.awsHeaders = builder.awsHeaders;
        this.payload = builder.payload;
        this.debug = builder.debug;
        if (this.awsHeaders == null) {
            this.awsHeaders = new TreeMap<>();
        }
        String findTimestampFromHeaderCaseInsensitive = findTimestampFromHeaderCaseInsensitive();
        this.xAmzDate = findTimestampFromHeaderCaseInsensitive;
        if (findTimestampFromHeaderCaseInsensitive == null) {
            String timeStamp = getTimeStamp();
            this.xAmzDate = timeStamp;
            this.awsHeaders.put(AWSV4AuthParams.AWSAmzDateKey, timeStamp);
        } else {
            this.awsHeadersHasTimestamp = true;
        }
        this.currentDate = getDateFromTimeStamp(this.xAmzDate);
    }

    private String prepareCanonicalRequest() {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.httpMethodName).append(UpdateDialogNewBase.TYPE);
        String str = this.canonicalURI;
        String str2 = (str == null || str.trim().isEmpty()) ? "/" : this.canonicalURI;
        this.canonicalURI = str2;
        sb.append(str2).append(UpdateDialogNewBase.TYPE);
        StringBuilder sb2 = new StringBuilder("");
        TreeMap<String, ArrayList<String>> treeMap = this.queryParameters;
        if (treeMap != null && !treeMap.isEmpty()) {
            for (Map.Entry<String, ArrayList<String>> entry : this.queryParameters.entrySet()) {
                String key = entry.getKey();
                ArrayList<String> value = entry.getValue();
                for (int i = 0; i < value.size(); i++) {
                    sb2.append(key).append(ContainerUtils.KEY_VALUE_DELIMITER).append(encodeParameter(value.get(i))).append(ContainerUtils.FIELD_DELIMITER);
                    Log.i("AWSV4 queryParameters", key + "++++" + value.get(i));
                }
            }
            sb2.deleteCharAt(sb2.lastIndexOf(ContainerUtils.FIELD_DELIMITER));
            sb2.append(UpdateDialogNewBase.TYPE);
        } else {
            sb2.append(UpdateDialogNewBase.TYPE);
        }
        sb.append((CharSequence) sb2);
        StringBuilder sb3 = new StringBuilder("");
        TreeMap<String, String> treeMap2 = this.awsHeaders;
        if (treeMap2 != null && !treeMap2.isEmpty()) {
            TreeMap treeMap3 = new TreeMap();
            for (Map.Entry<String, String> entry2 : this.awsHeaders.entrySet()) {
                treeMap3.put(entry2.getKey().toLowerCase(), entry2.getValue().trim());
            }
            for (Map.Entry entry3 : treeMap3.entrySet()) {
                String lowerCase = ((String) entry3.getKey()).toLowerCase();
                String trim = ((String) entry3.getValue()).trim();
                sb3.append(lowerCase).append(";");
                sb.append(lowerCase).append(Constants.COLON_SEPARATOR).append(trim).append(UpdateDialogNewBase.TYPE);
            }
            sb.append(UpdateDialogNewBase.TYPE);
        } else {
            sb.append(UpdateDialogNewBase.TYPE);
        }
        String substring = sb3.substring(0, sb3.length() - 1);
        this.strSignedHeader = substring;
        sb.append(substring).append(UpdateDialogNewBase.TYPE);
        String str3 = this.payload;
        String str4 = str3 != null ? str3 : "";
        this.payload = str4;
        sb.append(generateHex(str4));
        if (this.debug) {
            System.out.println("##Canonical Request:\n" + sb.toString());
        }
        return sb.toString();
    }

    private String prepareStringToSign(String str) {
        String str2 = (("AWS4-HMAC-SHA256\n" + this.xAmzDate + UpdateDialogNewBase.TYPE) + this.currentDate + "/" + this.regionName + "/" + this.serviceName + "/aws4_request\n") + generateHex(str);
        if (this.debug) {
            System.out.println("##String to sign:\n" + str2);
        }
        return str2;
    }

    private String calculateSignature(String str) {
        try {
            return bytesToHex(SHA256UseMac(getSignatureKey(this.secretAccessKey, this.currentDate, this.regionName, this.serviceName), str));
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, String> getHeaders() {
        String calculateSignature = calculateSignature(prepareStringToSign(prepareCanonicalRequest()));
        if (calculateSignature != null) {
            HashMap hashMap = new HashMap(0);
            for (Map.Entry<String, String> entry : this.awsHeaders.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            hashMap.put("Authorization", buildAuthorizationString(calculateSignature));
            if (this.debug) {
                System.out.println("##Signature:\n" + calculateSignature);
                System.out.println("##Header:");
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    System.out.println(((String) entry2.getKey()) + " = " + ((String) entry2.getValue()));
                }
                System.out.println("================================");
            }
            return hashMap;
        }
        if (!this.debug) {
            return null;
        }
        System.out.println("##Signature:\n" + calculateSignature);
        return null;
    }

    private String buildAuthorizationString(String str) {
        return "AWS4-HMAC-SHA256 Credential=" + this.accessKeyID + "/" + this.currentDate + "/" + this.regionName + "/" + this.serviceName + "/aws4_request,SignedHeaders=" + this.strSignedHeader + ",Signature=" + str;
    }

    private static synchronized String generateHex(String str) {
        String format;
        synchronized (AWSV4Auth.class) {
            try {
                mMessageDigest.update(str.getBytes("UTF-8"));
                format = String.format("%064x", new BigInteger(1, mMessageDigest.digest()));
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return format;
    }

    private static synchronized byte[] SHA256UseMac(byte[] bArr, String str) throws Exception {
        byte[] doFinal;
        synchronized (AWSV4Auth.class) {
            mMacInstance.init(new SecretKeySpec(bArr, MAC_ALGORITHM));
            doFinal = mMacInstance.doFinal(str.getBytes("UTF8"));
        }
        return doFinal;
    }

    private static synchronized byte[] getSignatureKey(String str, String str2, String str3, String str4) throws Exception {
        byte[] SHA256UseMac;
        synchronized (AWSV4Auth.class) {
            SHA256UseMac = SHA256UseMac(SHA256UseMac(SHA256UseMac(SHA256UseMac(("AWS4" + str).getBytes("UTF8"), str2), str3), str4), AWSV4AuthParams.aws4Request);
        }
        return SHA256UseMac;
    }

    private String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr).toLowerCase();
    }

    private String getTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    private String getDateFromTimeStamp(String str) {
        if (str == null || str.length() < 8) {
            return null;
        }
        return str.substring(0, 8);
    }

    private String encodeParameter(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception unused) {
            return str;
        }
    }

    private String findTimestampFromHeaderCaseInsensitive() {
        TreeMap<String, String> treeMap = this.awsHeaders;
        if (treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        for (Map.Entry<String, String> entry : this.awsHeaders.entrySet()) {
            if (entry.getKey().toLowerCase().equals(AWSV4AuthParams.AWSAmzDateKey)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
