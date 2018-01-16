package cp.fr.advancelayoutapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private Fragment myself = this;
    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_b, container, false);

        Button btDelete = view.findViewById(R.id.btFragmentDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().beginTransaction().remove(myself).commit();

            }
        });

        //Reference de l'activité principale
        DrawerActivity myActivity = (DrawerActivity) getActivity();

        //Affichage du nom de l'utilisateur
       TextView myTextView = view.findViewById((R.id.textViewFragmentB));
       //Definition du texte dans le fragment
       myTextView.setText(myActivity.getUser().getUserName());

        return view;
    }

}
