package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.disk.DiskStorage;
import java.io.IOException;

/* loaded from: classes6.dex */
public interface TTDiskStorage extends DiskStorage {
    BinaryResource getTempResource(String str, Object obj) throws IOException;

    DiskStorage.Inserter insertTemp(String str, int i, Object obj) throws IOException;
}
