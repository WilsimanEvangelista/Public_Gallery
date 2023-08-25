package silva.evangelista.santos.wilsiman.galeriapublica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static int RESULT_REQUEST_PERMISSION = 2;

    //definindo o bottonViewNavigation como um atributo da classe MainActivity
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abaixo obtemos uma referência para MainViewMode
        final MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

        //Abaixo obtemos a referência para o BottonNavigationView
        bottomNavigationView = findViewById(R.id.btNav);
        //Abaixo setamos em bottonNavigationView o “escutador” de eventos de seleção do menu
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Abaixo é guardado dentro de MainViewModel a opção que foi escolhida pelo usuário
                vm.setNavigationOpSelected(item.getItemId());
                switch (item.getItemId()) {
                    //Abaixo são definidas as ações que serão realizadas para cada opção.
                    case R.id.gridViewOp: GridViewFragment gridViewFragment = GridViewFragment.newInstance();
                    setFragment(gridViewFragment);
                    break;
                    case  R.id.listViewOp: ListViewFragment listViewFragment = ListViewFragment.newInstance();
                    setFragment(listViewFragment);
                    break;
                }
                return true;
            }
        });
    }

    //Abaixo o método setFragment recebe como parâmetro um fragmento
    void setFragment (Fragment fragment) {
        //Abaixo é iniciada uma transação do gerenciador de fragmentos
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //O fragment passado como parêmetro para o método setFragment será setado no espaço
        // definido pelo elemento UI fragContainer
        fragmentTransaction.replace(R.id.fragContainer,fragment);
        //Abaixo indica-se que esse fragmento agora faz parte da pilha de tela do botão voltar
        // do Android
        fragmentTransaction.addToBackStack(null);
        //Abaixo, é realizado o commit da transação
        fragmentTransaction.commit();
    }



    @Override
    protected void onResume() {
        super.onResume();
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        checkForPermissions(permissions);
    }
}