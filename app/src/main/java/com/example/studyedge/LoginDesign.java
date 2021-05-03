package com.example.studyedge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginDesign extends Fragment {

    EditText email,pass;
    TextView forgetpass;
    Button Login;
    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_design,container,false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.password);
        forgetpass = root.findViewById(R.id.forgetpass);
        Login = root.findViewById(R.id.login);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        forgetpass.setTranslationX(800);
        Login.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        Login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        Login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Login Button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),homeScreen.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
