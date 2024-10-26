package com.esprit.examen.services;

import com.esprit.examen.controllers.FactureRestController;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.services.IFactureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FactureRestControllerTest {

    @InjectMocks
    private FactureRestController factureRestController;

    @Mock
    private IFactureService factureService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllFactures() {
        List<Facture> factures = new ArrayList<>();
        // Add some Facture objects to the list

        when(factureService.retrieveAllFactures()).thenReturn(factures);

        List<Facture> result = factureRestController.getFactures();

        assertEquals(factures, result);
    }

    @Test
    public void testRetrieveFacture() {
        Long id = 1L; // Replace with the appropriate ID
        Facture facture = new Facture();
        // Initialize facture as needed

        when(factureService.retrieveFacture(id)).thenReturn(facture);

        Facture result = factureRestController.retrieveFacture(id);

        assertEquals(facture, result);
    }

    @Test
    public void testAddFacture() {
        Facture facture = new Facture();
        // Initialize facture as needed

        when(factureService.addFacture(any(Facture.class))).thenReturn(facture);

        Facture result = factureRestController.addFacture(facture);

        assertEquals(facture, result);
    }

    @Test
    public void testCancelFacture() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(factureService).cancelFacture(id);

        factureRestController.cancelFacture(id);

        verify(factureService, times(1)).cancelFacture(id);
    }

    @Test
    public void testGetFactureByFournisseur() {
        Long fournisseurId = 1L; // Replace with the appropriate ID
        List<Facture> factures = new ArrayList<>();
        // Add some Facture objects to the list

        when(factureService.getFacturesByFournisseur(fournisseurId)).thenReturn(factures);

        List<Facture> result = factureRestController.getFactureByFournisseur(fournisseurId);

        assertEquals(factures, result);
    }

    @Test
    public void testAssignOperateurToFacture() {
        Long idOperateur = 1L; // Replace with the appropriate ID
        Long idFacture = 1L; // Replace with the appropriate ID
        doNothing().when(factureService).assignOperateurToFacture(idOperateur, idFacture);

        factureRestController.assignOperateurToFacture(idOperateur, idFacture);

        verify(factureService, times(1)).assignOperateurToFacture(idOperateur, idFacture);
    }

    @Test
    public void testPourcentageRecouvrement() {
        Date startDate = new Date(); // Replace with the appropriate start date
        Date endDate = new Date(); // Replace with the appropriate end date
        float expectedPercentage = 0.0f; // Replace with the expected percentage

        when(factureService.pourcentageRecouvrement(startDate, endDate)).thenReturn(expectedPercentage);

        float result = factureRestController.pourcentageRecouvrement(startDate, endDate);

        assertEquals(expectedPercentage, result, 0.001); // Adjust delta as needed
    }
}
