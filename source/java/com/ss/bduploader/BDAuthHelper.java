package com.ss.bduploader;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.bduploader.AWSV4Auth;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes7.dex */
public class BDAuthHelper {
    public static final int keyAccessKey = 0;
    public static final int keyAuthorization = 10;
    public static final int keyCanonicalURI = 5;
    public static final int keyHost = 7;
    public static final int keyHttpMethod = 4;
    public static final int keyPlayLoad = 6;
    public static final int keyQueryStr = 11;
    public static final int keyRegionName = 2;
    public static final int keySecretKey = 1;
    public static final int keyServiceName = 3;
    public static final int keyXAmzDate = 8;
    public static final int keyXAmzSecurityToken = 9;
    private String accessKeyID;
    private String authorization;
    private TreeMap<String, String> awsHeaders;
    private String canonicalURI;
    private boolean debug = false;
    private String host;
    private String httpMethodName;
    private String payload;
    private TreeMap<String, ArrayList<String>> queryParameters;
    private String queryStr;
    private String regionName;
    private String secretAccessKey;
    private String serviceName;
    private String xAmzDate;
    private String xAmzSecurityToken;

    public String getStringValue(int i) {
        getSignature();
        if (i != 10) {
            return null;
        }
        return this.authorization;
    }

    private String parseAPIString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "parseAPIString:query string is empty";
        }
        try {
            String[] split = str.split("[?]");
            if (split.length < 2) {
                return "parseAPIString:query string param is empty";
            }
            String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
            TreeMap<String, ArrayList<String>> treeMap = new TreeMap<>();
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length >= 2) {
                    if (!treeMap.containsKey(split3[0])) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(split3[1]);
                        treeMap.put(split3[0], arrayList);
                    } else {
                        treeMap.get(split3[0]).add(split3[1]);
                    }
                }
            }
            this.queryParameters = treeMap;
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setStringValue(int i, String str) {
        switch (i) {
            case 0:
                this.accessKeyID = str;
                return;
            case 1:
                this.secretAccessKey = str;
                return;
            case 2:
                this.regionName = str;
                return;
            case 3:
                this.serviceName = str;
                return;
            case 4:
                this.httpMethodName = str;
                return;
            case 5:
                this.canonicalURI = str;
                return;
            case 6:
                this.payload = str;
                return;
            case 7:
                this.host = str;
                return;
            case 8:
                this.xAmzDate = str;
                return;
            case 9:
                this.xAmzSecurityToken = str;
                return;
            case 10:
            default:
                return;
            case 11:
                this.queryStr = str;
                return;
        }
    }

    public Map<String, String> getSignature() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put(AWSV4AuthParams.AWSAmzDateKey, this.xAmzDate);
        treeMap.put(AWSV4AuthParams.AMZ_SECURITY_TOKEN_KEY, this.xAmzSecurityToken);
        parseAPIString(this.queryStr);
        Map<String, String> headers = new AWSV4Auth.Builder(this.accessKeyID, this.secretAccessKey).regionName(this.regionName).serviceName(this.serviceName).httpMethodName(this.httpMethodName).canonicalURI(AWSV4AuthParams.CANONICAL_URI).queryParameters(this.queryParameters).awsHeaders(treeMap).payload(this.payload).build().getHeaders();
        this.authorization = headers.get("Authorization");
        return headers;
    }

    public void setQueryParameters(TreeMap<String, ArrayList<String>> treeMap) {
        this.queryParameters = treeMap;
    }

    public void setAwsHeaders(TreeMap<String, String> treeMap) {
        this.awsHeaders = treeMap;
    }
}
