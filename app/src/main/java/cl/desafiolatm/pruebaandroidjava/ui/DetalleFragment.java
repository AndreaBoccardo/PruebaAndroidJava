package cl.desafiolatm.pruebaandroidjava.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import cl.desafiolatm.pruebaandroidjava.R;
import cl.desafiolatm.pruebaandroidjava.databinding.FragmentDetalleBinding;
import cl.desafiolatm.pruebaandroidjava.viewmodel.HeroeViewModel;

public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;
    private HeroeViewModel modelo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater,container,false);
        modelo = new ViewModelProvider(getActivity()).get(HeroeViewModel.class);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.titulo_fragmento_detalle);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setSuperHeroe(modelo.getSuperHeroe().getValue());

        modelo.getSuperHeroe().observe(getViewLifecycleOwner(), item -> {
            Picasso.get().load(String.valueOf(item.getImages())).into(binding.ivHeroeItem);
        });

        return binding.getRoot();
    }
}