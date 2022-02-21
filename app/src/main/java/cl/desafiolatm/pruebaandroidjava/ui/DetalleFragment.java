package cl.desafiolatm.pruebaandroidjava.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.desafiolatm.pruebaandroidjava.R;
import cl.desafiolatm.pruebaandroidjava.databinding.FragmentDetalleBinding;

public class DetalleFragment extends Fragment {

    private FragmentDetalleBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater,container,false);


        return binding.getRoot();
    }
}