package com.example.sony.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookDescription extends AppCompatActivity {


    public static String currentUser;
    private ImageView imageView;
    private EditText bTitle;
    private EditText bAuthor;
    private EditText bEditorial;
    private EditText bDescription;
    private Button NewLibbro;

    String[] userNames;
    List<Item> items;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookdescription);

        //  Button newButton= (Button)findViewById(R.id.add);


        Intent intent = getIntent();
        String message = intent.getStringExtra("title");
        currentUser = intent.getStringExtra("user");
        initComponents(message);

        String arrayNames = "u_"+message;
        int resArrayName = getResources().getIdentifier(arrayNames,"array",getPackageName());
        items = new ArrayList<Item>();
        userNames = getResources().getStringArray(resArrayName);

        String ur, uName, uId;
        int resUserImage;
        for (int i = 0; i < userNames.length; i++) {
            uId = userNames[i];
            ur = "@string/"+userNames[i]+"name";
            uName = getString(getResources().getIdentifier(ur,"string", getPackageName()));
            ur = "@drawable/"+userNames[i];
            resUserImage = getResources().getIdentifier(ur, "drawable", getPackageName());
            Item item = new Item(uId, uName, resUserImage);
            items.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        Adapter adapter = new Adapter(this, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemClickListener());


    }

    public void toTradeBookActivity(String message) {
        Intent intent = new Intent(getApplicationContext(), BookDescription.class);
        intent.putExtra("usuario", message) ;
        startActivity(intent);
    }

    public void initComponents(String id) {
        imageView = (ImageView) findViewById(R.id.bookImage);
        bTitle = (EditText) findViewById(R.id.bookTitle);
        bAuthor = (EditText) findViewById(R.id.bookAuthor);
        bEditorial = (EditText) findViewById(R.id.bookEditorial);
        bDescription = (EditText) findViewById(R.id.bookDescription);
        getData(id);

    }

    public void getData (String id) {
        String title, author, editorial, description, image;
        int resImage, resTitle, resAuthor, resEditorial, resDescription;

        image = "@drawable/"+id;
        title = "@string/t_"+id;
        author = "@string/a_"+id;
        editorial = "@string/e_"+id;
        description = "@string/d_"+id;

        resImage = getResources().getIdentifier(image, "drawable", getPackageName());
        resTitle = getResources().getIdentifier(title,"string", getPackageName());
        resAuthor = getResources().getIdentifier(author,"string", getPackageName());
        resEditorial = getResources().getIdentifier(editorial,"string", getPackageName());
        resDescription = getResources().getIdentifier(description,"string", getPackageName());

        setComponents(resImage, resTitle, resAuthor, resEditorial, resDescription);

    }

    public void setComponents(int rImage, int rTitle,int rAuthor,int rEditorial, int rDescription) {
        imageView.setImageResource(rImage);
        bTitle.setText(getString(rTitle));
        bAuthor.setText(getString(rAuthor));
        bEditorial.setText(getString(rEditorial));
        bDescription.setText(getString(rDescription));
    }
    private int userSelected;

    class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    }


}
