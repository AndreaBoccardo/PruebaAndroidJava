package cl.desafiolatm.pruebaandroidjava.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cl.desafiolatm.pruebaandroidjava.R;
import cl.desafiolatm.pruebaandroidjava.cliente.ClienteRetrofit;
import cl.desafiolatm.pruebaandroidjava.modelo.Heroe;
import cl.desafiolatm.pruebaandroidjava.modelo.HeroeItem;
import cl.desafiolatm.pruebaandroidjava.service.HeroeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroeViewModel extends ViewModel {

    private MutableLiveData<Heroe> heroe;
    private MutableLiveData<HeroeItem> superHeroe;
    private MutableLiveData<Integer> toast_error;

    public HeroeViewModel() {
        load();
        superHeroe = new MutableLiveData<>();
        toast_error = new MutableLiveData<>();
    }

    public void cargarHeroe(HeroeItem item){
        superHeroe.setValue(item);
    }

    private void load(){
        heroe = new MutableLiveData<>();
        HeroeService service = ClienteRetrofit.getInstance().create(HeroeService.class);
        Call<Heroe> call = service.getHeroe();
        call.enqueue(new Callback<Heroe>() {
            @Override
            public void onResponse(Call<Heroe> call, Response<Heroe> response) {
                Heroe h = response.body();
                heroe.postValue(h);
            }

            @Override
            public void onFailure(Call<Heroe> call, Throwable t) {
                toast_error.setValue(R.string.msg_error);
            }
        });
    }

    public MutableLiveData<Heroe> getHeroe() {
        return heroe;
    }

    public MutableLiveData<HeroeItem> getSuperHeroe() {
        return superHeroe;
    }

    public MutableLiveData<Integer> getToast_error() {
        return toast_error;
    }
}
