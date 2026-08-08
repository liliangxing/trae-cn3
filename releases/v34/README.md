# v34 — FileName = Earliest Message + Token Redaction + Preview Fix

## Changes

- File name now uses the **earliest** user message (previously used the latest message by mistake)
- GitHub auth tokens in the file name are redacted to `xxx` via regex (privacy protection)
- Preview no longer loads HTML via `file://` (fixes `net::ERR_ACCESS_DENIED`)
  - Uses FileProvider to build a `content://` URI that WebView can render
- Markdown rendered to static HTML in Java, no longer depends on marked CDN (works offline)

## Files

- `trae_cn3_v34.apk` — DOWNLOAD from [GitHub Releases](https://github.com/liliangxing/trae-cn3/releases/tag/v34)

## Build Notes

Input APK: v33 (`trae_cn3_v33.apk`). Toolchain: JDK 17, dx 1.13, apktool 2.9.3,
baksmali 2.5.2, uber-apk-signer 1.3.0.

Build command:

```bash
bash build.sh /data/user/work/trae_cn3_v33.apk /data/user/work/trae_cn3_v34.apk
```

See `../BUILD_SCRIPT/PACKAGE_POLICY.md` for build instructions.
