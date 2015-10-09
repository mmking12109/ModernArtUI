package com.example.yang.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MOMADialog extends Dialog implements View.OnClickListener {

    static private final String URL = "http://www.moma.org/collection/artists/4293";

    Button positive, negative;

    public MOMADialog(Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.moma_dialog);

        positive = (Button) findViewById(R.id.positive_button);
        negative = (Button) findViewById(R.id.negative_button);

        positive.setOnClickListener(this);
        negative.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.positive_button:
                // Go to moma.org
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                getContext().startActivity(intent);
                break;
            case R.id.negative_button:
                //Dismiss dialog
                dismiss();
                break;
            default:
                break;
        }
    }

//    public Dialog onCreateDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//
//        // Get the layout inflater
//        LayoutInflater inflater = getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        View layout = inflater.inflate(R.layout.moma_dialog, null);
//        builder.setView(layout);
//
//        Button positive = (Button)layout.findViewById(R.id.positive_button);
//        Button negative = (Button)layout.findViewById(R.id.negative_button);
//
//        positive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
//                getContext().startActivity(intent);
//            }
//        });
//
//        negative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Close dialog
//                dismiss();
//            }
//        });
//
//        return builder.create();
//    }
}
