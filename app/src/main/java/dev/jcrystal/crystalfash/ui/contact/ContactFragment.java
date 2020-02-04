package dev.jcrystal.crystalfash.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import dev.jcrystal.crystalfash.R;
import jcrystal.mobile.net.controllers.ManagerContact;
import jcrystal.mobile.net.utils.OnErrorListener;
import jcrystal.mobile.net.utils.OnVoidSuccessListener;

public class ContactFragment extends Fragment{

    Button btnContact;
    EditText editName, editEmail, editMessage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        btnContact = root.findViewById(R.id.btn_contact_id);
        editName = root.findViewById(R.id.txt_name_id);
        editEmail = root.findViewById(R.id.txt_email_id);
        editMessage = root.findViewById(R.id.txt_message_id);

        Activity activity = this.getActivity();
        ContactFragment temp = this;
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ManagerContact.contact(activity, editName.getText().toString(), editEmail.getText().toString(), editMessage.getText().toString(), (OnVoidSuccessListener) activity, (OnErrorListener) activity);

            }
        });
        return root;
    }
}
