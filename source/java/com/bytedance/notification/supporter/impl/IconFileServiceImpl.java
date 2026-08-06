package com.bytedance.notification.supporter.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.notification.supporter.service.IIconFileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class IconFileServiceImpl implements IIconFileService {
    private final String ICON_FILE = "proxy_icon_files";
    private final File iconDir;

    public IconFileServiceImpl(Context context) {
        this.iconDir = new File(context.getFilesDir(), "proxy_icon_files");
    }

    @Override // com.bytedance.notification.supporter.service.IIconFileService
    public Bitmap getTargetPkgIcon(String str) {
        getIconFileName(str);
        File file = new File(this.iconDir, getIconFileName(str));
        if (!file.exists()) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.notification.supporter.service.IIconFileService
    public void saveTargetPkgIcon(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = this.iconDir;
        if (file == null || bitmap == null) {
            return;
        }
        if (file.exists() || this.iconDir.mkdir()) {
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(new File(this.iconDir, getIconFileName(str)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                bitmap.compress(compressFormat, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = compressFormat;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private String getIconFileName(String str) {
        return str + ".jpg";
    }
}
