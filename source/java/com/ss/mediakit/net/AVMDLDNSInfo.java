package com.ss.mediakit.net;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AVMDLDNSInfo {
    public String mErrorStr;
    public long mExpiredTime;
    public String mHost;
    public String[] mHosts;
    public String mId;
    public String mIpList;
    public int mTaskType;
    public int mType;
    public JSONObject mExtraInfoJson = new JSONObject();
    public String mExtraInfo = "";

    public AVMDLDNSInfo(int i, String[] strArr, String str, long j, String str2, int i2) {
        this.mType = i;
        this.mHosts = strArr;
        this.mIpList = str;
        this.mExpiredTime = j;
        this.mId = str2;
        this.mTaskType = i2;
        setDnsExtInfo("task_type", i2);
    }

    public AVMDLDNSInfo(int i, String str, String str2, long j, String str3, int i2) {
        this.mType = i;
        this.mHost = str;
        this.mIpList = str2;
        this.mExpiredTime = j;
        this.mId = str3;
        this.mTaskType = i2;
        setDnsExtInfo("task_type", i2);
    }

    public AVMDLDNSInfo(int i, String str, String str2, long j, String str3, String str4, int i2) {
        this.mType = i;
        this.mHost = str;
        this.mIpList = str2;
        this.mExpiredTime = j;
        this.mId = str3;
        this.mErrorStr = str4;
        this.mTaskType = i2;
        setDnsExtInfo("task_type", i2);
    }

    public void setDnsExtInfo(String str, String str2) {
        try {
            if (this.mExtraInfoJson == null) {
                this.mExtraInfoJson = new JSONObject();
            }
            this.mExtraInfoJson.put(str, str2);
            this.mExtraInfo = this.mExtraInfoJson.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setDnsExtInfo(String str, int i) {
        try {
            if (this.mExtraInfoJson == null) {
                this.mExtraInfoJson = new JSONObject();
            }
            this.mExtraInfoJson.put(str, i);
            this.mExtraInfo = this.mExtraInfoJson.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
