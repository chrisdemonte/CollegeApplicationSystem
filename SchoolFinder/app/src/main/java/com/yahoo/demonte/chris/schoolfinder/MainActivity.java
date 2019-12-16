package com.yahoo.demonte.chris.schoolfinder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//API KEY: WEvhaC3y3VcHP7NEHbCuWUqpdgFEfTvfMC4okk4C
    // key:
    // https://api.data.gov/ed/collegescorecard/v1/schools.json?&fields=id,school.name,2013.student.size&api_key=WEvhaC3y3VcHP7NEHbCuWUqpdgFEfTvfMC4okk4C
//annotations 2-10, core 2-10, databind 210

    School temp;
    String selection = "";

    private ConstraintLayout signinLayout;
    private Button signinCreateAccountBtn;
    private Button signinSigninBtn;
    private TextView signinUsernameTextView;
    private TextView signinPasswordTextView;

    private ConstraintLayout accountCreationLayout;
    private Button createAccountCreateAccountBtn;
    private Button createAccountBackBtn;
    private TextView createAccountNameTextView;
    private TextView createAccountEmailTextView;
    private TextView createAccountMathTextView;
    private TextView createAccountReadingTextView;
    private TextView createAccountUsernameTextView;
    private TextView createAccountPasswordTextView;

    private ConstraintLayout menuLayout;
    private Button menuSearchBtn;
    private Button menuMatchUpBtn;
    private Button menuFavoritesBtn;
    private Button menuBackBtn;

    private ConstraintLayout collegeDetailLayout;
    private Button collegeDetailFavoriteBtn;
    private Button collegeDetailRemoveFavBtn;
    private Button collegeDetailBackBtn;
    private TextView collegeDetailNameTextView;
    private TextView collegeDetailDetailsTextView;

    private ConstraintLayout searchFormLayout;
    private AutoCompleteTextView searchFormNameEntry;
    private ArrayAdapter<String> searchNameAdapter;
    private TextView searchFormStateEntry;
    private TextView searchFormIDEntry;
    private Spinner searchFormRegionEntry;
    private TextView searchFormTuitionEntry;
    private TextView searchFormCityEntry;
    private Button searchFormSearchBtn;
    private Button searchFormMatchBtn;
    private Button searchFormBackBtn;

    private ConstraintLayout searchResultLayout;
    private ListView searchResultListView;
    private SearchResultAdapter searchResultAdapter;
    private Button searchResultBackBtn;
    private Button searchResultBackBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        signinLayout = (ConstraintLayout) findViewById(R.id.signinLayout);
        signinCreateAccountBtn = (Button) findViewById(R.id.createAccountButton);
        signinSigninBtn = (Button) findViewById(R.id.signInButton);
        signinUsernameTextView = (TextView) findViewById(R.id.usernameSignInEntry);
        signinPasswordTextView = (TextView) findViewById(R.id.passwordSignInEntry);

        accountCreationLayout = (ConstraintLayout) findViewById(R.id.userCreateLayout);
        createAccountCreateAccountBtn = (Button) findViewById(R.id.accountCreateButton);
        createAccountBackBtn = (Button) findViewById(R.id.accountBackButton);
        createAccountNameTextView = (TextView) findViewById(R.id.accountNameEntry) ;
        createAccountEmailTextView = (TextView) findViewById(R.id.accountEmailEntry);
        createAccountMathTextView = (TextView) findViewById(R.id.accountMathEntry);
        createAccountReadingTextView = (TextView) findViewById(R.id.accountReadingEntry) ;
        createAccountUsernameTextView = (TextView) findViewById(R.id.accountUsernameEntry) ;
        createAccountPasswordTextView = (TextView) findViewById(R.id.accountPasswordEntry);

        menuLayout = (ConstraintLayout) findViewById(R.id.menuLayout) ;
        menuSearchBtn = (Button) findViewById(R.id.menuSearchSchool) ;
        menuMatchUpBtn = (Button) findViewById(R.id.menuMatchupButton);
        menuFavoritesBtn = (Button) findViewById(R.id.menuViewSchoolButton);
        menuBackBtn = (Button) findViewById(R.id.menuBackButton) ;

        collegeDetailLayout = (ConstraintLayout) findViewById(R.id.collegeDetailLayout) ;
        collegeDetailFavoriteBtn = (Button) findViewById(R.id.collegeDetailFavoritesButton) ;
        collegeDetailRemoveFavBtn = (Button) findViewById(R.id.collegeDetailFavoritesButton2);
        collegeDetailBackBtn = (Button) findViewById(R.id.collegeDetailBackButton);
        collegeDetailNameTextView = (TextView) findViewById(R.id.collegeDetailNameTextView);
        collegeDetailDetailsTextView = (TextView) findViewById(R.id.collegeDetailsDetailsTextView);

        searchFormLayout = (ConstraintLayout) findViewById(R.id.searchLayout);
        searchFormNameEntry = (AutoCompleteTextView) findViewById(R.id.searchFormNameEntry);

        searchFormCityEntry = (TextView) findViewById(R.id.searchFormCityEntry) ;
        searchFormStateEntry = (TextView) findViewById(R.id.searchFormStateEntry);
        searchFormRegionEntry = (Spinner) findViewById(R.id.searchFormRegionEntry) ;
        this.generateSpinner();
        searchFormTuitionEntry = (TextView) findViewById(R.id.searchFormTuitionEntry);
        searchFormIDEntry = (TextView) findViewById(R.id.searchFormIDEntry);
        searchFormBackBtn = (Button) findViewById(R.id.serachFormbackButton) ;
        searchFormSearchBtn = (Button) findViewById(R.id.searchFormSearchButton);
        searchFormMatchBtn = (Button) findViewById(R.id.searchFormMatchButton);

        searchResultLayout = (ConstraintLayout) findViewById(R.id.searchResultLayout) ;
        searchResultListView = (ListView) findViewById(R.id.searchResultListView);
        searchResultAdapter = new SearchResultAdapter(getApplicationContext(), new ArrayList<School>());
        searchResultListView.setAdapter(searchResultAdapter);
        searchResultBackBtn = (Button) findViewById(R.id.searchResultbackButton);
        searchResultBackBtn2 = (Button) findViewById(R.id.searchResultbackButton2);

        this.giveButtonsActions();


        UserManager.loadAccounts(this);
        UserManager.setCurrentUser(UserManager.userAccounts.get("Chris"));
        DataBaseManager.updateDatabase(getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void giveButtonsActions(){
        signinCreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinLayout.setVisibility(View.GONE);
                createAccountNameTextView.setText("");
                createAccountEmailTextView.setText("");
                createAccountMathTextView.setText("");
                createAccountReadingTextView.setText("");
                createAccountUsernameTextView.setText("");
                createAccountPasswordTextView.setText("");
                accountCreationLayout.setVisibility(View.VISIBLE);
            }
        });
        signinSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signinUsernameTextView.getText().toString();
                String password = signinPasswordTextView.getText().toString();
                if (!username.contentEquals("") && !password.contentEquals("")){
                    if(UserManager.checkAccount(username, password)){
                        signinLayout.setVisibility(View.GONE);
                        menuLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        createAccountCreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = createAccountNameTextView.getText().toString();
                String email = createAccountEmailTextView.getText().toString();
                int math = Integer.parseInt(createAccountMathTextView.getText().toString());
                int reading = Integer.parseInt(createAccountReadingTextView.getText().toString());
                String username = createAccountUsernameTextView.getText().toString();
                String password = createAccountPasswordTextView.getText().toString();
                if (!name.contentEquals("") && !email.contentEquals("") && math!=0 && reading!=0 && !username.contentEquals("") && !password.contentEquals("")){
                    UserManager.setCurrentUser(new User(name, username, password, email, math, reading));
                    UserManager.addAccount(getApplicationContext(), UserManager.getCurrentUser());
                    accountCreationLayout.setVisibility(View.GONE);
                    signinUsernameTextView.setText("");
                    signinPasswordTextView.setText("");
                    signinLayout.setVisibility(View.VISIBLE);

                }
            }
        });
        createAccountBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountCreationLayout.setVisibility(View.GONE);
                signinUsernameTextView.setText("");
                signinPasswordTextView.setText("");
                signinLayout.setVisibility(View.VISIBLE);

            }
        });
        menuBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLayout.setVisibility(View.GONE);
                signinUsernameTextView.setText("");
                signinPasswordTextView.setText("");
                signinLayout.setVisibility(View.VISIBLE);

            }
        });
        menuSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLayout.setVisibility(View.GONE);
                searchFormLayout.setVisibility(View.VISIBLE);
                searchFormMatchBtn.setVisibility(View.GONE);
                searchFormSearchBtn.setVisibility(View.VISIBLE);
                searchFormNameEntry.setText("");
                searchFormIDEntry.setText("");
                searchFormCityEntry.setText("");
                searchFormStateEntry .setText("");
                searchFormRegionEntry.setSelection(0);
                searchFormTuitionEntry.setText("");
                selection = "";
            }
        });
        menuMatchUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLayout.setVisibility(View.GONE);
                searchFormLayout.setVisibility(View.VISIBLE);
                searchFormMatchBtn.setVisibility(View.VISIBLE);
                searchFormSearchBtn.setVisibility(View.GONE);
                searchFormNameEntry.setText("");
                searchFormIDEntry.setText("");
                searchFormCityEntry.setText("");
                searchFormStateEntry .setText("");
                searchFormRegionEntry.setSelection(0);
                searchFormTuitionEntry.setText("");
                selection ="";

            }
        });
        menuFavoritesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLayout.setVisibility(View.GONE);
                ArrayList<String> favs = UserManager.getCurrentUser().getFavorites();
                ArrayList<School> schools = new ArrayList<School>();
                for (int i = 0; i< favs.size(); i++){
                    if (DataBaseManager.schoolList.containsKey(favs.get(i))){
                        schools.add(DataBaseManager.schoolList.get(favs.get(i)));
                    }
                }
                searchResultAdapter.changeChoices(schools, false);
                searchResultLayout.setVisibility(View.VISIBLE);
                searchResultBackBtn.setVisibility(View.GONE);
                searchResultBackBtn2.setVisibility(View.VISIBLE);

            }
        });
        collegeDetailBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collegeDetailLayout.setVisibility(View.GONE);
                searchResultLayout.setVisibility(View.VISIBLE);
                if (searchResultBackBtn2.getVisibility()== View.VISIBLE){
                    ArrayList<String> favs = UserManager.getCurrentUser().getFavorites();
                    ArrayList<School> schools = new ArrayList<School>();
                    for (int i = 0; i< favs.size(); i++){
                        if (DataBaseManager.schoolList.containsKey(favs.get(i))){
                            schools.add(DataBaseManager.schoolList.get(favs.get(i)));
                        }
                    }
                    searchResultAdapter.changeChoices(schools, false);
                }
            }
        });
        collegeDetailFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collegeDetailFavoriteBtn.setVisibility(View.GONE);
                collegeDetailRemoveFavBtn.setVisibility(View.VISIBLE);
                UserManager.currentUser.getFavorites().add(temp.getId()+"");
                UserManager.saveAccounts(getApplicationContext());
            }
        });
        collegeDetailRemoveFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collegeDetailRemoveFavBtn.setVisibility(View.GONE);
                collegeDetailFavoriteBtn.setVisibility(View.VISIBLE);
                for (int i = UserManager.currentUser.getFavorites().size() - 1; i >= 0; i--){
                    if (temp.getId() == Integer.parseInt(UserManager.currentUser.getFavorites().get(i))){
                        UserManager.currentUser.getFavorites().remove(i);
                    }
                }
                UserManager.saveAccounts(getApplicationContext());
            }
        });
        searchResultBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchResultLayout.setVisibility(View.GONE);
                searchFormLayout.setVisibility(View.VISIBLE);
                selection = "";

            }
        });
        searchResultBackBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchResultLayout.setVisibility(View.GONE);
                menuLayout.setVisibility(View.VISIBLE);
                selection = "";

            }
        });

        searchFormNameEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Cursor res = DataBaseManager.dbHelper.getAutofill(s.toString(), null);
                ArrayList<String> item = new ArrayList<String>();
                int counter = 0;
                while (res.moveToNext() && counter < 5){
                    if (counter == 0){
                       // selection = res.getString(0);
                    }
                    item.add(res.getString(0));
                    counter++;
                }

                searchNameAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, item);
                searchNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                searchFormNameEntry.setAdapter(searchNameAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        searchFormNameEntry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long rowId) {
                selection = (String)parent.getItemAtPosition(position);
                //searchFormCityEntry.setText(selection);
            }
        });

        searchFormBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFormLayout.setVisibility(View.GONE);
                menuLayout.setVisibility(View.VISIBLE);
                selection = "";
                    }
                });



        searchFormSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFormLayout.setVisibility(View.GONE);
                searchResultLayout.setVisibility(View.VISIBLE);
                searchResultBackBtn2.setVisibility(View.GONE);
                searchResultBackBtn.setVisibility(View.VISIBLE);

                String query= " WHERE";
                String params= "";
                String[] paramArr;
                int counter = 0;
                String schoolName = selection;
                String id = searchFormIDEntry.getText().toString();
                String state = searchFormStateEntry.getText().toString();
                String city = searchFormCityEntry.getText().toString();
                String region = searchFormRegionEntry.getSelectedItem().toString();
                String tuition = searchFormTuitionEntry.getText().toString();

                if (!schoolName.contentEquals("")){
                    counter++;
                    query+= " Name = ?,";
                    params+= schoolName + ",";
                }
                if (!id.contentEquals("")){
                    counter++;
                    query+= " ID = ?,";
                    params+= id + ",";
                }

                if (!state.contentEquals("")){
                    counter++;
                    query+= " State = ?,";
                    params+= state + ",";
                }
                if (!city.contentEquals("")){
                    counter++;
                    query+= " City = ?,";
                    params+= city + ",";
                }
                if (!region.contentEquals("none")){
                    counter++;
                    query+= " Region = ?,";
                    params+= region.charAt(0) + ",";
                }if (!tuition.contentEquals("")){
                    counter++;
                    query+= " In_State_Tuition <= ? AND In_State_Tuition != -1,";
                    params+= tuition + ",";
                }

                if (counter == 0){
                    query = "";
                    paramArr = null;
                }
                else if (counter == 1){
                    query = query.substring(0, query.lastIndexOf(","));
                    params = params.substring(0, params.lastIndexOf(","));
                    paramArr = new String[1];
                    paramArr[0] = params;
                }
                else {
                    query = query.substring(0, query.lastIndexOf(","));
                    params = params.substring(0, params.lastIndexOf(","));
                    query = query.replaceAll(",", " AND ");
                    paramArr = params.split(",");
                }

                Cursor res = DataBaseManager.dbHelper.getSearchResult(query, paramArr);
                ArrayList<School> schools = new ArrayList<School>();
                while (res.moveToNext()){
                    String key = res.getString(0);
                    if (DataBaseManager.schoolList.containsKey(key)){
                        schools.add(DataBaseManager.schoolList.get(key));
                    }
                }
                searchResultAdapter.changeChoices(schools, false);

            }
        });


        searchResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                temp = (School)searchResultAdapter.getItem(position);
                searchResultLayout.setVisibility(View.GONE);
                collegeDetailNameTextView.setText(temp.getName());
                collegeDetailDetailsTextView.setText(temp.toFancyString());
                boolean isFav = false;
                for (int i = 0; i < UserManager.currentUser.getFavorites().size(); i++){
                    if (temp.getId() == Integer.parseInt(UserManager.currentUser.getFavorites().get(i))){
                        isFav = true;
                    }
                }
                if (isFav){
                    collegeDetailRemoveFavBtn.setVisibility(View.VISIBLE);
                    collegeDetailFavoriteBtn.setVisibility(View.GONE);
                }
                else {
                    collegeDetailRemoveFavBtn.setVisibility(View.GONE);
                    collegeDetailFavoriteBtn.setVisibility(View.VISIBLE);
                }
                collegeDetailLayout.setVisibility(View.VISIBLE);

            }
        });


        searchFormMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchFormLayout.setVisibility(View.GONE);
                searchResultLayout.setVisibility(View.VISIBLE);
                searchResultBackBtn2.setVisibility(View.GONE);
                searchResultBackBtn.setVisibility(View.VISIBLE);
                String query= " WHERE";
                String params= "";
                String[] paramArr;
                String schoolName = selection;
                String id = searchFormIDEntry.getText().toString();
                String state = searchFormStateEntry.getText().toString();
                String city = searchFormCityEntry.getText().toString();
                String region = searchFormRegionEntry.getSelectedItem().toString();
                String tuition = searchFormTuitionEntry.getText().toString();

                if (!schoolName.contentEquals("")){
                    query+= " Name = ?,";
                    params+= schoolName + ",";
                }
                if (!id.contentEquals("")){
                    query+= " ID = ?,";
                    params+= id + ",";
                }

                if (!state.contentEquals("")){
                    query+= " State = ?,";
                    params+= state + ",";
                }
                if (!city.contentEquals("")){
                    query+= " City = ?,";
                    params+= city + ",";
                }
                if (!region.contentEquals("none")){
                    query+= " Region = ?,";
                    params+= region.charAt(0) + ",";
                }if (!tuition.contentEquals("")){
                    query+= " In_State_Tuition <= ? AND In_State_Tuition != -1,";
                    params+= tuition + ",";
                }
                //query += " Math_SAT_25th_Percentile != -1 AND Math_SAT_25th_Percentile <= ? AND Reading_SAT_25th_Percentile != -1 AND Reading_SAT_25th_Percentile <= ?,";
                query += " Math_SAT_25th_Percentile != -1 AND Reading_SAT_25th_Percentile != -1,";
                //params+= UserManager.getCurrentUser().getMathScore()+"," +UserManager.getCurrentUser().getReadingScore()+ ",";
                query = query.substring(0, query.lastIndexOf(","));
                params = params.substring(0, params.lastIndexOf(","));
                query = query.replaceAll(",", " AND ");
                paramArr = params.split(",");

                Cursor res = DataBaseManager.dbHelper.getSearchResult(query, paramArr);
                ArrayList<School> schools = new ArrayList<School>();
                while (res.moveToNext()){
                    String key = res.getString(0);
                    if (DataBaseManager.schoolList.containsKey(key)){
                        schools.add(DataBaseManager.schoolList.get(key));
                    }
                }
                searchResultAdapter.changeChoices(schools, true);
            }
        });

    }
    private void generateSpinner() {

        ArrayList<String> choices = new ArrayList<String>();
        choices.add("none");
        choices.add("0. U.S.Service Schools");
        choices.add("1. New England");
        choices.add("2. Mid East");
        choices.add("3. Great Lakes");
        choices.add("4. Plains");
        choices.add("5. Southeast");
        choices.add("6. Southwest");
        choices.add("7. Rocky Mountains");
        choices.add("8. Far West");
        choices.add("9. Outlying Areas");


        ArrayAdapter arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices);
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.searchFormRegionEntry.setAdapter(arrAdapter);
        searchFormRegionEntry.setSelection(0);

    }
}
