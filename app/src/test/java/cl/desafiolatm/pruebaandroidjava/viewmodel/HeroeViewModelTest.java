package cl.desafiolatm.pruebaandroidjava.viewmodel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import cl.desafiolatm.pruebaandroidjava.modelo.HeroeItem;

@RunWith(MockitoJUnitRunner.class)
public class HeroeViewModelTest {

    @Mock
    private HeroeViewModel modelo;

    @Before
    public void setUp() throws Exception {
        modelo = mock(HeroeViewModel.class);
    }

    @Test
    public void test_cargarHeroe() {
        HeroeItem item = new HeroeItem();
        modelo.cargarHeroe(item);
        verify(modelo).cargarHeroe(item);
    }
}