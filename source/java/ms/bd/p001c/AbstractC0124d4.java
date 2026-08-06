package ms.bd.p001c;

import java.util.HashMap;
import net.openid.appauth.BuildConfig;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okio.Buffer;

/* renamed from: ms.bd.c.d4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0124d4 {

    /* renamed from: a */
    public static final /* synthetic */ int f160a = 0;

    static {
    }

    /* renamed from: a */
    public static String m85a(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
                return buffer.readUtf8();
            }
        } catch (Exception unused) {
        }
        return BuildConfig.FLAVOR;
    }

    /* renamed from: a */
    public static RequestBody m86a(RequestBody requestBody, HashMap hashMap) {
        try {
            String m85a = m85a(requestBody);
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : hashMap.keySet()) {
                builder.add(str, ((String) hashMap.get(str)).replaceAll((String) AbstractC0190p2.m166a(16777217, 0, 0L, "531ff8", new byte[]{Byte.MAX_VALUE}), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d7e4d9", new byte[]{48, 102, 52})));
            }
            FormBody build = builder.build();
            StringBuilder sb = new StringBuilder(m85a);
            if (m85a.length() > 0) {
                sb.append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "646373", new byte[]{97}));
            }
            sb.append(m85a(build));
            return RequestBody.create(requestBody.contentType(), sb.toString());
        } catch (Exception unused) {
            return requestBody;
        }
    }
}
