package silva.evangelista.santos.wilsiman.galeriapublica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

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
                vm.setNavigationOpSelected(item.getItemId());
                switch (item.getItemId()) {
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


}