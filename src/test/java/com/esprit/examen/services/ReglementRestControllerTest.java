package com.esprit.examen.services;

import com.esprit.examen.controllers.ReglementRestController;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.services.IReglementService;
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
public class ReglementRestControllerTest {

    @InjectMocks
    private ReglementRestController reglementRestController;

    @Mock
    private IReglementService reglementService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReglement() {
        Reglement reglement = new Reglement();
        // Initialize reglement as needed

        when(reglementService.addReglement(any(Reglement.class))).thenReturn(reglement);

        Reglement result = reglementRestController.addReglement(reglement);

        assertEquals(reglement, result);
    }

    @Test
    public void testGetReglement() {
        List<Reglement> reglements = new ArrayList<>();
        // Add some Reglement objects to the list

        when(reglementService.retrieveAllReglements()).thenReturn(reglements);

        List<Reglement> result = reglementRestController.getReglement();

        assertEquals(reglements, result);
    }

    @Test
    public void testRetrieveReglement() {
        Long id = 1L; // Replace with the appropriate ID
        Reglement reglement = new Reglement();
        // Initialize reglement as needed

        when(reglementService.retrieveReglement(id)).thenReturn(reglement);

        Reglement result = reglementRestController.retrieveReglement(id);

        assertEquals(reglement, result);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        Long factureId = 1L; // Replace with the appropriate ID
        List<Reglement> reglements = new ArrayList<>();
        // Add some Reglement objects to the list

        when(reglementService.retrieveReglementByFacture(factureId)).thenReturn(reglements);

        List<Reglement> result = reglementRestController.retrieveReglementByFacture(factureId);

        assertEquals(reglements, result);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date(); // Replace with the appropriate start date
        Date endDate = new Date(); // Replace with the appropriate end date
        float expectedChiffreAffaire = 0.0f; // Replace with the expected chiffre d'affaire

        when(reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(expectedChiffreAffaire);

        float result = reglementRestController.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        assertEquals(expectedChiffreAffaire, result, 0.001); // Adjust delta as needed
    }
}
