package ru.badver.docscanner;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.scanlibrary.ScanActivity;
import com.scanlibrary.ScanConstants;

public class RNDocScannerModule extends ReactContextBaseJavaModule {
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String E_PICKER_CANCELLED = "E_PICKER_CANCELLED";
    private static final String E_FAILED_TO_SCAN_DOCUMENT = "E_FAILED_TO_SCAN_DOCUMENT";
    private static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";

    private static final int SCAN_REQUEST_CODE = 77;
    private final ReactApplicationContext reactContext;
    private Promise scannerPromise;

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            if (requestCode == SCAN_REQUEST_CODE) {
                if (scannerPromise != null) {
                    if (resultCode == Activity.RESULT_OK) {
                        Bundle extras = data.getExtras();
                        if (extras != null) {
                            Uri uri = extras.getParcelable(ScanConstants.SCANNED_RESULT);
                            if (uri == null) {
                                scannerPromise.reject(E_NO_IMAGE_DATA_FOUND, "No image data found");
                            } else {
                                scannerPromise.resolve(uri.toString());
                            }
                        } else {
                            scannerPromise.reject(E_NO_IMAGE_DATA_FOUND, "No image data found");
                        }
                    } else {
                        scannerPromise.reject(E_PICKER_CANCELLED, "Document scanner was cancelled");
                    }
                    scannerPromise = null;
                }
            }
        }
    };

    public RNDocScannerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return "RNDocScanner";
    }

    @ReactMethod
    public void startScan(int preference, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }

        scannerPromise = promise;
        try {
            Intent intent = new Intent(getReactApplicationContext(), ScanActivity.class);
            intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, preference);
            currentActivity.startActivityForResult(intent, SCAN_REQUEST_CODE);
        } catch (Exception e) {
            scannerPromise.reject(E_FAILED_TO_SCAN_DOCUMENT, e);
            scannerPromise = null;
        }
    }
}