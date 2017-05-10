package com.example.sony.proyecto;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class NewBook extends AppCompatActivity {

    private ImageView img;
    private Button guardar;

    private SeekBar estado;
    private EditText titulo;
    private EditText autor;
    private EditText año;
    private Spinner categoria;
    private  Spinner  idioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_new_book);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //codigo para el retroceso o boton de atras en el toolBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        guardar= (Button)findViewById(R.id.button);
        estado=(SeekBar)findViewById(R.id.textEstado);
        categoria=(Spinner)findViewById(R.id.textcategoria);
        idioma =(Spinner) findViewById(R.id.textIdioma);
        autor = (EditText) findViewById(R.id.textAutor);
        año=(EditText) findViewById(R.id.textAño);
        titulo=(EditText) findViewById(R.id.textTitulo);

        //se definen algunos campos
        final String cateGoria ="Novela";
        final String estado ="nuevo";
        final String Idioma="Ingles";

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inten= new Intent(getApplicationContext(),MainActivity.class);
                inten.putExtra("titulo",titulo.getText());
                inten.putExtra("autor",autor.getText());
                inten.putExtra("categoria",cateGoria);
                inten.putExtra("estado",estado);
                inten.putExtra("idioma",Idioma);
                inten.putExtra("año",año.getText());
                startActivity(inten);
                Toast.makeText(getApplicationContext(), "Guardado!", Toast.LENGTH_SHORT).show();

            }
        });





        ImageButton addFoto = (ImageButton) findViewById(R.id.AddFoto);
        img = (ImageView) findViewById(R.id.imageView4);
        Spinner categoria = (Spinner) findViewById(R.id.textcategoria);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categoria_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        categoria.setAdapter(adapter);

        Spinner idioma = (Spinner) findViewById(R.id.textIdioma);

        ArrayAdapter<CharSequence> idiomaAdapter = ArrayAdapter.createFromResource(this, R.array.idiomas_array, android.R.layout.simple_spinner_item);
        idiomaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idioma.setAdapter(idiomaAdapter);


        File imagesFolder = new File(
                Environment.getExternalStorageDirectory(), "AndroidFacil");
        imagesFolder.mkdirs();

        final File image = new File(imagesFolder, "foto.jpg");

        addFoto.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

           /*    Uri output = Uri.fromFile(image);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                startActivityForResult(intent,1);

                */
                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
