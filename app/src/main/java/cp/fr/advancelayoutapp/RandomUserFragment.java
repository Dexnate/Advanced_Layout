package cp.fr.advancelayoutapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cp.fr.advancelayoutapp.model.RandomUser;


public class RandomUserFragment extends Fragment {

    private List<RandomUser> userList;
    private ListView userListView;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDataFromHttp();
        View view= inflater.inflate(R.layout.activity_random_user_fragment, container, false);
        userListView = view.findViewById(R.id.randomUserListView);

        return view;

    }

    private void processResponse(String response){
        //transformation de la réponse json en list de RandomUser
        userList = responseToList(response);


        //Conversion de la liste de RandomUser en un tableau de String comportant uniquement
        //le nom des utilisateurs
        String[] data = new String[userList.size()];
        for(int i=0; i<userList.size();i++){
            data[i] = userList.get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, data);

        userListView.setAdapter(adapter);
    }

    private void getDataFromHttp(){
        String url = "https://jsonplaceholder.typicode.com/users";

        //Définition de la requête
        StringRequest request = new StringRequest(
                //Methode de la requête http
                Request.Method.GET,
                url,
                //gestionnaire de succès
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("HTTP", response);
                       processResponse(response);

                    }
                },
                //Gestionnaire d'erreurs
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("HTTP", error.getMessage());
                    }
                }
        );

        //Ajout de la requete à la file d'execution
        Volley.newRequestQueue(this.getActivity()).add(request);
    }

    //Conversion d'une réponse json(chaine de caractère) en une liste RandomUser
    private List<RandomUser> responseToList(String response){
        List<RandomUser> list= new ArrayList<>();
        try {
            JSONArray jsonUsers = new JSONArray(response);
            JSONObject item;
            for(int i=0; i<jsonUsers.length(); i++){
                item=(JSONObject)jsonUsers.get(i);
                RandomUser user = new RandomUser();
                user.setName(item.getString("name"));
                user.setEmail(item.getString("email"));

                JSONObject geo = item.getJSONObject("address").getJSONObject("geo");
                user.setLatitude(geo.getDouble("lat"));
                user.setLongitude(geo.getDouble("lng"));

                //ajout de l'utilisateur à la liste
                list.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
