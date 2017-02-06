package com.ostap_kozak.android_quiz;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ostapkozak on 06/02/2017.
 */

public class ResultsDialog extends DialogFragment {
    CardView cardView_question1;

    public ResultsDialog() {
        // Empty constructor required for DialogFragment
    }

    public static ResultsDialog newInstance(String argument) {
        ResultsDialog frag = new ResultsDialog();
        Bundle args = new Bundle();
        args.putString("argument", argument);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = (LayoutInflater)getContext() .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.result_dialog,null);

        cardView_question1 = (CardView) view.findViewById(R.id.card_view_question1);
        String argument = getArguments().getString("argument", "False");

        if (argument.equals("True")) {
            cardView_question1.setCardBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cardView_question1.setCardBackgroundColor(Color.parseColor("#F44336"));
        }


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Your score: 10/10");
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setPositiveButton(android.R.string.ok,  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
                dialog.dismiss();
            }
        });

        return alertDialogBuilder.create();
    }


}
