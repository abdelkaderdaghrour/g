package com.esprit.examen.services;

import com.esprit.examen.controllers.CategorieProduitController;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategorieProduitTest {

    @InjectMocks
    private CategorieProduitController categorieProduitController;

    @Mock
    private ICategorieProduitService categorieProduitService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllCategorieProduits() {
        List<CategorieProduit> categorieProduits = new ArrayList<>();
        // Add some CategorieProduit objects to the list

        when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(categorieProduits);

        List<CategorieProduit> result = categorieProduitController.getCategorieProduit();

        assertEquals(categorieProduits, result);
    }

    @Test
    public void testRetrieveCategorieProduit() {
        Long id = 1L; // Replace with the appropriate ID
        CategorieProduit categorieProduit = new CategorieProduit();
        // Initialize categorieProduit as needed

        when(categorieProduitService.retrieveCategorieProduit(id)).thenReturn(categorieProduit);

        CategorieProduit result = categorieProduitController.retrieveCategorieProduit(id);

        assertEquals(categorieProduit, result);
    }

    @Test
    public void testAddCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        // Initialize categorieProduit as needed

        when(categorieProduitService.addCategorieProduit(any(CategorieProduit.class))).thenReturn(categorieProduit);

        CategorieProduit result = categorieProduitController.addCategorieProduit(categorieProduit);

        assertEquals(categorieProduit, result);
    }

    @Test
    public void testRemoveCategorieProduit() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(categorieProduitService).deleteCategorieProduit(id);

        categorieProduitController.removeCategorieProduit(id);

        verify(categorieProduitService, times(1)).deleteCategorieProduit(id);
    }

    @Test
    public void testModifyCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        // Initialize categorieProduit as needed

        when(categorieProduitService.updateCategorieProduit(any(CategorieProduit.class))).thenReturn(categorieProduit);

        CategorieProduit result = categorieProduitController.modifyCategorieProduit(categorieProduit);

        assertEquals(categorieProduit, result);
    }
}
