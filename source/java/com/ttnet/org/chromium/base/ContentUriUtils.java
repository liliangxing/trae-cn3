package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: classes7.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = new Object();

    /* loaded from: classes7.dex */
    public interface FileProviderUtil {
        Uri getContentUriFromFile(File file);
    }

    private ContentUriUtils() {
    }

    public static void setFileProviderUtil(FileProviderUtil fileProviderUtil) {
        synchronized (sLock) {
            sFileProviderUtil = fileProviderUtil;
        }
    }

    public static Uri getContentUriFromFile(File file) {
        synchronized (sLock) {
            FileProviderUtil fileProviderUtil = sFileProviderUtil;
            if (fileProviderUtil == null) {
                return null;
            }
            return fileProviderUtil.getContentUriFromFile(file);
        }
    }

    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }

    public static boolean contentUriExists(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        boolean z = assetFileDescriptor != null;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
        return z;
    }

    public static String getMimeType(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVirtualDocument(parse)) {
            String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
            if (streamTypes == null || streamTypes.length <= 0) {
                return null;
            }
            return streamTypes[0];
        }
        return contentResolver.getType(parse);
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        try {
            if (isVirtualDocument(parse)) {
                String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                if (streamTypes != null && streamTypes.length > 0) {
                    AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(parse, streamTypes[0], null);
                    if (openTypedAssetFileDescriptor == null || openTypedAssetFileDescriptor.getStartOffset() == 0) {
                        return openTypedAssetFileDescriptor;
                    }
                    try {
                        openTypedAssetFileDescriptor.close();
                    } catch (IOException unused) {
                    }
                    throw new SecurityException("Cannot open files with non-zero offset type.");
                }
            } else {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(parse, DownloadFileUtils.MODE_READ);
                if (openFileDescriptor != null) {
                    return new AssetFileDescriptor(openFileDescriptor, 0L, -1L);
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Cannot open content uri: %s", str, e);
        }
        return null;
    }

    public static String getDisplayName(Uri uri, Context context, String str) {
        String[] streamTypes;
        String extensionFromMimeType;
        if (uri == null) {
            return "";
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Cursor query = contentResolver.query(uri, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        int columnIndex = query.getColumnIndex(str);
                        if (columnIndex == -1) {
                            if (query != null) {
                                query.close();
                            }
                            return "";
                        }
                        String string = query.getString(columnIndex);
                        if (hasVirtualFlag(query) && (streamTypes = contentResolver.getStreamTypes(uri, "*/*")) != null && streamTypes.length > 0 && (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(streamTypes[0])) != null) {
                            string = string + LibrarianImpl.Constants.DOT + extensionFromMimeType;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return string;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (NullPointerException unused) {
        }
        return "";
    }

    public static String maybeGetDisplayName(String str) {
        try {
            String displayName = getDisplayName(Uri.parse(str), ContextUtils.getApplicationContext(), "_display_name");
            if (TextUtils.isEmpty(displayName)) {
                return null;
            }
            return displayName;
        } catch (Exception e) {
            Log.w(TAG, "Cannot open content uri: %s", str, e);
            return null;
        }
    }

    private static boolean isVirtualDocument(Uri uri) {
        if (uri == null || !DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), uri)) {
            return false;
        }
        try {
            Cursor query = ContextUtils.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() >= 1) {
                        query.moveToFirst();
                        boolean hasVirtualFlag = hasVirtualFlag(query);
                        if (query != null) {
                            query.close();
                        }
                        return hasVirtualFlag;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    private static boolean hasVirtualFlag(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(RouterConstants.QUERY_KEY_FLAGS);
        return columnIndex > -1 && (cursor.getLong(columnIndex) & 512) != 0;
    }

    public static boolean isContentUri(String str) {
        Uri parse;
        return (str == null || (parse = Uri.parse(str)) == null || !"content".equals(parse.getScheme())) ? false : true;
    }

    public static boolean delete(String str) {
        return ContextUtils.getApplicationContext().getContentResolver().delete(Uri.parse(str), null, null) > 0;
    }

    public static String getContentUriFromFilePath(String str) {
        try {
            Uri contentUriFromFile = getContentUriFromFile(new File(str));
            if (contentUriFromFile != null) {
                return contentUriFromFile.toString();
            }
            return null;
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Cannot retrieve content uri from file: %s", str, e);
            return null;
        }
    }
}
