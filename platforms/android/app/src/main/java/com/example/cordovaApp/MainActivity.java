
package com.example.cordovaApp;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;

import org.apache.cordova.*;

import ae.network.nicardmanagementsdk.api.interfaces.SuccessErrorCancelResponse;
import ae.network.nicardmanagementsdk.api.models.input.NIConnectionProperties;
import ae.network.nicardmanagementsdk.api.models.input.NIDisplayAttributes;
import ae.network.nicardmanagementsdk.api.models.input.NIInput;
import ae.network.nicardmanagementsdk.api.models.input.NIPinFormType;
import ae.network.nicardmanagementsdk.presentation.ui.set_pin.SetPinFragment;
import ae.network.nicardmanagementsdk.presentation.ui.set_pin.SetPinFragmentFromActivity;

public class MainActivity extends CordovaActivity implements SetPinFragment.OnFragmentInteractionListener
{
    private NIInput niInput;
    private NIPinFormType pinLength;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mf_ni_wrapper); // Replace with your main layout

        // Initialize niInput and pinLength here
        // Example initialization:
        niInput = new NIInput(
                "MF3",
                "FB1ABA5C-B58D-15BC-E054-00144FFA433E",
                "cardGUID",
                new NIConnectionProperties(
                        "https://api-uat.egy.network.global/sdk/v2",
                        "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICItNzBNYURtTkxYYW1OR294SGFLWjliM0V3TmdvQ1JOOW5HenlSSFZJN3ZjIn0.eyJleHAiOjE3MDc4MTk5MjksImlhdCI6MTcwNzgxODEyOSwianRpIjoiNWQyNjdkOTgtNmQwNC00Y2NjLTkzNTUtZTc1NTc1Mjk0Yjg5IiwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1ub25wcm9kLm5ldHdvcmsuZ2xvYmFsL2F1dGgvcmVhbG1zL05JLU5vblByb2QiLCJzdWIiOiI3M2Q5NDNhZi1mNjhjLTRjZTItOTM3OS02MjdjOTkzNDFhNzAiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjYmJiZmM2My01YzRmLTQ2ODgtOWFlNS03N2Y2YzExZDFkMjcxMDgzMTYiLCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImNsaWVudElkIjoiY2JiYmZjNjMtNWM0Zi00Njg4LTlhZTUtNzdmNmMxMWQxZDI3MTA4MzE2Iiwib3JnX2lkIjoiTUYzIiwicHJlZmVycmVkX3VzZXJuYW1lIjoic2VydmljZS1hY2NvdW50LWNiYmJmYzYzLTVjNGYtNDY4OC05YWU1LTc3ZjZjMTFkMWQyNzEwODMxNiJ9.mEakLpieG4-OnhjA44N58gGZjAaHE4N6teDNqVCvoEXbbvwEhXQp0WGt-XYVqasinkPQ88PM8SR_TpH_eLXa51hN_ob8YafIvSd9rGNOOIFDpntge2-IDIHnry4WigaJaChJQeV9XOkSpdZMqSxCFWqZeSVo0syd2boSlwRxDARNUzZ6KqhwmDkSHvXKs-qObimhREkE3mhK8rPvM8TuuoGkBCNLwLedjpVUGS95nSL9PyeBWcIkavuzbFFFbHqknYs4EBaeYnl3oteeExGLzLS9ea9GdO3pTeYKtSHlpbW9VgKFsSzluF_rNmjGRYb4BQONGUDnqh-Bllso-C_qKg"
                ),
                new NIDisplayAttributes()
        );
        pinLength = NIPinFormType.FOUR_DIGITS;

        Button openDialogButton = findViewById(R.id.openDialogButton); // Replace with your button ID
        openDialogButton.setOnClickListener(v -> {
            // Show the dialog
            showDialog();
        });

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    };

    private void showDialog() {
        // Create and show the dialog fragment
        SetPinFragmentFromActivity dialog = SetPinFragmentFromActivity.newInstance(niInput, pinLength, 0);
        dialog.show(getSupportFragmentManager(), SetPinFragmentFromActivity.TAG);
    }

    @Override
    public void onSetPinFragmentCompletion(@NonNull SuccessErrorCancelResponse successErrorCancelResponse) {

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }
}
