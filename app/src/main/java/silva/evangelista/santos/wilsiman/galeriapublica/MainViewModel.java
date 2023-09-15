package silva.evangelista.santos.wilsiman.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import kotlinx.coroutines.CoroutineScope;

//MainViewModel herda de AndroidViewModel
public class MainViewModel extends AndroidViewModel {

    //MainViewModel guarda somente um dado: navigationOpSelected
    //Esse é do tipo inteiro e serve para guardar a opção escolhida pelo usuário no menu btNav.
    int navigationOpSelected = R.id.gridViewOp;

    LiveData<PagingData<ImageData>> pageLv;

    //AndroidViewModel é uma especialização de ViewModel que possui como parâmetro de entrada
    // em seu construtor uma instância da aplicação
    public MainViewModel(@NonNull Application application) {
        super(application);
        GalleryRepository galleryRepository = new GalleryRepository(application);
        GalleryPagingSource galleryPagingSource = new GalleryPagingSource(galleryRepository);
        Pager<Integer, ImageData> pager = new Pager<>(new PagingConfig(10), () -> galleryPagingSource);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        pageLv = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);
    }

    public LiveData<PagingData<ImageData>> getPageLv() {
        return pageLv;
    }

    //Os métodos abaixo são para pegar e setar o valor navigationOpSelected
    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}
