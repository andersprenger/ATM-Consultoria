package br.poa.sprenger.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal,
                R.id.nav_servicos,
                R.id.nav_clientes,
                R.id.nav_contato,
                R.id.nav_sobre
        ).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     * Usa uma intent para enviar um email apartir de um app como Gmail.
     * Intents também podem ser usados para, por exemplo, iniciar uma nova atividade em resposta a uma ação
     * do usuário ou iniciar um serviço para fazer o download de um arquivo em segundo plano.
     *
     * O fab esta dento de app_bar_main...
     */
    public void enviarEmail(View view){
        //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("40028922")));
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://external-preview.redd.it/XUEQcanJ6RxwMVBdmhJLWpR6j2RvNFr2B_q-7WtCfck.jpg?auto=webp&s=f85e5a08e5066fdcc25d8b0f0982f19030ac817d")));
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.br/maps/place/at-home+cafe+%E3%83%89%E3%83%B3%E3%82%AD%E5%BA%97%EF%BC%88%E3%81%82%E3%81%A3%E3%81%A8%E3%81%BB%E3%81%89%E3%83%BC%E3%82%80%E3%82%AB%E3%83%95%E3%82%A7%EF%BC%89/@35.7007698,139.7718072,166m/data=!3m1!1e3!4m12!1m6!3m5!1s0x60188c1d94792ded:0x33b2a9fd2ac534f!2zYXQtaG9tZSBjYWZlIOODieODs-OCreW6l--8iOOBguOBo-OBqOOBu-OBieODvOOCgOOCq-ODleOCp--8iQ!8m2!3d35.70083!4d139.771849!3m4!1s0x60188c1d94792ded:0x33b2a9fd2ac534f!8m2!3d35.70083!4d139.771849").se));
        Intent enviarEmail = new Intent(Intent.ACTION_SEND);
        enviarEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@att.consultoria.br"});
        enviarEmail.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
        enviarEmail.putExtra(Intent.EXTRA_TEXT, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ultrices posuere justo ut rhoncus. Nunc egestas nulla metus.");
        enviarEmail.setType("message/rfc822"); //Escolher de acordo com a lista... https://www.sitepoint.com/mime-types-complete-list/
        startActivity(Intent.createChooser(enviarEmail,"Compartilhar"));
    }
}