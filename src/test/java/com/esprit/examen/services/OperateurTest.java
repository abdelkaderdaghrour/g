
package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest

public class OperateurTest {

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        List<Operateur> operateurs = new ArrayList<>();
        // Add some Operateur objects to the list

        when(operateurRepository.findAll()).thenReturn(operateurs);

        List<Operateur> result = operateurService.retrieveAllOperateurs();

        assertEquals(operateurs, result);
    }

    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        // Initialize operateur as needed

        when(operateurRepository.save(any(Operateur.class))).thenReturn(operateur);

        Operateur result = operateurService.addOperateur(operateur);

        assertEquals(operateur, result);
    }

    @Test
    public void testDeleteOperateur() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(operateurRepository).deleteById(id);

        operateurService.deleteOperateur(id);

        verify(operateurRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        // Initialize operateur as needed

        when(operateurRepository.save(any(Operateur.class))).thenReturn(operateur);

        Operateur result = operateurService.updateOperateur(operateur);

        assertEquals(operateur, result);
    }

    @Test
    public void testRetrieveOperateur() {
        Long id = 1L; // Replace with the appropriate ID
        Operateur operateur = new Operateur();
        // Initialize operateur as needed

        when(operateurRepository.findById(id)).thenReturn(Optional.of(operateur));

        Operateur result = operateurService.retrieveOperateur(id);

        assertEquals(operateur, result);
    }
}
