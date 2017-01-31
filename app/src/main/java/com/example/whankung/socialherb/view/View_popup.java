package com.example.whankung.socialherb.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.whankung.socialherb.R;
import com.example.whankung.socialherb.activity.MainInvite;


/**
 * Created by Admin on 30/8/2559.
 * <p>
 * //This code is used to call a View_popup.
 * <p>
 * View_popup alertDialog = new View_popup(
 * getResources().getString(R.string.str_msgFail),
 * getResources().getString(R.string.btn_name));
 * alertDialog.mListener = (Class).this;
 * alertDialog.show(getFragmentManager(), "");
 * );
 */

public class View_popup extends DialogFragment {
    private Typeface font;
    private TextView txt;
    private String message;
    private TextView btn_ok;
    private String msg_ok;
    private Dialog dialog;

    View.OnClickListener listenerOK;

    public onSubmitAlertDialogListener mListener;

    public View_popup(MainInvite strMsg) {

    }

    public interface onSubmitAlertDialogListener {
        void setOnSubmitAlertDialogListener();
    }


    public View_popup(String message, String button1) {

        this.message = message;
        msg_ok = button1;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
//                เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_popup);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        txt = (TextView) dialog.findViewById(R.id.txt);
        btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        txt.setText(message);
        btn_ok.setText(msg_ok);
//                เปลี่ยน font
        txt.setTypeface(font);
        btn_ok.setTypeface(font);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setOnSubmitAlertDialogListener();
                dialog.dismiss();
            }


        });
        return dialog;

    }


}








