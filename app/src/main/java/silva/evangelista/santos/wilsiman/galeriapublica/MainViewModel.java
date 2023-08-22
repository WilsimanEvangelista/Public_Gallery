package silva.evangelista.santos.wilsiman.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

//MainViewModel herda de AndroidViewModel
public class MainViewModel extends AndroidViewModel {

    //MainViewModel guarda somente um dado: navigationOpSelected
    //Esse é do tipo inteiro e serve para guardar a opção escolhida pelo usuário no menu btNav.
    int navigationOpSelected = R.id.gridViewOp;

    //AndroidViewModel é uma especialização de ViewModel que possui como parâmetro de entrada
    // em seu construtor uma instância da aplicação
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    //Os métodos abaixo são para pegar e setar o valor navigationOpSelected
    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}
