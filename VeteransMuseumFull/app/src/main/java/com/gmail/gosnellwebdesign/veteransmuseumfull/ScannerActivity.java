package com.gmail.gosnellwebdesign.veteransmuseumfull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Scanner;

public class ScannerActivity extends AppCompatActivity {
    CodeScanner codeScanner;
    CodeScannerView scannerView;
    TextView textViewQRResult;
    String codeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        // Widget references
        scannerView = findViewById(R.id.scannerView);
        codeScanner = new CodeScanner(this, scannerView);
        textViewQRResult = findViewById(R.id.textViewQRResult);

        textViewQRResult.setText("");

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            // Get codeString from recognized QR codes
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //textViewQRResult.setText(result.getText());
                        codeString = result.getText();
                        processQRResult();
                    }
                });
            }
        });

        // Open activity preview
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScanner.startPreview();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        requestForCamera();
    }

    // Request user's permission to use camera in-app
    private void requestForCamera() {
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                codeScanner.startPreview();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Toast.makeText(ScannerActivity.this, "Camera Permission is Required", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    // Open link from QR code
    private void processQRResult() {
        //Intent to new screen that displays HTTP requested WP content
        //If (QR code) then (display specific content associated with QR code)

        //Send code to new activity, process it there
        Intent i = new Intent(getApplicationContext(), ScannerResultActivity.class);
        i.putExtra("QRCode", codeString);
        startActivity(i);
    }
}