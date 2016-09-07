package nuez.antonio.facitec.edu.py.ultima_prueba;

import android.provider.Telephony;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    EditText nombre;
    EditText numeroTelefono;
    EditText edad;
    Button guardar;
    ListView usuarioList;
    List <String> usuario = new ArrayList<>();
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.editTelefono);
        numeroTelefono = (EditText) findViewById(R.id.editTelefono);
        edad = (EditText) findViewById(R.id.editEdad);
        guardar = (Button) findViewById(R.id.butnIngresar);


        usuarioList = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,usuario);
        usuarioList.setAdapter(adapter);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombr = nombre.getText().toString();
                String telef = numeroTelefono.getText().toString();
                String edd = edad.getText().toString();

                if (!validarNombre(nombr)){
                    nombre.setError(getString(R.string.error_nombre));

                }else if (!validarTelefono(telef)){
                    numeroTelefono.setError(getString(R.string.error_telefono));

                }else if (!validarEdad(edd)){
                    edad.setError(getString(R.string.error_edad));


                }else {
                    String mensaje = getString(R.string.bienvenida)+nombr+" "+telef+" "+edd;
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();


                    String datos = nombr+" "+telef+" "+edd;
                    usuario.add(datos);
                    adapter.notifyDataSetChanged();


                    nombre.setText(null);
                    numeroTelefono.setText(null);
                    edad.setText(null);

                }


            }
        });



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




    private boolean validarNombre (String nombre){
        return !nombre.equals("");
    }
    private boolean validarEdad (String edad){
        return !edad.equals("");
    }
    private boolean validarTelefono (String telefono){
        return !telefono.equals("");
    }

}
