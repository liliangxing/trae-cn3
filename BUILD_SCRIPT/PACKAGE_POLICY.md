# Package Policy

## Package Name

All future builds MUST use the package name: **`com.bytedance.trae.cn3`**

This is the consistent naming used by the compiled class namespace, the AndroidManifest package attribute, and the resources.arsc package name.

## App Display Name

The app display name (app_name string resource) is: **`TRAE3`**

## Keystore

The release keystore for signing is `release_cn3.keystore` with:
- Alias: `android`
- Store password: `12345678`
- Key password: `12345678`

KEEP THIS FILE SECURE. Do not commit it to public repositories.

## Build Verification

After building:
1. Verify package: `aapt dump badging TRAE3_cn3.apk | grep package`
   - Expected: `package: name='com.bytedance.trae.cn3' ...`
2. Verify app name: `aapt dump badging TRAE3_cn3.apk | grep application-label`
   - Expected: `application-label:'TRAE3'`
3. Verify signature: `apksigner verify --verbose TRAE3_cn3.apk`
   - Expected: v2+v3 verified
