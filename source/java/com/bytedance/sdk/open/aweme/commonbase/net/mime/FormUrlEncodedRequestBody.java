package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.net.OpenRequestBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes5.dex */
public class FormUrlEncodedRequestBody extends OpenRequestBody {
    private ByteArrayOutputStream content = new ByteArrayOutputStream();

    public void addField(String str, Boolean bool, String str2, Boolean bool2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.content.size() > 0) {
            this.content.write(38);
        }
        try {
            if (bool.booleanValue()) {
                str = URLEncoder.encode(str, "UTF-8");
            }
            if (bool2.booleanValue()) {
                str2 = URLEncoder.encode(str2, "UTF-8");
            }
            this.content.write(str.getBytes("UTF-8"));
            this.content.write(61);
            this.content.write(str2.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addField(String str, String str2) {
        Boolean bool = Boolean.TRUE;
        addField(str, bool, str2, bool);
    }

    public void addFields(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            addField(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String contentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content.toByteArray());
    }
}
