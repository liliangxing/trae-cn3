package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.utils.UriParserKt;
import com.bytedance.iesgurd.IESGurdResData;
import com.bytedance.iesgurd.IESGurdResFrom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* compiled from: GeckoFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"checkFileContentAvailable", "", "Lcom/bytedance/iesgurd/IESGurdResData;", "forest_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoFetcherKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkFileContentAvailable(IESGurdResData iESGurdResData) {
        InputStream data;
        try {
            if (iESGurdResData.getResFrom() == IESGurdResFrom.OFFLINE && (data = iESGurdResData.getData()) != null && data.available() == 0) {
                throw new IOException();
            }
            String path = iESGurdResData.getPath();
            if (path == null) {
                return true;
            }
            if (!(!UriParserKt.isHttpUrl(path))) {
                path = null;
            }
            if (path == null) {
                return true;
            }
            File file = new File(path);
            if (!file.exists()) {
                file = null;
            }
            if (file == null) {
                return true;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() == 0) {
                    throw new IOException();
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                return true;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
