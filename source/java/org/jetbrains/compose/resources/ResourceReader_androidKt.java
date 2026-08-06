package org.jetbrains.compose.resources;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.keva.KevaImpl;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ResourceReader.android.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"getPlatformResourceReader", "Lorg/jetbrains/compose/resources/ResourceReader;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ResourceReader_androidKt {
    public static final ResourceReader getPlatformResourceReader() {
        return new ResourceReader() { // from class: org.jetbrains.compose.resources.ResourceReader_androidKt$getPlatformResourceReader$1
            @Override // org.jetbrains.compose.resources.ResourceReader
            public Object read(String str, Continuation<? super byte[]> continuation) {
                InputStream open;
                if (StringsKt.startsWith$default(str, KevaImpl.PrivateConstants.FILES_DIR_NAME, false, 2, (Object) null) || StringsKt.startsWith$default(str, PreloadConfig.KEY_FONT, false, 2, (Object) null)) {
                    open = ResourceContextInitKt.getResourceContext().getAssets().open(getUri(str));
                    try {
                        InputStream inputStream = open;
                        Intrinsics.checkNotNull(inputStream);
                        byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
                        CloseableKt.closeFinally(open, null);
                        return readBytes;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                open = ResourceContextInitKt.getResourceContext().getAssets().open(str);
                try {
                    InputStream inputStream2 = open;
                    Intrinsics.checkNotNull(inputStream2);
                    byte[] readBytes2 = ByteStreamsKt.readBytes(inputStream2);
                    CloseableKt.closeFinally(open, null);
                    return readBytes2;
                } finally {
                }
            }

            @Override // org.jetbrains.compose.resources.ResourceReader
            public Object readPart(String str, long j, long j2, Continuation<? super byte[]> continuation) {
                InputStream open = ResourceContextInitKt.getResourceContext().getAssets().open(getUri(str));
                try {
                    InputStream inputStream = open;
                    int i = (int) j2;
                    byte[] bArr = new byte[i];
                    inputStream.skip(j);
                    inputStream.read(bArr, 0, i);
                    CloseableKt.closeFinally(open, null);
                    return bArr;
                } finally {
                }
            }

            @Override // org.jetbrains.compose.resources.ResourceReader
            public String getUri(String path) {
                Intrinsics.checkNotNullParameter(path, "path");
                return "composeResources/" + path;
            }
        };
    }
}
