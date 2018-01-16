package cp.fr.advancelayoutapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_Inscription extends Fragment {

    DrawerActivity parentActivity;
    EditText userNameEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment__inscription, container, false);

        //Recuperation d'une référence
         userNameEditText = view.findViewById(R.id.editTextInscription);

        //recuperation d'une référence à l'activité
        parentActivity=(DrawerActivity) getActivity();

        //gestion du clic sur bouton valider
        Button btValid=view.findViewById(R.id.btnValidateInscription);
        btValid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Récupération de la saisie de l'utilisateur
                String username = userNameEditText.getText().toString();
                //récuperation du champ formulaire
                parentActivity.getUser().setUserName(username);
            }
        });

        return view;

    }
}