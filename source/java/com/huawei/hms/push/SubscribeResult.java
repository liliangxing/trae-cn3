package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: classes6.dex */
public class SubscribeResult extends Result {
    private String a;
    private List<SubscribedItem> b;

    public String getErrorMsg() {
        return this.a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.b;
    }

    public void setErrorMsg(String str) {
        this.a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.b = list;
    }
}
