package cl.desafiolatm.pruebaandroidjava.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.desafiolatm.pruebaandroidjava.R;
import cl.desafiolatm.pruebaandroidjava.adapter.HeroeAdapter;
import cl.desafiolatm.pruebaandroidjava.databinding.FragmentListaBinding;
import cl.desafiolatm.pruebaandroidjava.viewmodel.HeroeViewModel;

public class ListaFragment extends Fragment {

    private FragmentListaBinding binding;
    private HeroeViewModel modelo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListaBinding.inflate(inflater,container,false);
        modelo = new ViewModelProvider(getActivity()).get(HeroeViewModel.class);
        HeroeAdapter adapter = new HeroeAdapter();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.titulo_fragmento_lista);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        binding.rvLista.setAdapter(adapter);
        binding.rvLista.setLayoutManager(gridLayoutManager);

        adapter.setListener(item -> {
            modelo.cargarHeroe(item);
            Navigation.findNavController(getView()).navigate(R.id.action_listaFragment_to_detalleFragment);
        });

        modelo.getHeroe().observe(getViewLifecycleOwner(),heroe -> {
            adapter.setLista(heroe.getHeroe());
        });

        modelo.getToast_error().observe(getViewLifecycleOwner(), error -> {
            Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
        });

        return binding.getRoot();
    }
}