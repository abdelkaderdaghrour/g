package com.esprit.examen.services;

import com.esprit.examen.controllers.ProduitRestController;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;
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
public class ProduitRestControllerTest {

    @InjectMocks
    private ProduitRestController produitRestController;

    @Mock
    private IProduitService produitService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProduits() {
        List<Produit> produits = new ArrayList<>();
        // Add some Produit objects to the list

        when(produitService.retrieveAllProduits()).thenReturn(produits);

        List<Produit> result = produitRestController.getProduits();

        assertEquals(produits, result);
    }

    @Test
    public void testRetrieveProduit() {
        Long id = 1L; // Replace with the appropriate ID
        Produit produit = new Produit();
        // Initialize produit as needed

        when(produitService.retrieveProduit(id)).thenReturn(produit);

        Produit result = produitRestController.retrieveRayon(id);

        assertEquals(produit, result);
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();
        // Initialize produit as needed

        when(produitService.addProduit(any(Produit.class))).thenReturn(produit);

        Produit result = produitRestController.addProduit(produit);

        assertEquals(produit, result);
    }

    @Test
    public void testRemoveProduit() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(produitService).deleteProduit(id);

        produitRestController.removeProduit(id);

        verify(produitService, times(1)).deleteProduit(id);
    }

    @Test
    public void testModifyProduit() {
        Produit produit = new Produit();
        // Initialize produit as needed

        when(produitService.updateProduit(any(Produit.class))).thenReturn(produit);

        Produit result = produitRestController.modifyProduit(produit);

        assertEquals(produit, result);
    }

    @Test
    public void testAssignProduitToStock() {
        Long idProduit = 1L; // Replace with the appropriate ID
        Long idStock = 1L; // Replace with the appropriate ID
        doNothing().when(produitService).assignProduitToStock(idProduit, idStock);

        produitRestController.assignProduitToStock(idProduit, idStock);

        verify(produitService, times(1)).assignProduitToStock(idProduit, idStock);
    }

    // Uncomment and modify the test method based on the actual behavior
    /*
    @Test
    public void testGetRevenuBrutProduit() {
        Long idProduit = 1L; // Replace with the appropriate ID
        Date startDate = new Date(); // Replace with the appropriate start date
        Date endDate = new Date(); // Replace with the appropriate end date
        float expectedRevenu = 0.0f; // Replace with the expected revenu

        when(produitService.getRevenuBrutProduit(idProduit, startDate, endDate)).thenReturn(expectedRevenu);

        float result = produitRestController.getRevenuBrutProduit(idProduit, startDate, endDate);

        assertEquals(expectedRevenu, result, 0.001); // Adjust delta as needed
    }
    */
}
