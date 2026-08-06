package okhttp3;

import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
